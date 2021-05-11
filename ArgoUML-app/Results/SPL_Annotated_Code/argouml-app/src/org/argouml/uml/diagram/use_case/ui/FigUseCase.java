// Compilation Unit of /FigUseCase.java 
 
package org.argouml.uml.diagram.use_case.ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.Action;
import org.argouml.model.AssociationChangeEvent;
import org.argouml.model.AttributeChangeEvent;
import org.argouml.model.Model;
import org.argouml.ui.ArgoJMenu;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ExtensionsCompartmentContainer;
import org.argouml.uml.diagram.ui.ActionAddExtensionPoint;
import org.argouml.uml.diagram.ui.ActionAddNote;
import org.argouml.uml.diagram.ui.ActionCompartmentDisplay;
import org.argouml.uml.diagram.ui.CompartmentFigText;
import org.argouml.uml.diagram.ui.FigNodeModelElement;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.Selection;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigCircle;
import org.tigris.gef.presentation.FigGroup;
import org.tigris.gef.presentation.FigLine;
import org.tigris.gef.presentation.FigRect;
import org.tigris.gef.presentation.FigText;
public class FigUseCase extends FigNodeModelElement
 implements ExtensionsCompartmentContainer
  { 
private static final int MIN_VERT_PADDING = 4;
private static final int STEREOTYPE_PADDING = 0;
private static final int SPACER = 2;
private FigMyCircle bigPort;
private FigMyCircle cover;
private FigLine epSep;
private FigGroup epVec;
private FigRect epBigPort;
private CompartmentFigText highlightedFigText;
@Override
    public String classNameAndBounds()
    { 
return super.classNameAndBounds()
               + "extensionPointVisible=" + isExtensionPointVisible();
} 

private Dimension calcEllipse(Dimension rectSize, int vertPadding)
    { 
double a;
double b = rectSize.height / 2.0 + vertPadding;
double x = rectSize.width / 2.0;
double y = rectSize.height / 2.0;
a = (x * b) / Math.sqrt(b * b - y * y);
return new Dimension(((int) (Math.ceil(a)) * 2),
                             ((int) (Math.ceil(b)) * 2));
} 

private double calcX(double a, double b, double y)
    { 
return (a * Math.sqrt(b * b - y * y)) / b;
} 

protected void createContainedModelElement(FigGroup fg, InputEvent ie)
    { 
if(getOwner() == null)//1
{ 
return;
} 

ActionAddExtensionPoint.singleton().actionPerformed(null);
CompartmentFigText ft =
            (CompartmentFigText) fg.getFigs().get(fg.getFigs().size() - 1);
if(ft != null)//1
{ 
ft.startTextEditor(ie);
ft.setHighlighted(true);
highlightedFigText = ft;
} 

ie.consume();
} 

@Override
    public void mousePressed(MouseEvent me)
    { 
super.mousePressed(me);
Editor ce = Globals.curEditor();
if(ce != null)//1
{ 
Selection sel = ce.getSelectionManager().findSelectionFor(this);
if(sel instanceof SelectionUseCase)//1
{ 
((SelectionUseCase) sel).hideButtons();
} 

} 

unhighlight();
Rectangle r = new Rectangle(me.getX() - 1, me.getY() - 1, 2, 2);
Fig f = hitFig(r);
if(f == epVec)//1
{ 
int i = (me.getY() - f.getY() - 1) / ROWHEIGHT;
List<CompartmentFigText> figs = getEPFigs();
if((i >= 0) && (i < figs.size()))//1
{ 
highlightedFigText = figs.get(i);
highlightedFigText.setHighlighted(true);
} 

} 

} 

@Override
    public Vector getPopUpActions(MouseEvent me)
    { 
boolean ms = TargetManager.getInstance().getTargets().size() > 1;
Vector popUpActions = super.getPopUpActions(me);
ArgoJMenu addMenu = new ArgoJMenu("menu.popup.add");
if(!ms)//1
{ 
addMenu.add(ActionAddExtensionPoint.singleton());
} 

addMenu.add(new ActionAddNote());
popUpActions.add(popUpActions.size() - getPopupAddOffset(), addMenu);
popUpActions.add(popUpActions.size() - getPopupAddOffset(),
                         buildModifierPopUp(LEAF | ROOT));
return popUpActions;
} 

@Override
    protected ArgoJMenu buildShowPopUp()
    { 
ArgoJMenu showMenu = super.buildShowPopUp();
Iterator i = ActionCompartmentDisplay.getActions().iterator();
while (i.hasNext()) //1
{ 
showMenu.add((Action) i.next());
} 

return showMenu;
} 

@Override
    public List<Point> getGravityPoints()
    { 
final int maxPoints = 30;
List<Point> ret = new ArrayList<Point>(maxPoints);
int cx = bigPort.getCenter().x;
int cy = bigPort.getCenter().y;
int radiusx = Math.round(bigPort.getWidth() / 2) + 1;
int radiusy = Math.round(bigPort.getHeight() / 2) + 1;
Point point = null;
for (int i = 0; i < maxPoints; i++) //1
{ 
point =
                new Point((int) (cx
                                 + (Math.cos(2 * Math.PI / maxPoints * i)
                                    * radiusx)),
                          (int) (cy
                                 + (Math.sin(2 * Math.PI / maxPoints * i)
                                    * radiusy)));
ret.add(point);
} 

return ret;
} 

@Override
    public void setFillColor(Color col)
    { 
if(cover != null)//1
{ 
cover.setFillColor(col);
} 

} 

@Override
    protected void setBoundsImpl(int x, int y, int w, int h)
    { 
Rectangle oldBounds = getBounds();
Dimension minSize = getMinimumSize();
int newW = (minSize.width > w) ? minSize.width : w;
int newH = (minSize.height > h) ? minSize.height : h;
newH = newH - (getStereotypeFig().getHeight() + STEREOTYPE_PADDING);
Dimension textSize = getTextSize();
int vPadding = (newH - textSize.height) / 2;
Dimension nameSize = getNameFig().getMinimumSize();
getNameFig().setBounds(x + ((newW - nameSize.width) / 2),
                               y + vPadding,
                               nameSize.width,
                               nameSize.height);
if(epVec.isVisible())//1
{ 
int currY = y + vPadding + nameSize.height + SPACER;
int sepLen =
                2 * (int) (calcX(newW / 2.0,
                                 newH / 2.0,
                                 newH / 2.0 - (currY - y)));
epSep.setShape(x + (newW - sepLen) / 2,
                           currY,
                           x + (newW + sepLen) / 2,
                           currY);
currY += 1 + SPACER;
updateFigGroupSize(
                x + ((newW - textSize.width) / 2),
                currY,
                textSize.width,
                (textSize.height - nameSize.height - SPACER * 2 - 1));
} 

bigPort.setBounds(x, y, newW, newH);
cover.setBounds(x, y, newW, newH);
_x = x;
_y = y;
_w = newW;
_h = newH + getStereotypeFig().getHeight() + STEREOTYPE_PADDING;
positionStereotypes();
firePropChange("bounds", oldBounds, getBounds());
updateEdges();
} 

@Override
    public Selection makeSelection()
    { 
return new SelectionUseCase(this);
} 

private void initialize()
    { 
bigPort = new FigMyCircle(0, 0, 100, 60);
cover = new FigMyCircle(0, 0, 100, 60);
getNameFig().setTextFilled(false);
getNameFig().setFilled(false);
getNameFig().setLineWidth(0);
getNameFig().setReturnAction(FigText.END_EDITING);
epSep = new FigLine(0, 30, 100, 100);
epSep.setLineWidth(LINE_WIDTH);
epSep.setVisible(false);
epBigPort =
            new FigRect(0, 30, getNameFig().getBounds().width, 20);
epBigPort.setFilled(false);
epBigPort.setLineWidth(0);
epBigPort.setVisible(false);
epVec = new FigGroup();
epVec.setFilled(false);
epVec.setLineWidth(0);
epVec.setVisible(false);
epVec.addFig(epBigPort);
setBigPort(bigPort);
addFig(bigPort);
addFig(cover);
addFig(getNameFig());
addFig(getStereotypeFig());
addFig(epSep);
addFig(epVec);
updateExtensionPoint();
setBounds(getBounds());
} 

@Override
    public Color getLineColor()
    { 
return cover.getLineColor();
} 

@Override
    public Color getFillColor()
    { 
return cover.getFillColor();
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigUseCase()
    { 
initialize();
} 

@Override
    protected void updateNameText()
    { 
Object useCase = getOwner();
if(useCase == null)//1
{ 
return;
} 

Rectangle oldBounds = getBounds();
super.updateNameText();
setBounds(oldBounds.x, oldBounds.y, oldBounds.width, oldBounds.height);
} 

@Override
    public boolean isFilled()
    { 
return cover.isFilled();
} 

@Override
    public void mouseExited(MouseEvent me)
    { 
super.mouseExited(me);
unhighlight();
} 

private List<CompartmentFigText> getEPFigs()
    { 
List<CompartmentFigText> l =
            new ArrayList<CompartmentFigText>(epVec.getFigs());
l.remove(0);
return l;
} 

public void setExtensionPointVisible(boolean isVisible)
    { 
if(epVec.isVisible() && (!isVisible))//1
{ 
setExtensionPointVisibleInternal(false);
} 
else
if((!epVec.isVisible()) && isVisible)//1
{ 
setExtensionPointVisibleInternal(true);
} 


updateStereotypeText();
} 

@Override
    public void mouseClicked(MouseEvent me)
    { 
super.mouseClicked(me);
if(me.isConsumed())//1
{ 
return;
} 

if(!isExtensionPointVisible() || me.getY() < epSep.getY1())//1
{ 
getNameFig().mouseClicked(me);
} 
else
if(me.getClickCount() >= 2
                   && !(me.isPopupTrigger()
                        || me.getModifiers() == InputEvent.BUTTON3_MASK))//1
{ 
createContainedModelElement(epVec, me);
} 


} 

@Override
    public Dimension getMinimumSize()
    { 
Dimension textSize = getTextSize();
Dimension size = calcEllipse(textSize, MIN_VERT_PADDING);
return new Dimension(Math.max(size.width, 100),
                             Math.max(size.height, 60));
} 

@Override
    public void renderingChanged()
    { 
super.renderingChanged();
if(getOwner() != null)//1
{ 
updateExtensionPoint();
} 

} 

public boolean isExtensionPointVisible()
    { 
return epVec.isVisible();
} 

@Override
    public void setLineColor(Color col)
    { 
if(cover != null)//1
{ 
cover.setLineColor(col);
epSep.setLineColor(col);
} 

} 

private Dimension getTextSize()
    { 
Dimension minSize = getNameFig().getMinimumSize();
if(epVec.isVisible())//1
{ 
minSize.height += 2 * SPACER + 1;
List<CompartmentFigText> figs = getEPFigs();
for (CompartmentFigText f : figs) //1
{ 
int elemWidth = f.getMinimumSize().width;
minSize.width = Math.max(minSize.width, elemWidth);
} 

int rowHeight = Math.max(ROWHEIGHT, minSize.height);
minSize.height += rowHeight * Math.max(1, figs.size());
} 

return minSize;
} 

@Override
    protected void modelChanged(PropertyChangeEvent mee)
    { 
super.modelChanged(mee);
if(mee instanceof AssociationChangeEvent
                || mee instanceof AttributeChangeEvent)//1
{ 
renderingChanged();
updateListeners(getOwner(), getOwner());
} 

} 

@Override
    public void setFilled(boolean f)
    { 
if(cover != null)//1
{ 
cover.setFilled(f);
} 

} 

@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 
Set<Object[]> l = new HashSet<Object[]>();
if(newOwner != null)//1
{ 
l.add(new Object[] {newOwner,
                                new String[] {"remove", "name", "isAbstract",
                                              "extensionPoint", "stereotype"
                                             }
                               });
for (Object ep : Model.getFacade().getExtensionPoints(newOwner)) //1
{ 
l.add(new Object[] {ep, new String[] {"location", "name"}});
} 

for (Object st : Model.getFacade().getStereotypes(newOwner)) //1
{ 
l.add(new Object[] {st, "name"});
} 

} 

updateElementListeners(l);
} 

public FigUseCase(Object owner, Rectangle bounds,
                      DiagramSettings settings)
    { 
super(owner, bounds, settings);
initialize();
if(bounds != null)//1
{ 
setLocation(bounds.x, bounds.y);
} 

} 

@Override
    public String placeString()
    { 
return "new Use Case";
} 

@Override
    public Object clone()
    { 
FigUseCase figClone = (FigUseCase) super.clone();
Iterator it = figClone.getFigs().iterator();
figClone.bigPort = (FigMyCircle) it.next();
figClone.cover = (FigMyCircle) it.next();
figClone.setNameFig((FigText) it.next());
it.next();
figClone.epSep = (FigLine) it.next();
figClone.epVec = (FigGroup) it.next();
return figClone;
} 

protected void updateExtensionPoint()
    { 
Object useCase = getOwner();
if(useCase == null)//1
{ 
return;
} 

Rectangle oldBounds = getBounds();
Collection eps =
            Model.getFacade().getExtensionPoints(useCase);
int epCount = 1;
if((eps != null) && (eps.size() > 0))//1
{ 
int xpos = epBigPort.getX();
int ypos = epBigPort.getY();
Iterator iter = eps.iterator();
List<CompartmentFigText> figs = getEPFigs();
List<CompartmentFigText> toBeRemoved =
                new ArrayList<CompartmentFigText>(figs);
while (iter.hasNext()) //1
{ 
CompartmentFigText epFig = null;
Object ep = iter.next();
for (CompartmentFigText candidate : figs) //1
{ 
if(candidate.getOwner() == ep)//1
{ 
epFig = candidate;
break;

} 

} 

if(epFig == null)//1
{ 
epFig = new CompartmentFigText(ep, new Rectangle(
                                                       xpos,
                                                       ypos + (epCount - 1) * ROWHEIGHT,
                                                       0,
                                                       ROWHEIGHT),
                                                   getSettings());
epFig.setFilled(false);
epFig.setLineWidth(0);
epFig.setTextColor(getTextColor());
epFig.setJustification(FigText.JUSTIFY_LEFT);
epFig.setReturnAction(FigText.END_EDITING);
epVec.addFig(epFig);
} 
else
{ 
toBeRemoved.remove(epFig);
} 

String epText = epFig.getNotationProvider().toString(ep,
                                getNotationSettings());
if(epText == null)//1
{ 
epText = "";
} 

epFig.setText(epText);
epCount++;
} 

for (Fig f : toBeRemoved) //1
{ 
epVec.removeFig(f);
} 

} 

setBounds(oldBounds.x, oldBounds.y, oldBounds.width, oldBounds.height);
} 

@Override
    public int getLineWidth()
    { 
return cover.getLineWidth();
} 

private CompartmentFigText unhighlight()
    { 
for (CompartmentFigText ft : getEPFigs()) //1
{ 
if(ft.isHighlighted())//1
{ 
ft.setHighlighted(false);
highlightedFigText = null;
return ft;
} 

} 

return null;
} 

@Override
    public void setLineWidth(int w)
    { 
if(cover != null)//1
{ 
cover.setLineWidth(w);
} 

} 

private void positionStereotypes()
    { 
if(((FigGroup) getStereotypeFig()).getFigCount() > 0)//1
{ 
getStereotypeFig().setBounds(
                (getX() + getWidth() / 2
                 - getStereotypeFig().getWidth() / 2),
                (getY() + bigPort.getHeight() + STEREOTYPE_PADDING),
                getStereotypeFig().getWidth(),
                getStereotypeFig().getHeight());
} 
else
{ 
getStereotypeFig().setBounds(0, 0, 0, 0);
} 

} 

private void setExtensionPointVisibleInternal(boolean visible)
    { 
Rectangle oldBounds = getBounds();
for (Fig fig : (List<Fig>) epVec.getFigs()) //1
{ 
fig.setVisible(visible);
} 

epVec.setVisible(visible);
epSep.setVisible(visible);
setBounds(oldBounds.x, oldBounds.y,
                  oldBounds.width,
                  oldBounds.height);
endTrans();
} 

@Override
    protected void updateStereotypeText()
    { 
super.updateStereotypeText();
if(getOwner() == null)//1
{ 
return;
} 

positionStereotypes();
damage();
} 

protected void updateFigGroupSize(int x, int y, int w,
                                      int h)
    { 
int newW = w;
int n = epVec.getFigs().size() - 1;
int newH =
            isCheckSize() ? Math.max(h, ROWHEIGHT * Math.max(1, n) + 2)
            : h;
Iterator figs = epVec.getFigs().iterator();
figs.next();
Fig fi;
int fw, fh;
int yy = y;
while (figs.hasNext()) //1
{ 
fi = (Fig) figs.next();
fw = fi.getMinimumSize().width;
fh = fi.getMinimumSize().height;
if(!isCheckSize() && fw > newW - 2)//1
{ 
fw = newW - 2;
} 

fi.setBounds(x + 1, yy + 1, fw, fh/* - 2*/);
if(isCheckSize() && newW < fw + 2)//1
{ 
newW = fw + 2;
} 

yy += fh;
} 

epBigPort.setBounds(x, y, newW, newH);
epVec.calcBounds();
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigUseCase(@SuppressWarnings("unused") GraphModel gm, Object node)
    { 
this();
setOwner(node);
} 

public static class FigMyCircle extends FigCircle
  { 
private static final long serialVersionUID = 2616728355472635182L;
@Override
        public Point connectionPoint(Point anotherPt)
        { 
double rx = _w / 2;
double ry = _h / 2;
double dx = anotherPt.x - (_x + rx);
double dy = anotherPt.y - (_y + ry);
double dd = ry * ry * dx * dx + rx * rx * dy * dy;
double mu = rx * ry / Math.sqrt(dd);
Point res =
                new Point((int) (mu * dx + _x + rx),
                          (int) (mu * dy + _y + ry));
return res;
} 

public FigMyCircle(int x, int y, int w, int h)
        { 
super(x, y, w, h);
} 

public FigMyCircle(int x, int y, int w, int h,
                           Color lColor,
                           Color fColor)
        { 
super(x, y, w, h, lColor, fColor);
} 

 } 

 } 


