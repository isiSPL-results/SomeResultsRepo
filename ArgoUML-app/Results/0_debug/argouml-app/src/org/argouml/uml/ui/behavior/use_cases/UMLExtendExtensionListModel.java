
//#if 1386148309 
// Compilation Unit of /UMLExtendExtensionListModel.java 
 

//#if 630354824 
package org.argouml.uml.ui.behavior.use_cases;
//#endif 


//#if -188478176 
import org.argouml.model.Model;
//#endif 


//#if 1109091076 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1043773070 
public class UMLExtendExtensionListModel extends 
//#if 220521005 
UMLModelElementListModel2
//#endif 

  { 

//#if 338230811 
protected void buildModelList()
    { 

//#if 66579568 
if(!isEmpty())//1
{ 

//#if 808338843 
removeAllElements();
//#endif 

} 

//#endif 


//#if 902619145 
addElement(Model.getFacade().getExtension(getTarget()));
//#endif 

} 

//#endif 


//#if 1590740785 
public UMLExtendExtensionListModel()
    { 

//#if 1791870096 
super("extension");
//#endif 

} 

//#endif 


//#if -171945905 
protected boolean isValidElement(Object element)
    { 

//#if -2100669588 
return Model.getFacade().isAUseCase(element);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

