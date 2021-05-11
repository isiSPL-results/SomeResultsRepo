// Compilation Unit of /PropPanelActionSequence.java 
 
package org.argouml.uml.ui.behavior.common_behavior;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.AbstractActionRemoveElement;
import org.argouml.uml.ui.ActionNavigateContainerElement;
import org.argouml.uml.ui.ActionRemoveModelElement;
import org.argouml.uml.ui.UMLModelElementOrderedListModel2;
import org.argouml.uml.ui.UMLMutableLinkedList;
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
public class PropPanelActionSequence extends PropPanelModelElement
  { 
private JScrollPane actionsScroll;
public PropPanelActionSequence(String name, ImageIcon icon)
    { 
super(name, icon);
initialize();
} 

public void initialize()
    { 
addField(Translator.localize("label.name"), getNameTextField());
JList actionsList = new UMLActionSequenceActionList();
actionsList.setVisibleRowCount(5);
actionsScroll = new JScrollPane(actionsList);
addField(Translator.localize("label.actions"),
                 actionsScroll);
addAction(new ActionNavigateContainerElement());
addAction(new ActionNewStereotype());
addAction(getDeleteAction());
} 

public PropPanelActionSequence()
    { 
this("label.action-sequence", lookupIcon("ActionSequence"));
} 

 } 

class UMLActionSequenceActionList extends UMLMutableLinkedList
  { 
@Override
    public JPopupMenu getPopupMenu()
    { 
return new PopupMenuNewAction(ActionNewAction.Roles.MEMBER, this);
} 

public UMLActionSequenceActionList()
    { 
super(new UMLActionSequenceActionListModel());
} 

 } 

class ActionRemoveAction extends AbstractActionRemoveElement
  { 
@Override
    public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
Object action = getObjectToRemove();
if(action != null)//1
{ 
Object as = getTarget();
if(Model.getFacade().isAActionSequence(as))//1
{ 
Model.getCommonBehaviorHelper().removeAction(as, action);
} 

} 

} 

public ActionRemoveAction()
    { 
super(Translator.localize("menu.popup.remove"));
} 

 } 

class PopupMenuNewActionSequenceAction extends JPopupMenu
  { 
public PopupMenuNewActionSequenceAction(String role,
                                            UMLMutableLinkedList list)
    { 
super();
JMenu newMenu = new JMenu();
newMenu.setText(Translator.localize("action.new"));
newMenu.add(ActionNewCallAction.getInstance());
ActionNewCallAction.getInstance().setTarget(list.getTarget());
ActionNewCallAction.getInstance().putValue(
            ActionNewAction.ROLE, role);
add(newMenu);
addSeparator();
ActionRemoveModelElement.SINGLETON.setObjectToRemove(ActionNewAction
                .getAction(role, list.getTarget()));
add(ActionRemoveModelElement.SINGLETON);
} 

 } 

class UMLActionSequenceActionListModel extends UMLModelElementOrderedListModel2
  { 
@Override
    protected void moveToBottom(int index)
    { 
Object target = getTarget();
List c = Model.getFacade().getActions(target);
if(index < c.size() - 1)//1
{ 
Object item = c.get(index);
Model.getCommonBehaviorHelper().removeAction(target, item);
Model.getCommonBehaviorHelper().addAction(target, c.size(), item);
} 

} 

public UMLActionSequenceActionListModel()
    { 
super("action");
} 

protected void buildModelList()
    { 
if(getTarget() != null)//1
{ 
setAllElements(Model.getFacade().getActions(getTarget()));
} 

} 

@Override
    protected void moveToTop(int index)
    { 
Object target = getTarget();
List c = Model.getFacade().getActions(target);
if(index > 0)//1
{ 
Object item = c.get(index);
Model.getCommonBehaviorHelper().removeAction(target, item);
Model.getCommonBehaviorHelper().addAction(target, 0, item);
} 

} 

protected void moveDown(int index)
    { 
Object target = getTarget();
List c = Model.getFacade().getActions(target);
if(index < c.size() - 1)//1
{ 
Object item = c.get(index);
Model.getCommonBehaviorHelper().removeAction(target, item);
Model.getCommonBehaviorHelper().addAction(target, index + 1, item);
} 

} 

protected boolean isValidElement(Object element)
    { 
return Model.getFacade().isAAction(element);
} 

 } 


