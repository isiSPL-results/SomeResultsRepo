
//#if 532444553 
// Compilation Unit of /ActionNewUseCase.java 
 

//#if 700637404 
package org.argouml.uml.ui.behavior.use_cases;
//#endif 


//#if 35290575 
import java.awt.event.ActionEvent;
//#endif 


//#if 1096927813 
import javax.swing.Action;
//#endif 


//#if -7003002 
import org.argouml.i18n.Translator;
//#endif 


//#if 876159564 
import org.argouml.model.Model;
//#endif 


//#if 1018547094 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -239844725 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if 267938729 
public class ActionNewUseCase extends 
//#if -173000152 
AbstractActionNewModelElement
//#endif 

  { 

//#if 1633102138 
public void actionPerformed(ActionEvent e)
    { 

//#if 1810753972 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if -971736282 
if(Model.getFacade().isAUseCase(target))//1
{ 

//#if 1582287825 
Object ns = Model.getFacade().getNamespace(target);
//#endif 


//#if 211079637 
if(ns != null)//1
{ 

//#if 790091784 
Object useCase = Model.getUseCasesFactory()
                                 .createUseCase();
//#endif 


//#if -1359331805 
Model.getCoreHelper().addOwnedElement(ns, useCase);
//#endif 


//#if -1063973058 
TargetManager.getInstance().setTarget(useCase);
//#endif 


//#if -2047154684 
super.actionPerformed(e);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -239226550 
public ActionNewUseCase()
    { 

//#if -2117023361 
super("button.new-usecase");
//#endif 


//#if 743102333 
putValue(Action.NAME, Translator.localize("button.new-usecase"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

