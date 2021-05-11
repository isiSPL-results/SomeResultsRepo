package org.argouml.ui;
import java.awt.BorderLayout;
import java.awt.Component;
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
import org.argouml.configuration.Configuration;
import org.argouml.i18n.Translator;
import org.argouml.kernel.ProfileConfiguration;
import org.argouml.profile.Profile;
import org.argouml.profile.ProfileException;
import org.argouml.profile.ProfileFacade;
import org.argouml.profile.UserDefinedProfile;
import org.argouml.profile.UserDefinedProfileHelper;
import org.argouml.swingext.JLinkButton;
import org.argouml.uml.diagram.DiagramAppearance;
public class SettingsTabProfile extends JPanel
 implements GUISettingsTabInterface
,ActionListener
  { 
private JButton loadFromFile = new JButton(Translator
            .localize("tab.profiles.userdefined.load"));
private JButton addButton = new JButton(">>");
private JButton removeButton = new JButton("<<");
private JList availableList = new JList();
private JList defaultList = new JList();
private JList directoryList = new JList();
private JButton addDirectory = new JButton(Translator
            .localize("tab.profiles.directories.add"));
private JButton removeDirectory = new JButton(Translator
            .localize("tab.profiles.directories.remove"));
private JButton refreshProfiles = new JButton(Translator
            .localize("tab.profiles.directories.refresh"));
private JLabel stereoLabel = new JLabel(Translator
                                            .localize("menu.popup.stereotype-view")
                                            + ": ");
private JComboBox stereoField = new JComboBox();
private void refreshLists()
    { 
availableList.setModel(new DefaultComboBoxModel(getAvailableProfiles()
                               .toArray()));
defaultList.setModel(new DefaultComboBoxModel(getUsedProfiles()
                             .toArray()));
directoryList.setModel(new DefaultComboBoxModel(ProfileFacade
                               .getManager().getSearchPathDirectories().toArray()));
} 
public void handleSettingsTabRefresh()
    { 
refreshLists();
switch (Configuration.getInteger(
                    ProfileConfiguration.KEY_DEFAULT_STEREOTYPE_VIEW,
                    DiagramAppearance.STEREOTYPE_VIEW_TEXTUAL)) //1
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
} 
public String getTabKey()
    { 
return "tab.profiles";
} 
public void handleSettingsTabCancel()
    { 
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
public SettingsTabProfile()
    { 
setLayout(new BorderLayout());
JPanel warning = new JPanel();
warning.setLayout(new BoxLayout(warning, BoxLayout.PAGE_AXIS));
JLabel warningLabel = new JLabel(Translator.localize("label.warning"));
warningLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
warning.add(warningLabel);
JLinkButton projectSettings = new JLinkButton();
projectSettings.setAction(new ActionProjectSettings());
projectSettings.setText(Translator.localize("button.project-settings"));
projectSettings.setIcon(null);
projectSettings.setAlignmentX(Component.RIGHT_ALIGNMENT);
warning.add(projectSettings);
add(warning, BorderLayout.NORTH);
JPanel profileSettings = new JPanel();
profileSettings.setLayout(new BoxLayout(profileSettings,
                                                BoxLayout.Y_AXIS));
profileSettings.add(initDefaultStereotypeViewSelector());
directoryList
        .setPrototypeCellValue("123456789012345678901234567890123456789012345678901234567890");
directoryList.setMinimumSize(new Dimension(50, 50));
JPanel sdirPanel = new JPanel();
sdirPanel.setLayout(new BoxLayout(sdirPanel, BoxLayout.Y_AXIS));
JPanel dlist = new JPanel();
dlist.setLayout(new BorderLayout());
JPanel lcb = new JPanel();
lcb.setLayout(new BoxLayout(lcb, BoxLayout.Y_AXIS));
lcb.add(addDirectory);
lcb.add(removeDirectory);
addDirectory.addActionListener(this);
removeDirectory.addActionListener(this);
dlist.add(new JScrollPane(directoryList), BorderLayout.CENTER);
dlist.add(lcb, BorderLayout.EAST);
sdirPanel.add(new JLabel(Translator
                                 .localize("tab.profiles.directories.desc")));
sdirPanel.add(dlist);
profileSettings.add(sdirPanel);
JPanel configPanel = new JPanel();
configPanel.setLayout(new BoxLayout(configPanel, BoxLayout.X_AXIS));
availableList.setPrototypeCellValue("12345678901234567890");
defaultList.setPrototypeCellValue("12345678901234567890");
availableList.setMinimumSize(new Dimension(50, 50));
defaultList.setMinimumSize(new Dimension(50, 50));
refreshLists();
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
                                 .localize("tab.profiles.userdefined.default")),
                      BorderLayout.NORTH);
rightList.add(new JScrollPane(defaultList), BorderLayout.CENTER);
configPanel.add(rightList);
addButton.addActionListener(this);
removeButton.addActionListener(this);
profileSettings.add(configPanel);
JPanel lffPanel = new JPanel();
lffPanel.setLayout(new FlowLayout());
lffPanel.add(loadFromFile);
lffPanel.add(refreshProfiles);
loadFromFile.addActionListener(this);
refreshProfiles.addActionListener(this);
profileSettings.add(lffPanel);
add(profileSettings, BorderLayout.CENTER);
} 
public JPanel getTabPanel()
    { 
return this;
} 
public void handleSettingsTabSave()
    { 
List<Profile> toRemove = new ArrayList<Profile>();
List<Profile> usedItens = new ArrayList<Profile>();
MutableComboBoxModel modelUsd = ((MutableComboBoxModel) defaultList
                                         .getModel());
MutableComboBoxModel modelDir = ((MutableComboBoxModel) directoryList
                                         .getModel());
for (int i = 0; i < modelUsd.getSize(); ++i) //1
{ 
usedItens.add((Profile) modelUsd.getElementAt(i));
} 
for (Profile profile : ProfileFacade.getManager().getDefaultProfiles()) //1
{ 
if(!usedItens.contains(profile))//1
{ 
toRemove.add(profile);
} 
} 
for (Profile profile : toRemove) //1
{ 
ProfileFacade.getManager().removeFromDefaultProfiles(profile);
} 
for (Profile profile : usedItens) //1
{ 
if(!ProfileFacade.getManager().getDefaultProfiles().contains(
                        profile))//1
{ 
ProfileFacade.getManager().addToDefaultProfiles(profile);
} 
} 
List<String> toRemoveDir = new ArrayList<String>();
List<String> usedItensDir = new ArrayList<String>();
for (int i = 0; i < modelDir.getSize(); ++i) //1
{ 
usedItensDir.add((String) modelDir.getElementAt(i));
} 
for (String dirEntry : ProfileFacade.getManager()
                .getSearchPathDirectories()) //1
{ 
if(!usedItensDir.contains(dirEntry))//1
{ 
toRemoveDir.add(dirEntry);
} 
} 
for (String dirEntry : toRemoveDir) //1
{ 
ProfileFacade.getManager().removeSearchPathDirectory(dirEntry);
} 
for (String dirEntry : usedItensDir) //1
{ 
if(!ProfileFacade.getManager().getSearchPathDirectories()
                    .contains(dirEntry))//1
{ 
ProfileFacade.getManager().addSearchPathDirectory(dirEntry);
} 
} 
} 
private List<Profile> getUsedProfiles()
    { 
return new ArrayList<Profile>(ProfileFacade.getManager()
                                      .getDefaultProfiles());
} 
public void handleResetToDefault()
    { 
refreshLists();
} 
private JPanel initDefaultStereotypeViewSelector()
    { 
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
                Object src = e.getSource();

                if (src == stereoField) {
                    Object item = e.getItem();
                    DefaultComboBoxModel model = (DefaultComboBoxModel) stereoField
                                                 .getModel();
                    int idx = model.getIndexOf(item);

                    switch (idx) {
                    case 0:
                        Configuration
                        .setInteger(
                            ProfileConfiguration.KEY_DEFAULT_STEREOTYPE_VIEW,
                            DiagramAppearance.STEREOTYPE_VIEW_TEXTUAL);
                        break;
                    case 1:
                        Configuration
                        .setInteger(
                            ProfileConfiguration.KEY_DEFAULT_STEREOTYPE_VIEW,
                            DiagramAppearance.STEREOTYPE_VIEW_BIG_ICON);
                        break;
                    case 2:
                        Configuration
                        .setInteger(
                            ProfileConfiguration.KEY_DEFAULT_STEREOTYPE_VIEW,
                            DiagramAppearance.STEREOTYPE_VIEW_SMALL_ICON);
                        break;
                    }
                }
            }

        });
return setDefStereoV;
} 
public void actionPerformed(ActionEvent arg0)
    { 
MutableComboBoxModel modelAvl = ((MutableComboBoxModel) availableList
                                         .getModel());
MutableComboBoxModel modelUsd = ((MutableComboBoxModel) defaultList
                                         .getModel());
if(arg0.getSource() == addButton)//1
{ 
if(availableList.getSelectedIndex() != -1)//1
{ 
Profile selected = (Profile) modelAvl
                                   .getElementAt(availableList.getSelectedIndex());
modelUsd.addElement(selected);
modelAvl.removeElement(selected);
} 
} 
else
if(arg0.getSource() == removeButton)//1
{ 
if(defaultList.getSelectedIndex() != -1)//1
{ 
Profile selected = (Profile) modelUsd.getElementAt(defaultList
                                   .getSelectedIndex());
if(selected == ProfileFacade.getManager().getUMLProfile())//1
{ 
JOptionPane.showMessageDialog(this, Translator
                                                  .localize("tab.profiles.cantremoveuml"));
} 
else
{ 
modelUsd.removeElement(selected);
modelAvl.addElement(selected);
} 
} 
} 
else
if(arg0.getSource() == loadFromFile)//1
{ 
JFileChooser fileChooser =
                UserDefinedProfileHelper.createUserDefinedProfileFileChooser();
int ret = fileChooser.showOpenDialog(this);
List<File> files = null;
if(ret == JFileChooser.APPROVE_OPTION)//1
{ 
files = UserDefinedProfileHelper.getFileList(
                            fileChooser.getSelectedFiles());
} 
if(files != null && files.size() > 0)//1
{ 
for (File file : files) //1
{ 
try//1
{ 
UserDefinedProfile profile =
                            new UserDefinedProfile(file);
ProfileFacade.getManager().registerProfile(profile);
modelAvl.addElement(profile);
} 
catch (ProfileException e) //1
{ 
JOptionPane.showMessageDialog(this, Translator
                                                      .localize("tab.profiles.userdefined.errorloading")
                                                      + ": " + file.getAbsolutePath());
} 
} 
} 
} 
else
if(arg0.getSource() == removeDirectory)//1
{ 
if(directoryList.getSelectedIndex() != -1)//1
{ 
int idx = directoryList.getSelectedIndex();
((MutableComboBoxModel) directoryList.getModel())
                .removeElementAt(idx);
} 
} 
else
if(arg0.getSource() == refreshProfiles)//1
{ 
boolean refresh = JOptionPane.showConfirmDialog(this, Translator
                              .localize("tab.profiles.confirmrefresh"), Translator
                              .localize("tab.profiles.confirmrefresh.title"),
                              JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
if(refresh)//1
{ 
handleSettingsTabSave();
ProfileFacade.getManager().refreshRegisteredProfiles();
refreshLists();
} 
} 
else
if(arg0.getSource() == addDirectory)//1
{ 
JFileChooser fileChooser = new JFileChooser();
fileChooser.setFileFilter(new FileFilter() {

                public boolean accept(File file) {
                    return file.isDirectory();
                }

                public String getDescription() {
                    return "Directories";
                }

            });
fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
int ret = fileChooser.showOpenDialog(this);
if(ret == JFileChooser.APPROVE_OPTION)//1
{ 
File file = fileChooser.getSelectedFile();
String path = file.getAbsolutePath();
((MutableComboBoxModel) directoryList.getModel())
                .addElement(path);
} 
} 
availableList.validate();
defaultList.validate();
} 

 } 
