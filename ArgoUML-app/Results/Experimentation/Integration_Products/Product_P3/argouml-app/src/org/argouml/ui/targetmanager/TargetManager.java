package org.argouml.ui.targetmanager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.management.ListenerNotFoundException;
import javax.management.Notification;
import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import javax.swing.event.EventListenerList;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.tigris.gef.base.Diagram;
import org.tigris.gef.presentation.Fig;
public final class TargetManager  { 
private static TargetManager instance = new TargetManager();
private List targets = new ArrayList();
private Object modelTarget;
private Fig figTarget;
private EventListenerList listenerList = new EventListenerList();
private HistoryManager historyManager = new HistoryManager();
private Remover umlListener = new TargetRemover();
private boolean inTransaction = false;
private void internalOnSetTarget(String eventName, Object[] oldTargets)
    { 
TargetEvent event =
            new TargetEvent(this, eventName, oldTargets, targets.toArray());
if(targets.size() > 0)//1
{ 
figTarget = determineFigTarget(targets.get(0));
modelTarget = determineModelTarget(targets.get(0));
} 
else
{ 
figTarget = null;
modelTarget = null;
} 
if(TargetEvent.TARGET_SET.equals(eventName))//1
{ 
fireTargetSet(event);
return;
} 
else
if(TargetEvent.TARGET_ADDED.equals(eventName))//1
{ 
fireTargetAdded(event);
return;
} 
else
if(TargetEvent.TARGET_REMOVED.equals(eventName))//1
{ 
fireTargetRemoved(event);
return;
} 
} 
public synchronized Object getTarget()
    { 
return targets.size() > 0 ? targets.get(0) : null;
} 
public void navigateForward() throws IllegalStateException
    { 
historyManager.navigateForward();
} 
public synchronized void setTargets(Collection targetsCollection)
    { 
Iterator ntarg;
if(isInTargetTransaction())//1
{ 
return;
} 
Collection targetsList = new ArrayList();
if(targetsCollection != null)//1
{ 
targetsList.addAll(targetsCollection);
} 
List modifiedList = new ArrayList();
Iterator it = targetsList.iterator();
while (it.hasNext()) //1
{ 
Object o = it.next();
o = getOwner(o);
if((o != null) && !modifiedList.contains(o))//1
{ 
modifiedList.add(o);
} 
} 
targetsList = modifiedList;
Object[] oldTargets = null;
if(targetsList.size() == targets.size())//1
{ 
boolean first = true;
ntarg = targetsList.iterator();
while (ntarg.hasNext()) //1
{ 
Object targ = ntarg.next();
if(targ == null)//1
{ 
continue;
} 
if(!targets.contains(targ)
                        || (first && targ != getTarget()))//1
{ 
oldTargets = targets.toArray();
break;

} 
first = false;
} 
} 
else
{ 
oldTargets = targets.toArray();
} 
if(oldTargets == null)//1
{ 
return;
} 
startTargetTransaction();
umlListener.removeAllListeners(targets);
targets.clear();
ntarg = targetsList.iterator();
while (ntarg.hasNext()) //1
{ 
Object targ = ntarg.next();
if(targets.contains(targ))//1
{ 
continue;
} 
targets.add(targ);
umlListener.addListener(targ);
} 
internalOnSetTarget(TargetEvent.TARGET_SET, oldTargets);
endTargetTransaction();
} 
public synchronized Collection getModelTargets()
    { 
ArrayList t = new ArrayList();
Iterator iter = getTargets().iterator();
while (iter.hasNext()) //1
{ 
t.add(determineModelTarget(iter.next()));
} 
return t;
} 
public boolean navigateBackPossible()
    { 
return historyManager.navigateBackPossible();
} 
public Object getModelTarget()
    { 
return modelTarget;
} 
private Object determineModelTarget(Object target)
    { 
if(target instanceof Fig)//1
{ 
Object owner = ((Fig) target).getOwner();
if(Model.getFacade().isAUMLElement(owner))//1
{ 
target = owner;
} 
} 
return target instanceof Diagram
               || Model.getFacade().isAUMLElement(target) ? target : null;
} 
private void endTargetTransaction()
    { 
inTransaction = false;
} 
public void removeHistoryElement(Object o)
    { 
historyManager.removeHistoryTarget(o);
} 
public synchronized Object getSingleModelTarget()
    { 
int i = 0;
Iterator iter = getTargets().iterator();
while (iter.hasNext()) //1
{ 
if(determineModelTarget(iter.next()) != null)//1
{ 
i++;
} 
if(i > 1)//1
{ 
break;

} 
} 
if(i == 1)//1
{ 
return modelTarget;
} 
return null;
} 
public void removeTargetListener(TargetListener listener)
    { 
listenerList.remove(TargetListener.class, listener);
} 
public static TargetManager getInstance()
    { 
return instance;
} 
public synchronized void removeTarget(Object target)
    { 
if(isInTargetTransaction())//1
{ 
return;
} 
if(target == null)//1
{ 
return;
} 
startTargetTransaction();
Object[] oldTargets = targets.toArray();
Collection c = getOwnerAndAllFigs(target);
targets.removeAll(c);
umlListener.removeAllListeners(c);
if(targets.size() != oldTargets.length)//1
{ 
internalOnSetTarget(TargetEvent.TARGET_REMOVED, oldTargets);
} 
endTargetTransaction();
} 
private boolean isInTargetTransaction()
    { 
return inTransaction;
} 
public Object getOwner(Object o)
    { 
if(o instanceof Fig)//1
{ 
if(((Fig) o).getOwner() != null)//1
{ 
o = ((Fig) o).getOwner();
} 
} 
return o;
} 
public boolean navigateForwardPossible()
    { 
return historyManager.navigateForwardPossible();
} 
private void fireTargetSet(TargetEvent targetEvent)
    { 
Object[] listeners = listenerList.getListenerList();
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 
try//1
{ 
if(listeners[i] == TargetListener.class)//1
{ 
((TargetListener) listeners[i + 1]).targetSet(targetEvent);
} 
} 
catch (RuntimeException e) //1
{ 
e.printStackTrace();
} 
} 
} 
public synchronized void setTarget(Object o)
    { 
if(isInTargetTransaction())//1
{ 
return;
} 
if((targets.size() == 0 && o == null)
                || (targets.size() == 1 && targets.get(0).equals(o)))//1
{ 
return;
} 
startTargetTransaction();
Object[] oldTargets = targets.toArray();
umlListener.removeAllListeners(targets);
targets.clear();
if(o != null)//1
{ 
Object newTarget;
if(o instanceof Diagram)//1
{ 
newTarget = o;
} 
else
{ 
newTarget = getOwner(o);
} 
targets.add(newTarget);
umlListener.addListener(newTarget);
} 
internalOnSetTarget(TargetEvent.TARGET_SET, oldTargets);
endTargetTransaction();
} 
private Fig determineFigTarget(Object target)
    { 
if(!(target instanceof Fig))//1
{ 
Project p = ProjectManager.getManager().getCurrentProject();
Collection col = p.findFigsForMember(target);
if(col == null || col.isEmpty())//1
{ 
target = null;
} 
else
{ 
target = col.iterator().next();
} 
} 
return target instanceof Fig ? (Fig) target : null;
} 
public synchronized void addTarget(Object target)
    { 
if(isInTargetTransaction())//1
{ 
return;
} 
Object newTarget = getOwner(target);
if(target == null
                || targets.contains(target)
                || targets.contains(newTarget))//1
{ 
return;
} 
startTargetTransaction();
Object[] oldTargets = targets.toArray();
targets.add(0, newTarget);
umlListener.addListener(newTarget);
internalOnSetTarget(TargetEvent.TARGET_ADDED, oldTargets);
endTargetTransaction();
} 
private void fireTargetAdded(TargetEvent targetEvent)
    { 
Object[] listeners = listenerList.getListenerList();
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 
try//1
{ 
if(listeners[i] == TargetListener.class)//1
{ 
((TargetListener) listeners[i + 1])
                    .targetAdded(targetEvent);
} 
} 
catch (RuntimeException e) //1
{ 
e.printStackTrace();
} 
} 
} 
private TargetManager()
    { 
} 
public void navigateBackward() throws IllegalStateException
    { 
historyManager.navigateBackward();
} 
public Fig getFigTarget()
    { 
return figTarget;
} 
private void startTargetTransaction()
    { 
inTransaction = true;
} 
public synchronized List getTargets()
    { 
return Collections.unmodifiableList(targets);
} 
public synchronized Object getSingleTarget()
    { 
return targets.size() == 1 ? targets.get(0) : null;
} 
public void addTargetListener(TargetListener listener)
    { 
listenerList.add(TargetListener.class, listener);
} 
public void cleanHistory()
    { 
historyManager.clean();
} 
private void fireTargetRemoved(TargetEvent targetEvent)
    { 
Object[] listeners = listenerList.getListenerList();
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 
try//1
{ 
if(listeners[i] == TargetListener.class)//1
{ 
((TargetListener) listeners[i + 1])
                    .targetRemoved(targetEvent);
} 
} 
catch (RuntimeException e) //1
{ 
} 
} 
} 
private Collection getOwnerAndAllFigs(Object o)
    { 
Collection c = new ArrayList();
c.add(o);
if(o instanceof Fig)//1
{ 
if(((Fig) o).getOwner() != null)//1
{ 
o = ((Fig) o).getOwner();
c.add(o);
} 
} 
if(!(o instanceof Fig))//1
{ 
Project p = ProjectManager.getManager().getCurrentProject();
Collection col = p.findAllPresentationsFor(o);
if(col != null && !col.isEmpty())//1
{ 
c.addAll(col);
} 
} 
return c;
} 
private final class HistoryManager implements TargetListener
  { 
private static final int MAX_SIZE = 100;
private List history = new ArrayList();
private boolean navigateBackward;
private int currentTarget = -1;
private Remover umlListener = new HistoryRemover();
private void putInHistory(Object target)
        { 
if(currentTarget > -1)//1
{ 
Object theModelTarget =
                    target instanceof Fig ? ((Fig) target).getOwner() : target;
Object oldTarget =
                    ((WeakReference) history.get(currentTarget)).get();
oldTarget =
                    oldTarget instanceof Fig
                    ? ((Fig) oldTarget).getOwner()
                    : oldTarget;
if(oldTarget == theModelTarget)//1
{ 
return;
} 
} 
if(target != null && !navigateBackward)//1
{ 
if(currentTarget + 1 == history.size())//1
{ 
umlListener.addListener(target);
history.add(new WeakReference(target));
currentTarget++;
resize();
} 
else
{ 
WeakReference ref =
                        currentTarget > -1
                        ? (WeakReference) history.get(currentTarget)
                        : null;
if(currentTarget == -1 || !ref.get().equals(target))//1
{ 
int size = history.size();
for (int i = currentTarget + 1; i < size; i++) //1
{ 
umlListener.removeListener(
                                history.remove(currentTarget + 1));
} 
history.add(new WeakReference(target));
umlListener.addListener(target);
currentTarget++;
} 
} 
} 
} 
private void clean()
        { 
umlListener.removeAllListeners(history);
history = new ArrayList();
currentTarget = -1;
} 
private boolean navigateForwardPossible()
        { 
return currentTarget < history.size() - 1;
} 
private void removeHistoryTarget(Object o)
        { 
if(o instanceof Diagram)//1
{ 
Iterator it = ((Diagram) o).getEdges().iterator();
while (it.hasNext()) //1
{ 
removeHistoryTarget(it.next());
} 
it = ((Diagram) o).getNodes().iterator();
while (it.hasNext()) //2
{ 
removeHistoryTarget(it.next());
} 
} 
ListIterator it = history.listIterator();
while (it.hasNext()) //1
{ 
WeakReference ref = (WeakReference) it.next();
Object historyObject = ref.get();
if(Model.getFacade().isAModelElement(o))//1
{ 
historyObject =
                        historyObject instanceof Fig
                        ? ((Fig) historyObject).getOwner()
                        : historyObject;
} 
if(o == historyObject)//1
{ 
if(history.indexOf(ref) <= currentTarget)//1
{ 
currentTarget--;
} 
it.remove();
} 
} 
} 
public void targetRemoved(TargetEvent e)
        { 
} 
private boolean navigateBackPossible()
        { 
return currentTarget > 0;
} 
public void targetSet(TargetEvent e)
        { 
Object[] newTargets = e.getNewTargets();
for (int i = newTargets.length - 1; i >= 0; i--) //1
{ 
putInHistory(newTargets[i]);
} 
} 
public void targetAdded(TargetEvent e)
        { 
Object[] addedTargets = e.getAddedTargets();
for (int i = addedTargets.length - 1; i >= 0; i--) //1
{ 
putInHistory(addedTargets[i]);
} 
} 
private HistoryManager()
        { 
addTargetListener(this);
} 
private void navigateForward()
        { 
if(currentTarget >= history.size() - 1)//1
{ 
throw new IllegalStateException(
                    "NavigateForward is not allowed "
                    + "since the targetpointer is pointing at "
                    + "the upper boundary "
                    + "of the history");
} 
setTarget(((WeakReference) history.get(++currentTarget)).get());
} 
private void resize()
        { 
int size = history.size();
if(size > MAX_SIZE)//1
{ 
int oversize = size - MAX_SIZE;
int halfsize = size / 2;
if(currentTarget > halfsize && oversize < halfsize)//1
{ 
for (int i = 0; i < oversize; i++) //1
{ 
umlListener.removeListener(
                            history.remove(0));
} 
currentTarget -= oversize;
} 
} 
} 
private void navigateBackward()
        { 
if(currentTarget == 0)//1
{ 
throw new IllegalStateException(
                    "NavigateBackward is not allowed "
                    + "since the targetpointer is pointing at "
                    + "the lower boundary "
                    + "of the history");
} 
navigateBackward = true;
if(targets.size() == 0)//1
{ 
setTarget(((WeakReference) history.get(currentTarget)).get());
} 
else
{ 
setTarget(((WeakReference) history.get(--currentTarget)).get());
} 
navigateBackward = false;
} 

 } 
private class TargetRemover extends Remover
  { 
protected void remove(Object obj)
        { 
removeTarget(obj);
} 

 } 
private abstract class Remover implements PropertyChangeListener
,NotificationListener
  { 
public void handleNotification(Notification notification,
                                       Object handback)
        { 
if("remove".equals(notification.getType()))//1
{ 
remove(notification.getSource());
} 
} 
private void removeAllListeners(Collection c)
        { 
Iterator i = c.iterator();
while (i.hasNext()) //1
{ 
removeListener(i.next());
} 
} 
private void removeListener(Object o)
        { 
if(Model.getFacade().isAModelElement(o))//1
{ 
Model.getPump().removeModelEventListener(this, o, "remove");
} 
else
if(o instanceof Diagram)//1
{ 
((Diagram) o).removePropertyChangeListener(this);
} 
else
if(o instanceof NotificationEmitter)//1
{ 
try//1
{ 
((NotificationEmitter) o).removeNotificationListener(this);
} 
catch (ListenerNotFoundException e) //1
{ 
} 
} 
} 
protected abstract void remove(Object obj);public void propertyChange(PropertyChangeEvent evt)
        { 
if("remove".equals(evt.getPropertyName()))//1
{ 
remove(evt.getSource());
} 
} 
protected Remover()
        { 
ProjectManager.getManager().addPropertyChangeListener(this);
} 
private void addListener(Object o)
        { 
if(Model.getFacade().isAModelElement(o))//1
{ 
Model.getPump().addModelEventListener(this, o, "remove");
} 
else
if(o instanceof Diagram)//1
{ 
((Diagram) o).addPropertyChangeListener(this);
} 
else
if(o instanceof NotificationEmitter)//1
{ 
((NotificationEmitter) o).addNotificationListener(
                    this, null, o);
} 
} 

 } 
private class HistoryRemover extends Remover
  { 
protected void remove(Object obj)
        { 
historyManager.removeHistoryTarget(obj);
} 

 } 

 } 
