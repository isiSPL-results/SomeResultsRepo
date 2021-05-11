
//#if -1096408113 
// Compilation Unit of /ActionNewArgument.java 
 

//#if -1331364748 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 123923810 
import java.awt.event.ActionEvent;
//#endif 


//#if -2086530151 
import org.argouml.model.Model;
//#endif 


//#if -1429555927 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1827303902 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if 1583724344 
public class ActionNewArgument extends 
//#if -324326334 
AbstractActionNewModelElement
//#endif 

  { 

//#if -325631706 
public ActionNewArgument()
    { 

//#if 656601117 
super();
//#endif 

} 

//#endif 


//#if -1207581996 
public void actionPerformed(ActionEvent e)
    { 

//#if 238829252 
super.actionPerformed(e);
//#endif 


//#if 1763499998 
Object target = getTarget();
//#endif 


//#if 1358420250 
if(Model.getFacade().isAAction(target))//1
{ 

//#if 238435359 
Object argument = Model.getCommonBehaviorFactory().createArgument();
//#endif 


//#if -1030627317 
Model.getCommonBehaviorHelper().addActualArgument(target, argument);
//#endif 


//#if 1901150570 
TargetManager.getInstance().setTarget(argument);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

