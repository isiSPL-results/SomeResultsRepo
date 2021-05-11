
//#if -1484597945 
// Compilation Unit of /ActionNewAction.java 
 

//#if 2039089857 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 1545594095 
import java.awt.event.ActionEvent;
//#endif 


//#if -1528688852 
import org.argouml.model.Model;
//#endif 


//#if 1514730166 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 81105323 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if 628827719 
import org.tigris.toolbar.toolbutton.ModalAction;
//#endif 


//#if 774538662 
public abstract class ActionNewAction extends 
//#if -1097948049 
AbstractActionNewModelElement
//#endif 

 implements 
//#if 1656631159 
ModalAction
//#endif 

  { 

//#if -2143473522 
public static final String ROLE = "role";
//#endif 


//#if 2080285311 
protected ActionNewAction()
    { 

//#if 2147199028 
super();
//#endif 

} 

//#endif 


//#if 707176129 
public void actionPerformed(ActionEvent e)
    { 

//#if -515761418 
super.actionPerformed(e);
//#endif 


//#if 554610352 
Object action = createAction();
//#endif 


//#if 1716327974 
if(getValue(ROLE).equals(Roles.EXIT))//1
{ 

//#if -1967783311 
Model.getStateMachinesHelper().setExit(getTarget(), action);
//#endif 

} 
else

//#if -1891260141 
if(getValue(ROLE).equals(Roles.ENTRY))//1
{ 

//#if -1444500718 
Model.getStateMachinesHelper().setEntry(getTarget(), action);
//#endif 

} 
else

//#if -485825193 
if(getValue(ROLE).equals(Roles.DO))//1
{ 

//#if 159673247 
Model.getStateMachinesHelper().setDoActivity(
                getTarget(), action);
//#endif 

} 
else

//#if -1583739278 
if(getValue(ROLE).equals(Roles.ACTION))//1
{ 

//#if -1357142642 
Model.getCollaborationsHelper().setAction(getTarget(), action);
//#endif 

} 
else

//#if 637603653 
if(getValue(ROLE).equals(Roles.EFFECT))//1
{ 

//#if 903118552 
Model.getStateMachinesHelper().setEffect(getTarget(), action);
//#endif 

} 
else

//#if 2087889487 
if(getValue(ROLE).equals(Roles.MEMBER))//1
{ 

//#if -1717969848 
Model.getCommonBehaviorHelper().addAction(getTarget(), action);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#if -436046047 
TargetManager.getInstance().setTarget(action);
//#endif 

} 

//#endif 


//#if 774025494 
protected abstract Object createAction();
//#endif 


//#if 897980827 
public static Object getAction(String role, Object t)
    { 

//#if 257389494 
if(role.equals(Roles.EXIT))//1
{ 

//#if -1233190117 
return Model.getFacade().getExit(t);
//#endif 

} 
else

//#if -874120067 
if(role.equals(Roles.ENTRY))//1
{ 

//#if -2063793178 
return Model.getFacade().getEntry(t);
//#endif 

} 
else

//#if -562250525 
if(role.equals(Roles.DO))//1
{ 

//#if -793498170 
return Model.getFacade().getDoActivity(t);
//#endif 

} 
else

//#if 1214880925 
if(role.equals(Roles.ACTION))//1
{ 

//#if 525327029 
return Model.getFacade().getAction(t);
//#endif 

} 
else

//#if -1049430781 
if(role.equals(Roles.EFFECT))//1
{ 

//#if -526781422 
return Model.getFacade().getEffect(t);
//#endif 

} 
else

//#if -1733771366 
if(role.equals(Roles.MEMBER))//1
{ 

//#if -1666942985 
return Model.getFacade().getActions(t);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#if 1091770100 
return null;
//#endif 

} 

//#endif 


//#if 1359289351 
public static interface Roles  { 

//#if -656171833 
String ENTRY = "entry";
//#endif 


//#if 888131917 
String EXIT = "exit";
//#endif 


//#if 1687936359 
String DO = "do";
//#endif 


//#if 774329661 
String ACTION = "action";
//#endif 


//#if -185455757 
String EFFECT = "effect";
//#endif 


//#if 78821381 
String MEMBER = "member";
//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

