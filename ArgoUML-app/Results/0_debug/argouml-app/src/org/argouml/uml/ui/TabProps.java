
//#if -1928756817 
// Compilation Unit of /TabProps.java 
 

//#if -581456309 
package org.argouml.uml.ui;
//#endif 


//#if 316152623 
import java.awt.BorderLayout;
//#endif 


//#if -936057062 
import java.util.Enumeration;
//#endif 


//#if -258834815 
import java.util.Hashtable;
//#endif 


//#if 1224837779 
import javax.swing.JPanel;
//#endif 


//#if -751398447 
import javax.swing.event.EventListenerList;
//#endif 


//#if 1306270919 
import org.apache.log4j.Logger;
//#endif 


//#if -329226319 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if 343084016 
import org.argouml.cognitive.Critic;
//#endif 


//#if -1141159878 
import org.argouml.model.Model;
//#endif 


//#if -1282624772 
import org.argouml.swingext.UpArrowIcon;
//#endif 


//#if -1722151073 
import org.argouml.ui.TabModelTarget;
//#endif 


//#if 2138813467 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if 302873741 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if -2044407064 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -942087431 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 279949003 
import org.argouml.uml.diagram.ui.PropPanelString;
//#endif 


//#if -7000981 
import org.tigris.gef.base.Diagram;
//#endif 


//#if 545433649 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1395731844 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 1153358009 
import org.tigris.swidgets.Horizontal;
//#endif 


//#if -353521378 
import org.tigris.swidgets.Orientable;
//#endif 


//#if 1942284425 
import org.tigris.swidgets.Orientation;
//#endif 


//#if 747124457 
public class TabProps extends 
//#if 1584234194 
AbstractArgoJPanel
//#endif 

 implements 
//#if -1156667166 
TabModelTarget
//#endif 

  { 

//#if -1912458420 
private static final Logger LOG = Logger.getLogger(TabProps.class);
//#endif 


//#if -1155710131 
private JPanel blankPanel = new JPanel();
//#endif 


//#if -1883819514 
private Hashtable<Class, TabModelTarget> panels =
        new Hashtable<Class, TabModelTarget>();
//#endif 


//#if -551011603 
private JPanel lastPanel;
//#endif 


//#if 845022373 
private String panelClassBaseName = "";
//#endif 


//#if -1074869339 
private Object target;
//#endif 


//#if 729917737 
private EventListenerList listenerList = new EventListenerList();
//#endif 


//#if 660421590 
public void targetRemoved(TargetEvent targetEvent)
    { 

//#if 2090914619 
setTarget(TargetManager.getInstance().getSingleTarget());
//#endif 


//#if -1509627058 
fireTargetRemoved(targetEvent);
//#endif 


//#if -470993850 
validate();
//#endif 


//#if -1167853715 
repaint();
//#endif 

} 

//#endif 


//#if -327748780 
private void addTargetListener(TargetListener listener)
    { 

//#if 1778700095 
listenerList.add(TargetListener.class, listener);
//#endif 

} 

//#endif 


//#if 1809468203 
private void removeTargetListener(TargetListener listener)
    { 

//#if 1277585460 
listenerList.remove(TargetListener.class, listener);
//#endif 

} 

//#endif 


//#if -1536696906 
public void targetAdded(TargetEvent targetEvent)
    { 

//#if 2053673722 
setTarget(TargetManager.getInstance().getSingleTarget());
//#endif 


//#if -763573523 
fireTargetAdded(targetEvent);
//#endif 


//#if 1217342352 
if(listenerList.getListenerCount() > 0)//1
{ 

//#if -226341632 
validate();
//#endif 


//#if 2026626931 
repaint();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -823159478 
@Deprecated
    public Object getTarget()
    { 

//#if -1984813308 
return target;
//#endif 

} 

//#endif 


//#if 558490001 
@Deprecated
    public void setTarget(Object target)
    { 

//#if 1554145975 
LOG.info("setTarget: there are "
                 + TargetManager.getInstance().getTargets().size()
                 + " targets");
//#endif 


//#if -1987933381 
target = (target instanceof Fig) ? ((Fig) target).getOwner() : target;
//#endif 


//#if 1448313302 
if(!(target == null || Model.getFacade().isAUMLElement(target)
                || target instanceof ArgoDiagram


                // TODO Improve extensibility of this!
                || target instanceof Critic

             ))//1
{ 

//#if -1941807592 
target = null;
//#endif 

} 

//#endif 


//#if 1363963037 
if(lastPanel != null)//1
{ 

//#if 1522402257 
remove(lastPanel);
//#endif 


//#if 544306417 
if(lastPanel instanceof TargetListener)//1
{ 

//#if 2979176 
removeTargetListener((TargetListener) lastPanel);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1708088415 
this.target = target;
//#endif 


//#if 1972657340 
if(target == null)//1
{ 

//#if -573709551 
add(blankPanel, BorderLayout.CENTER);
//#endif 


//#if 994702909 
validate();
//#endif 


//#if -704931178 
repaint();
//#endif 


//#if 189848917 
lastPanel = blankPanel;
//#endif 

} 
else
{ 

//#if -1437293288 
TabModelTarget newPanel = null;
//#endif 


//#if 1931929164 
newPanel = findPanelFor(target);
//#endif 


//#if 454395970 
if(newPanel != null)//1
{ 

//#if -761342154 
addTargetListener(newPanel);
//#endif 

} 

//#endif 


//#if -362450363 
if(newPanel instanceof JPanel)//1
{ 

//#if 948139554 
add((JPanel) newPanel, BorderLayout.CENTER);
//#endif 


//#if -1207904220 
lastPanel = (JPanel) newPanel;
//#endif 

} 
else
{ 

//#if -1759562573 
add(blankPanel, BorderLayout.CENTER);
//#endif 


//#if 1274143323 
validate();
//#endif 


//#if -1665748296 
repaint();
//#endif 


//#if -20005901 
lastPanel = blankPanel;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1774142267 
@Override
    public void setOrientation(Orientation orientation)
    { 

//#if 2096821608 
super.setOrientation(orientation);
//#endif 


//#if 1254054152 
Enumeration pps = panels.elements();
//#endif 


//#if -714980624 
while (pps.hasMoreElements()) //1
{ 

//#if -1065746705 
Object o = pps.nextElement();
//#endif 


//#if 539607789 
if(o instanceof Orientable)//1
{ 

//#if 1142096385 
Orientable orientable = (Orientable) o;
//#endif 


//#if -2103761685 
orientable.setOrientation(orientation);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1006331173 
public void addPanel(Class clazz, PropPanel panel)
    { 

//#if 617901116 
panels.put(clazz, panel);
//#endif 

} 

//#endif 


//#if -1696711592 
public void targetSet(TargetEvent targetEvent)
    { 

//#if -843003089 
setTarget(TargetManager.getInstance().getSingleTarget());
//#endif 


//#if -2017786812 
fireTargetSet(targetEvent);
//#endif 


//#if 1418999610 
validate();
//#endif 


//#if 1492473 
repaint();
//#endif 

} 

//#endif 


//#if -1534965286 
public boolean shouldBeEnabled(Object target)
    { 

//#if 1464473255 
if(target instanceof Fig)//1
{ 

//#if 749502267 
target = ((Fig) target).getOwner();
//#endif 

} 

//#endif 


//#if 2012980531 
return ((target instanceof Diagram || Model.getFacade().isAUMLElement(
                     target))


                || target instanceof Critic

                && findPanelFor(target) != null);
//#endif 

} 

//#endif 


//#if -1005049118 
public void refresh()
    { 

//#if -349739423 
setTarget(TargetManager.getInstance().getTarget());
//#endif 

} 

//#endif 


//#if -1785021790 
public TabProps()
    { 

//#if -1404576084 
this("tab.properties", "ui.PropPanel");
//#endif 

} 

//#endif 


//#if -2094413201 
public TabProps(String tabName, String panelClassBase)
    { 

//#if -1161368044 
super(tabName);
//#endif 


//#if -1008893736 
setIcon(new UpArrowIcon());
//#endif 


//#if 1642519287 
TargetManager.getInstance().addTargetListener(this);
//#endif 


//#if -1075261443 
setOrientation(Horizontal.getInstance());
//#endif 


//#if 586718266 
panelClassBaseName = panelClassBase;
//#endif 


//#if 2088793724 
setLayout(new BorderLayout());
//#endif 

} 

//#endif 


//#if 903167744 
private TabModelTarget findPanelFor(Object trgt)
    { 

//#if 1649875754 
TabModelTarget panel = panels.get(trgt.getClass());
//#endif 


//#if 2064003209 
if(panel != null)//1
{ 

//#if -199587125 
if(LOG.isDebugEnabled())//1
{ 

//#if 2005142196 
LOG.debug("Getting prop panel for: " + trgt.getClass().getName()
                          + ", " + "found (in cache?) " + panel);
//#endif 

} 

//#endif 


//#if -745044046 
return panel;
//#endif 

} 

//#endif 


//#if -1399327842 
panel = createPropPanel(trgt);
//#endif 


//#if 1967866248 
if(panel != null)//2
{ 

//#if 1418537748 
LOG.debug("Factory created " + panel.getClass().getName()
                      + " for " + trgt.getClass().getName());
//#endif 


//#if 1266749056 
panels.put(trgt.getClass(), panel);
//#endif 


//#if -2142232241 
return panel;
//#endif 

} 

//#endif 


//#if 936372446 
LOG.error("Failed to create a prop panel for : " + trgt);
//#endif 


//#if -657342913 
return null;
//#endif 

} 

//#endif 


//#if -969109663 
protected String getClassBaseName()
    { 

//#if -1461482524 
return panelClassBaseName;
//#endif 

} 

//#endif 


//#if -826393888 
private void fireTargetAdded(TargetEvent targetEvent)
    { 

//#if 56283997 
Object[] listeners = listenerList.getListenerList();
//#endif 


//#if 1016174565 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if 1655975182 
if(listeners[i] == TargetListener.class)//1
{ 

//#if 770564818 
((TargetListener) listeners[i + 1]).targetAdded(targetEvent);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1231168510 
private void fireTargetSet(TargetEvent targetEvent)
    { 

//#if -157669914 
Object[] listeners = listenerList.getListenerList();
//#endif 


//#if 1598849902 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if 800001972 
if(listeners[i] == TargetListener.class)//1
{ 

//#if 81635757 
((TargetListener) listeners[i + 1]).targetSet(targetEvent);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1432828588 
private TabModelTarget createPropPanel(Object targetObject)
    { 

//#if -2014287506 
TabModelTarget propPanel = null;
//#endif 


//#if -2114177086 
for (PropPanelFactory factory
                : PropPanelFactoryManager.getFactories()) //1
{ 

//#if 382053727 
propPanel = factory.createPropPanel(targetObject);
//#endif 


//#if 2024694203 
if(propPanel != null)//1
{ 

//#if -1566136525 
return propPanel;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1318565545 
if(targetObject instanceof FigText)//1
{ 

//#if 739704152 
propPanel = new PropPanelString();
//#endif 

} 

//#endif 


//#if 698235598 
if(propPanel instanceof Orientable)//1
{ 

//#if 820811710 
((Orientable) propPanel).setOrientation(getOrientation());
//#endif 

} 

//#endif 


//#if 1922143970 
if(propPanel instanceof PropPanel)//1
{ 

//#if 1537260969 
((PropPanel) propPanel).setOrientation(getOrientation());
//#endif 

} 

//#endif 


//#if -667097361 
return propPanel;
//#endif 

} 

//#endif 


//#if 361821824 
private void fireTargetRemoved(TargetEvent targetEvent)
    { 

//#if 807988793 
Object[] listeners = listenerList.getListenerList();
//#endif 


//#if -1415164223 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if 54807086 
if(listeners[i] == TargetListener.class)//1
{ 

//#if -1391950764 
((TargetListener) listeners[i + 1]).targetRemoved(targetEvent);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

