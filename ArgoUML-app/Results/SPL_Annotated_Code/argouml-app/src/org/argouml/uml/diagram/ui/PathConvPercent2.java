// Compilation Unit of /PathConvPercent2.java 
 
package org.argouml.uml.diagram.ui;
import java.awt.Point;
import org.tigris.gef.base.PathConv;
import org.tigris.gef.presentation.Fig;
public class PathConvPercent2 extends PathConv
  { 
private Fig itemFig;
private int percent;
private int offset;
private static final long serialVersionUID = -8079350336685789199L;
public void setClosestPoint(Point newPoint)
    { 
} 

public void stuffPoint(Point res)
    { 
int figLength = _pathFigure.getPerimeterLength();
if(figLength < 10)//1
{ 
res.setLocation(_pathFigure.getCenter());
return;
} 

int pointToGet = (figLength * percent) / 100;
_pathFigure.stuffPointAlongPerimeter(pointToGet, res);
applyOffsetAmount(_pathFigure.pointAlongPerimeter(pointToGet + 5),
                          _pathFigure.pointAlongPerimeter(pointToGet - 5), offset, res);
} 

private double tanh(double x)
    { 
return ((Math.exp(x) - Math.exp(-x)) / 2)
               / ((Math.exp(x) + Math.exp(-x)) / 2);
} 

public PathConvPercent2(Fig theFig, Fig theItemFig, int newPercent,
                            int newOffset)
    { 
super(theFig);
itemFig = theItemFig;
setPercentOffset(newPercent, newOffset);
} 

protected void applyOffsetAmount(
        Point p1, Point p2,
        int theOffset, Point res)
    { 
int recipnumerator = (p1.x - p2.x) * -1;
int recipdenominator = (p1.y - p2.y);
if(recipdenominator == 0 && recipnumerator == 0)//1
{ 
return;
} 

double len =
            Math.sqrt(recipnumerator * recipnumerator
                      + recipdenominator * recipdenominator);
int dx = (int) ((recipdenominator * theOffset) / len);
int dy = (int) ((recipnumerator * theOffset) / len);
res.x += Math.abs(dx);
res.y -= Math.abs(dy);
int width = itemFig.getWidth() / 2;
if(recipnumerator != 0)//1
{ 
double slope = (double) recipdenominator / (double) recipnumerator;
double factor = tanh(slope);
res.x += (Math.abs(factor) * width);
} 
else
{ 
res.x += width;
} 

} 

public void setPercentOffset(int newPercent, int newOffset)
    { 
percent = newPercent;
offset = newOffset;
} 

 } 


