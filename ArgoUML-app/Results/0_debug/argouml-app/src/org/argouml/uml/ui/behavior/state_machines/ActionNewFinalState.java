
//#if -910637154 
// Compilation Unit of /ActionNewFinalState.java 
 

//#if -1188802877 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 2088583553 
import java.awt.event.ActionEvent;
//#endif 


//#if 563372023 
import javax.swing.Action;
//#endif 


//#if -779430124 
import org.argouml.i18n.Translator;
//#endif 


//#if 354044890 
import org.argouml.model.Model;
//#endif 


//#if -187738947 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if 785377975 
public class ActionNewFinalState extends 
//#if -1628762109 
AbstractActionNewModelElement
//#endif 

  { 

//#if -1082178633 
private static ActionNewFinalState singleton = new ActionNewFinalState();
//#endif 


//#if 1796507312 
protected ActionNewFinalState()
    { 

//#if -1471259123 
super();
//#endif 


//#if 818432039 
putValue(Action.NAME, Translator.localize("button.new-finalstate"));
//#endif 

} 

//#endif 


//#if -227497643 
public void actionPerformed(ActionEvent e)
    { 

//#if 1915535332 
super.actionPerformed(e);
//#endif 


//#if 91466570 
Model.getStateMachinesFactory().buildFinalState(getTarget());
//#endif 

} 

//#endif 


//#if -1882385460 
public static ActionNewFinalState getSingleton()
    { 

//#if 1818439376 
return singleton;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

