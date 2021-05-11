package org.argouml.application.events;
public class ArgoGeneratorEvent extends ArgoEvent
  { 
public ArgoGeneratorEvent(int eventType, Object src)
    { 
super(eventType, src);
} 
public int getEventStartRange()
    { 
return ANY_GENERATOR_EVENT;
} 

 } 
