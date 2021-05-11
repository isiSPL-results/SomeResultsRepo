
//#if -244096113 
// Compilation Unit of /FigSimpleState.java 
 

//#if 1421168061 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if 1947653476 
import java.awt.Color;
//#endif 


//#if 103440833 
import java.awt.Dimension;
//#endif 


//#if 89662168 
import java.awt.Rectangle;
//#endif 


//#if -254043235 
import java.util.Iterator;
//#endif 


//#if -572016825 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -1672617840 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 1180742087 
import org.tigris.gef.presentation.FigLine;
//#endif 


//#if -1901435259 
import org.tigris.gef.presentation.FigRRect;
//#endif 


//#if 1186153943 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if 1188021166 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if -751705729 
public class FigSimpleState extends 
//#if 613892885 
FigState
//#endif 

  { 

//#if 320599217 
private FigRect cover;
//#endif 


//#if -617723809 
private FigLine divider;
//#endif 


//#if 1072206867 
@Override
    public Dimension getMinimumSize()
    { 

//#if 1670585785 
Dimension nameDim = getNameFig().getMinimumSize();
//#endif 


//#if -1658316109 
Dimension internalDim = getInternal().getMinimumSize();
//#endif 


//#if 56234767 
int h = SPACE_TOP + nameDim.height
                + SPACE_MIDDLE + internalDim.height
                + SPACE_BOTTOM;
//#endif 


//#if -1674597097 
int w = Math.max(nameDim.width + 2 * MARGIN,
                         internalDim.width + 2 * MARGIN);
//#endif 


//#if -1640930985 
return new Dimension(w, h);
//#endif 

} 

//#endif 


//#if -65178390 
@Override
    public void setLineWidth(int w)
    { 

//#if -1705218959 
cover.setLineWidth(w);
//#endif 


//#if -1691965681 
divider.setLineWidth(w);
//#endif 

} 

//#endif 


//#if -1450127098 
@Override
    protected int getInitialX()
    { 

//#if 1234365612 
return 0;
//#endif 

} 

//#endif 


//#if -427765245 
@Override
    public void setFillColor(Color col)
    { 

//#if -74815752 
cover.setFillColor(col);
//#endif 

} 

//#endif 


//#if 785762162 
@Override
    public void setLineColor(Color col)
    { 

//#if -173456292 
cover.setLineColor(col);
//#endif 


//#if -904621510 
divider.setLineColor(col);
//#endif 

} 

//#endif 


//#if 1557294502 
@Override
    public void setFilled(boolean f)
    { 

//#if 1787274482 
cover.setFilled(f);
//#endif 


//#if -807739555 
getBigPort().setFilled(f);
//#endif 

} 

//#endif 


//#if -402623348 
public FigSimpleState(Object owner, Rectangle bounds,
                          DiagramSettings settings)
    { 

//#if 847211301 
super(owner, bounds, settings);
//#endif 


//#if -1673548628 
initializeSimpleState();
//#endif 

} 

//#endif 


//#if 518514928 

//#if -1467165128 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigSimpleState()
    { 

//#if -2028486026 
initializeSimpleState();
//#endif 

} 

//#endif 


//#if -620848536 
@Override
    public boolean isFilled()
    { 

//#if 1258647565 
return cover.isFilled();
//#endif 

} 

//#endif 


//#if 1729164321 
private void initializeSimpleState()
    { 

//#if -1320170460 
cover =
            new FigRRect(getInitialX(), getInitialY(),
                         getInitialWidth(), getInitialHeight(),
                         LINE_COLOR, FILL_COLOR);
//#endif 


//#if 628451151 
getBigPort().setLineWidth(0);
//#endif 


//#if 2142755967 
divider =
            new FigLine(getInitialX(),
                        getInitialY() + 2 + getNameFig().getBounds().height + 1,
                        getInitialWidth() - 1,
                        getInitialY() + 2 + getNameFig().getBounds().height + 1,
                        LINE_COLOR);
//#endif 


//#if -254757338 
addFig(getBigPort());
//#endif 


//#if -418039839 
addFig(cover);
//#endif 


//#if -1084323330 
addFig(getNameFig());
//#endif 


//#if -1580312381 
addFig(divider);
//#endif 


//#if 541931870 
addFig(getInternal());
//#endif 


//#if 282192332 
Rectangle r = getBounds();
//#endif 


//#if -512993916 
setBounds(r.x, r.y, r.width, r.height);
//#endif 

} 

//#endif 


//#if 983558439 

//#if 674378987 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigSimpleState(@SuppressWarnings("unused") GraphModel gm,
                          Object node)
    { 

//#if -1400610718 
this();
//#endif 


//#if -446664015 
setOwner(node);
//#endif 

} 

//#endif 


//#if 1033712577 
@Override
    public Color getFillColor()
    { 

//#if -1441610592 
return cover.getFillColor();
//#endif 

} 

//#endif 


//#if -1450126137 
@Override
    protected int getInitialY()
    { 

//#if -161707919 
return 0;
//#endif 

} 

//#endif 


//#if -1216909454 
@Override
    public Object clone()
    { 

//#if 1907216031 
FigSimpleState figClone = (FigSimpleState) super.clone();
//#endif 


//#if 416862355 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if 1061197734 
figClone.setBigPort((FigRRect) it.next());
//#endif 


//#if 737575250 
figClone.cover = (FigRect) it.next();
//#endif 


//#if 1155512741 
figClone.setNameFig((FigText) it.next());
//#endif 


//#if 587891940 
figClone.divider = (FigLine) it.next();
//#endif 


//#if 687753447 
figClone.setInternal((FigText) it.next());
//#endif 


//#if 1315811314 
return figClone;
//#endif 

} 

//#endif 


//#if 1124806207 
@Override
    public int getLineWidth()
    { 

//#if -1250137769 
return cover.getLineWidth();
//#endif 

} 

//#endif 


//#if 207226928 
@Override
    public Color getLineColor()
    { 

//#if 1279773514 
return cover.getLineColor();
//#endif 

} 

//#endif 


//#if 546264148 
@Override
    protected int getInitialWidth()
    { 

//#if 1170910609 
return 70;
//#endif 

} 

//#endif 


//#if 1861823709 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 

//#if 745922202 
if(getNameFig() == null)//1
{ 

//#if -809010680 
return;
//#endif 

} 

//#endif 


//#if -1515151909 
Rectangle oldBounds = getBounds();
//#endif 


//#if -1885098247 
Dimension nameDim = getNameFig().getMinimumSize();
//#endif 


//#if 1690100388 
getNameFig().setBounds(x + MARGIN,
                               y + SPACE_TOP,
                               w - 2 * MARGIN,
                               nameDim.height);
//#endif 


//#if 64303934 
divider.setShape(x,
                         y + DIVIDER_Y + nameDim.height,
                         x + w - 1,
                         y + DIVIDER_Y + nameDim.height);
//#endif 


//#if -945902594 
getInternal().setBounds(
            x + MARGIN,
            y + SPACE_TOP + nameDim.height + SPACE_MIDDLE,
            w - 2 * MARGIN,
            h - SPACE_TOP - nameDim.height - SPACE_MIDDLE - SPACE_BOTTOM);
//#endif 


//#if -2051344561 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if 220290130 
cover.setBounds(x, y, w, h);
//#endif 


//#if -1044510164 
calcBounds();
//#endif 


//#if 1323471921 
updateEdges();
//#endif 


//#if 1551246888 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if 258133755 
@Override
    protected int getInitialHeight()
    { 

//#if -401682834 
return 40;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

