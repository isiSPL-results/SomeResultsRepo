
//#if -275097421 
// Compilation Unit of /SelectionDataType.java 
 

//#if -1376863733 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if -1843421631 
import org.argouml.model.Model;
//#endif 


//#if -1647311048 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 522824576 
class SelectionDataType extends 
//#if -1152652314 
SelectionGeneralizableElement
//#endif 

  { 

//#if 1413929375 
protected Object getNewNodeType(int buttonCode)
    { 

//#if 1288100043 
return Model.getMetaTypes().getDataType();
//#endif 

} 

//#endif 


//#if 1928296249 
protected Object getNewNode(int buttonCode)
    { 

//#if 657617360 
Object ns = Model.getFacade().getNamespace(getContent().getOwner());
//#endif 


//#if 1195686892 
return Model.getCoreFactory().buildDataType("", ns);
//#endif 

} 

//#endif 


//#if 401392919 
public SelectionDataType(Fig f)
    { 

//#if -811656198 
super(f);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

