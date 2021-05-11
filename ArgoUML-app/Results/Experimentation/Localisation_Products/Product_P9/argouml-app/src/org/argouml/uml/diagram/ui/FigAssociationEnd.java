package org.argouml.uml.diagram.ui;
import java.awt.Color;
import java.awt.Graphics;
import java.util.HashSet;
import java.util.Set;
import org.argouml.model.Model;
import org.argouml.notation.NotationProviderFactory2;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.base.Layer;
import org.tigris.gef.presentation.FigText;
public class FigAssociationEnd extends FigEdgeModelElement
  { 
private FigAssociationEndAnnotation destGroup;
private FigMultiplicity destMult;
@Override
    protected void updateStereotypeText()
    { 
} 
@SuppressWarnings("deprecation")

    private void initializeNotationProvidersInternal(Object own)
    { 
super.initNotationProviders(own);
destMult.initNotationProviders();
initNotationArguments();
} 
protected void initNotationArguments()
    { 
} 
@SuppressWarnings("deprecation")

    @Deprecated
    @Override
    public void setOwner(Object owner)
    { 
super.setOwner(owner);
destGroup.setOwner(owner);
destMult.setOwner(owner);
} 
@Override
    public void updateListeners(Object oldOwner, Object newOwner)
    { 
Set<Object[]> listeners = new HashSet<Object[]>();
if(newOwner != null)//1
{ 
listeners.add(new Object[] {newOwner,
                                        new String[] {"isAbstract", "remove"}
                                       });
} 
updateElementListeners(listeners);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigAssociationEnd(Object owner, Layer lay)
    { 
this();
setLayer(lay);
setOwner(owner);
if(Model.getFacade().isAAssociationEnd(owner))//1
{ 
addElementListener(owner);
} 
} 
@Override
    protected int getNotationProviderType()
    { 
return NotationProviderFactory2.TYPE_ASSOCIATION_END_NAME;
} 
@Override
    public void paintClarifiers(Graphics g)
    { 
indicateBounds(getNameFig(), g);
indicateBounds(destMult, g);
indicateBounds(destGroup.getRole(), g);
super.paintClarifiers(g);
} 
@Override
    protected void textEditStarted(FigText ft)
    { 
if(ft == destGroup.getRole())//1
{ 
destGroup.getRole().textEditStarted();
} 
else
if(ft == destMult)//1
{ 
destMult.textEditStarted();
} 
else
{ 
super.textEditStarted(ft);
} 
} 
@Override
    public void renderingChanged()
    { 
super.renderingChanged();
destMult.renderingChanged();
destGroup.renderingChanged();
initNotationArguments();
} 
@Override
    protected void textEdited(FigText ft)
    { 
if(getOwner() == null)//1
{ 
return;
} 
super.textEdited(ft);
if(getOwner() == null)//2
{ 
return;
} 
if(ft == destGroup.getRole())//1
{ 
destGroup.getRole().textEdited();
} 
else
if(ft == destMult)//1
{ 
destMult.textEdited();
} 
} 
public FigAssociationEnd(Object owner, DiagramSettings settings)
    { 
super(owner, settings);
destMult = new FigMultiplicity(owner, settings);
addPathItem(destMult,
                    new PathItemPlacement(this, destMult, 100, -5, 45, 5));
ArgoFigUtil.markPosition(this, 100, -5, 45, 5, Color.green);
destGroup = new FigAssociationEndAnnotation(this, owner, settings);
addPathItem(destGroup,
                    new PathItemPlacement(this, destGroup, 100, -5, -45, 5));
ArgoFigUtil.markPosition(this, 100, -5, -45, 5, Color.blue);
setBetweenNearestPoints(true);
initializeNotationProvidersInternal(owner);
} 
@SuppressWarnings("deprecation")

    @Override
    protected void initNotationProviders(Object own)
    { 
initializeNotationProvidersInternal(own);
} 
protected void updateMultiplicity()
    { 
if(getOwner() != null
                && destMult.getOwner() != null)//1
{ 
destMult.setText();
} 
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigAssociationEnd()
    { 
super();
destMult = new FigMultiplicity();
addPathItem(destMult,
                    new PathItemPlacement(this, destMult, 100, -5, 45, 5));
ArgoFigUtil.markPosition(this, 100, -5, 45, 5, Color.green);
destGroup = new FigAssociationEndAnnotation(this);
addPathItem(destGroup,
                    new PathItemPlacement(this, destGroup, 100, -5, -45, 5));
ArgoFigUtil.markPosition(this, 100, -5, -45, 5, Color.blue);
setBetweenNearestPoints(true);
} 

 } 
