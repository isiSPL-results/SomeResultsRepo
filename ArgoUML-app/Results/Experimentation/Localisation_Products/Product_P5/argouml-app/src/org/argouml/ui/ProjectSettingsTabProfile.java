package org.argouml.ui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.MutableComboBoxModel;
import javax.swing.filechooser.FileFilter;
import org.argouml.application.api.GUISettingsTabInterface;
import org.argouml.i18n.Translator;
import org.argouml.kernel.ProfileConfiguration;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.kernel.ProjectSettings;
import org.argouml.profile.Profile;
import org.argouml.profile.ProfileException;
import org.argouml.profile.ProfileFacade;
import org.argouml.profile.UserDefinedProfile;
import org.argouml.uml.diagram.DiagramAppearance;
public class ProjectSettingsTabProfile extends JPanel
 implements GUISettingsTabInterface
,ActionListener
  { 
private JButton loadFromFile = new JButton(Translator
            .localize("tab.profiles.userdefined.load"));
private JButton unregisterProfile = new JButton(Translator
            .localize("tab.profiles.userdefined.unload"));
private JButton addButton = new JButton(">>");
private JButton removeButton = new JButton("<<");
private JList availableList = new JList();
private JList usedList = new JList();
private JLabel stereoLabel = new JLabel(Translator
                                            .localize("menu.popup.stereotype-view")
                                            + ": ");
private JComboBox stereoField = new JComboBox();
public JPanel getTabPanel()
    { 
return this;
} 
public void handleResetToDefault()
    { 
refreshLists();
} 
private List<Profile> getAvailableProfiles()
    { 
List<Profile> used = getUsedProfiles();
List<Profile> ret = new ArrayList<Profile>();
for (Profile profile : ProfileFacade.getManager()
                .getRegisteredProfiles()) //1
{ 
if(!used.contains(profile))//1
{ 
ret.add(profile);
} 
} 
return ret;
} 
public ProjectSettingsTabProfile()
    { 
setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
JPanel setDefStereoV = new JPanel();
setDefStereoV.setLayout(new FlowLayout());
stereoLabel.setLabelFor(stereoField);
setDefStereoV.add(stereoLabel);
setDefStereoV.add(stereoField);
DefaultComboBoxModel cmodel = new DefaultComboBoxModel();
stereoField.setModel(cmodel);
cmodel.addElement(Translator
                          .localize("menu.popup.stereotype-view.textual"));
cmodel.addElement(Translator
                          .localize("menu.popup.stereotype-view.big-icon"));
cmodel.addElement(Translator
                          .localize("menu.popup.stereotype-view.small-icon"));
stereoField.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                ProjectSettings ps = ProjectManager.getManager()
                                     .getCurrentProject().getProjectSettings();
                Object src = e.getSource();

                if (src == stereoField) {
                    Object item = e.getItem();
                    DefaultComboBoxModel model =
                        (DefaultComboBoxModel) stereoField.getModel();
                    int idx = model.getIndexOf(item);

                    switch (idx) {
                    case 0:
                        ps.setDefaultStereotypeView(
                            DiagramAppearance.STEREOTYPE_VIEW_TEXTUAL);
                        break;
                    case 1:
                        ps.setDefaultStereotypeView(
                            DiagramAppearance.STEREOTYPE_VIEW_BIG_ICON);
                        break;
                    case 2:
                        ps.setDefaultStereotypeView(
                            DiagramAppearance.STEREOTYPE_VIEW_SMALL_ICON);
                        break;
                    }
                }
            }

        });
add(setDefStereoV);
JPanel configPanel = new JPanel();
configPanel.setLayout(new BoxLayout(configPanel, BoxLayout.X_AXIS));
availableList.setPrototypeCellValue("12345678901234567890");
usedList.setPrototypeCellValue("12345678901234567890");
availableList.setMinimumSize(new Dimension(50, 50));
usedList.setMinimumSize(new Dimension(50, 50));
JPanel leftList = new JPanel();
leftList.setLayout(new BorderLayout());
leftList.add(new JLabel(Translator
                                .localize("tab.profiles.userdefined.available")),
                     BorderLayout.NORTH);
leftList.add(new JScrollPane(availableList), BorderLayout.CENTER);
configPanel.add(leftList);
JPanel centerButtons = new JPanel();
centerButtons.setLayout(new BoxLayout(centerButtons, BoxLayout.Y_AXIS));
centerButtons.add(addButton);
centerButtons.add(removeButton);
configPanel.add(centerButtons);
JPanel rightList = new JPanel();
rightList.setLayout(new BorderLayout());
rightList.add(new JLabel(Translator
                                 .localize("tab.profiles.userdefined.active")),
                      BorderLayout.NORTH);
rightList.add(new JScrollPane(usedList), BorderLayout.CENTER);
configPanel.add(rightList);
addButton.addActionListener(this);
removeButton.addActionListener(this);
add(configPanel);
JPanel lffPanel = new JPanel();
lffPanel.setLayout(new FlowLayout());
lffPanel.add(unregisterProfile);
lffPanel.add(loadFromFile);
loadFromFile.addActionListener(this);
unregisterProfile.addActionListener(this);
add(lffPanel);
} 
private List<Profile> getActiveDependents(Profile selected)
    { 
MutableComboBoxModel modelUsd = ((MutableComboBoxModel) usedList
                                         .getModel());
List<Profile> ret = new ArrayList<Profile>();
for (int i = 0; i < modelUsd.getSize(); ++i) //1
{ 
Profile p = (Profile) modelUsd.getElementAt(i);
if(!p.equals(selected) && p.getDependencies().contains(selected))//1
{ 
ret.add(p);
} 
} 
return ret;
} 
public void handleSettingsTabCancel()
    { 
} 
private List<Profile> getUsedProfiles()
    { 
return new ArrayList<Profile>(ProjectManager.getManager()
                                      .getCurrentProject().getProfileConfiguration().getProfiles());
} 
public void handleSettingsTabRefresh()
    { 
ProjectSettings ps = ProjectManager.getManager().getCurrentProject()
                             .getProjectSettings();
switch (ps.getDefaultStereotypeViewValue()) //1
{ 
case DiagramAppearance.STEREOTYPE_VIEW_TEXTUAL://1

stereoField.setSelectedIndex(0);
break;


case DiagramAppearance.STEREOTYPE_VIEW_BIG_ICON://1

stereoField.setSelectedIndex(1);
break;


case DiagramAppearance.STEREOTYPE_VIEW_SMALL_ICON://1

stereoField.setSelectedIndex(2);
break;


} 
refreshLists();
} 
private List<Profile> getAvailableDependents(Profile selected)
    { 
MutableComboBoxModel modelAvl = ((MutableComboBoxModel) availableList
                                         .getModel());
List<Profile> ret = new ArrayList<Profile>();
for (int i = 0; i < modelAvl.getSize(); ++i) //1
{ 
Profile p = (Profile) modelAvl.getElementAt(i);
if(!p.equals(selected) && selected.getDependencies().contains(p))//1
{ 
ret.add(p);
} 
} 
return ret;
} 
public void handleSettingsTabSave()
    { 
List<Profile> toRemove = new ArrayList<Profile>();
Project proj = ProjectManager.getManager().getCurrentProject();
ProfileConfiguration pc = proj.getProfileConfiguration();
List<Profile> usedItens = new ArrayList<Profile>();
MutableComboBoxModel modelUsd = ((MutableComboBoxModel) usedList
                                         .getModel());
for (int i = 0; i < modelUsd.getSize(); ++i) //1
{ 
usedItens.add((Profile) modelUsd.getElementAt(i));
} 
for (Profile profile : pc.getProfiles()) //1
{ 
if(!usedItens.contains(profile))//1
{ 
toRemove.add(profile);
} 
} 
for (Profile profile : toRemove) //1
{ 
pc.removeProfile(profile);
} 
for (Profile profile : usedItens) //1
{ 
if(!pc.getProfiles().contains(profile))//1
{ 
pc.addProfile(profile);
} 
} 
proj.setProfileConfiguration(pc);
} 
public void actionPerformed(ActionEvent arg0)
    { 
MutableComboBoxModel modelAvailable =
            ((MutableComboBoxModel) availableList.getModel());
MutableComboBoxModel modelUsed =
            ((MutableComboBoxModel) usedList.getModel());
if(arg0.getSource() == addButton)//1
{ 
if(availableList.getSelectedIndex() != -1)//1
{ 
Profile selected = (Profile) modelAvailable
                                   .getElementAt(availableList.getSelectedIndex());
modelUsed.addElement(selected);
modelAvailable.removeElement(selected);
for (Profile profile : getAvailableDependents(selected)) //1
{ 
modelUsed.addElement(profile);
modelAvailable.removeElement(profile);
} 
} 
} 
else
if(arg0.getSource() == removeButton)//1
{ 
if(usedList.getSelectedIndex() != -1)//1
{ 
Profile selected = (Profile) modelUsed.getElementAt(usedList
                                   .getSelectedIndex());
List<Profile> dependents = getActiveDependents(selected);
boolean remove = true;
if(!dependents.isEmpty())//1
{ 
String message = Translator.localize(
                                         "tab.profiles.confirmdeletewithdependencies",
                                         new Object[] {dependents});
String title = Translator.localize(
                                       "tab.profiles.confirmdeletewithdependencies.title");
remove = (JOptionPane.showConfirmDialog(
                                  this, message, title, JOptionPane.YES_NO_OPTION)
                              == JOptionPane.YES_OPTION);
} 
if(remove)//1
{ 
if(!ProfileFacade.getManager().getRegisteredProfiles()
                            .contains(selected)
                            && !ProfileFacade.getManager().getDefaultProfiles()
                            .contains(selected))//1
{ 
remove = (JOptionPane
                                  .showConfirmDialog(
                                      this,
                                      Translator.localize(
                                          "tab.profiles.confirmdeleteunregistered"),
                                      Translator.localize(
                                          "tab.profiles.confirmdeleteunregistered.title"),
                                      JOptionPane.YES_NO_OPTION)
                                  == JOptionPane.YES_OPTION);
} 
if(remove)//1
{ 
modelUsed.removeElement(selected);
modelAvailable.addElement(selected);
for (Profile profile : dependents) //1
{ 
modelUsed.removeElement(profile);
modelAvailable.addElement(profile);
} 
} 
} 
} 
} 
else
if(arg0.getSource() == unregisterProfile)//1
{ 
if(availableList.getSelectedIndex() != -1)//1
{ 
Profile selected = (Profile) modelAvailable
                                   .getElementAt(availableList.getSelectedIndex());
if(selected instanceof UserDefinedProfile)//1
{ 
ProfileFacade.getManager().removeProfile(selected);
modelAvailable.removeElement(selected);
} 
else
{ 
JOptionPane.showMessageDialog(this, Translator
                                                  .localize("tab.profiles.cannotdelete"));
} 
} 
} 
else
if(arg0.getSource() == loadFromFile)//1
{ 
JFileChooser fileChooser = new JFileChooser();
fileChooser.setFileFilter(new FileFilter() {

                public boolean accept(File file) {
                    return file.isDirectory()
                           || (file.isFile() && (file.getName().endsWith(
                                                     ".xmi")
                                                 || file.getName().endsWith(".xml")
                                                 || file.getName().toLowerCase().endsWith(
                                                     ".xmi.zip")
                                                 || file.getName().toLowerCase().endsWith(".xml.zip")));
                }

                public String getDescription() {
                    return "*.xmi *.xml *.xmi.zip *.xml.zip";
                }

            });
int ret = fileChooser.showOpenDialog(this);
if(ret == JFileChooser.APPROVE_OPTION)//1
{ 
File file = fileChooser.getSelectedFile();
try//1
{ 
UserDefinedProfile profile = new UserDefinedProfile(file);
ProfileFacade.getManager().registerProfile(profile);
modelAvailable.addElement(profile);
} 
catch (ProfileException e) //1
{ 
JOptionPane.showMessageDialog(this, Translator
                                                  .localize("tab.profiles.userdefined.errorloading"));
} 
} 
} 
availableList.validate();
usedList.validate();
} 
private void refreshLists()
    { 
availableList.setModel(new DefaultComboBoxModel(getAvailableProfiles()
                               .toArray()));
usedList.setModel(
            new DefaultComboBoxModel(getUsedProfiles().toArray()));
} 
public String getTabKey()
    { 
return "tab.profiles";
} 

 } 
