
//#if 1680350307 
// Compilation Unit of /UMLSignalEventSignalListModel.java 
 

//#if 296659915 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 375356642 
import org.argouml.model.Model;
//#endif 


//#if -1398620030 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1721321962 
class UMLSignalEventSignalListModel extends 
//#if 1158404857 
UMLModelElementListModel2
//#endif 

  { 

//#if 1985932059 
protected boolean isValidElement(Object element)
    { 

//#if 1876589184 
return element == Model.getFacade().getSignal(getTarget());
//#endif 

} 

//#endif 


//#if -1693536025 
protected void buildModelList()
    { 

//#if -1563503666 
removeAllElements();
//#endif 


//#if -55439548 
addElement(Model.getFacade().getSignal(getTarget()));
//#endif 

} 

//#endif 


//#if 2017289352 
public UMLSignalEventSignalListModel()
    { 

//#if 1816488369 
super("signal");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

