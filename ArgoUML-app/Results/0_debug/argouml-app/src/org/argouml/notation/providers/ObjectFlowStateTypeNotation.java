
//#if -1171449423 
// Compilation Unit of /ObjectFlowStateTypeNotation.java 
 

//#if -1228284059 
package org.argouml.notation.providers;
//#endif 


//#if 32565020 
import org.argouml.model.Model;
//#endif 


//#if -141401823 
import org.argouml.notation.NotationProvider;
//#endif 


//#if 1183375670 
public abstract class ObjectFlowStateTypeNotation extends 
//#if 611874988 
NotationProvider
//#endif 

  { 

//#if -2085918930 
public ObjectFlowStateTypeNotation(Object objectflowstate)
    { 

//#if 1759944935 
if(!Model.getFacade().isAObjectFlowState(objectflowstate))//1
{ 

//#if 188025168 
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

