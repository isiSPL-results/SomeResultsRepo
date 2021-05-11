
//#if -2100177432 
// Compilation Unit of /DetailsPane.java 
 

//#if -1057943598 
package org.argouml.ui;
//#endif 


//#if -1410364452 
import java.awt.BorderLayout;
//#endif 


//#if 1862324967 
import java.awt.Component;
//#endif 


//#if -1570861154 
import java.awt.Dimension;
//#endif 


//#if 296979491 
import java.awt.Font;
//#endif 


//#if -1584639819 
import java.awt.Rectangle;
//#endif 


//#if -692389783 
import java.awt.event.MouseEvent;
//#endif 


//#if 494611839 
import java.awt.event.MouseListener;
//#endif 


//#if 871909943 
import java.util.ArrayList;
//#endif 


//#if -1928345222 
import java.util.Iterator;
//#endif 


//#if -1411439158 
import java.util.List;
//#endif 


//#if 807982439 
import javax.swing.Icon;
//#endif 


//#if -587292410 
import javax.swing.JPanel;
//#endif 


//#if 1496665976 
import javax.swing.JTabbedPane;
//#endif 


//#if 2031990048 
import javax.swing.event.ChangeEvent;
//#endif 


//#if 497164648 
import javax.swing.event.ChangeListener;
//#endif 


//#if -271528002 
import javax.swing.event.EventListenerList;
//#endif 


//#if 1063527332 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if -1842340255 
import org.argouml.i18n.Translator;
//#endif 


//#if 1828274599 
import org.argouml.model.Model;
//#endif 


//#if -702581797 
import org.argouml.swingext.LeftArrowIcon;
//#endif 


//#if 1098646575 
import org.argouml.swingext.UpArrowIcon;
//#endif 


//#if -1402466819 
import org.argouml.ui.ProjectBrowser.Position;
//#endif 


//#if -550755762 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if -2039120518 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if -1150123941 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1938171606 
import org.argouml.uml.ui.PropPanel;
//#endif 


//#if 1781988752 
import org.argouml.uml.ui.TabProps;
//#endif 


//#if -757746927 
import org.tigris.swidgets.Orientable;
//#endif 


//#if -1998773002 
import org.tigris.swidgets.Orientation;
//#endif 


//#if -19261900 
import org.apache.log4j.Logger;
//#endif 


//#if 216155241 
public class DetailsPane extends 
//#if -1450727761 
JPanel
//#endif 

 implements 
//#if 1263313529 
ChangeListener
//#endif 

, 
//#if -1995388956 
MouseListener
//#endif 

, 
//#if -1537741932 
Orientable
//#endif 

, 
//#if -43217062 
TargetListener
//#endif 

  { 

//#if 1933136818 
private JTabbedPane topLevelTabbedPane = new JTabbedPane();
//#endif 


//#if 2037599358 
private Object currentTarget;
//#endif 


//#if -891983105 
private List<JPanel> tabPanelList = new ArrayList<JPanel>();
//#endif 


//#if -38861806 
private int lastNonNullTab = -1;
//#endif 


//#if 1365154689 
private EventListenerList listenerList = new EventListenerList();
//#endif 


//#if -698568435 
private Orientation orientation;
//#endif 


//#if -1679790249 
private boolean hasTabs = false;
//#endif 


//#if 1521524694 
private Icon upArrowIcon = new UpArrowIcon();
//#endif 


//#if -811606442 
private Icon leftArrowIcon = new LeftArrowIcon();
//#endif 


//#if -1056649463 
private static final Logger LOG = Logger.getLogger(DetailsPane.class);
//#endif 


//#if 72466648 
private void fireTargetRemoved(TargetEvent targetEvent)
    { 

//#if -1106269599 
Object[] listeners = listenerList.getListenerList();
//#endif 


//#if 1015001833 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if -417202157 
if(listeners[i] == TargetListener.class)//1
{ 

//#if -1057689415 
((TargetListener) listeners[i + 1]).targetRemoved(targetEvent);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1837792676 
public void targetSet(TargetEvent e)
    { 

//#if -1939903579 
setTarget(e.getNewTarget(), false);
//#endif 


//#if 977389224 
fireTargetSet(e);
//#endif 

} 

//#endif 


//#if 494645604 
public void mouseExited(MouseEvent me)
    { 
} 

//#endif 


//#if 1912853961 
@Deprecated
    public boolean setToDoItem(Object item)
    { 

//#if -682922300 
enableTabs(item);
//#endif 


//#if -207511556 
for (JPanel t : tabPanelList) //1
{ 

//#if -1891841395 
if(t instanceof TabToDoTarget)//1
{ 

//#if 144714004 
((TabToDoTarget) t).setTarget(item);
//#endif 


//#if 1586027047 
topLevelTabbedPane.setSelectedComponent(t);
//#endif 


//#if -1619525925 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -256934448 
return false;
//#endif 

} 

//#endif 


//#if 869907852 
JTabbedPane getTabs()
    { 

//#if 2814079 
return topLevelTabbedPane;
//#endif 

} 

//#endif 


//#if -2084794680 
public void mouseClicked(MouseEvent me)
    { 

//#if 1209344858 
int tab = topLevelTabbedPane.getSelectedIndex();
//#endif 


//#if -204836323 
if(tab != -1)//1
{ 

//#if 2095015045 
Rectangle tabBounds = topLevelTabbedPane.getBoundsAt(tab);
//#endif 


//#if 396786538 
if(!tabBounds.contains(me.getX(), me.getY()))//1
{ 

//#if -1206305726 
return;
//#endif 

} 

//#endif 


//#if 50027477 
if(me.getClickCount() == 1)//1
{ 

//#if 694931545 
mySingleClick(tab);
//#endif 

} 
else

//#if 1229052962 
if(me.getClickCount() >= 2)//1
{ 

//#if -1500040713 
myDoubleClick(tab);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -1685261404 
public void mouseReleased(MouseEvent me)
    { 
} 

//#endif 


//#if -860839855 
public AbstractArgoJPanel getTab(
        Class< ? extends AbstractArgoJPanel> tabClass)
    { 

//#if 1280714691 
for (JPanel tab : tabPanelList) //1
{ 

//#if 432824590 
if(tab.getClass().equals(tabClass))//1
{ 

//#if -251237964 
return (AbstractArgoJPanel) tab;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1130930636 
return null;
//#endif 

} 

//#endif 


//#if 839389826 
public void targetAdded(TargetEvent e)
    { 

//#if -1221331367 
setTarget(e.getNewTarget(), false);
//#endif 


//#if -395991470 
fireTargetAdded(e);
//#endif 

} 

//#endif 


//#if 125237664 
@Override
    public Dimension getMinimumSize()
    { 

//#if 644209555 
return new Dimension(100, 100);
//#endif 

} 

//#endif 


//#if -513112106 
public void addTab(AbstractArgoJPanel p, boolean atEnd)
    { 

//#if 855201997 
Icon icon = p.getIcon();
//#endif 


//#if -934201989 
String title = Translator.localize(p.getTitle());
//#endif 


//#if -760221780 
if(atEnd)//1
{ 

//#if 287050240 
topLevelTabbedPane.addTab(title, icon, p);
//#endif 


//#if -1142911506 
tabPanelList.add(p);
//#endif 

} 
else
{ 

//#if 896481617 
topLevelTabbedPane.insertTab(title, icon, p, null, 0);
//#endif 


//#if -631466994 
tabPanelList.add(0, p);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1837912765 
public void mySingleClick(int tab)
    { 

//#if -1786092953 
LOG.debug("single: "
                  + topLevelTabbedPane.getComponentAt(tab).toString());
//#endif 

} 

//#endif 


//#if -947724890 
boolean hasTabs()
    { 

//#if 1615271801 
return hasTabs;
//#endif 

} 

//#endif 


//#if 1119399116 
private boolean selectPropsTab(Object target)
    { 

//#if -286223085 
if(getTabProps().shouldBeEnabled(target))//1
{ 

//#if -895004397 
int indexOfPropPanel = topLevelTabbedPane
                                   .indexOfComponent(getTabProps());
//#endif 


//#if 1217352036 
topLevelTabbedPane.setSelectedIndex(indexOfPropPanel);
//#endif 


//#if -846227505 
lastNonNullTab = indexOfPropPanel;
//#endif 


//#if 2098707243 
return true;
//#endif 

} 

//#endif 


//#if 1694242111 
return false;
//#endif 

} 

//#endif 


//#if 1863894065 
public void setOrientation(Orientation newOrientation)
    { 

//#if -101447906 
for (JPanel t : tabPanelList) //1
{ 

//#if 541748165 
if(t instanceof Orientable)//1
{ 

//#if -824723523 
Orientable o = (Orientable) t;
//#endif 


//#if -156153898 
o.setOrientation(newOrientation);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1078210425 
public TabProps getTabProps()
    { 

//#if 1058713305 
for (JPanel tab : tabPanelList) //1
{ 

//#if -527592904 
if(tab instanceof TabProps)//1
{ 

//#if -572818021 
return (TabProps) tab;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -675106082 
return null;
//#endif 

} 

//#endif 


//#if 1695190690 
public void targetRemoved(TargetEvent e)
    { 

//#if -1927567341 
setTarget(e.getNewTarget(), false);
//#endif 


//#if -49006344 
fireTargetRemoved(e);
//#endif 

} 

//#endif 


//#if -4225376 
public int getTabCount()
    { 

//#if 731469672 
return tabPanelList.size();
//#endif 

} 

//#endif 


//#if 5058584 
public void mouseEntered(MouseEvent me)
    { 
} 

//#endif 


//#if -341061864 
public boolean selectTabNamed(String tabName)
    { 

//#if -1010999032 
int index = getIndexOfNamedTab(tabName);
//#endif 


//#if 1071520122 
if(index != -1)//1
{ 

//#if -898414628 
topLevelTabbedPane.setSelectedIndex(index);
//#endif 


//#if 1927133021 
return true;
//#endif 

} 

//#endif 


//#if -294643405 
return false;
//#endif 

} 

//#endif 


//#if 1734196024 
private void fireTargetAdded(TargetEvent targetEvent)
    { 

//#if 792641108 
Object[] listeners = listenerList.getListenerList();
//#endif 


//#if 147810780 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if 749408160 
if(listeners[i] == TargetListener.class)//1
{ 

//#if 2097733266 
((TargetListener) listeners[i + 1]).targetAdded(targetEvent);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -617103956 
private void addTargetListener(TargetListener listener)
    { 

//#if -41473619 
listenerList.add(TargetListener.class, listener);
//#endif 

} 

//#endif 


//#if 760320602 
private void fireTargetSet(TargetEvent targetEvent)
    { 

//#if -32803549 
Object[] listeners = listenerList.getListenerList();
//#endif 


//#if -519348309 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if -442244250 
if(listeners[i] == TargetListener.class)//1
{ 

//#if -1160812852 
((TargetListener) listeners[i + 1]).targetSet(targetEvent);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 755996547 
public void mousePressed(MouseEvent me)
    { 
} 

//#endif 


//#if 19004761 
public void addToPropTab(Class c, PropPanel p)
    { 

//#if 1574098288 
for (JPanel panel : tabPanelList) //1
{ 

//#if -1473645890 
if(panel instanceof TabProps)//1
{ 

//#if 2066659361 
((TabProps) panel).addPanel(c, p);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1584620820 
private void enableTabs(Object target)
    { 

//#if 1811974373 
for (int i = 0; i < tabPanelList.size(); i++) //1
{ 

//#if 885961855 
JPanel tab = tabPanelList.get(i);
//#endif 


//#if -637651316 
boolean shouldEnable = false;
//#endif 


//#if 1252062040 
if(tab instanceof TargetListener)//1
{ 

//#if 756807036 
if(tab instanceof TabTarget)//1
{ 

//#if -1775519107 
shouldEnable = ((TabTarget) tab).shouldBeEnabled(target);
//#endif 

} 
else
{ 

//#if 1609503115 
if(tab instanceof TabToDoTarget)//1
{ 

//#if 1853176357 
shouldEnable = true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -636733176 
removeTargetListener((TargetListener) tab);
//#endif 


//#if 604137677 
if(shouldEnable)//1
{ 

//#if 1224532025 
addTargetListener((TargetListener) tab);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1370625589 
topLevelTabbedPane.setEnabledAt(i, shouldEnable);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2023691677 
private void setTarget(Object target, boolean defaultToProperties)
    { 

//#if 1390162771 
enableTabs(target);
//#endif 


//#if -997609488 
if(target != null)//1
{ 

//#if 1645157021 
boolean tabSelected = false;
//#endif 


//#if -1122696953 
if(defaultToProperties || lastNonNullTab < 0)//1
{ 

//#if 651833769 
tabSelected = selectPropsTab(target);
//#endif 

} 
else
{ 

//#if 989869044 
Component selectedTab = topLevelTabbedPane
                                        .getComponentAt(lastNonNullTab);
//#endif 


//#if -435040549 
if(selectedTab instanceof TabTarget)//1
{ 

//#if 799316941 
if(((TabTarget) selectedTab).shouldBeEnabled(target))//1
{ 

//#if -595949725 
topLevelTabbedPane.setSelectedIndex(lastNonNullTab);
//#endif 


//#if -386137106 
tabSelected = true;
//#endif 

} 
else
{ 

//#if 1017852011 
tabSelected = selectPropsTab(target);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1480721170 
if(!tabSelected)//1
{ 

//#if -1325476941 
for (int i = lastNonNullTab + 1;
                        i < topLevelTabbedPane.getTabCount();
                        i++) //1
{ 

//#if 1048923621 
Component tab = topLevelTabbedPane.getComponentAt(i);
//#endif 


//#if -960628410 
if(tab instanceof TabTarget)//1
{ 

//#if -775062057 
if(((TabTarget) tab).shouldBeEnabled(target))//1
{ 

//#if 1334610852 
topLevelTabbedPane.setSelectedIndex(i);
//#endif 


//#if -305345248 
((TabTarget) tab).setTarget(target);
//#endif 


//#if 2017517865 
lastNonNullTab = i;
//#endif 


//#if -733395343 
tabSelected = true;
//#endif 


//#if -998315797 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1444645281 
if(!tabSelected)//2
{ 

//#if 1486525407 
JPanel tab = tabPanelList.get(0);
//#endif 


//#if 92506018 
if(!(tab instanceof TabToDoTarget))//1
{ 

//#if 1008787597 
for (JPanel panel : tabPanelList) //1
{ 

//#if 544653675 
if(panel instanceof TabToDoTarget)//1
{ 

//#if -347758431 
tab = panel;
//#endif 


//#if -90426178 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 486928976 
if(tab instanceof TabToDoTarget)//1
{ 

//#if -2077853826 
topLevelTabbedPane.setSelectedComponent(tab);
//#endif 


//#if -1044031511 
((TabToDoTarget) tab).setTarget(target);
//#endif 


//#if -1903720408 
lastNonNullTab = topLevelTabbedPane.getSelectedIndex();
//#endif 

} 

//#endif 

} 

//#endif 

} 
else
{ 

//#if -811098344 
JPanel tab =
                tabPanelList.isEmpty() ? null : (JPanel) tabPanelList.get(0);
//#endif 


//#if 1631761597 
if(!(tab instanceof TabToDoTarget))//1
{ 

//#if 60959186 
Iterator it = tabPanelList.iterator();
//#endif 


//#if -1630295705 
while (it.hasNext()) //1
{ 

//#if -1183667050 
Object o = it.next();
//#endif 


//#if 1935767423 
if(o instanceof TabToDoTarget)//1
{ 

//#if -347260491 
tab = (JPanel) o;
//#endif 


//#if 238529334 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -729525483 
if(tab instanceof TabToDoTarget)//1
{ 

//#if 1826248612 
topLevelTabbedPane.setSelectedComponent(tab);
//#endif 


//#if -1235891057 
((TabToDoTarget) tab).setTarget(target);
//#endif 

} 
else
{ 

//#if 1222131918 
topLevelTabbedPane.setSelectedIndex(-1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1023799616 
currentTarget = target;
//#endif 

} 

//#endif 


//#if -926441004 
public void myDoubleClick(int tab)
    { 

//#if -1730846519 
LOG.debug("double: "
                  + topLevelTabbedPane.getComponentAt(tab).toString());
//#endif 

} 

//#endif 


//#if 343042139 
public void stateChanged(ChangeEvent e)
    { 

//#if -1967449174 
LOG.debug("DetailsPane state changed");
//#endif 


//#if 1883006979 
Component sel = topLevelTabbedPane.getSelectedComponent();
//#endif 


//#if -458408233 
if(lastNonNullTab >= 0)//1
{ 

//#if 1058535571 
JPanel tab = tabPanelList.get(lastNonNullTab);
//#endif 


//#if -931146742 
if(tab instanceof TargetListener)//1
{ 

//#if 1768781436 
removeTargetListener((TargetListener) tab);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1476739892 
Object target = TargetManager.getInstance().getSingleTarget();
//#endif 


//#if 2078045785 
if(!(sel instanceof TabToDoTarget))//1
{ 

//#if -920852339 
if(sel instanceof TabTarget)//1
{ 

//#if 1732860905 
((TabTarget) sel).setTarget(target);
//#endif 

} 
else

//#if -1032241450 
if(sel instanceof TargetListener)//1
{ 

//#if 1317431393 
removeTargetListener((TargetListener) sel);
//#endif 


//#if -207191458 
addTargetListener((TargetListener) sel);
//#endif 


//#if 1431505748 
((TargetListener) sel).targetSet(new TargetEvent(this,
                                                 TargetEvent.TARGET_SET, new Object[] {},
                                                 new Object[] { target }));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1992932889 
if(target != null
                && Model.getFacade().isAUMLElement(target)
                && topLevelTabbedPane.getSelectedIndex() > 0)//1
{ 

//#if 1117835801 
lastNonNullTab = topLevelTabbedPane.getSelectedIndex();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1816625733 
public DetailsPane(String compassPoint, Orientation theOrientation)
    { 

//#if 1210071402 
LOG.info("making DetailsPane(" + compassPoint + ")");
//#endif 


//#if -1011871511 
orientation = theOrientation;
//#endif 


//#if -759418879 
loadTabs(compassPoint, theOrientation);
//#endif 


//#if -1306439378 
setOrientation(orientation);
//#endif 


//#if -1351643865 
setLayout(new BorderLayout());
//#endif 


//#if 1675231097 
setFont(new Font("Dialog", Font.PLAIN, 10));
//#endif 


//#if 1547341059 
add(topLevelTabbedPane, BorderLayout.CENTER);
//#endif 


//#if 61105898 
setTarget(null, true);
//#endif 


//#if -1420249253 
topLevelTabbedPane.addMouseListener(this);
//#endif 


//#if 1800987000 
topLevelTabbedPane.addChangeListener(this);
//#endif 

} 

//#endif 


//#if 1742555458 
public int getIndexOfNamedTab(String tabName)
    { 

//#if 312528275 
for (int i = 0; i < tabPanelList.size(); i++) //1
{ 

//#if -1424454745 
String title = topLevelTabbedPane.getTitleAt(i);
//#endif 


//#if 1044392958 
if(title != null && title.equals(tabName))//1
{ 

//#if -1632793826 
return i;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1774534763 
return -1;
//#endif 

} 

//#endif 


//#if -910310214 
private void loadTabs(String direction, Orientation theOrientation)
    { 

//#if 394381387 
if(Position.South.toString().equalsIgnoreCase(direction)
                // Special case for backward compatibility
                || "detail".equalsIgnoreCase(direction))//1
{ 

//#if 1919534600 
hasTabs = true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1628783059 
private void removeTargetListener(TargetListener listener)
    { 

//#if 1798578914 
listenerList.remove(TargetListener.class, listener);
//#endif 

} 

//#endif 


//#if 1468745099 
public Object getTarget()
    { 

//#if 1973224391 
return currentTarget;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

