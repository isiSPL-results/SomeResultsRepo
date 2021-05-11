package org.argouml.application.events;
public class ArgoProfileEvent extends ArgoEvent
  { 
public ArgoProfileEvent(int eT, Object src)
    { 
super(eT, src);
} 
public int getEventStartRange()
    { 
return ANY_PROFILE_EVENT;
} 

 } 
