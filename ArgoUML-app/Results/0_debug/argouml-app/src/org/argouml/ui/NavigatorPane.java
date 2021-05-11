
//#if 401402529 
// Compilation Unit of /NavigatorPane.java 
 

//#if 942258047 
package org.argouml.ui;
//#endif 


//#if -916128311 
import java.awt.BorderLayout;
//#endif 


//#if -1939919663 
import java.awt.Dimension;
//#endif 


//#if -1978969244 
import java.util.ArrayList;
//#endif 


//#if 121093757 
import java.util.Collection;
//#endif 


//#if 1844124604 
import javax.swing.JComboBox;
//#endif 


//#if -956350919 
import javax.swing.JPanel;
//#endif 


//#if 1298973892 
import javax.swing.JScrollPane;
//#endif 


//#if -1974892734 
import javax.swing.JToolBar;
//#endif 


//#if -1657689458 
import org.argouml.i18n.Translator;
//#endif 


//#if 134673125 
import org.argouml.ui.explorer.ActionPerspectiveConfig;
//#endif 


//#if 1148255542 
import org.argouml.ui.explorer.DnDExplorerTree;
//#endif 


//#if -672813076 
import org.argouml.ui.explorer.ExplorerTree;
//#endif 


//#if -1492529855 
import org.argouml.ui.explorer.ExplorerTreeModel;
//#endif 


//#if 1394886474 
import org.argouml.ui.explorer.NameOrder;
//#endif 


//#if -2015998124 
import org.argouml.ui.explorer.PerspectiveComboBox;
//#endif 


//#if -992014696 
import org.argouml.ui.explorer.PerspectiveManager;
//#endif 


//#if 1082395937 
import org.argouml.ui.explorer.TypeThenNameOrder;
//#endif 


//#if 573853471 
import org.tigris.toolbar.ToolBarFactory;
//#endif 


//#if -792916798 
class NavigatorPane extends 
//#if -1549637547 
JPanel
//#endif 

  { 

//#if 662835086 
private static final long serialVersionUID = 8403903607517813289L;
//#endif 


//#if -1151105636 
public Dimension getMinimumSize()
    { 

//#if -667603818 
return new Dimension(120, 100);
//#endif 

} 

//#endif 


//#if -1161552222 
public NavigatorPane(SplashScreen splash)
    { 

//#if -812223922 
JComboBox perspectiveCombo = new PerspectiveComboBox();
//#endif 


//#if -1014185673 
JComboBox orderByCombo = new JComboBox();
//#endif 


//#if 374489840 
ExplorerTree tree = new DnDExplorerTree();
//#endif 


//#if -1592779725 
Collection<Object> toolbarTools = new ArrayList<Object>();
//#endif 


//#if -393080671 
toolbarTools.add(new ActionPerspectiveConfig());
//#endif 


//#if 1719968202 
toolbarTools.add(perspectiveCombo);
//#endif 


//#if 1789491914 
JToolBar toolbar = (new ToolBarFactory(toolbarTools)).createToolBar();
//#endif 


//#if -415665245 
toolbar.setFloatable(false);
//#endif 


//#if -1392731127 
orderByCombo.addItem(new TypeThenNameOrder());
//#endif 


//#if -1772928704 
orderByCombo.addItem(new NameOrder());
//#endif 


//#if 2048064197 
Collection<Object> toolbarTools2 = new ArrayList<Object>();
//#endif 


//#if -415633235 
toolbarTools2.add(orderByCombo);
//#endif 


//#if -1647250990 
JToolBar toolbar2 = (new ToolBarFactory(toolbarTools2)).createToolBar();
//#endif 


//#if -675109879 
toolbar2.setFloatable(false);
//#endif 


//#if 699963243 
JPanel toolbarpanel = new JPanel();
//#endif 


//#if 624203607 
toolbarpanel.setLayout(new BorderLayout());
//#endif 


//#if -1951021875 
toolbarpanel.add(toolbar, BorderLayout.NORTH);
//#endif 


//#if 1804269727 
toolbarpanel.add(toolbar2, BorderLayout.SOUTH);
//#endif 


//#if -576390946 
setLayout(new BorderLayout());
//#endif 


//#if 1844667084 
add(toolbarpanel, BorderLayout.NORTH);
//#endif 


//#if -754078005 
add(new JScrollPane(tree), BorderLayout.CENTER);
//#endif 


//#if 338892302 
if(splash != null)//1
{ 

//#if -1679377113 
splash.getStatusBar().showStatus(Translator.localize(
                                                 "statusmsg.bar.making-navigator-pane-perspectives"));
//#endif 


//#if -1404683487 
splash.getStatusBar().showProgress(25);
//#endif 

} 

//#endif 


//#if 1109296126 
perspectiveCombo.addItemListener((ExplorerTreeModel) tree.getModel());
//#endif 


//#if 1503031623 
orderByCombo.addItemListener((ExplorerTreeModel) tree.getModel());
//#endif 


//#if -704350974 
PerspectiveManager.getInstance().loadUserPerspectives();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

