
//#if -835578265 
// Compilation Unit of /UMLModelElementSourceFlowListModel.java 
 

//#if 1423505734 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -264634815 
import org.argouml.model.Model;
//#endif 


//#if -1380769661 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1848481054 
public class UMLModelElementSourceFlowListModel extends 
//#if -1557530796 
UMLModelElementListModel2
//#endif 

  { 

//#if 468583331 
protected boolean isValidElement(Object o)
    { 

//#if 974954869 
return Model.getFacade().isAFlow(o)
               && Model.getFacade().getSourceFlows(getTarget()).contains(o);
//#endif 

} 

//#endif 


//#if 1237395394 
protected void buildModelList()
    { 

//#if 1769699807 
if(getTarget() != null)//1
{ 

//#if -342641942 
setAllElements(Model.getFacade().getSourceFlows(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 109582623 
public UMLModelElementSourceFlowListModel()
    { 

//#if -1010200068 
super("sourceFlow");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

