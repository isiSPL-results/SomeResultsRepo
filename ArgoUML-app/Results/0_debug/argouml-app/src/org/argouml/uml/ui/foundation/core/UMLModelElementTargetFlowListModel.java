
//#if 3648798 
// Compilation Unit of /UMLModelElementTargetFlowListModel.java 
 

//#if 847350829 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -1456311384 
import org.argouml.model.Model;
//#endif 


//#if -36445828 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1877663515 
public class UMLModelElementTargetFlowListModel extends 
//#if -532471116 
UMLModelElementListModel2
//#endif 

  { 

//#if 362427785 
public UMLModelElementTargetFlowListModel()
    { 

//#if -101391954 
super("targetFlow");
//#endif 

} 

//#endif 


//#if -1248484574 
protected void buildModelList()
    { 

//#if -671719759 
if(getTarget() != null)//1
{ 

//#if -338067665 
setAllElements(Model.getFacade().getTargetFlows(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2040019197 
protected boolean isValidElement(Object o)
    { 

//#if 2042733068 
return Model.getFacade().isAFlow(o)
               && Model.getFacade().getTargetFlows(getTarget()).contains(o);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

