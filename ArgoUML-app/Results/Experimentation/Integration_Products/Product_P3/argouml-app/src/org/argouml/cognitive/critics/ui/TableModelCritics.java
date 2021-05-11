package org.argouml.cognitive.critics.ui;
import java.beans.PropertyChangeEvent;
import java.beans.VetoableChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import org.argouml.cognitive.Agency;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Translator;
class TableModelCritics extends AbstractTableModel
 implements VetoableChangeListener
  { 
private List<Critic> critics;
private boolean advanced;
void setAdvanced(boolean advancedMode)
    { 
advanced = advancedMode;
fireTableStructureChanged();
} 
public int getColumnCount()
    { 
return advanced ? 6 : 3;
} 
public int getRowCount()
    { 
if(critics == null)//1
{ 
return 0;
} 
return critics.size();
} 
public String getColumnName(int c)
    { 
if(c == 0)//1
{ 
return Translator.localize("dialog.browse.column-name.active");
} 
if(c == 1)//1
{ 
return Translator.localize("dialog.browse.column-name.headline");
} 
if(c == 2)//1
{ 
return Translator.localize("dialog.browse.column-name.snoozed");
} 
if(c == 3)//1
{ 
return Translator.localize("dialog.browse.column-name.priority");
} 
if(c == 4)//1
return Translator.localize(
                       "dialog.browse.column-name.supported-decision");
if(c == 5)//1
return Translator.localize(
                       "dialog.browse.column-name.knowledge-type");
throw new IllegalArgumentException();
} 
public Class< ? > getColumnClass(int c)
    { 
if(c == 0)//1
{ 
return Boolean.class;
} 
if(c == 1)//1
{ 
return String.class;
} 
if(c == 2)//1
{ 
return String.class;
} 
if(c == 3)//1
{ 
return Integer.class;
} 
if(c == 4)//1
{ 
return String.class;
} 
if(c == 5)//1
{ 
return String.class;
} 
throw new IllegalArgumentException();
} 
public Critic getCriticAtRow(int row)
    { 
return critics.get(row);
} 
public void vetoableChange(PropertyChangeEvent pce)
    { 
SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                fireTableStructureChanged();
            }
        });
} 
public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    { 
if(columnIndex != 0)//1
{ 
return;
} 
if(!(aValue instanceof Boolean))//1
{ 
return;
} 
Boolean enable = (Boolean) aValue;
Critic cr = critics.get(rowIndex);
cr.setEnabled(enable.booleanValue());
fireTableRowsUpdated(rowIndex, rowIndex);
} 
private String listToString(List l)
    { 
StringBuffer buf = new StringBuffer();
Iterator i = l.iterator();
boolean hasNext = i.hasNext();
while (hasNext) //1
{ 
Object o = i.next();
buf.append(String.valueOf(o));
hasNext = i.hasNext();
if(hasNext)//1
{ 
buf.append(", ");
} 
} 
return buf.toString();
} 
public boolean isCellEditable(int row, int col)
    { 
return col == 0;
} 
public Object getValueAt(int row, int col)
    { 
Critic cr = critics.get(row);
if(col == 0)//1
{ 
return cr.isEnabled() ? Boolean.TRUE : Boolean.FALSE;
} 
if(col == 1)//1
{ 
return cr.getHeadline();
} 
if(col == 2)//1
{ 
return cr.isActive() ? "no" : "yes";
} 
if(col == 3)//1
{ 
return cr.getPriority();
} 
if(col == 4)//1
{ 
return listToString(cr.getSupportedDecisions());
} 
if(col == 5)//1
{ 
return listToString(cr.getKnowledgeTypes());
} 
throw new IllegalArgumentException();
} 
public TableModelCritics(boolean advancedMode)
    { 
critics = new ArrayList<Critic>(Agency.getCriticList());
Collections.sort(critics, new Comparator<Critic>() {
            public int compare(Critic o1, Critic o2) {
                return o1.getHeadline().compareTo(o2.getHeadline());
            }
        });
advanced = advancedMode;
} 

 } 
