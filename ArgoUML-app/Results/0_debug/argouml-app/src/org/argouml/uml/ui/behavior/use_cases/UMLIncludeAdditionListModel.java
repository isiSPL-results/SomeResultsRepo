
//#if 1744401553 
// Compilation Unit of /UMLIncludeAdditionListModel.java 
 

//#if 1791405899 
package org.argouml.uml.ui.behavior.use_cases;
//#endif 


//#if -1462361155 
import org.argouml.model.Model;
//#endif 


//#if 740311152 
public class UMLIncludeAdditionListModel extends 
//#if -1758315351 
UMLIncludeListModel
//#endif 

  { 

//#if -1327560315 
public UMLIncludeAdditionListModel()
    { 

//#if 1563602196 
super("addition");
//#endif 

} 

//#endif 


//#if -249435762 
protected void buildModelList()
    { 

//#if 133882715 
super.buildModelList();
//#endif 


//#if -941404251 
addElement(Model.getFacade().getAddition(getTarget()));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

