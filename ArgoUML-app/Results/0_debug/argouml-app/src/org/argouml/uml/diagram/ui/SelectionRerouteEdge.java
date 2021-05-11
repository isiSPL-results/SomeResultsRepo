
//#if -1429085443 
// Compilation Unit of /SelectionRerouteEdge.java 
 

//#if -880930036 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 1794626836 
import org.argouml.uml.diagram.UMLMutableGraphSupport;
//#endif 


//#if -1950150042 
import java.awt.Rectangle;
//#endif 


//#if -1186390632 
import java.awt.event.MouseEvent;
//#endif 


//#if 459435126 
import java.util.Enumeration;
//#endif 


//#if 175392778 
import org.tigris.gef.base.Globals;
//#endif 


//#if 1598856591 
import org.tigris.gef.base.Editor;
//#endif 


//#if -997254199 
import org.tigris.gef.base.Layer;
//#endif 


//#if 912700160 
import org.tigris.gef.base.LayerManager;
//#endif 


//#if 1751002224 
import org.tigris.gef.base.ModeManager;
//#endif 


//#if 1854089108 
import org.tigris.gef.base.ModeCreatePolyEdge;
//#endif 


//#if -2094494731 
import org.tigris.gef.base.FigModifyingMode;
//#endif 


//#if 1920871053 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1540885328 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if 2135669209 
public class SelectionRerouteEdge extends 
//#if 1834302170 
SelectionEdgeClarifiers
//#endif 

  { 

//#if 132704395 
private FigNodeModelElement sourceFig;
//#endif 


//#if -2134813230 
private FigNodeModelElement destFig;
//#endif 


//#if 1412944744 
private boolean armed;
//#endif 


//#if -1081449878 
private int pointIndex;
//#endif 


//#if -519828170 
public void mouseReleased(MouseEvent me)
    { 

//#if 195202698 
if(me.isConsumed() || !armed || pointIndex == -1)//1
{ 

//#if 1124159927 
armed = false;
//#endif 


//#if 1242065696 
super.mouseReleased(me);
//#endif 


//#if 1793761998 
return;
//#endif 

} 

//#endif 


//#if -854716088 
int x = me.getX(), y = me.getY();
//#endif 


//#if -708212848 
FigNodeModelElement newFig = null;
//#endif 


//#if -2123666809 
Rectangle mousePoint = new Rectangle(x - 5, y - 5, 5, 5);
//#endif 


//#if 1520248298 
Editor editor = Globals.curEditor();
//#endif 


//#if -1817493907 
LayerManager lm = editor.getLayerManager();
//#endif 


//#if -1567658526 
Layer active = lm.getActiveLayer();
//#endif 


//#if -2073133908 
Enumeration figs = active.elementsIn(mousePoint);
//#endif 


//#if 1956990763 
while (figs.hasMoreElements()) //1
{ 

//#if 1029040992 
Fig candidateFig = (Fig) figs.nextElement();
//#endif 


//#if 1722515568 
if(candidateFig instanceof FigNodeModelElement
                    && candidateFig.isSelectable())//1
{ 

//#if -190981363 
newFig = (FigNodeModelElement) candidateFig;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1615776582 
if(newFig == null)//1
{ 

//#if 776264892 
armed = false;
//#endif 


//#if 904042149 
super.mouseReleased(me);
//#endif 


//#if -31225687 
return;
//#endif 

} 

//#endif 


//#if -118072709 
UMLMutableGraphSupport mgm =
            (UMLMutableGraphSupport) editor.getGraphModel();
//#endif 


//#if -834098455 
FigNodeModelElement oldFig = null;
//#endif 


//#if -2046708180 
boolean isSource = false;
//#endif 


//#if 856471375 
if(pointIndex == 0)//1
{ 

//#if -577967394 
oldFig = sourceFig;
//#endif 


//#if 57575433 
isSource = true;
//#endif 

} 
else
{ 

//#if 213886869 
oldFig = destFig;
//#endif 

} 

//#endif 


//#if -720474531 
if(mgm.canChangeConnectedNode(newFig.getOwner(),
                                       oldFig.getOwner(),
                                       this.getContent().getOwner()))//1
{ 

//#if -1459022411 
mgm.changeConnectedNode(newFig.getOwner(),
                                    oldFig.getOwner(),
                                    this.getContent().getOwner(),
                                    isSource);
//#endif 

} 

//#endif 


//#if 937081070 
editor.getSelectionManager().deselect(getContent());
//#endif 


//#if -1762682498 
armed = false;
//#endif 


//#if 1138453894 
FigEdgeModelElement figEdge = (FigEdgeModelElement) getContent();
//#endif 


//#if 1313264811 
figEdge.determineFigNodes();
//#endif 


//#if 390766423 
figEdge.computeRoute();
//#endif 


//#if -409059225 
super.mouseReleased(me);
//#endif 


//#if 1988254375 
return;
//#endif 

} 

//#endif 


//#if -1838808143 
public void mousePressed(MouseEvent me)
    { 

//#if 1210506804 
sourceFig =
            (FigNodeModelElement) ((FigEdge) getContent()).getSourceFigNode();
//#endif 


//#if 1874396930 
destFig =
            (FigNodeModelElement) ((FigEdge) getContent()).getDestFigNode();
//#endif 


//#if -1322088086 
Rectangle mousePosition =
            new Rectangle(me.getX() - 5, me.getY() - 5, 10, 10);
//#endif 


//#if 1145487040 
pointIndex = -1;
//#endif 


//#if -421917356 
int npoints = getContent().getNumPoints();
//#endif 


//#if -1335333186 
int[] xs = getContent().getXs();
//#endif 


//#if -1401416418 
int[] ys = getContent().getYs();
//#endif 


//#if 401416361 
for (int i = 0; i < npoints; ++i) //1
{ 

//#if 89558844 
if(mousePosition.contains(xs[i], ys[i]))//1
{ 

//#if 343289618 
pointIndex = i;
//#endif 


//#if 408403687 
super.mousePressed(me);
//#endif 


//#if 507049552 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1604600638 
super.mousePressed(me);
//#endif 

} 

//#endif 


//#if -977012447 
public void mouseDragged(MouseEvent me)
    { 

//#if 200442503 
Editor editor = Globals.curEditor();
//#endif 


//#if -939090160 
ModeManager modeMgr = editor.getModeManager();
//#endif 


//#if 968771968 
FigModifyingMode fMode = modeMgr.top();
//#endif 


//#if 958349983 
if(!(fMode instanceof ModeCreatePolyEdge))//1
{ 

//#if 897641479 
armed = true;
//#endif 

} 

//#endif 


//#if -2099458389 
super.mouseDragged(me);
//#endif 

} 

//#endif 


//#if -1512234797 
public SelectionRerouteEdge(FigEdgeModelElement feme)
    { 

//#if -499243448 
super(feme);
//#endif 


//#if 398930766 
pointIndex = -1;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

