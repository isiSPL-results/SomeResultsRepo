// Compilation Unit of /FigComponent.java 
 
package org.argouml.uml.diagram.deployment.ui;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.argouml.model.Model;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
import org.tigris.gef.base.Selection;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigText;
public class FigComponent extends AbstractFigComponent
  { 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigComponent()
    { 
super();
} 

public FigComponent(Object owner, Rectangle bounds,
                        DiagramSettings settings)
    { 
super(owner, bounds, settings);
} 

@Override
    public void setEnclosingFig(Fig encloser)
    { 
Object comp = getOwner();
if(encloser != null
                && (Model.getFacade().isANode(encloser.getOwner())
                    || Model.getFacade().isAComponent(encloser.getOwner()))
                && getOwner() != null)//1
{ 
if(Model.getFacade().isANode(encloser.getOwner()))//1
{ 
Object node = encloser.getOwner();
if(!Model.getFacade().getDeploymentLocations(comp).contains(
                            node))//1
{ 
Model.getCoreHelper().addDeploymentLocation(comp, node);
} 

} 

super.setEnclosingFig(encloser);
if(getLayer() != null)//1
{ 
List contents = new ArrayList(getLayer().getContents());
Iterator it = contents.iterator();
while (it.hasNext()) //1
{ 
Object o = it.next();
if(o instanceof FigEdgeModelElement)//1
{ 
FigEdgeModelElement figedge = (FigEdgeModelElement) o;
figedge.getLayer().bringToFront(figedge);
} 

} 

} 

} 
else
if(encloser == null && getEnclosingFig() != null)//1
{ 
Object encloserOwner = getEnclosingFig().getOwner();
if(Model.getFacade().isANode(encloserOwner)
                    && (Model.getFacade().getDeploymentLocations(comp)
                        .contains(encloserOwner)))//1
{ 
Model.getCoreHelper().removeDeploymentLocation(comp,
                        encloserOwner);
} 

super.setEnclosingFig(encloser);
} 


} 

@Override
    protected void textEditStarted(FigText ft)
    { 
if(ft == getNameFig())//1
{ 
showHelp("parsing.help.fig-component");
} 

} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigComponent(GraphModel gm, Object node)
    { 
super(gm, node);
} 

@Override
    public Selection makeSelection()
    { 
return new SelectionComponent(this);
} 

@Override
    public Vector getPopUpActions(MouseEvent me)
    { 
Vector popUpActions = super.getPopUpActions(me);
popUpActions.add(
            popUpActions.size() - getPopupAddOffset(),
            buildModifierPopUp(ABSTRACT | LEAF | ROOT));
return popUpActions;
} 

 } 


