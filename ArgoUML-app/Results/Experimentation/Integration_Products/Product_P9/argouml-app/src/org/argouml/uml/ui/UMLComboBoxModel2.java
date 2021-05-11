package org.argouml.uml.ui;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import org.apache.log4j.Logger;
import org.argouml.model.AddAssociationEvent;
import org.argouml.model.AssociationChangeEvent;
import org.argouml.model.AttributeChangeEvent;
import org.argouml.model.DeleteInstanceEvent;
import org.argouml.model.InvalidElementException;
import org.argouml.model.Model;
import org.argouml.model.RemoveAssociationEvent;
import org.argouml.model.UmlChangeEvent;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.ui.targetmanager.TargetListener;
import org.argouml.uml.diagram.ArgoDiagram;
import org.tigris.gef.presentation.Fig;
public abstract class UMLComboBoxModel2 extends AbstractListModel
 implements PropertyChangeListener
,ComboBoxModel
,TargetListener
,PopupMenuListener
  { 
private static final Logger LOG = Logger.getLogger(UMLComboBoxModel2.class);
protected static final String CLEARED = "<none>";
private Object comboBoxTarget = null;
private List objects = new LinkedList();
private Object selectedObject = null;
private boolean isClearable = false;
private String propertySetName;
private boolean fireListEvents = true;
protected boolean buildingModel = false;
private boolean processingWillBecomeVisible = false;
private boolean modelValid;
protected void addOtherModelEventListeners(Object newTarget)
    { 
} 
private Object internal2external(Object o)
    { 
return isClearable && CLEARED.equals(o) ? null : o;
} 
protected boolean isClearable()
    { 
return isClearable;
} 
public Object getElementAt(int index)
    { 
if(index >= 0 && index < objects.size())//1
{ 
return objects.get(index);
} 
return null;
} 
protected void removeOtherModelEventListeners(Object oldTarget)
    { 
} 
protected void setModelInvalid()
    { 
assert isLazy();
modelValid = false;
} 
protected String getName(Object obj)
    { 
try//1
{ 
Object n = Model.getFacade().getName(obj);
String name = (n != null ? (String) n : "");
return name;
} 
catch (InvalidElementException e) //1
{ 
return "";
} 
} 
public void removeAllElements()
    { 
int startIndex = 0;
int endIndex = Math.max(0, objects.size() - 1);
objects.clear();
selectedObject = null;
fireIntervalRemoved(this, startIndex, endIndex);
} 
public int getSize()
    { 
return objects.size();
} 
protected abstract boolean isValidElement(Object element);public final void propertyChange(final PropertyChangeEvent pve)
    { 
if(pve instanceof UmlChangeEvent)//1
{ 
final UmlChangeEvent event = (UmlChangeEvent) pve;
Runnable doWorkRunnable = new Runnable() {
                public void run() {
                    try {
                        modelChanged(event);
                    } catch (InvalidElementException e) {


                        if (LOG.isDebugEnabled()) {
                            LOG.debug("event = "
                                      + event.getClass().getName());
                            LOG.debug("source = " + event.getSource());
                            LOG.debug("old = " + event.getOldValue());
                            LOG.debug("name = " + event.getPropertyName());
                            LOG.debug("updateLayout method accessed "
                                      + "deleted element ", e);
                        }

                    }
                }
            };
SwingUtilities.invokeLater(doWorkRunnable);
} 
} 
public void popupMenuWillBecomeVisible(PopupMenuEvent ev)
    { 
if(isLazy() && !modelValid && !processingWillBecomeVisible)//1
{ 
buildModelListTimed();
modelValid = true;
JComboBox list = (JComboBox) ev.getSource();
processingWillBecomeVisible = true;
try//1
{ 
list.getUI().setPopupVisible( list, true );
} 
finally { 
processingWillBecomeVisible = false;
} 
} 
} 
protected void addAll(Collection col)
    { 
Object selected = getSelectedItem();
fireListEvents = false;
int oldSize = objects.size();
for (Object o : col) //1
{ 
addElement(o);
} 
setSelectedItem(external2internal(selected));
fireListEvents = true;
if(objects.size() != oldSize)//1
{ 
fireIntervalAdded(this, oldSize == 0 ? 0 : oldSize - 1,
                              objects.size() - 1);
} 
} 
protected void buildMinimalModelList()
    { 
buildModelListTimed();
} 
protected String getPropertySetName()
    { 
return propertySetName;
} 
@Override
    protected void fireIntervalRemoved(Object source, int index0, int index1)
    { 
if(fireListEvents && !buildingModel)//1
{ 
super.fireIntervalRemoved(source, index0, index1);
} 
} 
protected Object getTarget()
    { 
return comboBoxTarget;
} 
public void removeElement(Object o)
    { 
int index = objects.indexOf(o);
if(getElementAt(index) == selectedObject)//1
{ 
if(!isClearable)//1
{ 
if(index == 0)//1
{ 
setSelectedItem(getSize() == 1
                                    ? null
                                    : getElementAt(index + 1));
} 
else
{ 
setSelectedItem(getElementAt(index - 1));
} 
} 
} 
if(index >= 0)//1
{ 
objects.remove(index);
fireIntervalRemoved(this, index, index);
} 
} 
public void popupMenuWillBecomeInvisible(PopupMenuEvent e)
    { 
} 
public void targetSet(TargetEvent e)
    { 
LOG.debug("targetSet targetevent :  " + e);
setTarget(e.getNewTarget());
} 
public void setSelectedItem(Object o)
    { 
if((selectedObject != null && !selectedObject.equals(o))
                || (selectedObject == null && o != null))//1
{ 
selectedObject = o;
fireContentsChanged(this, -1, -1);
} 
} 
protected void setFireListEvents(boolean events)
    { 
this.fireListEvents = events;
} 
protected boolean isValidEvent(PropertyChangeEvent e)
    { 
boolean valid = false;
if(!(getChangedElement(e) instanceof Collection))//1
{ 
if((e.getNewValue() == null && e.getOldValue() != null)
                    // Don't try to test this if we're removing the element
                    || isValidElement(getChangedElement(e)))//1
{ 
valid = true;
} 
} 
else
{ 
Collection col = (Collection) getChangedElement(e);
if(!col.isEmpty())//1
{ 
valid = true;
for (Object o : col) //1
{ 
if(!isValidElement(o))//1
{ 
valid = false;
break;

} 
} 
} 
else
{ 
if(e.getOldValue() instanceof Collection
                        && !((Collection) e.getOldValue()).isEmpty())//1
{ 
valid = true;
} 
} 
} 
return valid;
} 
private void buildModelListTimed()
    { 
long startTime = System.currentTimeMillis();
try//1
{ 
buildModelList();
long endTime = System.currentTimeMillis();
LOG.debug("buildModelList took " + (endTime - startTime)
                      + " msec. for " + this.getClass().getName());
} 
catch (InvalidElementException e) //1
{ 
LOG.warn("buildModelList attempted to operate on "
                     + "deleted element");
} 
} 
public void popupMenuCanceled(PopupMenuEvent e)
    { 
} 
protected boolean isLazy()
    { 
return false;
} 
public void modelChanged(UmlChangeEvent evt)
    { 
buildingModel = true;
if(evt instanceof AttributeChangeEvent)//1
{ 
if(evt.getPropertyName().equals(propertySetName))//1
{ 
if(evt.getSource() == getTarget()
                        && (isClearable || getChangedElement(evt) != null))//1
{ 
Object elem = getChangedElement(evt);
if(elem != null && !contains(elem))//1
{ 
addElement(elem);
} 
buildingModel = false;
setSelectedItem(elem);
} 
} 
} 
else
if(evt instanceof DeleteInstanceEvent)//1
{ 
if(contains(getChangedElement(evt)))//1
{ 
Object o = getChangedElement(evt);
removeElement(o);
} 
} 
else
if(evt instanceof AddAssociationEvent)//1
{ 
if(getTarget() != null && isValidEvent(evt))//1
{ 
if(evt.getPropertyName().equals(propertySetName)
                        && (evt.getSource() == getTarget()))//1
{ 
Object elem = evt.getNewValue();
setSelectedItem(elem);
} 
else
{ 
Object o = getChangedElement(evt);
addElement(o);
} 
} 
} 
else
if(evt instanceof RemoveAssociationEvent && isValidEvent(evt))//1
{ 
if(evt.getPropertyName().equals(propertySetName)
                    && (evt.getSource() == getTarget()))//1
{ 
if(evt.getOldValue() == internal2external(getSelectedItem()))//1
{ 
setSelectedItem(external2internal(evt.getNewValue()));
} 
} 
else
{ 
Object o = getChangedElement(evt);
if(contains(o))//1
{ 
removeElement(o);
} 
} 
} 
else
if(evt.getSource() instanceof ArgoDiagram
                   && evt.getPropertyName().equals(propertySetName))//1
{ 
addElement(evt.getNewValue());
buildingModel = false;
setSelectedItem(evt.getNewValue());
} 
buildingModel = false;
} 
protected abstract void buildModelList();protected abstract Object getSelectedModelElement();@Override
    protected void fireContentsChanged(Object source, int index0, int index1)
    { 
if(fireListEvents && !buildingModel)//1
{ 
super.fireContentsChanged(source, index0, index1);
} 
} 
public UMLComboBoxModel2(String name, boolean clearable)
    { 
super();
if(name == null || name.equals(""))//1
{ 
throw new IllegalArgumentException("one of the arguments is null");
} 
isClearable = clearable;
propertySetName = name;
} 
public Object getSelectedItem()
    { 
return selectedObject;
} 
public void addElement(Object o)
    { 
if(!objects.contains(o))//1
{ 
objects.add(o);
fireIntervalAdded(this, objects.size() - 1, objects.size() - 1);
} 
} 
public void targetRemoved(TargetEvent e)
    { 
LOG.debug("targetRemoved targetevent :  " + e);
Object currentTarget = comboBoxTarget;
Object oldTarget =
            e.getOldTargets().length > 0
            ? e.getOldTargets()[0] : null;
if(oldTarget instanceof Fig)//1
{ 
oldTarget = ((Fig) oldTarget).getOwner();
} 
if(oldTarget == currentTarget)//1
{ 
if(Model.getFacade().isAModelElement(currentTarget))//1
{ 
Model.getPump().removeModelEventListener(this,
                        currentTarget, propertySetName);
} 
comboBoxTarget = e.getNewTarget();
} 
setTarget(e.getNewTarget());
} 
protected void removeAll(Collection col)
    { 
int first = -1;
int last = -1;
fireListEvents = false;
for (Object o : col) //1
{ 
int index = getIndexOf(o);
removeElement(o);
if(first == -1)//1
{ 
first = index;
last = index;
} 
else
{ 
if(index  != last + 1)//1
{ 
fireListEvents = true;
fireIntervalRemoved(this, first, last);
fireListEvents = false;
first = index;
last = index;
} 
else
{ 
last++;
} 
} 
} 
fireListEvents = true;
} 
public boolean contains(Object elem)
    { 
if(objects.contains(elem))//1
{ 
return true;
} 
if(elem instanceof Collection)//1
{ 
for (Object o : (Collection) elem) //1
{ 
if(!objects.contains(o))//1
{ 
return false;
} 
} 
return true;
} 
return false;
} 
protected Object getChangedElement(PropertyChangeEvent e)
    { 
if(e instanceof AssociationChangeEvent)//1
{ 
return ((AssociationChangeEvent) e).getChangedValue();
} 
return e.getNewValue();
} 
protected void setElements(Collection elements)
    { 
if(elements != null)//1
{ 
ArrayList toBeRemoved = new ArrayList();
for (Object o : objects) //1
{ 
if(!elements.contains(o)
                        && !(isClearable
                             // Check against "" is needed for backward
                             // compatibility.  Don't remove without
                             // checking subclasses and warning downstream
                             // developers - tfm - 20081211
                             && ("".equals(o) || CLEARED.equals(o))))//1
{ 
toBeRemoved.add(o);
} 
} 
removeAll(toBeRemoved);
addAll(elements);
if(isClearable && !elements.contains(CLEARED))//1
{ 
addElement(CLEARED);
} 
if(!objects.contains(selectedObject))//1
{ 
selectedObject = null;
} 
} 
else
{ 
throw new IllegalArgumentException("In setElements: may not set "
                                               + "elements to null collection");
} 
} 
@Override
    protected void fireIntervalAdded(Object source, int index0, int index1)
    { 
if(fireListEvents && !buildingModel)//1
{ 
super.fireIntervalAdded(source, index0, index1);
} 
} 
public int getIndexOf(Object o)
    { 
return objects.indexOf(o);
} 
public void setTarget(Object theNewTarget)
    { 
if(theNewTarget != null && theNewTarget.equals(comboBoxTarget))//1
{ 
LOG.debug("Ignoring duplicate setTarget request " + theNewTarget);
return;
} 
modelValid = false;
LOG.debug("setTarget target :  " + theNewTarget);
theNewTarget = theNewTarget instanceof Fig
                       ? ((Fig) theNewTarget).getOwner() : theNewTarget;
if(Model.getFacade().isAModelElement(theNewTarget)
                || theNewTarget instanceof ArgoDiagram)//1
{ 
if(Model.getFacade().isAModelElement(comboBoxTarget))//1
{ 
Model.getPump().removeModelEventListener(this, comboBoxTarget,
                        propertySetName);
removeOtherModelEventListeners(comboBoxTarget);
} 
else
if(comboBoxTarget instanceof ArgoDiagram)//1
{ 
((ArgoDiagram) comboBoxTarget).removePropertyChangeListener(
                    ArgoDiagram.NAMESPACE_KEY, this);
} 
if(Model.getFacade().isAModelElement(theNewTarget))//1
{ 
comboBoxTarget = theNewTarget;
Model.getPump().addModelEventListener(this, comboBoxTarget,
                                                      propertySetName);
addOtherModelEventListeners(comboBoxTarget);
buildingModel = true;
buildMinimalModelList();
setSelectedItem(external2internal(getSelectedModelElement()));
buildingModel = false;
if(getSize() > 0)//1
{ 
fireIntervalAdded(this, 0, getSize() - 1);
} 
} 
else
if(theNewTarget instanceof ArgoDiagram)//1
{ 
comboBoxTarget = theNewTarget;
ArgoDiagram diagram = (ArgoDiagram) theNewTarget;
diagram.addPropertyChangeListener(
                    ArgoDiagram.NAMESPACE_KEY, this);
buildingModel = true;
buildMinimalModelList();
setSelectedItem(external2internal(getSelectedModelElement()));
buildingModel = false;
if(getSize() > 0)//1
{ 
fireIntervalAdded(this, 0, getSize() - 1);
} 
} 
else
{ 
comboBoxTarget = null;
removeAllElements();
} 
if(getSelectedItem() != null && isClearable)//1
{ 
addElement(CLEARED);
} 
} 
} 
public void targetAdded(TargetEvent e)
    { 
LOG.debug("targetAdded targetevent :  " + e);
setTarget(e.getNewTarget());
} 
private Object external2internal(Object o)
    { 
return o == null && isClearable ? CLEARED : o;
} 
protected boolean isFireListEvents()
    { 
return fireListEvents;
} 

 } 
