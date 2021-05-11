
//#if 258484777 
// Compilation Unit of /ActionNewTimeEvent.java 
 

//#if -1989223938 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 2039560271 
import org.argouml.i18n.Translator;
//#endif 


//#if 216040085 
import org.argouml.model.Model;
//#endif 


//#if 509632566 
public class ActionNewTimeEvent extends 
//#if -214016050 
ActionNewEvent
//#endif 

  { 

//#if 944981407 
private static ActionNewTimeEvent singleton = new ActionNewTimeEvent();
//#endif 


//#if 175944492 
protected Object createEvent(Object ns)
    { 

//#if 642562788 
return Model.getStateMachinesFactory().buildTimeEvent(ns);
//#endif 

} 

//#endif 


//#if -921132492 
protected ActionNewTimeEvent()
    { 

//#if 249109431 
super();
//#endif 


//#if -609241823 
putValue(NAME, Translator.localize("button.new-timeevent"));
//#endif 

} 

//#endif 


//#if -689318034 
public static ActionNewTimeEvent getSingleton()
    { 

//#if 611680555 
return singleton;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

