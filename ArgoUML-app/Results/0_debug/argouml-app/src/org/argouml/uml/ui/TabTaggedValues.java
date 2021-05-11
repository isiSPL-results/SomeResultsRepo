
//#if -83369819 
// Compilation Unit of /TabTaggedValues.java 
 

//#if -1192455364 
package org.argouml.uml.ui;
//#endif 


//#if 1556580320 
import java.awt.BorderLayout;
//#endif 


//#if -1145451481 
import java.awt.Font;
//#endif 


//#if 1765032720 
import java.awt.event.ActionEvent;
//#endif 


//#if -798558907 
import java.awt.event.ComponentEvent;
//#endif 


//#if -1293831389 
import java.awt.event.ComponentListener;
//#endif 


//#if -1461709434 
import java.util.Collection;
//#endif 


//#if 152133766 
import javax.swing.Action;
//#endif 


//#if -1851757238 
import javax.swing.DefaultCellEditor;
//#endif 


//#if -2071384834 
import javax.swing.DefaultListSelectionModel;
//#endif 


//#if -257307682 
import javax.swing.JButton;
//#endif 


//#if -1126503278 
import javax.swing.JLabel;
//#endif 


//#if -1011629182 
import javax.swing.JPanel;
//#endif 


//#if -1839913701 
import javax.swing.JScrollPane;
//#endif 


//#if -897463560 
import javax.swing.JTable;
//#endif 


//#if 737271371 
import javax.swing.JToolBar;
//#endif 


//#if -1256065732 
import javax.swing.event.ListSelectionEvent;
//#endif 


//#if 1346542540 
import javax.swing.event.ListSelectionListener;
//#endif 


//#if 827042877 
import javax.swing.table.TableCellEditor;
//#endif 


//#if 278432694 
import javax.swing.table.TableColumn;
//#endif 


//#if -643620552 
import org.apache.log4j.Logger;
//#endif 


//#if 1403319328 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if 1543335396 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 2075395941 
import org.argouml.i18n.Translator;
//#endif 


//#if -437134614 
import org.argouml.model.InvalidElementException;
//#endif 


//#if 1203915947 
import org.argouml.model.Model;
//#endif 


//#if 1909792171 
import org.argouml.swingext.UpArrowIcon;
//#endif 


//#if -922823621 
import org.argouml.ui.LookAndFeelMgr;
//#endif 


//#if -428983536 
import org.argouml.ui.TabModelTarget;
//#endif 


//#if 646053834 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if 1634261491 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewTagDefinition;
//#endif 


//#if 1750649741 
import org.argouml.uml.ui.foundation.extension_mechanisms.UMLTagDefinitionComboBoxModel;
//#endif 


//#if 2033888162 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -755290 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 1111414198 
import org.tigris.toolbar.ToolBar;
//#endif 


//#if -1919249051 
class ActionRemoveTaggedValue extends 
//#if -567719898 
UndoableAction
//#endif 

  { 

//#if -330975693 
private static final long serialVersionUID = 8276763533039642549L;
//#endif 


//#if -1391550174 
private JTable table;
//#endif 


//#if -261407947 
public ActionRemoveTaggedValue(JTable tableTv)
    { 

//#if -1098199481 
super(Translator.localize("button.delete"),
              ResourceLoaderWrapper.lookupIcon("Delete"));
//#endif 


//#if -1071773380 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("button.delete"));
//#endif 


//#if -1402286712 
table = tableTv;
//#endif 

} 

//#endif 


//#if 1461983795 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if -1628782969 
super.actionPerformed(e);
//#endif 


//#if -1073411149 
TabTaggedValuesModel model = (TabTaggedValuesModel) table.getModel();
//#endif 


//#if 154937202 
model.removeRow(table.getSelectedRow());
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 138561286 
public class TabTaggedValues extends 
//#if -568149205 
AbstractArgoJPanel
//#endif 

 implements 
//#if -1258686021 
TabModelTarget
//#endif 

, 
//#if -1957019092 
ListSelectionListener
//#endif 

, 
//#if -1742224741 
ComponentListener
//#endif 

  { 

//#if 1779262307 
private static final Logger LOG = Logger.getLogger(TabTaggedValues.class);
//#endif 


//#if -1705990442 
private static final long serialVersionUID = -8566948113385239423L;
//#endif 


//#if 658920894 
private Object target;
//#endif 


//#if 1451480037 
private boolean shouldBeEnabled = false;
//#endif 


//#if -1380311173 
private JTable table = new JTable(10, 2);
//#endif 


//#if 940943592 
private JLabel titleLabel;
//#endif 


//#if 603075111 
private JToolBar buttonPanel;
//#endif 


//#if -142103734 
private UMLComboBox2 tagDefinitionsComboBox;
//#endif 


//#if 380370690 
private UMLComboBoxModel2 tagDefinitionsComboBoxModel;
//#endif 


//#if 990542249 
public void refresh()
    { 

//#if -1364681844 
setTarget(target);
//#endif 

} 

//#endif 


//#if -1904269387 
public void componentHidden(ComponentEvent e)
    { 

//#if -246516670 
stopEditing();
//#endif 


//#if -557742321 
setTargetInternal(null);
//#endif 

} 

//#endif 


//#if -868405979 
public TabTaggedValues()
    { 

//#if -244289446 
super("tab.tagged-values");
//#endif 


//#if 1717640908 
setIcon(new UpArrowIcon());
//#endif 


//#if -1811526513 
buttonPanel = new ToolBar();
//#endif 


//#if 1834318737 
buttonPanel.setName(getTitle());
//#endif 


//#if -2032846174 
buttonPanel.setFloatable(false);
//#endif 


//#if -1282189812 
JButton b = new JButton();
//#endif 


//#if 657772460 
buttonPanel.add(b);
//#endif 


//#if 355377973 
b.setAction(new ActionNewTagDefinition());
//#endif 


//#if -1565868068 
b.setText("");
//#endif 


//#if -152814354 
b.setFocusable(false);
//#endif 


//#if -2097296322 
b = new JButton();
//#endif 


//#if 2058598182 
buttonPanel.add(b);
//#endif 


//#if -682523118 
b.setToolTipText(Translator.localize("button.delete"));
//#endif 


//#if -695990583 
b.setAction(new ActionRemoveTaggedValue(table));
//#endif 


//#if -1135765258 
b.setText("");
//#endif 


//#if 172960420 
b.setFocusable(false);
//#endif 


//#if 1004112413 
table.setModel(new TabTaggedValuesModel());
//#endif 


//#if -2018546426 
table.setRowSelectionAllowed(false);
//#endif 


//#if 1815149227 
tagDefinitionsComboBoxModel = new UMLTagDefinitionComboBoxModel();
//#endif 


//#if -380960036 
tagDefinitionsComboBox = new UMLComboBox2(tagDefinitionsComboBoxModel);
//#endif 


//#if -1845808269 
Class tagDefinitionClass = (Class) Model.getMetaTypes()
                                   .getTagDefinition();
//#endif 


//#if -1906885650 
tagDefinitionsComboBox.setRenderer(new UMLListCellRenderer2(false));
//#endif 


//#if -378185014 
table.setDefaultEditor(tagDefinitionClass,
                               new DefaultCellEditor(tagDefinitionsComboBox));
//#endif 


//#if 1848539698 
table.setDefaultRenderer(tagDefinitionClass,
                                 new UMLTableCellRenderer());
//#endif 


//#if -1210101352 
table.getSelectionModel().addListSelectionListener(this);
//#endif 


//#if -237990947 
JScrollPane sp = new JScrollPane(table);
//#endif 


//#if -1601336768 
Font labelFont = LookAndFeelMgr.getInstance().getStandardFont();
//#endif 


//#if -1626064839 
table.setFont(labelFont);
//#endif 


//#if -1333881580 
titleLabel = new JLabel("none");
//#endif 


//#if 1543181430 
resizeColumns();
//#endif 


//#if 1860871176 
setLayout(new BorderLayout());
//#endif 


//#if 1575023814 
titleLabel.setLabelFor(buttonPanel);
//#endif 


//#if -1365016580 
JPanel topPane = new JPanel(new BorderLayout());
//#endif 


//#if 260293606 
topPane.add(titleLabel, BorderLayout.WEST);
//#endif 


//#if -111823192 
topPane.add(buttonPanel, BorderLayout.CENTER);
//#endif 


//#if -464628518 
add(topPane, BorderLayout.NORTH);
//#endif 


//#if -1263806468 
add(sp, BorderLayout.CENTER);
//#endif 


//#if 1578670819 
addComponentListener(this);
//#endif 

} 

//#endif 


//#if -228316498 
public void setTarget(Object theTarget)
    { 

//#if -2094002820 
stopEditing();
//#endif 


//#if -1714435993 
Object t = (theTarget instanceof Fig)
                   ? ((Fig) theTarget).getOwner() : theTarget;
//#endif 


//#if -1258738430 
if(!(Model.getFacade().isAModelElement(t)))//1
{ 

//#if -729337753 
target = null;
//#endif 


//#if 502295017 
shouldBeEnabled = false;
//#endif 


//#if 1506700172 
return;
//#endif 

} 

//#endif 


//#if -468002821 
target = t;
//#endif 


//#if -499831037 
shouldBeEnabled = true;
//#endif 


//#if -1342417154 
if(isVisible())//1
{ 

//#if -1140109816 
setTargetInternal(target);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1693747379 
private void setTargetInternal(Object t)
    { 

//#if 1561743581 
tagDefinitionsComboBoxModel.setTarget(t);
//#endif 


//#if 1881967320 
table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//#endif 


//#if 747296833 
((TabTaggedValuesModel) table.getModel()).setTarget(t);
//#endif 


//#if 962841056 
table.sizeColumnsToFit(0);
//#endif 


//#if -1383958048 
if(t != null)//1
{ 

//#if 799556471 
titleLabel.setText("Target: "
                               + Model.getFacade().getUMLClassName(t)
                               + " ("
                               + Model.getFacade().getName(t) + ")");
//#endif 

} 
else
{ 

//#if -2017162386 
titleLabel.setText("none");
//#endif 

} 

//#endif 


//#if 1162814424 
validate();
//#endif 

} 

//#endif 


//#if -152533332 
public boolean shouldBeEnabled(Object theTarget)
    { 

//#if 725171685 
Object t = (theTarget instanceof Fig)
                   ? ((Fig) theTarget).getOwner() : theTarget;
//#endif 


//#if 1013560772 
if(!(Model.getFacade().isAModelElement(t)))//1
{ 

//#if -1939314606 
shouldBeEnabled = false;
//#endif 


//#if -462000248 
return shouldBeEnabled;
//#endif 

} 

//#endif 


//#if -1930223615 
shouldBeEnabled = true;
//#endif 


//#if -562109021 
return true;
//#endif 

} 

//#endif 


//#if 1105139873 
public void targetAdded(TargetEvent e)
    { 

//#if -733213069 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -1017416169 
public void resizeColumns()
    { 

//#if 1282475083 
TableColumn keyCol = table.getColumnModel().getColumn(0);
//#endif 


//#if -460732722 
TableColumn valCol = table.getColumnModel().getColumn(1);
//#endif 


//#if -1714546641 
keyCol.setMinWidth(50);
//#endif 


//#if -1829425302 
keyCol.setWidth(150);
//#endif 


//#if 839014093 
keyCol.setPreferredWidth(150);
//#endif 


//#if 1984776667 
valCol.setMinWidth(250);
//#endif 


//#if 227658160 
valCol.setWidth(550);
//#endif 


//#if 1506353871 
valCol.setPreferredWidth(550);
//#endif 


//#if -290835864 
table.doLayout();
//#endif 

} 

//#endif 


//#if 828014467 
public void targetSet(TargetEvent e)
    { 

//#if 24684990 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 768170326 
private void stopEditing()
    { 

//#if 1445411642 
if(table.isEditing())//1
{ 

//#if -779589769 
TableCellEditor ce = table.getCellEditor();
//#endif 


//#if 304352378 
try //1
{ 

//#if -165969704 
if(ce != null && !ce.stopCellEditing())//1
{ 

//#if 1101481002 
ce.cancelCellEditing();
//#endif 

} 

//#endif 

} 

//#if -1967691765 
catch (InvalidElementException e) //1
{ 

//#if -1746178862 
LOG.warn("failed to cancel editing - "
                         + "model element deleted while edit in progress");
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 1403665749 
protected JTable getTable()
    { 

//#if -4335946 
return table;
//#endif 

} 

//#endif 


//#if 1351747522 
public void valueChanged(ListSelectionEvent e)
    { 

//#if -1742436397 
if(!e.getValueIsAdjusting())//1
{ 

//#if -1614353998 
DefaultListSelectionModel sel =
                (DefaultListSelectionModel) e.getSource();
//#endif 


//#if 1712081599 
Collection tvs =
                Model.getFacade().getTaggedValuesCollection(target);
//#endif 


//#if -1615564122 
int index = sel.getLeadSelectionIndex();
//#endif 


//#if -216753551 
if(index >= 0 && index < tvs.size())//1
{ 

//#if -596719898 
Object tagDef = Model.getFacade().getTagDefinition(
                                    TabTaggedValuesModel.getFromCollection(tvs, index));
//#endif 


//#if -694318799 
tagDefinitionsComboBoxModel.setSelectedItem(tagDef);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 3886644 
protected TabTaggedValuesModel getTableModel()
    { 

//#if -430110614 
return (TabTaggedValuesModel) table.getModel();
//#endif 

} 

//#endif 


//#if 59242720 
public void componentMoved(ComponentEvent e)
    { 
} 

//#endif 


//#if -1598260670 
public void componentShown(ComponentEvent e)
    { 

//#if 1354960902 
setTargetInternal(target);
//#endif 

} 

//#endif 


//#if -1474608598 
public Object getTarget()
    { 

//#if 1944681174 
return target;
//#endif 

} 

//#endif 


//#if -617051903 
public void targetRemoved(TargetEvent e)
    { 

//#if -433910863 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -520936317 
public void componentResized(ComponentEvent e)
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

