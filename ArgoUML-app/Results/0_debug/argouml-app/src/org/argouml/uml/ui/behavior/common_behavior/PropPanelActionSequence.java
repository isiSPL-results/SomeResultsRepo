
//#if 958352939 
// Compilation Unit of /PropPanelActionSequence.java 
 

//#if -449621399 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 649021079 
import java.awt.event.ActionEvent;
//#endif 


//#if 1947712589 
import java.util.List;
//#endif 


//#if -401390849 
import javax.swing.ImageIcon;
//#endif 


//#if -963434037 
import javax.swing.JList;
//#endif 


//#if -962634454 
import javax.swing.JMenu;
//#endif 


//#if 1430704066 
import javax.swing.JPopupMenu;
//#endif 


//#if -1204738316 
import javax.swing.JScrollPane;
//#endif 


//#if 1838773438 
import org.argouml.i18n.Translator;
//#endif 


//#if 1839091332 
import org.argouml.model.Model;
//#endif 


//#if -1500670930 
import org.argouml.uml.ui.AbstractActionRemoveElement;
//#endif 


//#if -1527092026 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if -1501502469 
import org.argouml.uml.ui.ActionRemoveModelElement;
//#endif 


//#if 1868228891 
import org.argouml.uml.ui.UMLModelElementOrderedListModel2;
//#endif 


//#if -193778337 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if 235042958 
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
//#endif 


//#if -869467701 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if 509557332 
public class PropPanelActionSequence extends 
//#if 1343844539 
PropPanelModelElement
//#endif 

  { 

//#if 578759686 
private JScrollPane actionsScroll;
//#endif 


//#if -585618630 
public PropPanelActionSequence(String name, ImageIcon icon)
    { 

//#if -206952664 
super(name, icon);
//#endif 


//#if -1139996173 
initialize();
//#endif 

} 

//#endif 


//#if 1378655015 
public void initialize()
    { 

//#if 1178035917 
addField(Translator.localize("label.name"), getNameTextField());
//#endif 


//#if 61650139 
JList actionsList = new UMLActionSequenceActionList();
//#endif 


//#if 1168063841 
actionsList.setVisibleRowCount(5);
//#endif 


//#if -1567803167 
actionsScroll = new JScrollPane(actionsList);
//#endif 


//#if -1464324632 
addField(Translator.localize("label.actions"),
                 actionsScroll);
//#endif 


//#if 986078266 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if 286689098 
addAction(new ActionNewStereotype());
//#endif 


//#if -720801201 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if -1249745673 
public PropPanelActionSequence()
    { 

//#if 313695014 
this("label.action-sequence", lookupIcon("ActionSequence"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -450679886 
class UMLActionSequenceActionList extends 
//#if 766405993 
UMLMutableLinkedList
//#endif 

  { 

//#if 1500969836 
@Override
    public JPopupMenu getPopupMenu()
    { 

//#if -842151954 
return new PopupMenuNewAction(ActionNewAction.Roles.MEMBER, this);
//#endif 

} 

//#endif 


//#if -1507884521 
public UMLActionSequenceActionList()
    { 

//#if -295170367 
super(new UMLActionSequenceActionListModel());
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -411874179 
class ActionRemoveAction extends 
//#if 781979163 
AbstractActionRemoveElement
//#endif 

  { 

//#if -1355207898 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if -1605499093 
super.actionPerformed(e);
//#endif 


//#if 679132147 
Object action = getObjectToRemove();
//#endif 


//#if -423899983 
if(action != null)//1
{ 

//#if -46867403 
Object as = getTarget();
//#endif 


//#if 1631969826 
if(Model.getFacade().isAActionSequence(as))//1
{ 

//#if -693009276 
Model.getCommonBehaviorHelper().removeAction(as, action);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -387744673 
public ActionRemoveAction()
    { 

//#if -881714741 
super(Translator.localize("menu.popup.remove"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1053606607 
class PopupMenuNewActionSequenceAction extends 
//#if 1789724479 
JPopupMenu
//#endif 

  { 

//#if 401630620 
public PopupMenuNewActionSequenceAction(String role,
                                            UMLMutableLinkedList list)
    { 

//#if -812533625 
super();
//#endif 


//#if -322260238 
JMenu newMenu = new JMenu();
//#endif 


//#if 2138160776 
newMenu.setText(Translator.localize("action.new"));
//#endif 


//#if 1660422512 
newMenu.add(ActionNewCallAction.getInstance());
//#endif 


//#if -89157127 
ActionNewCallAction.getInstance().setTarget(list.getTarget());
//#endif 


//#if 1772391044 
ActionNewCallAction.getInstance().putValue(
            ActionNewAction.ROLE, role);
//#endif 


//#if 1595604802 
add(newMenu);
//#endif 


//#if 241633806 
addSeparator();
//#endif 


//#if -1995128389 
ActionRemoveModelElement.SINGLETON.setObjectToRemove(ActionNewAction
                .getAction(role, list.getTarget()));
//#endif 


//#if 1767391179 
add(ActionRemoveModelElement.SINGLETON);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1833918103 
class UMLActionSequenceActionListModel extends 
//#if 215922792 
UMLModelElementOrderedListModel2
//#endif 

  { 

//#if 1604211142 
@Override
    protected void moveToBottom(int index)
    { 

//#if -802976828 
Object target = getTarget();
//#endif 


//#if 1882874830 
List c = Model.getFacade().getActions(target);
//#endif 


//#if -253506126 
if(index < c.size() - 1)//1
{ 

//#if 2141863122 
Object item = c.get(index);
//#endif 


//#if 248156697 
Model.getCommonBehaviorHelper().removeAction(target, item);
//#endif 


//#if 2096594689 
Model.getCommonBehaviorHelper().addAction(target, c.size(), item);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -898408145 
public UMLActionSequenceActionListModel()
    { 

//#if 1194743023 
super("action");
//#endif 

} 

//#endif 


//#if -2032856031 
protected void buildModelList()
    { 

//#if -1078708890 
if(getTarget() != null)//1
{ 

//#if 1525674119 
setAllElements(Model.getFacade().getActions(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -392648426 
@Override
    protected void moveToTop(int index)
    { 

//#if 1556481068 
Object target = getTarget();
//#endif 


//#if 1130795574 
List c = Model.getFacade().getActions(target);
//#endif 


//#if 1986125269 
if(index > 0)//1
{ 

//#if 240049525 
Object item = c.get(index);
//#endif 


//#if -397850116 
Model.getCommonBehaviorHelper().removeAction(target, item);
//#endif 


//#if 463038785 
Model.getCommonBehaviorHelper().addAction(target, 0, item);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1106424440 
protected void moveDown(int index)
    { 

//#if -210445182 
Object target = getTarget();
//#endif 


//#if -1538506484 
List c = Model.getFacade().getActions(target);
//#endif 


//#if -47303184 
if(index < c.size() - 1)//1
{ 

//#if -208970402 
Object item = c.get(index);
//#endif 


//#if -1595109467 
Model.getCommonBehaviorHelper().removeAction(target, item);
//#endif 


//#if -452777296 
Model.getCommonBehaviorHelper().addAction(target, index + 1, item);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 226204245 
protected boolean isValidElement(Object element)
    { 

//#if 79863080 
return Model.getFacade().isAAction(element);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

