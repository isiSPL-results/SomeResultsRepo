
//#if -1239134194 
// Compilation Unit of /ActionAddClassifierRole.java 
 

//#if 1658765220 
package org.argouml.uml.diagram.sequence.ui;
//#endif 


//#if 1113857479 
import org.argouml.model.Model;
//#endif 


//#if 912684269 
import org.argouml.ui.CmdCreateNode;
//#endif 


//#if -1796068970 
import org.argouml.uml.diagram.sequence.SequenceDiagramGraphModel;
//#endif 


//#if -1904456514 
import org.tigris.gef.base.Editor;
//#endif 


//#if -1053131077 
import org.tigris.gef.base.Globals;
//#endif 


//#if -1864458765 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -361684255 
public class ActionAddClassifierRole extends 
//#if -1434852873 
CmdCreateNode
//#endif 

  { 

//#if 1532943522 
private static final long serialVersionUID = 1824497910678123381L;
//#endif 


//#if 784263642 
public Object makeNode()
    { 

//#if 1357368041 
Object node = null;
//#endif 


//#if 118137928 
Editor ce = Globals.curEditor();
//#endif 


//#if 1627879562 
GraphModel gm = ce.getGraphModel();
//#endif 


//#if -632205815 
if(gm instanceof SequenceDiagramGraphModel)//1
{ 

//#if -2080695601 
Object collaboration =
                ((SequenceDiagramGraphModel) gm).getCollaboration();
//#endif 


//#if 1668519279 
node =
                Model.getCollaborationsFactory().buildClassifierRole(
                    collaboration);
//#endif 

} 
else
{ 

//#if -2055551023 
throw new IllegalStateException("Graphmodel is not a "
                                            + "sequence diagram graph model");
//#endif 

} 

//#endif 


//#if -282432424 
return node;
//#endif 

} 

//#endif 


//#if -1645964775 
public ActionAddClassifierRole()
    { 

//#if -1458126531 
super(Model.getMetaTypes().getClassifierRole(),
              "button.new-classifierrole");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

