
//#if 1923156439 
// Compilation Unit of /FigState.java 
 

//#if -2007765405 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if -1879269434 
import java.awt.Font;
//#endif 


//#if 723323634 
import java.awt.Rectangle;
//#endif 


//#if 134635975 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -1971839380 
import java.beans.PropertyVetoException;
//#endif 


//#if 2015687546 
import org.argouml.model.AssociationChangeEvent;
//#endif 


//#if -167494891 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if 719611274 
import org.argouml.model.Model;
//#endif 


//#if -1999387648 
import org.argouml.notation.Notation;
//#endif 


//#if -1299496907 
import org.argouml.notation.NotationName;
//#endif 


//#if -1780938993 
import org.argouml.notation.NotationProvider;
//#endif 


//#if 947138439 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if -1789344915 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -465014090 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -1756152801 
import org.tigris.gef.presentation.FigRRect;
//#endif 


//#if 222876372 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 1378040009 
public abstract class FigState extends 
//#if -2024410783 
FigStateVertex
//#endif 

  { 

//#if -1082103375 
protected static final int SPACE_TOP = 0;
//#endif 


//#if 1444709525 
protected static final int SPACE_MIDDLE = 0;
//#endif 


//#if -206543846 
protected static final int DIVIDER_Y = 0;
//#endif 


//#if -799935239 
protected static final int SPACE_BOTTOM = 6;
//#endif 


//#if -2053797261 
protected static final int MARGIN = 2;
//#endif 


//#if -703927403 
protected NotationProvider notationProviderBody;
//#endif 


//#if -245091264 
private FigText internal;
//#endif 


//#if 1160022687 
@Override
    protected void updateFont()
    { 

//#if -1665714536 
super.updateFont();
//#endif 


//#if -403382863 
Font f = getSettings().getFont(Font.PLAIN);
//#endif 


//#if -1337441913 
internal.setFont(f);
//#endif 

} 

//#endif 


//#if -617475515 
protected abstract int getInitialHeight();
//#endif 


//#if 1631661425 
@Deprecated
    public FigState(@SuppressWarnings("unused") GraphModel gm, Object node)
    { 

//#if -1234670668 
this();
//#endif 


//#if 972360707 
setOwner(node);
//#endif 

} 

//#endif 


//#if -396041919 
protected FigText getInternal()
    { 

//#if 1348745446 
return internal;
//#endif 

} 

//#endif 


//#if -230889043 
@Override
    public void removeFromDiagramImpl()
    { 

//#if -513514244 
if(notationProviderBody != null)//1
{ 

//#if -1742746299 
notationProviderBody.cleanListener(this, getOwner());
//#endif 

} 

//#endif 


//#if 1772379607 
super.removeFromDiagramImpl();
//#endif 

} 

//#endif 


//#if -850989662 
@Override
    public void renderingChanged()
    { 

//#if 1513579152 
super.renderingChanged();
//#endif 


//#if -1611072413 
Object state = getOwner();
//#endif 


//#if 1606105060 
if(state == null)//1
{ 

//#if 1573975152 
return;
//#endif 

} 

//#endif 


//#if -824035332 
if(notationProviderBody != null)//1
{ 

//#if -683390836 
internal.setText(notationProviderBody.toString(getOwner(),
                             getNotationSettings()));
//#endif 

} 

//#endif 


//#if -762508063 
calcBounds();
//#endif 


//#if 1224605278 
setBounds(getBounds());
//#endif 

} 

//#endif 


//#if -1283096630 
protected abstract int getInitialWidth();
//#endif 


//#if 1477164977 
protected void setInternal(FigText theInternal)
    { 

//#if -1573974189 
this.internal = theInternal;
//#endif 

} 

//#endif 


//#if -1826411715 
protected abstract int getInitialY();
//#endif 


//#if -505751104 
@Override
    protected void initNotationProviders(Object own)
    { 

//#if -431035489 
if(notationProviderBody != null)//1
{ 

//#if 430059282 
notationProviderBody.cleanListener(this, own);
//#endif 

} 

//#endif 


//#if -1271858175 
super.initNotationProviders(own);
//#endif 


//#if -700036146 
NotationName notation = Notation.findNotation(
                                    getNotationSettings().getNotationLanguage());
//#endif 


//#if 2067530168 
if(Model.getFacade().isAState(own))//1
{ 

//#if 1300406591 
notationProviderBody =
                NotationProviderFactory2.getInstance().getNotationProvider(
                    NotationProviderFactory2.TYPE_STATEBODY, own, this,
                    notation);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1826412676 
protected abstract int getInitialX();
//#endif 


//#if -1261312974 
public FigState(Object owner, Rectangle bounds, DiagramSettings settings)
    { 

//#if 449771248 
super(owner, bounds, settings);
//#endif 


//#if -51730769 
initializeState();
//#endif 


//#if 1087312888 
NotationName notation = Notation.findNotation(
                                    getNotationSettings().getNotationLanguage());
//#endif 


//#if -198244031 
notationProviderBody =
            NotationProviderFactory2.getInstance().getNotationProvider(
                NotationProviderFactory2.TYPE_STATEBODY, getOwner(), this,
                notation);
//#endif 

} 

//#endif 


//#if -2127203994 

//#if -888240411 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    @Override
    public void setOwner(Object newOwner)
    { 

//#if 1218100943 
super.setOwner(newOwner);
//#endif 


//#if -1229814120 
renderingChanged();
//#endif 

} 

//#endif 


//#if -245673178 
protected void modelChanged(PropertyChangeEvent mee)
    { 

//#if -154102649 
super.modelChanged(mee);
//#endif 


//#if 1349511718 
if(mee instanceof AssociationChangeEvent
                || mee instanceof AttributeChangeEvent)//1
{ 

//#if -938811134 
renderingChanged();
//#endif 


//#if -1499272835 
notationProviderBody.updateListener(this, getOwner(), mee);
//#endif 


//#if -798788933 
damage();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1415190080 
@Override
    public void textEdited(FigText ft) throws PropertyVetoException
    { 

//#if 165731017 
super.textEdited(ft);
//#endif 


//#if -1693844423 
if(ft == getInternal())//1
{ 

//#if -1871750582 
Object st = getOwner();
//#endif 


//#if -2068644655 
if(st == null)//1
{ 

//#if 1497942410 
return;
//#endif 

} 

//#endif 


//#if -2006444736 
notationProviderBody.parse(getOwner(), ft.getText());
//#endif 


//#if 550049563 
ft.setText(notationProviderBody.toString(getOwner(),
                       getNotationSettings()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1246819566 
@Override
    protected void textEditStarted(FigText ft)
    { 

//#if -784037598 
super.textEditStarted(ft);
//#endif 


//#if -251882451 
if(ft == internal)//1
{ 

//#if 1019763147 
showHelp(notationProviderBody.getParsingHelp());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2142614213 
private void initializeState()
    { 

//#if 2044628994 
setBigPort(new FigRRect(getInitialX() + 1, getInitialY() + 1,
                                getInitialWidth() - 2, getInitialHeight() - 2,
                                DEBUG_COLOR, DEBUG_COLOR));
//#endif 


//#if 862722426 
getNameFig().setLineWidth(0);
//#endif 


//#if 1628272229 
getNameFig().setBounds(getInitialX() + 2, getInitialY() + 2,
                               getInitialWidth() - 4,
                               getNameFig().getBounds().height);
//#endif 


//#if 587062657 
getNameFig().setFilled(false);
//#endif 


//#if 732739137 
internal =
            new FigText(getInitialX() + 2,
                        getInitialY() + 2 + NAME_FIG_HEIGHT + 4,
                        getInitialWidth() - 4,
                        getInitialHeight()
                        - (getInitialY() + 2 + NAME_FIG_HEIGHT + 4));
//#endif 


//#if 1043268011 
internal.setFont(getSettings().getFont(Font.PLAIN));
//#endif 


//#if 1190433024 
internal.setTextColor(TEXT_COLOR);
//#endif 


//#if -1294707615 
internal.setLineWidth(0);
//#endif 


//#if -1868759174 
internal.setFilled(false);
//#endif 


//#if 1597122999 
internal.setExpandOnly(true);
//#endif 


//#if 1936195103 
internal.setReturnAction(FigText.INSERT);
//#endif 


//#if -485205786 
internal.setJustification(FigText.JUSTIFY_LEFT);
//#endif 

} 

//#endif 


//#if 933901242 

//#if 1752000388 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigState()
    { 

//#if -649899475 
super();
//#endif 


//#if 820026247 
initializeState();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

