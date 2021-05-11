
//#if -1172072915 
// Compilation Unit of /AbstractFigComponent.java 
 

//#if 1174568508 
package org.argouml.uml.diagram.deployment.ui;
//#endif 


//#if 712652213 
import java.awt.Color;
//#endif 


//#if 542323090 
import java.awt.Dimension;
//#endif 


//#if 528544425 
import java.awt.Rectangle;
//#endif 


//#if 980512510 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 1849530110 
import java.util.Collection;
//#endif 


//#if 184839022 
import java.util.Iterator;
//#endif 


//#if 2064001009 
import org.argouml.model.AssociationChangeEvent;
//#endif 


//#if -507109044 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if -467683277 
import org.argouml.model.Model;
//#endif 


//#if 567518230 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -1823649909 
import org.argouml.uml.diagram.ui.FigNodeModelElement;
//#endif 


//#if -12645281 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 846983718 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if 848850941 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if -1351363090 
public abstract class AbstractFigComponent extends 
//#if -401979721 
FigNodeModelElement
//#endif 

  { 

//#if -851801123 
private static final int BX = 10;
//#endif 


//#if 130040477 
private static final int FINGER_HEIGHT = BX;
//#endif 


//#if -1258439432 
private static final int FINGER_WIDTH = BX * 2;
//#endif 


//#if -749615255 
private static final int OVERLAP = 0;
//#endif 


//#if -347303287 
private static final int DEFAULT_WIDTH = 120;
//#endif 


//#if -1561609389 
private static final int DEFAULT_HEIGHT = 80;
//#endif 


//#if 1814032491 
private FigRect cover;
//#endif 


//#if -735665956 
private FigRect upperRect;
//#endif 


//#if -2139786787 
private FigRect lowerRect;
//#endif 


//#if 1289398581 
@Override
    public void setLineColor(Color c)
    { 

//#if 191330181 
cover.setLineColor(c);
//#endif 


//#if -1391154348 
getStereotypeFig().setFilled(false);
//#endif 


//#if 1630192967 
getStereotypeFig().setLineWidth(0);
//#endif 


//#if 1903988315 
getNameFig().setFilled(false);
//#endif 


//#if -2142837408 
getNameFig().setLineWidth(0);
//#endif 


//#if 14755702 
upperRect.setLineColor(c);
//#endif 


//#if 1343739511 
lowerRect.setLineColor(c);
//#endif 

} 

//#endif 


//#if -2027119912 
@Override
    public boolean getUseTrapRect()
    { 

//#if -987726337 
return true;
//#endif 

} 

//#endif 


//#if 423849677 
@Override
    public Dimension getMinimumSize()
    { 

//#if 1193809363 
Dimension stereoDim = getStereotypeFig().getMinimumSize();
//#endif 


//#if 827597677 
Dimension nameDim = getNameFig().getMinimumSize();
//#endif 


//#if 1590017071 
int h = Math.max(stereoDim.height + nameDim.height - OVERLAP,
                         4 * FINGER_HEIGHT);
//#endif 


//#if -2008079651 
int w = Math.max(stereoDim.width, nameDim.width) + FINGER_WIDTH;
//#endif 


//#if -758139357 
return new Dimension(w, h);
//#endif 

} 

//#endif 


//#if -1968079520 
@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 

//#if -1427981254 
super.updateListeners(oldOwner, newOwner);
//#endif 


//#if -622967933 
if(newOwner != null)//1
{ 

//#if 921107118 
Collection c = Model.getFacade().getStereotypes(newOwner);
//#endif 


//#if 53800805 
Iterator i = c.iterator();
//#endif 


//#if 210951360 
while (i.hasNext()) //1
{ 

//#if 509204191 
Object st = i.next();
//#endif 


//#if 869116595 
addElementListener(st, "name");
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1383871286 

//#if 1321431344 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public AbstractFigComponent()
    { 

//#if -1155353462 
super();
//#endif 


//#if 267230832 
initFigs();
//#endif 

} 

//#endif 


//#if -2046525259 
private void initFigs()
    { 

//#if -937346827 
cover = new FigRect(BX, 10, DEFAULT_WIDTH, DEFAULT_HEIGHT, LINE_COLOR,
                            FILL_COLOR);
//#endif 


//#if -1399984248 
upperRect = new FigRect(0, 2 * FINGER_HEIGHT,
                                FINGER_WIDTH, FINGER_HEIGHT,
                                LINE_COLOR, FILL_COLOR);
//#endif 


//#if 1563229380 
lowerRect = new FigRect(0, 5 * FINGER_HEIGHT,
                                FINGER_WIDTH, FINGER_HEIGHT,
                                LINE_COLOR, FILL_COLOR);
//#endif 


//#if -1826489074 
getNameFig().setLineWidth(0);
//#endif 


//#if -1174115219 
getNameFig().setFilled(false);
//#endif 


//#if -784303602 
getNameFig().setText(placeString());
//#endif 


//#if 614846909 
addFig(getBigPort());
//#endif 


//#if 1947199530 
addFig(cover);
//#endif 


//#if 186882126 
addFig(getStereotypeFig());
//#endif 


//#if -214719083 
addFig(getNameFig());
//#endif 


//#if -681283111 
addFig(upperRect);
//#endif 


//#if -1259355912 
addFig(lowerRect);
//#endif 

} 

//#endif 


//#if -1997867349 
@Override
    public void setHandleBox(int x, int y, int w, int h)
    { 

//#if 223898898 
setBounds(x - BX, y, w + BX, h);
//#endif 

} 

//#endif 


//#if 2139448983 
@Override
    protected void setStandardBounds(int x, int y, int w,
                                     int h)
    { 

//#if -153834617 
if(getNameFig() == null)//1
{ 

//#if -1775676135 
return;
//#endif 

} 

//#endif 


//#if 569066760 
Rectangle oldBounds = getBounds();
//#endif 


//#if 586490996 
getBigPort().setBounds(x + BX, y, w - BX, h);
//#endif 


//#if -1597454799 
cover.setBounds(x + BX, y, w - BX, h);
//#endif 


//#if -786659956 
Dimension stereoDim = getStereotypeFig().getMinimumSize();
//#endif 


//#if 1435261990 
Dimension nameDim = getNameFig().getMinimumSize();
//#endif 


//#if -1598190074 
int halfHeight = FINGER_HEIGHT / 2;
//#endif 


//#if -1006997202 
upperRect.setBounds(x, y + h / 3 - halfHeight, FINGER_WIDTH,
                            FINGER_HEIGHT);
//#endif 


//#if 1305784277 
lowerRect.setBounds(x, y + 2 * h / 3 - halfHeight, FINGER_WIDTH,
                            FINGER_HEIGHT);
//#endif 


//#if -147451501 
getStereotypeFig().setBounds(x + FINGER_WIDTH + 1,
                                     y + 1,
                                     w - FINGER_WIDTH - 2,
                                     stereoDim.height);
//#endif 


//#if 143703285 
getNameFig().setBounds(x + FINGER_WIDTH + 1,
                               y + stereoDim.height - OVERLAP + 1,
                               w - FINGER_WIDTH - 2,
                               nameDim.height);
//#endif 


//#if 1954063120 
_x = x;
//#endif 


//#if 1954092942 
_y = y;
//#endif 


//#if 1954033298 
_w = w;
//#endif 


//#if 1953585968 
_h = h;
//#endif 


//#if 576639829 
firePropChange("bounds", oldBounds, getBounds());
//#endif 


//#if 488806756 
updateEdges();
//#endif 

} 

//#endif 


//#if 805900588 
@Override
    public Object clone()
    { 

//#if 1900575109 
AbstractFigComponent figClone = (AbstractFigComponent) super.clone();
//#endif 


//#if -1218821959 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if 1780355022 
figClone.setBigPort((FigRect) it.next());
//#endif 


//#if -1171894292 
figClone.cover = (FigRect) it.next();
//#endif 


//#if 2025747166 
it.next();
//#endif 


//#if 1241296063 
figClone.setNameFig((FigText) it.next());
//#endif 


//#if 458332635 
figClone.upperRect = (FigRect) it.next();
//#endif 


//#if 1206452026 
figClone.lowerRect = (FigRect) it.next();
//#endif 


//#if -663747688 
return figClone;
//#endif 

} 

//#endif 


//#if -17152244 
@Override
    protected void modelChanged(PropertyChangeEvent mee)
    { 

//#if 15738822 
super.modelChanged(mee);
//#endif 


//#if 304767047 
if(mee instanceof AssociationChangeEvent
                || mee instanceof AttributeChangeEvent)//1
{ 

//#if 480315407 
renderingChanged();
//#endif 


//#if 625239209 
updateListeners(getOwner(), getOwner());
//#endif 


//#if 1522505224 
damage();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1881680403 

//#if 273833483 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public AbstractFigComponent(@SuppressWarnings("unused") GraphModel gm,
                                Object node)
    { 

//#if 21932960 
this();
//#endif 


//#if -985489425 
setOwner(node);
//#endif 

} 

//#endif 


//#if 1939780266 
@Override
    public Rectangle getHandleBox()
    { 

//#if -1550882818 
Rectangle r = getBounds();
//#endif 


//#if 1959916176 
return new Rectangle(r.x + BX, r.y, r.width - BX, r.height);
//#endif 

} 

//#endif 


//#if -116913646 
public AbstractFigComponent(Object owner, Rectangle bounds,
                                DiagramSettings settings)
    { 

//#if -268283314 
super(owner, bounds, settings);
//#endif 


//#if 1815921315 
initFigs();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

