
//#if 265729420 
// Compilation Unit of /ButtonActionNewChangeEvent.java 
 

//#if -186626409 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if -1548896578 
import org.argouml.model.Model;
//#endif 


//#if 1631383228 
public class ButtonActionNewChangeEvent extends 
//#if -1497465233 
ButtonActionNewEvent
//#endif 

  { 

//#if -1675404729 
protected String getKeyName()
    { 

//#if 390299682 
return "button.new-changeevent";
//#endif 

} 

//#endif 


//#if 1142370281 
protected String getIconName()
    { 

//#if -1997012174 
return "ChangeEvent";
//#endif 

} 

//#endif 


//#if -1966420357 
protected Object createEvent(Object ns)
    { 

//#if -1747596318 
return Model.getStateMachinesFactory().buildChangeEvent(ns);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

