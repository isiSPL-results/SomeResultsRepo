// Compilation Unit of /AbstractFigComponent.java 
 
package org.argouml.uml.diagram.deployment.ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.util.Collection;
import java.util.Iterator;
import org.argouml.model.AssociationChangeEvent;
import org.argouml.model.AttributeChangeEvent;
import org.argouml.model.Model;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.FigNodeModelElement;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.FigRect;
import org.tigris.gef.presentation.FigText;
public abstract class AbstractFigComponent extends FigNodeModelElement
  { 
private static final int BX = 10;
private static final int FINGER_HEIGHT = BX;
private static final int FINGER_WIDTH = BX * 2;
private static final int OVERLAP = 0;
private static final int DEFAULT_WIDTH = 120;
private static final int DEFAULT_HEIGHT = 80;
private FigRect cover;
private FigRect upperRect;
private FigRect lowerRect;
@Override
    public void setLineColor(Color c)
    { 
cover.setLineColor(c);
getStereotypeFig().setFilled(false);
getStereotypeFig().setLineWidth(0);
getNameFig().setFilled(false);
getNameFig().setLineWidth(0);
upperRect.setLineColor(c);
lowerRect.setLineColor(c);
} 

@Override
    public boolean getUseTrapRect()
    { 
return true;
} 

@Override
    public Dimension getMinimumSize()
    { 
Dimension stereoDim = getStereotypeFig().getMinimumSize();
Dimension nameDim = getNameFig().getMinimumSize();
int h = Math.max(stereoDim.height + nameDim.height - OVERLAP,
                         4 * FINGER_HEIGHT);
int w = Math.max(stereoDim.width, nameDim.width) + FINGER_WIDTH;
return new Dimension(w, h);
} 

@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 
super.updateListeners(oldOwner, newOwner);
if(newOwner != null)//1
{ 
Collection c = Model.getFacade().getStereotypes(newOwner);
Iterator i = c.iterator();
while (i.hasNext()) //1
{ 
Object st = i.next();
addElementListener(st, "name");
} 

} 

} 

@SuppressWarnings("deprecation")

    @Deprecated
    public AbstractFigComponent()
    { 
super();
initFigs();
} 

private void initFigs()
    { 
cover = new FigRect(BX, 10, DEFAULT_WIDTH, DEFAULT_HEIGHT, LINE_COLOR,
                            FILL_COLOR);
upperRect = new FigRect(0, 2 * FINGER_HEIGHT,
                                FINGER_WIDTH, FINGER_HEIGHT,
                                LINE_COLOR, FILL_COLOR);
lowerRect = new FigRect(0, 5 * FINGER_HEIGHT,
                                FINGER_WIDTH, FINGER_HEIGHT,
                                LINE_COLOR, FILL_COLOR);
getNameFig().setLineWidth(0);
getNameFig().setFilled(false);
getNameFig().setText(placeString());
addFig(getBigPort());
addFig(cover);
addFig(getStereotypeFig());
addFig(getNameFig());
addFig(upperRect);
addFig(lowerRect);
} 

@Override
    public void setHandleBox(int x, int y, int w, int h)
    { 
setBounds(x - BX, y, w + BX, h);
} 

@Override
    protected void setStandardBounds(int x, int y, int w,
                                     int h)
    { 
if(getNameFig() == null)//1
{ 
return;
} 

Rectangle oldBounds = getBounds();
getBigPort().setBounds(x + BX, y, w - BX, h);
cover.setBounds(x + BX, y, w - BX, h);
Dimension stereoDim = getStereotypeFig().getMinimumSize();
Dimension nameDim = getNameFig().getMinimumSize();
int halfHeight = FINGER_HEIGHT / 2;
upperRect.setBounds(x, y + h / 3 - halfHeight, FINGER_WIDTH,
                            FINGER_HEIGHT);
lowerRect.setBounds(x, y + 2 * h / 3 - halfHeight, FINGER_WIDTH,
                            FINGER_HEIGHT);
getStereotypeFig().setBounds(x + FINGER_WIDTH + 1,
                                     y + 1,
                                     w - FINGER_WIDTH - 2,
                                     stereoDim.height);
getNameFig().setBounds(x + FINGER_WIDTH + 1,
                               y + stereoDim.height - OVERLAP + 1,
                               w - FINGER_WIDTH - 2,
                               nameDim.height);
_x = x;
_y = y;
_w = w;
_h = h;
firePropChange("bounds", oldBounds, getBounds());
updateEdges();
} 

@Override
    public Object clone()
    { 
AbstractFigComponent figClone = (AbstractFigComponent) super.clone();
Iterator it = figClone.getFigs().iterator();
figClone.setBigPort((FigRect) it.next());
figClone.cover = (FigRect) it.next();
it.next();
figClone.setNameFig((FigText) it.next());
figClone.upperRect = (FigRect) it.next();
figClone.lowerRect = (FigRect) it.next();
return figClone;
} 

@Override
    protected void modelChanged(PropertyChangeEvent mee)
    { 
super.modelChanged(mee);
if(mee instanceof AssociationChangeEvent
                || mee instanceof AttributeChangeEvent)//1
{ 
renderingChanged();
updateListeners(getOwner(), getOwner());
damage();
} 

} 

@SuppressWarnings("deprecation")

    @Deprecated
    public AbstractFigComponent(@SuppressWarnings("unused") GraphModel gm,
                                Object node)
    { 
this();
setOwner(node);
} 

@Override
    public Rectangle getHandleBox()
    { 
Rectangle r = getBounds();
return new Rectangle(r.x + BX, r.y, r.width - BX, r.height);
} 

public AbstractFigComponent(Object owner, Rectangle bounds,
                                DiagramSettings settings)
    { 
super(owner, bounds, settings);
initFigs();
} 

 } 


