package org.argouml.uml.diagram.ui;
import org.argouml.uml.diagram.UMLMutableGraphSupport;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Layer;
import org.tigris.gef.base.LayerManager;
import org.tigris.gef.base.ModeManager;
import org.tigris.gef.base.ModeCreatePolyEdge;
import org.tigris.gef.base.FigModifyingMode;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigEdge;
public class SelectionRerouteEdge extends SelectionEdgeClarifiers
  { 
private FigNodeModelElement sourceFig;
private FigNodeModelElement destFig;
private boolean armed;
private int pointIndex;
public void mouseReleased(MouseEvent me)
    { 
if(me.isConsumed() || !armed || pointIndex == -1)//1
{ 
armed = false;
super.mouseReleased(me);
return;
} 
int x = me.getX(), y = me.getY();
FigNodeModelElement newFig = null;
Rectangle mousePoint = new Rectangle(x - 5, y - 5, 5, 5);
Editor editor = Globals.curEditor();
LayerManager lm = editor.getLayerManager();
Layer active = lm.getActiveLayer();
Enumeration figs = active.elementsIn(mousePoint);
while (figs.hasMoreElements()) //1
{ 
Fig candidateFig = (Fig) figs.nextElement();
if(candidateFig instanceof FigNodeModelElement
                    && candidateFig.isSelectable())//1
{ 
newFig = (FigNodeModelElement) candidateFig;
} 
} 
if(newFig == null)//1
{ 
armed = false;
super.mouseReleased(me);
return;
} 
UMLMutableGraphSupport mgm =
            (UMLMutableGraphSupport) editor.getGraphModel();
FigNodeModelElement oldFig = null;
boolean isSource = false;
if(pointIndex == 0)//1
{ 
oldFig = sourceFig;
isSource = true;
} 
else
{ 
oldFig = destFig;
} 
if(mgm.canChangeConnectedNode(newFig.getOwner(),
                                       oldFig.getOwner(),
                                       this.getContent().getOwner()))//1
{ 
mgm.changeConnectedNode(newFig.getOwner(),
                                    oldFig.getOwner(),
                                    this.getContent().getOwner(),
                                    isSource);
} 
editor.getSelectionManager().deselect(getContent());
armed = false;
FigEdgeModelElement figEdge = (FigEdgeModelElement) getContent();
figEdge.determineFigNodes();
figEdge.computeRoute();
super.mouseReleased(me);
return;
} 
public void mousePressed(MouseEvent me)
    { 
sourceFig =
            (FigNodeModelElement) ((FigEdge) getContent()).getSourceFigNode();
destFig =
            (FigNodeModelElement) ((FigEdge) getContent()).getDestFigNode();
Rectangle mousePosition =
            new Rectangle(me.getX() - 5, me.getY() - 5, 10, 10);
pointIndex = -1;
int npoints = getContent().getNumPoints();
int[] xs = getContent().getXs();
int[] ys = getContent().getYs();
for (int i = 0; i < npoints; ++i) //1
{ 
if(mousePosition.contains(xs[i], ys[i]))//1
{ 
pointIndex = i;
super.mousePressed(me);
return;
} 
} 
super.mousePressed(me);
} 
public void mouseDragged(MouseEvent me)
    { 
Editor editor = Globals.curEditor();
ModeManager modeMgr = editor.getModeManager();
FigModifyingMode fMode = modeMgr.top();
if(!(fMode instanceof ModeCreatePolyEdge))//1
{ 
armed = true;
} 
super.mouseDragged(me);
} 
public SelectionRerouteEdge(FigEdgeModelElement feme)
    { 
super(feme);
pointIndex = -1;
} 

 } 
