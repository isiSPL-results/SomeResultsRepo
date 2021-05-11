
//#if 262447322 
// Compilation Unit of /ButtonActionNewSignalEvent.java 
 

//#if 1265814652 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if 191127267 
import org.argouml.model.Model;
//#endif 


//#if 1417708287 
public class ButtonActionNewSignalEvent extends 
//#if -1227414467 
ButtonActionNewEvent
//#endif 

  { 

//#if 2049519801 
protected String getKeyName()
    { 

//#if -632745128 
return "button.new-signalevent";
//#endif 

} 

//#endif 


//#if -810936247 
protected Object createEvent(Object ns)
    { 

//#if 445443358 
return Model.getStateMachinesFactory().buildSignalEvent(ns);
//#endif 

} 

//#endif 


//#if 650913719 
protected String getIconName()
    { 

//#if 62591690 
return "SignalEvent";
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

