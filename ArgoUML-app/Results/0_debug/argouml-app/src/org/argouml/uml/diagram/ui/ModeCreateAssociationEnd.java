
//#if -287993855 
// Compilation Unit of /ModeCreateAssociationEnd.java 
 

//#if -2128641064 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 2096033702 
import java.awt.Color;
//#endif 


//#if 1195464751 
import java.util.Collection;
//#endif 


//#if 154114991 
import java.util.List;
//#endif 


//#if -311950877 
import org.argouml.model.IllegalModelElementConnectionException;
//#endif 


//#if 537828706 
import org.argouml.model.Model;
//#endif 


//#if 1520697145 
import org.argouml.uml.diagram.static_structure.ui.FigClass;
//#endif 


//#if -1566345977 
import org.argouml.uml.diagram.static_structure.ui.FigClassifierBox;
//#endif 


//#if 623792021 
import org.tigris.gef.base.Layer;
//#endif 


//#if -2103716347 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if -621708052 
import org.tigris.gef.graph.MutableGraphModel;
//#endif 


//#if -1524476583 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -141430756 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if -132794249 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if 1655573215 
public class ModeCreateAssociationEnd extends 
//#if -1578006558 
ModeCreateGraphEdge
//#endif 

  { 

//#if 1725832258 
private static final long serialVersionUID = -7249069222789301797L;
//#endif 


//#if 731618084 
public Object getMetaType()
    { 

//#if -2022748850 
return Model.getMetaTypes().getAssociationEnd();
//#endif 

} 

//#endif 


//#if -1591872935 
@Override
    protected FigEdge buildConnection(
        MutableGraphModel graphModel,
        Object edgeType,
        Fig sourceFig,
        Fig destFig)
    { 

//#if -1219202075 
try //1
{ 

//#if 1753371928 
if(sourceFig instanceof FigClassifierBox)//1
{ 

//#if 766080583 
final Fig tempFig = sourceFig;
//#endif 


//#if 668839207 
sourceFig = destFig;
//#endif 


//#if -79719456 
destFig = tempFig;
//#endif 

} 

//#endif 


//#if 1439305104 
Object associationEnd =
                Model.getUmlFactory().buildConnection(
                    edgeType,
                    sourceFig.getOwner(),
                    null,
                    destFig.getOwner(),
                    null,
                    null,
                    null);
//#endif 


//#if 433457965 
final FigNode sourceFigNode = convertToFigNode(sourceFig);
//#endif 


//#if 1708801613 
final FigNode destFigNode = convertToFigNode(destFig);
//#endif 


//#if -1428372631 
graphModel.addEdge(associationEnd);
//#endif 


//#if -452995527 
setNewEdge(associationEnd);
//#endif 


//#if 467100382 
if(getNewEdge() != null)//1
{ 

//#if -222599552 
sourceFigNode.damage();
//#endif 


//#if -975252263 
destFigNode.damage();
//#endif 


//#if 1334658123 
Layer lay = editor.getLayerManager().getActiveLayer();
//#endif 


//#if -1249253272 
FigEdge fe = (FigEdge) lay.presentationFor(getNewEdge());
//#endif 


//#if 69388189 
_newItem.setLineColor(Color.black);
//#endif 


//#if 954329189 
fe.setFig(_newItem);
//#endif 


//#if -848714334 
fe.setSourcePortFig(sourceFigNode);
//#endif 


//#if 1272671237 
fe.setSourceFigNode(sourceFigNode);
//#endif 


//#if -523164332 
fe.setDestPortFig(destFigNode);
//#endif 


//#if -1061738377 
fe.setDestFigNode(destFigNode);
//#endif 


//#if 621990340 
return fe;
//#endif 

} 
else
{ 

//#if -1207449258 
return null;
//#endif 

} 

//#endif 

} 

//#if 1294110504 
catch (IllegalModelElementConnectionException e) //1
{ 

//#if 616013367 
return null;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 446645478 
private FigNode convertToFigNode(Fig fig)
    { 

//#if -672731588 
if(fig instanceof FigEdgePort)//1
{ 

//#if 2126739083 
fig = fig.getGroup();
//#endif 

} 

//#endif 


//#if 1119116749 
if(!(fig instanceof FigAssociation))//1
{ 

//#if 1730981581 
return (FigNode) fig;
//#endif 

} 

//#endif 


//#if -1009219119 
final FigAssociation figAssociation = (FigAssociation) fig;
//#endif 


//#if -1755972875 
final int x = figAssociation.getEdgePort().getX();
//#endif 


//#if -123139085 
final int y = figAssociation.getEdgePort().getY();
//#endif 


//#if -355018293 
final Object association = fig.getOwner();
//#endif 


//#if -1067035966 
final FigNode originalEdgePort = figAssociation.getEdgePort();
//#endif 


//#if -1774101449 
FigClassAssociationClass associationClassBox = null;
//#endif 


//#if -877397961 
FigEdgeAssociationClass associationClassLink = null;
//#endif 


//#if 927883760 
final LayerPerspective lay =
            (LayerPerspective) editor.getLayerManager().getActiveLayer();
//#endif 


//#if 2131978331 
final Collection<FigEdge> existingEdges = originalEdgePort.getEdges();
//#endif 


//#if 987873807 
for (FigEdge edge : existingEdges) //1
{ 

//#if -1877297300 
if(edge instanceof FigEdgeAssociationClass)//1
{ 

//#if -767466802 
associationClassLink = (FigEdgeAssociationClass) edge;
//#endif 


//#if -1962770738 
FigNode figNode = edge.getSourceFigNode();
//#endif 


//#if -376484160 
if(figNode instanceof FigEdgePort)//1
{ 

//#if -2083681820 
figNode = edge.getDestFigNode();
//#endif 

} 

//#endif 


//#if 688717943 
associationClassBox = (FigClassAssociationClass) figNode;
//#endif 


//#if -428467018 
originalEdgePort.removeFigEdge(edge);
//#endif 


//#if -1926504698 
lay.remove(edge);
//#endif 


//#if -567002929 
lay.remove(associationClassBox);
//#endif 

} 
else
{ 

//#if -686690329 
originalEdgePort.removeFigEdge(edge);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -245943623 
List associationFigs = lay.presentationsFor(association);
//#endif 


//#if 2106398301 
figAssociation.removeFromDiagram();
//#endif 


//#if -1850309125 
associationFigs = lay.presentationsFor(association);
//#endif 


//#if 1116863869 
final MutableGraphModel gm =
            (MutableGraphModel) editor.getGraphModel();
//#endif 


//#if 1348717647 
gm.addNode(association);
//#endif 


//#if -948819337 
associationFigs = lay.presentationsFor(association);
//#endif 


//#if -1405340180 
associationFigs.remove(figAssociation);
//#endif 


//#if -948819336 
associationFigs = lay.presentationsFor(association);
//#endif 


//#if -1193456755 
final FigNodeAssociation figNode =
            (FigNodeAssociation) associationFigs.get(0);
//#endif 


//#if -1231162370 
figNode.setLocation(
            x - figNode.getWidth() / 2,
            y - figNode.getHeight() / 2);
//#endif 


//#if 493487577 
editor.add(figNode);
//#endif 


//#if -1683294236 
editor.getSelectionManager().deselectAll();
//#endif 


//#if -369255682 
final Collection<Object> associationEnds =
            Model.getFacade().getConnections(association);
//#endif 


//#if -901774360 
for (Object associationEnd : associationEnds) //1
{ 

//#if 285229164 
gm.addEdge(associationEnd);
//#endif 

} 

//#endif 


//#if 632748610 
for (FigEdge edge : existingEdges) //2
{ 

//#if 1833944038 
if(edge.getDestFigNode() == originalEdgePort)//1
{ 

//#if 844036901 
edge.setDestFigNode(figNode);
//#endif 


//#if 586935938 
edge.setDestPortFig(figNode);
//#endif 

} 

//#endif 


//#if 1622839501 
if(edge.getSourceFigNode() == originalEdgePort)//1
{ 

//#if -728738819 
edge.setSourceFigNode(figNode);
//#endif 


//#if -985839782 
edge.setSourcePortFig(figNode);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2107349442 
figNode.updateEdges();
//#endif 


//#if -134885411 
if(associationClassBox != null)//1
{ 

//#if 2093877187 
associationFigs = lay.presentationsFor(association);
//#endif 


//#if -1027627324 
lay.add(associationClassBox);
//#endif 


//#if -1178987835 
associationClassLink.setSourceFigNode(figNode);
//#endif 


//#if -1511160571 
lay.add(associationClassLink);
//#endif 


//#if -1409682513 
associationFigs = lay.presentationsFor(association);
//#endif 

} 

//#endif 


//#if -212214450 
return figNode;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

