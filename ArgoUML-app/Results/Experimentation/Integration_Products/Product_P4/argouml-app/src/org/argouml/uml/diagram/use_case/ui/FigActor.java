package org.argouml.uml.diagram.use_case.ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.argouml.model.Model;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.FigNodeModelElement;
import org.tigris.gef.base.Selection;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigCircle;
import org.tigris.gef.presentation.FigLine;
import org.tigris.gef.presentation.FigRect;
public class FigActor extends FigNodeModelElement
  { 
private static final long serialVersionUID = 7265843766314395713L;
protected static final int MIN_VERT_PADDING = 4;
private static final int HEAD_POSN = 2;
private static final int BODY_POSN = 3;
private static final int ARMS_POSN = 4;
private static final int LEFT_LEG_POSN = 5;
private static final int RIGHT_LEG_POSN = 6;
@Override
    protected void setBoundsImpl(final int x, final int y,
                                 final int w, final int h)
    { 
int middle = x + w / 2;
Rectangle oldBounds = getBounds();
getBigPort().setBounds(x, y, w, h);
getFigAt(HEAD_POSN).setLocation(
            middle - getFigAt(HEAD_POSN).getWidth() / 2, y + 10);
getFigAt(BODY_POSN).setLocation(middle, y + 25);
getFigAt(ARMS_POSN).setLocation(
            middle - getFigAt(ARMS_POSN).getWidth() / 2, y + 30);
getFigAt(LEFT_LEG_POSN).setLocation(
            middle - getFigAt(LEFT_LEG_POSN).getWidth(), y + 40);
getFigAt(RIGHT_LEG_POSN).setLocation(middle, y +  40);
Dimension minTextSize = getNameFig().getMinimumSize();
getNameFig().setBounds(middle - minTextSize.width / 2,
                               y +  55,
                               minTextSize.width,
                               minTextSize.height);
if(getStereotypeFig().isVisible())//1
{ 
Dimension minStereoSize = getStereotypeFig().getMinimumSize();
assert minStereoSize.width <= w;
getStereotypeFig().setBounds(middle - minStereoSize.width / 2,
                                         y + 55 + getNameFig().getHeight(),
                                         minStereoSize.width,
                                         minStereoSize.height);
} 
calcBounds();
firePropChange("bounds", oldBounds, getBounds());
updateEdges();
} 
@Override
    public Object deepHitPort(int x, int y)
    { 
Object o = super.deepHitPort(x, y);
if(o != null)//1
{ 
return o;
} 
if(hit(new Rectangle(new Dimension(x, y))))//1
{ 
return getOwner();
} 
return null;
} 
private void constructFigs()
    { 
Color fg = getLineColor();
Color fill = getFillColor();
FigRect bigPort = new ActorPortFigRect(X0, Y0, 0, 0, this);
FigCircle head =
            new FigCircle(X0 + 2, Y0, 16, 15, fg, fill);
FigLine body = new FigLine(X0 + 10, Y0 + 15, 20, 40, fg);
FigLine arms = new FigLine(X0, Y0 + 20, 30, 30, fg);
FigLine leftLeg = new FigLine(X0 + 10, Y0 + 30, 15, 55, fg);
FigLine rightLeg = new FigLine(X0 + 10, Y0 + 30, 25, 55, fg);
body.setLineWidth(LINE_WIDTH);
arms.setLineWidth(LINE_WIDTH);
leftLeg.setLineWidth(LINE_WIDTH);
rightLeg.setLineWidth(LINE_WIDTH);
getNameFig().setBounds(X0, Y0 + 45, 20, 20);
getNameFig().setTextFilled(false);
getNameFig().setFilled(false);
getNameFig().setLineWidth(0);
getStereotypeFig().setBounds(getBigPort().getCenter().x,
                                     getBigPort().getCenter().y,
                                     0, 0);
setSuppressCalcBounds(true);
addFig(bigPort);
addFig(getNameFig());
addFig(head);
addFig(body);
addFig(arms);
addFig(leftLeg);
addFig(rightLeg);
addFig(getStereotypeFig());
setBigPort(bigPort);
setSuppressCalcBounds(false);
} 
@Override
    public void setLineWidth(int width)
    { 
for (int i = HEAD_POSN; i < RIGHT_LEG_POSN; i++) //1
{ 
Fig f = getFigAt(i);
if(f != null)//1
{ 
f.setLineWidth(width);
} 
} 
getFigAt(HEAD_POSN).setLineWidth(width);
getFigAt(BODY_POSN).setLineWidth(width);
getFigAt(ARMS_POSN).setLineWidth(width);
getFigAt(LEFT_LEG_POSN).setLineWidth(width);
getFigAt(RIGHT_LEG_POSN).setLineWidth(width);
} 
@Override
    public List<Point> getGravityPoints()
    { 
final int maxPoints = 20;
List<Point> ret = new ArrayList<Point>();
int cx = getFigAt(HEAD_POSN).getCenter().x;
int cy = getFigAt(HEAD_POSN).getCenter().y;
int radiusx = Math.round(getFigAt(HEAD_POSN).getWidth() / 2) + 1;
int radiusy = Math.round(getFigAt(HEAD_POSN).getHeight() / 2) + 1;
Point point = null;
for (int i = 0; i < maxPoints; i++) //1
{ 
double angle = 2 * Math.PI / maxPoints * i;
point =
                new Point((int) (cx + Math.cos(angle) * radiusx),
                          (int) (cy + Math.sin(angle) * radiusy));
ret.add(point);
} 
ret.add(new Point(((FigLine) getFigAt(LEFT_LEG_POSN)).getX2(),
                          ((FigLine) getFigAt(LEFT_LEG_POSN)).getY2()));
ret.add(new Point(((FigLine) getFigAt(RIGHT_LEG_POSN)).getX2(),
                          ((FigLine) getFigAt(RIGHT_LEG_POSN)).getY2()));
ret.add(new Point(((FigLine) getFigAt(ARMS_POSN)).getX1(),
                          ((FigLine) getFigAt(ARMS_POSN)).getY1()));
ret.add(new Point(((FigLine) getFigAt(ARMS_POSN)).getX2(),
                          ((FigLine) getFigAt(ARMS_POSN)).getY2()));
return ret;
} 
@Override
    public void setFilled(boolean filled)
    { 
getFigAt(HEAD_POSN).setFilled(filled);
} 
@Override
    public Selection makeSelection()
    { 
return new SelectionActor(this);
} 
@Override
    protected void modelChanged(PropertyChangeEvent mee)
    { 
super.modelChanged(mee);
boolean damage = false;
if(getOwner() == null)//1
{ 
return;
} 
if(mee == null
                || mee.getPropertyName().equals("stereotype")
                || Model.getFacade().getStereotypes(getOwner())
                .contains(mee.getSource()))//1
{ 
updateStereotypeText();
damage = true;
} 
if(damage)//1
{ 
damage();
} 
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigActor()
    { 
constructFigs();
} 
@Override
    protected int getNameFigFontStyle()
    { 
Object cls = getOwner();
return Model.getFacade().isAbstract(cls) ? Font.ITALIC : Font.PLAIN;
} 
public FigActor(Object owner, Rectangle bounds, DiagramSettings settings)
    { 
super(owner, bounds, settings);
constructFigs();
if(bounds != null)//1
{ 
setLocation(bounds.x, bounds.y);
} 
} 
@Override
    public Vector getPopUpActions(MouseEvent me)
    { 
Vector popUpActions = super.getPopUpActions(me);
popUpActions.add(
            popUpActions.size() - getPopupAddOffset(),
            buildModifierPopUp(ABSTRACT | LEAF | ROOT));
return popUpActions;
} 
@Override
    public boolean isResizable()
    { 
return false;
} 
@Override
    public Dimension getMinimumSize()
    { 
Dimension nameDim = getNameFig().getMinimumSize();
int w = Math.max(nameDim.width, 40);
int h = nameDim.height + 55;
if(getStereotypeFig().isVisible())//1
{ 
Dimension stereoDim = getStereotypeFig().getMinimumSize();
w = Math.max(stereoDim.width, w);
h = h + stereoDim.height;
} 
return new Dimension(w, h);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigActor(@SuppressWarnings("unused") GraphModel gm, Object node)
    { 
this();
setOwner(node);
} 
@Override
    protected void updateBounds()
    { 
if(!isCheckSize())//1
{ 
return;
} 
Rectangle bbox = getBounds();
Dimension minSize = getMinimumSize();
setBounds(bbox.x, bbox.y, minSize.width, minSize.height);
} 
static class ActorPortFigRect extends FigRect
  { 
private Fig parent;
private static final long serialVersionUID = 5973857118854162659L;
public ActorPortFigRect(int x, int y, int w, int h, Fig p)
        { 
super(x, y, w, h, null, null);
parent = p;
} 
@Override
        public List getGravityPoints()
        { 
return parent.getGravityPoints();
} 

 } 

 } 
