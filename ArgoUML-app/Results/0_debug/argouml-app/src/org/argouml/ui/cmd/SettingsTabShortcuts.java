
//#if -1460987242 
// Compilation Unit of /SettingsTabShortcuts.java 
 

//#if -495062854 
package org.argouml.ui.cmd;
//#endif 


//#if 2093003792 
import java.awt.BorderLayout;
//#endif 


//#if 590046221 
import java.awt.Color;
//#endif 


//#if -1403291630 
import java.awt.GridBagConstraints;
//#endif 


//#if 1104279268 
import java.awt.GridBagLayout;
//#endif 


//#if 2119159760 
import java.awt.Insets;
//#endif 


//#if -1006684960 
import java.awt.event.ActionEvent;
//#endif 


//#if 355699112 
import java.awt.event.ActionListener;
//#endif 


//#if -1479754759 
import java.text.MessageFormat;
//#endif 


//#if -1670230516 
import javax.swing.BorderFactory;
//#endif 


//#if -1350649731 
import javax.swing.ButtonGroup;
//#endif 


//#if 425504354 
import javax.swing.JLabel;
//#endif 


//#if 138030243 
import javax.swing.JOptionPane;
//#endif 


//#if 540378450 
import javax.swing.JPanel;
//#endif 


//#if 1086492969 
import javax.swing.JRadioButton;
//#endif 


//#if -1733032629 
import javax.swing.JScrollPane;
//#endif 


//#if 654544072 
import javax.swing.JTable;
//#endif 


//#if -1794727309 
import javax.swing.KeyStroke;
//#endif 


//#if 1253404273 
import javax.swing.ListSelectionModel;
//#endif 


//#if -2047064325 
import javax.swing.SwingConstants;
//#endif 


//#if -511384820 
import javax.swing.event.ListSelectionEvent;
//#endif 


//#if -1665459204 
import javax.swing.event.ListSelectionListener;
//#endif 


//#if -1861625009 
import javax.swing.table.AbstractTableModel;
//#endif 


//#if -1097230342 
import javax.swing.table.DefaultTableCellRenderer;
//#endif 


//#if -2023553745 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if 2051493781 
import org.argouml.i18n.Translator;
//#endif 


//#if 803558381 
import org.argouml.util.KeyEventUtils;
//#endif 


//#if -928015674 
class KeyStrokeCellRenderer extends 
//#if 1876936259 
DefaultTableCellRenderer
//#endif 

  { 

//#if -2113282013 
public KeyStrokeCellRenderer()
    { 

//#if -235590045 
super();
//#endif 


//#if -1039119531 
setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//#endif 

} 

//#endif 


//#if 979765112 
@Override
    public void setValue(Object value)
    { 

//#if -1165150785 
if(value != null && value instanceof KeyStroke)//1
{ 

//#if 241115932 
value = KeyEventUtils.formatKeyStroke((KeyStroke) value);
//#endif 

} 

//#endif 


//#if -1727721935 
super.setValue(value);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1856343025 
class SettingsTabShortcuts extends 
//#if -431477405 
JPanel
//#endif 

 implements 
//#if 598955065 
GUISettingsTabInterface
//#endif 

, 
//#if -261768781 
ActionListener
//#endif 

, 
//#if 1475896473 
ListSelectionListener
//#endif 

, 
//#if 1458938841 
ShortcutChangedListener
//#endif 

  { 

//#if -752779515 
private static final long serialVersionUID = -2033414439459450620L;
//#endif 


//#if 1442828956 
private static final String NONE_NAME = Translator
                                            .localize("label.shortcut-none");
//#endif 


//#if -1056490306 
private static final String DEFAULT_NAME = Translator
            .localize("label.shortcut-default");
//#endif 


//#if 301771434 
private static final String CUSTOM_NAME = Translator
            .localize("label.shortcut-custom");
//#endif 


//#if -1117853973 
private JTable table;
//#endif 


//#if -448973495 
private JPanel selectedContainer;
//#endif 


//#if 1748587438 
private ShortcutField shortcutField = new ShortcutField("", 12);
//#endif 


//#if -861658286 
private Color shortcutFieldDefaultBg = null;
//#endif 


//#if -778358519 
private JRadioButton customButton = new JRadioButton(CUSTOM_NAME);
//#endif 


//#if 1798064615 
private JRadioButton defaultButton = new JRadioButton(DEFAULT_NAME);
//#endif 


//#if -1840021463 
private JRadioButton noneButton = new JRadioButton(NONE_NAME);
//#endif 


//#if -636464559 
private JLabel warningLabel = new JLabel(" ");
//#endif 


//#if -595085081 
private ActionWrapper target;
//#endif 


//#if 1517629826 
private ActionWrapper[] actions = ShortcutMgr.getShortcuts();
//#endif 


//#if -1002638940 
private int lastRowSelected = -1;
//#endif 


//#if -1447348770 
private final String[] columnNames = {
        Translator.localize("misc.column-name.action"),
        Translator.localize("misc.column-name.shortcut"),
        Translator.localize("misc.column-name.default")
    };
//#endif 


//#if -843265017 
private Object[][] elements;
//#endif 


//#if -300494169 
public void shortcutChange(ShortcutChangedEvent event)
    { 

//#if -75102704 
checkShortcutAlreadyAssigned(event.getKeyStroke());
//#endif 


//#if 1320963740 
setKeyStrokeValue(event.getKeyStroke());
//#endif 


//#if -1179236257 
this.selectedContainer.repaint();
//#endif 

} 

//#endif 


//#if 242527871 
public void handleSettingsTabCancel()
    { 
} 

//#endif 


//#if -1893714940 
public void actionPerformed(ActionEvent e)
    { 

//#if 2063504253 
resetKeyStrokeConflict();
//#endif 


//#if 1191468684 
if(e.getSource() == customButton)//1
{ 

//#if 162799533 
setKeyStrokeValue(ShortcutMgr.decodeKeyStroke(shortcutField
                              .getText()));
//#endif 


//#if -1944176614 
shortcutField.setEnabled(true);
//#endif 


//#if 2119178114 
shortcutField.requestFocus();
//#endif 

} 
else

//#if -215172663 
if(e.getSource() == defaultButton)//1
{ 

//#if -241575351 
setKeyStrokeValue(target.getDefaultShortcut());
//#endif 


//#if -864887054 
shortcutField.setEnabled(false);
//#endif 


//#if 48869853 
checkShortcutAlreadyAssigned(target.getDefaultShortcut());
//#endif 

} 
else

//#if 1565907616 
if(e.getSource() == noneButton)//1
{ 

//#if -1574487024 
setKeyStrokeValue(null);
//#endif 


//#if 1778549361 
shortcutField.setEnabled(false);
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if -509745702 
public JPanel getTabPanel()
    { 

//#if 743232233 
if(table == null)//1
{ 

//#if -1136985560 
setLayout(new GridBagLayout());
//#endif 


//#if -752667440 
GridBagConstraints panelConstraints = new GridBagConstraints();
//#endif 


//#if -277846331 
panelConstraints.gridx = 0;
//#endif 


//#if -277816540 
panelConstraints.gridy = 0;
//#endif 


//#if 2009274327 
panelConstraints.anchor = GridBagConstraints.NORTH;
//#endif 


//#if 1264826891 
panelConstraints.fill = GridBagConstraints.BOTH;
//#endif 


//#if 412890578 
panelConstraints.weightx = 5;
//#endif 


//#if -84374420 
panelConstraints.weighty = 15;
//#endif 


//#if -1937291596 
table = new JTable(new ShortcutTableModel());
//#endif 


//#if 5586265 
table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
//#endif 


//#if -468902351 
table.setShowVerticalLines(true);
//#endif 


//#if 1395272371 
table.setDefaultRenderer(KeyStroke.class,
                                     new KeyStrokeCellRenderer());
//#endif 


//#if -584700948 
table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//#endif 


//#if 1681653840 
table.getSelectionModel().addListSelectionListener(this);
//#endif 


//#if 1747170968 
JPanel tableContainer = new JPanel(new BorderLayout());
//#endif 


//#if 1418936437 
tableContainer.setBorder(
                BorderFactory.createTitledBorder(
                    Translator.localize(
                        "dialog.shortcut.titled-border.actions")));
//#endif 


//#if 1118441761 
tableContainer.add(new JScrollPane(table));
//#endif 


//#if 1510793993 
add(tableContainer, panelConstraints);
//#endif 


//#if -68539605 
customButton.addActionListener(this);
//#endif 


//#if 794578325 
defaultButton.addActionListener(this);
//#endif 


//#if 767596356 
noneButton.addActionListener(this);
//#endif 


//#if 1635705073 
selectedContainer = new JPanel(new GridBagLayout());
//#endif 


//#if -846724812 
selectedContainer.setBorder(
                BorderFactory.createTitledBorder(
                    Translator.localize(
                        "dialog.shortcut.titled-border.selected")));
//#endif 


//#if 1818661326 
GridBagConstraints constraints = new GridBagConstraints();
//#endif 


//#if 414064283 
constraints.gridx = 0;
//#endif 


//#if 414094074 
constraints.gridy = 0;
//#endif 


//#if 1416599292 
constraints.insets = new Insets(0, 5, 10, 0);
//#endif 


//#if -411691802 
noneButton.setActionCommand(NONE_NAME);
//#endif 


//#if 2059590952 
defaultButton.setActionCommand(DEFAULT_NAME);
//#endif 


//#if 1293995188 
customButton.setActionCommand(CUSTOM_NAME);
//#endif 


//#if 1057204366 
noneButton.addActionListener(this);
//#endif 


//#if 1718158493 
defaultButton.addActionListener(this);
//#endif 


//#if -1753860281 
customButton.addActionListener(this);
//#endif 


//#if 1395531138 
ButtonGroup radioButtonGroup = new ButtonGroup();
//#endif 


//#if 429367922 
radioButtonGroup.add(noneButton);
//#endif 


//#if 1638047311 
radioButtonGroup.add(defaultButton);
//#endif 


//#if 391135275 
radioButtonGroup.add(customButton);
//#endif 


//#if -1135926398 
selectedContainer.add(noneButton, constraints);
//#endif 


//#if 414064314 
constraints.gridx = 1;
//#endif 


//#if -439095850 
constraints.insets = new Insets(0, 5, 10, 0);
//#endif 


//#if 1149027347 
selectedContainer.add(defaultButton, constraints);
//#endif 


//#if 414064345 
constraints.gridx = 2;
//#endif 


//#if -439095849 
constraints.insets = new Insets(0, 5, 10, 0);
//#endif 


//#if 1910622779 
selectedContainer.add(customButton, constraints);
//#endif 


//#if 414064376 
constraints.gridx = 3;
//#endif 


//#if -1291308168 
constraints.weightx = 10.0;
//#endif 


//#if -1427066746 
constraints.insets = new Insets(0, 10, 10, 15);
//#endif 


//#if -443567246 
constraints.fill = GridBagConstraints.HORIZONTAL;
//#endif 


//#if 1550138768 
shortcutField.addShortcutChangedListener(this);
//#endif 


//#if -1358697874 
shortcutFieldDefaultBg = shortcutField.getBackground();
//#endif 


//#if 924658132 
selectedContainer.add(shortcutField, constraints);
//#endif 


//#if -860370551 
constraints.gridwidth = 4;
//#endif 


//#if 414094105 
constraints.gridy = 1;
//#endif 


//#if 243027415 
constraints.gridx = 0;
//#endif 


//#if -822499371 
constraints.anchor = GridBagConstraints.WEST;
//#endif 


//#if -2013274235 
constraints.insets = new Insets(0, 10, 5, 10);
//#endif 


//#if 2079446188 
warningLabel.setForeground(Color.RED);
//#endif 


//#if 860693552 
selectedContainer.add(warningLabel, constraints);
//#endif 


//#if -277816509 
panelConstraints.gridy = 1;
//#endif 


//#if 695368389 
panelConstraints.anchor = GridBagConstraints.CENTER;
//#endif 


//#if 709868647 
panelConstraints.fill = GridBagConstraints.BOTH;
//#endif 


//#if 412890454 
panelConstraints.weightx = 1;
//#endif 


//#if 412920245 
panelConstraints.weighty = 1;
//#endif 


//#if 1596242750 
add(selectedContainer, panelConstraints);
//#endif 


//#if -1980370083 
JLabel restart =
                new JLabel(Translator.localize("label.restart-application"));
//#endif 


//#if -1059011515 
restart.setHorizontalAlignment(SwingConstants.CENTER);
//#endif 


//#if 1247036851 
restart.setVerticalAlignment(SwingConstants.CENTER);
//#endif 


//#if -386482832 
restart.setBorder(BorderFactory.createEmptyBorder(10, 2, 10, 2));
//#endif 


//#if -277816478 
panelConstraints.gridy = 2;
//#endif 


//#if 1092454765 
panelConstraints.anchor = GridBagConstraints.CENTER;
//#endif 


//#if 709868648 
panelConstraints.fill = GridBagConstraints.BOTH;
//#endif 


//#if -366773956 
panelConstraints.weightx = 1;
//#endif 


//#if 412920214 
panelConstraints.weighty = 0;
//#endif 


//#if -305912907 
add(restart, panelConstraints);
//#endif 


//#if -1863786004 
this.enableFields(false);
//#endif 

} 

//#endif 


//#if 1205286550 
return this;
//#endif 

} 

//#endif 


//#if 445508213 
private void setKeyStrokeValue(KeyStroke newKeyStroke)
    { 

//#if -8095945 
String formattedKeyStroke = KeyEventUtils.formatKeyStroke(newKeyStroke);
//#endif 


//#if -356193533 
shortcutField.setText(formattedKeyStroke);
//#endif 


//#if -1822762105 
table.getModel().setValueAt(newKeyStroke, table.getSelectedRow(), 1);
//#endif 


//#if 2109726264 
actions[table.getSelectedRow()].setCurrentShortcut(newKeyStroke);
//#endif 


//#if -2062212206 
table.repaint();
//#endif 

} 

//#endif 


//#if -783985911 
private void resetKeyStrokeConflict()
    { 

//#if 111015310 
this.warningLabel.setText(" ");
//#endif 


//#if 782641417 
this.shortcutField.setBackground(shortcutFieldDefaultBg);
//#endif 

} 

//#endif 


//#if -657854042 
public ActionWrapper getActionAlreadyAssigned(KeyStroke keyStroke)
    { 

//#if 171188198 
for (int i = 0; i < actions.length; i++) //1
{ 

//#if 437407378 
if(actions[i].getCurrentShortcut() != null
                    && actions[i].getCurrentShortcut().equals(keyStroke)
                    && !actions[i].getActionName().equals(
                        target.getActionName()))//1
{ 

//#if -1296306194 
return actions[i];
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1274035602 
KeyStroke duplicate = ShortcutMgr.getDuplicate(keyStroke);
//#endif 


//#if 232071156 
if(duplicate != null)//1
{ 

//#if -1134216342 
for (int i = 0; i < actions.length; i++) //1
{ 

//#if 1156434801 
if(actions[i].getCurrentShortcut() != null
                        && actions[i].getCurrentShortcut().equals(duplicate)
                        && !actions[i].getActionName().equals(
                            target.getActionName()))//1
{ 

//#if 1181722038 
return actions[i];
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1651390107 
return null;
//#endif 

} 

//#endif 


//#if 2040290166 
public void valueChanged(ListSelectionEvent lse)
    { 

//#if 1826754382 
if(lse.getValueIsAdjusting())//1
{ 

//#if 429121369 
return;
//#endif 

} 

//#endif 


//#if -628169053 
Object src = lse.getSource();
//#endif 


//#if -977128893 
if(src != table.getSelectionModel() || table.getSelectedRow() == -1)//1
{ 

//#if 1677476871 
return;
//#endif 

} 

//#endif 


//#if -1710322006 
if(!noneButton.isSelected())//1
{ 

//#if 782139065 
ActionWrapper oldAction = getActionAlreadyAssigned(ShortcutMgr
                                      .decodeKeyStroke(shortcutField.getText()));
//#endif 


//#if 457767897 
if(oldAction != null)//1
{ 

//#if -2114183923 
String t = MessageFormat.format(Translator
                                                .localize("optionpane.conflict-shortcut"),
                                                new Object[] {shortcutField.getText(),
                                                        oldAction.getActionName()
                                                             });
//#endif 


//#if -941035723 
int response = JOptionPane.showConfirmDialog(this, t, t,
                               JOptionPane.YES_NO_OPTION);
//#endif 


//#if -391678866 
switch (response) //1
{ 
case JOptionPane.YES_OPTION://1


//#if 63683749 
oldAction.setCurrentShortcut(null);
//#endif 


//#if -391842633 
table.setValueAt(oldAction, -1, -1);
//#endif 


//#if -1912039894 
break;

//#endif 


case JOptionPane.NO_OPTION://1


//#if -71805082 
table.getSelectionModel().removeListSelectionListener(this);
//#endif 


//#if 319221879 
table.getSelectionModel().setSelectionInterval(
                        lastRowSelected, lastRowSelected);
//#endif 


//#if -1905853013 
table.getSelectionModel().addListSelectionListener(this);
//#endif 


//#if 537439225 
return;
//#endif 


} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1941820992 
setTarget(actions[table.getSelectedRow()]);
//#endif 


//#if -573370111 
lastRowSelected = table.getSelectedRow();
//#endif 

} 

//#endif 


//#if -1105039587 
private void checkShortcutAlreadyAssigned(KeyStroke newKeyStroke)
    { 

//#if -1846431193 
ActionWrapper oldAction = getActionAlreadyAssigned(newKeyStroke);
//#endif 


//#if -1025098966 
if(oldAction != null)//1
{ 

//#if -1182977368 
this.shortcutField.setBackground(Color.YELLOW);
//#endif 


//#if 1917918173 
this.warningLabel.setText(MessageFormat.format(Translator
                                      .localize("misc.shortcuts.conflict"),
                                      new Object[] {KeyEventUtils.formatKeyStroke(oldAction
                                                    .getCurrentShortcut()),
                                                    oldAction.getActionName()
                                                   }));
//#endif 

} 
else
{ 

//#if 893667204 
resetKeyStrokeConflict();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1691596870 
public void handleResetToDefault()
    { 
} 

//#endif 


//#if -247587390 
public void handleSettingsTabSave()
    { 

//#if 2004896363 
if(getActionAlreadyAssigned(ShortcutMgr
                                     .decodeKeyStroke(shortcutField.getText())) != null)//1
{ 

//#if -314007652 
JOptionPane.showMessageDialog(this,
                                          Translator.localize(
                                              "optionpane.shortcut-save-conflict"),
                                          Translator.localize(
                                              "optionpane.shortcut-save-conflict-title"),
                                          JOptionPane.WARNING_MESSAGE);
//#endif 

} 
else
{ 

//#if 534355257 
ShortcutMgr.saveShortcuts(actions);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2114753540 
private void enableFields(boolean enable)
    { 

//#if 202820822 
shortcutField.setEditable(enable);
//#endif 


//#if -1854668584 
customButton.setEnabled(enable);
//#endif 


//#if 269698750 
defaultButton.setEnabled(enable);
//#endif 


//#if -26618081 
noneButton.setEnabled(enable);
//#endif 

} 

//#endif 


//#if -105259010 
public String getTabKey()
    { 

//#if -313297945 
return "tab.shortcuts";
//#endif 

} 

//#endif 


//#if -2112664552 
public void handleSettingsTabRefresh()
    { 

//#if 792206988 
actions = ShortcutMgr.getShortcuts();
//#endif 


//#if 199806350 
table.setModel(new ShortcutTableModel());
//#endif 

} 

//#endif 


//#if 2031521015 
private void setTarget(Object t)
    { 

//#if 1020906696 
target = (ActionWrapper) t;
//#endif 


//#if -1650887181 
enableFields(true);
//#endif 


//#if 621311390 
selectedContainer.setBorder(BorderFactory.createTitledBorder(Translator
                                    .localize("dialog.shortcut.titled-border.selected-partial")
                                    + " \"" + target.getActionName() + "\""));
//#endif 


//#if 1890910784 
shortcutField.setText(KeyEventUtils.formatKeyStroke(target
                              .getCurrentShortcut()));
//#endif 


//#if -414422745 
resetKeyStrokeConflict();
//#endif 


//#if 1512416388 
if(target.getCurrentShortcut() == null)//1
{ 

//#if -1945154735 
noneButton.setSelected(true);
//#endif 


//#if 2014004420 
shortcutField.setEnabled(false);
//#endif 

} 
else

//#if -1654056450 
if(target.getDefaultShortcut() != null
                   && target.getCurrentShortcut().equals(
                       target.getDefaultShortcut()))//1
{ 

//#if -1084960560 
defaultButton.setSelected(true);
//#endif 


//#if 1900769264 
shortcutField.setEnabled(false);
//#endif 

} 
else
{ 

//#if -1930635564 
customButton.setSelected(true);
//#endif 


//#if -1063348147 
shortcutField.setEnabled(true);
//#endif 


//#if 1270933621 
shortcutField.requestFocus();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -391201264 
class ShortcutTableModel extends 
//#if -935294536 
AbstractTableModel
//#endif 

  { 

//#if 973121305 
@Override
        public Class<?> getColumnClass(int col)
        { 

//#if -181325696 
switch (col) //1
{ 
case 0://1


//#if -201970729 
return String.class;
//#endif 


case 1://1


//#if -1344218343 
return KeyStroke.class;
//#endif 


case 2://1


//#if 661542644 
return KeyStroke.class;
//#endif 


default://1


//#if 603263158 
return null;
//#endif 


} 

//#endif 

} 

//#endif 


//#if 1649743631 
public int getColumnCount()
        { 

//#if -1875015518 
return columnNames.length;
//#endif 

} 

//#endif 


//#if -603841714 
public Object getValueAt(int row, int col)
        { 

//#if -1830794048 
return elements[row][col];
//#endif 

} 

//#endif 


//#if -1929201018 
public ShortcutTableModel()
        { 

//#if 1783578939 
elements = new Object[actions.length][3];
//#endif 


//#if 559441106 
for (int i = 0; i < elements.length; i++) //1
{ 

//#if -991953649 
ActionWrapper currentAction = actions[i];
//#endif 


//#if -954904738 
elements[i][0] = currentAction.getActionName();
//#endif 


//#if -852959147 
elements[i][1] = currentAction.getCurrentShortcut();
//#endif 


//#if -1629645012 
elements[i][2] = currentAction.getDefaultShortcut();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1948299847 
@Override
        public void setValueAt(Object ob, int row, int col)
        { 

//#if 1644573322 
if(ob instanceof ActionWrapper)//1
{ 

//#if 860375262 
ActionWrapper newValueAction = (ActionWrapper) ob;
//#endif 


//#if 311650306 
for (int i = 0; i < elements.length; i++) //1
{ 

//#if -1210477580 
if(elements[i][0].equals(newValueAction.getActionName()))//1
{ 

//#if -2028352587 
elements[i][1] = newValueAction.getCurrentShortcut();
//#endif 


//#if 135944274 
repaint();
//#endif 


//#if 797933439 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1231110846 
for (int i = 0; i < actions.length; i++) //1
{ 

//#if -1297153085 
if(actions[i].getKey().equals(newValueAction.getKey()))//1
{ 

//#if 1411956520 
actions[i].setCurrentShortcut(newValueAction
                                                      .getCurrentShortcut());
//#endif 


//#if -1656777432 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 
else
{ 

//#if -436804848 
elements[row][col] = ob;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -346862980 
@Override
        public String getColumnName(int col)
        { 

//#if -1932610640 
return columnNames[col];
//#endif 

} 

//#endif 


//#if -1777623487 
public int getRowCount()
        { 

//#if -1750730957 
return elements.length;
//#endif 

} 

//#endif 


//#if 150275425 
@Override
        public boolean isCellEditable(int row, int col)
        { 

//#if 1475500385 
return false;
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

