// Compilation Unit of /CubePortFigRect.java 
 
package org.argouml.uml.diagram.deployment.ui;
import java.awt.Point;
import java.awt.Rectangle;
import org.tigris.gef.base.Geometry;
import org.tigris.gef.presentation.FigRect;
class CubePortFigRect extends FigRect
  { 
private int d;
private static final long serialVersionUID = -136360467045533658L;
public Point getClosestPoint(Point anotherPt)
    { 
Rectangle r = getBounds();
int[] xs = {
            r.x,
            r.x + d,
            r.x + r.width,
            r.x + r.width,
            r.x + r.width - d,
            r.x,
            r.x,
        };
int[] ys = {
            r.y + d,
            r.y,
            r.y,
            r.y + r.height - d,
            r.y + r.height,
            r.y + r.height,
            r.y + d,
        };
Point p =
            Geometry.ptClosestTo(
                xs,
                ys,
                7, anotherPt);
return p;
} 

public CubePortFigRect(int x, int y, int w, int h, int depth)
    { 
super(x, y, w, h);
d = depth;
} 

 } 


