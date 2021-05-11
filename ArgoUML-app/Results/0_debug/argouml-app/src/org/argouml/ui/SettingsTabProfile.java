
//#if -1882063227 
// Compilation Unit of /SettingsTabProfile.java 
 

//#if 1613881468 
package org.argouml.ui;
//#endif 


//#if 204977414 
import java.awt.BorderLayout;
//#endif 


//#if -426030595 
import java.awt.Component;
//#endif 


//#if 435750580 
import java.awt.Dimension;
//#endif 


//#if 2109869572 
import java.awt.FlowLayout;
//#endif 


//#if -357540438 
import java.awt.event.ActionEvent;
//#endif 


//#if -1217579874 
import java.awt.event.ActionListener;
//#endif 


//#if 491037063 
import java.awt.event.ItemEvent;
//#endif 


//#if -1422751839 
import java.awt.event.ItemListener;
//#endif 


//#if -1255360346 
import java.io.File;
//#endif 


//#if -1347635743 
import java.util.ArrayList;
//#endif 


//#if -632514592 
import java.util.List;
//#endif 


//#if 1583279051 
import javax.swing.BoxLayout;
//#endif 


//#if 1487547307 
import javax.swing.DefaultComboBoxModel;
//#endif 


//#if 2087651972 
import javax.swing.JButton;
//#endif 


//#if -1329736967 
import javax.swing.JComboBox;
//#endif 


//#if -77858399 
import javax.swing.JFileChooser;
//#endif 


//#if 1304445228 
import javax.swing.JLabel;
//#endif 


//#if -1481686696 
import javax.swing.JList;
//#endif 


//#if -1779120103 
import javax.swing.JOptionPane;
//#endif 


//#if 1419319324 
import javax.swing.JPanel;
//#endif 


//#if 644784321 
import javax.swing.JScrollPane;
//#endif 


//#if 1124259792 
import javax.swing.MutableComboBoxModel;
//#endif 


//#if -1619243565 
import javax.swing.filechooser.FileFilter;
//#endif 


//#if 71988133 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if 532861367 
import org.argouml.configuration.Configuration;
//#endif 


//#if 700137483 
import org.argouml.i18n.Translator;
//#endif 


//#if -800255849 
import org.argouml.kernel.ProfileConfiguration;
//#endif 


//#if -1508384495 
import org.argouml.profile.Profile;
//#endif 


//#if -458963498 
import org.argouml.profile.ProfileException;
//#endif 


//#if 1195402007 
import org.argouml.profile.ProfileFacade;
//#endif 


//#if -2071610671 
import org.argouml.profile.UserDefinedProfile;
//#endif 


//#if 637104195 
import org.argouml.profile.UserDefinedProfileHelper;
//#endif 


//#if -1949473130 
import org.argouml.swingext.JLinkButton;
//#endif 


//#if -1150959341 
import org.argouml.uml.diagram.DiagramAppearance;
//#endif 


//#if 1520220270 
public class SettingsTabProfile extends 
//#if -1256021353 
JPanel
//#endif 

 implements 
//#if 1041460613 
GUISettingsTabInterface
//#endif 

, 
//#if -1444824345 
ActionListener
//#endif 

  { 

//#if 2090840788 
private JButton loadFromFile = new JButton(Translator
            .localize("tab.profiles.userdefined.load"));
//#endif 


//#if -18419842 
private JButton addButton = new JButton(">>");
//#endif 


//#if 822098893 
private JButton removeButton = new JButton("<<");
//#endif 


//#if -521071366 
private JList availableList = new JList();
//#endif 


//#if -1524297742 
private JList defaultList = new JList();
//#endif 


//#if -1902387042 
private JList directoryList = new JList();
//#endif 


//#if 1200800626 
private JButton addDirectory = new JButton(Translator
            .localize("tab.profiles.directories.add"));
//#endif 


//#if -57017610 
private JButton removeDirectory = new JButton(Translator
            .localize("tab.profiles.directories.remove"));
//#endif 


//#if 734530399 
private JButton refreshProfiles = new JButton(Translator
            .localize("tab.profiles.directories.refresh"));
//#endif 


//#if 407198735 
private JLabel stereoLabel = new JLabel(Translator
                                            .localize("menu.popup.stereotype-view")
                                            + ": ");
//#endif 


//#if -853420777 
private JComboBox stereoField = new JComboBox();
//#endif 


//#if 1468072821 
private void refreshLists()
    { 

//#if -120449519 
availableList.setModel(new DefaultComboBoxModel(getAvailableProfiles()
                               .toArray()));
//#endif 


//#if -858634625 
defaultList.setModel(new DefaultComboBoxModel(getUsedProfiles()
                             .toArray()));
//#endif 


//#if -1623284619 
directoryList.setModel(new DefaultComboBoxModel(ProfileFacade
                               .getManager().getSearchPathDirectories().toArray()));
//#endif 

} 

//#endif 


//#if -96752052 
public void handleSettingsTabRefresh()
    { 

//#if -1998371193 
refreshLists();
//#endif 


//#if 2089565698 
switch (Configuration.getInteger(
                    ProfileConfiguration.KEY_DEFAULT_STEREOTYPE_VIEW,
                    DiagramAppearance.STEREOTYPE_VIEW_TEXTUAL)) //1
{ 
case DiagramAppearance.STEREOTYPE_VIEW_TEXTUAL://1


//#if 1158234444 
stereoField.setSelectedIndex(0);
//#endif 


//#if -772945491 
break;

//#endif 


case DiagramAppearance.STEREOTYPE_VIEW_BIG_ICON://1


//#if 441377735 
stereoField.setSelectedIndex(1);
//#endif 


//#if 1735875815 
break;

//#endif 


case DiagramAppearance.STEREOTYPE_VIEW_SMALL_ICON://1


//#if 840919747 
stereoField.setSelectedIndex(2);
//#endif 


//#if -1443105822 
break;

//#endif 


} 

//#endif 

} 

//#endif 


//#if 337246538 
public String getTabKey()
    { 

//#if -1242898620 
return "tab.profiles";
//#endif 

} 

//#endif 


//#if 861746635 
public void handleSettingsTabCancel()
    { 
} 

//#endif 


//#if 1319641995 
private List<Profile> getAvailableProfiles()
    { 

//#if 502839910 
List<Profile> used = getUsedProfiles();
//#endif 


//#if -1668165613 
List<Profile> ret = new ArrayList<Profile>();
//#endif 


//#if 129667135 
for (Profile profile : ProfileFacade.getManager()
                .getRegisteredProfiles()) //1
{ 

//#if -1983553814 
if(!used.contains(profile))//1
{ 

//#if -351141683 
ret.add(profile);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -909779034 
return ret;
//#endif 

} 

//#endif 


//#if 785684062 
public SettingsTabProfile()
    { 

//#if -1915440471 
setLayout(new BorderLayout());
//#endif 


//#if 157943327 
JPanel warning = new JPanel();
//#endif 


//#if -739648012 
warning.setLayout(new BoxLayout(warning, BoxLayout.PAGE_AXIS));
//#endif 


//#if -1212375751 
JLabel warningLabel = new JLabel(Translator.localize("label.warning"));
//#endif 


//#if 1192928798 
warningLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
//#endif 


//#if -626088985 
warning.add(warningLabel);
//#endif 


//#if -268127919 
JLinkButton projectSettings = new JLinkButton();
//#endif 


//#if -6880449 
projectSettings.setAction(new ActionProjectSettings());
//#endif 


//#if -2024030428 
projectSettings.setText(Translator.localize("button.project-settings"));
//#endif 


//#if 1055983516 
projectSettings.setIcon(null);
//#endif 


//#if 1032777274 
projectSettings.setAlignmentX(Component.RIGHT_ALIGNMENT);
//#endif 


//#if 1613600625 
warning.add(projectSettings);
//#endif 


//#if -1975354694 
add(warning, BorderLayout.NORTH);
//#endif 


//#if 221620431 
JPanel profileSettings = new JPanel();
//#endif 


//#if -997058198 
profileSettings.setLayout(new BoxLayout(profileSettings,
                                                BoxLayout.Y_AXIS));
//#endif 


//#if 539377037 
profileSettings.add(initDefaultStereotypeViewSelector());
//#endif 


//#if 977353808 
directoryList
        .setPrototypeCellValue("123456789012345678901234567890123456789012345678901234567890");
//#endif 


//#if 80267389 
directoryList.setMinimumSize(new Dimension(50, 50));
//#endif 


//#if -1313783279 
JPanel sdirPanel = new JPanel();
//#endif 


//#if 1916130154 
sdirPanel.setLayout(new BoxLayout(sdirPanel, BoxLayout.Y_AXIS));
//#endif 


//#if -760091655 
JPanel dlist = new JPanel();
//#endif 


//#if 1105619901 
dlist.setLayout(new BorderLayout());
//#endif 


//#if -426248368 
JPanel lcb = new JPanel();
//#endif 


//#if -1612387702 
lcb.setLayout(new BoxLayout(lcb, BoxLayout.Y_AXIS));
//#endif 


//#if -1787534228 
lcb.add(addDirectory);
//#endif 


//#if 1962793741 
lcb.add(removeDirectory);
//#endif 


//#if 608120171 
addDirectory.addActionListener(this);
//#endif 


//#if -1985928682 
removeDirectory.addActionListener(this);
//#endif 


//#if 2080601667 
dlist.add(new JScrollPane(directoryList), BorderLayout.CENTER);
//#endif 


//#if -806995729 
dlist.add(lcb, BorderLayout.EAST);
//#endif 


//#if 1882897087 
sdirPanel.add(new JLabel(Translator
                                 .localize("tab.profiles.directories.desc")));
//#endif 


//#if -1778093659 
sdirPanel.add(dlist);
//#endif 


//#if -1786791921 
profileSettings.add(sdirPanel);
//#endif 


//#if -923244391 
JPanel configPanel = new JPanel();
//#endif 


//#if -100726743 
configPanel.setLayout(new BoxLayout(configPanel, BoxLayout.X_AXIS));
//#endif 


//#if -278666784 
availableList.setPrototypeCellValue("12345678901234567890");
//#endif 


//#if 1708344424 
defaultList.setPrototypeCellValue("12345678901234567890");
//#endif 


//#if 1527772065 
availableList.setMinimumSize(new Dimension(50, 50));
//#endif 


//#if 693592105 
defaultList.setMinimumSize(new Dimension(50, 50));
//#endif 


//#if 1343954204 
refreshLists();
//#endif 


//#if 2011773722 
JPanel leftList = new JPanel();
//#endif 


//#if 603901512 
leftList.setLayout(new BorderLayout());
//#endif 


//#if 1112628004 
leftList.add(new JLabel(Translator
                                .localize("tab.profiles.userdefined.available")),
                     BorderLayout.NORTH);
//#endif 


//#if -947705038 
leftList.add(new JScrollPane(availableList), BorderLayout.CENTER);
//#endif 


//#if -1826796370 
configPanel.add(leftList);
//#endif 


//#if -720939057 
JPanel centerButtons = new JPanel();
//#endif 


//#if 1508694570 
centerButtons.setLayout(new BoxLayout(centerButtons, BoxLayout.Y_AXIS));
//#endif 


//#if 925468056 
centerButtons.add(addButton);
//#endif 


//#if -288758347 
centerButtons.add(removeButton);
//#endif 


//#if 173589127 
configPanel.add(centerButtons);
//#endif 


//#if 702951969 
JPanel rightList = new JPanel();
//#endif 


//#if 2075598229 
rightList.setLayout(new BorderLayout());
//#endif 


//#if -1230390871 
rightList.add(new JLabel(Translator
                                 .localize("tab.profiles.userdefined.default")),
                      BorderLayout.NORTH);
//#endif 


//#if 112490567 
rightList.add(new JScrollPane(defaultList), BorderLayout.CENTER);
//#endif 


//#if -424344843 
configPanel.add(rightList);
//#endif 


//#if 887765868 
addButton.addActionListener(this);
//#endif 


//#if 1714781857 
removeButton.addActionListener(this);
//#endif 


//#if -968255929 
profileSettings.add(configPanel);
//#endif 


//#if -941509625 
JPanel lffPanel = new JPanel();
//#endif 


//#if 433265661 
lffPanel.setLayout(new FlowLayout());
//#endif 


//#if 767226583 
lffPanel.add(loadFromFile);
//#endif 


//#if -1051329570 
lffPanel.add(refreshProfiles);
//#endif 


//#if 2144381163 
loadFromFile.addActionListener(this);
//#endif 


//#if -1754633222 
refreshProfiles.addActionListener(this);
//#endif 


//#if 344255895 
profileSettings.add(lffPanel);
//#endif 


//#if 464246548 
add(profileSettings, BorderLayout.CENTER);
//#endif 

} 

//#endif 


//#if -463676378 
public JPanel getTabPanel()
    { 

//#if -1387234323 
return this;
//#endif 

} 

//#endif 


//#if 486017038 
public void handleSettingsTabSave()
    { 

//#if 1291366243 
List<Profile> toRemove = new ArrayList<Profile>();
//#endif 


//#if -1985921578 
List<Profile> usedItens = new ArrayList<Profile>();
//#endif 


//#if 2090400886 
MutableComboBoxModel modelUsd = ((MutableComboBoxModel) defaultList
                                         .getModel());
//#endif 


//#if -755596079 
MutableComboBoxModel modelDir = ((MutableComboBoxModel) directoryList
                                         .getModel());
//#endif 


//#if 1558486279 
for (int i = 0; i < modelUsd.getSize(); ++i) //1
{ 

//#if -153986252 
usedItens.add((Profile) modelUsd.getElementAt(i));
//#endif 

} 

//#endif 


//#if -648423738 
for (Profile profile : ProfileFacade.getManager().getDefaultProfiles()) //1
{ 

//#if 1391993444 
if(!usedItens.contains(profile))//1
{ 

//#if -679942776 
toRemove.add(profile);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 683124330 
for (Profile profile : toRemove) //1
{ 

//#if 1900553293 
ProfileFacade.getManager().removeFromDefaultProfiles(profile);
//#endif 

} 

//#endif 


//#if -769746553 
for (Profile profile : usedItens) //1
{ 

//#if -347625752 
if(!ProfileFacade.getManager().getDefaultProfiles().contains(
                        profile))//1
{ 

//#if 1535448644 
ProfileFacade.getManager().addToDefaultProfiles(profile);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1339377412 
List<String> toRemoveDir = new ArrayList<String>();
//#endif 


//#if 1831887303 
List<String> usedItensDir = new ArrayList<String>();
//#endif 


//#if -1178908594 
for (int i = 0; i < modelDir.getSize(); ++i) //1
{ 

//#if 479225507 
usedItensDir.add((String) modelDir.getElementAt(i));
//#endif 

} 

//#endif 


//#if -785652497 
for (String dirEntry : ProfileFacade.getManager()
                .getSearchPathDirectories()) //1
{ 

//#if -1621453743 
if(!usedItensDir.contains(dirEntry))//1
{ 

//#if -864404788 
toRemoveDir.add(dirEntry);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2104692329 
for (String dirEntry : toRemoveDir) //1
{ 

//#if 2002693693 
ProfileFacade.getManager().removeSearchPathDirectory(dirEntry);
//#endif 

} 

//#endif 


//#if -2120491328 
for (String dirEntry : usedItensDir) //1
{ 

//#if -395735044 
if(!ProfileFacade.getManager().getSearchPathDirectories()
                    .contains(dirEntry))//1
{ 

//#if 30890918 
ProfileFacade.getManager().addSearchPathDirectory(dirEntry);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1738476081 
private List<Profile> getUsedProfiles()
    { 

//#if 1601122041 
return new ArrayList<Profile>(ProfileFacade.getManager()
                                      .getDefaultProfiles());
//#endif 

} 

//#endif 


//#if -1471327110 
public void handleResetToDefault()
    { 

//#if 1690218409 
refreshLists();
//#endif 

} 

//#endif 


//#if 1723546600 
private JPanel initDefaultStereotypeViewSelector()
    { 

//#if 745271090 
JPanel setDefStereoV = new JPanel();
//#endif 


//#if -642584730 
setDefStereoV.setLayout(new FlowLayout());
//#endif 


//#if -10876965 
stereoLabel.setLabelFor(stereoField);
//#endif 


//#if -829332930 
setDefStereoV.add(stereoLabel);
//#endif 


//#if -1627383100 
setDefStereoV.add(stereoField);
//#endif 


//#if 1043585797 
DefaultComboBoxModel cmodel = new DefaultComboBoxModel();
//#endif 


//#if 1616983031 
stereoField.setModel(cmodel);
//#endif 


//#if 211272105 
cmodel.addElement(Translator
                          .localize("menu.popup.stereotype-view.textual"));
//#endif 


//#if -1943863006 
cmodel.addElement(Translator
                          .localize("menu.popup.stereotype-view.big-icon"));
//#endif 


//#if -1480901573 
cmodel.addElement(Translator
                          .localize("menu.popup.stereotype-view.small-icon"));
//#endif 


//#if 1604756853 
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
//#endif 


//#if 815589734 
return setDefStereoV;
//#endif 

} 

//#endif 


//#if 1342857827 
public void actionPerformed(ActionEvent arg0)
    { 

//#if 837354702 
MutableComboBoxModel modelAvl = ((MutableComboBoxModel) availableList
                                         .getModel());
//#endif 


//#if -1657926331 
MutableComboBoxModel modelUsd = ((MutableComboBoxModel) defaultList
                                         .getModel());
//#endif 


//#if 381599161 
if(arg0.getSource() == addButton)//1
{ 

//#if 1264274552 
if(availableList.getSelectedIndex() != -1)//1
{ 

//#if -1319151810 
Profile selected = (Profile) modelAvl
                                   .getElementAt(availableList.getSelectedIndex());
//#endif 


//#if 1451771428 
modelUsd.addElement(selected);
//#endif 


//#if 400443650 
modelAvl.removeElement(selected);
//#endif 

} 

//#endif 

} 
else

//#if -298276892 
if(arg0.getSource() == removeButton)//1
{ 

//#if -1407331702 
if(defaultList.getSelectedIndex() != -1)//1
{ 

//#if 299867967 
Profile selected = (Profile) modelUsd.getElementAt(defaultList
                                   .getSelectedIndex());
//#endif 


//#if 1941765726 
if(selected == ProfileFacade.getManager().getUMLProfile())//1
{ 

//#if -1763903911 
JOptionPane.showMessageDialog(this, Translator
                                                  .localize("tab.profiles.cantremoveuml"));
//#endif 

} 
else
{ 

//#if 1257669667 
modelUsd.removeElement(selected);
//#endif 


//#if -1747932219 
modelAvl.addElement(selected);
//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if 1581585465 
if(arg0.getSource() == loadFromFile)//1
{ 

//#if 1090772135 
JFileChooser fileChooser =
                UserDefinedProfileHelper.createUserDefinedProfileFileChooser();
//#endif 


//#if -898118836 
int ret = fileChooser.showOpenDialog(this);
//#endif 


//#if 271864717 
List<File> files = null;
//#endif 


//#if -316228555 
if(ret == JFileChooser.APPROVE_OPTION)//1
{ 

//#if -1312123789 
files = UserDefinedProfileHelper.getFileList(
                            fileChooser.getSelectedFiles());
//#endif 

} 

//#endif 


//#if -1467021793 
if(files != null && files.size() > 0)//1
{ 

//#if 15316717 
for (File file : files) //1
{ 

//#if -1385433766 
try //1
{ 

//#if -1740242924 
UserDefinedProfile profile =
                            new UserDefinedProfile(file);
//#endif 


//#if 1662536984 
ProfileFacade.getManager().registerProfile(profile);
//#endif 


//#if 1492357252 
modelAvl.addElement(profile);
//#endif 

} 

//#if 482244075 
catch (ProfileException e) //1
{ 

//#if -437783308 
JOptionPane.showMessageDialog(this, Translator
                                                      .localize("tab.profiles.userdefined.errorloading")
                                                      + ": " + file.getAbsolutePath());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if -6418106 
if(arg0.getSource() == removeDirectory)//1
{ 

//#if 1126829304 
if(directoryList.getSelectedIndex() != -1)//1
{ 

//#if 126875580 
int idx = directoryList.getSelectedIndex();
//#endif 


//#if -1272113464 
((MutableComboBoxModel) directoryList.getModel())
                .removeElementAt(idx);
//#endif 

} 

//#endif 

} 
else

//#if 1681324649 
if(arg0.getSource() == refreshProfiles)//1
{ 

//#if 500884203 
boolean refresh = JOptionPane.showConfirmDialog(this, Translator
                              .localize("tab.profiles.confirmrefresh"), Translator
                              .localize("tab.profiles.confirmrefresh.title"),
                              JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
//#endif 


//#if -2023417847 
if(refresh)//1
{ 

//#if 214418639 
handleSettingsTabSave();
//#endif 


//#if 535962082 
ProfileFacade.getManager().refreshRegisteredProfiles();
//#endif 


//#if 693368708 
refreshLists();
//#endif 

} 

//#endif 

} 
else

//#if -764113767 
if(arg0.getSource() == addDirectory)//1
{ 

//#if -311215865 
JFileChooser fileChooser = new JFileChooser();
//#endif 


//#if -570656679 
fileChooser.setFileFilter(new FileFilter() {

                public boolean accept(File file) {
                    return file.isDirectory();
                }

                public String getDescription() {
                    return "Directories";
                }

            });
//#endif 


//#if 190886066 
fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//#endif 


//#if -1783620962 
int ret = fileChooser.showOpenDialog(this);
//#endif 


//#if -1730266461 
if(ret == JFileChooser.APPROVE_OPTION)//1
{ 

//#if -806931928 
File file = fileChooser.getSelectedFile();
//#endif 


//#if -547166676 
String path = file.getAbsolutePath();
//#endif 


//#if 1421457598 
((MutableComboBoxModel) directoryList.getModel())
                .addElement(path);
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#if -1408514090 
availableList.validate();
//#endif 


//#if -284803698 
defaultList.validate();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

