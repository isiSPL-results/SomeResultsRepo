
//#if -739726584 
// Compilation Unit of /FigStubState.java 
 

//#if -1857596200 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if 73975337 
import java.awt.Color;
//#endif 


//#if -1380314437 
import java.awt.Font;
//#endif 


//#if 1175071005 
import java.awt.Rectangle;
//#endif 


//#if -1841784974 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 831365602 
import java.util.Iterator;
//#endif 


//#if -390381876 
import org.apache.log4j.Logger;
//#endif 


//#if -97295244 
import org.argouml.model.Facade;
//#endif 


//#if 1457154623 
import org.argouml.model.Model;
//#endif 


//#if 80295965 
import org.argouml.model.StateMachinesHelper;
//#endif 


//#if -991904222 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 769353255 
import org.argouml.uml.diagram.ui.SelectionMoveClarifiers;
//#endif 


//#if -1232670633 
import org.tigris.gef.base.Selection;
//#endif 


//#if -1604521365 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -1500684766 
import org.tigris.gef.presentation.FigLine;
//#endif 


//#if -1495272910 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if -1493405687 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if -2143175800 
public class FigStubState extends 
//#if -587827835 
FigStateVertex
//#endif 

  { 

//#if 893962361 
private static final Logger LOG = Logger.getLogger(FigStubState.class);
//#endif 


//#if 985329446 
private static final int X = 0;
//#endif 


//#if 985359237 
private static final int Y = 0;
//#endif 


//#if 463285613 
private static final int WIDTH = 45;
//#endif 


//#if 262547709 
private static final int HEIGHT = 20;
//#endif 


//#if 1642930976 
private FigText referenceFig;
//#endif 


//#if 457330544 
private FigLine stubline;
//#endif 


//#if -1118836808 
private Facade facade;
//#endif 


//#if 1149074837 
private StateMachinesHelper stateMHelper;
//#endif 


//#if -1151297656 

//#if 1736888869 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigStubState()
    { 

//#if -309058730 
super();
//#endif 


//#if 775564324 
initFigs();
//#endif 

} 

//#endif 


//#if 1626663814 
@Override
    public void setLineColor(Color col)
    { 

//#if -573611956 
stubline.setLineColor(col);
//#endif 

} 

//#endif 


//#if -2064186788 
public FigStubState(Object owner, Rectangle bounds,
                        DiagramSettings settings)
    { 

//#if -1504755874 
super(owner, bounds, settings);
//#endif 


//#if -1616522317 
initFigs();
//#endif 

} 

//#endif 


//#if -290603475 
@Override
    public Color getFillColor()
    { 

//#if -1515858379 
return referenceFig.getFillColor();
//#endif 

} 

//#endif 


//#if 2024487646 
@Override
    public Object clone()
    { 

//#if 254150901 
FigStubState figClone = (FigStubState) super.clone();
//#endif 


//#if -1713613391 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if -452363306 
figClone.setBigPort((FigRect) it.next());
//#endif 


//#if 1760309267 
figClone.referenceFig = (FigText) it.next();
//#endif 


//#if -837436715 
figClone.stubline = (FigLine) it.next();
//#endif 


//#if -1543086448 
return figClone;
//#endif 

} 

//#endif 


//#if 413136407 
@Override
    public void setFillColor(Color col)
    { 

//#if -779963896 
referenceFig.setFillColor(col);
//#endif 

} 

//#endif 


//#if -45690924 
@Override
    public boolean isFilled()
    { 

//#if -1353008229 
return referenceFig.isFilled();
//#endif 

} 

//#endif 


//#if 786273475 
@Override
    protected void updateFont()
    { 

//#if 1452829317 
super.updateFont();
//#endif 


//#if 45043684 
Font f = getSettings().getFont(Font.PLAIN);
//#endif 


//#if 953078326 
referenceFig.setFont(f);
//#endif 

} 

//#endif 


//#if 1636434174 
@Override
    public void renderingChanged()
    { 

//#if -2135228592 
super.renderingChanged();
//#endif 


//#if -353154214 
updateReferenceText();
//#endif 

} 

//#endif 


//#if -449366337 
public void updateReferenceText()
    { 

//#if 1248604141 
Object text = null;
//#endif 


//#if -1372453472 
try //1
{ 

//#if -1502522626 
text = facade.getReferenceState(getOwner());
//#endif 

} 

//#if -1928833326 
catch (Exception e) //1
{ 

//#if -1810624747 
LOG.error("Exception caught and ignored!!", e);
//#endif 

} 

//#endif 


//#endif 


//#if -677230855 
if(text != null)//1
{ 

//#if 118482205 
referenceFig.setText((String) text);
//#endif 

} 
else
{ 

//#if -2073242780 
referenceFig.setText("");
//#endif 

} 

//#endif 


//#if 1983526790 
calcBounds();
//#endif 


//#if 1965416131 
setBounds(getBounds());
//#endif 


//#if 43423329 
damage();
//#endif 

} 

//#endif 


//#if 1075317977 
protected void updateListenersX(Object newOwner, Object oldV)
    { 

//#if -30665471 
updateListeners(oldV, newOwner);
//#endif 

} 

//#endif 


//#if 987645044 
@Override
    public Selection makeSelection()
    { 

//#if -1432471900 
return new SelectionMoveClarifiers(this);
//#endif 

} 

//#endif 


//#if 55575472 
private void addListeners(Object newOwner)
    { 

//#if -1229524281 
Object container;
//#endif 


//#if -822473165 
Object top;
//#endif 


//#if 10180925 
Object reference;
//#endif 


//#if 1845096120 
container = facade.getContainer(newOwner);
//#endif 


//#if -992650856 
if(container != null
                && facade.isASubmachineState(container))//1
{ 

//#if -374202643 
addElementListener(container);
//#endif 

} 

//#endif 


//#if 902331106 
if(container != null
                && facade.isASubmachineState(container)
                && facade.getSubmachine(container) != null)//1
{ 

//#if -2059756401 
top = facade.getTop(facade.getSubmachine(container));
//#endif 


//#if 1727175959 
reference = stateMHelper.getStatebyName(facade
                                                    .getReferenceState(newOwner), top);
//#endif 


//#if 896888507 
String[] properties = {"name", "container"};
//#endif 


//#if -1656803687 
container = reference;
//#endif 


//#if -178540969 
while (container != null
                    && !container.equals(top)) //1
{ 

//#if 1991349520 
addElementListener(container);
//#endif 


//#if 645399800 
container = facade.getContainer(container);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1911210431 
@Deprecated
    public FigStubState(@SuppressWarnings("unused") GraphModel gm,
                        Object node)
    { 

//#if 1989673214 
this();
//#endif 


//#if 193443661 
setOwner(node);
//#endif 

} 

//#endif 


//#if -435698330 
@Override
    public void setOwner(Object node)
    { 

//#if 843295370 
super.setOwner(node);
//#endif 


//#if -1585623292 
renderingChanged();
//#endif 

} 

//#endif 


//#if 1644346435 
@Override
    protected void setStandardBounds(int theX, int theY, int theW, int theH)
    { 

//#if 872326155 
Rectangle oldBounds = getBounds();
//#endif 


//#if 1242812478 
theW = 60;
//#endif 


//#if 118214043 
referenceFig.setBounds(theX, theY, theW,
                               referenceFig.getBounds().height);
//#endif 


//#if -665148596 
stubline.setShape(theX, theY,
                          theX + theW, theY);
//#endif 


//#if 722030609 
getBigPort().setBounds(theX, theY, theW, theH);
//#endif 


//#if -2113782692 
calcBounds();
//#endif 


//#if -1759205375 
updateEdges();
//#endif 


//#if -1445868456 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if 1699963819 
@Override
    public int getLineWidth()
    { 

//#if -967343637 
return stubline.getLineWidth();
//#endif 

} 

//#endif 


//#if 804897534 
@Override
    public void setLineWidth(int w)
    { 

//#if -642536074 
stubline.setLineWidth(w);
//#endif 

} 

//#endif 


//#if 2127849241 
private void removeListeners()
    { 

//#if 645944641 
Object container;
//#endif 


//#if -1607117779 
Object top;
//#endif 


//#if 1885649847 
Object reference;
//#endif 


//#if 1453443020 
Object owner = getOwner();
//#endif 


//#if 433165023 
if(owner == null)//1
{ 

//#if 95555419 
return;
//#endif 

} 

//#endif 


//#if -256761736 
container = facade.getContainer(owner);
//#endif 


//#if -1506775790 
if(container != null
                && facade.isASubmachineState(container))//1
{ 

//#if -794678331 
removeElementListener(container);
//#endif 

} 

//#endif 


//#if -1858940376 
if(container != null
                && facade.isASubmachineState(container)
                && facade.getSubmachine(container) != null)//1
{ 

//#if -664078763 
top = facade.getTop(facade.getSubmachine(container));
//#endif 


//#if -19899887 
reference = stateMHelper.getStatebyName(facade
                                                    .getReferenceState(owner), top);
//#endif 


//#if -1644465806 
if(reference != null)//1
{ 

//#if -811941917 
removeElementListener(reference);
//#endif 


//#if 1920776698 
container = facade.getContainer(reference);
//#endif 


//#if 1576108559 
while (container != null && !facade.isTop(container)) //1
{ 

//#if -1151461394 
removeElementListener(container);
//#endif 


//#if 1362685189 
container = facade.getContainer(container);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -771101378 
@Override
    protected void modelChanged(PropertyChangeEvent mee)
    { 

//#if -356383285 
super.modelChanged(mee);
//#endif 


//#if -1115720702 
if(getOwner() == null)//1
{ 

//#if 1919670796 
return;
//#endif 

} 

//#endif 


//#if 48596215 
Object top = null;
//#endif 


//#if -737272936 
Object oldRef = null;
//#endif 


//#if -334443606 
Object container = facade.getContainer(getOwner());
//#endif 


//#if -1262125729 
if((mee.getSource().equals(getOwner())))//1
{ 

//#if -1467453441 
if(mee.getPropertyName().equals("referenceState"))//1
{ 

//#if 844304245 
updateReferenceText();
//#endif 


//#if 1020461286 
if(container != null && facade.isASubmachineState(container)
                        && facade.getSubmachine(container) != null)//1
{ 

//#if -1581168320 
top = facade.getTop(facade.getSubmachine(container));
//#endif 


//#if -1844556689 
oldRef = stateMHelper.getStatebyName(
                                 (String) mee.getOldValue(), top);
//#endif 

} 

//#endif 


//#if -1980665484 
updateListeners(oldRef, getOwner());
//#endif 

} 
else

//#if -1662032546 
if((mee.getPropertyName().equals("container")
                        && facade.isASubmachineState(container)))//1
{ 

//#if -1450038464 
removeListeners();
//#endif 


//#if -497690743 
Object o = mee.getOldValue();
//#endif 


//#if 361052843 
if(o != null && facade.isASubmachineState(o))//1
{ 

//#if -2071386983 
removeElementListener(o);
//#endif 

} 

//#endif 


//#if 778359908 
stateMHelper.setReferenceState(getOwner(), null);
//#endif 


//#if -205472853 
updateListeners(getOwner(), getOwner());
//#endif 


//#if 1960350604 
updateReferenceText();
//#endif 

} 

//#endif 


//#endif 

} 
else
{ 

//#if -1719036323 
if(container != null
                    && mee.getSource().equals(container)
                    && facade.isASubmachineState(container)
                    && facade.getSubmachine(container) != null)//1
{ 

//#if -1249975095 
if(mee.getPropertyName().equals("submachine"))//1
{ 

//#if 1458369604 
if(mee.getOldValue() != null)//1
{ 

//#if -1268423290 
top = facade.getTop(mee.getOldValue());
//#endif 


//#if -195364945 
oldRef = stateMHelper.getStatebyName(facade
                                                             .getReferenceState(getOwner()), top);
//#endif 

} 

//#endif 


//#if 1682692519 
stateMHelper.setReferenceState(getOwner(), null);
//#endif 


//#if -346409830 
updateListeners(oldRef, getOwner());
//#endif 


//#if -227662193 
updateReferenceText();
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1186351711 
if(facade.getSubmachine(container) != null)//1
{ 

//#if -595597783 
top = facade.getTop(facade.getSubmachine(container));
//#endif 

} 

//#endif 


//#if -1819093149 
String path = facade.getReferenceState(getOwner());
//#endif 


//#if 1423766603 
Object refObject = stateMHelper.getStatebyName(path, top);
//#endif 


//#if -930428301 
String ref;
//#endif 


//#if 183696272 
if(refObject == null)//1
{ 

//#if 1375627374 
ref = stateMHelper.getPath(mee.getSource());
//#endif 

} 
else
{ 

//#if 491249527 
ref = stateMHelper.getPath(refObject);
//#endif 

} 

//#endif 


//#if -300137471 
stateMHelper.setReferenceState(getOwner(), ref);
//#endif 


//#if -771984923 
updateReferenceText();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1535122926 
@Override
    public void setFilled(boolean f)
    { 

//#if 272772778 
referenceFig.setFilled(f);
//#endif 

} 

//#endif 


//#if -1117089124 
@Override
    public Color getLineColor()
    { 

//#if 660695230 
return stubline.getLineColor();
//#endif 

} 

//#endif 


//#if 1750526299 
@Override
    public boolean isResizable()
    { 

//#if 1202588538 
return false;
//#endif 

} 

//#endif 


//#if 768342851 
private void initFigs()
    { 

//#if 513290202 
facade = Model.getFacade();
//#endif 


//#if -1679893083 
stateMHelper = Model.getStateMachinesHelper();
//#endif 


//#if 1629937688 
setBigPort(new FigRect(X, Y, WIDTH, HEIGHT));
//#endif 


//#if -301140652 
getBigPort().setLineWidth(0);
//#endif 


//#if -1132954393 
getBigPort().setFilled(false);
//#endif 


//#if 686327568 
stubline = new FigLine(X,
                               Y,
                               WIDTH,
                               Y,
                               TEXT_COLOR);
//#endif 


//#if -592605668 
referenceFig = new FigText(0, 0, WIDTH, HEIGHT, true);
//#endif 


//#if -754769216 
referenceFig.setFont(getSettings().getFontPlain());
//#endif 


//#if -1935549382 
referenceFig.setTextColor(TEXT_COLOR);
//#endif 


//#if -241073556 
referenceFig.setReturnAction(FigText.END_EDITING);
//#endif 


//#if 1684810919 
referenceFig.setTabAction(FigText.END_EDITING);
//#endif 


//#if 744396206 
referenceFig.setJustification(FigText.JUSTIFY_CENTER);
//#endif 


//#if 1958518759 
referenceFig.setLineWidth(0);
//#endif 


//#if -924329547 
referenceFig.setBounds(X, Y,
                               WIDTH, referenceFig.getBounds().height);
//#endif 


//#if 197010612 
referenceFig.setFilled(false);
//#endif 


//#if -899768714 
referenceFig.setEditable(false);
//#endif 


//#if -249226965 
addFig(getBigPort());
//#endif 


//#if -1673135368 
addFig(referenceFig);
//#endif 


//#if 2114795553 
addFig(stubline);
//#endif 


//#if -1811045083 
setShadowSize(0);
//#endif 


//#if -1007819859 
setBlinkPorts(false);
//#endif 

} 

//#endif 


//#if -332312875 
@Override
    protected void updateListeners(Object oldV, Object newOwner)
    { 

//#if 1228310183 
if(oldV != null)//1
{ 

//#if -291135480 
if(oldV != newOwner)//1
{ 

//#if 405252490 
removeElementListener(oldV);
//#endif 

} 

//#endif 


//#if -1853075922 
Object container = facade.getContainer(oldV);
//#endif 


//#if 1690765252 
while (container != null && !facade.isTop(container)) //1
{ 

//#if 1255853168 
removeElementListener(container);
//#endif 


//#if 226623367 
container = facade.getContainer(container);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 221520208 
super.updateListeners(getOwner(), newOwner);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

