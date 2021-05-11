
//#if 1947614819 
// Compilation Unit of /ProjectSettingsDialog.java 
 

//#if 1538851286 
package org.argouml.ui;
//#endif 


//#if -1405407462 
import java.awt.Dimension;
//#endif 


//#if -544292848 
import java.awt.event.ActionEvent;
//#endif 


//#if 1518989432 
import java.awt.event.ActionListener;
//#endif 


//#if 1127770698 
import java.awt.event.WindowEvent;
//#endif 


//#if 933389310 
import java.awt.event.WindowListener;
//#endif 


//#if -1762891530 
import java.util.Iterator;
//#endif 


//#if 846327518 
import javax.swing.JButton;
//#endif 


//#if -421838718 
import javax.swing.JPanel;
//#endif 


//#if 1056767356 
import javax.swing.JTabbedPane;
//#endif 


//#if -1584672213 
import javax.swing.SwingConstants;
//#endif 


//#if -1818923009 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if -794219931 
import org.argouml.i18n.Translator;
//#endif 


//#if 1601527234 
import org.argouml.util.ArgoDialog;
//#endif 


//#if -565975897 
public class ProjectSettingsDialog extends 
//#if -485031321 
ArgoDialog
//#endif 

 implements 
//#if 2140160170 
WindowListener
//#endif 

  { 

//#if 1142422138 
private JButton applyButton;
//#endif 


//#if -481685261 
private JButton resetToDefaultButton;
//#endif 


//#if -1795850372 
private JTabbedPane tabs;
//#endif 


//#if -1918871822 
private boolean doingShow;
//#endif 


//#if 863357750 
private boolean windowOpen;
//#endif 


//#if -1699000279 
public void showDialog()
    { 

//#if 1604990402 
if(doingShow)//1
{ 

//#if -459802313 
return;
//#endif 

} 

//#endif 


//#if 2136422483 
doingShow = true;
//#endif 


//#if -373045544 
handleRefresh();
//#endif 


//#if -874571801 
setVisible(true);
//#endif 


//#if -1846597411 
toFront();
//#endif 


//#if 1387826258 
doingShow = false;
//#endif 

} 

//#endif 


//#if 902416791 
private void handleSave()
    { 

//#if -1162108341 
for (int i = 0; i < tabs.getComponentCount(); i++) //1
{ 

//#if 2024082460 
Object o = tabs.getComponent(i);
//#endif 


//#if 1662247225 
if(o instanceof GUISettingsTabInterface)//1
{ 

//#if -268605699 
((GUISettingsTabInterface) o).handleSettingsTabSave();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 592136917 
windowOpen = false;
//#endif 

} 

//#endif 


//#if 2040541282 
public void windowOpened(WindowEvent e)
    { 

//#if -1975527231 
handleOpen();
//#endif 

} 

//#endif 


//#if -420282095 
private void handleResetToDefault()
    { 

//#if -797219806 
for (int i = 0; i < tabs.getComponentCount(); i++) //1
{ 

//#if -585052489 
Object o = tabs.getComponent(i);
//#endif 


//#if -1689152684 
if(o instanceof GUISettingsTabInterface)//1
{ 

//#if 881484168 
((GUISettingsTabInterface) o).handleResetToDefault();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1979114011 
public void windowIconified(WindowEvent e)
    { 
} 

//#endif 


//#if -1469790171 
public void windowClosed(WindowEvent e)
    { 
} 

//#endif 


//#if -144892402 
public void showDialog(JPanel tab)
    { 

//#if -92181255 
try //1
{ 

//#if -771682732 
tabs.setSelectedComponent(tab);
//#endif 

} 

//#if 2095172759 
catch (Throwable t) //1
{ 
} 

//#endif 


//#endif 


//#if -1068928270 
showDialog();
//#endif 

} 

//#endif 


//#if 57279940 
public void windowActivated(WindowEvent e)
    { 

//#if 1224980103 
handleOpen();
//#endif 

} 

//#endif 


//#if 2039224053 
public void actionPerformed(ActionEvent ev)
    { 

//#if -718969326 
super.actionPerformed(ev);
//#endif 


//#if -1813213781 
if(ev.getSource() == getOkButton())//1
{ 

//#if 581124567 
handleSave();
//#endif 

} 
else

//#if -1785646851 
if(ev.getSource() == getCancelButton())//1
{ 

//#if 1649375001 
handleCancel();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -2006447901 
public void windowDeactivated(WindowEvent e)
    { 
} 

//#endif 


//#if 1002738723 
private void handleRefresh()
    { 

//#if 1536101022 
for (int i = 0; i < tabs.getComponentCount(); i++) //1
{ 

//#if -2084126483 
Object o = tabs.getComponent(i);
//#endif 


//#if -1639979894 
if(o instanceof GUISettingsTabInterface)//1
{ 

//#if -165751249 
((GUISettingsTabInterface) o).handleSettingsTabRefresh();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 279590294 
public ProjectSettingsDialog()
    { 

//#if 1733098203 
super(Translator.localize("dialog.file.properties"),
              ArgoDialog.OK_CANCEL_OPTION,
              true);
//#endif 


//#if -1453268396 
tabs = new JTabbedPane();
//#endif 


//#if -964009622 
applyButton = new JButton(Translator.localize("button.apply"));
//#endif 


//#if 958413274 
String mnemonic = Translator.localize("button.apply.mnemonic");
//#endif 


//#if -1702282156 
if(mnemonic != null && mnemonic.length() > 0)//1
{ 

//#if -1019557665 
applyButton.setMnemonic(mnemonic.charAt(0));
//#endif 

} 

//#endif 


//#if -427567449 
applyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleSave();
            }
        });
//#endif 


//#if 1432228902 
addButton(applyButton);
//#endif 


//#if 400708506 
resetToDefaultButton = new JButton(
            Translator.localize("button.reset-to-default"));
//#endif 


//#if 663007450 
mnemonic = Translator.localize("button.reset-to-default.mnemonic");
//#endif 


//#if -2008769059 
if(mnemonic != null && mnemonic.length() > 0)//2
{ 

//#if -38952702 
resetToDefaultButton.setMnemonic(mnemonic.charAt(0));
//#endif 

} 

//#endif 


//#if 644308292 
resetToDefaultButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleResetToDefault();
            }
        });
//#endif 


//#if -430303353 
addButton(resetToDefaultButton);
//#endif 


//#if -720400360 
Iterator iter = GUI.getInstance().getProjectSettingsTabs().iterator();
//#endif 


//#if -1757959890 
while (iter.hasNext()) //1
{ 

//#if -989450529 
GUISettingsTabInterface stp =
                (GUISettingsTabInterface) iter.next();
//#endif 


//#if 1531947378 
tabs.addTab(
                Translator.localize(stp.getTabKey()),
                stp.getTabPanel());
//#endif 

} 

//#endif 


//#if 677008900 
final int minimumWidth = 480;
//#endif 


//#if 483893754 
tabs.setPreferredSize(new Dimension(Math.max(tabs
                                            .getPreferredSize().width, minimumWidth), tabs
                                            .getPreferredSize().height));
//#endif 


//#if -1223097689 
tabs.setTabPlacement(SwingConstants.LEFT);
//#endif 


//#if -1255750550 
setContent(tabs);
//#endif 


//#if -1173796790 
addWindowListener(this);
//#endif 

} 

//#endif 


//#if 801255204 
private void handleOpen()
    { 

//#if -1594758879 
if(!windowOpen)//1
{ 

//#if 156338085 
getOkButton().requestFocusInWindow();
//#endif 


//#if -1009164424 
windowOpen = true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 641005800 
public void windowClosing(WindowEvent e)
    { 

//#if 1118376665 
handleCancel();
//#endif 

} 

//#endif 


//#if 252125444 
public void windowDeiconified(WindowEvent e)
    { 
} 

//#endif 


//#if 1589950740 
private void handleCancel()
    { 

//#if 2139100203 
for (int i = 0; i < tabs.getComponentCount(); i++) //1
{ 

//#if 2075824169 
Object o = tabs.getComponent(i);
//#endif 


//#if 447396294 
if(o instanceof GUISettingsTabInterface)//1
{ 

//#if -399799395 
((GUISettingsTabInterface) o).handleSettingsTabCancel();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 373509301 
windowOpen = false;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

