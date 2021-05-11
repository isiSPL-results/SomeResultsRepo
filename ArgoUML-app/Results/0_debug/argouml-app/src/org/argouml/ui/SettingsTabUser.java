
//#if -11617386 
// Compilation Unit of /SettingsTabUser.java 
 

//#if -876700698 
package org.argouml.ui;
//#endif 


//#if -1285506832 
import java.awt.BorderLayout;
//#endif 


//#if -1799299501 
import java.awt.Component;
//#endif 


//#if 1297896690 
import java.awt.GridBagConstraints;
//#endif 


//#if -550334972 
import java.awt.GridBagLayout;
//#endif 


//#if 453835952 
import java.awt.Insets;
//#endif 


//#if 92794805 
import javax.swing.BoxLayout;
//#endif 


//#if -68823678 
import javax.swing.JLabel;
//#endif 


//#if 46050418 
import javax.swing.JPanel;
//#endif 


//#if -30442935 
import javax.swing.JTextField;
//#endif 


//#if 1769960940 
import org.argouml.application.api.Argo;
//#endif 


//#if 1423131151 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if -1416728799 
import org.argouml.configuration.Configuration;
//#endif 


//#if 457714805 
import org.argouml.i18n.Translator;
//#endif 


//#if 508931180 
import org.argouml.swingext.JLinkButton;
//#endif 


//#if -1708941529 
class SettingsTabUser extends 
//#if 746585147 
JPanel
//#endif 

 implements 
//#if 1902645345 
GUISettingsTabInterface
//#endif 

  { 

//#if 760100113 
private JTextField userFullname;
//#endif 


//#if 1444591343 
private JTextField userEmail;
//#endif 


//#if -1878102911 
private static final long serialVersionUID = -742258688091914619L;
//#endif 


//#if 1198431270 
public String getTabKey()
    { 

//#if 983139432 
return "tab.user";
//#endif 

} 

//#endif 


//#if -345477465 
public void handleSettingsTabCancel()
    { 

//#if -410571521 
handleSettingsTabRefresh();
//#endif 

} 

//#endif 


//#if -453785622 
public void handleSettingsTabSave()
    { 

//#if 684985308 
Configuration.setString(Argo.KEY_USER_FULLNAME, userFullname.getText());
//#endif 


//#if -1381631578 
Configuration.setString(Argo.KEY_USER_EMAIL, userEmail.getText());
//#endif 

} 

//#endif 


//#if -1793837054 
public JPanel getTabPanel()
    { 

//#if -1448354405 
return this;
//#endif 

} 

//#endif 


//#if 1546397982 
public void handleResetToDefault()
    { 
} 

//#endif 


//#if -1724804611 
SettingsTabUser()
    { 

//#if 1153692478 
setLayout(new BorderLayout());
//#endif 


//#if 116782353 
JPanel top = new JPanel();
//#endif 


//#if 1403803621 
top.setLayout(new BorderLayout());
//#endif 


//#if 169579946 
JPanel warning = new JPanel();
//#endif 


//#if 1013549705 
warning.setLayout(new BoxLayout(warning, BoxLayout.PAGE_AXIS));
//#endif 


//#if -20199922 
JLabel warningLabel = new JLabel(Translator.localize("label.warning"));
//#endif 


//#if 1397802793 
warningLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
//#endif 


//#if -614452366 
warning.add(warningLabel);
//#endif 


//#if 1586730012 
JLinkButton projectSettings = new JLinkButton();
//#endif 


//#if 197993546 
projectSettings.setAction(new ActionProjectSettings());
//#endif 


//#if -16919697 
projectSettings.setText(Translator.localize("button.project-settings"));
//#endif 


//#if 1709824423 
projectSettings.setIcon(null);
//#endif 


//#if 1285434703 
projectSettings.setAlignmentX(Component.RIGHT_ALIGNMENT);
//#endif 


//#if 387766278 
warning.add(projectSettings);
//#endif 


//#if -1406665730 
top.add(warning, BorderLayout.NORTH);
//#endif 


//#if -1747295535 
JPanel settings = new JPanel();
//#endif 


//#if -780382377 
settings.setLayout(new GridBagLayout());
//#endif 


//#if 1068129726 
GridBagConstraints labelConstraints = new GridBagConstraints();
//#endif 


//#if -1229272003 
labelConstraints.anchor = GridBagConstraints.WEST;
//#endif 


//#if 913589138 
labelConstraints.gridy = 0;
//#endif 


//#if 913559347 
labelConstraints.gridx = 0;
//#endif 


//#if 948137412 
labelConstraints.gridwidth = 1;
//#endif 


//#if 2060217053 
labelConstraints.gridheight = 1;
//#endif 


//#if 1444903668 
labelConstraints.insets = new Insets(2, 20, 2, 4);
//#endif 


//#if 333411524 
GridBagConstraints fieldConstraints = new GridBagConstraints();
//#endif 


//#if 1446341097 
fieldConstraints.anchor = GridBagConstraints.EAST;
//#endif 


//#if 310955284 
fieldConstraints.fill = GridBagConstraints.HORIZONTAL;
//#endif 


//#if 617883288 
fieldConstraints.gridy = 0;
//#endif 


//#if 617853528 
fieldConstraints.gridx = 1;
//#endif 


//#if 1586388488 
fieldConstraints.gridwidth = 3;
//#endif 


//#if 371162007 
fieldConstraints.gridheight = 1;
//#endif 


//#if 1435270792 
fieldConstraints.weightx = 1.0;
//#endif 


//#if 710302930 
fieldConstraints.insets = new Insets(2, 4, 2, 20);
//#endif 


//#if -473697920 
labelConstraints.gridy = 0;
//#endif 


//#if -868751174 
fieldConstraints.gridy = 0;
//#endif 


//#if -422931463 
settings.add(new JLabel(Translator.localize("label.user")),
                     labelConstraints);
//#endif 


//#if -545835012 
JTextField j = new JTextField();
//#endif 


//#if 655354938 
userFullname = j;
//#endif 


//#if -1644837998 
settings.add(userFullname, fieldConstraints);
//#endif 


//#if 913589169 
labelConstraints.gridy = 1;
//#endif 


//#if 617883319 
fieldConstraints.gridy = 1;
//#endif 


//#if -939136214 
settings.add(new JLabel(Translator.localize("label.email")),
                     labelConstraints);
//#endif 


//#if -507673125 
JTextField j1 = new JTextField();
//#endif 


//#if -1306391591 
userEmail = j1;
//#endif 


//#if -922789588 
settings.add(userEmail, fieldConstraints);
//#endif 


//#if -364987771 
top.add(settings, BorderLayout.CENTER);
//#endif 


//#if -2080240404 
add(top, BorderLayout.NORTH);
//#endif 

} 

//#endif 


//#if 1134006512 
public void handleSettingsTabRefresh()
    { 

//#if 29799920 
userFullname.setText(Configuration.getString(Argo.KEY_USER_FULLNAME));
//#endif 


//#if 1874980278 
userEmail.setText(Configuration.getString(Argo.KEY_USER_EMAIL));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

