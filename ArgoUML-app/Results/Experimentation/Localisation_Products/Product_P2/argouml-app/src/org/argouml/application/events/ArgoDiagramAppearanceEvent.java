package org.argouml.application.events;
public class ArgoDiagramAppearanceEvent extends ArgoEvent
  { 
public ArgoDiagramAppearanceEvent(int eventType, Object src)
    { 
super(eventType, src);
} 
public int getEventStartRange()
    { 
return ANY_DIAGRAM_APPEARANCE_EVENT;
} 

 } 
