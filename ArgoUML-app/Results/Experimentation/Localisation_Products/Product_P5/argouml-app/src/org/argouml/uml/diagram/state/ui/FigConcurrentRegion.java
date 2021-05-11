package org.argouml.uml.diagram.state.ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JSeparator;
import org.argouml.model.Model;
import org.argouml.model.UmlChangeEvent;
import org.argouml.ui.ProjectActions;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.ActionAddConcurrentRegion;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.Layer;
import org.tigris.gef.base.Selection;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigLine;
import org.tigris.gef.presentation.FigRect;
import org.tigris.gef.presentation.FigText;
import org.tigris.gef.presentation.Handle;
public class FigConcurrentRegion extends FigState
 implements MouseListener
,MouseMotionListener
  { 
public static final int INSET_HORZ = 3;
public static final int INSET_VERT = 5;
private FigRect cover;
private FigLine dividerline;
private static Handle curHandle = new Handle(-1);
private static final long serialVersionUID = -7228935179004210975L;
@Override
    public Vector getPopUpActions(MouseEvent me)
    { 
Vector popUpActions = super.getPopUpActions(me);
popUpActions.remove(
            ProjectActions.getInstance().getRemoveFromDiagramAction());
popUpActions.add(new JSeparator());
popUpActions.addElement(
            new ActionAddConcurrentRegion());
return popUpActions;
} 
@Override
    public void setLineWidth(int w)
    { 
dividerline.setLineWidth(w);
} 
protected int getInitialX()
    { 
return 0;
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigConcurrentRegion()
    { 
super();
initialize();
} 
@Override
    public int getLineWidth()
    { 
return dividerline.getLineWidth();
} 
@Override
    public Dimension getMinimumSize()
    { 
Dimension nameDim = getNameFig().getMinimumSize();
Dimension internalDim = getInternal().getMinimumSize();
int h = nameDim.height + 4 + internalDim.height;
int w = nameDim.width + 2 * MARGIN;
return new Dimension(w, h);
} 
public int getInitialHeight()
    { 
return 130;
} 
@Override
    public Color getLineColor()
    { 
return dividerline.getLineColor();
} 
@Deprecated
    public FigConcurrentRegion(GraphModel gm, Object node,
                               Color col, int width, int height)
    { 
this(gm, node);
setLineColor(col);
Rectangle r = getBounds();
setBounds(r.x, r.y, width, height);
} 
@Override
    public void setFilled(boolean f)
    { 
cover.setFilled(f);
getBigPort().setFilled(f);
} 
public void setBounds(int xInc, int yInc, int w, int hInc,
                          boolean concurrency)
    { 
if(getNameFig() == null)//1
{ 
return;
} 
Rectangle oldBounds = getBounds();
Dimension nameDim = getNameFig().getMinimumSize();
int x = oldBounds.x + xInc;
int y = oldBounds.y + yInc;
int h = oldBounds.height + hInc;
dividerline.setShape(x, y,
                             x + w, y);
getNameFig().setBounds(x + 2, y + 2, w - 4, nameDim.height);
getInternal().setBounds(x + 2, y + nameDim.height + 4,
                                w - 4, h - nameDim.height - 8);
getBigPort().setBounds(x, y, w, h);
cover.setBounds(x, y, w, h);
calcBounds();
updateEdges();
firePropChange("bounds", oldBounds, getBounds());
} 
public void setBounds(int yInc, int hInc)
    { 
if(getNameFig() == null)//1
{ 
return;
} 
Rectangle oldBounds = getBounds();
Dimension nameDim = getNameFig().getMinimumSize();
int x = oldBounds.x;
int y = oldBounds.y + yInc;
int w = oldBounds.width;
int h = oldBounds.height + hInc;
dividerline.setShape(x, y, x + w, y);
getNameFig().setBounds(x + 2, y + 2, w - 4, nameDim.height);
getInternal().setBounds(x + 2, y + nameDim.height + 4,
                                w - 4, h - nameDim.height - 8);
getBigPort().setBounds(x, y, w, h);
cover.setBounds(x, y, w, h);
calcBounds();
updateEdges();
firePropChange("bounds", oldBounds, getBounds());
} 
private void initialize()
    { 
cover =
            new FigRect(getInitialX(),
                        getInitialY(),
                        getInitialWidth(), getInitialHeight(),
                        INVISIBLE_LINE_COLOR, FILL_COLOR);
dividerline = new FigLine(getInitialX(),
                                  getInitialY(),
                                  getInitialWidth(),
                                  getInitialY(),
                                  getInitialColor());
dividerline.setDashed(true);
getBigPort().setLineWidth(0);
cover.setLineWidth(0);
addFig(getBigPort());
addFig(cover);
addFig(getNameFig());
addFig(dividerline);
addFig(getInternal());
setShadowSize(0);
} 
@Override
    public Object clone()
    { 
FigConcurrentRegion figClone = (FigConcurrentRegion) super.clone();
Iterator it = figClone.getFigs().iterator();
figClone.setBigPort((FigRect) it.next());
figClone.cover = (FigRect) it.next();
figClone.setNameFig((FigText) it.next());
figClone.dividerline = (FigLine) it.next();
figClone.setInternal((FigText) it.next());
return figClone;
} 
public void setBounds(int xInc, int yInc, int w, boolean concurrency)
    { 
if(getNameFig() == null)//1
{ 
return;
} 
Rectangle oldBounds = getBounds();
Dimension nameDim = getNameFig().getMinimumSize();
int x = oldBounds.x + xInc;
int y = oldBounds.y + yInc;
int h = oldBounds.height;
dividerline.setShape(x, y, x + w, y);
getNameFig().setBounds(x + 2, y + 2, w - 4, nameDim.height);
getInternal().setBounds(x + 2, y + nameDim.height + 4,
                                w - 4, h - nameDim.height - 8);
getBigPort().setBounds(x, y, w, h);
cover.setBounds(x, y, w, h);
calcBounds();
updateEdges();
firePropChange("bounds", oldBounds, getBounds());
} 
@Override
    public Selection makeSelection()
    { 
Selection sel = new SelectionState(this);
((SelectionState) sel).setIncomingButtonEnabled(false);
((SelectionState) sel).setOutgoingButtonEnabled(false);
return sel;
} 
@Override
    public void setFillColor(Color col)
    { 
cover.setFillColor(col);
} 
@Override
    public boolean getUseTrapRect()
    { 
return true;
} 
@Override
    public void mousePressed(MouseEvent e)
    { 
int x = e.getX();
int y = e.getY();
Globals.curEditor().getSelectionManager().hitHandle(
            new Rectangle(x - 4, y - 4, 8, 8), curHandle);
} 
public FigConcurrentRegion(Object node, Rectangle bounds, DiagramSettings
                               settings)
    { 
super(node, bounds, settings);
initialize();
if(bounds != null)//1
{ 
setBounds(bounds.x - _x, bounds.y - _y, bounds.width,
                      bounds.height - _h, true);
} 
updateNameText();
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigConcurrentRegion(GraphModel gm, Object node)
    { 
this();
setOwner(node);
} 
@Override
    public Color getFillColor()
    { 
return cover.getFillColor();
} 
@Override
    public void setLayer(Layer lay)
    { 
super.setLayer(lay);
for (Fig f : lay.getContents()) //1
{ 
if(f instanceof FigCompositeState)//1
{ 
if(f.getOwner()
                        == Model.getFacade().getContainer(getOwner()))//1
{ 
setEnclosingFig(f);
break;

} 
} 
} 
} 
protected int getInitialWidth()
    { 
return 30;
} 
protected void modelChanged(PropertyChangeEvent mee)
    { 
if("container".equals(mee.getPropertyName())
                || "isConcurrent".equals(mee.getPropertyName())
                || "subvertex".equals(mee.getPropertyName()))//1
{ 
} 
else
{ 
super.modelChanged(mee);
} 
} 
public void mouseMoved(MouseEvent e)
    { 
} 
@Override
    public boolean isFilled()
    { 
return cover.isFilled();
} 
@Override
    public void setLineColor(Color col)
    { 
cover.setLineColor(INVISIBLE_LINE_COLOR);
dividerline.setLineColor(col);
} 
public void mouseDragged(MouseEvent e)
    { 
if(curHandle.index == -1)//1
{ 
Globals.curEditor().getSelectionManager().select(getEnclosingFig());
} 
} 
@Override
    public void mouseReleased(MouseEvent e)
    { 
curHandle.index = -1;
} 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 
if(getNameFig() == null)//1
{ 
return;
} 
Rectangle oldBounds = getBounds();
Dimension nameDim = getNameFig().getMinimumSize();
int adjacentindex = -1;
List regionsList = null;
int index = 0;
if(getEnclosingFig() != null)//1
{ 
x = oldBounds.x;
w = oldBounds.width;
FigCompositeState f = ((FigCompositeState) getEnclosingFig());
regionsList = f.getEnclosedFigs();
index = regionsList.indexOf(this);
if(((curHandle.index == 0) || (curHandle.index == 2))
                    && index > 0)//1
{ 
adjacentindex = index - 1;
} 
if(((curHandle.index == 5) || (curHandle.index == 7))
                    && (index < (regionsList.size() - 1)))//1
{ 
adjacentindex = index + 1;
} 
if(h <= getMinimumSize().height)//1
{ 
if(h <= oldBounds.height)//1
{ 
h = oldBounds.height;
y = oldBounds.y;
} 
} 
if(adjacentindex == -1)//1
{ 
x = oldBounds.x;
y = oldBounds.y;
h = oldBounds.height;
if(w > f.getBounds().width)//1
{ 
Rectangle fR = f.getBounds();
f.setBounds(fR.x, fR.y, w + 6, fR.height);
} 
} 
else
{ 
int hIncrement = oldBounds.height - h;
FigConcurrentRegion adjacentFig =
                    ((FigConcurrentRegion)
                     regionsList.get(adjacentindex));
if((adjacentFig.getBounds().height + hIncrement)
                        <= adjacentFig.getMinimumSize().height)//1
{ 
y = oldBounds.y;
h = oldBounds.height;
} 
else
{ 
if((curHandle.index == 0) || (curHandle.index == 2))//1
{ 
((FigConcurrentRegion) regionsList.
                         get(adjacentindex)).setBounds(0, hIncrement);
} 
if((curHandle.index == 5) || (curHandle.index == 7))//1
{ 
((FigConcurrentRegion) regionsList.
                         get(adjacentindex)).setBounds(-hIncrement,
                                                       hIncrement);
} 
} 
} 
} 
dividerline.setShape(x, y, x + w, y);
getNameFig().setBounds(x + MARGIN,
                               y + SPACE_TOP,
                               w - 2 * MARGIN,
                               nameDim.height);
getInternal().setBounds(
            x + MARGIN,
            y + nameDim.height + SPACE_TOP + SPACE_MIDDLE,
            w - 2 * MARGIN,
            h - nameDim.height - SPACE_TOP - SPACE_MIDDLE - SPACE_BOTTOM);
getBigPort().setBounds(x, y, w, h);
cover.setBounds(x, y, w, h);
calcBounds();
updateEdges();
firePropChange("bounds", oldBounds, getBounds());
} 
protected int getInitialY()
    { 
return 0;
} 
@Override
    protected void updateLayout(UmlChangeEvent event)
    { 
if(!"container".equals(event.getPropertyName()) &&
                !"isConcurrent".equals(event.getPropertyName()))//1
{ 
super.updateLayout(event);
} 
final String eName = event.getPropertyName();
if(eName == "incoming" || eName == "outgoing")//1
{ 
final Object owner = getOwner();
final Collection transactions = (Collection) event.getNewValue();
if(!transactions.isEmpty())//1
{ 
final Object transition = transactions.iterator().next();
if(eName == "incoming")//1
{ 
if(Model.getFacade().isATransition(transition))//1
{ 
Model.getCommonBehaviorHelper().setTarget(transition,
                                Model.getFacade().getContainer(owner));
} 
} 
else
{ 
if(Model.getFacade().isATransition(transition))//1
{ 
Model.getStateMachinesHelper().setSource(transition,
                                Model.getFacade().getContainer(owner));
} 
} 
} 
} 
} 
protected Color getInitialColor()
    { 
return LINE_COLOR;
} 

 } 
