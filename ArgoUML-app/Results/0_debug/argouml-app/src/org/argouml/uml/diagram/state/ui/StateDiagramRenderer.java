
//#if 1883142940 
// Compilation Unit of /StateDiagramRenderer.java 
 

//#if -851274886 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if -1615549300 
import java.util.Map;
//#endif 


//#if 563347438 
import org.apache.log4j.Logger;
//#endif 


//#if -1884083359 
import org.argouml.model.Model;
//#endif 


//#if 1354479523 
import org.argouml.uml.CommentEdge;
//#endif 


//#if 1170883488 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 346487620 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -2054828422 
import org.argouml.uml.diagram.UmlDiagramRenderer;
//#endif 


//#if 195517333 
import org.argouml.uml.diagram.static_structure.ui.FigEdgeNote;
//#endif 


//#if -127569855 
import org.argouml.uml.diagram.ui.UMLDiagram;
//#endif 


//#if -1597430766 
import org.tigris.gef.base.Diagram;
//#endif 


//#if 1038571988 
import org.tigris.gef.base.Layer;
//#endif 


//#if -1049608602 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if -906268275 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -800163941 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if -791527434 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if 1792751276 
public class StateDiagramRenderer extends 
//#if 618582847 
UmlDiagramRenderer
//#endif 

  { 

//#if -1786287114 
private static final Logger LOG =
        Logger.getLogger(StateDiagramRenderer.class);
//#endif 


//#if 452135631 
public FigNode getFigNodeFor(GraphModel gm, Layer lay, Object node,
                                 Map styleAttributes)
    { 

//#if 1670822619 
assert node != null;
//#endif 


//#if 1213280684 
FigNode figNode = null;
//#endif 


//#if -813794690 
Diagram diag = ((LayerPerspective) lay).getDiagram();
//#endif 


//#if -366566474 
if(diag instanceof UMLDiagram
                && ((UMLDiagram) diag).doesAccept(node))//1
{ 

//#if -605118665 
figNode = ((UMLDiagram) diag).drop(node, null);
//#endif 

} 
else
{ 

//#if 1587891107 
LOG.debug("TODO: StateDiagramRenderer getFigNodeFor");
//#endif 


//#if -1545853534 
throw new IllegalArgumentException(
                "Node is not a recognised type. Received "
                + node.getClass().getName());
//#endif 

} 

//#endif 


//#if 202316434 
lay.add(figNode);
//#endif 


//#if 1277215898 
return figNode;
//#endif 

} 

//#endif 


//#if -770746688 
public FigEdge getFigEdgeFor(GraphModel gm, Layer lay, Object edge,
                                 Map styleAttributes)
    { 

//#if -1782467690 
assert edge != null;
//#endif 


//#if -1890192763 
assert lay instanceof LayerPerspective;
//#endif 


//#if 1087490674 
ArgoDiagram diag = (ArgoDiagram) ((LayerPerspective) lay).getDiagram();
//#endif 


//#if 1715017082 
DiagramSettings settings = diag.getDiagramSettings();
//#endif 


//#if -463461550 
FigEdge newEdge = null;
//#endif 


//#if 1365512362 
if(Model.getFacade().isATransition(edge))//1
{ 

//#if 1340816392 
newEdge = new FigTransition(edge, settings);
//#endif 

} 
else

//#if 106388618 
if(edge instanceof CommentEdge)//1
{ 

//#if -343028273 
newEdge = new FigEdgeNote(edge, settings);
//#endif 

} 

//#endif 


//#endif 


//#if 2018940256 
if(newEdge == null)//1
{ 

//#if 689239374 
LOG.debug("TODO: StateDiagramRenderer getFigEdgeFor");
//#endif 


//#if -1338183646 
return null;
//#endif 

} 

//#endif 


//#if 2108432639 
lay.add(newEdge);
//#endif 


//#if -142946547 
return newEdge;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

