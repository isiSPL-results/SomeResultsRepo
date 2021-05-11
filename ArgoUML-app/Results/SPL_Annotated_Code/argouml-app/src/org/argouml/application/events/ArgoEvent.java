// Compilation Unit of /ArgoEvent.java 
 
package org.argouml.application.events;
import java.util.EventObject;
public abstract class ArgoEvent extends EventObject
 implements ArgoEventTypes
  { 
private int eventType = 0;
public int getEventEndRange()
    { 
return (getEventStartRange() == 0
                ? ARGO_EVENT_END
                : getEventStartRange() + 99);
} 

public ArgoEvent(int eT, Object src)
    { 
super(src);
eventType = eT;
} 

public String toString()
    { 
return "{" + getClass().getName() + ":" + eventType
               + "(" + getEventStartRange() + "-" + getEventEndRange() + ")"
               + "/" + super.toString() + "}";
} 

public int getEventType()
    { 
return eventType;
} 

public int getEventStartRange()
    { 
return ANY_EVENT;
} 

 } 


