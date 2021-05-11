
//#if 733213309 
// Compilation Unit of /UMLGeneralizableElementSpecializationListModel.java 
 

//#if -1817117987 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1485728344 
import org.argouml.model.Model;
//#endif 


//#if 43907276 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -73615789 
public class UMLGeneralizableElementSpecializationListModel extends 
//#if -905291609 
UMLModelElementListModel2
//#endif 

  { 

//#if -1548421484 
public UMLGeneralizableElementSpecializationListModel()
    { 

//#if -974214212 
super("specialization",
              Model.getMetaTypes().getGeneralization(),
              true);
//#endif 

} 

//#endif 


//#if -47303349 
@Override
    protected boolean isValidElement(Object element)
    { 

//#if -857549549 
return Model.getFacade().isAGeneralization(element)
               && Model.getFacade().getSpecializations(getTarget())
               .contains(element);
//#endif 

} 

//#endif 


//#if 1721260823 
@Override
    protected void buildModelList()
    { 

//#if -1912288680 
if(getTarget() != null
                && Model.getFacade().isAGeneralizableElement(getTarget()))//1
{ 

//#if -1381883039 
setAllElements(Model.getFacade().getSpecializations(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

