
//#if -720492408 
// Compilation Unit of /FigActor.java 
 

//#if -1893862686 
package org.argouml.uml.diagram.use_case.ui;
//#endif 


//#if -2138763144 
import java.awt.Color;
//#endif 


//#if 1813836501 
import java.awt.Dimension;
//#endif 


//#if 349422220 
import java.awt.Font;
//#endif 


//#if -1766674453 
import java.awt.Point;
//#endif 


//#if 1800057836 
import java.awt.Rectangle;
//#endif 


//#if -1594369710 
import java.awt.event.MouseEvent;
//#endif 


//#if 1424778177 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -1576645152 
import java.util.ArrayList;
//#endif 


//#if 214285441 
import java.util.List;
//#endif 


//#if -74258564 
import java.util.Vector;
//#endif 


//#if 1469794512 
import org.argouml.model.Model;
//#endif 


//#if 1146903219 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -758882738 
import org.argouml.uml.diagram.ui.FigNodeModelElement;
//#endif 


//#if -988750296 
import org.tigris.gef.base.Selection;
//#endif 


//#if 874688508 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -63196473 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 955911895 
import org.tigris.gef.presentation.FigCircle;
//#endif 


//#if 1059580723 
import org.tigris.gef.presentation.FigLine;
//#endif 


//#if 1064992579 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if 1957837193 
public class FigActor extends 
//#if -2134068768 
FigNodeModelElement
//#endif 

  { 

//#if -4140002 
private static final long serialVersionUID = 7265843766314395713L;
//#endif 


//#if -49188296 
protected static final int MIN_VERT_PADDING = 4;
//#endif 


//#if 1168126046 
private static final int HEAD_POSN = 2;
//#endif 


//#if -287393217 
private static final int BODY_POSN = 3;
//#endif 


//#if -1026192045 
private static final int ARMS_POSN = 4;
//#endif 


//#if 727234065 
private static final int LEFT_LEG_POSN = 5;
//#endif 


//#if 1205538083 
private static final int RIGHT_LEG_POSN = 6;
//#endif 


//#if 1603338209 
@Override
    protected void setBoundsImpl(final int x, final int y,
                                 final int w, final int h)
    { 

//#if 119767352 
int middle = x + w / 2;
//#endif 


//#if 189664148 
Rectangle oldBounds = getBounds();
//#endif 


//#if -741654346 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if -2811329 
getFigAt(HEAD_POSN).setLocation(
            middle - getFigAt(HEAD_POSN).getWidth() / 2, y + 10);
//#endif 


//#if -228167699 
getFigAt(BODY_POSN).setLocation(middle, y + 25);
//#endif 


//#if -1746015459 
getFigAt(ARMS_POSN).setLocation(
            middle - getFigAt(ARMS_POSN).getWidth() / 2, y + 30);
//#endif 


//#if 1719940767 
getFigAt(LEFT_LEG_POSN).setLocation(
            middle - getFigAt(LEFT_LEG_POSN).getWidth(), y + 40);
//#endif 


//#if -1556123721 
getFigAt(RIGHT_LEG_POSN).setLocation(middle, y +  40);
//#endif 


//#if -313173105 
Dimension minTextSize = getNameFig().getMinimumSize();
//#endif 


//#if -1224818084 
getNameFig().setBounds(middle - minTextSize.width / 2,
                               y +  55,
                               minTextSize.width,
                               minTextSize.height);
//#endif 


//#if 1968179488 
if(getStereotypeFig().isVisible())//1
{ 

//#if -1300042028 
Dimension minStereoSize = getStereotypeFig().getMinimumSize();
//#endif 


//#if -1166260946 
assert minStereoSize.width <= w;
//#endif 


//#if -2098773580 
getStereotypeFig().setBounds(middle - minStereoSize.width / 2,
                                         y + 55 + getNameFig().getHeight(),
                                         minStereoSize.width,
                                         minStereoSize.height);
//#endif 

} 

//#endif 


//#if 1983292453 
calcBounds();
//#endif 


//#if -2040856095 
firePropChange("bounds", oldBounds, getBounds());
//#endif 


//#if 696072536 
updateEdges();
//#endif 

} 

//#endif 


//#if 2061374295 
@Override
    public Object deepHitPort(int x, int y)
    { 

//#if -43261720 
Object o = super.deepHitPort(x, y);
//#endif 


//#if -1602994050 
if(o != null)//1
{ 

//#if -1796210515 
return o;
//#endif 

} 

//#endif 


//#if -1108885402 
if(hit(new Rectangle(new Dimension(x, y))))//1
{ 

//#if -105061681 
return getOwner();
//#endif 

} 

//#endif 


//#if -1945994187 
return null;
//#endif 

} 

//#endif 


//#if -1338671767 
private void constructFigs()
    { 

//#if -10284222 
Color fg = getLineColor();
//#endif 


//#if 1362608979 
Color fill = getFillColor();
//#endif 


//#if -1173392707 
FigRect bigPort = new ActorPortFigRect(X0, Y0, 0, 0, this);
//#endif 


//#if -1565728558 
FigCircle head =
            new FigCircle(X0 + 2, Y0, 16, 15, fg, fill);
//#endif 


//#if -861021910 
FigLine body = new FigLine(X0 + 10, Y0 + 15, 20, 40, fg);
//#endif 


//#if -548720379 
FigLine arms = new FigLine(X0, Y0 + 20, 30, 30, fg);
//#endif 


//#if 732649108 
FigLine leftLeg = new FigLine(X0 + 10, Y0 + 30, 15, 55, fg);
//#endif 


//#if -119398302 
FigLine rightLeg = new FigLine(X0 + 10, Y0 + 30, 25, 55, fg);
//#endif 


//#if -1350627969 
body.setLineWidth(LINE_WIDTH);
//#endif 


//#if 1244982580 
arms.setLineWidth(LINE_WIDTH);
//#endif 


//#if 313198936 
leftLeg.setLineWidth(LINE_WIDTH);
//#endif 


//#if 1293387567 
rightLeg.setLineWidth(LINE_WIDTH);
//#endif 


//#if -1306406424 
getNameFig().setBounds(X0, Y0 + 45, 20, 20);
//#endif 


//#if 1111377658 
getNameFig().setTextFilled(false);
//#endif 


//#if 1418545005 
getNameFig().setFilled(false);
//#endif 


//#if 1720828430 
getNameFig().setLineWidth(0);
//#endif 


//#if 991997387 
getStereotypeFig().setBounds(getBigPort().getCenter().x,
                                     getBigPort().getCenter().y,
                                     0, 0);
//#endif 


//#if -404665779 
setSuppressCalcBounds(true);
//#endif 


//#if -937186732 
addFig(bigPort);
//#endif 


//#if 1631087253 
addFig(getNameFig());
//#endif 


//#if 787962609 
addFig(head);
//#endif 


//#if 625532467 
addFig(body);
//#endif 


//#if 599936232 
addFig(arms);
//#endif 


//#if -102746182 
addFig(leftLeg);
//#endif 


//#if 2095649635 
addFig(rightLeg);
//#endif 


//#if 297835854 
addFig(getStereotypeFig());
//#endif 


//#if -191126640 
setBigPort(bigPort);
//#endif 


//#if 305580072 
setSuppressCalcBounds(false);
//#endif 

} 

//#endif 


//#if -1021560726 
@Override
    public void setLineWidth(int width)
    { 

//#if -957738683 
for (int i = HEAD_POSN; i < RIGHT_LEG_POSN; i++) //1
{ 

//#if -1707472343 
Fig f = getFigAt(i);
//#endif 


//#if 880156556 
if(f != null)//1
{ 

//#if 290701431 
f.setLineWidth(width);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 742194831 
getFigAt(HEAD_POSN).setLineWidth(width);
//#endif 


//#if -224638579 
getFigAt(BODY_POSN).setLineWidth(width);
//#endif 


//#if -1365090184 
getFigAt(ARMS_POSN).setLineWidth(width);
//#endif 


//#if 646294649 
getFigAt(LEFT_LEG_POSN).setLineWidth(width);
//#endif 


//#if -709983902 
getFigAt(RIGHT_LEG_POSN).setLineWidth(width);
//#endif 

} 

//#endif 


//#if 600907564 
@Override
    public List<Point> getGravityPoints()
    { 

//#if -1649977709 
final int maxPoints = 20;
//#endif 


//#if -809100588 
List<Point> ret = new ArrayList<Point>();
//#endif 


//#if -1413085968 
int cx = getFigAt(HEAD_POSN).getCenter().x;
//#endif 


//#if 537214318 
int cy = getFigAt(HEAD_POSN).getCenter().y;
//#endif 


//#if 683029260 
int radiusx = Math.round(getFigAt(HEAD_POSN).getWidth() / 2) + 1;
//#endif 


//#if -621560160 
int radiusy = Math.round(getFigAt(HEAD_POSN).getHeight() / 2) + 1;
//#endif 


//#if 325018642 
Point point = null;
//#endif 


//#if -1490052202 
for (int i = 0; i < maxPoints; i++) //1
{ 

//#if 305915187 
double angle = 2 * Math.PI / maxPoints * i;
//#endif 


//#if -858858715 
point =
                new Point((int) (cx + Math.cos(angle) * radiusx),
                          (int) (cy + Math.sin(angle) * radiusy));
//#endif 


//#if 477392467 
ret.add(point);
//#endif 

} 

//#endif 


//#if -806693991 
ret.add(new Point(((FigLine) getFigAt(LEFT_LEG_POSN)).getX2(),
                          ((FigLine) getFigAt(LEFT_LEG_POSN)).getY2()));
//#endif 


//#if 1993637539 
ret.add(new Point(((FigLine) getFigAt(RIGHT_LEG_POSN)).getX2(),
                          ((FigLine) getFigAt(RIGHT_LEG_POSN)).getY2()));
//#endif 


//#if -1441226663 
ret.add(new Point(((FigLine) getFigAt(ARMS_POSN)).getX1(),
                          ((FigLine) getFigAt(ARMS_POSN)).getY1()));
//#endif 


//#if 1181629305 
ret.add(new Point(((FigLine) getFigAt(ARMS_POSN)).getX2(),
                          ((FigLine) getFigAt(ARMS_POSN)).getY2()));
//#endif 


//#if -117549659 
return ret;
//#endif 

} 

//#endif 


//#if -2016801037 
@Override
    public void setFilled(boolean filled)
    { 

//#if 1448643582 
getFigAt(HEAD_POSN).setFilled(filled);
//#endif 

} 

//#endif 


//#if -1499640305 
@Override
    public Selection makeSelection()
    { 

//#if -316259648 
return new SelectionActor(this);
//#endif 

} 

//#endif 


//#if 1735462851 
@Override
    protected void modelChanged(PropertyChangeEvent mee)
    { 

//#if -788347794 
super.modelChanged(mee);
//#endif 


//#if -982663049 
boolean damage = false;
//#endif 


//#if -1129655041 
if(getOwner() == null)//1
{ 

//#if -1445486546 
return;
//#endif 

} 

//#endif 


//#if 562656663 
if(mee == null
                || mee.getPropertyName().equals("stereotype")
                || Model.getFacade().getStereotypes(getOwner())
                .contains(mee.getSource()))//1
{ 

//#if -1397761300 
updateStereotypeText();
//#endif 


//#if 255838597 
damage = true;
//#endif 

} 

//#endif 


//#if 517320841 
if(damage)//1
{ 

//#if 347484245 
damage();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -626261867 

//#if 947097934 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigActor()
    { 

//#if 201129700 
constructFigs();
//#endif 

} 

//#endif 


//#if -1057455796 
@Override
    protected int getNameFigFontStyle()
    { 

//#if 1418046666 
Object cls = getOwner();
//#endif 


//#if 774087278 
return Model.getFacade().isAbstract(cls) ? Font.ITALIC : Font.PLAIN;
//#endif 

} 

//#endif 


//#if -364363067 
public FigActor(Object owner, Rectangle bounds, DiagramSettings settings)
    { 

//#if -1868689246 
super(owner, bounds, settings);
//#endif 


//#if -18964328 
constructFigs();
//#endif 


//#if 351005191 
if(bounds != null)//1
{ 

//#if 973466203 
setLocation(bounds.x, bounds.y);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1516841540 
@Override
    public Vector getPopUpActions(MouseEvent me)
    { 

//#if -1339297812 
Vector popUpActions = super.getPopUpActions(me);
//#endif 


//#if 1141925112 
popUpActions.add(
            popUpActions.size() - getPopupAddOffset(),
            buildModifierPopUp(ABSTRACT | LEAF | ROOT));
//#endif 


//#if -918006305 
return popUpActions;
//#endif 

} 

//#endif 


//#if -1070008202 
@Override
    public boolean isResizable()
    { 

//#if 87444093 
return false;
//#endif 

} 

//#endif 


//#if 1579992900 
@Override
    public Dimension getMinimumSize()
    { 

//#if 2055319072 
Dimension nameDim = getNameFig().getMinimumSize();
//#endif 


//#if 309555959 
int w = Math.max(nameDim.width, 40);
//#endif 


//#if 981162351 
int h = nameDim.height + 55;
//#endif 


//#if -49545714 
if(getStereotypeFig().isVisible())//1
{ 

//#if -1184969517 
Dimension stereoDim = getStereotypeFig().getMinimumSize();
//#endif 


//#if -2015889359 
w = Math.max(stereoDim.width, w);
//#endif 


//#if 592005390 
h = h + stereoDim.height;
//#endif 

} 

//#endif 


//#if -1084917552 
return new Dimension(w, h);
//#endif 

} 

//#endif 


//#if 96103820 

//#if 1334405460 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigActor(@SuppressWarnings("unused") GraphModel gm, Object node)
    { 

//#if 276743483 
this();
//#endif 


//#if 414772874 
setOwner(node);
//#endif 

} 

//#endif 


//#if -27242194 
@Override
    protected void updateBounds()
    { 

//#if -1490956518 
if(!isCheckSize())//1
{ 

//#if -281595167 
return;
//#endif 

} 

//#endif 


//#if 1176347980 
Rectangle bbox = getBounds();
//#endif 


//#if 1696692745 
Dimension minSize = getMinimumSize();
//#endif 


//#if -37258755 
setBounds(bbox.x, bbox.y, minSize.width, minSize.height);
//#endif 

} 

//#endif 


//#if -670169309 
static class ActorPortFigRect extends 
//#if -1604318818 
FigRect
//#endif 

  { 

//#if -2138801050 
private Fig parent;
//#endif 


//#if -1197550769 
private static final long serialVersionUID = 5973857118854162659L;
//#endif 


//#if -1501869780 
public ActorPortFigRect(int x, int y, int w, int h, Fig p)
        { 

//#if 120927806 
super(x, y, w, h, null, null);
//#endif 


//#if 550660523 
parent = p;
//#endif 

} 

//#endif 


//#if 348834725 
@Override
        public List getGravityPoints()
        { 

//#if 179561146 
return parent.getGravityPoints();
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

