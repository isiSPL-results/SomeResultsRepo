
//#if 930176756 
// Compilation Unit of /LoadSwingWorker.java 
 

//#if 1566959010 
package org.argouml.ui;
//#endif 


//#if -1164102336 
import java.io.File;
//#endif 


//#if -1026661039 
import java.io.IOException;
//#endif 


//#if 370943789 
import javax.swing.UIManager;
//#endif 


//#if -276644815 
import org.argouml.i18n.Translator;
//#endif 


//#if 1056898550 
import org.argouml.taskmgmt.ProgressMonitor;
//#endif 


//#if -1390091917 
import org.argouml.util.ArgoFrame;
//#endif 


//#if 1329863684 
import org.apache.log4j.Logger;
//#endif 


//#if -933383867 
public class LoadSwingWorker extends 
//#if -969226299 
SwingWorker
//#endif 

  { 

//#if 1812135822 
private boolean showUi;
//#endif 


//#if 1848602071 
private File file;
//#endif 


//#if -674092969 
private static final Logger LOG = Logger.getLogger(LoadSwingWorker.class);
//#endif 


//#if -1609902686 
public LoadSwingWorker(File aFile, boolean aShowUi)
    { 

//#if -1709397680 
super("ArgoLoadProjectThread");
//#endif 


//#if 1040177722 
this.showUi = aShowUi;
//#endif 


//#if -32934812 
this.file = aFile;
//#endif 

} 

//#endif 


//#if 72163916 
public Object construct(ProgressMonitor pmw)
    { 

//#if -389075027 
Thread currentThread = Thread.currentThread();
//#endif 


//#if 1822264143 
currentThread.setPriority(currentThread.getPriority() - 1);
//#endif 


//#if -1152771755 
ProjectBrowser.getInstance().loadProject(file, showUi, pmw);
//#endif 


//#if -1605199334 
return null;
//#endif 

} 

//#endif 


//#if -692163103 
public ProgressMonitor initProgressMonitorWindow()
    { 

//#if -601520617 
UIManager.put("ProgressMonitor.progressText",
                      Translator.localize("filechooser.open-project"));
//#endif 


//#if 730288131 
Object[] msgArgs = new Object[] {this.file.getPath()};
//#endif 


//#if -1923556616 
return new ProgressMonitorWindow(ArgoFrame.getInstance(),
                                         Translator.messageFormat("dialog.openproject.title", msgArgs));
//#endif 

} 

//#endif 


//#if -2117404025 
public void finished()
    { 

//#if 1128129662 
super.finished();
//#endif 


//#if -2140042867 
try //1
{ 

//#if 205674361 
ProjectBrowser.getInstance().addFileSaved(file);
//#endif 

} 

//#if 664674415 
catch (IOException exc) //1
{ 

//#if -1660107599 
LOG.error("Failed to save file: " + file
                      + " in most recently used list");
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

