
//#if -949363568 
// Compilation Unit of /ActionNewCallEvent.java 
 

//#if 855361850 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 133963659 
import org.argouml.i18n.Translator;
//#endif 


//#if -1602721839 
import org.argouml.model.Model;
//#endif 


//#if -1185952119 
public class ActionNewCallEvent extends 
//#if -94923875 
ActionNewEvent
//#endif 

  { 

//#if 1842574160 
private static ActionNewCallEvent singleton = new ActionNewCallEvent();
//#endif 


//#if -1100097068 
protected ActionNewCallEvent()
    { 

//#if 1233421851 
super();
//#endif 


//#if 478749644 
putValue(NAME, Translator.localize("button.new-callevent"));
//#endif 

} 

//#endif 


//#if -1682138164 
public static ActionNewCallEvent getSingleton()
    { 

//#if -2079209741 
return singleton;
//#endif 

} 

//#endif 


//#if -1468493381 
protected Object createEvent(Object ns)
    { 

//#if 1782226343 
return Model.getStateMachinesFactory().buildCallEvent(ns);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

