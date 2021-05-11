
//#if 590257518 
// Compilation Unit of /FigConcurrentRegion.java 
 

//#if 1124828486 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if 1418526843 
import java.awt.Color;
//#endif 


//#if 450308440 
import java.awt.Dimension;
//#endif 


//#if 436529775 
import java.awt.Rectangle;
//#endif 


//#if 1957615983 
import java.awt.event.MouseEvent;
//#endif 


//#if 1022518969 
import java.awt.event.MouseListener;
//#endif 


//#if -2117777885 
import java.awt.event.MouseMotionListener;
//#endif 


//#if 1829891524 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -677202620 
import java.util.Collection;
//#endif 


//#if 92824372 
import java.util.Iterator;
//#endif 


//#if -523391868 
import java.util.List;
//#endif 


//#if -312548673 
import java.util.Vector;
//#endif 


//#if 880693631 
import javax.swing.JSeparator;
//#endif 


//#if -765613011 
import org.argouml.model.Model;
//#endif 


//#if 342073354 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if 1663714451 
import org.argouml.ui.ProjectActions;
//#endif 


//#if -106011632 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1492289876 
import org.argouml.uml.diagram.ui.ActionAddConcurrentRegion;
//#endif 


//#if -2091226591 
import org.tigris.gef.base.Globals;
//#endif 


//#if 2146752416 
import org.tigris.gef.base.Layer;
//#endif 


//#if -421492795 
import org.tigris.gef.base.Selection;
//#endif 


//#if 548300377 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -389584604 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -133747952 
import org.tigris.gef.presentation.FigLine;
//#endif 


//#if -128336096 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if -126468873 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 440463238 
import org.tigris.gef.presentation.Handle;
//#endif 


//#if -2010406188 
public class FigConcurrentRegion extends 
//#if 399259790 
FigState
//#endif 

 implements 
//#if 1844199288 
MouseListener
//#endif 

, 
//#if 819145294 
MouseMotionListener
//#endif 

  { 

//#if 2044349443 
public static final int INSET_HORZ = 3;
//#endif 


//#if 1298028895 
public static final int INSET_VERT = 5;
//#endif 


//#if -109609814 
private FigRect cover;
//#endif 


//#if -432878044 
private FigLine dividerline;
//#endif 


//#if 654287395 
private static Handle curHandle = new Handle(-1);
//#endif 


//#if -1376196910 
private static final long serialVersionUID = -7228935179004210975L;
//#endif 


//#if 705706500 
@Override
    public Vector getPopUpActions(MouseEvent me)
    { 

//#if -861842788 
Vector popUpActions = super.getPopUpActions(me);
//#endif 


//#if 841852050 
popUpActions.remove(
            ProjectActions.getInstance().getRemoveFromDiagramAction());
//#endif 


//#if -1146166571 
popUpActions.add(new JSeparator());
//#endif 


//#if -1742748892 
popUpActions.addElement(
            new ActionAddConcurrentRegion());
//#endif 


//#if -878988145 
return popUpActions;
//#endif 

} 

//#endif 


//#if 1464188433 
@Override
    public void setLineWidth(int w)
    { 

//#if -1979703514 
dividerline.setLineWidth(w);
//#endif 

} 

//#endif 


//#if 1363801673 
protected int getInitialX()
    { 

//#if -814959441 
return 0;
//#endif 

} 

//#endif 


//#if -1934080555 

//#if -1869145320 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigConcurrentRegion()
    { 

//#if -1185130105 
super();
//#endif 


//#if 1430632258 
initialize();
//#endif 

} 

//#endif 


//#if -1899657032 
@Override
    public int getLineWidth()
    { 

//#if 166942495 
return dividerline.getLineWidth();
//#endif 

} 

//#endif 


//#if 1426154892 
@Override
    public Dimension getMinimumSize()
    { 

//#if 738215436 
Dimension nameDim = getNameFig().getMinimumSize();
//#endif 


//#if -531222976 
Dimension internalDim = getInternal().getMinimumSize();
//#endif 


//#if 1560473978 
int h = nameDim.height + 4 + internalDim.height;
//#endif 


//#if 435927291 
int w = nameDim.width + 2 * MARGIN;
//#endif 


//#if 1813011044 
return new Dimension(w, h);
//#endif 

} 

//#endif 


//#if -2031558181 
public int getInitialHeight()
    { 

//#if 90860171 
return 130;
//#endif 

} 

//#endif 


//#if 1390913641 
@Override
    public Color getLineColor()
    { 

//#if -1371850345 
return dividerline.getLineColor();
//#endif 

} 

//#endif 


//#if 1483969197 
@Deprecated
    public FigConcurrentRegion(GraphModel gm, Object node,
                               Color col, int width, int height)
    { 

//#if 974187884 
this(gm, node);
//#endif 


//#if 1853714067 
setLineColor(col);
//#endif 


//#if -1323139923 
Rectangle r = getBounds();
//#endif 


//#if -618993717 
setBounds(r.x, r.y, width, height);
//#endif 

} 

//#endif 


//#if 1723025759 
@Override
    public void setFilled(boolean f)
    { 

//#if 1640645151 
cover.setFilled(f);
//#endif 


//#if -445479536 
getBigPort().setFilled(f);
//#endif 

} 

//#endif 


//#if -98784335 
public void setBounds(int xInc, int yInc, int w, int hInc,
                          boolean concurrency)
    { 

//#if 473743952 
if(getNameFig() == null)//1
{ 

//#if 366341425 
return;
//#endif 

} 

//#endif 


//#if -349216495 
Rectangle oldBounds = getBounds();
//#endif 


//#if -2129574353 
Dimension nameDim = getNameFig().getMinimumSize();
//#endif 


//#if -1088447414 
int x = oldBounds.x + xInc;
//#endif 


//#if -1044492083 
int y = oldBounds.y + yInc;
//#endif 


//#if 493804521 
int h = oldBounds.height + hInc;
//#endif 


//#if -1808611710 
dividerline.setShape(x, y,
                             x + w, y);
//#endif 


//#if -1387544098 
getNameFig().setBounds(x + 2, y + 2, w - 4, nameDim.height);
//#endif 


//#if 781507963 
getInternal().setBounds(x + 2, y + nameDim.height + 4,
                                w - 4, h - nameDim.height - 8);
//#endif 


//#if -267085095 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if -51888120 
cover.setBounds(x, y, w, h);
//#endif 


//#if -73117982 
calcBounds();
//#endif 


//#if 1371858491 
updateEdges();
//#endif 


//#if 1306770782 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if -945465813 
public void setBounds(int yInc, int hInc)
    { 

//#if 1288743511 
if(getNameFig() == null)//1
{ 

//#if -1488269478 
return;
//#endif 

} 

//#endif 


//#if 964749272 
Rectangle oldBounds = getBounds();
//#endif 


//#if -1415422218 
Dimension nameDim = getNameFig().getMinimumSize();
//#endif 


//#if 1779693154 
int x = oldBounds.x;
//#endif 


//#if 1195359782 
int y = oldBounds.y + yInc;
//#endif 


//#if -184637131 
int w = oldBounds.width;
//#endif 


//#if 2024332848 
int h = oldBounds.height + hInc;
//#endif 


//#if 269621403 
dividerline.setShape(x, y, x + w, y);
//#endif 


//#if -2071650523 
getNameFig().setBounds(x + 2, y + 2, w - 4, nameDim.height);
//#endif 


//#if 1055510850 
getInternal().setBounds(x + 2, y + nameDim.height + 4,
                                w - 4, h - nameDim.height - 8);
//#endif 


//#if 1811148018 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if 763111439 
cover.setBounds(x, y, w, h);
//#endif 


//#if -150550167 
calcBounds();
//#endif 


//#if -1028539244 
updateEdges();
//#endif 


//#if 2020922917 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if -894860281 
private void initialize()
    { 

//#if 1134149847 
cover =
            new FigRect(getInitialX(),
                        getInitialY(),
                        getInitialWidth(), getInitialHeight(),
                        INVISIBLE_LINE_COLOR, FILL_COLOR);
//#endif 


//#if -726296944 
dividerline = new FigLine(getInitialX(),
                                  getInitialY(),
                                  getInitialWidth(),
                                  getInitialY(),
                                  getInitialColor());
//#endif 


//#if -813559182 
dividerline.setDashed(true);
//#endif 


//#if 1171547088 
getBigPort().setLineWidth(0);
//#endif 


//#if -186275 
cover.setLineWidth(0);
//#endif 


//#if 554746791 
addFig(getBigPort());
//#endif 


//#if 1754720640 
addFig(cover);
//#endif 


//#if -274819201 
addFig(getNameFig());
//#endif 


//#if 157706646 
addFig(dividerline);
//#endif 


//#if -133243907 
addFig(getInternal());
//#endif 


//#if 1686760865 
setShadowSize(0);
//#endif 

} 

//#endif 


//#if 1609297515 
@Override
    public Object clone()
    { 

//#if 1917692681 
FigConcurrentRegion figClone = (FigConcurrentRegion) super.clone();
//#endif 


//#if -1383437025 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if -995901784 
figClone.setBigPort((FigRect) it.next());
//#endif 


//#if 451324486 
figClone.cover = (FigRect) it.next();
//#endif 


//#if -1534960743 
figClone.setNameFig((FigText) it.next());
//#endif 


//#if -1074429236 
figClone.dividerline = (FigLine) it.next();
//#endif 


//#if -1112545933 
figClone.setInternal((FigText) it.next());
//#endif 


//#if -537664642 
return figClone;
//#endif 

} 

//#endif 


//#if 830346008 
public void setBounds(int xInc, int yInc, int w, boolean concurrency)
    { 

//#if -557610569 
if(getNameFig() == null)//1
{ 

//#if -2079863004 
return;
//#endif 

} 

//#endif 


//#if 1910947640 
Rectangle oldBounds = getBounds();
//#endif 


//#if 1663923798 
Dimension nameDim = getNameFig().getMinimumSize();
//#endif 


//#if -1412864445 
int x = oldBounds.x + xInc;
//#endif 


//#if -1368909114 
int y = oldBounds.y + yInc;
//#endif 


//#if -453846971 
int h = oldBounds.height;
//#endif 


//#if -463000261 
dividerline.setShape(x, y, x + w, y);
//#endif 


//#if -940210555 
getNameFig().setBounds(x + 2, y + 2, w - 4, nameDim.height);
//#endif 


//#if -1367553886 
getInternal().setBounds(x + 2, y + nameDim.height + 4,
                                w - 4, h - nameDim.height - 8);
//#endif 


//#if 1078526354 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if -1083242641 
cover.setBounds(x, y, w, h);
//#endif 


//#if -238700343 
calcBounds();
//#endif 


//#if 533772596 
updateEdges();
//#endif 


//#if 805301637 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if -1088960825 
@Override
    public Selection makeSelection()
    { 

//#if -1313104261 
Selection sel = new SelectionState(this);
//#endif 


//#if 1645467254 
((SelectionState) sel).setIncomingButtonEnabled(false);
//#endif 


//#if -1214086416 
((SelectionState) sel).setOutgoingButtonEnabled(false);
//#endif 


//#if 2141701560 
return sel;
//#endif 

} 

//#endif 


//#if 1954688938 
@Override
    public void setFillColor(Color col)
    { 

//#if -966173422 
cover.setFillColor(col);
//#endif 

} 

//#endif 


//#if -685296297 
@Override
    public boolean getUseTrapRect()
    { 

//#if -1345182992 
return true;
//#endif 

} 

//#endif 


//#if -1516264388 
@Override
    public void mousePressed(MouseEvent e)
    { 

//#if -1155827453 
int x = e.getX();
//#endif 


//#if 1342218275 
int y = e.getY();
//#endif 


//#if 1011886492 
Globals.curEditor().getSelectionManager().hitHandle(
            new Rectangle(x - 4, y - 4, 8, 8), curHandle);
//#endif 

} 

//#endif 


//#if 1469511680 
public FigConcurrentRegion(Object node, Rectangle bounds, DiagramSettings
                               settings)
    { 

//#if -639608342 
super(node, bounds, settings);
//#endif 


//#if -595076017 
initialize();
//#endif 


//#if 844661680 
if(bounds != null)//1
{ 

//#if -1297532475 
setBounds(bounds.x - _x, bounds.y - _y, bounds.width,
                      bounds.height - _h, true);
//#endif 

} 

//#endif 


//#if -1421223554 
updateNameText();
//#endif 

} 

//#endif 


//#if 1045580497 

//#if -494477286 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigConcurrentRegion(GraphModel gm, Object node)
    { 

//#if 376555533 
this();
//#endif 


//#if -1532166308 
setOwner(node);
//#endif 

} 

//#endif 


//#if -2077568006 
@Override
    public Color getFillColor()
    { 

//#if -360641272 
return cover.getFillColor();
//#endif 

} 

//#endif 


//#if -2060431771 
@Override
    public void setLayer(Layer lay)
    { 

//#if -1860881051 
super.setLayer(lay);
//#endif 


//#if -2104554773 
for (Fig f : lay.getContents()) //1
{ 

//#if -345858687 
if(f instanceof FigCompositeState)//1
{ 

//#if 1262371607 
if(f.getOwner()
                        == Model.getFacade().getContainer(getOwner()))//1
{ 

//#if -1441771885 
setEnclosingFig(f);
//#endif 


//#if -1153885741 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1356734487 
protected int getInitialWidth()
    { 

//#if 1630753811 
return 30;
//#endif 

} 

//#endif 


//#if 1670722325 
protected void modelChanged(PropertyChangeEvent mee)
    { 

//#if -929937868 
if("container".equals(mee.getPropertyName())
                || "isConcurrent".equals(mee.getPropertyName())
                || "subvertex".equals(mee.getPropertyName()))//1
{ 
} 
else
{ 

//#if 1667487315 
super.modelChanged(mee);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1603310699 
public void mouseMoved(MouseEvent e)
    { 
} 

//#endif 


//#if 649655521 
@Override
    public boolean isFilled()
    { 

//#if -1321448412 
return cover.isFilled();
//#endif 

} 

//#endif 


//#if -1126750951 
@Override
    public void setLineColor(Color col)
    { 

//#if -145322752 
cover.setLineColor(INVISIBLE_LINE_COLOR);
//#endif 


//#if 1939445880 
dividerline.setLineColor(col);
//#endif 

} 

//#endif 


//#if 640516438 
public void mouseDragged(MouseEvent e)
    { 

//#if -2094890611 
if(curHandle.index == -1)//1
{ 

//#if 1444271331 
Globals.curEditor().getSelectionManager().select(getEnclosingFig());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 954114343 
@Override
    public void mouseReleased(MouseEvent e)
    { 

//#if -1568571834 
curHandle.index = -1;
//#endif 

} 

//#endif 


//#if -590641194 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 

//#if 1836191895 
if(getNameFig() == null)//1
{ 

//#if -608581330 
return;
//#endif 

} 

//#endif 


//#if -1836278248 
Rectangle oldBounds = getBounds();
//#endif 


//#if 2096731446 
Dimension nameDim = getNameFig().getMinimumSize();
//#endif 


//#if -439986590 
int adjacentindex = -1;
//#endif 


//#if 148881647 
List regionsList = null;
//#endif 


//#if 1053723166 
int index = 0;
//#endif 


//#if 1976166166 
if(getEnclosingFig() != null)//1
{ 

//#if -1702056696 
x = oldBounds.x;
//#endif 


//#if 927964379 
w = oldBounds.width;
//#endif 


//#if -33136401 
FigCompositeState f = ((FigCompositeState) getEnclosingFig());
//#endif 


//#if 649681398 
regionsList = f.getEnclosedFigs();
//#endif 


//#if -29951271 
index = regionsList.indexOf(this);
//#endif 


//#if -1127442714 
if(((curHandle.index == 0) || (curHandle.index == 2))
                    && index > 0)//1
{ 

//#if -943373505 
adjacentindex = index - 1;
//#endif 

} 

//#endif 


//#if 1939959333 
if(((curHandle.index == 5) || (curHandle.index == 7))
                    && (index < (regionsList.size() - 1)))//1
{ 

//#if 1278795945 
adjacentindex = index + 1;
//#endif 

} 

//#endif 


//#if 602025591 
if(h <= getMinimumSize().height)//1
{ 

//#if -1048079285 
if(h <= oldBounds.height)//1
{ 

//#if -2079213576 
h = oldBounds.height;
//#endif 


//#if -399189011 
y = oldBounds.y;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1867161121 
if(adjacentindex == -1)//1
{ 

//#if -2071888155 
x = oldBounds.x;
//#endif 


//#if 1717520547 
y = oldBounds.y;
//#endif 


//#if -769864446 
h = oldBounds.height;
//#endif 


//#if -94307171 
if(w > f.getBounds().width)//1
{ 

//#if 570750259 
Rectangle fR = f.getBounds();
//#endif 


//#if -2009106849 
f.setBounds(fR.x, fR.y, w + 6, fR.height);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -910410474 
int hIncrement = oldBounds.height - h;
//#endif 


//#if 1179488744 
FigConcurrentRegion adjacentFig =
                    ((FigConcurrentRegion)
                     regionsList.get(adjacentindex));
//#endif 


//#if 321147267 
if((adjacentFig.getBounds().height + hIncrement)
                        <= adjacentFig.getMinimumSize().height)//1
{ 

//#if 1772051532 
y = oldBounds.y;
//#endif 


//#if 1666423545 
h = oldBounds.height;
//#endif 

} 
else
{ 

//#if 1813372091 
if((curHandle.index == 0) || (curHandle.index == 2))//1
{ 

//#if -315955038 
((FigConcurrentRegion) regionsList.
                         get(adjacentindex)).setBounds(0, hIncrement);
//#endif 

} 

//#endif 


//#if 682835121 
if((curHandle.index == 5) || (curHandle.index == 7))//1
{ 

//#if 1691684527 
((FigConcurrentRegion) regionsList.
                         get(adjacentindex)).setBounds(-hIncrement,
                                                       hIncrement);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -662885797 
dividerline.setShape(x, y, x + w, y);
//#endif 


//#if -943513119 
getNameFig().setBounds(x + MARGIN,
                               y + SPACE_TOP,
                               w - 2 * MARGIN,
                               nameDim.height);
//#endif 


//#if -1921863651 
getInternal().setBounds(
            x + MARGIN,
            y + nameDim.height + SPACE_TOP + SPACE_MIDDLE,
            w - 2 * MARGIN,
            h - nameDim.height - SPACE_TOP - SPACE_MIDDLE - SPACE_BOTTOM);
//#endif 


//#if 878640818 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if 1310559823 
cover.setBounds(x, y, w, h);
//#endif 


//#if -1545629783 
calcBounds();
//#endif 


//#if -1326334380 
updateEdges();
//#endif 


//#if 1238109285 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if 1363802634 
protected int getInitialY()
    { 

//#if 1638717904 
return 0;
//#endif 

} 

//#endif 


//#if 1283284483 
@Override
    protected void updateLayout(UmlChangeEvent event)
    { 

//#if 640715256 
if(!"container".equals(event.getPropertyName()) &&
                !"isConcurrent".equals(event.getPropertyName()))//1
{ 

//#if 1178816557 
super.updateLayout(event);
//#endif 

} 

//#endif 


//#if 146299951 
final String eName = event.getPropertyName();
//#endif 


//#if 866016464 
if(eName == "incoming" || eName == "outgoing")//1
{ 

//#if -1998147945 
final Object owner = getOwner();
//#endif 


//#if -539824201 
final Collection transactions = (Collection) event.getNewValue();
//#endif 


//#if -1431250558 
if(!transactions.isEmpty())//1
{ 

//#if 1556665111 
final Object transition = transactions.iterator().next();
//#endif 


//#if 886521182 
if(eName == "incoming")//1
{ 

//#if 1752728495 
if(Model.getFacade().isATransition(transition))//1
{ 

//#if -1060802761 
Model.getCommonBehaviorHelper().setTarget(transition,
                                Model.getFacade().getContainer(owner));
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1181351019 
if(Model.getFacade().isATransition(transition))//1
{ 

//#if -237522784 
Model.getStateMachinesHelper().setSource(transition,
                                Model.getFacade().getContainer(owner));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 109075040 
protected Color getInitialColor()
    { 

//#if 1806486762 
return LINE_COLOR;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

