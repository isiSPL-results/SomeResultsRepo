
//#if -42925226 
// Compilation Unit of /CubePortFigRect.java 
 

//#if 1456172689 
package org.argouml.uml.diagram.deployment.ui;
//#endif 


//#if 1154757757 
import java.awt.Point;
//#endif 


//#if 1830002558 
import java.awt.Rectangle;
//#endif 


//#if -383589886 
import org.tigris.gef.base.Geometry;
//#endif 


//#if 209185265 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if 1743658783 
class CubePortFigRect extends 
//#if 1822127434 
FigRect
//#endif 

  { 

//#if 1930830017 
private int d;
//#endif 


//#if 871551491 
private static final long serialVersionUID = -136360467045533658L;
//#endif 


//#if -257908242 
public Point getClosestPoint(Point anotherPt)
    { 

//#if 939712360 
Rectangle r = getBounds();
//#endif 


//#if -163052022 
int[] xs = {
            r.x,
            r.x + d,
            r.x + r.width,
            r.x + r.width,
            r.x + r.width - d,
            r.x,
            r.x,
        };
//#endif 


//#if -2130408708 
int[] ys = {
            r.y + d,
            r.y,
            r.y,
            r.y + r.height - d,
            r.y + r.height,
            r.y + r.height,
            r.y + d,
        };
//#endif 


//#if 1455527467 
Point p =
            Geometry.ptClosestTo(
                xs,
                ys,
                7, anotherPt);
//#endif 


//#if -1743442980 
return p;
//#endif 

} 

//#endif 


//#if -1330577686 
public CubePortFigRect(int x, int y, int w, int h, int depth)
    { 

//#if -197714860 
super(x, y, w, h);
//#endif 


//#if 40998862 
d = depth;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

