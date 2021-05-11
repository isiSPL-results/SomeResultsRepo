
//#if -1574998049 
// Compilation Unit of /ActionNewUseCaseExtensionPoint.java 
 

//#if -1533281340 
package org.argouml.uml.ui.behavior.use_cases;
//#endif 


//#if -321473353 
import java.awt.event.ActionEvent;
//#endif 


//#if 29004900 
import org.argouml.model.Model;
//#endif 


//#if -1699292301 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if -937622654 
public class ActionNewUseCaseExtensionPoint extends 
//#if 127455692 
AbstractActionNewModelElement
//#endif 

  { 

//#if 966664476 
public static final ActionNewUseCaseExtensionPoint SINGLETON =
        new ActionNewUseCaseExtensionPoint();
//#endif 


//#if -217802530 
protected ActionNewUseCaseExtensionPoint()
    { 

//#if -1455098890 
super();
//#endif 

} 

//#endif 


//#if 2033288158 
public void actionPerformed(ActionEvent e)
    { 

//#if -627871682 
super.actionPerformed(e);
//#endif 


//#if -1800644308 
if(Model.getFacade().isAUseCase(getTarget()))//1
{ 

//#if 477393354 
Model.getUseCasesFactory().buildExtensionPoint(getTarget());
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

