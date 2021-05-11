// Compilation Unit of /UMLModelElementListModel2.java 
 
package org.argouml.uml.ui;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JPopupMenu;
import org.apache.log4j.Logger;
import org.argouml.model.AddAssociationEvent;
import org.argouml.model.AssociationChangeEvent;
import org.argouml.model.AttributeChangeEvent;
import org.argouml.model.InvalidElementException;
import org.argouml.model.Model;
import org.argouml.model.RemoveAssociationEvent;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.ui.targetmanager.TargetListener;
import org.tigris.gef.base.Diagram;
import org.tigris.gef.presentation.Fig;
public abstract class UMLModelElementListModel2 extends DefaultListModel
 implements TargetListener
, PropertyChangeListener
  { 
private static final Logger LOG =
        Logger.getLogger(UMLModelElementListModel2.class);
private String eventName = null;
private Object listTarget = null;
private boolean fireListEvents = true;
private boolean buildingModel = false;
private Object metaType;
private boolean reverseDropConnection;
protected boolean hasPopup()
    { 
return false;
} 

public Object getTarget()
    { 
return listTarget;
} 

protected void fireContentsChanged(Object source, int index0, int index1)
    { 
if(fireListEvents && !buildingModel)//1
{ 
super.fireContentsChanged(source, index0, index1);
} 

} 

protected void setEventName(String theEventName)
    { 
eventName = theEventName;
} 

protected void setAllElements(Collection col)
    { 
if(!isEmpty())//1
{ 
removeAllElements();
} 

addAll(col);
} 

public void setTarget(Object theNewTarget)
    { 
theNewTarget = theNewTarget instanceof Fig
                       ? ((Fig) theNewTarget).getOwner() : theNewTarget;
if(Model.getFacade().isAUMLElement(theNewTarget)
                || theNewTarget instanceof Diagram)//1
{ 
if(Model.getFacade().isAUMLElement(listTarget))//1
{ 
Model.getPump().removeModelEventListener(this, listTarget,
                        eventName);
removeOtherModelEventListeners(listTarget);
} 

if(Model.getFacade().isAUMLElement(theNewTarget))//1
{ 
listTarget = theNewTarget;
Model.getPump().addModelEventListener(this, listTarget,
                                                      eventName);
addOtherModelEventListeners(listTarget);
rebuildModelList();
} 
else
{ 
listTarget = null;
removeAllElements();
} 

} 

} 

protected boolean isValidEvent(PropertyChangeEvent e)
    { 
boolean valid = false;
if(!(getChangedElement(e) instanceof Collection))//1
{ 
if((e.getNewValue() == null && e.getOldValue() != null)
                    // Don't test changed element if it was deleted
                    || isValidElement(getChangedElement(e)))//1
{ 
valid = true;
} 

} 
else
{ 
Collection col = (Collection) getChangedElement(e);
Iterator it = col.iterator();
if(!col.isEmpty())//1
{ 
valid = true;
while (it.hasNext()) //1
{ 
Object o = it.next();
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

public boolean contains(Object elem)
    { 
if(super.contains(elem))//1
{ 
return true;
} 

if(elem instanceof Collection)//1
{ 
Iterator it = ((Collection) elem).iterator();
while (it.hasNext()) //1
{ 
if(!super.contains(it.next()))//1
{ 
return false;
} 

} 

return true;
} 

return false;
} 

protected abstract boolean isValidElement(Object element);
public void targetAdded(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 

protected void removeOtherModelEventListeners(Object oldTarget)
    { 
} 

protected Object getChangedElement(PropertyChangeEvent e)
    { 
if(e instanceof AssociationChangeEvent)//1
{ 
return ((AssociationChangeEvent) e).getChangedValue();
} 

if(e instanceof AttributeChangeEvent)//1
{ 
return ((AttributeChangeEvent) e).getSource();
} 

return e.getNewValue();
} 

private void rebuildModelList()
    { 
removeAllElements();
buildingModel = true;
try //1
{ 
buildModelList();
} 
catch (InvalidElementException exception) //1
{ 
LOG.debug("buildModelList threw exception for target "
                      + getTarget() + ": "
                      + exception);
} 

finally { 
buildingModel = false;
} 

if(getSize() > 0)//1
{ 
fireIntervalAdded(this, 0, getSize() - 1);
} 

} 

public boolean buildPopup(JPopupMenu popup, int index)
    { 
return false;
} 

protected abstract void buildModelList();
public boolean isReverseDropConnection()
    { 
return reverseDropConnection;
} 

protected void setBuildingModel(boolean building)
    { 
this.buildingModel = building;
} 

public UMLModelElementListModel2()
    { 
super();
} 

public void targetSet(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 

public void propertyChange(PropertyChangeEvent e)
    { 
if(e instanceof AttributeChangeEvent)//1
{ 
try //1
{ 
if(isValidEvent(e))//1
{ 
rebuildModelList();
} 

} 
catch (InvalidElementException iee) //1
{ 
return;
} 


} 
else
if(e instanceof AddAssociationEvent)//1
{ 
if(isValidEvent(e))//1
{ 
Object o = getChangedElement(e);
if(o instanceof Collection)//1
{ 
ArrayList tempList = new ArrayList((Collection) o);
Iterator it = tempList.iterator();
while (it.hasNext()) //1
{ 
Object o2 = it.next();
addElement(o2);
} 

} 
else
{ 
addElement(o);
} 

} 

} 
else
if(e instanceof RemoveAssociationEvent)//1
{ 
boolean valid = false;
if(!(getChangedElement(e) instanceof Collection))//1
{ 
valid = contains(getChangedElement(e));
} 
else
{ 
Collection col = (Collection) getChangedElement(e);
Iterator it = col.iterator();
valid = true;
while (it.hasNext()) //1
{ 
Object o = it.next();
if(!contains(o))//1
{ 
valid = false;
break;

} 

} 

} 

if(valid)//1
{ 
Object o = getChangedElement(e);
if(o instanceof Collection)//1
{ 
Iterator it = ((Collection) o).iterator();
while (it.hasNext()) //1
{ 
Object o3 = it.next();
removeElement(o3);
} 

} 
else
{ 
removeElement(o);
} 

} 

} 



} 

protected void fireIntervalAdded(Object source, int index0, int index1)
    { 
if(fireListEvents && !buildingModel)//1
{ 
super.fireIntervalAdded(source, index0, index1);
} 

} 

String getEventName()
    { 
return eventName;
} 

public UMLModelElementListModel2(String name, Object theMetaType)
    { 
super();
this.metaType = theMetaType;
eventName = name;
} 

protected void fireIntervalRemoved(Object source, int index0, int index1)
    { 
if(fireListEvents && !buildingModel)//1
{ 
super.fireIntervalRemoved(source, index0, index1);
} 

} 

public Object getMetaType()
    { 
return metaType;
} 

protected void addOtherModelEventListeners(Object newTarget)
    { 
} 

protected void setListTarget(Object t)
    { 
this.listTarget = t;
} 

protected void addAll(Collection col)
    { 
if(col.size() == 0)//1
{ 
return;
} 

Iterator it = col.iterator();
fireListEvents = false;
int intervalStart = getSize() == 0 ? 0 : getSize() - 1;
while (it.hasNext()) //1
{ 
Object o = it.next();
addElement(o);
} 

fireListEvents = true;
fireIntervalAdded(this, intervalStart, getSize() - 1);
} 

public void targetRemoved(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 

public UMLModelElementListModel2(
        String name,
        Object theMetaType,
        boolean reverseTheDropConnection)
    { 
super();
this.metaType = theMetaType;
eventName = name;
this.reverseDropConnection = reverseTheDropConnection;
} 

public void addElement(Object obj)
    { 
if(obj != null && !contains(obj))//1
{ 
super.addElement(obj);
} 

} 

public UMLModelElementListModel2(String name)
    { 
super();
eventName = name;
} 

 } 


