
//#if 2128230487 
// Compilation Unit of /TabTaggedValuesModel.java 
 

//#if -1074166029 
package org.argouml.uml.ui;
//#endif 


//#if 897042287 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -749029191 
import java.beans.PropertyChangeListener;
//#endif 


//#if 1855511786 
import java.beans.VetoableChangeListener;
//#endif 


//#if -2089707345 
import java.util.Collection;
//#endif 


//#if 1946101087 
import java.util.Iterator;
//#endif 


//#if 1018838063 
import java.util.List;
//#endif 


//#if -448354503 
import javax.swing.SwingUtilities;
//#endif 


//#if 803728166 
import javax.swing.event.TableModelEvent;
//#endif 


//#if -720961880 
import javax.swing.table.AbstractTableModel;
//#endif 


//#if -451845777 
import org.apache.log4j.Logger;
//#endif 


//#if -1459006436 
import org.argouml.i18n.Translator;
//#endif 


//#if -119282778 
import org.argouml.kernel.DelayedChangeNotify;
//#endif 


//#if 794166013 
import org.argouml.kernel.DelayedVChangeListener;
//#endif 


//#if -1336928495 
import org.argouml.model.DeleteInstanceEvent;
//#endif 


//#if -102032543 
import org.argouml.model.InvalidElementException;
//#endif 


//#if 1395690722 
import org.argouml.model.Model;
//#endif 


//#if 1780088428 
public class TabTaggedValuesModel extends 
//#if -1555748539 
AbstractTableModel
//#endif 

 implements 
//#if 567249648 
VetoableChangeListener
//#endif 

, 
//#if 1061749856 
DelayedVChangeListener
//#endif 

, 
//#if 344684865 
PropertyChangeListener
//#endif 

  { 

//#if 1328890924 
private static final Logger LOG =
        Logger.getLogger(TabTaggedValuesModel.class);
//#endif 


//#if -1822504624 
private Object target;
//#endif 


//#if 949112465 
private static final long serialVersionUID = -5711005901444956345L;
//#endif 


//#if 392933198 
public int getRowCount()
    { 

//#if 1386926746 
if(target == null)//1
{ 

//#if -1081997153 
return 0;
//#endif 

} 

//#endif 


//#if 1647015911 
try //1
{ 

//#if 1530148415 
Collection tvs =
                Model.getFacade().getTaggedValuesCollection(target);
//#endif 


//#if 1368230364 
return tvs.size() + 1;
//#endif 

} 

//#if 877772733 
catch (InvalidElementException e) //1
{ 

//#if -737960910 
return 0;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1625067715 
public void vetoableChange(PropertyChangeEvent pce)
    { 

//#if 942543700 
DelayedChangeNotify delayedNotify = new DelayedChangeNotify(this, pce);
//#endif 


//#if 1208681541 
SwingUtilities.invokeLater(delayedNotify);
//#endif 

} 

//#endif 


//#if 62868340 
@Override
    public boolean isCellEditable(int row, int col)
    { 

//#if 1933456001 
return true;
//#endif 

} 

//#endif 


//#if -1635679816 
public TabTaggedValuesModel()
    { 
} 

//#endif 


//#if 21178990 
public void setTarget(Object t)
    { 

//#if -1351331247 
if(LOG.isDebugEnabled())//1
{ 

//#if -1503420353 
LOG.debug("Set target to " + t);
//#endif 

} 

//#endif 


//#if -1708787475 
if(t != null && !Model.getFacade().isAModelElement(t))//1
{ 

//#if 334038855 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if -465208247 
if(target != t)//1
{ 

//#if 746669021 
if(target != null)//1
{ 

//#if -1150646335 
Model.getPump().removeModelEventListener(this, target);
//#endif 

} 

//#endif 


//#if 421754537 
target = t;
//#endif 


//#if -1649365282 
if(t != null)//1
{ 

//#if -1036414519 
Model.getPump().addModelEventListener(this, t,
                                                      new String[] {"taggedValue", "referenceTag"});
//#endif 

} 

//#endif 

} 

//#endif 


//#if 27566755 
fireTableDataChanged();
//#endif 

} 

//#endif 


//#if -1295901003 
static Object getFromCollection(Collection collection, int index)
    { 

//#if -982277847 
if(collection instanceof List)//1
{ 

//#if 112498207 
return ((List) collection).get(index);
//#endif 

} 

//#endif 


//#if 93399252 
if(index >= collection.size() || index < 0)//1
{ 

//#if 1568591480 
throw new IndexOutOfBoundsException();
//#endif 

} 

//#endif 


//#if -589008658 
Iterator it = collection.iterator();
//#endif 


//#if -773022312 
for (int i = 0; i < index; i++ ) //1
{ 

//#if 395440996 
it.next();
//#endif 

} 

//#endif 


//#if 80579398 
return it.next();
//#endif 

} 

//#endif 


//#if -162549604 
public void addRow(Object[] values)
    { 

//#if -1086115898 
Object tagType = values[0];
//#endif 


//#if -2086828494 
String tagValue = (String) values[1];
//#endif 


//#if 1884168289 
if(tagType == null)//1
{ 

//#if 647046869 
tagType = "";
//#endif 

} 

//#endif 


//#if -860877848 
if(tagValue == null)//1
{ 

//#if 1489754602 
tagValue = "";
//#endif 

} 

//#endif 


//#if -628357553 
Object tv = Model.getExtensionMechanismsFactory().createTaggedValue();
//#endif 


//#if 558471161 
Model.getExtensionMechanismsHelper().addTaggedValue(target, tv);
//#endif 


//#if -420015722 
Model.getExtensionMechanismsHelper().setType(tv, tagType);
//#endif 


//#if -230930642 
Model.getExtensionMechanismsHelper().setDataValues(tv,
                new String[] {tagValue});
//#endif 


//#if 353104855 
fireTableChanged(new TableModelEvent(this));
//#endif 

} 

//#endif 


//#if -1832505695 
public Object getValueAt(int row, int col)
    { 

//#if -1778157803 
Collection tvs = Model.getFacade().getTaggedValuesCollection(target);
//#endif 


//#if 1417640685 
if(row > tvs.size() || col > 1)//1
{ 

//#if -1737798336 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if -1799223498 
if(row == tvs.size())//1
{ 

//#if -1639043954 
return "";
//#endif 

} 

//#endif 


//#if -100129309 
Object tv = tvs.toArray()[row];
//#endif 


//#if -1147165597 
if(col == 0)//1
{ 

//#if -646505299 
Object n = Model.getFacade().getTagDefinition(tv);
//#endif 


//#if -1287653478 
if(n == null)//1
{ 

//#if 1783884772 
return "";
//#endif 

} 

//#endif 


//#if -524041787 
return n;
//#endif 

} 

//#endif 


//#if -1146242076 
if(col == 1)//1
{ 

//#if 1415751771 
String be = Model.getFacade().getValueOfTag(tv);
//#endif 


//#if 1969586201 
if(be == null)//1
{ 

//#if -707098847 
return "";
//#endif 

} 

//#endif 


//#if -1647861660 
return be;
//#endif 

} 

//#endif 


//#if -1264552346 
return "TV-" + row * 2 + col;
//#endif 

} 

//#endif 


//#if 1718548383 
@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    { 

//#if -465163678 
if(columnIndex != 0 && columnIndex != 1)//1
{ 

//#if 1406492737 
return;
//#endif 

} 

//#endif 


//#if -134486179 
if(columnIndex == 1 && aValue == null)//1
{ 

//#if -1847346376 
aValue = "";
//#endif 

} 

//#endif 


//#if -2013521187 
if((aValue == null || "".equals(aValue)) && columnIndex == 0)//1
{ 

//#if 148197641 
removeRow(rowIndex);
//#endif 


//#if -112520482 
return;
//#endif 

} 

//#endif 


//#if -796052553 
Collection tvs = Model.getFacade().getTaggedValuesCollection(target);
//#endif 


//#if -899229271 
if(tvs.size() <= rowIndex)//1
{ 

//#if 1484719357 
if(columnIndex == 0)//1
{ 

//#if 852524034 
addRow(new Object[] {aValue, null});
//#endif 

} 

//#endif 


//#if 1485642878 
if(columnIndex == 1)//1
{ 

//#if 591681498 
addRow(new Object[] {null, aValue});
//#endif 

} 

//#endif 

} 
else
{ 

//#if 1243095463 
Object tv = getFromCollection(tvs, rowIndex);
//#endif 


//#if 1855483555 
if(columnIndex == 0)//1
{ 

//#if 713917457 
Model.getExtensionMechanismsHelper().setType(tv, aValue);
//#endif 

} 
else

//#if -1704589253 
if(columnIndex == 1)//1
{ 

//#if -27566363 
Model.getExtensionMechanismsHelper().setDataValues(tv,
                        new String[] {(String) aValue });
//#endif 

} 

//#endif 


//#endif 


//#if -1149527028 
fireTableChanged(
                new TableModelEvent(this, rowIndex, rowIndex, columnIndex));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 615794822 
@Override
    public String getColumnName(int c)
    { 

//#if -60416785 
if(c == 0)//1
{ 

//#if 2073844316 
return Translator.localize("label.taggedvaluespane.tag");
//#endif 

} 

//#endif 


//#if -59493264 
if(c == 1)//1
{ 

//#if -1252779402 
return Translator.localize("label.taggedvaluespane.value");
//#endif 

} 

//#endif 


//#if -1077258512 
return "XXX";
//#endif 

} 

//#endif 


//#if -2063018681 
public void removeRow(int row)
    { 

//#if -880877968 
Collection c = Model.getFacade().getTaggedValuesCollection(target);
//#endif 


//#if 267233058 
if((row >= 0) && (row < c.size()))//1
{ 

//#if -229217507 
Object element = getFromCollection(c, row);
//#endif 


//#if -1701610125 
Model.getUmlFactory().delete(element);
//#endif 


//#if -300752380 
fireTableChanged(new TableModelEvent(this));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -323662110 
public int getColumnCount()
    { 

//#if -986068821 
return 2;
//#endif 

} 

//#endif 


//#if 993450372 
@Override
    public Class getColumnClass(int c)
    { 

//#if -1630983957 
if(c == 0)//1
{ 

//#if -1655229890 
return (Class) Model.getMetaTypes().getTagDefinition();
//#endif 

} 

//#endif 


//#if -1630060436 
if(c == 1)//1
{ 

//#if -1288433299 
return String.class;
//#endif 

} 

//#endif 


//#if -2088435377 
return null;
//#endif 

} 

//#endif 


//#if 771613853 
public void propertyChange(PropertyChangeEvent evt)
    { 

//#if 1696116871 
if("taggedValue".equals(evt.getPropertyName())
                || "referenceTag".equals(evt.getPropertyName()))//1
{ 

//#if 1732725106 
fireTableChanged(new TableModelEvent(this));
//#endif 

} 

//#endif 


//#if 83720724 
if(evt instanceof DeleteInstanceEvent
                && evt.getSource() == target)//1
{ 

//#if -1655734801 
setTarget(null);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -786001579 
public void delayedVetoableChange(PropertyChangeEvent pce)
    { 

//#if -822953284 
fireTableDataChanged();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

