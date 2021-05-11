
//#if 19325032 
// Compilation Unit of /ActionNewException.java 
 

//#if 619137363 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if -89390079 
import java.awt.event.ActionEvent;
//#endif 


//#if 1106092663 
import javax.swing.Action;
//#endif 


//#if 422864020 
import org.argouml.i18n.Translator;
//#endif 


//#if -1096378022 
import org.argouml.model.Model;
//#endif 


//#if -1633112632 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 728577853 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if 827835731 
public class ActionNewException extends 
//#if 505679715 
AbstractActionNewModelElement
//#endif 

  { 

//#if -1077063065 
public ActionNewException()
    { 

//#if 252905662 
super("button.new-exception");
//#endif 


//#if -2009779796 
putValue(Action.NAME, Translator.localize("button.new-exception"));
//#endif 

} 

//#endif 


//#if 1870262453 
public void actionPerformed(ActionEvent e)
    { 

//#if -751481819 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if -1890822709 
Object ns = null;
//#endif 


//#if -905979559 
if(Model.getFacade().isANamespace(target))//1
{ 

//#if 4862027 
ns = target;
//#endif 

} 
else
{ 

//#if 204147318 
ns = Model.getFacade().getNamespace(target);
//#endif 

} 

//#endif 


//#if 1070222790 
Object newElement = Model.getCommonBehaviorFactory().createException();
//#endif 


//#if -507486697 
Model.getCoreHelper().setNamespace(newElement, ns);
//#endif 


//#if -1302767193 
TargetManager.getInstance().setTarget(newElement);
//#endif 


//#if 470586742 
super.actionPerformed(e);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

