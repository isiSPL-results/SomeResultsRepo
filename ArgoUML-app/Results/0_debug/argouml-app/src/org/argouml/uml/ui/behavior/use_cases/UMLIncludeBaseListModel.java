
//#if -1514863997 
// Compilation Unit of /UMLIncludeBaseListModel.java 
 

//#if 529995129 
package org.argouml.uml.ui.behavior.use_cases;
//#endif 


//#if -887625905 
import org.argouml.model.Model;
//#endif 


//#if -1483884723 
public class UMLIncludeBaseListModel extends 
//#if -155265784 
UMLIncludeListModel
//#endif 

  { 

//#if 1554962221 
protected void buildModelList()
    { 

//#if 927596916 
super.buildModelList();
//#endif 


//#if -1559138103 
addElement(Model.getFacade().getBase(getTarget()));
//#endif 

} 

//#endif 


//#if -1426318609 
public UMLIncludeBaseListModel()
    { 

//#if 2126300867 
super("base");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

