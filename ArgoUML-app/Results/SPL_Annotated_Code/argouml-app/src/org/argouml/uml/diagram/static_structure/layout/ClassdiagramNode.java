// Compilation Unit of /ClassdiagramNode.java 
 
package org.argouml.uml.diagram.static_structure.layout;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import org.argouml.uml.diagram.layout.LayoutedNode;
import org.argouml.uml.diagram.static_structure.ui.FigComment;
import org.argouml.uml.diagram.static_structure.ui.FigInterface;
import org.argouml.uml.diagram.static_structure.ui.FigPackage;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigNode;
class ClassdiagramNode implements LayoutedNode
, Comparable
  { 
public static final int NOCOLUMN = -1;
public static final int NORANK = -1;
public static final int NOWEIGHT = -1;
private int column = NOCOLUMN;
private List<ClassdiagramNode> downlinks =
        new ArrayList<ClassdiagramNode>();
private int edgeOffset = 0;
private FigNode figure = null;
private int placementHint = -1;
private int rank = NORANK;
private List<ClassdiagramNode> uplinks = new ArrayList<ClassdiagramNode>();
private float weight = NOWEIGHT;
private static final float UPLINK_FACTOR = 5;
public int getPlacementHint()
    { 
return placementHint;
} 

public void setEdgeOffset(int newOffset)
    { 
edgeOffset = newOffset;
} 

public void addRank(int n)
    { 
setRank(n + getRank());
} 

public float calculateWeight()
    { 
weight = 0;
for (ClassdiagramNode node : uplinks) //1
{ 
weight = Math.max(weight, node.getWeight()
                              * UPLINK_FACTOR
                              * (1 + 1 / Math.max(1, node.getColumn() + UPLINK_FACTOR)));
} 

weight += getSubtreeWeight()
                  + (1 / Math.max(1, getColumn() + UPLINK_FACTOR));
return weight;
} 

public void addUplink(ClassdiagramNode newUplink)
    { 
uplinks.add(newUplink);
} 

public int getTypeOrderNumer()
    { 
int result = 99;
if(getFigure() instanceof FigPackage)//1
{ 
result = 0;
} 
else
if(getFigure() instanceof FigInterface)//1
{ 
result = 1;
} 


return result;
} 

public Dimension getSize()
    { 
return getFigure().getSize();
} 

public void setRank(int newRank)
    { 
rank = newRank;
} 

public FigNode getFigure()
    { 
return figure;
} 

public int getEdgeOffset()
    { 
return edgeOffset;
} 

public Point getLocation()
    { 
return getFigure().getLocation();
} 

public int getRank()
    { 
return rank == NORANK ? getLevel() : rank;
} 

public float getWeight()
    { 
return weight;
} 

public void setPlacementHint(int hint)
    { 
placementHint = hint;
} 

public int getLevel()
    { 
int result = 0;
for (ClassdiagramNode node : uplinks) //1
{ 
result =
                (node == this) ? result : Math.max(
                    node.getLevel() + 1, result);
} 

return result;
} 

public void addDownlink(ClassdiagramNode newDownlink)
    { 
downlinks.add(newDownlink);
} 

private float getSubtreeWeight()
    { 
float w = 1;
for (ClassdiagramNode node : downlinks) //1
{ 
w += node.getSubtreeWeight() / UPLINK_FACTOR;
} 

return w;
} 

public int getColumn()
    { 
return column;
} 

@SuppressWarnings("unchecked")

    public void setLocation(Point newLocation)
    { 
Point oldLocation = getFigure().getLocation();
getFigure().setLocation(newLocation);
int xTrans = newLocation.x - oldLocation.x;
int yTrans = newLocation.y - oldLocation.y;
for (Fig fig : (List<Fig>) getFigure().getEnclosedFigs()) //1
{ 
fig.translate(xTrans, yTrans);
} 

} 

public int compareTo(Object arg0)
    { 
ClassdiagramNode node = (ClassdiagramNode) arg0;
int result = 0;
result =
            Boolean.valueOf(node.isStandalone()).compareTo(
                Boolean.valueOf(isStandalone()));
if(result == 0)//1
{ 
result = this.getTypeOrderNumer() - node.getTypeOrderNumer();
} 

if(result == 0)//2
{ 
result = this.getRank() - node.getRank();
} 

if(result == 0)//3
{ 
result = (int) Math.signum(node.getWeight() - this.getWeight());
} 

if(result == 0)//4
{ 
result = String.valueOf(this.getFigure().getOwner()).compareTo(
                         String.valueOf(node.getFigure().getOwner()));
} 

if(result == 0)//5
{ 
result = node.hashCode() - this.hashCode();
} 

return result;
} 

public boolean isStandalone()
    { 
return uplinks.isEmpty() && downlinks.isEmpty();
} 

public void setWeight(float w)
    { 
weight = w;
} 

public void setColumn(int newColumn)
    { 
column = newColumn;
calculateWeight();
} 

public boolean isPackage()
    { 
return (getFigure() instanceof FigPackage);
} 

public List<ClassdiagramNode> getDownNodes()
    { 
return downlinks;
} 

public boolean isComment()
    { 
return (getFigure() instanceof FigComment);
} 

public void setFigure(FigNode newFigure)
    { 
figure = newFigure;
} 

public ClassdiagramNode(FigNode f)
    { 
setFigure(f);
} 

public List<ClassdiagramNode> getUpNodes()
    { 
return uplinks;
} 

 } 


