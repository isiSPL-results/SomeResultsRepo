// Compilation Unit of /ButtonActionNewSignalEvent.java 
 
package org.argouml.uml.diagram.state.ui;
import org.argouml.model.Model;
public class ButtonActionNewSignalEvent extends ButtonActionNewEvent
  { 
protected String getKeyName()
    { 
return "button.new-signalevent";
} 

protected Object createEvent(Object ns)
    { 
return Model.getStateMachinesFactory().buildSignalEvent(ns);
} 

protected String getIconName()
    { 
return "SignalEvent";
} 

 } 


