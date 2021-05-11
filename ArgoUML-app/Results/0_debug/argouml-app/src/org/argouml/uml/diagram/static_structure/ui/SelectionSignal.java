
//#if 494117006 
// Compilation Unit of /SelectionSignal.java 
 

//#if 100709605 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if 555831079 
import org.argouml.model.Model;
//#endif 


//#if -576884194 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -141184118 
class SelectionSignal extends 
//#if 1077042985 
SelectionGeneralizableElement
//#endif 

  { 

//#if 1095281189 
protected Object getNewNodeType(int index)
    { 

//#if -306518769 
return Model.getMetaTypes().getSignal();
//#endif 

} 

//#endif 


//#if -935416373 
protected Object getNewNode(int index)
    { 

//#if -1128289411 
return Model.getCommonBehaviorFactory().createSignal();
//#endif 

} 

//#endif 


//#if 1797384126 
public SelectionSignal(Fig f)
    { 

//#if -40233076 
super(f);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

