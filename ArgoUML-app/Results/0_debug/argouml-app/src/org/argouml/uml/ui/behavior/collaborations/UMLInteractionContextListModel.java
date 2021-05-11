
//#if -1752710871 
// Compilation Unit of /UMLInteractionContextListModel.java 
 

//#if -1740201830 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if -2121437051 
import org.argouml.model.Model;
//#endif 


//#if -2032107329 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -739495587 
public class UMLInteractionContextListModel extends 
//#if 1902337402 
UMLModelElementListModel2
//#endif 

  { 

//#if -219215128 
protected void buildModelList()
    { 

//#if -2074489005 
removeAllElements();
//#endif 


//#if -653869856 
addElement(Model.getFacade().getContext(getTarget()));
//#endif 

} 

//#endif 


//#if -818728341 
protected boolean isValidElement(Object elem)
    { 

//#if 2073252336 
return Model.getFacade().isACollaboration(elem)
               && Model.getFacade().getInteractions(elem).contains(getTarget());
//#endif 

} 

//#endif 


//#if 1438471736 
public UMLInteractionContextListModel()
    { 

//#if -1796933145 
super("context");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

