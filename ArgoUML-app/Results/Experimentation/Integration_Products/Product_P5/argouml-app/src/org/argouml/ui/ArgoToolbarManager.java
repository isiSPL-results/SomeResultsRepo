package org.argouml.ui;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import org.argouml.configuration.Configuration;
import org.argouml.configuration.ConfigurationKey;
import org.argouml.i18n.Translator;
public class ArgoToolbarManager  { 
private static final String KEY_NAME = "toolbars";
private static ArgoToolbarManager instance;
private JPopupMenu popup;
private JMenu menu;
private ArrayList<JMenuItem> allMenuItems = new ArrayList<JMenuItem>();
private ArgoToolbarManager()
    { 
} 
public void registerContainer(final JComponent container,
                                  final JToolBar[] toolbars)
    { 
for (JToolBar toolbar : toolbars) //1
{ 
registerNew(toolbar, toolbar, -1);
} 
for (JToolBar toolbar : toolbars) //2
{ 
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
} 
} 
private JPopupMenu getPopupMenu()
    { 
if(popup == null)//1
{ 
popup = new JPopupMenu();
} 
return popup;
} 
public JMenu getMenu()
    { 
if(menu == null)//1
{ 
menu = new JMenu();
} 
return menu;
} 
private void registerNew(Object key, JToolBar newToolbar,
                             int prefferedMenuPosition)
    { 
JCheckBoxMenuItem wantedMenuItem = null;
for (int i = 0; i < getMenu().getItemCount(); i++) //1
{ 
ToolbarManagerMenuItemAction menuItemAction =
                (ToolbarManagerMenuItemAction) getMenu()
                .getItem(i).getAction();
if(menuItemAction.getKey().equals(key))//1
{ 
wantedMenuItem = (JCheckBoxMenuItem) getMenu().getItem(i);
} 
} 
boolean visibility = getConfiguredToolbarAppearance(newToolbar
                             .getName());
newToolbar.setVisible(visibility);
if(wantedMenuItem == null)//1
{ 
ToolbarManagerMenuItemAction action =
                new ToolbarManagerMenuItemAction(
                Translator.localize(newToolbar.getName()), key);
wantedMenuItem = new JCheckBoxMenuItem(Translator
                                                   .localize(newToolbar.getName()), newToolbar.isVisible());
wantedMenuItem.setAction(action);
JCheckBoxMenuItem menuItem2 = new JCheckBoxMenuItem(Translator
                    .localize(newToolbar.getName()), newToolbar.isVisible());
menuItem2.setAction(action);
getMenu().insert(wantedMenuItem, prefferedMenuPosition);
getPopupMenu().insert(menuItem2, prefferedMenuPosition);
allMenuItems.add(wantedMenuItem);
allMenuItems.add(menuItem2);
} 
ArrayList<JToolBar> toolBarsForClass =
            ((ToolbarManagerMenuItemAction) wantedMenuItem
             .getAction()).getToolbars();
boolean visible = true;
if(toolBarsForClass.size() > 0)//1
{ 
visible = toolBarsForClass.get(0).isVisible();
newToolbar.setVisible(visible);
} 
toolBarsForClass.add(newToolbar);
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
} 
public void registerToolbar(Object key, JToolBar newToolbar,
                                int prefferedMenuPosition)
    { 
registerNew(key, newToolbar, prefferedMenuPosition);
} 
public static ArgoToolbarManager getInstance()
    { 
if(instance == null)//1
{ 
instance = new ArgoToolbarManager();
} 
return instance;
} 
public boolean getConfiguredToolbarAppearance(String toolbarName)
    { 
ConfigurationKey key = Configuration.makeKey("toolbars", toolbarName);
String visibilityAsString = Configuration.getString(key);
return (visibilityAsString.equals("false")) ? false : true;
} 
private class ToolbarManagerMenuItemAction extends AbstractAction
  { 
private Object key;
private ArrayList<JToolBar> toolbars = new ArrayList<JToolBar>();
public void actionPerformed(final ActionEvent e)
        { 
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
for (JMenuItem menuItem : allMenuItems) //1
{ 
if(menuItem.getAction().equals(this))//1
{ 
menuItem.setSelected(((JCheckBoxMenuItem) e.getSource())
                                         .isSelected());
} 
} 
} 
public Object getKey()
        { 
return key;
} 
public ArrayList<JToolBar> getToolbars()
        { 
return toolbars;
} 
public ToolbarManagerMenuItemAction(String name, Object newKey)
        { 
super(name);
this.key = newKey;
toolbars = new ArrayList<JToolBar>();
} 

 } 

 } 
