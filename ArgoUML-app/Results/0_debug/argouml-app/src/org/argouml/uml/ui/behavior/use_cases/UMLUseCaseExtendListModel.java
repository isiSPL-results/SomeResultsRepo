
//#if -325410709 
// Compilation Unit of /UMLUseCaseExtendListModel.java 
 

//#if -477464199 
package org.argouml.uml.ui.behavior.use_cases;
//#endif 


//#if 1934164815 
import org.argouml.model.Model;
//#endif 


//#if -235311051 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 268538837 
public class UMLUseCaseExtendListModel extends 
//#if 1571551864 
UMLModelElementListModel2
//#endif 

  { 

//#if 528808166 
protected void buildModelList()
    { 

//#if 114988877 
setAllElements(Model.getFacade().getExtends(getTarget()));
//#endif 

} 

//#endif 


//#if -1579515280 
public UMLUseCaseExtendListModel()
    { 

//#if 1249272099 
super("extend");
//#endif 

} 

//#endif 


//#if -2146846777 
protected boolean isValidElement(Object o)
    { 

//#if -495025987 
return Model.getFacade().getExtends(getTarget()).contains(o);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

