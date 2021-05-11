
//#if 549325192 
// Compilation Unit of /ArgoStatusEvent.java 
 

//#if 2102457999 
package org.argouml.application.events;
//#endif 


//#if 456170638 
public class ArgoStatusEvent extends 
//#if 1385643963 
ArgoEvent
//#endif 

  { 

//#if -1327078304 
private String text;
//#endif 


//#if -1256203655 
public ArgoStatusEvent(int eventType, Object src, String message)
    { 

//#if 936119878 
super(eventType, src);
//#endif 


//#if -1425065639 
text = message;
//#endif 

} 

//#endif 


//#if 1415576608 
@Override
    public int getEventStartRange()
    { 

//#if 1534504993 
return ANY_STATUS_EVENT;
//#endif 

} 

//#endif 


//#if -1465551132 
public String getText()
    { 

//#if -443010111 
return text;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

