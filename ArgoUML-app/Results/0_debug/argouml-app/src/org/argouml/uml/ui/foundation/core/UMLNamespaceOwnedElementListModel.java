
//#if 1973519108 
// Compilation Unit of /UMLNamespaceOwnedElementListModel.java 
 

//#if -1819435362 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -679876711 
import org.argouml.model.Model;
//#endif 


//#if 145161771 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 352565886 
public class UMLNamespaceOwnedElementListModel extends 
//#if -1901799076 
UMLModelElementListModel2
//#endif 

  { 

//#if -1899122829 
public UMLNamespaceOwnedElementListModel()
    { 

//#if -694238442 
super("ownedElement");
//#endif 

} 

//#endif 


//#if 1500235210 
protected void buildModelList()
    { 

//#if -1506937398 
if(getTarget() != null)//1
{ 

//#if -1761854635 
setAllElements(Model.getFacade().getOwnedElements(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1498162690 
protected boolean isValidElement(Object element)
    { 

//#if -1538035883 
return Model.getFacade().getOwnedElements(getTarget())
               .contains(element);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

