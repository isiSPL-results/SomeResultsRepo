// Compilation Unit of /PropPanel.java 
 
package org.argouml.uml.ui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.event.EventListenerList;
import org.apache.log4j.Logger;
import org.argouml.application.api.AbstractArgoJPanel;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.kernel.ProfileConfiguration;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.ui.ActionCreateContainedModelElement;
import org.argouml.ui.LookAndFeelMgr;
import org.argouml.ui.TabModelTarget;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.ui.targetmanager.TargetListener;
import org.argouml.ui.targetmanager.TargettableModelView;
import org.tigris.gef.presentation.Fig;
import org.tigris.swidgets.GridLayout2;
import org.tigris.swidgets.Orientation;
import org.tigris.toolbar.ToolBarFactory;
public abstract class PropPanel extends AbstractArgoJPanel
 implements TabModelTarget
, UMLUserInterfaceContainer
, ComponentListener
  { 
private static final Logger LOG = Logger.getLogger(PropPanel.class);
private Object target;
private Object modelElement;
private EventListenerList listenerList;
private JPanel buttonPanel = new JPanel(new GridLayout());
private JLabel titleLabel;
private List actions = new ArrayList();
private static Font stdFont =
        LookAndFeelMgr.getInstance().getStandardFont();
private Collection<TargetListener> collectTargetListenerActions()
    { 
Collection<TargetListener> set = new HashSet<TargetListener>();
for (Object obj : actions) //1
{ 
if(obj instanceof TargetListener)//1
{ 
set.add((TargetListener) obj);
} 

} 

return set;
} 

public void buildToolbar()
    { 
LOG.debug("Building toolbar");
ToolBarFactory factory = new ToolBarFactory(getActions());
factory.setRollover(true);
factory.setFloatable(false);
JToolBar toolBar = factory.createToolBar();
toolBar.setName("misc.toolbar.properties");
buttonPanel.removeAll();
buttonPanel.add(BorderLayout.WEST, toolBar);
buttonPanel.putClientProperty("ToolBar.toolTipSelectTool",
                                      Translator.localize("action.select"));
} 

public JLabel addFieldBefore(String label, Component component,
                                 Component beforeComponent)
    { 
int nComponent = getComponentCount();
for (int i = 0; i < nComponent; ++i) //1
{ 
if(getComponent(i) == beforeComponent)//1
{ 
JLabel jlabel = createLabelFor(label, component);
component.setFont(stdFont);
add(jlabel, i - 1);
add(component, i++);
return jlabel;
} 

} 

throw new IllegalArgumentException("Component not found");
} 

private void fireTargetRemoved(TargetEvent targetEvent)
    { 
if(listenerList == null)//1
{ 
listenerList = collectTargetListeners(this);
} 

Object[] listeners = listenerList.getListenerList();
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 
if(listeners[i] == TargetListener.class)//1
{ 
((TargetListener) listeners[i + 1]).targetRemoved(targetEvent);
} 

} 

} 

protected void setButtonPanelSize(int height)
    { 
buttonPanel.setMinimumSize(new Dimension(0, height));
buttonPanel.setPreferredSize(new Dimension(0, height));
} 

private EventListenerList collectTargetListeners(Container container)
    { 
Component[] components = container.getComponents();
EventListenerList list = new EventListenerList();
for (int i = 0; i < components.length; i++) //1
{ 
if(components[i] instanceof TargetListener)//1
{ 
list.add(TargetListener.class, (TargetListener) components[i]);
} 

if(components[i] instanceof TargettableModelView)//1
{ 
list.add(TargetListener.class,
                         ((TargettableModelView) components[i])
                         .getTargettableModel());
} 

if(components[i] instanceof Container)//1
{ 
EventListenerList list2 = collectTargetListeners(
                                              (Container) components[i]);
Object[] objects = list2.getListenerList();
for (int j = 1; j < objects.length; j += 2) //1
{ 
list.add(TargetListener.class, (TargetListener) objects[j]);
} 

} 

} 

if(container instanceof PropPanel)//1
{ 
for (TargetListener action : collectTargetListenerActions()) //1
{ 
list.add(TargetListener.class, action);
} 

} 

return list;
} 

protected void setTitleLabel(JLabel theTitleLabel)
    { 
titleLabel = theTitleLabel;
titleLabel.setFont(stdFont);
} 

public void componentResized(ComponentEvent e)
    { 
} 

protected Object getDisplayNamespace()
    { 
Object ns = null;
Object theTarget = getTarget();
if(Model.getFacade().isAModelElement(theTarget))//1
{ 
ns = Model.getFacade().getNamespace(theTarget);
} 

return ns;
} 

public final Object getTarget()
    { 
return target;
} 

protected JLabel getTitleLabel()
    { 
return titleLabel;
} 

protected List getActions()
    { 
return actions;
} 

protected void addAction(Action action, String tooltip)
    { 
JButton button = new TargettableButton(action);
if(tooltip != null)//1
{ 
button.setToolTipText(tooltip);
} 

button.setText("");
button.setFocusable(false);
actions.add(button);
} 

public String formatElement(Object element)
    { 
return getProfile().getFormatingStrategy().formatElement(element,
                getDisplayNamespace());
} 

public JLabel addField(String label, Component component)
    { 
JLabel jlabel = createLabelFor(label, component);
component.setFont(stdFont);
add(jlabel);
add(component);
if(component instanceof UMLLinkedList)//1
{ 
UMLModelElementListModel2 list =
                (UMLModelElementListModel2) ((UMLLinkedList) component).getModel();
ActionCreateContainedModelElement newAction =
                new ActionCreateContainedModelElement(
                list.getMetaType(),
                list.getTarget(),
                "New...");
} 

return jlabel;
} 

public void targetRemoved(TargetEvent e)
    { 
setTarget(e.getNewTarget());
if(isVisible())//1
{ 
fireTargetRemoved(e);
} 

} 

protected final Action getDeleteAction()
    { 
return ActionDeleteModelElements.getTargetFollower();
} 

public final Object getModelElement()
    { 
return modelElement;
} 

public void targetSet(TargetEvent e)
    { 
setTarget(e.getNewTarget());
if(isVisible())//1
{ 
fireTargetSet(e);
} 

} 

public void componentShown(ComponentEvent e)
    { 
fireTargetSet(new TargetEvent(
                          this, TargetEvent.TARGET_SET, null, new Object[] {target}));
} 

public String formatNamespace(Object namespace)
    { 
return getProfile().getFormatingStrategy().formatElement(namespace,
                null);
} 

public JLabel addFieldAfter(String label, Component component,
                                Component afterComponent)
    { 
int nComponent = getComponentCount();
for (int i = 0; i < nComponent; ++i) //1
{ 
if(getComponent(i) == afterComponent)//1
{ 
JLabel jlabel = createLabelFor(label, component);
component.setFont(stdFont);
add(jlabel, ++i);
add(component, ++i);
return jlabel;
} 

} 

throw new IllegalArgumentException("Component not found");
} 

protected UMLSingleRowSelector getSingleRowScroll(ListModel model)
    { 
UMLSingleRowSelector pane = new UMLSingleRowSelector(model);
return pane;
} 

protected void addAction(Action action)
    { 
actions.add(action);
} 

public void refresh()
    { 
SwingUtilities.invokeLater(new UMLChangeDispatch(this, 0));
} 

@Override
    public void setOrientation(Orientation orientation)
    { 
super.setOrientation(orientation);
} 

public boolean shouldBeEnabled(Object t)
    { 
t = (t instanceof Fig) ? ((Fig) t).getOwner() : t;
return Model.getFacade().isAUMLElement(t);
} 

public PropPanel(String label, ImageIcon icon)
    { 
super(Translator.localize(label));
LabelledLayout layout = new LabelledLayout();
layout.setHgap(5);
setLayout(layout);
if(icon != null)//1
{ 
setTitleLabel(new JLabel(Translator.localize(label), icon,
                                     SwingConstants.LEFT));
} 
else
{ 
setTitleLabel(new JLabel(Translator.localize(label)));
} 

titleLabel.setLabelFor(buttonPanel);
add(titleLabel);
add(buttonPanel);
addComponentListener(this);
} 

protected final JPanel createBorderPanel(String title)
    { 
return new GroupPanel(Translator.localize(title));
} 

private void fireTargetSet(TargetEvent targetEvent)
    { 
if(listenerList == null)//1
{ 
listenerList = collectTargetListeners(this);
} 

Object[] listeners = listenerList.getListenerList();
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 
if(listeners[i] == TargetListener.class)//1
{ 
((TargetListener) listeners[i + 1]).targetSet(targetEvent);
} 

} 

} 

protected static ImageIcon lookupIcon(String name)
    { 
return ResourceLoaderWrapper.lookupIconResource(name);
} 

private JLabel createLabelFor(String label, Component comp)
    { 
JLabel jlabel = new JLabel(Translator.localize(label));
jlabel.setToolTipText(Translator.localize(label));
jlabel.setFont(stdFont);
jlabel.setLabelFor(comp);
return jlabel;
} 

public String formatCollection(Iterator iter)
    { 
Object namespace = getDisplayNamespace();
return getProfile().getFormatingStrategy().formatCollection(iter,
                namespace);
} 

public boolean isRemovableElement()
    { 
return ((getTarget() != null) && (getTarget() != (ProjectManager
                                          .getManager().getCurrentProject().getModel())));
} 

public void componentHidden(ComponentEvent e)
    { 
} 

public void targetAdded(TargetEvent e)
    { 
if(listenerList == null)//1
{ 
listenerList = collectTargetListeners(this);
} 

setTarget(e.getNewTarget());
if(isVisible())//1
{ 
fireTargetAdded(e);
} 

} 

protected final void addSeparator()
    { 
add(LabelledLayout.getSeparator());
} 

protected void addAction(Object[] actionArray)
    { 
actions.add(actionArray);
} 

public void componentMoved(ComponentEvent e)
    { 
} 

public void setTarget(Object t)
    { 
LOG.debug("setTarget called with " + t + " as parameter (not target!)");
t = (t instanceof Fig) ? ((Fig) t).getOwner() : t;
Runnable dispatch = null;
if(t != target)//1
{ 
target = t;
modelElement = null;
if(listenerList == null)//1
{ 
listenerList = collectTargetListeners(this);
} 

if(Model.getFacade().isAUMLElement(target))//1
{ 
modelElement = target;
} 

dispatch = new UMLChangeDispatch(this,
                                             UMLChangeDispatch.TARGET_CHANGED_ADD);
buildToolbar();
} 
else
{ 
dispatch = new UMLChangeDispatch(this,
                                             UMLChangeDispatch.TARGET_REASSERTED);
} 

SwingUtilities.invokeLater(dispatch);
if(titleLabel != null)//1
{ 
Icon icon = null;
if(t != null)//1
{ 
icon = ResourceLoaderWrapper.getInstance().lookupIcon(t);
} 

if(icon != null)//1
{ 
titleLabel.setIcon(icon);
} 

} 

} 

public ProfileConfiguration getProfile()
    { 
return ProjectManager.getManager().getCurrentProject()
               .getProfileConfiguration();
} 

private void fireTargetAdded(TargetEvent targetEvent)
    { 
if(listenerList == null)//1
{ 
listenerList = collectTargetListeners(this);
} 

Object[] listeners = listenerList.getListenerList();
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 
if(listeners[i] == TargetListener.class)//1
{ 
((TargetListener) listeners[i + 1]).targetAdded(targetEvent);
} 

} 

} 

private static class TargettableButton extends JButton
 implements TargettableModelView
  { 
public TargettableButton(Action action)
        { 
super(action);
} 

public TargetListener getTargettableModel()
        { 
if(getAction() instanceof TargetListener)//1
{ 
return (TargetListener) getAction();
} 

return null;
} 

 } 

private class GroupPanel extends JPanel
  { 
public GroupPanel(String title)
        { 
super(new GridLayout2());
TitledBorder border = new TitledBorder(Translator.localize(title));
border.setTitleFont(stdFont);
setBorder(border);
} 

public void setEnabled(boolean enabled)
        { 
super.setEnabled(enabled);
for (final Component component : getComponents()) //1
{ 
component.setEnabled(enabled);
} 

} 

 } 

 } 


