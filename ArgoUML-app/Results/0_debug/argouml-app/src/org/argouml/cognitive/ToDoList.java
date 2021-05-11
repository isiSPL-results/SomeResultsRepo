
//#if 772142584 
// Compilation Unit of /ToDoList.java 
 

//#if 1865056048 
package org.argouml.cognitive;
//#endif 


//#if 699327837 
import java.util.ArrayList;
//#endif 


//#if 617025503 
import java.util.Collections;
//#endif 


//#if -1972730528 
import java.util.HashSet;
//#endif 


//#if 975581588 
import java.util.Iterator;
//#endif 


//#if -62197799 
import java.util.LinkedHashSet;
//#endif 


//#if -1907250460 
import java.util.List;
//#endif 


//#if -188155489 
import java.util.Observable;
//#endif 


//#if 1324153778 
import java.util.Set;
//#endif 


//#if -1943511324 
import javax.swing.event.EventListenerList;
//#endif 


//#if -1276989862 
import org.apache.log4j.Logger;
//#endif 


//#if -482069625 
import org.argouml.i18n.Translator;
//#endif 


//#if 1994990476 
import org.argouml.model.InvalidElementException;
//#endif 


//#if -627688833 
public class ToDoList extends 
//#if 1297292211 
Observable
//#endif 

 implements 
//#if 1778242957 
Runnable
//#endif 

  { 

//#if 1153497186 
private static final Logger LOG = Logger.getLogger(ToDoList.class);
//#endif 


//#if -377820600 
private static final int SLEEP_SECONDS = 3;
//#endif 


//#if 592253461 
private List<ToDoItem> items;
//#endif 


//#if 867062564 
private Set<ToDoItem> itemSet;
//#endif 


//#if -1174427347 
private volatile ListSet allOffenders;
//#endif 


//#if 943686380 
private volatile ListSet<Poster> allPosters;
//#endif 


//#if 1750363480 
private Set<ResolvedCritic> resolvedItems;
//#endif 


//#if 2048138133 
private Thread validityChecker;
//#endif 


//#if -532990158 
private Designer designer;
//#endif 


//#if -2052483728 
private EventListenerList listenerList;
//#endif 


//#if 1424282395 
private static int longestToDoList;
//#endif 


//#if 83437946 
private static int numNotValid;
//#endif 


//#if 180702286 
private boolean isPaused;
//#endif 


//#if -1201557063 
private Object pausedMutex = new Object();
//#endif 


//#if 52513467 
public void resume()
    { 

//#if -583747422 
synchronized (pausedMutex) //1
{ 

//#if -1430912199 
isPaused = false;
//#endif 


//#if 100931811 
pausedMutex.notifyAll();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 517166183 
@Deprecated
    protected void fireToDoItemRemoved(ToDoItem item)
    { 

//#if 709425838 
List<ToDoItem> l = new ArrayList<ToDoItem>();
//#endif 


//#if -1503589854 
l.add(item);
//#endif 


//#if -1096894138 
fireToDoItemsRemoved(l);
//#endif 

} 

//#endif 


//#if 209120640 
private void addE(ToDoItem item)
    { 

//#if -726438725 
if(itemSet.contains(item))//1
{ 

//#if -639796996 
return;
//#endif 

} 

//#endif 


//#if 25764792 
if(item.getPoster() instanceof Critic)//1
{ 

//#if -2024343813 
ResolvedCritic rc;
//#endif 


//#if 1952346585 
try //1
{ 

//#if 869359264 
rc = new ResolvedCritic((Critic) item.getPoster(), item
                                        .getOffenders(), false);
//#endif 


//#if 1779032654 
Iterator<ResolvedCritic> elems = resolvedItems.iterator();
//#endif 


//#if 200153658 
while (elems.hasNext()) //1
{ 

//#if -1912960602 
if(elems.next().equals(rc))//1
{ 

//#if 779029264 
LOG.debug("ToDoItem not added because it was resolved");
//#endif 


//#if 2056699062 
return;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#if -1176774788 
catch (UnresolvableException ure) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 


//#if -1820614722 
items.add(item);
//#endif 


//#if -30297393 
itemSet.add(item);
//#endif 


//#if 1618224599 
longestToDoList = Math.max(longestToDoList, items.size());
//#endif 


//#if -76934457 
addOffenders(item.getOffenders());
//#endif 


//#if 259952090 
addPosters(item.getPoster());
//#endif 


//#if -1320834412 
notifyObservers("addElement", item);
//#endif 


//#if -720914912 
fireToDoItemAdded(item);
//#endif 

} 

//#endif 


//#if 1465653397 
ToDoList()
    { 

//#if -2085965415 
items = Collections.synchronizedList(new ArrayList<ToDoItem>(100));
//#endif 


//#if -1122022995 
itemSet = Collections.synchronizedSet(new HashSet<ToDoItem>(100));
//#endif 


//#if -1796982222 
resolvedItems =
            Collections.synchronizedSet(new LinkedHashSet<ResolvedCritic>(100));
//#endif 


//#if 516326506 
listenerList = new EventListenerList();
//#endif 


//#if 961060769 
longestToDoList = 0;
//#endif 


//#if 1973198528 
numNotValid = 0;
//#endif 

} 

//#endif 


//#if 1818070691 
@Override
    public String toString()
    { 

//#if 1022725202 
StringBuffer res = new StringBuffer(100);
//#endif 


//#if -542191797 
res.append(getClass().getName()).append(" {\n");
//#endif 


//#if 585604230 
List<ToDoItem> itemList = getToDoItemList();
//#endif 


//#if -1622321407 
synchronized (itemList) //1
{ 

//#if -2145494546 
for (ToDoItem item : itemList) //1
{ 

//#if -129813280 
res.append("    ").append(item.toString()).append("\n");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1497242939 
res.append("  }");
//#endif 


//#if 329046020 
return res.toString();
//#endif 

} 

//#endif 


//#if 175913680 
public ListSet getOffenders()
    { 

//#if 1289628553 
ListSet all = allOffenders;
//#endif 


//#if 1949008300 
if(all == null)//1
{ 

//#if 510433311 
int size = items.size();
//#endif 


//#if -1745037244 
all = new ListSet(size * 2);
//#endif 


//#if 1601876243 
synchronized (items) //1
{ 

//#if 1204522740 
for (ToDoItem item : items) //1
{ 

//#if -1954969180 
all.addAll(item.getOffenders());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2135293537 
allOffenders = all;
//#endif 

} 

//#endif 


//#if -2067958767 
return all;
//#endif 

} 

//#endif 


//#if -1367008530 
public List<ToDoItem> getToDoItemList()
    { 

//#if -306443139 
return items;
//#endif 

} 

//#endif 


//#if 404499536 
private void addPosters(Poster newp)
    { 

//#if 877358239 
if(allPosters != null)//1
{ 

//#if 1896336742 
allPosters.add(newp);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 437005224 
public void removeAllElements()
    { 

//#if -1683341030 
LOG.debug("removing all todo items");
//#endif 


//#if 1450559300 
List<ToDoItem> oldItems = new ArrayList<ToDoItem>(items);
//#endif 


//#if -291331842 
items.clear();
//#endif 


//#if -1963913073 
itemSet.clear();
//#endif 


//#if -2071861728 
recomputeAllOffenders();
//#endif 


//#if -338803020 
recomputeAllPosters();
//#endif 


//#if -1485202997 
notifyObservers("removeAllElements");
//#endif 


//#if -391713580 
fireToDoItemsRemoved(oldItems);
//#endif 

} 

//#endif 


//#if -978208870 
public void notifyObservers(Object o)
    { 

//#if 1173510955 
setChanged();
//#endif 


//#if 1659003741 
super.notifyObservers(o);
//#endif 

} 

//#endif 


//#if 1358836033 
private boolean removeE(ToDoItem item)
    { 

//#if -1964859782 
itemSet.remove(item);
//#endif 


//#if 883645691 
return items.remove(item);
//#endif 

} 

//#endif 


//#if -217436968 
public int size()
    { 

//#if 111274424 
return items.size();
//#endif 

} 

//#endif 


//#if -1358401694 
public boolean addResolvedCritic(ResolvedCritic rc)
    { 

//#if -1846520109 
return resolvedItems.add(rc);
//#endif 

} 

//#endif 


//#if -651055468 
protected void fireToDoItemAdded(ToDoItem item)
    { 

//#if -1403514384 
List<ToDoItem> l = new ArrayList<ToDoItem>();
//#endif 


//#if 479857568 
l.add(item);
//#endif 


//#if 917637604 
fireToDoItemsAdded(l);
//#endif 

} 

//#endif 


//#if -1980281578 
public void notifyObservers(String action, Object arg)
    { 

//#if -1227767914 
setChanged();
//#endif 


//#if 457848506 
List<Object> l = new ArrayList<Object>(2);
//#endif 


//#if -2096050909 
l.add(action);
//#endif 


//#if 1130366125 
l.add(arg);
//#endif 


//#if 1552905221 
super.notifyObservers(l);
//#endif 

} 

//#endif 


//#if -847010931 
@Deprecated
    protected synchronized void forceValidityCheck(
        final List<ToDoItem> removes)
    { 

//#if -577534376 
synchronized (items) //1
{ 

//#if -1766476693 
for (ToDoItem item : items) //1
{ 

//#if 2040765265 
boolean valid;
//#endif 


//#if 1133886604 
try //1
{ 

//#if 811691894 
valid = item.stillValid(designer);
//#endif 

} 

//#if 1035620724 
catch (InvalidElementException ex) //1
{ 

//#if 2128702103 
valid = false;
//#endif 

} 

//#endif 


//#if -416648327 
catch (Exception ex) //1
{ 

//#if -1189492454 
valid = false;
//#endif 


//#if -612226214 
StringBuffer buf = new StringBuffer(
                        "Exception raised in ToDo list cleaning");
//#endif 


//#if 316435634 
buf.append("\n");
//#endif 


//#if -1506159992 
buf.append(item.toString());
//#endif 


//#if 1478452126 
LOG.error(buf.toString(), ex);
//#endif 

} 

//#endif 


//#endif 


//#if 899881688 
if(!valid)//1
{ 

//#if 2015824056 
numNotValid++;
//#endif 


//#if -145225321 
removes.add(item);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 928048108 
for (ToDoItem item : removes) //1
{ 

//#if -40884848 
removeE(item);
//#endif 

} 

//#endif 


//#if 462102625 
recomputeAllOffenders();
//#endif 


//#if 682827061 
recomputeAllPosters();
//#endif 


//#if -1144459719 
fireToDoItemsRemoved(removes);
//#endif 

} 

//#endif 


//#if -2090569953 
public void run()
    { 

//#if 1222207425 
final List<ToDoItem> removes = new ArrayList<ToDoItem>();
//#endif 


//#if -3479937 
while (true) //1
{ 

//#if 1091574402 
synchronized (pausedMutex) //1
{ 

//#if 2038736374 
while (isPaused) //1
{ 

//#if 700816194 
try //1
{ 

//#if 1036895331 
pausedMutex.wait();
//#endif 

} 

//#if -622581702 
catch (InterruptedException ignore) //1
{ 

//#if -1318463584 
LOG.error("InterruptedException!!!", ignore);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -485362335 
forceValidityCheck(removes);
//#endif 


//#if -320703319 
removes.clear();
//#endif 


//#if -860958957 
try //1
{ 

//#if -2052547144 
Thread.sleep(SLEEP_SECONDS * 1000);
//#endif 

} 

//#if -2031498024 
catch (InterruptedException ignore) //1
{ 

//#if 1146241721 
LOG.error("InterruptedException!!!", ignore);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 399008358 
@Deprecated
    protected void fireToDoItemsAdded(List<ToDoItem> theItems)
    { 

//#if 1491450991 
if(theItems.size() > 0)//1
{ 

//#if 535696586 
final Object[] listeners = listenerList.getListenerList();
//#endif 


//#if 1356716407 
ToDoListEvent e = null;
//#endif 


//#if -454716090 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if 1878380200 
if(listeners[i] == ToDoListListener.class)//1
{ 

//#if 1566010676 
if(e == null)//1
{ 

//#if 1312005620 
e = new ToDoListEvent(theItems);
//#endif 

} 

//#endif 


//#if -980718870 
((ToDoListListener) listeners[i + 1]).toDoItemsAdded(e);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 125272664 
public void setPaused(boolean paused)
    { 

//#if 1574966890 
if(paused)//1
{ 

//#if 212426251 
pause();
//#endif 

} 
else
{ 

//#if 1508292749 
resume();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1364747278 
public Set<ResolvedCritic> getResolvedItems()
    { 

//#if 1784668046 
return resolvedItems;
//#endif 

} 

//#endif 


//#if 2007928625 
public ListSet<Poster> getPosters()
    { 

//#if 487780149 
ListSet<Poster> all = allPosters;
//#endif 


//#if 460340441 
if(all == null)//1
{ 

//#if 1352568278 
all = new ListSet<Poster>();
//#endif 


//#if 2043092899 
synchronized (items) //1
{ 

//#if 1623533789 
for (ToDoItem item : items) //1
{ 

//#if 550193227 
all.add(item.getPoster());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2093616861 
allPosters = all;
//#endif 

} 

//#endif 


//#if -1069198082 
return all;
//#endif 

} 

//#endif 


//#if -1331862774 
public void pause()
    { 

//#if 1723056897 
synchronized (pausedMutex) //1
{ 

//#if -300408497 
isPaused = true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 643570438 
public static List<Decision> getDecisionList()
    { 

//#if 605372354 
return new ArrayList<Decision>();
//#endif 

} 

//#endif 


//#if 1456432605 
public void addElement(ToDoItem item)
    { 

//#if -594844965 
addE(item);
//#endif 

} 

//#endif 


//#if -247287975 
public void forceValidityCheck()
    { 

//#if -77417080 
final List<ToDoItem> removes = new ArrayList<ToDoItem>();
//#endif 


//#if 915588701 
forceValidityCheck(removes);
//#endif 

} 

//#endif 


//#if 724867166 
public boolean removeElement(ToDoItem item)
    { 

//#if 205895111 
boolean res = removeE(item);
//#endif 


//#if -1506259449 
recomputeAllOffenders();
//#endif 


//#if 1677425755 
recomputeAllPosters();
//#endif 


//#if 1042112102 
fireToDoItemRemoved(item);
//#endif 


//#if 1368936227 
notifyObservers("removeElement", item);
//#endif 


//#if 35797781 
return res;
//#endif 

} 

//#endif 


//#if -1237235311 
public List<ToDoItem> elementListForOffender(Object offender)
    { 

//#if 941466605 
List<ToDoItem> offenderItems = new ArrayList<ToDoItem>();
//#endif 


//#if 710129348 
synchronized (items) //1
{ 

//#if -840674155 
for (ToDoItem item : items) //1
{ 

//#if 491614874 
if(item.getOffenders().contains(offender))//1
{ 

//#if 913667931 
offenderItems.add(item);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1265840724 
return offenderItems;
//#endif 

} 

//#endif 


//#if -1392241102 
public boolean resolve(ToDoItem item)
    { 

//#if 531726070 
boolean res = removeE(item);
//#endif 


//#if -1742030057 
fireToDoItemRemoved(item);
//#endif 


//#if 876157382 
return res;
//#endif 

} 

//#endif 


//#if 522720363 
@Deprecated
    protected void recomputeAllPosters()
    { 

//#if 1757954631 
allPosters = null;
//#endif 

} 

//#endif 


//#if 177308904 
public void notifyObservers()
    { 

//#if -1652168672 
setChanged();
//#endif 


//#if 1368645665 
super.notifyObservers();
//#endif 

} 

//#endif 


//#if -886178878 
public ToDoItem get(int index)
    { 

//#if -726894105 
return items.get(index);
//#endif 

} 

//#endif 


//#if 1561093258 
@Deprecated
    protected void fireToDoItemsRemoved(final List<ToDoItem> theItems)
    { 

//#if -1267160869 
if(theItems.size() > 0)//1
{ 

//#if 1562619878 
final Object[] listeners = listenerList.getListenerList();
//#endif 


//#if 1462172563 
ToDoListEvent e = null;
//#endif 


//#if 1336286378 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if -1267970345 
if(listeners[i] == ToDoListListener.class)//1
{ 

//#if -801711574 
if(e == null)//1
{ 

//#if -659504115 
e = new ToDoListEvent(theItems);
//#endif 

} 

//#endif 


//#if -1360113836 
((ToDoListListener) listeners[i + 1]).toDoItemsRemoved(e);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -424629578 
public boolean explicitlyResolve(ToDoItem item, String reason)
    throws UnresolvableException
    { 

//#if 214270186 
if(item.getPoster() instanceof Designer)//1
{ 

//#if -1875039488 
boolean res = resolve(item);
//#endif 


//#if 1783486033 
return res;
//#endif 

} 

//#endif 


//#if 1751180575 
if(!(item.getPoster() instanceof Critic))//1
{ 

//#if 344834679 
throw new UnresolvableException(Translator.localize(
                                                "misc.todo-unresolvable", new Object[] {item.getPoster()
                                                        .getClass()
                                                                                       }));
//#endif 

} 

//#endif 


//#if 950651311 
ResolvedCritic rc = new ResolvedCritic((Critic) item.getPoster(), item
                                               .getOffenders());
//#endif 


//#if -942379491 
boolean res = resolve(item);
//#endif 


//#if -963165914 
if(res)//1
{ 

//#if -1547396739 
res = addResolvedCritic(rc);
//#endif 

} 

//#endif 


//#if 1417567444 
return res;
//#endif 

} 

//#endif 


//#if -163578949 
@Deprecated
    protected void fireToDoItemChanged(ToDoItem item)
    { 

//#if -539711226 
Object[] listeners = listenerList.getListenerList();
//#endif 


//#if -397538513 
ToDoListEvent e = null;
//#endif 


//#if -1672730994 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if -513754820 
if(listeners[i] == ToDoListListener.class)//1
{ 

//#if -93463850 
if(e == null)//1
{ 

//#if 1610861737 
List<ToDoItem> its = new ArrayList<ToDoItem>();
//#endif 


//#if 1611406599 
its.add(item);
//#endif 


//#if -1358015595 
e = new ToDoListEvent(its);
//#endif 

} 

//#endif 


//#if -713490308 
((ToDoListListener) listeners[i + 1]).toDoItemsChanged(e);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1265600460 
public void removeToDoListListener(ToDoListListener l)
    { 

//#if 1684302085 
listenerList.remove(ToDoListListener.class, l);
//#endif 

} 

//#endif 


//#if 1406998772 
public static List<Goal> getGoalList()
    { 

//#if 2104170695 
return new ArrayList<Goal>();
//#endif 

} 

//#endif 


//#if -1546022564 
@Deprecated
    protected void fireToDoListChanged()
    { 

//#if 1168850375 
Object[] listeners = listenerList.getListenerList();
//#endif 


//#if 1369763534 
ToDoListEvent e = null;
//#endif 


//#if -1505751985 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if -1027024083 
if(listeners[i] == ToDoListListener.class)//1
{ 

//#if -1934460223 
if(e == null)//1
{ 

//#if 239867027 
e = new ToDoListEvent();
//#endif 

} 

//#endif 


//#if -1581955657 
((ToDoListListener) listeners[i + 1]).toDoListChanged(e);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 97658799 
public void removeAll(ToDoList list)
    { 

//#if -1843876498 
List<ToDoItem> itemList = list.getToDoItemList();
//#endif 


//#if -999784553 
synchronized (itemList) //1
{ 

//#if -656542645 
for (ToDoItem item : itemList) //1
{ 

//#if 1932354647 
removeE(item);
//#endif 

} 

//#endif 


//#if -2037858246 
recomputeAllOffenders();
//#endif 


//#if 1444470606 
recomputeAllPosters();
//#endif 


//#if 2107308018 
fireToDoItemsRemoved(itemList);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 604463041 
private void addOffenders(ListSet newoffs)
    { 

//#if -754197365 
if(allOffenders != null)//1
{ 

//#if -847512904 
allOffenders.addAll(newoffs);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -270440833 
@Deprecated
    protected void recomputeAllOffenders()
    { 

//#if 24108809 
allOffenders = null;
//#endif 

} 

//#endif 


//#if -666414968 
public boolean isPaused()
    { 

//#if -13819562 
synchronized (pausedMutex) //1
{ 

//#if -1122553916 
return isPaused;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1882855183 
public synchronized void spawnValidityChecker(Designer d)
    { 

//#if -138634 
designer = d;
//#endif 


//#if 442322851 
validityChecker = new Thread(this, "Argo-ToDoValidityCheckingThread");
//#endif 


//#if 98610624 
validityChecker.setDaemon(true);
//#endif 


//#if -104237593 
validityChecker.setPriority(Thread.MIN_PRIORITY);
//#endif 


//#if 493023946 
setPaused(false);
//#endif 


//#if 400559702 
validityChecker.start();
//#endif 

} 

//#endif 


//#if -559951311 
public void addToDoListListener(ToDoListListener l)
    { 

//#if -356153939 
listenerList.add(ToDoListListener.class, l);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

