
//#if -1123447960 
// Compilation Unit of /SettingsTabEnvironment.java 
 

//#if -786648146 
package org.argouml.ui;
//#endif 


//#if -1116742984 
import java.awt.BorderLayout;
//#endif 


//#if 1001824275 
import java.util.ArrayList;
//#endif 


//#if -1963587666 
import java.util.Collection;
//#endif 


//#if 241033396 
import javax.swing.BorderFactory;
//#endif 


//#if 987620025 
import javax.swing.DefaultComboBoxModel;
//#endif 


//#if 1643509931 
import javax.swing.JComboBox;
//#endif 


//#if -1667807046 
import javax.swing.JLabel;
//#endif 


//#if -1552932950 
import javax.swing.JPanel;
//#endif 


//#if 906269057 
import javax.swing.JTextField;
//#endif 


//#if -1188370652 
import org.argouml.application.api.Argo;
//#endif 


//#if -229698089 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if -1819037975 
import org.argouml.configuration.Configuration;
//#endif 


//#if 530110525 
import org.argouml.i18n.Translator;
//#endif 


//#if 1506154314 
import org.argouml.uml.ui.SaveGraphicsManager;
//#endif 


//#if 1152218610 
import org.argouml.util.SuffixFilter;
//#endif 


//#if 1780216307 
import org.tigris.swidgets.LabelledLayout;
//#endif 


//#if -1595751313 
class SettingsTabEnvironment extends 
//#if 1438524521 
JPanel
//#endif 

 implements 
//#if 1232439795 
GUISettingsTabInterface
//#endif 

  { 

//#if 212459795 
private JTextField fieldArgoExtDir;
//#endif 


//#if 275427991 
private JTextField fieldJavaHome;
//#endif 


//#if 1458115214 
private JTextField fieldUserHome;
//#endif 


//#if 324005820 
private JTextField fieldUserDir;
//#endif 


//#if -599246200 
private JTextField fieldStartupDir;
//#endif 


//#if 1754693042 
private JComboBox fieldGraphicsFormat;
//#endif 


//#if 933960861 
private JComboBox fieldGraphicsResolution;
//#endif 


//#if -1013971696 
private Collection<GResolution> theResolutions;
//#endif 


//#if -421790923 
private static final long serialVersionUID = 543442930918741133L;
//#endif 


//#if 214048057 
public void handleSettingsTabCancel()
    { 

//#if -515955292 
handleSettingsTabRefresh();
//#endif 

} 

//#endif 


//#if -743705860 
public void handleSettingsTabSave()
    { 

//#if 1266289987 
Configuration.setString(Argo.KEY_STARTUP_DIR, fieldUserDir.getText());
//#endif 


//#if 985550185 
GResolution r = (GResolution) fieldGraphicsResolution.getSelectedItem();
//#endif 


//#if -42227066 
Configuration.setInteger(SaveGraphicsManager.KEY_GRAPHICS_RESOLUTION,
                                 r.getResolution());
//#endif 


//#if 104383293 
SaveGraphicsManager.getInstance().setDefaultFilter(
            (SuffixFilter) fieldGraphicsFormat.getSelectedItem());
//#endif 

} 

//#endif 


//#if 927051249 
SettingsTabEnvironment()
    { 

//#if -1915978199 
super();
//#endif 


//#if 472167491 
setLayout(new BorderLayout());
//#endif 


//#if -1151498010 
int labelGap = 10;
//#endif 


//#if -1402583995 
int componentGap = 5;
//#endif 


//#if 270297817 
JPanel top = new JPanel(new LabelledLayout(labelGap, componentGap));
//#endif 


//#if -2146536401 
JLabel label =
            new JLabel(Translator.localize("label.default.graphics-format"));
//#endif 


//#if -349672056 
fieldGraphicsFormat = new JComboBox();
//#endif 


//#if -1142462567 
label.setLabelFor(fieldGraphicsFormat);
//#endif 


//#if 1135187740 
top.add(label);
//#endif 


//#if -1383286364 
top.add(fieldGraphicsFormat);
//#endif 


//#if 1569782298 
label =
            new JLabel(
            Translator.localize("label.default.graphics-resolution"));
//#endif 


//#if -1299745209 
theResolutions = new ArrayList<GResolution>();
//#endif 


//#if -1753316646 
theResolutions.add(new GResolution(1, "combobox.item.resolution-1"));
//#endif 


//#if 358897244 
theResolutions.add(new GResolution(2, "combobox.item.resolution-2"));
//#endif 


//#if 288357728 
theResolutions.add(new GResolution(4, "combobox.item.resolution-4"));
//#endif 


//#if -1922457923 
fieldGraphicsResolution = new JComboBox();
//#endif 


//#if -87427314 
label.setLabelFor(fieldGraphicsResolution);
//#endif 


//#if -194479690 
top.add(label);
//#endif 


//#if 370232217 
top.add(fieldGraphicsResolution);
//#endif 


//#if 879767227 
label = new JLabel(System.getProperty("argo.ext.dir"));
//#endif 


//#if 2108696831 
JTextField j2 = new JTextField();
//#endif 


//#if 186062443 
fieldArgoExtDir = j2;
//#endif 


//#if 711497317 
fieldArgoExtDir.setEnabled(false);
//#endif 


//#if 1792924636 
label.setLabelFor(fieldArgoExtDir);
//#endif 


//#if -194479689 
top.add(label);
//#endif 


//#if -2139362457 
top.add(fieldArgoExtDir);
//#endif 


//#if -592265542 
label = new JLabel("${java.home}");
//#endif 


//#if 1111624478 
JTextField j3 = new JTextField();
//#endif 


//#if 276143558 
fieldJavaHome = j3;
//#endif 


//#if -948228183 
fieldJavaHome.setEnabled(false);
//#endif 


//#if -1223134376 
label.setLabelFor(fieldJavaHome);
//#endif 


//#if -194479688 
top.add(label);
//#endif 


//#if 1534781859 
top.add(fieldJavaHome);
//#endif 


//#if -58569935 
label = new JLabel("${user.home}");
//#endif 


//#if 114552125 
JTextField j4 = new JTextField();
//#endif 


//#if 2094474894 
fieldUserHome = j4;
//#endif 


//#if 1411653600 
fieldUserHome.setEnabled(false);
//#endif 


//#if 1080431169 
label.setLabelFor(fieldUserHome);
//#endif 


//#if -194479687 
top.add(label);
//#endif 


//#if -456619892 
top.add(fieldUserHome);
//#endif 


//#if 1269270345 
label = new JLabel("${user.dir}");
//#endif 


//#if -882520228 
JTextField j5 = new JTextField();
//#endif 


//#if 1336945605 
fieldUserDir = j5;
//#endif 


//#if 1395476424 
fieldUserDir.setEnabled(false);
//#endif 


//#if 1693550735 
label.setLabelFor(fieldUserDir);
//#endif 


//#if -194479686 
top.add(label);
//#endif 


//#if -1265525532 
top.add(fieldUserDir);
//#endif 


//#if 1362835766 
label = new JLabel(Translator.localize("label.startup-directory"));
//#endif 


//#if -1879592581 
JTextField j6 = new JTextField();
//#endif 


//#if -681357998 
fieldStartupDir = j6;
//#endif 


//#if -916366182 
fieldStartupDir.setEnabled(false);
//#endif 


//#if -1895124729 
label.setLabelFor(fieldStartupDir);
//#endif 


//#if -194479685 
top.add(label);
//#endif 


//#if -1532444526 
top.add(fieldStartupDir);
//#endif 


//#if -1799550297 
top.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//#endif 


//#if -2102225081 
add(top, BorderLayout.NORTH);
//#endif 


//#if 1701027598 
JPanel bottom = new JPanel();
//#endif 


//#if -1475182128 
bottom.add(new JLabel(
                       Translator.localize("label.graphics-export-resolution.warning")));
//#endif 


//#if 477119927 
add(bottom, BorderLayout.SOUTH);
//#endif 

} 

//#endif 


//#if 1259951052 
public void handleResetToDefault()
    { 
} 

//#endif 


//#if -1616276204 
public JPanel getTabPanel()
    { 

//#if 2071122469 
return this;
//#endif 

} 

//#endif 


//#if 528225720 
public String getTabKey()
    { 

//#if 659381406 
return "tab.environment";
//#endif 

} 

//#endif 


//#if 1299428510 
public void handleSettingsTabRefresh()
    { 

//#if -1828252752 
fieldArgoExtDir.setText(System.getProperty("argo.ext.dir"));
//#endif 


//#if -1814634028 
fieldJavaHome.setText(System.getProperty("java.home"));
//#endif 


//#if 71643188 
fieldUserHome.setText(System.getProperty("user.home"));
//#endif 


//#if 1188139528 
fieldUserDir.setText(Configuration.getString(Argo.KEY_STARTUP_DIR,
                             System.getProperty("user.dir")));
//#endif 


//#if 312697796 
fieldStartupDir.setText(Argo.getDirectory());
//#endif 


//#if -1425358265 
fieldGraphicsFormat.removeAllItems();
//#endif 


//#if 1109330500 
Collection c = SaveGraphicsManager.getInstance().getSettingsList();
//#endif 


//#if -1763902539 
fieldGraphicsFormat.setModel(new DefaultComboBoxModel(c.toArray()));
//#endif 


//#if -987339716 
fieldGraphicsResolution.removeAllItems();
//#endif 


//#if -181342799 
fieldGraphicsResolution.setModel(new DefaultComboBoxModel(
                                             theResolutions.toArray()));
//#endif 


//#if 1989524711 
int defaultResolution =
            Configuration.getInteger(
                SaveGraphicsManager.KEY_GRAPHICS_RESOLUTION, 1);
//#endif 


//#if 549033687 
for (GResolution gr : theResolutions) //1
{ 

//#if -841624391 
if(defaultResolution == gr.getResolution())//1
{ 

//#if 1823488778 
fieldGraphicsResolution.setSelectedItem(gr);
//#endif 


//#if -1237061932 
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


//#if 2019825413 
class GResolution  { 

//#if 448977218 
private int resolution;
//#endif 


//#if 1148635962 
private String label;
//#endif 


//#if -1198125976 
public String toString()
    { 

//#if -781879535 
return label;
//#endif 

} 

//#endif 


//#if -988211595 
int getResolution()
    { 

//#if -1478011522 
return resolution;
//#endif 

} 

//#endif 


//#if -388526150 
GResolution(int r, String name)
    { 

//#if 1248249528 
resolution = r;
//#endif 


//#if 1967657779 
label = Translator.localize(name);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

