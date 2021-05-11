// Compilation Unit of /ArgoHelpEvent.java 
 
package org.argouml.application.events;
public class ArgoHelpEvent extends ArgoEvent
  { 
private String helpText;
public ArgoHelpEvent(int eventType, Object src, String message)
    { 
super(eventType, src);
helpText = message;
} 

public String getHelpText()
    { 
return helpText;
} 

@Override
    public int getEventStartRange()
    { 
return ANY_HELP_EVENT;
} 

 } 


