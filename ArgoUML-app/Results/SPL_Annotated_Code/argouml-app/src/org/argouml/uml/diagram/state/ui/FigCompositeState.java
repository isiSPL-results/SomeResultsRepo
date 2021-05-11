// Compilation Unit of /FigCompositeState.java 
 
package org.argouml.uml.diagram.state.ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;
import org.argouml.model.Model;
import org.argouml.model.RemoveAssociationEvent;
import org.argouml.model.UmlChangeEvent;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.ActionAddConcurrentRegion;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigLine;
import org.tigris.gef.presentation.FigRRect;
import org.tigris.gef.presentation.FigRect;
import org.tigris.gef.presentation.FigText;
public class FigCompositeState extends FigState
  { 
private FigRect cover;
private FigLine divider;
public Object clone()
    { 
FigCompositeState figClone = (FigCompositeState) super.clone();
Iterator it = figClone.getFigs().iterator();
figClone.setBigPort((FigRRect) it.next());
figClone.cover = (FigRect) it.next();
figClone.setNameFig((FigText) it.next());
figClone.divider = (FigLine) it.next();
figClone.setInternal((FigText) it.next());
return figClone;
} 

public void setLineWidth(int w)
    { 
cover.setLineWidth(w);
divider.setLineWidth(w);
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigCompositeState()
    { 
super();
initFigs();
} 

public void setFilled(boolean f)
    { 
cover.setFilled(f);
getBigPort().setFilled(f);
} 

public Vector getPopUpActions(MouseEvent me)
    { 
Vector popUpActions = super.getPopUpActions(me);
boolean ms = TargetManager.getInstance().getTargets().size() > 1;
if(!ms)//1
{ 
popUpActions.add(
                popUpActions.size() - getPopupAddOffset(),
                new ActionAddConcurrentRegion());
} 

return popUpActions;
} 

protected int getInitialHeight()
    { 
return 150;
} 

protected int getInitialWidth()
    { 
return 180;
} 

public Color getFillColor()
    { 
return cover.getFillColor();
} 

public boolean getUseTrapRect()
    { 
return true;
} 

protected void setStandardBounds(int x, int y, int w, int h)
    { 
if(getNameFig() == null)//1
{ 
return;
} 

Rectangle oldBounds = getBounds();
Dimension nameDim = getNameFig().getMinimumSize();
List regionsList = getEnclosedFigs();
if(getOwner() != null)//1
{ 
if(isConcurrent()
                    && !regionsList.isEmpty()
                    && regionsList.get(regionsList.size() - 1)
                    instanceof FigConcurrentRegion)//1
{ 
FigConcurrentRegion f =
                    ((FigConcurrentRegion) regionsList.get(
                         regionsList.size() - 1));
Rectangle regionBounds = f.getBounds();
if((h - oldBounds.height + regionBounds.height)
                        <= (f.getMinimumSize().height))//1
{ 
h = oldBounds.height;
y = oldBounds.y;
} 

} 

} 

getNameFig().setBounds(x + MARGIN,
                               y + SPACE_TOP,
                               w - 2 * MARGIN,
                               nameDim.height);
divider.setShape(x,
                         y + DIVIDER_Y + nameDim.height,
                         x + w - 1,
                         y + DIVIDER_Y + nameDim.height);
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
if(getOwner() != null)//2
{ 
if(isConcurrent()
                    && !regionsList.isEmpty()
                    && regionsList.get(regionsList.size() - 1)
                    instanceof FigConcurrentRegion)//1
{ 
FigConcurrentRegion f = ((FigConcurrentRegion) regionsList
                                         .get(regionsList.size() - 1));
for (int i = 0; i < regionsList.size() - 1; i++) //1
{ 
((FigConcurrentRegion) regionsList.get(i))
                    .setBounds(x - oldBounds.x, y - oldBounds.y,
                               w - 2 * FigConcurrentRegion.INSET_HORZ, true);
} 

f.setBounds(x - oldBounds.x,
                            y - oldBounds.y,
                            w - 2 * FigConcurrentRegion.INSET_HORZ,
                            h - oldBounds.height, true);
} 

} 

} 

public boolean isConcurrent()
    { 
Object owner = getOwner();
if(owner == null)//1
{ 
return false;
} 

return Model.getFacade().isConcurrent(owner);
} 

@Override
    public boolean isFilled()
    { 
return cover.isFilled();
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigCompositeState(@SuppressWarnings("unused") GraphModel gm, Object node)
    { 
this();
setOwner(node);
} 

public int getLineWidth()
    { 
return cover.getLineWidth();
} 

protected int getInitialX()
    { 
return 0;
} 

public void setLineColor(Color col)
    { 
cover.setLineColor(col);
divider.setLineColor(col);
} 

public void setCompositeStateHeight(int h)
    { 
if(getNameFig() == null)//1
{ 
return;
} 

Rectangle oldBounds = getBounds();
Dimension nameDim = getNameFig().getMinimumSize();
int x = oldBounds.x;
int y = oldBounds.y;
int w = oldBounds.width;
getInternal().setBounds(
            x + MARGIN,
            y + nameDim.height + 4,
            w - 2 * MARGIN,
            h - nameDim.height - 6);
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

public Dimension getMinimumSize()
    { 
Dimension nameDim = getNameFig().getMinimumSize();
Dimension internalDim = getInternal().getMinimumSize();
int h =
            SPACE_TOP + nameDim.height
            + SPACE_MIDDLE + internalDim.height
            + SPACE_BOTTOM;
int w =
            Math.max(nameDim.width + 2 * MARGIN,
                     internalDim.width + 2 * MARGIN);
return new Dimension(w, h);
} 

@Override
    protected void updateLayout(UmlChangeEvent event)
    { 
if(!(event instanceof RemoveAssociationEvent) ||
                !"subvertex".equals(event.getPropertyName()))//1
{ 
return;
} 

final Object removedRegion = event.getOldValue();
List<FigConcurrentRegion> regionFigs =
            ((List<FigConcurrentRegion>) getEnclosedFigs().clone());
int totHeight = getInitialHeight();
if(!regionFigs.isEmpty())//1
{ 
Fig removedFig = null;
for (FigConcurrentRegion figRegion : regionFigs) //1
{ 
if(figRegion.getOwner() == removedRegion)//1
{ 
removedFig = figRegion;
removeEnclosedFig(figRegion);
break;

} 

} 

if(removedFig != null)//1
{ 
regionFigs.remove(removedFig);
if(!regionFigs.isEmpty())//1
{ 
for (FigConcurrentRegion figRegion : regionFigs) //1
{ 
if(figRegion.getY() > removedFig.getY())//1
{ 
figRegion.displace(0, -removedFig.getHeight());
} 

} 

totHeight = getHeight() - removedFig.getHeight();
} 

} 

} 

setBounds(getX(), getY(), getWidth(), totHeight);
renderingChanged();
} 

public FigCompositeState(Object owner, Rectangle bounds,
                             DiagramSettings settings)
    { 
super(owner, bounds, settings);
initFigs();
updateNameText();
} 

public void setFillColor(Color col)
    { 
cover.setFillColor(col);
} 

public Color getLineColor()
    { 
return cover.getLineColor();
} 

private void initFigs()
    { 
cover =
            new FigRRect(getInitialX(), getInitialY(),
                         getInitialWidth(), getInitialHeight(),
                         LINE_COLOR, FILL_COLOR);
getBigPort().setLineWidth(0);
divider =
            new FigLine(getInitialX(),
                        getInitialY() + 2 + getNameFig().getBounds().height + 1,
                        getInitialWidth() - 1,
                        getInitialY() + 2 + getNameFig().getBounds().height + 1,
                        LINE_COLOR);
addFig(getBigPort());
addFig(cover);
addFig(getNameFig());
addFig(divider);
addFig(getInternal());
setBounds(getBounds());
} 

@Deprecated
    public void setBounds(int h)
    { 
setCompositeStateHeight(h);
} 

@Override
    public Vector<Fig> getEnclosedFigs()
    { 
Vector<Fig> enclosedFigs = super.getEnclosedFigs();
if(isConcurrent())//1
{ 
TreeMap<Integer, Fig> figsByY = new TreeMap<Integer, Fig>();
for (Fig fig : enclosedFigs) //1
{ 
if(fig instanceof FigConcurrentRegion)//1
{ 
figsByY.put(fig.getY(), fig);
} 

} 

return new Vector<Fig>(figsByY.values());
} 

return enclosedFigs;
} 

 } 


