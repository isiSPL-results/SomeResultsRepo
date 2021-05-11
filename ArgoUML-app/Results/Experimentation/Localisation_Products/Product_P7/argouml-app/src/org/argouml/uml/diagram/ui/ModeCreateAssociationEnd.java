package org.argouml.uml.diagram.ui;
import java.awt.Color;
import java.util.Collection;
import java.util.List;
import org.argouml.model.IllegalModelElementConnectionException;
import org.argouml.model.Model;
import org.argouml.uml.diagram.static_structure.ui.FigClass;
import org.argouml.uml.diagram.static_structure.ui.FigClassifierBox;
import org.tigris.gef.base.Layer;
import org.tigris.gef.base.LayerPerspective;
import org.tigris.gef.graph.MutableGraphModel;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigEdge;
import org.tigris.gef.presentation.FigNode;
public class ModeCreateAssociationEnd extends ModeCreateGraphEdge
  { 
private static final long serialVersionUID = -7249069222789301797L;
public Object getMetaType()
    { 
return Model.getMetaTypes().getAssociationEnd();
} 
@Override
    protected FigEdge buildConnection(
        MutableGraphModel graphModel,
        Object edgeType,
        Fig sourceFig,
        Fig destFig)
    { 
try//1
{ 
if(sourceFig instanceof FigClassifierBox)//1
{ 
final Fig tempFig = sourceFig;
sourceFig = destFig;
destFig = tempFig;
} 
Object associationEnd =
                Model.getUmlFactory().buildConnection(
                    edgeType,
                    sourceFig.getOwner(),
                    null,
                    destFig.getOwner(),
                    null,
                    null,
                    null);
final FigNode sourceFigNode = convertToFigNode(sourceFig);
final FigNode destFigNode = convertToFigNode(destFig);
graphModel.addEdge(associationEnd);
setNewEdge(associationEnd);
if(getNewEdge() != null)//1
{ 
sourceFigNode.damage();
destFigNode.damage();
Layer lay = editor.getLayerManager().getActiveLayer();
FigEdge fe = (FigEdge) lay.presentationFor(getNewEdge());
_newItem.setLineColor(Color.black);
fe.setFig(_newItem);
fe.setSourcePortFig(sourceFigNode);
fe.setSourceFigNode(sourceFigNode);
fe.setDestPortFig(destFigNode);
fe.setDestFigNode(destFigNode);
return fe;
} 
else
{ 
return null;
} 
} 
catch (IllegalModelElementConnectionException e) //1
{ 
return null;
} 
} 
private FigNode convertToFigNode(Fig fig)
    { 
if(fig instanceof FigEdgePort)//1
{ 
fig = fig.getGroup();
} 
if(!(fig instanceof FigAssociation))//1
{ 
return (FigNode) fig;
} 
final FigAssociation figAssociation = (FigAssociation) fig;
final int x = figAssociation.getEdgePort().getX();
final int y = figAssociation.getEdgePort().getY();
final Object association = fig.getOwner();
final FigNode originalEdgePort = figAssociation.getEdgePort();
FigClassAssociationClass associationClassBox = null;
FigEdgeAssociationClass associationClassLink = null;
final LayerPerspective lay =
            (LayerPerspective) editor.getLayerManager().getActiveLayer();
final Collection<FigEdge> existingEdges = originalEdgePort.getEdges();
for (FigEdge edge : existingEdges) //1
{ 
if(edge instanceof FigEdgeAssociationClass)//1
{ 
associationClassLink = (FigEdgeAssociationClass) edge;
FigNode figNode = edge.getSourceFigNode();
if(figNode instanceof FigEdgePort)//1
{ 
figNode = edge.getDestFigNode();
} 
associationClassBox = (FigClassAssociationClass) figNode;
originalEdgePort.removeFigEdge(edge);
lay.remove(edge);
lay.remove(associationClassBox);
} 
else
{ 
originalEdgePort.removeFigEdge(edge);
} 
} 
List associationFigs = lay.presentationsFor(association);
figAssociation.removeFromDiagram();
associationFigs = lay.presentationsFor(association);
final MutableGraphModel gm =
            (MutableGraphModel) editor.getGraphModel();
gm.addNode(association);
associationFigs = lay.presentationsFor(association);
associationFigs.remove(figAssociation);
associationFigs = lay.presentationsFor(association);
final FigNodeAssociation figNode =
            (FigNodeAssociation) associationFigs.get(0);
figNode.setLocation(
            x - figNode.getWidth() / 2,
            y - figNode.getHeight() / 2);
editor.add(figNode);
editor.getSelectionManager().deselectAll();
final Collection<Object> associationEnds =
            Model.getFacade().getConnections(association);
for (Object associationEnd : associationEnds) //1
{ 
gm.addEdge(associationEnd);
} 
for (FigEdge edge : existingEdges) //2
{ 
if(edge.getDestFigNode() == originalEdgePort)//1
{ 
edge.setDestFigNode(figNode);
edge.setDestPortFig(figNode);
} 
if(edge.getSourceFigNode() == originalEdgePort)//1
{ 
edge.setSourceFigNode(figNode);
edge.setSourcePortFig(figNode);
} 
} 
figNode.updateEdges();
if(associationClassBox != null)//1
{ 
associationFigs = lay.presentationsFor(association);
lay.add(associationClassBox);
associationClassLink.setSourceFigNode(figNode);
lay.add(associationClassLink);
associationFigs = lay.presentationsFor(association);
} 
return figNode;
} 

 } 
