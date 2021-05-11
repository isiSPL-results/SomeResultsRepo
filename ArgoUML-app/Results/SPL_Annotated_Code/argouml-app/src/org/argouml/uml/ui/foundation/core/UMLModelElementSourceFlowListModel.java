// Compilation Unit of /UMLModelElementSourceFlowListModel.java 
 
package org.argouml.uml.ui.foundation.core;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLModelElementSourceFlowListModel extends UMLModelElementListModel2
  { 
protected boolean isValidElement(Object o)
    { 
return Model.getFacade().isAFlow(o)
               && Model.getFacade().getSourceFlows(getTarget()).contains(o);
} 

protected void buildModelList()
    { 
if(getTarget() != null)//1
{ 
setAllElements(Model.getFacade().getSourceFlows(getTarget()));
} 

} 

public UMLModelElementSourceFlowListModel()
    { 
super("sourceFlow");
} 

 } 


