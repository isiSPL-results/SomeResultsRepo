
//#if 307271347 
// Compilation Unit of /UMLGeneralizableElementGeneralizationListModel.java 
 

//#if 1036684226 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1156999869 
import org.argouml.model.Model;
//#endif 


//#if 2046335367 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -902027011 
public class UMLGeneralizableElementGeneralizationListModel extends 
//#if 1655266405 
UMLModelElementListModel2
//#endif 

  { 

//#if 129597063 
protected boolean isValidElement(Object element)
    { 

//#if -1017681905 
return Model.getFacade().isAGeneralization(element)
               && Model.getFacade().getGeneralizations(getTarget())
               .contains(element);
//#endif 

} 

//#endif 


//#if -1040868269 
protected void buildModelList()
    { 

//#if 1404690808 
if(getTarget() != null
                && Model.getFacade().isAGeneralizableElement(getTarget()))//1
{ 

//#if -1923163497 
setAllElements(Model.getFacade().getGeneralizations(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1031138821 
public UMLGeneralizableElementGeneralizationListModel()
    { 

//#if -2105676514 
super("generalization", Model.getMetaTypes().getGeneralization());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

