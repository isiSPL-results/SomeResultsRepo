// Compilation Unit of /UseCaseDiagramRenderer.java 
 
package org.argouml.uml.diagram.use_case.ui;
import java.util.Map;
import org.apache.log4j.Logger;
import org.argouml.model.Model;
import org.argouml.uml.CommentEdge;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.DiagramUtils;
import org.argouml.uml.diagram.GraphChangeAdapter;
import org.argouml.uml.diagram.UmlDiagramRenderer;
import org.argouml.uml.diagram.static_structure.ui.FigEdgeNote;
import org.argouml.uml.diagram.ui.FigAssociation;
import org.argouml.uml.diagram.ui.FigDependency;
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
import org.argouml.uml.diagram.ui.FigGeneralization;
import org.argouml.uml.diagram.ui.FigNodeModelElement;
import org.argouml.uml.diagram.ui.UMLDiagram;
import org.tigris.gef.base.Layer;
import org.tigris.gef.base.LayerPerspective;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.FigEdge;
import org.tigris.gef.presentation.FigNode;
public class UseCaseDiagramRenderer extends UmlDiagramRenderer
  { 
static final long serialVersionUID = 2217410137377934879L;
private static final Logger LOG =
        Logger.getLogger(UseCaseDiagramRenderer.class);
public FigNode getFigNodeFor(GraphModel gm, Layer lay, Object node,
                                 Map styleAttributes)
    { 
FigNodeModelElement figNode = null;
ArgoDiagram diag = DiagramUtils.getActiveDiagram();
if(diag instanceof UMLDiagram
                && ((UMLDiagram) diag).doesAccept(node))//1
{ 
figNode =
                (FigNodeModelElement) ((UMLDiagram) diag).drop(node, null);
} 
else
{ 
LOG.debug(this.getClass().toString()
                      + ": getFigNodeFor(" + gm.toString() + ", "
                      + lay.toString() + ", " + node.toString()
                      + ") - cannot create this sort of node.");
return null;
} 

lay.add(figNode);
figNode.setDiElement(
            GraphChangeAdapter.getInstance().createElement(gm, node));
return figNode;
} 

public FigEdge getFigEdgeFor(GraphModel gm, Layer lay, Object edge,
                                 Map styleAttributes)
    { 
if(LOG.isDebugEnabled())//1
{ 
LOG.debug("making figedge for " + edge);
} 

if(edge == null)//1
{ 
throw new IllegalArgumentException("A model edge must be supplied");
} 

DiagramSettings settings = ((ArgoDiagram) ((LayerPerspective) lay)
                                    .getDiagram()).getDiagramSettings();
FigEdge newEdge = null;
if(Model.getFacade().isAAssociation(edge))//1
{ 
newEdge = new FigAssociation(edge, settings);
} 
else
if(Model.getFacade().isAGeneralization(edge))//1
{ 
newEdge = new FigGeneralization(edge, settings);
} 
else
if(Model.getFacade().isAExtend(edge))//1
{ 
newEdge = new FigExtend(edge, settings);
Object base = Model.getFacade().getBase(edge);
Object extension = Model.getFacade().getExtension(edge);
FigNode baseFN = (FigNode) lay.presentationFor(base);
FigNode extensionFN = (FigNode) lay.presentationFor(extension);
newEdge.setSourcePortFig(extensionFN);
newEdge.setSourceFigNode(extensionFN);
newEdge.setDestPortFig(baseFN);
newEdge.setDestFigNode(baseFN);
} 
else
if(Model.getFacade().isAInclude(edge))//1
{ 
newEdge = new FigInclude(edge, settings);
Object base = Model.getFacade().getBase(edge);
Object addition = Model.getFacade().getAddition(edge);
FigNode baseFN = (FigNode) lay.presentationFor(base);
FigNode additionFN = (FigNode) lay.presentationFor(addition);
newEdge.setSourcePortFig(baseFN);
newEdge.setSourceFigNode(baseFN);
newEdge.setDestPortFig(additionFN);
newEdge.setDestFigNode(additionFN);
} 
else
if(Model.getFacade().isADependency(edge))//1
{ 
newEdge = new FigDependency(edge, settings);
Object supplier =
                ((Model.getFacade().getSuppliers(edge).toArray())[0]);
Object client =
                ((Model.getFacade().getClients(edge).toArray())[0]);
FigNode supplierFN = (FigNode) lay.presentationFor(supplier);
FigNode clientFN = (FigNode) lay.presentationFor(client);
newEdge.setSourcePortFig(clientFN);
newEdge.setSourceFigNode(clientFN);
newEdge.setDestPortFig(supplierFN);
newEdge.setDestFigNode(supplierFN);
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
else
{ 
setPorts(lay, newEdge);
} 

lay.add(newEdge);
newEdge.setLayer(lay);
return newEdge;
} 

 } 


