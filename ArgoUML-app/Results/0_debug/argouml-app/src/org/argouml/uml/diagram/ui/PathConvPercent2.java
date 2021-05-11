
//#if 1342464914 
// Compilation Unit of /PathConvPercent2.java 
 

//#if -1008131751 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 987501560 
import java.awt.Point;
//#endif 


//#if 702364310 
import org.tigris.gef.base.PathConv;
//#endif 


//#if 116345434 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1658012715 
public class PathConvPercent2 extends 
//#if 1058143563 
PathConv
//#endif 

  { 

//#if 938934941 
private Fig itemFig;
//#endif 


//#if -1283502636 
private int percent;
//#endif 


//#if -1187977974 
private int offset;
//#endif 


//#if -1985199382 
private static final long serialVersionUID = -8079350336685789199L;
//#endif 


//#if -45198681 
public void setClosestPoint(Point newPoint)
    { 
} 

//#endif 


//#if -267977604 
public void stuffPoint(Point res)
    { 

//#if -1806738992 
int figLength = _pathFigure.getPerimeterLength();
//#endif 


//#if -900775911 
if(figLength < 10)//1
{ 

//#if -2089886303 
res.setLocation(_pathFigure.getCenter());
//#endif 


//#if -1910894125 
return;
//#endif 

} 

//#endif 


//#if -1164662469 
int pointToGet = (figLength * percent) / 100;
//#endif 


//#if -1205663988 
_pathFigure.stuffPointAlongPerimeter(pointToGet, res);
//#endif 


//#if -1870545443 
applyOffsetAmount(_pathFigure.pointAlongPerimeter(pointToGet + 5),
                          _pathFigure.pointAlongPerimeter(pointToGet - 5), offset, res);
//#endif 

} 

//#endif 


//#if 1856488065 
private double tanh(double x)
    { 

//#if 1601492687 
return ((Math.exp(x) - Math.exp(-x)) / 2)
               / ((Math.exp(x) + Math.exp(-x)) / 2);
//#endif 

} 

//#endif 


//#if -1261905303 
public PathConvPercent2(Fig theFig, Fig theItemFig, int newPercent,
                            int newOffset)
    { 

//#if 307630412 
super(theFig);
//#endif 


//#if 982791253 
itemFig = theItemFig;
//#endif 


//#if 1814709462 
setPercentOffset(newPercent, newOffset);
//#endif 

} 

//#endif 


//#if 205735670 
protected void applyOffsetAmount(
        Point p1, Point p2,
        int theOffset, Point res)
    { 

//#if -1091913091 
int recipnumerator = (p1.x - p2.x) * -1;
//#endif 


//#if 842047118 
int recipdenominator = (p1.y - p2.y);
//#endif 


//#if -1980288039 
if(recipdenominator == 0 && recipnumerator == 0)//1
{ 

//#if -425884156 
return;
//#endif 

} 

//#endif 


//#if -2005911959 
double len =
            Math.sqrt(recipnumerator * recipnumerator
                      + recipdenominator * recipdenominator);
//#endif 


//#if -1201808281 
int dx = (int) ((recipdenominator * theOffset) / len);
//#endif 


//#if -1732381437 
int dy = (int) ((recipnumerator * theOffset) / len);
//#endif 


//#if 221803517 
res.x += Math.abs(dx);
//#endif 


//#if -1568593377 
res.y -= Math.abs(dy);
//#endif 


//#if -1605675973 
int width = itemFig.getWidth() / 2;
//#endif 


//#if 1517295382 
if(recipnumerator != 0)//1
{ 

//#if -1025757823 
double slope = (double) recipdenominator / (double) recipnumerator;
//#endif 


//#if -1804569372 
double factor = tanh(slope);
//#endif 


//#if -510012339 
res.x += (Math.abs(factor) * width);
//#endif 

} 
else
{ 

//#if -1085399603 
res.x += width;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 178398186 
public void setPercentOffset(int newPercent, int newOffset)
    { 

//#if -508593143 
percent = newPercent;
//#endif 


//#if -1418533411 
offset = newOffset;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

