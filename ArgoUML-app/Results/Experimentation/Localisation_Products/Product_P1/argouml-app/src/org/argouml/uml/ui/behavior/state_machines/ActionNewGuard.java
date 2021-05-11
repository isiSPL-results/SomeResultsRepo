package org.argouml.uml.ui.behavior.state_machines;
import java.awt.event.ActionEvent;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.ui.AbstractActionNewModelElement;
public class ActionNewGuard extends AbstractActionNewModelElement
  { 
private static ActionNewGuard singleton = new ActionNewGuard();
public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
TargetManager.getInstance().setTarget(
            Model.getStateMachinesFactory().buildGuard(getTarget()));
} 
public boolean isEnabled()
    { 
Object t = getTarget();
return t != null
               && Model.getFacade().getGuard(t) == null;
} 
protected ActionNewGuard()
    { 
super();
} 
public static ActionNewGuard getSingleton()
    { 
return singleton;
} 

 } 
