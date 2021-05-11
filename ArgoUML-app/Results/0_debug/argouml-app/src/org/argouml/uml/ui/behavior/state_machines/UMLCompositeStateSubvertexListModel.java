
//#if 226247634 
// Compilation Unit of /UMLCompositeStateSubvertexListModel.java 
 

//#if 785747834 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 398708241 
import org.argouml.model.Model;
//#endif 


//#if 878203571 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -2101832306 
public class UMLCompositeStateSubvertexListModel extends 
//#if -560480481 
UMLModelElementListModel2
//#endif 

  { 

//#if -171622335 
protected boolean isValidElement(Object element)
    { 

//#if 1028275397 
return Model.getFacade().getSubvertices(getTarget()).contains(element);
//#endif 

} 

//#endif 


//#if 102765069 
protected void buildModelList()
    { 

//#if -2061290927 
setAllElements(Model.getFacade().getSubvertices(getTarget()));
//#endif 

} 

//#endif 


//#if 392289294 
public UMLCompositeStateSubvertexListModel()
    { 

//#if -109302713 
super("subvertex");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

