
//#if 1819151839 
// Compilation Unit of /ActionNewChangeEvent.java 
 

//#if -1790488702 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 594359763 
import org.argouml.i18n.Translator;
//#endif 


//#if 1010819609 
import org.argouml.model.Model;
//#endif 


//#if -2006724625 
public class ActionNewChangeEvent extends 
//#if -488036639 
ActionNewEvent
//#endif 

  { 

//#if -1597476148 
private static ActionNewChangeEvent singleton = new ActionNewChangeEvent();
//#endif 


//#if -177210434 
protected ActionNewChangeEvent()
    { 

//#if 1644368529 
super();
//#endif 


//#if 68275780 
putValue(NAME, Translator.localize("button.new-changeevent"));
//#endif 

} 

//#endif 


//#if -1904829953 
protected Object createEvent(Object ns)
    { 

//#if -1382157151 
return Model.getStateMachinesFactory().buildChangeEvent(ns);
//#endif 

} 

//#endif 


//#if -1743928834 
public static ActionNewChangeEvent getSingleton()
    { 

//#if -1301105892 
return singleton;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

