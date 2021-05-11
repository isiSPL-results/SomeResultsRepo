// Compilation Unit of /DeploymentDiagramRenderer.java 
 
package org.argouml.uml.diagram.deployment.ui;
import java.util.Collection;
import java.util.Map;
import org.apache.log4j.Logger;
import org.argouml.model.Model;
import org.argouml.uml.CommentEdge;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.UmlDiagramRenderer;
import org.argouml.uml.diagram.static_structure.ui.FigEdgeNote;
import org.argouml.uml.diagram.static_structure.ui.FigLink;
import org.argouml.uml.diagram.ui.FigAssociation;
import org.argouml.uml.diagram.ui.FigAssociationClass;
import org.argouml.uml.diagram.ui.FigAssociationEnd;
import org.argouml.uml.diagram.ui.FigDependency;
import org.argouml.uml.diagram.ui.FigGeneralization;
import org.argouml.uml.diagram.ui.UMLDiagram;
import org.tigris.gef.base.Diagram;
import org.tigris.gef.base.Layer;
import org.tigris.gef.base.LayerPerspective;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.FigEdge;
import org.tigris.gef.presentation.FigNode;
public class DeploymentDiagramRenderer extends UmlDiagramRenderer
  { 
static final long serialVersionUID = 8002278834226522224L;
private static final Logger LOG =
        Logger.getLogger(DeploymentDiagramRenderer.class);
public FigEdge getFigEdgeFor(
        GraphModel gm,
        Layer lay,
        Object edge,
        Map styleAttributes)
    { 
assert lay instanceof LayerPerspective;
ArgoDiagram diag = (ArgoDiagram) ((LayerPerspective) lay).getDiagram();
DiagramSettings settings = diag.getDiagramSettings();
FigEdge newEdge = null;
if(Model.getFacade().isAAssociationClass(edge))//1
{ 
newEdge = new FigAssociationClass(edge, settings);
} 
else
if(Model.getFacade().isAAssociation(edge))//1
{ 
newEdge = new FigAssociation(edge, settings);
} 
else
if(Model.getFacade().isAAssociationEnd(edge))//1
{ 
FigAssociationEnd asend = new FigAssociationEnd(edge, settings);
Model.getFacade().getAssociation(edge);
FigNode associationFN =
                (FigNode) lay.presentationFor(Model
                                              .getFacade().getAssociation(edge));
FigNode classifierFN =
                (FigNode) lay.presentationFor(Model
                                              .getFacade().getType(edge));
asend.setSourcePortFig(associationFN);
asend.setSourceFigNode(associationFN);
asend.setDestPortFig(classifierFN);
asend.setDestFigNode(classifierFN);
newEdge = asend;
} 
else
if(Model.getFacade().isALink(edge))//1
{ 
FigLink lnkFig = new FigLink(edge, settings);
Collection linkEnds = Model.getFacade().getConnections(edge);
Object[] leArray = linkEnds.toArray();
Object fromEnd = leArray[0];
Object fromInst = Model.getFacade().getInstance(fromEnd);
Object toEnd = leArray[1];
Object toInst = Model.getFacade().getInstance(toEnd);
FigNode fromFN = (FigNode) lay.presentationFor(fromInst);
FigNode toFN = (FigNode) lay.presentationFor(toInst);
lnkFig.setSourcePortFig(fromFN);
lnkFig.setSourceFigNode(fromFN);
lnkFig.setDestPortFig(toFN);
lnkFig.setDestFigNode(toFN);
newEdge = lnkFig;
} 
else
if(Model.getFacade().isADependency(edge))//1
{ 
FigDependency depFig = new FigDependency(edge, settings);
Object supplier =
                ((Model.getFacade().getSuppliers(edge).toArray())[0]);
Object client =
                ((Model.getFacade().getClients(edge).toArray())[0]);
FigNode supFN = (FigNode) lay.presentationFor(supplier);
FigNode cliFN = (FigNode) lay.presentationFor(client);
depFig.setSourcePortFig(cliFN);
depFig.setSourceFigNode(cliFN);
depFig.setDestPortFig(supFN);
depFig.setDestFigNode(supFN);
depFig.getFig().setDashed(true);
newEdge = depFig;
} 
else
if(Model.getFacade().isAGeneralization(edge))//1
{ 
newEdge = new FigGeneralization(edge, settings);
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

public FigNode getFigNodeFor(
        GraphModel gm,
        Layer lay,
        Object node,
        Map styleAttributes)
    { 
FigNode figNode = null;
Diagram diag = ((LayerPerspective) lay).getDiagram();
if(diag instanceof UMLDiagram
                && ((UMLDiagram) diag).doesAccept(node))//1
{ 
figNode = ((UMLDiagram) diag).drop(node, null);
} 
else
{ 
LOG.debug("TODO: DeploymentDiagramRenderer getFigNodeFor");
return null;
} 

lay.add(figNode);
return figNode;
} 

 } 


