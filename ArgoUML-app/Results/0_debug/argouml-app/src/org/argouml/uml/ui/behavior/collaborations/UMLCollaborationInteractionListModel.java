
//#if -690268197 
// Compilation Unit of /UMLCollaborationInteractionListModel.java 
 

//#if 1059833801 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if -992688844 
import org.argouml.model.Model;
//#endif 


//#if -1130348688 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1232759810 
public class UMLCollaborationInteractionListModel extends 
//#if -1501280059 
UMLModelElementListModel2
//#endif 

  { 

//#if -10295680 
protected boolean isValidElement(Object elem)
    { 

//#if -521945215 
return Model.getFacade().isAInteraction(elem)
               && Model.getFacade().getContext(elem) == getTarget();
//#endif 

} 

//#endif 


//#if -1950132045 
protected void buildModelList()
    { 

//#if -1760173549 
setAllElements(Model.getFacade().getInteractions(getTarget()));
//#endif 

} 

//#endif 


//#if -1218599683 
public UMLCollaborationInteractionListModel()
    { 

//#if -1309967427 
super("interaction");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

