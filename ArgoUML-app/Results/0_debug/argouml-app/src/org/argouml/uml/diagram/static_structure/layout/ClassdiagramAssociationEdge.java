
//#if -901695132 
// Compilation Unit of /ClassdiagramAssociationEdge.java 
 

//#if -1768567534 
package org.argouml.uml.diagram.static_structure.layout;
//#endif 


//#if -119665289 
import java.awt.Point;
//#endif 


//#if -1687832450 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if -1679195943 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if -1677340593 
import org.tigris.gef.presentation.FigPoly;
//#endif 


//#if -1720089665 
public class ClassdiagramAssociationEdge extends 
//#if -1092554931 
ClassdiagramEdge
//#endif 

  { 

//#if 1094907712 
private static final int SELF_SIZE = 30;
//#endif 


//#if 2036955438 
public ClassdiagramAssociationEdge(FigEdge edge)
    { 

//#if -1259505331 
super(edge);
//#endif 

} 

//#endif 


//#if 1140895069 
public void layout()
    { 

//#if -1112273986 
if(getDestFigNode() == getSourceFigNode())//1
{ 

//#if -966784421 
Point centerRight = getCenterRight((FigNode) getSourceFigNode());
//#endif 


//#if 698876889 
int yoffset = getSourceFigNode().getHeight() / 2;
//#endif 


//#if -483003338 
yoffset = java.lang.Math.min(SELF_SIZE, yoffset);
//#endif 


//#if -1548349465 
FigPoly fig = getUnderlyingFig();
//#endif 


//#if 687055345 
fig.addPoint(centerRight);
//#endif 


//#if -1019699478 
fig.addPoint(centerRight.x + SELF_SIZE, centerRight.y);
//#endif 


//#if 1918790251 
fig.addPoint(centerRight.x + SELF_SIZE, centerRight.y + yoffset);
//#endif 


//#if -995204254 
fig.addPoint(centerRight.x, centerRight.y + yoffset);
//#endif 


//#if -39078272 
fig.setFilled(false);
//#endif 


//#if -79361337 
fig.setSelfLoop(true);
//#endif 


//#if 795955734 
getCurrentEdge().setFig(fig);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -23359274 
private Point getCenterRight(FigNode fig)
    { 

//#if 1284978187 
Point center = fig.getCenter();
//#endif 


//#if -365413694 
return new Point(center.x + fig.getWidth() / 2, center.y);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

