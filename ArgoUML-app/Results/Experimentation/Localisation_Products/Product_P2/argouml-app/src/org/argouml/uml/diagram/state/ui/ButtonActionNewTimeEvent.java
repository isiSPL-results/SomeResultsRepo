package org.argouml.uml.diagram.state.ui;
import org.argouml.model.Model;
public class ButtonActionNewTimeEvent extends ButtonActionNewEvent
  { 
protected String getKeyName()
    { 
return "button.new-timeevent";
} 
protected Object createEvent(Object ns)
    { 
return Model.getStateMachinesFactory().buildTimeEvent(ns);
} 
protected String getIconName()
    { 
return "TimeEvent";
} 

 } 
