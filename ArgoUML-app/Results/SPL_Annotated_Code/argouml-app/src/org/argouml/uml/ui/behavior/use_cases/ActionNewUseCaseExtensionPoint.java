// Compilation Unit of /ActionNewUseCaseExtensionPoint.java 
 
package org.argouml.uml.ui.behavior.use_cases;
import java.awt.event.ActionEvent;
import org.argouml.model.Model;
import org.argouml.uml.ui.AbstractActionNewModelElement;
public class ActionNewUseCaseExtensionPoint extends AbstractActionNewModelElement
  { 
public static final ActionNewUseCaseExtensionPoint SINGLETON =
        new ActionNewUseCaseExtensionPoint();
protected ActionNewUseCaseExtensionPoint()
    { 
super();
} 

public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
if(Model.getFacade().isAUseCase(getTarget()))//1
{ 
Model.getUseCasesFactory().buildExtensionPoint(getTarget());
} 

} 

 } 


