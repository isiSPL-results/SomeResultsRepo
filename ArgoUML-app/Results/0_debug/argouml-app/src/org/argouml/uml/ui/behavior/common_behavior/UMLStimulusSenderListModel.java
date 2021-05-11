
//#if 1520245906 
// Compilation Unit of /UMLStimulusSenderListModel.java 
 

//#if 135691942 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 974870055 
import org.argouml.model.Model;
//#endif 


//#if 1493423197 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 1320636777 
public class UMLStimulusSenderListModel extends 
//#if -937181584 
UMLModelElementListModel2
//#endif 

  { 

//#if 170083184 
public UMLStimulusSenderListModel()
    { 

//#if -1608292202 
super("sender");
//#endif 

} 

//#endif 


//#if 1074397406 
protected void buildModelList()
    { 

//#if 942819596 
removeAllElements();
//#endif 


//#if 293855897 
addElement(Model.getFacade().getSender(getTarget()));
//#endif 

} 

//#endif 


//#if 1768823861 
protected boolean isValidElement(Object elem)
    { 

//#if 1794130004 
return Model.getFacade().getSender(getTarget()) == elem;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

