package org.argouml.uml.diagram.state.ui;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.Action;
import org.argouml.model.Model;
import org.argouml.notation.NotationProviderFactory2;
import org.argouml.ui.ArgoJMenu;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
import org.argouml.uml.diagram.ui.PathItemPlacement;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewActionSequence;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewCallAction;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewCreateAction;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewDestroyAction;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewReturnAction;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewSendAction;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewTerminateAction;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewUninterpretedAction;
import org.argouml.uml.ui.behavior.state_machines.ButtonActionNewGuard;
import org.tigris.gef.base.Layer;
import org.tigris.gef.presentation.ArrowHeadGreater;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigNode;
public class FigTransition extends FigEdgeModelElement
  { 
private ArrowHeadGreater endArrow = new ArrowHeadGreater();
private boolean dashed;
@Override
    protected int getNotationProviderType()
    { 
return NotationProviderFactory2.TYPE_TRANSITION;
} 
@Override
    protected Object getDestination()
    { 
if(getOwner() != null)//1
{ 
return Model.getStateMachinesHelper().getDestination(getOwner());
} 
return null;
} 
@Override
    public void renderingChanged()
    { 
super.renderingChanged();
updateDashed();
} 
@Deprecated
    public FigTransition(Object edge, Layer lay)
    { 
this();
if(Model.getFacade().isATransition(edge))//1
{ 
initPorts(lay, edge);
} 
setLayer(lay);
setOwner(edge);
} 
private void initializeTransition()
    { 
addPathItem(getNameFig(),
                    new PathItemPlacement(this, getNameFig(), 50, 10));
getFig().setLineColor(LINE_COLOR);
setDestArrowHead(endArrow);
allowRemoveFromDiagram(false);
updateDashed();
} 
@Override
    public void setLayer(Layer lay)
    { 
super.setLayer(lay);
if(getLayer() != null && getOwner() != null)//1
{ 
initPorts(lay, getOwner());
} 
} 
private void updateDashed()
    { 
if(Model.getFacade().isATransition(getOwner()))//1
{ 
dashed =
                Model.getFacade().isAObjectFlowState(
                    Model.getFacade().getSource(getOwner()))
                || Model.getFacade().isAObjectFlowState(
                    Model.getFacade().getTarget(getOwner()));
getFig().setDashed(dashed);
} 
} 
@Deprecated
    private void initPorts(Layer lay, Object owner)
    { 
final Object sourceSV = Model.getFacade().getSource(owner);
final FigNode sourceFN = (FigNode) lay.presentationFor(sourceSV);
if(sourceFN != null)//1
{ 
setSourcePortFig(sourceFN);
setSourceFigNode(sourceFN);
} 
final Object destSV = Model.getFacade().getTarget(owner);
final FigNode destFN = (FigNode) lay.presentationFor(destSV);
if(destFN != null)//1
{ 
setDestPortFig(destFN);
setDestFigNode(destFN);
} 
} 
@Override
    public void setFig(Fig f)
    { 
super.setFig(f);
getFig().setDashed(dashed);
} 
@Override
    public void paint(Graphics g)
    { 
endArrow.setLineColor(getLineColor());
super.paint(g);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigTransition()
    { 
super();
initializeTransition();
} 
@Override
    protected Object getSource()
    { 
if(getOwner() != null)//1
{ 
return Model.getStateMachinesHelper().getSource(getOwner());
} 
return null;
} 
@SuppressWarnings("deprecation")
@Deprecated
    
    @Override
    public void setOwner(Object owner)
    { 
super.setOwner(owner);
if(getLayer() != null && getOwner() != null)//1
{ 
initPorts(getLayer(), owner);
} 
} 
@Override
    public Vector getPopUpActions(MouseEvent me)
    { 
Vector popUpActions = super.getPopUpActions(me);
boolean ms = TargetManager.getInstance().getTargets().size() > 1;
if(ms)//1
{ 
return popUpActions;
} 
Action a;
ArgoJMenu triggerMenu =
            new ArgoJMenu("menu.popup.trigger");
a = new ButtonActionNewCallEvent();
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
triggerMenu.add(a);
a = new ButtonActionNewChangeEvent();
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
triggerMenu.add(a);
a = new ButtonActionNewSignalEvent();
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
triggerMenu.add(a);
a = new ButtonActionNewTimeEvent();
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
triggerMenu.add(a);
popUpActions.add(
            popUpActions.size() - getPopupAddOffset(),
            triggerMenu);
a = new ButtonActionNewGuard();
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
popUpActions.add(popUpActions.size() - getPopupAddOffset(), a);
ArgoJMenu effectMenu =
            new ArgoJMenu("menu.popup.effect");
a = ActionNewCallAction.getButtonInstance();
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
effectMenu.add(a);
a = ActionNewCreateAction.getButtonInstance();
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
effectMenu.add(a);
a = ActionNewDestroyAction.getButtonInstance();
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
effectMenu.add(a);
a = ActionNewReturnAction.getButtonInstance();
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
effectMenu.add(a);
a = ActionNewSendAction.getButtonInstance();
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
effectMenu.add(a);
a = ActionNewTerminateAction.getButtonInstance();
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
effectMenu.add(a);
a = ActionNewUninterpretedAction.getButtonInstance();
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
effectMenu.add(a);
a = ActionNewActionSequence.getButtonInstance();
a.putValue(Action.NAME, a.getValue(Action.SHORT_DESCRIPTION));
effectMenu.add(a);
popUpActions.add(popUpActions.size() - getPopupAddOffset(),
                         effectMenu);
return popUpActions;
} 
public FigTransition(Object owner, DiagramSettings settings)
    { 
super(owner, settings);
initializeTransition();
} 
@Override
    public void paintClarifiers(Graphics g)
    { 
indicateBounds(getNameFig(), g);
super.paintClarifiers(g);
} 

 } 
