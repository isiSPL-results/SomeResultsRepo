
//#if 531741283 
// Compilation Unit of /CollabDiagramRenderer.java 
 

//#if -863976974 
package org.argouml.uml.diagram.collaboration.ui;
//#endif 


//#if 597548368 
import java.util.Map;
//#endif 


//#if 1994001330 
import org.apache.log4j.Logger;
//#endif 


//#if -453429467 
import org.argouml.model.Model;
//#endif 


//#if 953041255 
import org.argouml.uml.CommentEdge;
//#endif 


//#if 531155300 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 746913544 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -90307530 
import org.argouml.uml.diagram.UmlDiagramRenderer;
//#endif 


//#if 1731024729 
import org.argouml.uml.diagram.static_structure.ui.FigEdgeNote;
//#endif 


//#if -222372669 
import org.argouml.uml.diagram.ui.FigDependency;
//#endif 


//#if -747094478 
import org.argouml.uml.diagram.ui.FigGeneralization;
//#endif 


//#if -726035195 
import org.argouml.uml.diagram.ui.UMLDiagram;
//#endif 


//#if -1998869034 
import org.tigris.gef.base.Diagram;
//#endif 


//#if 1507427480 
import org.tigris.gef.base.Layer;
//#endif 


//#if 593654050 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if -294946479 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -1439892129 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if -1431255622 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if 1403067846 
public class CollabDiagramRenderer extends 
//#if 242307249 
UmlDiagramRenderer
//#endif 

  { 

//#if -940883358 
private static final Logger LOG =
        Logger.getLogger(CollabDiagramRenderer.class);
//#endif 


//#if -84974947 
public FigNode getFigNodeFor(GraphModel gm, Layer lay,
                                 Object node, Map styleAttributes)
    { 

//#if -1325424026 
FigNode figNode = null;
//#endif 


//#if -118844319 
assert node != null;
//#endif 


//#if 370850820 
Diagram diag = ((LayerPerspective) lay).getDiagram();
//#endif 


//#if -600901520 
if(diag instanceof UMLDiagram
                && ((UMLDiagram) diag).doesAccept(node))//1
{ 

//#if -729573087 
figNode = ((UMLDiagram) diag).drop(node, null);
//#endif 

} 
else
{ 

//#if -1575541441 
LOG.error("TODO: CollabDiagramRenderer getFigNodeFor");
//#endif 


//#if -2082257543 
throw new IllegalArgumentException(
                "Node is not a recognised type. Received "
                + node.getClass().getName());
//#endif 

} 

//#endif 


//#if -1587350504 
lay.add(figNode);
//#endif 


//#if -1313290028 
return figNode;
//#endif 

} 

//#endif 


//#if -1307857266 
public FigEdge getFigEdgeFor(GraphModel gm, Layer lay,
                                 Object edge, Map styleAttributes)
    { 

//#if 1238874093 
if(LOG.isDebugEnabled())//1
{ 

//#if -839420762 
LOG.debug("making figedge for " + edge);
//#endif 

} 

//#endif 


//#if -1128931634 
if(edge == null)//1
{ 

//#if 462640662 
throw new IllegalArgumentException("A model edge must be supplied");
//#endif 

} 

//#endif 


//#if -622469585 
assert lay instanceof LayerPerspective;
//#endif 


//#if -1165397860 
ArgoDiagram diag = (ArgoDiagram) ((LayerPerspective) lay).getDiagram();
//#endif 


//#if -507097180 
DiagramSettings settings = diag.getDiagramSettings();
//#endif 


//#if -1711234308 
FigEdge newEdge = null;
//#endif 


//#if -479179440 
if(Model.getFacade().isAAssociationRole(edge))//1
{ 

//#if -367291543 
newEdge = new FigAssociationRole(edge, settings);
//#endif 

} 
else

//#if -137727784 
if(Model.getFacade().isAGeneralization(edge))//1
{ 

//#if 1523101101 
newEdge = new FigGeneralization(edge, settings);
//#endif 

} 
else

//#if 414971808 
if(Model.getFacade().isADependency(edge))//1
{ 

//#if -872717573 
newEdge = new FigDependency(edge, settings);
//#endif 

} 
else

//#if -1182306764 
if(edge instanceof CommentEdge)//1
{ 

//#if 1766751677 
newEdge = new FigEdgeNote(edge, settings);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#if 771167498 
if(newEdge == null)//1
{ 

//#if 882349492 
throw new IllegalArgumentException(
                "Don't know how to create FigEdge for model type "
                + edge.getClass().getName());
//#endif 

} 

//#endif 


//#if -1232104264 
setPorts(lay, newEdge);
//#endif 


//#if 247876348 
assert newEdge != null : "There has been no FigEdge created";
//#endif 


//#if -1254270541 
assert (newEdge.getDestFigNode() != null)
        : "The FigEdge has no dest node";
//#endif 


//#if -1347163761 
assert (newEdge.getDestPortFig() != null)
        : "The FigEdge has no dest port";
//#endif 


//#if 192968979 
assert (newEdge.getSourceFigNode() != null)
        : "The FigEdge has no source node";
//#endif 


//#if 1569273263 
assert (newEdge.getSourcePortFig() != null)
        : "The FigEdge has no source port";
//#endif 


//#if -1909337707 
lay.add(newEdge);
//#endif 


//#if -1867065801 
return newEdge;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

