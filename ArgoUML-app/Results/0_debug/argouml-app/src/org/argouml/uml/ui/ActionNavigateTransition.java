
//#if 149862300 
// Compilation Unit of /ActionNavigateTransition.java 
 

//#if 870146847 
package org.argouml.uml.ui;
//#endif 


//#if 1009939214 
import org.argouml.model.Model;
//#endif 


//#if 520885302 
public class ActionNavigateTransition extends 
//#if 1849275772 
AbstractActionNavigate
//#endif 

  { 

//#if 1770906093 
protected Object navigateTo(Object source)
    { 

//#if 2057199177 
return Model.getFacade().getTransition(source);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

