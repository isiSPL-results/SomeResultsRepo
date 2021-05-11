
//#if 1874701917 
// Compilation Unit of /ButtonActionNewCallEvent.java 
 

//#if -159284259 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if 483240836 
import org.argouml.model.Model;
//#endif 


//#if 501248072 
public class ButtonActionNewCallEvent extends 
//#if 603954989 
ButtonActionNewEvent
//#endif 

  { 

//#if 578652105 
protected String getKeyName()
    { 

//#if -2079485611 
return "button.new-callevent";
//#endif 

} 

//#endif 


//#if 2145301305 
protected Object createEvent(Object ns)
    { 

//#if 52526607 
return Model.getStateMachinesFactory().buildCallEvent(ns);
//#endif 

} 

//#endif 


//#if -1996311897 
protected String getIconName()
    { 

//#if 1292457423 
return "CallEvent";
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

