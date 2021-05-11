
//#if -291288191 
// Compilation Unit of /FigObject.java 
 

//#if -562804350 
package org.argouml.uml.diagram.deployment.ui;
//#endif 


//#if 769520379 
import java.awt.Color;
//#endif 


//#if 627760088 
import java.awt.Dimension;
//#endif 


//#if 613981423 
import java.awt.Rectangle;
//#endif 


//#if 270276020 
import java.util.Iterator;
//#endif 


//#if 79006125 
import org.argouml.model.Model;
//#endif 


//#if -1915074710 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if -1751432816 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -109415215 
import org.argouml.uml.diagram.ui.FigNodeModelElement;
//#endif 


//#if -264485563 
import org.tigris.gef.base.Selection;
//#endif 


//#if 1108394969 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 170509988 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1101964128 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if -1100096905 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 502613832 
public class FigObject extends 
//#if -22001021 
FigNodeModelElement
//#endif 

  { 

//#if 708470303 
private FigRect cover;
//#endif 


//#if -1157852448 
@Override
    public Object clone()
    { 

//#if 1763802534 
FigObject figClone = (FigObject) super.clone();
//#endif 


//#if -1336560452 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if -1548578965 
figClone.setBigPort((FigRect) it.next());
//#endif 


//#if 1585842505 
figClone.cover = (FigRect) it.next();
//#endif 


//#if -2087637924 
figClone.setNameFig((FigText) it.next());
//#endif 


//#if 1063712091 
return figClone;
//#endif 

} 

//#endif 


//#if 726542020 
@Override
    public void setLineColor(Color col)
    { 

//#if 236465416 
cover.setLineColor(col);
//#endif 

} 

//#endif 


//#if 193053731 
@Override
    public void setEnclosingFig(Fig encloser)
    { 

//#if -1339611444 
assert Model.getFacade().isAObject(getOwner());
//#endif 


//#if 1355191090 
Object owner = getOwner();
//#endif 


//#if 1564059103 
if(encloser != null
                && (Model.getFacade()
                    .isAComponentInstance(encloser.getOwner())))//1
{ 

//#if -166321505 
Model.getCommonBehaviorHelper()
            .setComponentInstance(owner, encloser.getOwner());
//#endif 


//#if -769557830 
super.setEnclosingFig(encloser);
//#endif 

} 
else

//#if 309537794 
if(Model.getFacade().getComponentInstance(owner) != null)//1
{ 

//#if 918782528 
Model.getCommonBehaviorHelper().setComponentInstance(owner, null);
//#endif 


//#if -1740297933 
super.setEnclosingFig(null);
//#endif 

} 

//#endif 


//#endif 


//#if -1466636694 
if(encloser != null
                && (Model.getFacade()
                    .isAComponent(encloser.getOwner())))//1
{ 

//#if -1774841500 
moveIntoComponent(encloser);
//#endif 


//#if -751887959 
super.setEnclosingFig(encloser);
//#endif 

} 
else

//#if 1459361826 
if(encloser != null
                   && Model.getFacade().isANode(encloser.getOwner()))//1
{ 

//#if -1564430931 
super.setEnclosingFig(encloser);
//#endif 

} 
else

//#if -543586936 
if(encloser == null)//1
{ 

//#if 534240253 
super.setEnclosingFig(null);
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if 832848116 
public FigObject(Object owner, Rectangle bounds, DiagramSettings settings)
    { 

//#if -60842587 
super(owner, bounds, settings);
//#endif 


//#if 1123419578 
initFigs();
//#endif 

} 

//#endif 


//#if 740898610 
@Override
    public Selection makeSelection()
    { 

//#if 620721901 
return new SelectionObject(this);
//#endif 

} 

//#endif 


//#if 540953916 
@Override
    public void setLineWidth(int w)
    { 

//#if 1862128382 
cover.setLineWidth(w);
//#endif 

} 

//#endif 


//#if -2025302314 
@Override
    public boolean isFilled()
    { 

//#if -1291281203 
return cover.isFilled();
//#endif 

} 

//#endif 


//#if -853122786 
@Override
    public Color getLineColor()
    { 

//#if -641238449 
return cover.getLineColor();
//#endif 

} 

//#endif 


//#if -1343940533 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 

//#if -1888669459 
if(getNameFig() == null)//1
{ 

//#if 17679334 
return;
//#endif 

} 

//#endif 


//#if -1727552018 
Rectangle oldBounds = getBounds();
//#endif 


//#if -288074238 
Dimension nameMin = getNameFig().getMinimumSize();
//#endif 


//#if -45813348 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if 1880665765 
cover.setBounds(x, y, w, h);
//#endif 


//#if 779737 
getNameFig().setBounds(x, y, nameMin.width + 10, nameMin.height + 4);
//#endif 


//#if 1333876598 
_x = x;
//#endif 


//#if 1333906420 
_y = y;
//#endif 


//#if 1333846776 
_w = w;
//#endif 


//#if 1333399446 
_h = h;
//#endif 


//#if 223914043 
firePropChange("bounds", oldBounds, getBounds());
//#endif 


//#if 871891199 
calcBounds();
//#endif 


//#if 602372030 
updateEdges();
//#endif 

} 

//#endif 


//#if 2047190078 

//#if 1921030527 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigObject()
    { 

//#if 1627368428 
super();
//#endif 


//#if -1123691570 
initFigs();
//#endif 

} 

//#endif 


//#if -1959214719 
private void initFigs()
    { 

//#if -1729693039 
setBigPort(new FigRect(X0, Y0, 90, 50, DEBUG_COLOR, DEBUG_COLOR));
//#endif 


//#if 1703085050 
cover = new FigRect(X0, Y0, 90, 50, LINE_COLOR, FILL_COLOR);
//#endif 


//#if 273235152 
getNameFig().setLineWidth(0);
//#endif 


//#if -507173653 
getNameFig().setFilled(false);
//#endif 


//#if 843156280 
getNameFig().setUnderline(true);
//#endif 


//#if 372523247 
Dimension nameMin = getNameFig().getMinimumSize();
//#endif 


//#if -1007504278 
getNameFig().setBounds(X0, Y0, nameMin.width + 20, nameMin.height);
//#endif 


//#if 799142783 
addFig(getBigPort());
//#endif 


//#if -1449304920 
addFig(cover);
//#endif 


//#if -30423209 
addFig(getNameFig());
//#endif 


//#if -532073243 
Rectangle r = getBounds();
//#endif 


//#if -615484191 
setBounds(r.x, r.y, nameMin.width, nameMin.height);
//#endif 

} 

//#endif 


//#if 1297397133 
@Override
    protected int getNotationProviderType()
    { 

//#if 1374856824 
return NotationProviderFactory2.TYPE_OBJECT;
//#endif 

} 

//#endif 


//#if -1977744767 
@Override
    public Dimension getMinimumSize()
    { 

//#if 1469939698 
Dimension nameMin = getNameFig().getMinimumSize();
//#endif 


//#if 889142972 
int w = nameMin.width + 10;
//#endif 


//#if -890400448 
int h = nameMin.height + 5;
//#endif 


//#if 1385650970 
w = Math.max(60, w);
//#endif 


//#if 1492783988 
return new Dimension(w, h);
//#endif 

} 

//#endif 


//#if 1738274037 

//#if 1309188709 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigObject(@SuppressWarnings("unused") GraphModel gm, Object node)
    { 

//#if 214875931 
this();
//#endif 


//#if -1579087766 
setOwner(node);
//#endif 

} 

//#endif 


//#if -1127440492 
@Override
    public void setFilled(boolean f)
    { 

//#if 864774746 
cover.setFilled(f);
//#endif 

} 

//#endif 


//#if -26637137 
@Override
    public Color getFillColor()
    { 

//#if 1895378120 
return cover.getFillColor();
//#endif 

} 

//#endif 


//#if -486985387 
@Override
    public void setFillColor(Color col)
    { 

//#if -360048062 
cover.setFillColor(col);
//#endif 

} 

//#endif 


//#if -279647571 
@Override
    public int getLineWidth()
    { 

//#if 41669948 
return cover.getLineWidth();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

