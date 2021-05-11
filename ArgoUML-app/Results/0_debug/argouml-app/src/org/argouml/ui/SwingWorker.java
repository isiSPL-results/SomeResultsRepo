
//#if 503323745 
// Compilation Unit of /SwingWorker.java 
 

//#if -84277056 
package org.argouml.ui;
//#endif 


//#if 416097578 
import java.awt.Cursor;
//#endif 


//#if 267330278 
import java.awt.event.ActionEvent;
//#endif 


//#if -82340382 
import java.awt.event.ActionListener;
//#endif 


//#if 1493092006 
import javax.swing.SwingUtilities;
//#endif 


//#if -1011276513 
import javax.swing.Timer;
//#endif 


//#if -2057438556 
import org.argouml.swingext.GlassPane;
//#endif 


//#if -1306879592 
import org.argouml.taskmgmt.ProgressMonitor;
//#endif 


//#if -1149354091 
import org.argouml.util.ArgoFrame;
//#endif 


//#if -737525470 
import org.apache.log4j.Logger;
//#endif 


//#if -805592117 
public abstract class SwingWorker  { 

//#if -9078989 
private Object value;
//#endif 


//#if 102072881 
private GlassPane glassPane;
//#endif 


//#if -1927918191 
private Timer timer;
//#endif 


//#if 274505668 
private ProgressMonitor pmw;
//#endif 


//#if -1526569455 
private ThreadVar threadVar;
//#endif 


//#if -433283073 
private static final Logger LOG =
        Logger.getLogger(SwingWorker.class);
//#endif 


//#if -441630747 
public abstract ProgressMonitor initProgressMonitorWindow();
//#endif 


//#if 1143887582 
protected void setGlassPane(GlassPane newGlassPane)
    { 

//#if 1537612565 
glassPane = newGlassPane;
//#endif 

} 

//#endif 


//#if -1241393769 
private synchronized void setValue(Object x)
    { 

//#if 1820851314 
value = x;
//#endif 

} 

//#endif 


//#if -1907268267 
public abstract Object construct(ProgressMonitor progressMonitor);
//#endif 


//#if -594300951 
public void finished()
    { 

//#if 1710369167 
deactivateGlassPane();
//#endif 


//#if -808620372 
ArgoFrame.getInstance().setCursor(Cursor.getPredefinedCursor(
                                              Cursor.DEFAULT_CURSOR));
//#endif 

} 

//#endif 


//#if 270725246 
protected GlassPane getGlassPane()
    { 

//#if -1072256435 
return glassPane;
//#endif 

} 

//#endif 


//#if 1747943797 
public SwingWorker(String threadName)
    { 

//#if -1517242656 
this();
//#endif 


//#if 1269782790 
threadVar.get().setName(threadName);
//#endif 

} 

//#endif 


//#if -218639117 
private void deactivateGlassPane()
    { 

//#if -1662574346 
if(getGlassPane() != null)//1
{ 

//#if 523702183 
getGlassPane().setVisible(false);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -501272724 
public Object doConstruct()
    { 

//#if 2125679726 
activateGlassPane();
//#endif 


//#if -179723755 
pmw = initProgressMonitorWindow();
//#endif 


//#if 556639286 
ArgoFrame.getInstance().setCursor(
            Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
//#endif 


//#if 556655195 
Object retVal = null;
//#endif 


//#if -2050384305 
timer = new Timer(25, new TimerListener());
//#endif 


//#if -421675002 
timer.start();
//#endif 


//#if 297107323 
try //1
{ 

//#if -1460225461 
retVal = construct(pmw);
//#endif 

} 

//#if 1898246626 
catch (Exception exc) //1
{ 

//#if -1551218767 
LOG.error("Error while loading project: " + exc);
//#endif 

} 

//#endif 

finally { 

//#if -1414333783 
pmw.close();
//#endif 

} 

//#endif 


//#if -1716781594 
return retVal;
//#endif 

} 

//#endif 


//#if -2076881491 
public void start()
    { 

//#if -1289950165 
Thread t = threadVar.get();
//#endif 


//#if 578771223 
if(t != null)//1
{ 

//#if 1502755508 
t.start();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 464773046 
public Object get()
    { 

//#if 175966929 
while (true) //1
{ 

//#if -1392783794 
Thread t = threadVar.get();
//#endif 


//#if -2005837218 
if(t == null)//1
{ 

//#if -1147026233 
return getValue();
//#endif 

} 

//#endif 


//#if 1523043324 
try //1
{ 

//#if 1275624842 
t.join();
//#endif 

} 

//#if 1697921384 
catch (InterruptedException e) //1
{ 

//#if 949922259 
Thread.currentThread().interrupt();
//#endif 


//#if 1847492690 
return null;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -44404023 
protected void activateGlassPane()
    { 

//#if 105691222 
GlassPane aPane = GlassPane.mount(ArgoFrame.getInstance(), true);
//#endif 


//#if -328182998 
setGlassPane(aPane);
//#endif 


//#if -867815504 
if(getGlassPane() != null)//1
{ 

//#if -2146898503 
getGlassPane().setVisible(true);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -672157756 
protected synchronized Object getValue()
    { 

//#if 1617026100 
return value;
//#endif 

} 

//#endif 


//#if -1525138597 
public SwingWorker()
    { 

//#if -681276072 
final Runnable doFinished = new Runnable() {
            public void run() {
                finished();
            }
        };
//#endif 


//#if 1659754220 
Runnable doConstruct = new Runnable() {
            public void run() {
                try {
                    setValue(doConstruct());
                } finally {
                    threadVar.clear();
                }

                SwingUtilities.invokeLater(doFinished);
            }
        };
//#endif 


//#if -1260954306 
Thread t = new Thread(doConstruct);
//#endif 


//#if -1375490870 
threadVar = new ThreadVar(t);
//#endif 

} 

//#endif 


//#if -249051538 
public void interrupt()
    { 

//#if -1108253133 
Thread t = threadVar.get();
//#endif 


//#if 616250655 
if(t != null)//1
{ 

//#if 1077487312 
t.interrupt();
//#endif 

} 

//#endif 


//#if 2002285545 
threadVar.clear();
//#endif 

} 

//#endif 


//#if -2022939587 
private static class ThreadVar  { 

//#if -1390003964 
private Thread thread;
//#endif 


//#if -1029057110 
ThreadVar(Thread t)
        { 

//#if -1129826620 
thread = t;
//#endif 

} 

//#endif 


//#if -950547015 
synchronized Thread get()
        { 

//#if 283885724 
return thread;
//#endif 

} 

//#endif 


//#if 348504774 
synchronized void clear()
        { 

//#if -532851231 
thread = null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1608674938 
class TimerListener implements 
//#if 2116764226 
ActionListener
//#endif 

  { 

//#if -676525993 
public void actionPerformed(ActionEvent evt)
        { 

//#if -1010660326 
if(pmw.isCanceled())//1
{ 

//#if 515039005 
threadVar.thread.interrupt();
//#endif 


//#if 1417162596 
interrupt();
//#endif 


//#if 1183262402 
timer.stop();
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

