
//#if -564770465 
// Compilation Unit of /ProjectSettingsTabProfile.java 
 

//#if 1620106189 
package org.argouml.ui;
//#endif 


//#if 1191653271 
import java.awt.BorderLayout;
//#endif 


//#if 1192820163 
import java.awt.Dimension;
//#endif 


//#if -190777131 
import java.awt.FlowLayout;
//#endif 


//#if 1072420281 
import java.awt.event.ActionEvent;
//#endif 


//#if 1256558127 
import java.awt.event.ActionListener;
//#endif 


//#if -204680874 
import java.awt.event.ItemEvent;
//#endif 


//#if -43642510 
import java.awt.event.ItemListener;
//#endif 


//#if -618993931 
import java.io.File;
//#endif 


//#if 646684850 
import java.util.ArrayList;
//#endif 


//#if 1030254191 
import java.util.List;
//#endif 


//#if -1725012388 
import javax.swing.BoxLayout;
//#endif 


//#if -1695998854 
import javax.swing.DefaultComboBoxModel;
//#endif 


//#if -212994731 
import javax.swing.JButton;
//#endif 


//#if -343061110 
import javax.swing.JComboBox;
//#endif 


//#if -773576336 
import javax.swing.JFileChooser;
//#endif 


//#if 2061514811 
import javax.swing.JLabel;
//#endif 


//#if 205302889 
import javax.swing.JList;
//#endif 


//#if 1523573354 
import javax.swing.JOptionPane;
//#endif 


//#if -2118578389 
import javax.swing.JPanel;
//#endif 


//#if -347489518 
import javax.swing.JScrollPane;
//#endif 


//#if -2059286369 
import javax.swing.MutableComboBoxModel;
//#endif 


//#if 1304577762 
import javax.swing.filechooser.FileFilter;
//#endif 


//#if 1914821238 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if 2079246812 
import org.argouml.i18n.Translator;
//#endif 


//#if 1165191400 
import org.argouml.kernel.ProfileConfiguration;
//#endif 


//#if -785204952 
import org.argouml.kernel.Project;
//#endif 


//#if -512222015 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -996383675 
import org.argouml.kernel.ProjectSettings;
//#endif 


//#if -129275166 
import org.argouml.profile.Profile;
//#endif 


//#if 424720165 
import org.argouml.profile.ProfileException;
//#endif 


//#if 1289718824 
import org.argouml.profile.ProfileFacade;
//#endif 


//#if 1039832160 
import org.argouml.profile.UserDefinedProfile;
//#endif 


//#if -2141763292 
import org.argouml.uml.diagram.DiagramAppearance;
//#endif 


//#if -769368598 
public class ProjectSettingsTabProfile extends 
//#if -34219322 
JPanel
//#endif 

 implements 
//#if 1440725302 
GUISettingsTabInterface
//#endif 

, 
//#if -1601350634 
ActionListener
//#endif 

  { 

//#if -742058557 
private JButton loadFromFile = new JButton(Translator
            .localize("tab.profiles.userdefined.load"));
//#endif 


//#if -2116985037 
private JButton unregisterProfile = new JButton(Translator
            .localize("tab.profiles.userdefined.unload"));
//#endif 


//#if 1495535855 
private JButton addButton = new JButton(">>");
//#endif 


//#if 1624692924 
private JButton removeButton = new JButton("<<");
//#endif 


//#if -862808341 
private JList availableList = new JList();
//#endif 


//#if 151928033 
private JList usedList = new JList();
//#endif 


//#if 502574782 
private JLabel stereoLabel = new JLabel(Translator
                                            .localize("menu.popup.stereotype-view")
                                            + ": ");
//#endif 


//#if -1935909304 
private JComboBox stereoField = new JComboBox();
//#endif 


//#if 977600407 
public JPanel getTabPanel()
    { 

//#if 575045823 
return this;
//#endif 

} 

//#endif 


//#if 15507433 
public void handleResetToDefault()
    { 

//#if -1153685394 
refreshLists();
//#endif 

} 

//#endif 


//#if 1007628346 
private List<Profile> getAvailableProfiles()
    { 

//#if -263119629 
List<Profile> used = getUsedProfiles();
//#endif 


//#if -1396572762 
List<Profile> ret = new ArrayList<Profile>();
//#endif 


//#if -2032684590 
for (Profile profile : ProfileFacade.getManager()
                .getRegisteredProfiles()) //1
{ 

//#if -2004585852 
if(!used.contains(profile))//1
{ 

//#if 428504088 
ret.add(profile);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2017863565 
return ret;
//#endif 

} 

//#endif 


//#if -349621700 
public ProjectSettingsTabProfile()
    { 

//#if -59454824 
setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//#endif 


//#if -904235384 
JPanel setDefStereoV = new JPanel();
//#endif 


//#if -1961342768 
setDefStereoV.setLayout(new FlowLayout());
//#endif 


//#if -1352096187 
stereoLabel.setLabelFor(stereoField);
//#endif 


//#if -605448152 
setDefStereoV.add(stereoLabel);
//#endif 


//#if -1403498322 
setDefStereoV.add(stereoField);
//#endif 


//#if 1335649647 
DefaultComboBoxModel cmodel = new DefaultComboBoxModel();
//#endif 


//#if -1555964831 
stereoField.setModel(cmodel);
//#endif 


//#if 729951763 
cmodel.addElement(Translator
                          .localize("menu.popup.stereotype-view.textual"));
//#endif 


//#if 1250304504 
cmodel.addElement(Translator
                          .localize("menu.popup.stereotype-view.big-icon"));
//#endif 


//#if 1507426193 
cmodel.addElement(Translator
                          .localize("menu.popup.stereotype-view.small-icon"));
//#endif 


//#if -1343871152 
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
//#endif 


//#if -1784535686 
add(setDefStereoV);
//#endif 


//#if 913863969 
JPanel configPanel = new JPanel();
//#endif 


//#if -158240591 
configPanel.setLayout(new BoxLayout(configPanel, BoxLayout.X_AXIS));
//#endif 


//#if -1041149848 
availableList.setPrototypeCellValue("12345678901234567890");
//#endif 


//#if 235247196 
usedList.setPrototypeCellValue("12345678901234567890");
//#endif 


//#if -447452119 
availableList.setMinimumSize(new Dimension(50, 50));
//#endif 


//#if 494261021 
usedList.setMinimumSize(new Dimension(50, 50));
//#endif 


//#if -1425032302 
JPanel leftList = new JPanel();
//#endif 


//#if 185455312 
leftList.setLayout(new BorderLayout());
//#endif 


//#if 2096635820 
leftList.add(new JLabel(Translator
                                .localize("tab.profiles.userdefined.available")),
                     BorderLayout.NORTH);
//#endif 


//#if -1591339590 
leftList.add(new JScrollPane(availableList), BorderLayout.CENTER);
//#endif 


//#if 694738230 
configPanel.add(leftList);
//#endif 


//#if -491363753 
JPanel centerButtons = new JPanel();
//#endif 


//#if 2122825394 
centerButtons.setLayout(new BoxLayout(centerButtons, BoxLayout.Y_AXIS));
//#endif 


//#if 984729616 
centerButtons.add(addButton);
//#endif 


//#if -59183043 
centerButtons.add(removeButton);
//#endif 


//#if 1289373439 
configPanel.add(centerButtons);
//#endif 


//#if 1536147625 
JPanel rightList = new JPanel();
//#endif 


//#if 1988667917 
rightList.setLayout(new BorderLayout());
//#endif 


//#if 877789592 
rightList.add(new JLabel(Translator
                                 .localize("tab.profiles.userdefined.active")),
                      BorderLayout.NORTH);
//#endif 


//#if -208903297 
rightList.add(new JScrollPane(usedList), BorderLayout.CENTER);
//#endif 


//#if 433816429 
configPanel.add(rightList);
//#endif 


//#if -1828666380 
addButton.addActionListener(this);
//#endif 


//#if -2039494375 
removeButton.addActionListener(this);
//#endif 


//#if -1573939903 
add(configPanel);
//#endif 


//#if -83348353 
JPanel lffPanel = new JPanel();
//#endif 


//#if 1281991301 
lffPanel.setLayout(new FlowLayout());
//#endif 


//#if -2096152434 
lffPanel.add(unregisterProfile);
//#endif 


//#if 1625387855 
lffPanel.add(loadFromFile);
//#endif 


//#if -1609895069 
loadFromFile.addActionListener(this);
//#endif 


//#if -1100613990 
unregisterProfile.addActionListener(this);
//#endif 


//#if 691396829 
add(lffPanel);
//#endif 

} 

//#endif 


//#if 983737241 
private List<Profile> getActiveDependents(Profile selected)
    { 

//#if -895318604 
MutableComboBoxModel modelUsd = ((MutableComboBoxModel) usedList
                                         .getModel());
//#endif 


//#if -1694113005 
List<Profile> ret = new ArrayList<Profile>();
//#endif 


//#if -236893 
for (int i = 0; i < modelUsd.getSize(); ++i) //1
{ 

//#if 411866426 
Profile p = (Profile) modelUsd.getElementAt(i);
//#endif 


//#if 323845091 
if(!p.equals(selected) && p.getDependencies().contains(selected))//1
{ 

//#if 1391883216 
ret.add(p);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1044917414 
return ret;
//#endif 

} 

//#endif 


//#if 1151893500 
public void handleSettingsTabCancel()
    { 
} 

//#endif 


//#if 1396739106 
private List<Profile> getUsedProfiles()
    { 

//#if -618309461 
return new ArrayList<Profile>(ProjectManager.getManager()
                                      .getCurrentProject().getProfileConfiguration().getProfiles());
//#endif 

} 

//#endif 


//#if 307866171 
public void handleSettingsTabRefresh()
    { 

//#if -1419947205 
ProjectSettings ps = ProjectManager.getManager().getCurrentProject()
                             .getProjectSettings();
//#endif 


//#if 1607763977 
switch (ps.getDefaultStereotypeViewValue()) //1
{ 
case DiagramAppearance.STEREOTYPE_VIEW_TEXTUAL://1


//#if -292547210 
stereoField.setSelectedIndex(0);
//#endif 


//#if -61309353 
break;

//#endif 


case DiagramAppearance.STEREOTYPE_VIEW_BIG_ICON://1


//#if 167250608 
stereoField.setSelectedIndex(1);
//#endif 


//#if 1259001104 
break;

//#endif 


case DiagramAppearance.STEREOTYPE_VIEW_SMALL_ICON://1


//#if 1292424294 
stereoField.setSelectedIndex(2);
//#endif 


//#if -1692884155 
break;

//#endif 


} 

//#endif 


//#if 1200683864 
refreshLists();
//#endif 

} 

//#endif 


//#if -952320790 
private List<Profile> getAvailableDependents(Profile selected)
    { 

//#if -353688496 
MutableComboBoxModel modelAvl = ((MutableComboBoxModel) availableList
                                         .getModel());
//#endif 


//#if -1341980346 
List<Profile> ret = new ArrayList<Profile>();
//#endif 


//#if -1438198617 
for (int i = 0; i < modelAvl.getSize(); ++i) //1
{ 

//#if -893947351 
Profile p = (Profile) modelAvl.getElementAt(i);
//#endif 


//#if -1454679213 
if(!p.equals(selected) && selected.getDependencies().contains(p))//1
{ 

//#if 1264875798 
ret.add(p);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1534249171 
return ret;
//#endif 

} 

//#endif 


//#if -666752385 
public void handleSettingsTabSave()
    { 

//#if -1200705792 
List<Profile> toRemove = new ArrayList<Profile>();
//#endif 


//#if 360485020 
Project proj = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 1116125600 
ProfileConfiguration pc = proj.getProfileConfiguration();
//#endif 


//#if -1930743335 
List<Profile> usedItens = new ArrayList<Profile>();
//#endif 


//#if 798707035 
MutableComboBoxModel modelUsd = ((MutableComboBoxModel) usedList
                                         .getModel());
//#endif 


//#if -1040694262 
for (int i = 0; i < modelUsd.getSize(); ++i) //1
{ 

//#if 165244317 
usedItens.add((Profile) modelUsd.getElementAt(i));
//#endif 

} 

//#endif 


//#if 1372974516 
for (Profile profile : pc.getProfiles()) //1
{ 

//#if 890450974 
if(!usedItens.contains(profile))//1
{ 

//#if 1698664496 
toRemove.add(profile);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 33030253 
for (Profile profile : toRemove) //1
{ 

//#if 467868285 
pc.removeProfile(profile);
//#endif 

} 

//#endif 


//#if 552173540 
for (Profile profile : usedItens) //1
{ 

//#if -899832145 
if(!pc.getProfiles().contains(profile))//1
{ 

//#if -1428599624 
pc.addProfile(profile);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 505939706 
proj.setProfileConfiguration(pc);
//#endif 

} 

//#endif 


//#if 1030844178 
public void actionPerformed(ActionEvent arg0)
    { 

//#if -935145693 
MutableComboBoxModel modelAvailable =
            ((MutableComboBoxModel) availableList.getModel());
//#endif 


//#if -2085614531 
MutableComboBoxModel modelUsed =
            ((MutableComboBoxModel) usedList.getModel());
//#endif 


//#if 1508708956 
if(arg0.getSource() == addButton)//1
{ 

//#if 44520758 
if(availableList.getSelectedIndex() != -1)//1
{ 

//#if 1441059272 
Profile selected = (Profile) modelAvailable
                                   .getElementAt(availableList.getSelectedIndex());
//#endif 


//#if -624306289 
modelUsed.addElement(selected);
//#endif 


//#if -1325492824 
modelAvailable.removeElement(selected);
//#endif 


//#if -1953983763 
for (Profile profile : getAvailableDependents(selected)) //1
{ 

//#if 1727760483 
modelUsed.addElement(profile);
//#endif 


//#if 1378613546 
modelAvailable.removeElement(profile);
//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if 785995360 
if(arg0.getSource() == removeButton)//1
{ 

//#if 1512276892 
if(usedList.getSelectedIndex() != -1)//1
{ 

//#if 1381982400 
Profile selected = (Profile) modelUsed.getElementAt(usedList
                                   .getSelectedIndex());
//#endif 


//#if -618216470 
List<Profile> dependents = getActiveDependents(selected);
//#endif 


//#if -2112432339 
boolean remove = true;
//#endif 


//#if -15305801 
if(!dependents.isEmpty())//1
{ 

//#if -1339254370 
String message = Translator.localize(
                                         "tab.profiles.confirmdeletewithdependencies",
                                         new Object[] {dependents});
//#endif 


//#if 1258521536 
String title = Translator.localize(
                                       "tab.profiles.confirmdeletewithdependencies.title");
//#endif 


//#if 517672905 
remove = (JOptionPane.showConfirmDialog(
                                  this, message, title, JOptionPane.YES_NO_OPTION)
                              == JOptionPane.YES_OPTION);
//#endif 

} 

//#endif 


//#if -1057854232 
if(remove)//1
{ 

//#if -1200037664 
if(!ProfileFacade.getManager().getRegisteredProfiles()
                            .contains(selected)
                            && !ProfileFacade.getManager().getDefaultProfiles()
                            .contains(selected))//1
{ 

//#if -1404105514 
remove = (JOptionPane
                                  .showConfirmDialog(
                                      this,
                                      Translator.localize(
                                          "tab.profiles.confirmdeleteunregistered"),
                                      Translator.localize(
                                          "tab.profiles.confirmdeleteunregistered.title"),
                                      JOptionPane.YES_NO_OPTION)
                                  == JOptionPane.YES_OPTION);
//#endif 

} 

//#endif 


//#if 1891649997 
if(remove)//1
{ 

//#if -1339550218 
modelUsed.removeElement(selected);
//#endif 


//#if 627467357 
modelAvailable.addElement(selected);
//#endif 


//#if -1681854426 
for (Profile profile : dependents) //1
{ 

//#if -1708793610 
modelUsed.removeElement(profile);
//#endif 


//#if -597843793 
modelAvailable.addElement(profile);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if -766650792 
if(arg0.getSource() == unregisterProfile)//1
{ 

//#if 76955265 
if(availableList.getSelectedIndex() != -1)//1
{ 

//#if -284489863 
Profile selected = (Profile) modelAvailable
                                   .getElementAt(availableList.getSelectedIndex());
//#endif 


//#if -1032629741 
if(selected instanceof UserDefinedProfile)//1
{ 

//#if -1764067089 
ProfileFacade.getManager().removeProfile(selected);
//#endif 


//#if -333154305 
modelAvailable.removeElement(selected);
//#endif 

} 
else
{ 

//#if 2099957645 
JOptionPane.showMessageDialog(this, Translator
                                                  .localize("tab.profiles.cannotdelete"));
//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if -1958994956 
if(arg0.getSource() == loadFromFile)//1
{ 

//#if 1468870403 
JFileChooser fileChooser = new JFileChooser();
//#endif 


//#if 1384924073 
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
//#endif 


//#if 1485266842 
int ret = fileChooser.showOpenDialog(this);
//#endif 


//#if 869033511 
if(ret == JFileChooser.APPROVE_OPTION)//1
{ 

//#if 425060115 
File file = fileChooser.getSelectedFile();
//#endif 


//#if -2120174076 
try //1
{ 

//#if -1174754095 
UserDefinedProfile profile = new UserDefinedProfile(file);
//#endif 


//#if 1520108821 
ProfileFacade.getManager().registerProfile(profile);
//#endif 


//#if 734382837 
modelAvailable.addElement(profile);
//#endif 

} 

//#if -1913762705 
catch (ProfileException e) //1
{ 

//#if -1386964243 
JOptionPane.showMessageDialog(this, Translator
                                                  .localize("tab.profiles.userdefined.errorloading"));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#if 1575231443 
availableList.validate();
//#endif 


//#if 480801691 
usedList.validate();
//#endif 

} 

//#endif 


//#if -1385617690 
private void refreshLists()
    { 

//#if 1882865053 
availableList.setModel(new DefaultComboBoxModel(getAvailableProfiles()
                               .toArray()));
//#endif 


//#if 102674175 
usedList.setModel(
            new DefaultComboBoxModel(getUsedProfiles().toArray()));
//#endif 

} 

//#endif 


//#if 736511227 
public String getTabKey()
    { 

//#if -1194442744 
return "tab.profiles";
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

