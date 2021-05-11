
//#if -136768275 
// Compilation Unit of /UMLStateDiagram.java 
 

//#if -109982608 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if -1674795772 
import java.awt.Point;
//#endif 


//#if -1977453435 
import java.awt.Rectangle;
//#endif 


//#if -1166866726 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 1414515391 
import java.beans.PropertyVetoException;
//#endif 


//#if -1232727590 
import java.util.Collection;
//#endif 


//#if 1523153642 
import java.util.HashSet;
//#endif 


//#if 183656922 
import javax.swing.Action;
//#endif 


//#if 546428004 
import org.apache.log4j.Logger;
//#endif 


//#if 2021475473 
import org.argouml.i18n.Translator;
//#endif 


//#if -2145535674 
import org.argouml.model.DeleteInstanceEvent;
//#endif 


//#if -1901002793 
import org.argouml.model.Model;
//#endif 


//#if 2082757853 
import org.argouml.ui.CmdCreateNode;
//#endif 


//#if 1338844399 
import org.argouml.uml.diagram.DiagramFactory;
//#endif 


//#if 1405690810 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -889396557 
import org.argouml.uml.diagram.UMLMutableGraphSupport;
//#endif 


//#if 556727732 
import org.argouml.uml.diagram.activity.ui.FigActionState;
//#endif 


//#if 1609322924 
import org.argouml.uml.diagram.state.StateDiagramGraphModel;
//#endif 


//#if -401448803 
import org.argouml.uml.diagram.static_structure.ui.FigComment;
//#endif 


//#if -284193103 
import org.argouml.uml.diagram.ui.ActionSetMode;
//#endif 


//#if 201349167 
import org.argouml.uml.diagram.ui.RadioAction;
//#endif 


//#if -1748812233 
import org.argouml.uml.diagram.ui.UMLDiagram;
//#endif 


//#if -1224608706 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewActionSequence;
//#endif 


//#if -1153400127 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewCallAction;
//#endif 


//#if -1541625885 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewCreateAction;
//#endif 


//#if -1782812943 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewDestroyAction;
//#endif 


//#if -2025215697 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewReturnAction;
//#endif 


//#if -1003427241 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewSendAction;
//#endif 


//#if -829434582 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewTerminateAction;
//#endif 


//#if 1210634776 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewUninterpretedAction;
//#endif 


//#if 807862262 
import org.argouml.uml.ui.behavior.state_machines.ButtonActionNewGuard;
//#endif 


//#if -41231906 
import org.argouml.util.ToolBarUtility;
//#endif 


//#if -1933190736 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if 200825568 
import org.tigris.gef.base.LayerPerspectiveMutable;
//#endif 


//#if -1679604685 
import org.tigris.gef.base.ModeCreatePolyEdge;
//#endif 


//#if -1374219412 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if -831422395 
public class UMLStateDiagram extends 
//#if 700922787 
UMLDiagram
//#endif 

  { 

//#if -253088592 
private static final long serialVersionUID = -1541136327444703151L;
//#endif 


//#if -981207100 
private static final Logger LOG = Logger.getLogger(UMLStateDiagram.class);
//#endif 


//#if -2059012718 
private Object theStateMachine;
//#endif 


//#if -106439197 
private Action actionStubState;
//#endif 


//#if 1980186901 
private Action actionState;
//#endif 


//#if 2052817132 
private Action actionSynchState;
//#endif 


//#if 540469308 
private Action actionSubmachineState;
//#endif 


//#if -1341391802 
private Action actionCompositeState;
//#endif 


//#if 44411519 
private Action actionStartPseudoState;
//#endif 


//#if 1427286419 
private Action actionFinalPseudoState;
//#endif 


//#if 1586357941 
private Action actionBranchPseudoState;
//#endif 


//#if -1249160043 
private Action actionForkPseudoState;
//#endif 


//#if 378521853 
private Action actionJoinPseudoState;
//#endif 


//#if 671536371 
private Action actionShallowHistoryPseudoState;
//#endif 


//#if 1106970469 
private Action actionDeepHistoryPseudoState;
//#endif 


//#if 105537194 
private Action actionCallEvent;
//#endif 


//#if 1799154620 
private Action actionChangeEvent;
//#endif 


//#if 939076788 
private Action actionSignalEvent;
//#endif 


//#if -689707047 
private Action actionTimeEvent;
//#endif 


//#if 1637558657 
private Action actionGuard;
//#endif 


//#if -808614884 
private Action actionCallAction;
//#endif 


//#if -915489154 
private Action actionCreateAction;
//#endif 


//#if 447556534 
private Action actionDestroyAction;
//#endif 


//#if -1399078966 
private Action actionReturnAction;
//#endif 


//#if -658641998 
private Action actionSendAction;
//#endif 


//#if -633047889 
private Action actionTerminateAction;
//#endif 


//#if 566765341 
private Action actionUninterpretedAction;
//#endif 


//#if -802631655 
private Action actionActionSequence;
//#endif 


//#if -1142677221 
private Action actionTransition;
//#endif 


//#if -1966578009 
private Action actionJunctionPseudoState;
//#endif 


//#if -517571017 
protected Action getActionCompositeState()
    { 

//#if 848104747 
if(actionCompositeState == null)//1
{ 

//#if -1778867637 
actionCompositeState =
                new RadioAction(new CmdCreateNode(
                                    Model.getMetaTypes().getCompositeState(),
                                    "button.new-compositestate"));
//#endif 

} 

//#endif 


//#if -1100359140 
return actionCompositeState;
//#endif 

} 

//#endif 


//#if 1918896479 
protected Action getActionChangeEvent()
    { 

//#if 132837516 
if(actionChangeEvent == null)//1
{ 

//#if 85273829 
actionChangeEvent = new ButtonActionNewChangeEvent();
//#endif 

} 

//#endif 


//#if 242552171 
return actionChangeEvent;
//#endif 

} 

//#endif 


//#if -21927756 
private StateDiagramGraphModel createGraphModel()
    { 

//#if 1331352485 
if((getGraphModel() instanceof StateDiagramGraphModel))//1
{ 

//#if 1080786389 
return (StateDiagramGraphModel) getGraphModel();
//#endif 

} 
else
{ 

//#if -293844418 
return new StateDiagramGraphModel();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 509083514 
protected Action getActionGuard()
    { 

//#if -1209974102 
if(actionGuard == null)//1
{ 

//#if -1247440291 
actionGuard = new ButtonActionNewGuard();
//#endif 

} 

//#endif 


//#if -1896315789 
return actionGuard;
//#endif 

} 

//#endif 


//#if 848485108 
@Override
    public FigNode drop(Object droppedObject, Point location)
    { 

//#if 197679686 
FigNode figNode = null;
//#endif 


//#if 71712172 
Rectangle bounds = null;
//#endif 


//#if -148325988 
if(location != null)//1
{ 

//#if -722518880 
bounds = new Rectangle(location.x, location.y, 0, 0);
//#endif 

} 

//#endif 


//#if -1541352921 
DiagramSettings settings = getDiagramSettings();
//#endif 


//#if 665994456 
if(Model.getFacade().isAActionState(droppedObject))//1
{ 

//#if -486026591 
figNode = new FigActionState(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 1369617439 
if(Model.getFacade().isAFinalState(droppedObject))//1
{ 

//#if -417179941 
figNode = new FigFinalState(droppedObject, bounds, settings);
//#endif 

} 
else

//#if -987709820 
if(Model.getFacade().isAStubState(droppedObject))//1
{ 

//#if 2009997043 
figNode = new FigStubState(droppedObject, bounds, settings);
//#endif 

} 
else

//#if -589282533 
if(Model.getFacade().isASubmachineState(droppedObject))//1
{ 

//#if 331354128 
figNode = new FigSubmachineState(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 1218103444 
if(Model.getFacade().isACompositeState(droppedObject))//1
{ 

//#if -921570499 
figNode = new FigCompositeState(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 684553924 
if(Model.getFacade().isASynchState(droppedObject))//1
{ 

//#if -1931788325 
figNode = new FigSynchState(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 1816714829 
if(Model.getFacade().isAState(droppedObject))//1
{ 

//#if 502163035 
figNode = new FigSimpleState(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 845616694 
if(Model.getFacade().isAComment(droppedObject))//1
{ 

//#if -180528432 
figNode = new FigComment(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 168770656 
if(Model.getFacade().isAPseudostate(droppedObject))//1
{ 

//#if 1508933806 
Object kind = Model.getFacade().getKind(droppedObject);
//#endif 


//#if -968789337 
if(kind == null)//1
{ 

//#if 2042987773 
LOG.warn("found a null type pseudostate");
//#endif 


//#if 1135952242 
return null;
//#endif 

} 

//#endif 


//#if 335014206 
if(kind.equals(Model.getPseudostateKind().getInitial()))//1
{ 

//#if -1834014059 
figNode = new FigInitialState(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 2010989328 
if(kind.equals(
                               Model.getPseudostateKind().getChoice()))//1
{ 

//#if -1283481083 
figNode = new FigBranchState(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 217224127 
if(kind.equals(
                               Model.getPseudostateKind().getJunction()))//1
{ 

//#if 149896114 
figNode = new FigJunctionState(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 518700047 
if(kind.equals(
                               Model.getPseudostateKind().getFork()))//1
{ 

//#if -678722390 
figNode = new FigForkState(droppedObject, bounds, settings);
//#endif 

} 
else

//#if -1310116859 
if(kind.equals(
                               Model.getPseudostateKind().getJoin()))//1
{ 

//#if 1161634165 
figNode = new FigJoinState(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 1401850315 
if(kind.equals(
                               Model.getPseudostateKind().getShallowHistory()))//1
{ 

//#if 317582490 
figNode = new FigShallowHistoryState(droppedObject, bounds,
                                                         settings);
//#endif 

} 
else

//#if 205743609 
if(kind.equals(
                               Model.getPseudostateKind().getDeepHistory()))//1
{ 

//#if -482441071 
figNode = new FigDeepHistoryState(droppedObject, bounds,
                                                      settings);
//#endif 

} 
else
{ 

//#if -2003151370 
LOG.warn("found a type not known");
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#if -799000427 
if(figNode != null)//1
{ 

//#if 1666247766 
if(location != null)//1
{ 

//#if 1057741523 
figNode.setLocation(location.x, location.y);
//#endif 

} 

//#endif 


//#if -1635275906 
LOG.debug("Dropped object " + droppedObject + " converted to "
                      + figNode);
//#endif 

} 
else
{ 

//#if 331275194 
LOG.debug("Dropped object NOT added " + figNode);
//#endif 

} 

//#endif 


//#if 534833332 
return figNode;
//#endif 

} 

//#endif 


//#if 113695601 
protected Object[] getTriggerActions()
    { 

//#if -1368574427 
Object[] actions = {
            getActionCallEvent(),
            getActionChangeEvent(),
            getActionSignalEvent(),
            getActionTimeEvent(),
        };
//#endif 


//#if 588291432 
ToolBarUtility.manageDefault(actions, "diagram.state.trigger");
//#endif 


//#if 734367032 
return actions;
//#endif 

} 

//#endif 


//#if -1369864385 
protected Action getActionCreateAction()
    { 

//#if -1423448054 
if(actionCreateAction == null)//1
{ 

//#if -163929254 
actionCreateAction = ActionNewCreateAction.getButtonInstance();
//#endif 

} 

//#endif 


//#if 1024411499 
return actionCreateAction;
//#endif 

} 

//#endif 


//#if 1011161727 
@Deprecated
    public UMLStateDiagram(Object ns, Object machine)
    { 

//#if -320163101 
this();
//#endif 


//#if 1947426486 
if(!Model.getFacade().isAStateMachine(machine))//1
{ 

//#if -822111154 
throw new IllegalStateException(
                "No StateMachine given to create a Statechart diagram");
//#endif 

} 

//#endif 


//#if -2039336762 
if(ns == null)//1
{ 

//#if -487666818 
ns = getNamespaceFromMachine(machine);
//#endif 

} 

//#endif 


//#if -741340743 
if(!Model.getFacade().isANamespace(ns))//1
{ 

//#if -76318607 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if 1794298896 
nameDiagram(ns);
//#endif 


//#if 1817330710 
setup(ns, machine);
//#endif 

} 

//#endif 


//#if -331299668 
@Override
    public void initialize(Object o)
    { 

//#if 70470216 
if(Model.getFacade().isAStateMachine(o))//1
{ 

//#if 268385002 
Object machine = o;
//#endif 


//#if 247148192 
Object contextNamespace = getNamespaceFromMachine(machine);
//#endif 


//#if -1559031987 
setup(contextNamespace, machine);
//#endif 

} 
else
{ 

//#if 2041919732 
throw new IllegalStateException(
                "Cannot find namespace "
                + "while initializing "
                + "statechart diagram");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1061696548 
@Override
    public Object getDependentElement()
    { 

//#if -972658446 
return getStateMachine();
//#endif 

} 

//#endif 


//#if -1116208264 
@Override
    public boolean doesAccept(Object objectToAccept)
    { 

//#if -1174157154 
if(Model.getFacade().isAState(objectToAccept))//1
{ 

//#if 119082062 
return true;
//#endif 

} 
else

//#if -974213284 
if(Model.getFacade().isASynchState(objectToAccept))//1
{ 

//#if 157007563 
return true;
//#endif 

} 
else

//#if 229868701 
if(Model.getFacade().isAStubState(objectToAccept))//1
{ 

//#if -1052660718 
return true;
//#endif 

} 
else

//#if 226859289 
if(Model.getFacade().isAPseudostate(objectToAccept))//1
{ 

//#if -244554057 
return true;
//#endif 

} 
else

//#if 2029926991 
if(Model.getFacade().isAComment(objectToAccept))//1
{ 

//#if -793339082 
return true;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#if -472609288 
return false;
//#endif 

} 

//#endif 


//#if -330109139 
public void encloserChanged(FigNode enclosed,
                                FigNode oldEncloser, FigNode newEncloser)
    { 
} 

//#endif 


//#if -306814324 
public boolean isRelocationAllowed(Object base)
    { 

//#if -1415592125 
return false;
//#endif 

} 

//#endif 


//#if 1491624103 
protected Action getActionChoicePseudoState()
    { 

//#if 865735647 
if(actionBranchPseudoState == null)//1
{ 

//#if -866787644 
actionBranchPseudoState = new RadioAction(
                new ActionCreatePseudostate(Model.getPseudostateKind()
                                            .getChoice(), "button.new-choice"));
//#endif 

} 

//#endif 


//#if -2003249456 
return actionBranchPseudoState;
//#endif 

} 

//#endif 


//#if -64681567 
protected Action getActionCallAction()
    { 

//#if 100996487 
if(actionCallAction == null)//1
{ 

//#if -1419513493 
actionCallAction = ActionNewCallAction.getButtonInstance();
//#endif 

} 

//#endif 


//#if 1518227044 
return actionCallAction;
//#endif 

} 

//#endif 


//#if 346256546 
protected Action getActionTimeEvent()
    { 

//#if -1926583647 
if(actionTimeEvent == null)//1
{ 

//#if -2024518590 
actionTimeEvent = new ButtonActionNewTimeEvent();
//#endif 

} 

//#endif 


//#if 560180442 
return actionTimeEvent;
//#endif 

} 

//#endif 


//#if -1554602287 
protected Action getActionSynchState()
    { 

//#if 1479164139 
if(actionSynchState == null)//1
{ 

//#if -810367255 
actionSynchState =
                new RadioAction(
                new CmdCreateNode(
                    Model.getMetaTypes().getSynchState(),
                    "button.new-synchstate"));
//#endif 

} 

//#endif 


//#if -696270744 
return actionSynchState;
//#endif 

} 

//#endif 


//#if -1830679422 
protected Action getActionTransition()
    { 

//#if 1340999704 
if(actionTransition == null)//1
{ 

//#if -2145874059 
actionTransition = new RadioAction(
                new ActionSetMode(
                    ModeCreatePolyEdge.class,
                    "edgeClass",
                    Model.getMetaTypes().getTransition(),
                    "button.new-transition"));
//#endif 

} 

//#endif 


//#if 1224708115 
return actionTransition;
//#endif 

} 

//#endif 


//#if -722098356 
protected Action getActionTerminateAction()
    { 

//#if 1172788947 
if(actionTerminateAction == null)//1
{ 

//#if -513957331 
actionTerminateAction =
                ActionNewTerminateAction.getButtonInstance();
//#endif 

} 

//#endif 


//#if -1633030344 
return actionTerminateAction;
//#endif 

} 

//#endif 


//#if -1336145122 
protected Action getActionUninterpretedAction()
    { 

//#if 1781455490 
if(actionUninterpretedAction == null)//1
{ 

//#if 1488742313 
actionUninterpretedAction =
                ActionNewUninterpretedAction.getButtonInstance();
//#endif 

} 

//#endif 


//#if -710449853 
return actionUninterpretedAction;
//#endif 

} 

//#endif 


//#if -1059773730 
protected Action getActionStartPseudoState()
    { 

//#if 863916762 
if(actionStartPseudoState == null)//1
{ 

//#if -1432276505 
actionStartPseudoState = new RadioAction(
                new ActionCreatePseudostate(
                    Model.getPseudostateKind().getInitial(),
                    "button.new-initial"));
//#endif 

} 

//#endif 


//#if -285736355 
return actionStartPseudoState;
//#endif 

} 

//#endif 


//#if 1224559816 
protected Action getActionShallowHistoryPseudoState()
    { 

//#if 1383263594 
if(actionShallowHistoryPseudoState == null)//1
{ 

//#if 1907929845 
actionShallowHistoryPseudoState = new RadioAction(
                new ActionCreatePseudostate(
                    Model.getPseudostateKind().getShallowHistory(),
                    "button.new-shallowhistory"));
//#endif 

} 

//#endif 


//#if 1380819159 
return actionShallowHistoryPseudoState;
//#endif 

} 

//#endif 


//#if 353865170 
public UMLStateDiagram(String name, Object machine)
    { 

//#if -2021546180 
super(name, machine, new StateDiagramGraphModel());
//#endif 


//#if 461990626 
if(!Model.getFacade().isAStateMachine(machine))//1
{ 

//#if 1753442048 
throw new IllegalStateException(
                "No StateMachine given to create a Statechart diagram");
//#endif 

} 

//#endif 


//#if -426389854 
namespace = getNamespaceFromMachine(machine);
//#endif 


//#if 27558717 
if(!Model.getFacade().isANamespace(namespace))//1
{ 

//#if 915073077 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if -2004342104 
nameDiagram(namespace);
//#endif 


//#if 182288120 
setup(namespace, machine);
//#endif 

} 

//#endif 


//#if -817175953 
private Object getNamespaceFromMachine(Object machine)
    { 

//#if 121913798 
if(!Model.getFacade().isAStateMachine(machine))//1
{ 

//#if 2002142230 
throw new IllegalStateException(
                "No StateMachine given to create a Statechart diagram");
//#endif 

} 

//#endif 


//#if -1609703576 
Object ns = Model.getFacade().getNamespace(machine);
//#endif 


//#if -379451310 
if(ns != null)//1
{ 

//#if -451160273 
return ns;
//#endif 

} 

//#endif 


//#if 891036898 
Object context = Model.getFacade().getContext(machine);
//#endif 


//#if -951115466 
if(Model.getFacade().isAClassifier(context))//1
{ 

//#if 1877992540 
ns = context;
//#endif 

} 
else

//#if 1226453154 
if(Model.getFacade().isABehavioralFeature(context))//1
{ 

//#if -1002599956 
ns = Model.getFacade().getNamespace( // or just the owner?
                     Model.getFacade().getOwner(context));
//#endif 

} 

//#endif 


//#endif 


//#if -1586862154 
if(ns == null)//1
{ 

//#if -635037706 
ns = getProject().getRoots().iterator().next();
//#endif 

} 

//#endif 


//#if 876512797 
if(ns == null || !Model.getFacade().isANamespace(ns))//1
{ 

//#if -1999661470 
throw new IllegalStateException(
                "Can not deduce a Namespace from a StateMachine");
//#endif 

} 

//#endif 


//#if 902201341 
return ns;
//#endif 

} 

//#endif 


//#if 571792574 
protected Action getActionJoinPseudoState()
    { 

//#if -1552205815 
if(actionJoinPseudoState == null)//1
{ 

//#if 1743745577 
actionJoinPseudoState = new RadioAction(new ActionCreatePseudostate(
                    Model.getPseudostateKind().getJoin(), "button.new-join"));
//#endif 

} 

//#endif 


//#if -430431158 
return actionJoinPseudoState;
//#endif 

} 

//#endif 


//#if 1026287463 
protected Action getActionSignalEvent()
    { 

//#if -788504857 
if(actionSignalEvent == null)//1
{ 

//#if 702688781 
actionSignalEvent = new ButtonActionNewSignalEvent();
//#endif 

} 

//#endif 


//#if -69803786 
return actionSignalEvent;
//#endif 

} 

//#endif 


//#if -1754342810 
protected Action getActionState()
    { 

//#if 749051905 
if(actionState == null)//1
{ 

//#if -1533996931 
actionState =
                new RadioAction(
                new CmdCreateNode(Model.getMetaTypes().getSimpleState(),
                                  "button.new-simplestate"));
//#endif 

} 

//#endif 


//#if -1779976526 
return actionState;
//#endif 

} 

//#endif 


//#if 1247690712 
protected Action getActionStubState()
    { 

//#if -1288352578 
if(actionStubState == null)//1
{ 

//#if -2015959659 
actionStubState =
                new RadioAction(
                new CmdCreateNode(
                    Model.getMetaTypes().getStubState(),
                    "button.new-stubstate"));
//#endif 

} 

//#endif 


//#if -1263236853 
return actionStubState;
//#endif 

} 

//#endif 


//#if 1393221454 
@Override
    public Object getOwner()
    { 

//#if -642671050 
if(!(getGraphModel() instanceof StateDiagramGraphModel))//1
{ 

//#if -2069470065 
throw new IllegalStateException(
                "Incorrect graph model of "
                + getGraphModel().getClass().getName());
//#endif 

} 

//#endif 


//#if 1636290069 
StateDiagramGraphModel gm = (StateDiagramGraphModel) getGraphModel();
//#endif 


//#if 1481592547 
return gm.getMachine();
//#endif 

} 

//#endif 


//#if -435433583 
public boolean relocate(Object base)
    { 

//#if 377611814 
return false;
//#endif 

} 

//#endif 


//#if -1505304536 
public String getLabelName()
    { 

//#if -1438038206 
return Translator.localize("label.state-chart-diagram");
//#endif 

} 

//#endif 


//#if 1734589652 
protected Action getActionJunctionPseudoState()
    { 

//#if -835339497 
if(actionJunctionPseudoState == null)//1
{ 

//#if 1174385176 
actionJunctionPseudoState = new RadioAction(
                new ActionCreatePseudostate(
                    Model.getPseudostateKind().getJunction(),
                    "button.new-junction"));
//#endif 

} 

//#endif 


//#if -749617940 
return actionJunctionPseudoState;
//#endif 

} 

//#endif 


//#if -377066211 
public void setup(Object namespace, Object machine)
    { 

//#if 1602416851 
setNamespace(namespace);
//#endif 


//#if -1650717953 
theStateMachine = machine;
//#endif 


//#if -963869314 
StateDiagramGraphModel gm = createGraphModel();
//#endif 


//#if 1660471616 
gm.setHomeModel(namespace);
//#endif 


//#if -1229561252 
if(theStateMachine != null)//1
{ 

//#if 1570969644 
gm.setMachine(theStateMachine);
//#endif 

} 

//#endif 


//#if 1124700783 
StateDiagramRenderer rend = new StateDiagramRenderer();
//#endif 


//#if 1920228537 
LayerPerspective lay = new LayerPerspectiveMutable(
            Model.getFacade().getName(namespace), gm);
//#endif 


//#if -840010093 
lay.setGraphNodeRenderer(rend);
//#endif 


//#if 313125240 
lay.setGraphEdgeRenderer(rend);
//#endif 


//#if 1503198290 
setLayer(lay);
//#endif 


//#if 1428667526 
Model.getPump().addModelEventListener(this, theStateMachine,
                                              new String[] {"remove", "namespace"});
//#endif 

} 

//#endif 


//#if -227989163 
protected Object[] getUmlActions()
    { 

//#if 858619972 
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
//#endif 


//#if 1608897029 
return actions;
//#endif 

} 

//#endif 


//#if 1653261350 
protected Action getActionForkPseudoState()
    { 

//#if 1551091354 
if(actionForkPseudoState == null)//1
{ 

//#if 1299629869 
actionForkPseudoState = new RadioAction(
                new ActionCreatePseudostate(
                    Model.getPseudostateKind()
                    .getFork(), "button.new-fork"));
//#endif 

} 

//#endif 


//#if -761196085 
return actionForkPseudoState;
//#endif 

} 

//#endif 


//#if -1391633454 
private void nameDiagram(Object ns)
    { 

//#if 12117371 
String nname = Model.getFacade().getName(ns);
//#endif 


//#if 1398151766 
if(nname != null && nname.trim().length() != 0)//1
{ 

//#if 144062824 
int number = (Model.getFacade().getBehaviors(ns)) == null ? 0
                         : Model.getFacade().getBehaviors(ns).size();
//#endif 


//#if -4319910 
String name = nname + " " + (number++);
//#endif 


//#if -1204955468 
LOG.info("UMLStateDiagram constructor: String name = " + name);
//#endif 


//#if -2075380729 
try //1
{ 

//#if 131503894 
setName(name);
//#endif 

} 

//#if 1047726176 
catch (PropertyVetoException pve) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 10184184 
protected Action getActionDeepHistoryPseudoState()
    { 

//#if -2096810166 
if(actionDeepHistoryPseudoState == null)//1
{ 

//#if 70276545 
actionDeepHistoryPseudoState = new RadioAction(
                new ActionCreatePseudostate(
                    Model.getPseudostateKind().getDeepHistory(),
                    "button.new-deephistory"));
//#endif 

} 

//#endif 


//#if 163137305 
return actionDeepHistoryPseudoState;
//#endif 

} 

//#endif 


//#if -1140324790 
protected Action getActionFinalPseudoState()
    { 

//#if 976969305 
if(actionFinalPseudoState == null)//1
{ 

//#if 1937894939 
actionFinalPseudoState =
                new RadioAction(
                new CmdCreateNode(
                    Model.getMetaTypes().getFinalState(),
                    "button.new-finalstate"));
//#endif 

} 

//#endif 


//#if -1246978108 
return actionFinalPseudoState;
//#endif 

} 

//#endif 


//#if -770975759 
protected Action getActionCallEvent()
    { 

//#if -863062230 
if(actionCallEvent == null)//1
{ 

//#if -1078235431 
actionCallEvent = new ButtonActionNewCallEvent();
//#endif 

} 

//#endif 


//#if 945012581 
return actionCallEvent;
//#endif 

} 

//#endif 


//#if 289510603 
protected Action getActionSendAction()
    { 

//#if -655794541 
if(actionSendAction == null)//1
{ 

//#if -1468499765 
actionSendAction = ActionNewSendAction.getButtonInstance();
//#endif 

} 

//#endif 


//#if -450146468 
return actionSendAction;
//#endif 

} 

//#endif 


//#if 1743509827 

//#if -851223917 
@SuppressWarnings("unchecked")
//#endif 


    public Collection getRelocationCandidates(Object root)
    { 

//#if 3359113 
Collection c =  new HashSet();
//#endif 


//#if 1744680519 
c.add(getOwner());
//#endif 


//#if 62232109 
return c;
//#endif 

} 

//#endif 


//#if 1979834178 
protected Object[] getEffectActions()
    { 

//#if 38417876 
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
//#endif 


//#if 2027319504 
ToolBarUtility.manageDefault(actions, "diagram.state.effect");
//#endif 


//#if 334444639 
return actions;
//#endif 

} 

//#endif 


//#if -995875644 
protected Action getActionActionSequence()
    { 

//#if 1989720281 
if(actionActionSequence == null)//1
{ 

//#if 843730423 
actionActionSequence =
                ActionNewActionSequence.getButtonInstance();
//#endif 

} 

//#endif 


//#if 1447165136 
return actionActionSequence;
//#endif 

} 

//#endif 


//#if 1262468287 
@Deprecated
    public UMLStateDiagram()
    { 

//#if -205794663 
super(new StateDiagramGraphModel());
//#endif 


//#if 1966809024 
try //1
{ 

//#if 1843177788 
setName(getNewDiagramName());
//#endif 

} 

//#if 762264989 
catch (PropertyVetoException pve) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 


//#if 790025445 
protected Action getActionDestroyAction()
    { 

//#if 644806797 
if(actionDestroyAction == null)//1
{ 

//#if 1439366834 
actionDestroyAction = ActionNewDestroyAction.getButtonInstance();
//#endif 

} 

//#endif 


//#if 10062880 
return actionDestroyAction;
//#endif 

} 

//#endif 


//#if 1303688381 
@Override
    public void propertyChange(PropertyChangeEvent evt)
    { 

//#if 1915974228 
if((evt.getSource() == theStateMachine)
                && (evt instanceof DeleteInstanceEvent)
                && "remove".equals(evt.getPropertyName()))//1
{ 

//#if -2119280933 
Model.getPump().removeModelEventListener(this,
                    theStateMachine, new String[] {"remove", "namespace"});
//#endif 


//#if -2011766737 
if(getProject() != null)//1
{ 

//#if -2040496189 
getProject().moveToTrash(this);
//#endif 

} 
else
{ 

//#if 1025223323 
DiagramFactory.getInstance().removeDiagram(this);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1847505832 
if(evt.getSource() == theStateMachine
                && "namespace".equals(evt.getPropertyName()))//1
{ 

//#if -1394080772 
Object newNamespace = evt.getNewValue();
//#endif 


//#if 268746254 
if(newNamespace != null // this in case we are being deleted
                    && getNamespace() != newNamespace)//1
{ 

//#if -512533307 
setNamespace(newNamespace);
//#endif 


//#if -221777867 
((UMLMutableGraphSupport) getGraphModel())
                .setHomeModel(newNamespace);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1414198687 
public void setStateMachine(Object sm)
    { 

//#if 393375723 
if(!Model.getFacade().isAStateMachine(sm))//1
{ 

//#if -492780510 
throw new IllegalArgumentException("This is not a StateMachine");
//#endif 

} 

//#endif 


//#if -657159541 
((StateDiagramGraphModel) getGraphModel()).setMachine(sm);
//#endif 

} 

//#endif 


//#if 818720627 
protected Action getActionReturnAction()
    { 

//#if 497912097 
if(actionReturnAction == null)//1
{ 

//#if 407612847 
actionReturnAction = ActionNewReturnAction.getButtonInstance();
//#endif 

} 

//#endif 


//#if -1724884006 
return actionReturnAction;
//#endif 

} 

//#endif 


//#if 1297196383 
protected Action getActionSubmachineState()
    { 

//#if -1342367086 
if(actionSubmachineState == null)//1
{ 

//#if 403676637 
actionSubmachineState =
                new RadioAction(
                new CmdCreateNode(
                    Model.getMetaTypes().getSubmachineState(),
                    "button.new-submachinestate"));
//#endif 

} 

//#endif 


//#if -1561404303 
return actionSubmachineState;
//#endif 

} 

//#endif 


//#if -1652135871 
public Object getStateMachine()
    { 

//#if 687153032 
return ((StateDiagramGraphModel) getGraphModel()).getMachine();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

