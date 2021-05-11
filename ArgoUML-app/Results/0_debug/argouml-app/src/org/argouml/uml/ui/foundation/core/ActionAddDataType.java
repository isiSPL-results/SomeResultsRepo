
//#if 270685377 
// Compilation Unit of /ActionAddDataType.java 
 

//#if 610788137 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1960180855 
import java.awt.event.ActionEvent;
//#endif 


//#if 1597665517 
import javax.swing.Action;
//#endif 


//#if -464946466 
import org.argouml.i18n.Translator;
//#endif 


//#if 1619420324 
import org.argouml.model.Model;
//#endif 


//#if 1680800318 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -265694413 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if 639220811 
public class ActionAddDataType extends 
//#if -1701258473 
AbstractActionNewModelElement
//#endif 

  { 

//#if -176510103 
public void actionPerformed(ActionEvent e)
    { 

//#if -81045251 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 449201827 
Object ns = null;
//#endif 


//#if 872271233 
if(Model.getFacade().isANamespace(target))//1
{ 

//#if -921681834 
ns = target;
//#endif 

} 

//#endif 


//#if 900212431 
if(Model.getFacade().isAParameter(target))//1

//#if 1209655219 
if(Model.getFacade().getBehavioralFeature(target) != null)//1
{ 

//#if -112817635 
target = Model.getFacade().getBehavioralFeature(target);
//#endif 

} 

//#endif 


//#endif 


//#if 90041884 
if(Model.getFacade().isAFeature(target))//1

//#if 259538503 
if(Model.getFacade().getOwner(target) != null)//1
{ 

//#if -288219795 
target = Model.getFacade().getOwner(target);
//#endif 

} 

//#endif 


//#endif 


//#if -1002439872 
if(Model.getFacade().isAEvent(target))//1
{ 

//#if 23946094 
ns = Model.getFacade().getNamespace(target);
//#endif 

} 

//#endif 


//#if -754097173 
if(Model.getFacade().isAClassifier(target))//1
{ 

//#if -223806589 
ns = Model.getFacade().getNamespace(target);
//#endif 

} 

//#endif 


//#if -1836299292 
if(Model.getFacade().isAAssociationEnd(target))//1
{ 

//#if -408890399 
target = Model.getFacade().getAssociation(target);
//#endif 


//#if -1734766149 
ns = Model.getFacade().getNamespace(target);
//#endif 

} 

//#endif 


//#if 1801705326 
Object newDt = Model.getCoreFactory().buildDataType("", ns);
//#endif 


//#if -1703512623 
TargetManager.getInstance().setTarget(newDt);
//#endif 


//#if -471847522 
super.actionPerformed(e);
//#endif 

} 

//#endif 


//#if -120431165 
public ActionAddDataType()
    { 

//#if -198358208 
super("button.new-datatype");
//#endif 


//#if 1511917058 
putValue(Action.NAME, Translator.localize("button.new-datatype"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

