
//#if 1195965371 
// Compilation Unit of /ExtensionPointNotation.java 
 

//#if -1182030541 
package org.argouml.notation.providers;
//#endif 


//#if 2059688682 
import org.argouml.model.Model;
//#endif 


//#if -495971217 
import org.argouml.notation.NotationProvider;
//#endif 


//#if 34882351 
public abstract class ExtensionPointNotation extends 
//#if 799124849 
NotationProvider
//#endif 

  { 

//#if 1297506097 
public ExtensionPointNotation(Object ep)
    { 

//#if -1903438448 
if(!Model.getFacade().isAExtensionPoint(ep))//1
{ 

//#if -158562579 
throw new IllegalArgumentException(
                "This is not an ExtensionPoint.");
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

