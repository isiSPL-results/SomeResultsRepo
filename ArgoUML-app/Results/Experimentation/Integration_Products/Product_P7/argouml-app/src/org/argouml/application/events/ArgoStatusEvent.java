package org.argouml.application.events;
public class ArgoStatusEvent extends ArgoEvent
  { 
private String text;
public ArgoStatusEvent(int eventType, Object src, String message)
    { 
super(eventType, src);
text = message;
} 
@Override
    public int getEventStartRange()
    { 
return ANY_STATUS_EVENT;
} 
public String getText()
    { 
return text;
} 

 } 
