package org.argouml.uml.ui.behavior.state_machines;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class ActionNewSignalEvent extends ActionNewEvent
  { 
private static ActionNewSignalEvent singleton = new ActionNewSignalEvent();
protected Object createEvent(Object ns)
    { 
return Model.getStateMachinesFactory().buildSignalEvent(ns);
} 
public static ActionNewSignalEvent getSingleton()
    { 
return singleton;
} 
protected ActionNewSignalEvent()
    { 
super();
putValue(NAME, Translator.localize("button.new-signalevent"));
} 

 } 
