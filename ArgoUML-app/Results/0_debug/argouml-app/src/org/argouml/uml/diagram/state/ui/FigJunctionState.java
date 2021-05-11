
//#if -545746185 
// Compilation Unit of /FigJunctionState.java 
 

//#if 586292912 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if 55401297 
import java.awt.Color;
//#endif 


//#if 427489988 
import java.awt.Point;
//#endif 


//#if 1758456389 
import java.awt.Rectangle;
//#endif 


//#if -258835239 
import java.awt.event.MouseEvent;
//#endif 


//#if 1414750986 
import java.util.Iterator;
//#endif 


//#if 1439876602 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1129422857 
import org.tigris.gef.base.Geometry;
//#endif 


//#if 1700811331 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -542075564 
import org.tigris.gef.presentation.FigDiamond;
//#endif 


//#if 1503256906 
public class FigJunctionState extends 
//#if 802433156 
FigStateVertex
//#endif 

  { 

//#if -1699891513 
private static final int X = 0;
//#endif 


//#if -1699861722 
private static final int Y = 0;
//#endif 


//#if -1978991026 
private static final int WIDTH = 32;
//#endif 


//#if 1861416925 
private static final int HEIGHT = 32;
//#endif 


//#if 482545179 
private FigDiamond head;
//#endif 


//#if -1988974577 
private static final long serialVersionUID = -5845934640541945686L;
//#endif 


//#if -422064101 
@Override
    public Color getLineColor()
    { 

//#if -1893550141 
return head.getLineColor();
//#endif 

} 

//#endif 


//#if 746526714 

//#if 790307055 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigJunctionState(@SuppressWarnings("unused") GraphModel gm,
                            Object node)
    { 

//#if 533471820 
this();
//#endif 


//#if 1071950491 
setOwner(node);
//#endif 

} 

//#endif 


//#if 1657650020 
private void initFigs()
    { 

//#if 978985206 
setEditable(false);
//#endif 


//#if -1623549898 
setBigPort(new FigDiamond(X, Y, WIDTH, HEIGHT, false,
                                  DEBUG_COLOR, DEBUG_COLOR));
//#endif 


//#if 223085284 
head = new FigDiamond(X, Y, WIDTH, HEIGHT, false,
                              LINE_COLOR, FILL_COLOR);
//#endif 


//#if -1699499290 
addFig(getBigPort());
//#endif 


//#if 1999613978 
addFig(head);
//#endif 


//#if 1836875112 
setBlinkPorts(false);
//#endif 

} 

//#endif 


//#if -1065097373 
public FigJunctionState(Object owner, Rectangle bounds,
                            DiagramSettings settings)
    { 

//#if -953346869 
super(owner, bounds, settings);
//#endif 


//#if -10151328 
initFigs();
//#endif 

} 

//#endif 


//#if 452549560 
@Override
    public void setFillColor(Color col)
    { 

//#if -24577654 
head.setFillColor(col);
//#endif 

} 

//#endif 


//#if 372786077 
@Override
    public Object clone()
    { 

//#if 1864190697 
FigJunctionState figClone = (FigJunctionState) super.clone();
//#endif 


//#if 1658987609 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if 524960970 
figClone.setBigPort((FigDiamond) it.next());
//#endif 


//#if -966394985 
figClone.head = (FigDiamond) it.next();
//#endif 


//#if 1237135160 
return figClone;
//#endif 

} 

//#endif 


//#if 258023711 
@Override
    public void setLineWidth(int w)
    { 

//#if -135380264 
head.setLineWidth(w);
//#endif 

} 

//#endif 


//#if -1733913336 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 

//#if 1499766102 
if(getNameFig() == null)//1
{ 

//#if 832849114 
return;
//#endif 

} 

//#endif 


//#if -1590927465 
Rectangle oldBounds = getBounds();
//#endif 


//#if -105419501 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if 996066631 
head.setBounds(x, y, w, h);
//#endif 


//#if 1839727336 
calcBounds();
//#endif 


//#if 540521205 
updateEdges();
//#endif 


//#if 1326378980 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if -1308342255 
@Override
    public void setFilled(boolean f)
    { 
} 

//#endif 


//#if 1821465532 
@Override
    public boolean isResizable()
    { 

//#if 568488719 
return false;
//#endif 

} 

//#endif 


//#if 1666076967 
@Override
    public void setLineColor(Color col)
    { 

//#if 1005180916 
head.setLineColor(col);
//#endif 

} 

//#endif 


//#if -274729750 
@Override
    public int getLineWidth()
    { 

//#if -1625694080 
return head.getLineWidth();
//#endif 

} 

//#endif 


//#if 1690858764 
@Override
    public void mouseClicked(MouseEvent me) { 
} 

//#endif 


//#if -842186109 

//#if -1540837047 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigJunctionState()
    { 

//#if -1931294506 
super();
//#endif 


//#if -278423900 
initFigs();
//#endif 

} 

//#endif 


//#if 1821269545 
@Override
    public Point getClosestPoint(Point anotherPt)
    { 

//#if -509558425 
Rectangle r = getBounds();
//#endif 


//#if 797378417 
int[] xs = {r.x + r.width / 2,
                    r.x + r.width,
                    r.x + r.width / 2,
                    r.x,
                    r.x + r.width / 2,
                   };
//#endif 


//#if -1350687860 
int[] ys = {r.y,
                    r.y + r.height / 2,
                    r.y + r.height,
                    r.y + r.height / 2,
                    r.y,
                   };
//#endif 


//#if 2082676264 
Point p =
            Geometry.ptClosestTo(
                xs,
                ys,
                5,
                anotherPt);
//#endif 


//#if -817534019 
return p;
//#endif 

} 

//#endif 


//#if -2020384493 
@Override
    public boolean isFilled()
    { 

//#if -1149153901 
return true;
//#endif 

} 

//#endif 


//#if 404421548 
@Override
    public Color getFillColor()
    { 

//#if 245504997 
return head.getFillColor();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

