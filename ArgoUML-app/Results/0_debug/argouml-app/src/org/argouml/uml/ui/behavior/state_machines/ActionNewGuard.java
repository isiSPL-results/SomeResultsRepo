
//#if 1350040096 
// Compilation Unit of /ActionNewGuard.java 
 

//#if -1120866976 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -625098428 
import java.awt.event.ActionEvent;
//#endif 


//#if 252746487 
import org.argouml.model.Model;
//#endif 


//#if -1038777077 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1105088576 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if 1240327660 
public class ActionNewGuard extends 
//#if -1154861594 
AbstractActionNewModelElement
//#endif 

  { 

//#if 246386088 
private static ActionNewGuard singleton = new ActionNewGuard();
//#endif 


//#if 546312056 
public void actionPerformed(ActionEvent e)
    { 

//#if 428589943 
super.actionPerformed(e);
//#endif 


//#if 669224157 
TargetManager.getInstance().setTarget(
            Model.getStateMachinesFactory().buildGuard(getTarget()));
//#endif 

} 

//#endif 


//#if 1884023630 
public boolean isEnabled()
    { 

//#if -762506645 
Object t = getTarget();
//#endif 


//#if 705347487 
return t != null
               && Model.getFacade().getGuard(t) == null;
//#endif 

} 

//#endif 


//#if 1312974229 
protected ActionNewGuard()
    { 

//#if -1786898844 
super();
//#endif 

} 

//#endif 


//#if -1617965283 
public static ActionNewGuard getSingleton()
    { 

//#if -962992491 
return singleton;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

