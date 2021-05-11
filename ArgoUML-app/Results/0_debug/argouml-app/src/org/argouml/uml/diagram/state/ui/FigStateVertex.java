
//#if 2038851925 
// Compilation Unit of /FigStateVertex.java 
 

//#if -2023971651 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if -253329961 
import java.awt.Point;
//#endif 


//#if -909268008 
import java.awt.Rectangle;
//#endif 


//#if 333599604 
import java.util.ArrayList;
//#endif 


//#if -1252973411 
import java.util.Iterator;
//#endif 


//#if 1727629933 
import java.util.List;
//#endif 


//#if -904764316 
import org.argouml.model.Model;
//#endif 


//#if 1970392647 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 2025800783 
import org.argouml.uml.diagram.activity.ui.SelectionActionState;
//#endif 


//#if 1701149754 
import org.argouml.uml.diagram.ui.FigNodeModelElement;
//#endif 


//#if -534272767 
import org.tigris.gef.base.Editor;
//#endif 


//#if -1527107880 
import org.tigris.gef.base.Globals;
//#endif 


//#if 731422860 
import org.tigris.gef.base.LayerDiagram;
//#endif 


//#if -1594949053 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if 530709180 
import org.tigris.gef.base.Selection;
//#endif 


//#if 786364304 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -151520677 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1814643742 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if 1823280249 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if 1404024499 
public abstract class FigStateVertex extends 
//#if -1378241712 
FigNodeModelElement
//#endif 

  { 

//#if 854750832 
private static final int CIRCLE_POINTS = 32;
//#endif 


//#if 1941836636 

//#if 208385912 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigStateVertex(@SuppressWarnings("unused") GraphModel gm, Object node)
    { 

//#if -55399078 
this();
//#endif 


//#if 449726377 
setOwner(node);
//#endif 

} 

//#endif 


//#if 2074927554 
public void redrawEnclosedFigs()
    { 

//#if 475796483 
Editor editor = Globals.curEditor();
//#endif 


//#if 102379080 
if(editor != null && !getEnclosedFigs().isEmpty())//1
{ 

//#if 1627718951 
LayerDiagram lay =
                ((LayerDiagram) editor.getLayerManager().getActiveLayer());
//#endif 


//#if 771663545 
for (Fig f : getEnclosedFigs()) //1
{ 

//#if 453437780 
lay.bringInFrontOf(f, this);
//#endif 


//#if 1068595312 
if(f instanceof FigNode)//1
{ 

//#if -1443176022 
FigNode fn = (FigNode) f;
//#endif 


//#if -1327581954 
Iterator it = fn.getFigEdges().iterator();
//#endif 


//#if 1160327377 
while (it.hasNext()) //1
{ 

//#if 12596981 
lay.bringInFrontOf(((FigEdge) it.next()), this);
//#endif 

} 

//#endif 


//#if -1315590191 
if(fn instanceof FigStateVertex)//1
{ 

//#if 504821601 
((FigStateVertex) fn).redrawEnclosedFigs();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1139260005 

//#if 865410628 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigStateVertex()
    { 

//#if -1610404535 
this.allowRemoveFromDiagram(false);
//#endif 

} 

//#endif 


//#if -418695297 
@Override
    public Selection makeSelection()
    { 

//#if -635070000 
Object pstate = getOwner();
//#endif 


//#if -2010850137 
if(pstate != null)//1
{ 

//#if 1761626613 
if(Model.getFacade().isAActivityGraph(
                        Model.getFacade().getStateMachine(
                            Model.getFacade().getContainer(pstate))))//1
{ 

//#if 1370493320 
return new SelectionActionState(this);
//#endif 

} 

//#endif 


//#if -1375750670 
return new SelectionState(this);
//#endif 

} 

//#endif 


//#if 1669109684 
return null;
//#endif 

} 

//#endif 


//#if -102638321 
List<Point> getCircleGravityPoints()
    { 

//#if -893241659 
List<Point> ret = new ArrayList<Point>();
//#endif 


//#if -1931710844 
int cx = getBigPort().getCenter().x;
//#endif 


//#if -1238609116 
int cy = getBigPort().getCenter().y;
//#endif 


//#if -177478801 
double radius = getBigPort().getWidth() / 2 + 1;
//#endif 


//#if -1756939787 
final double pi2 = Math.PI * 2;
//#endif 


//#if -1389630064 
for (int i = 0; i < CIRCLE_POINTS; i++) //1
{ 

//#if -1452298821 
int x = (int) (cx + Math.cos(pi2 * i / CIRCLE_POINTS) * radius);
//#endif 


//#if 1139118124 
int y = (int) (cy + Math.sin(pi2 * i / CIRCLE_POINTS) * radius);
//#endif 


//#if 1462130612 
ret.add(new Point(x, y));
//#endif 

} 

//#endif 


//#if -1957067692 
return ret;
//#endif 

} 

//#endif 


//#if 1440889621 
public FigStateVertex(Object owner, Rectangle bounds, DiagramSettings settings)
    { 

//#if 161101017 
super(owner, bounds, settings);
//#endif 


//#if -768329684 
this.allowRemoveFromDiagram(false);
//#endif 

} 

//#endif 


//#if 1559832432 
@Override
    public void setEnclosingFig(Fig encloser)
    { 

//#if 1631110336 
LayerPerspective layer = (LayerPerspective) getLayer();
//#endif 


//#if -1130015993 
if(layer == null)//1
{ 

//#if -1714376011 
return;
//#endif 

} 

//#endif 


//#if -673020824 
super.setEnclosingFig(encloser);
//#endif 


//#if 1507679310 
if(!(Model.getFacade().isAStateVertex(getOwner())))//1
{ 

//#if -615723216 
return;
//#endif 

} 

//#endif 


//#if -242950236 
Object stateVertex = getOwner();
//#endif 


//#if 1991714290 
Object compositeState = null;
//#endif 


//#if -536906177 
if(encloser != null
                && (Model.getFacade().isACompositeState(encloser.getOwner())))//1
{ 

//#if -2034246500 
compositeState = encloser.getOwner();
//#endif 


//#if -2003109976 
((FigStateVertex) encloser).redrawEnclosedFigs();
//#endif 

} 
else
{ 

//#if -294722859 
compositeState = Model.getStateMachinesHelper().getTop(
                                 Model.getStateMachinesHelper()
                                 .getStateMachine(stateVertex));
//#endif 

} 

//#endif 


//#if 1726456238 
if(compositeState != null)//1
{ 

//#if -1610759544 
if(Model.getFacade().getContainer(stateVertex) != compositeState)//1
{ 

//#if 1142760901 
Model.getStateMachinesHelper().setContainer(stateVertex,
                        compositeState);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

