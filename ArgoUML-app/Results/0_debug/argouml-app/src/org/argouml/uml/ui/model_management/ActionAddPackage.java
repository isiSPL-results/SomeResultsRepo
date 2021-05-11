
//#if 279631174 
// Compilation Unit of /ActionAddPackage.java 
 

//#if 557836023 
package org.argouml.uml.ui.model_management;
//#endif 


//#if -1345758700 
import java.awt.event.ActionEvent;
//#endif 


//#if -1725973622 
import javax.swing.Action;
//#endif 


//#if 130142433 
import org.argouml.i18n.Translator;
//#endif 


//#if -532138969 
import org.argouml.model.Model;
//#endif 


//#if -2030731813 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1477153520 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if 753163461 
class ActionAddPackage extends 
//#if -1195885819 
AbstractActionNewModelElement
//#endif 

  { 

//#if 342685595 
public ActionAddPackage()
    { 

//#if 1800317257 
super("button.new-package");
//#endif 


//#if -313926715 
putValue(Action.NAME, Translator.localize("button.new-package"));
//#endif 

} 

//#endif 


//#if -2083685929 
public void actionPerformed(ActionEvent e)
    { 

//#if -1190153414 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if -1631501617 
if(Model.getFacade().isAPackage(target))//1
{ 

//#if 333551581 
Object newPackage =
                Model.getModelManagementFactory().createPackage();
//#endif 


//#if 1204903467 
Model.getCoreHelper().addOwnedElement(target, newPackage);
//#endif 


//#if 386346602 
TargetManager.getInstance().setTarget(newPackage);
//#endif 


//#if 1100909917 
super.actionPerformed(e);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

