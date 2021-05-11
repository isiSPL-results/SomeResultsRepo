
//#if -1837589613 
// Compilation Unit of /UMLCollaborationConstrainingElementListModel.java 
 

//#if -1368602360 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if -188900365 
import org.argouml.model.Model;
//#endif 


//#if 897541649 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -26818400 
public class UMLCollaborationConstrainingElementListModel extends 
//#if -444194296 
UMLModelElementListModel2
//#endif 

  { 

//#if 1942840859 
public UMLCollaborationConstrainingElementListModel()
    { 

//#if 932787087 
super("constrainingElement");
//#endif 

} 

//#endif 


//#if -1654891619 
protected boolean isValidElement(Object elem)
    { 

//#if -1236033141 
return (Model.getFacade().getConstrainingElements(getTarget())
                .contains(elem));
//#endif 

} 

//#endif 


//#if 1474353270 
protected void buildModelList()
    { 

//#if 1729382602 
setAllElements(Model.getFacade().getConstrainingElements(getTarget()));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

