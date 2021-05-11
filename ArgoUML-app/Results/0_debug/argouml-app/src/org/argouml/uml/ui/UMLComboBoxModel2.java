
//#if -1983677085 
// Compilation Unit of /UMLComboBoxModel2.java 
 

//#if 1371768145 
package org.argouml.uml.ui;
//#endif 


//#if -245513647 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -1017038185 
import java.beans.PropertyChangeListener;
//#endif 


//#if -1128371888 
import java.util.ArrayList;
//#endif 


//#if 719808017 
import java.util.Collection;
//#endif 


//#if 1835136376 
import java.util.LinkedList;
//#endif 


//#if -295290095 
import java.util.List;
//#endif 


//#if -990743642 
import javax.swing.AbstractListModel;
//#endif 


//#if 1528170851 
import javax.swing.ComboBoxModel;
//#endif 


//#if -1070569816 
import javax.swing.JComboBox;
//#endif 


//#if -24026341 
import javax.swing.SwingUtilities;
//#endif 


//#if 1328386980 
import javax.swing.event.PopupMenuEvent;
//#endif 


//#if -1101429660 
import javax.swing.event.PopupMenuListener;
//#endif 


//#if 1792606413 
import org.apache.log4j.Logger;
//#endif 


//#if 1056347055 
import org.argouml.model.AddAssociationEvent;
//#endif 


//#if -418599036 
import org.argouml.model.AssociationChangeEvent;
//#endif 


//#if 786395551 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if 1399224815 
import org.argouml.model.DeleteInstanceEvent;
//#endif 


//#if -1824989377 
import org.argouml.model.InvalidElementException;
//#endif 


//#if -654824384 
import org.argouml.model.Model;
//#endif 


//#if 340738128 
import org.argouml.model.RemoveAssociationEvent;
//#endif 


//#if -1257470633 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if 47094997 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if 1598431635 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if -1817055745 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -302635465 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1533777844 
public abstract class UMLComboBoxModel2 extends 
//#if -281334492 
AbstractListModel
//#endif 

 implements 
//#if -1646987106 
PropertyChangeListener
//#endif 

, 
//#if 1819261767 
ComboBoxModel
//#endif 

, 
//#if -2090907318 
TargetListener
//#endif 

, 
//#if -722568198 
PopupMenuListener
//#endif 

  { 

//#if 1905953225 
private static final Logger LOG = Logger.getLogger(UMLComboBoxModel2.class);
//#endif 


//#if 598334436 
protected static final String CLEARED = "<none>";
//#endif 


//#if 571830786 
private Object comboBoxTarget = null;
//#endif 


//#if -2068365656 
private List objects = new LinkedList();
//#endif 


//#if 434793838 
private Object selectedObject = null;
//#endif 


//#if 266728130 
private boolean isClearable = false;
//#endif 


//#if -1971705390 
private String propertySetName;
//#endif 


//#if -1756851513 
private boolean fireListEvents = true;
//#endif 


//#if 855910719 
protected boolean buildingModel = false;
//#endif 


//#if -1320785255 
private boolean processingWillBecomeVisible = false;
//#endif 


//#if -107624194 
private boolean modelValid;
//#endif 


//#if 1286358813 
protected void addOtherModelEventListeners(Object newTarget)
    { 
} 

//#endif 


//#if 1085512062 
private Object internal2external(Object o)
    { 

//#if -1128911207 
return isClearable && CLEARED.equals(o) ? null : o;
//#endif 

} 

//#endif 


//#if -195491841 
protected boolean isClearable()
    { 

//#if 330634521 
return isClearable;
//#endif 

} 

//#endif 


//#if 779595204 
public Object getElementAt(int index)
    { 

//#if -1580934759 
if(index >= 0 && index < objects.size())//1
{ 

//#if -2090511753 
return objects.get(index);
//#endif 

} 

//#endif 


//#if 387104133 
return null;
//#endif 

} 

//#endif 


//#if -1712172455 
protected void removeOtherModelEventListeners(Object oldTarget)
    { 
} 

//#endif 


//#if -1585521452 
protected void setModelInvalid()
    { 

//#if 640743218 
assert isLazy();
//#endif 


//#if -738792930 
modelValid = false;
//#endif 

} 

//#endif 


//#if -7773646 
protected String getName(Object obj)
    { 

//#if -495846483 
try //1
{ 

//#if 2143740490 
Object n = Model.getFacade().getName(obj);
//#endif 


//#if 392681387 
String name = (n != null ? (String) n : "");
//#endif 


//#if 544558808 
return name;
//#endif 

} 

//#if 2017518152 
catch (InvalidElementException e) //1
{ 

//#if 407187522 
return "";
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -522251885 
public void removeAllElements()
    { 

//#if 1795958726 
int startIndex = 0;
//#endif 


//#if 1383111108 
int endIndex = Math.max(0, objects.size() - 1);
//#endif 


//#if -1197077148 
objects.clear();
//#endif 


//#if -1484471026 
selectedObject = null;
//#endif 


//#if 1115993239 
fireIntervalRemoved(this, startIndex, endIndex);
//#endif 

} 

//#endif 


//#if 1033758423 
public int getSize()
    { 

//#if -235496976 
return objects.size();
//#endif 

} 

//#endif 


//#if 366833549 
protected abstract boolean isValidElement(Object element);
//#endif 


//#if 1610806800 
public final void propertyChange(final PropertyChangeEvent pve)
    { 

//#if -193627074 
if(pve instanceof UmlChangeEvent)//1
{ 

//#if -1620986910 
final UmlChangeEvent event = (UmlChangeEvent) pve;
//#endif 


//#if 1065214144 
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
//#endif 


//#if 360958797 
SwingUtilities.invokeLater(doWorkRunnable);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1023357713 
public void popupMenuWillBecomeVisible(PopupMenuEvent ev)
    { 

//#if -130794765 
if(isLazy() && !modelValid && !processingWillBecomeVisible)//1
{ 

//#if 1588487259 
buildModelListTimed();
//#endif 


//#if 1436366210 
modelValid = true;
//#endif 


//#if -1263539149 
JComboBox list = (JComboBox) ev.getSource();
//#endif 


//#if -1220829257 
processingWillBecomeVisible = true;
//#endif 


//#if 1836273813 
try //1
{ 

//#if -1666585594 
list.getUI().setPopupVisible( list, true );
//#endif 

} 
finally { 

//#if -603473525 
processingWillBecomeVisible = false;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1586628206 
protected void addAll(Collection col)
    { 

//#if -637283598 
Object selected = getSelectedItem();
//#endif 


//#if 1778069441 
fireListEvents = false;
//#endif 


//#if 1679425538 
int oldSize = objects.size();
//#endif 


//#if 1511949048 
for (Object o : col) //1
{ 

//#if -422649956 
addElement(o);
//#endif 

} 

//#endif 


//#if -1159846595 
setSelectedItem(external2internal(selected));
//#endif 


//#if 1317726980 
fireListEvents = true;
//#endif 


//#if 1020043060 
if(objects.size() != oldSize)//1
{ 

//#if 1002491069 
fireIntervalAdded(this, oldSize == 0 ? 0 : oldSize - 1,
                              objects.size() - 1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 672643800 
protected void buildMinimalModelList()
    { 

//#if 2004501559 
buildModelListTimed();
//#endif 

} 

//#endif 


//#if 477542909 
protected String getPropertySetName()
    { 

//#if 1584146180 
return propertySetName;
//#endif 

} 

//#endif 


//#if 703356782 
@Override
    protected void fireIntervalRemoved(Object source, int index0, int index1)
    { 

//#if 1667056082 
if(fireListEvents && !buildingModel)//1
{ 

//#if -173025338 
super.fireIntervalRemoved(source, index0, index1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1453534560 
protected Object getTarget()
    { 

//#if 1418155577 
return comboBoxTarget;
//#endif 

} 

//#endif 


//#if 737673931 
public void removeElement(Object o)
    { 

//#if 882375899 
int index = objects.indexOf(o);
//#endif 


//#if 2078399466 
if(getElementAt(index) == selectedObject)//1
{ 

//#if -1268247008 
if(!isClearable)//1
{ 

//#if 117839763 
if(index == 0)//1
{ 

//#if -1154351303 
setSelectedItem(getSize() == 1
                                    ? null
                                    : getElementAt(index + 1));
//#endif 

} 
else
{ 

//#if 1042572181 
setSelectedItem(getElementAt(index - 1));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -427403131 
if(index >= 0)//1
{ 

//#if -378861553 
objects.remove(index);
//#endif 


//#if -1854386060 
fireIntervalRemoved(this, index, index);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -454062736 
public void popupMenuWillBecomeInvisible(PopupMenuEvent e)
    { 
} 

//#endif 


//#if -1979966028 
public void targetSet(TargetEvent e)
    { 

//#if 1709244507 
LOG.debug("targetSet targetevent :  " + e);
//#endif 


//#if -1966137408 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 1514252627 
public void setSelectedItem(Object o)
    { 

//#if 709730582 
if((selectedObject != null && !selectedObject.equals(o))
                || (selectedObject == null && o != null))//1
{ 

//#if 971078225 
selectedObject = o;
//#endif 


//#if -569503374 
fireContentsChanged(this, -1, -1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1845529090 
protected void setFireListEvents(boolean events)
    { 

//#if -987736043 
this.fireListEvents = events;
//#endif 

} 

//#endif 


//#if -1308366376 
protected boolean isValidEvent(PropertyChangeEvent e)
    { 

//#if -1039258093 
boolean valid = false;
//#endif 


//#if -1579227499 
if(!(getChangedElement(e) instanceof Collection))//1
{ 

//#if -1957442500 
if((e.getNewValue() == null && e.getOldValue() != null)
                    // Don't try to test this if we're removing the element
                    || isValidElement(getChangedElement(e)))//1
{ 

//#if -1901052457 
valid = true;
//#endif 

} 

//#endif 

} 
else
{ 

//#if 1460690509 
Collection col = (Collection) getChangedElement(e);
//#endif 


//#if -1702911418 
if(!col.isEmpty())//1
{ 

//#if 1300616004 
valid = true;
//#endif 


//#if -1912793577 
for (Object o : col) //1
{ 

//#if 1438315543 
if(!isValidElement(o))//1
{ 

//#if -590178335 
valid = false;
//#endif 


//#if 2019403396 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 
else
{ 

//#if -1145028333 
if(e.getOldValue() instanceof Collection
                        && !((Collection) e.getOldValue()).isEmpty())//1
{ 

//#if 522470049 
valid = true;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1378890307 
return valid;
//#endif 

} 

//#endif 


//#if -576119059 
private void buildModelListTimed()
    { 

//#if 408901486 
long startTime = System.currentTimeMillis();
//#endif 


//#if 73407979 
try //1
{ 

//#if 121448262 
buildModelList();
//#endif 


//#if -1147379295 
long endTime = System.currentTimeMillis();
//#endif 


//#if 1952091764 
LOG.debug("buildModelList took " + (endTime - startTime)
                      + " msec. for " + this.getClass().getName());
//#endif 

} 

//#if -1286569748 
catch (InvalidElementException e) //1
{ 

//#if 635513183 
LOG.warn("buildModelList attempted to operate on "
                     + "deleted element");
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1432638983 
public void popupMenuCanceled(PopupMenuEvent e)
    { 
} 

//#endif 


//#if -1125706370 
protected boolean isLazy()
    { 

//#if 952433487 
return false;
//#endif 

} 

//#endif 


//#if -1052983785 
public void modelChanged(UmlChangeEvent evt)
    { 

//#if -205415267 
buildingModel = true;
//#endif 


//#if -1339591806 
if(evt instanceof AttributeChangeEvent)//1
{ 

//#if -1825868121 
if(evt.getPropertyName().equals(propertySetName))//1
{ 

//#if 43114817 
if(evt.getSource() == getTarget()
                        && (isClearable || getChangedElement(evt) != null))//1
{ 

//#if -619069463 
Object elem = getChangedElement(evt);
//#endif 


//#if -1324373110 
if(elem != null && !contains(elem))//1
{ 

//#if -1989060684 
addElement(elem);
//#endif 

} 

//#endif 


//#if 1549185613 
buildingModel = false;
//#endif 


//#if -1521675546 
setSelectedItem(elem);
//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if 316246200 
if(evt instanceof DeleteInstanceEvent)//1
{ 

//#if 667598702 
if(contains(getChangedElement(evt)))//1
{ 

//#if 1820990936 
Object o = getChangedElement(evt);
//#endif 


//#if 1369510539 
removeElement(o);
//#endif 

} 

//#endif 

} 
else

//#if -231840920 
if(evt instanceof AddAssociationEvent)//1
{ 

//#if 1762806268 
if(getTarget() != null && isValidEvent(evt))//1
{ 

//#if 1177090562 
if(evt.getPropertyName().equals(propertySetName)
                        && (evt.getSource() == getTarget()))//1
{ 

//#if -2105651712 
Object elem = evt.getNewValue();
//#endif 


//#if -1646247482 
setSelectedItem(elem);
//#endif 

} 
else
{ 

//#if 1037034145 
Object o = getChangedElement(evt);
//#endif 


//#if 548068529 
addElement(o);
//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if -1689341177 
if(evt instanceof RemoveAssociationEvent && isValidEvent(evt))//1
{ 

//#if 865930280 
if(evt.getPropertyName().equals(propertySetName)
                    && (evt.getSource() == getTarget()))//1
{ 

//#if 1429525980 
if(evt.getOldValue() == internal2external(getSelectedItem()))//1
{ 

//#if 1139832081 
setSelectedItem(external2internal(evt.getNewValue()));
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1921050362 
Object o = getChangedElement(evt);
//#endif 


//#if 1490930840 
if(contains(o))//1
{ 

//#if 1570570168 
removeElement(o);
//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if 308635714 
if(evt.getSource() instanceof ArgoDiagram
                   && evt.getPropertyName().equals(propertySetName))//1
{ 

//#if -392758022 
addElement(evt.getNewValue());
//#endif 


//#if -1776381320 
buildingModel = false;
//#endif 


//#if 35558463 
setSelectedItem(evt.getNewValue());
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#if 1805300040 
buildingModel = false;
//#endif 

} 

//#endif 


//#if 1194875225 
protected abstract void buildModelList();
//#endif 


//#if 1263564411 
protected abstract Object getSelectedModelElement();
//#endif 


//#if -1653079539 
@Override
    protected void fireContentsChanged(Object source, int index0, int index1)
    { 

//#if 241251279 
if(fireListEvents && !buildingModel)//1
{ 

//#if -401247290 
super.fireContentsChanged(source, index0, index1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 67581942 
public UMLComboBoxModel2(String name, boolean clearable)
    { 

//#if 173636637 
super();
//#endif 


//#if 1538462508 
if(name == null || name.equals(""))//1
{ 

//#if 59546545 
throw new IllegalArgumentException("one of the arguments is null");
//#endif 

} 

//#endif 


//#if -1888266670 
isClearable = clearable;
//#endif 


//#if 906784781 
propertySetName = name;
//#endif 

} 

//#endif 


//#if -1867690408 
public Object getSelectedItem()
    { 

//#if -1609982119 
return selectedObject;
//#endif 

} 

//#endif 


//#if 1476915108 
public void addElement(Object o)
    { 

//#if -798820001 
if(!objects.contains(o))//1
{ 

//#if 1084163532 
objects.add(o);
//#endif 


//#if 153479207 
fireIntervalAdded(this, objects.size() - 1, objects.size() - 1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1332894030 
public void targetRemoved(TargetEvent e)
    { 

//#if -342010827 
LOG.debug("targetRemoved targetevent :  " + e);
//#endif 


//#if 1430720063 
Object currentTarget = comboBoxTarget;
//#endif 


//#if -1754317381 
Object oldTarget =
            e.getOldTargets().length > 0
            ? e.getOldTargets()[0] : null;
//#endif 


//#if -1836692201 
if(oldTarget instanceof Fig)//1
{ 

//#if -1185492385 
oldTarget = ((Fig) oldTarget).getOwner();
//#endif 

} 

//#endif 


//#if -120549399 
if(oldTarget == currentTarget)//1
{ 

//#if 1777980175 
if(Model.getFacade().isAModelElement(currentTarget))//1
{ 

//#if -206748931 
Model.getPump().removeModelEventListener(this,
                        currentTarget, propertySetName);
//#endif 

} 

//#endif 


//#if 80953514 
comboBoxTarget = e.getNewTarget();
//#endif 

} 

//#endif 


//#if 62411944 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 1941761871 
protected void removeAll(Collection col)
    { 

//#if 2018023698 
int first = -1;
//#endif 


//#if -568043608 
int last = -1;
//#endif 


//#if 62367057 
fireListEvents = false;
//#endif 


//#if -1600447352 
for (Object o : col) //1
{ 

//#if 545403650 
int index = getIndexOf(o);
//#endif 


//#if 1731168365 
removeElement(o);
//#endif 


//#if 459541845 
if(first == -1)//1
{ 

//#if 1490053421 
first = index;
//#endif 


//#if -386112455 
last = index;
//#endif 

} 
else
{ 

//#if 430097624 
if(index  != last + 1)//1
{ 

//#if 582247420 
fireListEvents = true;
//#endif 


//#if -839635440 
fireIntervalRemoved(this, first, last);
//#endif 


//#if 453039561 
fireListEvents = false;
//#endif 


//#if -1703735371 
first = index;
//#endif 


//#if 480693425 
last = index;
//#endif 

} 
else
{ 

//#if 770187973 
last++;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -677280908 
fireListEvents = true;
//#endif 

} 

//#endif 


//#if 459612460 
public boolean contains(Object elem)
    { 

//#if 94054267 
if(objects.contains(elem))//1
{ 

//#if -614391738 
return true;
//#endif 

} 

//#endif 


//#if 1021284137 
if(elem instanceof Collection)//1
{ 

//#if -1609095759 
for (Object o : (Collection) elem) //1
{ 

//#if -1426120988 
if(!objects.contains(o))//1
{ 

//#if 906730740 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1837905489 
return true;
//#endif 

} 

//#endif 


//#if 1330762955 
return false;
//#endif 

} 

//#endif 


//#if 294204743 
protected Object getChangedElement(PropertyChangeEvent e)
    { 

//#if -890741718 
if(e instanceof AssociationChangeEvent)//1
{ 

//#if 1827694661 
return ((AssociationChangeEvent) e).getChangedValue();
//#endif 

} 

//#endif 


//#if 10009247 
return e.getNewValue();
//#endif 

} 

//#endif 


//#if -1874997400 
protected void setElements(Collection elements)
    { 

//#if 1092300230 
if(elements != null)//1
{ 

//#if 1818640952 
ArrayList toBeRemoved = new ArrayList();
//#endif 


//#if 2132832108 
for (Object o : objects) //1
{ 

//#if -76901004 
if(!elements.contains(o)
                        && !(isClearable
                             // Check against "" is needed for backward
                             // compatibility.  Don't remove without
                             // checking subclasses and warning downstream
                             // developers - tfm - 20081211
                             && ("".equals(o) || CLEARED.equals(o))))//1
{ 

//#if 1810603546 
toBeRemoved.add(o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -943509278 
removeAll(toBeRemoved);
//#endif 


//#if -1312411318 
addAll(elements);
//#endif 


//#if 2006087775 
if(isClearable && !elements.contains(CLEARED))//1
{ 

//#if -21161829 
addElement(CLEARED);
//#endif 

} 

//#endif 


//#if 2138441093 
if(!objects.contains(selectedObject))//1
{ 

//#if 402198243 
selectedObject = null;
//#endif 

} 

//#endif 

} 
else
{ 

//#if 663761759 
throw new IllegalArgumentException("In setElements: may not set "
                                               + "elements to null collection");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -29498738 
@Override
    protected void fireIntervalAdded(Object source, int index0, int index1)
    { 

//#if 28601968 
if(fireListEvents && !buildingModel)//1
{ 

//#if 1085747650 
super.fireIntervalAdded(source, index0, index1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1254523635 
public int getIndexOf(Object o)
    { 

//#if 1395201872 
return objects.indexOf(o);
//#endif 

} 

//#endif 


//#if -706880845 
public void setTarget(Object theNewTarget)
    { 

//#if 1975726413 
if(theNewTarget != null && theNewTarget.equals(comboBoxTarget))//1
{ 

//#if 141288994 
LOG.debug("Ignoring duplicate setTarget request " + theNewTarget);
//#endif 


//#if -1297798599 
return;
//#endif 

} 

//#endif 


//#if 191949327 
modelValid = false;
//#endif 


//#if -738199103 
LOG.debug("setTarget target :  " + theNewTarget);
//#endif 


//#if -1777241286 
theNewTarget = theNewTarget instanceof Fig
                       ? ((Fig) theNewTarget).getOwner() : theNewTarget;
//#endif 


//#if -868430523 
if(Model.getFacade().isAModelElement(theNewTarget)
                || theNewTarget instanceof ArgoDiagram)//1
{ 

//#if -400710502 
if(Model.getFacade().isAModelElement(comboBoxTarget))//1
{ 

//#if 774181264 
Model.getPump().removeModelEventListener(this, comboBoxTarget,
                        propertySetName);
//#endif 


//#if 887496581 
removeOtherModelEventListeners(comboBoxTarget);
//#endif 

} 
else

//#if -962906075 
if(comboBoxTarget instanceof ArgoDiagram)//1
{ 

//#if 732196183 
((ArgoDiagram) comboBoxTarget).removePropertyChangeListener(
                    ArgoDiagram.NAMESPACE_KEY, this);
//#endif 

} 

//#endif 


//#endif 


//#if 1481443592 
if(Model.getFacade().isAModelElement(theNewTarget))//1
{ 

//#if 296823523 
comboBoxTarget = theNewTarget;
//#endif 


//#if 1049698253 
Model.getPump().addModelEventListener(this, comboBoxTarget,
                                                      propertySetName);
//#endif 


//#if -879118592 
addOtherModelEventListeners(comboBoxTarget);
//#endif 


//#if 1967133870 
buildingModel = true;
//#endif 


//#if -1313635875 
buildMinimalModelList();
//#endif 


//#if -1640618679 
setSelectedItem(external2internal(getSelectedModelElement()));
//#endif 


//#if 434846551 
buildingModel = false;
//#endif 


//#if 493602174 
if(getSize() > 0)//1
{ 

//#if -853893848 
fireIntervalAdded(this, 0, getSize() - 1);
//#endif 

} 

//#endif 

} 
else

//#if -1638737502 
if(theNewTarget instanceof ArgoDiagram)//1
{ 

//#if -1845566444 
comboBoxTarget = theNewTarget;
//#endif 


//#if 1701230880 
ArgoDiagram diagram = (ArgoDiagram) theNewTarget;
//#endif 


//#if 834619238 
diagram.addPropertyChangeListener(
                    ArgoDiagram.NAMESPACE_KEY, this);
//#endif 


//#if -15658915 
buildingModel = true;
//#endif 


//#if 1156021134 
buildMinimalModelList();
//#endif 


//#if 491934266 
setSelectedItem(external2internal(getSelectedModelElement()));
//#endif 


//#if -902187640 
buildingModel = false;
//#endif 


//#if -1094379537 
if(getSize() > 0)//1
{ 

//#if 304385849 
fireIntervalAdded(this, 0, getSize() - 1);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -603888151 
comboBoxTarget = null;
//#endif 


//#if 894560746 
removeAllElements();
//#endif 

} 

//#endif 


//#endif 


//#if -534439450 
if(getSelectedItem() != null && isClearable)//1
{ 

//#if -1410831576 
addElement(CLEARED);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -124653934 
public void targetAdded(TargetEvent e)
    { 

//#if 740459823 
LOG.debug("targetAdded targetevent :  " + e);
//#endif 


//#if -1941628594 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -702145446 
private Object external2internal(Object o)
    { 

//#if -1807240578 
return o == null && isClearable ? CLEARED : o;
//#endif 

} 

//#endif 


//#if 909940407 
protected boolean isFireListEvents()
    { 

//#if -1739660453 
return fireListEvents;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

