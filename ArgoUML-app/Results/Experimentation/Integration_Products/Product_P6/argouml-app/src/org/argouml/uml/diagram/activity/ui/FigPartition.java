package org.argouml.uml.diagram.activity.ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.argouml.model.Model;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.FigNodeModelElement;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.Layer;
import org.tigris.gef.base.Selection;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigLine;
import org.tigris.gef.presentation.FigRect;
import org.tigris.gef.presentation.FigText;
import org.tigris.gef.presentation.Handle;
public class FigPartition extends FigNodeModelElement
  { 
private static final int MIN_WIDTH = 64;
private static final int MIN_HEIGHT = 256;
private FigLine leftLine;
private FigLine rightLine;
private FigLine topLine;
private FigLine bottomLine;
private FigLine seperator;
private FigPartition previousPartition;
private FigPartition nextPartition;
@SuppressWarnings("deprecation")

    @Deprecated
    public FigPartition(@SuppressWarnings("unused")
                        GraphModel gm, Object node)
    { 
this();
setOwner(node);
} 
@Override
    public Selection makeSelection()
    { 
return new SelectionPartition(this);
} 
private FigPool getFigPool()
    { 
if(getLayer() != null)//1
{ 
for (Object o : getLayer().getContents()) //1
{ 
if(o instanceof FigPool)//1
{ 
return (FigPool) o;
} 
} 
} 
return null;
} 
void setNextPartition(FigPartition next)
    { 
this.nextPartition = next;
} 
private void initFigs()
    { 
setBigPort(new FigRect(X0, Y0, 160, 200, DEBUG_COLOR, DEBUG_COLOR));
getBigPort().setFilled(false);
getBigPort().setLineWidth(0);
leftLine = new FigLine(X0, Y0, 10, 300, LINE_COLOR);
rightLine = new FigLine(150, Y0, 160, 300, LINE_COLOR);
bottomLine = new FigLine(X0, 300, 150, 300, LINE_COLOR);
topLine = new FigLine(X0, Y0, 150, 10, LINE_COLOR);
getNameFig().setLineWidth(0);
getNameFig().setBounds(X0, Y0, 50, 25);
getNameFig().setFilled(false);
seperator = new FigLine(X0, Y0 + 15, 150, 25, LINE_COLOR);
addFig(getBigPort());
addFig(rightLine);
addFig(leftLine);
addFig(topLine);
addFig(bottomLine);
addFig(getNameFig());
addFig(seperator);
setFilled(false);
setBounds(getBounds());
} 
@Override
    public Color getFillColor()
    { 
return getBigPort().getFillColor();
} 
public void appendToPool(Object activityGraph)
    { 
List partitions = getPartitions(getLayer());
Model.getCoreHelper().setModelElementContainer(
            getOwner(), activityGraph);
if(partitions.size() == 1)//1
{ 
FigPool fp = new FigPool(null, getBounds(), getSettings());
getLayer().add(fp);
getLayer().bringToFront(this);
} 
else
if(partitions.size() > 1)//1
{ 
FigPool fp = getFigPool();
fp.setWidth(fp.getWidth() + getWidth());
int x = 0;
Iterator it = partitions.iterator();
FigPartition f = null;
FigPartition previousFig = null;
while (it.hasNext()) //1
{ 
f = (FigPartition) it.next();
if(f != this && f.getX() + f.getWidth() > x)//1
{ 
previousFig = f;
x = f.getX();
} 
} 
setPreviousPartition(previousFig);
previousPartition.setNextPartition(this);
setBounds(
                x + previousFig.getWidth(),
                previousFig.getY(),
                getWidth(),
                previousFig.getHeight());
} 
} 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 
if(getNameFig() == null)//1
{ 
return;
} 
Rectangle oldBounds = getBounds();
Rectangle nameBounds = getNameFig().getBounds();
getNameFig().setBounds(x, y, w, nameBounds.height);
getBigPort().setBounds(x, y, w, h);
leftLine.setBounds(x, y, 0, h);
rightLine.setBounds(x + (w - 1), y, 0, h);
topLine.setBounds(x, y, w - 1, 0);
bottomLine.setBounds(x, y + h, w - 1, 0);
seperator.setBounds(x, y + nameBounds.height, w - 1, 0);
firePropChange("bounds", oldBounds, getBounds());
calcBounds();
updateEdges();
} 
@Override
    public void setLineWidth(int w)
    { 
rightLine.setLineWidth(w);
leftLine.setLineWidth(w);
} 
private List<FigPartition> getPartitions(Layer layer)
    { 
final List<FigPartition> partitions = new ArrayList<FigPartition>();
for (Object o : layer.getContents()) //1
{ 
if(o instanceof FigPartition)//1
{ 
partitions.add((FigPartition) o);
} 
} 
return partitions;
} 
@Override
    public int getLineWidth()
    { 
return rightLine.getLineWidth();
} 
@Override
    public List getDragDependencies()
    { 
List dependents = getPartitions(getLayer());
dependents.add(getFigPool());
dependents.addAll(getFigPool().getEnclosedFigs());
return dependents;
} 
@Override
    public String placeString()
    { 
return "";
} 
@Override
    public void setFillColor(Color col)
    { 
getBigPort().setFillColor(col);
getNameFig().setFillColor(col);
} 
private void translateWithContents(int dx)
    { 
for (Fig f : getFigPool().getEnclosedFigs()) //1
{ 
f.setX(f.getX() + dx);
} 
setX(getX() + dx);
damage();
} 
@Override
    public Dimension getMinimumSize()
    { 
Dimension nameDim = getNameFig().getMinimumSize();
int w = nameDim.width;
int h = nameDim.height;
w = Math.max(MIN_WIDTH, w);
h = Math.max(MIN_HEIGHT, h);
return new Dimension(w, h);
} 
@Override
    public void removeFromDiagramImpl()
    { 
int width = getWidth();
FigPool figPool = getFigPool();
if(figPool == null)//1
{ 
super.removeFromDiagramImpl();
return;
} 
int newFigPoolWidth = figPool.getWidth() - width;
super.removeFromDiagramImpl();
FigPartition next = nextPartition;
while (next != null) //1
{ 
next.translateWithContents(-width);
next = next.nextPartition;
} 
if(nextPartition == null && previousPartition == null)//1
{ 
figPool.removeFromDiagram();
return;
} 
if(nextPartition != null)//1
{ 
nextPartition.setPreviousPartition(previousPartition);
} 
if(previousPartition != null)//1
{ 
previousPartition.setNextPartition(nextPartition);
} 
setPreviousPartition(null);
setNextPartition(null);
figPool.setWidth(newFigPoolWidth);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigPartition()
    { 
initFigs();
} 
void setPreviousPartition(FigPartition previous)
    { 
this.previousPartition = previous;
leftLine.setVisible(previousPartition == null);
} 
@Override
    public void setFilled(boolean f)
    { 
getBigPort().setFilled(f);
getNameFig().setFilled(f);
super.setFilled(f);
} 
@Override
    public void setLineColor(Color col)
    { 
rightLine.setLineColor(col);
leftLine.setLineColor(col);
bottomLine.setLineColor(col);
topLine.setLineColor(col);
seperator.setLineColor(col);
} 
@Override
    public boolean isFilled()
    { 
return getBigPort().isFilled();
} 
@Override
    public Object clone()
    { 
FigPartition figClone = (FigPartition) super.clone();
Iterator it = figClone.getFigs().iterator();
figClone.setBigPort((FigRect) it.next());
figClone.rightLine = (FigLine) it.next();
figClone.leftLine = (FigLine) it.next();
figClone.bottomLine = (FigLine) it.next();
figClone.topLine = (FigLine) it.next();
figClone.setNameFig((FigText) it.next());
return figClone;
} 
public FigPartition(Object owner, Rectangle bounds,
                        DiagramSettings settings)
    { 
super(owner, bounds, settings);
initFigs();
} 
@Override
    public Color getLineColor()
    { 
return rightLine.getLineColor();
} 
private class SelectionPartition extends Selection
  { 
private int cx;
private int cy;
private int cw;
private int ch;
public SelectionPartition(FigPartition f)
        { 
super(f);
} 
public void hitHandle(Rectangle r, Handle h)
        { 
if(getContent().isResizable())//1
{ 
updateHandleBox();
Rectangle testRect = new Rectangle(0, 0, 0, 0);
testRect.setBounds(
                    cx - HAND_SIZE / 2,
                    cy - HAND_SIZE / 2,
                    HAND_SIZE,
                    ch + HAND_SIZE / 2);
boolean leftEdge = r.intersects(testRect);
testRect.setBounds(
                    cx + cw - HAND_SIZE / 2,
                    cy - HAND_SIZE / 2,
                    HAND_SIZE,
                    ch + HAND_SIZE / 2);
boolean rightEdge = r.intersects(testRect);
testRect.setBounds(
                    cx - HAND_SIZE / 2,
                    cy - HAND_SIZE / 2,
                    cw + HAND_SIZE / 2,
                    HAND_SIZE);
boolean topEdge = r.intersects(testRect);
testRect.setBounds(
                    cx - HAND_SIZE / 2,
                    cy + ch - HAND_SIZE / 2,
                    cw + HAND_SIZE / 2,
                    HAND_SIZE);
boolean bottomEdge = r.intersects(testRect);
if(leftEdge && topEdge)//1
{ 
h.index = Handle.NORTHWEST;
h.instructions = "Resize top left";
} 
else
if(rightEdge && topEdge)//1
{ 
h.index = Handle.NORTHEAST;
h.instructions = "Resize top right";
} 
else
if(leftEdge && bottomEdge)//1
{ 
h.index = Handle.SOUTHWEST;
h.instructions = "Resize bottom left";
} 
else
if(rightEdge && bottomEdge)//1
{ 
h.index = Handle.SOUTHEAST;
h.instructions = "Resize bottom right";
} 
else
{ 
h.index = -1;
h.instructions = "Move object(s)";
} 
} 
else
{ 
h.index = -1;
h.instructions = "Move object(s)";
} 
} 
private void setHandleBox(
            FigPartition neighbour,
            int x,
            int y,
            int width,
            int height)
        { 
final List<FigPartition> partitions = getPartitions(getLayer());
int newNeighbourWidth = 0;
if(neighbour != null)//1
{ 
newNeighbourWidth =
                    (neighbour.getWidth() + getContent().getWidth()) - width;
if(neighbour.getMinimumSize().width > newNeighbourWidth)//1
{ 
return;
} 
} 
int lowX = 0;
int totalWidth = 0;
for (Fig f : partitions) //1
{ 
if(f == getContent())//1
{ 
f.setHandleBox(x, y, width, height);
} 
else
if(f == neighbour && f == previousPartition)//1
{ 
f.setHandleBox(f.getX(), y, newNeighbourWidth, height);
} 
else
if(f == neighbour && f == nextPartition)//1
{ 
f.setHandleBox(x + width, y, newNeighbourWidth, height);
} 
else
{ 
f.setHandleBox(f.getX(), y, f.getWidth(), height);
} 
if(f.getHandleBox().getX() < lowX || totalWidth == 0)//1
{ 
lowX = f.getHandleBox().x;
} 
totalWidth += f.getHandleBox().width;
} 
FigPool pool = getFigPool();
pool.setBounds(lowX, y, totalWidth, height);
} 
public void dragHandle(int mX, int mY, int anX, int anY, Handle hand)
        { 
final Fig fig = getContent();
updateHandleBox();
final int x = cx;
final int y = cy;
final int w = cw;
final int h = ch;
int newX = x, newY = y, newWidth = w, newHeight = h;
Dimension minSize = fig.getMinimumSize();
int minWidth = minSize.width, minHeight = minSize.height;
switch (hand.index) //1
{ 
case -1 ://1

fig.translate(anX - mX, anY - mY);
return;

case Handle.NORTHWEST ://1

newWidth = x + w - mX;
newWidth = (newWidth < minWidth) ? minWidth : newWidth;
newHeight = y + h - mY;
newHeight = (newHeight < minHeight) ? minHeight : newHeight;
newX = x + w - newWidth;
newY = y + h - newHeight;
if((newX + newWidth) != (x + w))//1
{ 
newX += (newX + newWidth) - (x + w);
} 
if((newY + newHeight) != (y + h))//1
{ 
newY += (newY + newHeight) - (y + h);
} 
setHandleBox(
                    previousPartition,
                    newX,
                    newY,
                    newWidth,
                    newHeight);
return;

case Handle.NORTH ://1

break;


case Handle.NORTHEAST ://1

newWidth = mX - x;
newWidth = (newWidth < minWidth) ? minWidth : newWidth;
newHeight = y + h - mY;
newHeight = (newHeight < minHeight) ? minHeight : newHeight;
newY = y + h - newHeight;
if((newY + newHeight) != (y + h))//1
{ 
newY += (newY + newHeight) - (y + h);
} 
setHandleBox(
                    nextPartition,
                    newX,
                    newY,
                    newWidth,
                    newHeight);
break;


case Handle.WEST ://1

break;


case Handle.EAST ://1

break;


case Handle.SOUTHWEST ://1

newWidth = x + w - mX;
newWidth = (newWidth < minWidth) ? minWidth : newWidth;
newHeight = mY - y;
newHeight = (newHeight < minHeight) ? minHeight : newHeight;
newX = x + w - newWidth;
if((newX + newWidth) != (x + w))//1
{ 
newX += (newX + newWidth) - (x + w);
} 
setHandleBox(
                    previousPartition,
                    newX,
                    newY,
                    newWidth,
                    newHeight);
break;


case Handle.SOUTH ://1

break;


case Handle.SOUTHEAST ://1

newWidth = mX - x;
newWidth = (newWidth < minWidth) ? minWidth : newWidth;
newHeight = mY - y;
newHeight = (newHeight < minHeight) ? minHeight : newHeight;
setHandleBox(
                    nextPartition,
                    newX,
                    newY,
                    newWidth,
                    newHeight);
break;


} 
} 
private void updateHandleBox()
        { 
final Rectangle cRect = getContent().getHandleBox();
cx = cRect.x;
cy = cRect.y;
cw = cRect.width;
ch = cRect.height;
} 
@Override
        public void paint(Graphics g)
        { 
final Fig fig = getContent();
if(getContent().isResizable())//1
{ 
updateHandleBox();
g.setColor(Globals.getPrefs().handleColorFor(fig));
g.fillRect(
                    cx - HAND_SIZE / 2,
                    cy - HAND_SIZE / 2,
                    HAND_SIZE,
                    HAND_SIZE);
g.fillRect(
                    cx + cw - HAND_SIZE / 2,
                    cy - HAND_SIZE / 2,
                    HAND_SIZE,
                    HAND_SIZE);
g.fillRect(
                    cx - HAND_SIZE / 2,
                    cy + ch - HAND_SIZE / 2,
                    HAND_SIZE,
                    HAND_SIZE);
g.fillRect(
                    cx + cw - HAND_SIZE / 2,
                    cy + ch - HAND_SIZE / 2,
                    HAND_SIZE,
                    HAND_SIZE);
} 
else
{ 
final int x = fig.getX();
final int y = fig.getY();
final int w = fig.getWidth();
final int h = fig.getHeight();
g.setColor(Globals.getPrefs().handleColorFor(fig));
g.drawRect(
                    x - BORDER_WIDTH,
                    y - BORDER_WIDTH,
                    w + BORDER_WIDTH * 2 - 1,
                    h + BORDER_WIDTH * 2 - 1);
g.drawRect(
                    x - BORDER_WIDTH - 1,
                    y - BORDER_WIDTH - 1,
                    w + BORDER_WIDTH * 2 + 2 - 1,
                    h + BORDER_WIDTH * 2 + 2 - 1);
g.fillRect(x - HAND_SIZE, y - HAND_SIZE, HAND_SIZE, HAND_SIZE);
g.fillRect(x + w, y - HAND_SIZE, HAND_SIZE, HAND_SIZE);
g.fillRect(x - HAND_SIZE, y + h, HAND_SIZE, HAND_SIZE);
g.fillRect(x + w, y + h, HAND_SIZE, HAND_SIZE);
} 
} 

 } 

 } 
