// Compilation Unit of /FigObject.java 
 
package org.argouml.uml.diagram.deployment.ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Iterator;
import org.argouml.model.Model;
import org.argouml.notation.NotationProviderFactory2;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.FigNodeModelElement;
import org.tigris.gef.base.Selection;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigRect;
import org.tigris.gef.presentation.FigText;
public class FigObject extends FigNodeModelElement
  { 
private FigRect cover;
@Override
    public Object clone()
    { 
FigObject figClone = (FigObject) super.clone();
Iterator it = figClone.getFigs().iterator();
figClone.setBigPort((FigRect) it.next());
figClone.cover = (FigRect) it.next();
figClone.setNameFig((FigText) it.next());
return figClone;
} 

@Override
    public void setLineColor(Color col)
    { 
cover.setLineColor(col);
} 

@Override
    public void setEnclosingFig(Fig encloser)
    { 
assert Model.getFacade().isAObject(getOwner());
Object owner = getOwner();
if(encloser != null
                && (Model.getFacade()
                    .isAComponentInstance(encloser.getOwner())))//1
{ 
Model.getCommonBehaviorHelper()
            .setComponentInstance(owner, encloser.getOwner());
super.setEnclosingFig(encloser);
} 
else
if(Model.getFacade().getComponentInstance(owner) != null)//1
{ 
Model.getCommonBehaviorHelper().setComponentInstance(owner, null);
super.setEnclosingFig(null);
} 


if(encloser != null
                && (Model.getFacade()
                    .isAComponent(encloser.getOwner())))//1
{ 
moveIntoComponent(encloser);
super.setEnclosingFig(encloser);
} 
else
if(encloser != null
                   && Model.getFacade().isANode(encloser.getOwner()))//1
{ 
super.setEnclosingFig(encloser);
} 
else
if(encloser == null)//1
{ 
super.setEnclosingFig(null);
} 



} 

public FigObject(Object owner, Rectangle bounds, DiagramSettings settings)
    { 
super(owner, bounds, settings);
initFigs();
} 

@Override
    public Selection makeSelection()
    { 
return new SelectionObject(this);
} 

@Override
    public void setLineWidth(int w)
    { 
cover.setLineWidth(w);
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

@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 
if(getNameFig() == null)//1
{ 
return;
} 

Rectangle oldBounds = getBounds();
Dimension nameMin = getNameFig().getMinimumSize();
getBigPort().setBounds(x, y, w, h);
cover.setBounds(x, y, w, h);
getNameFig().setBounds(x, y, nameMin.width + 10, nameMin.height + 4);
_x = x;
_y = y;
_w = w;
_h = h;
firePropChange("bounds", oldBounds, getBounds());
calcBounds();
updateEdges();
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigObject()
    { 
super();
initFigs();
} 

private void initFigs()
    { 
setBigPort(new FigRect(X0, Y0, 90, 50, DEBUG_COLOR, DEBUG_COLOR));
cover = new FigRect(X0, Y0, 90, 50, LINE_COLOR, FILL_COLOR);
getNameFig().setLineWidth(0);
getNameFig().setFilled(false);
getNameFig().setUnderline(true);
Dimension nameMin = getNameFig().getMinimumSize();
getNameFig().setBounds(X0, Y0, nameMin.width + 20, nameMin.height);
addFig(getBigPort());
addFig(cover);
addFig(getNameFig());
Rectangle r = getBounds();
setBounds(r.x, r.y, nameMin.width, nameMin.height);
} 

@Override
    protected int getNotationProviderType()
    { 
return NotationProviderFactory2.TYPE_OBJECT;
} 

@Override
    public Dimension getMinimumSize()
    { 
Dimension nameMin = getNameFig().getMinimumSize();
int w = nameMin.width + 10;
int h = nameMin.height + 5;
w = Math.max(60, w);
return new Dimension(w, h);
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigObject(@SuppressWarnings("unused") GraphModel gm, Object node)
    { 
this();
setOwner(node);
} 

@Override
    public void setFilled(boolean f)
    { 
cover.setFilled(f);
} 

@Override
    public Color getFillColor()
    { 
return cover.getFillColor();
} 

@Override
    public void setFillColor(Color col)
    { 
cover.setFillColor(col);
} 

@Override
    public int getLineWidth()
    { 
return cover.getLineWidth();
} 

 } 


