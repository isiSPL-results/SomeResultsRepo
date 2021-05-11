
//#if -252674305 
// Compilation Unit of /UMLActivityDiagram.java 
 

//#if 1586611257 
package org.argouml.uml.diagram.activity.ui;
//#endif 


//#if -660445029 
import java.awt.Point;
//#endif 


//#if 1213109404 
import java.awt.Rectangle;
//#endif 


//#if 1697954929 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 1434089110 
import java.beans.PropertyVetoException;
//#endif 


//#if 1702789936 
import java.util.ArrayList;
//#endif 


//#if -1708488655 
import java.util.Collection;
//#endif 


//#if -1423538958 
import java.util.Collections;
//#endif 


//#if 656060985 
import java.util.HashMap;
//#endif 


//#if 656243699 
import java.util.HashSet;
//#endif 


//#if 869404001 
import java.util.Iterator;
//#endif 


//#if 1320514865 
import java.util.List;
//#endif 


//#if -920747535 
import javax.swing.Action;
//#endif 


//#if 540617389 
import org.apache.log4j.Logger;
//#endif 


//#if 210652762 
import org.argouml.i18n.Translator;
//#endif 


//#if 589439275 
import org.argouml.model.ActivityGraphsHelper;
//#endif 


//#if -456664113 
import org.argouml.model.DeleteInstanceEvent;
//#endif 


//#if -1906813408 
import org.argouml.model.Model;
//#endif 


//#if 1781828660 
import org.argouml.ui.CmdCreateNode;
//#endif 


//#if 913623043 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -2115597750 
import org.argouml.uml.diagram.UMLMutableGraphSupport;
//#endif 


//#if 642380381 
import org.argouml.uml.diagram.activity.ActivityDiagramGraphModel;
//#endif 


//#if -393630717 
import org.argouml.uml.diagram.state.StateDiagramGraphModel;
//#endif 


//#if -1475524583 
import org.argouml.uml.diagram.state.ui.ActionCreatePseudostate;
//#endif 


//#if -151226312 
import org.argouml.uml.diagram.state.ui.ButtonActionNewCallEvent;
//#endif 


//#if -137438774 
import org.argouml.uml.diagram.state.ui.ButtonActionNewChangeEvent;
//#endif 


//#if -997516606 
import org.argouml.uml.diagram.state.ui.ButtonActionNewSignalEvent;
//#endif 


//#if -946470553 
import org.argouml.uml.diagram.state.ui.ButtonActionNewTimeEvent;
//#endif 


//#if -1519829455 
import org.argouml.uml.diagram.state.ui.FigBranchState;
//#endif 


//#if -701541861 
import org.argouml.uml.diagram.state.ui.FigFinalState;
//#endif 


//#if 552342161 
import org.argouml.uml.diagram.state.ui.FigForkState;
//#endif 


//#if 1695347369 
import org.argouml.uml.diagram.state.ui.FigInitialState;
//#endif 


//#if -371591943 
import org.argouml.uml.diagram.state.ui.FigJoinState;
//#endif 


//#if -1657324253 
import org.argouml.uml.diagram.state.ui.FigJunctionState;
//#endif 


//#if 30335339 
import org.argouml.uml.diagram.state.ui.FigStateVertex;
//#endif 


//#if -1094549196 
import org.argouml.uml.diagram.static_structure.ui.FigComment;
//#endif 


//#if 1641575304 
import org.argouml.uml.diagram.ui.ActionSetMode;
//#endif 


//#if 1016760006 
import org.argouml.uml.diagram.ui.RadioAction;
//#endif 


//#if -59940672 
import org.argouml.uml.diagram.ui.UMLDiagram;
//#endif 


//#if 827834631 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewActionSequence;
//#endif 


//#if -1341776886 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewCallAction;
//#endif 


//#if 2111902444 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewCreateAction;
//#endif 


//#if -192584440 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewDestroyAction;
//#endif 


//#if 1628312632 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewReturnAction;
//#endif 


//#if -1191804000 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewSendAction;
//#endif 


//#if -1628200575 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewTerminateAction;
//#endif 


//#if 1854970607 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewUninterpretedAction;
//#endif 


//#if 619485503 
import org.argouml.uml.ui.behavior.state_machines.ButtonActionNewGuard;
//#endif 


//#if -1426073817 
import org.argouml.util.ToolBarUtility;
//#endif 


//#if 1584972295 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if -1405701463 
import org.tigris.gef.base.LayerPerspectiveMutable;
//#endif 


//#if -864193846 
import org.tigris.gef.base.ModeCreatePolyEdge;
//#endif 


//#if 753233228 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -184651753 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1925858357 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if -1483663560 
public class UMLActivityDiagram extends 
//#if 715008486 
UMLDiagram
//#endif 

  { 

//#if -1977193385 
private static final Logger LOG =
        Logger.getLogger(UMLActivityDiagram.class);
//#endif 


//#if -1566971064 
private static final long serialVersionUID = 6223128918989919230L;
//#endif 


//#if -878041102 
private Object theActivityGraph;
//#endif 


//#if -1813797774 
private Action actionState;
//#endif 


//#if 1640397570 
private Action actionStartPseudoState;
//#endif 


//#if -1271694826 
private Action actionFinalPseudoState;
//#endif 


//#if -1234099388 
private Action actionJunctionPseudoState;
//#endif 


//#if -1197676622 
private Action actionForkPseudoState;
//#endif 


//#if 430005274 
private Action actionJoinPseudoState;
//#endif 


//#if 1979731934 
private Action actionTransition;
//#endif 


//#if -364969505 
private Action actionObjectFlowState;
//#endif 


//#if -615074145 
private Action actionSwimlane;
//#endif 


//#if 1713485936 
private Action actionCallState;
//#endif 


//#if -544299951 
private Action actionSubactivityState;
//#endif 


//#if 1314638727 
private Action actionCallEvent;
//#endif 


//#if -190409383 
private Action actionChangeEvent;
//#endif 


//#if -1050487215 
private Action actionSignalEvent;
//#endif 


//#if 519394486 
private Action actionTimeEvent;
//#endif 


//#if 2138541278 
private Action actionGuard;
//#endif 


//#if -1981173025 
private Action actionCallAction;
//#endif 


//#if 1832536193 
private Action actionCreateAction;
//#endif 


//#if -263003629 
private Action actionDestroyAction;
//#endif 


//#if 1348946381 
private Action actionReturnAction;
//#endif 


//#if -1831200139 
private Action actionSendAction;
//#endif 


//#if -581564468 
private Action actionTerminateAction;
//#endif 


//#if 1299243962 
private Action actionUninterpretedAction;
//#endif 


//#if -1355160228 
private Action actionActionSequence;
//#endif 


//#if 109110811 
protected Action getActionJoinPseudoState()
    { 

//#if 292196409 
if(actionJoinPseudoState == null)//1
{ 

//#if -2035393251 
actionJoinPseudoState =
                new RadioAction(
                new ActionCreatePseudostate(
                    Model.getPseudostateKind().getJoin(),
                    "button.new-join"));
//#endif 

} 

//#endif 


//#if -268869510 
return actionJoinPseudoState;
//#endif 

} 

//#endif 


//#if 1257990966 
protected Action getActionReturnAction()
    { 

//#if -1782645157 
if(actionReturnAction == null)//1
{ 

//#if 1417059974 
actionReturnAction = ActionNewReturnAction.getButtonInstance();
//#endif 

} 

//#endif 


//#if 65586324 
return actionReturnAction;
//#endif 

} 

//#endif 


//#if 1696409741 
protected Action getActionFinalPseudoState()
    { 

//#if 824512734 
if(actionFinalPseudoState == null)//1
{ 

//#if 131807349 
actionFinalPseudoState =
                new RadioAction(
                new CmdCreateNode(
                    Model.getMetaTypes().getFinalState(),
                    "button.new-finalstate"));
//#endif 

} 

//#endif 


//#if 1079761417 
return actionFinalPseudoState;
//#endif 

} 

//#endif 


//#if -1037752508 
protected Action getActionSignalEvent()
    { 

//#if 1672022965 
if(actionSignalEvent == null)//1
{ 

//#if -23985087 
actionSignalEvent = new ButtonActionNewSignalEvent();
//#endif 

} 

//#endif 


//#if 847036484 
return actionSignalEvent;
//#endif 

} 

//#endif 


//#if -1178480719 
protected Action getActionJunctionPseudoState()
    { 

//#if 1085405714 
if(actionJunctionPseudoState == null)//1
{ 

//#if -124460571 
actionJunctionPseudoState =
                new RadioAction(
                new ActionCreatePseudostate(
                    Model.getPseudostateKind().getJunction(),
                    "button.new-junction"));
//#endif 

} 

//#endif 


//#if 1807455271 
return actionJunctionPseudoState;
//#endif 

} 

//#endif 


//#if 1541427852 
private void changePartition(FigNode enclosed)
    { 

//#if 223818817 
assert enclosed != null;
//#endif 


//#if 654101419 
Object state = enclosed.getOwner();
//#endif 


//#if 1205074243 
ActivityGraphsHelper activityGraph = Model.getActivityGraphsHelper();
//#endif 


//#if 824157426 
for (Object f : getLayer().getContentsNoEdges()) //1
{ 

//#if -88670314 
if(f instanceof FigPartition)//1
{ 

//#if 1009694068 
FigPartition fig = (FigPartition) f;
//#endif 


//#if 1835032092 
Object partition = fig.getOwner();
//#endif 


//#if -688227812 
if(fig.getBounds().intersects(enclosed.getBounds()))//1
{ 

//#if -201819210 
activityGraph.addContent(partition, state);
//#endif 

} 
else

//#if -1817028980 
if(isStateInPartition(state, partition))//1
{ 

//#if 689897303 
activityGraph.removeContent(partition, state);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -641775824 
public void encloserChanged(
        FigNode enclosed, FigNode oldEncloser, FigNode newEncloser)
    { 

//#if -344411485 
if(oldEncloser == null && newEncloser == null)//1
{ 

//#if -410513274 
return;
//#endif 

} 

//#endif 


//#if -742406563 
if(enclosed instanceof FigStateVertex
            ||

            enclosed instanceof FigObjectFlowState)//1
{ 

//#if 238355089 
changePartition(enclosed);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1774931112 
protected Object[] getUmlActions()
    { 

//#if 1703831790 
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
//#endif 


//#if 1821459749 
return actions;
//#endif 

} 

//#endif 


//#if 397739967 
protected Action getActionTimeEvent()
    { 

//#if 200316252 
if(actionTimeEvent == null)//1
{ 

//#if 58456828 
actionTimeEvent = new ButtonActionNewTimeEvent();
//#endif 

} 

//#endif 


//#if 2058551253 
return actionTimeEvent;
//#endif 

} 

//#endif 


//#if 2031317599 
protected Object[] getEffectActions()
    { 

//#if -1689364002 
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


//#if 58821636 
ToolBarUtility.manageDefault(actions, "diagram.activity.effect");
//#endif 


//#if 1331086825 
return actions;
//#endif 

} 

//#endif 


//#if 1522504066 
protected Action getActionDestroyAction()
    { 

//#if -1978214181 
if(actionDestroyAction == null)//1
{ 

//#if -227016080 
actionDestroyAction = ActionNewDestroyAction.getButtonInstance();
//#endif 

} 

//#endif 


//#if -1232388370 
return actionDestroyAction;
//#endif 

} 

//#endif 


//#if 1776960801 
protected Action getActionStartPseudoState()
    { 

//#if 1769410053 
if(actionStartPseudoState == null)//1
{ 

//#if -1139923249 
actionStartPseudoState =
                new RadioAction(
                new ActionCreatePseudostate(
                    Model.getPseudostateKind().getInitial(),
                    "button.new-initial"));
//#endif 

} 

//#endif 


//#if -801424952 
return actionStartPseudoState;
//#endif 

} 

//#endif 


//#if -692743584 

//#if 146973932 
@SuppressWarnings("unchecked")
//#endif 


    public Collection getRelocationCandidates(Object root)
    { 

//#if 926201544 
Collection c =  new HashSet();
//#endif 


//#if -248243736 
c.add(getOwner());
//#endif 


//#if 744808206 
return c;
//#endif 

} 

//#endif 


//#if 1232747209 
@Override
    public void postLoad()
    { 

//#if 1237945517 
FigPartition previous = null;
//#endif 


//#if 601018230 
HashMap map = new HashMap();
//#endif 


//#if -1101700958 
Iterator it = new ArrayList(getLayer().getContents()).iterator();
//#endif 


//#if -112844893 
while (it.hasNext()) //1
{ 

//#if -239880583 
Fig f = (Fig) it.next();
//#endif 


//#if 74009496 
if(f instanceof FigPartition)//1
{ 

//#if 1993666389 
map.put(Integer.valueOf(f.getX()), f);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1783976741 
List xList = new ArrayList(map.keySet());
//#endif 


//#if 1266971152 
Collections.sort(xList);
//#endif 


//#if -1884398437 
it = xList.iterator();
//#endif 


//#if 1197261870 
while (it.hasNext()) //2
{ 

//#if 1402757806 
Fig f = (Fig) map.get(it.next());
//#endif 


//#if 1265373434 
if(f instanceof FigPartition)//1
{ 

//#if 528944950 
FigPartition fp = (FigPartition) f;
//#endif 


//#if -1065590618 
if(previous != null)//1
{ 

//#if -835753412 
previous.setNextPartition(fp);
//#endif 

} 

//#endif 


//#if 1496517955 
fp.setPreviousPartition(previous);
//#endif 


//#if -1667976369 
fp.setNextPartition(null);
//#endif 


//#if -1379202574 
previous = fp;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 45751803 
protected Action getActionUninterpretedAction()
    { 

//#if 1844257944 
if(actionUninterpretedAction == null)//1
{ 

//#if -357418499 
actionUninterpretedAction =
                ActionNewUninterpretedAction.getButtonInstance();
//#endif 

} 

//#endif 


//#if -267094055 
return actionUninterpretedAction;
//#endif 

} 

//#endif 


//#if -1657695279 
@Override
    public FigNode drop(Object droppedObject, Point location)
    { 

//#if 1165096172 
FigNode figNode = null;
//#endif 


//#if -3147834 
Rectangle bounds = null;
//#endif 


//#if -223185994 
if(location != null)//1
{ 

//#if 1577685092 
bounds = new Rectangle(location.x, location.y, 0, 0);
//#endif 

} 

//#endif 


//#if 1501847105 
DiagramSettings settings = getDiagramSettings();
//#endif 


//#if 562221679 
if(Model.getFacade().isAPartition(droppedObject))//1
{ 

//#if 893249164 
figNode = new FigPartition(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 168138273 
if(Model.getFacade().isAActionState(droppedObject))//1
{ 

//#if 1269291476 
figNode = new FigActionState(droppedObject, bounds, settings);
//#endif 

} 
else

//#if -52900548 
if(Model.getFacade().isACallState(droppedObject))//1
{ 

//#if 116582730 
figNode = new FigCallState(droppedObject, bounds, settings);
//#endif 

} 
else

//#if -2115858326 
if(Model.getFacade().isAObjectFlowState(droppedObject))//1
{ 

//#if -51695206 
figNode = new FigObjectFlowState(droppedObject, bounds, settings);
//#endif 

} 
else

//#if -83414046 
if(Model.getFacade().isASubactivityState(droppedObject))//1
{ 

//#if -254720193 
figNode = new FigSubactivityState(droppedObject, bounds, settings);
//#endif 

} 
else

//#if -1691281326 
if(Model.getFacade().isAFinalState(droppedObject))//1
{ 

//#if 2043943405 
figNode = new FigFinalState(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 1866725735 
if(Model.getFacade().isAPseudostate(droppedObject))//1
{ 

//#if 1165877244 
Object kind = Model.getFacade().getKind(droppedObject);
//#endif 


//#if 926240281 
if(kind == null)//1
{ 

//#if -663222269 
LOG.warn("found a null type pseudostate");
//#endif 


//#if -1208280532 
return null;
//#endif 

} 

//#endif 


//#if -1240639952 
if(kind.equals(Model.getPseudostateKind().getInitial()))//1
{ 

//#if -1921172464 
figNode = new FigInitialState(droppedObject, bounds, settings);
//#endif 

} 
else

//#if -1795033478 
if(kind.equals(
                           Model.getPseudostateKind().getChoice()))//1
{ 

//#if 1384177445 
figNode = new FigBranchState(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 743139799 
if(kind.equals(
                           Model.getPseudostateKind().getJunction()))//1
{ 

//#if -2054854791 
figNode = new FigJunctionState(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 515750091 
if(kind.equals(
                           Model.getPseudostateKind().getFork()))//1
{ 

//#if 306365437 
figNode = new FigForkState(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 1521485660 
if(kind.equals(
                           Model.getPseudostateKind().getJoin()))//1
{ 

//#if -1106337742 
figNode = new FigJoinState(droppedObject, bounds, settings);
//#endif 

} 
else
{ 

//#if -1872617839 
LOG.warn("found a type not known");
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 
else

//#if -924201077 
if(Model.getFacade().isAComment(droppedObject))//1
{ 

//#if -569546519 
figNode = new FigComment(droppedObject, bounds, settings);
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


//#if 168416059 
if(figNode != null)//1
{ 

//#if 1100199875 
if(location != null)//1
{ 

//#if 149970244 
figNode.setLocation(location.x, location.y);
//#endif 

} 

//#endif 


//#if 167304875 
LOG.debug("Dropped object " + droppedObject + " converted to "
                      + figNode);
//#endif 

} 
else
{ 

//#if 1601382838 
LOG.debug("Dropped object NOT added. This usualy means that this "
                      + "type of object is not accepted!");
//#endif 

} 

//#endif 


//#if -723191846 
return figNode;
//#endif 

} 

//#endif 


//#if 1190579587 
protected Action getActionForkPseudoState()
    { 

//#if 1805662852 
if(actionForkPseudoState == null)//1
{ 

//#if -1921675005 
actionForkPseudoState =
                new RadioAction(
                new ActionCreatePseudostate(
                    Model.getPseudostateKind().getFork(),
                    "button.new-fork"));
//#endif 

} 

//#endif 


//#if 159726901 
return actionForkPseudoState;
//#endif 

} 

//#endif 


//#if -1240130747 
protected Action getActionCallState()
    { 

//#if -1418113047 
if(actionCallState == null)//1
{ 

//#if 2010267517 
actionCallState =
                new RadioAction(
                new CmdCreateNode(
                    Model.getMetaTypes().getCallState(),
                    "button.new-callstate"));
//#endif 

} 

//#endif 


//#if -196279850 
return actionCallState;
//#endif 

} 

//#endif 


//#if -719492338 
protected Action getActionCallEvent()
    { 

//#if 1284761757 
if(actionCallEvent == null)//1
{ 

//#if -24275217 
actionCallEvent = new ButtonActionNewCallEvent();
//#endif 

} 

//#endif 


//#if 715899672 
return actionCallEvent;
//#endif 

} 

//#endif 


//#if -1509162993 
public boolean isRelocationAllowed(Object base)
    { 

//#if -56938808 
return false;
//#endif 

} 

//#endif 


//#if -454331356 
protected Action getActionSwimlane()
    { 

//#if -2015004121 
if(actionSwimlane == null)//1
{ 

//#if -207858002 
actionSwimlane =
                new ActionCreatePartition(getStateMachine());
//#endif 

} 

//#endif 


//#if 1833515204 
return actionSwimlane;
//#endif 

} 

//#endif 


//#if -930594046 
protected Action getActionCreateAction()
    { 

//#if 725057120 
if(actionCreateAction == null)//1
{ 

//#if -898303265 
actionCreateAction = ActionNewCreateAction.getButtonInstance();
//#endif 

} 

//#endif 


//#if -1932798399 
return actionCreateAction;
//#endif 

} 

//#endif 


//#if 1140254827 
public String getLabelName()
    { 

//#if 852858732 
return Translator.localize("label.activity-diagram");
//#endif 

} 

//#endif 


//#if -96839315 
public void initialize(Object o)
    { 

//#if 1968242847 
if(!(Model.getFacade().isAActivityGraph(o)))//1
{ 

//#if 1345476825 
return;
//#endif 

} 

//#endif 


//#if -1300450419 
Object context = Model.getFacade().getContext(o);
//#endif 


//#if -274728325 
if(context != null)//1
{ 

//#if 1154339392 
if(Model.getFacade().isABehavioralFeature(context))//1
{ 

//#if -2022976985 
setup(Model.getFacade().getNamespace(
                          Model.getFacade().getOwner(context)), o);
//#endif 

} 
else
{ 

//#if 40892265 
setup(context, o);
//#endif 

} 

//#endif 

} 
else
{ 

//#if 1301484158 
Object namespace4Diagram = Model.getFacade().getNamespace(o);
//#endif 


//#if -550327050 
if(namespace4Diagram != null)//1
{ 

//#if -760959963 
setup(namespace4Diagram, o);
//#endif 

} 
else
{ 

//#if -696116569 
throw new IllegalStateException("Cannot find context "
                                                + "nor namespace while initializing activity diagram");
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1885496654 
protected Action getActionSendAction()
    { 

//#if -363659814 
if(actionSendAction == null)//1
{ 

//#if 1816095453 
actionSendAction = ActionNewSendAction.getButtonInstance();
//#endif 

} 

//#endif 


//#if -1326207005 
return actionSendAction;
//#endif 

} 

//#endif 


//#if 1023688042 
@Deprecated
    public UMLActivityDiagram(Object namespace, Object agraph)
    { 

//#if 1513869323 
this();
//#endif 


//#if -1704954288 
if(namespace == null)//1
{ 

//#if -1102562707 
namespace = Model.getFacade().getNamespace(agraph);
//#endif 

} 

//#endif 


//#if -1210376322 
if(!Model.getFacade().isANamespace(namespace)
                || !Model.getFacade().isAActivityGraph(agraph))//1
{ 

//#if 1624243937 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if 1450254972 
if(Model.getFacade().getName(namespace) != null)//1
{ 

//#if 1673948436 
if(!Model.getFacade().getName(namespace).trim().equals(""))//1
{ 

//#if -247930810 
String name =
                    Model.getFacade().getName(namespace)
                    + " activity "
                    + (Model.getFacade().getBehaviors(namespace).size());
//#endif 


//#if 978922850 
try //1
{ 

//#if -99526501 
setName(name);
//#endif 

} 

//#if -1655997768 
catch (PropertyVetoException pve) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 736790796 
setup(namespace, agraph);
//#endif 

} 

//#endif 


//#if -654868379 
public Object getDependentElement()
    { 

//#if 299692253 
return getStateMachine();
//#endif 

} 

//#endif 


//#if -1145993746 
public boolean relocate(Object base)
    { 

//#if -282446257 
return false;
//#endif 

} 

//#endif 


//#if 236125127 
protected Action getActionActionSequence()
    { 

//#if -1353303463 
if(actionActionSequence == null)//1
{ 

//#if 1250169487 
actionActionSequence =
                ActionNewActionSequence.getButtonInstance();
//#endif 

} 

//#endif 


//#if 1168023120 
return actionActionSequence;
//#endif 

} 

//#endif 


//#if -1059139746 
public void setup(Object namespace, Object agraph)
    { 

//#if -815433594 
if(!Model.getFacade().isANamespace(namespace)
                || !Model.getFacade().isAActivityGraph(agraph))//1
{ 

//#if 1029941613 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if 1810415383 
setNamespace(namespace);
//#endif 


//#if 1023331544 
theActivityGraph = agraph;
//#endif 


//#if -499764750 
ActivityDiagramGraphModel gm = createGraphModel();
//#endif 


//#if 506930300 
gm.setHomeModel(namespace);
//#endif 


//#if 805529739 
if(theActivityGraph != null)//1
{ 

//#if -938699507 
gm.setMachine(theActivityGraph);
//#endif 

} 

//#endif 


//#if -1789518739 
ActivityDiagramRenderer rend = new ActivityDiagramRenderer();
//#endif 


//#if -1874457859 
LayerPerspective lay = new LayerPerspectiveMutable(
            Model.getFacade().getName(namespace), gm);
//#endif 


//#if -1076571185 
lay.setGraphNodeRenderer(rend);
//#endif 


//#if 76564148 
lay.setGraphEdgeRenderer(rend);
//#endif 


//#if 310054806 
setLayer(lay);
//#endif 


//#if -518835025 
Model.getPump().addModelEventListener(this, theActivityGraph,
                                              new String[] {"remove", "namespace"});
//#endif 

} 

//#endif 


//#if 551060483 
protected Action getActionState()
    { 

//#if -1801103928 
if(actionState == null)//1
{ 

//#if 1341233147 
actionState =
                new RadioAction(
                new CmdCreateNode(
                    Model.getMetaTypes().getActionState(),
                    "button.new-actionstate"));
//#endif 

} 

//#endif 


//#if -1908863559 
return actionState;
//#endif 

} 

//#endif 


//#if -1184780119 
protected Action getActionTerminateAction()
    { 

//#if 1705226939 
if(actionTerminateAction == null)//1
{ 

//#if 223348131 
actionTerminateAction =
                ActionNewTerminateAction.getButtonInstance();
//#endif 

} 

//#endif 


//#if -365733600 
return actionTerminateAction;
//#endif 

} 

//#endif 


//#if 1892725165 
public Object getOwner()
    { 

//#if -1691707962 
if(!(getGraphModel() instanceof ActivityDiagramGraphModel))//1
{ 

//#if -1487728521 
throw new IllegalStateException(
                "Incorrect graph model of "
                + getGraphModel().getClass().getName());
//#endif 

} 

//#endif 


//#if -911703717 
ActivityDiagramGraphModel gm =
            (ActivityDiagramGraphModel) getGraphModel();
//#endif 


//#if 137238073 
return gm.getMachine();
//#endif 

} 

//#endif 


//#if -1524152910 
protected Action getActionSubactivityState()
    { 

//#if 1822450700 
if(actionSubactivityState == null)//1
{ 

//#if 1186874289 
actionSubactivityState =
                new RadioAction(
                new CmdCreateNode(
                    Model.getMetaTypes().getSubactivityState(),
                    "button.new-subactivitystate"));
//#endif 

} 

//#endif 


//#if 139225613 
return actionSubactivityState;
//#endif 

} 

//#endif 


//#if -268897546 
private boolean isStateInPartition(Object state, Object partition)
    { 

//#if -892947858 
return Model.getFacade().getContents(partition).contains(state);
//#endif 

} 

//#endif 


//#if 1234696438 
protected Action getActionObjectFlowState()
    { 

//#if 437250557 
if(actionObjectFlowState == null)//1
{ 

//#if -198230161 
actionObjectFlowState =
                new RadioAction(
                new CmdCreateNode(
                    Model.getMetaTypes().getObjectFlowState(),
                    "button.new-objectflowstate"));
//#endif 

} 

//#endif 


//#if 1174813416 
return actionObjectFlowState;
//#endif 

} 

//#endif 


//#if -145143492 
protected Action getActionChangeEvent()
    { 

//#if 545440954 
if(actionChangeEvent == null)//1
{ 

//#if 853370587 
actionChangeEvent = new ButtonActionNewChangeEvent();
//#endif 

} 

//#endif 


//#if 433265689 
return actionChangeEvent;
//#endif 

} 

//#endif 


//#if 312102491 
private ActivityDiagramGraphModel createGraphModel()
    { 

//#if -1892549921 
if((getGraphModel() instanceof ActivityDiagramGraphModel))//1
{ 

//#if -1848109158 
return (ActivityDiagramGraphModel) getGraphModel();
//#endif 

} 
else
{ 

//#if 1659729976 
return new ActivityDiagramGraphModel();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -737329572 
public void propertyChange(PropertyChangeEvent evt)
    { 

//#if -1185091204 
if((evt.getSource() == theActivityGraph)
                && (evt instanceof DeleteInstanceEvent)
                && "remove".equals(evt.getPropertyName()))//1
{ 

//#if -251004748 
Model.getPump().removeModelEventListener(this,
                    theActivityGraph, new String[] {"remove", "namespace"});
//#endif 


//#if 1996513397 
getProject().moveToTrash(this);
//#endif 

} 

//#endif 


//#if 982230816 
if(evt.getSource() == getStateMachine())//1
{ 

//#if -284588677 
Object newNamespace =
                Model.getFacade().getNamespace(getStateMachine());
//#endif 


//#if -907713334 
if(getNamespace() != newNamespace)//1
{ 

//#if -1270388300 
setNamespace(newNamespace);
//#endif 


//#if 367223396 
((UMLMutableGraphSupport) getGraphModel())
                .setHomeModel(newNamespace);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -234693371 
protected Action getActionTransition()
    { 

//#if -1415806954 
if(actionTransition == null)//1
{ 

//#if 1548481766 
actionTransition =
                new RadioAction(
                new ActionSetMode(
                    ModeCreatePolyEdge.class,
                    "edgeClass",
                    Model.getMetaTypes().getTransition(),
                    "button.new-transition"));
//#endif 

} 

//#endif 


//#if -957391215 
return actionTransition;
//#endif 

} 

//#endif 


//#if 1709681652 
protected Object[] getTriggerActions()
    { 

//#if -750643226 
Object[] actions = {
            getActionCallEvent(),
            getActionChangeEvent(),
            getActionSignalEvent(),
            getActionTimeEvent(),
        };
//#endif 


//#if -1867269843 
ToolBarUtility.manageDefault(actions, "diagram.activity.trigger");
//#endif 


//#if 66026455 
return actions;
//#endif 

} 

//#endif 


//#if -1480480489 
protected Action getActionGuard()
    { 

//#if 1391043060 
if(actionGuard == null)//1
{ 

//#if -950040183 
actionGuard = new ButtonActionNewGuard();
//#endif 

} 

//#endif 


//#if -1302027459 
return actionGuard;
//#endif 

} 

//#endif 


//#if 1531304484 
protected Action getActionCallAction()
    { 

//#if 312412404 
if(actionCallAction == null)//1
{ 

//#if -719621831 
actionCallAction = ActionNewCallAction.getButtonInstance();
//#endif 

} 

//#endif 


//#if 280663953 
return actionCallAction;
//#endif 

} 

//#endif 


//#if -251109402 
@Deprecated
    public UMLActivityDiagram()
    { 

//#if 1700238103 
super();
//#endif 


//#if -959866418 
try //1
{ 

//#if 1745625093 
setName(getNewDiagramName());
//#endif 

} 

//#if -938873257 
catch (PropertyVetoException pve) //1
{ 
} 

//#endif 


//#endif 


//#if -823410195 
setGraphModel(createGraphModel());
//#endif 

} 

//#endif 


//#if -443034338 
public Object getStateMachine()
    { 

//#if -1690729646 
GraphModel gm = getGraphModel();
//#endif 


//#if 884991407 
if(gm instanceof StateDiagramGraphModel)//1
{ 

//#if -1711152661 
Object machine = ((StateDiagramGraphModel) gm).getMachine();
//#endif 


//#if 825751356 
if(!Model.getUmlFactory().isRemoved(machine))//1
{ 

//#if 1781327010 
return machine;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -912375279 
return null;
//#endif 

} 

//#endif 


//#if 1110759739 
@Override
    public boolean doesAccept(Object objectToAccept)
    { 

//#if -1570500362 
if(Model.getFacade().isAPartition(objectToAccept))//1
{ 

//#if -112445107 
return true;
//#endif 

} 
else

//#if 185891114 
if(Model.getFacade().isAState(objectToAccept))//1
{ 

//#if -757177136 
return true;
//#endif 

} 
else

//#if 1816342526 
if(Model.getFacade().isAPseudostate(objectToAccept))//1
{ 

//#if 15115644 
Object kind = Model.getFacade().getKind(objectToAccept);
//#endif 


//#if -324766036 
if(kind == null)//1
{ 

//#if 1123733002 
LOG.warn("found a null type pseudostate");
//#endif 


//#if 1444311207 
return false;
//#endif 

} 

//#endif 


//#if 617894681 
if(kind.equals(
                        Model.getPseudostateKind().getShallowHistory()))//1
{ 

//#if 2132670315 
return false;
//#endif 

} 
else

//#if 1979990249 
if(kind.equals(
                           Model.getPseudostateKind().getDeepHistory()))//1
{ 

//#if -444698845 
return false;
//#endif 

} 

//#endif 


//#endif 


//#if 1722899771 
return true;
//#endif 

} 
else

//#if -740124280 
if(Model.getFacade().isAComment(objectToAccept))//1
{ 

//#if -676758076 
return true;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#if -1160838247 
return false;
//#endif 

} 

//#endif 


//#if 1465682108 
public void setStateMachine(Object sm)
    { 

//#if 1436649551 
if(!Model.getFacade().isAStateMachine(sm))//1
{ 

//#if -468349883 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if 376524727 
((ActivityDiagramGraphModel) getGraphModel()).setMachine(sm);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

