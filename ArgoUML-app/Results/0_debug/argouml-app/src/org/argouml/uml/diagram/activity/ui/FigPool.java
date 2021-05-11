
//#if 807644179 
// Compilation Unit of /FigPool.java 
 

//#if 716492484 
package org.argouml.uml.diagram.activity.ui;
//#endif 


//#if 587091443 
import java.awt.Color;
//#endif 


//#if -1938490672 
import java.awt.Dimension;
//#endif 


//#if -1952269337 
import java.awt.Rectangle;
//#endif 


//#if 1998992556 
import java.util.Iterator;
//#endif 


//#if 1283458485 
import org.argouml.model.Model;
//#endif 


//#if -667112040 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -526843065 
import org.argouml.uml.diagram.ui.FigEmptyRect;
//#endif 


//#if 800124873 
import org.argouml.uml.diagram.ui.FigNodeModelElement;
//#endif 


//#if 1239912480 
import org.argouml.uml.diagram.ui.FigStereotypesGroup;
//#endif 


//#if -1344554324 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1839592280 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if -1648168339 
public class FigPool extends 
//#if 1700851293 
FigNodeModelElement
//#endif 

  { 

//#if -450745625 
@Override
    public Dimension getMinimumSize()
    { 

//#if -1651028552 
Dimension nameDim = getNameFig().getMinimumSize();
//#endif 


//#if -708627178 
int w = nameDim.width;
//#endif 


//#if 144647204 
int h = nameDim.height;
//#endif 


//#if 1002691802 
w = Math.max(64, w);
//#endif 


//#if -424466447 
h = Math.max(256, h);
//#endif 


//#if 1208321080 
return new Dimension(w, h);
//#endif 

} 

//#endif 


//#if -1277192846 
@Override
    public boolean getUseTrapRect()
    { 

//#if -1527681831 
return true;
//#endif 

} 

//#endif 


//#if 1278677425 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 

//#if 1743264395 
Rectangle oldBounds = getBounds();
//#endif 


//#if 175313055 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if -1929493800 
firePropChange("bounds", oldBounds, getBounds());
//#endif 


//#if -1932242212 
calcBounds();
//#endif 

} 

//#endif 


//#if -77503074 

//#if -1711782121 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigPool(Rectangle r)
    { 

//#if -571090815 
initialize(r);
//#endif 

} 

//#endif 


//#if 1479899541 
@Override
    public Color getFillColor()
    { 

//#if 581368613 
return getBigPort().getFillColor();
//#endif 

} 

//#endif 


//#if 802973543 
protected FigStereotypesGroup createStereotypeFig()
    { 

//#if 1328037581 
return null;
//#endif 

} 

//#endif 


//#if -394652241 
@Override
    public void setFillColor(Color col)
    { 

//#if -1679609584 
getBigPort().setFillColor(col);
//#endif 


//#if 829196344 
getNameFig().setFillColor(col);
//#endif 

} 

//#endif 


//#if -1773452055 
private void initialize(Rectangle r)
    { 

//#if 1863180517 
setBigPort(new FigEmptyRect(r.x, r.y, r.width, r.height));
//#endif 


//#if 133061537 
getBigPort().setFilled(false);
//#endif 


//#if -1922869414 
getBigPort().setLineWidth(0);
//#endif 


//#if 1395188017 
addFig(getBigPort());
//#endif 


//#if 638996321 
setBounds(r);
//#endif 

} 

//#endif 


//#if -1545755578 
@Override
    public Object clone()
    { 

//#if -833953968 
FigPool figClone = (FigPool) super.clone();
//#endif 


//#if 1709388614 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if -896133215 
figClone.setBigPort((FigRect) it.next());
//#endif 


//#if -970421147 
return figClone;
//#endif 

} 

//#endif 


//#if 1131129210 
@Override
    public void setFilled(boolean f)
    { 

//#if -80647004 
getBigPort().setFilled(f);
//#endif 

} 

//#endif 


//#if 215369020 
@Override
    public boolean isFilled()
    { 

//#if 1318983535 
return getBigPort().isFilled();
//#endif 

} 

//#endif 


//#if 1732788912 
@Override
    public boolean isSelectable()
    { 

//#if 285279966 
return false;
//#endif 

} 

//#endif 


//#if 233521381 
@Override
    public void addEnclosedFig(Fig figState)
    { 

//#if 1061875487 
super.addEnclosedFig(figState);
//#endif 


//#if 474122201 
Iterator it = getLayer().getContentsNoEdges().iterator();
//#endif 


//#if -214113327 
while (it.hasNext()) //1
{ 

//#if 359056517 
Fig f = (Fig) it.next();
//#endif 


//#if 2042385368 
if(f instanceof FigPartition
                    && f.getBounds().intersects(figState.getBounds()))//1
{ 

//#if -1375409439 
Model.getCoreHelper().setModelElementContainer(
                    figState.getOwner(), f.getOwner());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -2047599651 
public FigPool(Object owner, Rectangle bounds, DiagramSettings settings)
    { 

//#if 774664032 
super(null, bounds, settings);
//#endif 


//#if -107565133 
initialize(bounds);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

