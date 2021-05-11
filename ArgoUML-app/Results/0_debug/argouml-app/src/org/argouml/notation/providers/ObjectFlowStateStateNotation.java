
//#if 1207396225 
// Compilation Unit of /ObjectFlowStateStateNotation.java 
 

//#if -394240849 
package org.argouml.notation.providers;
//#endif 


//#if -466203034 
import org.argouml.model.Model;
//#endif 


//#if 1044659947 
import org.argouml.notation.NotationProvider;
//#endif 


//#if -435861233 
public abstract class ObjectFlowStateStateNotation extends 
//#if -259499013 
NotationProvider
//#endif 

  { 

//#if 1365722380 
public ObjectFlowStateStateNotation(Object objectflowstate)
    { 

//#if -687362404 
if(!Model.getFacade().isAObjectFlowState(objectflowstate))//1
{ 

//#if 361896120 
throw new IllegalArgumentException(
                "This is not a ObjectFlowState.");
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

