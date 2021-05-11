// Compilation Unit of /FigMessage.java 
 
package org.argouml.uml.diagram.ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.util.Iterator;
import java.util.Vector;
import org.argouml.model.Model;
import org.argouml.notation.NotationProviderFactory2;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.collaboration.ui.FigAssociationRole;
import org.tigris.gef.base.Layer;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigPoly;
import org.tigris.gef.presentation.FigText;
public class FigMessage extends FigNodeModelElement
  { 
private static Vector<String> arrowDirections;
private FigPoly figPoly;
private static final int SOUTH = 0;
private static final int EAST = 1;
private static final int WEST = 2;
private static final int NORTH = 3;
private int arrowDirection = -1;
@Override
    public boolean isFilled()
    { 
return true;
} 

@Override
    public int getLineWidth()
    { 
return figPoly.getLineWidth();
} 

@Override
    public void setFillColor(Color col)
    { 
getNameFig().setFillColor(col);
} 

@Override
    public Dimension getMinimumSize()
    { 
Dimension nameMin = getNameFig().getMinimumSize();
Dimension figPolyMin = figPoly.getSize();
int h = Math.max(figPolyMin.height, nameMin.height);
int w = figPolyMin.width + nameMin.width;
return new Dimension(w, h);
} 

@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 
if(getNameFig() == null)//1
{ 
return;
} 

Rectangle oldBounds = getBounds();
Dimension nameMin = getNameFig().getMinimumSize();
int ht = 0;
if(nameMin.height > figPoly.getHeight())//1
{ 
ht = (nameMin.height - figPoly.getHeight()) / 2;
} 

getNameFig().setBounds(x, y, w - figPoly.getWidth(), nameMin.height);
getBigPort().setBounds(x, y, w - figPoly.getWidth(), nameMin.height);
figPoly.setBounds(x + getNameFig().getWidth(), y + ht,
                          figPoly.getWidth(), figPoly.getHeight());
firePropChange("bounds", oldBounds, getBounds());
calcBounds();
updateEdges();
} 

@Override
    public void renderingChanged()
    { 
super.renderingChanged();
updateArrow();
} 

@Override
    protected void modelChanged(PropertyChangeEvent mee)
    { 
super.modelChanged(mee);
if(true)//1
{ 
return;
} 

if(Model.getFacade().isAMessage(getOwner()))//1
{ 
if(Model.getFacade().isAParameter(mee.getSource()))//1
{ 
Object par = mee.getSource();
updateArgumentsFromParameter(getOwner(), par);
} 

if(mee == null || mee.getSource() == getOwner()
                    || Model.getFacade().isAAction(mee.getSource())
                    || Model.getFacade().isAOperation(mee.getSource())
                    || Model.getFacade().isAArgument(mee.getSource())
                    || Model.getFacade().isASignal(mee.getSource()))//1
{ 
updateListeners(getOwner());
} 

updateArrow();
damage();
} 

} 

@Override
    public Object clone()
    { 
FigMessage figClone = (FigMessage) super.clone();
Iterator it = figClone.getFigs().iterator();
figClone.setNameFig((FigText) it.next());
figClone.figPoly = (FigPoly) it.next();
return figClone;
} 

public static Vector<String> getArrowDirections()
    { 
return arrowDirections;
} 

@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 
if(oldOwner != null)//1
{ 
removeElementListener(oldOwner);
} 

if(newOwner != null)//1
{ 
addElementListener(newOwner, "remove");
} 

} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigMessage(@SuppressWarnings("unused") GraphModel gm, Layer lay,
                      Object node)
    { 
this();
setLayer(lay);
setOwner(node);
} 

private void initArrows()
    { 
if(arrowDirections == null)//1
{ 
arrowDirections = new Vector<String>(4);
arrowDirections.add(SOUTH, "South");
arrowDirections.add(EAST, "East");
arrowDirections.add(WEST, "West");
arrowDirections.add(NORTH, "North");
} 

} 

public void updateArrow()
    { 
Object mes = getOwner();
if(mes == null || getLayer() == null)//1
{ 
return;
} 

Object sender = Model.getFacade().getSender(mes);
Object receiver = Model.getFacade().getReceiver(mes);
Fig senderPort = getLayer().presentationFor(sender);
Fig receiverPort = getLayer().presentationFor(receiver);
if(senderPort == null || receiverPort == null)//1
{ 
return;
} 

int sx = senderPort.getX();
int sy = senderPort.getY();
int rx = receiverPort.getX();
int ry = receiverPort.getY();
if(sx < rx && Math.abs(sy - ry) <= Math.abs(sx - rx))//1
{ 
setArrow(EAST);
} 
else
if(sx > rx && Math.abs(sy - ry) <= Math.abs(sx - rx))//1
{ 
setArrow(WEST);
} 
else
if(sy < ry)//1
{ 
setArrow(SOUTH);
} 
else
{ 
setArrow(NORTH);
} 



} 

protected void updateArgumentsFromParameter(Object newOwner,
            Object parameter)
    { 
if(true)//1
{ 
return;
} 

if(newOwner != null)//1
{ 
Object act = Model.getFacade().getAction(newOwner);
if(Model.getFacade().isACallAction(act))//1
{ 
if(Model.getFacade().getOperation(act) != null)//1
{ 
Object operation = Model.getFacade().getOperation(act);
if(Model.getDirectionKind().getInParameter().equals(
                                Model.getFacade().getKind(parameter)))//1
{ 
Object newArgument = Model.getCommonBehaviorFactory()
                                             .createArgument();
Model.getCommonBehaviorHelper().setValue(
                            newArgument,
                            Model.getDataTypesFactory().createExpression(
                                "",
                                Model.getFacade().getName(parameter)));
Model.getCoreHelper().setName(newArgument,
                                                      Model.getFacade().getName(parameter));
Model.getCommonBehaviorHelper().addActualArgument(act,
                                newArgument);
Model.getPump().removeModelEventListener(this,
                                parameter);
Model.getPump().addModelEventListener(this, parameter);
} 

} 

} 

} 

} 

protected void updateListeners(Object newOwner)
    { 
if(true)//1
{ 
return;
} 

if(newOwner != null)//1
{ 
Object act = Model.getFacade().getAction(newOwner);
if(act != null)//1
{ 
Model.getPump().removeModelEventListener(this, act);
Model.getPump().addModelEventListener(this, act);
Iterator iter = Model.getFacade().getActualArguments(act)
                                .iterator();
while (iter.hasNext()) //1
{ 
Object arg = iter.next();
Model.getPump().removeModelEventListener(this, arg);
Model.getPump().addModelEventListener(this, arg);
} 

if(Model.getFacade().isACallAction(act))//1
{ 
Object oper = Model.getFacade().getOperation(act);
if(oper != null)//1
{ 
Model.getPump().removeModelEventListener(this, oper);
Model.getPump().addModelEventListener(this, oper);
Iterator it2 = Model.getFacade().getParameters(oper)
                                       .iterator();
while (it2.hasNext()) //1
{ 
Object param = it2.next();
Model.getPump().removeModelEventListener(this,
                                    param);
Model.getPump().addModelEventListener(this, param);
} 

} 

} 

if(Model.getFacade().isASendAction(act))//1
{ 
Object sig = Model.getFacade().getSignal(act);
if(sig != null)//1
{ 
Model.getPump().removeModelEventListener(this, sig);
} 

Model.getPump().addModelEventListener(this, sig);
} 

} 

} 

} 

public int getArrow()
    { 
return arrowDirection;
} 

@Override
    public void setLineColor(Color col)
    { 
figPoly.setLineColor(col);
getNameFig().setLineColor(col);
} 

@Override
    protected int getNotationProviderType()
    { 
return NotationProviderFactory2.TYPE_MESSAGE;
} 

public void addPathItemToFigAssociationRole(Layer lay)
    { 
Object associationRole =
            Model.getFacade().getCommunicationConnection(getOwner());
if(associationRole != null && lay != null)//1
{ 
FigAssociationRole figAssocRole =
                (FigAssociationRole) lay.presentationFor(associationRole);
if(figAssocRole != null)//1
{ 
figAssocRole.addMessage(this);
lay.bringToFront(this);
} 

} 

} 

@Override
    public void setFilled(boolean f)
    { 
} 

@Override
    public Color getLineColor()
    { 
return figPoly.getLineColor();
} 

public FigMessage(Object owner, Rectangle bounds,
                      DiagramSettings settings)
    { 
super(owner, bounds, settings);
initArrows();
initFigs();
updateNameText();
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigMessage()
    { 
super();
initFigs();
initArrows();
Rectangle r = getBounds();
setBounds(r.x, r.y, r.width, r.height);
} 

private void initFigs()
    { 
setShadowSize(0);
getNameFig().setLineWidth(0);
getNameFig().setReturnAction(FigText.END_EDITING);
getNameFig().setFilled(false);
Dimension nameMin = getNameFig().getMinimumSize();
getNameFig().setBounds(X0, Y0, 90, nameMin.height);
getBigPort().setBounds(X0, Y0, 90, nameMin.height);
figPoly = new FigPoly(LINE_COLOR, SOLID_FILL_COLOR);
int[] xpoints = {75, 75, 77, 75, 73, 75};
int[] ypoints = {33, 24, 24, 15, 24, 24};
Polygon polygon = new Polygon(xpoints, ypoints, 6);
figPoly.setPolygon(polygon);
figPoly.setBounds(100, 10, 5, 18);
getBigPort().setFilled(false);
getBigPort().setLineWidth(0);
addFig(getBigPort());
addFig(getNameFig());
addFig(figPoly);
} 

@Override
    public Color getFillColor()
    { 
return getNameFig().getFillColor();
} 

@Override
    public void setLineWidth(int w)
    { 
figPoly.setLineWidth(w);
} 

public void setArrow(int direction)
    { 
Rectangle bbox = getBounds();
if(arrowDirection == direction)//1
{ 
return;
} 

arrowDirection = direction;
switch (direction) //1
{ 
case SOUTH://1

{ 
int[] xpoints = {75, 75, 77, 75, 73, 75};
int[] ypoints = {15, 24, 24, 33, 24, 24};
Polygon polygon = new Polygon(xpoints, ypoints, 6);
figPoly.setPolygon(polygon);
break;

} 

case EAST://1

{ 
int[] xpoints = {66, 75, 75, 84, 75, 75};
int[] ypoints = {24, 24, 26, 24, 22, 24};
Polygon polygon = new Polygon(xpoints, ypoints, 6);
figPoly.setPolygon(polygon);
break;

} 

case WEST://1

{ 
int[] xpoints = {84, 75, 75, 66, 75, 75};
int[] ypoints = {24, 24, 26, 24, 22, 24};
Polygon polygon = new Polygon(xpoints, ypoints, 6);
figPoly.setPolygon(polygon);
break;

} 

default://1

{ 
int[] xpoints = {75, 75, 77, 75, 73, 75};
int[] ypoints = {33, 24, 24, 15, 24, 24};
Polygon polygon = new Polygon(xpoints, ypoints, 6);
figPoly.setPolygon(polygon);
break;

} 

} 

setBounds(bbox);
} 

 } 


