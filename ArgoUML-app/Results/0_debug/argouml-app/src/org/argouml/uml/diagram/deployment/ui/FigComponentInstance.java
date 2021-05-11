
//#if 344788382 
// Compilation Unit of /FigComponentInstance.java 
 

//#if -2056559827 
package org.argouml.uml.diagram.deployment.ui;
//#endif 


//#if -2085684710 
import java.awt.Rectangle;
//#endif 


//#if 1288627044 
import java.awt.event.MouseEvent;
//#endif 


//#if -1775579790 
import java.util.ArrayList;
//#endif 


//#if 1865577183 
import java.util.Iterator;
//#endif 


//#if 1689274799 
import java.util.List;
//#endif 


//#if -1619939486 
import org.argouml.model.Model;
//#endif 


//#if -741472417 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if -813212347 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -584218838 
import org.argouml.uml.diagram.ui.ArgoFig;
//#endif 


//#if -128738399 
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
//#endif 


//#if 1014993219 
import org.tigris.gef.base.Editor;
//#endif 


//#if -744502570 
import org.tigris.gef.base.Globals;
//#endif 


//#if 995135290 
import org.tigris.gef.base.Selection;
//#endif 


//#if 423257230 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -514627751 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1429600780 
public class FigComponentInstance extends 
//#if 282490827 
AbstractFigComponent
//#endif 

  { 

//#if -1876505974 
@Override
    public void mousePressed(MouseEvent me)
    { 

//#if 1948454136 
super.mousePressed(me);
//#endif 


//#if -919852593 
Editor ce = Globals.curEditor();
//#endif 


//#if -1619630619 
Selection sel = ce.getSelectionManager().findSelectionFor(this);
//#endif 


//#if 1771774995 
if(sel instanceof SelectionComponentInstance)//1
{ 

//#if -1270289446 
((SelectionComponentInstance) sel).hideButtons();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -598918949 

//#if -56276006 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigComponentInstance()
    { 

//#if -457024393 
super();
//#endif 


//#if -1625511764 
getNameFig().setUnderline(true);
//#endif 

} 

//#endif 


//#if 690805927 
@Override
    protected int getNotationProviderType()
    { 

//#if -73294671 
return NotationProviderFactory2.TYPE_COMPONENTINSTANCE;
//#endif 

} 

//#endif 


//#if -617993094 
@Override
    public Object clone()
    { 

//#if 1291998943 
FigComponentInstance figClone = (FigComponentInstance) super.clone();
//#endif 


//#if -2038308008 
return figClone;
//#endif 

} 

//#endif 


//#if -1431404471 
@Override
    public void setEnclosingFig(Fig encloser)
    { 

//#if 1307169494 
if(getOwner() != null)//1
{ 

//#if 2051700604 
Object comp = getOwner();
//#endif 


//#if -1657109781 
if(encloser != null)//1
{ 

//#if 1118766858 
Object nodeOrComp = encloser.getOwner();
//#endif 


//#if -480546264 
if(Model.getFacade().isANodeInstance(nodeOrComp))//1
{ 

//#if -1306039070 
if(Model.getFacade()
                            .getNodeInstance(comp) != nodeOrComp)//1
{ 

//#if -213590043 
Model.getCommonBehaviorHelper()
                        .setNodeInstance(comp, nodeOrComp);
//#endif 


//#if 1998280948 
super.setEnclosingFig(encloser);
//#endif 

} 

//#endif 

} 
else

//#if 71642405 
if(Model.getFacade().isAComponentInstance(nodeOrComp))//1
{ 

//#if 745197081 
if(Model.getFacade()
                            .getComponentInstance(comp) != nodeOrComp)//1
{ 

//#if 1196894614 
Model.getCommonBehaviorHelper()
                        .setComponentInstance(comp, nodeOrComp);
//#endif 


//#if -843282192 
super.setEnclosingFig(encloser);
//#endif 

} 

//#endif 

} 
else

//#if 2146236576 
if(Model.getFacade().isANode(nodeOrComp))//1
{ 

//#if 1671229564 
super.setEnclosingFig(encloser);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#if -86116000 
if(getLayer() != null)//1
{ 

//#if -1918426814 
List contents = new ArrayList(getLayer().getContents());
//#endif 


//#if -1310514057 
Iterator it = contents.iterator();
//#endif 


//#if 1463801391 
while (it.hasNext()) //1
{ 

//#if 1489316769 
Object o = it.next();
//#endif 


//#if -823194276 
if(o instanceof FigEdgeModelElement)//1
{ 

//#if -1257303396 
FigEdgeModelElement figedge =
                                (FigEdgeModelElement) o;
//#endif 


//#if -1037413591 
figedge.getLayer().bringToFront(figedge);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if 2068620586 
if(isVisible()
                       // If we are not visible most likely we're being deleted.
                       // TODO: This indicates a more fundamental problem that
                       // should be investigated - tfm - 20061230
                       && encloser == null && getEnclosingFig() != null)//1
{ 

//#if 1987369665 
if(Model.getFacade().getNodeInstance(comp) != null)//1
{ 

//#if -13086062 
Model.getCommonBehaviorHelper()
                    .setNodeInstance(comp, null);
//#endif 

} 

//#endif 


//#if -986759422 
if(Model.getFacade().getComponentInstance(comp) != null)//1
{ 

//#if -120423557 
Model.getCommonBehaviorHelper()
                    .setComponentInstance(comp, null);
//#endif 

} 

//#endif 


//#if 1178388634 
super.setEnclosingFig(encloser);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 182800651 

//#if 1931083450 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigComponentInstance(GraphModel gm, Object node)
    { 

//#if -872705741 
super(gm, node);
//#endif 


//#if 1335844494 
getNameFig().setUnderline(true);
//#endif 

} 

//#endif 


//#if -359696040 
@Override
    public Selection makeSelection()
    { 

//#if 1494724236 
return new SelectionComponentInstance(this);
//#endif 

} 

//#endif 


//#if -422329905 
@Override
    public void mouseClicked(MouseEvent me)
    { 

//#if -1671887415 
super.mouseClicked(me);
//#endif 


//#if 640215601 
setLineColor(LINE_COLOR);
//#endif 

} 

//#endif 


//#if -89240719 
public FigComponentInstance(Object owner, Rectangle bounds,
                                DiagramSettings settings)
    { 

//#if 1470923915 
super(owner, bounds, settings);
//#endif 


//#if -1402303985 
getNameFig().setUnderline(true);
//#endif 

} 

//#endif 


//#if 2116596398 
@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 

//#if -1934446767 
super.updateListeners(oldOwner, newOwner);
//#endif 


//#if 1047488538 
if(newOwner != null)//1
{ 

//#if -286124650 
for (Object classifier
                    : Model.getFacade().getClassifiers(newOwner)) //1
{ 

//#if 538949251 
addElementListener(classifier, "name");
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

