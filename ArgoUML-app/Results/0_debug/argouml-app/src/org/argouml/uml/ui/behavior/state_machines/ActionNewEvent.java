
//#if -663931730 
// Compilation Unit of /ActionNewEvent.java 
 

//#if 81851717 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 119996095 
import java.awt.event.ActionEvent;
//#endif 


//#if 290709755 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1488308060 
import org.argouml.model.Model;
//#endif 


//#if 939682950 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1059033221 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if 127653626 
public abstract class ActionNewEvent extends 
//#if -1945720385 
AbstractActionNewModelElement
//#endif 

  { 

//#if 1523579358 
public static final String ROLE = "role";
//#endif 


//#if 1416177320 
protected abstract Object createEvent(Object ns);
//#endif 


//#if 774204139 
public static Object getAction(String role, Object t)
    { 

//#if 1530434797 
if(role.equals(Roles.TRIGGER))//1
{ 

//#if -1984331520 
return Model.getFacade().getTrigger(t);
//#endif 

} 

//#endif 


//#if -137351093 
return null;
//#endif 

} 

//#endif 


//#if -2137765871 
public void actionPerformed(ActionEvent e)
    { 

//#if -652026189 
super.actionPerformed(e);
//#endif 


//#if 872644557 
Object target = getTarget();
//#endif 


//#if 441156558 
Object model =
            ProjectManager.getManager().getCurrentProject().getModel();
//#endif 


//#if -525688638 
Object ns = Model.getStateMachinesHelper()
                    .findNamespaceForEvent(target, model);
//#endif 


//#if 133934646 
Object event = createEvent(ns);
//#endif 


//#if -481600285 
if(getValue(ROLE).equals(Roles.TRIGGER))//1
{ 

//#if -1129478822 
Model.getStateMachinesHelper()
            .setEventAsTrigger(target, event);
//#endif 

} 

//#endif 


//#if -351677262 
if(getValue(ROLE).equals(Roles.DEFERRABLE_EVENT))//1
{ 

//#if -389431312 
Model.getStateMachinesHelper()
            .addDeferrableEvent(target, event);
//#endif 

} 

//#endif 


//#if 1694664752 
TargetManager.getInstance().setTarget(event);
//#endif 

} 

//#endif 


//#if 2025576611 
protected ActionNewEvent()
    { 

//#if 1833359613 
super();
//#endif 

} 

//#endif 


//#if 8100023 
public static interface Roles  { 

//#if -303107540 
public static final  String TRIGGER = "trigger";
//#endif 


//#if 210741042 
public static final String DEFERRABLE_EVENT = "deferrable-event";
//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

