package org.argouml.uml.diagram.static_structure.ui;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.HashSet;
import java.util.Set;
import javax.swing.Action;
import org.apache.log4j.Logger;
import org.argouml.model.AddAssociationEvent;
import org.argouml.model.AssociationChangeEvent;
import org.argouml.model.AttributeChangeEvent;
import org.argouml.model.Model;
import org.argouml.model.RemoveAssociationEvent;
import org.argouml.model.UmlChangeEvent;
import org.argouml.ui.ArgoJMenu;
import org.argouml.uml.diagram.AttributesCompartmentContainer;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.FigAttributesCompartment;
import org.argouml.uml.ui.foundation.core.ActionAddAttribute;
public class FigClassifierBoxWithAttributes extends FigClassifierBox
 implements AttributesCompartmentContainer
  { 
private static final Logger LOG =
        Logger.getLogger(FigClassifierBoxWithAttributes.class);
private FigAttributesCompartment attributesFigCompartment;
public void setAttributesVisible(boolean isVisible)
    { 
setCompartmentVisible(attributesFigCompartment, isVisible);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    @Override
    public void setOwner(Object owner)
    { 
attributesFigCompartment.setOwner(owner);
super.setOwner(owner);
} 
@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 
Set<Object[]> listeners = new HashSet<Object[]>();
if(newOwner != null)//1
{ 
listeners.add(new Object[] {newOwner, null});
for (Object stereotype
                    : Model.getFacade().getStereotypes(newOwner)) //1
{ 
listeners.add(new Object[] {stereotype, null});
} 
for (Object feat : Model.getFacade().getFeatures(newOwner)) //1
{ 
listeners.add(new Object[] {feat, null});
for (Object stereotype
                        : Model.getFacade().getStereotypes(feat)) //1
{ 
listeners.add(new Object[] {stereotype, null});
} 
if(Model.getFacade().isAOperation(feat))//1
{ 
for (Object param : Model.getFacade().getParameters(feat)) //1
{ 
listeners.add(new Object[] {param, null});
} 
} 
} 
} 
updateElementListeners(listeners);
} 
protected FigAttributesCompartment getAttributesFig()
    { 
return attributesFigCompartment;
} 
@Override
    protected void setStandardBounds(final int x, final int y, final int width,
                                     final int height)
    { 
Rectangle oldBounds = getBounds();
int w = Math.max(width, getMinimumSize().width);
int h = Math.max(height, getMinimumSize().height);
getBigPort().setBounds(x, y, w, h);
if(borderFig != null)//1
{ 
borderFig.setBounds(x, y, w, h);
} 
final int whitespace = h - getMinimumSize().height;
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
if(isAttributesVisible())//1
{ 
int attributesHeight =
                attributesFigCompartment.getMinimumSize().height;
if(isOperationsVisible())//1
{ 
attributesHeight += whitespace / 2;
} 
attributesFigCompartment.setBounds(
                x,
                y + currentHeight,
                w,
                attributesHeight);
currentHeight += attributesHeight;
} 
if(isOperationsVisible())//1
{ 
int operationsY = y + currentHeight;
int operationsHeight = (h + y) - operationsY - LINE_WIDTH;
if(operationsHeight < getOperationsFig().getMinimumSize().height)//1
{ 
operationsHeight = getOperationsFig().getMinimumSize().height;
} 
getOperationsFig().setBounds(
                x,
                operationsY,
                w,
                operationsHeight);
} 
calcBounds();
updateEdges();
LOG.debug("Bounds change : old - " + oldBounds + ", new - "
                  + getBounds());
firePropChange("bounds", oldBounds, getBounds());
} 
@Override
    public Dimension getMinimumSize()
    { 
Dimension aSize = getNameFig().getMinimumSize();
aSize.height += NAME_V_PADDING * 2;
aSize.height = Math.max(NAME_FIG_HEIGHT, aSize.height);
aSize = addChildDimensions(aSize, getStereotypeFig());
aSize = addChildDimensions(aSize, getAttributesFig());
aSize = addChildDimensions(aSize, getOperationsFig());
aSize.width = Math.max(WIDTH, aSize.width);
return aSize;
} 
@Override
    protected void updateLayout(UmlChangeEvent event)
    { 
super.updateLayout(event);
if(event instanceof AttributeChangeEvent)//1
{ 
Object source = event.getSource();
if(Model.getFacade().isAAttribute(source))//1
{ 
updateAttributes();
} 
} 
else
if(event instanceof AssociationChangeEvent
                   && getOwner().equals(event.getSource()))//1
{ 
Object o = null;
if(event instanceof AddAssociationEvent)//1
{ 
o = event.getNewValue();
} 
else
if(event instanceof RemoveAssociationEvent)//1
{ 
o = event.getOldValue();
} 
if(Model.getFacade().isAAttribute(o))//1
{ 
updateAttributes();
} 
} 
} 
public boolean isAttributesVisible()
    { 
return attributesFigCompartment != null
               && attributesFigCompartment.isVisible();
} 
public Rectangle getAttributesBounds()
    { 
return attributesFigCompartment.getBounds();
} 
@Override
    public void renderingChanged()
    { 
super.renderingChanged();
if(getOwner() != null)//1
{ 
updateAttributes();
} 
} 
@Override
    protected ArgoJMenu buildAddMenu()
    { 
ArgoJMenu addMenu = super.buildAddMenu();
Action addAttribute = new ActionAddAttribute();
addAttribute.setEnabled(isSingleTarget());
addMenu.insert(addAttribute, 0);
return addMenu;
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigClassifierBoxWithAttributes()
    { 
super();
attributesFigCompartment = new FigAttributesCompartment(
            DEFAULT_COMPARTMENT_BOUNDS.x,
            DEFAULT_COMPARTMENT_BOUNDS.y,
            DEFAULT_COMPARTMENT_BOUNDS.width,
            DEFAULT_COMPARTMENT_BOUNDS.height);
} 
@Override
    public String classNameAndBounds()
    { 
return super.classNameAndBounds()
               + "attributesVisible=" + isAttributesVisible() + ";";
} 
protected void updateAttributes()
    { 
if(!isAttributesVisible())//1
{ 
return;
} 
attributesFigCompartment.populate();
setBounds(getBounds());
} 
public FigClassifierBoxWithAttributes(Object owner, Rectangle bounds,
                                          DiagramSettings settings)
    { 
super(owner, bounds, settings);
attributesFigCompartment = new FigAttributesCompartment(owner,
                DEFAULT_COMPARTMENT_BOUNDS, settings);
} 

 } 
