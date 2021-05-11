
//#if 1554270323 
// Compilation Unit of /PropPanel.java 
 

//#if 1195800374 
package org.argouml.uml.ui;
//#endif 


//#if -1137158822 
import java.awt.BorderLayout;
//#endif 


//#if -286086615 
import java.awt.Component;
//#endif 


//#if 306604837 
import java.awt.Container;
//#endif 


//#if 575694560 
import java.awt.Dimension;
//#endif 


//#if -60509279 
import java.awt.Font;
//#endif 


//#if -1616699840 
import java.awt.GridLayout;
//#endif 


//#if 894937279 
import java.awt.event.ComponentEvent;
//#endif 


//#if 965186921 
import java.awt.event.ComponentListener;
//#endif 


//#if -1304339659 
import java.util.ArrayList;
//#endif 


//#if -440225588 
import java.util.Collection;
//#endif 


//#if -196046536 
import java.util.HashSet;
//#endif 


//#if 218210492 
import java.util.Iterator;
//#endif 


//#if 391310860 
import java.util.List;
//#endif 


//#if -1571941044 
import javax.swing.Action;
//#endif 


//#if -1916037847 
import javax.swing.Icon;
//#endif 


//#if -686855072 
import javax.swing.ImageIcon;
//#endif 


//#if 2130948056 
import javax.swing.JButton;
//#endif 


//#if 1444389208 
import javax.swing.JLabel;
//#endif 


//#if 1559263304 
import javax.swing.JPanel;
//#endif 


//#if 1758755217 
import javax.swing.JToolBar;
//#endif 


//#if 964930185 
import javax.swing.ListModel;
//#endif 


//#if -1821907983 
import javax.swing.SwingConstants;
//#endif 


//#if 444233110 
import javax.swing.SwingUtilities;
//#endif 


//#if 978808634 
import javax.swing.border.TitledBorder;
//#endif 


//#if 1652827324 
import javax.swing.event.EventListenerList;
//#endif 


//#if 538343474 
import org.apache.log4j.Logger;
//#endif 


//#if 458646502 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if -1245064354 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 441405791 
import org.argouml.i18n.Translator;
//#endif 


//#if 2035139563 
import org.argouml.kernel.ProfileConfiguration;
//#endif 


//#if -1293437436 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1909087323 
import org.argouml.model.Model;
//#endif 


//#if 1030371667 
import org.argouml.ui.ActionCreateContainedModelElement;
//#endif 


//#if 770672565 
import org.argouml.ui.LookAndFeelMgr;
//#endif 


//#if 1264512650 
import org.argouml.ui.TabModelTarget;
//#endif 


//#if 752630800 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if 645592184 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if 274464972 
import org.argouml.ui.targetmanager.TargettableModelView;
//#endif 


//#if 1691117724 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1441926370 
import org.tigris.swidgets.GridLayout2;
//#endif 


//#if -1206998796 
import org.tigris.swidgets.Orientation;
//#endif 


//#if 267638064 
import org.tigris.toolbar.ToolBarFactory;
//#endif 


//#if -1447177504 
public abstract class PropPanel extends 
//#if 830582512 
AbstractArgoJPanel
//#endif 

 implements 
//#if -2104780800 
TabModelTarget
//#endif 

, 
//#if -1700453172 
UMLUserInterfaceContainer
//#endif 

, 
//#if -588725706 
ComponentListener
//#endif 

  { 

//#if 2085015334 
private static final Logger LOG = Logger.getLogger(PropPanel.class);
//#endif 


//#if 515337283 
private Object target;
//#endif 


//#if -1712892991 
private Object modelElement;
//#endif 


//#if 959211205 
private EventListenerList listenerList;
//#endif 


//#if -1574429496 
private JPanel buttonPanel = new JPanel(new GridLayout());
//#endif 


//#if 1281225965 
private JLabel titleLabel;
//#endif 


//#if -1200795779 
private List actions = new ArrayList();
//#endif 


//#if 981830366 
private static Font stdFont =
        LookAndFeelMgr.getInstance().getStandardFont();
//#endif 


//#if -548666190 
private Collection<TargetListener> collectTargetListenerActions()
    { 

//#if -273873643 
Collection<TargetListener> set = new HashSet<TargetListener>();
//#endif 


//#if -546833146 
for (Object obj : actions) //1
{ 

//#if 639952807 
if(obj instanceof TargetListener)//1
{ 

//#if 2056544358 
set.add((TargetListener) obj);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -723610073 
return set;
//#endif 

} 

//#endif 


//#if 1084768902 
public void buildToolbar()
    { 

//#if 1440395013 
LOG.debug("Building toolbar");
//#endif 


//#if -1212833728 
ToolBarFactory factory = new ToolBarFactory(getActions());
//#endif 


//#if 1338210692 
factory.setRollover(true);
//#endif 


//#if -926030608 
factory.setFloatable(false);
//#endif 


//#if 195120317 
JToolBar toolBar = factory.createToolBar();
//#endif 


//#if -1515386891 
toolBar.setName("misc.toolbar.properties");
//#endif 


//#if -689375644 
buttonPanel.removeAll();
//#endif 


//#if -799981990 
buttonPanel.add(BorderLayout.WEST, toolBar);
//#endif 


//#if -1559577854 
buttonPanel.putClientProperty("ToolBar.toolTipSelectTool",
                                      Translator.localize("action.select"));
//#endif 

} 

//#endif 


//#if 2023551015 
public JLabel addFieldBefore(String label, Component component,
                                 Component beforeComponent)
    { 

//#if -1384794729 
int nComponent = getComponentCount();
//#endif 


//#if 1995086593 
for (int i = 0; i < nComponent; ++i) //1
{ 

//#if -892424386 
if(getComponent(i) == beforeComponent)//1
{ 

//#if 206070249 
JLabel jlabel = createLabelFor(label, component);
//#endif 


//#if -109078884 
component.setFont(stdFont);
//#endif 


//#if 1858504548 
add(jlabel, i - 1);
//#endif 


//#if 1181763237 
add(component, i++);
//#endif 


//#if 1199363489 
return jlabel;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1150209314 
throw new IllegalArgumentException("Component not found");
//#endif 

} 

//#endif 


//#if -721445090 
private void fireTargetRemoved(TargetEvent targetEvent)
    { 

//#if 1590281347 
if(listenerList == null)//1
{ 

//#if 1799888026 
listenerList = collectTargetListeners(this);
//#endif 

} 

//#endif 


//#if 1753068518 
Object[] listeners = listenerList.getListenerList();
//#endif 


//#if -1130491538 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if 1123575780 
if(listeners[i] == TargetListener.class)//1
{ 

//#if 1809855271 
((TargetListener) listeners[i + 1]).targetRemoved(targetEvent);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -163071645 
protected void setButtonPanelSize(int height)
    { 

//#if -1888248562 
buttonPanel.setMinimumSize(new Dimension(0, height));
//#endif 


//#if -1876275781 
buttonPanel.setPreferredSize(new Dimension(0, height));
//#endif 

} 

//#endif 


//#if 199148201 
private EventListenerList collectTargetListeners(Container container)
    { 

//#if -2119641458 
Component[] components = container.getComponents();
//#endif 


//#if -537561936 
EventListenerList list = new EventListenerList();
//#endif 


//#if 595060957 
for (int i = 0; i < components.length; i++) //1
{ 

//#if 562476918 
if(components[i] instanceof TargetListener)//1
{ 

//#if -1338904898 
list.add(TargetListener.class, (TargetListener) components[i]);
//#endif 

} 

//#endif 


//#if -618236318 
if(components[i] instanceof TargettableModelView)//1
{ 

//#if -1816634486 
list.add(TargetListener.class,
                         ((TargettableModelView) components[i])
                         .getTargettableModel());
//#endif 

} 

//#endif 


//#if 331373792 
if(components[i] instanceof Container)//1
{ 

//#if 1433478769 
EventListenerList list2 = collectTargetListeners(
                                              (Container) components[i]);
//#endif 


//#if -914363139 
Object[] objects = list2.getListenerList();
//#endif 


//#if -673381791 
for (int j = 1; j < objects.length; j += 2) //1
{ 

//#if 1828220396 
list.add(TargetListener.class, (TargetListener) objects[j]);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1697844644 
if(container instanceof PropPanel)//1
{ 

//#if 993009549 
for (TargetListener action : collectTargetListenerActions()) //1
{ 

//#if 1442281220 
list.add(TargetListener.class, action);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -31718174 
return list;
//#endif 

} 

//#endif 


//#if -882123721 
protected void setTitleLabel(JLabel theTitleLabel)
    { 

//#if -614470266 
titleLabel = theTitleLabel;
//#endif 


//#if -1411192860 
titleLabel.setFont(stdFont);
//#endif 

} 

//#endif 


//#if 695765086 
public void componentResized(ComponentEvent e)
    { 
} 

//#endif 


//#if -266226850 
protected Object getDisplayNamespace()
    { 

//#if -1511966728 
Object ns = null;
//#endif 


//#if 1045609354 
Object theTarget = getTarget();
//#endif 


//#if 1160977437 
if(Model.getFacade().isAModelElement(theTarget))//1
{ 

//#if -182011993 
ns = Model.getFacade().getNamespace(theTarget);
//#endif 

} 

//#endif 


//#if -929973847 
return ns;
//#endif 

} 

//#endif 


//#if 1726638935 
public final Object getTarget()
    { 

//#if -81301256 
return target;
//#endif 

} 

//#endif 


//#if -1833216618 
protected JLabel getTitleLabel()
    { 

//#if -1323726783 
return titleLabel;
//#endif 

} 

//#endif 


//#if -1103958023 
protected List getActions()
    { 

//#if -1038791354 
return actions;
//#endif 

} 

//#endif 


//#if 735371263 
protected void addAction(Action action, String tooltip)
    { 

//#if -459736791 
JButton button = new TargettableButton(action);
//#endif 


//#if 2054666860 
if(tooltip != null)//1
{ 

//#if 313202492 
button.setToolTipText(tooltip);
//#endif 

} 

//#endif 


//#if 414097598 
button.setText("");
//#endif 


//#if 2138184656 
button.setFocusable(false);
//#endif 


//#if 281928581 
actions.add(button);
//#endif 

} 

//#endif 


//#if -1834461372 
public String formatElement(Object element)
    { 

//#if 664873589 
return getProfile().getFormatingStrategy().formatElement(element,
                getDisplayNamespace());
//#endif 

} 

//#endif 


//#if -726504673 
public JLabel addField(String label, Component component)
    { 

//#if 1836586816 
JLabel jlabel = createLabelFor(label, component);
//#endif 


//#if -709770317 
component.setFont(stdFont);
//#endif 


//#if -1832356916 
add(jlabel);
//#endif 


//#if -792007521 
add(component);
//#endif 


//#if -572151988 
if(component instanceof UMLLinkedList)//1
{ 

//#if 1168470315 
UMLModelElementListModel2 list =
                (UMLModelElementListModel2) ((UMLLinkedList) component).getModel();
//#endif 


//#if -1698900107 
ActionCreateContainedModelElement newAction =
                new ActionCreateContainedModelElement(
                list.getMetaType(),
                list.getTarget(),
                "New...");
//#endif 

} 

//#endif 


//#if -874535176 
return jlabel;
//#endif 

} 

//#endif 


//#if 1025551644 
public void targetRemoved(TargetEvent e)
    { 

//#if 367919778 
setTarget(e.getNewTarget());
//#endif 


//#if -1726348836 
if(isVisible())//1
{ 

//#if -953418382 
fireTargetRemoved(e);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1861468321 
protected final Action getDeleteAction()
    { 

//#if 590666944 
return ActionDeleteModelElements.getTargetFollower();
//#endif 

} 

//#endif 


//#if -1073711847 
public final Object getModelElement()
    { 

//#if -1157306831 
return modelElement;
//#endif 

} 

//#endif 


//#if 18278686 
public void targetSet(TargetEvent e)
    { 

//#if 934049187 
setTarget(e.getNewTarget());
//#endif 


//#if 517673501 
if(isVisible())//1
{ 

//#if -2061219889 
fireTargetSet(e);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -881911587 
public void componentShown(ComponentEvent e)
    { 

//#if 1206509069 
fireTargetSet(new TargetEvent(
                          this, TargetEvent.TARGET_SET, null, new Object[] {target}));
//#endif 

} 

//#endif 


//#if 19358598 
public String formatNamespace(Object namespace)
    { 

//#if 1757265807 
return getProfile().getFormatingStrategy().formatElement(namespace,
                null);
//#endif 

} 

//#endif 


//#if 7766843 
public JLabel addFieldAfter(String label, Component component,
                                Component afterComponent)
    { 

//#if 1086166715 
int nComponent = getComponentCount();
//#endif 


//#if -1944130467 
for (int i = 0; i < nComponent; ++i) //1
{ 

//#if 1858507636 
if(getComponent(i) == afterComponent)//1
{ 

//#if -1031367931 
JLabel jlabel = createLabelFor(label, component);
//#endif 


//#if -923068744 
component.setFont(stdFont);
//#endif 


//#if -1500497660 
add(jlabel, ++i);
//#endif 


//#if -1910318527 
add(component, ++i);
//#endif 


//#if 1894151869 
return jlabel;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 444668418 
throw new IllegalArgumentException("Component not found");
//#endif 

} 

//#endif 


//#if -612643268 
protected UMLSingleRowSelector getSingleRowScroll(ListModel model)
    { 

//#if 1655328398 
UMLSingleRowSelector pane = new UMLSingleRowSelector(model);
//#endif 


//#if -1857628371 
return pane;
//#endif 

} 

//#endif 


//#if -857423291 
protected void addAction(Action action)
    { 

//#if 1116652870 
actions.add(action);
//#endif 

} 

//#endif 


//#if 1401552516 
public void refresh()
    { 

//#if -1852504690 
SwingUtilities.invokeLater(new UMLChangeDispatch(this, 0));
//#endif 

} 

//#endif 


//#if -623424163 
@Override
    public void setOrientation(Orientation orientation)
    { 

//#if 1046402795 
super.setOrientation(orientation);
//#endif 

} 

//#endif 


//#if -988428555 
public boolean shouldBeEnabled(Object t)
    { 

//#if 1880752164 
t = (t instanceof Fig) ? ((Fig) t).getOwner() : t;
//#endif 


//#if 81512423 
return Model.getFacade().isAUMLElement(t);
//#endif 

} 

//#endif 


//#if -1210559568 
public PropPanel(String label, ImageIcon icon)
    { 

//#if -1484482223 
super(Translator.localize(label));
//#endif 


//#if -492338951 
LabelledLayout layout = new LabelledLayout();
//#endif 


//#if 150892733 
layout.setHgap(5);
//#endif 


//#if -281691414 
setLayout(layout);
//#endif 


//#if -1631079267 
if(icon != null)//1
{ 

//#if -1347481876 
setTitleLabel(new JLabel(Translator.localize(label), icon,
                                     SwingConstants.LEFT));
//#endif 

} 
else
{ 

//#if 489589406 
setTitleLabel(new JLabel(Translator.localize(label)));
//#endif 

} 

//#endif 


//#if 467966995 
titleLabel.setLabelFor(buttonPanel);
//#endif 


//#if 1376449767 
add(titleLabel);
//#endif 


//#if 986619531 
add(buttonPanel);
//#endif 


//#if 198580470 
addComponentListener(this);
//#endif 

} 

//#endif 


//#if 325714763 
protected final JPanel createBorderPanel(String title)
    { 

//#if -1227501131 
return new GroupPanel(Translator.localize(title));
//#endif 

} 

//#endif 


//#if 126190496 
private void fireTargetSet(TargetEvent targetEvent)
    { 

//#if 445733344 
if(listenerList == null)//1
{ 

//#if 1908367794 
listenerList = collectTargetListeners(this);
//#endif 

} 

//#endif 


//#if 564281923 
Object[] listeners = listenerList.getListenerList();
//#endif 


//#if 911297739 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if -684498644 
if(listeners[i] == TargetListener.class)//1
{ 

//#if -1405976294 
((TargetListener) listeners[i + 1]).targetSet(targetEvent);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1317538731 
protected static ImageIcon lookupIcon(String name)
    { 

//#if 1606682361 
return ResourceLoaderWrapper.lookupIconResource(name);
//#endif 

} 

//#endif 


//#if 1706470667 
private JLabel createLabelFor(String label, Component comp)
    { 

//#if -367238585 
JLabel jlabel = new JLabel(Translator.localize(label));
//#endif 


//#if 1735120922 
jlabel.setToolTipText(Translator.localize(label));
//#endif 


//#if 758086811 
jlabel.setFont(stdFont);
//#endif 


//#if -1247917724 
jlabel.setLabelFor(comp);
//#endif 


//#if 908527919 
return jlabel;
//#endif 

} 

//#endif 


//#if 897099461 
public String formatCollection(Iterator iter)
    { 

//#if -652102180 
Object namespace = getDisplayNamespace();
//#endif 


//#if -585921631 
return getProfile().getFormatingStrategy().formatCollection(iter,
                namespace);
//#endif 

} 

//#endif 


//#if 887248080 
public boolean isRemovableElement()
    { 

//#if 1960528764 
return ((getTarget() != null) && (getTarget() != (ProjectManager
                                          .getManager().getCurrentProject().getModel())));
//#endif 

} 

//#endif 


//#if -1172284294 
public void componentHidden(ComponentEvent e)
    { 
} 

//#endif 


//#if 338134908 
public void targetAdded(TargetEvent e)
    { 

//#if 2083983148 
if(listenerList == null)//1
{ 

//#if 1462692633 
listenerList = collectTargetListeners(this);
//#endif 

} 

//#endif 


//#if -1142321268 
setTarget(e.getNewTarget());
//#endif 


//#if -200619194 
if(isVisible())//1
{ 

//#if -476448699 
fireTargetAdded(e);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1892454852 
protected final void addSeparator()
    { 

//#if -1901992640 
add(LabelledLayout.getSeparator());
//#endif 

} 

//#endif 


//#if 1235249823 
protected void addAction(Object[] actionArray)
    { 

//#if -46169369 
actions.add(actionArray);
//#endif 

} 

//#endif 


//#if 775591803 
public void componentMoved(ComponentEvent e)
    { 
} 

//#endif 


//#if -1076942239 
public void setTarget(Object t)
    { 

//#if 2013214676 
LOG.debug("setTarget called with " + t + " as parameter (not target!)");
//#endif 


//#if 1940365620 
t = (t instanceof Fig) ? ((Fig) t).getOwner() : t;
//#endif 


//#if 1048058178 
Runnable dispatch = null;
//#endif 


//#if 301425362 
if(t != target)//1
{ 

//#if -1213031832 
target = t;
//#endif 


//#if -1911661547 
modelElement = null;
//#endif 


//#if 1686285537 
if(listenerList == null)//1
{ 

//#if -1140541905 
listenerList = collectTargetListeners(this);
//#endif 

} 

//#endif 


//#if 690717397 
if(Model.getFacade().isAUMLElement(target))//1
{ 

//#if -504140083 
modelElement = target;
//#endif 

} 

//#endif 


//#if -174011866 
dispatch = new UMLChangeDispatch(this,
                                             UMLChangeDispatch.TARGET_CHANGED_ADD);
//#endif 


//#if 1541342626 
buildToolbar();
//#endif 

} 
else
{ 

//#if 1514935461 
dispatch = new UMLChangeDispatch(this,
                                             UMLChangeDispatch.TARGET_REASSERTED);
//#endif 

} 

//#endif 


//#if -2015219346 
SwingUtilities.invokeLater(dispatch);
//#endif 


//#if 458791838 
if(titleLabel != null)//1
{ 

//#if 1483373239 
Icon icon = null;
//#endif 


//#if 1582455266 
if(t != null)//1
{ 

//#if -1518284159 
icon = ResourceLoaderWrapper.getInstance().lookupIcon(t);
//#endif 

} 

//#endif 


//#if 706662273 
if(icon != null)//1
{ 

//#if -190565668 
titleLabel.setIcon(icon);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1246453211 
public ProfileConfiguration getProfile()
    { 

//#if -1516555482 
return ProjectManager.getManager().getCurrentProject()
               .getProfileConfiguration();
//#endif 

} 

//#endif 


//#if -2074447106 
private void fireTargetAdded(TargetEvent targetEvent)
    { 

//#if -1016672874 
if(listenerList == null)//1
{ 

//#if -1926857248 
listenerList = collectTargetListeners(this);
//#endif 

} 

//#endif 


//#if -2006617095 
Object[] listeners = listenerList.getListenerList();
//#endif 


//#if 1017418881 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if 1051538978 
if(listeners[i] == TargetListener.class)//1
{ 

//#if -1884463272 
((TargetListener) listeners[i + 1]).targetAdded(targetEvent);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1315952909 
private static class TargettableButton extends 
//#if 843157738 
JButton
//#endif 

 implements 
//#if 1523035939 
TargettableModelView
//#endif 

  { 

//#if -1682517175 
public TargettableButton(Action action)
        { 

//#if 1643539034 
super(action);
//#endif 

} 

//#endif 


//#if -1057973725 
public TargetListener getTargettableModel()
        { 

//#if -537602114 
if(getAction() instanceof TargetListener)//1
{ 

//#if -673111887 
return (TargetListener) getAction();
//#endif 

} 

//#endif 


//#if 88132705 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1082142699 
private class GroupPanel extends 
//#if 1367681447 
JPanel
//#endif 

  { 

//#if -1009371985 
public GroupPanel(String title)
        { 

//#if -1640507081 
super(new GridLayout2());
//#endif 


//#if 923874370 
TitledBorder border = new TitledBorder(Translator.localize(title));
//#endif 


//#if 476166894 
border.setTitleFont(stdFont);
//#endif 


//#if -1932062227 
setBorder(border);
//#endif 

} 

//#endif 


//#if -1878743855 
public void setEnabled(boolean enabled)
        { 

//#if 87363974 
super.setEnabled(enabled);
//#endif 


//#if 92906217 
for (final Component component : getComponents()) //1
{ 

//#if -1780089756 
component.setEnabled(enabled);
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

