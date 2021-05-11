
//#if 1104788997 
// Compilation Unit of /FigTransition.java 
 

//#if -908427434 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if -1371598083 
import java.awt.Graphics;
//#endif 


//#if 1558242175 
import java.awt.event.MouseEvent;
//#endif 


//#if 816203439 
import java.util.Vector;
//#endif 


//#if 701693876 
import javax.swing.Action;
//#endif 


//#if 413858365 
import org.argouml.model.Model;
//#endif 


//#if 2063723514 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if -520413793 
import org.argouml.ui.ArgoJMenu;
//#endif 


//#if 1929995269 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -767716832 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 932989542 
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
//#endif 


//#if -61145491 
import org.argouml.uml.diagram.ui.PathItemPlacement;
//#endif 


//#if -1988465244 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewActionSequence;
//#endif 


//#if -1979080921 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewCallAction;
//#endif 


//#if -451919159 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewCreateAction;
//#endif 


//#if 1933324491 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewDestroyAction;
//#endif 


//#if -935508971 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewReturnAction;
//#endif 


//#if -1829108035 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewSendAction;
//#endif 


//#if 1260816516 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewTerminateAction;
//#endif 


//#if 1763854450 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewUninterpretedAction;
//#endif 


//#if -17818532 
import org.argouml.uml.ui.behavior.state_machines.ButtonActionNewGuard;
//#endif 


//#if 1747378608 
import org.tigris.gef.base.Layer;
//#endif 


//#if -1168545587 
import org.tigris.gef.presentation.ArrowHeadGreater;
//#endif 


//#if -1339185356 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 119448786 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if 880148846 
public class FigTransition extends 
//#if -265308033 
FigEdgeModelElement
//#endif 

  { 

//#if -175105063 
private ArrowHeadGreater endArrow = new ArrowHeadGreater();
//#endif 


//#if -1790244464 
private boolean dashed;
//#endif 


//#if 757208620 
@Override
    protected int getNotationProviderType()
    { 

//#if 373177736 
return NotationProviderFactory2.TYPE_TRANSITION;
//#endif 

} 

//#endif 


//#if 1097285903 
@Override
    protected Object getDestination()
    { 

//#if 189265676 
if(getOwner() != null)//1
{ 

//#if -348493524 
return Model.getStateMachinesHelper().getDestination(getOwner());
//#endif 

} 

//#endif 


//#if 550488892 
return null;
//#endif 

} 

//#endif 


//#if 1991715773 
@Override
    public void renderingChanged()
    { 

//#if -856003736 
super.renderingChanged();
//#endif 


//#if 1029186825 
updateDashed();
//#endif 

} 

//#endif 


//#if -1475520804 
@Deprecated
    public FigTransition(Object edge, Layer lay)
    { 

//#if -873685489 
this();
//#endif 


//#if -1878618824 
if(Model.getFacade().isATransition(edge))//1
{ 

//#if -1376499693 
initPorts(lay, edge);
//#endif 

} 

//#endif 


//#if -663647222 
setLayer(lay);
//#endif 


//#if -1920634791 
setOwner(edge);
//#endif 

} 

//#endif 


//#if -231237016 
private void initializeTransition()
    { 

//#if -1992296512 
addPathItem(getNameFig(),
                    new PathItemPlacement(this, getNameFig(), 50, 10));
//#endif 


//#if -1352134657 
getFig().setLineColor(LINE_COLOR);
//#endif 


//#if 2025301066 
setDestArrowHead(endArrow);
//#endif 


//#if 1692883970 
allowRemoveFromDiagram(false);
//#endif 


//#if 1076369191 
updateDashed();
//#endif 

} 

//#endif 


//#if 1930526225 
@Override
    public void setLayer(Layer lay)
    { 

//#if 984693737 
super.setLayer(lay);
//#endif 


//#if 740842906 
if(getLayer() != null && getOwner() != null)//1
{ 

//#if -1116204602 
initPorts(lay, getOwner());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2142592003 
private void updateDashed()
    { 

//#if 1258943449 
if(Model.getFacade().isATransition(getOwner()))//1
{ 

//#if 1306614907 
dashed =
                Model.getFacade().isAObjectFlowState(
                    Model.getFacade().getSource(getOwner()))
                || Model.getFacade().isAObjectFlowState(
                    Model.getFacade().getTarget(getOwner()));
//#endif 


//#if -801322559 
getFig().setDashed(dashed);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -124518385 
@Deprecated
    private void initPorts(Layer lay, Object owner)
    { 

//#if -1429091726 
final Object sourceSV = Model.getFacade().getSource(owner);
//#endif 


//#if 1057652964 
final FigNode sourceFN = (FigNode) lay.presentationFor(sourceSV);
//#endif 


//#if 1618576009 
if(sourceFN != null)//1
{ 

//#if -2028431117 
setSourcePortFig(sourceFN);
//#endif 


//#if 1646731440 
setSourceFigNode(sourceFN);
//#endif 

} 

//#endif 


//#if -789740433 
final Object destSV = Model.getFacade().getTarget(owner);
//#endif 


//#if -926161806 
final FigNode destFN = (FigNode) lay.presentationFor(destSV);
//#endif 


//#if -141172400 
if(destFN != null)//1
{ 

//#if 960666589 
setDestPortFig(destFN);
//#endif 


//#if -1663439142 
setDestFigNode(destFN);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -908936139 
@Override
    public void setFig(Fig f)
    { 

//#if -1808288231 
super.setFig(f);
//#endif 


//#if -1806411421 
getFig().setDashed(dashed);
//#endif 

} 

//#endif 


//#if -704867637 
@Override
    public void paint(Graphics g)
    { 

//#if 867196110 
endArrow.setLineColor(getLineColor());
//#endif 


//#if -1386997963 
super.paint(g);
//#endif 

} 

//#endif 


//#if 1729070259 

//#if 1877609935 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigTransition()
    { 

//#if -454877345 
super();
//#endif 


//#if 1977813717 
initializeTransition();
//#endif 

} 

//#endif 


//#if -1396121892 
@Override
    protected Object getSource()
    { 

//#if 1739039314 
if(getOwner() != null)//1
{ 

//#if -1108927271 
return Model.getStateMachinesHelper().getSource(getOwner());
//#endif 

} 

//#endif 


//#if -317608062 
return null;
//#endif 

} 

//#endif 


//#if -1061504799 

//#if 490166650 
@SuppressWarnings("deprecation")
//#endif 

@Deprecated
    
    @Override
    public void setOwner(Object owner)
    { 

//#if -973036543 
super.setOwner(owner);
//#endif 


//#if 1334299155 
if(getLayer() != null && getOwner() != null)//1
{ 

//#if -393488320 
initPorts(getLayer(), owner);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 181854680 
@Override
    public Vector getPopUpActions(MouseEvent me)
    { 

//#if 1143909296 
Vector popUpActions = super.getPopUpActions(me);
//#endif 


//#if 701268831 
boolean ms = TargetManager.getInstance().getTargets().size() > 1;
//#endif 


//#if 1080199138 
if(ms)//1
{ 

//#if -325443341 
return popUpActions;
//#endif 

} 

//#endif 


//#if 1876603495 
Action a;
//#endif 


//#if -212092092 
ArgoJMenu triggerMenu =
            new ArgoJMenu("menu.popup.trigger");
//#endif 


//#if 1803511145 
a = new ButtonActionNewCallEvent();
//#endif 


//#if -1548943675 
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
//#endif 


//#if 1693351582 
triggerMenu.add(a);
//#endif 


//#if 312319483 
a = new ButtonActionNewChangeEvent();
//#endif 


//#if 547652973 
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
//#endif 


//#if -2048832780 
triggerMenu.add(a);
//#endif 


//#if -1588756237 
a = new ButtonActionNewSignalEvent();
//#endif 


//#if 547652974 
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
//#endif 


//#if -2048832779 
triggerMenu.add(a);
//#endif 


//#if 2077974232 
a = new ButtonActionNewTimeEvent();
//#endif 


//#if 547652975 
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
//#endif 


//#if -2048832778 
triggerMenu.add(a);
//#endif 


//#if -449087263 
popUpActions.add(
            popUpActions.size() - getPopupAddOffset(),
            triggerMenu);
//#endif 


//#if 242583168 
a = new ButtonActionNewGuard();
//#endif 


//#if 547652976 
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
//#endif 


//#if -1849853557 
popUpActions.add(popUpActions.size() - getPopupAddOffset(), a);
//#endif 


//#if -524210576 
ArgoJMenu effectMenu =
            new ArgoJMenu("menu.popup.effect");
//#endif 


//#if 2078635488 
a = ActionNewCallAction.getButtonInstance();
//#endif 


//#if 547652977 
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
//#endif 


//#if -1579934779 
effectMenu.add(a);
//#endif 


//#if 821919298 
a = ActionNewCreateAction.getButtonInstance();
//#endif 


//#if 547652978 
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
//#endif 


//#if 709642349 
effectMenu.add(a);
//#endif 


//#if -574740462 
a = ActionNewDestroyAction.getButtonInstance();
//#endif 


//#if 547652979 
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
//#endif 


//#if 709642350 
effectMenu.add(a);
//#endif 


//#if 302571918 
a = ActionNewReturnAction.getButtonInstance();
//#endif 


//#if 547652980 
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
//#endif 


//#if 709642351 
effectMenu.add(a);
//#endif 


//#if -1724107146 
a = ActionNewSendAction.getButtonInstance();
//#endif 


//#if -202627004 
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
//#endif 


//#if 709642352 
effectMenu.add(a);
//#endif 


//#if -1255569525 
a = ActionNewTerminateAction.getButtonInstance();
//#endif 


//#if -202627003 
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
//#endif 


//#if 709642353 
effectMenu.add(a);
//#endif 


//#if -1576103687 
a = ActionNewUninterpretedAction.getButtonInstance();
//#endif 


//#if -202627002 
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
//#endif 


//#if 709642354 
effectMenu.add(a);
//#endif 


//#if -264059043 
a = ActionNewActionSequence.getButtonInstance();
//#endif 


//#if -202627001 
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
//#endif 


//#if 709642355 
effectMenu.add(a);
//#endif 


//#if 996502154 
popUpActions.add(popUpActions.size() - getPopupAddOffset(),
                         effectMenu);
//#endif 


//#if 1909210787 
return popUpActions;
//#endif 

} 

//#endif 


//#if 639004949 
public FigTransition(Object owner, DiagramSettings settings)
    { 

//#if 1921999992 
super(owner, settings);
//#endif 


//#if 1987270296 
initializeTransition();
//#endif 

} 

//#endif 


//#if -497147689 
@Override
    public void paintClarifiers(Graphics g)
    { 

//#if -633396325 
indicateBounds(getNameFig(), g);
//#endif 


//#if -16315296 
super.paintClarifiers(g);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

