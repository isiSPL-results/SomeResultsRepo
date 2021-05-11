
//#if -1612389788 
// Compilation Unit of /ActionNewInterface.java 
 

//#if 1822661716 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -2104740116 
import java.awt.event.ActionEvent;
//#endif 


//#if -191303582 
import javax.swing.Action;
//#endif 


//#if -1923444983 
import org.argouml.i18n.Translator;
//#endif 


//#if -184138161 
import org.argouml.model.Model;
//#endif 


//#if -1613518157 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1455658984 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if 1201306289 
class ActionNewInterface extends 
//#if -137005665 
AbstractActionNewModelElement
//#endif 

  { 

//#if -448397291 
public ActionNewInterface()
    { 

//#if -2008414523 
super("button.new-interface");
//#endif 


//#if 2136211527 
putValue(Action.NAME, Translator.localize("button.new-interface"));
//#endif 

} 

//#endif 


//#if -1531069455 
public void actionPerformed(ActionEvent e)
    { 

//#if 1223657748 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if -1176404248 
if(Model.getFacade().isAInterface(target))//1
{ 

//#if 217456898 
Object iface = target;
//#endif 


//#if 469608157 
Object newInterface =
                Model.getCoreFactory().createInterface();
//#endif 


//#if 1702314788 
Model.getCoreHelper().addOwnedElement(
                Model.getFacade().getNamespace(iface),
                newInterface);
//#endif 


//#if -1246225818 
TargetManager.getInstance().setTarget(newInterface);
//#endif 


//#if 1838249652 
super.actionPerformed(e);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

