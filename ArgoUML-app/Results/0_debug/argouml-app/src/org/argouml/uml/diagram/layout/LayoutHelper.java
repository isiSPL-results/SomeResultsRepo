
//#if 446065602 
// Compilation Unit of /LayoutHelper.java 
 

//#if -736279976 
package org.argouml.uml.diagram.layout;
//#endif 


//#if 1374214019 
import java.awt.Point;
//#endif 


//#if -915189884 
import java.awt.Rectangle;
//#endif 


//#if -2134542567 
import java.awt.Polygon;
//#endif 


//#if 536927816 
public class LayoutHelper  { 

//#if -226593782 
public static final int NORTH = 0;
//#endif 


//#if -1403065844 
public static final int NORTHEAST = 1;
//#endif 


//#if -81898174 
public static final int EAST = 2;
//#endif 


//#if -1347192671 
public static final int SOUTHEAST = 4;
//#endif 


//#if -16588998 
public static final int SOUTH = 8;
//#endif 


//#if 1747559566 
public static final int SOUTHWEST = 16;
//#endif 


//#if -1977980267 
public static final int WEST = 32;
//#endif 


//#if 15498829 
public static final int NORTHWEST = 64;
//#endif 


//#if -2077136325 
public static Point getPointOnPerimeter(Rectangle rect, int direction,
                                            double xOff, double yOff)
    { 

//#if -596963117 
double x = 0;
//#endif 


//#if -596933326 
double y = 0;
//#endif 


//#if 108082079 
if(direction == NORTH
                || direction == NORTHEAST
                || direction == NORTHWEST)//1
{ 

//#if -2022883646 
y = rect.getY();
//#endif 

} 

//#endif 


//#if 103661175 
if(direction == SOUTH
                || direction == SOUTHWEST
                || direction == SOUTHEAST)//1
{ 

//#if 1556303523 
y = rect.getY() + rect.getHeight();
//#endif 

} 

//#endif 


//#if 214986419 
if(direction == EAST
                || direction == WEST)//1
{ 

//#if -696491745 
y = rect.getY() + rect.getHeight() / 2.0;
//#endif 

} 

//#endif 


//#if -1057497947 
if(direction == NORTHWEST
                || direction == WEST
                || direction == SOUTHWEST)//1
{ 

//#if -2124573163 
x = rect.getX();
//#endif 

} 

//#endif 


//#if -978240077 
if(direction == NORTHEAST
                || direction == EAST
                || direction == SOUTHEAST)//1
{ 

//#if -1040660358 
x = rect.getX() + rect.getWidth();
//#endif 

} 

//#endif 


//#if -699681195 
if(direction == NORTH || direction == SOUTH)//1
{ 

//#if -7636320 
x = rect.getX() + rect.getWidth() / 2.0;
//#endif 

} 

//#endif 


//#if -2117577204 
x += xOff;
//#endif 


//#if -373843348 
y += yOff;
//#endif 


//#if 689943849 
return new Point((int) x, (int) y);
//#endif 

} 

//#endif 


//#if 1574722912 
public static Polygon getRoutingPolygonStraightLine(Point start, Point end)
    { 

//#if 932000338 
return getRoutingPolygonStraightLineWithOffset(start, end, 0);
//#endif 

} 

//#endif 


//#if -1623004271 
public static Polygon getRoutingPolygonStraightLineWithOffset(Point start,
            Point end, int offset)
    { 

//#if 1519065807 
Polygon newPoly = new Polygon();
//#endif 


//#if 1299243308 
newPoly.addPoint((int) start.getX(), (int) start.getY());
//#endif 


//#if -928417832 
if(offset != 0)//1
{ 

//#if 102215770 
double newY = 0.0;
//#endif 


//#if 143323480 
if(offset < 0)//1
{ 

//#if -537890193 
newY =
                    Math.min(start.getY() + offset, end.getY() + offset);
//#endif 

} 

//#endif 


//#if 200581782 
if(offset > 0)//1
{ 

//#if 2019404651 
newY =
                    Math.max(start.getY() + offset, end.getY() + offset);
//#endif 

} 

//#endif 


//#if -479436067 
newPoly.addPoint((int) start.getX(), (int) newY);
//#endif 


//#if 1672143108 
newPoly.addPoint((int) end.getX(), (int) newY);
//#endif 

} 

//#endif 


//#if -1264657862 
newPoly.addPoint((int) end.getX(), (int) end.getY());
//#endif 


//#if 1267152249 
return newPoly;
//#endif 

} 

//#endif 


//#if 1616988410 
public static Point getPointOnPerimeter(Rectangle rect, int direction)
    { 

//#if 691006820 
return getPointOnPerimeter(rect, direction, 0, 0);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

