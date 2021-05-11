// Compilation Unit of /LoadSwingWorker.java 
 
package org.argouml.ui;
import java.io.File;
import java.io.IOException;
import javax.swing.UIManager;
import org.argouml.i18n.Translator;
import org.argouml.taskmgmt.ProgressMonitor;
import org.argouml.util.ArgoFrame;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

public class LoadSwingWorker extends SwingWorker
  { 
private boolean showUi;
private File file;

//#if LOGGING 
private static final Logger LOG = Logger.getLogger(LoadSwingWorker.class);
//#endif 

public LoadSwingWorker(File aFile, boolean aShowUi)
    { 
super("ArgoLoadProjectThread");
this.showUi = aShowUi;
this.file = aFile;
} 

public Object construct(ProgressMonitor pmw)
    { 
Thread currentThread = Thread.currentThread();
currentThread.setPriority(currentThread.getPriority() - 1);
ProjectBrowser.getInstance().loadProject(file, showUi, pmw);
return null;
} 

public ProgressMonitor initProgressMonitorWindow()
    { 
UIManager.put("ProgressMonitor.progressText",
                      Translator.localize("filechooser.open-project"));
Object[] msgArgs = new Object[] {this.file.getPath()};
return new ProgressMonitorWindow(ArgoFrame.getInstance(),
                                         Translator.messageFormat("dialog.openproject.title", msgArgs));
} 

public void finished()
    { 
super.finished();
try //1
{ 
ProjectBrowser.getInstance().addFileSaved(file);
} 
catch (IOException exc) //1
{ 

//#if LOGGING 
LOG.error("Failed to save file: " + file
                      + " in most recently used list");
//#endif 

} 


} 

 } 


