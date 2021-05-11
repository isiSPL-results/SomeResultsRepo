
//#if -2075951351 
// Compilation Unit of /FigActionState.java 
 

//#if -604392099 
package org.argouml.uml.diagram.activity.ui;
//#endif 


//#if -1278857908 
import java.awt.Color;
//#endif 


//#if -1390705239 
import java.awt.Dimension;
//#endif 


//#if -1404483904 
import java.awt.Rectangle;
//#endif 


//#if 1193367701 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 1857067450 
import java.beans.PropertyVetoException;
//#endif 


//#if -1748189307 
import java.util.Iterator;
//#endif 


//#if -1169173 
import org.argouml.model.AddAssociationEvent;
//#endif 


//#if -1931836445 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if -1834263940 
import org.argouml.model.Model;
//#endif 


//#if -164119694 
import org.argouml.notation.Notation;
//#endif 


//#if 1432497831 
import org.argouml.notation.NotationName;
//#endif 


//#if -36737919 
import org.argouml.notation.NotationProvider;
//#endif 


//#if 1353646841 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if -649358241 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1068601799 
import org.argouml.uml.diagram.state.ui.FigStateVertex;
//#endif 


//#if -555131590 
import org.argouml.uml.diagram.ui.FigMultiLineTextWithBold;
//#endif 


//#if -2004068952 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 1763795053 
import org.tigris.gef.presentation.FigRRect;
//#endif 


//#if 1444801734 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 756738915 
public class FigActionState extends 
//#if 1241590826 
FigStateVertex
//#endif 

  { 

//#if -2136673901 
private static final int HEIGHT = 25;
//#endif 


//#if -170030418 
private static final int STATE_WIDTH = 90;
//#endif 


//#if 757804384 
private static final int PADDING = 8;
//#endif 


//#if 217726688 
private FigRRect cover;
//#endif 


//#if 131430763 
private NotationProvider notationProvider;
//#endif 


//#if -450561922 
private static final long serialVersionUID = -3526461404860044420L;
//#endif 


//#if -1488109486 
@Override
    public void setFillColor(Color col)
    { 

//#if 1413109223 
cover.setFillColor(col);
//#endif 

} 

//#endif 


//#if -538473226 
@Override
    public void removeFromDiagramImpl()
    { 

//#if -1614895534 
if(notationProvider != null)//1
{ 

//#if 894423243 
notationProvider.cleanListener(this, getOwner());
//#endif 

} 

//#endif 


//#if -1451742273 
super.removeFromDiagramImpl();
//#endif 

} 

//#endif 


//#if 98944607 
public FigActionState(Object owner, Rectangle bounds,
                          DiagramSettings settings)
    { 

//#if -906006618 
super(owner, bounds, settings);
//#endif 


//#if -1833851889 
initializeActionState();
//#endif 

} 

//#endif 


//#if 1274609763 
@Override
    protected void modelChanged(PropertyChangeEvent mee)
    { 

//#if -1071778737 
super.modelChanged(mee);
//#endif 


//#if 1471016509 
if(mee instanceof AddAssociationEvent
                || mee instanceof AttributeChangeEvent)//1
{ 

//#if -656941788 
renderingChanged();
//#endif 


//#if 1618608161 
notationProvider.updateListener(this, getOwner(), mee);
//#endif 


//#if -669724323 
damage();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 513049793 
@Override
    public Color getLineColor()
    { 

//#if -390699222 
return cover.getLineColor();
//#endif 

} 

//#endif 


//#if -1178755100 
@Override
    public Dimension getMinimumSize()
    { 

//#if -462240042 
Dimension stereoDim = getStereotypeFig().getMinimumSize();
//#endif 


//#if 125142896 
Dimension nameDim = getNameFig().getMinimumSize();
//#endif 


//#if 1260993203 
int w = Math.max(stereoDim.width, nameDim.width) + PADDING * 2;
//#endif 


//#if 1020254099 
int h = stereoDim.height - 2 + nameDim.height + PADDING;
//#endif 


//#if 1607650465 
w = Math.max(w, h + 44);
//#endif 


//#if -2000168576 
return new Dimension(w, h);
//#endif 

} 

//#endif 


//#if 645515030 
@Override
    protected void textEdited(FigText ft) throws PropertyVetoException
    { 

//#if 2036117361 
notationProvider.parse(getOwner(), ft.getText());
//#endif 


//#if -1409679088 
ft.setText(notationProvider.toString(getOwner(),
                                             getNotationSettings()));
//#endif 

} 

//#endif 


//#if 2111585655 
@Override
    protected void textEditStarted(FigText ft)
    { 

//#if -1495495414 
if(ft == getNameFig())//1
{ 

//#if -1726387737 
showHelp(notationProvider.getParsingHelp());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1339535442 
@Override
    public Color getFillColor()
    { 

//#if 169433647 
return cover.getFillColor();
//#endif 

} 

//#endif 


//#if -1653982793 
@Override
    public void setFilled(boolean f)
    { 

//#if 338060058 
cover.setFilled(f);
//#endif 

} 

//#endif 


//#if 285595529 
@Override
    protected void initNotationProviders(Object own)
    { 

//#if -452464679 
if(notationProvider != null)//1
{ 

//#if 1274969578 
notationProvider.cleanListener(this, own);
//#endif 

} 

//#endif 


//#if -585618307 
super.initNotationProviders(own);
//#endif 


//#if 18919805 
NotationName notationName = Notation.findNotation(getNotationSettings()
                                    .getNotationLanguage());
//#endif 


//#if -820963566 
if(Model.getFacade().isAActionState(own))//1
{ 

//#if 1088697666 
notationProvider =
                NotationProviderFactory2.getInstance().getNotationProvider(
                    getNotationProviderType(), own, this, notationName);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1407121607 
@Override
    public boolean isFilled()
    { 

//#if -347375132 
return cover.isFilled();
//#endif 

} 

//#endif 


//#if -1791351630 

//#if -72768572 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigActionState(@SuppressWarnings("unused") GraphModel gm,
                          Object node)
    { 

//#if 655296215 
setOwner(node);
//#endif 


//#if 1588426787 
initializeActionState();
//#endif 

} 

//#endif 


//#if 1078158009 
@Override
    public void setLineWidth(int w)
    { 

//#if -1286900855 
cover.setLineWidth(w);
//#endif 

} 

//#endif 


//#if 1185508667 

//#if -424925012 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigActionState()
    { 

//#if 649533579 
initializeActionState();
//#endif 

} 

//#endif 


//#if 338533136 
@Override
    public int getLineWidth()
    { 

//#if 959649247 
return cover.getLineWidth();
//#endif 

} 

//#endif 


//#if -1324122960 
@Override
    protected int getNotationProviderType()
    { 

//#if -1150804435 
return NotationProviderFactory2.TYPE_ACTIONSTATE;
//#endif 

} 

//#endif 


//#if 1306642350 
private void initializeActionState()
    { 

//#if 378434876 
setBigPort(new FigRRect(X0 + 1, Y0 + 1, STATE_WIDTH - 2, HEIGHT - 2,
                                DEBUG_COLOR, DEBUG_COLOR));
//#endif 


//#if -87023226 
((FigRRect) getBigPort()).setCornerRadius(getBigPort().getHeight() / 2);
//#endif 


//#if 1597582763 
cover = new FigRRect(X0, Y0, STATE_WIDTH, HEIGHT,
                             LINE_COLOR, FILL_COLOR);
//#endif 


//#if -920235989 
cover.setCornerRadius(getHeight() / 2);
//#endif 


//#if -1194713482 
Rectangle bounds = new Rectangle(X0 + PADDING, Y0,
                                         STATE_WIDTH - PADDING * 2, HEIGHT);
//#endif 


//#if 315480652 
setNameFig(new FigMultiLineTextWithBold(
                       getOwner(),
                       bounds,
                       getSettings(),
                       true));
//#endif 


//#if 1009956794 
getNameFig().setText(placeString());
//#endif 


//#if -1427852852 
getNameFig().setBotMargin(7);
//#endif 


//#if 478698458 
getNameFig().setTopMargin(7);
//#endif 


//#if 1969897246 
getNameFig().setRightMargin(4);
//#endif 


//#if -1874780003 
getNameFig().setLeftMargin(4);
//#endif 


//#if -283235053 
getNameFig().setJustification(FigText.JUSTIFY_CENTER);
//#endif 


//#if 113346490 
getBigPort().setLineWidth(0);
//#endif 


//#if 946696593 
addFig(getBigPort());
//#endif 


//#if -1805144362 
addFig(cover);
//#endif 


//#if -1155462878 
addFig(getStereotypeFig());
//#endif 


//#if 117130601 
addFig(getNameFig());
//#endif 


//#if -466782601 
Rectangle r = getBounds();
//#endif 


//#if -1017514311 
setBounds(r.x, r.y, r.width, r.height);
//#endif 

} 

//#endif 


//#if 875228355 
@Override
    public Object clone()
    { 

//#if 195550513 
FigActionState figClone = (FigActionState) super.clone();
//#endif 


//#if 484304157 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if 1128639536 
figClone.setBigPort((FigRRect) it.next());
//#endif 


//#if -869556840 
figClone.cover = (FigRRect) it.next();
//#endif 


//#if 1157688283 
figClone.setNameFig((FigText) it.next());
//#endif 


//#if 1727421692 
return figClone;
//#endif 

} 

//#endif 


//#if -274582079 
@Override
    public void setLineColor(Color col)
    { 

//#if -986923076 
cover.setLineColor(col);
//#endif 

} 

//#endif 


//#if -178018639 
@Override
    protected void updateNameText()
    { 

//#if -590154790 
if(notationProvider != null)//1
{ 

//#if 1184939451 
getNameFig().setText(notationProvider.toString(getOwner(),
                                 getNotationSettings()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1209148392 
@Override
    protected void updateStereotypeText()
    { 

//#if -1263210288 
getStereotypeFig().setOwner(getOwner());
//#endif 

} 

//#endif 


//#if -2017778130 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 

//#if 394396687 
if(getNameFig() == null)//1
{ 

//#if -2125206583 
return;
//#endif 

} 

//#endif 


//#if -1954146416 
Rectangle oldBounds = getBounds();
//#endif 


//#if 1703559188 
Dimension stereoDim = getStereotypeFig().getMinimumSize();
//#endif 


//#if 2105613998 
Dimension nameDim = getNameFig().getMinimumSize();
//#endif 


//#if 53348782 
getNameFig().setBounds(x + PADDING, y + stereoDim.height,
                               w - PADDING * 2, nameDim.height);
//#endif 


//#if 1937866740 
getStereotypeFig().setBounds(x + PADDING, y,
                                     w - PADDING * 2, stereoDim.height);
//#endif 


//#if 1919083792 
getBigPort().setBounds(x + 1, y + 1, w - 2, h - 2);
//#endif 


//#if -131235385 
cover.setBounds(x, y, w, h);
//#endif 


//#if -772591838 
((FigRRect) getBigPort()).setCornerRadius(h);
//#endif 


//#if 1343176181 
cover.setCornerRadius(h);
//#endif 


//#if -614009055 
calcBounds();
//#endif 


//#if 1784104412 
updateEdges();
//#endif 


//#if 1246991837 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

