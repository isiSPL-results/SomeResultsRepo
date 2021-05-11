
//#if 1952434990 
// Compilation Unit of /FigComponent.java 
 

//#if 418447222 
package org.argouml.uml.diagram.deployment.ui;
//#endif 


//#if 42783971 
import java.awt.Rectangle;
//#endif 


//#if 458491003 
import java.awt.event.MouseEvent;
//#endif 


//#if -217560119 
import java.util.ArrayList;
//#endif 


//#if -300921432 
import java.util.Iterator;
//#endif 


//#if 271905016 
import java.util.List;
//#endif 


//#if -536421837 
import java.util.Vector;
//#endif 


//#if 975841849 
import org.argouml.model.Model;
//#endif 


//#if -1397405156 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 838917866 
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
//#endif 


//#if 295783633 
import org.tigris.gef.base.Selection;
//#endif 


//#if -1638786971 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 1718295344 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1181087485 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 1903539528 
public class FigComponent extends 
//#if 150600486 
AbstractFigComponent
//#endif 

  { 

//#if -850185173 

//#if -1378521062 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigComponent()
    { 

//#if 1999362917 
super();
//#endif 

} 

//#endif 


//#if 1267197899 
public FigComponent(Object owner, Rectangle bounds,
                        DiagramSettings settings)
    { 

//#if 625587385 
super(owner, bounds, settings);
//#endif 

} 

//#endif 


//#if 1170127886 
@Override
    public void setEnclosingFig(Fig encloser)
    { 

//#if -256636290 
Object comp = getOwner();
//#endif 


//#if -945484630 
if(encloser != null
                && (Model.getFacade().isANode(encloser.getOwner())
                    || Model.getFacade().isAComponent(encloser.getOwner()))
                && getOwner() != null)//1
{ 

//#if -1695254585 
if(Model.getFacade().isANode(encloser.getOwner()))//1
{ 

//#if -374680330 
Object node = encloser.getOwner();
//#endif 


//#if 967009583 
if(!Model.getFacade().getDeploymentLocations(comp).contains(
                            node))//1
{ 

//#if -1720044575 
Model.getCoreHelper().addDeploymentLocation(comp, node);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1885350099 
super.setEnclosingFig(encloser);
//#endif 


//#if -1903651211 
if(getLayer() != null)//1
{ 

//#if 988504772 
List contents = new ArrayList(getLayer().getContents());
//#endif 


//#if -1248414283 
Iterator it = contents.iterator();
//#endif 


//#if 1187923761 
while (it.hasNext()) //1
{ 

//#if -1240648576 
Object o = it.next();
//#endif 


//#if 1901314589 
if(o instanceof FigEdgeModelElement)//1
{ 

//#if 94879483 
FigEdgeModelElement figedge = (FigEdgeModelElement) o;
//#endif 


//#if -1292931094 
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

//#if -2021232779 
if(encloser == null && getEnclosingFig() != null)//1
{ 

//#if -823830452 
Object encloserOwner = getEnclosingFig().getOwner();
//#endif 


//#if -1101606067 
if(Model.getFacade().isANode(encloserOwner)
                    && (Model.getFacade().getDeploymentLocations(comp)
                        .contains(encloserOwner)))//1
{ 

//#if -950677000 
Model.getCoreHelper().removeDeploymentLocation(comp,
                        encloserOwner);
//#endif 

} 

//#endif 


//#if -1337522692 
super.setEnclosingFig(encloser);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 471120009 
@Override
    protected void textEditStarted(FigText ft)
    { 

//#if 132201700 
if(ft == getNameFig())//1
{ 

//#if -1266738328 
showHelp("parsing.help.fig-component");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 198286267 

//#if 601041608 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigComponent(GraphModel gm, Object node)
    { 

//#if 278504316 
super(gm, node);
//#endif 

} 

//#endif 


//#if 1757825565 
@Override
    public Selection makeSelection()
    { 

//#if 1656849394 
return new SelectionComponent(this);
//#endif 

} 

//#endif 


//#if -990944018 
@Override
    public Vector getPopUpActions(MouseEvent me)
    { 

//#if -2124818227 
Vector popUpActions = super.getPopUpActions(me);
//#endif 


//#if 439373657 
popUpActions.add(
            popUpActions.size() - getPopupAddOffset(),
            buildModifierPopUp(ABSTRACT | LEAF | ROOT));
//#endif 


//#if -1963780608 
return popUpActions;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

