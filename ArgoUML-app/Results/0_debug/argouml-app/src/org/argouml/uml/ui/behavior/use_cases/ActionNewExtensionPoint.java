
//#if -1019921117 
// Compilation Unit of /ActionNewExtensionPoint.java 
 

//#if -2047627140 
package org.argouml.uml.ui.behavior.use_cases;
//#endif 


//#if -1035092625 
import java.awt.event.ActionEvent;
//#endif 


//#if 907979237 
import javax.swing.Action;
//#endif 


//#if 1170856166 
import org.argouml.i18n.Translator;
//#endif 


//#if 1857488556 
import org.argouml.model.Model;
//#endif 


//#if 1857407798 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -849475029 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if -60757578 
class ActionNewExtensionPoint extends 
//#if 1737337623 
AbstractActionNewModelElement
//#endif 

  { 

//#if -825356594 
private static final long serialVersionUID = 1556105736769814764L;
//#endif 


//#if 1740952975 
public ActionNewExtensionPoint()
    { 

//#if 1084204240 
super("button.new-extension-point");
//#endif 


//#if -1445888316 
putValue(Action.NAME,
                 Translator.localize("button.new-extension-point"));
//#endif 

} 

//#endif 


//#if -223642775 
public void actionPerformed(ActionEvent e)
    { 

//#if 200331415 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 1820002979 
if(Model.getFacade().isAUseCase(target))//1
{ 

//#if -934240947 
TargetManager.getInstance().setTarget(
                Model.getUseCasesFactory().buildExtensionPoint(target));
//#endif 


//#if 117553075 
super.actionPerformed(e);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

