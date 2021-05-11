
//#if -1267682289 
// Compilation Unit of /SelectionCallState.java 
 

//#if -1673287218 
package org.argouml.uml.diagram.activity.ui;
//#endif 


//#if 1786249835 
import org.argouml.model.Model;
//#endif 


//#if -1396792990 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1859781916 
public class SelectionCallState extends 
//#if -23856299 
SelectionActionState
//#endif 

  { 

//#if 2086567696 
protected Object getNewNode(int buttonCode)
    { 

//#if -2000506996 
return Model.getActivityGraphsFactory().createCallState();
//#endif 

} 

//#endif 


//#if 2091916790 
protected Object getNewNodeType(int buttonCode)
    { 

//#if 1577931249 
return Model.getMetaTypes().getCallState();
//#endif 

} 

//#endif 


//#if 1327211541 
public SelectionCallState(Fig f)
    { 

//#if -1618399859 
super(f);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

