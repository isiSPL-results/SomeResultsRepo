
//#if -299895056 
// Compilation Unit of /UMLDependencyClientListModel.java 
 

//#if -1061708512 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -723773157 
import org.argouml.model.Model;
//#endif 


//#if -2061094423 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1817773650 
public class UMLDependencyClientListModel extends 
//#if -811542186 
UMLModelElementListModel2
//#endif 

  { 

//#if -392965693 
public UMLDependencyClientListModel()
    { 

//#if -1426005217 
super("client");
//#endif 

} 

//#endif 


//#if -1452787163 
protected boolean isValidElement(Object o)
    { 

//#if 1461822361 
return Model.getFacade().isAModelElement(o)
               && Model.getFacade().getClients(getTarget()).contains(o);
//#endif 

} 

//#endif 


//#if -1139590972 
protected void buildModelList()
    { 

//#if 464027997 
if(getTarget() != null)//1
{ 

//#if 915880014 
setAllElements(Model.getFacade().getClients(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

