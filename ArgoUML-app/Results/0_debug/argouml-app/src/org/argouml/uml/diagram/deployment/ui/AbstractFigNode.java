
//#if -529975448 
// Compilation Unit of /AbstractFigNode.java 
 

//#if 465182630 
package org.argouml.uml.diagram.deployment.ui;
//#endif 


//#if -960563937 
import java.awt.Color;
//#endif 


//#if -2081018884 
import java.awt.Dimension;
//#endif 


//#if -588475246 
import java.awt.Point;
//#endif 


//#if -2094797549 
import java.awt.Rectangle;
//#endif 


//#if -1454746037 
import java.awt.event.MouseEvent;
//#endif 


//#if -240248216 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -2058077799 
import java.util.ArrayList;
//#endif 


//#if 1963695848 
import java.util.Collection;
//#endif 


//#if 1519368348 
import java.util.HashSet;
//#endif 


//#if 1856464344 
import java.util.Iterator;
//#endif 


//#if 1430596846 
import java.util.Set;
//#endif 


//#if -1050994981 
import org.argouml.model.AssociationChangeEvent;
//#endif 


//#if -1216494922 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if -970280951 
import org.argouml.model.Model;
//#endif 


//#if 51392492 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 2109171747 
import org.argouml.uml.diagram.ui.ArgoFig;
//#endif 


//#if -1233203430 
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
//#endif 


//#if 808052469 
import org.argouml.uml.diagram.ui.FigNodeModelElement;
//#endif 


//#if 504559959 
import org.tigris.gef.base.Geometry;
//#endif 


//#if 897201825 
import org.tigris.gef.base.Selection;
//#endif 


//#if 798477877 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -139407104 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 562542795 
import org.tigris.gef.presentation.FigCube;
//#endif 


//#if 575920380 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if 577787603 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if -2052554937 
public abstract class AbstractFigNode extends 
//#if 1541126088 
FigNodeModelElement
//#endif 

  { 

//#if 156416543 
protected static final int DEPTH = 20;
//#endif 


//#if -451458293 
private FigCube cover;
//#endif 


//#if 2111931712 
private static final int DEFAULT_X = 10;
//#endif 


//#if 2112855233 
private static final int DEFAULT_Y = 10;
//#endif 


//#if -1490797065 
private static final int DEFAULT_WIDTH = 200;
//#endif 


//#if 2040082673 
private static final int DEFAULT_HEIGHT = 180;
//#endif 


//#if 2006802865 
@Override
    public boolean isFilled()
    { 

//#if -1777421489 
return cover.isFilled();
//#endif 

} 

//#endif 


//#if -1142889170 
@Override
    public void mouseClicked(MouseEvent me)
    { 

//#if -1517816671 
super.mouseClicked(me);
//#endif 


//#if -1621654775 
setLineColor(LINE_COLOR);
//#endif 

} 

//#endif 


//#if -1556819135 
@Override
    public void setLineWidth(int w)
    { 

//#if -1402339701 
cover.setLineWidth(w);
//#endif 

} 

//#endif 


//#if 1539349370 

//#if 562277203 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public AbstractFigNode(Object element, int x, int y)
    { 

//#if 2132717274 
super(element, x, y);
//#endif 

} 

//#endif 


//#if -769217333 
@Override
    public Point getClosestPoint(Point anotherPt)
    { 

//#if 870850542 
Rectangle r = getBounds();
//#endif 


//#if 2041422098 
int[] xs = {
            r.x,
            r.x + DEPTH,
            r.x + r.width,
            r.x + r.width,
            r.x + r.width - DEPTH,
            r.x,
            r.x,
        };
//#endif 


//#if -1976986377 
int[] ys = {
            r.y + DEPTH,
            r.y,
            r.y,
            r.y + r.height - DEPTH,
            r.y + r.height,
            r.y + r.height,
            r.y + DEPTH,
        };
//#endif 


//#if 2016355505 
Point p = Geometry.ptClosestTo(xs, ys, 7, anotherPt);
//#endif 


//#if -1746685930 
return p;
//#endif 

} 

//#endif 


//#if -879341577 
@Override
    public Selection makeSelection()
    { 

//#if 1540967669 
return new SelectionNode(this);
//#endif 

} 

//#endif 


//#if -665583012 
@Override
    public Dimension getMinimumSize()
    { 

//#if 159250847 
Dimension stereoDim = getStereotypeFig().getMinimumSize();
//#endif 


//#if -1929342151 
Dimension nameDim = getNameFig().getMinimumSize();
//#endif 


//#if -1482521736 
int w = Math.max(stereoDim.width, nameDim.width + 1) + DEPTH;
//#endif 


//#if 100859077 
int h = stereoDim.height + nameDim.height + DEPTH;
//#endif 


//#if 141934281 
w = Math.max(3 * DEPTH, w);
//#endif 


//#if 647993129 
h = Math.max(3 * DEPTH, h);
//#endif 


//#if 1784290263 
return new Dimension(w, h);
//#endif 

} 

//#endif 


//#if -2058084902 

//#if 970220498 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public AbstractFigNode()
    { 

//#if 1894795777 
super();
//#endif 


//#if -1359871591 
initFigs();
//#endif 

} 

//#endif 


//#if 119423632 
@Override
    protected void updateStereotypeText()
    { 

//#if -1739593830 
getStereotypeFig().setOwner(getOwner());
//#endif 

} 

//#endif 


//#if 93860975 
@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 

//#if -1227293303 
Set<Object[]> l = new HashSet<Object[]>();
//#endif 


//#if -1617812015 
if(newOwner != null)//1
{ 

//#if -217339242 
l.add(new Object[] {newOwner, null});
//#endif 


//#if -1887682620 
Collection c = Model.getFacade().getStereotypes(newOwner);
//#endif 


//#if -688649093 
Iterator i = c.iterator();
//#endif 


//#if -1635629226 
while (i.hasNext()) //1
{ 

//#if -2090960478 
Object st = i.next();
//#endif 


//#if -1679136945 
l.add(new Object[] {st, "name"});
//#endif 

} 

//#endif 

} 

//#endif 


//#if -896385254 
updateElementListeners(l);
//#endif 

} 

//#endif 


//#if -162741202 
public AbstractFigNode(Object owner, Rectangle bounds,
                           DiagramSettings settings)
    { 

//#if 1406433547 
super(owner, bounds, settings);
//#endif 


//#if 1057558176 
initFigs();
//#endif 

} 

//#endif 


//#if 455557947 
@Override
    public Object clone()
    { 

//#if -1074820441 
AbstractFigNode figClone = (AbstractFigNode) super.clone();
//#endif 


//#if -1776851619 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if -1701329238 
figClone.setBigPort((FigRect) it.next());
//#endif 


//#if -762379049 
figClone.cover = (FigCube) it.next();
//#endif 


//#if -1820568902 
it.next();
//#endif 


//#if 2054579099 
figClone.setNameFig((FigText) it.next());
//#endif 


//#if -336614084 
return figClone;
//#endif 

} 

//#endif 


//#if -1388294255 

//#if -1892722327 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public AbstractFigNode(@SuppressWarnings("unused") GraphModel gm,
                           Object node)
    { 

//#if 1658904548 
this();
//#endif 


//#if -1114746829 
setOwner(node);
//#endif 


//#if 1875194966 
if(Model.getFacade().isAClassifier(node)
                && (Model.getFacade().getName(node) != null))//1
{ 

//#if -900727574 
getNameFig().setText(Model.getFacade().getName(node));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1895843816 
@Override
    public void setEnclosingFig(Fig encloser)
    { 

//#if -1985401889 
if(encloser == null
                || (encloser != null
                    && Model.getFacade().isANode(encloser.getOwner())))//1
{ 

//#if 1889682058 
super.setEnclosingFig(encloser);
//#endif 

} 

//#endif 


//#if 1854472938 
if(getLayer() != null)//1
{ 

//#if 1288820936 
Collection contents = getLayer().getContents();
//#endif 


//#if 2101670295 
Collection<FigEdgeModelElement> bringToFrontList =
                new ArrayList<FigEdgeModelElement>();
//#endif 


//#if 1118715100 
for (Object o : contents) //1
{ 

//#if 2102833246 
if(o instanceof FigEdgeModelElement)//1
{ 

//#if 89045875 
bringToFrontList.add((FigEdgeModelElement) o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1187013311 
for (FigEdgeModelElement figEdge : bringToFrontList) //1
{ 

//#if -1797779565 
figEdge.getLayer().bringToFront(figEdge);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1733895633 
@Override
    public void setFilled(boolean f)
    { 

//#if 252824653 
cover.setFilled(f);
//#endif 

} 

//#endif 


//#if -184574810 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 

//#if 551211202 
if(getNameFig() == null)//1
{ 

//#if 178073033 
return;
//#endif 

} 

//#endif 


//#if -1492037117 
Rectangle oldBounds = getBounds();
//#endif 


//#if -1334786009 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if 57529918 
cover.setBounds(x, y + DEPTH, w - DEPTH, h - DEPTH);
//#endif 


//#if -1556475513 
Dimension stereoDim = getStereotypeFig().getMinimumSize();
//#endif 


//#if -609807583 
Dimension nameDim = getNameFig().getMinimumSize();
//#endif 


//#if 836306395 
getNameFig().setBounds(
            x + 4, y + DEPTH + stereoDim.height + 1,
            w - DEPTH - 8, nameDim.height);
//#endif 


//#if 71642938 
getStereotypeFig().setBounds(x + 1, y + DEPTH + 1,
                                     w - DEPTH - 2, stereoDim.height);
//#endif 


//#if 1078686667 
_x = x;
//#endif 


//#if 1078716489 
_y = y;
//#endif 


//#if 1078656845 
_w = w;
//#endif 


//#if 1078209515 
_h = h;
//#endif 


//#if -1468429744 
firePropChange("bounds", oldBounds, getBounds());
//#endif 


//#if -1692439799 
updateEdges();
//#endif 

} 

//#endif 


//#if -765938469 
@Override
    protected void modelChanged(PropertyChangeEvent mee)
    { 

//#if -792025338 
super.modelChanged(mee);
//#endif 


//#if -1589581561 
if(mee instanceof AssociationChangeEvent
                || mee instanceof AttributeChangeEvent)//1
{ 

//#if -1190996633 
renderingChanged();
//#endif 


//#if -1739450879 
updateListeners(getOwner(), getOwner());
//#endif 


//#if 1714008416 
damage();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 152749607 
@Override
    public boolean getUseTrapRect()
    { 

//#if -249292818 
return true;
//#endif 

} 

//#endif 


//#if 145876934 
@Override
    public void setLineColor(Color c)
    { 

//#if 62677156 
cover.setLineColor(c);
//#endif 

} 

//#endif 


//#if 1262350726 
private void initFigs()
    { 

//#if -613268066 
setBigPort(new CubePortFigRect(DEFAULT_X, DEFAULT_Y - DEPTH,
                                       DEFAULT_WIDTH + DEPTH,
                                       DEFAULT_HEIGHT + DEPTH, DEPTH));
//#endif 


//#if 258727954 
getBigPort().setFilled(false);
//#endif 


//#if 1960509641 
getBigPort().setLineWidth(0);
//#endif 


//#if 581269651 
cover = new FigCube(DEFAULT_X, DEFAULT_Y, DEFAULT_WIDTH,
                            DEFAULT_HEIGHT, LINE_COLOR, FILL_COLOR);
//#endif 


//#if -1482685967 
getNameFig().setLineWidth(0);
//#endif 


//#if 893846506 
getNameFig().setFilled(false);
//#endif 


//#if 1242627121 
getNameFig().setJustification(0);
//#endif 


//#if 419195296 
addFig(getBigPort());
//#endif 


//#if 249764263 
addFig(cover);
//#endif 


//#if -1676445199 
addFig(getStereotypeFig());
//#endif 


//#if -410370696 
addFig(getNameFig());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

