
//#if -344568728 
// Compilation Unit of /PathItemPlacement.java 
 

//#if -1775057509 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 1761938691 
import java.awt.Color;
//#endif 


//#if -471485984 
import java.awt.Dimension;
//#endif 


//#if -2032910491 
import java.awt.Graphics;
//#endif 


//#if 2134027382 
import java.awt.Point;
//#endif 


//#if -485264649 
import java.awt.Rectangle;
//#endif 


//#if -1103274418 
import java.awt.geom.Line2D;
//#endif 


//#if 253234482 
import org.apache.log4j.Logger;
//#endif 


//#if -718734695 
import org.tigris.gef.base.Globals;
//#endif 


//#if -1597497708 
import org.tigris.gef.base.PathConv;
//#endif 


//#if -1754727012 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1712013601 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if 1489011658 
public class PathItemPlacement extends 
//#if -1918108026 
PathConv
//#endif 

  { 

//#if 1978570692 
private static final Logger LOG = Logger.getLogger(PathItemPlacement.class);
//#endif 


//#if -219356741 
private boolean useCollisionCheck = true;
//#endif 


//#if 541546062 
private boolean useAngle = true;
//#endif 


//#if -1114334189 
private double angle = 90;
//#endif 


//#if -1015482856 
private Fig itemFig;
//#endif 


//#if 1057046863 
private int percent;
//#endif 


//#if -1212294454 
private int pathOffset;
//#endif 


//#if -1776782804 
private int vectorOffset;
//#endif 


//#if 1253007374 
private Point offset;
//#endif 


//#if -1738219765 
private final boolean swap = true;
//#endif 


//#if 713906361 
public PathItemPlacement(FigEdge pathFig, Fig theItemFig, int pathPercent,
                             int displacement)
    { 

//#if -681966267 
this(pathFig, theItemFig, pathPercent, 0, 90, displacement);
//#endif 

} 

//#endif 


//#if -164407042 
public void stuffPoint(Point result)
    { 

//#if -1114416438 
result = getPosition(result);
//#endif 

} 

//#endif 


//#if -1839506721 
private Point getPosition(Point result)
    { 

//#if 92776922 
Point anchor = getAnchorPosition();
//#endif 


//#if -900484115 
result.setLocation(anchor);
//#endif 


//#if 1148608294 
if(!useAngle)//1
{ 

//#if -302166632 
result.translate(offset.x, offset.y);
//#endif 


//#if 1549915466 
return result;
//#endif 

} 

//#endif 


//#if 418650790 
double slope = getSlope();
//#endif 


//#if 1627248222 
result.setLocation(applyOffset(slope, vectorOffset, anchor));
//#endif 


//#if 569822678 
if(useCollisionCheck)//1
{ 

//#if 166595425 
int increment = 2;
//#endif 


//#if 1113046908 
Dimension size = new Dimension(itemFig.getWidth(), itemFig
                                           .getHeight());
//#endif 


//#if 887864652 
FigEdge fp = (FigEdge) _pathFigure;
//#endif 


//#if 2124919064 
Point[] points = fp.getPoints();
//#endif 


//#if 1381584092 
if(intersects(points, result, size))//1
{ 

//#if 2035708845 
int scaledOffset = vectorOffset + increment;
//#endif 


//#if -49083969 
int limit = 20;
//#endif 


//#if -1815363595 
int count = 0;
//#endif 


//#if -146331394 
while (intersects(points, result, size) && count++ < limit) //1
{ 

//#if 1613647451 
result.setLocation(
                        applyOffset(slope, scaledOffset, anchor));
//#endif 


//#if -1798702911 
scaledOffset += increment;
//#endif 

} 

//#endif 


//#if -221670125 
if(false)//1
{ 

//#if 463354403 
LOG.debug("Retry limit exceeded.  Trying other side");
//#endif 


//#if 653235391 
result.setLocation(anchor);
//#endif 


//#if -798136099 
result.setLocation(
                        applyOffset(slope, -vectorOffset, anchor));
//#endif 


//#if -701341117 
count = 0;
//#endif 


//#if -1155497305 
scaledOffset = -scaledOffset;
//#endif 


//#if -2125511385 
while (intersects(points, result, size)
                            && count++ < limit) //1
{ 

//#if -756123368 
result.setLocation(
                            applyOffset(slope, scaledOffset, anchor));
//#endif 


//#if 1219582756 
scaledOffset += increment;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1642001362 
return result;
//#endif 

} 

//#endif 


//#if 2119335915 
private Point intersection(Line2D m, Line2D n)
    { 

//#if -2077718430 
double d = (n.getY2() - n.getY1()) * (m.getX2() - m.getX1())
                   - (n.getX2() - n.getX1()) * (m.getY2() - m.getY1());
//#endif 


//#if -443807739 
double a = (n.getX2() - n.getX1()) * (m.getY1() - n.getY1())
                   - (n.getY2() - n.getY1()) * (m.getX1() - n.getX1());
//#endif 


//#if -355956377 
double as = a / d;
//#endif 


//#if -317866390 
double x = m.getX1() + as * (m.getX2() - m.getX1());
//#endif 


//#if -458689528 
double y = m.getY1() + as * (m.getY2() - m.getY1());
//#endif 


//#if 84003951 
return new Point((int) x, (int) y);
//#endif 

} 

//#endif 


//#if -633803586 
public void setDisplacementAngle(double offsetAngle)
    { 

//#if 1511521666 
angle = offsetAngle * Math.PI / 180.0;
//#endif 


//#if -937829078 
useAngle = true;
//#endif 

} 

//#endif 


//#if -174614117 
public Point getAnchorPosition()
    { 

//#if -305042663 
int pathDistance = getPathDistance();
//#endif 


//#if -2139937545 
Point anchor = new Point();
//#endif 


//#if 2088406638 
_pathFigure.stuffPointAlongPerimeter(pathDistance, anchor);
//#endif 


//#if 1643792987 
return anchor;
//#endif 

} 

//#endif 


//#if -1496934523 
public void setDisplacementVector(double vectorAngle,
                                      int vectorDistance)
    { 

//#if -1887334676 
setDisplacementAngle(vectorAngle);
//#endif 


//#if -773818596 
setDisplacementDistance(vectorDistance);
//#endif 

} 

//#endif 


//#if 146597185 
public void paint(Graphics g)
    { 

//#if -1047707143 
final Point p1 = getAnchorPosition();
//#endif 


//#if -852978618 
Point p2 = getPoint();
//#endif 


//#if -593787657 
Rectangle r = itemFig.getBounds();
//#endif 


//#if 1438498288 
Color c = Globals.getPrefs().handleColorFor(itemFig);
//#endif 


//#if -1723888845 
c = new Color(c.getRed(), c.getGreen(), c.getBlue(), 100);
//#endif 


//#if -830621788 
g.setColor(c);
//#endif 


//#if -161778688 
r.grow(2, 2);
//#endif 


//#if 1723113565 
g.fillRoundRect(r.x, r.y, r.width, r.height, 8, 8);
//#endif 


//#if 1514269054 
if(r.contains(p2))//1
{ 

//#if -490414824 
p2 = getRectLineIntersection(r, p1, p2);
//#endif 

} 

//#endif 


//#if -570136954 
g.drawLine(p1.x, p1.y, p2.x, p2.y);
//#endif 

} 

//#endif 


//#if -1559270211 
private double getSlope()
    { 

//#if -1349243345 
final int slopeSegLen = 40;
//#endif 


//#if -1827310145 
int pathLength = _pathFigure.getPerimeterLength();
//#endif 


//#if 152874979 
int pathDistance = getPathDistance();
//#endif 


//#if -1996950515 
int d1 = Math.max(0, pathDistance - slopeSegLen / 2);
//#endif 


//#if 2127960709 
int d2 = Math.min(pathLength - 1, d1 + slopeSegLen);
//#endif 


//#if 1601209609 
if(d1 == d2)//1
{ 

//#if -328027808 
return 0;
//#endif 

} 

//#endif 


//#if -1891030514 
Point p1 = _pathFigure.pointAlongPerimeter(d1);
//#endif 


//#if -258225554 
Point p2 = _pathFigure.pointAlongPerimeter(d2);
//#endif 


//#if -258617855 
double theta = getSlope(p1, p2);
//#endif 


//#if -1650752302 
return theta;
//#endif 

} 

//#endif 


//#if -302946683 
public double getAngle()
    { 

//#if -2032838386 
return angle * 180 / Math.PI;
//#endif 

} 

//#endif 


//#if 1694366816 
public int[] computeVector(Point point)
    { 

//#if -2074089794 
Point anchor = getAnchorPosition();
//#endif 


//#if -80227937 
int distance = (int) anchor.distance(point);
//#endif 


//#if -57104313 
int angl = 0;
//#endif 


//#if -16193507 
double pathSlope = getSlope();
//#endif 


//#if -1718111288 
double offsetSlope = getSlope(anchor, point);
//#endif 


//#if -1529763087 
if(swap && pathSlope > Math.PI / 2 && pathSlope < Math.PI * 3 / 2)//1
{ 

//#if 1805143446 
angl = -(int) ((offsetSlope - pathSlope) / Math.PI * 180);
//#endif 

} 
else
{ 

//#if 415753167 
angl = (int) ((offsetSlope - pathSlope) / Math.PI * 180);
//#endif 

} 

//#endif 


//#if -776486542 
int[] result = new int[] {angl, distance};
//#endif 


//#if -911394450 
return result;
//#endif 

} 

//#endif 


//#if 720602164 
public int getVectorOffset()
    { 

//#if -1703014361 
return vectorOffset;
//#endif 

} 

//#endif 


//#if 1693598208 
public void setAbsoluteOffset(Point newOffset)
    { 

//#if -572154502 
offset = newOffset;
//#endif 


//#if -964531567 
useAngle = false;
//#endif 

} 

//#endif 


//#if 958476773 
public void setAnchorPercent(int newPercent)
    { 

//#if -1705232719 
percent = newPercent;
//#endif 

} 

//#endif 


//#if 693981706 
public Fig getItemFig()
    { 

//#if -780581699 
return itemFig;
//#endif 

} 

//#endif 


//#if -1872862999 
public int getPercent()
    { 

//#if 1671902961 
return percent;
//#endif 

} 

//#endif 


//#if 1063337759 
public void setDisplacementDistance(int newDistance)
    { 

//#if -570827949 
vectorOffset = newDistance;
//#endif 


//#if 786413366 
useAngle = true;
//#endif 

} 

//#endif 


//#if -401912453 
public PathItemPlacement(FigEdge pathFig, Fig theItemFig, int pathPercent,
                             int pathDelta,
                             int displacementAngle,
                             int displacementDistance)
    { 

//#if -1948110925 
super(pathFig);
//#endif 


//#if -1271734626 
itemFig = theItemFig;
//#endif 


//#if -197076073 
setAnchor(pathPercent, pathDelta);
//#endif 


//#if -1001873811 
setDisplacementVector(displacementAngle + 180, displacementDistance);
//#endif 

} 

//#endif 


//#if 395159969 
public PathItemPlacement(FigEdge pathFig, Fig theItemFig, int pathPercent,
                             int pathDelta, Point absoluteOffset)
    { 

//#if 95753816 
super(pathFig);
//#endif 


//#if -1489507645 
itemFig = theItemFig;
//#endif 


//#if 3621628 
setAnchor(pathPercent, pathDelta);
//#endif 


//#if 331186724 
setAbsoluteOffset(absoluteOffset);
//#endif 

} 

//#endif 


//#if 1892135003 
private Point applyOffset(double theta, int theOffset,
                              Point anchor)
    { 

//#if -1878967871 
Point result = new Point(anchor);
//#endif 


//#if 266510099 
final boolean aboveAndRight = false;
//#endif 


//#if -1742392157 
if(swap && theta > Math.PI / 2 && theta < Math.PI * 3 / 2)//1
{ 

//#if 2057958619 
theta = theta - angle;
//#endif 

} 
else
{ 

//#if -1472035586 
theta = theta + angle;
//#endif 

} 

//#endif 


//#if -944046766 
if(theta > Math.PI * 2)//1
{ 

//#if 209419518 
theta -= Math.PI * 2;
//#endif 

} 

//#endif 


//#if 1048975037 
if(theta < 0)//1
{ 

//#if -541814146 
theta += Math.PI * 2;
//#endif 

} 

//#endif 


//#if 1278453200 
int dx = (int) (theOffset * Math.cos(theta));
//#endif 


//#if -346335904 
int dy = (int) (theOffset * Math.sin(theta));
//#endif 


//#if -2062488787 
if(aboveAndRight)//1
{ 

//#if 1852341777 
dx = Math.abs(dx);
//#endif 


//#if 726201830 
dy = -Math.abs(dy);
//#endif 

} 

//#endif 


//#if 1362111488 
result.x += dx;
//#endif 


//#if 1390740670 
result.y += dy;
//#endif 


//#if -516668512 
return result;
//#endif 

} 

//#endif 


//#if 934339609 
public void setPoint(Point newPoint)
    { 

//#if 1146706012 
int vect[] = computeVector(newPoint);
//#endif 


//#if -1439702132 
setDisplacementAngle(vect[0]);
//#endif 


//#if -1285127393 
setDisplacementDistance(vect[1]);
//#endif 

} 

//#endif 


//#if -573908318 
private boolean intersects(Point[] points, Point center, Dimension size)
    { 

//#if -1092915626 
Rectangle r = new Rectangle(center.x - (size.width / 2),
                                    center.y - (size.height / 2),
                                    size.width, size.height);
//#endif 


//#if 734256162 
Line2D line = new Line2D.Double();
//#endif 


//#if -1340775315 
for (int i = 0; i < points.length - 1; i++) //1
{ 

//#if 1716520636 
line.setLine(points[i], points[i + 1]);
//#endif 


//#if -290965548 
if(r.intersectsLine(line))//1
{ 

//#if -118456735 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1985866004 
return false;
//#endif 

} 

//#endif 


//#if -274640752 
private static double getSlope(Point p1, Point p2)
    { 

//#if -1708989563 
int opposite = p2.y - p1.y;
//#endif 


//#if 1816665834 
int adjacent = p2.x - p1.x;
//#endif 


//#if 1194879133 
double theta;
//#endif 


//#if -195832454 
if(adjacent == 0)//1
{ 

//#if -396175937 
if(opposite == 0)//1
{ 

//#if 1754400002 
return 0;
//#endif 

} 

//#endif 


//#if 500571765 
if(opposite < 0)//1
{ 

//#if -166309093 
theta = Math.PI * 3 / 2;
//#endif 

} 
else
{ 

//#if -366472900 
theta = Math.PI / 2;
//#endif 

} 

//#endif 

} 
else
{ 

//#if -426552280 
theta = Math.atan((double) opposite / (double) adjacent);
//#endif 


//#if -163013130 
if(adjacent < 0)//1
{ 

//#if 294236352 
theta += Math.PI;
//#endif 

} 

//#endif 


//#if 693162722 
if(theta < 0)//1
{ 

//#if 158206232 
theta += Math.PI * 2;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 975857340 
return theta;
//#endif 

} 

//#endif 


//#if 1662152216 
private int getPathDistance()
    { 

//#if -2100069557 
int length = _pathFigure.getPerimeterLength();
//#endif 


//#if -265706918 
int distance = Math.max(0, (length * percent) / 100 + pathOffset);
//#endif 


//#if 1127953657 
if(distance >= length)//1
{ 

//#if -1664336852 
distance = length - 1;
//#endif 

} 

//#endif 


//#if -597999966 
return distance;
//#endif 

} 

//#endif 


//#if -645580361 
public void setDisplacementVector(int vectorAngle, int vectorDistance)
    { 

//#if 733182560 
setDisplacementAngle(vectorAngle);
//#endif 


//#if 369687440 
setDisplacementDistance(vectorDistance);
//#endif 

} 

//#endif 


//#if -1526055468 
public void setDisplacementAngle(int offsetAngle)
    { 

//#if 252576570 
angle = offsetAngle * Math.PI / 180.0;
//#endif 


//#if 85221602 
useAngle = true;
//#endif 

} 

//#endif 


//#if -564060666 
public Point getPosition()
    { 

//#if -1628981725 
return getPosition(new Point());
//#endif 

} 

//#endif 


//#if 1039579080 
private Point getRectLineIntersection(Rectangle r, Point pOut, Point pIn)
    { 

//#if -467982495 
Line2D.Double m, n;
//#endif 


//#if 1906007476 
m = new Line2D.Double(pOut, pIn);
//#endif 


//#if -1186673757 
n = new Line2D.Double(r.x, r.y, r.x + r.width, r.y);
//#endif 


//#if 690002907 
if(m.intersectsLine(n))//1
{ 

//#if -384697782 
return intersection(m, n);
//#endif 

} 

//#endif 


//#if 1816890128 
n = new Line2D.Double(r.x + r.width, r.y, r.x + r.width,
                              r.y + r.height);
//#endif 


//#if 163200246 
if(m.intersectsLine(n))//2
{ 

//#if -1547517293 
return intersection(m, n);
//#endif 

} 

//#endif 


//#if 1744191843 
n = new Line2D.Double(r.x, r.y + r.height, r.x + r.width,
                              r.y + r.height);
//#endif 


//#if 163230038 
if(m.intersectsLine(n))//3
{ 

//#if 1794705815 
return intersection(m, n);
//#endif 

} 

//#endif 


//#if -801258973 
n = new Line2D.Double(r.x, r.y, r.x, r.y + r.width);
//#endif 


//#if 163259830 
if(m.intersectsLine(n))//4
{ 

//#if 1712155473 
return intersection(m, n);
//#endif 

} 

//#endif 


//#if -1021173065 
LOG.warn("Could not find rectangle intersection, using inner point.");
//#endif 


//#if -672225638 
return pIn;
//#endif 

} 

//#endif 


//#if -150970243 
public void setAnchorOffset(int newOffset)
    { 

//#if 1092685082 
pathOffset = newOffset;
//#endif 

} 

//#endif 


//#if -972463598 
public void setAnchor(int newPercent, int newOffset)
    { 

//#if 323536590 
setAnchorPercent(newPercent);
//#endif 


//#if 1727238916 
setAnchorOffset(newOffset);
//#endif 

} 

//#endif 


//#if 1012705250 
public void setClosestPoint(Point newPoint)
    { 

//#if -1380166109 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if 1786960707 
@Override
    public Point getPoint()
    { 

//#if -314323349 
return getPosition();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

