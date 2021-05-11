
//#if -795078261 
// Compilation Unit of /ModeCreateGraphEdge.java 
 

//#if -1861846575 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -1653425907 
import java.awt.Color;
//#endif 


//#if -1281337216 
import java.awt.Point;
//#endif 


//#if 752251293 
import java.awt.event.MouseEvent;
//#endif 


//#if -2070366261 
import java.awt.event.MouseListener;
//#endif 


//#if 1747602536 
import org.apache.log4j.Logger;
//#endif 


//#if -699828261 
import org.argouml.model.Model;
//#endif 


//#if 2128429071 
import org.argouml.uml.diagram.static_structure.ui.FigEdgeNote;
//#endif 


//#if 941387726 
import org.tigris.gef.base.Layer;
//#endif 


//#if 395527087 
import org.tigris.gef.base.ModeCreatePolyEdge;
//#endif 


//#if 2119778643 
import org.tigris.gef.graph.MutableGraphModel;
//#endif 


//#if -600070446 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1984158997 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if 1992795504 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if 1994650854 
import org.tigris.gef.presentation.FigPoly;
//#endif 


//#if 70184033 
public abstract class ModeCreateGraphEdge extends 
//#if 984674052 
ModeCreatePolyEdge
//#endif 

  { 

//#if 152167090 
private static final Logger LOG =
        Logger.getLogger(ModeCreateGraphEdge.class);
//#endif 


//#if 913329231 
private Fig sourceFig;
//#endif 


//#if 2026517030 
protected FigEdge buildConnection(
        MutableGraphModel graphModel,
        Object edgeType,
        Fig fromElement,
        Fig destFigNode)
    { 

//#if -294283141 
Object modelElement = graphModel.connect(
                                  fromElement.getOwner(),
                                  destFigNode.getOwner(),
                                  edgeType);
//#endif 


//#if 447953784 
setNewEdge(modelElement);
//#endif 


//#if -752969692 
if(getNewEdge() != null)//1
{ 

//#if 6765488 
getSourceFigNode().damage();
//#endif 


//#if 2021792612 
destFigNode.damage();
//#endif 


//#if 68601238 
Layer lay = editor.getLayerManager().getActiveLayer();
//#endif 


//#if 1840792307 
FigEdge fe = (FigEdge) lay.presentationFor(getNewEdge());
//#endif 


//#if -1498005784 
_newItem.setLineColor(Color.black);
//#endif 


//#if -1027201926 
fe.setFig(_newItem);
//#endif 


//#if -252097318 
fe.setSourcePortFig(getStartPortFig());
//#endif 


//#if -2097132075 
fe.setSourceFigNode(getSourceFigNode());
//#endif 


//#if 1153563167 
fe.setDestPortFig(destFigNode);
//#endif 


//#if 1200730047 
fe.setDestFigNode((FigNode) destFigNode);
//#endif 


//#if -2082778929 
return fe;
//#endif 

} 
else
{ 

//#if -22842334 
return null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1778151965 
protected abstract Object getMetaType();
//#endif 


//#if -828523906 
@Override
    public void mousePressed(MouseEvent me)
    { 

//#if -815678809 
int x = me.getX(), y = me.getY();
//#endif 


//#if -227050734 
Fig underMouse = editor.hit(x, y);
//#endif 


//#if -1333443262 
if(underMouse == null)//1
{ 

//#if 1982290746 
underMouse = editor.hit(x - 16, y - 16, 32, 32);
//#endif 

} 

//#endif 


//#if 1955189260 
if(underMouse == null && _npoints == 0)//1
{ 

//#if -766112931 
done();
//#endif 


//#if -925965575 
me.consume();
//#endif 


//#if -1506163760 
return;
//#endif 

} 

//#endif 


//#if -279744910 
if(_npoints > 0)//1
{ 

//#if 551502506 
me.consume();
//#endif 


//#if 1798569025 
return;
//#endif 

} 

//#endif 


//#if -70609291 
sourceFig = underMouse;
//#endif 


//#if -1045877229 
if(underMouse instanceof FigEdgeModelElement
                && !(underMouse instanceof FigEdgeNote))//1
{ 

//#if -966615488 
FigEdgeModelElement sourceEdge = (FigEdgeModelElement) underMouse;
//#endif 


//#if 1050703670 
sourceEdge.makeEdgePort();
//#endif 


//#if -1703382943 
FigEdgePort edgePort = sourceEdge.getEdgePort();
//#endif 


//#if 189038864 
sourceEdge.computeRoute();
//#endif 


//#if 1433014315 
underMouse = edgePort;
//#endif 


//#if 482311377 
setSourceFigNode(edgePort);
//#endif 


//#if -1210431330 
setStartPort(sourceFig.getOwner());
//#endif 


//#if -206001645 
setStartPortFig(edgePort);
//#endif 

} 
else

//#if 2091718827 
if(underMouse instanceof FigNodeModelElement)//1
{ 

//#if 1447786041 
if(getSourceFigNode() == null)//1
{ 

//#if -265130713 
setSourceFigNode((FigNode) underMouse);
//#endif 


//#if 426117763 
setStartPort(getSourceFigNode().deepHitPort(x, y));
//#endif 

} 

//#endif 


//#if 2070555057 
if(getStartPort() == null)//1
{ 

//#if -642209577 
done();
//#endif 


//#if -1497367309 
me.consume();
//#endif 


//#if -1382260406 
return;
//#endif 

} 

//#endif 


//#if -1741437458 
setStartPortFig(
                getSourceFigNode().getPortFig(getStartPort()));
//#endif 

} 
else
{ 

//#if -1403319285 
done();
//#endif 


//#if 1066412327 
me.consume();
//#endif 


//#if -2143370114 
return;
//#endif 

} 

//#endif 


//#endif 


//#if 2020878255 
createFig(me);
//#endif 


//#if 820946991 
me.consume();
//#endif 

} 

//#endif 


//#if 734212105 
@Override
    public void mouseReleased(MouseEvent me)
    { 

//#if -975090706 
if(me.isConsumed())//1
{ 

//#if -1066977405 
return;
//#endif 

} 

//#endif 


//#if 1100251464 
if(getSourceFigNode() == null)//1
{ 

//#if -1059715295 
done();
//#endif 


//#if -664011843 
me.consume();
//#endif 


//#if -1799766124 
return;
//#endif 

} 

//#endif 


//#if -1877247100 
int x = me.getX(), y = me.getY();
//#endif 


//#if -1155833512 
Fig destFig = editor.hit(x, y);
//#endif 


//#if 1210412174 
if(destFig == null)//1
{ 

//#if -2016790652 
destFig = editor.hit(x - 16, y - 16, 32, 32);
//#endif 

} 

//#endif 


//#if 167419299 
MutableGraphModel graphModel =
            (MutableGraphModel) editor.getGraphModel();
//#endif 


//#if 56341444 
if(!isConnectionValid(sourceFig, destFig))//1
{ 

//#if 631773385 
destFig = null;
//#endif 

} 
else
{ 

//#if 1425139611 
LOG.info("Connection valid");
//#endif 

} 

//#endif 


//#if 1316987516 
if(destFig instanceof FigEdgeModelElement
                && !(destFig instanceof FigEdgeNote))//1
{ 

//#if 380861032 
FigEdgeModelElement destEdge = (FigEdgeModelElement) destFig;
//#endif 


//#if 1701720835 
destEdge.makeEdgePort();
//#endif 


//#if -548526346 
destFig = destEdge.getEdgePort();
//#endif 


//#if 840056029 
destEdge.computeRoute();
//#endif 

} 

//#endif 


//#if 1867153622 
if(destFig instanceof FigNodeModelElement)//1
{ 

//#if 1294450585 
FigNode destFigNode = (FigNode) destFig;
//#endif 


//#if 217349350 
Object foundPort = destFigNode.getOwner();
//#endif 


//#if -1423170772 
if(foundPort == getStartPort() && _npoints < 4)//1
{ 

//#if -573036074 
done();
//#endif 


//#if -1500216654 
me.consume();
//#endif 


//#if -1313086903 
return;
//#endif 

} 

//#endif 


//#if 1195188087 
if(foundPort != null)//1
{ 

//#if 571024721 
FigPoly p = (FigPoly) _newItem;
//#endif 


//#if -1726538317 
if(foundPort == getStartPort() && _npoints >= 4)//1
{ 

//#if -1017993884 
p.setSelfLoop(true);
//#endif 

} 

//#endif 


//#if -1918355849 
editor.damageAll();
//#endif 


//#if 1818497053 
p.setComplete(true);
//#endif 


//#if 1510271544 
LOG.info("Connecting");
//#endif 


//#if 2127013749 
FigEdge fe = buildConnection(
                                 graphModel,
                                 getMetaType(),
                                 sourceFig,
                                 destFig);
//#endif 


//#if 1926317091 
if(fe != null)//1
{ 

//#if -923372961 
editor.getSelectionManager().select(fe);
//#endif 

} 

//#endif 


//#if -904210309 
editor.damageAll();
//#endif 


//#if 790320221 
if(fe instanceof MouseListener)//1
{ 

//#if 1704105408 
((MouseListener) fe).mouseReleased(me);
//#endif 

} 

//#endif 


//#if -1785578580 
endAttached(fe);
//#endif 


//#if -922771770 
done();
//#endif 


//#if 1126990754 
me.consume();
//#endif 


//#if -1662822599 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 733769432 
if(!nearLast(x, y))//1
{ 

//#if -2004927022 
editor.damageAll();
//#endif 


//#if 1046489365 
Point snapPt = new Point(x, y);
//#endif 


//#if -1507301740 
editor.snap(snapPt);
//#endif 


//#if 436007631 
((FigPoly) _newItem).addPoint(snapPt.x, snapPt.y);
//#endif 


//#if 1966843282 
_npoints++;
//#endif 


//#if 1329319744 
editor.damageAll();
//#endif 

} 

//#endif 


//#if 594098485 
_lastX = x;
//#endif 


//#if 594128307 
_lastY = y;
//#endif 


//#if -2103672884 
me.consume();
//#endif 

} 

//#endif 


//#if -1291221702 
protected boolean isConnectionValid(Fig source, Fig dest)
    { 

//#if -313889719 
return Model.getUmlFactory().isConnectionValid(
                   getMetaType(),
                   source == null ? null : source.getOwner(),
                   dest == null ? null : dest.getOwner(),
                   true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

