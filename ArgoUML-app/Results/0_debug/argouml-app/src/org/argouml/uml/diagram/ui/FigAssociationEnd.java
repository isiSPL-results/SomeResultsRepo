
//#if -264369083 
// Compilation Unit of /FigAssociationEnd.java 
 

//#if -1602533657 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 84434999 
import java.awt.Color;
//#endif 


//#if -305942607 
import java.awt.Graphics;
//#endif 


//#if -1135257980 
import java.util.HashSet;
//#endif 


//#if -1860829482 
import java.util.Set;
//#endif 


//#if 590102513 
import org.argouml.model.Model;
//#endif 


//#if -940494162 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if 990179284 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -680687004 
import org.tigris.gef.base.Layer;
//#endif 


//#if 1565608635 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 660953831 
public class FigAssociationEnd extends 
//#if -1279960187 
FigEdgeModelElement
//#endif 

  { 

//#if -184535561 
private FigAssociationEndAnnotation destGroup;
//#endif 


//#if -1648745478 
private FigMultiplicity destMult;
//#endif 


//#if 397169742 
@Override
    protected void updateStereotypeText()
    { 
} 

//#endif 


//#if 2098232197 

//#if 641329520 
@SuppressWarnings("deprecation")
//#endif 


    private void initializeNotationProvidersInternal(Object own)
    { 

//#if 241912760 
super.initNotationProviders(own);
//#endif 


//#if 931637585 
destMult.initNotationProviders();
//#endif 


//#if -2077354965 
initNotationArguments();
//#endif 

} 

//#endif 


//#if -849370542 
protected void initNotationArguments()
    { 
} 

//#endif 


//#if -2147302425 

//#if 907767110 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    @Override
    public void setOwner(Object owner)
    { 

//#if 1110715575 
super.setOwner(owner);
//#endif 


//#if -113039243 
destGroup.setOwner(owner);
//#endif 


//#if 251426292 
destMult.setOwner(owner);
//#endif 

} 

//#endif 


//#if 1167072066 
@Override
    public void updateListeners(Object oldOwner, Object newOwner)
    { 

//#if 269234436 
Set<Object[]> listeners = new HashSet<Object[]>();
//#endif 


//#if 163662121 
if(newOwner != null)//1
{ 

//#if -1432673036 
listeners.add(new Object[] {newOwner,
                                        new String[] {"isAbstract", "remove"}
                                       });
//#endif 

} 

//#endif 


//#if 58832853 
updateElementListeners(listeners);
//#endif 

} 

//#endif 


//#if -1122228729 

//#if 1054281224 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigAssociationEnd(Object owner, Layer lay)
    { 

//#if -1096755423 
this();
//#endif 


//#if -1542432072 
setLayer(lay);
//#endif 


//#if -1273196823 
setOwner(owner);
//#endif 


//#if 111072487 
if(Model.getFacade().isAAssociationEnd(owner))//1
{ 

//#if 10613705 
addElementListener(owner);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 454344550 
@Override
    protected int getNotationProviderType()
    { 

//#if 1284231310 
return NotationProviderFactory2.TYPE_ASSOCIATION_END_NAME;
//#endif 

} 

//#endif 


//#if -1892390819 
@Override
    public void paintClarifiers(Graphics g)
    { 

//#if 1780187040 
indicateBounds(getNameFig(), g);
//#endif 


//#if 813467022 
indicateBounds(destMult, g);
//#endif 


//#if -1050970470 
indicateBounds(destGroup.getRole(), g);
//#endif 


//#if -767160283 
super.paintClarifiers(g);
//#endif 

} 

//#endif 


//#if 1821878957 
@Override
    protected void textEditStarted(FigText ft)
    { 

//#if -1016908139 
if(ft == destGroup.getRole())//1
{ 

//#if -1319120230 
destGroup.getRole().textEditStarted();
//#endif 

} 
else

//#if -1515253620 
if(ft == destMult)//1
{ 

//#if 1574499694 
destMult.textEditStarted();
//#endif 

} 
else
{ 

//#if -1099146261 
super.textEditStarted(ft);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1858578109 
@Override
    public void renderingChanged()
    { 

//#if 1281958372 
super.renderingChanged();
//#endif 


//#if -2043033679 
destMult.renderingChanged();
//#endif 


//#if -339038234 
destGroup.renderingChanged();
//#endif 


//#if 1956915953 
initNotationArguments();
//#endif 

} 

//#endif 


//#if -2133162057 
@Override
    protected void textEdited(FigText ft)
    { 

//#if 978454916 
if(getOwner() == null)//1
{ 

//#if -544017939 
return;
//#endif 

} 

//#endif 


//#if 950712619 
super.textEdited(ft);
//#endif 


//#if -792558931 
if(getOwner() == null)//2
{ 

//#if 1153221515 
return;
//#endif 

} 

//#endif 


//#if -757262049 
if(ft == destGroup.getRole())//1
{ 

//#if -1424606478 
destGroup.getRole().textEdited();
//#endif 

} 
else

//#if 1921711840 
if(ft == destMult)//1
{ 

//#if 1628699551 
destMult.textEdited();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 656870314 
public FigAssociationEnd(Object owner, DiagramSettings settings)
    { 

//#if 2002753717 
super(owner, settings);
//#endif 


//#if -1629043614 
destMult = new FigMultiplicity(owner, settings);
//#endif 


//#if -1917072930 
addPathItem(destMult,
                    new PathItemPlacement(this, destMult, 100, -5, 45, 5));
//#endif 


//#if 1735507322 
ArgoFigUtil.markPosition(this, 100, -5, 45, 5, Color.green);
//#endif 


//#if 1859285947 
destGroup = new FigAssociationEndAnnotation(this, owner, settings);
//#endif 


//#if -273516429 
addPathItem(destGroup,
                    new PathItemPlacement(this, destGroup, 100, -5, -45, 5));
//#endif 


//#if -2023733698 
ArgoFigUtil.markPosition(this, 100, -5, -45, 5, Color.blue);
//#endif 


//#if -1393779385 
setBetweenNearestPoints(true);
//#endif 


//#if 2145290160 
initializeNotationProvidersInternal(owner);
//#endif 

} 

//#endif 


//#if -146013121 

//#if 866515769 
@SuppressWarnings("deprecation")
//#endif 


    @Override
    protected void initNotationProviders(Object own)
    { 

//#if 1479290231 
initializeNotationProvidersInternal(own);
//#endif 

} 

//#endif 


//#if 155306236 
protected void updateMultiplicity()
    { 

//#if 1113557194 
if(getOwner() != null
                && destMult.getOwner() != null)//1
{ 

//#if 1505841734 
destMult.setText();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1738627598 

//#if 152840166 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigAssociationEnd()
    { 

//#if 1145866468 
super();
//#endif 


//#if 1770677521 
destMult = new FigMultiplicity();
//#endif 


//#if -434397047 
addPathItem(destMult,
                    new PathItemPlacement(this, destMult, 100, -5, 45, 5));
//#endif 


//#if 100845103 
ArgoFigUtil.markPosition(this, 100, -5, 45, 5, Color.green);
//#endif 


//#if 1389026982 
destGroup = new FigAssociationEndAnnotation(this);
//#endif 


//#if 680041960 
addPathItem(destGroup,
                    new PathItemPlacement(this, destGroup, 100, -5, -45, 5));
//#endif 


//#if 636571379 
ArgoFigUtil.markPosition(this, 100, -5, -45, 5, Color.blue);
//#endif 


//#if -982467854 
setBetweenNearestPoints(true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

