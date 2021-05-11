package org.argouml.uml.ui;
import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.Hashtable;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.EventListenerList;
import org.apache.log4j.Logger;
import org.argouml.application.api.AbstractArgoJPanel;
import org.argouml.kernel.DelayedChangeNotify;
import org.argouml.kernel.DelayedVChangeListener;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.swingext.UpArrowIcon;
import org.argouml.ui.StylePanel;
import org.argouml.ui.TabFigTarget;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.ui.targetmanager.TargetListener;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramUtils;
import org.argouml.uml.diagram.ui.FigAssociationClass;
import org.argouml.uml.diagram.ui.FigClassAssociationClass;
import org.argouml.uml.util.namespace.Namespace;
import org.argouml.uml.util.namespace.StringNamespace;
import org.argouml.uml.util.namespace.StringNamespaceElement;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigEdge;
public class TabStyle extends AbstractArgoJPanel
 implements TabFigTarget
,PropertyChangeListener
,DelayedVChangeListener
  { 
private static final Logger LOG = Logger.getLogger(TabStyle.class);
private Fig target;
private boolean shouldBeEnabled = false;
private JPanel blankPanel = new JPanel();
private Hashtable<Class, TabFigTarget> panels =
        new Hashtable<Class, TabFigTarget>();
private JPanel lastPanel = null;
private StylePanel stylePanel = null;
private String[] stylePanelNames;
private EventListenerList listenerList = new EventListenerList();
public void delayedVetoableChange(PropertyChangeEvent pce)
    { 
if(stylePanel != null)//1
{ 
stylePanel.refresh(pce);
} 
} 
protected String[] getStylePanelNames()
    { 
return stylePanelNames;
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
public StylePanel findPanelFor(Class targetClass)
    { 
Class panelClass = null;
TabFigTarget p = panels.get(targetClass);
if(p == null)//1
{ 
Class newClass = targetClass;
while (newClass != null && panelClass == null) //1
{ 
panelClass = panelClassFor(newClass);
newClass = newClass.getSuperclass();
} 
if(panelClass == null)//1
{ 
return null;
} 
try//1
{ 
p = (TabFigTarget) panelClass.newInstance();
} 
catch (IllegalAccessException ignore) //1
{ 
LOG.error(ignore);
return null;
} 
catch (InstantiationException ignore) //1
{ 
LOG.error(ignore);
return null;
} 
panels.put(targetClass, p);
} 
LOG.debug("found style for " + targetClass.getName() + "("
                  + p.getClass() + ")");
return (StylePanel) p;
} 
private void addTargetListener(TargetListener listener)
    { 
listenerList.add(TargetListener.class, listener);
} 
public void propertyChange(PropertyChangeEvent pce)
    { 
DelayedChangeNotify delayedNotify = new DelayedChangeNotify(this, pce);
SwingUtilities.invokeLater(delayedNotify);
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
public Class panelClassFor(Class targetClass)
    { 
if(targetClass == null)//1
{ 
return null;
} 
StringNamespace classNs = (StringNamespace) StringNamespace
                                  .parse(targetClass);
StringNamespace baseNs = (StringNamespace) StringNamespace.parse(
                                     "org.argouml.ui.", Namespace.JAVA_NS_TOKEN);
StringNamespaceElement targetClassElement =
            (StringNamespaceElement) classNs.peekNamespaceElement();
LOG.debug("Attempt to find style panel for: " + classNs);
classNs.popNamespaceElement();
String[] bases = new String[] {
            classNs.toString(), baseNs.toString()
        };
for (String stylePanelName : stylePanelNames) //1
{ 
for (String baseName : bases) //1
{ 
String name = baseName + "." + stylePanelName
                              + targetClassElement;
Class cls = loadClass(name);
if(cls != null)//1
{ 
return cls;
} 
} 
} 
return null;
} 
public void addPanel(Class c, StylePanel s)
    { 
panels.put(c, s);
} 
public void targetSet(TargetEvent e)
    { 
setTarget(e.getNewTarget());
fireTargetSet(e);
} 
public TabStyle()
    { 
this("tab.style", new String[] {"StylePanel", "SP"});
} 
public void setTarget(Object t)
    { 
if(target != null)//1
{ 
target.removePropertyChangeListener(this);
if(target instanceof FigEdge)//1
{ 
((FigEdge) target).getFig().removePropertyChangeListener(this);
} 
if(target instanceof FigAssociationClass)//1
{ 
FigClassAssociationClass ac =
                    ((FigAssociationClass) target).getAssociationClass();
if(ac != null)//1
{ 
ac.removePropertyChangeListener(this);
} 
} 
} 
if(!(t instanceof Fig))//1
{ 
if(Model.getFacade().isAModelElement(t))//1
{ 
ArgoDiagram diagram = DiagramUtils.getActiveDiagram();
if(diagram != null)//1
{ 
t = diagram.presentationFor(t);
} 
if(!(t instanceof Fig))//1
{ 
Project p = ProjectManager.getManager().getCurrentProject();
Collection col = p.findFigsForMember(t);
if(col == null || col.isEmpty())//1
{ 
return;
} 
t = col.iterator().next();
} 
if(!(t instanceof Fig))//2
{ 
return;
} 
} 
else
{ 
return;
} 
} 
target = (Fig) t;
if(target != null)//2
{ 
target.addPropertyChangeListener(this);
if(target instanceof FigEdge)//1
{ 
((FigEdge) target).getFig().addPropertyChangeListener(this);
} 
if(target instanceof FigAssociationClass)//1
{ 
FigClassAssociationClass ac =
                    ((FigAssociationClass) target).getAssociationClass();
if(ac != null)//1
{ 
ac.addPropertyChangeListener(this);
} 
} 
} 
if(lastPanel != null)//1
{ 
remove(lastPanel);
if(lastPanel instanceof TargetListener)//1
{ 
removeTargetListener((TargetListener) lastPanel);
} 
} 
if(t == null)//1
{ 
add(blankPanel, BorderLayout.NORTH);
shouldBeEnabled = false;
lastPanel = blankPanel;
return;
} 
shouldBeEnabled = true;
stylePanel = null;
Class targetClass = t.getClass();
stylePanel = findPanelFor(targetClass);
if(stylePanel != null)//1
{ 
removeTargetListener(stylePanel);
addTargetListener(stylePanel);
stylePanel.setTarget(target);
add(stylePanel, BorderLayout.NORTH);
shouldBeEnabled = true;
lastPanel = stylePanel;
} 
else
{ 
add(blankPanel, BorderLayout.NORTH);
shouldBeEnabled = false;
lastPanel = blankPanel;
} 
validate();
repaint();
} 
private Class loadClass(String name)
    { 
try//1
{ 
Class cls = Class.forName(name);
return cls;
} 
catch (ClassNotFoundException ignore) //1
{ 
LOG.debug("ClassNotFoundException. Could not find class:"
                      + name);
} 
return null;
} 
private void removeTargetListener(TargetListener listener)
    { 
listenerList.remove(TargetListener.class, listener);
} 
public TabStyle(String tabName, String[] spn)
    { 
super(tabName);
this.stylePanelNames = spn;
setIcon(new UpArrowIcon());
setLayout(new BorderLayout());
} 
public void targetRemoved(TargetEvent e)
    { 
setTarget(e.getNewTarget());
fireTargetRemoved(e);
} 
public void refresh()
    { 
setTarget(target);
} 
public boolean shouldBeEnabled(Object targetItem)
    { 
if(!(targetItem instanceof Fig))//1
{ 
if(Model.getFacade().isAModelElement(targetItem))//1
{ 
ArgoDiagram diagram = DiagramUtils.getActiveDiagram();
if(diagram == null)//1
{ 
shouldBeEnabled = false;
return false;
} 
Fig f = diagram.presentationFor(targetItem);
if(f == null)//1
{ 
shouldBeEnabled = false;
return false;
} 
targetItem = f;
} 
else
{ 
shouldBeEnabled = false;
return false;
} 
} 
shouldBeEnabled = true;
Class targetClass = targetItem.getClass();
stylePanel = findPanelFor(targetClass);
targetClass = targetClass.getSuperclass();
if(stylePanel == null)//1
{ 
shouldBeEnabled = false;
} 
return shouldBeEnabled;
} 
public Object getTarget()
    { 
return target;
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
public void targetAdded(TargetEvent e)
    { 
setTarget(e.getNewTarget());
fireTargetAdded(e);
} 

 } 
