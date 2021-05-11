package org.argouml.uml.diagram.ui;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import org.apache.log4j.Logger;
import org.argouml.model.Model;
import org.argouml.uml.diagram.static_structure.ui.FigEdgeNote;
import org.tigris.gef.base.Layer;
import org.tigris.gef.base.ModeCreatePolyEdge;
import org.tigris.gef.graph.MutableGraphModel;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigEdge;
import org.tigris.gef.presentation.FigNode;
import org.tigris.gef.presentation.FigPoly;
public abstract class ModeCreateGraphEdge extends ModeCreatePolyEdge
  { 
private static final Logger LOG =
        Logger.getLogger(ModeCreateGraphEdge.class);
private Fig sourceFig;
protected FigEdge buildConnection(
        MutableGraphModel graphModel,
        Object edgeType,
        Fig fromElement,
        Fig destFigNode)
    { 
Object modelElement = graphModel.connect(
                                  fromElement.getOwner(),
                                  destFigNode.getOwner(),
                                  edgeType);
setNewEdge(modelElement);
if(getNewEdge() != null)//1
{ 
getSourceFigNode().damage();
destFigNode.damage();
Layer lay = editor.getLayerManager().getActiveLayer();
FigEdge fe = (FigEdge) lay.presentationFor(getNewEdge());
_newItem.setLineColor(Color.black);
fe.setFig(_newItem);
fe.setSourcePortFig(getStartPortFig());
fe.setSourceFigNode(getSourceFigNode());
fe.setDestPortFig(destFigNode);
fe.setDestFigNode((FigNode) destFigNode);
return fe;
} 
else
{ 
return null;
} 
} 
protected abstract Object getMetaType();@Override
    public void mousePressed(MouseEvent me)
    { 
int x = me.getX(), y = me.getY();
Fig underMouse = editor.hit(x, y);
if(underMouse == null)//1
{ 
underMouse = editor.hit(x - 16, y - 16, 32, 32);
} 
if(underMouse == null && _npoints == 0)//1
{ 
done();
me.consume();
return;
} 
if(_npoints > 0)//1
{ 
me.consume();
return;
} 
sourceFig = underMouse;
if(underMouse instanceof FigEdgeModelElement
                && !(underMouse instanceof FigEdgeNote))//1
{ 
FigEdgeModelElement sourceEdge = (FigEdgeModelElement) underMouse;
sourceEdge.makeEdgePort();
FigEdgePort edgePort = sourceEdge.getEdgePort();
sourceEdge.computeRoute();
underMouse = edgePort;
setSourceFigNode(edgePort);
setStartPort(sourceFig.getOwner());
setStartPortFig(edgePort);
} 
else
if(underMouse instanceof FigNodeModelElement)//1
{ 
if(getSourceFigNode() == null)//1
{ 
setSourceFigNode((FigNode) underMouse);
setStartPort(getSourceFigNode().deepHitPort(x, y));
} 
if(getStartPort() == null)//1
{ 
done();
me.consume();
return;
} 
setStartPortFig(
                getSourceFigNode().getPortFig(getStartPort()));
} 
else
{ 
done();
me.consume();
return;
} 
createFig(me);
me.consume();
} 
@Override
    public void mouseReleased(MouseEvent me)
    { 
if(me.isConsumed())//1
{ 
return;
} 
if(getSourceFigNode() == null)//1
{ 
done();
me.consume();
return;
} 
int x = me.getX(), y = me.getY();
Fig destFig = editor.hit(x, y);
if(destFig == null)//1
{ 
destFig = editor.hit(x - 16, y - 16, 32, 32);
} 
MutableGraphModel graphModel =
            (MutableGraphModel) editor.getGraphModel();
if(!isConnectionValid(sourceFig, destFig))//1
{ 
destFig = null;
} 
else
{ 
LOG.info("Connection valid");
} 
if(destFig instanceof FigEdgeModelElement
                && !(destFig instanceof FigEdgeNote))//1
{ 
FigEdgeModelElement destEdge = (FigEdgeModelElement) destFig;
destEdge.makeEdgePort();
destFig = destEdge.getEdgePort();
destEdge.computeRoute();
} 
if(destFig instanceof FigNodeModelElement)//1
{ 
FigNode destFigNode = (FigNode) destFig;
Object foundPort = destFigNode.getOwner();
if(foundPort == getStartPort() && _npoints < 4)//1
{ 
done();
me.consume();
return;
} 
if(foundPort != null)//1
{ 
FigPoly p = (FigPoly) _newItem;
if(foundPort == getStartPort() && _npoints >= 4)//1
{ 
p.setSelfLoop(true);
} 
editor.damageAll();
p.setComplete(true);
LOG.info("Connecting");
FigEdge fe = buildConnection(
                                 graphModel,
                                 getMetaType(),
                                 sourceFig,
                                 destFig);
if(fe != null)//1
{ 
editor.getSelectionManager().select(fe);
} 
editor.damageAll();
if(fe instanceof MouseListener)//1
{ 
((MouseListener) fe).mouseReleased(me);
} 
endAttached(fe);
done();
me.consume();
return;
} 
} 
if(!nearLast(x, y))//1
{ 
editor.damageAll();
Point snapPt = new Point(x, y);
editor.snap(snapPt);
((FigPoly) _newItem).addPoint(snapPt.x, snapPt.y);
_npoints++;
editor.damageAll();
} 
_lastX = x;
_lastY = y;
me.consume();
} 
protected boolean isConnectionValid(Fig source, Fig dest)
    { 
return Model.getUmlFactory().isConnectionValid(
                   getMetaType(),
                   source == null ? null : source.getOwner(),
                   dest == null ? null : dest.getOwner(),
                   true);
} 

 } 
