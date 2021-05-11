// Compilation Unit of /TabTaggedValuesModel.java 
 
package org.argouml.uml.ui;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import org.apache.log4j.Logger;
import org.argouml.i18n.Translator;
import org.argouml.kernel.DelayedChangeNotify;
import org.argouml.kernel.DelayedVChangeListener;
import org.argouml.model.DeleteInstanceEvent;
import org.argouml.model.InvalidElementException;
import org.argouml.model.Model;
public class TabTaggedValuesModel extends AbstractTableModel
 implements VetoableChangeListener
, DelayedVChangeListener
, PropertyChangeListener
  { 
private static final Logger LOG =
        Logger.getLogger(TabTaggedValuesModel.class);
private Object target;
private static final long serialVersionUID = -5711005901444956345L;
public int getRowCount()
    { 
if(target == null)//1
{ 
return 0;
} 

try //1
{ 
Collection tvs =
                Model.getFacade().getTaggedValuesCollection(target);
return tvs.size() + 1;
} 
catch (InvalidElementException e) //1
{ 
return 0;
} 


} 

public void vetoableChange(PropertyChangeEvent pce)
    { 
DelayedChangeNotify delayedNotify = new DelayedChangeNotify(this, pce);
SwingUtilities.invokeLater(delayedNotify);
} 

@Override
    public boolean isCellEditable(int row, int col)
    { 
return true;
} 

public TabTaggedValuesModel()
    { 
} 

public void setTarget(Object t)
    { 
if(LOG.isDebugEnabled())//1
{ 
LOG.debug("Set target to " + t);
} 

if(t != null && !Model.getFacade().isAModelElement(t))//1
{ 
throw new IllegalArgumentException();
} 

if(target != t)//1
{ 
if(target != null)//1
{ 
Model.getPump().removeModelEventListener(this, target);
} 

target = t;
if(t != null)//1
{ 
Model.getPump().addModelEventListener(this, t,
                                                      new String[] {"taggedValue", "referenceTag"});
} 

} 

fireTableDataChanged();
} 

static Object getFromCollection(Collection collection, int index)
    { 
if(collection instanceof List)//1
{ 
return ((List) collection).get(index);
} 

if(index >= collection.size() || index < 0)//1
{ 
throw new IndexOutOfBoundsException();
} 

Iterator it = collection.iterator();
for (int i = 0; i < index; i++ ) //1
{ 
it.next();
} 

return it.next();
} 

public void addRow(Object[] values)
    { 
Object tagType = values[0];
String tagValue = (String) values[1];
if(tagType == null)//1
{ 
tagType = "";
} 

if(tagValue == null)//1
{ 
tagValue = "";
} 

Object tv = Model.getExtensionMechanismsFactory().createTaggedValue();
Model.getExtensionMechanismsHelper().addTaggedValue(target, tv);
Model.getExtensionMechanismsHelper().setType(tv, tagType);
Model.getExtensionMechanismsHelper().setDataValues(tv,
                new String[] {tagValue});
fireTableChanged(new TableModelEvent(this));
} 

public Object getValueAt(int row, int col)
    { 
Collection tvs = Model.getFacade().getTaggedValuesCollection(target);
if(row > tvs.size() || col > 1)//1
{ 
throw new IllegalArgumentException();
} 

if(row == tvs.size())//1
{ 
return "";
} 

Object tv = tvs.toArray()[row];
if(col == 0)//1
{ 
Object n = Model.getFacade().getTagDefinition(tv);
if(n == null)//1
{ 
return "";
} 

return n;
} 

if(col == 1)//1
{ 
String be = Model.getFacade().getValueOfTag(tv);
if(be == null)//1
{ 
return "";
} 

return be;
} 

return "TV-" + row * 2 + col;
} 

@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    { 
if(columnIndex != 0 && columnIndex != 1)//1
{ 
return;
} 

if(columnIndex == 1 && aValue == null)//1
{ 
aValue = "";
} 

if((aValue == null || "".equals(aValue)) && columnIndex == 0)//1
{ 
removeRow(rowIndex);
return;
} 

Collection tvs = Model.getFacade().getTaggedValuesCollection(target);
if(tvs.size() <= rowIndex)//1
{ 
if(columnIndex == 0)//1
{ 
addRow(new Object[] {aValue, null});
} 

if(columnIndex == 1)//1
{ 
addRow(new Object[] {null, aValue});
} 

} 
else
{ 
Object tv = getFromCollection(tvs, rowIndex);
if(columnIndex == 0)//1
{ 
Model.getExtensionMechanismsHelper().setType(tv, aValue);
} 
else
if(columnIndex == 1)//1
{ 
Model.getExtensionMechanismsHelper().setDataValues(tv,
                        new String[] {(String) aValue });
} 


fireTableChanged(
                new TableModelEvent(this, rowIndex, rowIndex, columnIndex));
} 

} 

@Override
    public String getColumnName(int c)
    { 
if(c == 0)//1
{ 
return Translator.localize("label.taggedvaluespane.tag");
} 

if(c == 1)//1
{ 
return Translator.localize("label.taggedvaluespane.value");
} 

return "XXX";
} 

public void removeRow(int row)
    { 
Collection c = Model.getFacade().getTaggedValuesCollection(target);
if((row >= 0) && (row < c.size()))//1
{ 
Object element = getFromCollection(c, row);
Model.getUmlFactory().delete(element);
fireTableChanged(new TableModelEvent(this));
} 

} 

public int getColumnCount()
    { 
return 2;
} 

@Override
    public Class getColumnClass(int c)
    { 
if(c == 0)//1
{ 
return (Class) Model.getMetaTypes().getTagDefinition();
} 

if(c == 1)//1
{ 
return String.class;
} 

return null;
} 

public void propertyChange(PropertyChangeEvent evt)
    { 
if("taggedValue".equals(evt.getPropertyName())
                || "referenceTag".equals(evt.getPropertyName()))//1
{ 
fireTableChanged(new TableModelEvent(this));
} 

if(evt instanceof DeleteInstanceEvent
                && evt.getSource() == target)//1
{ 
setTarget(null);
} 

} 

public void delayedVetoableChange(PropertyChangeEvent pce)
    { 
fireTableDataChanged();
} 

 } 


