
//#if 1658412912 
// Compilation Unit of /ElementPropPanelFactory.java 
 

//#if 125865815 
package org.argouml.uml.ui;
//#endif 


//#if -176897210 
import org.argouml.model.Model;
//#endif 


//#if -2109363939 
import org.argouml.uml.ui.behavior.activity_graphs.PropPanelActionState;
//#endif 


//#if 272008921 
import org.argouml.uml.ui.behavior.activity_graphs.PropPanelActivityGraph;
//#endif 


//#if -2000084347 
import org.argouml.uml.ui.behavior.activity_graphs.PropPanelCallState;
//#endif 


//#if -1897724851 
import org.argouml.uml.ui.behavior.activity_graphs.PropPanelClassifierInState;
//#endif 


//#if -552482764 
import org.argouml.uml.ui.behavior.activity_graphs.PropPanelObjectFlowState;
//#endif 


//#if 747304782 
import org.argouml.uml.ui.behavior.activity_graphs.PropPanelPartition;
//#endif 


//#if -2062243684 
import org.argouml.uml.ui.behavior.activity_graphs.PropPanelSubactivityState;
//#endif 


//#if -1715946721 
import org.argouml.uml.ui.behavior.collaborations.PropPanelAssociationEndRole;
//#endif 


//#if 1855487472 
import org.argouml.uml.ui.behavior.collaborations.PropPanelAssociationRole;
//#endif 


//#if 1701412856 
import org.argouml.uml.ui.behavior.collaborations.PropPanelClassifierRole;
//#endif 


//#if 552619266 
import org.argouml.uml.ui.behavior.collaborations.PropPanelCollaboration;
//#endif 


//#if -103244331 
import org.argouml.uml.ui.behavior.collaborations.PropPanelInteraction;
//#endif 


//#if -1062977408 
import org.argouml.uml.ui.behavior.collaborations.PropPanelMessage;
//#endif 


//#if 1207886647 
import org.argouml.uml.ui.behavior.common_behavior.PropPanelAction;
//#endif 


//#if -60110986 
import org.argouml.uml.ui.behavior.common_behavior.PropPanelActionSequence;
//#endif 


//#if -1095876848 
import org.argouml.uml.ui.behavior.common_behavior.PropPanelArgument;
//#endif 


//#if -524045831 
import org.argouml.uml.ui.behavior.common_behavior.PropPanelCallAction;
//#endif 


//#if -1660151785 
import org.argouml.uml.ui.behavior.common_behavior.PropPanelComponentInstance;
//#endif 


//#if 1972431131 
import org.argouml.uml.ui.behavior.common_behavior.PropPanelCreateAction;
//#endif 


//#if -221227847 
import org.argouml.uml.ui.behavior.common_behavior.PropPanelDestroyAction;
//#endif 


//#if 2044801562 
import org.argouml.uml.ui.behavior.common_behavior.PropPanelException;
//#endif 


//#if 583655027 
import org.argouml.uml.ui.behavior.common_behavior.PropPanelLink;
//#endif 


//#if 1639701928 
import org.argouml.uml.ui.behavior.common_behavior.PropPanelLinkEnd;
//#endif 


//#if 179998550 
import org.argouml.uml.ui.behavior.common_behavior.PropPanelNodeInstance;
//#endif 


//#if 710041422 
import org.argouml.uml.ui.behavior.common_behavior.PropPanelObject;
//#endif 


//#if -527977574 
import org.argouml.uml.ui.behavior.common_behavior.PropPanelReception;
//#endif 


//#if 1488841319 
import org.argouml.uml.ui.behavior.common_behavior.PropPanelReturnAction;
//#endif 


//#if -374072945 
import org.argouml.uml.ui.behavior.common_behavior.PropPanelSendAction;
//#endif 


//#if 162988293 
import org.argouml.uml.ui.behavior.common_behavior.PropPanelSignal;
//#endif 


//#if 1473912115 
import org.argouml.uml.ui.behavior.common_behavior.PropPanelStimulus;
//#endif 


//#if 910256370 
import org.argouml.uml.ui.behavior.common_behavior.PropPanelTerminateAction;
//#endif 


//#if -1847901728 
import org.argouml.uml.ui.behavior.common_behavior.PropPanelUninterpretedAction;
//#endif 


//#if -1947351689 
import org.argouml.uml.ui.behavior.state_machines.PropPanelCallEvent;
//#endif 


//#if 362926921 
import org.argouml.uml.ui.behavior.state_machines.PropPanelChangeEvent;
//#endif 


//#if -1536569959 
import org.argouml.uml.ui.behavior.state_machines.PropPanelCompositeState;
//#endif 


//#if -658022072 
import org.argouml.uml.ui.behavior.state_machines.PropPanelFinalState;
//#endif 


//#if -713818418 
import org.argouml.uml.ui.behavior.state_machines.PropPanelGuard;
//#endif 


//#if -432308320 
import org.argouml.uml.ui.behavior.state_machines.PropPanelPseudostate;
//#endif 


//#if -497150911 
import org.argouml.uml.ui.behavior.state_machines.PropPanelSignalEvent;
//#endif 


//#if -523840332 
import org.argouml.uml.ui.behavior.state_machines.PropPanelSimpleState;
//#endif 


//#if 1612359917 
import org.argouml.uml.ui.behavior.state_machines.PropPanelStateMachine;
//#endif 


//#if 1379448798 
import org.argouml.uml.ui.behavior.state_machines.PropPanelStateVertex;
//#endif 


//#if 2135639216 
import org.argouml.uml.ui.behavior.state_machines.PropPanelStubState;
//#endif 


//#if -1215086263 
import org.argouml.uml.ui.behavior.state_machines.PropPanelSubmachineState;
//#endif 


//#if -1457196097 
import org.argouml.uml.ui.behavior.state_machines.PropPanelSynchState;
//#endif 


//#if 1552371366 
import org.argouml.uml.ui.behavior.state_machines.PropPanelTimeEvent;
//#endif 


//#if -357723154 
import org.argouml.uml.ui.behavior.state_machines.PropPanelTransition;
//#endif 


//#if 1620203097 
import org.argouml.uml.ui.behavior.use_cases.PropPanelActor;
//#endif 


//#if -1457352370 
import org.argouml.uml.ui.behavior.use_cases.PropPanelExtend;
//#endif 


//#if -1613354569 
import org.argouml.uml.ui.behavior.use_cases.PropPanelExtensionPoint;
//#endif 


//#if -317099706 
import org.argouml.uml.ui.behavior.use_cases.PropPanelInclude;
//#endif 


//#if -716848521 
import org.argouml.uml.ui.behavior.use_cases.PropPanelUseCase;
//#endif 


//#if 222399185 
import org.argouml.uml.ui.foundation.core.PropPanelAbstraction;
//#endif 


//#if -1733179818 
import org.argouml.uml.ui.foundation.core.PropPanelAssociation;
//#endif 


//#if -1274985304 
import org.argouml.uml.ui.foundation.core.PropPanelAssociationClass;
//#endif 


//#if 937281253 
import org.argouml.uml.ui.foundation.core.PropPanelAssociationEnd;
//#endif 


//#if 451357339 
import org.argouml.uml.ui.foundation.core.PropPanelAttribute;
//#endif 


//#if -1730337473 
import org.argouml.uml.ui.foundation.core.PropPanelClass;
//#endif 


//#if 1281415230 
import org.argouml.uml.ui.foundation.core.PropPanelClassifier;
//#endif 


//#if -1996779976 
import org.argouml.uml.ui.foundation.core.PropPanelComment;
//#endif 


//#if -401734566 
import org.argouml.uml.ui.foundation.core.PropPanelComponent;
//#endif 


//#if -189639678 
import org.argouml.uml.ui.foundation.core.PropPanelConstraint;
//#endif 


//#if -648998469 
import org.argouml.uml.ui.foundation.core.PropPanelDataType;
//#endif 


//#if 602031188 
import org.argouml.uml.ui.foundation.core.PropPanelDependency;
//#endif 


//#if 988107088 
import org.argouml.uml.ui.foundation.core.PropPanelEnumeration;
//#endif 


//#if -1021012265 
import org.argouml.uml.ui.foundation.core.PropPanelEnumerationLiteral;
//#endif 


//#if -330127919 
import org.argouml.uml.ui.foundation.core.PropPanelFlow;
//#endif 


//#if 1854633283 
import org.argouml.uml.ui.foundation.core.PropPanelGeneralization;
//#endif 


//#if -1552827490 
import org.argouml.uml.ui.foundation.core.PropPanelInterface;
//#endif 


//#if -1998939266 
import org.argouml.uml.ui.foundation.core.PropPanelMethod;
//#endif 


//#if -322661507 
import org.argouml.uml.ui.foundation.core.PropPanelNode;
//#endif 


//#if 49895728 
import org.argouml.uml.ui.foundation.core.PropPanelOperation;
//#endif 


//#if 504447790 
import org.argouml.uml.ui.foundation.core.PropPanelParameter;
//#endif 


//#if -1744199088 
import org.argouml.uml.ui.foundation.core.PropPanelPermission;
//#endif 


//#if 766348807 
import org.argouml.uml.ui.foundation.core.PropPanelRelationship;
//#endif 


//#if -1208560074 
import org.argouml.uml.ui.foundation.core.PropPanelUsage;
//#endif 


//#if 1443526546 
import org.argouml.uml.ui.foundation.extension_mechanisms.PropPanelStereotype;
//#endif 


//#if 712944741 
import org.argouml.uml.ui.foundation.extension_mechanisms.PropPanelTagDefinition;
//#endif 


//#if 1966425677 
import org.argouml.uml.ui.foundation.extension_mechanisms.PropPanelTaggedValue;
//#endif 


//#if -952865521 
import org.argouml.uml.ui.model_management.PropPanelModel;
//#endif 


//#if 494212178 
import org.argouml.uml.ui.model_management.PropPanelPackage;
//#endif 


//#if 1873533449 
import org.argouml.uml.ui.model_management.PropPanelSubsystem;
//#endif 


//#if 1807004314 
class ElementPropPanelFactory implements 
//#if 465589337 
PropPanelFactory
//#endif 

  { 

//#if -1056321863 
private PropPanelStateVertex getStateVertexPropPanel(Object element)
    { 

//#if 1748846938 
if(Model.getFacade().isAState(element))//1
{ 

//#if -174208248 
if(Model.getFacade().isACallState(element))//1
{ 

//#if -468796524 
return new PropPanelCallState();
//#endif 

} 
else

//#if 1202039721 
if(Model.getFacade().isAActionState(element))//1
{ 

//#if 156578353 
return new PropPanelActionState();
//#endif 

} 
else

//#if -320501818 
if(Model.getFacade().isACompositeState(element))//1
{ 

//#if 888704093 
if(Model.getFacade().isASubmachineState(element))//1
{ 

//#if 1922881803 
if(Model.getFacade().isASubactivityState(element))//1
{ 

//#if -2146094694 
return new PropPanelSubactivityState();
//#endif 

} 
else
{ 

//#if -113386072 
return new PropPanelSubmachineState();
//#endif 

} 

//#endif 

} 
else
{ 

//#if 955471276 
return new PropPanelCompositeState();
//#endif 

} 

//#endif 

} 
else

//#if -1553163733 
if(Model.getFacade().isAFinalState(element))//1
{ 

//#if 1912181734 
return new PropPanelFinalState();
//#endif 

} 
else

//#if -1758117 
if(Model.getFacade().isAObjectFlowState(element))//1
{ 

//#if 2105590906 
return new PropPanelObjectFlowState();
//#endif 

} 
else

//#if 588069001 
if(Model.getFacade().isASimpleState(element))//1
{ 

//#if 426823430 
return new PropPanelSimpleState();
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 
else

//#if -470007006 
if(Model.getFacade().isAPseudostate(element))//1
{ 

//#if 1426620719 
return new PropPanelPseudostate();
//#endif 

} 
else

//#if 1019653315 
if(Model.getFacade().isAStubState(element))//1
{ 

//#if 790476515 
return new PropPanelStubState();
//#endif 

} 
else

//#if 1360218245 
if(Model.getFacade().isASynchState(element))//1
{ 

//#if -827602211 
return new PropPanelSynchState();
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#if -352406518 
throw new IllegalArgumentException("Unsupported State type");
//#endif 

} 

//#endif 


//#if 1571520923 
private PropPanelClassifier getClassifierPropPanel(Object element)
    { 

//#if -248787695 
if(Model.getFacade().isAActor(element))//1
{ 

//#if -1844712454 
return new PropPanelActor();
//#endif 

} 
else

//#if -579326601 
if(Model.getFacade().isAAssociationClass(element))//1
{ 

//#if -1064588445 
return new PropPanelAssociationClass();
//#endif 

} 
else

//#if -458735623 
if(Model.getFacade().isAClass(element))//1
{ 

//#if -940026275 
return new PropPanelClass();
//#endif 

} 
else

//#if 234964132 
if(Model.getFacade().isAClassifierInState(element))//1
{ 

//#if 259542356 
return new PropPanelClassifierInState();
//#endif 

} 
else

//#if 1446651984 
if(Model.getFacade().isAClassifierRole(element))//1
{ 

//#if 887966678 
return new PropPanelClassifierRole();
//#endif 

} 
else

//#if 2059117042 
if(Model.getFacade().isAComponent(element))//1
{ 

//#if -1949784804 
return new PropPanelComponent();
//#endif 

} 
else

//#if 1136294710 
if(Model.getFacade().isADataType(element))//1
{ 

//#if -1985573210 
if(Model.getFacade().isAEnumeration(element))//1
{ 

//#if -555986713 
return new PropPanelEnumeration();
//#endif 

} 
else
{ 

//#if -1093511330 
return new PropPanelDataType();
//#endif 

} 

//#endif 

} 
else

//#if 1782241946 
if(Model.getFacade().isAInterface(element))//1
{ 

//#if -1826143064 
return new PropPanelInterface();
//#endif 

} 
else

//#if -25963163 
if(Model.getFacade().isANode(element))//1
{ 

//#if -921793618 
return new PropPanelNode();
//#endif 

} 
else

//#if -1184577373 
if(Model.getFacade().isASignal(element))//1
{ 

//#if -1052887311 
if(Model.getFacade().isAException(element))//1
{ 

//#if -2116995123 
return new PropPanelException();
//#endif 

} 
else
{ 

//#if 2056799845 
return new PropPanelSignal();
//#endif 

} 

//#endif 

} 
else

//#if 721229235 
if(Model.getFacade().isAUseCase(element))//1
{ 

//#if 310255814 
return new PropPanelUseCase();
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


//#endif 


//#endif 


//#if 1171515844 
throw new IllegalArgumentException("Unsupported Element type");
//#endif 

} 

//#endif 


//#if -1479478811 
private PropPanelAction getActionPropPanel(Object action)
    { 

//#if -613702374 
if(Model.getFacade().isACallAction(action))//1
{ 

//#if 1432955959 
return new PropPanelCallAction();
//#endif 

} 
else

//#if 619456593 
if(Model.getFacade().isACreateAction(action))//1
{ 

//#if -271933163 
return new PropPanelCreateAction();
//#endif 

} 
else

//#if 702657345 
if(Model.getFacade().isADestroyAction(action))//1
{ 

//#if 2053002207 
return new PropPanelDestroyAction();
//#endif 

} 
else

//#if 1529844824 
if(Model.getFacade().isAReturnAction(action))//1
{ 

//#if 802659750 
return new PropPanelReturnAction();
//#endif 

} 
else

//#if 133860104 
if(Model.getFacade().isASendAction(action))//1
{ 

//#if -1312206593 
return new PropPanelSendAction();
//#endif 

} 
else

//#if -1860708852 
if(Model.getFacade().isATerminateAction(action))//1
{ 

//#if -1227036380 
return new PropPanelTerminateAction();
//#endif 

} 
else

//#if -2071667346 
if(Model.getFacade().isAUninterpretedAction(action))//1
{ 

//#if 1825945676 
return new PropPanelUninterpretedAction();
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#if 1740570760 
throw new IllegalArgumentException("Unsupported Action type");
//#endif 

} 

//#endif 


//#if 1639603835 
private PropPanelRelationship getRelationshipPropPanel(Object element)
    { 

//#if 1351209459 
if(Model.getFacade().isAAssociation(element))//1
{ 

//#if 1518054822 
if(Model.getFacade().isAAssociationRole(element))//1
{ 

//#if 2115986084 
return new PropPanelAssociationRole();
//#endif 

} 
else
{ 

//#if -1821764596 
return new PropPanelAssociation();
//#endif 

} 

//#endif 

} 
else

//#if -800953619 
if(Model.getFacade().isADependency(element))//1
{ 

//#if 707065216 
if(Model.getFacade().isAAbstraction(element))//1
{ 

//#if 743752081 
return new PropPanelAbstraction();
//#endif 

} 
else

//#if -1910804062 
if(Model.getFacade().isAPackageImport(element))//1
{ 

//#if -464192872 
return new PropPanelPermission();
//#endif 

} 
else

//#if -397535894 
if(Model.getFacade().isAUsage(element))//1
{ 

//#if 1492542931 
return new PropPanelUsage();
//#endif 

} 
else
{ 

//#if 1735546961 
return new PropPanelDependency();
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 
else

//#if 679504647 
if(Model.getFacade().isAExtend(element))//1
{ 

//#if -63782782 
return new PropPanelExtend();
//#endif 

} 
else

//#if 1363018125 
if(Model.getFacade().isAFlow(element))//1
{ 

//#if 701101680 
return new PropPanelFlow();
//#endif 

} 
else

//#if -871987557 
if(Model.getFacade().isAGeneralization(element))//1
{ 

//#if -1984273468 
return new PropPanelGeneralization();
//#endif 

} 
else

//#if -381262909 
if(Model.getFacade().isAInclude(element))//1
{ 

//#if 1519112564 
return new PropPanelInclude();
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#if -1825388630 
throw new IllegalArgumentException("Unsupported Relationship type");
//#endif 

} 

//#endif 


//#if 1488117495 
public PropPanel createPropPanel(Object element)
    { 

//#if 567970922 
if(Model.getFacade().isAElement(element))//1
{ 

//#if 1692836947 
if(Model.getFacade().isASubsystem(element))//1
{ 

//#if 1573107558 
return new PropPanelSubsystem();
//#endif 

} 
else

//#if -2100675629 
if(Model.getFacade().isAClassifier(element))//1
{ 

//#if -37917259 
return getClassifierPropPanel(element);
//#endif 

} 
else

//#if 1490632070 
if(Model.getFacade().isARelationship(element))//1
{ 

//#if 941114767 
return getRelationshipPropPanel(element);
//#endif 

} 
else

//#if -437023712 
if(Model.getFacade().isAStateVertex(element))//1
{ 

//#if -660846301 
return getStateVertexPropPanel(element);
//#endif 

} 
else

//#if 331201578 
if(Model.getFacade().isAActionSequence(element))//1
{ 

//#if 1246438680 
return new PropPanelActionSequence();
//#endif 

} 
else

//#if -1558262423 
if(Model.getFacade().isAAction(element))//1
{ 

//#if 795312083 
return getActionPropPanel(element);
//#endif 

} 
else

//#if -1633866973 
if(Model.getFacade().isAActivityGraph(element))//1
{ 

//#if -395698869 
return new PropPanelActivityGraph();
//#endif 

} 
else

//#if 1658140583 
if(Model.getFacade().isAArgument(element))//1
{ 

//#if -901075844 
return new PropPanelArgument();
//#endif 

} 
else

//#if -1250970824 
if(Model.getFacade().isAAssociationEndRole(element))//1
{ 

//#if 698140241 
return new PropPanelAssociationEndRole();
//#endif 

} 
else

//#if 2005510888 
if(Model.getFacade().isAAssociationEnd(element))//1
{ 

//#if 510276405 
return new PropPanelAssociationEnd();
//#endif 

} 
else

//#if 1094518802 
if(Model.getFacade().isAAttribute(element))//1
{ 

//#if -1623402444 
return new PropPanelAttribute();
//#endif 

} 
else

//#if -861368902 
if(Model.getFacade().isACollaboration(element))//1
{ 

//#if -1593236441 
return new PropPanelCollaboration();
//#endif 

} 
else

//#if -2125888876 
if(Model.getFacade().isAComment(element))//1
{ 

//#if 1314766949 
return new PropPanelComment();
//#endif 

} 
else

//#if -2001514653 
if(Model.getFacade().isAComponentInstance(element))//1
{ 

//#if -1205192506 
return new PropPanelComponentInstance();
//#endif 

} 
else

//#if -656443570 
if(Model.getFacade().isAConstraint(element))//1
{ 

//#if -1902425120 
return new PropPanelConstraint();
//#endif 

} 
else

//#if 1592976614 
if(Model.getFacade().isAEnumerationLiteral(element))//1
{ 

//#if -174318924 
return new PropPanelEnumerationLiteral();
//#endif 

} 
else

//#if 1445284228 
if(Model.getFacade().isAExtensionPoint(element))//1
{ 

//#if 263116234 
return new PropPanelExtensionPoint();
//#endif 

} 
else

//#if 1275413936 
if(Model.getFacade().isAGuard(element))//1
{ 

//#if -1940832202 
return new PropPanelGuard();
//#endif 

} 
else

//#if 918740666 
if(Model.getFacade().isAInteraction(element))//1
{ 

//#if 417995547 
return new PropPanelInteraction();
//#endif 

} 
else

//#if 1739101206 
if(Model.getFacade().isALink(element))//1
{ 

//#if 899143343 
return new PropPanelLink();
//#endif 

} 
else

//#if -734485896 
if(Model.getFacade().isALinkEnd(element))//1
{ 

//#if -1746590536 
return new PropPanelLinkEnd();
//#endif 

} 
else

//#if 1049300335 
if(Model.getFacade().isAMessage(element))//1
{ 

//#if -642296212 
return new PropPanelMessage();
//#endif 

} 
else

//#if -815401908 
if(Model.getFacade().isAMethod(element))//1
{ 

//#if 2067988478 
return new PropPanelMethod();
//#endif 

} 
else

//#if -122953095 
if(Model.getFacade().isAModel(element))//1
{ 

//#if -1548097469 
return new PropPanelModel();
//#endif 

} 
else

//#if 147662531 
if(Model.getFacade().isANodeInstance(element))//1
{ 

//#if -1348866074 
return new PropPanelNodeInstance();
//#endif 

} 
else

//#if 655891103 
if(Model.getFacade().isAObject(element))//1
{ 

//#if 1048749152 
return new PropPanelObject();
//#endif 

} 
else

//#if -1162500294 
if(Model.getFacade().isAOperation(element))//1
{ 

//#if 836414958 
return new PropPanelOperation();
//#endif 

} 
else

//#if 771201858 
if(Model.getFacade().isAPackage(element))//1
{ 

//#if -65725741 
return new PropPanelPackage();
//#endif 

} 
else

//#if -251886249 
if(Model.getFacade().isAParameter(element))//1
{ 

//#if -757661639 
return new PropPanelParameter();
//#endif 

} 
else

//#if -2147003233 
if(Model.getFacade().isAPartition(element))//1
{ 

//#if 363449002 
return new PropPanelPartition();
//#endif 

} 
else

//#if -767569210 
if(Model.getFacade().isAReception(element))//1
{ 

//#if -1273845680 
return new PropPanelReception();
//#endif 

} 
else

//#if 1821695801 
if(Model.getFacade().isAStateMachine(element))//1
{ 

//#if -1455030366 
return new PropPanelStateMachine();
//#endif 

} 
else

//#if 419824852 
if(Model.getFacade().isAStereotype(element))//1
{ 

//#if -741619825 
return new PropPanelStereotype();
//#endif 

} 
else

//#if -808186846 
if(Model.getFacade().isAStimulus(element))//1
{ 

//#if 1374631331 
return new PropPanelStimulus();
//#endif 

} 
else

//#if -289586272 
if(Model.getFacade().isATaggedValue(element))//1
{ 

//#if -1371561115 
return new PropPanelTaggedValue();
//#endif 

} 
else

//#if 288836986 
if(Model.getFacade().isATagDefinition(element))//1
{ 

//#if 1303462502 
return new PropPanelTagDefinition();
//#endif 

} 
else

//#if 1995514128 
if(Model.getFacade().isATransition(element))//1
{ 

//#if -501618369 
return new PropPanelTransition();
//#endif 

} 
else

//#if -851771634 
if(Model.getFacade().isACallEvent(element))//1
{ 

//#if 286381576 
return new PropPanelCallEvent();
//#endif 

} 
else

//#if -883499862 
if(Model.getFacade().isAChangeEvent(element))//1
{ 

//#if -1786021906 
return new PropPanelChangeEvent();
//#endif 

} 
else

//#if 483705019 
if(Model.getFacade().isASignalEvent(element))//1
{ 

//#if 1209742846 
return new PropPanelSignalEvent();
//#endif 

} 
else

//#if 1882618021 
if(Model.getFacade().isATimeEvent(element))//1
{ 

//#if -1782110711 
return new PropPanelTimeEvent();
//#endif 

} 
else

//#if -133540651 
if(Model.getFacade().isADependency(element))//1
{ 

//#if 177082817 
return new PropPanelDependency();
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


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#if 1585168200 
throw new IllegalArgumentException("Unsupported Element type");
//#endif 

} 

//#endif 


//#if 812955749 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

