
//#if 75414563 
// Compilation Unit of /UMLAttributeInitialValueListModel.java 
 

//#if 1792514295 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -1427251342 
import org.argouml.model.Model;
//#endif 


//#if -109144078 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -169672512 
public class UMLAttributeInitialValueListModel extends 
//#if -1908510814 
UMLModelElementListModel2
//#endif 

  { 

//#if 644977058 
public UMLAttributeInitialValueListModel()
    { 

//#if 1435100128 
super("initialValue");
//#endif 

} 

//#endif 


//#if 707053840 
protected void buildModelList()
    { 

//#if -1808189119 
if(getTarget() != null)//1
{ 

//#if 1665733688 
removeAllElements();
//#endif 


//#if 349587029 
addElement(Model.getFacade().getInitialValue(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -243691196 
protected boolean isValidElement(Object element)
    { 

//#if 1061858044 
return Model.getFacade().getInitialValue(getTarget()) == element;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

