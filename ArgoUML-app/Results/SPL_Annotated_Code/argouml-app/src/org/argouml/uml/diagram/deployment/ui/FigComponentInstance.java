// Compilation Unit of /FigComponentInstance.java 
 
package org.argouml.uml.diagram.deployment.ui;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.argouml.model.Model;
import org.argouml.notation.NotationProviderFactory2;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.ArgoFig;
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.Selection;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.Fig;
public class FigComponentInstance extends AbstractFigComponent
  { 
@Override
    public void mousePressed(MouseEvent me)
    { 
super.mousePressed(me);
Editor ce = Globals.curEditor();
Selection sel = ce.getSelectionManager().findSelectionFor(this);
if(sel instanceof SelectionComponentInstance)//1
{ 
((SelectionComponentInstance) sel).hideButtons();
} 

} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigComponentInstance()
    { 
super();
getNameFig().setUnderline(true);
} 

@Override
    protected int getNotationProviderType()
    { 
return NotationProviderFactory2.TYPE_COMPONENTINSTANCE;
} 

@Override
    public Object clone()
    { 
FigComponentInstance figClone = (FigComponentInstance) super.clone();
return figClone;
} 

@Override
    public void setEnclosingFig(Fig encloser)
    { 
if(getOwner() != null)//1
{ 
Object comp = getOwner();
if(encloser != null)//1
{ 
Object nodeOrComp = encloser.getOwner();
if(Model.getFacade().isANodeInstance(nodeOrComp))//1
{ 
if(Model.getFacade()
                            .getNodeInstance(comp) != nodeOrComp)//1
{ 
Model.getCommonBehaviorHelper()
                        .setNodeInstance(comp, nodeOrComp);
super.setEnclosingFig(encloser);
} 

} 
else
if(Model.getFacade().isAComponentInstance(nodeOrComp))//1
{ 
if(Model.getFacade()
                            .getComponentInstance(comp) != nodeOrComp)//1
{ 
Model.getCommonBehaviorHelper()
                        .setComponentInstance(comp, nodeOrComp);
super.setEnclosingFig(encloser);
} 

} 
else
if(Model.getFacade().isANode(nodeOrComp))//1
{ 
super.setEnclosingFig(encloser);
} 



if(getLayer() != null)//1
{ 
List contents = new ArrayList(getLayer().getContents());
Iterator it = contents.iterator();
while (it.hasNext()) //1
{ 
Object o = it.next();
if(o instanceof FigEdgeModelElement)//1
{ 
FigEdgeModelElement figedge =
                                (FigEdgeModelElement) o;
figedge.getLayer().bringToFront(figedge);
} 

} 

} 

} 
else
if(isVisible()
                       // If we are not visible most likely we're being deleted.
                       // TODO: This indicates a more fundamental problem that
                       // should be investigated - tfm - 20061230
                       && encloser == null && getEnclosingFig() != null)//1
{ 
if(Model.getFacade().getNodeInstance(comp) != null)//1
{ 
Model.getCommonBehaviorHelper()
                    .setNodeInstance(comp, null);
} 

if(Model.getFacade().getComponentInstance(comp) != null)//1
{ 
Model.getCommonBehaviorHelper()
                    .setComponentInstance(comp, null);
} 

super.setEnclosingFig(encloser);
} 


} 

} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigComponentInstance(GraphModel gm, Object node)
    { 
super(gm, node);
getNameFig().setUnderline(true);
} 

@Override
    public Selection makeSelection()
    { 
return new SelectionComponentInstance(this);
} 

@Override
    public void mouseClicked(MouseEvent me)
    { 
super.mouseClicked(me);
setLineColor(LINE_COLOR);
} 

public FigComponentInstance(Object owner, Rectangle bounds,
                                DiagramSettings settings)
    { 
super(owner, bounds, settings);
getNameFig().setUnderline(true);
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

 } 


