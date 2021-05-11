
//#if -1786963483 
// Compilation Unit of /TargetManager.java 
 

//#if 376196032 
package org.argouml.ui.targetmanager;
//#endif 


//#if -689645426 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 647372602 
import java.beans.PropertyChangeListener;
//#endif 


//#if 450858214 
import java.lang.ref.WeakReference;
//#endif 


//#if 472307507 
import java.util.ArrayList;
//#endif 


//#if -1198738290 
import java.util.Collection;
//#endif 


//#if 1493820469 
import java.util.Collections;
//#endif 


//#if -694309634 
import java.util.Iterator;
//#endif 


//#if 1003711310 
import java.util.List;
//#endif 


//#if 1422118272 
import java.util.ListIterator;
//#endif 


//#if 2142946547 
import javax.management.ListenerNotFoundException;
//#endif 


//#if -903330644 
import javax.management.Notification;
//#endif 


//#if -492429028 
import javax.management.NotificationEmitter;
//#endif 


//#if -257477288 
import javax.management.NotificationListener;
//#endif 


//#if 144565434 
import javax.swing.event.EventListenerList;
//#endif 


//#if 1059479431 
import org.argouml.kernel.Project;
//#endif 


//#if -70427262 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1356918947 
import org.argouml.model.Model;
//#endif 


//#if -550602668 
import org.tigris.gef.base.Diagram;
//#endif 


//#if -1185818726 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -490617552 
import org.apache.log4j.Logger;
//#endif 


//#if 968644519 
public final class TargetManager  { 

//#if 728148675 
private static TargetManager instance = new TargetManager();
//#endif 


//#if 446918793 
private List targets = new ArrayList();
//#endif 


//#if -382427487 
private Object modelTarget;
//#endif 


//#if 665654793 
private Fig figTarget;
//#endif 


//#if -391128050 
private EventListenerList listenerList = new EventListenerList();
//#endif 


//#if -1435639893 
private HistoryManager historyManager = new HistoryManager();
//#endif 


//#if 2117454971 
private Remover umlListener = new TargetRemover();
//#endif 


//#if 1872189507 
private boolean inTransaction = false;
//#endif 


//#if 1008161576 
private static final Logger LOG = Logger.getLogger(TargetManager.class);
//#endif 


//#if -1656294129 
private void internalOnSetTarget(String eventName, Object[] oldTargets)
    { 

//#if -1129684307 
TargetEvent event =
            new TargetEvent(this, eventName, oldTargets, targets.toArray());
//#endif 


//#if -1519037526 
if(targets.size() > 0)//1
{ 

//#if -2112535032 
figTarget = determineFigTarget(targets.get(0));
//#endif 


//#if 1718536616 
modelTarget = determineModelTarget(targets.get(0));
//#endif 

} 
else
{ 

//#if -768569337 
figTarget = null;
//#endif 


//#if 1298134252 
modelTarget = null;
//#endif 

} 

//#endif 


//#if -754147998 
if(TargetEvent.TARGET_SET.equals(eventName))//1
{ 

//#if -1094237091 
fireTargetSet(event);
//#endif 


//#if -395936439 
return;
//#endif 

} 
else

//#if 1873497820 
if(TargetEvent.TARGET_ADDED.equals(eventName))//1
{ 

//#if 751698110 
fireTargetAdded(event);
//#endif 


//#if -1079373108 
return;
//#endif 

} 
else

//#if -788677118 
if(TargetEvent.TARGET_REMOVED.equals(eventName))//1
{ 

//#if -1047455494 
fireTargetRemoved(event);
//#endif 


//#if 936849704 
return;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#if 743951486 
LOG.error("Unknown eventName: " + eventName);
//#endif 

} 

//#endif 


//#if -2052007222 
public synchronized Object getTarget()
    { 

//#if 2092513998 
return targets.size() > 0 ? targets.get(0) : null;
//#endif 

} 

//#endif 


//#if -73111183 
public void navigateForward() throws IllegalStateException
    { 

//#if -2042835489 
historyManager.navigateForward();
//#endif 


//#if -550492985 
LOG.debug("Navigate forward");
//#endif 

} 

//#endif 


//#if 1538353276 
public synchronized void setTargets(Collection targetsCollection)
    { 

//#if -1264703703 
Iterator ntarg;
//#endif 


//#if -650863604 
if(isInTargetTransaction())//1
{ 

//#if 1584205844 
return;
//#endif 

} 

//#endif 


//#if 528102616 
Collection targetsList = new ArrayList();
//#endif 


//#if 716010800 
if(targetsCollection != null)//1
{ 

//#if -211349133 
targetsList.addAll(targetsCollection);
//#endif 

} 

//#endif 


//#if 1077499835 
List modifiedList = new ArrayList();
//#endif 


//#if -218359798 
Iterator it = targetsList.iterator();
//#endif 


//#if -1512422342 
while (it.hasNext()) //1
{ 

//#if -1286520770 
Object o = it.next();
//#endif 


//#if -1755066415 
o = getOwner(o);
//#endif 


//#if 1872801188 
if((o != null) && !modifiedList.contains(o))//1
{ 

//#if -1559131096 
modifiedList.add(o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 319018503 
targetsList = modifiedList;
//#endif 


//#if -627503933 
Object[] oldTargets = null;
//#endif 


//#if 1011237313 
if(targetsList.size() == targets.size())//1
{ 

//#if -1494217873 
boolean first = true;
//#endif 


//#if -459760134 
ntarg = targetsList.iterator();
//#endif 


//#if 590297706 
while (ntarg.hasNext()) //1
{ 

//#if 1403883008 
Object targ = ntarg.next();
//#endif 


//#if -568489047 
if(targ == null)//1
{ 

//#if -887202767 
continue;
//#endif 

} 

//#endif 


//#if -1978911934 
if(!targets.contains(targ)
                        || (first && targ != getTarget()))//1
{ 

//#if 977748774 
oldTargets = targets.toArray();
//#endif 


//#if -485409760 
break;

//#endif 

} 

//#endif 


//#if -1876665608 
first = false;
//#endif 

} 

//#endif 

} 
else
{ 

//#if -719949606 
oldTargets = targets.toArray();
//#endif 

} 

//#endif 


//#if -1346093627 
if(oldTargets == null)//1
{ 

//#if 1920081804 
return;
//#endif 

} 

//#endif 


//#if 1500042111 
startTargetTransaction();
//#endif 


//#if 745062532 
umlListener.removeAllListeners(targets);
//#endif 


//#if -330105079 
targets.clear();
//#endif 


//#if -1252408767 
ntarg = targetsList.iterator();
//#endif 


//#if 1480825393 
while (ntarg.hasNext()) //1
{ 

//#if -69296427 
Object targ = ntarg.next();
//#endif 


//#if 1888051093 
if(targets.contains(targ))//1
{ 

//#if 1805901955 
continue;
//#endif 

} 

//#endif 


//#if 1083056367 
targets.add(targ);
//#endif 


//#if 686842933 
umlListener.addListener(targ);
//#endif 

} 

//#endif 


//#if 39093247 
internalOnSetTarget(TargetEvent.TARGET_SET, oldTargets);
//#endif 


//#if -260737672 
endTargetTransaction();
//#endif 

} 

//#endif 


//#if -927244077 
public synchronized Collection getModelTargets()
    { 

//#if 619023268 
ArrayList t = new ArrayList();
//#endif 


//#if 691336129 
Iterator iter = getTargets().iterator();
//#endif 


//#if -417824840 
while (iter.hasNext()) //1
{ 

//#if 897509064 
t.add(determineModelTarget(iter.next()));
//#endif 

} 

//#endif 


//#if -296477384 
return t;
//#endif 

} 

//#endif 


//#if -1104024889 
public boolean navigateBackPossible()
    { 

//#if 2089458074 
return historyManager.navigateBackPossible();
//#endif 

} 

//#endif 


//#if -693183089 
public Object getModelTarget()
    { 

//#if 61217780 
return modelTarget;
//#endif 

} 

//#endif 


//#if 789525016 
private Object determineModelTarget(Object target)
    { 

//#if 529435147 
if(target instanceof Fig)//1
{ 

//#if -1025680747 
Object owner = ((Fig) target).getOwner();
//#endif 


//#if -1667703120 
if(Model.getFacade().isAUMLElement(owner))//1
{ 

//#if 944791873 
target = owner;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 834486076 
return target instanceof Diagram
               || Model.getFacade().isAUMLElement(target) ? target : null;
//#endif 

} 

//#endif 


//#if 322961256 
private void endTargetTransaction()
    { 

//#if -230962560 
inTransaction = false;
//#endif 

} 

//#endif 


//#if 1232996406 
public void removeHistoryElement(Object o)
    { 

//#if 577336800 
historyManager.removeHistoryTarget(o);
//#endif 

} 

//#endif 


//#if 1187110331 
public synchronized Object getSingleModelTarget()
    { 

//#if -299319392 
int i = 0;
//#endif 


//#if 436485012 
Iterator iter = getTargets().iterator();
//#endif 


//#if 236059909 
while (iter.hasNext()) //1
{ 

//#if -1111727283 
if(determineModelTarget(iter.next()) != null)//1
{ 

//#if -1412110467 
i++;
//#endif 

} 

//#endif 


//#if 994597766 
if(i > 1)//1
{ 

//#if 609833314 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1785143059 
if(i == 1)//1
{ 

//#if -1703832082 
return modelTarget;
//#endif 

} 

//#endif 


//#if 184521878 
return null;
//#endif 

} 

//#endif 


//#if 380510224 
public void removeTargetListener(TargetListener listener)
    { 

//#if -182523559 
listenerList.remove(TargetListener.class, listener);
//#endif 

} 

//#endif 


//#if -1327647863 
public static TargetManager getInstance()
    { 

//#if -190849976 
return instance;
//#endif 

} 

//#endif 


//#if 1124492857 
public synchronized void removeTarget(Object target)
    { 

//#if -1723473662 
if(isInTargetTransaction())//1
{ 

//#if 754737942 
return;
//#endif 

} 

//#endif 


//#if 221131077 
if(target == null)//1
{ 

//#if -391506868 
return;
//#endif 

} 

//#endif 


//#if 1867631817 
startTargetTransaction();
//#endif 


//#if 338889699 
Object[] oldTargets = targets.toArray();
//#endif 


//#if -1757786153 
Collection c = getOwnerAndAllFigs(target);
//#endif 


//#if 840618584 
targets.removeAll(c);
//#endif 


//#if 632480155 
umlListener.removeAllListeners(c);
//#endif 


//#if 493415954 
if(targets.size() != oldTargets.length)//1
{ 

//#if 1798415982 
internalOnSetTarget(TargetEvent.TARGET_REMOVED, oldTargets);
//#endif 

} 

//#endif 


//#if 1040202050 
endTargetTransaction();
//#endif 

} 

//#endif 


//#if 440571800 
private boolean isInTargetTransaction()
    { 

//#if -53070335 
return inTransaction;
//#endif 

} 

//#endif 


//#if 717602202 
public Object getOwner(Object o)
    { 

//#if 909712903 
if(o instanceof Fig)//1
{ 

//#if -1597597502 
if(((Fig) o).getOwner() != null)//1
{ 

//#if -459037070 
o = ((Fig) o).getOwner();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -711774959 
return o;
//#endif 

} 

//#endif 


//#if 1344331721 
public boolean navigateForwardPossible()
    { 

//#if 751963734 
return historyManager.navigateForwardPossible();
//#endif 

} 

//#endif 


//#if 1182629479 
private void fireTargetSet(TargetEvent targetEvent)
    { 

//#if -92402794 
Object[] listeners = listenerList.getListenerList();
//#endif 


//#if -1685513954 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if -641164287 
try //1
{ 

//#if -1929399285 
if(listeners[i] == TargetListener.class)//1
{ 

//#if -1580827698 
((TargetListener) listeners[i + 1]).targetSet(targetEvent);
//#endif 

} 

//#endif 

} 

//#if -1754117215 
catch (RuntimeException e) //1
{ 

//#if 55953367 
LOG.error("While calling targetSet for "
                          + targetEvent
                          + " in "
                          + listeners[i + 1]
                          + " an error is thrown.",
                          e);
//#endif 


//#if -168531317 
e.printStackTrace();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -1451805791 
public synchronized void setTarget(Object o)
    { 

//#if -472230982 
if(isInTargetTransaction())//1
{ 

//#if -634869521 
return;
//#endif 

} 

//#endif 


//#if -1846619504 
if((targets.size() == 0 && o == null)
                || (targets.size() == 1 && targets.get(0).equals(o)))//1
{ 

//#if -410902222 
return;
//#endif 

} 

//#endif 


//#if -528578799 
startTargetTransaction();
//#endif 


//#if 1794284075 
Object[] oldTargets = targets.toArray();
//#endif 


//#if -1677248846 
umlListener.removeAllListeners(targets);
//#endif 


//#if -618422473 
targets.clear();
//#endif 


//#if -131214515 
if(o != null)//1
{ 

//#if 269607025 
Object newTarget;
//#endif 


//#if 1307208611 
if(o instanceof Diagram)//1
{ 

//#if -686333519 
newTarget = o;
//#endif 

} 
else
{ 

//#if -1976237033 
newTarget = getOwner(o);
//#endif 

} 

//#endif 


//#if -1437371512 
targets.add(newTarget);
//#endif 


//#if -591369214 
umlListener.addListener(newTarget);
//#endif 

} 

//#endif 


//#if 1735470097 
internalOnSetTarget(TargetEvent.TARGET_SET, oldTargets);
//#endif 


//#if 505865610 
endTargetTransaction();
//#endif 

} 

//#endif 


//#if 2055853846 
private Fig determineFigTarget(Object target)
    { 

//#if 605084466 
if(!(target instanceof Fig))//1
{ 

//#if 829636140 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 1648763587 
Collection col = p.findFigsForMember(target);
//#endif 


//#if -1101852632 
if(col == null || col.isEmpty())//1
{ 

//#if 725736531 
target = null;
//#endif 

} 
else
{ 

//#if -984863619 
target = col.iterator().next();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1596556250 
return target instanceof Fig ? (Fig) target : null;
//#endif 

} 

//#endif 


//#if -1447006768 
public synchronized void addTarget(Object target)
    { 

//#if -851349193 
if(target instanceof TargetListener)//1
{ 

//#if 1294773285 
LOG.warn("addTarget method received a TargetListener, "
                     + "perhaps addTargetListener was intended! - " + target);
//#endif 

} 

//#endif 


//#if -652827622 
if(isInTargetTransaction())//1
{ 

//#if 677452197 
return;
//#endif 

} 

//#endif 


//#if -859778171 
Object newTarget = getOwner(target);
//#endif 


//#if -2038655299 
if(target == null
                || targets.contains(target)
                || targets.contains(newTarget))//1
{ 

//#if -56206395 
return;
//#endif 

} 

//#endif 


//#if -534152527 
startTargetTransaction();
//#endif 


//#if -1397940789 
Object[] oldTargets = targets.toArray();
//#endif 


//#if 1859355158 
targets.add(0, newTarget);
//#endif 


//#if 1999404748 
umlListener.addListener(newTarget);
//#endif 


//#if 2142169427 
internalOnSetTarget(TargetEvent.TARGET_ADDED, oldTargets);
//#endif 


//#if -1791344342 
endTargetTransaction();
//#endif 

} 

//#endif 


//#if -448866299 
private void fireTargetAdded(TargetEvent targetEvent)
    { 

//#if -803234917 
Object[] listeners = listenerList.getListenerList();
//#endif 


//#if 201948707 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if 2075827477 
try //1
{ 

//#if 60042873 
if(listeners[i] == TargetListener.class)//1
{ 

//#if -1914263944 
((TargetListener) listeners[i + 1])
                    .targetAdded(targetEvent);
//#endif 

} 

//#endif 

} 

//#if -802137418 
catch (RuntimeException e) //1
{ 

//#if -1577636950 
LOG.error("While calling targetAdded for "
                          + targetEvent
                          + " in "
                          + listeners[i + 1]
                          + " an error is thrown.",
                          e);
//#endif 


//#if -1685796422 
e.printStackTrace();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 1001210364 
private TargetManager()
    { 
} 

//#endif 


//#if -410809677 
public void navigateBackward() throws IllegalStateException
    { 

//#if 1901012652 
historyManager.navigateBackward();
//#endif 


//#if 316753912 
LOG.debug("Navigate backward");
//#endif 

} 

//#endif 


//#if 2023483385 
public Fig getFigTarget()
    { 

//#if 1380964769 
return figTarget;
//#endif 

} 

//#endif 


//#if -716028095 
private void startTargetTransaction()
    { 

//#if -329300651 
inTransaction = true;
//#endif 

} 

//#endif 


//#if -1651727702 
public synchronized List getTargets()
    { 

//#if 353330297 
return Collections.unmodifiableList(targets);
//#endif 

} 

//#endif 


//#if -189284046 
public synchronized Object getSingleTarget()
    { 

//#if -1585181337 
return targets.size() == 1 ? targets.get(0) : null;
//#endif 

} 

//#endif 


//#if 85250191 
public void addTargetListener(TargetListener listener)
    { 

//#if 751170706 
listenerList.add(TargetListener.class, listener);
//#endif 

} 

//#endif 


//#if 1690996651 
public void cleanHistory()
    { 

//#if 807691552 
historyManager.clean();
//#endif 

} 

//#endif 


//#if -1906385307 
private void fireTargetRemoved(TargetEvent targetEvent)
    { 

//#if 705446526 
Object[] listeners = listenerList.getListenerList();
//#endif 


//#if 663795718 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if -2089136024 
try //1
{ 

//#if -1607955459 
if(listeners[i] == TargetListener.class)//1
{ 

//#if -434015966 
((TargetListener) listeners[i + 1])
                    .targetRemoved(targetEvent);
//#endif 

} 

//#endif 

} 

//#if -1514550433 
catch (RuntimeException e) //1
{ 

//#if -153044827 
LOG.warn("While calling targetRemoved for "
                         + targetEvent
                         + " in "
                         + listeners[i + 1]
                         + " an error is thrown.",
                         e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 1708003692 
private Collection getOwnerAndAllFigs(Object o)
    { 

//#if -1944685710 
Collection c = new ArrayList();
//#endif 


//#if 726166742 
c.add(o);
//#endif 


//#if 586274339 
if(o instanceof Fig)//1
{ 

//#if -184769736 
if(((Fig) o).getOwner() != null)//1
{ 

//#if 1732158918 
o = ((Fig) o).getOwner();
//#endif 


//#if -1010524443 
c.add(o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1590918383 
if(!(o instanceof Fig))//1
{ 

//#if 791067730 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -2019758748 
Collection col = p.findAllPresentationsFor(o);
//#endif 


//#if 944325705 
if(col != null && !col.isEmpty())//1
{ 

//#if -1471863171 
c.addAll(col);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -385518079 
return c;
//#endif 

} 

//#endif 


//#if -1446604164 
private final class HistoryManager implements 
//#if -612739828 
TargetListener
//#endif 

  { 

//#if 2080488552 
private static final int MAX_SIZE = 100;
//#endif 


//#if -1285828096 
private List history = new ArrayList();
//#endif 


//#if -554639621 
private boolean navigateBackward;
//#endif 


//#if 1927335665 
private int currentTarget = -1;
//#endif 


//#if -387051993 
private Remover umlListener = new HistoryRemover();
//#endif 


//#if -244493791 
private void putInHistory(Object target)
        { 

//#if 192834476 
if(currentTarget > -1)//1
{ 

//#if 692597852 
Object theModelTarget =
                    target instanceof Fig ? ((Fig) target).getOwner() : target;
//#endif 


//#if -1980383608 
Object oldTarget =
                    ((WeakReference) history.get(currentTarget)).get();
//#endif 


//#if 1614837415 
oldTarget =
                    oldTarget instanceof Fig
                    ? ((Fig) oldTarget).getOwner()
                    : oldTarget;
//#endif 


//#if -1320703144 
if(oldTarget == theModelTarget)//1
{ 

//#if -1173851647 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 417531869 
if(target != null && !navigateBackward)//1
{ 

//#if -114496543 
if(currentTarget + 1 == history.size())//1
{ 

//#if -1957012343 
umlListener.addListener(target);
//#endif 


//#if 1956440035 
history.add(new WeakReference(target));
//#endif 


//#if 94700126 
currentTarget++;
//#endif 


//#if -219057511 
resize();
//#endif 

} 
else
{ 

//#if 542861775 
WeakReference ref =
                        currentTarget > -1
                        ? (WeakReference) history.get(currentTarget)
                        : null;
//#endif 


//#if -716530019 
if(currentTarget == -1 || !ref.get().equals(target))//1
{ 

//#if -1492579945 
int size = history.size();
//#endif 


//#if 167786686 
for (int i = currentTarget + 1; i < size; i++) //1
{ 

//#if 296893535 
umlListener.removeListener(
                                history.remove(currentTarget + 1));
//#endif 

} 

//#endif 


//#if -1793663439 
history.add(new WeakReference(target));
//#endif 


//#if 853976407 
umlListener.addListener(target);
//#endif 


//#if -1740069076 
currentTarget++;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1676876698 
private void clean()
        { 

//#if 1993326462 
umlListener.removeAllListeners(history);
//#endif 


//#if -635333310 
history = new ArrayList();
//#endif 


//#if 1315233420 
currentTarget = -1;
//#endif 

} 

//#endif 


//#if 649563674 
private boolean navigateForwardPossible()
        { 

//#if 1038033285 
return currentTarget < history.size() - 1;
//#endif 

} 

//#endif 


//#if -2023913264 
private void removeHistoryTarget(Object o)
        { 

//#if 1415583738 
if(o instanceof Diagram)//1
{ 

//#if 1726122436 
Iterator it = ((Diagram) o).getEdges().iterator();
//#endif 


//#if -1187520299 
while (it.hasNext()) //1
{ 

//#if 1161960113 
removeHistoryTarget(it.next());
//#endif 

} 

//#endif 


//#if 20185041 
it = ((Diagram) o).getNodes().iterator();
//#endif 


//#if 228466108 
while (it.hasNext()) //2
{ 

//#if -1540267922 
removeHistoryTarget(it.next());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1574887745 
ListIterator it = history.listIterator();
//#endif 


//#if 957847643 
while (it.hasNext()) //1
{ 

//#if 1838982107 
WeakReference ref = (WeakReference) it.next();
//#endif 


//#if 1166847102 
Object historyObject = ref.get();
//#endif 


//#if -870478089 
if(Model.getFacade().isAModelElement(o))//1
{ 

//#if 2124020164 
historyObject =
                        historyObject instanceof Fig
                        ? ((Fig) historyObject).getOwner()
                        : historyObject;
//#endif 

} 

//#endif 


//#if 1738645889 
if(o == historyObject)//1
{ 

//#if 97794312 
if(history.indexOf(ref) <= currentTarget)//1
{ 

//#if 1778574547 
currentTarget--;
//#endif 

} 

//#endif 


//#if 945848964 
it.remove();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1952743600 
public void targetRemoved(TargetEvent e)
        { 
} 

//#endif 


//#if 826099222 
private boolean navigateBackPossible()
        { 

//#if -1991523491 
return currentTarget > 0;
//#endif 

} 

//#endif 


//#if 1255909042 
public void targetSet(TargetEvent e)
        { 

//#if -415968962 
Object[] newTargets = e.getNewTargets();
//#endif 


//#if 417030880 
for (int i = newTargets.length - 1; i >= 0; i--) //1
{ 

//#if -1155551061 
putInHistory(newTargets[i]);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -5033968 
public void targetAdded(TargetEvent e)
        { 

//#if 1275101976 
Object[] addedTargets = e.getAddedTargets();
//#endif 


//#if 1136742490 
for (int i = addedTargets.length - 1; i >= 0; i--) //1
{ 

//#if -1707102373 
putInHistory(addedTargets[i]);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1024686902 
private HistoryManager()
        { 

//#if 781093741 
addTargetListener(this);
//#endif 

} 

//#endif 


//#if -224919899 
private void navigateForward()
        { 

//#if -725186297 
if(currentTarget >= history.size() - 1)//1
{ 

//#if 2093516680 
throw new IllegalStateException(
                    "NavigateForward is not allowed "
                    + "since the targetpointer is pointing at "
                    + "the upper boundary "
                    + "of the history");
//#endif 

} 

//#endif 


//#if -1530976499 
setTarget(((WeakReference) history.get(++currentTarget)).get());
//#endif 

} 

//#endif 


//#if -693024731 
private void resize()
        { 

//#if 1354987195 
int size = history.size();
//#endif 


//#if 1603021837 
if(size > MAX_SIZE)//1
{ 

//#if 133556260 
int oversize = size - MAX_SIZE;
//#endif 


//#if -317431867 
int halfsize = size / 2;
//#endif 


//#if 1069320072 
if(currentTarget > halfsize && oversize < halfsize)//1
{ 

//#if -1966692223 
for (int i = 0; i < oversize; i++) //1
{ 

//#if -1911087950 
umlListener.removeListener(
                            history.remove(0));
//#endif 

} 

//#endif 


//#if 2085063864 
currentTarget -= oversize;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 120185829 
private void navigateBackward()
        { 

//#if -735408800 
if(currentTarget == 0)//1
{ 

//#if 1808354374 
throw new IllegalStateException(
                    "NavigateBackward is not allowed "
                    + "since the targetpointer is pointing at "
                    + "the lower boundary "
                    + "of the history");
//#endif 

} 

//#endif 


//#if 958172957 
navigateBackward = true;
//#endif 


//#if -425644424 
if(targets.size() == 0)//1
{ 

//#if 686085285 
setTarget(((WeakReference) history.get(currentTarget)).get());
//#endif 

} 
else
{ 

//#if -168770144 
setTarget(((WeakReference) history.get(--currentTarget)).get());
//#endif 

} 

//#endif 


//#if -778170680 
navigateBackward = false;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -811848858 
private class TargetRemover extends 
//#if -1027091036 
Remover
//#endif 

  { 

//#if 180094205 
protected void remove(Object obj)
        { 

//#if -2094882940 
removeTarget(obj);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -353754855 
private abstract class Remover implements 
//#if 580963615 
PropertyChangeListener
//#endif 

, 
//#if 587736997 
NotificationListener
//#endif 

  { 

//#if 1129347344 
public void handleNotification(Notification notification,
                                       Object handback)
        { 

//#if -395775938 
if("remove".equals(notification.getType()))//1
{ 

//#if -964605669 
remove(notification.getSource());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1079251367 
private void removeAllListeners(Collection c)
        { 

//#if 2078775599 
Iterator i = c.iterator();
//#endif 


//#if 1821995274 
while (i.hasNext()) //1
{ 

//#if 814162228 
removeListener(i.next());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -181800488 
private void removeListener(Object o)
        { 

//#if -1310847204 
if(Model.getFacade().isAModelElement(o))//1
{ 

//#if 174085735 
Model.getPump().removeModelEventListener(this, o, "remove");
//#endif 

} 
else

//#if 623970690 
if(o instanceof Diagram)//1
{ 

//#if 280830160 
((Diagram) o).removePropertyChangeListener(this);
//#endif 

} 
else

//#if -1181909399 
if(o instanceof NotificationEmitter)//1
{ 

//#if -1748756814 
try //1
{ 

//#if -162544156 
((NotificationEmitter) o).removeNotificationListener(this);
//#endif 

} 

//#if 2044245928 
catch (ListenerNotFoundException e) //1
{ 

//#if 1983671898 
LOG.error("Notification Listener for "
                              + "CommentEdge not found", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if 985426295 
protected abstract void remove(Object obj);
//#endif 


//#if 411959035 
public void propertyChange(PropertyChangeEvent evt)
        { 

//#if 1649609148 
if("remove".equals(evt.getPropertyName()))//1
{ 

//#if 1307638552 
remove(evt.getSource());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -887191513 
protected Remover()
        { 

//#if 832525896 
ProjectManager.getManager().addPropertyChangeListener(this);
//#endif 

} 

//#endif 


//#if -1685179363 
private void addListener(Object o)
        { 

//#if 270218207 
if(Model.getFacade().isAModelElement(o))//1
{ 

//#if 235935362 
Model.getPump().addModelEventListener(this, o, "remove");
//#endif 

} 
else

//#if 1810315840 
if(o instanceof Diagram)//1
{ 

//#if 1243600073 
((Diagram) o).addPropertyChangeListener(this);
//#endif 

} 
else

//#if -1175979336 
if(o instanceof NotificationEmitter)//1
{ 

//#if -1398775879 
((NotificationEmitter) o).addNotificationListener(
                    this, null, o);
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#if -743320431 
private class HistoryRemover extends 
//#if -2104169500 
Remover
//#endif 

  { 

//#if -151394627 
protected void remove(Object obj)
        { 

//#if 1321495898 
historyManager.removeHistoryTarget(obj);
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

