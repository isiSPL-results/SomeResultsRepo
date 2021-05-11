// Compilation Unit of /ElementPropPanelFactory.java 
 
package org.argouml.uml.ui;
import org.argouml.model.Model;
import org.argouml.uml.ui.behavior.activity_graphs.PropPanelActionState;
import org.argouml.uml.ui.behavior.activity_graphs.PropPanelActivityGraph;
import org.argouml.uml.ui.behavior.activity_graphs.PropPanelCallState;
import org.argouml.uml.ui.behavior.activity_graphs.PropPanelClassifierInState;
import org.argouml.uml.ui.behavior.activity_graphs.PropPanelObjectFlowState;
import org.argouml.uml.ui.behavior.activity_graphs.PropPanelPartition;
import org.argouml.uml.ui.behavior.activity_graphs.PropPanelSubactivityState;
import org.argouml.uml.ui.behavior.collaborations.PropPanelAssociationEndRole;
import org.argouml.uml.ui.behavior.collaborations.PropPanelAssociationRole;
import org.argouml.uml.ui.behavior.collaborations.PropPanelClassifierRole;
import org.argouml.uml.ui.behavior.collaborations.PropPanelCollaboration;
import org.argouml.uml.ui.behavior.collaborations.PropPanelInteraction;
import org.argouml.uml.ui.behavior.collaborations.PropPanelMessage;
import org.argouml.uml.ui.behavior.common_behavior.PropPanelAction;
import org.argouml.uml.ui.behavior.common_behavior.PropPanelActionSequence;
import org.argouml.uml.ui.behavior.common_behavior.PropPanelArgument;
import org.argouml.uml.ui.behavior.common_behavior.PropPanelCallAction;
import org.argouml.uml.ui.behavior.common_behavior.PropPanelComponentInstance;
import org.argouml.uml.ui.behavior.common_behavior.PropPanelCreateAction;
import org.argouml.uml.ui.behavior.common_behavior.PropPanelDestroyAction;
import org.argouml.uml.ui.behavior.common_behavior.PropPanelException;
import org.argouml.uml.ui.behavior.common_behavior.PropPanelLink;
import org.argouml.uml.ui.behavior.common_behavior.PropPanelLinkEnd;
import org.argouml.uml.ui.behavior.common_behavior.PropPanelNodeInstance;
import org.argouml.uml.ui.behavior.common_behavior.PropPanelObject;
import org.argouml.uml.ui.behavior.common_behavior.PropPanelReception;
import org.argouml.uml.ui.behavior.common_behavior.PropPanelReturnAction;
import org.argouml.uml.ui.behavior.common_behavior.PropPanelSendAction;
import org.argouml.uml.ui.behavior.common_behavior.PropPanelSignal;
import org.argouml.uml.ui.behavior.common_behavior.PropPanelStimulus;
import org.argouml.uml.ui.behavior.common_behavior.PropPanelTerminateAction;
import org.argouml.uml.ui.behavior.common_behavior.PropPanelUninterpretedAction;
import org.argouml.uml.ui.behavior.state_machines.PropPanelCallEvent;
import org.argouml.uml.ui.behavior.state_machines.PropPanelChangeEvent;
import org.argouml.uml.ui.behavior.state_machines.PropPanelCompositeState;
import org.argouml.uml.ui.behavior.state_machines.PropPanelFinalState;
import org.argouml.uml.ui.behavior.state_machines.PropPanelGuard;
import org.argouml.uml.ui.behavior.state_machines.PropPanelPseudostate;
import org.argouml.uml.ui.behavior.state_machines.PropPanelSignalEvent;
import org.argouml.uml.ui.behavior.state_machines.PropPanelSimpleState;
import org.argouml.uml.ui.behavior.state_machines.PropPanelStateMachine;
import org.argouml.uml.ui.behavior.state_machines.PropPanelStateVertex;
import org.argouml.uml.ui.behavior.state_machines.PropPanelStubState;
import org.argouml.uml.ui.behavior.state_machines.PropPanelSubmachineState;
import org.argouml.uml.ui.behavior.state_machines.PropPanelSynchState;
import org.argouml.uml.ui.behavior.state_machines.PropPanelTimeEvent;
import org.argouml.uml.ui.behavior.state_machines.PropPanelTransition;
import org.argouml.uml.ui.behavior.use_cases.PropPanelActor;
import org.argouml.uml.ui.behavior.use_cases.PropPanelExtend;
import org.argouml.uml.ui.behavior.use_cases.PropPanelExtensionPoint;
import org.argouml.uml.ui.behavior.use_cases.PropPanelInclude;
import org.argouml.uml.ui.behavior.use_cases.PropPanelUseCase;
import org.argouml.uml.ui.foundation.core.PropPanelAbstraction;
import org.argouml.uml.ui.foundation.core.PropPanelAssociation;
import org.argouml.uml.ui.foundation.core.PropPanelAssociationClass;
import org.argouml.uml.ui.foundation.core.PropPanelAssociationEnd;
import org.argouml.uml.ui.foundation.core.PropPanelAttribute;
import org.argouml.uml.ui.foundation.core.PropPanelClass;
import org.argouml.uml.ui.foundation.core.PropPanelClassifier;
import org.argouml.uml.ui.foundation.core.PropPanelComment;
import org.argouml.uml.ui.foundation.core.PropPanelComponent;
import org.argouml.uml.ui.foundation.core.PropPanelConstraint;
import org.argouml.uml.ui.foundation.core.PropPanelDataType;
import org.argouml.uml.ui.foundation.core.PropPanelDependency;
import org.argouml.uml.ui.foundation.core.PropPanelEnumeration;
import org.argouml.uml.ui.foundation.core.PropPanelEnumerationLiteral;
import org.argouml.uml.ui.foundation.core.PropPanelFlow;
import org.argouml.uml.ui.foundation.core.PropPanelGeneralization;
import org.argouml.uml.ui.foundation.core.PropPanelInterface;
import org.argouml.uml.ui.foundation.core.PropPanelMethod;
import org.argouml.uml.ui.foundation.core.PropPanelNode;
import org.argouml.uml.ui.foundation.core.PropPanelOperation;
import org.argouml.uml.ui.foundation.core.PropPanelParameter;
import org.argouml.uml.ui.foundation.core.PropPanelPermission;
import org.argouml.uml.ui.foundation.core.PropPanelRelationship;
import org.argouml.uml.ui.foundation.core.PropPanelUsage;
import org.argouml.uml.ui.foundation.extension_mechanisms.PropPanelStereotype;
import org.argouml.uml.ui.foundation.extension_mechanisms.PropPanelTagDefinition;
import org.argouml.uml.ui.foundation.extension_mechanisms.PropPanelTaggedValue;
import org.argouml.uml.ui.model_management.PropPanelModel;
import org.argouml.uml.ui.model_management.PropPanelPackage;
import org.argouml.uml.ui.model_management.PropPanelSubsystem;
class ElementPropPanelFactory implements PropPanelFactory
  { 
private PropPanelStateVertex getStateVertexPropPanel(Object element)
    { 
if(Model.getFacade().isAState(element))//1
{ 
if(Model.getFacade().isACallState(element))//1
{ 
return new PropPanelCallState();
} 
else
if(Model.getFacade().isAActionState(element))//1
{ 
return new PropPanelActionState();
} 
else
if(Model.getFacade().isACompositeState(element))//1
{ 
if(Model.getFacade().isASubmachineState(element))//1
{ 
if(Model.getFacade().isASubactivityState(element))//1
{ 
return new PropPanelSubactivityState();
} 
else
{ 
return new PropPanelSubmachineState();
} 

} 
else
{ 
return new PropPanelCompositeState();
} 

} 
else
if(Model.getFacade().isAFinalState(element))//1
{ 
return new PropPanelFinalState();
} 
else
if(Model.getFacade().isAObjectFlowState(element))//1
{ 
return new PropPanelObjectFlowState();
} 
else
if(Model.getFacade().isASimpleState(element))//1
{ 
return new PropPanelSimpleState();
} 






} 
else
if(Model.getFacade().isAPseudostate(element))//1
{ 
return new PropPanelPseudostate();
} 
else
if(Model.getFacade().isAStubState(element))//1
{ 
return new PropPanelStubState();
} 
else
if(Model.getFacade().isASynchState(element))//1
{ 
return new PropPanelSynchState();
} 




throw new IllegalArgumentException("Unsupported State type");
} 

private PropPanelClassifier getClassifierPropPanel(Object element)
    { 
if(Model.getFacade().isAActor(element))//1
{ 
return new PropPanelActor();
} 
else
if(Model.getFacade().isAAssociationClass(element))//1
{ 
return new PropPanelAssociationClass();
} 
else
if(Model.getFacade().isAClass(element))//1
{ 
return new PropPanelClass();
} 
else
if(Model.getFacade().isAClassifierInState(element))//1
{ 
return new PropPanelClassifierInState();
} 
else
if(Model.getFacade().isAClassifierRole(element))//1
{ 
return new PropPanelClassifierRole();
} 
else
if(Model.getFacade().isAComponent(element))//1
{ 
return new PropPanelComponent();
} 
else
if(Model.getFacade().isADataType(element))//1
{ 
if(Model.getFacade().isAEnumeration(element))//1
{ 
return new PropPanelEnumeration();
} 
else
{ 
return new PropPanelDataType();
} 

} 
else
if(Model.getFacade().isAInterface(element))//1
{ 
return new PropPanelInterface();
} 
else
if(Model.getFacade().isANode(element))//1
{ 
return new PropPanelNode();
} 
else
if(Model.getFacade().isASignal(element))//1
{ 
if(Model.getFacade().isAException(element))//1
{ 
return new PropPanelException();
} 
else
{ 
return new PropPanelSignal();
} 

} 
else
if(Model.getFacade().isAUseCase(element))//1
{ 
return new PropPanelUseCase();
} 











throw new IllegalArgumentException("Unsupported Element type");
} 

private PropPanelAction getActionPropPanel(Object action)
    { 
if(Model.getFacade().isACallAction(action))//1
{ 
return new PropPanelCallAction();
} 
else
if(Model.getFacade().isACreateAction(action))//1
{ 
return new PropPanelCreateAction();
} 
else
if(Model.getFacade().isADestroyAction(action))//1
{ 
return new PropPanelDestroyAction();
} 
else
if(Model.getFacade().isAReturnAction(action))//1
{ 
return new PropPanelReturnAction();
} 
else
if(Model.getFacade().isASendAction(action))//1
{ 
return new PropPanelSendAction();
} 
else
if(Model.getFacade().isATerminateAction(action))//1
{ 
return new PropPanelTerminateAction();
} 
else
if(Model.getFacade().isAUninterpretedAction(action))//1
{ 
return new PropPanelUninterpretedAction();
} 







throw new IllegalArgumentException("Unsupported Action type");
} 

private PropPanelRelationship getRelationshipPropPanel(Object element)
    { 
if(Model.getFacade().isAAssociation(element))//1
{ 
if(Model.getFacade().isAAssociationRole(element))//1
{ 
return new PropPanelAssociationRole();
} 
else
{ 
return new PropPanelAssociation();
} 

} 
else
if(Model.getFacade().isADependency(element))//1
{ 
if(Model.getFacade().isAAbstraction(element))//1
{ 
return new PropPanelAbstraction();
} 
else
if(Model.getFacade().isAPackageImport(element))//1
{ 
return new PropPanelPermission();
} 
else
if(Model.getFacade().isAUsage(element))//1
{ 
return new PropPanelUsage();
} 
else
{ 
return new PropPanelDependency();
} 



} 
else
if(Model.getFacade().isAExtend(element))//1
{ 
return new PropPanelExtend();
} 
else
if(Model.getFacade().isAFlow(element))//1
{ 
return new PropPanelFlow();
} 
else
if(Model.getFacade().isAGeneralization(element))//1
{ 
return new PropPanelGeneralization();
} 
else
if(Model.getFacade().isAInclude(element))//1
{ 
return new PropPanelInclude();
} 






throw new IllegalArgumentException("Unsupported Relationship type");
} 

public PropPanel createPropPanel(Object element)
    { 
if(Model.getFacade().isAElement(element))//1
{ 
if(Model.getFacade().isASubsystem(element))//1
{ 
return new PropPanelSubsystem();
} 
else
if(Model.getFacade().isAClassifier(element))//1
{ 
return getClassifierPropPanel(element);
} 
else
if(Model.getFacade().isARelationship(element))//1
{ 
return getRelationshipPropPanel(element);
} 
else
if(Model.getFacade().isAStateVertex(element))//1
{ 
return getStateVertexPropPanel(element);
} 
else
if(Model.getFacade().isAActionSequence(element))//1
{ 
return new PropPanelActionSequence();
} 
else
if(Model.getFacade().isAAction(element))//1
{ 
return getActionPropPanel(element);
} 
else
if(Model.getFacade().isAActivityGraph(element))//1
{ 
return new PropPanelActivityGraph();
} 
else
if(Model.getFacade().isAArgument(element))//1
{ 
return new PropPanelArgument();
} 
else
if(Model.getFacade().isAAssociationEndRole(element))//1
{ 
return new PropPanelAssociationEndRole();
} 
else
if(Model.getFacade().isAAssociationEnd(element))//1
{ 
return new PropPanelAssociationEnd();
} 
else
if(Model.getFacade().isAAttribute(element))//1
{ 
return new PropPanelAttribute();
} 
else
if(Model.getFacade().isACollaboration(element))//1
{ 
return new PropPanelCollaboration();
} 
else
if(Model.getFacade().isAComment(element))//1
{ 
return new PropPanelComment();
} 
else
if(Model.getFacade().isAComponentInstance(element))//1
{ 
return new PropPanelComponentInstance();
} 
else
if(Model.getFacade().isAConstraint(element))//1
{ 
return new PropPanelConstraint();
} 
else
if(Model.getFacade().isAEnumerationLiteral(element))//1
{ 
return new PropPanelEnumerationLiteral();
} 
else
if(Model.getFacade().isAExtensionPoint(element))//1
{ 
return new PropPanelExtensionPoint();
} 
else
if(Model.getFacade().isAGuard(element))//1
{ 
return new PropPanelGuard();
} 
else
if(Model.getFacade().isAInteraction(element))//1
{ 
return new PropPanelInteraction();
} 
else
if(Model.getFacade().isALink(element))//1
{ 
return new PropPanelLink();
} 
else
if(Model.getFacade().isALinkEnd(element))//1
{ 
return new PropPanelLinkEnd();
} 
else
if(Model.getFacade().isAMessage(element))//1
{ 
return new PropPanelMessage();
} 
else
if(Model.getFacade().isAMethod(element))//1
{ 
return new PropPanelMethod();
} 
else
if(Model.getFacade().isAModel(element))//1
{ 
return new PropPanelModel();
} 
else
if(Model.getFacade().isANodeInstance(element))//1
{ 
return new PropPanelNodeInstance();
} 
else
if(Model.getFacade().isAObject(element))//1
{ 
return new PropPanelObject();
} 
else
if(Model.getFacade().isAOperation(element))//1
{ 
return new PropPanelOperation();
} 
else
if(Model.getFacade().isAPackage(element))//1
{ 
return new PropPanelPackage();
} 
else
if(Model.getFacade().isAParameter(element))//1
{ 
return new PropPanelParameter();
} 
else
if(Model.getFacade().isAPartition(element))//1
{ 
return new PropPanelPartition();
} 
else
if(Model.getFacade().isAReception(element))//1
{ 
return new PropPanelReception();
} 
else
if(Model.getFacade().isAStateMachine(element))//1
{ 
return new PropPanelStateMachine();
} 
else
if(Model.getFacade().isAStereotype(element))//1
{ 
return new PropPanelStereotype();
} 
else
if(Model.getFacade().isAStimulus(element))//1
{ 
return new PropPanelStimulus();
} 
else
if(Model.getFacade().isATaggedValue(element))//1
{ 
return new PropPanelTaggedValue();
} 
else
if(Model.getFacade().isATagDefinition(element))//1
{ 
return new PropPanelTagDefinition();
} 
else
if(Model.getFacade().isATransition(element))//1
{ 
return new PropPanelTransition();
} 
else
if(Model.getFacade().isACallEvent(element))//1
{ 
return new PropPanelCallEvent();
} 
else
if(Model.getFacade().isAChangeEvent(element))//1
{ 
return new PropPanelChangeEvent();
} 
else
if(Model.getFacade().isASignalEvent(element))//1
{ 
return new PropPanelSignalEvent();
} 
else
if(Model.getFacade().isATimeEvent(element))//1
{ 
return new PropPanelTimeEvent();
} 
else
if(Model.getFacade().isADependency(element))//1
{ 
return new PropPanelDependency();
} 










































throw new IllegalArgumentException("Unsupported Element type");
} 

return null;
} 

 } 


