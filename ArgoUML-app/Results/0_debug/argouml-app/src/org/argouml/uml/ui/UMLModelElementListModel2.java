
//#if -1603562138 
// Compilation Unit of /UMLModelElementListModel2.java 
 

//#if -1259293500 
package org.argouml.uml.ui;
//#endif 


//#if -767918850 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 971039946 
import java.beans.PropertyChangeListener;
//#endif 


//#if 535533763 
import java.util.ArrayList;
//#endif 


//#if 761275646 
import java.util.Collection;
//#endif 


//#if -1385006738 
import java.util.Iterator;
//#endif 


//#if -830775414 
import javax.swing.DefaultListModel;
//#endif 


//#if 467730995 
import javax.swing.JPopupMenu;
//#endif 


//#if 204160704 
import org.apache.log4j.Logger;
//#endif 


//#if -1134564254 
import org.argouml.model.AddAssociationEvent;
//#endif 


//#if 760591857 
import org.argouml.model.AssociationChangeEvent;
//#endif 


//#if 1587621708 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if 370189938 
import org.argouml.model.InvalidElementException;
//#endif 


//#if 2051697203 
import org.argouml.model.Model;
//#endif 


//#if 1519929021 
import org.argouml.model.RemoveAssociationEvent;
//#endif 


//#if 1226285890 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if -1958156282 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if -585061916 
import org.tigris.gef.base.Diagram;
//#endif 


//#if 682672426 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 601835739 
public abstract class UMLModelElementListModel2 extends 
//#if 2020936068 
DefaultListModel
//#endif 

 implements 
//#if -1687989889 
TargetListener
//#endif 

, 
//#if 1199307731 
PropertyChangeListener
//#endif 

  { 

//#if 999073138 
private static final Logger LOG =
        Logger.getLogger(UMLModelElementListModel2.class);
//#endif 


//#if 365279874 
private String eventName = null;
//#endif 


//#if 1145951598 
private Object listTarget = null;
//#endif 


//#if -391942532 
private boolean fireListEvents = true;
//#endif 


//#if -1221162177 
private boolean buildingModel = false;
//#endif 


//#if 1510657748 
private Object metaType;
//#endif 


//#if -1310187669 
private boolean reverseDropConnection;
//#endif 


//#if -1499814937 
protected boolean hasPopup()
    { 

//#if -499414577 
return false;
//#endif 

} 

//#endif 


//#if 78388486 
public Object getTarget()
    { 

//#if -1621827500 
return listTarget;
//#endif 

} 

//#endif 


//#if 1089904000 
protected void fireContentsChanged(Object source, int index0, int index1)
    { 

//#if -1437559441 
if(fireListEvents && !buildingModel)//1
{ 

//#if -1624703920 
super.fireContentsChanged(source, index0, index1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1970342823 
protected void setEventName(String theEventName)
    { 

//#if -2092202907 
eventName = theEventName;
//#endif 

} 

//#endif 


//#if -1957041199 
protected void setAllElements(Collection col)
    { 

//#if -1764411564 
if(!isEmpty())//1
{ 

//#if -38500822 
removeAllElements();
//#endif 

} 

//#endif 


//#if 1954973100 
addAll(col);
//#endif 

} 

//#endif 


//#if 921765918 
public void setTarget(Object theNewTarget)
    { 

//#if 388303568 
theNewTarget = theNewTarget instanceof Fig
                       ? ((Fig) theNewTarget).getOwner() : theNewTarget;
//#endif 


//#if -1371279777 
if(Model.getFacade().isAUMLElement(theNewTarget)
                || theNewTarget instanceof Diagram)//1
{ 

//#if 1126598569 
if(Model.getFacade().isAUMLElement(listTarget))//1
{ 

//#if -952179359 
Model.getPump().removeModelEventListener(this, listTarget,
                        eventName);
//#endif 


//#if -512669405 
removeOtherModelEventListeners(listTarget);
//#endif 

} 

//#endif 


//#if -1064628616 
if(Model.getFacade().isAUMLElement(theNewTarget))//1
{ 

//#if 560905273 
listTarget = theNewTarget;
//#endif 


//#if -950920026 
Model.getPump().addModelEventListener(this, listTarget,
                                                      eventName);
//#endif 


//#if 1464521814 
addOtherModelEventListeners(listTarget);
//#endif 


//#if 1357271394 
rebuildModelList();
//#endif 

} 
else
{ 

//#if -981658843 
listTarget = null;
//#endif 


//#if 2003950053 
removeAllElements();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1751301005 
protected boolean isValidEvent(PropertyChangeEvent e)
    { 

//#if 1471856536 
boolean valid = false;
//#endif 


//#if 1810982000 
if(!(getChangedElement(e) instanceof Collection))//1
{ 

//#if -2016242482 
if((e.getNewValue() == null && e.getOldValue() != null)
                    // Don't test changed element if it was deleted
                    || isValidElement(getChangedElement(e)))//1
{ 

//#if 1356987740 
valid = true;
//#endif 

} 

//#endif 

} 
else
{ 

//#if 54285921 
Collection col = (Collection) getChangedElement(e);
//#endif 


//#if -32428792 
Iterator it = col.iterator();
//#endif 


//#if 1389857626 
if(!col.isEmpty())//1
{ 

//#if 947406660 
valid = true;
//#endif 


//#if 1651535250 
while (it.hasNext()) //1
{ 

//#if 929395047 
Object o = it.next();
//#endif 


//#if 2068053748 
if(!isValidElement(o))//1
{ 

//#if -1591593485 
valid = false;
//#endif 


//#if 536459798 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 
else
{ 

//#if -341694254 
if(e.getOldValue() instanceof Collection
                        && !((Collection) e.getOldValue()).isEmpty())//1
{ 

//#if -1559435914 
valid = true;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1006127144 
return valid;
//#endif 

} 

//#endif 


//#if 1612020439 
public boolean contains(Object elem)
    { 

//#if 1088440505 
if(super.contains(elem))//1
{ 

//#if 63253497 
return true;
//#endif 

} 

//#endif 


//#if 280176046 
if(elem instanceof Collection)//1
{ 

//#if 140522626 
Iterator it = ((Collection) elem).iterator();
//#endif 


//#if 1811589561 
while (it.hasNext()) //1
{ 

//#if -1462637757 
if(!super.contains(it.next()))//1
{ 

//#if -1335179910 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -577544850 
return true;
//#endif 

} 

//#endif 


//#if 783346278 
return false;
//#endif 

} 

//#endif 


//#if -1173142088 
protected abstract boolean isValidElement(Object element);
//#endif 


//#if -762148483 
public void targetAdded(TargetEvent e)
    { 

//#if 1618170588 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 1852982734 
protected void removeOtherModelEventListeners(Object oldTarget)
    { 
} 

//#endif 


//#if -200399748 
protected Object getChangedElement(PropertyChangeEvent e)
    { 

//#if 723756700 
if(e instanceof AssociationChangeEvent)//1
{ 

//#if 1670753846 
return ((AssociationChangeEvent) e).getChangedValue();
//#endif 

} 

//#endif 


//#if -50395679 
if(e instanceof AttributeChangeEvent)//1
{ 

//#if 1922751154 
return ((AttributeChangeEvent) e).getSource();
//#endif 

} 

//#endif 


//#if 2115509649 
return e.getNewValue();
//#endif 

} 

//#endif 


//#if 1296321066 
private void rebuildModelList()
    { 

//#if 652687765 
removeAllElements();
//#endif 


//#if 1846988854 
buildingModel = true;
//#endif 


//#if -709675451 
try //1
{ 

//#if 1871752397 
buildModelList();
//#endif 

} 

//#if -368700375 
catch (InvalidElementException exception) //1
{ 

//#if -659660498 
LOG.debug("buildModelList threw exception for target "
                      + getTarget() + ": "
                      + exception);
//#endif 

} 

//#endif 

finally { 

//#if -1223132538 
buildingModel = false;
//#endif 

} 

//#endif 


//#if -2004125450 
if(getSize() > 0)//1
{ 

//#if 1836792175 
fireIntervalAdded(this, 0, getSize() - 1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -139956672 
public boolean buildPopup(JPopupMenu popup, int index)
    { 

//#if -1970923423 
return false;
//#endif 

} 

//#endif 


//#if -1552030332 
protected abstract void buildModelList();
//#endif 


//#if -787929951 
public boolean isReverseDropConnection()
    { 

//#if -793038629 
return reverseDropConnection;
//#endif 

} 

//#endif 


//#if -1681391686 
protected void setBuildingModel(boolean building)
    { 

//#if 421707996 
this.buildingModel = building;
//#endif 

} 

//#endif 


//#if -1054651028 
public UMLModelElementListModel2()
    { 

//#if -2134673639 
super();
//#endif 

} 

//#endif 


//#if -827558049 
public void targetSet(TargetEvent e)
    { 

//#if -591292852 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 1852226733 
public void propertyChange(PropertyChangeEvent e)
    { 

//#if -967326303 
if(e instanceof AttributeChangeEvent)//1
{ 

//#if 434591964 
try //1
{ 

//#if -1430904154 
if(isValidEvent(e))//1
{ 

//#if 721361688 
rebuildModelList();
//#endif 

} 

//#endif 

} 

//#if -887717421 
catch (InvalidElementException iee) //1
{ 

//#if 800688706 
return;
//#endif 

} 

//#endif 


//#endif 

} 
else

//#if 2083898032 
if(e instanceof AddAssociationEvent)//1
{ 

//#if -1813616434 
if(isValidEvent(e))//1
{ 

//#if 1509794340 
Object o = getChangedElement(e);
//#endif 


//#if -605169262 
if(o instanceof Collection)//1
{ 

//#if -857002488 
ArrayList tempList = new ArrayList((Collection) o);
//#endif 


//#if 416722125 
Iterator it = tempList.iterator();
//#endif 


//#if 1755892625 
while (it.hasNext()) //1
{ 

//#if -758647651 
Object o2 = it.next();
//#endif 


//#if -2033806240 
addElement(o2);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1635978047 
addElement(o);
//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if -744018308 
if(e instanceof RemoveAssociationEvent)//1
{ 

//#if -1144329347 
boolean valid = false;
//#endif 


//#if 1942289387 
if(!(getChangedElement(e) instanceof Collection))//1
{ 

//#if 295465586 
valid = contains(getChangedElement(e));
//#endif 

} 
else
{ 

//#if 2058280639 
Collection col = (Collection) getChangedElement(e);
//#endif 


//#if -1327471126 
Iterator it = col.iterator();
//#endif 


//#if -1549158276 
valid = true;
//#endif 


//#if -679835302 
while (it.hasNext()) //1
{ 

//#if -329818027 
Object o = it.next();
//#endif 


//#if 1892589233 
if(!contains(o))//1
{ 

//#if -671281193 
valid = false;
//#endif 


//#if -488190214 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -643616803 
if(valid)//1
{ 

//#if -426776092 
Object o = getChangedElement(e);
//#endif 


//#if 1410570706 
if(o instanceof Collection)//1
{ 

//#if -1769260798 
Iterator it = ((Collection) o).iterator();
//#endif 


//#if 1410829933 
while (it.hasNext()) //1
{ 

//#if -1866963598 
Object o3 = it.next();
//#endif 


//#if 270934994 
removeElement(o3);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1210729760 
removeElement(o);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if -545079615 
protected void fireIntervalAdded(Object source, int index0, int index1)
    { 

//#if 578287760 
if(fireListEvents && !buildingModel)//1
{ 

//#if -1022105176 
super.fireIntervalAdded(source, index0, index1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 525213115 
String getEventName()
    { 

//#if 1775456305 
return eventName;
//#endif 

} 

//#endif 


//#if -1469664053 
public UMLModelElementListModel2(String name, Object theMetaType)
    { 

//#if 161681349 
super();
//#endif 


//#if -544629505 
this.metaType = theMetaType;
//#endif 


//#if -80925454 
eventName = name;
//#endif 

} 

//#endif 


//#if -848626975 
protected void fireIntervalRemoved(Object source, int index0, int index1)
    { 

//#if 1901827689 
if(fireListEvents && !buildingModel)//1
{ 

//#if 1566867812 
super.fireIntervalRemoved(source, index0, index1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1561640492 
public Object getMetaType()
    { 

//#if -312629996 
return metaType;
//#endif 

} 

//#endif 


//#if -1738207288 
protected void addOtherModelEventListeners(Object newTarget)
    { 
} 

//#endif 


//#if 374160467 
protected void setListTarget(Object t)
    { 

//#if 35514048 
this.listTarget = t;
//#endif 

} 

//#endif 


//#if -221719225 
protected void addAll(Collection col)
    { 

//#if 603017045 
if(col.size() == 0)//1
{ 

//#if -363991521 
return;
//#endif 

} 

//#endif 


//#if 1256412306 
Iterator it = col.iterator();
//#endif 


//#if 831438512 
fireListEvents = false;
//#endif 


//#if 492514233 
int intervalStart = getSize() == 0 ? 0 : getSize() - 1;
//#endif 


//#if -900789246 
while (it.hasNext()) //1
{ 

//#if -1757170396 
Object o = it.next();
//#endif 


//#if -951824857 
addElement(o);
//#endif 

} 

//#endif 


//#if -236830155 
fireListEvents = true;
//#endif 


//#if 1259912268 
fireIntervalAdded(this, intervalStart, getSize() - 1);
//#endif 

} 

//#endif 


//#if 215167709 
public void targetRemoved(TargetEvent e)
    { 

//#if 604149199 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -1665578477 
public UMLModelElementListModel2(
        String name,
        Object theMetaType,
        boolean reverseTheDropConnection)
    { 

//#if -1444863426 
super();
//#endif 


//#if 1554998072 
this.metaType = theMetaType;
//#endif 


//#if 667226201 
eventName = name;
//#endif 


//#if -1958801600 
this.reverseDropConnection = reverseTheDropConnection;
//#endif 

} 

//#endif 


//#if 663503367 
public void addElement(Object obj)
    { 

//#if 1503391413 
if(obj != null && !contains(obj))//1
{ 

//#if -340641063 
super.addElement(obj);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1120905488 
public UMLModelElementListModel2(String name)
    { 

//#if 954850187 
super();
//#endif 


//#if 400864876 
eventName = name;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

