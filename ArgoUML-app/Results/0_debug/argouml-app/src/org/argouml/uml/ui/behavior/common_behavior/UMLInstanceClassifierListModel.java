
//#if -60467269 
// Compilation Unit of /UMLInstanceClassifierListModel.java 
 

//#if 749896205 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if -100130720 
import org.argouml.model.Model;
//#endif 


//#if 2107627460 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 1057186153 
public class UMLInstanceClassifierListModel extends 
//#if -1081918515 
UMLModelElementListModel2
//#endif 

  { 

//#if 1451329467 
protected void buildModelList()
    { 

//#if 1038104466 
if(getTarget() != null)//1
{ 

//#if -538687785 
setAllElements(Model.getFacade().getClassifiers(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1349830604 
public UMLInstanceClassifierListModel()
    { 

//#if -1464966685 
super("classifier");
//#endif 

} 

//#endif 


//#if -378175396 
protected boolean isValidElement(Object o)
    { 

//#if -2146421466 
return Model.getFacade().isAClassifier(o)
               && Model.getFacade().getClassifiers(getTarget()).contains(o);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

