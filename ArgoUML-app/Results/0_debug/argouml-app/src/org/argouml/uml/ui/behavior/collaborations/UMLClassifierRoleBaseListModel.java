
//#if -1896859620 
// Compilation Unit of /UMLClassifierRoleBaseListModel.java 
 

//#if -1052474185 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if -1699822302 
import org.argouml.model.Model;
//#endif 


//#if 2107580482 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -645490027 
public class UMLClassifierRoleBaseListModel extends 
//#if -1227926022 
UMLModelElementListModel2
//#endif 

  { 

//#if 1227311595 
protected boolean isValidElement(Object elem)
    { 

//#if -172334885 
return Model.getFacade().isAClassifier(elem)
               && Model.getFacade().getBases(getTarget()).contains(elem);
//#endif 

} 

//#endif 


//#if 950715240 
protected void buildModelList()
    { 

//#if 202831340 
setAllElements(Model.getFacade().getBases(getTarget()));
//#endif 

} 

//#endif 


//#if 2036487789 
public UMLClassifierRoleBaseListModel()
    { 

//#if -1292101837 
super("base");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

