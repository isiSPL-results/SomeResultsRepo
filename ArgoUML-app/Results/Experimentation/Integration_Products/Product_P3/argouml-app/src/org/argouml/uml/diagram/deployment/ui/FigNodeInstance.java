package org.argouml.uml.diagram.deployment.ui;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import org.argouml.model.Model;
import org.argouml.notation.NotationProviderFactory2;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
import org.tigris.gef.base.Selection;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.Fig;
public class FigNodeInstance extends AbstractFigNode
  { 
@Override
    public Object clone()
    { 
Object clone = super.clone();
return clone;
} 
@Override
    public Selection makeSelection()
    { 
return new SelectionNodeInstance(this);
} 
@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 
super.updateListeners(oldOwner, newOwner);
if(newOwner != null)//1
{ 
for (Object classifier
                    : Model.getFacade().getClassifiers(newOwner)) //1
{ 
addElementListener(classifier, "name");
} 
} 
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigNodeInstance()
    { 
super();
getNameFig().setUnderline(true);
} 
public FigNodeInstance(Object owner, Rectangle bounds,
                           DiagramSettings settings)
    { 
super(owner, bounds, settings);
getNameFig().setUnderline(true);
} 
@Override
    protected int getNotationProviderType()
    { 
return NotationProviderFactory2.TYPE_NODEINSTANCE;
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigNodeInstance(GraphModel gm, Object node)
    { 
super(gm, node);
getNameFig().setUnderline(true);
} 
@Override
    public void setEnclosingFig(Fig encloser)
    { 
if(getOwner() != null)//1
{ 
Object nod = getOwner();
if(encloser != null)//1
{ 
Object comp = encloser.getOwner();
if(Model.getFacade().isAComponentInstance(comp))//1
{ 
if(Model.getFacade().getComponentInstance(nod) != comp)//1
{ 
Model.getCommonBehaviorHelper()
                        .setComponentInstance(nod, comp);
super.setEnclosingFig(encloser);
} 
} 
else
if(Model.getFacade().isANode(comp))//1
{ 
super.setEnclosingFig(encloser);
} 
} 
else
if(encloser == null)//1
{ 
if(isVisible()
                        // If we are not visible most likely
                        // we're being deleted.
                        // TODO: This indicates a more fundamental problem that
                        // should be investigated - tfm - 20061230
                        && Model.getFacade().getComponentInstance(nod) != null)//1
{ 
Model.getCommonBehaviorHelper()
                    .setComponentInstance(nod, null);
super.setEnclosingFig(encloser);
} 
} 
} 
if(getLayer() != null)//1
{ 
Collection contents = new ArrayList(getLayer().getContents());
for (Object o : contents) //1
{ 
if(o instanceof FigEdgeModelElement)//1
{ 
FigEdgeModelElement figedge = (FigEdgeModelElement) o;
figedge.getLayer().bringToFront(figedge);
} 
} 
} 
} 

 } 
