// Compilation Unit of /ActionNewTimeEvent.java 
 
package org.argouml.uml.ui.behavior.state_machines;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class ActionNewTimeEvent extends ActionNewEvent
  { 
private static ActionNewTimeEvent singleton = new ActionNewTimeEvent();
protected Object createEvent(Object ns)
    { 
return Model.getStateMachinesFactory().buildTimeEvent(ns);
} 

protected ActionNewTimeEvent()
    { 
super();
putValue(NAME, Translator.localize("button.new-timeevent"));
} 

public static ActionNewTimeEvent getSingleton()
    { 
return singleton;
} 

 } 


