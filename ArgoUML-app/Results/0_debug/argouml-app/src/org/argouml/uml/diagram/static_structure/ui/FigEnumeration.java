
//#if -2120380821 
// Compilation Unit of /FigEnumeration.java 
 

//#if -39343459 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if 796310998 
import java.awt.Dimension;
//#endif 


//#if 782532333 
import java.awt.Rectangle;
//#endif 


//#if -1351568062 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -1574403198 
import java.util.HashSet;
//#endif 


//#if -1391240492 
import java.util.Set;
//#endif 


//#if -1351324606 
import javax.swing.Action;
//#endif 


//#if 317024565 
import org.argouml.model.AssociationChangeEvent;
//#endif 


//#if 5038992 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if 761083503 
import org.argouml.model.Model;
//#endif 


//#if 1653630893 
import org.argouml.ui.ArgoJMenu;
//#endif 


//#if -735761838 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -871860006 
import org.argouml.uml.diagram.ui.EnumLiteralsCompartmentContainer;
//#endif 


//#if 499856069 
import org.argouml.uml.diagram.ui.FigEnumLiteralsCompartment;
//#endif 


//#if -1430974172 
import org.argouml.uml.ui.foundation.core.ActionAddEnumerationLiteral;
//#endif 


//#if -2048141177 
import org.tigris.gef.base.Selection;
//#endif 


//#if 707301019 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -1399560740 
public class FigEnumeration extends 
//#if 1304843285 
FigDataType
//#endif 

 implements 
//#if -1502955033 
EnumLiteralsCompartmentContainer
//#endif 

  { 

//#if -1211586745 
private static final long serialVersionUID = 3333154292883077250L;
//#endif 


//#if 1902631494 
private FigEnumLiteralsCompartment literalsCompartment;
//#endif 


//#if -787125538 
public FigEnumLiteralsCompartment getLiteralsCompartment()
    { 

//#if -1066332513 
if(literalsCompartment == null)//1
{ 

//#if 1142352020 
literalsCompartment = new FigEnumLiteralsCompartment(getOwner(),
                    DEFAULT_COMPARTMENT_BOUNDS, getSettings());
//#endif 

} 

//#endif 


//#if 686318730 
return literalsCompartment;
//#endif 

} 

//#endif 


//#if -1010895731 

//#if -1941851423 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigEnumeration()
    { 

//#if -767671668 
super();
//#endif 


//#if 18701469 
enableSizeChecking(true);
//#endif 


//#if -970366207 
setSuppressCalcBounds(false);
//#endif 


//#if 997202819 
addFig(getLiteralsCompartment());
//#endif 


//#if -1626389440 
setBounds(getBounds());
//#endif 

} 

//#endif 


//#if -631383788 
@Override
    protected void setStandardBounds(final int x, final int y, final int width,
                                     final int height)
    { 

//#if -1343400757 
Rectangle oldBounds = getBounds();
//#endif 


//#if -1487887661 
int w = Math.max(width, getMinimumSize().width);
//#endif 


//#if -273769246 
int h = Math.max(height, getMinimumSize().height);
//#endif 


//#if -1022026145 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if 78508867 
borderFig.setBounds(x, y, w, h);
//#endif 


//#if 182420323 
int currentHeight = 0;
//#endif 


//#if -351580905 
if(getStereotypeFig().isVisible())//1
{ 

//#if -1289772791 
int stereotypeHeight = getStereotypeFig().getMinimumSize().height;
//#endif 


//#if 1424391510 
getStereotypeFig().setBounds(
                x,
                y,
                w,
                stereotypeHeight);
//#endif 


//#if -1858035165 
currentHeight += stereotypeHeight;
//#endif 

} 

//#endif 


//#if -1653107142 
int nameHeight = getNameFig().getMinimumSize().height;
//#endif 


//#if 1226471026 
getNameFig().setBounds(x, y + currentHeight, w, nameHeight);
//#endif 


//#if 1572161099 
currentHeight += nameHeight;
//#endif 


//#if -125426928 
int visibleCompartments = getOperationsFig().isVisible() ? 1 : 0;
//#endif 


//#if -1736279565 
if(getLiteralsCompartment().isVisible())//1
{ 

//#if -1712845935 
visibleCompartments++;
//#endif 


//#if -1226171703 
int literalsHeight =
                getLiteralsCompartment().getMinimumSize().height;
//#endif 


//#if -1650682868 
literalsHeight = Math.max(literalsHeight,
                                      (h - currentHeight) / visibleCompartments);
//#endif 


//#if -211097607 
getLiteralsCompartment().setBounds(
                x + LINE_WIDTH,
                y + currentHeight,
                w - LINE_WIDTH,
                literalsHeight);
//#endif 


//#if -1370934649 
currentHeight += literalsHeight;
//#endif 

} 

//#endif 


//#if -109447011 
if(getOperationsFig().isVisible())//1
{ 

//#if -667584779 
int operationsHeight = getOperationsFig().getMinimumSize().height;
//#endif 


//#if 974552239 
operationsHeight = Math.max(operationsHeight, h - currentHeight);
//#endif 


//#if -994219603 
getOperationsFig().setBounds(
                x,
                y + currentHeight,
                w,
                operationsHeight);
//#endif 


//#if 1207934641 
currentHeight += operationsHeight;
//#endif 

} 

//#endif 


//#if -1363174116 
calcBounds();
//#endif 


//#if 34824001 
updateEdges();
//#endif 


//#if -775488232 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if -359032498 
@Override
    protected ArgoJMenu buildAddMenu()
    { 

//#if 76223898 
ArgoJMenu addMenu = super.buildAddMenu();
//#endif 


//#if -1481017493 
Action addEnumerationLiteral = new ActionAddEnumerationLiteral();
//#endif 


//#if 1682219976 
addEnumerationLiteral.setEnabled(isSingleTarget());
//#endif 


//#if 1094515988 
addMenu.add(addEnumerationLiteral);
//#endif 


//#if -196759299 
return addMenu;
//#endif 

} 

//#endif 


//#if -1838698018 
public Rectangle getEnumLiteralsBounds()
    { 

//#if -981654461 
return literalsCompartment.getBounds();
//#endif 

} 

//#endif 


//#if -164035298 
@Override
    public Dimension getMinimumSize()
    { 

//#if 1354223138 
Dimension aSize = super.getMinimumSize();
//#endif 


//#if -534740285 
if(literalsCompartment != null)//1
{ 

//#if 57041835 
aSize = addChildDimensions(aSize, literalsCompartment);
//#endif 

} 

//#endif 


//#if -983338658 
return aSize;
//#endif 

} 

//#endif 


//#if 359158712 
public boolean isEnumLiteralsVisible()
    { 

//#if 1626517421 
return literalsCompartment.isVisible();
//#endif 

} 

//#endif 


//#if -1861036609 
@Override
    public void renderingChanged()
    { 

//#if 345976884 
super.renderingChanged();
//#endif 


//#if -1534270263 
if(getOwner() != null)//1
{ 

//#if -182084424 
updateEnumLiterals();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 347140026 
@Override
    protected String getKeyword()
    { 

//#if -983591388 
return "enumeration";
//#endif 

} 

//#endif 


//#if -1228012135 
public FigEnumeration(Object owner, Rectangle bounds,
                          DiagramSettings settings)
    { 

//#if 234895054 
super(owner, bounds, settings);
//#endif 


//#if 1604442578 
enableSizeChecking(true);
//#endif 


//#if 655506870 
setSuppressCalcBounds(false);
//#endif 


//#if -229469256 
addFig(getLiteralsCompartment());
//#endif 


//#if 1179001893 
setEnumLiteralsVisible(true);
//#endif 


//#if -1818786152 
literalsCompartment.populate();
//#endif 


//#if 730565301 
setBounds(getBounds());
//#endif 

} 

//#endif 


//#if 1356811037 
@Override
    protected void modelChanged(PropertyChangeEvent mee)
    { 

//#if 1571337551 
super.modelChanged(mee);
//#endif 


//#if 1441183326 
if(mee instanceof AssociationChangeEvent
                || mee instanceof AttributeChangeEvent)//1
{ 

//#if 38794281 
renderingChanged();
//#endif 


//#if -1311883325 
updateListeners(getOwner(), getOwner());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1112503172 

//#if -1438061494 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigEnumeration(@SuppressWarnings("unused") GraphModel gm,
                          Object node)
    { 

//#if -1335548082 
this();
//#endif 


//#if 463680604 
enableSizeChecking(true);
//#endif 


//#if 363014575 
setEnumLiteralsVisible(true);
//#endif 


//#if -1506701923 
setOwner(node);
//#endif 


//#if -3583582 
literalsCompartment.populate();
//#endif 


//#if -262799425 
setBounds(getBounds());
//#endif 

} 

//#endif 


//#if -289131970 
protected void updateEnumLiterals()
    { 

//#if 423016546 
if(!literalsCompartment.isVisible())//1
{ 

//#if 1600125952 
return;
//#endif 

} 

//#endif 


//#if 89681975 
literalsCompartment.populate();
//#endif 


//#if -498891948 
setBounds(getBounds());
//#endif 

} 

//#endif 


//#if -1468475139 
@Override
    public Object clone()
    { 

//#if 256478327 
FigEnumeration clone = (FigEnumeration) super.clone();
//#endif 


//#if -476384613 
clone.literalsCompartment =
            (FigEnumLiteralsCompartment) literalsCompartment.clone();
//#endif 


//#if -1490493740 
return clone;
//#endif 

} 

//#endif 


//#if -1382187396 
public void setEnumLiteralsVisible(boolean isVisible)
    { 

//#if -2068693362 
setCompartmentVisible(literalsCompartment, isVisible);
//#endif 

} 

//#endif 


//#if -128884687 
@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 

//#if -1738088416 
Set<Object[]> l = new HashSet<Object[]>();
//#endif 


//#if 1968850522 
if(newOwner != null)//1
{ 

//#if -157817028 
l.add(new Object[] {newOwner, null});
//#endif 


//#if -491412323 
for (Object stereo : Model.getFacade().getStereotypes(newOwner)) //1
{ 

//#if -374712978 
l.add(new Object[] {stereo, null});
//#endif 

} 

//#endif 


//#if 1827043975 
for (Object feat : Model.getFacade().getFeatures(newOwner)) //1
{ 

//#if 60788398 
l.add(new Object[] {feat, null});
//#endif 


//#if 837211243 
for (Object stereo : Model.getFacade().getStereotypes(feat)) //1
{ 

//#if -1699706068 
l.add(new Object[] {stereo, null});
//#endif 

} 

//#endif 

} 

//#endif 


//#if -304175008 
for (Object literal : Model.getFacade().getEnumerationLiterals(
                        newOwner)) //1
{ 

//#if 1789930585 
l.add(new Object[] {literal, null});
//#endif 

} 

//#endif 

} 

//#endif 


//#if -693760975 
updateElementListeners(l);
//#endif 

} 

//#endif 


//#if -1417351947 
@Override
    public Selection makeSelection()
    { 

//#if 1494618118 
return new SelectionEnumeration(this);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

