
//#if -1684354746 
// Compilation Unit of /UMLSignalContextListModel.java 
 

//#if -1288380065 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 349999566 
import org.argouml.model.Model;
//#endif 


//#if 69351190 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1860295362 
public class UMLSignalContextListModel extends 
//#if -511468001 
UMLModelElementListModel2
//#endif 

  { 

//#if -503025395 
protected void buildModelList()
    { 

//#if 474992363 
if(getTarget() != null)//1
{ 

//#if -2030435079 
setAllElements(Model.getFacade().getContexts(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1948830401 
public UMLSignalContextListModel()
    { 

//#if -1102587674 
super("context");
//#endif 

} 

//#endif 


//#if -1827954879 
protected boolean isValidElement(Object element)
    { 

//#if 340964082 
return Model.getFacade().isABehavioralFeature(element)
               && Model.getFacade().getContexts(getTarget()).contains(
                   element);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

