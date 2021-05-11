package org.argouml.uml.diagram.state.ui;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.FigCircle;
public class FigBranchState extends FigStateVertex
  { 
private static final int WIDTH = 24;
private static final int HEIGHT = 24;
private FigCircle head;
private FigCircle bp;
static final long serialVersionUID = 6572261327347541373L;
@Override
    public void setLineWidth(int w)
    { 
head.setLineWidth(w);
} 
@Override
    public boolean isFilled()
    { 
return true;
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
head.setBounds(x, y, w, h);
calcBounds();
updateEdges();
firePropChange("bounds", oldBounds, getBounds());
} 
@Override
    public Color getLineColor()
    { 
return head.getLineColor();
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigBranchState()
    { 
super();
initFigs();
} 
@Override
    public int getLineWidth()
    { 
return head.getLineWidth();
} 
@Override
    public void setFillColor(Color col)
    { 
head.setFillColor(col);
} 
@Override
    public void mouseClicked(MouseEvent me)
    { 
} 
@Override
    public Object clone()
    { 
FigBranchState figClone = (FigBranchState) super.clone();
Iterator it = figClone.getFigs().iterator();
figClone.setBigPort((FigCircle) it.next());
figClone.head = (FigCircle) it.next();
return figClone;
} 
@Override
    public void setFilled(boolean f)
    { 
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigBranchState(@SuppressWarnings("unused") GraphModel gm,
                          Object node)
    { 
this();
setOwner(node);
} 
@Override
    public void setLineColor(Color col)
    { 
head.setLineColor(col);
} 
private void initFigs()
    { 
setEditable(false);
bp = new FigCircle(X0, Y0, WIDTH, HEIGHT, DEBUG_COLOR, DEBUG_COLOR);
setBigPort(bp);
head = new FigCircle(X0, Y0, WIDTH, HEIGHT, LINE_COLOR, FILL_COLOR);
addFig(getBigPort());
addFig(head);
setBlinkPorts(false);
} 
public FigBranchState(Object owner, Rectangle bounds,
                          DiagramSettings settings)
    { 
super(owner, bounds, settings);
initFigs();
} 
@Override
    public boolean isResizable()
    { 
return false;
} 
@Override
    public Point getClosestPoint(Point anotherPt)
    { 
Point p = bp.connectionPoint(anotherPt);
return p;
} 
@Override
    public Color getFillColor()
    { 
return head.getFillColor();
} 

 } 
