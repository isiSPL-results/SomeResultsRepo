package org.argouml.uml.ui;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Collection;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import org.apache.log4j.Logger;
import org.argouml.application.api.AbstractArgoJPanel;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.model.InvalidElementException;
import org.argouml.model.Model;
import org.argouml.swingext.UpArrowIcon;
import org.argouml.ui.LookAndFeelMgr;
import org.argouml.ui.TabModelTarget;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewTagDefinition;
import org.argouml.uml.ui.foundation.extension_mechanisms.UMLTagDefinitionComboBoxModel;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.undo.UndoableAction;
import org.tigris.toolbar.ToolBar;
class ActionRemoveTaggedValue extends UndoableAction
  { 
private static final long serialVersionUID = 8276763533039642549L;
private JTable table;
public ActionRemoveTaggedValue(JTable tableTv)
    { 
super(Translator.localize("button.delete"),
              ResourceLoaderWrapper.lookupIcon("Delete"));
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("button.delete"));
table = tableTv;
} 
@Override
    public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
TabTaggedValuesModel model = (TabTaggedValuesModel) table.getModel();
model.removeRow(table.getSelectedRow());
} 

 } 
public class TabTaggedValues extends AbstractArgoJPanel
 implements TabModelTarget
,ListSelectionListener
,ComponentListener
  { 
private static final Logger LOG = Logger.getLogger(TabTaggedValues.class);
private static final long serialVersionUID = -8566948113385239423L;
private Object target;
private boolean shouldBeEnabled = false;
private JTable table = new JTable(10, 2);
private JLabel titleLabel;
private JToolBar buttonPanel;
private UMLComboBox2 tagDefinitionsComboBox;
private UMLComboBoxModel2 tagDefinitionsComboBoxModel;
public void refresh()
    { 
setTarget(target);
} 
public void componentHidden(ComponentEvent e)
    { 
stopEditing();
setTargetInternal(null);
} 
public TabTaggedValues()
    { 
super("tab.tagged-values");
setIcon(new UpArrowIcon());
buttonPanel = new ToolBar();
buttonPanel.setName(getTitle());
buttonPanel.setFloatable(false);
JButton b = new JButton();
buttonPanel.add(b);
b.setAction(new ActionNewTagDefinition());
b.setText("");
b.setFocusable(false);
b = new JButton();
buttonPanel.add(b);
b.setToolTipText(Translator.localize("button.delete"));
b.setAction(new ActionRemoveTaggedValue(table));
b.setText("");
b.setFocusable(false);
table.setModel(new TabTaggedValuesModel());
table.setRowSelectionAllowed(false);
tagDefinitionsComboBoxModel = new UMLTagDefinitionComboBoxModel();
tagDefinitionsComboBox = new UMLComboBox2(tagDefinitionsComboBoxModel);
Class tagDefinitionClass = (Class) Model.getMetaTypes()
                                   .getTagDefinition();
tagDefinitionsComboBox.setRenderer(new UMLListCellRenderer2(false));
table.setDefaultEditor(tagDefinitionClass,
                               new DefaultCellEditor(tagDefinitionsComboBox));
table.setDefaultRenderer(tagDefinitionClass,
                                 new UMLTableCellRenderer());
table.getSelectionModel().addListSelectionListener(this);
JScrollPane sp = new JScrollPane(table);
Font labelFont = LookAndFeelMgr.getInstance().getStandardFont();
table.setFont(labelFont);
titleLabel = new JLabel("none");
resizeColumns();
setLayout(new BorderLayout());
titleLabel.setLabelFor(buttonPanel);
JPanel topPane = new JPanel(new BorderLayout());
topPane.add(titleLabel, BorderLayout.WEST);
topPane.add(buttonPanel, BorderLayout.CENTER);
add(topPane, BorderLayout.NORTH);
add(sp, BorderLayout.CENTER);
addComponentListener(this);
} 
public void setTarget(Object theTarget)
    { 
stopEditing();
Object t = (theTarget instanceof Fig)
                   ? ((Fig) theTarget).getOwner() : theTarget;
if(!(Model.getFacade().isAModelElement(t)))//1
{ 
target = null;
shouldBeEnabled = false;
return;
} 
target = t;
shouldBeEnabled = true;
if(isVisible())//1
{ 
setTargetInternal(target);
} 
} 
private void setTargetInternal(Object t)
    { 
tagDefinitionsComboBoxModel.setTarget(t);
table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
((TabTaggedValuesModel) table.getModel()).setTarget(t);
table.sizeColumnsToFit(0);
if(t != null)//1
{ 
titleLabel.setText("Target: "
                               + Model.getFacade().getUMLClassName(t)
                               + " ("
                               + Model.getFacade().getName(t) + ")");
} 
else
{ 
titleLabel.setText("none");
} 
validate();
} 
public boolean shouldBeEnabled(Object theTarget)
    { 
Object t = (theTarget instanceof Fig)
                   ? ((Fig) theTarget).getOwner() : theTarget;
if(!(Model.getFacade().isAModelElement(t)))//1
{ 
shouldBeEnabled = false;
return shouldBeEnabled;
} 
shouldBeEnabled = true;
return true;
} 
public void targetAdded(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
public void resizeColumns()
    { 
TableColumn keyCol = table.getColumnModel().getColumn(0);
TableColumn valCol = table.getColumnModel().getColumn(1);
keyCol.setMinWidth(50);
keyCol.setWidth(150);
keyCol.setPreferredWidth(150);
valCol.setMinWidth(250);
valCol.setWidth(550);
valCol.setPreferredWidth(550);
table.doLayout();
} 
public void targetSet(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
private void stopEditing()
    { 
if(table.isEditing())//1
{ 
TableCellEditor ce = table.getCellEditor();
try//1
{ 
if(ce != null && !ce.stopCellEditing())//1
{ 
ce.cancelCellEditing();
} 
} 
catch (InvalidElementException e) //1
{ 
LOG.warn("failed to cancel editing - "
                         + "model element deleted while edit in progress");
} 
} 
} 
protected JTable getTable()
    { 
return table;
} 
public void valueChanged(ListSelectionEvent e)
    { 
if(!e.getValueIsAdjusting())//1
{ 
DefaultListSelectionModel sel =
                (DefaultListSelectionModel) e.getSource();
Collection tvs =
                Model.getFacade().getTaggedValuesCollection(target);
int index = sel.getLeadSelectionIndex();
if(index >= 0 && index < tvs.size())//1
{ 
Object tagDef = Model.getFacade().getTagDefinition(
                                    TabTaggedValuesModel.getFromCollection(tvs, index));
tagDefinitionsComboBoxModel.setSelectedItem(tagDef);
} 
} 
} 
protected TabTaggedValuesModel getTableModel()
    { 
return (TabTaggedValuesModel) table.getModel();
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
public void targetRemoved(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
public void componentResized(ComponentEvent e)
    { 
} 

 } 
