
//#if 1763555943 
// Compilation Unit of /UMLConstraintConstrainedElementListModel.java 
 

//#if 1900588868 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 838615359 
import org.argouml.model.Model;
//#endif 


//#if 1811761221 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 1358067101 
public class UMLConstraintConstrainedElementListModel extends 
//#if -271019256 
UMLModelElementListModel2
//#endif 

  { 

//#if 563267958 
protected void buildModelList()
    { 

//#if 2111148250 
if(getTarget() != null)//1
{ 

//#if 754823670 
setAllElements(Model.getFacade()
                           .getConstrainedElements(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1374248612 
public UMLConstraintConstrainedElementListModel()
    { 

//#if 1345400710 
super("constrainedElement");
//#endif 

} 

//#endif 


//#if 1888880042 
protected boolean isValidElement(Object element)
    { 

//#if -1549813218 
return Model.getFacade().isAModelElement(element)
               && Model.getFacade().getConstrainedElements(getTarget())
               .contains(element);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

