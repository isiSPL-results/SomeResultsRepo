// Compilation Unit of /UMLCommentAnnotatedElementListModel.java 
 
package org.argouml.uml.ui.foundation.core;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLCommentAnnotatedElementListModel extends UMLModelElementListModel2
  { 
protected void buildModelList()
    { 
if(getTarget() != null)//1
{ 
setAllElements(Model.getFacade().getAnnotatedElements(getTarget()));
} 

} 

protected boolean isValidElement(Object element)
    { 
return Model.getFacade().isAModelElement(element)
               && Model.getFacade().getAnnotatedElements(getTarget())
               .contains(element);
} 

public UMLCommentAnnotatedElementListModel()
    { 
super("annotatedElement");
} 

 } 


