
//#if 218029185 
// Compilation Unit of /ComponentInstanceNotation.java 
 

//#if 864257874 
package org.argouml.notation.providers;
//#endif 


//#if -361509879 
import org.argouml.model.Model;
//#endif 


//#if 1868014414 
import org.argouml.notation.NotationProvider;
//#endif 


//#if -341296969 
public abstract class ComponentInstanceNotation extends 
//#if -1782681565 
NotationProvider
//#endif 

  { 

//#if 1174455651 
public ComponentInstanceNotation(Object componentInstance)
    { 

//#if -335027185 
if(!Model.getFacade().isAComponentInstance(componentInstance))//1
{ 

//#if 1215896627 
throw new IllegalArgumentException(
                "This is not a ComponentInstance.");
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

