// Compilation Unit of /DetailsPane.java 
 
package org.argouml.ui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;
import org.argouml.application.api.AbstractArgoJPanel;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.swingext.LeftArrowIcon;
import org.argouml.swingext.UpArrowIcon;
import org.argouml.ui.ProjectBrowser.Position;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.ui.targetmanager.TargetListener;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.ui.PropPanel;
import org.argouml.uml.ui.TabProps;
import org.tigris.swidgets.Orientable;
import org.tigris.swidgets.Orientation;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

public class DetailsPane extends JPanel
 implements ChangeListener
, MouseListener
, Orientable
, TargetListener
  { 
private JTabbedPane topLevelTabbedPane = new JTabbedPane();
private Object currentTarget;
private List<JPanel> tabPanelList = new ArrayList<JPanel>();
private int lastNonNullTab = -1;
private EventListenerList listenerList = new EventListenerList();
private Orientation orientation;
private boolean hasTabs = false;
private Icon upArrowIcon = new UpArrowIcon();
private Icon leftArrowIcon = new LeftArrowIcon();

//#if LOGGING 
private static final Logger LOG = Logger.getLogger(DetailsPane.class);
//#endif 

private void fireTargetRemoved(TargetEvent targetEvent)
    { 
Object[] listeners = listenerList.getListenerList();
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 
if(listeners[i] == TargetListener.class)//1
{ 
((TargetListener) listeners[i + 1]).targetRemoved(targetEvent);
} 

} 

} 

public void targetSet(TargetEvent e)
    { 
setTarget(e.getNewTarget(), false);
fireTargetSet(e);
} 

public void mouseExited(MouseEvent me)
    { 
} 

@Deprecated
    public boolean setToDoItem(Object item)
    { 
enableTabs(item);
for (JPanel t : tabPanelList) //1
{ 
if(t instanceof TabToDoTarget)//1
{ 
((TabToDoTarget) t).setTarget(item);
topLevelTabbedPane.setSelectedComponent(t);
return true;
} 

} 

return false;
} 

JTabbedPane getTabs()
    { 
return topLevelTabbedPane;
} 

public void mouseClicked(MouseEvent me)
    { 
int tab = topLevelTabbedPane.getSelectedIndex();
if(tab != -1)//1
{ 
Rectangle tabBounds = topLevelTabbedPane.getBoundsAt(tab);
if(!tabBounds.contains(me.getX(), me.getY()))//1
{ 
return;
} 

if(me.getClickCount() == 1)//1
{ 
mySingleClick(tab);
} 
else
if(me.getClickCount() >= 2)//1
{ 
myDoubleClick(tab);
} 


} 

} 

public void mouseReleased(MouseEvent me)
    { 
} 

public AbstractArgoJPanel getTab(
        Class< ? extends AbstractArgoJPanel> tabClass)
    { 
for (JPanel tab : tabPanelList) //1
{ 
if(tab.getClass().equals(tabClass))//1
{ 
return (AbstractArgoJPanel) tab;
} 

} 

return null;
} 

public void targetAdded(TargetEvent e)
    { 
setTarget(e.getNewTarget(), false);
fireTargetAdded(e);
} 

@Override
    public Dimension getMinimumSize()
    { 
return new Dimension(100, 100);
} 

public void addTab(AbstractArgoJPanel p, boolean atEnd)
    { 
Icon icon = p.getIcon();
String title = Translator.localize(p.getTitle());
if(atEnd)//1
{ 
topLevelTabbedPane.addTab(title, icon, p);
tabPanelList.add(p);
} 
else
{ 
topLevelTabbedPane.insertTab(title, icon, p, null, 0);
tabPanelList.add(0, p);
} 

} 

public void mySingleClick(int tab)
    { 

//#if LOGGING 
LOG.debug("single: "
                  + topLevelTabbedPane.getComponentAt(tab).toString());
//#endif 

} 

boolean hasTabs()
    { 
return hasTabs;
} 

private boolean selectPropsTab(Object target)
    { 
if(getTabProps().shouldBeEnabled(target))//1
{ 
int indexOfPropPanel = topLevelTabbedPane
                                   .indexOfComponent(getTabProps());
topLevelTabbedPane.setSelectedIndex(indexOfPropPanel);
lastNonNullTab = indexOfPropPanel;
return true;
} 

return false;
} 

public void setOrientation(Orientation newOrientation)
    { 
for (JPanel t : tabPanelList) //1
{ 
if(t instanceof Orientable)//1
{ 
Orientable o = (Orientable) t;
o.setOrientation(newOrientation);
} 

} 

} 

public TabProps getTabProps()
    { 
for (JPanel tab : tabPanelList) //1
{ 
if(tab instanceof TabProps)//1
{ 
return (TabProps) tab;
} 

} 

return null;
} 

public void targetRemoved(TargetEvent e)
    { 
setTarget(e.getNewTarget(), false);
fireTargetRemoved(e);
} 

public int getTabCount()
    { 
return tabPanelList.size();
} 

public void mouseEntered(MouseEvent me)
    { 
} 

public boolean selectTabNamed(String tabName)
    { 
int index = getIndexOfNamedTab(tabName);
if(index != -1)//1
{ 
topLevelTabbedPane.setSelectedIndex(index);
return true;
} 

return false;
} 

private void fireTargetAdded(TargetEvent targetEvent)
    { 
Object[] listeners = listenerList.getListenerList();
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 
if(listeners[i] == TargetListener.class)//1
{ 
((TargetListener) listeners[i + 1]).targetAdded(targetEvent);
} 

} 

} 

private void addTargetListener(TargetListener listener)
    { 
listenerList.add(TargetListener.class, listener);
} 

private void fireTargetSet(TargetEvent targetEvent)
    { 
Object[] listeners = listenerList.getListenerList();
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 
if(listeners[i] == TargetListener.class)//1
{ 
((TargetListener) listeners[i + 1]).targetSet(targetEvent);
} 

} 

} 

public void mousePressed(MouseEvent me)
    { 
} 

public void addToPropTab(Class c, PropPanel p)
    { 
for (JPanel panel : tabPanelList) //1
{ 
if(panel instanceof TabProps)//1
{ 
((TabProps) panel).addPanel(c, p);
} 

} 

} 

private void enableTabs(Object target)
    { 
for (int i = 0; i < tabPanelList.size(); i++) //1
{ 
JPanel tab = tabPanelList.get(i);
boolean shouldEnable = false;
if(tab instanceof TargetListener)//1
{ 
if(tab instanceof TabTarget)//1
{ 
shouldEnable = ((TabTarget) tab).shouldBeEnabled(target);
} 
else
{ 
if(tab instanceof TabToDoTarget)//1
{ 
shouldEnable = true;
} 

} 

removeTargetListener((TargetListener) tab);
if(shouldEnable)//1
{ 
addTargetListener((TargetListener) tab);
} 

} 

topLevelTabbedPane.setEnabledAt(i, shouldEnable);
} 

} 

private void setTarget(Object target, boolean defaultToProperties)
    { 
enableTabs(target);
if(target != null)//1
{ 
boolean tabSelected = false;
if(defaultToProperties || lastNonNullTab < 0)//1
{ 
tabSelected = selectPropsTab(target);
} 
else
{ 
Component selectedTab = topLevelTabbedPane
                                        .getComponentAt(lastNonNullTab);
if(selectedTab instanceof TabTarget)//1
{ 
if(((TabTarget) selectedTab).shouldBeEnabled(target))//1
{ 
topLevelTabbedPane.setSelectedIndex(lastNonNullTab);
tabSelected = true;
} 
else
{ 
tabSelected = selectPropsTab(target);
} 

} 

} 

if(!tabSelected)//1
{ 
for (int i = lastNonNullTab + 1;
                        i < topLevelTabbedPane.getTabCount();
                        i++) //1
{ 
Component tab = topLevelTabbedPane.getComponentAt(i);
if(tab instanceof TabTarget)//1
{ 
if(((TabTarget) tab).shouldBeEnabled(target))//1
{ 
topLevelTabbedPane.setSelectedIndex(i);
((TabTarget) tab).setTarget(target);
lastNonNullTab = i;
tabSelected = true;
break;

} 

} 

} 

} 

if(!tabSelected)//2
{ 
JPanel tab = tabPanelList.get(0);
if(!(tab instanceof TabToDoTarget))//1
{ 
for (JPanel panel : tabPanelList) //1
{ 
if(panel instanceof TabToDoTarget)//1
{ 
tab = panel;
break;

} 

} 

} 

if(tab instanceof TabToDoTarget)//1
{ 
topLevelTabbedPane.setSelectedComponent(tab);
((TabToDoTarget) tab).setTarget(target);
lastNonNullTab = topLevelTabbedPane.getSelectedIndex();
} 

} 

} 
else
{ 
JPanel tab =
                tabPanelList.isEmpty() ? null : (JPanel) tabPanelList.get(0);
if(!(tab instanceof TabToDoTarget))//1
{ 
Iterator it = tabPanelList.iterator();
while (it.hasNext()) //1
{ 
Object o = it.next();
if(o instanceof TabToDoTarget)//1
{ 
tab = (JPanel) o;
break;

} 

} 

} 

if(tab instanceof TabToDoTarget)//1
{ 
topLevelTabbedPane.setSelectedComponent(tab);
((TabToDoTarget) tab).setTarget(target);
} 
else
{ 
topLevelTabbedPane.setSelectedIndex(-1);
} 

} 

currentTarget = target;
} 

public void myDoubleClick(int tab)
    { 

//#if LOGGING 
LOG.debug("double: "
                  + topLevelTabbedPane.getComponentAt(tab).toString());
//#endif 

} 

public void stateChanged(ChangeEvent e)
    { 

//#if LOGGING 
LOG.debug("DetailsPane state changed");
//#endif 

Component sel = topLevelTabbedPane.getSelectedComponent();
if(lastNonNullTab >= 0)//1
{ 
JPanel tab = tabPanelList.get(lastNonNullTab);
if(tab instanceof TargetListener)//1
{ 
removeTargetListener((TargetListener) tab);
} 

} 

Object target = TargetManager.getInstance().getSingleTarget();
if(!(sel instanceof TabToDoTarget))//1
{ 
if(sel instanceof TabTarget)//1
{ 
((TabTarget) sel).setTarget(target);
} 
else
if(sel instanceof TargetListener)//1
{ 
removeTargetListener((TargetListener) sel);
addTargetListener((TargetListener) sel);
((TargetListener) sel).targetSet(new TargetEvent(this,
                                                 TargetEvent.TARGET_SET, new Object[] {},
                                                 new Object[] { target }));
} 


} 

if(target != null
                && Model.getFacade().isAUMLElement(target)
                && topLevelTabbedPane.getSelectedIndex() > 0)//1
{ 
lastNonNullTab = topLevelTabbedPane.getSelectedIndex();
} 

} 

public DetailsPane(String compassPoint, Orientation theOrientation)
    { 

//#if LOGGING 
LOG.info("making DetailsPane(" + compassPoint + ")");
//#endif 

orientation = theOrientation;
loadTabs(compassPoint, theOrientation);
setOrientation(orientation);
setLayout(new BorderLayout());
setFont(new Font("Dialog", Font.PLAIN, 10));
add(topLevelTabbedPane, BorderLayout.CENTER);
setTarget(null, true);
topLevelTabbedPane.addMouseListener(this);
topLevelTabbedPane.addChangeListener(this);
} 

public int getIndexOfNamedTab(String tabName)
    { 
for (int i = 0; i < tabPanelList.size(); i++) //1
{ 
String title = topLevelTabbedPane.getTitleAt(i);
if(title != null && title.equals(tabName))//1
{ 
return i;
} 

} 

return -1;
} 

private void loadTabs(String direction, Orientation theOrientation)
    { 
if(Position.South.toString().equalsIgnoreCase(direction)
                // Special case for backward compatibility
                || "detail".equalsIgnoreCase(direction))//1
{ 
hasTabs = true;
} 

} 

private void removeTargetListener(TargetListener listener)
    { 
listenerList.remove(TargetListener.class, listener);
} 

public Object getTarget()
    { 
return currentTarget;
} 

 } 


