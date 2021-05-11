
//#if 835970566 
// Compilation Unit of /SettingsDialog.java 
 

//#if -2044866303 
package org.argouml.ui;
//#endif 


//#if 360942607 
import java.awt.Dimension;
//#endif 


//#if -29796347 
import java.awt.event.ActionEvent;
//#endif 


//#if 145971299 
import java.awt.event.ActionListener;
//#endif 


//#if 1642267199 
import java.awt.event.WindowEvent;
//#endif 


//#if -439628823 
import java.awt.event.WindowListener;
//#endif 


//#if -57802053 
import java.util.List;
//#endif 


//#if -231395191 
import javax.swing.JButton;
//#endif 


//#if 44134823 
import javax.swing.JTabbedPane;
//#endif 


//#if -1070175712 
import javax.swing.SwingConstants;
//#endif 


//#if 1563379114 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if -369704132 
import org.argouml.configuration.Configuration;
//#endif 


//#if -2024697584 
import org.argouml.i18n.Translator;
//#endif 


//#if 371049581 
import org.argouml.util.ArgoDialog;
//#endif 


//#if 1199678214 
class SettingsDialog extends 
//#if 1223183423 
ArgoDialog
//#endif 

 implements 
//#if -1518805374 
WindowListener
//#endif 

  { 

//#if 1737135186 
private JButton applyButton;
//#endif 


//#if -1134234460 
private JTabbedPane tabs;
//#endif 


//#if 1021089374 
private boolean windowOpen;
//#endif 


//#if -2131734614 
private static final long serialVersionUID = -8233301947357843703L;
//#endif 


//#if 399114405 
private List<GUISettingsTabInterface> settingsTabs;
//#endif 


//#if 813253389 
public void windowIconified(WindowEvent e)
    { 
} 

//#endif 


//#if 1597451771 
private void handleRefresh()
    { 

//#if 758587227 
for (GUISettingsTabInterface tab : settingsTabs) //1
{ 

//#if 699878856 
tab.handleSettingsTabRefresh();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1399030795 
public void windowDeactivated(WindowEvent e)
    { 
} 

//#endif 


//#if 897150922 
SettingsDialog()
    { 

//#if -617819398 
super(Translator.localize("dialog.settings"),
              ArgoDialog.OK_CANCEL_OPTION,
              true);
//#endif 


//#if 678392465 
tabs = new JTabbedPane();
//#endif 


//#if -77079577 
applyButton = new JButton(Translator.localize("button.apply"));
//#endif 


//#if 1845343319 
String mnemonic = Translator.localize("button.apply.mnemonic");
//#endif 


//#if 287460369 
if(mnemonic != null && mnemonic.length() > 0)//1
{ 

//#if 74518976 
applyButton.setMnemonic(mnemonic.charAt(0));
//#endif 

} 

//#endif 


//#if -1189337462 
applyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleSave();
            }
        });
//#endif 


//#if -1205761143 
addButton(applyButton);
//#endif 


//#if 1157787392 
settingsTabs = GUI.getInstance().getSettingsTabs();
//#endif 


//#if -1214290877 
for (GUISettingsTabInterface stp : settingsTabs) //1
{ 

//#if 4455232 
tabs.addTab(
                Translator.localize(stp.getTabKey()),
                stp.getTabPanel());
//#endif 

} 

//#endif 


//#if -400719705 
final int minimumWidth = 480;
//#endif 


//#if -389486435 
tabs.setPreferredSize(new Dimension(Math.max(tabs
                                            .getPreferredSize().width, minimumWidth), tabs
                                            .getPreferredSize().height));
//#endif 


//#if 766644836 
tabs.setTabPlacement(SwingConstants.LEFT);
//#endif 


//#if -266059251 
setContent(tabs);
//#endif 


//#if -1347109561 
addWindowListener(this);
//#endif 

} 

//#endif 


//#if -1445319956 
public void windowActivated(WindowEvent e)
    { 

//#if 2146300055 
handleOpen();
//#endif 

} 

//#endif 


//#if 1462871116 
private void handleOpen()
    { 

//#if 1240172524 
if(!windowOpen)//1
{ 

//#if 494899692 
getOkButton().requestFocusInWindow();
//#endif 


//#if -2143185199 
windowOpen = true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -611946511 
@Override
    public void setVisible(boolean show)
    { 

//#if -1199516363 
if(show)//1
{ 

//#if 1656523465 
handleRefresh();
//#endif 


//#if -704514674 
toFront();
//#endif 

} 

//#endif 


//#if 810118073 
super.setVisible(show);
//#endif 

} 

//#endif 


//#if 1564032703 
private void handleSave()
    { 

//#if 546526645 
for (GUISettingsTabInterface tab : settingsTabs) //1
{ 

//#if -1894897132 
tab.handleSettingsTabSave();
//#endif 

} 

//#endif 


//#if 2083856063 
windowOpen = false;
//#endif 


//#if -1919441399 
Configuration.save();
//#endif 

} 

//#endif 


//#if -182258691 
public void windowClosed(WindowEvent e)
    { 
} 

//#endif 


//#if 1899776016 
public void windowClosing(WindowEvent e)
    { 

//#if 963501264 
handleCancel();
//#endif 

} 

//#endif 


//#if 1747682364 
private void handleCancel()
    { 

//#if 419436213 
for (GUISettingsTabInterface tab : settingsTabs) //1
{ 

//#if -967088031 
tab.handleSettingsTabCancel();
//#endif 

} 

//#endif 


//#if 1723441087 
windowOpen = false;
//#endif 

} 

//#endif 


//#if -637363156 
public void windowDeiconified(WindowEvent e)
    { 
} 

//#endif 


//#if -966894534 
public void windowOpened(WindowEvent e)
    { 

//#if 1604906900 
handleOpen();
//#endif 

} 

//#endif 


//#if -1591699763 
public void actionPerformed(ActionEvent ev)
    { 

//#if -992680183 
super.actionPerformed(ev);
//#endif 


//#if -152795678 
if(ev.getSource() == getOkButton())//1
{ 

//#if -1162544504 
handleSave();
//#endif 

} 
else

//#if 1246936272 
if(ev.getSource() == getCancelButton())//1
{ 

//#if -1418862587 
handleCancel();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

