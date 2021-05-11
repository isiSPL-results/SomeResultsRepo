package org.argouml.uml.diagram.state.ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Iterator;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.FigLine;
import org.tigris.gef.presentation.FigRRect;
import org.tigris.gef.presentation.FigRect;
import org.tigris.gef.presentation.FigText;
public class FigSimpleState extends FigState
  { 
private FigRect cover;
private FigLine divider;
@Override
    public Dimension getMinimumSize()
    { 
Dimension nameDim = getNameFig().getMinimumSize();
Dimension internalDim = getInternal().getMinimumSize();
int h = SPACE_TOP + nameDim.height
                + SPACE_MIDDLE + internalDim.height
                + SPACE_BOTTOM;
int w = Math.max(nameDim.width + 2 * MARGIN,
                         internalDim.width + 2 * MARGIN);
return new Dimension(w, h);
} 
@Override
    public void setLineWidth(int w)
    { 
cover.setLineWidth(w);
divider.setLineWidth(w);
} 
@Override
    protected int getInitialX()
    { 
return 0;
} 
@Override
    public void setFillColor(Color col)
    { 
cover.setFillColor(col);
} 
@Override
    public void setLineColor(Color col)
    { 
cover.setLineColor(col);
divider.setLineColor(col);
} 
@Override
    public void setFilled(boolean f)
    { 
cover.setFilled(f);
getBigPort().setFilled(f);
} 
public FigSimpleState(Object owner, Rectangle bounds,
                          DiagramSettings settings)
    { 
super(owner, bounds, settings);
initializeSimpleState();
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigSimpleState()
    { 
initializeSimpleState();
} 
@Override
    public boolean isFilled()
    { 
return cover.isFilled();
} 
private void initializeSimpleState()
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
Rectangle r = getBounds();
setBounds(r.x, r.y, r.width, r.height);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigSimpleState(@SuppressWarnings("unused") GraphModel gm,
                          Object node)
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
    protected int getInitialY()
    { 
return 0;
} 
@Override
    public Object clone()
    { 
FigSimpleState figClone = (FigSimpleState) super.clone();
Iterator it = figClone.getFigs().iterator();
figClone.setBigPort((FigRRect) it.next());
figClone.cover = (FigRect) it.next();
figClone.setNameFig((FigText) it.next());
figClone.divider = (FigLine) it.next();
figClone.setInternal((FigText) it.next());
return figClone;
} 
@Override
    public int getLineWidth()
    { 
return cover.getLineWidth();
} 
@Override
    public Color getLineColor()
    { 
return cover.getLineColor();
} 
@Override
    protected int getInitialWidth()
    { 
return 70;
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
            y + SPACE_TOP + nameDim.height + SPACE_MIDDLE,
            w - 2 * MARGIN,
            h - SPACE_TOP - nameDim.height - SPACE_MIDDLE - SPACE_BOTTOM);
getBigPort().setBounds(x, y, w, h);
cover.setBounds(x, y, w, h);
calcBounds();
updateEdges();
firePropChange("bounds", oldBounds, getBounds());
} 
@Override
    protected int getInitialHeight()
    { 
return 40;
} 

 } 
