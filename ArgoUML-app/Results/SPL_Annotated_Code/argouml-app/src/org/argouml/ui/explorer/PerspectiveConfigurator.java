// Compilation Unit of /PerspectiveConfigurator.java 
 
package org.argouml.ui.explorer;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.argouml.i18n.Translator;
import org.argouml.swingext.SpacerPanel;
import org.argouml.ui.explorer.rules.PerspectiveRule;
import org.argouml.util.ArgoDialog;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

public class PerspectiveConfigurator extends ArgoDialog
  { 
private static final int INSET_PX = 3;
private JPanel  configPanelNorth;
private JPanel  configPanelSouth;
private JSplitPane splitPane;
private JTextField renameTextField;
private JButton newPerspectiveButton;
private JButton removePerspectiveButton;
private JButton duplicatePerspectiveButton;
private JButton moveUpButton, moveDownButton;
private JButton addRuleButton;
private JButton removeRuleButton;
private JButton resetToDefaultButton;
private JList   perspectiveList;
private JList   perspectiveRulesList;
private JList   ruleLibraryList;
private DefaultListModel perspectiveListModel;
private DefaultListModel perspectiveRulesListModel;
private DefaultListModel ruleLibraryListModel;
private JLabel persLabel;
private JLabel ruleLibLabel;
private JLabel rulesLabel;

//#if LOGGING 
private static final Logger LOG =
        Logger.getLogger(PerspectiveConfigurator.class);
//#endif 

private void updatePersLabel()
    { 
persLabel.setText(Translator.localize("label.perspectives")
                          + " (" + perspectiveListModel.size() + ")");
} 

private void makeLayout()
    { 
GridBagLayout gb = new GridBagLayout();
configPanelNorth.setLayout(gb);
configPanelSouth.setLayout(gb);
GridBagConstraints c = new GridBagConstraints();
c.ipadx = 3;
c.ipady = 3;
persLabel = new JLabel();
persLabel.setBorder(BorderFactory.createEmptyBorder(
                                INSET_PX, INSET_PX, INSET_PX, INSET_PX));
c.fill = GridBagConstraints.BOTH;
c.gridx = 0;
c.gridy = 0;
c.gridwidth = 3;
c.weightx = 1.0;
c.weighty = 0.0;
gb.setConstraints(persLabel, c);
configPanelNorth.add(persLabel);
JPanel persPanel = new JPanel(new BorderLayout());
JScrollPane persScroll =
            new JScrollPane(perspectiveList,
                            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
persPanel.add(renameTextField, BorderLayout.NORTH);
persPanel.add(persScroll, BorderLayout.CENTER);
c.gridx = 0;
c.gridy = 1;
c.gridwidth = 4;
c.weightx = 1.0;
c.weighty = 1.0;
gb.setConstraints(persPanel, c);
configPanelNorth.add(persPanel);
JPanel persButtons = new JPanel(new GridLayout(6, 1, 0, 5));
persButtons.add(newPerspectiveButton);
persButtons.add(removePerspectiveButton);
persButtons.add(duplicatePerspectiveButton);
persButtons.add(moveUpButton);
persButtons.add(moveDownButton);
persButtons.add(resetToDefaultButton);
JPanel persButtonWrapper =
            new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
persButtonWrapper.add(persButtons);
c.gridx = 4;
c.gridy = 1;
c.gridwidth = 1;
c.weightx = 0.0;
c.weighty = 0.0;
c.ipadx = 0;
c.ipady = 0;
c.insets = new Insets(0, 5, 0, 0);
gb.setConstraints(persButtonWrapper, c);
configPanelNorth.add(persButtonWrapper);
ruleLibLabel = new JLabel();
ruleLibLabel.setBorder(BorderFactory.createEmptyBorder(
                                   INSET_PX, INSET_PX, INSET_PX, INSET_PX));
c.gridx = 0;
c.gridy = 3;
c.gridwidth = 1;
c.weightx = 1.0;
c.weighty = 0.0;
c.ipadx = 3;
c.ipady = 3;
c.insets = new Insets(10, 0, 0, 0);
gb.setConstraints(ruleLibLabel, c);
configPanelSouth.add(ruleLibLabel);
addRuleButton.setMargin(new Insets(2, 15, 2, 15));
removeRuleButton.setMargin(new Insets(2, 15, 2, 15));
JPanel xferButtons = new JPanel();
xferButtons.setLayout(new BoxLayout(xferButtons, BoxLayout.Y_AXIS));
xferButtons.add(addRuleButton);
xferButtons.add(new SpacerPanel());
xferButtons.add(removeRuleButton);
c.gridx = 2;
c.gridy = 4;
c.weightx = 0.0;
c.weighty = 0.0;
c.insets = new Insets(0, 3, 0, 5);
gb.setConstraints(xferButtons, c);
configPanelSouth.add(xferButtons);
rulesLabel = new JLabel();
rulesLabel.setBorder(BorderFactory.createEmptyBorder(
                                 INSET_PX, INSET_PX, INSET_PX, INSET_PX));
c.gridx = 3;
c.gridy = 3;
c.gridwidth = 1;
c.weightx = 1.0;
c.insets = new Insets(10, 0, 0, 0);
gb.setConstraints(rulesLabel, c);
configPanelSouth.add(rulesLabel);
c.gridx = 0;
c.gridy = 4;
c.weighty = 1.0;
c.gridwidth = 2;
c.gridheight = 2;
c.insets = new Insets(0, 0, 0, 0);
JScrollPane ruleLibScroll =
            new JScrollPane(ruleLibraryList,
                            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
gb.setConstraints(ruleLibScroll, c);
configPanelSouth.add(ruleLibScroll);
c.gridx = 3;
c.gridy = 4;
c.gridwidth = 2;
c.gridheight = 2;
JScrollPane rulesScroll =
            new JScrollPane(perspectiveRulesList,
                            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
gb.setConstraints(rulesScroll, c);
configPanelSouth.add(rulesScroll);
} 

private void doRemoveRule()
    { 
int selLibNr = ruleLibraryList.getSelectedIndex();
PerspectiveRule sel =
            (PerspectiveRule) perspectiveRulesList.getSelectedValue();
int selectedItem = perspectiveRulesList.getSelectedIndex();
Object selPers = perspectiveList.getSelectedValue();
perspectiveRulesListModel.removeElement(sel);
((ExplorerPerspective) selPers).removeRule(sel);
if(perspectiveRulesListModel.getSize() > selectedItem)//1
{ 
perspectiveRulesList.setSelectedIndex(selectedItem);
} 
else
if(perspectiveRulesListModel.getSize() > 0)//1
{ 
perspectiveRulesList.setSelectedIndex(
                perspectiveRulesListModel.getSize() - 1);
} 


loadLibrary();
ruleLibraryList.setSelectedIndex(selLibNr);
updateRuleLabel();
} 

private void doAddRule()
    { 
Object sel = ruleLibraryList.getSelectedValue();
int selLibNr = ruleLibraryList.getSelectedIndex();
try //1
{ 
PerspectiveRule newRule =
                (PerspectiveRule) sel.getClass().newInstance();
perspectiveRulesListModel.insertElementAt(newRule, 0);
((ExplorerPerspective) perspectiveList.getSelectedValue())
            .addRule(newRule);
sortJListModel(perspectiveRulesList);
perspectiveRulesList.setSelectedValue(newRule, true);
loadLibrary();
if(!(ruleLibraryListModel.size() > selLibNr))//1
{ 
selLibNr = ruleLibraryListModel.size() - 1;
} 

ruleLibraryList.setSelectedIndex(selLibNr);
updateRuleLabel();
} 
catch (Exception e) //1
{ 

//#if LOGGING 
LOG.error("problem adding rule", e);
//#endif 

} 


} 

private void updateRuleLabel()
    { 
rulesLabel.setText(Translator.localize("label.selected-rules")
                           + " (" + perspectiveRulesListModel.size() + ")");
} 

private void updateLibLabel()
    { 
ruleLibLabel.setText(Translator.localize("label.rules-library")
                             + " (" + ruleLibraryListModel.size() + ")");
} 

private void makeButtons()
    { 
newPerspectiveButton = new JButton();
nameButton(newPerspectiveButton, "button.new");
newPerspectiveButton.setToolTipText(
            Translator.localize("button.new.tooltip"));
removePerspectiveButton = new JButton();
nameButton(removePerspectiveButton, "button.remove");
removePerspectiveButton.setToolTipText(
            Translator.localize("button.remove.tooltip"));
duplicatePerspectiveButton = new JButton();
nameButton(duplicatePerspectiveButton, "button.duplicate");
duplicatePerspectiveButton.setToolTipText(
            Translator.localize("button.duplicate.tooltip"));
moveUpButton = new JButton();
nameButton(moveUpButton, "button.move-up");
moveUpButton.setToolTipText(
            Translator.localize("button.move-up.tooltip"));
moveDownButton = new JButton();
nameButton(moveDownButton, "button.move-down");
moveDownButton.setToolTipText(
            Translator.localize("button.move-down.tooltip"));
addRuleButton = new JButton(">>");
addRuleButton.setToolTipText(Translator.localize("button.add-rule"));
removeRuleButton = new JButton("<<");
removeRuleButton.setToolTipText(Translator.localize(
                                            "button.remove-rule"));
resetToDefaultButton = new JButton();
nameButton(resetToDefaultButton, "button.restore-defaults");
resetToDefaultButton.setToolTipText(
            Translator.localize("button.restore-defaults.tooltip"));
removePerspectiveButton.setEnabled(false);
duplicatePerspectiveButton.setEnabled(false);
moveUpButton.setEnabled(false);
moveDownButton.setEnabled(false);
addRuleButton.setEnabled(false);
removeRuleButton.setEnabled(false);
renameTextField.setEnabled(false);
} 

public PerspectiveConfigurator()
    { 
super(Translator.localize("dialog.title.configure-perspectives"),
              ArgoDialog.OK_CANCEL_OPTION,
              true);
configPanelNorth = new JPanel();
configPanelSouth = new JPanel();
makeLists();
makeButtons();
makeLayout();
updateRuleLabel();
makeListeners();
loadPerspectives();
loadLibrary();
splitPane =
            new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                           configPanelNorth, configPanelSouth);
splitPane.setContinuousLayout(true);
setContent(splitPane);
} 

private void sortJListModel(JList list)
    { 
DefaultListModel model = (DefaultListModel) list.getModel();
List all = new ArrayList();
for (int i = 0; i < model.getSize(); i++) //1
{ 
all.add(model.getElementAt(i));
} 

model.clear();
Collections.sort(all, new Comparator() {
            public int compare(Object o1, Object o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
for (Object obj : all) //1
{ 
model.addElement(obj);
} 

} 

private void makeLists()
    { 
renameTextField = new JTextField();
perspectiveListModel = new DefaultListModel();
perspectiveList = new JList(perspectiveListModel);
perspectiveRulesListModel = new DefaultListModel();
perspectiveRulesList = new JList(perspectiveRulesListModel);
ruleLibraryListModel = new DefaultListModel();
ruleLibraryList = new JList(ruleLibraryListModel);
perspectiveList.setBorder(BorderFactory.createEmptyBorder(
                                      INSET_PX, INSET_PX, INSET_PX, INSET_PX));
perspectiveRulesList.setBorder(BorderFactory.createEmptyBorder(
                                           INSET_PX, INSET_PX, INSET_PX, INSET_PX));
ruleLibraryList.setBorder(BorderFactory.createEmptyBorder(
                                      INSET_PX, INSET_PX, INSET_PX, INSET_PX));
perspectiveList.setSelectionMode(
            ListSelectionModel.SINGLE_SELECTION);
perspectiveRulesList.setSelectionMode(
            ListSelectionModel.SINGLE_SELECTION);
ruleLibraryList.setSelectionMode(
            ListSelectionModel.SINGLE_SELECTION);
} 

private void makeListeners()
    { 
renameTextField.addActionListener(new RenameListener());
renameTextField.getDocument().addDocumentListener(
            new RenameDocumentListener());
newPerspectiveButton.addActionListener(new NewPerspectiveListener());
removePerspectiveButton.addActionListener(
            new RemovePerspectiveListener());
duplicatePerspectiveButton.addActionListener(
            new DuplicatePerspectiveListener());
moveUpButton.addActionListener(new MoveUpListener());
moveDownButton.addActionListener(new MoveDownListener());
addRuleButton.addActionListener(new RuleListener());
removeRuleButton.addActionListener(new RuleListener());
resetToDefaultButton.addActionListener(new ResetListener());
perspectiveList.addListSelectionListener(
            new PerspectiveListSelectionListener());
perspectiveRulesList.addListSelectionListener(
            new RulesListSelectionListener());
perspectiveRulesList.addMouseListener(new RuleListMouseListener());
ruleLibraryList.addListSelectionListener(
            new LibraryListSelectionListener());
ruleLibraryList.addMouseListener(new RuleListMouseListener());
getOkButton().addActionListener(new OkListener());
} 

private void loadLibrary()
    { 
List<PerspectiveRule> rulesLib = new ArrayList<PerspectiveRule>();
rulesLib.addAll(PerspectiveManager.getInstance().getRules());
Collections.sort(rulesLib, new Comparator<PerspectiveRule>() {
            public int compare(PerspectiveRule o1, PerspectiveRule o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
ExplorerPerspective selPers =
            (ExplorerPerspective) perspectiveList.getSelectedValue();
if(selPers != null)//1
{ 
for (PerspectiveRule persRule : selPers.getList()) //1
{ 
for (PerspectiveRule libRule : rulesLib) //1
{ 
if(libRule.toString().equals(persRule.toString()))//1
{ 
rulesLib.remove(libRule);
break;

} 

} 

} 

} 

ruleLibraryListModel.clear();
for (PerspectiveRule rule : rulesLib) //1
{ 
ruleLibraryListModel.addElement(rule);
} 

updateLibLabel();
} 

private void loadPerspectives()
    { 
List<ExplorerPerspective> perspectives =
            PerspectiveManager.getInstance().getPerspectives();
for (ExplorerPerspective perspective : perspectives) //1
{ 
List<PerspectiveRule> rules = perspective.getList();
ExplorerPerspective editablePerspective =
                new ExplorerPerspective(perspective.toString());
for (PerspectiveRule rule : rules) //1
{ 
editablePerspective.addRule(rule);
} 

perspectiveListModel.addElement(editablePerspective);
} 

updatePersLabel();
} 

class PerspectiveListSelectionListener implements ListSelectionListener
  { 
public void valueChanged(ListSelectionEvent lse)
        { 
if(lse.getValueIsAdjusting())//1
{ 
return;
} 

Object selPers = perspectiveList.getSelectedValue();
loadLibrary();
Object selRule = ruleLibraryList.getSelectedValue();
renameTextField.setEnabled(selPers != null);
removePerspectiveButton.setEnabled(selPers != null);
duplicatePerspectiveButton.setEnabled(selPers != null);
moveUpButton.setEnabled(perspectiveList.getSelectedIndex() > 0);
moveDownButton.setEnabled((selPers != null)
                                      && (perspectiveList.getSelectedIndex()
                                          < (perspectiveList.getModel().getSize() - 1)));
if(selPers == null)//1
{ 
return;
} 

renameTextField.setText(selPers.toString());
ExplorerPerspective pers = (ExplorerPerspective) selPers;
perspectiveRulesListModel.clear();
for (PerspectiveRule rule : pers.getList()) //1
{ 
perspectiveRulesListModel.insertElementAt(rule, 0);
} 

sortJListModel(perspectiveRulesList);
addRuleButton.setEnabled(selPers != null && selRule != null);
updateRuleLabel();
} 

 } 

class RemovePerspectiveListener implements ActionListener
  { 
public void actionPerformed(ActionEvent e)
        { 
Object sel = perspectiveList.getSelectedValue();
if(perspectiveListModel.getSize() > 1)//1
{ 
perspectiveListModel.removeElement(sel);
} 

perspectiveList.setSelectedIndex(0);
if(perspectiveListModel.getSize() == 1)//1
{ 
removePerspectiveButton.setEnabled(false);
} 

updatePersLabel();
} 

 } 

class MoveDownListener implements ActionListener
  { 
public void actionPerformed(ActionEvent e)
        { 
int sel = perspectiveList.getSelectedIndex();
if(sel < (perspectiveListModel.getSize() - 1))//1
{ 
Object selObj = perspectiveListModel.get(sel);
Object nextObj = perspectiveListModel.get(sel + 1);
perspectiveListModel.set(sel, nextObj);
perspectiveListModel.set(sel + 1, selObj);
perspectiveList.setSelectedIndex(sel + 1);
perspectiveList.ensureIndexIsVisible(sel + 1);
} 

} 

 } 

class RuleListener implements ActionListener
  { 
public void actionPerformed(ActionEvent e)
        { 
Object src = e.getSource();
if(perspectiveList.getSelectedValue() == null)//1
{ 
return;
} 

if(src == addRuleButton)//1
{ 
doAddRule();
} 
else
if(src == removeRuleButton)//1
{ 
doRemoveRule();
} 


} 

 } 

class RuleListMouseListener extends MouseAdapter
  { 
public void mouseClicked(MouseEvent me)
        { 
Object src = me.getSource();
if(me.getClickCount() != 2
                    || perspectiveList.getSelectedValue() == null)//1
{ 
return;
} 

if(src == ruleLibraryList && addRuleButton.isEnabled())//1
{ 
doAddRule();
} 

if(src == perspectiveRulesList && removeRuleButton.isEnabled())//1
{ 
doRemoveRule();
} 

} 

 } 

class NewPerspectiveListener implements ActionListener
  { 
public void actionPerformed(ActionEvent e)
        { 
Object[] msgArgs = {
                Integer.valueOf((perspectiveList.getModel().getSize() + 1)),
            };
ExplorerPerspective newPers =
                new ExplorerPerspective(Translator.messageFormat(
                                            "dialog.perspective.explorer-perspective", msgArgs));
perspectiveListModel.insertElementAt(newPers, 0);
perspectiveList.setSelectedValue(newPers, true);
perspectiveRulesListModel.clear();
updatePersLabel();
updateRuleLabel();
} 

 } 

class RulesListSelectionListener implements ListSelectionListener
  { 
public void valueChanged(ListSelectionEvent lse)
        { 
if(lse.getValueIsAdjusting())//1
{ 
return;
} 

Object selPers = null;
if(perspectiveListModel.size() > 0)//1
{ 
selPers = perspectiveList.getSelectedValue();
} 

Object selRule = null;
if(perspectiveRulesListModel.size() > 0)//1
{ 
selRule = perspectiveRulesList.getSelectedValue();
} 

removeRuleButton.setEnabled(selPers != null && selRule != null);
} 

 } 

class LibraryListSelectionListener implements ListSelectionListener
  { 
public void valueChanged(ListSelectionEvent lse)
        { 
if(lse.getValueIsAdjusting())//1
{ 
return;
} 

Object selPers = perspectiveList.getSelectedValue();
Object selRule = ruleLibraryList.getSelectedValue();
addRuleButton.setEnabled(selPers != null && selRule != null);
} 

 } 

class DuplicatePerspectiveListener implements ActionListener
  { 
public void actionPerformed(ActionEvent e)
        { 
Object sel = perspectiveList.getSelectedValue();
if(sel != null)//1
{ 
Object[] msgArgs = {sel.toString() };
ExplorerPerspective newPers =
                    ((ExplorerPerspective) sel).makeNamedClone(Translator
                            .messageFormat("dialog.perspective.copy-of", msgArgs));
perspectiveListModel.insertElementAt(newPers, 0);
perspectiveList.setSelectedValue(newPers, true);
} 

updatePersLabel();
} 

 } 

class MoveUpListener implements ActionListener
  { 
public void actionPerformed(ActionEvent e)
        { 
int sel = perspectiveList.getSelectedIndex();
if(sel > 0)//1
{ 
Object selObj = perspectiveListModel.get(sel);
Object prevObj = perspectiveListModel.get(sel - 1);
perspectiveListModel.set(sel, prevObj);
perspectiveListModel.set(sel - 1, selObj);
perspectiveList.setSelectedIndex(sel - 1);
perspectiveList.ensureIndexIsVisible(sel - 1);
} 

} 

 } 

class ResetListener implements ActionListener
  { 
public void actionPerformed(ActionEvent e)
        { 
Collection<ExplorerPerspective> c =
                PerspectiveManager.getInstance().getDefaultPerspectives();
if(c.size() > 0)//1
{ 
perspectiveListModel.removeAllElements();
for (ExplorerPerspective p : c) //1
{ 
perspectiveListModel.addElement(p);
} 

updatePersLabel();
} 

} 

 } 

class RenameDocumentListener implements DocumentListener
  { 
private void update()
        { 
int sel = perspectiveList.getSelectedIndex();
Object selPers = perspectiveList.getSelectedValue();
String newName = renameTextField.getText();
if(sel >= 0 && newName.length() > 0)//1
{ 
((ExplorerPerspective) selPers).setName(newName);
perspectiveListModel.set(sel, selPers);
} 

} 

public void changedUpdate(DocumentEvent e)
        { 
update();
} 

public void removeUpdate(DocumentEvent e)
        { 
update();
} 

public void insertUpdate(DocumentEvent e)
        { 
update();
} 

 } 

class OkListener implements ActionListener
  { 
public void actionPerformed(ActionEvent e)
        { 
PerspectiveManager.getInstance().removeAllPerspectives();
for (int i = 0; i < perspectiveListModel.size(); i++) //1
{ 
ExplorerPerspective perspective =
                    (ExplorerPerspective) perspectiveListModel.get(i);
PerspectiveManager.getInstance().addPerspective(perspective);
} 

PerspectiveManager.getInstance().saveUserPerspectives();
} 

 } 

class RenameListener implements ActionListener
  { 
public void actionPerformed(ActionEvent e)
        { 
int sel = perspectiveList.getSelectedIndex();
Object selPers = perspectiveList.getSelectedValue();
String newName = renameTextField.getText();
if(sel >= 0 && newName.length() > 0)//1
{ 
((ExplorerPerspective) selPers).setName(newName);
perspectiveListModel.set(sel, selPers);
perspectiveList.requestFocus();
} 

} 

 } 

 } 


