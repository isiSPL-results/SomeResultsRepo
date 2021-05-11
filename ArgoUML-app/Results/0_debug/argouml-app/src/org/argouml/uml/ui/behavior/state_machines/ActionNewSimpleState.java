
//#if -1142859560 
// Compilation Unit of /ActionNewSimpleState.java 
 

//#if -502998240 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 760322948 
import java.awt.event.ActionEvent;
//#endif 


//#if 1073245434 
import javax.swing.Action;
//#endif 


//#if 994164081 
import org.argouml.i18n.Translator;
//#endif 


//#if -1990924105 
import org.argouml.model.Model;
//#endif 


//#if -585565568 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if -323009978 
public class ActionNewSimpleState extends 
//#if 766217459 
AbstractActionNewModelElement
//#endif 

  { 

//#if -875892555 
private static ActionNewSimpleState singleton = new ActionNewSimpleState();
//#endif 


//#if 1269900028 
protected ActionNewSimpleState()
    { 

//#if 1174530904 
super();
//#endif 


//#if -1275603344 
putValue(Action.NAME, Translator.localize("button.new-simplestate"));
//#endif 

} 

//#endif 


//#if -297627638 
public static ActionNewSimpleState getSingleton()
    { 

//#if -11390765 
return singleton;
//#endif 

} 

//#endif 


//#if 1848490565 
public void actionPerformed(ActionEvent e)
    { 

//#if -198715613 
super.actionPerformed(e);
//#endif 


//#if 38082901 
Model.getStateMachinesFactory().buildSimpleState(getTarget());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

