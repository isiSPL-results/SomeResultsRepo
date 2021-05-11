
//#if 1269216613 
// Compilation Unit of /ActionSaveGraphics.java 
 

//#if -691494289 
package org.argouml.uml.ui;
//#endif 


//#if 525681789 
import java.awt.event.ActionEvent;
//#endif 


//#if -165692231 
import java.io.File;
//#endif 


//#if 1157769981 
import java.io.FileNotFoundException;
//#endif 


//#if -1683928104 
import java.io.FileOutputStream;
//#endif 


//#if -920374344 
import java.io.IOException;
//#endif 


//#if -1718899087 
import javax.swing.AbstractAction;
//#endif 


//#if 664959284 
import javax.swing.JFileChooser;
//#endif 


//#if -1478063578 
import javax.swing.JOptionPane;
//#endif 


//#if 2142133995 
import org.apache.log4j.Logger;
//#endif 


//#if -1714035320 
import org.argouml.application.api.CommandLineInterface;
//#endif 


//#if 402547266 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if -287645357 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if 1312726812 
import org.argouml.application.events.ArgoStatusEvent;
//#endif 


//#if 860090455 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 43047364 
import org.argouml.configuration.Configuration;
//#endif 


//#if -1984744552 
import org.argouml.i18n.Translator;
//#endif 


//#if -1331943444 
import org.argouml.kernel.Project;
//#endif 


//#if -744666755 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 896486743 
import org.argouml.ui.ExceptionDialog;
//#endif 


//#if 536169089 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if -891002580 
import org.argouml.util.ArgoFrame;
//#endif 


//#if -1851890035 
import org.argouml.util.SuffixFilter;
//#endif 


//#if -1670267761 
import org.tigris.gef.base.Diagram;
//#endif 


//#if -2030716074 
import org.tigris.gef.base.SaveGraphicsAction;
//#endif 


//#if -1691694205 
import org.tigris.gef.util.Util;
//#endif 


//#if -2004775832 
public class ActionSaveGraphics extends 
//#if 292057513 
AbstractAction
//#endif 

 implements 
//#if -598834677 
CommandLineInterface
//#endif 

  { 

//#if 425310915 
private static final long serialVersionUID = 3062674953320109889L;
//#endif 


//#if 1468147483 
private static final Logger LOG =
        Logger.getLogger(ActionSaveGraphics.class);
//#endif 


//#if 1783285017 
public ActionSaveGraphics()
    { 

//#if 665426148 
super(Translator.localize("action.save-graphics"),
              ResourceLoaderWrapper.lookupIcon("action.save-graphics"));
//#endif 

} 

//#endif 


//#if -453551379 
public void actionPerformed(ActionEvent ae)
    { 

//#if -111791121 
trySave();
//#endif 

} 

//#endif 


//#if -477018113 
private void updateStatus(String status)
    { 

//#if 1837790611 
ArgoEventPump.fireEvent(
            new ArgoStatusEvent(ArgoEventTypes.STATUS_TEXT,
                                this, status));
//#endif 

} 

//#endif 


//#if -921356349 
private boolean trySave()
    { 

//#if 1673905181 
Object target = DiagramUtils.getActiveDiagram();
//#endif 


//#if -262330390 
if(!(target instanceof Diagram))//1
{ 

//#if 1250444714 
return false;
//#endif 

} 

//#endif 


//#if -1519294294 
String defaultName = ((Diagram) target).getName();
//#endif 


//#if 376088542 
defaultName = Util.stripJunk(defaultName);
//#endif 


//#if 989000643 
Project p =  ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -461917698 
SaveGraphicsManager sgm = SaveGraphicsManager.getInstance();
//#endif 


//#if 1864329305 
try //1
{ 

//#if 2021952265 
JFileChooser chooser = null;
//#endif 


//#if 436079162 
if(p != null
                    && p.getURI() != null
                    && p.getURI().toURL().getFile().length() > 0)//1
{ 

//#if -374867267 
chooser = new JFileChooser(p.getURI().toURL().getFile());
//#endif 

} 

//#endif 


//#if -333376525 
if(chooser == null)//1
{ 

//#if -134293171 
chooser = new JFileChooser();
//#endif 

} 

//#endif 


//#if 1865950318 
Object[] s = {defaultName };
//#endif 


//#if -653158969 
chooser.setDialogTitle(
                Translator.messageFormat("filechooser.save-graphics", s));
//#endif 


//#if -809736548 
chooser.setAcceptAllFileFilterUsed(false);
//#endif 


//#if 482873914 
sgm.setFileChooserFilters(chooser, defaultName);
//#endif 


//#if -1662596805 
String fn = Configuration.getString(
                            SaveGraphicsManager.KEY_SAVE_GRAPHICS_PATH);
//#endif 


//#if 2064185488 
if(fn.length() > 0)//1
{ 

//#if 140415045 
chooser.setSelectedFile(new File(fn));
//#endif 

} 

//#endif 


//#if 1715568211 
int retval = chooser.showSaveDialog(ArgoFrame.getInstance());
//#endif 


//#if -451874063 
if(retval == JFileChooser.APPROVE_OPTION)//1
{ 

//#if -1550579311 
File theFile = chooser.getSelectedFile();
//#endif 


//#if -576015086 
if(theFile != null)//1
{ 

//#if -1082431725 
String path = theFile.getPath();
//#endif 


//#if -1539096510 
Configuration.setString(
                        SaveGraphicsManager.KEY_SAVE_GRAPHICS_PATH,
                        path);
//#endif 


//#if -1109936829 
theFile = new File(theFile.getParentFile(),
                                       sgm.fixExtension(theFile.getName()));
//#endif 


//#if 824120660 
String suffix = sgm.getFilterFromFileName(theFile.getName())
                                    .getSuffix();
//#endif 


//#if -1117619072 
return doSave(theFile, suffix, true);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#if 79502491 
catch (OutOfMemoryError e) //1
{ 

//#if -988671069 
ExceptionDialog ed = new ExceptionDialog(ArgoFrame.getInstance(),
                    "You have run out of memory. "
                    + "Close down ArgoUML and restart with a larger heap size.", e);
//#endif 


//#if 294738683 
ed.setModal(true);
//#endif 


//#if -593193578 
ed.setVisible(true);
//#endif 

} 

//#endif 


//#if -1207042034 
catch (Exception e) //1
{ 

//#if -587638496 
ExceptionDialog ed =
                new ExceptionDialog(ArgoFrame.getInstance(), e);
//#endif 


//#if -881910757 
ed.setModal(true);
//#endif 


//#if -1776906570 
ed.setVisible(true);
//#endif 


//#if 258322451 
LOG.error("Got some exception", e);
//#endif 

} 

//#endif 


//#endif 


//#if -324685813 
return false;
//#endif 

} 

//#endif 


//#if -1261654461 
private boolean doSave(File theFile,
                           String suffix, boolean useUI)
    throws FileNotFoundException, IOException
    { 

//#if 547968473 
SaveGraphicsManager sgm = SaveGraphicsManager.getInstance();
//#endif 


//#if 873489579 
SaveGraphicsAction cmd = null;
//#endif 


//#if -647659782 
cmd = sgm.getSaveActionBySuffix(suffix);
//#endif 


//#if 605979334 
if(cmd == null)//1
{ 

//#if 1094112448 
return false;
//#endif 

} 

//#endif 


//#if 379030464 
if(useUI)//1
{ 

//#if -2084816075 
updateStatus(Translator.localize(
                             "statusmsg.bar.save-graphics-status-writing",
                             new Object[] {theFile}));
//#endif 

} 

//#endif 


//#if 1832216930 
if(theFile.exists() && useUI)//1
{ 

//#if 1022910480 
int response = JOptionPane.showConfirmDialog(
                               ArgoFrame.getInstance(),
                               Translator.messageFormat("optionpane.confirm-overwrite",
                                       new Object[] {theFile}),
                               Translator.localize("optionpane.confirm-overwrite-title"),
                               JOptionPane.YES_NO_OPTION);
//#endif 


//#if -794919241 
if(response != JOptionPane.YES_OPTION)//1
{ 

//#if -278968458 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2013188987 
FileOutputStream fo = new FileOutputStream(theFile);
//#endif 


//#if 1940700029 
cmd.setStream(fo);
//#endif 


//#if 312551267 
cmd.setScale(Configuration.getInteger(
                         SaveGraphicsManager.KEY_GRAPHICS_RESOLUTION, 1));
//#endif 


//#if 1357695070 
try //1
{ 

//#if -2099173593 
cmd.actionPerformed(null);
//#endif 

} 
finally { 

//#if -1603369260 
fo.close();
//#endif 

} 

//#endif 


//#if 227608305 
if(useUI)//2
{ 

//#if -2080162478 
updateStatus(Translator.localize(
                             "statusmsg.bar.save-graphics-status-wrote",
                             new Object[] {theFile}));
//#endif 

} 

//#endif 


//#if -2082401131 
return true;
//#endif 

} 

//#endif 


//#if -2105757723 
public boolean doCommand(String argument)
    { 

//#if -633739243 
File file = new File(argument);
//#endif 


//#if -118480232 
String suffix = SuffixFilter.getExtension(file);
//#endif 


//#if -509471232 
if(suffix == null)//1
{ 

//#if -1438407966 
return false;
//#endif 

} 

//#endif 


//#if 510153857 
try //1
{ 

//#if 1516134984 
return doSave(file, suffix, false);
//#endif 

} 

//#if 61450261 
catch (FileNotFoundException e) //1
{ 

//#if 1344630932 
LOG.error("File not found error when writing.", e);
//#endif 

} 

//#endif 


//#if 514269904 
catch (IOException e) //1
{ 

//#if -1668074986 
LOG.error("IO error when writing.", e);
//#endif 

} 

//#endif 


//#endif 


//#if -2004427213 
return false;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

