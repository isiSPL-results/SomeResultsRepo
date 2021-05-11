
//#if -943648241 
// Compilation Unit of /FigPartition.java 
 

//#if 461311872 
package org.argouml.uml.diagram.activity.ui;
//#endif 


//#if -1399733329 
import java.awt.Color;
//#endif 


//#if -1885392244 
import java.awt.Dimension;
//#endif 


//#if 1523710265 
import java.awt.Graphics;
//#endif 


//#if -1899170909 
import java.awt.Rectangle;
//#endif 


//#if -288619255 
import java.util.ArrayList;
//#endif 


//#if 2052090984 
import java.util.Iterator;
//#endif 


//#if 953315256 
import java.util.List;
//#endif 


//#if -823180423 
import org.argouml.model.Model;
//#endif 


//#if -660610212 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -1331792507 
import org.argouml.uml.diagram.ui.FigNodeModelElement;
//#endif 


//#if 595032941 
import org.tigris.gef.base.Globals;
//#endif 


//#if -1635922964 
import org.tigris.gef.base.Layer;
//#endif 


//#if -201427439 
import org.tigris.gef.base.Selection;
//#endif 


//#if 1577709989 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 639825008 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1160499108 
import org.tigris.gef.presentation.FigLine;
//#endif 


//#if -1155087252 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if -1153220029 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 1515720890 
import org.tigris.gef.presentation.Handle;
//#endif 


//#if -791119371 
public class FigPartition extends 
//#if -138725213 
FigNodeModelElement
//#endif 

  { 

//#if 114846309 
private static final int MIN_WIDTH = 64;
//#endif 


//#if -295490211 
private static final int MIN_HEIGHT = 256;
//#endif 


//#if 799245429 
private FigLine leftLine;
//#endif 


//#if -11214026 
private FigLine rightLine;
//#endif 


//#if -1290809763 
private FigLine topLine;
//#endif 


//#if -353192047 
private FigLine bottomLine;
//#endif 


//#if -1467499483 
private FigLine seperator;
//#endif 


//#if -1334849413 
private FigPartition previousPartition;
//#endif 


//#if -1074686217 
private FigPartition nextPartition;
//#endif 


//#if 2032783876 

//#if -92677193 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigPartition(@SuppressWarnings("unused")
                        GraphModel gm, Object node)
    { 

//#if -307760352 
this();
//#endif 


//#if 1704748911 
setOwner(node);
//#endif 

} 

//#endif 


//#if 59757906 
@Override
    public Selection makeSelection()
    { 

//#if -701359950 
return new SelectionPartition(this);
//#endif 

} 

//#endif 


//#if -2013495522 
private FigPool getFigPool()
    { 

//#if 1675895255 
if(getLayer() != null)//1
{ 

//#if -21794679 
for (Object o : getLayer().getContents()) //1
{ 

//#if 790028488 
if(o instanceof FigPool)//1
{ 

//#if -415704155 
return (FigPool) o;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1254730729 
return null;
//#endif 

} 

//#endif 


//#if -2109668377 
void setNextPartition(FigPartition next)
    { 

//#if -897782081 
this.nextPartition = next;
//#endif 

} 

//#endif 


//#if 1832953761 
private void initFigs()
    { 

//#if -621335025 
setBigPort(new FigRect(X0, Y0, 160, 200, DEBUG_COLOR, DEBUG_COLOR));
//#endif 


//#if -421206510 
getBigPort().setFilled(false);
//#endif 


//#if -416728375 
getBigPort().setLineWidth(0);
//#endif 


//#if 60455134 
leftLine = new FigLine(X0, Y0, 10, 300, LINE_COLOR);
//#endif 


//#if 1706575641 
rightLine = new FigLine(150, Y0, 160, 300, LINE_COLOR);
//#endif 


//#if -1740693445 
bottomLine = new FigLine(X0, 300, 150, 300, LINE_COLOR);
//#endif 


//#if -1354557891 
topLine = new FigLine(X0, Y0, 150, 10, LINE_COLOR);
//#endif 


//#if 435043313 
getNameFig().setLineWidth(0);
//#endif 


//#if 523146605 
getNameFig().setBounds(X0, Y0, 50, 25);
//#endif 


//#if 213912042 
getNameFig().setFilled(false);
//#endif 


//#if -1718547396 
seperator = new FigLine(X0, Y0 + 15, 150, 25, LINE_COLOR);
//#endif 


//#if -1306221664 
addFig(getBigPort());
//#endif 


//#if 784505568 
addFig(rightLine);
//#endif 


//#if 844440015 
addFig(leftLine);
//#endif 


//#if -608382247 
addFig(topLine);
//#endif 


//#if -1622390669 
addFig(bottomLine);
//#endif 


//#if -2135787656 
addFig(getNameFig());
//#endif 


//#if -1410670639 
addFig(seperator);
//#endif 


//#if -446520082 
setFilled(false);
//#endif 


//#if 1860678346 
setBounds(getBounds());
//#endif 

} 

//#endif 


//#if 1587583631 
@Override
    public Color getFillColor()
    { 

//#if -44868091 
return getBigPort().getFillColor();
//#endif 

} 

//#endif 


//#if -1031679603 
public void appendToPool(Object activityGraph)
    { 

//#if -33922114 
List partitions = getPartitions(getLayer());
//#endif 


//#if -157087455 
Model.getCoreHelper().setModelElementContainer(
            getOwner(), activityGraph);
//#endif 


//#if -1102680082 
if(partitions.size() == 1)//1
{ 

//#if -278073379 
FigPool fp = new FigPool(null, getBounds(), getSettings());
//#endif 


//#if -1710924362 
getLayer().add(fp);
//#endif 


//#if 1947740297 
getLayer().bringToFront(this);
//#endif 

} 
else

//#if 406454402 
if(partitions.size() > 1)//1
{ 

//#if 1924217969 
FigPool fp = getFigPool();
//#endif 


//#if -461204603 
fp.setWidth(fp.getWidth() + getWidth());
//#endif 


//#if -179408109 
int x = 0;
//#endif 


//#if -1751566145 
Iterator it = partitions.iterator();
//#endif 


//#if -323232693 
FigPartition f = null;
//#endif 


//#if -603966798 
FigPartition previousFig = null;
//#endif 


//#if 1481680118 
while (it.hasNext()) //1
{ 

//#if -662231047 
f = (FigPartition) it.next();
//#endif 


//#if -597059933 
if(f != this && f.getX() + f.getWidth() > x)//1
{ 

//#if -580856356 
previousFig = f;
//#endif 


//#if 2019215380 
x = f.getX();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1577840524 
setPreviousPartition(previousFig);
//#endif 


//#if 294067132 
previousPartition.setNextPartition(this);
//#endif 


//#if 54828913 
setBounds(
                x + previousFig.getWidth(),
                previousFig.getY(),
                getWidth(),
                previousFig.getHeight());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -299594197 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 

//#if -381687475 
if(getNameFig() == null)//1
{ 

//#if -834601338 
return;
//#endif 

} 

//#endif 


//#if 507942478 
Rectangle oldBounds = getBounds();
//#endif 


//#if -195442950 
Rectangle nameBounds = getNameFig().getBounds();
//#endif 


//#if 163705121 
getNameFig().setBounds(x, y, w, nameBounds.height);
//#endif 


//#if 535039292 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if 534456420 
leftLine.setBounds(x, y, 0, h);
//#endif 


//#if -527912510 
rightLine.setBounds(x + (w - 1), y, 0, h);
//#endif 


//#if 93498531 
topLine.setBounds(x, y, w - 1, 0);
//#endif 


//#if 2067446616 
bottomLine.setBounds(x, y + h, w - 1, 0);
//#endif 


//#if 2091650757 
seperator.setBounds(x, y + nameBounds.height, w - 1, 0);
//#endif 


//#if -697640805 
firePropChange("bounds", oldBounds, getBounds());
//#endif 


//#if -1395373729 
calcBounds();
//#endif 


//#if -963364002 
updateEdges();
//#endif 

} 

//#endif 


//#if -956959908 
@Override
    public void setLineWidth(int w)
    { 

//#if -827538230 
rightLine.setLineWidth(w);
//#endif 


//#if 1970841641 
leftLine.setLineWidth(w);
//#endif 

} 

//#endif 


//#if -301317607 
private List<FigPartition> getPartitions(Layer layer)
    { 

//#if 1590082689 
final List<FigPartition> partitions = new ArrayList<FigPartition>();
//#endif 


//#if 1899395025 
for (Object o : layer.getContents()) //1
{ 

//#if 1738672266 
if(o instanceof FigPartition)//1
{ 

//#if 1909161572 
partitions.add((FigPartition) o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1256593504 
return partitions;
//#endif 

} 

//#endif 


//#if -474615667 
@Override
    public int getLineWidth()
    { 

//#if -1368832097 
return rightLine.getLineWidth();
//#endif 

} 

//#endif 


//#if 963375767 
@Override
    public List getDragDependencies()
    { 

//#if 710638602 
List dependents = getPartitions(getLayer());
//#endif 


//#if -677834938 
dependents.add(getFigPool());
//#endif 


//#if -1818678608 
dependents.addAll(getFigPool().getEnclosedFigs());
//#endif 


//#if 1299631167 
return dependents;
//#endif 

} 

//#endif 


//#if 837114761 
@Override
    public String placeString()
    { 

//#if 1865417354 
return "";
//#endif 

} 

//#endif 


//#if 2066794357 
@Override
    public void setFillColor(Color col)
    { 

//#if -1562713503 
getBigPort().setFillColor(col);
//#endif 


//#if 946092425 
getNameFig().setFillColor(col);
//#endif 

} 

//#endif 


//#if 818884033 
private void translateWithContents(int dx)
    { 

//#if -124564374 
for (Fig f : getFigPool().getEnclosedFigs()) //1
{ 

//#if 1228206875 
f.setX(f.getX() + dx);
//#endif 

} 

//#endif 


//#if -667281621 
setX(getX() + dx);
//#endif 


//#if -1303224228 
damage();
//#endif 

} 

//#endif 


//#if -1618270111 
@Override
    public Dimension getMinimumSize()
    { 

//#if -530575215 
Dimension nameDim = getNameFig().getMinimumSize();
//#endif 


//#if -669743249 
int w = nameDim.width;
//#endif 


//#if 1350049003 
int h = nameDim.height;
//#endif 


//#if -1162151778 
w = Math.max(MIN_WIDTH, w);
//#endif 


//#if -1774741461 
h = Math.max(MIN_HEIGHT, h);
//#endif 


//#if -1785282177 
return new Dimension(w, h);
//#endif 

} 

//#endif 


//#if -2005603789 
@Override
    public void removeFromDiagramImpl()
    { 

//#if 464765355 
int width = getWidth();
//#endif 


//#if 761071898 
FigPool figPool = getFigPool();
//#endif 


//#if 131889707 
if(figPool == null)//1
{ 

//#if -1211096038 
super.removeFromDiagramImpl();
//#endif 


//#if -164232423 
return;
//#endif 

} 

//#endif 


//#if 1465793348 
int newFigPoolWidth = figPool.getWidth() - width;
//#endif 


//#if -46349009 
super.removeFromDiagramImpl();
//#endif 


//#if 1977883777 
FigPartition next = nextPartition;
//#endif 


//#if -754623012 
while (next != null) //1
{ 

//#if 1621063888 
next.translateWithContents(-width);
//#endif 


//#if -170213371 
next = next.nextPartition;
//#endif 

} 

//#endif 


//#if -2653240 
if(nextPartition == null && previousPartition == null)//1
{ 

//#if 991750767 
figPool.removeFromDiagram();
//#endif 


//#if 298998943 
return;
//#endif 

} 

//#endif 


//#if 1171449854 
if(nextPartition != null)//1
{ 

//#if 74393343 
nextPartition.setPreviousPartition(previousPartition);
//#endif 

} 

//#endif 


//#if 1951912826 
if(previousPartition != null)//1
{ 

//#if 210857851 
previousPartition.setNextPartition(nextPartition);
//#endif 

} 

//#endif 


//#if -574420311 
setPreviousPartition(null);
//#endif 


//#if -654186459 
setNextPartition(null);
//#endif 


//#if 641661801 
figPool.setWidth(newFigPoolWidth);
//#endif 

} 

//#endif 


//#if -888802547 

//#if -2048941410 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigPartition()
    { 

//#if -1975984439 
initFigs();
//#endif 

} 

//#endif 


//#if 175112031 
void setPreviousPartition(FigPartition previous)
    { 

//#if 591354685 
this.previousPartition = previous;
//#endif 


//#if -463901164 
leftLine.setVisible(previousPartition == null);
//#endif 

} 

//#endif 


//#if -318128780 
@Override
    public void setFilled(boolean f)
    { 

//#if -769043173 
getBigPort().setFilled(f);
//#endif 


//#if 1914709235 
getNameFig().setFilled(f);
//#endif 


//#if 725171640 
super.setFilled(f);
//#endif 

} 

//#endif 


//#if -1014645532 
@Override
    public void setLineColor(Color col)
    { 

//#if 2026944284 
rightLine.setLineColor(col);
//#endif 


//#if 1760344419 
leftLine.setLineColor(col);
//#endif 


//#if -1578793857 
bottomLine.setLineColor(col);
//#endif 


//#if -1243984509 
topLine.setLineColor(col);
//#endif 


//#if -1106324917 
seperator.setLineColor(col);
//#endif 

} 

//#endif 


//#if 2074696886 
@Override
    public boolean isFilled()
    { 

//#if 1590281901 
return getBigPort().isFilled();
//#endif 

} 

//#endif 


//#if 495683776 
@Override
    public Object clone()
    { 

//#if 1432910176 
FigPartition figClone = (FigPartition) super.clone();
//#endif 


//#if 1210473066 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if 1165982717 
figClone.setBigPort((FigRect) it.next());
//#endif 


//#if -139767996 
figClone.rightLine = (FigLine) it.next();
//#endif 


//#if 1678345351 
figClone.leftLine = (FigLine) it.next();
//#endif 


//#if 720127915 
figClone.bottomLine = (FigLine) it.next();
//#endif 


//#if -1629026179 
figClone.topLine = (FigLine) it.next();
//#endif 


//#if 626923758 
figClone.setNameFig((FigText) it.next());
//#endif 


//#if 1567381641 
return figClone;
//#endif 

} 

//#endif 


//#if -1909931213 
public FigPartition(Object owner, Rectangle bounds,
                        DiagramSettings settings)
    { 

//#if -1341407779 
super(owner, bounds, settings);
//#endif 


//#if -802143246 
initFigs();
//#endif 

} 

//#endif 


//#if 761097982 
@Override
    public Color getLineColor()
    { 

//#if -509278534 
return rightLine.getLineColor();
//#endif 

} 

//#endif 


//#if -1313306295 
private class SelectionPartition extends 
//#if 2057212102 
Selection
//#endif 

  { 

//#if -794580556 
private int cx;
//#endif 


//#if -794580525 
private int cy;
//#endif 


//#if -794580587 
private int cw;
//#endif 


//#if -794581052 
private int ch;
//#endif 


//#if 321156740 
public SelectionPartition(FigPartition f)
        { 

//#if 844235840 
super(f);
//#endif 

} 

//#endif 


//#if 120922626 
public void hitHandle(Rectangle r, Handle h)
        { 

//#if 477785802 
if(getContent().isResizable())//1
{ 

//#if -1189831167 
updateHandleBox();
//#endif 


//#if -1742211442 
Rectangle testRect = new Rectangle(0, 0, 0, 0);
//#endif 


//#if 1494540930 
testRect.setBounds(
                    cx - HAND_SIZE / 2,
                    cy - HAND_SIZE / 2,
                    HAND_SIZE,
                    ch + HAND_SIZE / 2);
//#endif 


//#if -2083161362 
boolean leftEdge = r.intersects(testRect);
//#endif 


//#if -1034924985 
testRect.setBounds(
                    cx + cw - HAND_SIZE / 2,
                    cy - HAND_SIZE / 2,
                    HAND_SIZE,
                    ch + HAND_SIZE / 2);
//#endif 


//#if -673844203 
boolean rightEdge = r.intersects(testRect);
//#endif 


//#if -416620677 
testRect.setBounds(
                    cx - HAND_SIZE / 2,
                    cy - HAND_SIZE / 2,
                    cw + HAND_SIZE / 2,
                    HAND_SIZE);
//#endif 


//#if 396602894 
boolean topEdge = r.intersects(testRect);
//#endif 


//#if -2008078937 
testRect.setBounds(
                    cx - HAND_SIZE / 2,
                    cy + ch - HAND_SIZE / 2,
                    cw + HAND_SIZE / 2,
                    HAND_SIZE);
//#endif 


//#if -987453102 
boolean bottomEdge = r.intersects(testRect);
//#endif 


//#if 2107386540 
if(leftEdge && topEdge)//1
{ 

//#if 1674613912 
h.index = Handle.NORTHWEST;
//#endif 


//#if 1984721165 
h.instructions = "Resize top left";
//#endif 

} 
else

//#if -361972506 
if(rightEdge && topEdge)//1
{ 

//#if -85535009 
h.index = Handle.NORTHEAST;
//#endif 


//#if -1228691917 
h.instructions = "Resize top right";
//#endif 

} 
else

//#if -1682054633 
if(leftEdge && bottomEdge)//1
{ 

//#if 33449063 
h.index = Handle.SOUTHWEST;
//#endif 


//#if -510296324 
h.instructions = "Resize bottom left";
//#endif 

} 
else

//#if -1408089487 
if(rightEdge && bottomEdge)//1
{ 

//#if 386206667 
h.index = Handle.SOUTHEAST;
//#endif 


//#if -843492341 
h.instructions = "Resize bottom right";
//#endif 

} 
else
{ 

//#if -918946320 
h.index = -1;
//#endif 


//#if 1956830689 
h.instructions = "Move object(s)";
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 

} 
else
{ 

//#if -771550387 
h.index = -1;
//#endif 


//#if 1587585726 
h.instructions = "Move object(s)";
//#endif 

} 

//#endif 

} 

//#endif 


//#if -139764258 
private void setHandleBox(
            FigPartition neighbour,
            int x,
            int y,
            int width,
            int height)
        { 

//#if -40893628 
final List<FigPartition> partitions = getPartitions(getLayer());
//#endif 


//#if 2129483493 
int newNeighbourWidth = 0;
//#endif 


//#if 1001240774 
if(neighbour != null)//1
{ 

//#if 1626507794 
newNeighbourWidth =
                    (neighbour.getWidth() + getContent().getWidth()) - width;
//#endif 


//#if 1996498228 
if(neighbour.getMinimumSize().width > newNeighbourWidth)//1
{ 

//#if 1925473028 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1331008862 
int lowX = 0;
//#endif 


//#if -1290862656 
int totalWidth = 0;
//#endif 


//#if 1924133345 
for (Fig f : partitions) //1
{ 

//#if 867006581 
if(f == getContent())//1
{ 

//#if -2135893918 
f.setHandleBox(x, y, width, height);
//#endif 

} 
else

//#if 440363174 
if(f == neighbour && f == previousPartition)//1
{ 

//#if 290563529 
f.setHandleBox(f.getX(), y, newNeighbourWidth, height);
//#endif 

} 
else

//#if 1029318573 
if(f == neighbour && f == nextPartition)//1
{ 

//#if 1310023731 
f.setHandleBox(x + width, y, newNeighbourWidth, height);
//#endif 

} 
else
{ 

//#if 667734049 
f.setHandleBox(f.getX(), y, f.getWidth(), height);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#if -28254924 
if(f.getHandleBox().getX() < lowX || totalWidth == 0)//1
{ 

//#if -2009843248 
lowX = f.getHandleBox().x;
//#endif 

} 

//#endif 


//#if -1406056437 
totalWidth += f.getHandleBox().width;
//#endif 

} 

//#endif 


//#if 1240990438 
FigPool pool = getFigPool();
//#endif 


//#if 483428514 
pool.setBounds(lowX, y, totalWidth, height);
//#endif 

} 

//#endif 


//#if -616477209 
public void dragHandle(int mX, int mY, int anX, int anY, Handle hand)
        { 

//#if -895072167 
final Fig fig = getContent();
//#endif 


//#if 1054361687 
updateHandleBox();
//#endif 


//#if -1271646959 
final int x = cx;
//#endif 


//#if -1270723407 
final int y = cy;
//#endif 


//#if -1272570511 
final int w = cw;
//#endif 


//#if -1286423791 
final int h = ch;
//#endif 


//#if 297787999 
int newX = x, newY = y, newWidth = w, newHeight = h;
//#endif 


//#if -1849697186 
Dimension minSize = fig.getMinimumSize();
//#endif 


//#if -1865163421 
int minWidth = minSize.width, minHeight = minSize.height;
//#endif 


//#if 469623339 
switch (hand.index) //1
{ 
case -1 ://1


//#if -1585571946 
fig.translate(anX - mX, anY - mY);
//#endif 


//#if 931260871 
return;
//#endif 


case Handle.NORTHWEST ://1


//#if 1785004645 
newWidth = x + w - mX;
//#endif 


//#if 1813010793 
newWidth = (newWidth < minWidth) ? minWidth : newWidth;
//#endif 


//#if 208825613 
newHeight = y + h - mY;
//#endif 


//#if -109975982 
newHeight = (newHeight < minHeight) ? minHeight : newHeight;
//#endif 


//#if -669001412 
newX = x + w - newWidth;
//#endif 


//#if 1540488634 
newY = y + h - newHeight;
//#endif 


//#if 1343469751 
if((newX + newWidth) != (x + w))//1
{ 

//#if 1738730372 
newX += (newX + newWidth) - (x + w);
//#endif 

} 

//#endif 


//#if -194578939 
if((newY + newHeight) != (y + h))//1
{ 

//#if 882013959 
newY += (newY + newHeight) - (y + h);
//#endif 

} 

//#endif 


//#if -888318019 
setHandleBox(
                    previousPartition,
                    newX,
                    newY,
                    newWidth,
                    newHeight);
//#endif 


//#if 2024920342 
return;
//#endif 


case Handle.NORTH ://1


//#if -984633239 
break;

//#endif 


case Handle.NORTHEAST ://1


//#if 2027979766 
newWidth = mX - x;
//#endif 


//#if -1327690474 
newWidth = (newWidth < minWidth) ? minWidth : newWidth;
//#endif 


//#if 1707466106 
newHeight = y + h - mY;
//#endif 


//#if 1859352261 
newHeight = (newHeight < minHeight) ? minHeight : newHeight;
//#endif 


//#if -1375009049 
newY = y + h - newHeight;
//#endif 


//#if -845652296 
if((newY + newHeight) != (y + h))//1
{ 

//#if 1703845955 
newY += (newY + newHeight) - (y + h);
//#endif 

} 

//#endif 


//#if -2098400218 
setHandleBox(
                    nextPartition,
                    newX,
                    newY,
                    newWidth,
                    newHeight);
//#endif 


//#if -86786204 
break;

//#endif 


case Handle.WEST ://1


//#if 621023981 
break;

//#endif 


case Handle.EAST ://1


//#if 674713512 
break;

//#endif 


case Handle.SOUTHWEST ://1


//#if 1847801671 
newWidth = x + w - mX;
//#endif 


//#if 2015627335 
newWidth = (newWidth < minWidth) ? minWidth : newWidth;
//#endif 


//#if -1884616138 
newHeight = mY - y;
//#endif 


//#if -414264780 
newHeight = (newHeight < minHeight) ? minHeight : newHeight;
//#endif 


//#if -450601570 
newX = x + w - newWidth;
//#endif 


//#if 1138098965 
if((newX + newWidth) != (x + w))//1
{ 

//#if -1402112697 
newX += (newX + newWidth) - (x + w);
//#endif 

} 

//#endif 


//#if -933320165 
setHandleBox(
                    previousPartition,
                    newX,
                    newY,
                    newWidth,
                    newHeight);
//#endif 


//#if 1014215955 
break;

//#endif 


case Handle.SOUTH ://1


//#if -1861516505 
break;

//#endif 


case Handle.SOUTHEAST ://1


//#if 1048917193 
newWidth = mX - x;
//#endif 


//#if 1740440227 
newWidth = (newWidth < minWidth) ? minWidth : newWidth;
//#endif 


//#if 367293586 
newHeight = mY - y;
//#endif 


//#if 792719704 
newHeight = (newHeight < minHeight) ? minHeight : newHeight;
//#endif 


//#if 1343561075 
setHandleBox(
                    nextPartition,
                    newX,
                    newY,
                    newWidth,
                    newHeight);
//#endif 


//#if 166982455 
break;

//#endif 


} 

//#endif 

} 

//#endif 


//#if 468238314 
private void updateHandleBox()
        { 

//#if 1376870096 
final Rectangle cRect = getContent().getHandleBox();
//#endif 


//#if 206651028 
cx = cRect.x;
//#endif 


//#if 10137554 
cy = cRect.y;
//#endif 


//#if 214737127 
cw = cRect.width;
//#endif 


//#if 685505203 
ch = cRect.height;
//#endif 

} 

//#endif 


//#if -596894438 
@Override
        public void paint(Graphics g)
        { 

//#if 679974205 
final Fig fig = getContent();
//#endif 


//#if -2082771592 
if(getContent().isResizable())//1
{ 

//#if 1335741368 
updateHandleBox();
//#endif 


//#if -1263938236 
g.setColor(Globals.getPrefs().handleColorFor(fig));
//#endif 


//#if -321843449 
g.fillRect(
                    cx - HAND_SIZE / 2,
                    cy - HAND_SIZE / 2,
                    HAND_SIZE,
                    HAND_SIZE);
//#endif 


//#if 3443286 
g.fillRect(
                    cx + cw - HAND_SIZE / 2,
                    cy - HAND_SIZE / 2,
                    HAND_SIZE,
                    HAND_SIZE);
//#endif 


//#if 191842703 
g.fillRect(
                    cx - HAND_SIZE / 2,
                    cy + ch - HAND_SIZE / 2,
                    HAND_SIZE,
                    HAND_SIZE);
//#endif 


//#if 1362745312 
g.fillRect(
                    cx + cw - HAND_SIZE / 2,
                    cy + ch - HAND_SIZE / 2,
                    HAND_SIZE,
                    HAND_SIZE);
//#endif 

} 
else
{ 

//#if 895415689 
final int x = fig.getX();
//#endif 


//#if 602042473 
final int y = fig.getY();
//#endif 


//#if -128838662 
final int w = fig.getWidth();
//#endif 


//#if 810526108 
final int h = fig.getHeight();
//#endif 


//#if -1472546315 
g.setColor(Globals.getPrefs().handleColorFor(fig));
//#endif 


//#if -961336870 
g.drawRect(
                    x - BORDER_WIDTH,
                    y - BORDER_WIDTH,
                    w + BORDER_WIDTH * 2 - 1,
                    h + BORDER_WIDTH * 2 - 1);
//#endif 


//#if -1977094022 
g.drawRect(
                    x - BORDER_WIDTH - 1,
                    y - BORDER_WIDTH - 1,
                    w + BORDER_WIDTH * 2 + 2 - 1,
                    h + BORDER_WIDTH * 2 + 2 - 1);
//#endif 


//#if -181034026 
g.fillRect(x - HAND_SIZE, y - HAND_SIZE, HAND_SIZE, HAND_SIZE);
//#endif 


//#if 344996926 
g.fillRect(x + w, y - HAND_SIZE, HAND_SIZE, HAND_SIZE);
//#endif 


//#if -1750942097 
g.fillRect(x - HAND_SIZE, y + h, HAND_SIZE, HAND_SIZE);
//#endif 


//#if -1599062313 
g.fillRect(x + w, y + h, HAND_SIZE, HAND_SIZE);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

