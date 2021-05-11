
//#if 1300562453 
// Compilation Unit of /FigUseCase.java 
 

//#if 239044086 
package org.argouml.uml.diagram.use_case.ui;
//#endif 


//#if -2064242036 
import java.awt.Color;
//#endif 


//#if 1066066665 
import java.awt.Dimension;
//#endif 


//#if -1692153345 
import java.awt.Point;
//#endif 


//#if 1052288000 
import java.awt.Rectangle;
//#endif 


//#if 2090915363 
import java.awt.event.InputEvent;
//#endif 


//#if -1064080706 
import java.awt.event.MouseEvent;
//#endif 


//#if -449915435 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 1012293708 
import java.util.ArrayList;
//#endif 


//#if -1639035243 
import java.util.Collection;
//#endif 


//#if -180228081 
import java.util.HashSet;
//#endif 


//#if 708582597 
import java.util.Iterator;
//#endif 


//#if 288806549 
import java.util.List;
//#endif 


//#if -406120991 
import java.util.Set;
//#endif 


//#if -1473917808 
import java.util.Vector;
//#endif 


//#if -1081568939 
import javax.swing.Action;
//#endif 


//#if -926011896 
import org.argouml.model.AssociationChangeEvent;
//#endif 


//#if 1228325155 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if 1300514108 
import org.argouml.model.Model;
//#endif 


//#if 1196110464 
import org.argouml.ui.ArgoJMenu;
//#endif 


//#if -138648922 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1468596449 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -2067084130 
import org.argouml.uml.diagram.ExtensionsCompartmentContainer;
//#endif 


//#if -1116808289 
import org.argouml.uml.diagram.ui.ActionAddExtensionPoint;
//#endif 


//#if -1843231074 
import org.argouml.uml.diagram.ui.ActionAddNote;
//#endif 


//#if -2146719691 
import org.argouml.uml.diagram.ui.ActionCompartmentDisplay;
//#endif 


//#if -706525796 
import org.argouml.uml.diagram.ui.CompartmentFigText;
//#endif 


//#if -1859639198 
import org.argouml.uml.diagram.ui.FigNodeModelElement;
//#endif 


//#if 1095497001 
import org.tigris.gef.base.Editor;
//#endif 


//#if 1751114672 
import org.tigris.gef.base.Globals;
//#endif 


//#if -1603413612 
import org.tigris.gef.base.Selection;
//#endif 


//#if -1406238616 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 1950843699 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1643454909 
import org.tigris.gef.presentation.FigCircle;
//#endif 


//#if 485383620 
import org.tigris.gef.presentation.FigGroup;
//#endif 


//#if 851289503 
import org.tigris.gef.presentation.FigLine;
//#endif 


//#if 856701359 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if 858568582 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 1373482495 
public class FigUseCase extends 
//#if 306630489 
FigNodeModelElement
//#endif 

 implements 
//#if 2146173443 
ExtensionsCompartmentContainer
//#endif 

  { 

//#if 384313706 
private static final int MIN_VERT_PADDING = 4;
//#endif 


//#if 1597860570 
private static final int STEREOTYPE_PADDING = 0;
//#endif 


//#if -743926064 
private static final int SPACER = 2;
//#endif 


//#if -894666409 
private FigMyCircle bigPort;
//#endif 


//#if -1745062591 
private FigMyCircle cover;
//#endif 


//#if -2124094051 
private FigLine epSep;
//#endif 


//#if -1604487152 
private FigGroup epVec;
//#endif 


//#if -1465958742 
private FigRect epBigPort;
//#endif 


//#if 1645373211 
private CompartmentFigText highlightedFigText;
//#endif 


//#if -1977435920 
@Override
    public String classNameAndBounds()
    { 

//#if -103388233 
return super.classNameAndBounds()
               + "extensionPointVisible=" + isExtensionPointVisible();
//#endif 

} 

//#endif 


//#if 220950613 
private Dimension calcEllipse(Dimension rectSize, int vertPadding)
    { 

//#if -1977970540 
double a;
//#endif 


//#if -802622714 
double b = rectSize.height / 2.0 + vertPadding;
//#endif 


//#if 1130501050 
double x = rectSize.width / 2.0;
//#endif 


//#if 961980740 
double y = rectSize.height / 2.0;
//#endif 


//#if 1447354738 
a = (x * b) / Math.sqrt(b * b - y * y);
//#endif 


//#if 764547250 
return new Dimension(((int) (Math.ceil(a)) * 2),
                             ((int) (Math.ceil(b)) * 2));
//#endif 

} 

//#endif 


//#if 112609297 
private double calcX(double a, double b, double y)
    { 

//#if -1941566463 
return (a * Math.sqrt(b * b - y * y)) / b;
//#endif 

} 

//#endif 


//#if 1122628109 
protected void createContainedModelElement(FigGroup fg, InputEvent ie)
    { 

//#if -436641839 
if(getOwner() == null)//1
{ 

//#if 6030726 
return;
//#endif 

} 

//#endif 


//#if 1488128018 
ActionAddExtensionPoint.singleton().actionPerformed(null);
//#endif 


//#if 1061601681 
CompartmentFigText ft =
            (CompartmentFigText) fg.getFigs().get(fg.getFigs().size() - 1);
//#endif 


//#if -759428483 
if(ft != null)//1
{ 

//#if -1517580182 
ft.startTextEditor(ie);
//#endif 


//#if -461316793 
ft.setHighlighted(true);
//#endif 


//#if -1299676930 
highlightedFigText = ft;
//#endif 

} 

//#endif 


//#if 1977253225 
ie.consume();
//#endif 

} 

//#endif 


//#if 1531626042 
@Override
    public void mousePressed(MouseEvent me)
    { 

//#if 732913407 
super.mousePressed(me);
//#endif 


//#if -654402922 
Editor ce = Globals.curEditor();
//#endif 


//#if 885924917 
if(ce != null)//1
{ 

//#if 696916098 
Selection sel = ce.getSelectionManager().findSelectionFor(this);
//#endif 


//#if -1426422725 
if(sel instanceof SelectionUseCase)//1
{ 

//#if 681537035 
((SelectionUseCase) sel).hideButtons();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 204186434 
unhighlight();
//#endif 


//#if -781258677 
Rectangle r = new Rectangle(me.getX() - 1, me.getY() - 1, 2, 2);
//#endif 


//#if 113163525 
Fig f = hitFig(r);
//#endif 


//#if 1179732659 
if(f == epVec)//1
{ 

//#if 1486587586 
int i = (me.getY() - f.getY() - 1) / ROWHEIGHT;
//#endif 


//#if 955212669 
List<CompartmentFigText> figs = getEPFigs();
//#endif 


//#if 195398753 
if((i >= 0) && (i < figs.size()))//1
{ 

//#if 1035972504 
highlightedFigText = figs.get(i);
//#endif 


//#if -615969000 
highlightedFigText.setHighlighted(true);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 988236067 
@Override
    public Vector getPopUpActions(MouseEvent me)
    { 

//#if -1480040485 
boolean ms = TargetManager.getInstance().getTargets().size() > 1;
//#endif 


//#if 954001076 
Vector popUpActions = super.getPopUpActions(me);
//#endif 


//#if -678077408 
ArgoJMenu addMenu = new ArgoJMenu("menu.popup.add");
//#endif 


//#if -1542189609 
if(!ms)//1
{ 

//#if -1866320909 
addMenu.add(ActionAddExtensionPoint.singleton());
//#endif 

} 

//#endif 


//#if -1911313256 
addMenu.add(new ActionAddNote());
//#endif 


//#if 1578726534 
popUpActions.add(popUpActions.size() - getPopupAddOffset(), addMenu);
//#endif 


//#if -1613449680 
popUpActions.add(popUpActions.size() - getPopupAddOffset(),
                         buildModifierPopUp(LEAF | ROOT));
//#endif 


//#if 364656295 
return popUpActions;
//#endif 

} 

//#endif 


//#if 1187759888 
@Override
    protected ArgoJMenu buildShowPopUp()
    { 

//#if -1318870706 
ArgoJMenu showMenu = super.buildShowPopUp();
//#endif 


//#if 121931493 
Iterator i = ActionCompartmentDisplay.getActions().iterator();
//#endif 


//#if 640281715 
while (i.hasNext()) //1
{ 

//#if -554915693 
showMenu.add((Action) i.next());
//#endif 

} 

//#endif 


//#if 1344802184 
return showMenu;
//#endif 

} 

//#endif 


//#if -843453485 
@Override
    public List<Point> getGravityPoints()
    { 

//#if -422932801 
final int maxPoints = 30;
//#endif 


//#if -543472276 
List<Point> ret = new ArrayList<Point>(maxPoints);
//#endif 


//#if -1867654437 
int cx = bigPort.getCenter().x;
//#endif 


//#if -1934661159 
int cy = bigPort.getCenter().y;
//#endif 


//#if -43611721 
int radiusx = Math.round(bigPort.getWidth() / 2) + 1;
//#endif 


//#if 200750037 
int radiusy = Math.round(bigPort.getHeight() / 2) + 1;
//#endif 


//#if -1769875257 
Point point = null;
//#endif 


//#if -82235509 
for (int i = 0; i < maxPoints; i++) //1
{ 

//#if -392746831 
point =
                new Point((int) (cx
                                 + (Math.cos(2 * Math.PI / maxPoints * i)
                                    * radiusx)),
                          (int) (cy
                                 + (Math.sin(2 * Math.PI / maxPoints * i)
                                    * radiusy)));
//#endif 


//#if 1450924051 
ret.add(point);
//#endif 

} 

//#endif 


//#if -781208038 
return ret;
//#endif 

} 

//#endif 


//#if 445305259 
@Override
    public void setFillColor(Color col)
    { 

//#if -274937254 
if(cover != null)//1
{ 

//#if 560412184 
cover.setFillColor(col);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 170581874 
@Override
    protected void setBoundsImpl(int x, int y, int w, int h)
    { 

//#if -804984536 
Rectangle oldBounds = getBounds();
//#endif 


//#if -678222616 
Dimension minSize = getMinimumSize();
//#endif 


//#if 1052837491 
int newW = (minSize.width > w) ? minSize.width : w;
//#endif 


//#if 1914107806 
int newH = (minSize.height > h) ? minSize.height : h;
//#endif 


//#if 1139192243 
newH = newH - (getStereotypeFig().getHeight() + STEREOTYPE_PADDING);
//#endif 


//#if 575725014 
Dimension textSize = getTextSize();
//#endif 


//#if 1491046351 
int vPadding = (newH - textSize.height) / 2;
//#endif 


//#if 943617529 
Dimension nameSize = getNameFig().getMinimumSize();
//#endif 


//#if 74175782 
getNameFig().setBounds(x + ((newW - nameSize.width) / 2),
                               y + vPadding,
                               nameSize.width,
                               nameSize.height);
//#endif 


//#if -1527074696 
if(epVec.isVisible())//1
{ 

//#if 1808102321 
int currY = y + vPadding + nameSize.height + SPACER;
//#endif 


//#if 148189137 
int sepLen =
                2 * (int) (calcX(newW / 2.0,
                                 newH / 2.0,
                                 newH / 2.0 - (currY - y)));
//#endif 


//#if 650660539 
epSep.setShape(x + (newW - sepLen) / 2,
                           currY,
                           x + (newW + sepLen) / 2,
                           currY);
//#endif 


//#if 552889087 
currY += 1 + SPACER;
//#endif 


//#if 1367128204 
updateFigGroupSize(
                x + ((newW - textSize.width) / 2),
                currY,
                textSize.width,
                (textSize.height - nameSize.height - SPACER * 2 - 1));
//#endif 

} 

//#endif 


//#if -769597805 
bigPort.setBounds(x, y, newW, newH);
//#endif 


//#if -192534679 
cover.setBounds(x, y, newW, newH);
//#endif 


//#if -2000212176 
_x = x;
//#endif 


//#if -2000182354 
_y = y;
//#endif 


//#if -840041066 
_w = newW;
//#endif 


//#if 560127711 
_h = newH + getStereotypeFig().getHeight() + STEREOTYPE_PADDING;
//#endif 


//#if -1696216359 
positionStereotypes();
//#endif 


//#if 1709979509 
firePropChange("bounds", oldBounds, getBounds());
//#endif 


//#if -1281380028 
updateEdges();
//#endif 

} 

//#endif 


//#if -13437688 
@Override
    public Selection makeSelection()
    { 

//#if -906704605 
return new SelectionUseCase(this);
//#endif 

} 

//#endif 


//#if -582790072 
private void initialize()
    { 

//#if -1504002466 
bigPort = new FigMyCircle(0, 0, 100, 60);
//#endif 


//#if 824204340 
cover = new FigMyCircle(0, 0, 100, 60);
//#endif 


//#if 1613402593 
getNameFig().setTextFilled(false);
//#endif 


//#if 715726292 
getNameFig().setFilled(false);
//#endif 


//#if 2113798855 
getNameFig().setLineWidth(0);
//#endif 


//#if -780883060 
getNameFig().setReturnAction(FigText.END_EDITING);
//#endif 


//#if -507813714 
epSep = new FigLine(0, 30, 100, 100);
//#endif 


//#if -925826435 
epSep.setLineWidth(LINE_WIDTH);
//#endif 


//#if -664973083 
epSep.setVisible(false);
//#endif 


//#if -989140325 
epBigPort =
            new FigRect(0, 30, getNameFig().getBounds().width, 20);
//#endif 


//#if 1174906764 
epBigPort.setFilled(false);
//#endif 


//#if 743137807 
epBigPort.setLineWidth(0);
//#endif 


//#if -1947884862 
epBigPort.setVisible(false);
//#endif 


//#if -1703581312 
epVec = new FigGroup();
//#endif 


//#if -2134633793 
epVec.setFilled(false);
//#endif 


//#if -1718926212 
epVec.setLineWidth(0);
//#endif 


//#if -1464427025 
epVec.setVisible(false);
//#endif 


//#if 1869218805 
epVec.addFig(epBigPort);
//#endif 


//#if 1356201655 
setBigPort(bigPort);
//#endif 


//#if 1688187131 
addFig(bigPort);
//#endif 


//#if 2063222673 
addFig(cover);
//#endif 


//#if -1941343154 
addFig(getNameFig());
//#endif 


//#if 1049081927 
addFig(getStereotypeFig());
//#endif 


//#if -460433267 
addFig(epSep);
//#endif 


//#if -457675197 
addFig(epVec);
//#endif 


//#if 1289073939 
updateExtensionPoint();
//#endif 


//#if -256716256 
setBounds(getBounds());
//#endif 

} 

//#endif 


//#if 556193160 
@Override
    public Color getLineColor()
    { 

//#if 265458339 
return cover.getLineColor();
//#endif 

} 

//#endif 


//#if 1382678809 
@Override
    public Color getFillColor()
    { 

//#if 1845839616 
return cover.getFillColor();
//#endif 

} 

//#endif 


//#if 1460452848 

//#if 168745373 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigUseCase()
    { 

//#if -214939236 
initialize();
//#endif 

} 

//#endif 


//#if -784188424 
@Override
    protected void updateNameText()
    { 

//#if 1114838571 
Object useCase = getOwner();
//#endif 


//#if 1640097896 
if(useCase == null)//1
{ 

//#if -960703235 
return;
//#endif 

} 

//#endif 


//#if 1655334482 
Rectangle oldBounds = getBounds();
//#endif 


//#if -520248647 
super.updateNameText();
//#endif 


//#if 1177301708 
setBounds(oldBounds.x, oldBounds.y, oldBounds.width, oldBounds.height);
//#endif 

} 

//#endif 


//#if -1563501120 
@Override
    public boolean isFilled()
    { 

//#if -752653833 
return cover.isFilled();
//#endif 

} 

//#endif 


//#if -865807411 
@Override
    public void mouseExited(MouseEvent me)
    { 

//#if 527424498 
super.mouseExited(me);
//#endif 


//#if 662499630 
unhighlight();
//#endif 

} 

//#endif 


//#if 852971277 
private List<CompartmentFigText> getEPFigs()
    { 

//#if 1822373831 
List<CompartmentFigText> l =
            new ArrayList<CompartmentFigText>(epVec.getFigs());
//#endif 


//#if 1052491952 
l.remove(0);
//#endif 


//#if 1554953647 
return l;
//#endif 

} 

//#endif 


//#if 1608926333 
public void setExtensionPointVisible(boolean isVisible)
    { 

//#if -1250591699 
if(epVec.isVisible() && (!isVisible))//1
{ 

//#if -258579696 
setExtensionPointVisibleInternal(false);
//#endif 

} 
else

//#if 860723961 
if((!epVec.isVisible()) && isVisible)//1
{ 

//#if -344965620 
setExtensionPointVisibleInternal(true);
//#endif 

} 

//#endif 


//#endif 


//#if -185226272 
updateStereotypeText();
//#endif 

} 

//#endif 


//#if -1309165185 
@Override
    public void mouseClicked(MouseEvent me)
    { 

//#if 476104440 
super.mouseClicked(me);
//#endif 


//#if -1390247637 
if(me.isConsumed())//1
{ 

//#if 2041609185 
return;
//#endif 

} 

//#endif 


//#if 635380061 
if(!isExtensionPointVisible() || me.getY() < epSep.getY1())//1
{ 

//#if 795008375 
getNameFig().mouseClicked(me);
//#endif 

} 
else

//#if -278045096 
if(me.getClickCount() >= 2
                   && !(me.isPopupTrigger()
                        || me.getModifiers() == InputEvent.BUTTON3_MASK))//1
{ 

//#if -814912634 
createContainedModelElement(epVec, me);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 407633771 
@Override
    public Dimension getMinimumSize()
    { 

//#if 347340386 
Dimension textSize = getTextSize();
//#endif 


//#if -1400913112 
Dimension size = calcEllipse(textSize, MIN_VERT_PADDING);
//#endif 


//#if 1654340603 
return new Dimension(Math.max(size.width, 100),
                             Math.max(size.height, 60));
//#endif 

} 

//#endif 


//#if -1296447854 
@Override
    public void renderingChanged()
    { 

//#if 2079393192 
super.renderingChanged();
//#endif 


//#if -2055370947 
if(getOwner() != null)//1
{ 

//#if 1147009280 
updateExtensionPoint();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -57766535 
public boolean isExtensionPointVisible()
    { 

//#if 472805625 
return epVec.isVisible();
//#endif 

} 

//#endif 


//#if 1658832666 
@Override
    public void setLineColor(Color col)
    { 

//#if -354142182 
if(cover != null)//1
{ 

//#if 1245343560 
cover.setLineColor(col);
//#endif 


//#if 1491269068 
epSep.setLineColor(col);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 92331682 
private Dimension getTextSize()
    { 

//#if -743000170 
Dimension minSize = getNameFig().getMinimumSize();
//#endif 


//#if -263550542 
if(epVec.isVisible())//1
{ 

//#if -747623221 
minSize.height += 2 * SPACER + 1;
//#endif 


//#if -612154811 
List<CompartmentFigText> figs = getEPFigs();
//#endif 


//#if 969918651 
for (CompartmentFigText f : figs) //1
{ 

//#if -158480721 
int elemWidth = f.getMinimumSize().width;
//#endif 


//#if 566469523 
minSize.width = Math.max(minSize.width, elemWidth);
//#endif 

} 

//#endif 


//#if -320508208 
int rowHeight = Math.max(ROWHEIGHT, minSize.height);
//#endif 


//#if 2052190749 
minSize.height += rowHeight * Math.max(1, figs.size());
//#endif 

} 

//#endif 


//#if -462768087 
return minSize;
//#endif 

} 

//#endif 


//#if 304557098 
@Override
    protected void modelChanged(PropertyChangeEvent mee)
    { 

//#if -1162797332 
super.modelChanged(mee);
//#endif 


//#if 1470797025 
if(mee instanceof AssociationChangeEvent
                || mee instanceof AttributeChangeEvent)//1
{ 

//#if 1899199374 
renderingChanged();
//#endif 


//#if 1929454248 
updateListeners(getOwner(), getOwner());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2034814718 
@Override
    public void setFilled(boolean f)
    { 

//#if -604080329 
if(cover != null)//1
{ 

//#if 561109304 
cover.setFilled(f);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1651436290 
@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 

//#if -1793669644 
Set<Object[]> l = new HashSet<Object[]>();
//#endif 


//#if -1384567290 
if(newOwner != null)//1
{ 

//#if 181546860 
l.add(new Object[] {newOwner,
                                new String[] {"remove", "name", "isAbstract",
                                              "extensionPoint", "stereotype"
                                             }
                               });
//#endif 


//#if -991541897 
for (Object ep : Model.getFacade().getExtensionPoints(newOwner)) //1
{ 

//#if 796177069 
l.add(new Object[] {ep, new String[] {"location", "name"}});
//#endif 

} 

//#endif 


//#if -993130560 
for (Object st : Model.getFacade().getStereotypes(newOwner)) //1
{ 

//#if 226757558 
l.add(new Object[] {st, "name"});
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1447104517 
updateElementListeners(l);
//#endif 

} 

//#endif 


//#if 548538716 
public FigUseCase(Object owner, Rectangle bounds,
                      DiagramSettings settings)
    { 

//#if 552400029 
super(owner, bounds, settings);
//#endif 


//#if -1053505055 
initialize();
//#endif 


//#if 908950466 
if(bounds != null)//1
{ 

//#if 262199584 
setLocation(bounds.x, bounds.y);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 632209939 
@Override
    public String placeString()
    { 

//#if 794922785 
return "new Use Case";
//#endif 

} 

//#endif 


//#if 1675566794 
@Override
    public Object clone()
    { 

//#if -725651972 
FigUseCase figClone = (FigUseCase) super.clone();
//#endif 


//#if 849840800 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if -452282473 
figClone.bigPort = (FigMyCircle) it.next();
//#endif 


//#if -169693395 
figClone.cover = (FigMyCircle) it.next();
//#endif 


//#if 1585121784 
figClone.setNameFig((FigText) it.next());
//#endif 


//#if 1847364055 
it.next();
//#endif 


//#if -1374628399 
figClone.epSep = (FigLine) it.next();
//#endif 


//#if 1989281984 
figClone.epVec = (FigGroup) it.next();
//#endif 


//#if -1051303873 
return figClone;
//#endif 

} 

//#endif 


//#if 625943965 
protected void updateExtensionPoint()
    { 

//#if 670412952 
Object useCase = getOwner();
//#endif 


//#if 1998175707 
if(useCase == null)//1
{ 

//#if 1643829559 
return;
//#endif 

} 

//#endif 


//#if -1537688833 
Rectangle oldBounds = getBounds();
//#endif 


//#if 1857507298 
Collection eps =
            Model.getFacade().getExtensionPoints(useCase);
//#endif 


//#if -932290222 
int epCount = 1;
//#endif 


//#if 932199466 
if((eps != null) && (eps.size() > 0))//1
{ 

//#if 1118252602 
int xpos = epBigPort.getX();
//#endif 


//#if -919773896 
int ypos = epBigPort.getY();
//#endif 


//#if -1631761853 
Iterator iter = eps.iterator();
//#endif 


//#if 711977123 
List<CompartmentFigText> figs = getEPFigs();
//#endif 


//#if -1514919617 
List<CompartmentFigText> toBeRemoved =
                new ArrayList<CompartmentFigText>(figs);
//#endif 


//#if -621503221 
while (iter.hasNext()) //1
{ 

//#if 268107457 
CompartmentFigText epFig = null;
//#endif 


//#if 384267316 
Object ep = iter.next();
//#endif 


//#if -1923915204 
for (CompartmentFigText candidate : figs) //1
{ 

//#if -1117591746 
if(candidate.getOwner() == ep)//1
{ 

//#if 1977354064 
epFig = candidate;
//#endif 


//#if 1212019024 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1330183789 
if(epFig == null)//1
{ 

//#if 136590306 
epFig = new CompartmentFigText(ep, new Rectangle(
                                                       xpos,
                                                       ypos + (epCount - 1) * ROWHEIGHT,
                                                       0,
                                                       ROWHEIGHT),
                                                   getSettings());
//#endif 


//#if 862583919 
epFig.setFilled(false);
//#endif 


//#if 178873548 
epFig.setLineWidth(0);
//#endif 


//#if 1412177605 
epFig.setTextColor(getTextColor());
//#endif 


//#if -114032613 
epFig.setJustification(FigText.JUSTIFY_LEFT);
//#endif 


//#if 1068969639 
epFig.setReturnAction(FigText.END_EDITING);
//#endif 


//#if -725311144 
epVec.addFig(epFig);
//#endif 

} 
else
{ 

//#if -1118364466 
toBeRemoved.remove(epFig);
//#endif 

} 

//#endif 


//#if 96554412 
String epText = epFig.getNotationProvider().toString(ep,
                                getNotationSettings());
//#endif 


//#if 1633560354 
if(epText == null)//1
{ 

//#if 798288104 
epText = "";
//#endif 

} 

//#endif 


//#if -2038920408 
epFig.setText(epText);
//#endif 


//#if 887249511 
epCount++;
//#endif 

} 

//#endif 


//#if 869826693 
for (Fig f : toBeRemoved) //1
{ 

//#if 3725286 
epVec.removeFig(f);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -109693377 
setBounds(oldBounds.x, oldBounds.y, oldBounds.width, oldBounds.height);
//#endif 

} 

//#endif 


//#if 182153623 
@Override
    public int getLineWidth()
    { 

//#if -1532994129 
return cover.getLineWidth();
//#endif 

} 

//#endif 


//#if 191368602 
private CompartmentFigText unhighlight()
    { 

//#if -1086723575 
for (CompartmentFigText ft : getEPFigs()) //1
{ 

//#if -43264932 
if(ft.isHighlighted())//1
{ 

//#if 15112130 
ft.setHighlighted(false);
//#endif 


//#if 485060945 
highlightedFigText = null;
//#endif 


//#if 669332129 
return ft;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -61571578 
return null;
//#endif 

} 

//#endif 


//#if -2127984494 
@Override
    public void setLineWidth(int w)
    { 

//#if 1490238851 
if(cover != null)//1
{ 

//#if 1353746924 
cover.setLineWidth(w);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1803207742 
private void positionStereotypes()
    { 

//#if 2037502907 
if(((FigGroup) getStereotypeFig()).getFigCount() > 0)//1
{ 

//#if 978977706 
getStereotypeFig().setBounds(
                (getX() + getWidth() / 2
                 - getStereotypeFig().getWidth() / 2),
                (getY() + bigPort.getHeight() + STEREOTYPE_PADDING),
                getStereotypeFig().getWidth(),
                getStereotypeFig().getHeight());
//#endif 

} 
else
{ 

//#if -377998525 
getStereotypeFig().setBounds(0, 0, 0, 0);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1488574358 
private void setExtensionPointVisibleInternal(boolean visible)
    { 

//#if -1832894736 
Rectangle oldBounds = getBounds();
//#endif 


//#if -1213444644 
for (Fig fig : (List<Fig>) epVec.getFigs()) //1
{ 

//#if -1244582680 
fig.setVisible(visible);
//#endif 

} 

//#endif 


//#if 2107649120 
epVec.setVisible(visible);
//#endif 


//#if 1583741398 
epSep.setVisible(visible);
//#endif 


//#if -1269168914 
setBounds(oldBounds.x, oldBounds.y,
                  oldBounds.width,
                  oldBounds.height);
//#endif 


//#if 430784190 
endTrans();
//#endif 

} 

//#endif 


//#if 1638080543 
@Override
    protected void updateStereotypeText()
    { 

//#if 2098864009 
super.updateStereotypeText();
//#endif 


//#if -917212574 
if(getOwner() == null)//1
{ 

//#if 616007387 
return;
//#endif 

} 

//#endif 


//#if -66513480 
positionStereotypes();
//#endif 


//#if 209642965 
damage();
//#endif 

} 

//#endif 


//#if -1287886548 
protected void updateFigGroupSize(int x, int y, int w,
                                      int h)
    { 

//#if -454742553 
int newW = w;
//#endif 


//#if -1663128842 
int n = epVec.getFigs().size() - 1;
//#endif 


//#if 1861601797 
int newH =
            isCheckSize() ? Math.max(h, ROWHEIGHT * Math.max(1, n) + 2)
            : h;
//#endif 


//#if -531844373 
Iterator figs = epVec.getFigs().iterator();
//#endif 


//#if -1408681548 
figs.next();
//#endif 


//#if -1752229216 
Fig fi;
//#endif 


//#if 324891745 
int fw, fh;
//#endif 


//#if 1136482396 
int yy = y;
//#endif 


//#if 1607345082 
while (figs.hasNext()) //1
{ 

//#if 75420399 
fi = (Fig) figs.next();
//#endif 


//#if -537558730 
fw = fi.getMinimumSize().width;
//#endif 


//#if -1828980092 
fh = fi.getMinimumSize().height;
//#endif 


//#if -440791365 
if(!isCheckSize() && fw > newW - 2)//1
{ 

//#if -814008232 
fw = newW - 2;
//#endif 

} 

//#endif 


//#if 2026899876 
fi.setBounds(x + 1, yy + 1, fw, fh/* - 2*/);
//#endif 


//#if 1246771420 
if(isCheckSize() && newW < fw + 2)//1
{ 

//#if -1049114691 
newW = fw + 2;
//#endif 

} 

//#endif 


//#if -1099442989 
yy += fh;
//#endif 

} 

//#endif 


//#if -59861261 
epBigPort.setBounds(x, y, newW, newH);
//#endif 


//#if 873429439 
epVec.calcBounds();
//#endif 

} 

//#endif 


//#if 1636138535 

//#if 1459471998 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigUseCase(@SuppressWarnings("unused") GraphModel gm, Object node)
    { 

//#if 765558660 
this();
//#endif 


//#if -200978477 
setOwner(node);
//#endif 

} 

//#endif 


//#if 442999967 
public static class FigMyCircle extends 
//#if 1201762817 
FigCircle
//#endif 

  { 

//#if -241155851 
private static final long serialVersionUID = 2616728355472635182L;
//#endif 


//#if 474685902 
@Override
        public Point connectionPoint(Point anotherPt)
        { 

//#if -513050827 
double rx = _w / 2;
//#endif 


//#if 374005989 
double ry = _h / 2;
//#endif 


//#if 1716298523 
double dx = anotherPt.x - (_x + rx);
//#endif 


//#if -489641159 
double dy = anotherPt.y - (_y + ry);
//#endif 


//#if -1384248637 
double dd = ry * ry * dx * dx + rx * rx * dy * dy;
//#endif 


//#if -1562650143 
double mu = rx * ry / Math.sqrt(dd);
//#endif 


//#if -1355131273 
Point res =
                new Point((int) (mu * dx + _x + rx),
                          (int) (mu * dy + _y + ry));
//#endif 


//#if 1646701382 
return res;
//#endif 

} 

//#endif 


//#if -1000567857 
public FigMyCircle(int x, int y, int w, int h)
        { 

//#if 1394678475 
super(x, y, w, h);
//#endif 

} 

//#endif 


//#if 858019693 
public FigMyCircle(int x, int y, int w, int h,
                           Color lColor,
                           Color fColor)
        { 

//#if 348806821 
super(x, y, w, h, lColor, fColor);
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

