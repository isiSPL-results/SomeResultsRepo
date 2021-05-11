
//#if -1319948102 
// Compilation Unit of /FigNodeInstance.java 
 

//#if -2085592471 
package org.argouml.uml.diagram.deployment.ui;
//#endif 


//#if 1286008662 
import java.awt.Rectangle;
//#endif 


//#if -332300362 
import java.util.ArrayList;
//#endif 


//#if -371778453 
import java.util.Collection;
//#endif 


//#if 1385013158 
import org.argouml.model.Model;
//#endif 


//#if -1518162781 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if -1713224311 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1563664093 
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
//#endif 


//#if -757056386 
import org.tigris.gef.base.Selection;
//#endif 


//#if 194236626 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -743648355 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1977432185 
public class FigNodeInstance extends 
//#if 2012046753 
AbstractFigNode
//#endif 

  { 

//#if -1064082835 
@Override
    public Object clone()
    { 

//#if -1437942633 
Object clone = super.clone();
//#endif 


//#if 431097846 
return clone;
//#endif 

} 

//#endif 


//#if -832365179 
@Override
    public Selection makeSelection()
    { 

//#if -1519792159 
return new SelectionNodeInstance(this);
//#endif 

} 

//#endif 


//#if -1417561695 
@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 

//#if 995366353 
super.updateListeners(oldOwner, newOwner);
//#endif 


//#if -1109061990 
if(newOwner != null)//1
{ 

//#if 652757639 
for (Object classifier
                    : Model.getFacade().getClassifiers(newOwner)) //1
{ 

//#if -506285091 
addElementListener(classifier, "name");
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 394851075 

//#if 1418364861 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigNodeInstance()
    { 

//#if 1932711410 
super();
//#endif 


//#if 891756839 
getNameFig().setUnderline(true);
//#endif 

} 

//#endif 


//#if -596337911 
public FigNodeInstance(Object owner, Rectangle bounds,
                           DiagramSettings settings)
    { 

//#if 1739301973 
super(owner, bounds, settings);
//#endif 


//#if 914284037 
getNameFig().setUnderline(true);
//#endif 

} 

//#endif 


//#if 1699584986 
@Override
    protected int getNotationProviderType()
    { 

//#if 1988195642 
return NotationProviderFactory2.TYPE_NODEINSTANCE;
//#endif 

} 

//#endif 


//#if -547968541 

//#if 1479860919 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigNodeInstance(GraphModel gm, Object node)
    { 

//#if 1477965271 
super(gm, node);
//#endif 


//#if -389261718 
getNameFig().setUnderline(true);
//#endif 

} 

//#endif 


//#if -224024714 
@Override
    public void setEnclosingFig(Fig encloser)
    { 

//#if 1142730260 
if(getOwner() != null)//1
{ 

//#if 113109180 
Object nod = getOwner();
//#endif 


//#if -1406939087 
if(encloser != null)//1
{ 

//#if -27551023 
Object comp = encloser.getOwner();
//#endif 


//#if 1743619954 
if(Model.getFacade().isAComponentInstance(comp))//1
{ 

//#if -1724896612 
if(Model.getFacade().getComponentInstance(nod) != comp)//1
{ 

//#if 478407047 
Model.getCommonBehaviorHelper()
                        .setComponentInstance(nod, comp);
//#endif 


//#if -564358496 
super.setEnclosingFig(encloser);
//#endif 

} 

//#endif 

} 
else

//#if -1908009883 
if(Model.getFacade().isANode(comp))//1
{ 

//#if 1754251888 
super.setEnclosingFig(encloser);
//#endif 

} 

//#endif 


//#endif 

} 
else

//#if 110223735 
if(encloser == null)//1
{ 

//#if 194907167 
if(isVisible()
                        // If we are not visible most likely
                        // we're being deleted.
                        // TODO: This indicates a more fundamental problem that
                        // should be investigated - tfm - 20061230
                        && Model.getFacade().getComponentInstance(nod) != null)//1
{ 

//#if 1821034454 
Model.getCommonBehaviorHelper()
                    .setComponentInstance(nod, null);
//#endif 


//#if 1731079081 
super.setEnclosingFig(encloser);
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -872180814 
if(getLayer() != null)//1
{ 

//#if -1036083187 
Collection contents = new ArrayList(getLayer().getContents());
//#endif 


//#if -1142383973 
for (Object o : contents) //1
{ 

//#if 44388080 
if(o instanceof FigEdgeModelElement)//1
{ 

//#if 283886261 
FigEdgeModelElement figedge = (FigEdgeModelElement) o;
//#endif 


//#if -21531920 
figedge.getLayer().bringToFront(figedge);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

