
//#if 553045791 
// Compilation Unit of /ActionSaveAllGraphics.java 
 

//#if 99489467 
package org.argouml.uml.ui;
//#endif 


//#if 1807655601 
import java.awt.event.ActionEvent;
//#endif 


//#if 1499153901 
import java.io.File;
//#endif 


//#if 1590407241 
import java.io.FileNotFoundException;
//#endif 


//#if -1888180468 
import java.io.FileOutputStream;
//#endif 


//#if -129390588 
import java.io.IOException;
//#endif 


//#if -2086044345 
import java.net.MalformedURLException;
//#endif 


//#if -436925275 
import javax.swing.AbstractAction;
//#endif 


//#if 1579282727 
import javax.swing.Action;
//#endif 


//#if 460706920 
import javax.swing.JFileChooser;
//#endif 


//#if 593557618 
import javax.swing.JOptionPane;
//#endif 


//#if -81212105 
import org.apache.log4j.Logger;
//#endif 


//#if -760734858 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if -1989652833 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if 90102608 
import org.argouml.application.events.ArgoStatusEvent;
//#endif 


//#if 970797072 
import org.argouml.configuration.Configuration;
//#endif 


//#if -898262044 
import org.argouml.i18n.Translator;
//#endif 


//#if -49969632 
import org.argouml.kernel.Project;
//#endif 


//#if 927680713 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -142087048 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1357933417 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -181045323 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if 390971232 
import org.argouml.util.ArgoFrame;
//#endif 


//#if -583785253 
import org.tigris.gef.base.Diagram;
//#endif 


//#if 215968650 
import org.tigris.gef.base.SaveGraphicsAction;
//#endif 


//#if -1895946569 
import org.tigris.gef.util.Util;
//#endif 


//#if 1797347227 
public class ActionSaveAllGraphics extends 
//#if 1042039133 
AbstractAction
//#endif 

  { 

//#if -1955111320 
private static final Logger LOG =
        Logger.getLogger(ActionSaveAllGraphics.class);
//#endif 


//#if 454944538 
private boolean overwrite;
//#endif 


//#if 682628425 
protected File getSaveDir(Project p)
    { 

//#if 1540405860 
JFileChooser chooser = getFileChooser(p);
//#endif 


//#if 2001235284 
String fn = Configuration.getString(
                        SaveGraphicsManager.KEY_SAVEALL_GRAPHICS_PATH);
//#endif 


//#if 834791142 
if(fn.length() > 0)//1
{ 

//#if 1397880979 
chooser.setSelectedFile(new File(fn));
//#endif 

} 

//#endif 


//#if -1087701975 
int retval = chooser.showSaveDialog(ArgoFrame.getInstance());
//#endif 


//#if 1257036999 
if(retval == JFileChooser.APPROVE_OPTION)//1
{ 

//#if -1577717602 
File theFile = chooser.getSelectedFile();
//#endif 


//#if 796257269 
String path = theFile.getPath();
//#endif 


//#if -2062714259 
Configuration.setString(
                SaveGraphicsManager.KEY_SAVEALL_GRAPHICS_PATH,
                path);
//#endif 


//#if -1055161712 
return theFile;
//#endif 

} 

//#endif 


//#if 1228503610 
return null;
//#endif 

} 

//#endif 


//#if -1661225308 
private void showStatus(String text)
    { 

//#if 675984127 
ArgoEventPump.fireEvent(new ArgoStatusEvent(
                                    ArgoEventTypes.STATUS_TEXT, this, text));
//#endif 

} 

//#endif 


//#if 1932812102 
private JFileChooser getFileChooser(Project p)
    { 

//#if -1937375224 
JFileChooser chooser = null;
//#endif 


//#if -1772485717 
try //1
{ 

//#if 384309085 
if(p != null
                    && p.getURI() != null
                    && p.getURI().toURL().getFile().length() > 0)//1
{ 

//#if 1516509731 
chooser = new JFileChooser(p.getURI().toURL().getFile());
//#endif 

} 

//#endif 

} 

//#if 811934255 
catch ( MalformedURLException ex ) //1
{ 

//#if 472189532 
LOG.error("exception in opening JFileChooser", ex);
//#endif 

} 

//#endif 


//#endif 


//#if 549206932 
if(chooser == null)//1
{ 

//#if 926706230 
chooser = new JFileChooser();
//#endif 

} 

//#endif 


//#if -1475784084 
chooser.setDialogTitle(
            Translator.localize("filechooser.save-all-graphics"));
//#endif 


//#if 1529659682 
chooser.setDialogType(JFileChooser.OPEN_DIALOG);
//#endif 


//#if 1555331036 
chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//#endif 


//#if -255254879 
chooser.setMultiSelectionEnabled(false);
//#endif 


//#if -739618939 
return chooser;
//#endif 

} 

//#endif 


//#if -318784048 
public boolean trySave(boolean canOverwrite)
    { 

//#if 1585990583 
return trySave(canOverwrite, null);
//#endif 

} 

//#endif 


//#if -986279389 
protected boolean trySaveDiagram(Object target,
                                     File saveDir)
    { 

//#if 355420845 
if(target instanceof Diagram)//1
{ 

//#if -1487039806 
String defaultName = ((Diagram) target).getName();
//#endif 


//#if 1592148982 
defaultName = Util.stripJunk(defaultName);
//#endif 


//#if -1773041039 
try //1
{ 

//#if 854243490 
File theFile = new File(saveDir, defaultName + "."
                                        + SaveGraphicsManager.getInstance().getDefaultSuffix());
//#endif 


//#if 2038197051 
String name = theFile.getName();
//#endif 


//#if -463483806 
String path = theFile.getParent();
//#endif 


//#if -401757251 
SaveGraphicsAction cmd = SaveGraphicsManager.getInstance()
                                         .getSaveActionBySuffix(
                                             SaveGraphicsManager.getInstance().getDefaultSuffix());
//#endif 


//#if -200013090 
if(cmd == null)//1
{ 

//#if 823423417 
showStatus("Unknown graphics file type with extension "
                               + SaveGraphicsManager.getInstance()
                               .getDefaultSuffix());
//#endif 


//#if 2070734791 
return false;
//#endif 

} 

//#endif 


//#if -972904302 
showStatus( "Writing " + path + name + "..." );
//#endif 


//#if -1957481508 
boolean result = saveGraphicsToFile(theFile, cmd);
//#endif 


//#if -1848595170 
showStatus( "Wrote " + path + name );
//#endif 


//#if -1877223218 
return result;
//#endif 

} 

//#if 444183961 
catch ( FileNotFoundException ignore ) //1
{ 

//#if 506532704 
LOG.error("got a FileNotFoundException", ignore);
//#endif 

} 

//#endif 


//#if -1828201346 
catch ( IOException ignore ) //1
{ 

//#if 2144384396 
LOG.error("got an IOException", ignore);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 602971202 
return false;
//#endif 

} 

//#endif 


//#if 67501996 
public ActionSaveAllGraphics()
    { 

//#if -1924635258 
super(Translator.localize("action.save-all-graphics"),
              null);
//#endif 


//#if 1500572249 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.save-all-graphics"));
//#endif 

} 

//#endif 


//#if -1586089567 
public void actionPerformed( ActionEvent ae )
    { 

//#if -188230959 
trySave( false );
//#endif 

} 

//#endif 


//#if -725450955 
private boolean saveGraphicsToFile(File theFile, SaveGraphicsAction cmd)
    throws IOException
    { 

//#if -42427135 
if(theFile.exists() && !overwrite)//1
{ 

//#if 61112820 
String message = Translator.messageFormat(
                                 "optionpane.confirm-overwrite",
                                 new Object[] {theFile});
//#endif 


//#if 760287089 
String title = Translator.localize(
                               "optionpane.confirm-overwrite-title");
//#endif 


//#if -1907757769 
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
//#endif 


//#if -1824578964 
int response =
                JOptionPane.showOptionDialog(ArgoFrame.getInstance(),
                                             message,
                                             title,
                                             JOptionPane.YES_NO_CANCEL_OPTION,
                                             JOptionPane.QUESTION_MESSAGE,
                                             null,     //do not use a custom Icon
                                             options,  //the titles of buttons
                                             options[0]);
//#endif 


//#if -663701117 
if(response == 1)//1
{ 

//#if -2071433765 
overwrite = true;
//#endif 

} 

//#endif 


//#if -662777596 
if(response == 2)//1
{ 

//#if 1235767762 
return true;
//#endif 

} 

//#endif 


//#if -661854075 
if(response == 3)//1
{ 

//#if 1574825964 
return false;
//#endif 

} 

//#endif 


//#if -711707213 
if(response == JOptionPane.CLOSED_OPTION)//1
{ 

//#if 33302807 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -452030729 
FileOutputStream fo = null;
//#endif 


//#if -137161200 
try //1
{ 

//#if -655314743 
fo = new FileOutputStream( theFile );
//#endif 


//#if 1860185374 
cmd.setStream(fo);
//#endif 


//#if -386443132 
cmd.setScale(Configuration.getInteger(
                             SaveGraphicsManager.KEY_GRAPHICS_RESOLUTION, 1));
//#endif 


//#if -479585484 
cmd.actionPerformed(null);
//#endif 

} 
finally { 

//#if -403849982 
if(fo != null)//1
{ 

//#if 497827365 
fo.close();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -777943517 
return true;
//#endif 

} 

//#endif 


//#if 1895585419 
public boolean trySave(boolean canOverwrite, File directory)
    { 

//#if -407280413 
overwrite = canOverwrite;
//#endif 


//#if 205868219 
Project p =  ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 1161596660 
TargetManager tm = TargetManager.getInstance();
//#endif 


//#if 309576371 
File saveDir = (directory != null) ? directory : getSaveDir(p);
//#endif 


//#if -722592225 
if(saveDir == null)//1
{ 

//#if -1089715849 
return false;
//#endif 

} 

//#endif 


//#if -233561358 
boolean okSoFar = true;
//#endif 


//#if -1147758574 
ArgoDiagram activeDiagram = DiagramUtils.getActiveDiagram();
//#endif 


//#if 566585256 
for (ArgoDiagram d : p.getDiagramList()) //1
{ 

//#if -925416426 
tm.setTarget(d);
//#endif 


//#if -1450500171 
okSoFar = trySaveDiagram(d, saveDir);
//#endif 


//#if -2058874233 
if(!okSoFar)//1
{ 

//#if -1569192839 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 381645952 
tm.setTarget(activeDiagram);
//#endif 


//#if 1596550999 
return okSoFar;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

