package org.argouml.uml.ui;
import java.awt.BorderLayout;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;
import org.apache.log4j.Logger;
import org.argouml.application.api.AbstractArgoJPanel;
import org.argouml.cognitive.Critic;
import org.argouml.model.Model;
import org.argouml.swingext.UpArrowIcon;
import org.argouml.ui.TabModelTarget;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.ui.targetmanager.TargetListener;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.ui.PropPanelString;
import org.tigris.gef.base.Diagram;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigText;
import org.tigris.swidgets.Horizontal;
import org.tigris.swidgets.Orientable;
import org.tigris.swidgets.Orientation;
public class TabProps extends AbstractArgoJPanel
 implements TabModelTarget
  { 
private static final Logger LOG = Logger.getLogger(TabProps.class);
private JPanel blankPanel = new JPanel();
private Hashtable<Class, TabModelTarget> panels =
        new Hashtable<Class, TabModelTarget>();
private JPanel lastPanel;
private String panelClassBaseName = "";
private Object target;
private EventListenerList listenerList = new EventListenerList();
public void targetRemoved(TargetEvent targetEvent)
    { 
setTarget(TargetManager.getInstance().getSingleTarget());
fireTargetRemoved(targetEvent);
validate();
repaint();
} 
private void addTargetListener(TargetListener listener)
    { 
listenerList.add(TargetListener.class, listener);
} 
private void removeTargetListener(TargetListener listener)
    { 
listenerList.remove(TargetListener.class, listener);
} 
public void targetAdded(TargetEvent targetEvent)
    { 
setTarget(TargetManager.getInstance().getSingleTarget());
fireTargetAdded(targetEvent);
if(listenerList.getListenerCount() > 0)//1
{ 
validate();
repaint();
} 
} 
@Deprecated
    public Object getTarget()
    { 
return target;
} 
@Deprecated
    public void setTarget(Object target)
    { 
LOG.info("setTarget: there are "
                 + TargetManager.getInstance().getTargets().size()
                 + " targets");
target = (target instanceof Fig) ? ((Fig) target).getOwner() : target;
if(!(target == null || Model.getFacade().isAUMLElement(target)
                || target instanceof ArgoDiagram


                // TODO Improve extensibility of this!
                || target instanceof Critic

             ))//1
{ 
target = null;
} 
if(lastPanel != null)//1
{ 
remove(lastPanel);
if(lastPanel instanceof TargetListener)//1
{ 
removeTargetListener((TargetListener) lastPanel);
} 
} 
this.target = target;
if(target == null)//1
{ 
add(blankPanel, BorderLayout.CENTER);
validate();
repaint();
lastPanel = blankPanel;
} 
else
{ 
TabModelTarget newPanel = null;
newPanel = findPanelFor(target);
if(newPanel != null)//1
{ 
addTargetListener(newPanel);
} 
if(newPanel instanceof JPanel)//1
{ 
add((JPanel) newPanel, BorderLayout.CENTER);
lastPanel = (JPanel) newPanel;
} 
else
{ 
add(blankPanel, BorderLayout.CENTER);
validate();
repaint();
lastPanel = blankPanel;
} 
} 
} 
@Override
    public void setOrientation(Orientation orientation)
    { 
super.setOrientation(orientation);
Enumeration pps = panels.elements();
while (pps.hasMoreElements()) //1
{ 
Object o = pps.nextElement();
if(o instanceof Orientable)//1
{ 
Orientable orientable = (Orientable) o;
orientable.setOrientation(orientation);
} 
} 
} 
public void addPanel(Class clazz, PropPanel panel)
    { 
panels.put(clazz, panel);
} 
public void targetSet(TargetEvent targetEvent)
    { 
setTarget(TargetManager.getInstance().getSingleTarget());
fireTargetSet(targetEvent);
validate();
repaint();
} 
public boolean shouldBeEnabled(Object target)
    { 
if(target instanceof Fig)//1
{ 
target = ((Fig) target).getOwner();
} 
return ((target instanceof Diagram || Model.getFacade().isAUMLElement(
                     target))


                || target instanceof Critic

                && findPanelFor(target) != null);
} 
public void refresh()
    { 
setTarget(TargetManager.getInstance().getTarget());
} 
public TabProps()
    { 
this("tab.properties", "ui.PropPanel");
} 
public TabProps(String tabName, String panelClassBase)
    { 
super(tabName);
setIcon(new UpArrowIcon());
TargetManager.getInstance().addTargetListener(this);
setOrientation(Horizontal.getInstance());
panelClassBaseName = panelClassBase;
setLayout(new BorderLayout());
} 
private TabModelTarget findPanelFor(Object trgt)
    { 
TabModelTarget panel = panels.get(trgt.getClass());
if(panel != null)//1
{ 
if(LOG.isDebugEnabled())//1
{ 
LOG.debug("Getting prop panel for: " + trgt.getClass().getName()
                          + ", " + "found (in cache?) " + panel);
} 
return panel;
} 
panel = createPropPanel(trgt);
if(panel != null)//2
{ 
LOG.debug("Factory created " + panel.getClass().getName()
                      + " for " + trgt.getClass().getName());
panels.put(trgt.getClass(), panel);
return panel;
} 
LOG.error("Failed to create a prop panel for : " + trgt);
return null;
} 
protected String getClassBaseName()
    { 
return panelClassBaseName;
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
private TabModelTarget createPropPanel(Object targetObject)
    { 
TabModelTarget propPanel = null;
for (PropPanelFactory factory
                : PropPanelFactoryManager.getFactories()) //1
{ 
propPanel = factory.createPropPanel(targetObject);
if(propPanel != null)//1
{ 
return propPanel;
} 
} 
if(targetObject instanceof FigText)//1
{ 
propPanel = new PropPanelString();
} 
if(propPanel instanceof Orientable)//1
{ 
((Orientable) propPanel).setOrientation(getOrientation());
} 
if(propPanel instanceof PropPanel)//1
{ 
((PropPanel) propPanel).setOrientation(getOrientation());
} 
return propPanel;
} 
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

 } 
