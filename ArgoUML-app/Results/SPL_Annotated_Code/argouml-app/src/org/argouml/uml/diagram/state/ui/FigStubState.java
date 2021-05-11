// Compilation Unit of /FigStubState.java 
 
package org.argouml.uml.diagram.state.ui;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.argouml.model.Facade;
import org.argouml.model.Model;
import org.argouml.model.StateMachinesHelper;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.SelectionMoveClarifiers;
import org.tigris.gef.base.Selection;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.FigLine;
import org.tigris.gef.presentation.FigRect;
import org.tigris.gef.presentation.FigText;
public class FigStubState extends FigStateVertex
  { 
private static final Logger LOG = Logger.getLogger(FigStubState.class);
private static final int X = 0;
private static final int Y = 0;
private static final int WIDTH = 45;
private static final int HEIGHT = 20;
private FigText referenceFig;
private FigLine stubline;
private Facade facade;
private StateMachinesHelper stateMHelper;
@SuppressWarnings("deprecation")

    @Deprecated
    public FigStubState()
    { 
super();
initFigs();
} 

@Override
    public void setLineColor(Color col)
    { 
stubline.setLineColor(col);
} 

public FigStubState(Object owner, Rectangle bounds,
                        DiagramSettings settings)
    { 
super(owner, bounds, settings);
initFigs();
} 

@Override
    public Color getFillColor()
    { 
return referenceFig.getFillColor();
} 

@Override
    public Object clone()
    { 
FigStubState figClone = (FigStubState) super.clone();
Iterator it = figClone.getFigs().iterator();
figClone.setBigPort((FigRect) it.next());
figClone.referenceFig = (FigText) it.next();
figClone.stubline = (FigLine) it.next();
return figClone;
} 

@Override
    public void setFillColor(Color col)
    { 
referenceFig.setFillColor(col);
} 

@Override
    public boolean isFilled()
    { 
return referenceFig.isFilled();
} 

@Override
    protected void updateFont()
    { 
super.updateFont();
Font f = getSettings().getFont(Font.PLAIN);
referenceFig.setFont(f);
} 

@Override
    public void renderingChanged()
    { 
super.renderingChanged();
updateReferenceText();
} 

public void updateReferenceText()
    { 
Object text = null;
try //1
{ 
text = facade.getReferenceState(getOwner());
} 
catch (Exception e) //1
{ 
LOG.error("Exception caught and ignored!!", e);
} 


if(text != null)//1
{ 
referenceFig.setText((String) text);
} 
else
{ 
referenceFig.setText("");
} 

calcBounds();
setBounds(getBounds());
damage();
} 

protected void updateListenersX(Object newOwner, Object oldV)
    { 
updateListeners(oldV, newOwner);
} 

@Override
    public Selection makeSelection()
    { 
return new SelectionMoveClarifiers(this);
} 

private void addListeners(Object newOwner)
    { 
Object container;
Object top;
Object reference;
container = facade.getContainer(newOwner);
if(container != null
                && facade.isASubmachineState(container))//1
{ 
addElementListener(container);
} 

if(container != null
                && facade.isASubmachineState(container)
                && facade.getSubmachine(container) != null)//1
{ 
top = facade.getTop(facade.getSubmachine(container));
reference = stateMHelper.getStatebyName(facade
                                                    .getReferenceState(newOwner), top);
String[] properties = {"name", "container"};
container = reference;
while (container != null
                    && !container.equals(top)) //1
{ 
addElementListener(container);
container = facade.getContainer(container);
} 

} 

} 

@Deprecated
    public FigStubState(@SuppressWarnings("unused") GraphModel gm,
                        Object node)
    { 
this();
setOwner(node);
} 

@Override
    public void setOwner(Object node)
    { 
super.setOwner(node);
renderingChanged();
} 

@Override
    protected void setStandardBounds(int theX, int theY, int theW, int theH)
    { 
Rectangle oldBounds = getBounds();
theW = 60;
referenceFig.setBounds(theX, theY, theW,
                               referenceFig.getBounds().height);
stubline.setShape(theX, theY,
                          theX + theW, theY);
getBigPort().setBounds(theX, theY, theW, theH);
calcBounds();
updateEdges();
firePropChange("bounds", oldBounds, getBounds());
} 

@Override
    public int getLineWidth()
    { 
return stubline.getLineWidth();
} 

@Override
    public void setLineWidth(int w)
    { 
stubline.setLineWidth(w);
} 

private void removeListeners()
    { 
Object container;
Object top;
Object reference;
Object owner = getOwner();
if(owner == null)//1
{ 
return;
} 

container = facade.getContainer(owner);
if(container != null
                && facade.isASubmachineState(container))//1
{ 
removeElementListener(container);
} 

if(container != null
                && facade.isASubmachineState(container)
                && facade.getSubmachine(container) != null)//1
{ 
top = facade.getTop(facade.getSubmachine(container));
reference = stateMHelper.getStatebyName(facade
                                                    .getReferenceState(owner), top);
if(reference != null)//1
{ 
removeElementListener(reference);
container = facade.getContainer(reference);
while (container != null && !facade.isTop(container)) //1
{ 
removeElementListener(container);
container = facade.getContainer(container);
} 

} 

} 

} 

@Override
    protected void modelChanged(PropertyChangeEvent mee)
    { 
super.modelChanged(mee);
if(getOwner() == null)//1
{ 
return;
} 

Object top = null;
Object oldRef = null;
Object container = facade.getContainer(getOwner());
if((mee.getSource().equals(getOwner())))//1
{ 
if(mee.getPropertyName().equals("referenceState"))//1
{ 
updateReferenceText();
if(container != null && facade.isASubmachineState(container)
                        && facade.getSubmachine(container) != null)//1
{ 
top = facade.getTop(facade.getSubmachine(container));
oldRef = stateMHelper.getStatebyName(
                                 (String) mee.getOldValue(), top);
} 

updateListeners(oldRef, getOwner());
} 
else
if((mee.getPropertyName().equals("container")
                        && facade.isASubmachineState(container)))//1
{ 
removeListeners();
Object o = mee.getOldValue();
if(o != null && facade.isASubmachineState(o))//1
{ 
removeElementListener(o);
} 

stateMHelper.setReferenceState(getOwner(), null);
updateListeners(getOwner(), getOwner());
updateReferenceText();
} 


} 
else
{ 
if(container != null
                    && mee.getSource().equals(container)
                    && facade.isASubmachineState(container)
                    && facade.getSubmachine(container) != null)//1
{ 
if(mee.getPropertyName().equals("submachine"))//1
{ 
if(mee.getOldValue() != null)//1
{ 
top = facade.getTop(mee.getOldValue());
oldRef = stateMHelper.getStatebyName(facade
                                                             .getReferenceState(getOwner()), top);
} 

stateMHelper.setReferenceState(getOwner(), null);
updateListeners(oldRef, getOwner());
updateReferenceText();
} 

} 
else
{ 
if(facade.getSubmachine(container) != null)//1
{ 
top = facade.getTop(facade.getSubmachine(container));
} 

String path = facade.getReferenceState(getOwner());
Object refObject = stateMHelper.getStatebyName(path, top);
String ref;
if(refObject == null)//1
{ 
ref = stateMHelper.getPath(mee.getSource());
} 
else
{ 
ref = stateMHelper.getPath(refObject);
} 

stateMHelper.setReferenceState(getOwner(), ref);
updateReferenceText();
} 

} 

} 

@Override
    public void setFilled(boolean f)
    { 
referenceFig.setFilled(f);
} 

@Override
    public Color getLineColor()
    { 
return stubline.getLineColor();
} 

@Override
    public boolean isResizable()
    { 
return false;
} 

private void initFigs()
    { 
facade = Model.getFacade();
stateMHelper = Model.getStateMachinesHelper();
setBigPort(new FigRect(X, Y, WIDTH, HEIGHT));
getBigPort().setLineWidth(0);
getBigPort().setFilled(false);
stubline = new FigLine(X,
                               Y,
                               WIDTH,
                               Y,
                               TEXT_COLOR);
referenceFig = new FigText(0, 0, WIDTH, HEIGHT, true);
referenceFig.setFont(getSettings().getFontPlain());
referenceFig.setTextColor(TEXT_COLOR);
referenceFig.setReturnAction(FigText.END_EDITING);
referenceFig.setTabAction(FigText.END_EDITING);
referenceFig.setJustification(FigText.JUSTIFY_CENTER);
referenceFig.setLineWidth(0);
referenceFig.setBounds(X, Y,
                               WIDTH, referenceFig.getBounds().height);
referenceFig.setFilled(false);
referenceFig.setEditable(false);
addFig(getBigPort());
addFig(referenceFig);
addFig(stubline);
setShadowSize(0);
setBlinkPorts(false);
} 

@Override
    protected void updateListeners(Object oldV, Object newOwner)
    { 
if(oldV != null)//1
{ 
if(oldV != newOwner)//1
{ 
removeElementListener(oldV);
} 

Object container = facade.getContainer(oldV);
while (container != null && !facade.isTop(container)) //1
{ 
removeElementListener(container);
container = facade.getContainer(container);
} 

} 

super.updateListeners(getOwner(), newOwner);
} 

 } 


