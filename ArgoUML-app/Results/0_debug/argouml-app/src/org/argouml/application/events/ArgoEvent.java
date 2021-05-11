
//#if -799792 
// Compilation Unit of /ArgoEvent.java 
 

//#if -117003257 
package org.argouml.application.events;
//#endif 


//#if -692103539 
import java.util.EventObject;
//#endif 


//#if -490941702 
public abstract class ArgoEvent extends 
//#if 107042552 
EventObject
//#endif 

 implements 
//#if -1119665447 
ArgoEventTypes
//#endif 

  { 

//#if 560945441 
private int eventType = 0;
//#endif 


//#if 1255545772 
public int getEventEndRange()
    { 

//#if 1040740912 
return (getEventStartRange() == 0
                ? ARGO_EVENT_END
                : getEventStartRange() + 99);
//#endif 

} 

//#endif 


//#if -1891807389 
public ArgoEvent(int eT, Object src)
    { 

//#if 652793468 
super(src);
//#endif 


//#if 2058613430 
eventType = eT;
//#endif 

} 

//#endif 


//#if -1756766776 
public String toString()
    { 

//#if -483648155 
return "{" + getClass().getName() + ":" + eventType
               + "(" + getEventStartRange() + "-" + getEventEndRange() + ")"
               + "/" + super.toString() + "}";
//#endif 

} 

//#endif 


//#if -2069241788 
public int getEventType()
    { 

//#if -293013017 
return eventType;
//#endif 

} 

//#endif 


//#if 1701432325 
public int getEventStartRange()
    { 

//#if 435388186 
return ANY_EVENT;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

