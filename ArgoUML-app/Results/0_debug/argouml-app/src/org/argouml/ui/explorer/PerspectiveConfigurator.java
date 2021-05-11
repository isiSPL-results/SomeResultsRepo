
//#if 2007729266 
// Compilation Unit of /PerspectiveConfigurator.java 
 

//#if 1073648812 
package org.argouml.ui.explorer;
//#endif 


//#if -1704595193 
import java.awt.BorderLayout;
//#endif 


//#if -962505147 
import java.awt.FlowLayout;
//#endif 


//#if 977723337 
import java.awt.GridBagConstraints;
//#endif 


//#if -657172275 
import java.awt.GridBagLayout;
//#endif 


//#if -437403347 
import java.awt.GridLayout;
//#endif 


//#if -1677209081 
import java.awt.Insets;
//#endif 


//#if 1841068617 
import java.awt.event.ActionEvent;
//#endif 


//#if -706486369 
import java.awt.event.ActionListener;
//#endif 


//#if 729134399 
import java.awt.event.MouseAdapter;
//#endif 


//#if 735367188 
import java.awt.event.MouseEvent;
//#endif 


//#if -125043166 
import java.util.ArrayList;
//#endif 


//#if 1758227327 
import java.util.Collection;
//#endif 


//#if -1329525916 
import java.util.Collections;
//#endif 


//#if -510749625 
import java.util.Comparator;
//#endif 


//#if -1474336001 
import java.util.List;
//#endif 


//#if -1162725501 
import javax.swing.BorderFactory;
//#endif 


//#if -326293556 
import javax.swing.BoxLayout;
//#endif 


//#if 1253938443 
import javax.swing.DefaultListModel;
//#endif 


//#if -984722747 
import javax.swing.JButton;
//#endif 


//#if -2119799605 
import javax.swing.JLabel;
//#endif 


//#if -1869240871 
import javax.swing.JList;
//#endif 


//#if -2004925509 
import javax.swing.JPanel;
//#endif 


//#if -503455614 
import javax.swing.JScrollPane;
//#endif 


//#if -1960654371 
import javax.swing.JSplitPane;
//#endif 


//#if -137280238 
import javax.swing.JTextField;
//#endif 


//#if -1609574566 
import javax.swing.ListSelectionModel;
//#endif 


//#if -28425738 
import javax.swing.event.DocumentEvent;
//#endif 


//#if -1971888942 
import javax.swing.event.DocumentListener;
//#endif 


//#if -117622475 
import javax.swing.event.ListSelectionEvent;
//#endif 


//#if -647124685 
import javax.swing.event.ListSelectionListener;
//#endif 


//#if 137541452 
import org.argouml.i18n.Translator;
//#endif 


//#if 254875347 
import org.argouml.swingext.SpacerPanel;
//#endif 


//#if -380685206 
import org.argouml.ui.explorer.rules.PerspectiveRule;
//#endif 


//#if -1761678679 
import org.argouml.util.ArgoDialog;
//#endif 


//#if 692837535 
import org.apache.log4j.Logger;
//#endif 


//#if -1496547941 
public class PerspectiveConfigurator extends 
//#if 63381068 
ArgoDialog
//#endif 

  { 

//#if 1397015900 
private static final int INSET_PX = 3;
//#endif 


//#if -1081181178 
private JPanel  configPanelNorth;
//#endif 


//#if -937946050 
private JPanel  configPanelSouth;
//#endif 


//#if 1111954441 
private JSplitPane splitPane;
//#endif 


//#if -1561617081 
private JTextField renameTextField;
//#endif 


//#if -2051940535 
private JButton newPerspectiveButton;
//#endif 


//#if 1730606965 
private JButton removePerspectiveButton;
//#endif 


//#if -1270671116 
private JButton duplicatePerspectiveButton;
//#endif 


//#if 602093324 
private JButton moveUpButton, moveDownButton;
//#endif 


//#if -339557200 
private JButton addRuleButton;
//#endif 


//#if 2038615973 
private JButton removeRuleButton;
//#endif 


//#if 2076553390 
private JButton resetToDefaultButton;
//#endif 


//#if 1624421073 
private JList   perspectiveList;
//#endif 


//#if -1779866190 
private JList   perspectiveRulesList;
//#endif 


//#if -1668034354 
private JList   ruleLibraryList;
//#endif 


//#if -85209526 
private DefaultListModel perspectiveListModel;
//#endif 


//#if -254109907 
private DefaultListModel perspectiveRulesListModel;
//#endif 


//#if 470738541 
private DefaultListModel ruleLibraryListModel;
//#endif 


//#if 1010189663 
private JLabel persLabel;
//#endif 


//#if -2111091506 
private JLabel ruleLibLabel;
//#endif 


//#if 2083883228 
private JLabel rulesLabel;
//#endif 


//#if -265885914 
private static final Logger LOG =
        Logger.getLogger(PerspectiveConfigurator.class);
//#endif 


//#if 659816394 
private void updatePersLabel()
    { 

//#if -278926892 
persLabel.setText(Translator.localize("label.perspectives")
                          + " (" + perspectiveListModel.size() + ")");
//#endif 

} 

//#endif 


//#if 1921117189 
private void makeLayout()
    { 

//#if -1840182001 
GridBagLayout gb = new GridBagLayout();
//#endif 


//#if 1360736747 
configPanelNorth.setLayout(gb);
//#endif 


//#if 620365859 
configPanelSouth.setLayout(gb);
//#endif 


//#if 2144986557 
GridBagConstraints c = new GridBagConstraints();
//#endif 


//#if -778539733 
c.ipadx = 3;
//#endif 


//#if -778509942 
c.ipady = 3;
//#endif 


//#if -512414568 
persLabel = new JLabel();
//#endif 


//#if -1334659427 
persLabel.setBorder(BorderFactory.createEmptyBorder(
                                INSET_PX, INSET_PX, INSET_PX, INSET_PX));
//#endif 


//#if 148492134 
c.fill = GridBagConstraints.BOTH;
//#endif 


//#if 2034847370 
c.gridx = 0;
//#endif 


//#if 2034877161 
c.gridy = 0;
//#endif 


//#if 189491673 
c.gridwidth = 3;
//#endif 


//#if 38373977 
c.weightx = 1.0;
//#endif 


//#if 66973337 
c.weighty = 0.0;
//#endif 


//#if -27087779 
gb.setConstraints(persLabel, c);
//#endif 


//#if 1334808679 
configPanelNorth.add(persLabel);
//#endif 


//#if -1719437239 
JPanel persPanel = new JPanel(new BorderLayout());
//#endif 


//#if 120292127 
JScrollPane persScroll =
            new JScrollPane(perspectiveList,
                            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//#endif 


//#if -1133929780 
persPanel.add(renameTextField, BorderLayout.NORTH);
//#endif 


//#if -164991226 
persPanel.add(persScroll, BorderLayout.CENTER);
//#endif 


//#if 969630600 
c.gridx = 0;
//#endif 


//#if 2034877192 
c.gridy = 1;
//#endif 


//#if 189491704 
c.gridwidth = 4;
//#endif 


//#if 737894745 
c.weightx = 1.0;
//#endif 


//#if 67003128 
c.weighty = 1.0;
//#endif 


//#if -901828755 
gb.setConstraints(persPanel, c);
//#endif 


//#if 600938359 
configPanelNorth.add(persPanel);
//#endif 


//#if 945662894 
JPanel persButtons = new JPanel(new GridLayout(6, 1, 0, 5));
//#endif 


//#if -1935844589 
persButtons.add(newPerspectiveButton);
//#endif 


//#if 1788157865 
persButtons.add(removePerspectiveButton);
//#endif 


//#if -244451448 
persButtons.add(duplicatePerspectiveButton);
//#endif 


//#if -1139380253 
persButtons.add(moveUpButton);
//#endif 


//#if 1908903402 
persButtons.add(moveDownButton);
//#endif 


//#if 1493415502 
persButtons.add(resetToDefaultButton);
//#endif 


//#if -1597953958 
JPanel persButtonWrapper =
            new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
//#endif 


//#if 719193834 
persButtonWrapper.add(persButtons);
//#endif 


//#if 2034847494 
c.gridx = 4;
//#endif 


//#if 1858057802 
c.gridy = 1;
//#endif 


//#if 189491611 
c.gridwidth = 1;
//#endif 


//#if 38344186 
c.weightx = 0.0;
//#endif 


//#if -1957063399 
c.weighty = 0.0;
//#endif 


//#if -778539826 
c.ipadx = 0;
//#endif 


//#if -778510035 
c.ipady = 0;
//#endif 


//#if 1067508878 
c.insets = new Insets(0, 5, 0, 0);
//#endif 


//#if 464254954 
gb.setConstraints(persButtonWrapper, c);
//#endif 


//#if -1294349772 
configPanelNorth.add(persButtonWrapper);
//#endif 


//#if 1302604825 
ruleLibLabel = new JLabel();
//#endif 


//#if -1112832610 
ruleLibLabel.setBorder(BorderFactory.createEmptyBorder(
                                   INSET_PX, INSET_PX, INSET_PX, INSET_PX));
//#endif 


//#if 969630601 
c.gridx = 0;
//#endif 


//#if 2034877254 
c.gridy = 3;
//#endif 


//#if 1557603031 
c.gridwidth = 1;
//#endif 


//#if 737894746 
c.weightx = 1.0;
//#endif 


//#if -1957063398 
c.weighty = 0.0;
//#endif 


//#if -653740729 
c.ipadx = 3;
//#endif 


//#if 233762952 
c.ipady = 3;
//#endif 


//#if 535328226 
c.insets = new Insets(10, 0, 0, 0);
//#endif 


//#if 212088286 
gb.setConstraints(ruleLibLabel, c);
//#endif 


//#if -727130434 
configPanelSouth.add(ruleLibLabel);
//#endif 


//#if 1009445793 
addRuleButton.setMargin(new Insets(2, 15, 2, 15));
//#endif 


//#if -59393748 
removeRuleButton.setMargin(new Insets(2, 15, 2, 15));
//#endif 


//#if -1848469478 
JPanel xferButtons = new JPanel();
//#endif 


//#if 715370031 
xferButtons.setLayout(new BoxLayout(xferButtons, BoxLayout.Y_AXIS));
//#endif 


//#if -1229820215 
xferButtons.add(addRuleButton);
//#endif 


//#if 4874211 
xferButtons.add(new SpacerPanel());
//#endif 


//#if 1337146396 
xferButtons.add(removeRuleButton);
//#endif 


//#if 2034847432 
c.gridx = 2;
//#endif 


//#if 2034877285 
c.gridy = 4;
//#endif 


//#if -149608936 
c.weightx = 0.0;
//#endif 


//#if -1957063397 
c.weighty = 0.0;
//#endif 


//#if -707493679 
c.insets = new Insets(0, 3, 0, 5);
//#endif 


//#if 1422815269 
gb.setConstraints(xferButtons, c);
//#endif 


//#if 1603389623 
configPanelSouth.add(xferButtons);
//#endif 


//#if -997550745 
rulesLabel = new JLabel();
//#endif 


//#if 474425324 
rulesLabel.setBorder(BorderFactory.createEmptyBorder(
                                 INSET_PX, INSET_PX, INSET_PX, INSET_PX));
//#endif 


//#if 2034847463 
c.gridx = 3;
//#endif 


//#if 1859904844 
c.gridy = 3;
//#endif 


//#if 1557603032 
c.gridwidth = 1;
//#endif 


//#if 737894747 
c.weightx = 1.0;
//#endif 


//#if 749657392 
c.insets = new Insets(10, 0, 0, 0);
//#endif 


//#if 632176912 
gb.setConstraints(rulesLabel, c);
//#endif 


//#if -56227792 
configPanelSouth.add(rulesLabel);
//#endif 


//#if 969630602 
c.gridx = 0;
//#endif 


//#if 1860828365 
c.gridy = 4;
//#endif 


//#if -1069559718 
c.weighty = 1.0;
//#endif 


//#if 189491642 
c.gridwidth = 2;
//#endif 


//#if 17033733 
c.gridheight = 2;
//#endif 


//#if 924957769 
c.insets = new Insets(0, 0, 0, 0);
//#endif 


//#if -1478128549 
JScrollPane ruleLibScroll =
            new JScrollPane(ruleLibraryList,
                            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//#endif 


//#if -252948011 
gb.setConstraints(ruleLibScroll, c);
//#endif 


//#if 490936359 
configPanelSouth.add(ruleLibScroll);
//#endif 


//#if 972401163 
c.gridx = 3;
//#endif 


//#if 1860828366 
c.gridy = 4;
//#endif 


//#if 1558526552 
c.gridwidth = 2;
//#endif 


//#if 645845549 
c.gridheight = 2;
//#endif 


//#if -203590531 
JScrollPane rulesScroll =
            new JScrollPane(perspectiveRulesList,
                            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//#endif 


//#if -115102493 
gb.setConstraints(rulesScroll, c);
//#endif 


//#if -185918219 
configPanelSouth.add(rulesScroll);
//#endif 

} 

//#endif 


//#if 1220818456 
private void doRemoveRule()
    { 

//#if 621680313 
int selLibNr = ruleLibraryList.getSelectedIndex();
//#endif 


//#if 1189713331 
PerspectiveRule sel =
            (PerspectiveRule) perspectiveRulesList.getSelectedValue();
//#endif 


//#if 1286418356 
int selectedItem = perspectiveRulesList.getSelectedIndex();
//#endif 


//#if -273989718 
Object selPers = perspectiveList.getSelectedValue();
//#endif 


//#if 1662418670 
perspectiveRulesListModel.removeElement(sel);
//#endif 


//#if -1176114435 
((ExplorerPerspective) selPers).removeRule(sel);
//#endif 


//#if -163259979 
if(perspectiveRulesListModel.getSize() > selectedItem)//1
{ 

//#if -307885265 
perspectiveRulesList.setSelectedIndex(selectedItem);
//#endif 

} 
else

//#if -250524305 
if(perspectiveRulesListModel.getSize() > 0)//1
{ 

//#if -2037917036 
perspectiveRulesList.setSelectedIndex(
                perspectiveRulesListModel.getSize() - 1);
//#endif 

} 

//#endif 


//#endif 


//#if 1352961397 
loadLibrary();
//#endif 


//#if 59744627 
ruleLibraryList.setSelectedIndex(selLibNr);
//#endif 


//#if -1387892325 
updateRuleLabel();
//#endif 

} 

//#endif 


//#if 176457959 
private void doAddRule()
    { 

//#if 869103685 
Object sel = ruleLibraryList.getSelectedValue();
//#endif 


//#if 227965831 
int selLibNr = ruleLibraryList.getSelectedIndex();
//#endif 


//#if -1657502376 
try //1
{ 

//#if 109520858 
PerspectiveRule newRule =
                (PerspectiveRule) sel.getClass().newInstance();
//#endif 


//#if -1392681024 
perspectiveRulesListModel.insertElementAt(newRule, 0);
//#endif 


//#if -295713317 
((ExplorerPerspective) perspectiveList.getSelectedValue())
            .addRule(newRule);
//#endif 


//#if -1220060430 
sortJListModel(perspectiveRulesList);
//#endif 


//#if 1766947761 
perspectiveRulesList.setSelectedValue(newRule, true);
//#endif 


//#if 341006983 
loadLibrary();
//#endif 


//#if 1248749752 
if(!(ruleLibraryListModel.size() > selLibNr))//1
{ 

//#if -956593091 
selLibNr = ruleLibraryListModel.size() - 1;
//#endif 

} 

//#endif 


//#if 406062497 
ruleLibraryList.setSelectedIndex(selLibNr);
//#endif 


//#if 868509101 
updateRuleLabel();
//#endif 

} 

//#if -1627141798 
catch (Exception e) //1
{ 

//#if 319172862 
LOG.error("problem adding rule", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1841916164 
private void updateRuleLabel()
    { 

//#if 1629400400 
rulesLabel.setText(Translator.localize("label.selected-rules")
                           + " (" + perspectiveRulesListModel.size() + ")");
//#endif 

} 

//#endif 


//#if 955807397 
private void updateLibLabel()
    { 

//#if -1068969167 
ruleLibLabel.setText(Translator.localize("label.rules-library")
                             + " (" + ruleLibraryListModel.size() + ")");
//#endif 

} 

//#endif 


//#if 811181352 
private void makeButtons()
    { 

//#if -663088392 
newPerspectiveButton = new JButton();
//#endif 


//#if -1828035062 
nameButton(newPerspectiveButton, "button.new");
//#endif 


//#if -207885050 
newPerspectiveButton.setToolTipText(
            Translator.localize("button.new.tooltip"));
//#endif 


//#if 1985367586 
removePerspectiveButton = new JButton();
//#endif 


//#if -1451955758 
nameButton(removePerspectiveButton, "button.remove");
//#endif 


//#if 1469942244 
removePerspectiveButton.setToolTipText(
            Translator.localize("button.remove.tooltip"));
//#endif 


//#if 953192301 
duplicatePerspectiveButton = new JButton();
//#endif 


//#if 1624181482 
nameButton(duplicatePerspectiveButton, "button.duplicate");
//#endif 


//#if -1405065380 
duplicatePerspectiveButton.setToolTipText(
            Translator.localize("button.duplicate.tooltip"));
//#endif 


//#if 515581384 
moveUpButton = new JButton();
//#endif 


//#if -773819037 
nameButton(moveUpButton, "button.move-up");
//#endif 


//#if 1011892781 
moveUpButton.setToolTipText(
            Translator.localize("button.move-up.tooltip"));
//#endif 


//#if -1478347825 
moveDownButton = new JButton();
//#endif 


//#if -15711787 
nameButton(moveDownButton, "button.move-down");
//#endif 


//#if -823374003 
moveDownButton.setToolTipText(
            Translator.localize("button.move-down.tooltip"));
//#endif 


//#if 2044383495 
addRuleButton = new JButton(">>");
//#endif 


//#if -532182504 
addRuleButton.setToolTipText(Translator.localize("button.add-rule"));
//#endif 


//#if -1577440548 
removeRuleButton = new JButton("<<");
//#endif 


//#if -1754937134 
removeRuleButton.setToolTipText(Translator.localize(
                                            "button.remove-rule"));
//#endif 


//#if -949850701 
resetToDefaultButton = new JButton();
//#endif 


//#if -2062783256 
nameButton(resetToDefaultButton, "button.restore-defaults");
//#endif 


//#if 766100066 
resetToDefaultButton.setToolTipText(
            Translator.localize("button.restore-defaults.tooltip"));
//#endif 


//#if 1373527897 
removePerspectiveButton.setEnabled(false);
//#endif 


//#if 1990210798 
duplicatePerspectiveButton.setEnabled(false);
//#endif 


//#if 1160535923 
moveUpButton.setEnabled(false);
//#endif 


//#if 1278213580 
moveDownButton.setEnabled(false);
//#endif 


//#if 430032404 
addRuleButton.setEnabled(false);
//#endif 


//#if -118257889 
removeRuleButton.setEnabled(false);
//#endif 


//#if -807112076 
renameTextField.setEnabled(false);
//#endif 

} 

//#endif 


//#if 1004893214 
public PerspectiveConfigurator()
    { 

//#if 1305792645 
super(Translator.localize("dialog.title.configure-perspectives"),
              ArgoDialog.OK_CANCEL_OPTION,
              true);
//#endif 


//#if 248274594 
configPanelNorth = new JPanel();
//#endif 


//#if -1973722406 
configPanelSouth = new JPanel();
//#endif 


//#if -1206116597 
makeLists();
//#endif 


//#if -286201313 
makeButtons();
//#endif 


//#if 1098529098 
makeLayout();
//#endif 


//#if 790477763 
updateRuleLabel();
//#endif 


//#if 835851553 
makeListeners();
//#endif 


//#if 1885439525 
loadPerspectives();
//#endif 


//#if -20501603 
loadLibrary();
//#endif 


//#if -2058861474 
splitPane =
            new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                           configPanelNorth, configPanelSouth);
//#endif 


//#if 2099612817 
splitPane.setContinuousLayout(true);
//#endif 


//#if 432526779 
setContent(splitPane);
//#endif 

} 

//#endif 


//#if -473829856 
private void sortJListModel(JList list)
    { 

//#if -501394202 
DefaultListModel model = (DefaultListModel) list.getModel();
//#endif 


//#if 1697905263 
List all = new ArrayList();
//#endif 


//#if -659247519 
for (int i = 0; i < model.getSize(); i++) //1
{ 

//#if 1866694655 
all.add(model.getElementAt(i));
//#endif 

} 

//#endif 


//#if 763967820 
model.clear();
//#endif 


//#if -562752653 
Collections.sort(all, new Comparator() {
            public int compare(Object o1, Object o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
//#endif 


//#if -1928665010 
for (Object obj : all) //1
{ 

//#if -203094386 
model.addElement(obj);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -684223044 
private void makeLists()
    { 

//#if -1657848730 
renameTextField = new JTextField();
//#endif 


//#if -830077987 
perspectiveListModel = new DefaultListModel();
//#endif 


//#if -1009551043 
perspectiveList = new JList(perspectiveListModel);
//#endif 


//#if 1278237406 
perspectiveRulesListModel = new DefaultListModel();
//#endif 


//#if -957556059 
perspectiveRulesList = new JList(perspectiveRulesListModel);
//#endif 


//#if -292614208 
ruleLibraryListModel = new DefaultListModel();
//#endif 


//#if 1646118877 
ruleLibraryList = new JList(ruleLibraryListModel);
//#endif 


//#if -990017671 
perspectiveList.setBorder(BorderFactory.createEmptyBorder(
                                      INSET_PX, INSET_PX, INSET_PX, INSET_PX));
//#endif 


//#if -273215720 
perspectiveRulesList.setBorder(BorderFactory.createEmptyBorder(
                                           INSET_PX, INSET_PX, INSET_PX, INSET_PX));
//#endif 


//#if 1835443062 
ruleLibraryList.setBorder(BorderFactory.createEmptyBorder(
                                      INSET_PX, INSET_PX, INSET_PX, INSET_PX));
//#endif 


//#if -1777378380 
perspectiveList.setSelectionMode(
            ListSelectionModel.SINGLE_SELECTION);
//#endif 


//#if -663245805 
perspectiveRulesList.setSelectionMode(
            ListSelectionModel.SINGLE_SELECTION);
//#endif 


//#if 1024522737 
ruleLibraryList.setSelectionMode(
            ListSelectionModel.SINGLE_SELECTION);
//#endif 

} 

//#endif 


//#if 941448934 
private void makeListeners()
    { 

//#if 1746682154 
renameTextField.addActionListener(new RenameListener());
//#endif 


//#if 195962414 
renameTextField.getDocument().addDocumentListener(
            new RenameDocumentListener());
//#endif 


//#if 1994245285 
newPerspectiveButton.addActionListener(new NewPerspectiveListener());
//#endif 


//#if 603854719 
removePerspectiveButton.addActionListener(
            new RemovePerspectiveListener());
//#endif 


//#if 2009225807 
duplicatePerspectiveButton.addActionListener(
            new DuplicatePerspectiveListener());
//#endif 


//#if -1716767419 
moveUpButton.addActionListener(new MoveUpListener());
//#endif 


//#if 985674771 
moveDownButton.addActionListener(new MoveDownListener());
//#endif 


//#if -1165136888 
addRuleButton.addActionListener(new RuleListener());
//#endif 


//#if 1087268937 
removeRuleButton.addActionListener(new RuleListener());
//#endif 


//#if -1606519399 
resetToDefaultButton.addActionListener(new ResetListener());
//#endif 


//#if 1089237349 
perspectiveList.addListSelectionListener(
            new PerspectiveListSelectionListener());
//#endif 


//#if 1229123053 
perspectiveRulesList.addListSelectionListener(
            new RulesListSelectionListener());
//#endif 


//#if -1889256340 
perspectiveRulesList.addMouseListener(new RuleListMouseListener());
//#endif 


//#if 695473731 
ruleLibraryList.addListSelectionListener(
            new LibraryListSelectionListener());
//#endif 


//#if -1764705198 
ruleLibraryList.addMouseListener(new RuleListMouseListener());
//#endif 


//#if 1796974078 
getOkButton().addActionListener(new OkListener());
//#endif 

} 

//#endif 


//#if 404110314 
private void loadLibrary()
    { 

//#if 1982771383 
List<PerspectiveRule> rulesLib = new ArrayList<PerspectiveRule>();
//#endif 


//#if -607034578 
rulesLib.addAll(PerspectiveManager.getInstance().getRules());
//#endif 


//#if 1210916633 
Collections.sort(rulesLib, new Comparator<PerspectiveRule>() {
            public int compare(PerspectiveRule o1, PerspectiveRule o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
//#endif 


//#if 396945759 
ExplorerPerspective selPers =
            (ExplorerPerspective) perspectiveList.getSelectedValue();
//#endif 


//#if 2572173 
if(selPers != null)//1
{ 

//#if 499551963 
for (PerspectiveRule persRule : selPers.getList()) //1
{ 

//#if -908656525 
for (PerspectiveRule libRule : rulesLib) //1
{ 

//#if -203662841 
if(libRule.toString().equals(persRule.toString()))//1
{ 

//#if -856646616 
rulesLib.remove(libRule);
//#endif 


//#if 62397411 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1437807662 
ruleLibraryListModel.clear();
//#endif 


//#if -130507976 
for (PerspectiveRule rule : rulesLib) //1
{ 

//#if -968937946 
ruleLibraryListModel.addElement(rule);
//#endif 

} 

//#endif 


//#if -1919391355 
updateLibLabel();
//#endif 

} 

//#endif 


//#if -1543040822 
private void loadPerspectives()
    { 

//#if -1222611103 
List<ExplorerPerspective> perspectives =
            PerspectiveManager.getInstance().getPerspectives();
//#endif 


//#if 1470269495 
for (ExplorerPerspective perspective : perspectives) //1
{ 

//#if -14683442 
List<PerspectiveRule> rules = perspective.getList();
//#endif 


//#if 996951822 
ExplorerPerspective editablePerspective =
                new ExplorerPerspective(perspective.toString());
//#endif 


//#if -25258938 
for (PerspectiveRule rule : rules) //1
{ 

//#if 1274309204 
editablePerspective.addRule(rule);
//#endif 

} 

//#endif 


//#if -602572024 
perspectiveListModel.addElement(editablePerspective);
//#endif 

} 

//#endif 


//#if 2127791721 
updatePersLabel();
//#endif 

} 

//#endif 


//#if -2134561645 
class PerspectiveListSelectionListener implements 
//#if 247633774 
ListSelectionListener
//#endif 

  { 

//#if 1570807627 
public void valueChanged(ListSelectionEvent lse)
        { 

//#if 1200427780 
if(lse.getValueIsAdjusting())//1
{ 

//#if 1709730422 
return;
//#endif 

} 

//#endif 


//#if -731620718 
Object selPers = perspectiveList.getSelectedValue();
//#endif 


//#if 1894906765 
loadLibrary();
//#endif 


//#if 2053837435 
Object selRule = ruleLibraryList.getSelectedValue();
//#endif 


//#if 53026915 
renameTextField.setEnabled(selPers != null);
//#endif 


//#if -1885337272 
removePerspectiveButton.setEnabled(selPers != null);
//#endif 


//#if -285671489 
duplicatePerspectiveButton.setEnabled(selPers != null);
//#endif 


//#if -1132492901 
moveUpButton.setEnabled(perspectiveList.getSelectedIndex() > 0);
//#endif 


//#if 1700381180 
moveDownButton.setEnabled((selPers != null)
                                      && (perspectiveList.getSelectedIndex()
                                          < (perspectiveList.getModel().getSize() - 1)));
//#endif 


//#if -343806564 
if(selPers == null)//1
{ 

//#if 2038618910 
return;
//#endif 

} 

//#endif 


//#if 1652039325 
renameTextField.setText(selPers.toString());
//#endif 


//#if 498253709 
ExplorerPerspective pers = (ExplorerPerspective) selPers;
//#endif 


//#if -785567725 
perspectiveRulesListModel.clear();
//#endif 


//#if -1873792846 
for (PerspectiveRule rule : pers.getList()) //1
{ 

//#if -1659374356 
perspectiveRulesListModel.insertElementAt(rule, 0);
//#endif 

} 

//#endif 


//#if -338889940 
sortJListModel(perspectiveRulesList);
//#endif 


//#if -889670342 
addRuleButton.setEnabled(selPers != null && selRule != null);
//#endif 


//#if -293661773 
updateRuleLabel();
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -338044801 
class RemovePerspectiveListener implements 
//#if 33021950 
ActionListener
//#endif 

  { 

//#if -758110183 
public void actionPerformed(ActionEvent e)
        { 

//#if 519273441 
Object sel = perspectiveList.getSelectedValue();
//#endif 


//#if 605847644 
if(perspectiveListModel.getSize() > 1)//1
{ 

//#if 686154198 
perspectiveListModel.removeElement(sel);
//#endif 

} 

//#endif 


//#if -1648853594 
perspectiveList.setSelectedIndex(0);
//#endif 


//#if 1064663320 
if(perspectiveListModel.getSize() == 1)//1
{ 

//#if -109954091 
removePerspectiveButton.setEnabled(false);
//#endif 

} 

//#endif 


//#if -1497787160 
updatePersLabel();
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -351318028 
class MoveDownListener implements 
//#if -908642168 
ActionListener
//#endif 

  { 

//#if 126525135 
public void actionPerformed(ActionEvent e)
        { 

//#if -520250442 
int sel = perspectiveList.getSelectedIndex();
//#endif 


//#if -1023128938 
if(sel < (perspectiveListModel.getSize() - 1))//1
{ 

//#if 2134173993 
Object selObj = perspectiveListModel.get(sel);
//#endif 


//#if 302473932 
Object nextObj = perspectiveListModel.get(sel + 1);
//#endif 


//#if 119650418 
perspectiveListModel.set(sel, nextObj);
//#endif 


//#if 520009933 
perspectiveListModel.set(sel + 1, selObj);
//#endif 


//#if -959116314 
perspectiveList.setSelectedIndex(sel + 1);
//#endif 


//#if -1113506107 
perspectiveList.ensureIndexIsVisible(sel + 1);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#if 179533917 
class RuleListener implements 
//#if -1991535193 
ActionListener
//#endif 

  { 

//#if -15076720 
public void actionPerformed(ActionEvent e)
        { 

//#if 1369041547 
Object src = e.getSource();
//#endif 


//#if 1686524942 
if(perspectiveList.getSelectedValue() == null)//1
{ 

//#if -1061344208 
return;
//#endif 

} 

//#endif 


//#if -995939555 
if(src == addRuleButton)//1
{ 

//#if -1339877273 
doAddRule();
//#endif 

} 
else

//#if 906933073 
if(src == removeRuleButton)//1
{ 

//#if 1584061427 
doRemoveRule();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#if 997604082 
class RuleListMouseListener extends 
//#if 177525905 
MouseAdapter
//#endif 

  { 

//#if -797822150 
public void mouseClicked(MouseEvent me)
        { 

//#if 2056047828 
Object src = me.getSource();
//#endif 


//#if -2025135558 
if(me.getClickCount() != 2
                    || perspectiveList.getSelectedValue() == null)//1
{ 

//#if 808617025 
return;
//#endif 

} 

//#endif 


//#if 358685040 
if(src == ruleLibraryList && addRuleButton.isEnabled())//1
{ 

//#if -368780048 
doAddRule();
//#endif 

} 

//#endif 


//#if 1117774121 
if(src == perspectiveRulesList && removeRuleButton.isEnabled())//1
{ 

//#if -1497763755 
doRemoveRule();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#if 144624029 
class NewPerspectiveListener implements 
//#if 1419171162 
ActionListener
//#endif 

  { 

//#if -1265061315 
public void actionPerformed(ActionEvent e)
        { 

//#if -318571923 
Object[] msgArgs = {
                Integer.valueOf((perspectiveList.getModel().getSize() + 1)),
            };
//#endif 


//#if 1643892794 
ExplorerPerspective newPers =
                new ExplorerPerspective(Translator.messageFormat(
                                            "dialog.perspective.explorer-perspective", msgArgs));
//#endif 


//#if -1074826493 
perspectiveListModel.insertElementAt(newPers, 0);
//#endif 


//#if -364371698 
perspectiveList.setSelectedValue(newPers, true);
//#endif 


//#if -849898477 
perspectiveRulesListModel.clear();
//#endif 


//#if 733591981 
updatePersLabel();
//#endif 


//#if -1276020813 
updateRuleLabel();
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1330806392 
class RulesListSelectionListener implements 
//#if 1755492629 
ListSelectionListener
//#endif 

  { 

//#if 176681970 
public void valueChanged(ListSelectionEvent lse)
        { 

//#if 1108694476 
if(lse.getValueIsAdjusting())//1
{ 

//#if -1811874012 
return;
//#endif 

} 

//#endif 


//#if -724100392 
Object selPers = null;
//#endif 


//#if 178413952 
if(perspectiveListModel.size() > 0)//1
{ 

//#if -1021356394 
selPers = perspectiveList.getSelectedValue();
//#endif 

} 

//#endif 


//#if -1378704802 
Object selRule = null;
//#endif 


//#if -742956107 
if(perspectiveRulesListModel.size() > 0)//1
{ 

//#if 1564867980 
selRule = perspectiveRulesList.getSelectedValue();
//#endif 

} 

//#endif 


//#if -22501387 
removeRuleButton.setEnabled(selPers != null && selRule != null);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 530195956 
class LibraryListSelectionListener implements 
//#if 1040432227 
ListSelectionListener
//#endif 

  { 

//#if 1726969152 
public void valueChanged(ListSelectionEvent lse)
        { 

//#if 128974352 
if(lse.getValueIsAdjusting())//1
{ 

//#if 1399538013 
return;
//#endif 

} 

//#endif 


//#if 1038838022 
Object selPers = perspectiveList.getSelectedValue();
//#endif 


//#if -470671121 
Object selRule = ruleLibraryList.getSelectedValue();
//#endif 


//#if 1120935086 
addRuleButton.setEnabled(selPers != null && selRule != null);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -464145774 
class DuplicatePerspectiveListener implements 
//#if 1097858417 
ActionListener
//#endif 

  { 

//#if -580713978 
public void actionPerformed(ActionEvent e)
        { 

//#if 1856346660 
Object sel = perspectiveList.getSelectedValue();
//#endif 


//#if 625027834 
if(sel != null)//1
{ 

//#if 1558867836 
Object[] msgArgs = {sel.toString() };
//#endif 


//#if 646669291 
ExplorerPerspective newPers =
                    ((ExplorerPerspective) sel).makeNamedClone(Translator
                            .messageFormat("dialog.perspective.copy-of", msgArgs));
//#endif 


//#if 332520985 
perspectiveListModel.insertElementAt(newPers, 0);
//#endif 


//#if -41878728 
perspectiveList.setSelectedValue(newPers, true);
//#endif 

} 

//#endif 


//#if -225665915 
updatePersLabel();
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 465188973 
class MoveUpListener implements 
//#if -845523743 
ActionListener
//#endif 

  { 

//#if 516745366 
public void actionPerformed(ActionEvent e)
        { 

//#if 1783357788 
int sel = perspectiveList.getSelectedIndex();
//#endif 


//#if -172306126 
if(sel > 0)//1
{ 

//#if 126596119 
Object selObj = perspectiveListModel.get(sel);
//#endif 


//#if -811079396 
Object prevObj = perspectiveListModel.get(sel - 1);
//#endif 


//#if 2109915524 
perspectiveListModel.set(sel, prevObj);
//#endif 


//#if -2111467459 
perspectiveListModel.set(sel - 1, selObj);
//#endif 


//#if -1188642698 
perspectiveList.setSelectedIndex(sel - 1);
//#endif 


//#if 1076148821 
perspectiveList.ensureIndexIsVisible(sel - 1);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#if 925738038 
class ResetListener implements 
//#if -184855585 
ActionListener
//#endif 

  { 

//#if 2038834008 
public void actionPerformed(ActionEvent e)
        { 

//#if -378663341 
Collection<ExplorerPerspective> c =
                PerspectiveManager.getInstance().getDefaultPerspectives();
//#endif 


//#if 1489763987 
if(c.size() > 0)//1
{ 

//#if 556059233 
perspectiveListModel.removeAllElements();
//#endif 


//#if 1007196999 
for (ExplorerPerspective p : c) //1
{ 

//#if -97131909 
perspectiveListModel.addElement(p);
//#endif 

} 

//#endif 


//#if 597216265 
updatePersLabel();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1952765594 
class RenameDocumentListener implements 
//#if 1831761198 
DocumentListener
//#endif 

  { 

//#if -132056158 
private void update()
        { 

//#if -1938679412 
int sel = perspectiveList.getSelectedIndex();
//#endif 


//#if -537212447 
Object selPers = perspectiveList.getSelectedValue();
//#endif 


//#if -640434734 
String newName = renameTextField.getText();
//#endif 


//#if -106871987 
if(sel >= 0 && newName.length() > 0)//1
{ 

//#if 2025233530 
((ExplorerPerspective) selPers).setName(newName);
//#endif 


//#if 461072012 
perspectiveListModel.set(sel, selPers);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 770567388 
public void changedUpdate(DocumentEvent e)
        { 

//#if -1717734408 
update();
//#endif 

} 

//#endif 


//#if -1477082908 
public void removeUpdate(DocumentEvent e)
        { 

//#if -1375735184 
update();
//#endif 

} 

//#endif 


//#if 2123138393 
public void insertUpdate(DocumentEvent e)
        { 

//#if 313849867 
update();
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1376177789 
class OkListener implements 
//#if 469377010 
ActionListener
//#endif 

  { 

//#if -576322907 
public void actionPerformed(ActionEvent e)
        { 

//#if -131897651 
PerspectiveManager.getInstance().removeAllPerspectives();
//#endif 


//#if -1695730963 
for (int i = 0; i < perspectiveListModel.size(); i++) //1
{ 

//#if -324614381 
ExplorerPerspective perspective =
                    (ExplorerPerspective) perspectiveListModel.get(i);
//#endif 


//#if 470917133 
PerspectiveManager.getInstance().addPerspective(perspective);
//#endif 

} 

//#endif 


//#if 1332204692 
PerspectiveManager.getInstance().saveUserPerspectives();
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 717408095 
class RenameListener implements 
//#if 255368663 
ActionListener
//#endif 

  { 

//#if 824541280 
public void actionPerformed(ActionEvent e)
        { 

//#if 68263087 
int sel = perspectiveList.getSelectedIndex();
//#endif 


//#if -717551266 
Object selPers = perspectiveList.getSelectedValue();
//#endif 


//#if -1733317195 
String newName = renameTextField.getText();
//#endif 


//#if -826139446 
if(sel >= 0 && newName.length() > 0)//1
{ 

//#if 986183816 
((ExplorerPerspective) selPers).setName(newName);
//#endif 


//#if 369089562 
perspectiveListModel.set(sel, selPers);
//#endif 


//#if -393187922 
perspectiveList.requestFocus();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

