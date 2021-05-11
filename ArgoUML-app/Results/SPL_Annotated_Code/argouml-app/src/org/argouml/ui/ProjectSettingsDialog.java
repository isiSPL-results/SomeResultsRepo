// Compilation Unit of /ProjectSettingsDialog.java 
 
package org.argouml.ui;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import org.argouml.application.api.GUISettingsTabInterface;
import org.argouml.i18n.Translator;
import org.argouml.util.ArgoDialog;
public class ProjectSettingsDialog extends ArgoDialog
 implements WindowListener
  { 
private JButton applyButton;
private JButton resetToDefaultButton;
private JTabbedPane tabs;
private boolean doingShow;
private boolean windowOpen;
public void showDialog()
    { 
if(doingShow)//1
{ 
return;
} 

doingShow = true;
handleRefresh();
setVisible(true);
toFront();
doingShow = false;
} 

private void handleSave()
    { 
for (int i = 0; i < tabs.getComponentCount(); i++) //1
{ 
Object o = tabs.getComponent(i);
if(o instanceof GUISettingsTabInterface)//1
{ 
((GUISettingsTabInterface) o).handleSettingsTabSave();
} 

} 

windowOpen = false;
} 

public void windowOpened(WindowEvent e)
    { 
handleOpen();
} 

private void handleResetToDefault()
    { 
for (int i = 0; i < tabs.getComponentCount(); i++) //1
{ 
Object o = tabs.getComponent(i);
if(o instanceof GUISettingsTabInterface)//1
{ 
((GUISettingsTabInterface) o).handleResetToDefault();
} 

} 

} 

public void windowIconified(WindowEvent e)
    { 
} 

public void windowClosed(WindowEvent e)
    { 
} 

public void showDialog(JPanel tab)
    { 
try //1
{ 
tabs.setSelectedComponent(tab);
} 
catch (Throwable t) //1
{ 
} 


showDialog();
} 

public void windowActivated(WindowEvent e)
    { 
handleOpen();
} 

public void actionPerformed(ActionEvent ev)
    { 
super.actionPerformed(ev);
if(ev.getSource() == getOkButton())//1
{ 
handleSave();
} 
else
if(ev.getSource() == getCancelButton())//1
{ 
handleCancel();
} 


} 

public void windowDeactivated(WindowEvent e)
    { 
} 

private void handleRefresh()
    { 
for (int i = 0; i < tabs.getComponentCount(); i++) //1
{ 
Object o = tabs.getComponent(i);
if(o instanceof GUISettingsTabInterface)//1
{ 
((GUISettingsTabInterface) o).handleSettingsTabRefresh();
} 

} 

} 

public ProjectSettingsDialog()
    { 
super(Translator.localize("dialog.file.properties"),
              ArgoDialog.OK_CANCEL_OPTION,
              true);
tabs = new JTabbedPane();
applyButton = new JButton(Translator.localize("button.apply"));
String mnemonic = Translator.localize("button.apply.mnemonic");
if(mnemonic != null && mnemonic.length() > 0)//1
{ 
applyButton.setMnemonic(mnemonic.charAt(0));
} 

applyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleSave();
            }
        });
addButton(applyButton);
resetToDefaultButton = new JButton(
            Translator.localize("button.reset-to-default"));
mnemonic = Translator.localize("button.reset-to-default.mnemonic");
if(mnemonic != null && mnemonic.length() > 0)//2
{ 
resetToDefaultButton.setMnemonic(mnemonic.charAt(0));
} 

resetToDefaultButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleResetToDefault();
            }
        });
addButton(resetToDefaultButton);
Iterator iter = GUI.getInstance().getProjectSettingsTabs().iterator();
while (iter.hasNext()) //1
{ 
GUISettingsTabInterface stp =
                (GUISettingsTabInterface) iter.next();
tabs.addTab(
                Translator.localize(stp.getTabKey()),
                stp.getTabPanel());
} 

final int minimumWidth = 480;
tabs.setPreferredSize(new Dimension(Math.max(tabs
                                            .getPreferredSize().width, minimumWidth), tabs
                                            .getPreferredSize().height));
tabs.setTabPlacement(SwingConstants.LEFT);
setContent(tabs);
addWindowListener(this);
} 

private void handleOpen()
    { 
if(!windowOpen)//1
{ 
getOkButton().requestFocusInWindow();
windowOpen = true;
} 

} 

public void windowClosing(WindowEvent e)
    { 
handleCancel();
} 

public void windowDeiconified(WindowEvent e)
    { 
} 

private void handleCancel()
    { 
for (int i = 0; i < tabs.getComponentCount(); i++) //1
{ 
Object o = tabs.getComponent(i);
if(o instanceof GUISettingsTabInterface)//1
{ 
((GUISettingsTabInterface) o).handleSettingsTabCancel();
} 

} 

windowOpen = false;
} 

 } 


