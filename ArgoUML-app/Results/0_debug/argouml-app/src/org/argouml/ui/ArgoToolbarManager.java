
//#if -1108914491 
// Compilation Unit of /ArgoToolbarManager.java 
 

//#if 1244500233 
package org.argouml.ui;
//#endif 


//#if -463551747 
import java.awt.event.ActionEvent;
//#endif 


//#if 789364323 
import java.awt.event.ComponentAdapter;
//#endif 


//#if -953953736 
import java.awt.event.ComponentEvent;
//#endif 


//#if -1994620149 
import java.awt.event.MouseAdapter;
//#endif 


//#if 1076666592 
import java.awt.event.MouseEvent;
//#endif 


//#if -602712082 
import java.util.ArrayList;
//#endif 


//#if 1586834673 
import javax.swing.AbstractAction;
//#endif 


//#if -932430770 
import javax.swing.JCheckBoxMenuItem;
//#endif 


//#if 1233072278 
import javax.swing.JComponent;
//#endif 


//#if 26031620 
import javax.swing.JMenu;
//#endif 


//#if 1832263857 
import javax.swing.JMenuItem;
//#endif 


//#if -247435480 
import javax.swing.JPopupMenu;
//#endif 


//#if 2034373624 
import javax.swing.JToolBar;
//#endif 


//#if 762209981 
import javax.swing.SwingUtilities;
//#endif 


//#if -1941378236 
import org.argouml.configuration.Configuration;
//#endif 


//#if 431156787 
import org.argouml.configuration.ConfigurationKey;
//#endif 


//#if 1708754200 
import org.argouml.i18n.Translator;
//#endif 


//#if 398266197 
public class ArgoToolbarManager  { 

//#if 1441723846 
private static final String KEY_NAME = "toolbars";
//#endif 


//#if -659128647 
private static ArgoToolbarManager instance;
//#endif 


//#if -1192343164 
private JPopupMenu popup;
//#endif 


//#if -652762937 
private JMenu menu;
//#endif 


//#if -884140171 
private ArrayList<JMenuItem> allMenuItems = new ArrayList<JMenuItem>();
//#endif 


//#if 97418112 
private ArgoToolbarManager()
    { 
} 

//#endif 


//#if 2140155974 
public void registerContainer(final JComponent container,
                                  final JToolBar[] toolbars)
    { 

//#if -323780446 
for (JToolBar toolbar : toolbars) //1
{ 

//#if 1067662257 
registerNew(toolbar, toolbar, -1);
//#endif 

} 

//#endif 


//#if 753356495 
for (JToolBar toolbar : toolbars) //2
{ 

//#if -2086606775 
toolbar.addComponentListener(new ComponentAdapter() {
                public void componentHidden(ComponentEvent e) {
                    boolean allHidden = true;
                    for (JToolBar bar : toolbars) {
                        if (bar.isVisible()) {
                            allHidden = false;
                            break;
                        }
                    }

                    if (allHidden) {
                        container.setVisible(false);
                    }
                }

                public void componentShown(ComponentEvent e) {
                    JToolBar oneVisible = null;
                    for (JToolBar bar : toolbars) {
                        if (bar.isVisible()) {
                            oneVisible = bar;
                            break;
                        }
                    }

                    if (oneVisible != null) {
                        container.setVisible(true);
                    }
                }
            });
//#endif 

} 

//#endif 

} 

//#endif 


//#if 525996203 
private JPopupMenu getPopupMenu()
    { 

//#if -364143307 
if(popup == null)//1
{ 

//#if -816037408 
popup = new JPopupMenu();
//#endif 

} 

//#endif 


//#if 152893540 
return popup;
//#endif 

} 

//#endif 


//#if 1567701125 
public JMenu getMenu()
    { 

//#if -2135839436 
if(menu == null)//1
{ 

//#if 396336874 
menu = new JMenu();
//#endif 

} 

//#endif 


//#if -2098563129 
return menu;
//#endif 

} 

//#endif 


//#if 476795040 
private void registerNew(Object key, JToolBar newToolbar,
                             int prefferedMenuPosition)
    { 

//#if 1251642652 
JCheckBoxMenuItem wantedMenuItem = null;
//#endif 


//#if -809642276 
for (int i = 0; i < getMenu().getItemCount(); i++) //1
{ 

//#if -183243275 
ToolbarManagerMenuItemAction menuItemAction =
                (ToolbarManagerMenuItemAction) getMenu()
                .getItem(i).getAction();
//#endif 


//#if 1996984516 
if(menuItemAction.getKey().equals(key))//1
{ 

//#if 1634414555 
wantedMenuItem = (JCheckBoxMenuItem) getMenu().getItem(i);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 716757824 
boolean visibility = getConfiguredToolbarAppearance(newToolbar
                             .getName());
//#endif 


//#if -755188636 
newToolbar.setVisible(visibility);
//#endif 


//#if -1398640256 
if(wantedMenuItem == null)//1
{ 

//#if 1364323644 
ToolbarManagerMenuItemAction action =
                new ToolbarManagerMenuItemAction(
                Translator.localize(newToolbar.getName()), key);
//#endif 


//#if 2092569045 
wantedMenuItem = new JCheckBoxMenuItem(Translator
                                                   .localize(newToolbar.getName()), newToolbar.isVisible());
//#endif 


//#if -897531038 
wantedMenuItem.setAction(action);
//#endif 


//#if 1986191989 
JCheckBoxMenuItem menuItem2 = new JCheckBoxMenuItem(Translator
                    .localize(newToolbar.getName()), newToolbar.isVisible());
//#endif 


//#if -335412311 
menuItem2.setAction(action);
//#endif 


//#if -863113038 
getMenu().insert(wantedMenuItem, prefferedMenuPosition);
//#endif 


//#if 1575441475 
getPopupMenu().insert(menuItem2, prefferedMenuPosition);
//#endif 


//#if -1414890235 
allMenuItems.add(wantedMenuItem);
//#endif 


//#if -827519968 
allMenuItems.add(menuItem2);
//#endif 

} 

//#endif 


//#if 743714807 
ArrayList<JToolBar> toolBarsForClass =
            ((ToolbarManagerMenuItemAction) wantedMenuItem
             .getAction()).getToolbars();
//#endif 


//#if -1940020043 
boolean visible = true;
//#endif 


//#if 1437189779 
if(toolBarsForClass.size() > 0)//1
{ 

//#if -1760404276 
visible = toolBarsForClass.get(0).isVisible();
//#endif 


//#if 254106540 
newToolbar.setVisible(visible);
//#endif 

} 

//#endif 


//#if 1586599648 
toolBarsForClass.add(newToolbar);
//#endif 


//#if -1375720087 
newToolbar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (e.isPopupTrigger()) {
                    getPopupMenu().show(e.getComponent(), e.getX(), e.getY());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (e.isPopupTrigger()) {
                    getPopupMenu().show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
//#endif 

} 

//#endif 


//#if -1318431927 
public void registerToolbar(Object key, JToolBar newToolbar,
                                int prefferedMenuPosition)
    { 

//#if -1463855509 
registerNew(key, newToolbar, prefferedMenuPosition);
//#endif 

} 

//#endif 


//#if -230468517 
public static ArgoToolbarManager getInstance()
    { 

//#if -1147820626 
if(instance == null)//1
{ 

//#if -196101429 
instance = new ArgoToolbarManager();
//#endif 

} 

//#endif 


//#if -1492177771 
return instance;
//#endif 

} 

//#endif 


//#if 590601537 
public boolean getConfiguredToolbarAppearance(String toolbarName)
    { 

//#if 1208209408 
ConfigurationKey key = Configuration.makeKey("toolbars", toolbarName);
//#endif 


//#if 1384483767 
String visibilityAsString = Configuration.getString(key);
//#endif 


//#if -1821178970 
return (visibilityAsString.equals("false")) ? false : true;
//#endif 

} 

//#endif 


//#if 1881096222 
private class ToolbarManagerMenuItemAction extends 
//#if 2110115645 
AbstractAction
//#endif 

  { 

//#if -554362087 
private Object key;
//#endif 


//#if 1982426743 
private ArrayList<JToolBar> toolbars = new ArrayList<JToolBar>();
//#endif 


//#if 308258546 
public void actionPerformed(final ActionEvent e)
        { 

//#if 671255327 
SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    for (JToolBar toolbar : getToolbars()) {
                        toolbar.setVisible(((JCheckBoxMenuItem) e.getSource())
                                           .isSelected());

                        // Make this change persistant
                        ConfigurationKey configurationKey = Configuration
                                                            .makeKey(ArgoToolbarManager.KEY_NAME, toolbar
                                                                    .getName());
                        Configuration.setString(configurationKey,
                                                ((Boolean) toolbar.isVisible()).toString());
                    }
                }
            });
//#endif 


//#if -1769700610 
for (JMenuItem menuItem : allMenuItems) //1
{ 

//#if -785840943 
if(menuItem.getAction().equals(this))//1
{ 

//#if -747586637 
menuItem.setSelected(((JCheckBoxMenuItem) e.getSource())
                                         .isSelected());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -408842409 
public Object getKey()
        { 

//#if -1998909182 
return key;
//#endif 

} 

//#endif 


//#if -457800139 
public ArrayList<JToolBar> getToolbars()
        { 

//#if -1620417834 
return toolbars;
//#endif 

} 

//#endif 


//#if -1152477701 
public ToolbarManagerMenuItemAction(String name, Object newKey)
        { 

//#if -1430526233 
super(name);
//#endif 


//#if -1026864693 
this.key = newKey;
//#endif 


//#if -403961622 
toolbars = new ArrayList<JToolBar>();
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

