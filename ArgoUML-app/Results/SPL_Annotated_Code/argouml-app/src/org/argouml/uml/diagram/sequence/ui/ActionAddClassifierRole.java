// Compilation Unit of /ActionAddClassifierRole.java 
 
package org.argouml.uml.diagram.sequence.ui;
import org.argouml.model.Model;
import org.argouml.ui.CmdCreateNode;
import org.argouml.uml.diagram.sequence.SequenceDiagramGraphModel;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.gef.graph.GraphModel;
public class ActionAddClassifierRole extends CmdCreateNode
  { 
private static final long serialVersionUID = 1824497910678123381L;
public Object makeNode()
    { 
Object node = null;
Editor ce = Globals.curEditor();
GraphModel gm = ce.getGraphModel();
if(gm instanceof SequenceDiagramGraphModel)//1
{ 
Object collaboration =
                ((SequenceDiagramGraphModel) gm).getCollaboration();
node =
                Model.getCollaborationsFactory().buildClassifierRole(
                    collaboration);
} 
else
{ 
throw new IllegalStateException("Graphmodel is not a "
                                            + "sequence diagram graph model");
} 

return node;
} 

public ActionAddClassifierRole()
    { 
super(Model.getMetaTypes().getClassifierRole(),
              "button.new-classifierrole");
} 

 } 


