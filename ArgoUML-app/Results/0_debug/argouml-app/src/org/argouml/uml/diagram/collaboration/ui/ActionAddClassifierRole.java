
//#if -2105031269 
// Compilation Unit of /ActionAddClassifierRole.java 
 

//#if 604873790 
package org.argouml.uml.diagram.collaboration.ui;
//#endif 


//#if -2145495951 
import org.argouml.model.Model;
//#endif 


//#if -994715517 
import org.argouml.ui.CmdCreateNode;
//#endif 


//#if -467137806 
import org.argouml.uml.diagram.collaboration.CollabDiagramGraphModel;
//#endif 


//#if -681861676 
import org.tigris.gef.base.Editor;
//#endif 


//#if -1807396763 
import org.tigris.gef.base.Globals;
//#endif 


//#if 1500809885 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -1115949941 
public class ActionAddClassifierRole extends 
//#if -1514606577 
CmdCreateNode
//#endif 

  { 

//#if 809994584 
private static final long serialVersionUID = 8939546123926523391L;
//#endif 


//#if -2135602639 
public ActionAddClassifierRole()
    { 

//#if 189998731 
super(Model.getMetaTypes().getClassifierRole(),
              "button.new-classifierrole");
//#endif 

} 

//#endif 


//#if 1433548482 
public Object makeNode()
    { 

//#if 1545214795 
Object node = null;
//#endif 


//#if 50430758 
Editor ce = Globals.curEditor();
//#endif 


//#if -1096760084 
GraphModel gm = ce.getGraphModel();
//#endif 


//#if 1285975071 
if(gm instanceof CollabDiagramGraphModel)//1
{ 

//#if 516037076 
Object collaboration =
                ((CollabDiagramGraphModel) gm).getHomeModel();
//#endif 


//#if -98116379 
node =
                Model.getCollaborationsFactory().buildClassifierRole(
                    collaboration);
//#endif 

} 
else
{ 

//#if 1397808301 
throw new IllegalStateException("Graphmodel is not a "
                                            + "collaboration diagram graph model");
//#endif 

} 

//#endif 


//#if 1983637174 
return node;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

