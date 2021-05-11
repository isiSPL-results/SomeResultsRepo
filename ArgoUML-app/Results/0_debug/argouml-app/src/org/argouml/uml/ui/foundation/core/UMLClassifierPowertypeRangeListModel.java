
//#if 187739001 
// Compilation Unit of /UMLClassifierPowertypeRangeListModel.java 
 

//#if 531495170 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 950253565 
import org.argouml.model.Model;
//#endif 


//#if 1593578567 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1002483741 
public class UMLClassifierPowertypeRangeListModel extends 
//#if 992303515 
UMLModelElementListModel2
//#endif 

  { 

//#if -1310916491 
public UMLClassifierPowertypeRangeListModel()
    { 

//#if -25249014 
super("powertypeRange");
//#endif 

} 

//#endif 


//#if -719057271 
protected void buildModelList()
    { 

//#if 1455991044 
if(getTarget() != null)//1
{ 

//#if 1276884492 
setAllElements(Model.getFacade().getPowertypeRanges(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1483160387 
protected boolean isValidElement(Object element)
    { 

//#if 1868731363 
return Model.getFacade().getPowertypeRanges(getTarget())
               .contains(element);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

