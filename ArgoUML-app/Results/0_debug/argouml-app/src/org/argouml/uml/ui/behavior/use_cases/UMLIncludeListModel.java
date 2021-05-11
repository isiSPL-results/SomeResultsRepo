
//#if 1958533394 
// Compilation Unit of /UMLIncludeListModel.java 
 

//#if 385937035 
package org.argouml.uml.ui.behavior.use_cases;
//#endif 


//#if 1204636797 
import org.argouml.model.Model;
//#endif 


//#if 640962503 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -2129942802 
public abstract class UMLIncludeListModel extends 
//#if -569474472 
UMLModelElementListModel2
//#endif 

  { 

//#if -280285958 
protected boolean isValidElement(Object element)
    { 

//#if 212991810 
return Model.getFacade().isAUseCase(element);
//#endif 

} 

//#endif 


//#if 1987016005 
public UMLIncludeListModel(String eventName)
    { 

//#if 1376773125 
super(eventName);
//#endif 


//#if 42297682 
Model.getPump().addClassModelEventListener(this,
                Model.getMetaTypes().getNamespace(), "ownedElement");
//#endif 

} 

//#endif 


//#if 429953222 
protected void buildModelList()
    { 

//#if 468842103 
if(!isEmpty())//1
{ 

//#if 1185273207 
removeAllElements();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

