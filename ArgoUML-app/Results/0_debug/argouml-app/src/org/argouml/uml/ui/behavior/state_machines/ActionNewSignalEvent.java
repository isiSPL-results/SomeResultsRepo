
//#if 1779918384 
// Compilation Unit of /ActionNewSignalEvent.java 
 

//#if -1096827559 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -1989004886 
import org.argouml.i18n.Translator;
//#endif 


//#if 953311600 
import org.argouml.model.Model;
//#endif 


//#if -1461912704 
public class ActionNewSignalEvent extends 
//#if -1544302596 
ActionNewEvent
//#endif 

  { 

//#if 230205009 
private static ActionNewSignalEvent singleton = new ActionNewSignalEvent();
//#endif 


//#if 493333722 
protected Object createEvent(Object ns)
    { 

//#if -707227682 
return Model.getStateMachinesFactory().buildSignalEvent(ns);
//#endif 

} 

//#endif 


//#if 1744589089 
public static ActionNewSignalEvent getSingleton()
    { 

//#if 793913282 
return singleton;
//#endif 

} 

//#endif 


//#if -31774197 
protected ActionNewSignalEvent()
    { 

//#if -1777630854 
super();
//#endif 


//#if 532994819 
putValue(NAME, Translator.localize("button.new-signalevent"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

