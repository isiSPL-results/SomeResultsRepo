package org.argouml.uml.diagram.collaboration.ui;
import org.argouml.model.Model;
import org.argouml.ui.CmdCreateNode;
import org.argouml.uml.diagram.collaboration.CollabDiagramGraphModel;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.gef.graph.GraphModel;
public class ActionAddClassifierRole extends CmdCreateNode
  { 
private static final long serialVersionUID = 8939546123926523391L;
public ActionAddClassifierRole()
    { 
super(Model.getMetaTypes().getClassifierRole(),
              "button.new-classifierrole");
} 
public Object makeNode()
    { 
Object node = null;
Editor ce = Globals.curEditor();
GraphModel gm = ce.getGraphModel();
if(gm instanceof CollabDiagramGraphModel)//1
{ 
Object collaboration =
                ((CollabDiagramGraphModel) gm).getHomeModel();
node =
                Model.getCollaborationsFactory().buildClassifierRole(
                    collaboration);
} 
else
{ 
throw new IllegalStateException("Graphmodel is not a "
                                            + "collaboration diagram graph model");
} 
return node;
} 

 } 
