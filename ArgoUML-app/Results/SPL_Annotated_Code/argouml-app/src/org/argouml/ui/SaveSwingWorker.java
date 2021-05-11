// Compilation Unit of /SaveSwingWorker.java 
 
package org.argouml.ui;
import java.io.File;
import javax.swing.UIManager;
import org.argouml.i18n.Translator;
import org.argouml.taskmgmt.ProgressMonitor;
import org.argouml.util.ArgoFrame;
import org.tigris.gef.undo.UndoManager;
public class SaveSwingWorker extends SwingWorker
  { 
private boolean overwrite;
private File file;
private boolean result;
public Object construct(ProgressMonitor pmw)
    { 
Thread currentThread = Thread.currentThread();
currentThread.setPriority(currentThread.getPriority() - 1);
result = ProjectBrowser.getInstance().trySave(overwrite, file, pmw);
return null;
} 

public SaveSwingWorker(boolean aOverwrite, File aFile)
    { 
super("ArgoSaveProjectThread");
overwrite = aOverwrite;
file = aFile;
} 

public void finished()
    { 
super.finished();
if(result)//1
{ 
ProjectBrowser.getInstance().buildTitleWithCurrentProjectName();
UndoManager.getInstance().empty();
} 

} 

public ProgressMonitor initProgressMonitorWindow()
    { 
Object[] msgArgs = new Object[] {file.getPath()};
UIManager.put("ProgressMonitor.progressText",
                      Translator.localize("filechooser.save-as-project"));
return new ProgressMonitorWindow(ArgoFrame.getInstance(),
                                         Translator.messageFormat("dialog.saveproject.title", msgArgs));
} 

 } 


