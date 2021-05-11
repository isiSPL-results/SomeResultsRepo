
//#if 1145239493 
// Compilation Unit of /TabStyle.java 
 

//#if 1578201025 
package org.argouml.uml.ui;
//#endif 


//#if 1277646629 
import java.awt.BorderLayout;
//#endif 


//#if -506334751 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -1542708985 
import java.beans.PropertyChangeListener;
//#endif 


//#if -1470707295 
import java.util.Collection;
//#endif 


//#if 1900822519 
import java.util.Hashtable;
//#endif 


//#if 1710146141 
import javax.swing.JPanel;
//#endif 


//#if 925620907 
import javax.swing.SwingUtilities;
//#endif 


//#if 10135367 
import javax.swing.event.EventListenerList;
//#endif 


//#if 1884042045 
import org.apache.log4j.Logger;
//#endif 


//#if 1458531451 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if -336757736 
import org.argouml.kernel.DelayedChangeNotify;
//#endif 


//#if -1191625397 
import org.argouml.kernel.DelayedVChangeListener;
//#endif 


//#if 2137201242 
import org.argouml.kernel.Project;
//#endif 


//#if 2034458447 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -563388752 
import org.argouml.model.Model;
//#endif 


//#if 951025990 
import org.argouml.swingext.UpArrowIcon;
//#endif 


//#if -995910905 
import org.argouml.ui.StylePanel;
//#endif 


//#if -1003735782 
import org.argouml.ui.TabFigTarget;
//#endif 


//#if -1346856859 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if -1877492733 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if -180553617 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -629503121 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if 684333548 
import org.argouml.uml.diagram.ui.FigAssociationClass;
//#endif 


//#if -301409340 
import org.argouml.uml.diagram.ui.FigClassAssociationClass;
//#endif 


//#if -1634279988 
import org.argouml.uml.util.namespace.Namespace;
//#endif 


//#if 1908669 
import org.argouml.uml.util.namespace.StringNamespace;
//#endif 


//#if 493219613 
import org.argouml.uml.util.namespace.StringNamespaceElement;
//#endif 


//#if 201844903 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 2143366250 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if -223288716 
public class TabStyle extends 
//#if 217961125 
AbstractArgoJPanel
//#endif 

 implements 
//#if 90139024 
TabFigTarget
//#endif 

, 
//#if -521114455 
PropertyChangeListener
//#endif 

, 
//#if 195950536 
DelayedVChangeListener
//#endif 

  { 

//#if 1936612570 
private static final Logger LOG = Logger.getLogger(TabStyle.class);
//#endif 


//#if 351026521 
private Fig target;
//#endif 


//#if -157695777 
private boolean shouldBeEnabled = false;
//#endif 


//#if -1496487840 
private JPanel blankPanel = new JPanel();
//#endif 


//#if 509755065 
private Hashtable<Class, TabFigTarget> panels =
        new Hashtable<Class, TabFigTarget>();
//#endif 


//#if -1978984936 
private JPanel lastPanel = null;
//#endif 


//#if -1817711120 
private StylePanel stylePanel = null;
//#endif 


//#if 644944812 
private String[] stylePanelNames;
//#endif 


//#if -773290692 
private EventListenerList listenerList = new EventListenerList();
//#endif 


//#if 492022509 
public void delayedVetoableChange(PropertyChangeEvent pce)
    { 

//#if -1367139998 
if(stylePanel != null)//1
{ 

//#if 1864175432 
stylePanel.refresh(pce);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -942364431 
protected String[] getStylePanelNames()
    { 

//#if -1179375201 
return stylePanelNames;
//#endif 

} 

//#endif 


//#if -401440077 
private void fireTargetAdded(TargetEvent targetEvent)
    { 

//#if -186059397 
Object[] listeners = listenerList.getListenerList();
//#endif 


//#if -113592317 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if -1073236923 
if(listeners[i] == TargetListener.class)//1
{ 

//#if -115254499 
((TargetListener) listeners[i + 1]).targetAdded(targetEvent);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1086537156 
public StylePanel findPanelFor(Class targetClass)
    { 

//#if -2034932389 
Class panelClass = null;
//#endif 


//#if 2100231965 
TabFigTarget p = panels.get(targetClass);
//#endif 


//#if -2125181092 
if(p == null)//1
{ 

//#if 1522124625 
Class newClass = targetClass;
//#endif 


//#if -1577566587 
while (newClass != null && panelClass == null) //1
{ 

//#if -976223315 
panelClass = panelClassFor(newClass);
//#endif 


//#if -2078770127 
newClass = newClass.getSuperclass();
//#endif 

} 

//#endif 


//#if 951106110 
if(panelClass == null)//1
{ 

//#if 463950139 
return null;
//#endif 

} 

//#endif 


//#if -1458441818 
try //1
{ 

//#if 921474704 
p = (TabFigTarget) panelClass.newInstance();
//#endif 

} 

//#if -142370371 
catch (IllegalAccessException ignore) //1
{ 

//#if 1640311359 
LOG.error(ignore);
//#endif 


//#if 1607122163 
return null;
//#endif 

} 

//#endif 


//#if -484670966 
catch (InstantiationException ignore) //1
{ 

//#if -1582333769 
LOG.error(ignore);
//#endif 


//#if 1984970107 
return null;
//#endif 

} 

//#endif 


//#endif 


//#if -1348810187 
panels.put(targetClass, p);
//#endif 

} 

//#endif 


//#if 514133354 
LOG.debug("found style for " + targetClass.getName() + "("
                  + p.getClass() + ")");
//#endif 


//#if 279020337 
return (StylePanel) p;
//#endif 

} 

//#endif 


//#if 30970471 
private void addTargetListener(TargetListener listener)
    { 

//#if 1216616827 
listenerList.add(TargetListener.class, listener);
//#endif 

} 

//#endif 


//#if -1052992266 
public void propertyChange(PropertyChangeEvent pce)
    { 

//#if -90259355 
DelayedChangeNotify delayedNotify = new DelayedChangeNotify(this, pce);
//#endif 


//#if 1760990294 
SwingUtilities.invokeLater(delayedNotify);
//#endif 

} 

//#endif 


//#if 1039662229 
private void fireTargetSet(TargetEvent targetEvent)
    { 

//#if -984879676 
Object[] listeners = listenerList.getListenerList();
//#endif 


//#if -1694824116 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if 637372153 
if(listeners[i] == TargetListener.class)//1
{ 

//#if 894094417 
((TargetListener) listeners[i + 1]).targetSet(targetEvent);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1599462472 
public Class panelClassFor(Class targetClass)
    { 

//#if 1121780742 
if(targetClass == null)//1
{ 

//#if -1040680385 
return null;
//#endif 

} 

//#endif 


//#if 485868648 
StringNamespace classNs = (StringNamespace) StringNamespace
                                  .parse(targetClass);
//#endif 


//#if 440663534 
StringNamespace baseNs = (StringNamespace) StringNamespace.parse(
                                     "org.argouml.ui.", Namespace.JAVA_NS_TOKEN);
//#endif 


//#if 1200342435 
StringNamespaceElement targetClassElement =
            (StringNamespaceElement) classNs.peekNamespaceElement();
//#endif 


//#if 2100009737 
LOG.debug("Attempt to find style panel for: " + classNs);
//#endif 


//#if 1119347956 
classNs.popNamespaceElement();
//#endif 


//#if 1301303846 
String[] bases = new String[] {
            classNs.toString(), baseNs.toString()
        };
//#endif 


//#if -1763855188 
for (String stylePanelName : stylePanelNames) //1
{ 

//#if -183561511 
for (String baseName : bases) //1
{ 

//#if -1378495042 
String name = baseName + "." + stylePanelName
                              + targetClassElement;
//#endif 


//#if 2138940348 
Class cls = loadClass(name);
//#endif 


//#if -205363060 
if(cls != null)//1
{ 

//#if -102355413 
return cls;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 857059209 
return null;
//#endif 

} 

//#endif 


//#if -729023406 
public void addPanel(Class c, StylePanel s)
    { 

//#if 888227343 
panels.put(c, s);
//#endif 

} 

//#endif 


//#if -1416477495 
public void targetSet(TargetEvent e)
    { 

//#if 1326617725 
setTarget(e.getNewTarget());
//#endif 


//#if -566260871 
fireTargetSet(e);
//#endif 

} 

//#endif 


//#if 1282092854 
public TabStyle()
    { 

//#if -1105844933 
this("tab.style", new String[] {"StylePanel", "SP"});
//#endif 

} 

//#endif 


//#if -93458474 
public void setTarget(Object t)
    { 

//#if 1855927114 
if(target != null)//1
{ 

//#if -1961694224 
target.removePropertyChangeListener(this);
//#endif 


//#if -997452301 
if(target instanceof FigEdge)//1
{ 

//#if 2014251268 
((FigEdge) target).getFig().removePropertyChangeListener(this);
//#endif 

} 

//#endif 


//#if 1780378541 
if(target instanceof FigAssociationClass)//1
{ 

//#if -1006296431 
FigClassAssociationClass ac =
                    ((FigAssociationClass) target).getAssociationClass();
//#endif 


//#if -86338712 
if(ac != null)//1
{ 

//#if 1585734644 
ac.removePropertyChangeListener(this);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -66207112 
if(!(t instanceof Fig))//1
{ 

//#if -231017190 
if(Model.getFacade().isAModelElement(t))//1
{ 

//#if 1571649379 
ArgoDiagram diagram = DiagramUtils.getActiveDiagram();
//#endif 


//#if -228776025 
if(diagram != null)//1
{ 

//#if -1393458436 
t = diagram.presentationFor(t);
//#endif 

} 

//#endif 


//#if 1755248431 
if(!(t instanceof Fig))//1
{ 

//#if -2034766975 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -1944834501 
Collection col = p.findFigsForMember(t);
//#endif 


//#if -1669907011 
if(col == null || col.isEmpty())//1
{ 

//#if 872884922 
return;
//#endif 

} 

//#endif 


//#if -173985116 
t = col.iterator().next();
//#endif 

} 

//#endif 


//#if -620744414 
if(!(t instanceof Fig))//2
{ 

//#if -1499151663 
return;
//#endif 

} 

//#endif 

} 
else
{ 

//#if 2101917035 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1167556933 
target = (Fig) t;
//#endif 


//#if 810728231 
if(target != null)//2
{ 

//#if -1005350831 
target.addPropertyChangeListener(this);
//#endif 


//#if 2065322699 
if(target instanceof FigEdge)//1
{ 

//#if 942132131 
((FigEdge) target).getFig().addPropertyChangeListener(this);
//#endif 

} 

//#endif 


//#if -1346362235 
if(target instanceof FigAssociationClass)//1
{ 

//#if -8433209 
FigClassAssociationClass ac =
                    ((FigAssociationClass) target).getAssociationClass();
//#endif 


//#if 1986622110 
if(ac != null)//1
{ 

//#if -624546563 
ac.addPropertyChangeListener(this);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1143006869 
if(lastPanel != null)//1
{ 

//#if -796171027 
remove(lastPanel);
//#endif 


//#if 1996282125 
if(lastPanel instanceof TargetListener)//1
{ 

//#if 13953763 
removeTargetListener((TargetListener) lastPanel);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1779142987 
if(t == null)//1
{ 

//#if -789110044 
add(blankPanel, BorderLayout.NORTH);
//#endif 


//#if -372538950 
shouldBeEnabled = false;
//#endif 


//#if -1373596756 
lastPanel = blankPanel;
//#endif 


//#if -1448424485 
return;
//#endif 

} 

//#endif 


//#if -122748706 
shouldBeEnabled = true;
//#endif 


//#if -1056099737 
stylePanel = null;
//#endif 


//#if 543010349 
Class targetClass = t.getClass();
//#endif 


//#if 1278936636 
stylePanel = findPanelFor(targetClass);
//#endif 


//#if 999305996 
if(stylePanel != null)//1
{ 

//#if 574803506 
removeTargetListener(stylePanel);
//#endif 


//#if -1126306727 
addTargetListener(stylePanel);
//#endif 


//#if 1237097633 
stylePanel.setTarget(target);
//#endif 


//#if 441221599 
add(stylePanel, BorderLayout.NORTH);
//#endif 


//#if -661098679 
shouldBeEnabled = true;
//#endif 


//#if -862249049 
lastPanel = stylePanel;
//#endif 

} 
else
{ 

//#if 2104982374 
add(blankPanel, BorderLayout.NORTH);
//#endif 


//#if 1406893560 
shouldBeEnabled = false;
//#endif 


//#if 69277614 
lastPanel = blankPanel;
//#endif 

} 

//#endif 


//#if 2015751175 
validate();
//#endif 


//#if 574931852 
repaint();
//#endif 

} 

//#endif 


//#if 304902674 
private Class loadClass(String name)
    { 

//#if -701242456 
try //1
{ 

//#if 494525083 
Class cls = Class.forName(name);
//#endif 


//#if -790564680 
return cls;
//#endif 

} 

//#if -1205059105 
catch (ClassNotFoundException ignore) //1
{ 

//#if 233520017 
LOG.debug("ClassNotFoundException. Could not find class:"
                      + name);
//#endif 

} 

//#endif 


//#endif 


//#if -1010424142 
return null;
//#endif 

} 

//#endif 


//#if -1758925000 
private void removeTargetListener(TargetListener listener)
    { 

//#if -1998686919 
listenerList.remove(TargetListener.class, listener);
//#endif 

} 

//#endif 


//#if -1663454181 
public TabStyle(String tabName, String[] spn)
    { 

//#if -1341644654 
super(tabName);
//#endif 


//#if -822993553 
this.stylePanelNames = spn;
//#endif 


//#if 666399642 
setIcon(new UpArrowIcon());
//#endif 


//#if -1061129094 
setLayout(new BorderLayout());
//#endif 

} 

//#endif 


//#if 1038105415 
public void targetRemoved(TargetEvent e)
    { 

//#if -1267208028 
setTarget(e.getNewTarget());
//#endif 


//#if -1808796112 
fireTargetRemoved(e);
//#endif 

} 

//#endif 


//#if -409841297 
public void refresh()
    { 

//#if -696374022 
setTarget(target);
//#endif 

} 

//#endif 


//#if -793892390 
public boolean shouldBeEnabled(Object targetItem)
    { 

//#if 192330360 
if(!(targetItem instanceof Fig))//1
{ 

//#if 1843514678 
if(Model.getFacade().isAModelElement(targetItem))//1
{ 

//#if 672767095 
ArgoDiagram diagram = DiagramUtils.getActiveDiagram();
//#endif 


//#if -1905347465 
if(diagram == null)//1
{ 

//#if 868588983 
shouldBeEnabled = false;
//#endif 


//#if -1001650155 
return false;
//#endif 

} 

//#endif 


//#if -1117482139 
Fig f = diagram.presentationFor(targetItem);
//#endif 


//#if -379079670 
if(f == null)//1
{ 

//#if 459433627 
shouldBeEnabled = false;
//#endif 


//#if -1690313223 
return false;
//#endif 

} 

//#endif 


//#if 764988238 
targetItem = f;
//#endif 

} 
else
{ 

//#if -1270969335 
shouldBeEnabled = false;
//#endif 


//#if 676943079 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1445502404 
shouldBeEnabled = true;
//#endif 


//#if 1317416357 
Class targetClass = targetItem.getClass();
//#endif 


//#if -1818618078 
stylePanel = findPanelFor(targetClass);
//#endif 


//#if 865857723 
targetClass = targetClass.getSuperclass();
//#endif 


//#if -652309034 
if(stylePanel == null)//1
{ 

//#if -654374273 
shouldBeEnabled = false;
//#endif 

} 

//#endif 


//#if -1373512649 
return shouldBeEnabled;
//#endif 

} 

//#endif 


//#if -1715091728 
public Object getTarget()
    { 

//#if -240247963 
return target;
//#endif 

} 

//#endif 


//#if 720541075 
private void fireTargetRemoved(TargetEvent targetEvent)
    { 

//#if -370726829 
Object[] listeners = listenerList.getListenerList();
//#endif 


//#if -89832741 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if -1959902749 
if(listeners[i] == TargetListener.class)//1
{ 

//#if -1702434298 
((TargetListener) listeners[i + 1]).targetRemoved(targetEvent);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 221946983 
public void targetAdded(TargetEvent e)
    { 

//#if -938163754 
setTarget(e.getNewTarget());
//#endif 


//#if 1099518366 
fireTargetAdded(e);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

