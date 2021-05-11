
//#if 1600077274 
// Compilation Unit of /ProgressMonitorWindow.java 
 

//#if 228096424 
package org.argouml.ui;
//#endif 


//#if -913302950 
import javax.swing.JDialog;
//#endif 


//#if 451751207 
import javax.swing.JFrame;
//#endif 


//#if -840427361 
import javax.swing.ProgressMonitor;
//#endif 


//#if -923257666 
import javax.swing.SwingUtilities;
//#endif 


//#if -1334501709 
import javax.swing.UIManager;
//#endif 


//#if 998864695 
import org.argouml.i18n.Translator;
//#endif 


//#if -958147536 
import org.argouml.taskmgmt.ProgressEvent;
//#endif 


//#if 729263533 
import org.argouml.util.ArgoFrame;
//#endif 


//#if -1944846350 
public class ProgressMonitorWindow implements 
//#if -1582726581 
org.argouml.taskmgmt.ProgressMonitor
//#endif 

  { 

//#if 1827938693 
private ProgressMonitor pbar;
//#endif 


//#if 1211196878 
static
    {
        UIManager.put("ProgressBar.repaintInterval", Integer.valueOf(150));
        UIManager.put("ProgressBar.cycleTime", Integer.valueOf(1050));
    }
//#endif 


//#if -1790115939 
public void setMaximumProgress(int max)
    { 

//#if 1417417624 
pbar.setMaximum(max);
//#endif 

} 

//#endif 


//#if 1332489389 
public void notifyNullAction()
    { 
} 

//#endif 


//#if -1389235324 
public ProgressMonitorWindow(JFrame parent, String title)
    { 

//#if 1580972780 
pbar = new ProgressMonitor(parent,
                                   title,
                                   null, 0, 100);
//#endif 


//#if -1380092515 
pbar.setMillisToDecideToPopup(250);
//#endif 


//#if -877603000 
pbar.setMillisToPopup(500);
//#endif 


//#if -1776333176 
parent.repaint();
//#endif 


//#if -946252960 
updateProgress(5);
//#endif 

} 

//#endif 


//#if -357177101 
public void notifyMessage(final String title, final String introduction,
                              final String message)
    { 

//#if 439081994 
final String messageString = introduction + " : " + message;
//#endif 


//#if 1255237723 
pbar.setNote(messageString);
//#endif 


//#if 1560249624 
SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JDialog dialog =
                    new ExceptionDialog(
                    ArgoFrame.getInstance(),
                    title,
                    introduction,
                    message);
                dialog.setVisible(true);
            }
        });
//#endif 

} 

//#endif 


//#if -529354128 
public void updateSubTask(String action)
    { 

//#if -709984412 
pbar.setNote(action);
//#endif 

} 

//#endif 


//#if -1335646633 
public void updateProgress(final int progress)
    { 

//#if 733925224 
if(pbar != null)//1
{ 

//#if -1169806593 
pbar.setProgress(progress);
//#endif 


//#if -670624334 
Object[] args = new Object[] {String.valueOf(progress)};
//#endif 


//#if -1870973653 
pbar.setNote(Translator.localize("dialog.progress.note", args));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 158991290 
public boolean isCanceled()
    { 

//#if 1515939419 
return (pbar != null) && pbar.isCanceled();
//#endif 

} 

//#endif 


//#if 1522463986 
public void updateMainTask(String name)
    { 

//#if -1016544056 
pbar.setNote(name);
//#endif 

} 

//#endif 


//#if -1881677229 
public void close()
    { 

//#if 800486024 
SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                pbar.close();
                pbar = null;
            }
        });
//#endif 

} 

//#endif 


//#if 189712795 
public void progress(final ProgressEvent event)
    { 

//#if -348106655 
final int progress = (int) event.getPosition();
//#endif 


//#if 1177940242 
if(pbar != null)//1
{ 

//#if -1586674589 
if(!SwingUtilities.isEventDispatchThread())//1
{ 

//#if 947145105 
SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        updateProgress(progress);
                    }
                });
//#endif 

} 
else
{ 

//#if 678774220 
updateProgress(progress);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

