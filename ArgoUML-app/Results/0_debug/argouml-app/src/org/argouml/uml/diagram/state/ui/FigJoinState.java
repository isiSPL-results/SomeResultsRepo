
//#if -597608467 
// Compilation Unit of /FigJoinState.java 
 

//#if 1257506735 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if -405402446 
import java.awt.Color;
//#endif 


//#if -1930493146 
import java.awt.Rectangle;
//#endif 


//#if 615568600 
import java.awt.event.MouseEvent;
//#endif 


//#if 2020768747 
import java.util.Iterator;
//#endif 


//#if 270250937 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 2054582018 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -1473557687 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if -1722213163 
public class FigJoinState extends 
//#if 861027070 
FigStateVertex
//#endif 

  { 

//#if 1382933153 
private static final int X = X0;
//#endif 


//#if 1383857635 
private static final int Y = Y0;
//#endif 


//#if -1008533823 
private static final int STATE_WIDTH = 80;
//#endif 


//#if -689149155 
private static final int HEIGHT = 7;
//#endif 


//#if -170039127 
private FigRect head;
//#endif 


//#if -1664312026 
static final long serialVersionUID = 2075803883819230367L;
//#endif 


//#if -1673872589 

//#if 207037670 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigJoinState()
    { 

//#if -349866920 
super();
//#endif 


//#if 534520802 
initFigs();
//#endif 

} 

//#endif 


//#if -1758297491 
@Override
    public void setLineColor(Color col)
    { 

//#if 1868319860 
head.setLineColor(col);
//#endif 

} 

//#endif 


//#if -1031052798 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 

//#if -610619824 
Rectangle oldBounds = getBounds();
//#endif 


//#if -860994547 
if(w > h)//1
{ 

//#if 1685080885 
h = HEIGHT;
//#endif 

} 
else
{ 

//#if -495176897 
w = HEIGHT;
//#endif 

} 

//#endif 


//#if 219346298 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if -1149197138 
head.setBounds(x, y, w, h);
//#endif 


//#if -266879519 
calcBounds();
//#endif 


//#if -339781860 
updateEdges();
//#endif 


//#if -102585187 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if 1323142398 
@Override
    public void setFillColor(Color col)
    { 

//#if 315014551 
head.setFillColor(col);
//#endif 

} 

//#endif 


//#if -979829 
@Override
    public void setFilled(boolean f)
    { 
} 

//#endif 


//#if 1303387364 
@Override
    public int getLineWidth()
    { 

//#if -2028257260 
return head.getLineWidth();
//#endif 

} 

//#endif 


//#if -1123642542 
@Override
    public void mouseClicked(MouseEvent me)
    { 
} 

//#endif 


//#if 1812384682 
private void initFigs()
    { 

//#if 883904356 
setEditable(false);
//#endif 


//#if -19284003 
setBigPort(new FigRect(X, Y, STATE_WIDTH, HEIGHT, DEBUG_COLOR,
                               DEBUG_COLOR));
//#endif 


//#if 1178934249 
head = new FigRect(X, Y, STATE_WIDTH, HEIGHT, LINE_COLOR,
                           SOLID_FILL_COLOR);
//#endif 


//#if 1417084372 
addFig(getBigPort());
//#endif 


//#if 1793837320 
addFig(head);
//#endif 


//#if 658491478 
setBlinkPorts(false);
//#endif 

} 

//#endif 


//#if 1698658455 
@Override
    public Object clone()
    { 

//#if 956687438 
FigJoinState figClone = (FigJoinState) super.clone();
//#endif 


//#if 974973458 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if -1474013355 
figClone.setBigPort((FigRect) it.next());
//#endif 


//#if -1635884284 
figClone.head = (FigRect) it.next();
//#endif 


//#if -217896399 
return figClone;
//#endif 

} 

//#endif 


//#if 854386021 
@Override
    public void setLineWidth(int w)
    { 

//#if -1976433452 
head.setLineWidth(w);
//#endif 

} 

//#endif 


//#if -442267379 
@Override
    public boolean isFilled()
    { 

//#if 328099957 
return true;
//#endif 

} 

//#endif 


//#if 25026965 
@Override
    public Color getLineColor()
    { 

//#if 35585637 
return head.getLineColor();
//#endif 

} 

//#endif 


//#if -884800342 

//#if 913647957 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigJoinState(@SuppressWarnings("unused") GraphModel gm,
                        Object node)
    { 

//#if 584497886 
this();
//#endif 


//#if -908160723 
setOwner(node);
//#endif 

} 

//#endif 


//#if 851512614 
@Override
    public Color getFillColor()
    { 

//#if -984780337 
return head.getFillColor();
//#endif 

} 

//#endif 


//#if -609170305 
public FigJoinState(Object owner, Rectangle bounds,
                        DiagramSettings settings)
    { 

//#if -862587997 
super(owner, bounds, settings);
//#endif 


//#if -1365475528 
initFigs();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

