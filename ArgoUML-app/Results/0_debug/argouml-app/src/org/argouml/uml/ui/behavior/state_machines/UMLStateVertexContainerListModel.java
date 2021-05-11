
//#if -1646502977 
// Compilation Unit of /UMLStateVertexContainerListModel.java 
 

//#if 2120881752 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -871501841 
import org.argouml.model.Model;
//#endif 


//#if -682317931 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1032869852 
public class UMLStateVertexContainerListModel extends 
//#if 718347689 
UMLModelElementListModel2
//#endif 

  { 

//#if -1038935145 
protected void buildModelList()
    { 

//#if -1975216975 
removeAllElements();
//#endif 


//#if 1108093228 
addElement(Model.getFacade().getContainer(getTarget()));
//#endif 

} 

//#endif 


//#if 1366578522 
public UMLStateVertexContainerListModel()
    { 

//#if -1133156467 
super("container");
//#endif 

} 

//#endif 


//#if -535300661 
protected boolean isValidElement(Object element)
    { 

//#if 734379139 
return Model.getFacade().getContainer(getTarget()) == element;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

