package org.argouml.uml.diagram.activity;
import org.argouml.model.Model;
import org.argouml.uml.diagram.state.StateDiagramGraphModel;
public class ActivityDiagramGraphModel extends StateDiagramGraphModel
  { 
private static final long serialVersionUID = 5047684232283453072L;
public boolean canAddNode(Object node)
    { 
if(containsNode(node))//1
{ 
return false;
} 
if(Model.getFacade().isAPartition(node))//1
{ 
return true;
} 
return super.canAddNode(node);
} 

 } 
