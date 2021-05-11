// Compilation Unit of /UMLConstraintConstrainedElementListModel.java 
 
package org.argouml.uml.ui.foundation.core;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLConstraintConstrainedElementListModel extends UMLModelElementListModel2
  { 
protected void buildModelList()
    { 
if(getTarget() != null)//1
{ 
setAllElements(Model.getFacade()
                           .getConstrainedElements(getTarget()));
} 

} 

public UMLConstraintConstrainedElementListModel()
    { 
super("constrainedElement");
} 

protected boolean isValidElement(Object element)
    { 
return Model.getFacade().isAModelElement(element)
               && Model.getFacade().getConstrainedElements(getTarget())
               .contains(element);
} 

 } 


