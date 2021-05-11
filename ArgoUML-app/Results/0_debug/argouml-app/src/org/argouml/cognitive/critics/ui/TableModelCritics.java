
//#if -533452350 
// Compilation Unit of /TableModelCritics.java 
 

//#if -539670042 
package org.argouml.cognitive.critics.ui;
//#endif 


//#if 857764115 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -49405754 
import java.beans.VetoableChangeListener;
//#endif 


//#if -141205554 
import java.util.ArrayList;
//#endif 


//#if 318288400 
import java.util.Collections;
//#endif 


//#if -1011783653 
import java.util.Comparator;
//#endif 


//#if 255730947 
import java.util.Iterator;
//#endif 


//#if 1116909011 
import java.util.List;
//#endif 


//#if -1997684003 
import javax.swing.SwingUtilities;
//#endif 


//#if -716513972 
import javax.swing.table.AbstractTableModel;
//#endif 


//#if -600537013 
import org.apache.log4j.Logger;
//#endif 


//#if -1206369925 
import org.argouml.cognitive.Agency;
//#endif 


//#if 887436012 
import org.argouml.cognitive.Critic;
//#endif 


//#if -60355706 
import org.argouml.cognitive.Translator;
//#endif 


//#if -169737135 
class TableModelCritics extends 
//#if 1837086172 
AbstractTableModel
//#endif 

 implements 
//#if -63704057 
VetoableChangeListener
//#endif 

  { 

//#if -1506856019 
private static final Logger LOG =
        Logger.getLogger(TableModelCritics.class);
//#endif 


//#if 1531767724 
private List<Critic> critics;
//#endif 


//#if -12987371 
private boolean advanced;
//#endif 


//#if -1375686509 
void setAdvanced(boolean advancedMode)
    { 

//#if -1877516357 
advanced = advancedMode;
//#endif 


//#if 1886887905 
fireTableStructureChanged();
//#endif 

} 

//#endif 


//#if 2006366827 
public int getColumnCount()
    { 

//#if -37074420 
return advanced ? 6 : 3;
//#endif 

} 

//#endif 


//#if -238020507 
public int getRowCount()
    { 

//#if -580484361 
if(critics == null)//1
{ 

//#if -760805446 
return 0;
//#endif 

} 

//#endif 


//#if -1683361978 
return critics.size();
//#endif 

} 

//#endif 


//#if 1136029483 
public String getColumnName(int c)
    { 

//#if -674599450 
if(c == 0)//1
{ 

//#if 1268242528 
return Translator.localize("dialog.browse.column-name.active");
//#endif 

} 

//#endif 


//#if -673675929 
if(c == 1)//1
{ 

//#if 1940390396 
return Translator.localize("dialog.browse.column-name.headline");
//#endif 

} 

//#endif 


//#if -672752408 
if(c == 2)//1
{ 

//#if -865642265 
return Translator.localize("dialog.browse.column-name.snoozed");
//#endif 

} 

//#endif 


//#if -671828887 
if(c == 3)//1
{ 

//#if -1033060127 
return Translator.localize("dialog.browse.column-name.priority");
//#endif 

} 

//#endif 


//#if -670905366 
if(c == 4)//1

//#if -1479543073 
return Translator.localize(
                       "dialog.browse.column-name.supported-decision");
//#endif 


//#endif 


//#if -669981845 
if(c == 5)//1

//#if -914785651 
return Translator.localize(
                       "dialog.browse.column-name.knowledge-type");
//#endif 


//#endif 


//#if -1635158230 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if -1510767388 
public Class< ? > getColumnClass(int c)
    { 

//#if -2009827807 
if(c == 0)//1
{ 

//#if -221785653 
return Boolean.class;
//#endif 

} 

//#endif 


//#if -2008904286 
if(c == 1)//1
{ 

//#if 1873649267 
return String.class;
//#endif 

} 

//#endif 


//#if -2007980765 
if(c == 2)//1
{ 

//#if 1224275709 
return String.class;
//#endif 

} 

//#endif 


//#if -2007057244 
if(c == 3)//1
{ 

//#if -132698836 
return Integer.class;
//#endif 

} 

//#endif 


//#if -2006133723 
if(c == 4)//1
{ 

//#if 690560441 
return String.class;
//#endif 

} 

//#endif 


//#if -2005210202 
if(c == 5)//1
{ 

//#if -583492663 
return String.class;
//#endif 

} 

//#endif 


//#if 712851045 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if -842938961 
public Critic getCriticAtRow(int row)
    { 

//#if -973885108 
return critics.get(row);
//#endif 

} 

//#endif 


//#if -357623404 
public void vetoableChange(PropertyChangeEvent pce)
    { 

//#if -1151925187 
SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                fireTableStructureChanged();
            }
        });
//#endif 

} 

//#endif 


//#if -575426684 
public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    { 

//#if -1211186509 
LOG.debug("setting table value " + rowIndex + ", " + columnIndex);
//#endif 


//#if 1846007705 
if(columnIndex != 0)//1
{ 

//#if -1445779989 
return;
//#endif 

} 

//#endif 


//#if -181136315 
if(!(aValue instanceof Boolean))//1
{ 

//#if 1725833179 
return;
//#endif 

} 

//#endif 


//#if 853311430 
Boolean enable = (Boolean) aValue;
//#endif 


//#if -233187437 
Critic cr = critics.get(rowIndex);
//#endif 


//#if 1140900395 
cr.setEnabled(enable.booleanValue());
//#endif 


//#if -891242126 
fireTableRowsUpdated(rowIndex, rowIndex);
//#endif 

} 

//#endif 


//#if -145369596 
private String listToString(List l)
    { 

//#if -508900699 
StringBuffer buf = new StringBuffer();
//#endif 


//#if 1816450535 
Iterator i = l.iterator();
//#endif 


//#if -1891315959 
boolean hasNext = i.hasNext();
//#endif 


//#if -55885187 
while (hasNext) //1
{ 

//#if -1240541431 
Object o = i.next();
//#endif 


//#if -1942671358 
buf.append(String.valueOf(o));
//#endif 


//#if -670558162 
hasNext = i.hasNext();
//#endif 


//#if -932570634 
if(hasNext)//1
{ 

//#if -1473437955 
buf.append(", ");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 322943490 
return buf.toString();
//#endif 

} 

//#endif 


//#if 596179887 
public boolean isCellEditable(int row, int col)
    { 

//#if -385706964 
return col == 0;
//#endif 

} 

//#endif 


//#if 1006474410 
public Object getValueAt(int row, int col)
    { 

//#if 1132148167 
Critic cr = critics.get(row);
//#endif 


//#if 737604141 
if(col == 0)//1
{ 

//#if 236098430 
return cr.isEnabled() ? Boolean.TRUE : Boolean.FALSE;
//#endif 

} 

//#endif 


//#if 738527662 
if(col == 1)//1
{ 

//#if -1020299145 
return cr.getHeadline();
//#endif 

} 

//#endif 


//#if 739451183 
if(col == 2)//1
{ 

//#if 1180653524 
return cr.isActive() ? "no" : "yes";
//#endif 

} 

//#endif 


//#if 740374704 
if(col == 3)//1
{ 

//#if -1807381825 
return cr.getPriority();
//#endif 

} 

//#endif 


//#if 741298225 
if(col == 4)//1
{ 

//#if -2133750333 
return listToString(cr.getSupportedDecisions());
//#endif 

} 

//#endif 


//#if 742221746 
if(col == 5)//1
{ 

//#if -618830113 
return listToString(cr.getKnowledgeTypes());
//#endif 

} 

//#endif 


//#if 292576366 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if -1218159512 
public TableModelCritics(boolean advancedMode)
    { 

//#if 1095944027 
critics = new ArrayList<Critic>(Agency.getCriticList());
//#endif 


//#if 1581421117 
Collections.sort(critics, new Comparator<Critic>() {
            public int compare(Critic o1, Critic o2) {
                return o1.getHeadline().compareTo(o2.getHeadline());
            }
        });
//#endif 


//#if 1895631575 
advanced = advancedMode;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

