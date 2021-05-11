package org.argouml.uml.diagram.state.ui;
import java.awt.Point;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.util.Collection;
import java.util.HashSet;
import javax.swing.Action;
import org.apache.log4j.Logger;
import org.argouml.i18n.Translator;
import org.argouml.model.DeleteInstanceEvent;
import org.argouml.model.Model;
import org.argouml.ui.CmdCreateNode;
import org.argouml.uml.diagram.DiagramFactory;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.UMLMutableGraphSupport;
import org.argouml.uml.diagram.activity.ui.FigActionState;
import org.argouml.uml.diagram.state.StateDiagramGraphModel;
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
import org.tigris.gef.presentation.FigNode;
public class UMLStateDiagram extends UMLDiagram
  { 
private static final long serialVersionUID = -1541136327444703151L;
private static final Logger LOG = Logger.getLogger(UMLStateDiagram.class);
private Object theStateMachine;
private Action actionStubState;
private Action actionState;
private Action actionSynchState;
private Action actionSubmachineState;
private Action actionCompositeState;
private Action actionStartPseudoState;
private Action actionFinalPseudoState;
private Action actionBranchPseudoState;
private Action actionForkPseudoState;
private Action actionJoinPseudoState;
private Action actionShallowHistoryPseudoState;
private Action actionDeepHistoryPseudoState;
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
private Action actionTransition;
private Action actionJunctionPseudoState;
protected Action getActionCompositeState()
    { 
if(actionCompositeState == null)//1
{ 
actionCompositeState =
                new RadioAction(new CmdCreateNode(
                                    Model.getMetaTypes().getCompositeState(),
                                    "button.new-compositestate"));
} 
return actionCompositeState;
} 
protected Action getActionChangeEvent()
    { 
if(actionChangeEvent == null)//1
{ 
actionChangeEvent = new ButtonActionNewChangeEvent();
} 
return actionChangeEvent;
} 
private StateDiagramGraphModel createGraphModel()
    { 
if((getGraphModel() instanceof StateDiagramGraphModel))//1
{ 
return (StateDiagramGraphModel) getGraphModel();
} 
else
{ 
return new StateDiagramGraphModel();
} 
} 
protected Action getActionGuard()
    { 
if(actionGuard == null)//1
{ 
actionGuard = new ButtonActionNewGuard();
} 
return actionGuard;
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
if(Model.getFacade().isAActionState(droppedObject))//1
{ 
figNode = new FigActionState(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAFinalState(droppedObject))//1
{ 
figNode = new FigFinalState(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAStubState(droppedObject))//1
{ 
figNode = new FigStubState(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isASubmachineState(droppedObject))//1
{ 
figNode = new FigSubmachineState(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isACompositeState(droppedObject))//1
{ 
figNode = new FigCompositeState(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isASynchState(droppedObject))//1
{ 
figNode = new FigSynchState(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAState(droppedObject))//1
{ 
figNode = new FigSimpleState(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAComment(droppedObject))//1
{ 
figNode = new FigComment(droppedObject, bounds, settings);
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
if(kind.equals(
                               Model.getPseudostateKind().getShallowHistory()))//1
{ 
figNode = new FigShallowHistoryState(droppedObject, bounds,
                                                         settings);
} 
else
if(kind.equals(
                               Model.getPseudostateKind().getDeepHistory()))//1
{ 
figNode = new FigDeepHistoryState(droppedObject, bounds,
                                                      settings);
} 
else
{ 
LOG.warn("found a type not known");
} 
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
LOG.debug("Dropped object NOT added " + figNode);
} 
return figNode;
} 
protected Object[] getTriggerActions()
    { 
Object[] actions = {
            getActionCallEvent(),
            getActionChangeEvent(),
            getActionSignalEvent(),
            getActionTimeEvent(),
        };
ToolBarUtility.manageDefault(actions, "diagram.state.trigger");
return actions;
} 
protected Action getActionCreateAction()
    { 
if(actionCreateAction == null)//1
{ 
actionCreateAction = ActionNewCreateAction.getButtonInstance();
} 
return actionCreateAction;
} 
@Deprecated
    public UMLStateDiagram(Object ns, Object machine)
    { 
this();
if(!Model.getFacade().isAStateMachine(machine))//1
{ 
throw new IllegalStateException(
                "No StateMachine given to create a Statechart diagram");
} 
if(ns == null)//1
{ 
ns = getNamespaceFromMachine(machine);
} 
if(!Model.getFacade().isANamespace(ns))//1
{ 
throw new IllegalArgumentException();
} 
nameDiagram(ns);
setup(ns, machine);
} 
@Override
    public void initialize(Object o)
    { 
if(Model.getFacade().isAStateMachine(o))//1
{ 
Object machine = o;
Object contextNamespace = getNamespaceFromMachine(machine);
setup(contextNamespace, machine);
} 
else
{ 
throw new IllegalStateException(
                "Cannot find namespace "
                + "while initializing "
                + "statechart diagram");
} 
} 
@Override
    public Object getDependentElement()
    { 
return getStateMachine();
} 
@Override
    public boolean doesAccept(Object objectToAccept)
    { 
if(Model.getFacade().isAState(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isASynchState(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAStubState(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAPseudostate(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAComment(objectToAccept))//1
{ 
return true;
} 
return false;
} 
public void encloserChanged(FigNode enclosed,
                                FigNode oldEncloser, FigNode newEncloser)
    { 
} 
public boolean isRelocationAllowed(Object base)
    { 
return false;
} 
protected Action getActionChoicePseudoState()
    { 
if(actionBranchPseudoState == null)//1
{ 
actionBranchPseudoState = new RadioAction(
                new ActionCreatePseudostate(Model.getPseudostateKind()
                                            .getChoice(), "button.new-choice"));
} 
return actionBranchPseudoState;
} 
protected Action getActionCallAction()
    { 
if(actionCallAction == null)//1
{ 
actionCallAction = ActionNewCallAction.getButtonInstance();
} 
return actionCallAction;
} 
protected Action getActionTimeEvent()
    { 
if(actionTimeEvent == null)//1
{ 
actionTimeEvent = new ButtonActionNewTimeEvent();
} 
return actionTimeEvent;
} 
protected Action getActionSynchState()
    { 
if(actionSynchState == null)//1
{ 
actionSynchState =
                new RadioAction(
                new CmdCreateNode(
                    Model.getMetaTypes().getSynchState(),
                    "button.new-synchstate"));
} 
return actionSynchState;
} 
protected Action getActionTransition()
    { 
if(actionTransition == null)//1
{ 
actionTransition = new RadioAction(
                new ActionSetMode(
                    ModeCreatePolyEdge.class,
                    "edgeClass",
                    Model.getMetaTypes().getTransition(),
                    "button.new-transition"));
} 
return actionTransition;
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
protected Action getActionUninterpretedAction()
    { 
if(actionUninterpretedAction == null)//1
{ 
actionUninterpretedAction =
                ActionNewUninterpretedAction.getButtonInstance();
} 
return actionUninterpretedAction;
} 
protected Action getActionStartPseudoState()
    { 
if(actionStartPseudoState == null)//1
{ 
actionStartPseudoState = new RadioAction(
                new ActionCreatePseudostate(
                    Model.getPseudostateKind().getInitial(),
                    "button.new-initial"));
} 
return actionStartPseudoState;
} 
protected Action getActionShallowHistoryPseudoState()
    { 
if(actionShallowHistoryPseudoState == null)//1
{ 
actionShallowHistoryPseudoState = new RadioAction(
                new ActionCreatePseudostate(
                    Model.getPseudostateKind().getShallowHistory(),
                    "button.new-shallowhistory"));
} 
return actionShallowHistoryPseudoState;
} 
public UMLStateDiagram(String name, Object machine)
    { 
super(name, machine, new StateDiagramGraphModel());
if(!Model.getFacade().isAStateMachine(machine))//1
{ 
throw new IllegalStateException(
                "No StateMachine given to create a Statechart diagram");
} 
namespace = getNamespaceFromMachine(machine);
if(!Model.getFacade().isANamespace(namespace))//1
{ 
throw new IllegalArgumentException();
} 
nameDiagram(namespace);
setup(namespace, machine);
} 
private Object getNamespaceFromMachine(Object machine)
    { 
if(!Model.getFacade().isAStateMachine(machine))//1
{ 
throw new IllegalStateException(
                "No StateMachine given to create a Statechart diagram");
} 
Object ns = Model.getFacade().getNamespace(machine);
if(ns != null)//1
{ 
return ns;
} 
Object context = Model.getFacade().getContext(machine);
if(Model.getFacade().isAClassifier(context))//1
{ 
ns = context;
} 
else
if(Model.getFacade().isABehavioralFeature(context))//1
{ 
ns = Model.getFacade().getNamespace( // or just the owner?
                     Model.getFacade().getOwner(context));
} 
if(ns == null)//1
{ 
ns = getProject().getRoots().iterator().next();
} 
if(ns == null || !Model.getFacade().isANamespace(ns))//1
{ 
throw new IllegalStateException(
                "Can not deduce a Namespace from a StateMachine");
} 
return ns;
} 
protected Action getActionJoinPseudoState()
    { 
if(actionJoinPseudoState == null)//1
{ 
actionJoinPseudoState = new RadioAction(new ActionCreatePseudostate(
                    Model.getPseudostateKind().getJoin(), "button.new-join"));
} 
return actionJoinPseudoState;
} 
protected Action getActionSignalEvent()
    { 
if(actionSignalEvent == null)//1
{ 
actionSignalEvent = new ButtonActionNewSignalEvent();
} 
return actionSignalEvent;
} 
protected Action getActionState()
    { 
if(actionState == null)//1
{ 
actionState =
                new RadioAction(
                new CmdCreateNode(Model.getMetaTypes().getSimpleState(),
                                  "button.new-simplestate"));
} 
return actionState;
} 
protected Action getActionStubState()
    { 
if(actionStubState == null)//1
{ 
actionStubState =
                new RadioAction(
                new CmdCreateNode(
                    Model.getMetaTypes().getStubState(),
                    "button.new-stubstate"));
} 
return actionStubState;
} 
@Override
    public Object getOwner()
    { 
if(!(getGraphModel() instanceof StateDiagramGraphModel))//1
{ 
throw new IllegalStateException(
                "Incorrect graph model of "
                + getGraphModel().getClass().getName());
} 
StateDiagramGraphModel gm = (StateDiagramGraphModel) getGraphModel();
return gm.getMachine();
} 
public boolean relocate(Object base)
    { 
return false;
} 
public String getLabelName()
    { 
return Translator.localize("label.state-chart-diagram");
} 
protected Action getActionJunctionPseudoState()
    { 
if(actionJunctionPseudoState == null)//1
{ 
actionJunctionPseudoState = new RadioAction(
                new ActionCreatePseudostate(
                    Model.getPseudostateKind().getJunction(),
                    "button.new-junction"));
} 
return actionJunctionPseudoState;
} 
public void setup(Object namespace, Object machine)
    { 
setNamespace(namespace);
theStateMachine = machine;
StateDiagramGraphModel gm = createGraphModel();
gm.setHomeModel(namespace);
if(theStateMachine != null)//1
{ 
gm.setMachine(theStateMachine);
} 
StateDiagramRenderer rend = new StateDiagramRenderer();
LayerPerspective lay = new LayerPerspectiveMutable(
            Model.getFacade().getName(namespace), gm);
lay.setGraphNodeRenderer(rend);
lay.setGraphEdgeRenderer(rend);
setLayer(lay);
Model.getPump().addModelEventListener(this, theStateMachine,
                                              new String[] {"remove", "namespace"});
} 
protected Object[] getUmlActions()
    { 
Object[] actions = {
            getActionState(),
            getActionCompositeState(),
            getActionTransition(),
            getActionSynchState(),
            getActionSubmachineState(),
            getActionStubState(),
            null,
            getActionStartPseudoState(),
            getActionFinalPseudoState(),
            getActionJunctionPseudoState(),
            getActionChoicePseudoState(),
            getActionForkPseudoState(),
            getActionJoinPseudoState(),
            getActionShallowHistoryPseudoState(),
            getActionDeepHistoryPseudoState(),
            null,
            getTriggerActions(),
            getActionGuard(),
            getEffectActions(),
        };
return actions;
} 
protected Action getActionForkPseudoState()
    { 
if(actionForkPseudoState == null)//1
{ 
actionForkPseudoState = new RadioAction(
                new ActionCreatePseudostate(
                    Model.getPseudostateKind()
                    .getFork(), "button.new-fork"));
} 
return actionForkPseudoState;
} 
private void nameDiagram(Object ns)
    { 
String nname = Model.getFacade().getName(ns);
if(nname != null && nname.trim().length() != 0)//1
{ 
int number = (Model.getFacade().getBehaviors(ns)) == null ? 0
                         : Model.getFacade().getBehaviors(ns).size();
String name = nname + " " + (number++);
LOG.info("UMLStateDiagram constructor: String name = " + name);
try//1
{ 
setName(name);
} 
catch (PropertyVetoException pve) //1
{ 
} 
} 
} 
protected Action getActionDeepHistoryPseudoState()
    { 
if(actionDeepHistoryPseudoState == null)//1
{ 
actionDeepHistoryPseudoState = new RadioAction(
                new ActionCreatePseudostate(
                    Model.getPseudostateKind().getDeepHistory(),
                    "button.new-deephistory"));
} 
return actionDeepHistoryPseudoState;
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
protected Action getActionCallEvent()
    { 
if(actionCallEvent == null)//1
{ 
actionCallEvent = new ButtonActionNewCallEvent();
} 
return actionCallEvent;
} 
protected Action getActionSendAction()
    { 
if(actionSendAction == null)//1
{ 
actionSendAction = ActionNewSendAction.getButtonInstance();
} 
return actionSendAction;
} 
@SuppressWarnings("unchecked")

    public Collection getRelocationCandidates(Object root)
    { 
Collection c =  new HashSet();
c.add(getOwner());
return c;
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
ToolBarUtility.manageDefault(actions, "diagram.state.effect");
return actions;
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
@Deprecated
    public UMLStateDiagram()
    { 
super(new StateDiagramGraphModel());
try//1
{ 
setName(getNewDiagramName());
} 
catch (PropertyVetoException pve) //1
{ 
} 
} 
protected Action getActionDestroyAction()
    { 
if(actionDestroyAction == null)//1
{ 
actionDestroyAction = ActionNewDestroyAction.getButtonInstance();
} 
return actionDestroyAction;
} 
@Override
    public void propertyChange(PropertyChangeEvent evt)
    { 
if((evt.getSource() == theStateMachine)
                && (evt instanceof DeleteInstanceEvent)
                && "remove".equals(evt.getPropertyName()))//1
{ 
Model.getPump().removeModelEventListener(this,
                    theStateMachine, new String[] {"remove", "namespace"});
if(getProject() != null)//1
{ 
getProject().moveToTrash(this);
} 
else
{ 
DiagramFactory.getInstance().removeDiagram(this);
} 
} 
if(evt.getSource() == theStateMachine
                && "namespace".equals(evt.getPropertyName()))//1
{ 
Object newNamespace = evt.getNewValue();
if(newNamespace != null // this in case we are being deleted
                    && getNamespace() != newNamespace)//1
{ 
setNamespace(newNamespace);
((UMLMutableGraphSupport) getGraphModel())
                .setHomeModel(newNamespace);
} 
} 
} 
public void setStateMachine(Object sm)
    { 
if(!Model.getFacade().isAStateMachine(sm))//1
{ 
throw new IllegalArgumentException("This is not a StateMachine");
} 
((StateDiagramGraphModel) getGraphModel()).setMachine(sm);
} 
protected Action getActionReturnAction()
    { 
if(actionReturnAction == null)//1
{ 
actionReturnAction = ActionNewReturnAction.getButtonInstance();
} 
return actionReturnAction;
} 
protected Action getActionSubmachineState()
    { 
if(actionSubmachineState == null)//1
{ 
actionSubmachineState =
                new RadioAction(
                new CmdCreateNode(
                    Model.getMetaTypes().getSubmachineState(),
                    "button.new-submachinestate"));
} 
return actionSubmachineState;
} 
public Object getStateMachine()
    { 
return ((StateDiagramGraphModel) getGraphModel()).getMachine();
} 

 } 
