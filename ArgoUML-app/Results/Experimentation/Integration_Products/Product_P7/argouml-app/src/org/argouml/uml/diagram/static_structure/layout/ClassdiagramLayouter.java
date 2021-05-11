package org.argouml.uml.diagram.static_structure.layout;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import org.apache.log4j.Logger;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.layout.LayoutedObject;
import org.argouml.uml.diagram.layout.Layouter;
import org.tigris.gef.presentation.Fig;
public class ClassdiagramLayouter implements Layouter
  { 
private static final int E_GAP = 5;
private static final int H_GAP = 80;
private static final Logger LOG =
        Logger.getLogger(ClassdiagramLayouter.class);
private static final int MAX_ROW_WIDTH = 1200;
private static final int V_GAP = 80;
private ArgoDiagram diagram;
private HashMap<Fig, ClassdiagramNode> figNodes =
        new HashMap<Fig, ClassdiagramNode>();
private List<ClassdiagramNode> layoutedClassNodes =
        new ArrayList<ClassdiagramNode>();
private List<ClassdiagramEdge> layoutedEdges =
        new ArrayList<ClassdiagramEdge>();
private List<LayoutedObject> layoutedObjects =
        new ArrayList<LayoutedObject>();
private List<NodeRow> nodeRows = new ArrayList<NodeRow>();
private int xPos;
private int yPos;
public void remove(LayoutedObject obj)
    { 
layoutedObjects.remove(obj);
} 
private void setupLinks()
    { 
figNodes.clear();
HashMap<Fig, List<ClassdiagramInheritanceEdge>> figParentEdges =
            new HashMap<Fig, List<ClassdiagramInheritanceEdge>>();
for (ClassdiagramNode node : layoutedClassNodes) //1
{ 
node.getUpNodes().clear();
node.getDownNodes().clear();
figNodes.put(node.getFigure(), node);
} 
for (ClassdiagramEdge edge : layoutedEdges) //1
{ 
Fig parentFig = edge.getDestFigNode();
ClassdiagramNode child = figNodes.get(edge.getSourceFigNode());
ClassdiagramNode parent = figNodes.get(parentFig);
if(edge instanceof ClassdiagramInheritanceEdge)//1
{ 
if(parent != null && child != null)//1
{ 
parent.addDownlink(child);
child.addUplink(parent);
List<ClassdiagramInheritanceEdge> edgeList =
                        figParentEdges.get(parentFig);
if(edgeList == null)//1
{ 
edgeList = new ArrayList<ClassdiagramInheritanceEdge>();
figParentEdges.put(parentFig, edgeList);
} 
edgeList.add((ClassdiagramInheritanceEdge) edge);
} 
else
{ 
LOG.error("Edge with missing end(s): " + edge);
} 
} 
else
if(edge instanceof ClassdiagramNoteEdge)//1
{ 
if(parent.isComment())//1
{ 
parent.addUplink(child);
} 
else
if(child.isComment())//1
{ 
child.addUplink(parent);
} 
else
{ 
LOG.error("Unexpected parent/child constellation for edge: "
                              + edge);
} 
} 
else
if(edge instanceof ClassdiagramAssociationEdge)//1
{ 
} 
else
{ 
LOG.error("Unsupported edge type");
} 
} 
} 
private void placeNodes()
    { 
int xInit = 0;
yPos = getVGap() / 2;
for (NodeRow row : nodeRows) //1
{ 
xPos = xInit;
int rowHeight = 0;
for (ClassdiagramNode node : row) //1
{ 
placeNode(node);
rowHeight = Math.max(rowHeight, node.getSize().height);
} 
yPos += rowHeight + getVGap();
} 
centerParents();
} 
private void rankAndWeightNodes()
    { 
List<ClassdiagramNode> comments = new ArrayList<ClassdiagramNode>();
nodeRows.clear();
TreeSet<ClassdiagramNode> nodeTree =
            new TreeSet<ClassdiagramNode>(layoutedClassNodes);
for (ClassdiagramNode node : nodeTree) //1
{ 
if(node.isComment())//1
{ 
comments.add(node);
} 
else
{ 
int rowNum = node.getRank();
for (int i = nodeRows.size(); i <= rowNum; i++) //1
{ 
nodeRows.add(new NodeRow(rowNum));
} 
nodeRows.get(rowNum).addNode(node);
} 
} 
for (ClassdiagramNode node : comments) //1
{ 
int rowInd =
                node.getUpNodes().isEmpty()
                ? 0
                : ((node.getUpNodes().get(0)).getRank());
nodeRows.get(rowInd).addNode(node);
} 
for (int row = 0; row < nodeRows.size();) //1
{ 
NodeRow diaRow = nodeRows.get(row);
diaRow.setRowNumber(row++);
diaRow = diaRow.doSplit(MAX_ROW_WIDTH, H_GAP);
if(diaRow != null)//1
{ 
nodeRows.add(row, diaRow);
} 
} 
} 
public LayoutedObject[] getObjects()
    { 
return (LayoutedObject[]) layoutedObjects.toArray();
} 
private int xCenter(List<ClassdiagramNode> nodes)
    { 
int left = 9999999;
int right = 0;
for (ClassdiagramNode node : nodes) //1
{ 
int x = node.getLocation().x;
left = Math.min(left, x);
right = Math.max(right, x + node.getSize().width);
} 
return (right + left) / 2;
} 
private int getHGap()
    { 
return H_GAP;
} 
public void add(LayoutedObject obj)
    { 
layoutedObjects.add(obj);
if(obj instanceof ClassdiagramNode)//1
{ 
layoutedClassNodes.add((ClassdiagramNode) obj);
} 
else
if(obj instanceof ClassdiagramEdge)//1
{ 
layoutedEdges.add((ClassdiagramEdge) obj);
} 
} 
public ClassdiagramLayouter(ArgoDiagram theDiagram)
    { 
diagram = theDiagram;
for (Fig fig : diagram.getLayer().getContents()) //1
{ 
if(fig.getEnclosingFig() == null)//1
{ 
add(ClassdiagramModelElementFactory.SINGLETON.getInstance(fig));
} 
} 
} 
public LayoutedObject getObject(int index)
    { 
return layoutedObjects.get(index);
} 
private void placeEdges()
    { 
ClassdiagramEdge.setVGap(getVGap());
ClassdiagramEdge.setHGap(getHGap());
for (ClassdiagramEdge edge : layoutedEdges) //1
{ 
if(edge instanceof ClassdiagramInheritanceEdge)//1
{ 
ClassdiagramNode parent = figNodes.get(edge.getDestFigNode());
((ClassdiagramInheritanceEdge) edge).setOffset(parent
                        .getEdgeOffset());
} 
edge.layout();
} 
} 
private int getVGap()
    { 
return V_GAP;
} 
private void placeNode(ClassdiagramNode node)
    { 
List<ClassdiagramNode> uplinks = node.getUpNodes();
List<ClassdiagramNode> downlinks = node.getDownNodes();
int width = node.getSize().width;
double xOffset = width + getHGap();
int bumpX = getHGap() / 2;
int xPosNew =
            Math.max(xPos + bumpX,
                     uplinks.size() == 1 ? node.getPlacementHint() : -1);
node.setLocation(new Point(xPosNew, yPos));
if(LOG.isDebugEnabled())//1
{ 
LOG.debug("placeNode - Row: " + node.getRank() + " Col: "
                      + node.getColumn() + " Weight: " + node.getWeight()
                      + " Position: (" + xPosNew + "," + yPos + ") xPos: "
                      + xPos + " hint: " + node.getPlacementHint());
} 
if(downlinks.size() == 1)//1
{ 
ClassdiagramNode downNode = downlinks.get(0);
if(downNode.getUpNodes().get(0).equals(node))//1
{ 
downNode.setPlacementHint(xPosNew);
} 
} 
xPos = (int) Math.max(node.getPlacementHint() + width, xPos + xOffset);
} 
public void layout()
    { 
long s = System.currentTimeMillis();
setupLinks();
rankAndWeightNodes();
placeNodes();
placeEdges();
LOG.debug("layout duration: " + (System.currentTimeMillis() - s));
} 
private void centerParents()
    { 
for (int i = nodeRows.size() - 1; i >= 0; i--) //1
{ 
for (ClassdiagramNode node : nodeRows.get(i)) //1
{ 
List<ClassdiagramNode> children = node.getDownNodes();
if(children.size() > 0)//1
{ 
node.setLocation(new Point(xCenter(children)
                                               - node.getSize().width / 2, node.getLocation().y));
} 
} 
} 
} 
public Dimension getMinimumDiagramSize()
    { 
int width = 0, height = 0;
int hGap2 = getHGap() / 2;
int vGap2 = getVGap() / 2;
for (ClassdiagramNode node : layoutedClassNodes) //1
{ 
width =
                Math.max(width,
                         node.getLocation().x
                         + (int) node.getSize().getWidth() + hGap2);
height =
                Math.max(height,
                         node.getLocation().y
                         + (int) node.getSize().getHeight() + vGap2);
} 
return new Dimension(width, height);
} 
private class NodeRow implements Iterable<ClassdiagramNode>
  { 
private List<ClassdiagramNode> nodes =
            new ArrayList<ClassdiagramNode>();
private int rowNumber;
public NodeRow(int aRowNumber)
        { 
rowNumber = aRowNumber;
} 
public NodeRow doSplit(int maxWidth, int gap)
        { 
TreeSet<ClassdiagramNode> ts = new TreeSet<ClassdiagramNode>(nodes);
if(ts.size() < 2)//1
{ 
return null;
} 
ClassdiagramNode firstNode = ts.first();
if(!firstNode.isStandalone())//1
{ 
return null;
} 
ClassdiagramNode lastNode = ts.last();
if(firstNode.isStandalone() && lastNode.isStandalone()
                    && (firstNode.isPackage() == lastNode.isPackage())
                    && getWidth(gap) <= maxWidth)//1
{ 
return null;
} 
boolean hasPackage = firstNode.isPackage();
NodeRow newRow = new NodeRow(rowNumber + 1);
ClassdiagramNode split = null;
int width = 0;
int count = 0;
for (Iterator<ClassdiagramNode> iter = ts.iterator();
                    iter.hasNext() && (width < maxWidth || count < 2);) //1
{ 
ClassdiagramNode node = iter.next();
split =
                    (split == null
                     || (hasPackage && split.isPackage() == hasPackage)
                     || split.isStandalone())
                    ? node
                    : split;
width += node.getSize().width + gap;
count++;
} 
nodes = new ArrayList<ClassdiagramNode>(ts.headSet(split));
for (ClassdiagramNode n : ts.tailSet(split)) //1
{ 
newRow.addNode(n);
} 
if(LOG.isDebugEnabled())//1
{ 
LOG.debug("Row split. This row width: " + getWidth(gap)
                          + " next row(s) width: " + newRow.getWidth(gap));
} 
return newRow;
} 
private void adjustRowNodes()
        { 
int col = 0;
int numNodesWithDownlinks = 0;
List<ClassdiagramNode> list = new ArrayList<ClassdiagramNode>();
for (ClassdiagramNode node : this ) //1
{ 
node.setRank(rowNumber);
node.setColumn(col++);
if(!node.getDownNodes().isEmpty())//1
{ 
numNodesWithDownlinks++;
list.add(node);
} 
} 
int offset = -numNodesWithDownlinks * E_GAP / 2;
for (ClassdiagramNode node : list ) //1
{ 
node.setEdgeOffset(offset);
offset += E_GAP;
} 
} 
public Iterator<ClassdiagramNode> iterator()
        { 
return (new TreeSet<ClassdiagramNode>(nodes)).iterator();
} 
public int getRowNumber()
        { 
return rowNumber;
} 
public void setRowNumber(int rowNum)
        { 
this.rowNumber = rowNum;
adjustRowNodes();
} 
public void addNode(ClassdiagramNode node)
        { 
node.setRank(rowNumber);
node.setColumn(nodes.size());
nodes.add(node);
} 
public List<ClassdiagramNode> getNodeList()
        { 
return nodes;
} 
public int getWidth(int gap)
        { 
int result = 0;
for (ClassdiagramNode node : nodes) //1
{ 
result += node.getSize().width + gap;
} 
if(LOG.isDebugEnabled())//1
{ 
LOG.debug("Width of row " + rowNumber + ": " + result);
} 
return result;
} 

 } 

 } 
