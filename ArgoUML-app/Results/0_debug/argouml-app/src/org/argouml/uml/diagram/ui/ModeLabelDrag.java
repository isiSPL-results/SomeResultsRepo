
//#if 1567577210 
// Compilation Unit of /ModeLabelDrag.java 
 

//#if 2071213712 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -2104041993 
import java.util.List;
//#endif 


//#if 209965409 
import java.awt.Point;
//#endif 


//#if -2135272932 
import java.awt.event.MouseEvent;
//#endif 


//#if -2046690933 
import org.tigris.gef.base.Editor;
//#endif 


//#if -1659452495 
import org.tigris.gef.base.FigModifyingModeImpl;
//#endif 


//#if -1093110658 
import org.tigris.gef.base.PathItemPlacementStrategy;
//#endif 


//#if 737078289 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -2075890988 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if -602845065 
public class ModeLabelDrag extends 
//#if 1390574120 
FigModifyingModeImpl
//#endif 

  { 

//#if -782065691 
private Fig dragFig = null;
//#endif 


//#if -1800882407 
private FigEdge figEdge = null;
//#endif 


//#if -910702002 
private Point dragBasePoint = new Point(0, 0);
//#endif 


//#if 1596018395 
private int deltax = 0;
//#endif 


//#if 1596048186 
private int deltay = 0;
//#endif 


//#if 590416226 
public ModeLabelDrag(Editor editor)
    { 

//#if 2127548603 
super(editor);
//#endif 

} 

//#endif 


//#if 1071759681 
public String instructions()
    { 

//#if -763721129 
return "  ";
//#endif 

} 

//#endif 


//#if 862533919 
public void mouseDragged(MouseEvent me)
    { 

//#if -98690612 
if(dragFig != null)//1
{ 

//#if -1211703848 
me = editor.translateMouseEvent(me);
//#endif 


//#if 1580246196 
Point newPoint = me.getPoint();
//#endif 


//#if 982793782 
newPoint.translate(-deltax, -deltay);
//#endif 


//#if -614565729 
PathItemPlacementStrategy pips
                = figEdge.getPathItemPlacementStrategy(dragFig);
//#endif 


//#if 836624887 
pips.setPoint(newPoint);
//#endif 


//#if 794178830 
newPoint = pips.getPoint();
//#endif 


//#if -1400583630 
int dx = newPoint.x - dragBasePoint.x;
//#endif 


//#if -1704554255 
int dy = newPoint.y - dragBasePoint.y;
//#endif 


//#if -1344348925 
dragBasePoint.setLocation(newPoint);
//#endif 


//#if 1025096986 
dragFig.translate(dx, dy);
//#endif 


//#if -1042378489 
me.consume();
//#endif 


//#if 920130459 
editor.damaged(dragFig);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 738223 
public void mousePressed(MouseEvent me)
    { 

//#if -909071086 
Point clickPoint = me.getPoint();
//#endif 


//#if -118104767 
Fig underMouse = editor.hit(clickPoint);
//#endif 


//#if 306258696 
if(underMouse instanceof FigEdge)//1
{ 

//#if -871815597 
List<Fig> figList = ((FigEdge)underMouse).getPathItemFigs();
//#endif 


//#if 346924230 
for (Fig fig : figList) //1
{ 

//#if 612367378 
if(fig.contains(clickPoint))//1
{ 

//#if -1711672015 
me.consume();
//#endif 


//#if 201875815 
dragFig = fig;
//#endif 


//#if -978433682 
dragBasePoint = fig.getCenter();
//#endif 


//#if -334686361 
deltax = clickPoint.x - dragBasePoint.x;
//#endif 


//#if -980958746 
deltay = clickPoint.y - dragBasePoint.y;
//#endif 


//#if 1541021213 
figEdge = (FigEdge) underMouse;
//#endif 


//#if 549715071 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 671534328 
public void mouseReleased(MouseEvent me)
    { 

//#if 1468293344 
if(dragFig != null)//1
{ 

//#if -1589357703 
dragFig = null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1929504732 
public ModeLabelDrag()
    { 

//#if -1841142672 
super();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

