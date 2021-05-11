// Compilation Unit of /TabChecklist.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.checklist.ui;
//#endif 


//#if COGNITIVE 
import java.awt.BorderLayout;
//#endif 


//#if COGNITIVE 
import java.awt.Dimension;
//#endif 


//#if COGNITIVE 
import java.awt.Font;
//#endif 


//#if COGNITIVE 
import java.awt.event.ActionEvent;
//#endif 


//#if COGNITIVE 
import java.awt.event.ActionListener;
//#endif 


//#if COGNITIVE 
import java.awt.event.ComponentEvent;
//#endif 


//#if COGNITIVE 
import java.awt.event.ComponentListener;
//#endif 


//#if COGNITIVE 
import java.beans.PropertyChangeEvent;
//#endif 


//#if COGNITIVE 
import java.beans.PropertyChangeListener;
//#endif 


//#if COGNITIVE 
import java.beans.VetoableChangeListener;
//#endif 


//#if COGNITIVE 
import javax.swing.JLabel;
//#endif 


//#if COGNITIVE 
import javax.swing.JScrollPane;
//#endif 


//#if COGNITIVE 
import javax.swing.JTable;
//#endif 


//#if COGNITIVE 
import javax.swing.SwingUtilities;
//#endif 


//#if COGNITIVE 
import javax.swing.event.ListSelectionEvent;
//#endif 


//#if COGNITIVE 
import javax.swing.event.ListSelectionListener;
//#endif 


//#if COGNITIVE 
import javax.swing.table.AbstractTableModel;
//#endif 


//#if COGNITIVE 
import javax.swing.table.TableColumn;
//#endif 


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
import org.apache.log4j.Logger;
//#endif 


//#if COGNITIVE 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Translator;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.checklist.CheckItem;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.checklist.CheckManager;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.checklist.Checklist;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.checklist.ChecklistStatus;
//#endif 


//#if COGNITIVE 
import org.argouml.model.Model;
//#endif 


//#if COGNITIVE 
import org.argouml.swingext.UpArrowIcon;
//#endif 


//#if COGNITIVE 
import org.argouml.ui.LookAndFeelMgr;
//#endif 


//#if COGNITIVE 
import org.argouml.ui.TabModelTarget;
//#endif 


//#if COGNITIVE 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if COGNITIVE 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if COGNITIVE 
public class TabChecklist extends AbstractArgoJPanel
 implements TabModelTarget
, ActionListener
, ListSelectionListener
, ComponentListener
  { 
private Object target;
private TableModelChecklist tableModel = null;
private boolean shouldBeEnabled = false;
private JTable table = new JTable(10, 2);
public void componentHidden(ComponentEvent e)
    { 
setTargetInternal(null);
} 

public void targetAdded(TargetEvent e)
    { 
} 

public void targetRemoved(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 

public void resizeColumns()
    { 
TableColumn checkCol = table.getColumnModel().getColumn(0);
TableColumn descCol = table.getColumnModel().getColumn(1);
checkCol.setMinWidth(20);
checkCol.setMaxWidth(30);
checkCol.setWidth(30);
descCol.setPreferredWidth(900);
table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
table.sizeColumnsToFit(0);
validate();
} 

public boolean shouldBeEnabled(Object t)
    { 
t = findTarget(t);
if(t == null)//1
{ 
shouldBeEnabled = false;
return shouldBeEnabled;
} 

shouldBeEnabled = true;
Checklist cl = CheckManager.getChecklistFor(t);
if(cl == null)//1
{ 
shouldBeEnabled = false;
return shouldBeEnabled;
} 

return shouldBeEnabled;
} 

public void setTarget(Object t)
    { 
target = findTarget(t);
if(target == null)//1
{ 
shouldBeEnabled = false;
return;
} 

shouldBeEnabled = true;
if(isVisible())//1
{ 
setTargetInternal(target);
} 

} 

public void valueChanged(ListSelectionEvent lse)
    { 
} 

public void componentMoved(ComponentEvent e)
    { 
} 

public void componentShown(ComponentEvent e)
    { 
setTargetInternal(target);
} 

public Object getTarget()
    { 
return target;
} 

public void actionPerformed(ActionEvent ae)
    { 
} 

public void componentResized(ComponentEvent e)
    { 
} 

public void refresh()
    { 
setTarget(target);
} 

private Object findTarget(Object t)
    { 
if(t instanceof Fig)//1
{ 
Fig f = (Fig) t;
t = f.getOwner();
} 

return t;
} 

public void targetSet(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 

private void setTargetInternal(Object t)
    { 
if(t == null)//1
{ 
return;
} 

Checklist cl = CheckManager.getChecklistFor(t);
if(cl == null)//1
{ 
target = null;
shouldBeEnabled = false;
return;
} 

tableModel.setTarget(t);
resizeColumns();
} 

public TabChecklist()
    { 
super("tab.checklist");
setIcon(new UpArrowIcon());
tableModel = new TableModelChecklist(this);
table.setModel(tableModel);
Font labelFont = LookAndFeelMgr.getInstance().getStandardFont();
table.setFont(labelFont);
table.setIntercellSpacing(new Dimension(0, 1));
table.setShowVerticalLines(false);
table.getSelectionModel().addListSelectionListener(this);
table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
TableColumn checkCol = table.getColumnModel().getColumn(0);
TableColumn descCol = table.getColumnModel().getColumn(1);
checkCol.setMinWidth(20);
checkCol.setMaxWidth(30);
checkCol.setWidth(30);
descCol.setPreferredWidth(900);
table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
table.sizeColumnsToFit(-1);
JScrollPane sp = new JScrollPane(table);
setLayout(new BorderLayout());
add(new JLabel(Translator.localize("tab.checklist.warning")),
            BorderLayout.NORTH);
add(sp, BorderLayout.CENTER);
addComponentListener(this);
} 

 } 

//#endif 


//#if COGNITIVE 
class TableModelChecklist extends AbstractTableModel
 implements VetoableChangeListener
, PropertyChangeListener
  { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
private static final Logger LOG =
        Logger.getLogger(TableModelChecklist.class);
//#endif 

private Object target;
private TabChecklist panel;
@Override
    public boolean isCellEditable(int row, int col)
    { 
return col == 0;
} 

public Object getValueAt(int row, int col)
    { 
Checklist cl = CheckManager.getChecklistFor(target);
if(cl == null)//1
{ 
return "no checklist";
} 

CheckItem ci = cl.get(row);
if(col == 0)//1
{ 
ChecklistStatus stat = CheckManager.getStatusFor(target);
return (stat.contains(ci)) ? Boolean.TRUE : Boolean.FALSE;
} 
else

//#if COGNITIVE 
if(col == 1)//1
{ 
return ci.getDescription(target);
} 
else
{ 
return "CL-" + row * 2 + col;
} 

//#endif 


} 

public int getColumnCount()
    { 
return 2;
} 

@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug("setting table value " + rowIndex + ", " + columnIndex);
//#endif 

if(columnIndex != 0)//1
{ 
return;
} 

if(!(aValue instanceof Boolean))//1
{ 
return;
} 

boolean val = ((Boolean) aValue).booleanValue();
Checklist cl = CheckManager.getChecklistFor(target);
if(cl == null)//1
{ 
return;
} 

CheckItem ci = cl.get(rowIndex);
if(columnIndex == 0)//1
{ 
ChecklistStatus stat = CheckManager.getStatusFor(target);
if(val)//1
{ 
stat.add(ci);
} 
else
{ 
stat.remove(ci);
} 

} 

} 

public void setTarget(Object t)
    { 
if(Model.getFacade().isAElement(target))//1
{ 
Model.getPump().removeModelEventListener(this, target);
} 

target = t;
if(Model.getFacade().isAElement(target))//2
{ 
Model.getPump().addModelEventListener(this, target, "name");
} 

fireTableStructureChanged();
} 

public TableModelChecklist(TabChecklist tc)
    { 
panel = tc;
} 

public void vetoableChange(PropertyChangeEvent pce)
    { 
SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                fireTableStructureChanged();
                panel.resizeColumns();
            }
        });
} 

public void propertyChange(PropertyChangeEvent evt)
    { 
fireTableStructureChanged();
panel.resizeColumns();
} 

@Override
    public String  getColumnName(int c)
    { 
if(c == 0)//1
{ 
return "X";
} 

if(c == 1)//1
{ 
return Translator.localize("tab.checklist.description");
} 

return "XXX";
} 

public int getRowCount()
    { 
if(target == null)//1
{ 
return 0;
} 

Checklist cl = CheckManager.getChecklistFor(target);
if(cl == null)//1
{ 
return 0;
} 

return cl.size();
} 

public Class getColumnClass(int c)
    { 
if(c == 0)//1
{ 
return Boolean.class;
} 
else

//#if COGNITIVE 
if(c == 1)//1
{ 
return String.class;
} 
else
{ 
return String.class;
} 

//#endif 


} 

 } 

//#endif 


