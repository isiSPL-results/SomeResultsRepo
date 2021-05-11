
//#if 545894404 
// Compilation Unit of /NodeInstanceNotation.java 
 

//#if 1268360925 
package org.argouml.notation.providers;
//#endif 


//#if -1847875948 
import org.argouml.model.Model;
//#endif 


//#if 958181017 
import org.argouml.notation.NotationProvider;
//#endif 


//#if 1125518315 
public abstract class NodeInstanceNotation extends 
//#if -669749935 
NotationProvider
//#endif 

  { 

//#if -848764501 
public NodeInstanceNotation(Object nodeInstance)
    { 

//#if -1727920186 
if(!Model.getFacade().isANodeInstance(nodeInstance))//1
{ 

//#if 768044899 
throw new IllegalArgumentException("This is not a NodeInstance.");
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

