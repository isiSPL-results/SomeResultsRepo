
//#if 2108296929 
// Compilation Unit of /ActionNewTransition.java 
 

//#if -62613094 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -1757646390 
import java.awt.event.ActionEvent;
//#endif 


//#if -700110799 
import org.argouml.model.Model;
//#endif 


//#if -1004639855 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1529821254 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if -120543320 
public class ActionNewTransition extends 
//#if 1927433308 
AbstractActionNewModelElement
//#endif 

  { 

//#if 1015462725 
public static final String SOURCE = "source";
//#endif 


//#if -1300907195 
public static final String DESTINATION = "destination";
//#endif 


//#if -455418280 
public ActionNewTransition()
    { 

//#if 1926061177 
super();
//#endif 

} 

//#endif 


//#if -890166504 
public boolean isEnabled()
    { 

//#if 1731629591 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 1829455072 
return super.isEnabled()



               && !Model.getStateMachinesHelper().isTopState(target)

               ;
//#endif 

} 

//#endif 


//#if -619771282 
public void actionPerformed(ActionEvent e)
    { 

//#if 644735407 
super.actionPerformed(e);
//#endif 


//#if 1088539483 
if(getValue(SOURCE) == null || getValue(DESTINATION) == null)//1
{ 

//#if 978152218 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if -1635033793 
Model.getStateMachinesFactory()
            .buildInternalTransition(target);
//#endif 

} 
else
{ 

//#if 258719201 
Model.getStateMachinesFactory()
            .buildTransition(getValue(SOURCE), getValue(DESTINATION));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

