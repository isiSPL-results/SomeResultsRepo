// Compilation Unit of /SelectionCallState.java 
 
package org.argouml.uml.diagram.activity.ui;
import org.argouml.model.Model;
import org.tigris.gef.presentation.Fig;
public class SelectionCallState extends SelectionActionState
  { 
protected Object getNewNode(int buttonCode)
    { 
return Model.getActivityGraphsFactory().createCallState();
} 

protected Object getNewNodeType(int buttonCode)
    { 
return Model.getMetaTypes().getCallState();
} 

public SelectionCallState(Fig f)
    { 
super(f);
} 

 } 


