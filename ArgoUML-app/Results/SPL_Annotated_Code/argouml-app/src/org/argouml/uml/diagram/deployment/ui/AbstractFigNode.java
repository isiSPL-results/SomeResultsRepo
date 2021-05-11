// Compilation Unit of /AbstractFigNode.java 
 
package org.argouml.uml.diagram.deployment.ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.argouml.model.AssociationChangeEvent;
import org.argouml.model.AttributeChangeEvent;
import org.argouml.model.Model;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.ArgoFig;
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
import org.argouml.uml.diagram.ui.FigNodeModelElement;
import org.tigris.gef.base.Geometry;
import org.tigris.gef.base.Selection;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigCube;
import org.tigris.gef.presentation.FigRect;
import org.tigris.gef.presentation.FigText;
public abstract class AbstractFigNode extends FigNodeModelElement
  { 
protected static final int DEPTH = 20;
private FigCube cover;
private static final int DEFAULT_X = 10;
private static final int DEFAULT_Y = 10;
private static final int DEFAULT_WIDTH = 200;
private static final int DEFAULT_HEIGHT = 180;
@Override
    public boolean isFilled()
    { 
return cover.isFilled();
} 

@Override
    public void mouseClicked(MouseEvent me)
    { 
super.mouseClicked(me);
setLineColor(LINE_COLOR);
} 

@Override
    public void setLineWidth(int w)
    { 
cover.setLineWidth(w);
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public AbstractFigNode(Object element, int x, int y)
    { 
super(element, x, y);
} 

@Override
    public Point getClosestPoint(Point anotherPt)
    { 
Rectangle r = getBounds();
int[] xs = {
            r.x,
            r.x + DEPTH,
            r.x + r.width,
            r.x + r.width,
            r.x + r.width - DEPTH,
            r.x,
            r.x,
        };
int[] ys = {
            r.y + DEPTH,
            r.y,
            r.y,
            r.y + r.height - DEPTH,
            r.y + r.height,
            r.y + r.height,
            r.y + DEPTH,
        };
Point p = Geometry.ptClosestTo(xs, ys, 7, anotherPt);
return p;
} 

@Override
    public Selection makeSelection()
    { 
return new SelectionNode(this);
} 

@Override
    public Dimension getMinimumSize()
    { 
Dimension stereoDim = getStereotypeFig().getMinimumSize();
Dimension nameDim = getNameFig().getMinimumSize();
int w = Math.max(stereoDim.width, nameDim.width + 1) + DEPTH;
int h = stereoDim.height + nameDim.height + DEPTH;
w = Math.max(3 * DEPTH, w);
h = Math.max(3 * DEPTH, h);
return new Dimension(w, h);
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public AbstractFigNode()
    { 
super();
initFigs();
} 

@Override
    protected void updateStereotypeText()
    { 
getStereotypeFig().setOwner(getOwner());
} 

@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 
Set<Object[]> l = new HashSet<Object[]>();
if(newOwner != null)//1
{ 
l.add(new Object[] {newOwner, null});
Collection c = Model.getFacade().getStereotypes(newOwner);
Iterator i = c.iterator();
while (i.hasNext()) //1
{ 
Object st = i.next();
l.add(new Object[] {st, "name"});
} 

} 

updateElementListeners(l);
} 

public AbstractFigNode(Object owner, Rectangle bounds,
                           DiagramSettings settings)
    { 
super(owner, bounds, settings);
initFigs();
} 

@Override
    public Object clone()
    { 
AbstractFigNode figClone = (AbstractFigNode) super.clone();
Iterator it = figClone.getFigs().iterator();
figClone.setBigPort((FigRect) it.next());
figClone.cover = (FigCube) it.next();
it.next();
figClone.setNameFig((FigText) it.next());
return figClone;
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public AbstractFigNode(@SuppressWarnings("unused") GraphModel gm,
                           Object node)
    { 
this();
setOwner(node);
if(Model.getFacade().isAClassifier(node)
                && (Model.getFacade().getName(node) != null))//1
{ 
getNameFig().setText(Model.getFacade().getName(node));
} 

} 

@Override
    public void setEnclosingFig(Fig encloser)
    { 
if(encloser == null
                || (encloser != null
                    && Model.getFacade().isANode(encloser.getOwner())))//1
{ 
super.setEnclosingFig(encloser);
} 

if(getLayer() != null)//1
{ 
Collection contents = getLayer().getContents();
Collection<FigEdgeModelElement> bringToFrontList =
                new ArrayList<FigEdgeModelElement>();
for (Object o : contents) //1
{ 
if(o instanceof FigEdgeModelElement)//1
{ 
bringToFrontList.add((FigEdgeModelElement) o);
} 

} 

for (FigEdgeModelElement figEdge : bringToFrontList) //1
{ 
figEdge.getLayer().bringToFront(figEdge);
} 

} 

} 

@Override
    public void setFilled(boolean f)
    { 
cover.setFilled(f);
} 

@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 
if(getNameFig() == null)//1
{ 
return;
} 

Rectangle oldBounds = getBounds();
getBigPort().setBounds(x, y, w, h);
cover.setBounds(x, y + DEPTH, w - DEPTH, h - DEPTH);
Dimension stereoDim = getStereotypeFig().getMinimumSize();
Dimension nameDim = getNameFig().getMinimumSize();
getNameFig().setBounds(
            x + 4, y + DEPTH + stereoDim.height + 1,
            w - DEPTH - 8, nameDim.height);
getStereotypeFig().setBounds(x + 1, y + DEPTH + 1,
                                     w - DEPTH - 2, stereoDim.height);
_x = x;
_y = y;
_w = w;
_h = h;
firePropChange("bounds", oldBounds, getBounds());
updateEdges();
} 

@Override
    protected void modelChanged(PropertyChangeEvent mee)
    { 
super.modelChanged(mee);
if(mee instanceof AssociationChangeEvent
                || mee instanceof AttributeChangeEvent)//1
{ 
renderingChanged();
updateListeners(getOwner(), getOwner());
damage();
} 

} 

@Override
    public boolean getUseTrapRect()
    { 
return true;
} 

@Override
    public void setLineColor(Color c)
    { 
cover.setLineColor(c);
} 

private void initFigs()
    { 
setBigPort(new CubePortFigRect(DEFAULT_X, DEFAULT_Y - DEPTH,
                                       DEFAULT_WIDTH + DEPTH,
                                       DEFAULT_HEIGHT + DEPTH, DEPTH));
getBigPort().setFilled(false);
getBigPort().setLineWidth(0);
cover = new FigCube(DEFAULT_X, DEFAULT_Y, DEFAULT_WIDTH,
                            DEFAULT_HEIGHT, LINE_COLOR, FILL_COLOR);
getNameFig().setLineWidth(0);
getNameFig().setFilled(false);
getNameFig().setJustification(0);
addFig(getBigPort());
addFig(cover);
addFig(getStereotypeFig());
addFig(getNameFig());
} 

 } 


