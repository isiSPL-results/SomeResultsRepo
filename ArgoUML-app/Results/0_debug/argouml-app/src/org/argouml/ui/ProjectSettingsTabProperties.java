
//#if 120899658 
// Compilation Unit of /ProjectSettingsTabProperties.java 
 

//#if -745853964 
package org.argouml.ui;
//#endif 


//#if 404260478 
import java.awt.BorderLayout;
//#endif 


//#if -1040498688 
import java.awt.GridBagConstraints;
//#endif 


//#if 292844086 
import java.awt.GridBagLayout;
//#endif 


//#if 584682686 
import java.awt.Insets;
//#endif 


//#if -1844075852 
import javax.swing.JLabel;
//#endif 


//#if -1729201756 
import javax.swing.JPanel;
//#endif 


//#if -1117719495 
import javax.swing.JScrollPane;
//#endif 


//#if -393774572 
import javax.swing.JTextArea;
//#endif 


//#if 812736123 
import javax.swing.JTextField;
//#endif 


//#if 2121058637 
import javax.swing.SwingConstants;
//#endif 


//#if 1113539486 
import org.argouml.application.api.Argo;
//#endif 


//#if -523934947 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if 1968125231 
import org.argouml.configuration.Configuration;
//#endif 


//#if -1880680573 
import org.argouml.i18n.Translator;
//#endif 


//#if 1303812769 
import org.argouml.kernel.Project;
//#endif 


//#if -579645144 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1447172085 
public class ProjectSettingsTabProperties extends 
//#if -475778802 
JPanel
//#endif 

 implements 
//#if 217037806 
GUISettingsTabInterface
//#endif 

  { 

//#if 2078662884 
private JTextField userFullname;
//#endif 


//#if 1201132540 
private JTextField userEmail;
//#endif 


//#if 743796756 
private JTextArea description;
//#endif 


//#if 1675295509 
private JTextField version;
//#endif 


//#if 1749406339 
public void handleSettingsTabRefresh()
    { 

//#if 1554452311 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -1137055378 
userFullname.setText(p.getAuthorname());
//#endif 


//#if -1685047791 
userEmail.setText(p.getAuthoremail());
//#endif 


//#if -1735140783 
description.setText(p.getDescription());
//#endif 


//#if -554747835 
description.setCaretPosition(0);
//#endif 


//#if -308511663 
version.setText(p.getVersion());
//#endif 

} 

//#endif 


//#if -921163977 
public void handleSettingsTabSave()
    { 

//#if -2045950266 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -924619397 
p.setAuthorname(userFullname.getText());
//#endif 


//#if -1424259266 
p.setAuthoremail(userEmail.getText());
//#endif 


//#if -1325373196 
p.setDescription(description.getText());
//#endif 

} 

//#endif 


//#if 1669868593 
public void handleResetToDefault()
    { 

//#if -2074149348 
userFullname.setText(Configuration.getString(Argo.KEY_USER_FULLNAME));
//#endif 


//#if -1148270878 
userEmail.setText(Configuration.getString(Argo.KEY_USER_EMAIL));
//#endif 

} 

//#endif 


//#if -487176269 
public String getTabKey()
    { 

//#if -789476258 
return "tab.user";
//#endif 

} 

//#endif 


//#if -1654585087 
ProjectSettingsTabProperties()
    { 

//#if -754780819 
setLayout(new BorderLayout());
//#endif 


//#if -938837566 
JPanel top = new JPanel();
//#endif 


//#if -394862380 
top.setLayout(new GridBagLayout());
//#endif 


//#if 1039573933 
GridBagConstraints labelConstraints = new GridBagConstraints();
//#endif 


//#if 2013709990 
labelConstraints.anchor = GridBagConstraints.LINE_START;
//#endif 


//#if 691123521 
labelConstraints.gridy = 0;
//#endif 


//#if 691093730 
labelConstraints.gridx = 0;
//#endif 


//#if -960335885 
labelConstraints.gridwidth = 1;
//#endif 


//#if -1267880306 
labelConstraints.gridheight = 1;
//#endif 


//#if 797177061 
labelConstraints.insets = new Insets(2, 20, 2, 4);
//#endif 


//#if -879866377 
labelConstraints.anchor =
            GridBagConstraints.FIRST_LINE_START;
//#endif 


//#if 304855731 
GridBagConstraints fieldConstraints = new GridBagConstraints();
//#endif 


//#if 1465955783 
fieldConstraints.anchor = GridBagConstraints.LINE_END;
//#endif 


//#if -1772904248 
fieldConstraints.fill = GridBagConstraints.BOTH;
//#endif 


//#if 395417671 
fieldConstraints.gridy = 0;
//#endif 


//#if 395387911 
fieldConstraints.gridx = 1;
//#endif 


//#if -322084809 
fieldConstraints.gridwidth = 3;
//#endif 


//#if 1338031944 
fieldConstraints.gridheight = 1;
//#endif 


//#if -473202505 
fieldConstraints.weightx = 1.0;
//#endif 


//#if 62576323 
fieldConstraints.insets = new Insets(2, 4, 2, 20);
//#endif 


//#if -812356239 
labelConstraints.gridy = 0;
//#endif 


//#if -1207409493 
fieldConstraints.gridy = 0;
//#endif 


//#if -736289636 
top.add(new JLabel(Translator.localize("label.user")),
                labelConstraints);
//#endif 


//#if 1197842895 
userFullname = new JTextField();
//#endif 


//#if 389781557 
top.add(userFullname, fieldConstraints);
//#endif 


//#if 691123552 
labelConstraints.gridy = 1;
//#endif 


//#if 395417702 
fieldConstraints.gridy = 1;
//#endif 


//#if -2063304985 
top.add(new JLabel(Translator.localize("label.email")),
                labelConstraints);
//#endif 


//#if 567988419 
userEmail = new JTextField();
//#endif 


//#if 194740073 
top.add(userEmail, fieldConstraints);
//#endif 


//#if 691123583 
labelConstraints.gridy = 2;
//#endif 


//#if 395417733 
fieldConstraints.gridy = 2;
//#endif 


//#if -444573354 
fieldConstraints.weighty = 1.0;
//#endif 


//#if -1082824368 
labelConstraints.weighty = 1.0;
//#endif 


//#if 1337514522 
JLabel lblDescription = new JLabel(
            Translator.localize("label.project.description"));
//#endif 


//#if 534714495 
lblDescription.setVerticalAlignment(SwingConstants.TOP);
//#endif 


//#if -851248902 
top.add(lblDescription,
                labelConstraints);
//#endif 


//#if 1098578453 
description = new JTextArea();
//#endif 


//#if 495798550 
JScrollPane area = new JScrollPane(description);
//#endif 


//#if -1408109336 
area.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//#endif 


//#if 1857131247 
description.setMargin(new Insets(3, 3, 3, 3));
//#endif 


//#if 2001100922 
description.setLineWrap(true);
//#endif 


//#if 967130087 
description.setWrapStyleWord(true);
//#endif 


//#if 1350593837 
top.add(area, fieldConstraints);
//#endif 


//#if 691123614 
labelConstraints.gridy = 3;
//#endif 


//#if 395417764 
fieldConstraints.gridy = 3;
//#endif 


//#if -444603145 
fieldConstraints.weighty = 0.0;
//#endif 


//#if -1082854159 
labelConstraints.weighty = 0.0;
//#endif 


//#if -1898465904 
top.add(new JLabel(Translator.localize("label.argouml.version")),
                labelConstraints);
//#endif 


//#if -1572310692 
version = new JTextField();
//#endif 


//#if 1512003709 
version.setEditable(false);
//#endif 


//#if -883489342 
top.add(version, fieldConstraints);
//#endif 


//#if -67162879 
add(top, BorderLayout.CENTER);
//#endif 

} 

//#endif 


//#if 1475489460 
public void handleSettingsTabCancel()
    { 

//#if 1225073762 
handleSettingsTabRefresh();
//#endif 

} 

//#endif 


//#if 1834955855 
public JPanel getTabPanel()
    { 

//#if -1820625396 
return this;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

