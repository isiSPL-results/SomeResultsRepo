
//#if 1180469653 
// Compilation Unit of /SettingsTabPreferences.java 
 

//#if 111418713 
package org.argouml.ui;
//#endif 


//#if 902699043 
import java.awt.BorderLayout;
//#endif 


//#if -2082192923 
import java.awt.GridBagConstraints;
//#endif 


//#if -1435429583 
import java.awt.GridBagLayout;
//#endif 


//#if 1441955363 
import java.awt.Insets;
//#endif 


//#if 1568054416 
import javax.swing.JCheckBox;
//#endif 


//#if -594423265 
import javax.swing.JPanel;
//#endif 


//#if -2051757863 
import org.argouml.application.api.Argo;
//#endif 


//#if 657475074 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if 2146666388 
import org.argouml.configuration.Configuration;
//#endif 


//#if 1372592488 
import org.argouml.i18n.Translator;
//#endif 


//#if -1810146679 
class SettingsTabPreferences extends 
//#if 397235730 
JPanel
//#endif 

 implements 
//#if 1945943914 
GUISettingsTabInterface
//#endif 

  { 

//#if -218512176 
private JCheckBox chkSplash;
//#endif 


//#if -740496765 
private JCheckBox chkReloadRecent;
//#endif 


//#if -2063616921 
private JCheckBox chkStripDiagrams;
//#endif 


//#if 441508265 
private static final long serialVersionUID = -340220974967836979L;
//#endif 


//#if 1161382091 
public JPanel getTabPanel()
    { 

//#if 1803821182 
return this;
//#endif 

} 

//#endif 


//#if -1542858704 
public void handleSettingsTabCancel()
    { 

//#if -2046544651 
handleSettingsTabRefresh();
//#endif 

} 

//#endif 


//#if -1625073529 
public void handleSettingsTabRefresh()
    { 

//#if -1872631621 
chkSplash.setSelected(Configuration.getBoolean(Argo.KEY_SPLASH, true));
//#endif 


//#if -900525553 
chkReloadRecent.setSelected(
            Configuration.getBoolean(Argo.KEY_RELOAD_RECENT_PROJECT,
                                     false));
//#endif 


//#if 267356740 
chkStripDiagrams.setSelected(
            Configuration.getBoolean(Argo.KEY_XMI_STRIP_DIAGRAMS,
                                     false));
//#endif 

} 

//#endif 


//#if 1241729839 
public String getTabKey()
    { 

//#if -942295052 
return "tab.preferences";
//#endif 

} 

//#endif 


//#if -777834753 
SettingsTabPreferences()
    { 

//#if 849159628 
setLayout(new BorderLayout());
//#endif 


//#if -1712953789 
JPanel top = new JPanel();
//#endif 


//#if -1009314859 
top.setLayout(new GridBagLayout());
//#endif 


//#if 820318176 
GridBagConstraints checkConstraints = new GridBagConstraints();
//#endif 


//#if 1800782739 
checkConstraints.anchor = GridBagConstraints.LINE_START;
//#endif 


//#if -1270775500 
checkConstraints.gridy = 0;
//#endif 


//#if -1270805291 
checkConstraints.gridx = 0;
//#endif 


//#if 1817512550 
checkConstraints.gridwidth = 1;
//#endif 


//#if -1053924741 
checkConstraints.gridheight = 1;
//#endif 


//#if 8518824 
checkConstraints.insets = new Insets(4, 10, 0, 10);
//#endif 


//#if -1270775438 
checkConstraints.gridy = 2;
//#endif 


//#if -940179499 
JCheckBox j = new JCheckBox(Translator.localize("label.splash"));
//#endif 


//#if -1879753022 
chkSplash = j;
//#endif 


//#if -2092351680 
top.add(chkSplash, checkConstraints);
//#endif 


//#if -1270792953 
checkConstraints.gridy++;
//#endif 


//#if 359331177 
JCheckBox j2 =
            new JCheckBox(Translator.localize("label.reload-recent"));
//#endif 


//#if 871435599 
chkReloadRecent = j2;
//#endif 


//#if -603389197 
top.add(chkReloadRecent, checkConstraints);
//#endif 


//#if 1943898091 
checkConstraints.gridy++;
//#endif 


//#if -1025026644 
JCheckBox j3 =
            new JCheckBox(Translator.localize("label.strip-diagrams"));
//#endif 


//#if 335193512 
chkStripDiagrams = j3;
//#endif 


//#if -104639431 
top.add(chkStripDiagrams, checkConstraints);
//#endif 


//#if -2097958664 
checkConstraints.fill = GridBagConstraints.HORIZONTAL;
//#endif 


//#if 403787934 
add(top, BorderLayout.NORTH);
//#endif 

} 

//#endif 


//#if -889105355 
public void handleResetToDefault()
    { 
} 

//#endif 


//#if 1355022259 
public void handleSettingsTabSave()
    { 

//#if -1683450398 
Configuration.setBoolean(Argo.KEY_SPLASH, chkSplash.isSelected());
//#endif 


//#if -182548743 
Configuration.setBoolean(Argo.KEY_RELOAD_RECENT_PROJECT,
                                 chkReloadRecent.isSelected());
//#endif 


//#if -383399946 
Configuration.setBoolean(Argo.KEY_XMI_STRIP_DIAGRAMS,
                                 chkStripDiagrams.isSelected());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

