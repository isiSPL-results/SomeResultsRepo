
//#if -606485241 
// Compilation Unit of /ActionNewExtendExtensionPoint.java 
 

//#if -943014846 
package org.argouml.uml.ui.behavior.use_cases;
//#endif 


//#if 1739833909 
import java.awt.event.ActionEvent;
//#endif 


//#if 622765990 
import org.argouml.model.Model;
//#endif 


//#if -351955343 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if 297291283 
public class ActionNewExtendExtensionPoint extends 
//#if 789206920 
AbstractActionNewModelElement
//#endif 

  { 

//#if -1821100278 
public static final ActionNewExtendExtensionPoint SINGLETON =
        new ActionNewExtendExtensionPoint();
//#endif 


//#if 1717319323 
protected ActionNewExtendExtensionPoint()
    { 

//#if 1895297763 
super();
//#endif 

} 

//#endif 


//#if -265023846 
public void actionPerformed(ActionEvent e)
    { 

//#if -1336393886 
super.actionPerformed(e);
//#endif 


//#if 391593353 
if(Model.getFacade().isAExtend(getTarget()))//1
{ 

//#if -846658167 
Object point =
                Model.getUseCasesFactory().buildExtensionPoint(
                    Model.getFacade().getBase(getTarget()));
//#endif 


//#if -56013476 
Model.getUseCasesHelper().addExtensionPoint(getTarget(), point);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

