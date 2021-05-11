
//#if -1269754827 
// Compilation Unit of /AssociationRoleNotation.java 
 

//#if -1486637478 
package org.argouml.notation.providers;
//#endif 


//#if 1715666984 
import java.beans.PropertyChangeListener;
//#endif 


//#if -472415471 
import org.argouml.model.Model;
//#endif 


//#if 1732930646 
import org.argouml.notation.NotationProvider;
//#endif 


//#if -107680924 
public abstract class AssociationRoleNotation extends 
//#if 1419461227 
NotationProvider
//#endif 

  { 

//#if 97646372 
public AssociationRoleNotation(Object role)
    { 

//#if 333623026 
if(!Model.getFacade().isAAssociationRole(role))//1
{ 

//#if -271735417 
throw new IllegalArgumentException(
                "This is not an AssociationRole.");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 362565760 
public void initialiseListener(PropertyChangeListener listener,
                                   Object modelElement)
    { 

//#if 1752637028 
addElementListener(listener, modelElement,
                           new String[] {"name", "base"});
//#endif 


//#if -1829835434 
Object assoc = Model.getFacade().getBase(modelElement);
//#endif 


//#if -1617333316 
if(assoc != null)//1
{ 

//#if -886412057 
addElementListener(listener, assoc, "name");
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

