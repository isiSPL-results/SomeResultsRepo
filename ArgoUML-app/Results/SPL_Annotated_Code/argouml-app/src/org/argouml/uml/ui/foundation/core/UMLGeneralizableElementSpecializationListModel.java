// Compilation Unit of /UMLGeneralizableElementSpecializationListModel.java 
 
package org.argouml.uml.ui.foundation.core;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLGeneralizableElementSpecializationListModel extends UMLModelElementListModel2
  { 
public UMLGeneralizableElementSpecializationListModel()
    { 
super("specialization",
              Model.getMetaTypes().getGeneralization(),
              true);
} 

@Override
    protected boolean isValidElement(Object element)
    { 
return Model.getFacade().isAGeneralization(element)
               && Model.getFacade().getSpecializations(getTarget())
               .contains(element);
} 

@Override
    protected void buildModelList()
    { 
if(getTarget() != null
                && Model.getFacade().isAGeneralizableElement(getTarget()))//1
{ 
setAllElements(Model.getFacade().getSpecializations(getTarget()));
} 

} 

 } 


