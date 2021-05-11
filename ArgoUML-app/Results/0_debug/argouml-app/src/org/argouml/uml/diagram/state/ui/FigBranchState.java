
//#if 47665289 
// Compilation Unit of /FigBranchState.java 
 

//#if 2083978835 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if 1888383118 
import java.awt.Color;
//#endif 


//#if -2034495487 
import java.awt.Point;
//#endif 


//#if 2027559170 
import java.awt.Rectangle;
//#endif 


//#if -929648772 
import java.awt.event.MouseEvent;
//#endif 


//#if 1683853767 
import java.util.Iterator;
//#endif 


//#if -397664419 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -795951450 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -1937312255 
import org.tigris.gef.presentation.FigCircle;
//#endif 


//#if 1613224377 
public class FigBranchState extends 
//#if -1354376649 
FigStateVertex
//#endif 

  { 

//#if -524228994 
private static final int WIDTH = 24;
//#endif 


//#if -285573369 
private static final int HEIGHT = 24;
//#endif 


//#if 1654575972 
private FigCircle head;
//#endif 


//#if -1714482954 
private FigCircle bp;
//#endif 


//#if -657866806 
static final long serialVersionUID = 6572261327347541373L;
//#endif 


//#if 162477580 
@Override
    public void setLineWidth(int w)
    { 

//#if 1299765571 
head.setLineWidth(w);
//#endif 

} 

//#endif 


//#if 142420998 
@Override
    public boolean isFilled()
    { 

//#if -2132888484 
return true;
//#endif 

} 

//#endif 


//#if 1395869051 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 

//#if -1890932521 
if(getNameFig() == null)//1
{ 

//#if 441588154 
return;
//#endif 

} 

//#endif 


//#if -551418280 
Rectangle oldBounds = getBounds();
//#endif 


//#if 2054594162 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if -1330068058 
head.setBounds(x, y, w, h);
//#endif 


//#if -1783986199 
calcBounds();
//#endif 


//#if -125448684 
updateEdges();
//#endif 


//#if -116853595 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if -730158514 
@Override
    public Color getLineColor()
    { 

//#if 297809802 
return head.getLineColor();
//#endif 

} 

//#endif 


//#if 766986530 

//#if -1916828953 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigBranchState()
    { 

//#if 876066255 
super();
//#endif 


//#if -2092147957 
initFigs();
//#endif 

} 

//#endif 


//#if 1888075741 
@Override
    public int getLineWidth()
    { 

//#if 142390148 
return head.getLineWidth();
//#endif 

} 

//#endif 


//#if 1697198629 
@Override
    public void setFillColor(Color col)
    { 

//#if -279368733 
head.setFillColor(col);
//#endif 

} 

//#endif 


//#if -853717767 
@Override
    public void mouseClicked(MouseEvent me)
    { 
} 

//#endif 


//#if -993296368 
@Override
    public Object clone()
    { 

//#if -1822048432 
FigBranchState figClone = (FigBranchState) super.clone();
//#endif 


//#if -439334172 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if -1354589841 
figClone.setBigPort((FigCircle) it.next());
//#endif 


//#if -784607190 
figClone.head = (FigCircle) it.next();
//#endif 


//#if 138210691 
return figClone;
//#endif 

} 

//#endif 


//#if 24694980 
@Override
    public void setFilled(boolean f)
    { 
} 

//#endif 


//#if 872618201 

//#if 441959550 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigBranchState(@SuppressWarnings("unused") GraphModel gm,
                          Object node)
    { 

//#if 751053930 
this();
//#endif 


//#if -516442439 
setOwner(node);
//#endif 

} 

//#endif 


//#if -1384241260 
@Override
    public void setLineColor(Color col)
    { 

//#if 351116436 
head.setLineColor(col);
//#endif 

} 

//#endif 


//#if 615860817 
private void initFigs()
    { 

//#if -925578849 
setEditable(false);
//#endif 


//#if 941796687 
bp = new FigCircle(X0, Y0, WIDTH, HEIGHT, DEBUG_COLOR, DEBUG_COLOR);
//#endif 


//#if -1544526091 
setBigPort(bp);
//#endif 


//#if -1584706918 
head = new FigCircle(X0, Y0, WIDTH, HEIGHT, LINE_COLOR, FILL_COLOR);
//#endif 


//#if 1965479247 
addFig(getBigPort());
//#endif 


//#if -27505789 
addFig(head);
//#endif 


//#if 1206886353 
setBlinkPorts(false);
//#endif 

} 

//#endif 


//#if 596702366 
public FigBranchState(Object owner, Rectangle bounds,
                          DiagramSettings settings)
    { 

//#if -1433239070 
super(owner, bounds, settings);
//#endif 


//#if -81825993 
initFigs();
//#endif 

} 

//#endif 


//#if 860473321 
@Override
    public boolean isResizable()
    { 

//#if -1413193540 
return false;
//#endif 

} 

//#endif 


//#if -1697984426 
@Override
    public Point getClosestPoint(Point anotherPt)
    { 

//#if -820552830 
Point p = bp.connectionPoint(anotherPt);
//#endif 


//#if -1129185767 
return p;
//#endif 

} 

//#endif 


//#if 96327135 
@Override
    public Color getFillColor()
    { 

//#if 59149069 
return head.getFillColor();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

