
//#if 1951104656 
// Compilation Unit of /SelectionException.java 
 

//#if -862975315 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if 2020011103 
import org.argouml.model.Model;
//#endif 


//#if -2031200426 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 991435253 
class SelectionException extends 
//#if -1323688790 
SelectionGeneralizableElement
//#endif 

  { 

//#if 1557598646 
public SelectionException(Fig f)
    { 

//#if 1583553525 
super(f);
//#endif 

} 

//#endif 


//#if 973213675 
@Override
    protected Object getNewNode(int buttonCode)
    { 

//#if 838532771 
return Model.getCommonBehaviorFactory().createException();
//#endif 

} 

//#endif 


//#if -1441150639 
@Override
    protected Object getNewNodeType(int buttonCode)
    { 

//#if -351680018 
return Model.getMetaTypes().getException();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

