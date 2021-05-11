
//#if 1155525378 
// Compilation Unit of /ActivityDiagramGraphModel.java 
 

//#if -1414152560 
package org.argouml.uml.diagram.activity;
//#endif 


//#if 460816821 
import org.argouml.model.Model;
//#endif 


//#if -1457634162 
import org.argouml.uml.diagram.state.StateDiagramGraphModel;
//#endif 


//#if 520888140 
public class ActivityDiagramGraphModel extends 
//#if 1923681893 
StateDiagramGraphModel
//#endif 

  { 

//#if 1951701200 
private static final long serialVersionUID = 5047684232283453072L;
//#endif 


//#if -1469926582 
public boolean canAddNode(Object node)
    { 

//#if -736273390 
if(containsNode(node))//1
{ 

//#if -1621197961 
return false;
//#endif 

} 

//#endif 


//#if -2020216410 
if(Model.getFacade().isAPartition(node))//1
{ 

//#if 1780721192 
return true;
//#endif 

} 

//#endif 


//#if 894553509 
return super.canAddNode(node);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

