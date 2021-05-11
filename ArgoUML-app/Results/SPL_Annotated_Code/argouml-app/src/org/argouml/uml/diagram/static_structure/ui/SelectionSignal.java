// Compilation Unit of /SelectionSignal.java 
 
package org.argouml.uml.diagram.static_structure.ui;
import org.argouml.model.Model;
import org.tigris.gef.presentation.Fig;
class SelectionSignal extends SelectionGeneralizableElement
  { 
protected Object getNewNodeType(int index)
    { 
return Model.getMetaTypes().getSignal();
} 

protected Object getNewNode(int index)
    { 
return Model.getCommonBehaviorFactory().createSignal();
} 

public SelectionSignal(Fig f)
    { 
super(f);
} 

 } 


