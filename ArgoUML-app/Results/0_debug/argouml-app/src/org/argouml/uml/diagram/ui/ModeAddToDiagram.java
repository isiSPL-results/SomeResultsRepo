
//#if -295362384 
// Compilation Unit of /ModeAddToDiagram.java 
 

//#if 1004077872 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -1682033073 
import java.awt.Cursor;
//#endif 


//#if 1697579201 
import java.awt.Point;
//#endif 


//#if 249997762 
import java.awt.Rectangle;
//#endif 


//#if 2121970294 
import java.awt.event.KeyEvent;
//#endif 


//#if 522831548 
import java.awt.event.MouseEvent;
//#endif 


//#if 1911100106 
import java.util.ArrayList;
//#endif 


//#if 454159319 
import java.util.Collection;
//#endif 


//#if -616428201 
import java.util.List;
//#endif 


//#if -817996473 
import org.apache.log4j.Logger;
//#endif 


//#if 1230922617 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 176587173 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if -1249830677 
import org.tigris.gef.base.Editor;
//#endif 


//#if -2038727919 
import org.tigris.gef.base.FigModifyingModeImpl;
//#endif 


//#if 711967981 
import org.tigris.gef.base.Layer;
//#endif 


//#if 2042043842 
import org.tigris.gef.graph.GraphNodeRenderer;
//#endif 


//#if 682849940 
import org.tigris.gef.graph.MutableGraphModel;
//#endif 


//#if 1574725809 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -731488305 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if 1573393810 
import org.tigris.gef.undo.Memento;
//#endif 


//#if -958161502 
import org.tigris.gef.undo.UndoManager;
//#endif 


//#if -390592757 
class AddToDiagramMemento extends 
//#if -1060073135 
Memento
//#endif 

  { 

//#if -1508513368 
private final List<FigNode> nodesPlaced;
//#endif 


//#if -1932090746 
private final Editor editor;
//#endif 


//#if -49094290 
private final MutableGraphModel mgm;
//#endif 


//#if 1416214634 
public void undo()
    { 

//#if 1144009980 
UndoManager.getInstance().addMementoLock(this);
//#endif 


//#if -605553363 
for (FigNode figNode : nodesPlaced) //1
{ 

//#if -1373690303 
mgm.removeNode(figNode.getOwner());
//#endif 


//#if 1830566711 
editor.remove(figNode);
//#endif 

} 

//#endif 


//#if 1230491057 
UndoManager.getInstance().removeMementoLock(this);
//#endif 

} 

//#endif 


//#if -139024397 
AddToDiagramMemento(final Editor ed, final List<FigNode> nodesPlaced)
    { 

//#if 978743231 
this.nodesPlaced = nodesPlaced;
//#endif 


//#if 1933886767 
this.editor = ed;
//#endif 


//#if -15254009 
this.mgm = (MutableGraphModel) editor.getGraphModel();
//#endif 

} 

//#endif 


//#if 1049323407 
public String toString()
    { 

//#if 755564351 
return (isStartChain() ? "*" : " ")
               + "AddToDiagramMemento";
//#endif 

} 

//#endif 


//#if 2048405947 
public void dispose()
    { 
} 

//#endif 


//#if 1322015492 
public void redo()
    { 

//#if 417097889 
UndoManager.getInstance().addMementoLock(this);
//#endif 


//#if 1746387304 
for (FigNode figNode : nodesPlaced) //1
{ 

//#if 1999043715 
editor.add(figNode);
//#endif 


//#if 602071979 
mgm.addNode(figNode.getOwner());
//#endif 

} 

//#endif 


//#if 1017494508 
UndoManager.getInstance().removeMementoLock(this);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 753013000 
public class ModeAddToDiagram extends 
//#if 1371578458 
FigModifyingModeImpl
//#endif 

  { 

//#if 254150418 
private static final long serialVersionUID = 8861862975789222877L;
//#endif 


//#if 218548802 
private final Collection<Object> modelElements;
//#endif 


//#if -1611006310 
private final boolean addRelatedEdges = true;
//#endif 


//#if 500277151 
private final String instructions;
//#endif 


//#if 394829301 
private static final Logger LOG = Logger.getLogger(ModeAddToDiagram.class);
//#endif 


//#if -1405868007 
@Override
    public String instructions()
    { 

//#if -915328958 
return instructions;
//#endif 

} 

//#endif 


//#if -1238841369 
public void keyTyped(KeyEvent ke)
    { 

//#if -317161863 
if(ke.getKeyChar() == KeyEvent.VK_ESCAPE)//1
{ 

//#if -598147343 
LOG.debug("ESC pressed");
//#endif 


//#if 1996845712 
leave();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -979905330 
public ModeAddToDiagram(
        final Collection<Object> modelElements,
        final String instructions)
    { 

//#if -109028989 
this.modelElements = modelElements;
//#endif 


//#if 991203066 
if(instructions == null)//1
{ 

//#if 78944155 
this.instructions = "";
//#endif 

} 
else
{ 

//#if 1701864843 
this.instructions = instructions;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1262803554 
@Override
    public void mouseReleased(final MouseEvent me)
    { 

//#if -1231459506 
if(me.isConsumed())//1
{ 

//#if -818223483 
if(LOG.isDebugEnabled())//1
{ 

//#if -213518860 
LOG.debug("MouseReleased but rejected as already consumed");
//#endif 

} 

//#endif 


//#if -1548764390 
return;
//#endif 

} 

//#endif 


//#if -1911424922 
UndoManager.getInstance().addMementoLock(this);
//#endif 


//#if -1903045568 
start();
//#endif 


//#if 605232312 
MutableGraphModel gm = (MutableGraphModel) editor.getGraphModel();
//#endif 


//#if 1676452936 
final int x = me.getX();
//#endif 


//#if 1805565446 
final int y = me.getY();
//#endif 


//#if 1314654145 
editor.damageAll();
//#endif 


//#if -2049477076 
final Point snapPt = new Point(x, y);
//#endif 


//#if -1679500667 
editor.snap(snapPt);
//#endif 


//#if -945091855 
editor.damageAll();
//#endif 


//#if -615323904 
int count = 0;
//#endif 


//#if 1067842347 
Layer lay = editor.getLayerManager().getActiveLayer();
//#endif 


//#if 1712390763 
GraphNodeRenderer renderer = editor.getGraphNodeRenderer();
//#endif 


//#if 1320081686 
final List<FigNode> placedFigs =
            new ArrayList<FigNode>(modelElements.size());
//#endif 


//#if 715449331 
ArgoDiagram diag = DiagramUtils.getActiveDiagram();
//#endif 


//#if -2117563199 
if(diag instanceof UMLDiagram)//1
{ 

//#if 317593749 
for (final Object node : modelElements) //1
{ 

//#if 1024845668 
if(((UMLDiagram) diag).doesAccept(node))//1
{ 

//#if -185914829 
final FigNode pers =
                        renderer.getFigNodeFor(gm, lay, node, null);
//#endif 


//#if -1844138175 
pers.setLocation(snapPt.x + (count++ * 100), snapPt.y);
//#endif 


//#if -129083781 
if(LOG.isDebugEnabled())//1
{ 

//#if -1341485629 
LOG.debug("mouseMoved: Location set ("
                                  + pers.getX() + "," + pers.getY() + ")");
//#endif 

} 

//#endif 


//#if -1910703111 
UndoManager.getInstance().startChain();
//#endif 


//#if 262894325 
editor.add(pers);
//#endif 


//#if -665284090 
gm.addNode(node);
//#endif 


//#if -1152442492 
if(addRelatedEdges)//1
{ 

//#if -2140114873 
gm.addNodeRelatedEdges(node);
//#endif 

} 

//#endif 


//#if -660420029 
Fig encloser = null;
//#endif 


//#if -173772281 
final Rectangle bbox = pers.getBounds();
//#endif 


//#if -419037937 
final List<Fig> otherFigs = lay.getContents();
//#endif 


//#if 814401609 
for (final Fig otherFig : otherFigs) //1
{ 

//#if 1108369325 
if(!(otherFig.getUseTrapRect()))//1
{ 

//#if 109315083 
continue;
//#endif 

} 

//#endif 


//#if -1037850428 
if(!(otherFig instanceof FigNode))//1
{ 

//#if 495840500 
continue;
//#endif 

} 

//#endif 


//#if -1203075258 
if(!otherFig.isVisible())//1
{ 

//#if 1070696378 
continue;
//#endif 

} 

//#endif 


//#if 497980154 
if(otherFig.equals(pers))//1
{ 

//#if -437127460 
continue;
//#endif 

} 

//#endif 


//#if -835972497 
final Rectangle trap = otherFig.getTrapRect();
//#endif 


//#if -711520805 
if(trap != null
                                && trap.contains(bbox.x, bbox.y)
                                && trap.contains(
                                    bbox.x + bbox.width,
                                    bbox.y + bbox.height))//1
{ 

//#if -1354430884 
encloser = otherFig;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 835860416 
pers.setEnclosingFig(encloser);
//#endif 


//#if 122035638 
placedFigs.add(pers);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 11229703 
UndoManager.getInstance().removeMementoLock(this);
//#endif 


//#if -192801332 
if(UndoManager.getInstance().isGenerateMementos())//1
{ 

//#if -791797383 
AddToDiagramMemento memento =
                new AddToDiagramMemento(editor, placedFigs);
//#endif 


//#if -399723706 
UndoManager.getInstance().addMemento(memento);
//#endif 

} 

//#endif 


//#if -583394260 
UndoManager.getInstance().addMementoLock(this);
//#endif 


//#if 394630971 
editor.getSelectionManager().select(placedFigs);
//#endif 


//#if -1036284144 
done();
//#endif 


//#if 1178702956 
me.consume();
//#endif 

} 

//#endif 


//#if 1168836119 
public Cursor getInitialCursor()
    { 

//#if -1424728272 
return Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

