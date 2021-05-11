// Compilation Unit of /SelectionDataType.java 
 
package org.argouml.uml.diagram.static_structure.ui;
import org.argouml.model.Model;
import org.tigris.gef.presentation.Fig;
class SelectionDataType extends SelectionGeneralizableElement
  { 
protected Object getNewNodeType(int buttonCode)
    { 
return Model.getMetaTypes().getDataType();
} 

protected Object getNewNode(int buttonCode)
    { 
Object ns = Model.getFacade().getNamespace(getContent().getOwner());
return Model.getCoreFactory().buildDataType("", ns);
} 

public SelectionDataType(Fig f)
    { 
super(f);
} 

 } 


