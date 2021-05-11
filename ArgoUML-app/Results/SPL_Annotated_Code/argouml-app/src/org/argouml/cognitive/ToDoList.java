// Compilation Unit of /ToDoList.java 
 

//#if COGNITIVE 
package org.argouml.cognitive;
//#endif 


//#if COGNITIVE 
import java.util.ArrayList;
//#endif 


//#if COGNITIVE 
import java.util.Collections;
//#endif 


//#if COGNITIVE 
import java.util.HashSet;
//#endif 


//#if COGNITIVE 
import java.util.Iterator;
//#endif 


//#if COGNITIVE 
import java.util.LinkedHashSet;
//#endif 


//#if COGNITIVE 
import java.util.List;
//#endif 


//#if COGNITIVE 
import java.util.Observable;
//#endif 


//#if COGNITIVE 
import java.util.Set;
//#endif 


//#if COGNITIVE 
import javax.swing.event.EventListenerList;
//#endif 


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
import org.apache.log4j.Logger;
//#endif 


//#if COGNITIVE 
import org.argouml.i18n.Translator;
//#endif 


//#if COGNITIVE 
import org.argouml.model.InvalidElementException;
//#endif 


//#if COGNITIVE 
public class ToDoList extends Observable
 implements Runnable
  { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
private static final Logger LOG = Logger.getLogger(ToDoList.class);
//#endif 

private static final int SLEEP_SECONDS = 3;
private List<ToDoItem> items;
private Set<ToDoItem> itemSet;
private volatile ListSet allOffenders;
private volatile ListSet<Poster> allPosters;
private Set<ResolvedCritic> resolvedItems;
private Thread validityChecker;
private Designer designer;
private EventListenerList listenerList;
private static int longestToDoList;
private static int numNotValid;
private boolean isPaused;
private Object pausedMutex = new Object();
public void resume()
    { 
synchronized (pausedMutex) //1
{ 
isPaused = false;
pausedMutex.notifyAll();
} 

} 

@Deprecated
    protected void fireToDoItemRemoved(ToDoItem item)
    { 
List<ToDoItem> l = new ArrayList<ToDoItem>();
l.add(item);
fireToDoItemsRemoved(l);
} 

private void addE(ToDoItem item)
    { 
if(itemSet.contains(item))//1
{ 
return;
} 

if(item.getPoster() instanceof Critic)//1
{ 
ResolvedCritic rc;
try //1
{ 
rc = new ResolvedCritic((Critic) item.getPoster(), item
                                        .getOffenders(), false);
Iterator<ResolvedCritic> elems = resolvedItems.iterator();
while (elems.hasNext()) //1
{ 
if(elems.next().equals(rc))//1
{ 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug("ToDoItem not added because it was resolved");
//#endif 

return;
} 

} 

} 

//#if COGNITIVE 
catch (UnresolvableException ure) //1
{ 
} 

//#endif 


} 

items.add(item);
itemSet.add(item);
longestToDoList = Math.max(longestToDoList, items.size());
addOffenders(item.getOffenders());
addPosters(item.getPoster());
notifyObservers("addElement", item);
fireToDoItemAdded(item);
} 

ToDoList()
    { 
items = Collections.synchronizedList(new ArrayList<ToDoItem>(100));
itemSet = Collections.synchronizedSet(new HashSet<ToDoItem>(100));
resolvedItems =
            Collections.synchronizedSet(new LinkedHashSet<ResolvedCritic>(100));
listenerList = new EventListenerList();
longestToDoList = 0;
numNotValid = 0;
} 

@Override
    public String toString()
    { 
StringBuffer res = new StringBuffer(100);
res.append(getClass().getName()).append(" {\n");
List<ToDoItem> itemList = getToDoItemList();
synchronized (itemList) //1
{ 
for (ToDoItem item : itemList) //1
{ 
res.append("    ").append(item.toString()).append("\n");
} 

} 

res.append("  }");
return res.toString();
} 

public ListSet getOffenders()
    { 
ListSet all = allOffenders;
if(all == null)//1
{ 
int size = items.size();
all = new ListSet(size * 2);
synchronized (items) //1
{ 
for (ToDoItem item : items) //1
{ 
all.addAll(item.getOffenders());
} 

} 

allOffenders = all;
} 

return all;
} 

public List<ToDoItem> getToDoItemList()
    { 
return items;
} 

private void addPosters(Poster newp)
    { 
if(allPosters != null)//1
{ 
allPosters.add(newp);
} 

} 

public void removeAllElements()
    { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug("removing all todo items");
//#endif 

List<ToDoItem> oldItems = new ArrayList<ToDoItem>(items);
items.clear();
itemSet.clear();
recomputeAllOffenders();
recomputeAllPosters();
notifyObservers("removeAllElements");
fireToDoItemsRemoved(oldItems);
} 

public void notifyObservers(Object o)
    { 
setChanged();
super.notifyObservers(o);
} 

private boolean removeE(ToDoItem item)
    { 
itemSet.remove(item);
return items.remove(item);
} 

public int size()
    { 
return items.size();
} 

public boolean addResolvedCritic(ResolvedCritic rc)
    { 
return resolvedItems.add(rc);
} 

protected void fireToDoItemAdded(ToDoItem item)
    { 
List<ToDoItem> l = new ArrayList<ToDoItem>();
l.add(item);
fireToDoItemsAdded(l);
} 

public void notifyObservers(String action, Object arg)
    { 
setChanged();
List<Object> l = new ArrayList<Object>(2);
l.add(action);
l.add(arg);
super.notifyObservers(l);
} 

@Deprecated
    protected synchronized void forceValidityCheck(
        final List<ToDoItem> removes)
    { 
synchronized (items) //1
{ 
for (ToDoItem item : items) //1
{ 
boolean valid;
try //1
{ 
valid = item.stillValid(designer);
} 

//#if COGNITIVE 
catch (InvalidElementException ex) //1
{ 
valid = false;
} 

//#endif 


//#if COGNITIVE 
catch (Exception ex) //1
{ 
valid = false;
StringBuffer buf = new StringBuffer(
                        "Exception raised in ToDo list cleaning");
buf.append("\n");
buf.append(item.toString());

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.error(buf.toString(), ex);
//#endif 

} 

//#endif 


if(!valid)//1
{ 
numNotValid++;
removes.add(item);
} 

} 

} 

for (ToDoItem item : removes) //1
{ 
removeE(item);
} 

recomputeAllOffenders();
recomputeAllPosters();
fireToDoItemsRemoved(removes);
} 

public void run()
    { 
final List<ToDoItem> removes = new ArrayList<ToDoItem>();
while (true) //1
{ 
synchronized (pausedMutex) //1
{ 
while (isPaused) //1
{ 
try //1
{ 
pausedMutex.wait();
} 

//#if COGNITIVE 
catch (InterruptedException ignore) //1
{ 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.error("InterruptedException!!!", ignore);
//#endif 

} 

//#endif 


} 

} 

forceValidityCheck(removes);
removes.clear();
try //1
{ 
Thread.sleep(SLEEP_SECONDS * 1000);
} 

//#if COGNITIVE 
catch (InterruptedException ignore) //1
{ 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.error("InterruptedException!!!", ignore);
//#endif 

} 

//#endif 


} 

} 

@Deprecated
    protected void fireToDoItemsAdded(List<ToDoItem> theItems)
    { 
if(theItems.size() > 0)//1
{ 
final Object[] listeners = listenerList.getListenerList();
ToDoListEvent e = null;
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 
if(listeners[i] == ToDoListListener.class)//1
{ 
if(e == null)//1
{ 
e = new ToDoListEvent(theItems);
} 

((ToDoListListener) listeners[i + 1]).toDoItemsAdded(e);
} 

} 

} 

} 

public void setPaused(boolean paused)
    { 
if(paused)//1
{ 
pause();
} 
else
{ 
resume();
} 

} 

public Set<ResolvedCritic> getResolvedItems()
    { 
return resolvedItems;
} 

public ListSet<Poster> getPosters()
    { 
ListSet<Poster> all = allPosters;
if(all == null)//1
{ 
all = new ListSet<Poster>();
synchronized (items) //1
{ 
for (ToDoItem item : items) //1
{ 
all.add(item.getPoster());
} 

} 

allPosters = all;
} 

return all;
} 

public void pause()
    { 
synchronized (pausedMutex) //1
{ 
isPaused = true;
} 

} 

public static List<Decision> getDecisionList()
    { 
return new ArrayList<Decision>();
} 

public void addElement(ToDoItem item)
    { 
addE(item);
} 

public void forceValidityCheck()
    { 
final List<ToDoItem> removes = new ArrayList<ToDoItem>();
forceValidityCheck(removes);
} 

public boolean removeElement(ToDoItem item)
    { 
boolean res = removeE(item);
recomputeAllOffenders();
recomputeAllPosters();
fireToDoItemRemoved(item);
notifyObservers("removeElement", item);
return res;
} 

public List<ToDoItem> elementListForOffender(Object offender)
    { 
List<ToDoItem> offenderItems = new ArrayList<ToDoItem>();
synchronized (items) //1
{ 
for (ToDoItem item : items) //1
{ 
if(item.getOffenders().contains(offender))//1
{ 
offenderItems.add(item);
} 

} 

} 

return offenderItems;
} 

public boolean resolve(ToDoItem item)
    { 
boolean res = removeE(item);
fireToDoItemRemoved(item);
return res;
} 

@Deprecated
    protected void recomputeAllPosters()
    { 
allPosters = null;
} 

public void notifyObservers()
    { 
setChanged();
super.notifyObservers();
} 

public ToDoItem get(int index)
    { 
return items.get(index);
} 

@Deprecated
    protected void fireToDoItemsRemoved(final List<ToDoItem> theItems)
    { 
if(theItems.size() > 0)//1
{ 
final Object[] listeners = listenerList.getListenerList();
ToDoListEvent e = null;
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 
if(listeners[i] == ToDoListListener.class)//1
{ 
if(e == null)//1
{ 
e = new ToDoListEvent(theItems);
} 

((ToDoListListener) listeners[i + 1]).toDoItemsRemoved(e);
} 

} 

} 

} 

public boolean explicitlyResolve(ToDoItem item, String reason)
    throws UnresolvableException
    { 
if(item.getPoster() instanceof Designer)//1
{ 
boolean res = resolve(item);
return res;
} 

if(!(item.getPoster() instanceof Critic))//1
{ 
throw new UnresolvableException(Translator.localize(
                                                "misc.todo-unresolvable", new Object[] {item.getPoster()
                                                        .getClass()
                                                                                       }));
} 

ResolvedCritic rc = new ResolvedCritic((Critic) item.getPoster(), item
                                               .getOffenders());
boolean res = resolve(item);
if(res)//1
{ 
res = addResolvedCritic(rc);
} 

return res;
} 

@Deprecated
    protected void fireToDoItemChanged(ToDoItem item)
    { 
Object[] listeners = listenerList.getListenerList();
ToDoListEvent e = null;
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 
if(listeners[i] == ToDoListListener.class)//1
{ 
if(e == null)//1
{ 
List<ToDoItem> its = new ArrayList<ToDoItem>();
its.add(item);
e = new ToDoListEvent(its);
} 

((ToDoListListener) listeners[i + 1]).toDoItemsChanged(e);
} 

} 

} 

public void removeToDoListListener(ToDoListListener l)
    { 
listenerList.remove(ToDoListListener.class, l);
} 

public static List<Goal> getGoalList()
    { 
return new ArrayList<Goal>();
} 

@Deprecated
    protected void fireToDoListChanged()
    { 
Object[] listeners = listenerList.getListenerList();
ToDoListEvent e = null;
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 
if(listeners[i] == ToDoListListener.class)//1
{ 
if(e == null)//1
{ 
e = new ToDoListEvent();
} 

((ToDoListListener) listeners[i + 1]).toDoListChanged(e);
} 

} 

} 

public void removeAll(ToDoList list)
    { 
List<ToDoItem> itemList = list.getToDoItemList();
synchronized (itemList) //1
{ 
for (ToDoItem item : itemList) //1
{ 
removeE(item);
} 

recomputeAllOffenders();
recomputeAllPosters();
fireToDoItemsRemoved(itemList);
} 

} 

private void addOffenders(ListSet newoffs)
    { 
if(allOffenders != null)//1
{ 
allOffenders.addAll(newoffs);
} 

} 

@Deprecated
    protected void recomputeAllOffenders()
    { 
allOffenders = null;
} 

public boolean isPaused()
    { 
synchronized (pausedMutex) //1
{ 
return isPaused;
} 

} 

public synchronized void spawnValidityChecker(Designer d)
    { 
designer = d;
validityChecker = new Thread(this, "Argo-ToDoValidityCheckingThread");
validityChecker.setDaemon(true);
validityChecker.setPriority(Thread.MIN_PRIORITY);
setPaused(false);
validityChecker.start();
} 

public void addToDoListListener(ToDoListListener l)
    { 
listenerList.add(ToDoListListener.class, l);
} 

 } 

//#endif 


