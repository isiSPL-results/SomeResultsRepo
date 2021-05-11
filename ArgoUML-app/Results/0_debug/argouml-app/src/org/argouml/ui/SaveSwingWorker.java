
//#if -1609592247 
// Compilation Unit of /SaveSwingWorker.java 
 

//#if -1470344122 
package org.argouml.ui;
//#endif 


//#if 1844046108 
import java.io.File;
//#endif 


//#if -1585050927 
import javax.swing.UIManager;
//#endif 


//#if -1842064171 
import org.argouml.i18n.Translator;
//#endif 


//#if 765779410 
import org.argouml.taskmgmt.ProgressMonitor;
//#endif 


//#if 1330357327 
import org.argouml.util.ArgoFrame;
//#endif 


//#if -67242493 
import org.tigris.gef.undo.UndoManager;
//#endif 


//#if 1925463282 
public class SaveSwingWorker extends 
//#if -1392952586 
SwingWorker
//#endif 

  { 

//#if 970512475 
private boolean overwrite;
//#endif 


//#if -1625403066 
private File file;
//#endif 


//#if 2139550035 
private boolean result;
//#endif 


//#if -1659983427 
public Object construct(ProgressMonitor pmw)
    { 

//#if -1633460728 
Thread currentThread = Thread.currentThread();
//#endif 


//#if -1115160982 
currentThread.setPriority(currentThread.getPriority() - 1);
//#endif 


//#if -757435587 
result = ProjectBrowser.getInstance().trySave(overwrite, file, pmw);
//#endif 


//#if -228658059 
return null;
//#endif 

} 

//#endif 


//#if 247075194 
public SaveSwingWorker(boolean aOverwrite, File aFile)
    { 

//#if -2048798058 
super("ArgoSaveProjectThread");
//#endif 


//#if -1276229959 
overwrite = aOverwrite;
//#endif 


//#if -480595175 
file = aFile;
//#endif 

} 

//#endif 


//#if 279744118 
public void finished()
    { 

//#if -2095030755 
super.finished();
//#endif 


//#if 670869112 
if(result)//1
{ 

//#if -1084415801 
ProjectBrowser.getInstance().buildTitleWithCurrentProjectName();
//#endif 


//#if -89424291 
UndoManager.getInstance().empty();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1410607792 
public ProgressMonitor initProgressMonitorWindow()
    { 

//#if 1049020093 
Object[] msgArgs = new Object[] {file.getPath()};
//#endif 


//#if 2121898751 
UIManager.put("ProgressMonitor.progressText",
                      Translator.localize("filechooser.save-as-project"));
//#endif 


//#if -864906651 
return new ProgressMonitorWindow(ArgoFrame.getInstance(),
                                         Translator.messageFormat("dialog.saveproject.title", msgArgs));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

