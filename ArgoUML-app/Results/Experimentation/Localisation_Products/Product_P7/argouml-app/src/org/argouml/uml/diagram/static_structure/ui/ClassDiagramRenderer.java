package org.argouml.uml.diagram.static_structure.ui;
import java.util.Collection;
import java.util.Map;
import org.apache.log4j.Logger;
import org.argouml.model.CoreFactory;
import org.argouml.model.Model;
import org.argouml.uml.CommentEdge;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.GraphChangeAdapter;
import org.argouml.uml.diagram.UmlDiagramRenderer;
import org.argouml.uml.diagram.ui.FigAbstraction;
import org.argouml.uml.diagram.ui.FigAssociation;
import org.argouml.uml.diagram.ui.FigAssociationClass;
import org.argouml.uml.diagram.ui.FigAssociationEnd;
import org.argouml.uml.diagram.ui.FigDependency;
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
import org.argouml.uml.diagram.ui.FigGeneralization;
import org.argouml.uml.diagram.ui.FigNodeModelElement;
import org.argouml.uml.diagram.ui.FigPermission;
import org.argouml.uml.diagram.ui.FigUsage;
import org.argouml.uml.diagram.ui.UMLDiagram;
import org.tigris.gef.base.Diagram;
import org.tigris.gef.base.Layer;
import org.tigris.gef.base.LayerPerspective;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.FigEdge;
import org.tigris.gef.presentation.FigNode;
public class ClassDiagramRenderer extends UmlDiagramRenderer
  { 
static final long serialVersionUID = 675407719309039112L;
private static final Logger LOG =
        Logger.getLogger(ClassDiagramRenderer.class);
public FigEdge getFigEdgeFor(GraphModel gm, Layer lay,
                                 Object edge, Map styleAttribute)
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
if(Model.getFacade().isAAssociationClass(edge))//1
{ 
newEdge = new FigAssociationClass(edge, settings);
} 
else
if(Model.getFacade().isAAssociationEnd(edge))//1
{ 
FigAssociationEnd asend = new FigAssociationEnd(edge, settings);
Model.getFacade().getAssociation(edge);
FigNode associationFN =
                (FigNode) lay.presentationFor(
                    Model.getFacade().getAssociation(edge));
FigNode classifierFN =
                (FigNode) lay.presentationFor(Model.getFacade().getType(edge));
asend.setSourcePortFig(associationFN);
asend.setSourceFigNode(associationFN);
asend.setDestPortFig(classifierFN);
asend.setDestFigNode(classifierFN);
newEdge = asend;
} 
else
if(Model.getFacade().isAAssociation(edge))//1
{ 
newEdge = new FigAssociation(edge, settings);
} 
else
if(Model.getFacade().isALink(edge))//1
{ 
FigLink lnkFig = new FigLink(edge, settings);
Collection linkEndsColn = Model.getFacade().getConnections(edge);
Object[] linkEnds = linkEndsColn.toArray();
Object fromInst = Model.getFacade().getInstance(linkEnds[0]);
Object toInst = Model.getFacade().getInstance(linkEnds[1]);
FigNode fromFN = (FigNode) lay.presentationFor(fromInst);
FigNode toFN = (FigNode) lay.presentationFor(toInst);
lnkFig.setSourcePortFig(fromFN);
lnkFig.setSourceFigNode(fromFN);
lnkFig.setDestPortFig(toFN);
lnkFig.setDestFigNode(toFN);
lnkFig.getFig().setLayer(lay);
newEdge = lnkFig;
} 
else
if(Model.getFacade().isAGeneralization(edge))//1
{ 
newEdge = new FigGeneralization(edge, settings);
} 
else
if(Model.getFacade().isAPackageImport(edge))//1
{ 
newEdge = new FigPermission(edge, settings);
} 
else
if(Model.getFacade().isAUsage(edge))//1
{ 
newEdge = new FigUsage(edge, settings);
} 
else
if(Model.getFacade().isAAbstraction(edge))//1
{ 
newEdge = new FigAbstraction(edge, settings);
} 
else
if(Model.getFacade().isADependency(edge))//1
{ 
String name = "";
for (Object stereotype : Model.getFacade().getStereotypes(edge)) //1
{ 
name = Model.getFacade().getName(stereotype);
if(CoreFactory.REALIZE_STEREOTYPE.equals(name))//1
{ 
break;

} 
} 
if(CoreFactory.REALIZE_STEREOTYPE.equals(name))//1
{ 
FigAbstraction realFig = new FigAbstraction(edge, settings);
Object supplier =
                    ((Model.getFacade().getSuppliers(edge).toArray())[0]);
Object client =
                    ((Model.getFacade().getClients(edge).toArray())[0]);
FigNode supFN = (FigNode) lay.presentationFor(supplier);
FigNode cliFN = (FigNode) lay.presentationFor(client);
realFig.setSourcePortFig(cliFN);
realFig.setSourceFigNode(cliFN);
realFig.setDestPortFig(supFN);
realFig.setDestFigNode(supFN);
realFig.getFig().setLayer(lay);
newEdge = realFig;
} 
else
{ 
FigDependency depFig = new FigDependency(edge, settings);
newEdge = depFig;
} 
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
public FigNode getFigNodeFor(GraphModel gm, Layer lay,
                                 Object node, Map styleAttributes)
    { 
FigNodeModelElement figNode = null;
if(node == null)//1
{ 
throw new IllegalArgumentException("A node must be supplied");
} 
Diagram diag = ((LayerPerspective) lay).getDiagram();
if(diag instanceof UMLDiagram
                && ((UMLDiagram) diag).doesAccept(node))//1
{ 
figNode = (FigNodeModelElement) ((UMLDiagram) diag)
                      .drop(node, null);
} 
else
{ 
LOG.error("TODO: ClassDiagramRenderer getFigNodeFor " + node);
throw new IllegalArgumentException(
                "Node is not a recognised type. Received "
                + node.getClass().getName());
} 
lay.add(figNode);
figNode.setDiElement(
            GraphChangeAdapter.getInstance().createElement(gm, node));
return figNode;
} 

 } 
