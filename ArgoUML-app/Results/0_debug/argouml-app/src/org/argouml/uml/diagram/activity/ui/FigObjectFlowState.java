
//#if 603840439 
// Compilation Unit of /FigObjectFlowState.java 
 

//#if -211076255 
package org.argouml.uml.diagram.activity.ui;
//#endif 


//#if -1954542000 
import java.awt.Color;
//#endif 


//#if 1664435373 
import java.awt.Dimension;
//#endif 


//#if 1650656708 
import java.awt.Rectangle;
//#endif 


//#if -104757324 
import java.awt.event.KeyEvent;
//#endif 


//#if 463516057 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 549306814 
import java.beans.PropertyVetoException;
//#endif 


//#if -2132324519 
import java.util.Collection;
//#endif 


//#if -576567861 
import java.util.HashSet;
//#endif 


//#if 1306951305 
import java.util.Iterator;
//#endif 


//#if 844343709 
import java.util.Set;
//#endif 


//#if 553248496 
import org.argouml.application.events.ArgoEvent;
//#endif 


//#if -1272204568 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if -1197187592 
import org.argouml.model.Model;
//#endif 


//#if 1336357358 
import org.argouml.notation.Notation;
//#endif 


//#if -453376221 
import org.argouml.notation.NotationName;
//#endif 


//#if -728848643 
import org.argouml.notation.NotationProvider;
//#endif 


//#if 1253704053 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if 1342617355 
import org.argouml.notation.NotationSettings;
//#endif 


//#if -47833125 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -661521370 
import org.argouml.uml.diagram.ui.FigNodeModelElement;
//#endif 


//#if 1698481586 
import org.argouml.uml.diagram.ui.FigSingleLineText;
//#endif 


//#if -212715217 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if -1573948080 
import org.tigris.gef.base.Selection;
//#endif 


//#if 1140333860 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 202448879 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1594169451 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if 1596036674 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 69459952 
public class FigObjectFlowState extends 
//#if -859288360 
FigNodeModelElement
//#endif 

  { 

//#if -706535176 
private static final int PADDING = 8;
//#endif 


//#if -215531998 
private static final int WIDTH = 70;
//#endif 


//#if 693956563 
private static final int HEIGHT = 50;
//#endif 


//#if -26970140 
private static final int STATE_HEIGHT = NAME_FIG_HEIGHT;
//#endif 


//#if -525833031 
private NotationProvider notationProviderType;
//#endif 


//#if 845367378 
private NotationProvider notationProviderState;
//#endif 


//#if 522366570 
private FigRect cover;
//#endif 


//#if -1464276647 
private FigText state;
//#endif 


//#if 955551328 
private void updateStateText()
    { 

//#if -1713211504 
if(isReadyToEdit())//1
{ 

//#if 183490541 
state.setText(notationProviderState.toString(getOwner(),
                          getNotationSettings()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1327351988 
@Override
    public Dimension getMinimumSize()
    { 

//#if -462643974 
Dimension tempDim = getNameFig().getMinimumSize();
//#endif 


//#if -1645519062 
int w = tempDim.width + PADDING * 2;
//#endif 


//#if 661382908 
int h = tempDim.height + PADDING;
//#endif 


//#if 1101724751 
tempDim = state.getMinimumSize();
//#endif 


//#if -511418497 
w = Math.max(w, tempDim.width + PADDING * 2);
//#endif 


//#if -393530378 
h = h + PADDING + tempDim.height + PADDING;
//#endif 


//#if -1518541066 
return new Dimension(Math.max(w, WIDTH / 2), Math.max(h, HEIGHT / 2));
//#endif 

} 

//#endif 


//#if 801916060 

//#if 1312029050 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigObjectFlowState()
    { 

//#if 244761257 
state = new FigSingleLineText(X0, Y0, WIDTH, STATE_HEIGHT, true);
//#endif 


//#if 2125035475 
initFigs();
//#endif 


//#if -2030865121 
ArgoEventPump.addListener(ArgoEvent.ANY_NOTATION_EVENT, this);
//#endif 

} 

//#endif 


//#if -2106320264 
@Override
    public int getLineWidth()
    { 

//#if -1587747511 
return cover.getLineWidth();
//#endif 

} 

//#endif 


//#if 1188469802 

//#if -1270425096 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigObjectFlowState(GraphModel gm, Object node)
    { 

//#if 494023375 
this();
//#endif 


//#if 1568639006 
setOwner(node);
//#endif 


//#if 880722333 
enableSizeChecking(true);
//#endif 

} 

//#endif 


//#if -1438192417 
@Override
    protected void textEditStarted(FigText ft)
    { 

//#if -1511164169 
if(ft == getNameFig())//1
{ 

//#if -844274900 
showHelp(notationProviderType.getParsingHelp());
//#endif 

} 

//#endif 


//#if -341117426 
if(ft == state)//1
{ 

//#if 1425097063 
showHelp(notationProviderState.getParsingHelp());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1799645718 
@Override
    public void setFillColor(Color col)
    { 

//#if 562406727 
cover.setFillColor(col);
//#endif 

} 

//#endif 


//#if -606996074 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 

//#if 318530875 
Rectangle oldBounds = getBounds();
//#endif 


//#if -1991595262 
Dimension classDim = getNameFig().getMinimumSize();
//#endif 


//#if -1988845536 
Dimension stateDim = state.getMinimumSize();
//#endif 


//#if -654173488 
int blank = (h - PADDING - classDim.height - stateDim.height) / 2;
//#endif 


//#if -1208808161 
getNameFig().setBounds(x + PADDING,
                               y + blank,
                               w - PADDING * 2,
                               classDim.height);
//#endif 


//#if 809734013 
state.setBounds(x + PADDING,
                        y + blank + classDim.height + PADDING,
                        w - PADDING * 2,
                        stateDim.height);
//#endif 


//#if -1041753105 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if 858663858 
cover.setBounds(x, y, w, h);
//#endif 


//#if -1275139700 
calcBounds();
//#endif 


//#if -1531076399 
updateEdges();
//#endif 


//#if 520564104 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if -1282276609 
@Override
    public void keyTyped(KeyEvent ke)
    { 

//#if -1037818547 
if(!isReadyToEdit())//1
{ 

//#if 508189448 
if(Model.getFacade().isAModelElement(getOwner()))//1
{ 

//#if 2137897183 
updateClassifierText();
//#endif 


//#if 1174629929 
updateStateText();
//#endif 


//#if -625659458 
setReadyToEdit(true);
//#endif 

} 
else
{ 

//#if 2058618326 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1942657773 
if(ke.isConsumed() || getOwner() == null)//1
{ 

//#if -1472651591 
return;
//#endif 

} 

//#endif 


//#if 2096117795 
getNameFig().keyTyped(ke);
//#endif 

} 

//#endif 


//#if 1748795985 
@Override
    public void renderingChanged()
    { 

//#if -145983607 
super.renderingChanged();
//#endif 


//#if 17835277 
updateClassifierText();
//#endif 


//#if -1222795973 
updateStateText();
//#endif 


//#if 1733136614 
updateBounds();
//#endif 


//#if 389052469 
damage();
//#endif 

} 

//#endif 


//#if 917259345 
@Override
    public void setLineWidth(int w)
    { 

//#if -1735542789 
cover.setLineWidth(w);
//#endif 

} 

//#endif 


//#if -951236210 
private void updateClassifierText()
    { 

//#if 832502998 
if(isReadyToEdit())//1
{ 

//#if 332768117 
if(notationProviderType != null)//1
{ 

//#if -238519986 
getNameFig().setText(
                    notationProviderType.toString(getOwner(),
                                                  getNotationSettings()));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -586118311 
@Override
    public void setLineColor(Color col)
    { 

//#if 203219289 
cover.setLineColor(col);
//#endif 

} 

//#endif 


//#if 442992289 
@Override
    public boolean isFilled()
    { 

//#if -517827676 
return cover.isFilled();
//#endif 

} 

//#endif 


//#if 1772263182 
public FigObjectFlowState(Object owner, Rectangle bounds,
                              DiagramSettings settings)
    { 

//#if -1744103391 
super(owner, bounds, settings);
//#endif 


//#if -301869164 
state = new FigSingleLineText(owner, new Rectangle(X0, Y0, WIDTH,
                                      STATE_HEIGHT), settings, true);
//#endif 


//#if -477075658 
initFigs();
//#endif 

} 

//#endif 


//#if 1948093215 
@Override
    public void setFilled(boolean f)
    { 

//#if 1782207544 
cover.setFilled(f);
//#endif 

} 

//#endif 


//#if -1837719201 
@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 

//#if 192905934 
Set<Object[]> l = new HashSet<Object[]>();
//#endif 


//#if -917440020 
if(newOwner != null)//1
{ 

//#if 1016334470 
l.add(new Object[] {newOwner, new String[] {"type", "remove"}});
//#endif 


//#if 294557843 
Object type = Model.getFacade().getType(newOwner);
//#endif 


//#if -1527310486 
if(Model.getFacade().isAClassifier(type))//1
{ 

//#if 1898868578 
if(Model.getFacade().isAClassifierInState(type))//1
{ 

//#if -2055752004 
Object classifier = Model.getFacade().getType(type);
//#endif 


//#if -2109409511 
l.add(new Object[] {classifier, "name"});
//#endif 


//#if -569705249 
l.add(new Object[] {type, "inState"});
//#endif 


//#if -1981519537 
Collection states = Model.getFacade().getInStates(type);
//#endif 


//#if 411233353 
Iterator i = states.iterator();
//#endif 


//#if 488734099 
while (i.hasNext()) //1
{ 

//#if -1535344188 
l.add(new Object[] {i.next(), "name"});
//#endif 

} 

//#endif 

} 
else
{ 

//#if 593861295 
l.add(new Object[] {type, "name"});
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -116735009 
updateElementListeners(l);
//#endif 

} 

//#endif 


//#if 1182528954 
@Override
    public Color getFillColor()
    { 

//#if -2083939346 
return cover.getFillColor();
//#endif 

} 

//#endif 


//#if -1510385423 
@Override
    protected void initNotationProviders(Object own)
    { 

//#if 1234886622 
super.initNotationProviders(own);
//#endif 


//#if 940627303 
if(Model.getFacade().isAModelElement(own))//1
{ 

//#if -1985756959 
NotationName notationName = Notation
                                        .findNotation(getNotationSettings().getNotationLanguage());
//#endif 


//#if 420439826 
notationProviderType =
                NotationProviderFactory2.getInstance().getNotationProvider(
                    NotationProviderFactory2.TYPE_OBJECTFLOWSTATE_TYPE,
                    own, notationName);
//#endif 


//#if 868400014 
notationProviderState =
                NotationProviderFactory2.getInstance().getNotationProvider(
                    NotationProviderFactory2.TYPE_OBJECTFLOWSTATE_STATE,
                    own, notationName);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1662409480 
@Override
    public void setEnclosingFig(Fig encloser)
    { 

//#if -669263880 
LayerPerspective layer = (LayerPerspective) getLayer();
//#endif 


//#if 1136662735 
if(layer == null)//1
{ 

//#if 356034599 
return;
//#endif 

} 

//#endif 


//#if -173306832 
super.setEnclosingFig(encloser);
//#endif 

} 

//#endif 


//#if -749897602 
@Override
    protected void textEdited(FigText ft) throws PropertyVetoException
    { 

//#if -2014793764 
if(ft == getNameFig())//1
{ 

//#if 722545079 
notationProviderType.parse(getOwner(), ft.getText());
//#endif 


//#if -1916322266 
ft.setText(notationProviderType.toString(getOwner(),
                       NotationSettings.getDefaultSettings()));
//#endif 

} 
else

//#if -1086672462 
if(ft == state)//1
{ 

//#if -1740390680 
notationProviderState.parse(getOwner(), ft.getText());
//#endif 


//#if -1195840537 
ft.setText(notationProviderState.toString(getOwner(),
                       NotationSettings.getDefaultSettings()));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -148283349 
@Override
    public Object clone()
    { 

//#if -1848737686 
FigObjectFlowState figClone = (FigObjectFlowState) super.clone();
//#endif 


//#if 2146286120 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if 1334717567 
figClone.setBigPort((FigRect) it.next());
//#endif 


//#if -1974336163 
figClone.cover = (FigRect) it.next();
//#endif 


//#if 795658608 
figClone.setNameFig((FigText) it.next());
//#endif 


//#if 634708558 
figClone.state = (FigText) it.next();
//#endif 


//#if 185919943 
return figClone;
//#endif 

} 

//#endif 


//#if 1325239755 
@Override
    protected void modelChanged(PropertyChangeEvent mee)
    { 

//#if -817687028 
super.modelChanged(mee);
//#endif 


//#if -263350181 
renderingChanged();
//#endif 


//#if 846321397 
updateListeners(getOwner(), getOwner());
//#endif 

} 

//#endif 


//#if 356043305 
@Override
    public Color getLineColor()
    { 

//#if 548528810 
return cover.getLineColor();
//#endif 

} 

//#endif 


//#if 1593163015 
@Override
    public Selection makeSelection()
    { 

//#if 2024602756 
return new SelectionActionState(this);
//#endif 

} 

//#endif 


//#if 861504150 
private void initFigs()
    { 

//#if -364244721 
setBigPort(new FigRect(X0, Y0, WIDTH, HEIGHT,
                               DEBUG_COLOR, DEBUG_COLOR));
//#endif 


//#if 1580648600 
cover =
            new FigRect(X0, Y0, WIDTH, HEIGHT,
                        LINE_COLOR, FILL_COLOR);
//#endif 


//#if 205229861 
getNameFig().setUnderline(true);
//#endif 


//#if 1683916803 
getNameFig().setLineWidth(0);
//#endif 


//#if -1088216654 
addFig(getBigPort());
//#endif 


//#if -14716459 
addFig(cover);
//#endif 


//#if -1917782646 
addFig(getNameFig());
//#endif 


//#if 1424626735 
addFig(state);
//#endif 


//#if -688125380 
enableSizeChecking(false);
//#endif 


//#if -529350268 
setReadyToEdit(false);
//#endif 


//#if -1808293288 
Rectangle r = getBounds();
//#endif 


//#if -1201938312 
setBounds(r.x, r.y, r.width, r.height);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

