
//#if 881330199 
// Compilation Unit of /TabChecklist.java 
 

//#if 1563189978 
package org.argouml.cognitive.checklist.ui;
//#endif 


//#if -1759867072 
import java.awt.BorderLayout;
//#endif 


//#if -670243142 
import java.awt.Dimension;
//#endif 


//#if -742771833 
import java.awt.Font;
//#endif 


//#if 1082054576 
import java.awt.event.ActionEvent;
//#endif 


//#if 509031640 
import java.awt.event.ActionListener;
//#endif 


//#if -2140365659 
import java.awt.event.ComponentEvent;
//#endif 


//#if -1798156349 
import java.awt.event.ComponentListener;
//#endif 


//#if 213690406 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -339933022 
import java.beans.PropertyChangeListener;
//#endif 


//#if -2030359341 
import java.beans.VetoableChangeListener;
//#endif 


//#if 198451506 
import javax.swing.JLabel;
//#endif 


//#if -2080123781 
import javax.swing.JScrollPane;
//#endif 


//#if 427491224 
import javax.swing.JTable;
//#endif 


//#if -1987150992 
import javax.swing.SwingUtilities;
//#endif 


//#if -1103937060 
import javax.swing.event.ListSelectionEvent;
//#endif 


//#if -2073654484 
import javax.swing.event.ListSelectionListener;
//#endif 


//#if 1840790047 
import javax.swing.table.AbstractTableModel;
//#endif 


//#if -1063374058 
import javax.swing.table.TableColumn;
//#endif 


//#if -883830632 
import org.apache.log4j.Logger;
//#endif 


//#if -277415744 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if -539899431 
import org.argouml.cognitive.Translator;
//#endif 


//#if -208744656 
import org.argouml.cognitive.checklist.CheckItem;
//#endif 


//#if -652804730 
import org.argouml.cognitive.checklist.CheckManager;
//#endif 


//#if -176735451 
import org.argouml.cognitive.checklist.Checklist;
//#endif 


//#if 909814227 
import org.argouml.cognitive.checklist.ChecklistStatus;
//#endif 


//#if 963705867 
import org.argouml.model.Model;
//#endif 


//#if 1405467211 
import org.argouml.swingext.UpArrowIcon;
//#endif 


//#if 2030336923 
import org.argouml.ui.LookAndFeelMgr;
//#endif 


//#if -1770790288 
import org.argouml.ui.TabModelTarget;
//#endif 


//#if 1994128490 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if 1047788290 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 974610414 
public class TabChecklist extends 
//#if -901547379 
AbstractArgoJPanel
//#endif 

 implements 
//#if -812271075 
TabModelTarget
//#endif 

, 
//#if -108041246 
ActionListener
//#endif 

, 
//#if 37334922 
ListSelectionListener
//#endif 

, 
//#if 186683129 
ComponentListener
//#endif 

  { 

//#if -1909144416 
private Object target;
//#endif 


//#if 199773522 
private TableModelChecklist tableModel = null;
//#endif 


//#if 1422671559 
private boolean shouldBeEnabled = false;
//#endif 


//#if -1658335143 
private JTable table = new JTable(10, 2);
//#endif 


//#if -1097834217 
public void componentHidden(ComponentEvent e)
    { 

//#if -1117499552 
setTargetInternal(null);
//#endif 

} 

//#endif 


//#if 827115903 
public void targetAdded(TargetEvent e)
    { 
} 

//#endif 


//#if -1510114721 
public void targetRemoved(TargetEvent e)
    { 

//#if 1028195411 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -1209465739 
public void resizeColumns()
    { 

//#if 1673216006 
TableColumn checkCol = table.getColumnModel().getColumn(0);
//#endif 


//#if 964740890 
TableColumn descCol = table.getColumnModel().getColumn(1);
//#endif 


//#if 768808041 
checkCol.setMinWidth(20);
//#endif 


//#if -1053468326 
checkCol.setMaxWidth(30);
//#endif 


//#if 471237164 
checkCol.setWidth(30);
//#endif 


//#if -1293772644 
descCol.setPreferredWidth(900);
//#endif 


//#if 1183598555 
table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
//#endif 


//#if -2086854653 
table.sizeColumnsToFit(0);
//#endif 


//#if -1177113579 
validate();
//#endif 

} 

//#endif 


//#if 770872376 
public boolean shouldBeEnabled(Object t)
    { 

//#if 810730907 
t = findTarget(t);
//#endif 


//#if -952598142 
if(t == null)//1
{ 

//#if -1032144886 
shouldBeEnabled = false;
//#endif 


//#if 445169472 
return shouldBeEnabled;
//#endif 

} 

//#endif 


//#if -1755079311 
shouldBeEnabled = true;
//#endif 


//#if 912732038 
Checklist cl = CheckManager.getChecklistFor(t);
//#endif 


//#if -1702064807 
if(cl == null)//1
{ 

//#if 1412128873 
shouldBeEnabled = false;
//#endif 


//#if -1405524065 
return shouldBeEnabled;
//#endif 

} 

//#endif 


//#if -1807298006 
return shouldBeEnabled;
//#endif 

} 

//#endif 


//#if -984558146 
public void setTarget(Object t)
    { 

//#if -1680103038 
target = findTarget(t);
//#endif 


//#if 78798393 
if(target == null)//1
{ 

//#if 1004184544 
shouldBeEnabled = false;
//#endif 


//#if -851680651 
return;
//#endif 

} 

//#endif 


//#if 2134185385 
shouldBeEnabled = true;
//#endif 


//#if 1015570968 
if(isVisible())//1
{ 

//#if 48568728 
setTargetInternal(target);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 412623719 
public void valueChanged(ListSelectionEvent lse)
    { 
} 

//#endif 


//#if 362351422 
public void componentMoved(ComponentEvent e)
    { 
} 

//#endif 


//#if -1295151968 
public void componentShown(ComponentEvent e)
    { 

//#if -1925447758 
setTargetInternal(target);
//#endif 

} 

//#endif 


//#if -455815160 
public Object getTarget()
    { 

//#if 1631116472 
return target;
//#endif 

} 

//#endif 


//#if -1336440236 
public void actionPerformed(ActionEvent ae)
    { 
} 

//#endif 


//#if -1291249823 
public void componentResized(ComponentEvent e)
    { 
} 

//#endif 


//#if -754866553 
public void refresh()
    { 

//#if -913039873 
setTarget(target);
//#endif 

} 

//#endif 


//#if 2147338088 
private Object findTarget(Object t)
    { 

//#if -1139685619 
if(t instanceof Fig)//1
{ 

//#if -310533911 
Fig f = (Fig) t;
//#endif 


//#if 1112704316 
t = f.getOwner();
//#endif 

} 

//#endif 


//#if 263708001 
return t;
//#endif 

} 

//#endif 


//#if -1348808735 
public void targetSet(TargetEvent e)
    { 

//#if 565529238 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 1708157099 
private void setTargetInternal(Object t)
    { 

//#if -1200400336 
if(t == null)//1
{ 

//#if 280933396 
return;
//#endif 

} 

//#endif 


//#if -1816157772 
Checklist cl = CheckManager.getChecklistFor(t);
//#endif 


//#if -793998229 
if(cl == null)//1
{ 

//#if -452613466 
target = null;
//#endif 


//#if -899260056 
shouldBeEnabled = false;
//#endif 


//#if -1565637139 
return;
//#endif 

} 

//#endif 


//#if 1024894198 
tableModel.setTarget(t);
//#endif 


//#if -730584759 
resizeColumns();
//#endif 

} 

//#endif 


//#if -237304365 
public TabChecklist()
    { 

//#if -861976005 
super("tab.checklist");
//#endif 


//#if 1343408904 
setIcon(new UpArrowIcon());
//#endif 


//#if -1728635892 
tableModel = new TableModelChecklist(this);
//#endif 


//#if 386153421 
table.setModel(tableModel);
//#endif 


//#if -907176828 
Font labelFont = LookAndFeelMgr.getInstance().getStandardFont();
//#endif 


//#if -1499589507 
table.setFont(labelFont);
//#endif 


//#if -1813508858 
table.setIntercellSpacing(new Dimension(0, 1));
//#endif 


//#if -89022280 
table.setShowVerticalLines(false);
//#endif 


//#if 776412636 
table.getSelectionModel().addListSelectionListener(this);
//#endif 


//#if 1223310925 
table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
//#endif 


//#if 1712928376 
TableColumn checkCol = table.getColumnModel().getColumn(0);
//#endif 


//#if -1389282712 
TableColumn descCol = table.getColumnModel().getColumn(1);
//#endif 


//#if 2107024439 
checkCol.setMinWidth(20);
//#endif 


//#if 284748072 
checkCol.setMaxWidth(30);
//#endif 


//#if 559658270 
checkCol.setWidth(30);
//#endif 


//#if 281187818 
descCol.setPreferredWidth(900);
//#endif 


//#if 858306789 
table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
//#endif 


//#if 1562669987 
table.sizeColumnsToFit(-1);
//#endif 


//#if -1074455271 
JScrollPane sp = new JScrollPane(table);
//#endif 


//#if -1444626868 
setLayout(new BorderLayout());
//#endif 


//#if -2112471309 
add(new JLabel(Translator.localize("tab.checklist.warning")),
            BorderLayout.NORTH);
//#endif 


//#if -123509448 
add(sp, BorderLayout.CENTER);
//#endif 


//#if -1432586713 
addComponentListener(this);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1170479365 
class TableModelChecklist extends 
//#if -1630597838 
AbstractTableModel
//#endif 

 implements 
//#if -1128550307 
VetoableChangeListener
//#endif 

, 
//#if -1351115090 
PropertyChangeListener
//#endif 

  { 

//#if 567688746 
private static final Logger LOG =
        Logger.getLogger(TableModelChecklist.class);
//#endif 


//#if -738236931 
private Object target;
//#endif 


//#if -1577790090 
private TabChecklist panel;
//#endif 


//#if 514218279 
@Override
    public boolean isCellEditable(int row, int col)
    { 

//#if -1956631412 
return col == 0;
//#endif 

} 

//#endif 


//#if 1653006740 
public Object getValueAt(int row, int col)
    { 

//#if -86880919 
Checklist cl = CheckManager.getChecklistFor(target);
//#endif 


//#if -1820524385 
if(cl == null)//1
{ 

//#if 692097257 
return "no checklist";
//#endif 

} 

//#endif 


//#if -100445451 
CheckItem ci = cl.get(row);
//#endif 


//#if -1298011489 
if(col == 0)//1
{ 

//#if 527565640 
ChecklistStatus stat = CheckManager.getStatusFor(target);
//#endif 


//#if 719044988 
return (stat.contains(ci)) ? Boolean.TRUE : Boolean.FALSE;
//#endif 

} 
else

//#if 1724490610 
if(col == 1)//1
{ 

//#if -1107978978 
return ci.getDescription(target);
//#endif 

} 
else
{ 

//#if 352144072 
return "CL-" + row * 2 + col;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1800181333 
public int getColumnCount()
    { 

//#if -1413422377 
return 2;
//#endif 

} 

//#endif 


//#if -1439453428 
@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    { 

//#if -186192259 
LOG.debug("setting table value " + rowIndex + ", " + columnIndex);
//#endif 


//#if -784226289 
if(columnIndex != 0)//1
{ 

//#if -133497111 
return;
//#endif 

} 

//#endif 


//#if -1332026437 
if(!(aValue instanceof Boolean))//1
{ 

//#if 62456387 
return;
//#endif 

} 

//#endif 


//#if -1726798125 
boolean val = ((Boolean) aValue).booleanValue();
//#endif 


//#if 691454481 
Checklist cl = CheckManager.getChecklistFor(target);
//#endif 


//#if -1465180345 
if(cl == null)//1
{ 

//#if 1061448568 
return;
//#endif 

} 

//#endif 


//#if 1945241129 
CheckItem ci = cl.get(rowIndex);
//#endif 


//#if -1703926997 
if(columnIndex == 0)//1
{ 

//#if -528430306 
ChecklistStatus stat = CheckManager.getStatusFor(target);
//#endif 


//#if -1750516054 
if(val)//1
{ 

//#if -1744928641 
stat.add(ci);
//#endif 

} 
else
{ 

//#if -1040949161 
stat.remove(ci);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -2017015269 
public void setTarget(Object t)
    { 

//#if -519620786 
if(Model.getFacade().isAElement(target))//1
{ 

//#if 250642540 
Model.getPump().removeModelEventListener(this, target);
//#endif 

} 

//#endif 


//#if 58679671 
target = t;
//#endif 


//#if -960624477 
if(Model.getFacade().isAElement(target))//2
{ 

//#if -1243014066 
Model.getPump().addModelEventListener(this, target, "name");
//#endif 

} 

//#endif 


//#if -610373699 
fireTableStructureChanged();
//#endif 

} 

//#endif 


//#if 1121322734 
public TableModelChecklist(TabChecklist tc)
    { 

//#if -517986910 
panel = tc;
//#endif 

} 

//#endif 


//#if 1241478762 
public void vetoableChange(PropertyChangeEvent pce)
    { 

//#if 1049802510 
SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                fireTableStructureChanged();
                panel.resizeColumns();
            }
        });
//#endif 

} 

//#endif 


//#if -656806966 
public void propertyChange(PropertyChangeEvent evt)
    { 

//#if -1889220061 
fireTableStructureChanged();
//#endif 


//#if 711905501 
panel.resizeColumns();
//#endif 

} 

//#endif 


//#if -1907569485 
@Override
    public String  getColumnName(int c)
    { 

//#if -1764613187 
if(c == 0)//1
{ 

//#if 213970543 
return "X";
//#endif 

} 

//#endif 


//#if -1763689666 
if(c == 1)//1
{ 

//#if -1893129037 
return Translator.localize("tab.checklist.description");
//#endif 

} 

//#endif 


//#if 1927227874 
return "XXX";
//#endif 

} 

//#endif 


//#if -1302866757 
public int getRowCount()
    { 

//#if -1582329576 
if(target == null)//1
{ 

//#if 921321704 
return 0;
//#endif 

} 

//#endif 


//#if 1669448314 
Checklist cl = CheckManager.getChecklistFor(target);
//#endif 


//#if -1172698640 
if(cl == null)//1
{ 

//#if -55124802 
return 0;
//#endif 

} 

//#endif 


//#if 1527803543 
return cl.size();
//#endif 

} 

//#endif 


//#if 1095812243 
public Class getColumnClass(int c)
    { 

//#if -1266146371 
if(c == 0)//1
{ 

//#if 784246931 
return Boolean.class;
//#endif 

} 
else

//#if -714221639 
if(c == 1)//1
{ 

//#if 928598313 
return String.class;
//#endif 

} 
else
{ 

//#if -1482183475 
return String.class;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

