
//#if -1035247520 
// Compilation Unit of /ArgoHelpEvent.java 
 

//#if 1576710989 
package org.argouml.application.events;
//#endif 


//#if -1962045091 
public class ArgoHelpEvent extends 
//#if 1395459929 
ArgoEvent
//#endif 

  { 

//#if 155313601 
private String helpText;
//#endif 


//#if 967919976 
public ArgoHelpEvent(int eventType, Object src, String message)
    { 

//#if 2085209909 
super(eventType, src);
//#endif 


//#if 626254215 
helpText = message;
//#endif 

} 

//#endif 


//#if -1920410077 
public String getHelpText()
    { 

//#if -635155442 
return helpText;
//#endif 

} 

//#endif 


//#if -605716158 
@Override
    public int getEventStartRange()
    { 

//#if 653675172 
return ANY_HELP_EVENT;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

