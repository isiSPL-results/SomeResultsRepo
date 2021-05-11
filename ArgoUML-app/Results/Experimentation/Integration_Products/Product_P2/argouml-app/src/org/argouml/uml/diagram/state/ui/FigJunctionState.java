package org.argouml.uml.diagram.state.ui;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.base.Geometry;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.FigDiamond;
public class FigJunctionState extends FigStateVertex
  { 
private static final int X = 0;
private static final int Y = 0;
private static final int WIDTH = 32;
private static final int HEIGHT = 32;
private FigDiamond head;
private static final long serialVersionUID = -5845934640541945686L;
@Override
    public Color getLineColor()
    { 
return head.getLineColor();
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigJunctionState(@SuppressWarnings("unused") GraphModel gm,
                            Object node)
    { 
this();
setOwner(node);
} 
private void initFigs()
    { 
setEditable(false);
setBigPort(new FigDiamond(X, Y, WIDTH, HEIGHT, false,
                                  DEBUG_COLOR, DEBUG_COLOR));
head = new FigDiamond(X, Y, WIDTH, HEIGHT, false,
                              LINE_COLOR, FILL_COLOR);
addFig(getBigPort());
addFig(head);
setBlinkPorts(false);
} 
public FigJunctionState(Object owner, Rectangle bounds,
                            DiagramSettings settings)
    { 
super(owner, bounds, settings);
initFigs();
} 
@Override
    public void setFillColor(Color col)
    { 
head.setFillColor(col);
} 
@Override
    public Object clone()
    { 
FigJunctionState figClone = (FigJunctionState) super.clone();
Iterator it = figClone.getFigs().iterator();
figClone.setBigPort((FigDiamond) it.next());
figClone.head = (FigDiamond) it.next();
return figClone;
} 
@Override
    public void setLineWidth(int w)
    { 
head.setLineWidth(w);
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
    public void setFilled(boolean f)
    { 
} 
@Override
    public boolean isResizable()
    { 
return false;
} 
@Override
    public void setLineColor(Color col)
    { 
head.setLineColor(col);
} 
@Override
    public int getLineWidth()
    { 
return head.getLineWidth();
} 
@Override
    public void mouseClicked(MouseEvent me) { 
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigJunctionState()
    { 
super();
initFigs();
} 
@Override
    public Point getClosestPoint(Point anotherPt)
    { 
Rectangle r = getBounds();
int[] xs = {r.x + r.width / 2,
                    r.x + r.width,
                    r.x + r.width / 2,
                    r.x,
                    r.x + r.width / 2,
                   };
int[] ys = {r.y,
                    r.y + r.height / 2,
                    r.y + r.height,
                    r.y + r.height / 2,
                    r.y,
                   };
Point p =
            Geometry.ptClosestTo(
                xs,
                ys,
                5,
                anotherPt);
return p;
} 
@Override
    public boolean isFilled()
    { 
return true;
} 
@Override
    public Color getFillColor()
    { 
return head.getFillColor();
} 

 } 
