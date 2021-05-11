package org.argouml.uml.diagram.static_structure.ui;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.Action;
import org.argouml.model.AssociationChangeEvent;
import org.argouml.model.AttributeChangeEvent;
import org.argouml.model.Model;
import org.argouml.ui.ArgoJMenu;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.EnumLiteralsCompartmentContainer;
import org.argouml.uml.diagram.ui.FigEnumLiteralsCompartment;
import org.argouml.uml.ui.foundation.core.ActionAddEnumerationLiteral;
import org.tigris.gef.base.Selection;
import org.tigris.gef.graph.GraphModel;
public class FigEnumeration extends FigDataType
 implements EnumLiteralsCompartmentContainer
  { 
private static final long serialVersionUID = 3333154292883077250L;
private FigEnumLiteralsCompartment literalsCompartment;
public FigEnumLiteralsCompartment getLiteralsCompartment()
    { 
if(literalsCompartment == null)//1
{ 
literalsCompartment = new FigEnumLiteralsCompartment(getOwner(),
                    DEFAULT_COMPARTMENT_BOUNDS, getSettings());
} 
return literalsCompartment;
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigEnumeration()
    { 
super();
enableSizeChecking(true);
setSuppressCalcBounds(false);
addFig(getLiteralsCompartment());
setBounds(getBounds());
} 
@Override
    protected void setStandardBounds(final int x, final int y, final int width,
                                     final int height)
    { 
Rectangle oldBounds = getBounds();
int w = Math.max(width, getMinimumSize().width);
int h = Math.max(height, getMinimumSize().height);
getBigPort().setBounds(x, y, w, h);
borderFig.setBounds(x, y, w, h);
int currentHeight = 0;
if(getStereotypeFig().isVisible())//1
{ 
int stereotypeHeight = getStereotypeFig().getMinimumSize().height;
getStereotypeFig().setBounds(
                x,
                y,
                w,
                stereotypeHeight);
currentHeight += stereotypeHeight;
} 
int nameHeight = getNameFig().getMinimumSize().height;
getNameFig().setBounds(x, y + currentHeight, w, nameHeight);
currentHeight += nameHeight;
int visibleCompartments = getOperationsFig().isVisible() ? 1 : 0;
if(getLiteralsCompartment().isVisible())//1
{ 
visibleCompartments++;
int literalsHeight =
                getLiteralsCompartment().getMinimumSize().height;
literalsHeight = Math.max(literalsHeight,
                                      (h - currentHeight) / visibleCompartments);
getLiteralsCompartment().setBounds(
                x + LINE_WIDTH,
                y + currentHeight,
                w - LINE_WIDTH,
                literalsHeight);
currentHeight += literalsHeight;
} 
if(getOperationsFig().isVisible())//1
{ 
int operationsHeight = getOperationsFig().getMinimumSize().height;
operationsHeight = Math.max(operationsHeight, h - currentHeight);
getOperationsFig().setBounds(
                x,
                y + currentHeight,
                w,
                operationsHeight);
currentHeight += operationsHeight;
} 
calcBounds();
updateEdges();
firePropChange("bounds", oldBounds, getBounds());
} 
@Override
    protected ArgoJMenu buildAddMenu()
    { 
ArgoJMenu addMenu = super.buildAddMenu();
Action addEnumerationLiteral = new ActionAddEnumerationLiteral();
addEnumerationLiteral.setEnabled(isSingleTarget());
addMenu.add(addEnumerationLiteral);
return addMenu;
} 
public Rectangle getEnumLiteralsBounds()
    { 
return literalsCompartment.getBounds();
} 
@Override
    public Dimension getMinimumSize()
    { 
Dimension aSize = super.getMinimumSize();
if(literalsCompartment != null)//1
{ 
aSize = addChildDimensions(aSize, literalsCompartment);
} 
return aSize;
} 
public boolean isEnumLiteralsVisible()
    { 
return literalsCompartment.isVisible();
} 
@Override
    public void renderingChanged()
    { 
super.renderingChanged();
if(getOwner() != null)//1
{ 
updateEnumLiterals();
} 
} 
@Override
    protected String getKeyword()
    { 
return "enumeration";
} 
public FigEnumeration(Object owner, Rectangle bounds,
                          DiagramSettings settings)
    { 
super(owner, bounds, settings);
enableSizeChecking(true);
setSuppressCalcBounds(false);
addFig(getLiteralsCompartment());
setEnumLiteralsVisible(true);
literalsCompartment.populate();
setBounds(getBounds());
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
@SuppressWarnings("deprecation")

    @Deprecated
    public FigEnumeration(@SuppressWarnings("unused") GraphModel gm,
                          Object node)
    { 
this();
enableSizeChecking(true);
setEnumLiteralsVisible(true);
setOwner(node);
literalsCompartment.populate();
setBounds(getBounds());
} 
protected void updateEnumLiterals()
    { 
if(!literalsCompartment.isVisible())//1
{ 
return;
} 
literalsCompartment.populate();
setBounds(getBounds());
} 
@Override
    public Object clone()
    { 
FigEnumeration clone = (FigEnumeration) super.clone();
clone.literalsCompartment =
            (FigEnumLiteralsCompartment) literalsCompartment.clone();
return clone;
} 
public void setEnumLiteralsVisible(boolean isVisible)
    { 
setCompartmentVisible(literalsCompartment, isVisible);
} 
@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 
Set<Object[]> l = new HashSet<Object[]>();
if(newOwner != null)//1
{ 
l.add(new Object[] {newOwner, null});
for (Object stereo : Model.getFacade().getStereotypes(newOwner)) //1
{ 
l.add(new Object[] {stereo, null});
} 
for (Object feat : Model.getFacade().getFeatures(newOwner)) //1
{ 
l.add(new Object[] {feat, null});
for (Object stereo : Model.getFacade().getStereotypes(feat)) //1
{ 
l.add(new Object[] {stereo, null});
} 
} 
for (Object literal : Model.getFacade().getEnumerationLiterals(
                        newOwner)) //1
{ 
l.add(new Object[] {literal, null});
} 
} 
updateElementListeners(l);
} 
@Override
    public Selection makeSelection()
    { 
return new SelectionEnumeration(this);
} 

 } 
