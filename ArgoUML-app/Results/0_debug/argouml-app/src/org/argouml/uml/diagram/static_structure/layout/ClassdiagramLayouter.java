
//#if 2119671663 
// Compilation Unit of /ClassdiagramLayouter.java 
 

//#if -1585242349 
package org.argouml.uml.diagram.static_structure.layout;
//#endif 


//#if 2061943842 
import java.awt.Dimension;
//#endif 


//#if 1217081272 
import java.awt.Point;
//#endif 


//#if 1819715123 
import java.util.ArrayList;
//#endif 


//#if 682998268 
import java.util.HashMap;
//#endif 


//#if 1704459774 
import java.util.Iterator;
//#endif 


//#if -1096926130 
import java.util.List;
//#endif 


//#if 1921150534 
import java.util.TreeSet;
//#endif 


//#if -661515216 
import org.apache.log4j.Logger;
//#endif 


//#if 705823970 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -448639440 
import org.argouml.uml.diagram.layout.LayoutedObject;
//#endif 


//#if -1965745567 
import org.argouml.uml.diagram.layout.Layouter;
//#endif 


//#if -43833702 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1116444777 
public class ClassdiagramLayouter implements 
//#if 1188531212 
Layouter
//#endif 

  { 

//#if 1465392220 
private static final int E_GAP = 5;
//#endif 


//#if 1350092368 
private static final int H_GAP = 80;
//#endif 


//#if 1825393771 
private static final Logger LOG =
        Logger.getLogger(ClassdiagramLayouter.class);
//#endif 


//#if -532827538 
private static final int MAX_ROW_WIDTH = 1200;
//#endif 


//#if 1815533662 
private static final int V_GAP = 80;
//#endif 


//#if -670601644 
private ArgoDiagram diagram;
//#endif 


//#if 395284796 
private HashMap<Fig, ClassdiagramNode> figNodes =
        new HashMap<Fig, ClassdiagramNode>();
//#endif 


//#if 1266418292 
private List<ClassdiagramNode> layoutedClassNodes =
        new ArrayList<ClassdiagramNode>();
//#endif 


//#if -1033713613 
private List<ClassdiagramEdge> layoutedEdges =
        new ArrayList<ClassdiagramEdge>();
//#endif 


//#if 369856721 
private List<LayoutedObject> layoutedObjects =
        new ArrayList<LayoutedObject>();
//#endif 


//#if -1713526245 
private List<NodeRow> nodeRows = new ArrayList<NodeRow>();
//#endif 


//#if -612784962 
private int xPos;
//#endif 


//#if -611861441 
private int yPos;
//#endif 


//#if 2060550828 
public void remove(LayoutedObject obj)
    { 

//#if 309801222 
layoutedObjects.remove(obj);
//#endif 

} 

//#endif 


//#if 1414481183 
private void setupLinks()
    { 

//#if -1324931701 
figNodes.clear();
//#endif 


//#if -1821043100 
HashMap<Fig, List<ClassdiagramInheritanceEdge>> figParentEdges =
            new HashMap<Fig, List<ClassdiagramInheritanceEdge>>();
//#endif 


//#if 125678915 
for (ClassdiagramNode node : layoutedClassNodes) //1
{ 

//#if -387645688 
node.getUpNodes().clear();
//#endif 


//#if -701735409 
node.getDownNodes().clear();
//#endif 


//#if -1574068751 
figNodes.put(node.getFigure(), node);
//#endif 

} 

//#endif 


//#if -1602525198 
for (ClassdiagramEdge edge : layoutedEdges) //1
{ 

//#if 1644392889 
Fig parentFig = edge.getDestFigNode();
//#endif 


//#if 1351541997 
ClassdiagramNode child = figNodes.get(edge.getSourceFigNode());
//#endif 


//#if -1469597338 
ClassdiagramNode parent = figNodes.get(parentFig);
//#endif 


//#if -1561139415 
if(edge instanceof ClassdiagramInheritanceEdge)//1
{ 

//#if 1464122969 
if(parent != null && child != null)//1
{ 

//#if -1415095039 
parent.addDownlink(child);
//#endif 


//#if 659751298 
child.addUplink(parent);
//#endif 


//#if -1220519896 
List<ClassdiagramInheritanceEdge> edgeList =
                        figParentEdges.get(parentFig);
//#endif 


//#if 325810771 
if(edgeList == null)//1
{ 

//#if 752773963 
edgeList = new ArrayList<ClassdiagramInheritanceEdge>();
//#endif 


//#if 496059108 
figParentEdges.put(parentFig, edgeList);
//#endif 

} 

//#endif 


//#if 990975068 
edgeList.add((ClassdiagramInheritanceEdge) edge);
//#endif 

} 
else
{ 

//#if -1470042352 
LOG.error("Edge with missing end(s): " + edge);
//#endif 

} 

//#endif 

} 
else

//#if -337033351 
if(edge instanceof ClassdiagramNoteEdge)//1
{ 

//#if 2052166895 
if(parent.isComment())//1
{ 

//#if -2023436230 
parent.addUplink(child);
//#endif 

} 
else

//#if -542424673 
if(child.isComment())//1
{ 

//#if 1199863604 
child.addUplink(parent);
//#endif 

} 
else
{ 

//#if 965443815 
LOG.error("Unexpected parent/child constellation for edge: "
                              + edge);
//#endif 

} 

//#endif 


//#endif 

} 
else

//#if 679125472 
if(edge instanceof ClassdiagramAssociationEdge)//1
{ 
} 
else
{ 

//#if 1790654731 
LOG.error("Unsupported edge type");
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -1106969523 
private void placeNodes()
    { 

//#if -2144333124 
int xInit = 0;
//#endif 


//#if -901789168 
yPos = getVGap() / 2;
//#endif 


//#if 1808094473 
for (NodeRow row : nodeRows) //1
{ 

//#if 1895568556 
xPos = xInit;
//#endif 


//#if 1560083982 
int rowHeight = 0;
//#endif 


//#if 402401454 
for (ClassdiagramNode node : row) //1
{ 

//#if 59426609 
placeNode(node);
//#endif 


//#if -1535150016 
rowHeight = Math.max(rowHeight, node.getSize().height);
//#endif 

} 

//#endif 


//#if -1722430909 
yPos += rowHeight + getVGap();
//#endif 

} 

//#endif 


//#if -1071556967 
centerParents();
//#endif 

} 

//#endif 


//#if 1485218673 
private void rankAndWeightNodes()
    { 

//#if -30372101 
List<ClassdiagramNode> comments = new ArrayList<ClassdiagramNode>();
//#endif 


//#if 1810503037 
nodeRows.clear();
//#endif 


//#if -1920274436 
TreeSet<ClassdiagramNode> nodeTree =
            new TreeSet<ClassdiagramNode>(layoutedClassNodes);
//#endif 


//#if -2036486623 
for (ClassdiagramNode node : nodeTree) //1
{ 

//#if -1881488421 
if(node.isComment())//1
{ 

//#if 1479424598 
comments.add(node);
//#endif 

} 
else
{ 

//#if -1040267831 
int rowNum = node.getRank();
//#endif 


//#if 754427131 
for (int i = nodeRows.size(); i <= rowNum; i++) //1
{ 

//#if -381223342 
nodeRows.add(new NodeRow(rowNum));
//#endif 

} 

//#endif 


//#if -447033386 
nodeRows.get(rowNum).addNode(node);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1754460843 
for (ClassdiagramNode node : comments) //1
{ 

//#if -1053142001 
int rowInd =
                node.getUpNodes().isEmpty()
                ? 0
                : ((node.getUpNodes().get(0)).getRank());
//#endif 


//#if -508886846 
nodeRows.get(rowInd).addNode(node);
//#endif 

} 

//#endif 


//#if -1258857365 
for (int row = 0; row < nodeRows.size();) //1
{ 

//#if -1586700380 
NodeRow diaRow = nodeRows.get(row);
//#endif 


//#if 2069564863 
diaRow.setRowNumber(row++);
//#endif 


//#if 1090042347 
diaRow = diaRow.doSplit(MAX_ROW_WIDTH, H_GAP);
//#endif 


//#if -915653250 
if(diaRow != null)//1
{ 

//#if 324819577 
nodeRows.add(row, diaRow);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1493601273 
public LayoutedObject[] getObjects()
    { 

//#if -873489189 
return (LayoutedObject[]) layoutedObjects.toArray();
//#endif 

} 

//#endif 


//#if -578521769 
private int xCenter(List<ClassdiagramNode> nodes)
    { 

//#if -974025725 
int left = 9999999;
//#endif 


//#if 171251745 
int right = 0;
//#endif 


//#if 1287251031 
for (ClassdiagramNode node : nodes) //1
{ 

//#if -2108576169 
int x = node.getLocation().x;
//#endif 


//#if 1251409957 
left = Math.min(left, x);
//#endif 


//#if 952334408 
right = Math.max(right, x + node.getSize().width);
//#endif 

} 

//#endif 


//#if 1610167363 
return (right + left) / 2;
//#endif 

} 

//#endif 


//#if -178256380 
private int getHGap()
    { 

//#if -221165299 
return H_GAP;
//#endif 

} 

//#endif 


//#if -686816429 
public void add(LayoutedObject obj)
    { 

//#if -1016430662 
layoutedObjects.add(obj);
//#endif 


//#if 300428450 
if(obj instanceof ClassdiagramNode)//1
{ 

//#if 346389497 
layoutedClassNodes.add((ClassdiagramNode) obj);
//#endif 

} 
else

//#if 1533240384 
if(obj instanceof ClassdiagramEdge)//1
{ 

//#if -1628832543 
layoutedEdges.add((ClassdiagramEdge) obj);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1463743131 
public ClassdiagramLayouter(ArgoDiagram theDiagram)
    { 

//#if -458474329 
diagram = theDiagram;
//#endif 


//#if 838930773 
for (Fig fig : diagram.getLayer().getContents()) //1
{ 

//#if -321923564 
if(fig.getEnclosingFig() == null)//1
{ 

//#if 695646119 
add(ClassdiagramModelElementFactory.SINGLETON.getInstance(fig));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1913141875 
public LayoutedObject getObject(int index)
    { 

//#if 569409875 
return layoutedObjects.get(index);
//#endif 

} 

//#endif 


//#if -816718158 
private void placeEdges()
    { 

//#if -38457417 
ClassdiagramEdge.setVGap(getVGap());
//#endif 


//#if -110454445 
ClassdiagramEdge.setHGap(getHGap());
//#endif 


//#if 1519599545 
for (ClassdiagramEdge edge : layoutedEdges) //1
{ 

//#if 1908629281 
if(edge instanceof ClassdiagramInheritanceEdge)//1
{ 

//#if 1852600240 
ClassdiagramNode parent = figNodes.get(edge.getDestFigNode());
//#endif 


//#if -833308244 
((ClassdiagramInheritanceEdge) edge).setOffset(parent
                        .getEdgeOffset());
//#endif 

} 

//#endif 


//#if 178892224 
edge.layout();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 222551734 
private int getVGap()
    { 

//#if 617020317 
return V_GAP;
//#endif 

} 

//#endif 


//#if -894538743 
private void placeNode(ClassdiagramNode node)
    { 

//#if 747777476 
List<ClassdiagramNode> uplinks = node.getUpNodes();
//#endif 


//#if -1189579182 
List<ClassdiagramNode> downlinks = node.getDownNodes();
//#endif 


//#if -696642139 
int width = node.getSize().width;
//#endif 


//#if 638152818 
double xOffset = width + getHGap();
//#endif 


//#if 1958331241 
int bumpX = getHGap() / 2;
//#endif 


//#if -948729776 
int xPosNew =
            Math.max(xPos + bumpX,
                     uplinks.size() == 1 ? node.getPlacementHint() : -1);
//#endif 


//#if -242805527 
node.setLocation(new Point(xPosNew, yPos));
//#endif 


//#if 1637245250 
if(LOG.isDebugEnabled())//1
{ 

//#if 631232057 
LOG.debug("placeNode - Row: " + node.getRank() + " Col: "
                      + node.getColumn() + " Weight: " + node.getWeight()
                      + " Position: (" + xPosNew + "," + yPos + ") xPos: "
                      + xPos + " hint: " + node.getPlacementHint());
//#endif 

} 

//#endif 


//#if -835873431 
if(downlinks.size() == 1)//1
{ 

//#if 88388382 
ClassdiagramNode downNode = downlinks.get(0);
//#endif 


//#if 956937212 
if(downNode.getUpNodes().get(0).equals(node))//1
{ 

//#if -1823558630 
downNode.setPlacementHint(xPosNew);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 188322257 
xPos = (int) Math.max(node.getPlacementHint() + width, xPos + xOffset);
//#endif 

} 

//#endif 


//#if -1181383555 
public void layout()
    { 

//#if -139654392 
long s = System.currentTimeMillis();
//#endif 


//#if 1665322303 
setupLinks();
//#endif 


//#if 1653753389 
rankAndWeightNodes();
//#endif 


//#if 809761745 
placeNodes();
//#endif 


//#if 1217619468 
placeEdges();
//#endif 


//#if -324953152 
LOG.debug("layout duration: " + (System.currentTimeMillis() - s));
//#endif 

} 

//#endif 


//#if 1922908115 
private void centerParents()
    { 

//#if -1533734919 
for (int i = nodeRows.size() - 1; i >= 0; i--) //1
{ 

//#if -813973923 
for (ClassdiagramNode node : nodeRows.get(i)) //1
{ 

//#if -1972044579 
List<ClassdiagramNode> children = node.getDownNodes();
//#endif 


//#if -1756548205 
if(children.size() > 0)//1
{ 

//#if 629089177 
node.setLocation(new Point(xCenter(children)
                                               - node.getSize().width / 2, node.getLocation().y));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1486126923 
public Dimension getMinimumDiagramSize()
    { 

//#if -889958515 
int width = 0, height = 0;
//#endif 


//#if 494305325 
int hGap2 = getHGap() / 2;
//#endif 


//#if -114364435 
int vGap2 = getVGap() / 2;
//#endif 


//#if -1254540232 
for (ClassdiagramNode node : layoutedClassNodes) //1
{ 

//#if -884483243 
width =
                Math.max(width,
                         node.getLocation().x
                         + (int) node.getSize().getWidth() + hGap2);
//#endif 


//#if -1086208617 
height =
                Math.max(height,
                         node.getLocation().y
                         + (int) node.getSize().getHeight() + vGap2);
//#endif 

} 

//#endif 


//#if 111331811 
return new Dimension(width, height);
//#endif 

} 

//#endif 


//#if -2022094034 
private class NodeRow implements 
//#if -2004424536 
Iterable<ClassdiagramNode>
//#endif 

  { 

//#if -405149027 
private List<ClassdiagramNode> nodes =
            new ArrayList<ClassdiagramNode>();
//#endif 


//#if -304532811 
private int rowNumber;
//#endif 


//#if 732401026 
public NodeRow(int aRowNumber)
        { 

//#if 2055631530 
rowNumber = aRowNumber;
//#endif 

} 

//#endif 


//#if 1498800592 
public NodeRow doSplit(int maxWidth, int gap)
        { 

//#if -255324698 
TreeSet<ClassdiagramNode> ts = new TreeSet<ClassdiagramNode>(nodes);
//#endif 


//#if -1602059119 
if(ts.size() < 2)//1
{ 

//#if -499692762 
return null;
//#endif 

} 

//#endif 


//#if -608569788 
ClassdiagramNode firstNode = ts.first();
//#endif 


//#if 1310805975 
if(!firstNode.isStandalone())//1
{ 

//#if -376947345 
return null;
//#endif 

} 

//#endif 


//#if -337362704 
ClassdiagramNode lastNode = ts.last();
//#endif 


//#if -1065338263 
if(firstNode.isStandalone() && lastNode.isStandalone()
                    && (firstNode.isPackage() == lastNode.isPackage())
                    && getWidth(gap) <= maxWidth)//1
{ 

//#if 204747153 
return null;
//#endif 

} 

//#endif 


//#if 1225469904 
boolean hasPackage = firstNode.isPackage();
//#endif 


//#if -1332893757 
NodeRow newRow = new NodeRow(rowNumber + 1);
//#endif 


//#if 1000971303 
ClassdiagramNode split = null;
//#endif 


//#if 949642948 
int width = 0;
//#endif 


//#if 1964741339 
int count = 0;
//#endif 


//#if 563105370 
for (Iterator<ClassdiagramNode> iter = ts.iterator();
                    iter.hasNext() && (width < maxWidth || count < 2);) //1
{ 

//#if 1959201347 
ClassdiagramNode node = iter.next();
//#endif 


//#if 125614591 
split =
                    (split == null
                     || (hasPackage && split.isPackage() == hasPackage)
                     || split.isStandalone())
                    ? node
                    : split;
//#endif 


//#if 83866336 
width += node.getSize().width + gap;
//#endif 


//#if -1714141224 
count++;
//#endif 

} 

//#endif 


//#if -1512095101 
nodes = new ArrayList<ClassdiagramNode>(ts.headSet(split));
//#endif 


//#if 1720281159 
for (ClassdiagramNode n : ts.tailSet(split)) //1
{ 

//#if -252799493 
newRow.addNode(n);
//#endif 

} 

//#endif 


//#if -2020820407 
if(LOG.isDebugEnabled())//1
{ 

//#if 7842080 
LOG.debug("Row split. This row width: " + getWidth(gap)
                          + " next row(s) width: " + newRow.getWidth(gap));
//#endif 

} 

//#endif 


//#if -1235836476 
return newRow;
//#endif 

} 

//#endif 


//#if 1398195277 
private void adjustRowNodes()
        { 

//#if -1824113778 
int col = 0;
//#endif 


//#if 1981667496 
int numNodesWithDownlinks = 0;
//#endif 


//#if 695990667 
List<ClassdiagramNode> list = new ArrayList<ClassdiagramNode>();
//#endif 


//#if -1285511719 
for (ClassdiagramNode node : this ) //1
{ 

//#if 1764063093 
node.setRank(rowNumber);
//#endif 


//#if -821668996 
node.setColumn(col++);
//#endif 


//#if 363629256 
if(!node.getDownNodes().isEmpty())//1
{ 

//#if -2127289162 
numNodesWithDownlinks++;
//#endif 


//#if 1495175818 
list.add(node);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1670774633 
int offset = -numNodesWithDownlinks * E_GAP / 2;
//#endif 


//#if -1168373799 
for (ClassdiagramNode node : list ) //1
{ 

//#if 1574044012 
node.setEdgeOffset(offset);
//#endif 


//#if 1399243807 
offset += E_GAP;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -676985924 
public Iterator<ClassdiagramNode> iterator()
        { 

//#if 143816372 
return (new TreeSet<ClassdiagramNode>(nodes)).iterator();
//#endif 

} 

//#endif 


//#if 454596163 
public int getRowNumber()
        { 

//#if -586436373 
return rowNumber;
//#endif 

} 

//#endif 


//#if -705235001 
public void setRowNumber(int rowNum)
        { 

//#if 702479455 
this.rowNumber = rowNum;
//#endif 


//#if -575269286 
adjustRowNodes();
//#endif 

} 

//#endif 


//#if 1322392823 
public void addNode(ClassdiagramNode node)
        { 

//#if -1882544135 
node.setRank(rowNumber);
//#endif 


//#if -1048906909 
node.setColumn(nodes.size());
//#endif 


//#if 1977196706 
nodes.add(node);
//#endif 

} 

//#endif 


//#if 975067802 
public List<ClassdiagramNode> getNodeList()
        { 

//#if -1220107233 
return nodes;
//#endif 

} 

//#endif 


//#if 1649740703 
public int getWidth(int gap)
        { 

//#if 625449242 
int result = 0;
//#endif 


//#if -1241766213 
for (ClassdiagramNode node : nodes) //1
{ 

//#if -672567736 
result += node.getSize().width + gap;
//#endif 

} 

//#endif 


//#if 70715352 
if(LOG.isDebugEnabled())//1
{ 

//#if -531900670 
LOG.debug("Width of row " + rowNumber + ": " + result);
//#endif 

} 

//#endif 


//#if 1398780400 
return result;
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

