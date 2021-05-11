// Compilation Unit of /FigSubmachineState.java 
 
package org.argouml.uml.diagram.state.ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.util.Iterator;
import org.argouml.model.Model;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.FigSingleLineText;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.FigLine;
import org.tigris.gef.presentation.FigRRect;
import org.tigris.gef.presentation.FigRect;
import org.tigris.gef.presentation.FigText;
public class FigSubmachineState extends FigState
  { 
private static final int INCLUDE_HEIGHT = NAME_FIG_HEIGHT;
private static final int WIDTH = 90;
private FigRect cover;
private FigLine divider;
private FigLine divider2;
private FigRect circle1;
private FigRect circle2;
private FigLine circle1tocircle2;
private FigText include;
public FigSubmachineState(Object owner, Rectangle bounds,
                              DiagramSettings settings)
    { 
super(owner, bounds, settings);
include = new FigSingleLineText(owner,
                                        new Rectangle(X0, Y0, WIDTH, INCLUDE_HEIGHT), settings, true);
initFigs();
} 

private void updateInclude()
    { 
include.setText(generateSubmachine(getOwner()));
calcBounds();
setBounds(getBounds());
damage();
} 

protected int getInitialX()
    { 
return 0;
} 

@Override
    public void setFilled(boolean f)
    { 
cover.setFilled(f);
getBigPort().setFilled(f);
} 

@Deprecated
    public FigSubmachineState(@SuppressWarnings("unused") GraphModel gm,
                              Object node)
    { 
this();
setOwner(node);
} 

private String generateSubmachine(Object m)
    { 
Object c = Model.getFacade().getSubmachine(m);
String s = "include / ";
if((c == null)
                || (Model.getFacade().getName(c) == null)
                || (Model.getFacade().getName(c).length() == 0))//1
{ 
return s;
} 

return (s + Model.getFacade().getName(c));
} 

@Override
    public Object clone()
    { 
FigSubmachineState figClone = (FigSubmachineState) super.clone();
Iterator it = figClone.getFigs().iterator();
figClone.setBigPort((FigRect) it.next());
figClone.cover = (FigRect) it.next();
figClone.setNameFig((FigText) it.next());
figClone.divider = (FigLine) it.next();
figClone.include = (FigText) it.next();
figClone.divider2 = (FigLine) it.next();
figClone.setInternal((FigText) it.next());
return figClone;
} 

@SuppressWarnings("deprecation")

    @Deprecated
    @Override
    public void setOwner(Object node)
    { 
super.setOwner(node);
updateInclude();
} 

protected int getInitialWidth()
    { 
return 180;
} 

@Override
    public Dimension getMinimumSize()
    { 
Dimension nameDim = getNameFig().getMinimumSize();
Dimension internalDim = getInternal().getMinimumSize();
Dimension includeDim = include.getMinimumSize();
int h =
            SPACE_TOP + nameDim.height
            + SPACE_MIDDLE + includeDim.height
            + SPACE_MIDDLE + internalDim.height
            + SPACE_BOTTOM;
int waux =
            Math.max(nameDim.width,
                     internalDim.width) + 2 * MARGIN;
int w = Math.max(waux, includeDim.width + 50);
return new Dimension(w, h);
} 

private void updateListenersX(Object newOwner, Object oldV)
    { 
this.updateListeners(getOwner(), newOwner);
if(oldV != null)//1
{ 
removeElementListener(oldV);
} 

} 

@Override
    public Color getFillColor()
    { 
return cover.getFillColor();
} 

@Override
    public boolean getUseTrapRect()
    { 
return true;
} 

@Override
    public void setLineWidth(int w)
    { 
cover.setLineWidth(w);
divider.setLineWidth(w);
divider2.setLineWidth(w);
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
divider2.setLineColor(col);
circle1.setLineColor(col);
circle2.setLineColor(col);
circle1tocircle2.setLineColor(col);
} 

protected int getInitialHeight()
    { 
return 150;
} 

@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 
super.updateListeners(oldOwner, newOwner);
if(newOwner != null)//1
{ 
Object newSm = Model.getFacade().getSubmachine(newOwner);
if(newSm != null)//1
{ 
addElementListener(newSm);
} 

} 

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
include.setText(placeString());
include.setBounds(getInitialX() + 2, getInitialY() + 2,
                          getInitialWidth() - 4, include.getBounds().height);
include.setEditable(false);
include.setBotMargin(4);
divider2 =
            new FigLine(getInitialX(),
                        getInitialY() + 2 + getNameFig().getBounds().height + 1,
                        getInitialWidth() - 1,
                        getInitialY() + 2 + getNameFig().getBounds().height + 1,
                        LINE_COLOR);
circle1 =
            new FigRRect(getInitialX() + getInitialWidth() - 55,
                         getInitialY() + getInitialHeight() - 15,
                         20, 10,
                         LINE_COLOR, FILL_COLOR);
circle2 =
            new FigRRect(getInitialX() + getInitialWidth() - 25,
                         getInitialY() + getInitialHeight() - 15,
                         20, 10,
                         LINE_COLOR, FILL_COLOR);
circle1tocircle2 =
            new FigLine(getInitialX() + getInitialWidth() - 35,
                        getInitialY() + getInitialHeight() - 10,
                        getInitialX() + getInitialWidth() - 25,
                        getInitialY() + getInitialHeight() - 10,
                        LINE_COLOR);
addFig(getBigPort());
addFig(cover);
addFig(getNameFig());
addFig(divider);
addFig(include);
addFig(divider2);
addFig(getInternal());
addFig(circle1);
addFig(circle2);
addFig(circle1tocircle2);
setBounds(getBounds());
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
Dimension includeDim = include.getMinimumSize();
getNameFig().setBounds(x + MARGIN,
                               y + SPACE_TOP,
                               w - 2 * MARGIN,
                               nameDim.height);
divider.setShape(x,
                         y + DIVIDER_Y + nameDim.height,
                         x + w - 1,
                         y + DIVIDER_Y + nameDim.height);
include.setBounds(x + MARGIN,
                          y + SPACE_TOP + nameDim.height + SPACE_TOP,
                          w - 2 * MARGIN,
                          includeDim.height);
divider2.setShape(x,
                          y + nameDim.height + DIVIDER_Y + includeDim.height + DIVIDER_Y,
                          x + w - 1,
                          y + nameDim.height + DIVIDER_Y + includeDim.height + DIVIDER_Y);
getInternal().setBounds(
            x + MARGIN,
            y + SPACE_TOP + nameDim.height
            + SPACE_TOP + includeDim.height + SPACE_MIDDLE,
            w - 2 * MARGIN,
            h - SPACE_TOP - nameDim.height
            - SPACE_TOP - includeDim.height
            - SPACE_MIDDLE - SPACE_BOTTOM);
circle1.setBounds(x + w - 55,
                          y + h - 15,
                          20, 10);
circle2.setBounds(x + w - 25,
                          y + h - 15,
                          20, 10);
circle1tocircle2.setShape(x + w - 35,
                                  y + h - 10,
                                  x + w - 25,
                                  y + h - 10);
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

@SuppressWarnings("deprecation")

    @Deprecated
    public FigSubmachineState()
    { 
super();
include = new FigSingleLineText(X0, Y0, WIDTH, INCLUDE_HEIGHT, true);
initFigs();
} 

@Override
    public boolean isFilled()
    { 
return cover.isFilled();
} 

@Override
    public Color getLineColor()
    { 
return cover.getLineColor();
} 

protected void modelChanged(PropertyChangeEvent mee)
    { 
super.modelChanged(mee);
if(getOwner() == null)//1
{ 
return;
} 

if((mee.getSource().equals(getOwner())))//1
{ 
if((mee.getPropertyName()).equals("submachine"))//1
{ 
updateInclude();
if(mee.getOldValue() != null)//1
{ 
updateListenersX(getOwner(), mee.getOldValue());
} 

} 

} 
else
{ 
if(mee.getSource()
                    == Model.getFacade().getSubmachine(getOwner()))//1
{ 
if(mee.getPropertyName().equals("name"))//1
{ 
updateInclude();
} 

if(mee.getPropertyName().equals("top"))//1
{ 
updateListeners(getOwner(), null);
} 

} 

} 

} 

@Override
    public int getLineWidth()
    { 
return cover.getLineWidth();
} 

 } 


