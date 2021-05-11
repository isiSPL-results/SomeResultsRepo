package org.argouml.ui;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import org.argouml.swingext.GlassPane;
import org.argouml.taskmgmt.ProgressMonitor;
import org.argouml.util.ArgoFrame;
public abstract class SwingWorker  { 
private Object value;
private GlassPane glassPane;
private Timer timer;
private ProgressMonitor pmw;
private ThreadVar threadVar;
public abstract ProgressMonitor initProgressMonitorWindow();protected void setGlassPane(GlassPane newGlassPane)
    { 
glassPane = newGlassPane;
} 
private synchronized void setValue(Object x)
    { 
value = x;
} 
public abstract Object construct(ProgressMonitor progressMonitor);public void finished()
    { 
deactivateGlassPane();
ArgoFrame.getInstance().setCursor(Cursor.getPredefinedCursor(
                                              Cursor.DEFAULT_CURSOR));
} 
protected GlassPane getGlassPane()
    { 
return glassPane;
} 
public SwingWorker(String threadName)
    { 
this();
threadVar.get().setName(threadName);
} 
private void deactivateGlassPane()
    { 
if(getGlassPane() != null)//1
{ 
getGlassPane().setVisible(false);
} 
} 
public Object doConstruct()
    { 
activateGlassPane();
pmw = initProgressMonitorWindow();
ArgoFrame.getInstance().setCursor(
            Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
Object retVal = null;
timer = new Timer(25, new TimerListener());
timer.start();
try//1
{ 
retVal = construct(pmw);
} 
catch (Exception exc) //1
{ 
} 
finally { 
pmw.close();
} 
return retVal;
} 
public void start()
    { 
Thread t = threadVar.get();
if(t != null)//1
{ 
t.start();
} 
} 
public Object get()
    { 
while (true) //1
{ 
Thread t = threadVar.get();
if(t == null)//1
{ 
return getValue();
} 
try//1
{ 
t.join();
} 
catch (InterruptedException e) //1
{ 
Thread.currentThread().interrupt();
return null;
} 
} 
} 
protected void activateGlassPane()
    { 
GlassPane aPane = GlassPane.mount(ArgoFrame.getInstance(), true);
setGlassPane(aPane);
if(getGlassPane() != null)//1
{ 
getGlassPane().setVisible(true);
} 
} 
protected synchronized Object getValue()
    { 
return value;
} 
public SwingWorker()
    { 
final Runnable doFinished = new Runnable() {
            public void run() {
                finished();
            }
        };
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
Thread t = new Thread(doConstruct);
threadVar = new ThreadVar(t);
} 
public void interrupt()
    { 
Thread t = threadVar.get();
if(t != null)//1
{ 
t.interrupt();
} 
threadVar.clear();
} 
private static class ThreadVar  { 
private Thread thread;
ThreadVar(Thread t)
        { 
thread = t;
} 
synchronized Thread get()
        { 
return thread;
} 
synchronized void clear()
        { 
thread = null;
} 

 } 
class TimerListener implements ActionListener
  { 
public void actionPerformed(ActionEvent evt)
        { 
if(pmw.isCanceled())//1
{ 
threadVar.thread.interrupt();
interrupt();
timer.stop();
} 
} 

 } 

 } 
