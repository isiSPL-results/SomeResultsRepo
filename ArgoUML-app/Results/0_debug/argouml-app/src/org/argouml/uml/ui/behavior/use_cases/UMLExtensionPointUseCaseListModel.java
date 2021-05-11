
//#if 608525213 
// Compilation Unit of /UMLExtensionPointUseCaseListModel.java 
 

//#if -1950689771 
package org.argouml.uml.ui.behavior.use_cases;
//#endif 


//#if -1734966733 
import org.argouml.model.Model;
//#endif 


//#if -1346312239 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 1144526884 
public class UMLExtensionPointUseCaseListModel extends 
//#if 2035636371 
UMLModelElementListModel2
//#endif 

  { 

//#if 1825296769 
protected void buildModelList()
    { 

//#if -917809817 
addElement(Model.getFacade().getUseCase(getTarget()));
//#endif 

} 

//#endif 


//#if -1961178462 
protected boolean isValidElement(Object o)
    { 

//#if 625645866 
return Model.getFacade().isAUseCase(o)
               && Model.getFacade().getUseCase(getTarget()) == o;
//#endif 

} 

//#endif 


//#if 668616246 
public UMLExtensionPointUseCaseListModel()
    { 

//#if 1933047933 
super("useCase");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

