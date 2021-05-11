
//#if -889587405 
// Compilation Unit of /ButtonActionNewTimeEvent.java 
 

//#if 230492323 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if 431837130 
import org.argouml.model.Model;
//#endif 


//#if 1897110707 
public class ButtonActionNewTimeEvent extends 
//#if -1166737963 
ButtonActionNewEvent
//#endif 

  { 

//#if 682089505 
protected String getKeyName()
    { 

//#if 1584603010 
return "button.new-timeevent";
//#endif 

} 

//#endif 


//#if -615398943 
protected Object createEvent(Object ns)
    { 

//#if 1745657389 
return Model.getStateMachinesFactory().buildTimeEvent(ns);
//#endif 

} 

//#endif 


//#if 1210247503 
protected String getIconName()
    { 

//#if 31421234 
return "TimeEvent";
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

