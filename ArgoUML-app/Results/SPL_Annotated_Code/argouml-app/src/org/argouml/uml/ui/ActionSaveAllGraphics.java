// Compilation Unit of /ActionSaveAllGraphics.java 
 
package org.argouml.uml.ui;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoStatusEvent;
import org.argouml.configuration.Configuration;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramUtils;
import org.argouml.util.ArgoFrame;
import org.tigris.gef.base.Diagram;
import org.tigris.gef.base.SaveGraphicsAction;
import org.tigris.gef.util.Util;
public class ActionSaveAllGraphics extends AbstractAction
  { 
private static final Logger LOG =
        Logger.getLogger(ActionSaveAllGraphics.class);
private boolean overwrite;
protected File getSaveDir(Project p)
    { 
JFileChooser chooser = getFileChooser(p);
String fn = Configuration.getString(
                        SaveGraphicsManager.KEY_SAVEALL_GRAPHICS_PATH);
if(fn.length() > 0)//1
{ 
chooser.setSelectedFile(new File(fn));
} 

int retval = chooser.showSaveDialog(ArgoFrame.getInstance());
if(retval == JFileChooser.APPROVE_OPTION)//1
{ 
File theFile = chooser.getSelectedFile();
String path = theFile.getPath();
Configuration.setString(
                SaveGraphicsManager.KEY_SAVEALL_GRAPHICS_PATH,
                path);
return theFile;
} 

return null;
} 

private void showStatus(String text)
    { 
ArgoEventPump.fireEvent(new ArgoStatusEvent(
                                    ArgoEventTypes.STATUS_TEXT, this, text));
} 

private JFileChooser getFileChooser(Project p)
    { 
JFileChooser chooser = null;
try //1
{ 
if(p != null
                    && p.getURI() != null
                    && p.getURI().toURL().getFile().length() > 0)//1
{ 
chooser = new JFileChooser(p.getURI().toURL().getFile());
} 

} 
catch ( MalformedURLException ex ) //1
{ 
LOG.error("exception in opening JFileChooser", ex);
} 


if(chooser == null)//1
{ 
chooser = new JFileChooser();
} 

chooser.setDialogTitle(
            Translator.localize("filechooser.save-all-graphics"));
chooser.setDialogType(JFileChooser.OPEN_DIALOG);
chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
chooser.setMultiSelectionEnabled(false);
return chooser;
} 

public boolean trySave(boolean canOverwrite)
    { 
return trySave(canOverwrite, null);
} 

protected boolean trySaveDiagram(Object target,
                                     File saveDir)
    { 
if(target instanceof Diagram)//1
{ 
String defaultName = ((Diagram) target).getName();
defaultName = Util.stripJunk(defaultName);
try //1
{ 
File theFile = new File(saveDir, defaultName + "."
                                        + SaveGraphicsManager.getInstance().getDefaultSuffix());
String name = theFile.getName();
String path = theFile.getParent();
SaveGraphicsAction cmd = SaveGraphicsManager.getInstance()
                                         .getSaveActionBySuffix(
                                             SaveGraphicsManager.getInstance().getDefaultSuffix());
if(cmd == null)//1
{ 
showStatus("Unknown graphics file type with extension "
                               + SaveGraphicsManager.getInstance()
                               .getDefaultSuffix());
return false;
} 

showStatus( "Writing " + path + name + "..." );
boolean result = saveGraphicsToFile(theFile, cmd);
showStatus( "Wrote " + path + name );
return result;
} 
catch ( FileNotFoundException ignore ) //1
{ 
LOG.error("got a FileNotFoundException", ignore);
} 

catch ( IOException ignore ) //1
{ 
LOG.error("got an IOException", ignore);
} 


} 

return false;
} 

public ActionSaveAllGraphics()
    { 
super(Translator.localize("action.save-all-graphics"),
              null);
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.save-all-graphics"));
} 

public void actionPerformed( ActionEvent ae )
    { 
trySave( false );
} 

private boolean saveGraphicsToFile(File theFile, SaveGraphicsAction cmd)
    throws IOException
    { 
if(theFile.exists() && !overwrite)//1
{ 
String message = Translator.messageFormat(
                                 "optionpane.confirm-overwrite",
                                 new Object[] {theFile});
String title = Translator.localize(
                               "optionpane.confirm-overwrite-title");
Object[] options = {
                Translator.localize(
                    "optionpane.confirm-overwrite.overwrite"), // 0
                Translator.localize(
                    "optionpane.confirm-overwrite.overwrite-all"), // 1
                Translator.localize(
                    "optionpane.confirm-overwrite.skip-this-one"), // 2
                Translator.localize(
                    "optionpane.confirm-overwrite.cancel")
            };
int response =
                JOptionPane.showOptionDialog(ArgoFrame.getInstance(),
                                             message,
                                             title,
                                             JOptionPane.YES_NO_CANCEL_OPTION,
                                             JOptionPane.QUESTION_MESSAGE,
                                             null,     //do not use a custom Icon
                                             options,  //the titles of buttons
                                             options[0]);
if(response == 1)//1
{ 
overwrite = true;
} 

if(response == 2)//1
{ 
return true;
} 

if(response == 3)//1
{ 
return false;
} 

if(response == JOptionPane.CLOSED_OPTION)//1
{ 
return false;
} 

} 

FileOutputStream fo = null;
try //1
{ 
fo = new FileOutputStream( theFile );
cmd.setStream(fo);
cmd.setScale(Configuration.getInteger(
                             SaveGraphicsManager.KEY_GRAPHICS_RESOLUTION, 1));
cmd.actionPerformed(null);
} 
finally { 
if(fo != null)//1
{ 
fo.close();
} 

} 

return true;
} 

public boolean trySave(boolean canOverwrite, File directory)
    { 
overwrite = canOverwrite;
Project p =  ProjectManager.getManager().getCurrentProject();
TargetManager tm = TargetManager.getInstance();
File saveDir = (directory != null) ? directory : getSaveDir(p);
if(saveDir == null)//1
{ 
return false;
} 

boolean okSoFar = true;
ArgoDiagram activeDiagram = DiagramUtils.getActiveDiagram();
for (ArgoDiagram d : p.getDiagramList()) //1
{ 
tm.setTarget(d);
okSoFar = trySaveDiagram(d, saveDir);
if(!okSoFar)//1
{ 
break;

} 

} 

tm.setTarget(activeDiagram);
return okSoFar;
} 

 } 


