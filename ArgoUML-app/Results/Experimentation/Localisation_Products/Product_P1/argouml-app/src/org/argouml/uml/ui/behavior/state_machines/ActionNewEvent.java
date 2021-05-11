package org.argouml.uml.ui.behavior.state_machines;
import java.awt.event.ActionEvent;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.ui.AbstractActionNewModelElement;
public abstract class ActionNewEvent extends AbstractActionNewModelElement
  { 
public static final String ROLE = "role";
protected abstract Object createEvent(Object ns);public static Object getAction(String role, Object t)
    { 
if(role.equals(Roles.TRIGGER))//1
{ 
return Model.getFacade().getTrigger(t);
} 
return null;
} 
public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
Object target = getTarget();
Object model =
            ProjectManager.getManager().getCurrentProject().getModel();
Object ns = Model.getStateMachinesHelper()
                    .findNamespaceForEvent(target, model);
Object event = createEvent(ns);
if(getValue(ROLE).equals(Roles.TRIGGER))//1
{ 
Model.getStateMachinesHelper()
            .setEventAsTrigger(target, event);
} 
if(getValue(ROLE).equals(Roles.DEFERRABLE_EVENT))//1
{ 
Model.getStateMachinesHelper()
            .addDeferrableEvent(target, event);
} 
TargetManager.getInstance().setTarget(event);
} 
protected ActionNewEvent()
    { 
super();
} 
public static interface Roles  { 
public static final  String TRIGGER = "trigger";
public static final String DEFERRABLE_EVENT = "deferrable-event";

 } 

 } 
