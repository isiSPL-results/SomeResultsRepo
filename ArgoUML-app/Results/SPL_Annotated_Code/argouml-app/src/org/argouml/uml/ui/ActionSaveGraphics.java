// Compilation Unit of /ActionSaveGraphics.java 
 
package org.argouml.uml.ui;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import org.argouml.application.api.CommandLineInterface;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoStatusEvent;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.configuration.Configuration;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.ui.ExceptionDialog;
import org.argouml.uml.diagram.DiagramUtils;
import org.argouml.util.ArgoFrame;
import org.argouml.util.SuffixFilter;
import org.tigris.gef.base.Diagram;
import org.tigris.gef.base.SaveGraphicsAction;
import org.tigris.gef.util.Util;
public class ActionSaveGraphics extends AbstractAction
 implements CommandLineInterface
  { 
private static final long serialVersionUID = 3062674953320109889L;
private static final Logger LOG =
        Logger.getLogger(ActionSaveGraphics.class);
public ActionSaveGraphics()
    { 
super(Translator.localize("action.save-graphics"),
              ResourceLoaderWrapper.lookupIcon("action.save-graphics"));
} 

public void actionPerformed(ActionEvent ae)
    { 
trySave();
} 

private void updateStatus(String status)
    { 
ArgoEventPump.fireEvent(
            new ArgoStatusEvent(ArgoEventTypes.STATUS_TEXT,
                                this, status));
} 

private boolean trySave()
    { 
Object target = DiagramUtils.getActiveDiagram();
if(!(target instanceof Diagram))//1
{ 
return false;
} 

String defaultName = ((Diagram) target).getName();
defaultName = Util.stripJunk(defaultName);
Project p =  ProjectManager.getManager().getCurrentProject();
SaveGraphicsManager sgm = SaveGraphicsManager.getInstance();
try //1
{ 
JFileChooser chooser = null;
if(p != null
                    && p.getURI() != null
                    && p.getURI().toURL().getFile().length() > 0)//1
{ 
chooser = new JFileChooser(p.getURI().toURL().getFile());
} 

if(chooser == null)//1
{ 
chooser = new JFileChooser();
} 

Object[] s = {defaultName };
chooser.setDialogTitle(
                Translator.messageFormat("filechooser.save-graphics", s));
chooser.setAcceptAllFileFilterUsed(false);
sgm.setFileChooserFilters(chooser, defaultName);
String fn = Configuration.getString(
                            SaveGraphicsManager.KEY_SAVE_GRAPHICS_PATH);
if(fn.length() > 0)//1
{ 
chooser.setSelectedFile(new File(fn));
} 

int retval = chooser.showSaveDialog(ArgoFrame.getInstance());
if(retval == JFileChooser.APPROVE_OPTION)//1
{ 
File theFile = chooser.getSelectedFile();
if(theFile != null)//1
{ 
String path = theFile.getPath();
Configuration.setString(
                        SaveGraphicsManager.KEY_SAVE_GRAPHICS_PATH,
                        path);
theFile = new File(theFile.getParentFile(),
                                       sgm.fixExtension(theFile.getName()));
String suffix = sgm.getFilterFromFileName(theFile.getName())
                                    .getSuffix();
return doSave(theFile, suffix, true);
} 

} 

} 
catch (OutOfMemoryError e) //1
{ 
ExceptionDialog ed = new ExceptionDialog(ArgoFrame.getInstance(),
                    "You have run out of memory. "
                    + "Close down ArgoUML and restart with a larger heap size.", e);
ed.setModal(true);
ed.setVisible(true);
} 

catch (Exception e) //1
{ 
ExceptionDialog ed =
                new ExceptionDialog(ArgoFrame.getInstance(), e);
ed.setModal(true);
ed.setVisible(true);
LOG.error("Got some exception", e);
} 


return false;
} 

private boolean doSave(File theFile,
                           String suffix, boolean useUI)
    throws FileNotFoundException, IOException
    { 
SaveGraphicsManager sgm = SaveGraphicsManager.getInstance();
SaveGraphicsAction cmd = null;
cmd = sgm.getSaveActionBySuffix(suffix);
if(cmd == null)//1
{ 
return false;
} 

if(useUI)//1
{ 
updateStatus(Translator.localize(
                             "statusmsg.bar.save-graphics-status-writing",
                             new Object[] {theFile}));
} 

if(theFile.exists() && useUI)//1
{ 
int response = JOptionPane.showConfirmDialog(
                               ArgoFrame.getInstance(),
                               Translator.messageFormat("optionpane.confirm-overwrite",
                                       new Object[] {theFile}),
                               Translator.localize("optionpane.confirm-overwrite-title"),
                               JOptionPane.YES_NO_OPTION);
if(response != JOptionPane.YES_OPTION)//1
{ 
return false;
} 

} 

FileOutputStream fo = new FileOutputStream(theFile);
cmd.setStream(fo);
cmd.setScale(Configuration.getInteger(
                         SaveGraphicsManager.KEY_GRAPHICS_RESOLUTION, 1));
try //1
{ 
cmd.actionPerformed(null);
} 
finally { 
fo.close();
} 

if(useUI)//2
{ 
updateStatus(Translator.localize(
                             "statusmsg.bar.save-graphics-status-wrote",
                             new Object[] {theFile}));
} 

return true;
} 

public boolean doCommand(String argument)
    { 
File file = new File(argument);
String suffix = SuffixFilter.getExtension(file);
if(suffix == null)//1
{ 
return false;
} 

try //1
{ 
return doSave(file, suffix, false);
} 
catch (FileNotFoundException e) //1
{ 
LOG.error("File not found error when writing.", e);
} 

catch (IOException e) //1
{ 
LOG.error("IO error when writing.", e);
} 


return false;
} 

 } 


