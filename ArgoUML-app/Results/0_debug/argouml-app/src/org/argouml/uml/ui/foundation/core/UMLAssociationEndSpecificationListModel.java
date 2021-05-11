
//#if 1401752282 
// Compilation Unit of /UMLAssociationEndSpecificationListModel.java 
 

//#if 819182938 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 868958293 
import org.argouml.model.Model;
//#endif 


//#if -78531857 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -551017885 
public class UMLAssociationEndSpecificationListModel extends 
//#if 2041121067 
UMLModelElementListModel2
//#endif 

  { 

//#if 1523794411 
public UMLAssociationEndSpecificationListModel()
    { 

//#if -1287185898 
super("specification");
//#endif 

} 

//#endif 


//#if -1004177895 
protected void buildModelList()
    { 

//#if 963884177 
if(getTarget() != null)//1
{ 

//#if 487923569 
setAllElements(Model.getFacade().getSpecifications(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 830574906 
protected boolean isValidElement(Object o)
    { 

//#if 617232158 
return Model.getFacade().isAClassifier(o)
               && Model.getFacade().getSpecifications(getTarget()).contains(o);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

