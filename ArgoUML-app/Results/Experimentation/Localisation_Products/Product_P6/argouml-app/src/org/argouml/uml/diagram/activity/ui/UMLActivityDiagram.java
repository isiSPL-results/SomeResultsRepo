package org.argouml.uml.diagram.activity.ui;
import java.awt.Point;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.swing.Action;
import org.apache.log4j.Logger;
import org.argouml.i18n.Translator;
import org.argouml.model.ActivityGraphsHelper;
import org.argouml.model.DeleteInstanceEvent;
import org.argouml.model.Model;
import org.argouml.ui.CmdCreateNode;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.UMLMutableGraphSupport;
import org.argouml.uml.diagram.activity.ActivityDiagramGraphModel;
import org.argouml.uml.diagram.state.StateDiagramGraphModel;
import org.argouml.uml.diagram.state.ui.ActionCreatePseudostate;
import org.argouml.uml.diagram.state.ui.ButtonActionNewCallEvent;
import org.argouml.uml.diagram.state.ui.ButtonActionNewChangeEvent;
import org.argouml.uml.diagram.state.ui.ButtonActionNewSignalEvent;
import org.argouml.uml.diagram.state.ui.ButtonActionNewTimeEvent;
import org.argouml.uml.diagram.state.ui.FigBranchState;
import org.argouml.uml.diagram.state.ui.FigFinalState;
import org.argouml.uml.diagram.state.ui.FigForkState;
import org.argouml.uml.diagram.state.ui.FigInitialState;
import org.argouml.uml.diagram.state.ui.FigJoinState;
import org.argouml.uml.diagram.state.ui.FigJunctionState;
import org.argouml.uml.diagram.state.ui.FigStateVertex;
import org.argouml.uml.diagram.static_structure.ui.FigComment;
import org.argouml.uml.diagram.ui.ActionSetMode;
import org.argouml.uml.diagram.ui.RadioAction;
import org.argouml.uml.diagram.ui.UMLDiagram;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewActionSequence;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewCallAction;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewCreateAction;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewDestroyAction;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewReturnAction;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewSendAction;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewTerminateAction;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewUninterpretedAction;
import org.argouml.uml.ui.behavior.state_machines.ButtonActionNewGuard;
import org.argouml.util.ToolBarUtility;
import org.tigris.gef.base.LayerPerspective;
import org.tigris.gef.base.LayerPerspectiveMutable;
import org.tigris.gef.base.ModeCreatePolyEdge;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigNode;
public class UMLActivityDiagram extends UMLDiagram
  { 
private static final Logger LOG =
        Logger.getLogger(UMLActivityDiagram.class);
private static final long serialVersionUID = 6223128918989919230L;
private Object theActivityGraph;
private Action actionState;
private Action actionStartPseudoState;
private Action actionFinalPseudoState;
private Action actionJunctionPseudoState;
private Action actionForkPseudoState;
private Action actionJoinPseudoState;
private Action actionTransition;
private Action actionObjectFlowState;
private Action actionSwimlane;
private Action actionCallState;
private Action actionSubactivityState;
private Action actionCallEvent;
private Action actionChangeEvent;
private Action actionSignalEvent;
private Action actionTimeEvent;
private Action actionGuard;
private Action actionCallAction;
private Action actionCreateAction;
private Action actionDestroyAction;
private Action actionReturnAction;
private Action actionSendAction;
private Action actionTerminateAction;
private Action actionUninterpretedAction;
private Action actionActionSequence;
protected Action getActionJoinPseudoState()
    { 
if(actionJoinPseudoState == null)//1
{ 
actionJoinPseudoState =
                new RadioAction(
                new ActionCreatePseudostate(
                    Model.getPseudostateKind().getJoin(),
                    "button.new-join"));
} 
return actionJoinPseudoState;
} 
protected Action getActionReturnAction()
    { 
if(actionReturnAction == null)//1
{ 
actionReturnAction = ActionNewReturnAction.getButtonInstance();
} 
return actionReturnAction;
} 
protected Action getActionFinalPseudoState()
    { 
if(actionFinalPseudoState == null)//1
{ 
actionFinalPseudoState =
                new RadioAction(
                new CmdCreateNode(
                    Model.getMetaTypes().getFinalState(),
                    "button.new-finalstate"));
} 
return actionFinalPseudoState;
} 
protected Action getActionSignalEvent()
    { 
if(actionSignalEvent == null)//1
{ 
actionSignalEvent = new ButtonActionNewSignalEvent();
} 
return actionSignalEvent;
} 
protected Action getActionJunctionPseudoState()
    { 
if(actionJunctionPseudoState == null)//1
{ 
actionJunctionPseudoState =
                new RadioAction(
                new ActionCreatePseudostate(
                    Model.getPseudostateKind().getJunction(),
                    "button.new-junction"));
} 
return actionJunctionPseudoState;
} 
private void changePartition(FigNode enclosed)
    { 
assert enclosed != null;
Object state = enclosed.getOwner();
ActivityGraphsHelper activityGraph = Model.getActivityGraphsHelper();
for (Object f : getLayer().getContentsNoEdges()) //1
{ 
if(f instanceof FigPartition)//1
{ 
FigPartition fig = (FigPartition) f;
Object partition = fig.getOwner();
if(fig.getBounds().intersects(enclosed.getBounds()))//1
{ 
activityGraph.addContent(partition, state);
} 
else
if(isStateInPartition(state, partition))//1
{ 
activityGraph.removeContent(partition, state);
} 
} 
} 
} 
public void encloserChanged(
        FigNode enclosed, FigNode oldEncloser, FigNode newEncloser)
    { 
if(oldEncloser == null && newEncloser == null)//1
{ 
return;
} 
if(enclosed instanceof FigStateVertex
            ||

            enclosed instanceof FigObjectFlowState)//1
{ 
changePartition(enclosed);
} 
} 
protected Object[] getUmlActions()
    { 
Object[] actions = {
            getActionState(),
            getActionTransition(),
            null,



            getActionStartPseudoState(),

            getActionFinalPseudoState(),



            getActionJunctionPseudoState(),
            getActionForkPseudoState(),
            getActionJoinPseudoState(),

            getActionSwimlane(),
            null,
            getActionCallState(),
            getActionObjectFlowState(),
            /*getActionSubactivityState()*/
            null,



            getTriggerActions(),

            getActionGuard(),
            getEffectActions(),
        };
return actions;
} 
protected Action getActionTimeEvent()
    { 
if(actionTimeEvent == null)//1
{ 
actionTimeEvent = new ButtonActionNewTimeEvent();
} 
return actionTimeEvent;
} 
protected Object[] getEffectActions()
    { 
Object[] actions = {
            getActionCallAction(),
            getActionCreateAction(),
            getActionDestroyAction(),
            getActionReturnAction(),
            getActionSendAction(),
            getActionTerminateAction(),
            getActionUninterpretedAction(),
            getActionActionSequence(),
        };
ToolBarUtility.manageDefault(actions, "diagram.activity.effect");
return actions;
} 
protected Action getActionDestroyAction()
    { 
if(actionDestroyAction == null)//1
{ 
actionDestroyAction = ActionNewDestroyAction.getButtonInstance();
} 
return actionDestroyAction;
} 
protected Action getActionStartPseudoState()
    { 
if(actionStartPseudoState == null)//1
{ 
actionStartPseudoState =
                new RadioAction(
                new ActionCreatePseudostate(
                    Model.getPseudostateKind().getInitial(),
                    "button.new-initial"));
} 
return actionStartPseudoState;
} 
@SuppressWarnings("unchecked")

    public Collection getRelocationCandidates(Object root)
    { 
Collection c =  new HashSet();
c.add(getOwner());
return c;
} 
@Override
    public void postLoad()
    { 
FigPartition previous = null;
HashMap map = new HashMap();
Iterator it = new ArrayList(getLayer().getContents()).iterator();
while (it.hasNext()) //1
{ 
Fig f = (Fig) it.next();
if(f instanceof FigPartition)//1
{ 
map.put(Integer.valueOf(f.getX()), f);
} 
} 
List xList = new ArrayList(map.keySet());
Collections.sort(xList);
it = xList.iterator();
while (it.hasNext()) //2
{ 
Fig f = (Fig) map.get(it.next());
if(f instanceof FigPartition)//1
{ 
FigPartition fp = (FigPartition) f;
if(previous != null)//1
{ 
previous.setNextPartition(fp);
} 
fp.setPreviousPartition(previous);
fp.setNextPartition(null);
previous = fp;
} 
} 
} 
protected Action getActionUninterpretedAction()
    { 
if(actionUninterpretedAction == null)//1
{ 
actionUninterpretedAction =
                ActionNewUninterpretedAction.getButtonInstance();
} 
return actionUninterpretedAction;
} 
@Override
    public FigNode drop(Object droppedObject, Point location)
    { 
FigNode figNode = null;
Rectangle bounds = null;
if(location != null)//1
{ 
bounds = new Rectangle(location.x, location.y, 0, 0);
} 
DiagramSettings settings = getDiagramSettings();
if(Model.getFacade().isAPartition(droppedObject))//1
{ 
figNode = new FigPartition(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAActionState(droppedObject))//1
{ 
figNode = new FigActionState(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isACallState(droppedObject))//1
{ 
figNode = new FigCallState(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAObjectFlowState(droppedObject))//1
{ 
figNode = new FigObjectFlowState(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isASubactivityState(droppedObject))//1
{ 
figNode = new FigSubactivityState(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAFinalState(droppedObject))//1
{ 
figNode = new FigFinalState(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAPseudostate(droppedObject))//1
{ 
Object kind = Model.getFacade().getKind(droppedObject);
if(kind == null)//1
{ 
LOG.warn("found a null type pseudostate");
return null;
} 
if(kind.equals(Model.getPseudostateKind().getInitial()))//1
{ 
figNode = new FigInitialState(droppedObject, bounds, settings);
} 
else
if(kind.equals(
                           Model.getPseudostateKind().getChoice()))//1
{ 
figNode = new FigBranchState(droppedObject, bounds, settings);
} 
else
if(kind.equals(
                           Model.getPseudostateKind().getJunction()))//1
{ 
figNode = new FigJunctionState(droppedObject, bounds, settings);
} 
else
if(kind.equals(
                           Model.getPseudostateKind().getFork()))//1
{ 
figNode = new FigForkState(droppedObject, bounds, settings);
} 
else
if(kind.equals(
                           Model.getPseudostateKind().getJoin()))//1
{ 
figNode = new FigJoinState(droppedObject, bounds, settings);
} 
else
{ 
LOG.warn("found a type not known");
} 
} 
else
if(Model.getFacade().isAComment(droppedObject))//1
{ 
figNode = new FigComment(droppedObject, bounds, settings);
} 
if(figNode != null)//1
{ 
if(location != null)//1
{ 
figNode.setLocation(location.x, location.y);
} 
LOG.debug("Dropped object " + droppedObject + " converted to "
                      + figNode);
} 
else
{ 
LOG.debug("Dropped object NOT added. This usualy means that this "
                      + "type of object is not accepted!");
} 
return figNode;
} 
protected Action getActionForkPseudoState()
    { 
if(actionForkPseudoState == null)//1
{ 
actionForkPseudoState =
                new RadioAction(
                new ActionCreatePseudostate(
                    Model.getPseudostateKind().getFork(),
                    "button.new-fork"));
} 
return actionForkPseudoState;
} 
protected Action getActionCallState()
    { 
if(actionCallState == null)//1
{ 
actionCallState =
                new RadioAction(
                new CmdCreateNode(
                    Model.getMetaTypes().getCallState(),
                    "button.new-callstate"));
} 
return actionCallState;
} 
protected Action getActionCallEvent()
    { 
if(actionCallEvent == null)//1
{ 
actionCallEvent = new ButtonActionNewCallEvent();
} 
return actionCallEvent;
} 
public boolean isRelocationAllowed(Object base)
    { 
return false;
} 
protected Action getActionSwimlane()
    { 
if(actionSwimlane == null)//1
{ 
actionSwimlane =
                new ActionCreatePartition(getStateMachine());
} 
return actionSwimlane;
} 
protected Action getActionCreateAction()
    { 
if(actionCreateAction == null)//1
{ 
actionCreateAction = ActionNewCreateAction.getButtonInstance();
} 
return actionCreateAction;
} 
public String getLabelName()
    { 
return Translator.localize("label.activity-diagram");
} 
public void initialize(Object o)
    { 
if(!(Model.getFacade().isAActivityGraph(o)))//1
{ 
return;
} 
Object context = Model.getFacade().getContext(o);
if(context != null)//1
{ 
if(Model.getFacade().isABehavioralFeature(context))//1
{ 
setup(Model.getFacade().getNamespace(
                          Model.getFacade().getOwner(context)), o);
} 
else
{ 
setup(context, o);
} 
} 
else
{ 
Object namespace4Diagram = Model.getFacade().getNamespace(o);
if(namespace4Diagram != null)//1
{ 
setup(namespace4Diagram, o);
} 
else
{ 
throw new IllegalStateException("Cannot find context "
                                                + "nor namespace while initializing activity diagram");
} 
} 
} 
protected Action getActionSendAction()
    { 
if(actionSendAction == null)//1
{ 
actionSendAction = ActionNewSendAction.getButtonInstance();
} 
return actionSendAction;
} 
@Deprecated
    public UMLActivityDiagram(Object namespace, Object agraph)
    { 
this();
if(namespace == null)//1
{ 
namespace = Model.getFacade().getNamespace(agraph);
} 
if(!Model.getFacade().isANamespace(namespace)
                || !Model.getFacade().isAActivityGraph(agraph))//1
{ 
throw new IllegalArgumentException();
} 
if(Model.getFacade().getName(namespace) != null)//1
{ 
if(!Model.getFacade().getName(namespace).trim().equals(""))//1
{ 
String name =
                    Model.getFacade().getName(namespace)
                    + " activity "
                    + (Model.getFacade().getBehaviors(namespace).size());
try//1
{ 
setName(name);
} 
catch (PropertyVetoException pve) //1
{ 
} 
} 
} 
setup(namespace, agraph);
} 
public Object getDependentElement()
    { 
return getStateMachine();
} 
public boolean relocate(Object base)
    { 
return false;
} 
protected Action getActionActionSequence()
    { 
if(actionActionSequence == null)//1
{ 
actionActionSequence =
                ActionNewActionSequence.getButtonInstance();
} 
return actionActionSequence;
} 
public void setup(Object namespace, Object agraph)
    { 
if(!Model.getFacade().isANamespace(namespace)
                || !Model.getFacade().isAActivityGraph(agraph))//1
{ 
throw new IllegalArgumentException();
} 
setNamespace(namespace);
theActivityGraph = agraph;
ActivityDiagramGraphModel gm = createGraphModel();
gm.setHomeModel(namespace);
if(theActivityGraph != null)//1
{ 
gm.setMachine(theActivityGraph);
} 
ActivityDiagramRenderer rend = new ActivityDiagramRenderer();
LayerPerspective lay = new LayerPerspectiveMutable(
            Model.getFacade().getName(namespace), gm);
lay.setGraphNodeRenderer(rend);
lay.setGraphEdgeRenderer(rend);
setLayer(lay);
Model.getPump().addModelEventListener(this, theActivityGraph,
                                              new String[] {"remove", "namespace"});
} 
protected Action getActionState()
    { 
if(actionState == null)//1
{ 
actionState =
                new RadioAction(
                new CmdCreateNode(
                    Model.getMetaTypes().getActionState(),
                    "button.new-actionstate"));
} 
return actionState;
} 
protected Action getActionTerminateAction()
    { 
if(actionTerminateAction == null)//1
{ 
actionTerminateAction =
                ActionNewTerminateAction.getButtonInstance();
} 
return actionTerminateAction;
} 
public Object getOwner()
    { 
if(!(getGraphModel() instanceof ActivityDiagramGraphModel))//1
{ 
throw new IllegalStateException(
                "Incorrect graph model of "
                + getGraphModel().getClass().getName());
} 
ActivityDiagramGraphModel gm =
            (ActivityDiagramGraphModel) getGraphModel();
return gm.getMachine();
} 
protected Action getActionSubactivityState()
    { 
if(actionSubactivityState == null)//1
{ 
actionSubactivityState =
                new RadioAction(
                new CmdCreateNode(
                    Model.getMetaTypes().getSubactivityState(),
                    "button.new-subactivitystate"));
} 
return actionSubactivityState;
} 
private boolean isStateInPartition(Object state, Object partition)
    { 
return Model.getFacade().getContents(partition).contains(state);
} 
protected Action getActionObjectFlowState()
    { 
if(actionObjectFlowState == null)//1
{ 
actionObjectFlowState =
                new RadioAction(
                new CmdCreateNode(
                    Model.getMetaTypes().getObjectFlowState(),
                    "button.new-objectflowstate"));
} 
return actionObjectFlowState;
} 
protected Action getActionChangeEvent()
    { 
if(actionChangeEvent == null)//1
{ 
actionChangeEvent = new ButtonActionNewChangeEvent();
} 
return actionChangeEvent;
} 
private ActivityDiagramGraphModel createGraphModel()
    { 
if((getGraphModel() instanceof ActivityDiagramGraphModel))//1
{ 
return (ActivityDiagramGraphModel) getGraphModel();
} 
else
{ 
return new ActivityDiagramGraphModel();
} 
} 
public void propertyChange(PropertyChangeEvent evt)
    { 
if((evt.getSource() == theActivityGraph)
                && (evt instanceof DeleteInstanceEvent)
                && "remove".equals(evt.getPropertyName()))//1
{ 
Model.getPump().removeModelEventListener(this,
                    theActivityGraph, new String[] {"remove", "namespace"});
getProject().moveToTrash(this);
} 
if(evt.getSource() == getStateMachine())//1
{ 
Object newNamespace =
                Model.getFacade().getNamespace(getStateMachine());
if(getNamespace() != newNamespace)//1
{ 
setNamespace(newNamespace);
((UMLMutableGraphSupport) getGraphModel())
                .setHomeModel(newNamespace);
} 
} 
} 
protected Action getActionTransition()
    { 
if(actionTransition == null)//1
{ 
actionTransition =
                new RadioAction(
                new ActionSetMode(
                    ModeCreatePolyEdge.class,
                    "edgeClass",
                    Model.getMetaTypes().getTransition(),
                    "button.new-transition"));
} 
return actionTransition;
} 
protected Object[] getTriggerActions()
    { 
Object[] actions = {
            getActionCallEvent(),
            getActionChangeEvent(),
            getActionSignalEvent(),
            getActionTimeEvent(),
        };
ToolBarUtility.manageDefault(actions, "diagram.activity.trigger");
return actions;
} 
protected Action getActionGuard()
    { 
if(actionGuard == null)//1
{ 
actionGuard = new ButtonActionNewGuard();
} 
return actionGuard;
} 
protected Action getActionCallAction()
    { 
if(actionCallAction == null)//1
{ 
actionCallAction = ActionNewCallAction.getButtonInstance();
} 
return actionCallAction;
} 
@Deprecated
    public UMLActivityDiagram()
    { 
super();
try//1
{ 
setName(getNewDiagramName());
} 
catch (PropertyVetoException pve) //1
{ 
} 
setGraphModel(createGraphModel());
} 
public Object getStateMachine()
    { 
GraphModel gm = getGraphModel();
if(gm instanceof StateDiagramGraphModel)//1
{ 
Object machine = ((StateDiagramGraphModel) gm).getMachine();
if(!Model.getUmlFactory().isRemoved(machine))//1
{ 
return machine;
} 
} 
return null;
} 
@Override
    public boolean doesAccept(Object objectToAccept)
    { 
if(Model.getFacade().isAPartition(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAState(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAPseudostate(objectToAccept))//1
{ 
Object kind = Model.getFacade().getKind(objectToAccept);
if(kind == null)//1
{ 
LOG.warn("found a null type pseudostate");
return false;
} 
if(kind.equals(
                        Model.getPseudostateKind().getShallowHistory()))//1
{ 
return false;
} 
else
if(kind.equals(
                           Model.getPseudostateKind().getDeepHistory()))//1
{ 
return false;
} 
return true;
} 
else
if(Model.getFacade().isAComment(objectToAccept))//1
{ 
return true;
} 
return false;
} 
public void setStateMachine(Object sm)
    { 
if(!Model.getFacade().isAStateMachine(sm))//1
{ 
throw new IllegalArgumentException();
} 
((ActivityDiagramGraphModel) getGraphModel()).setMachine(sm);
} 

 } 
