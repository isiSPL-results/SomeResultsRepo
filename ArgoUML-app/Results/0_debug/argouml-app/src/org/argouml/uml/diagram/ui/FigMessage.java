
//#if 2105332101 
// Compilation Unit of /FigMessage.java 
 

//#if -1982843341 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 1617200491 
import java.awt.Color;
//#endif 


//#if -1266502072 
import java.awt.Dimension;
//#endif 


//#if 542169524 
import java.awt.Polygon;
//#endif 


//#if -1280280737 
import java.awt.Rectangle;
//#endif 


//#if 547459764 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -1623986140 
import java.util.Iterator;
//#endif 


//#if 1634266031 
import java.util.Vector;
//#endif 


//#if 194295101 
import org.argouml.model.Model;
//#endif 


//#if -1541576966 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if -397325024 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1621952146 
import org.argouml.uml.diagram.collaboration.ui.FigAssociationRole;
//#endif 


//#if 1200479408 
import org.tigris.gef.base.Layer;
//#endif 


//#if -552378519 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -1490263500 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1704710328 
import org.tigris.gef.presentation.FigPoly;
//#endif 


//#if -1701302777 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 1863413646 
public class FigMessage extends 
//#if -1461578573 
FigNodeModelElement
//#endif 

  { 

//#if -391193379 
private static Vector<String> arrowDirections;
//#endif 


//#if 1514464766 
private FigPoly figPoly;
//#endif 


//#if 837479711 
private static final int SOUTH = 0;
//#endif 


//#if -608536922 
private static final int EAST = 1;
//#endif 


//#if -1698823213 
private static final int WEST = 2;
//#endif 


//#if 627475268 
private static final int NORTH = 3;
//#endif 


//#if 1455992834 
private int arrowDirection = -1;
//#endif 


//#if 258251430 
@Override
    public boolean isFilled()
    { 

//#if -165875569 
return true;
//#endif 

} 

//#endif 


//#if 2003906173 
@Override
    public int getLineWidth()
    { 

//#if -1916046507 
return figPoly.getLineWidth();
//#endif 

} 

//#endif 


//#if 1856255877 
@Override
    public void setFillColor(Color col)
    { 

//#if 2007105555 
getNameFig().setFillColor(col);
//#endif 

} 

//#endif 


//#if -1763609007 
@Override
    public Dimension getMinimumSize()
    { 

//#if -1256122581 
Dimension nameMin = getNameFig().getMinimumSize();
//#endif 


//#if -1178279810 
Dimension figPolyMin = figPoly.getSize();
//#endif 


//#if 1890189223 
int h = Math.max(figPolyMin.height, nameMin.height);
//#endif 


//#if 477246112 
int w = figPolyMin.width + nameMin.width;
//#endif 


//#if -1819285413 
return new Dimension(w, h);
//#endif 

} 

//#endif 


//#if -1346862053 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 

//#if -1917129826 
if(getNameFig() == null)//1
{ 

//#if 219343769 
return;
//#endif 

} 

//#endif 


//#if -1009723425 
Rectangle oldBounds = getBounds();
//#endif 


//#if -620395021 
Dimension nameMin = getNameFig().getMinimumSize();
//#endif 


//#if -705942419 
int ht = 0;
//#endif 


//#if 1571795843 
if(nameMin.height > figPoly.getHeight())//1
{ 

//#if 1423724822 
ht = (nameMin.height - figPoly.getHeight()) / 2;
//#endif 

} 

//#endif 


//#if -1536355451 
getNameFig().setBounds(x, y, w - figPoly.getWidth(), nameMin.height);
//#endif 


//#if 1278797229 
getBigPort().setBounds(x, y, w - figPoly.getWidth(), nameMin.height);
//#endif 


//#if -410416624 
figPoly.setBounds(x + getNameFig().getWidth(), y + ht,
                          figPoly.getWidth(), figPoly.getHeight());
//#endif 


//#if -108406740 
firePropChange("bounds", oldBounds, getBounds());
//#endif 


//#if 1485536560 
calcBounds();
//#endif 


//#if -1849458259 
updateEdges();
//#endif 

} 

//#endif 


//#if 852765036 
@Override
    public void renderingChanged()
    { 

//#if 1895915975 
super.renderingChanged();
//#endif 


//#if 704109234 
updateArrow();
//#endif 

} 

//#endif 


//#if 1168045456 
@Override
    protected void modelChanged(PropertyChangeEvent mee)
    { 

//#if -536325161 
super.modelChanged(mee);
//#endif 


//#if 1398122911 
if(true)//1
{ 

//#if 209393606 
return;
//#endif 

} 

//#endif 


//#if -147762490 
if(Model.getFacade().isAMessage(getOwner()))//1
{ 

//#if 2025865668 
if(Model.getFacade().isAParameter(mee.getSource()))//1
{ 

//#if 145138839 
Object par = mee.getSource();
//#endif 


//#if -1399551255 
updateArgumentsFromParameter(getOwner(), par);
//#endif 

} 

//#endif 


//#if -569831545 
if(mee == null || mee.getSource() == getOwner()
                    || Model.getFacade().isAAction(mee.getSource())
                    || Model.getFacade().isAOperation(mee.getSource())
                    || Model.getFacade().isAArgument(mee.getSource())
                    || Model.getFacade().isASignal(mee.getSource()))//1
{ 

//#if -292950821 
updateListeners(getOwner());
//#endif 

} 

//#endif 


//#if -1729867979 
updateArrow();
//#endif 


//#if 1421157392 
damage();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1192018256 
@Override
    public Object clone()
    { 

//#if 1501897406 
FigMessage figClone = (FigMessage) super.clone();
//#endif 


//#if 1126146498 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if 485656214 
figClone.setNameFig((FigText) it.next());
//#endif 


//#if 1916650708 
figClone.figPoly = (FigPoly) it.next();
//#endif 


//#if -647750175 
return figClone;
//#endif 

} 

//#endif 


//#if 1331268537 
public static Vector<String> getArrowDirections()
    { 

//#if -1257522724 
return arrowDirections;
//#endif 

} 

//#endif 


//#if 197187300 
@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 

//#if 1584830006 
if(oldOwner != null)//1
{ 

//#if 844337128 
removeElementListener(oldOwner);
//#endif 

} 

//#endif 


//#if 588454301 
if(newOwner != null)//1
{ 

//#if -6782712 
addElementListener(newOwner, "remove");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -525079962 

//#if -948903933 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigMessage(@SuppressWarnings("unused") GraphModel gm, Layer lay,
                      Object node)
    { 

//#if -2095107619 
this();
//#endif 


//#if -386550660 
setLayer(lay);
//#endif 


//#if -1652844244 
setOwner(node);
//#endif 

} 

//#endif 


//#if -766262964 
private void initArrows()
    { 

//#if 2060493030 
if(arrowDirections == null)//1
{ 

//#if -1877960721 
arrowDirections = new Vector<String>(4);
//#endif 


//#if 10390095 
arrowDirections.add(SOUTH, "South");
//#endif 


//#if -1033299799 
arrowDirections.add(EAST, "East");
//#endif 


//#if 1701425221 
arrowDirections.add(WEST, "West");
//#endif 


//#if 1732770127 
arrowDirections.add(NORTH, "North");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 569130590 
public void updateArrow()
    { 

//#if 637555352 
Object mes = getOwner();
//#endif 


//#if 19192486 
if(mes == null || getLayer() == null)//1
{ 

//#if -924602078 
return;
//#endif 

} 

//#endif 


//#if 982035433 
Object sender = Model.getFacade().getSender(mes);
//#endif 


//#if -531163555 
Object receiver = Model.getFacade().getReceiver(mes);
//#endif 


//#if 1946504235 
Fig senderPort = getLayer().presentationFor(sender);
//#endif 


//#if 723323807 
Fig receiverPort = getLayer().presentationFor(receiver);
//#endif 


//#if 1118956547 
if(senderPort == null || receiverPort == null)//1
{ 

//#if 378396332 
return;
//#endif 

} 

//#endif 


//#if 1643905933 
int sx = senderPort.getX();
//#endif 


//#if 1235111499 
int sy = senderPort.getY();
//#endif 


//#if 1448637382 
int rx = receiverPort.getX();
//#endif 


//#if -589389116 
int ry = receiverPort.getY();
//#endif 


//#if -912294403 
if(sx < rx && Math.abs(sy - ry) <= Math.abs(sx - rx))//1
{ 

//#if 1626478868 
setArrow(EAST);
//#endif 

} 
else

//#if -735342542 
if(sx > rx && Math.abs(sy - ry) <= Math.abs(sx - rx))//1
{ 

//#if 1024248505 
setArrow(WEST);
//#endif 

} 
else

//#if 1222561160 
if(sy < ry)//1
{ 

//#if 1696559368 
setArrow(SOUTH);
//#endif 

} 
else
{ 

//#if 742166971 
setArrow(NORTH);
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if 890616191 
protected void updateArgumentsFromParameter(Object newOwner,
            Object parameter)
    { 

//#if 1195101805 
if(true)//1
{ 

//#if 269856666 
return;
//#endif 

} 

//#endif 


//#if -832779627 
if(newOwner != null)//1
{ 

//#if -693627423 
Object act = Model.getFacade().getAction(newOwner);
//#endif 


//#if 1379113845 
if(Model.getFacade().isACallAction(act))//1
{ 

//#if -1652938270 
if(Model.getFacade().getOperation(act) != null)//1
{ 

//#if -157781101 
Object operation = Model.getFacade().getOperation(act);
//#endif 


//#if 1595011320 
if(Model.getDirectionKind().getInParameter().equals(
                                Model.getFacade().getKind(parameter)))//1
{ 

//#if -364304657 
Object newArgument = Model.getCommonBehaviorFactory()
                                             .createArgument();
//#endif 


//#if -1709868030 
Model.getCommonBehaviorHelper().setValue(
                            newArgument,
                            Model.getDataTypesFactory().createExpression(
                                "",
                                Model.getFacade().getName(parameter)));
//#endif 


//#if -444686668 
Model.getCoreHelper().setName(newArgument,
                                                      Model.getFacade().getName(parameter));
//#endif 


//#if 1297721320 
Model.getCommonBehaviorHelper().addActualArgument(act,
                                newArgument);
//#endif 


//#if 2083721080 
Model.getPump().removeModelEventListener(this,
                                parameter);
//#endif 


//#if -1313163869 
Model.getPump().addModelEventListener(this, parameter);
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


//#if -1869972439 
protected void updateListeners(Object newOwner)
    { 

//#if -1024494784 
if(true)//1
{ 

//#if -394466869 
return;
//#endif 

} 

//#endif 


//#if -1051540568 
if(newOwner != null)//1
{ 

//#if -1614838217 
Object act = Model.getFacade().getAction(newOwner);
//#endif 


//#if 2084083356 
if(act != null)//1
{ 

//#if 395871897 
Model.getPump().removeModelEventListener(this, act);
//#endif 


//#if 1113974420 
Model.getPump().addModelEventListener(this, act);
//#endif 


//#if 844169498 
Iterator iter = Model.getFacade().getActualArguments(act)
                                .iterator();
//#endif 


//#if 649972479 
while (iter.hasNext()) //1
{ 

//#if -1991101062 
Object arg = iter.next();
//#endif 


//#if 1002578690 
Model.getPump().removeModelEventListener(this, arg);
//#endif 


//#if 1655354835 
Model.getPump().addModelEventListener(this, arg);
//#endif 

} 

//#endif 


//#if 380504353 
if(Model.getFacade().isACallAction(act))//1
{ 

//#if -632248675 
Object oper = Model.getFacade().getOperation(act);
//#endif 


//#if -2126870686 
if(oper != null)//1
{ 

//#if 331426293 
Model.getPump().removeModelEventListener(this, oper);
//#endif 


//#if 524218438 
Model.getPump().addModelEventListener(this, oper);
//#endif 


//#if -1390760167 
Iterator it2 = Model.getFacade().getParameters(oper)
                                       .iterator();
//#endif 


//#if 2143707270 
while (it2.hasNext()) //1
{ 

//#if -59037557 
Object param = it2.next();
//#endif 


//#if -1375075466 
Model.getPump().removeModelEventListener(this,
                                    param);
//#endif 


//#if 1756883501 
Model.getPump().addModelEventListener(this, param);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1738507593 
if(Model.getFacade().isASendAction(act))//1
{ 

//#if -593996700 
Object sig = Model.getFacade().getSignal(act);
//#endif 


//#if -2037675782 
if(sig != null)//1
{ 

//#if -1637864152 
Model.getPump().removeModelEventListener(this, sig);
//#endif 

} 

//#endif 


//#if -1984512396 
Model.getPump().addModelEventListener(this, sig);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1880963572 
public int getArrow()
    { 

//#if 1191548115 
return arrowDirection;
//#endif 

} 

//#endif 


//#if -1225184012 
@Override
    public void setLineColor(Color col)
    { 

//#if -583275454 
figPoly.setLineColor(col);
//#endif 


//#if -2053273612 
getNameFig().setLineColor(col);
//#endif 

} 

//#endif 


//#if -477754019 
@Override
    protected int getNotationProviderType()
    { 

//#if -156286810 
return NotationProviderFactory2.TYPE_MESSAGE;
//#endif 

} 

//#endif 


//#if -1445293326 
public void addPathItemToFigAssociationRole(Layer lay)
    { 

//#if 855578094 
Object associationRole =
            Model.getFacade().getCommunicationConnection(getOwner());
//#endif 


//#if -1823639493 
if(associationRole != null && lay != null)//1
{ 

//#if 697790929 
FigAssociationRole figAssocRole =
                (FigAssociationRole) lay.presentationFor(associationRole);
//#endif 


//#if 902055873 
if(figAssocRole != null)//1
{ 

//#if -2044005387 
figAssocRole.addMessage(this);
//#endif 


//#if 1084171368 
lay.bringToFront(this);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -59062428 
@Override
    public void setFilled(boolean f)
    { 
} 

//#endif 


//#if -1086263058 
@Override
    public Color getLineColor()
    { 

//#if -2049867261 
return figPoly.getLineColor();
//#endif 

} 

//#endif 


//#if 791669638 
public FigMessage(Object owner, Rectangle bounds,
                      DiagramSettings settings)
    { 

//#if 1496243609 
super(owner, bounds, settings);
//#endif 


//#if -675193997 
initArrows();
//#endif 


//#if 1031609006 
initFigs();
//#endif 


//#if -88329972 
updateNameText();
//#endif 

} 

//#endif 


//#if -1971120774 

//#if 1200155689 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigMessage()
    { 

//#if -1326338530 
super();
//#endif 


//#if 282283100 
initFigs();
//#endif 


//#if 777116065 
initArrows();
//#endif 


//#if 518107242 
Rectangle r = getBounds();
//#endif 


//#if 1418772390 
setBounds(r.x, r.y, r.width, r.height);
//#endif 

} 

//#endif 


//#if 1881194417 
private void initFigs()
    { 

//#if -1254274661 
setShadowSize(0);
//#endif 


//#if -737109518 
getNameFig().setLineWidth(0);
//#endif 


//#if -735261375 
getNameFig().setReturnAction(FigText.END_EDITING);
//#endif 


//#if -1763087351 
getNameFig().setFilled(false);
//#endif 


//#if 1281317265 
Dimension nameMin = getNameFig().getMinimumSize();
//#endif 


//#if -568360709 
getNameFig().setBounds(X0, Y0, 90, nameMin.height);
//#endif 


//#if -2048613597 
getBigPort().setBounds(X0, Y0, 90, nameMin.height);
//#endif 


//#if -1480647144 
figPoly = new FigPoly(LINE_COLOR, SOLID_FILL_COLOR);
//#endif 


//#if -1937960352 
int[] xpoints = {75, 75, 77, 75, 73, 75};
//#endif 


//#if 2074263107 
int[] ypoints = {33, 24, 24, 15, 24, 24};
//#endif 


//#if 1824690324 
Polygon polygon = new Polygon(xpoints, ypoints, 6);
//#endif 


//#if 2137407516 
figPoly.setPolygon(polygon);
//#endif 


//#if -459624879 
figPoly.setBounds(100, 10, 5, 18);
//#endif 


//#if 1896761393 
getBigPort().setFilled(false);
//#endif 


//#if -1588881206 
getBigPort().setLineWidth(0);
//#endif 


//#if -262040927 
addFig(getBigPort());
//#endif 


//#if -1091606919 
addFig(getNameFig());
//#endif 


//#if -1736514433 
addFig(figPoly);
//#endif 

} 

//#endif 


//#if -259777409 
@Override
    public Color getFillColor()
    { 

//#if 1664909488 
return getNameFig().getFillColor();
//#endif 

} 

//#endif 


//#if 21228396 
@Override
    public void setLineWidth(int w)
    { 

//#if 695383787 
figPoly.setLineWidth(w);
//#endif 

} 

//#endif 


//#if -986364133 
public void setArrow(int direction)
    { 

//#if -836700955 
Rectangle bbox = getBounds();
//#endif 


//#if 145643895 
if(arrowDirection == direction)//1
{ 

//#if 2061008385 
return;
//#endif 

} 

//#endif 


//#if 1741754354 
arrowDirection = direction;
//#endif 


//#if -1376725686 
switch (direction) //1
{ 
case SOUTH://1

{ 

//#if -226014946 
int[] xpoints = {75, 75, 77, 75, 73, 75};
//#endif 


//#if -1887045127 
int[] ypoints = {15, 24, 24, 33, 24, 24};
//#endif 


//#if -1133864366 
Polygon polygon = new Polygon(xpoints, ypoints, 6);
//#endif 


//#if -1461171554 
figPoly.setPolygon(polygon);
//#endif 


//#if 412859968 
break;

//#endif 

} 

case EAST://1

{ 

//#if -2103124925 
int[] xpoints = {66, 75, 75, 84, 75, 75};
//#endif 


//#if -1984054490 
int[] ypoints = {24, 24, 26, 24, 22, 24};
//#endif 


//#if -941469957 
Polygon polygon = new Polygon(xpoints, ypoints, 6);
//#endif 


//#if 939797205 
figPoly.setPolygon(polygon);
//#endif 


//#if -192568905 
break;

//#endif 

} 

case WEST://1

{ 

//#if 1241028865 
int[] xpoints = {84, 75, 75, 66, 75, 75};
//#endif 


//#if -18187044 
int[] ypoints = {24, 24, 26, 24, 22, 24};
//#endif 


//#if 874262449 
Polygon polygon = new Polygon(xpoints, ypoints, 6);
//#endif 


//#if 658943839 
figPoly.setPolygon(polygon);
//#endif 


//#if -2106709567 
break;

//#endif 

} 

default://1

{ 

//#if -366964940 
int[] xpoints = {75, 75, 77, 75, 73, 75};
//#endif 


//#if -649708777 
int[] ypoints = {33, 24, 24, 15, 24, 24};
//#endif 


//#if 1770876776 
Polygon polygon = new Polygon(xpoints, ypoints, 6);
//#endif 


//#if 1918176968 
figPoly.setPolygon(polygon);
//#endif 


//#if -2132673046 
break;

//#endif 

} 

} 

//#endif 


//#if -1564081603 
setBounds(bbox);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

