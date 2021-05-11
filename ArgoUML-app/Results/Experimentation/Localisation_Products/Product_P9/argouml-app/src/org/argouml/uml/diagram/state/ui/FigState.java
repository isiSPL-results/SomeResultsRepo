package org.argouml.uml.diagram.state.ui;
import java.awt.Font;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import org.argouml.model.AssociationChangeEvent;
import org.argouml.model.AttributeChangeEvent;
import org.argouml.model.Model;
import org.argouml.notation.Notation;
import org.argouml.notation.NotationName;
import org.argouml.notation.NotationProvider;
import org.argouml.notation.NotationProviderFactory2;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.FigRRect;
import org.tigris.gef.presentation.FigText;
public abstract class FigState extends FigStateVertex
  { 
protected static final int SPACE_TOP = 0;
protected static final int SPACE_MIDDLE = 0;
protected static final int DIVIDER_Y = 0;
protected static final int SPACE_BOTTOM = 6;
protected static final int MARGIN = 2;
protected NotationProvider notationProviderBody;
private FigText internal;
@Override
    protected void updateFont()
    { 
super.updateFont();
Font f = getSettings().getFont(Font.PLAIN);
internal.setFont(f);
} 
protected abstract int getInitialHeight();@Deprecated
    public FigState(@SuppressWarnings("unused") GraphModel gm, Object node)
    { 
this();
setOwner(node);
} 
protected FigText getInternal()
    { 
return internal;
} 
@Override
    public void removeFromDiagramImpl()
    { 
if(notationProviderBody != null)//1
{ 
notationProviderBody.cleanListener(this, getOwner());
} 
super.removeFromDiagramImpl();
} 
@Override
    public void renderingChanged()
    { 
super.renderingChanged();
Object state = getOwner();
if(state == null)//1
{ 
return;
} 
if(notationProviderBody != null)//1
{ 
internal.setText(notationProviderBody.toString(getOwner(),
                             getNotationSettings()));
} 
calcBounds();
setBounds(getBounds());
} 
protected abstract int getInitialWidth();protected void setInternal(FigText theInternal)
    { 
this.internal = theInternal;
} 
protected abstract int getInitialY();@Override
    protected void initNotationProviders(Object own)
    { 
if(notationProviderBody != null)//1
{ 
notationProviderBody.cleanListener(this, own);
} 
super.initNotationProviders(own);
NotationName notation = Notation.findNotation(
                                    getNotationSettings().getNotationLanguage());
if(Model.getFacade().isAState(own))//1
{ 
notationProviderBody =
                NotationProviderFactory2.getInstance().getNotationProvider(
                    NotationProviderFactory2.TYPE_STATEBODY, own, this,
                    notation);
} 
} 
protected abstract int getInitialX();public FigState(Object owner, Rectangle bounds, DiagramSettings settings)
    { 
super(owner, bounds, settings);
initializeState();
NotationName notation = Notation.findNotation(
                                    getNotationSettings().getNotationLanguage());
notationProviderBody =
            NotationProviderFactory2.getInstance().getNotationProvider(
                NotationProviderFactory2.TYPE_STATEBODY, getOwner(), this,
                notation);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    @Override
    public void setOwner(Object newOwner)
    { 
super.setOwner(newOwner);
renderingChanged();
} 
protected void modelChanged(PropertyChangeEvent mee)
    { 
super.modelChanged(mee);
if(mee instanceof AssociationChangeEvent
                || mee instanceof AttributeChangeEvent)//1
{ 
renderingChanged();
notationProviderBody.updateListener(this, getOwner(), mee);
damage();
} 
} 
@Override
    public void textEdited(FigText ft) throws PropertyVetoException
    { 
super.textEdited(ft);
if(ft == getInternal())//1
{ 
Object st = getOwner();
if(st == null)//1
{ 
return;
} 
notationProviderBody.parse(getOwner(), ft.getText());
ft.setText(notationProviderBody.toString(getOwner(),
                       getNotationSettings()));
} 
} 
@Override
    protected void textEditStarted(FigText ft)
    { 
super.textEditStarted(ft);
if(ft == internal)//1
{ 
showHelp(notationProviderBody.getParsingHelp());
} 
} 
private void initializeState()
    { 
setBigPort(new FigRRect(getInitialX() + 1, getInitialY() + 1,
                                getInitialWidth() - 2, getInitialHeight() - 2,
                                DEBUG_COLOR, DEBUG_COLOR));
getNameFig().setLineWidth(0);
getNameFig().setBounds(getInitialX() + 2, getInitialY() + 2,
                               getInitialWidth() - 4,
                               getNameFig().getBounds().height);
getNameFig().setFilled(false);
internal =
            new FigText(getInitialX() + 2,
                        getInitialY() + 2 + NAME_FIG_HEIGHT + 4,
                        getInitialWidth() - 4,
                        getInitialHeight()
                        - (getInitialY() + 2 + NAME_FIG_HEIGHT + 4));
internal.setFont(getSettings().getFont(Font.PLAIN));
internal.setTextColor(TEXT_COLOR);
internal.setLineWidth(0);
internal.setFilled(false);
internal.setExpandOnly(true);
internal.setReturnAction(FigText.INSERT);
internal.setJustification(FigText.JUSTIFY_LEFT);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigState()
    { 
super();
initializeState();
} 

 } 
