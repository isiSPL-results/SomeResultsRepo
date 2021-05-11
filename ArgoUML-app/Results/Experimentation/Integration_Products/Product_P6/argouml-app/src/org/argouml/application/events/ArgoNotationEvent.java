package org.argouml.application.events;
public class ArgoNotationEvent extends ArgoEvent
  { 
public ArgoNotationEvent(int eventType, Object src)
    { 
super(eventType, src);
} 
public int getEventStartRange()
    { 
return ANY_NOTATION_EVENT;
} 

 } 
