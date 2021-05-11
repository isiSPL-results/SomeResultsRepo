// Compilation Unit of /CollabDiagramRenderer.java 
 
package org.argouml.uml.diagram.collaboration.ui;
import java.util.Map;
import org.apache.log4j.Logger;
import org.argouml.model.Model;
import org.argouml.uml.CommentEdge;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.UmlDiagramRenderer;
import org.argouml.uml.diagram.static_structure.ui.FigEdgeNote;
import org.argouml.uml.diagram.ui.FigDependency;
import org.argouml.uml.diagram.ui.FigGeneralization;
import org.argouml.uml.diagram.ui.UMLDiagram;
import org.tigris.gef.base.Diagram;
import org.tigris.gef.base.Layer;
import org.tigris.gef.base.LayerPerspective;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.FigEdge;
import org.tigris.gef.presentation.FigNode;
public class CollabDiagramRenderer extends UmlDiagramRenderer
  { 
private static final Logger LOG =
        Logger.getLogger(CollabDiagramRenderer.class);
public FigNode getFigNodeFor(GraphModel gm, Layer lay,
                                 Object node, Map styleAttributes)
    { 
FigNode figNode = null;
assert node != null;
Diagram diag = ((LayerPerspective) lay).getDiagram();
if(diag instanceof UMLDiagram
                && ((UMLDiagram) diag).doesAccept(node))//1
{ 
figNode = ((UMLDiagram) diag).drop(node, null);
} 
else
{ 
LOG.error("TODO: CollabDiagramRenderer getFigNodeFor");
throw new IllegalArgumentException(
                "Node is not a recognised type. Received "
                + node.getClass().getName());
} 

lay.add(figNode);
return figNode;
} 

public FigEdge getFigEdgeFor(GraphModel gm, Layer lay,
                                 Object edge, Map styleAttributes)
    { 
if(LOG.isDebugEnabled())//1
{ 
LOG.debug("making figedge for " + edge);
} 

if(edge == null)//1
{ 
throw new IllegalArgumentException("A model edge must be supplied");
} 

assert lay instanceof LayerPerspective;
ArgoDiagram diag = (ArgoDiagram) ((LayerPerspective) lay).getDiagram();
DiagramSettings settings = diag.getDiagramSettings();
FigEdge newEdge = null;
if(Model.getFacade().isAAssociationRole(edge))//1
{ 
newEdge = new FigAssociationRole(edge, settings);
} 
else
if(Model.getFacade().isAGeneralization(edge))//1
{ 
newEdge = new FigGeneralization(edge, settings);
} 
else
if(Model.getFacade().isADependency(edge))//1
{ 
newEdge = new FigDependency(edge, settings);
} 
else
if(edge instanceof CommentEdge)//1
{ 
newEdge = new FigEdgeNote(edge, settings);
} 




if(newEdge == null)//1
{ 
throw new IllegalArgumentException(
                "Don't know how to create FigEdge for model type "
                + edge.getClass().getName());
} 

setPorts(lay, newEdge);
assert newEdge != null : "There has been no FigEdge created";
assert (newEdge.getDestFigNode() != null)
        : "The FigEdge has no dest node";
assert (newEdge.getDestPortFig() != null)
        : "The FigEdge has no dest port";
assert (newEdge.getSourceFigNode() != null)
        : "The FigEdge has no source node";
assert (newEdge.getSourcePortFig() != null)
        : "The FigEdge has no source port";
lay.add(newEdge);
return newEdge;
} 

 } 


