
//#if -1720207327 
// Compilation Unit of /FigClassifierBoxWithAttributes.java 
 

//#if -371546045 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if -1790935300 
import java.awt.Dimension;
//#endif 


//#if -1804713965 
import java.awt.Rectangle;
//#endif 


//#if -1657862756 
import java.util.HashSet;
//#endif 


//#if 1033042414 
import java.util.Set;
//#endif 


//#if 356396392 
import javax.swing.Action;
//#endif 


//#if 658313622 
import org.apache.log4j.Logger;
//#endif 


//#if -1069215560 
import org.argouml.model.AddAssociationEvent;
//#endif 


//#if 1943349723 
import org.argouml.model.AssociationChangeEvent;
//#endif 


//#if -681536074 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if -1789117175 
import org.argouml.model.Model;
//#endif 


//#if -1592280409 
import org.argouml.model.RemoveAssociationEvent;
//#endif 


//#if 233064110 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if -93178797 
import org.argouml.ui.ArgoJMenu;
//#endif 


//#if -953690674 
import org.argouml.uml.diagram.AttributesCompartmentContainer;
//#endif 


//#if -544752404 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 11161777 
import org.argouml.uml.diagram.ui.FigAttributesCompartment;
//#endif 


//#if -1253608760 
import org.argouml.uml.ui.foundation.core.ActionAddAttribute;
//#endif 


//#if 452269058 
public class FigClassifierBoxWithAttributes extends 
//#if 726732213 
FigClassifierBox
//#endif 

 implements 
//#if -616782475 
AttributesCompartmentContainer
//#endif 

  { 

//#if 512908034 
private static final Logger LOG =
        Logger.getLogger(FigClassifierBoxWithAttributes.class);
//#endif 


//#if -1148236277 
private FigAttributesCompartment attributesFigCompartment;
//#endif 


//#if -931963930 
public void setAttributesVisible(boolean isVisible)
    { 

//#if 945989230 
setCompartmentVisible(attributesFigCompartment, isVisible);
//#endif 

} 

//#endif 


//#if -104249177 

//#if 552700887 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    @Override
    public void setOwner(Object owner)
    { 

//#if 1168357558 
attributesFigCompartment.setOwner(owner);
//#endif 


//#if -1673781118 
super.setOwner(owner);
//#endif 

} 

//#endif 


//#if 1310195565 
@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 

//#if -908736217 
Set<Object[]> listeners = new HashSet<Object[]>();
//#endif 


//#if -1771632730 
if(newOwner != null)//1
{ 

//#if 1529449351 
listeners.add(new Object[] {newOwner, null});
//#endif 


//#if -202167771 
for (Object stereotype
                    : Model.getFacade().getStereotypes(newOwner)) //1
{ 

//#if 419085484 
listeners.add(new Object[] {stereotype, null});
//#endif 

} 

//#endif 


//#if -1715038139 
for (Object feat : Model.getFacade().getFeatures(newOwner)) //1
{ 

//#if -1838225219 
listeners.add(new Object[] {feat, null});
//#endif 


//#if -1411827537 
for (Object stereotype
                        : Model.getFacade().getStereotypes(feat)) //1
{ 

//#if 399386355 
listeners.add(new Object[] {stereotype, null});
//#endif 

} 

//#endif 


//#if 970898997 
if(Model.getFacade().isAOperation(feat))//1
{ 

//#if -2098044526 
for (Object param : Model.getFacade().getParameters(feat)) //1
{ 

//#if -1937633667 
listeners.add(new Object[] {param, null});
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -806605704 
updateElementListeners(listeners);
//#endif 

} 

//#endif 


//#if 121546862 
protected FigAttributesCompartment getAttributesFig()
    { 

//#if -2133453398 
return attributesFigCompartment;
//#endif 

} 

//#endif 


//#if -1835509928 
@Override
    protected void setStandardBounds(final int x, final int y, final int width,
                                     final int height)
    { 

//#if 1744042158 
Rectangle oldBounds = getBounds();
//#endif 


//#if 672442320 
int w = Math.max(width, getMinimumSize().width);
//#endif 


//#if 1334138527 
int h = Math.max(height, getMinimumSize().height);
//#endif 


//#if 199423708 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if 130424905 
if(borderFig != null)//1
{ 

//#if 1771707040 
borderFig.setBounds(x, y, w, h);
//#endif 

} 

//#endif 


//#if -1079577893 
final int whitespace = h - getMinimumSize().height;
//#endif 


//#if 1575658438 
int currentHeight = 0;
//#endif 


//#if -2039334214 
if(getStereotypeFig().isVisible())//1
{ 

//#if 2146102010 
int stereotypeHeight = getStereotypeFig().getMinimumSize().height;
//#endif 


//#if 2123845767 
getStereotypeFig().setBounds(
                x,
                y,
                w,
                stereotypeHeight);
//#endif 


//#if 1761808978 
currentHeight += stereotypeHeight;
//#endif 

} 

//#endif 


//#if -1502582115 
int nameHeight = getNameFig().getMinimumSize().height;
//#endif 


//#if -956538539 
getNameFig().setBounds(x, y + currentHeight, w, nameHeight);
//#endif 


//#if -369459064 
currentHeight += nameHeight;
//#endif 


//#if 810622496 
if(isAttributesVisible())//1
{ 

//#if 1139120268 
int attributesHeight =
                attributesFigCompartment.getMinimumSize().height;
//#endif 


//#if 720016583 
if(isOperationsVisible())//1
{ 

//#if -675687105 
attributesHeight += whitespace / 2;
//#endif 

} 

//#endif 


//#if 1365492740 
attributesFigCompartment.setBounds(
                x,
                y + currentHeight,
                w,
                attributesHeight);
//#endif 


//#if 148766232 
currentHeight += attributesHeight;
//#endif 

} 

//#endif 


//#if -976221781 
if(isOperationsVisible())//1
{ 

//#if -1320158614 
int operationsY = y + currentHeight;
//#endif 


//#if 42383569 
int operationsHeight = (h + y) - operationsY - LINE_WIDTH;
//#endif 


//#if 977439512 
if(operationsHeight < getOperationsFig().getMinimumSize().height)//1
{ 

//#if 1488407675 
operationsHeight = getOperationsFig().getMinimumSize().height;
//#endif 

} 

//#endif 


//#if -1535443865 
getOperationsFig().setBounds(
                x,
                operationsY,
                w,
                operationsHeight);
//#endif 

} 

//#endif 


//#if -281574465 
calcBounds();
//#endif 


//#if -795325186 
updateEdges();
//#endif 


//#if -1827620931 
LOG.debug("Bounds change : old - " + oldBounds + ", new - "
                  + getBounds());
//#endif 


//#if 1825012475 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if -1931897254 
@Override
    public Dimension getMinimumSize()
    { 

//#if -1507544817 
Dimension aSize = getNameFig().getMinimumSize();
//#endif 


//#if -1558005391 
aSize.height += NAME_V_PADDING * 2;
//#endif 


//#if 193343556 
aSize.height = Math.max(NAME_FIG_HEIGHT, aSize.height);
//#endif 


//#if -869259275 
aSize = addChildDimensions(aSize, getStereotypeFig());
//#endif 


//#if -654989776 
aSize = addChildDimensions(aSize, getAttributesFig());
//#endif 


//#if 79877627 
aSize = addChildDimensions(aSize, getOperationsFig());
//#endif 


//#if -930797432 
aSize.width = Math.max(WIDTH, aSize.width);
//#endif 


//#if 188301842 
return aSize;
//#endif 

} 

//#endif 


//#if 1184872309 
@Override
    protected void updateLayout(UmlChangeEvent event)
    { 

//#if 820379230 
super.updateLayout(event);
//#endif 


//#if -482840891 
if(event instanceof AttributeChangeEvent)//1
{ 

//#if 1650796561 
Object source = event.getSource();
//#endif 


//#if -1625708271 
if(Model.getFacade().isAAttribute(source))//1
{ 

//#if 1568758453 
updateAttributes();
//#endif 

} 

//#endif 

} 
else

//#if -1433873619 
if(event instanceof AssociationChangeEvent
                   && getOwner().equals(event.getSource()))//1
{ 

//#if 1412509874 
Object o = null;
//#endif 


//#if 1273229810 
if(event instanceof AddAssociationEvent)//1
{ 

//#if 1756805526 
o = event.getNewValue();
//#endif 

} 
else

//#if 2105760283 
if(event instanceof RemoveAssociationEvent)//1
{ 

//#if -1905736412 
o = event.getOldValue();
//#endif 

} 

//#endif 


//#endif 


//#if -3644435 
if(Model.getFacade().isAAttribute(o))//1
{ 

//#if 1869963867 
updateAttributes();
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 71128354 
public boolean isAttributesVisible()
    { 

//#if 754116157 
return attributesFigCompartment != null
               && attributesFigCompartment.isVisible();
//#endif 

} 

//#endif 


//#if 552836972 
public Rectangle getAttributesBounds()
    { 

//#if 1125640095 
return attributesFigCompartment.getBounds();
//#endif 

} 

//#endif 


//#if -1707987453 
@Override
    public void renderingChanged()
    { 

//#if -2042243005 
super.renderingChanged();
//#endif 


//#if 411845784 
if(getOwner() != null)//1
{ 

//#if 929083879 
updateAttributes();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 671821714 
@Override
    protected ArgoJMenu buildAddMenu()
    { 

//#if 286264710 
ArgoJMenu addMenu = super.buildAddMenu();
//#endif 


//#if 1108495703 
Action addAttribute = new ActionAddAttribute();
//#endif 


//#if -161603990 
addAttribute.setEnabled(isSingleTarget());
//#endif 


//#if 78467604 
addMenu.insert(addAttribute, 0);
//#endif 


//#if -490427159 
return addMenu;
//#endif 

} 

//#endif 


//#if 494428113 

//#if 1259208541 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigClassifierBoxWithAttributes()
    { 

//#if 2034516790 
super();
//#endif 


//#if -1506442140 
attributesFigCompartment = new FigAttributesCompartment(
            DEFAULT_COMPARTMENT_BOUNDS.x,
            DEFAULT_COMPARTMENT_BOUNDS.y,
            DEFAULT_COMPARTMENT_BOUNDS.width,
            DEFAULT_COMPARTMENT_BOUNDS.height);
//#endif 

} 

//#endif 


//#if -1488453663 
@Override
    public String classNameAndBounds()
    { 

//#if 1868771081 
return super.classNameAndBounds()
               + "attributesVisible=" + isAttributesVisible() + ";";
//#endif 

} 

//#endif 


//#if 1482394260 
protected void updateAttributes()
    { 

//#if -265920057 
if(!isAttributesVisible())//1
{ 

//#if -647984200 
return;
//#endif 

} 

//#endif 


//#if 2038994884 
attributesFigCompartment.populate();
//#endif 


//#if 1883934256 
setBounds(getBounds());
//#endif 

} 

//#endif 


//#if 50663645 
public FigClassifierBoxWithAttributes(Object owner, Rectangle bounds,
                                          DiagramSettings settings)
    { 

//#if 1895521703 
super(owner, bounds, settings);
//#endif 


//#if 1746151038 
attributesFigCompartment = new FigAttributesCompartment(owner,
                DEFAULT_COMPARTMENT_BOUNDS, settings);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

