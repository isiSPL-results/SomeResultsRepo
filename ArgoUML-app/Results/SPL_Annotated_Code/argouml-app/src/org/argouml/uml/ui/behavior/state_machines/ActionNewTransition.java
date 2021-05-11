// Compilation Unit of /ActionNewTransition.java 
 
package org.argouml.uml.ui.behavior.state_machines;
import java.awt.event.ActionEvent;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.ui.AbstractActionNewModelElement;
public class ActionNewTransition extends AbstractActionNewModelElement
  { 
public static final String SOURCE = "source";
public static final String DESTINATION = "destination";
public ActionNewTransition()
    { 
super();
} 

public boolean isEnabled()
    { 
Object target = TargetManager.getInstance().getModelTarget();
return super.isEnabled()



               && !Model.getStateMachinesHelper().isTopState(target)

               ;
} 

public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
if(getValue(SOURCE) == null || getValue(DESTINATION) == null)//1
{ 
Object target = TargetManager.getInstance().getModelTarget();
Model.getStateMachinesFactory()
            .buildInternalTransition(target);
} 
else
{ 
Model.getStateMachinesFactory()
            .buildTransition(getValue(SOURCE), getValue(DESTINATION));
} 

} 

 } 


