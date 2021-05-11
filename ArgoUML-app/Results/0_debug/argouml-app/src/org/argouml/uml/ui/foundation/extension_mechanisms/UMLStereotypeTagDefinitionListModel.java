
//#if 260894711 
// Compilation Unit of /UMLStereotypeTagDefinitionListModel.java 
 

//#if -754434701 
package org.argouml.uml.ui.foundation.extension_mechanisms;
//#endif 


//#if 1513354153 
import org.argouml.model.Model;
//#endif 


//#if 189275163 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1087532772 
class UMLStereotypeTagDefinitionListModel extends 
//#if 1759152133 
UMLModelElementListModel2
//#endif 

  { 

//#if -1368918029 
protected void buildModelList()
    { 

//#if -2102267980 
if(getTarget() != null)//1
{ 

//#if -564171671 
setAllElements(Model.getFacade().getTagDefinitions(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1064000275 
public UMLStereotypeTagDefinitionListModel()
    { 

//#if -1345531390 
super("definedTag");
//#endif 

} 

//#endif 


//#if -1673487833 
protected boolean isValidElement(Object element)
    { 

//#if 1950557031 
return Model.getFacade().isATagDefinition(element)
               && Model.getFacade().getTagDefinitions(getTarget())
               .contains(element);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

