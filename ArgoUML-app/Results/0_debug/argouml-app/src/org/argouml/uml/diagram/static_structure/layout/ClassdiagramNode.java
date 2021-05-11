
//#if -924539621 
// Compilation Unit of /ClassdiagramNode.java 
 

//#if 949095029 
package org.argouml.uml.diagram.static_structure.layout;
//#endif 


//#if -2139330812 
import java.awt.Dimension;
//#endif 


//#if 93950874 
import java.awt.Point;
//#endif 


//#if 429219729 
import java.util.ArrayList;
//#endif 


//#if 2074910768 
import java.util.List;
//#endif 


//#if -1712660437 
import org.argouml.uml.diagram.layout.LayoutedNode;
//#endif 


//#if -1018003149 
import org.argouml.uml.diagram.static_structure.ui.FigComment;
//#endif 


//#if -1546134567 
import org.argouml.uml.diagram.static_structure.ui.FigInterface;
//#endif 


//#if 335280172 
import org.argouml.uml.diagram.static_structure.ui.FigPackage;
//#endif 


//#if 827376376 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -972669290 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if -1638814867 
class ClassdiagramNode implements 
//#if -99137024 
LayoutedNode
//#endif 

, 
//#if 918083887 
Comparable
//#endif 

  { 

//#if 739031766 
public static final int NOCOLUMN = -1;
//#endif 


//#if -348563924 
public static final int NORANK = -1;
//#endif 


//#if 1387186424 
public static final int NOWEIGHT = -1;
//#endif 


//#if 1822233790 
private int column = NOCOLUMN;
//#endif 


//#if -1940353561 
private List<ClassdiagramNode> downlinks =
        new ArrayList<ClassdiagramNode>();
//#endif 


//#if 314424887 
private int edgeOffset = 0;
//#endif 


//#if -1870889933 
private FigNode figure = null;
//#endif 


//#if 1047033125 
private int placementHint = -1;
//#endif 


//#if 1211921406 
private int rank = NORANK;
//#endif 


//#if 1334922638 
private List<ClassdiagramNode> uplinks = new ArrayList<ClassdiagramNode>();
//#endif 


//#if -1847371157 
private float weight = NOWEIGHT;
//#endif 


//#if 475321932 
private static final float UPLINK_FACTOR = 5;
//#endif 


//#if 327827112 
public int getPlacementHint()
    { 

//#if -1914638696 
return placementHint;
//#endif 

} 

//#endif 


//#if -1915286915 
public void setEdgeOffset(int newOffset)
    { 

//#if 1404480332 
edgeOffset = newOffset;
//#endif 

} 

//#endif 


//#if 23326397 
public void addRank(int n)
    { 

//#if 744166175 
setRank(n + getRank());
//#endif 

} 

//#endif 


//#if -1813132607 
public float calculateWeight()
    { 

//#if -824072741 
weight = 0;
//#endif 


//#if 1107748735 
for (ClassdiagramNode node : uplinks) //1
{ 

//#if -566917776 
weight = Math.max(weight, node.getWeight()
                              * UPLINK_FACTOR
                              * (1 + 1 / Math.max(1, node.getColumn() + UPLINK_FACTOR)));
//#endif 

} 

//#endif 


//#if 854097994 
weight += getSubtreeWeight()
                  + (1 / Math.max(1, getColumn() + UPLINK_FACTOR));
//#endif 


//#if 1704340574 
return weight;
//#endif 

} 

//#endif 


//#if -1827168555 
public void addUplink(ClassdiagramNode newUplink)
    { 

//#if -354518329 
uplinks.add(newUplink);
//#endif 

} 

//#endif 


//#if 599367141 
public int getTypeOrderNumer()
    { 

//#if 2051845312 
int result = 99;
//#endif 


//#if 1327136720 
if(getFigure() instanceof FigPackage)//1
{ 

//#if -212593764 
result = 0;
//#endif 

} 
else

//#if 1010633537 
if(getFigure() instanceof FigInterface)//1
{ 

//#if 131508450 
result = 1;
//#endif 

} 

//#endif 


//#endif 


//#if 1241559748 
return result;
//#endif 

} 

//#endif 


//#if -1305195824 
public Dimension getSize()
    { 

//#if -688355305 
return getFigure().getSize();
//#endif 

} 

//#endif 


//#if -1089098432 
public void setRank(int newRank)
    { 

//#if -2070604285 
rank = newRank;
//#endif 

} 

//#endif 


//#if 989634099 
public FigNode getFigure()
    { 

//#if 2038396961 
return figure;
//#endif 

} 

//#endif 


//#if -2002071050 
public int getEdgeOffset()
    { 

//#if -1736703347 
return edgeOffset;
//#endif 

} 

//#endif 


//#if 34173338 
public Point getLocation()
    { 

//#if -2072212985 
return getFigure().getLocation();
//#endif 

} 

//#endif 


//#if 810175026 
public int getRank()
    { 

//#if -1373725393 
return rank == NORANK ? getLevel() : rank;
//#endif 

} 

//#endif 


//#if -1640308687 
public float getWeight()
    { 

//#if -1833099867 
return weight;
//#endif 

} 

//#endif 


//#if -2137180641 
public void setPlacementHint(int hint)
    { 

//#if -374466358 
placementHint = hint;
//#endif 

} 

//#endif 


//#if -1562641376 
public int getLevel()
    { 

//#if 1536751097 
int result = 0;
//#endif 


//#if -257128729 
for (ClassdiagramNode node : uplinks) //1
{ 

//#if 1447509527 
result =
                (node == this) ? result : Math.max(
                    node.getLevel() + 1, result);
//#endif 

} 

//#endif 


//#if -415633167 
return result;
//#endif 

} 

//#endif 


//#if -322025593 
public void addDownlink(ClassdiagramNode newDownlink)
    { 

//#if 1676706505 
downlinks.add(newDownlink);
//#endif 

} 

//#endif 


//#if -1062341265 
private float getSubtreeWeight()
    { 

//#if 728671674 
float w = 1;
//#endif 


//#if 1631341621 
for (ClassdiagramNode node : downlinks) //1
{ 

//#if -2029598089 
w += node.getSubtreeWeight() / UPLINK_FACTOR;
//#endif 

} 

//#endif 


//#if -1185236986 
return w;
//#endif 

} 

//#endif 


//#if 311017884 
public int getColumn()
    { 

//#if -1414044123 
return column;
//#endif 

} 

//#endif 


//#if 1547897761 

//#if 796011186 
@SuppressWarnings("unchecked")
//#endif 


    public void setLocation(Point newLocation)
    { 

//#if 1999331015 
Point oldLocation = getFigure().getLocation();
//#endif 


//#if -902852873 
getFigure().setLocation(newLocation);
//#endif 


//#if 1800093069 
int xTrans = newLocation.x - oldLocation.x;
//#endif 


//#if -1279927476 
int yTrans = newLocation.y - oldLocation.y;
//#endif 


//#if 1767070406 
for (Fig fig : (List<Fig>) getFigure().getEnclosedFigs()) //1
{ 

//#if 137457481 
fig.translate(xTrans, yTrans);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1973640585 
public int compareTo(Object arg0)
    { 

//#if 2024958446 
ClassdiagramNode node = (ClassdiagramNode) arg0;
//#endif 


//#if -693557237 
int result = 0;
//#endif 


//#if 1656847667 
result =
            Boolean.valueOf(node.isStandalone()).compareTo(
                Boolean.valueOf(isStandalone()));
//#endif 


//#if -949726113 
if(result == 0)//1
{ 

//#if -567338655 
result = this.getTypeOrderNumer() - node.getTypeOrderNumer();
//#endif 

} 

//#endif 


//#if 1953990130 
if(result == 0)//2
{ 

//#if 1276752576 
result = this.getRank() - node.getRank();
//#endif 

} 

//#endif 


//#if 1954019922 
if(result == 0)//3
{ 

//#if -1306618627 
result = (int) Math.signum(node.getWeight() - this.getWeight());
//#endif 

} 

//#endif 


//#if 1954049714 
if(result == 0)//4
{ 

//#if 606339117 
result = String.valueOf(this.getFigure().getOwner()).compareTo(
                         String.valueOf(node.getFigure().getOwner()));
//#endif 

} 

//#endif 


//#if 1954079506 
if(result == 0)//5
{ 

//#if -785849421 
result = node.hashCode() - this.hashCode();
//#endif 

} 

//#endif 


//#if -835714785 
return result;
//#endif 

} 

//#endif 


//#if -1574545894 
public boolean isStandalone()
    { 

//#if -1258221641 
return uplinks.isEmpty() && downlinks.isEmpty();
//#endif 

} 

//#endif 


//#if -1233745202 
public void setWeight(float w)
    { 

//#if -735505333 
weight = w;
//#endif 

} 

//#endif 


//#if -990693312 
public void setColumn(int newColumn)
    { 

//#if -769205582 
column = newColumn;
//#endif 


//#if 2029255670 
calculateWeight();
//#endif 

} 

//#endif 


//#if 1132112435 
public boolean isPackage()
    { 

//#if -992472782 
return (getFigure() instanceof FigPackage);
//#endif 

} 

//#endif 


//#if -1706159269 
public List<ClassdiagramNode> getDownNodes()
    { 

//#if -1315015476 
return downlinks;
//#endif 

} 

//#endif 


//#if 2130002444 
public boolean isComment()
    { 

//#if -1152198561 
return (getFigure() instanceof FigComment);
//#endif 

} 

//#endif 


//#if 293924567 
public void setFigure(FigNode newFigure)
    { 

//#if 827061426 
figure = newFigure;
//#endif 

} 

//#endif 


//#if -952589220 
public ClassdiagramNode(FigNode f)
    { 

//#if -1604990143 
setFigure(f);
//#endif 

} 

//#endif 


//#if -238719486 
public List<ClassdiagramNode> getUpNodes()
    { 

//#if -613125485 
return uplinks;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

