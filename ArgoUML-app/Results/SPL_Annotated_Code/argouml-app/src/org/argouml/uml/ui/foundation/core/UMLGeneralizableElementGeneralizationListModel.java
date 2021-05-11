// Compilation Unit of /UMLGeneralizableElementGeneralizationListModel.java 
 
package org.argouml.uml.ui.foundation.core;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLGeneralizableElementGeneralizationListModel extends UMLModelElementListModel2
  { 
protected boolean isValidElement(Object element)
    { 
return Model.getFacade().isAGeneralization(element)
               && Model.getFacade().getGeneralizations(getTarget())
               .contains(element);
} 

protected void buildModelList()
    { 
if(getTarget() != null
                && Model.getFacade().isAGeneralizableElement(getTarget()))//1
{ 
setAllElements(Model.getFacade().getGeneralizations(getTarget()));
} 

} 

public UMLGeneralizableElementGeneralizationListModel()
    { 
super("generalization", Model.getMetaTypes().getGeneralization());
} 

 } 


