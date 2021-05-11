package org.argouml.uml.diagram.collaboration.ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Iterator;
import org.argouml.model.AddAssociationEvent;
import org.argouml.model.AttributeChangeEvent;
import org.argouml.model.UmlChangeEvent;
import org.argouml.notation.NotationProviderFactory2;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.FigNodeModelElement;
import org.tigris.gef.base.Layer;
import org.tigris.gef.base.Selection;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.FigRect;
import org.tigris.gef.presentation.FigText;
public class FigClassifierRole extends FigNodeModelElement
  { 
private static final int DEFAULT_HEIGHT = 50;
private static final int DEFAULT_WIDTH = 90;
private static final int PADDING = 5;
private FigRect cover;
@SuppressWarnings("deprecation")

    @Deprecated
    public FigClassifierRole(@SuppressWarnings("unused")
                             GraphModel gm, Layer lay, Object node)
    { 
this();
setLayer(lay);
setOwner(node);
} 
@Override
    public Selection makeSelection()
    { 
return new SelectionClassifierRole(this);
} 
@Override
    public void setFillColor(Color col)
    { 
cover.setFillColor(col);
} 
@Override
    protected int getNotationProviderType()
    { 
return NotationProviderFactory2.TYPE_CLASSIFIERROLE;
} 
@Override
    public Object clone()
    { 
FigClassifierRole figClone = (FigClassifierRole) super.clone();
Iterator it = figClone.getFigs().iterator();
figClone.setBigPort((FigRect) it.next());
figClone.cover   = (FigRect) it.next();
it.next();
figClone.setNameFig((FigText) it.next());
return figClone;
} 
@Override
    public boolean isFilled()
    { 
return cover.isFilled();
} 
private void initClassifierRoleFigs()
    { 
setBigPort(new FigRect(X0, Y0, DEFAULT_WIDTH, DEFAULT_HEIGHT,
                               DEBUG_COLOR, DEBUG_COLOR));
cover = new FigRect(X0, Y0, DEFAULT_WIDTH, DEFAULT_HEIGHT, LINE_COLOR,
                            FILL_COLOR);
getStereotypeFig().setLineWidth(0);
getStereotypeFig().setVisible(true);
getStereotypeFig().setFillColor(DEBUG_COLOR);
getStereotypeFig().setBounds(X0, Y0,
                                     DEFAULT_WIDTH, getStereotypeFig().getHeight());
getNameFig().setLineWidth(0);
getNameFig().setReturnAction(FigText.END_EDITING);
getNameFig().setFilled(false);
getNameFig().setUnderline(true);
getNameFig().setBounds(X0, Y0,
                               DEFAULT_WIDTH, getStereotypeFig().getHeight());
addFig(getBigPort());
addFig(cover);
addFig(getStereotypeFig());
addFig(getNameFig());
} 
@Override
    public Color getLineColor()
    { 
return cover.getLineColor();
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigClassifierRole()
    { 
initClassifierRoleFigs();
Rectangle r = getBounds();
setBounds(r.x, r.y, r.width, r.height);
} 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 
if(getNameFig() == null)//1
{ 
return;
} 
Rectangle oldBounds = getBounds();
Dimension minSize   = getMinimumSize();
int newW = (minSize.width  > w) ? minSize.width  : w;
int newH = (minSize.height > h) ? minSize.height : h;
Dimension stereoMin = getStereotypeFig().getMinimumSize();
Dimension nameMin   = getNameFig().getMinimumSize();
int extraEach = (newH - nameMin.height - stereoMin.height) / 2;
if(!(stereoMin.height == 0 && stereoMin.width == 0))//1
{ 
getStereotypeFig().setBounds(x, y + extraEach, newW,
                                         getStereotypeFig().getHeight());
} 
getNameFig().setBounds(x, y + stereoMin.height + extraEach, newW,
                               nameMin.height);
getBigPort().setBounds(x, y, newW, newH);
cover.setBounds(x, y, newW, newH);
_x = x;
_y = y;
_w = newW;
_h = newH;
firePropChange("bounds", oldBounds, getBounds());
updateEdges();
} 
@Override
    public int getLineWidth()
    { 
return cover.getLineWidth();
} 
@Override
    public Dimension getMinimumSize()
    { 
Dimension stereoMin  = getStereotypeFig().getMinimumSize();
Dimension nameMin    = getNameFig().getMinimumSize();
Dimension newMin    = new Dimension(nameMin.width, nameMin.height);
if(!(stereoMin.height == 0 && stereoMin.width == 0))//1
{ 
newMin.width   = Math.max(newMin.width, stereoMin.width);
newMin.height += stereoMin.height;
} 
newMin.height += PADDING;
return newMin;
} 
@Override
    public void setFilled(boolean f)
    { 
cover.setFilled(f);
} 
@Override
    public void setLineColor(Color col)
    { 
cover.setLineColor(col);
} 
@Override
    protected void updateStereotypeText()
    { 
Rectangle rect = getBounds();
int stereotypeHeight = 0;
if(getStereotypeFig().isVisible())//1
{ 
stereotypeHeight = getStereotypeFig().getHeight();
} 
int heightWithoutStereo = getHeight() - stereotypeHeight;
getStereotypeFig().populate();
stereotypeHeight = 0;
if(getStereotypeFig().isVisible())//2
{ 
stereotypeHeight = getStereotypeFig().getHeight();
} 
int minWidth = this.getMinimumSize().width;
if(minWidth > rect.width)//1
{ 
rect.width = minWidth;
} 
setBounds(
            rect.x,
            rect.y,
            rect.width,
            heightWithoutStereo + stereotypeHeight);
calcBounds();
} 
@Override
    public Color getFillColor()
    { 
return cover.getFillColor();
} 
@Override
    public void setLineWidth(int w)
    { 
cover.setLineWidth(w);
} 
@Override
    protected void updateLayout(UmlChangeEvent event)
    { 
super.updateLayout(event);
if(event instanceof AddAssociationEvent
                || event instanceof AttributeChangeEvent)//1
{ 
renderingChanged();
damage();
} 
} 
public FigClassifierRole(Object owner, Rectangle bounds,
                             DiagramSettings settings)
    { 
super(owner, bounds, settings);
initClassifierRoleFigs();
if(bounds != null)//1
{ 
setLocation(bounds.x, bounds.y);
} 
} 

 } 
