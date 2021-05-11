package org.argouml.uml.ui.behavior.common_behavior;
import java.awt.event.ActionEvent;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.ui.AbstractActionNewModelElement;
import org.tigris.toolbar.toolbutton.ModalAction;
public abstract class ActionNewAction extends AbstractActionNewModelElement
 implements ModalAction
  { 
public static final String ROLE = "role";
protected ActionNewAction()
    { 
super();
} 
public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
Object action = createAction();
if(getValue(ROLE).equals(Roles.EXIT))//1
{ 
Model.getStateMachinesHelper().setExit(getTarget(), action);
} 
else
if(getValue(ROLE).equals(Roles.ENTRY))//1
{ 
Model.getStateMachinesHelper().setEntry(getTarget(), action);
} 
else
if(getValue(ROLE).equals(Roles.DO))//1
{ 
Model.getStateMachinesHelper().setDoActivity(
                getTarget(), action);
} 
else
if(getValue(ROLE).equals(Roles.ACTION))//1
{ 
Model.getCollaborationsHelper().setAction(getTarget(), action);
} 
else
if(getValue(ROLE).equals(Roles.EFFECT))//1
{ 
Model.getStateMachinesHelper().setEffect(getTarget(), action);
} 
else
if(getValue(ROLE).equals(Roles.MEMBER))//1
{ 
Model.getCommonBehaviorHelper().addAction(getTarget(), action);
} 
TargetManager.getInstance().setTarget(action);
} 
protected abstract Object createAction();public static Object getAction(String role, Object t)
    { 
if(role.equals(Roles.EXIT))//1
{ 
return Model.getFacade().getExit(t);
} 
else
if(role.equals(Roles.ENTRY))//1
{ 
return Model.getFacade().getEntry(t);
} 
else
if(role.equals(Roles.DO))//1
{ 
return Model.getFacade().getDoActivity(t);
} 
else
if(role.equals(Roles.ACTION))//1
{ 
return Model.getFacade().getAction(t);
} 
else
if(role.equals(Roles.EFFECT))//1
{ 
return Model.getFacade().getEffect(t);
} 
else
if(role.equals(Roles.MEMBER))//1
{ 
return Model.getFacade().getActions(t);
} 
return null;
} 
public static interface Roles  { 
String ENTRY = "entry";
String EXIT = "exit";
String DO = "do";
String ACTION = "action";
String EFFECT = "effect";
String MEMBER = "member";

 } 

 } 
