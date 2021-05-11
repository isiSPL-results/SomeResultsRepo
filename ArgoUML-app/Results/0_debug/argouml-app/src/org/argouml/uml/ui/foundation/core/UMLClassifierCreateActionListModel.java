
//#if -1164798191 
// Compilation Unit of /UMLClassifierCreateActionListModel.java 
 

//#if 1406823772 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 325608279 
import org.argouml.model.Model;
//#endif 


//#if 1164174637 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 1698407861 
public class UMLClassifierCreateActionListModel extends 
//#if -607419694 
UMLModelElementListModel2
//#endif 

  { 

//#if 1179607498 
public UMLClassifierCreateActionListModel()
    { 

//#if 1824433550 
super("createAction");
//#endif 

} 

//#endif 


//#if -141245376 
protected void buildModelList()
    { 

//#if -1679712994 
if(getTarget() != null)//1
{ 

//#if -455733019 
setAllElements(Model.getFacade().getCreateActions(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1385354124 
protected boolean isValidElement(Object element)
    { 

//#if 2011092643 
return Model.getFacade().getCreateActions(getTarget())
               .contains(element);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

