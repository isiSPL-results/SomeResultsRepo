package org.argouml.uml.diagram;
import java.util.Map;
import org.argouml.model.CoreFactory;
import org.argouml.model.Model;
import org.argouml.uml.CommentEdge;
import org.argouml.uml.diagram.activity.ui.FigActionState;
import org.argouml.uml.diagram.activity.ui.FigCallState;
import org.argouml.uml.diagram.activity.ui.FigObjectFlowState;
import org.argouml.uml.diagram.activity.ui.FigPartition;
import org.argouml.uml.diagram.activity.ui.FigSubactivityState;
import org.argouml.uml.diagram.collaboration.ui.FigAssociationRole;
import org.argouml.uml.diagram.collaboration.ui.FigClassifierRole;
import org.argouml.uml.diagram.deployment.ui.FigComponent;
import org.argouml.uml.diagram.deployment.ui.FigComponentInstance;
import org.argouml.uml.diagram.deployment.ui.FigMNode;
import org.argouml.uml.diagram.deployment.ui.FigNodeInstance;
import org.argouml.uml.diagram.deployment.ui.FigObject;
import org.argouml.uml.diagram.state.ui.FigBranchState;
import org.argouml.uml.diagram.state.ui.FigCompositeState;
import org.argouml.uml.diagram.state.ui.FigConcurrentRegion;
import org.argouml.uml.diagram.state.ui.FigDeepHistoryState;
import org.argouml.uml.diagram.state.ui.FigFinalState;
import org.argouml.uml.diagram.state.ui.FigForkState;
import org.argouml.uml.diagram.state.ui.FigInitialState;
import org.argouml.uml.diagram.state.ui.FigJoinState;
import org.argouml.uml.diagram.state.ui.FigJunctionState;
import org.argouml.uml.diagram.state.ui.FigShallowHistoryState;
import org.argouml.uml.diagram.state.ui.FigSimpleState;
import org.argouml.uml.diagram.state.ui.FigStubState;
import org.argouml.uml.diagram.state.ui.FigSubmachineState;
import org.argouml.uml.diagram.state.ui.FigSynchState;
import org.argouml.uml.diagram.state.ui.FigTransition;
import org.argouml.uml.diagram.static_structure.ui.FigClass;
import org.argouml.uml.diagram.static_structure.ui.FigComment;
import org.argouml.uml.diagram.static_structure.ui.FigDataType;
import org.argouml.uml.diagram.static_structure.ui.FigEdgeNote;
import org.argouml.uml.diagram.static_structure.ui.FigEnumeration;
import org.argouml.uml.diagram.static_structure.ui.FigInterface;
import org.argouml.uml.diagram.static_structure.ui.FigLink;
import org.argouml.uml.diagram.static_structure.ui.FigModel;
import org.argouml.uml.diagram.static_structure.ui.FigPackage;
import org.argouml.uml.diagram.static_structure.ui.FigStereotypeDeclaration;
import org.argouml.uml.diagram.static_structure.ui.FigSubsystem;
import org.argouml.uml.diagram.ui.FigAbstraction;
import org.argouml.uml.diagram.ui.FigAssociation;
import org.argouml.uml.diagram.ui.FigAssociationClass;
import org.argouml.uml.diagram.ui.FigAssociationEnd;
import org.argouml.uml.diagram.ui.FigClassAssociationClass;
import org.argouml.uml.diagram.ui.FigDependency;
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
import org.argouml.uml.diagram.ui.FigGeneralization;
import org.argouml.uml.diagram.ui.FigMessage;
import org.argouml.uml.diagram.ui.FigNodeAssociation;
import org.argouml.uml.diagram.ui.FigPermission;
import org.argouml.uml.diagram.ui.FigUsage;
import org.argouml.uml.diagram.use_case.ui.FigActor;
import org.argouml.uml.diagram.use_case.ui.FigExtend;
import org.argouml.uml.diagram.use_case.ui.FigInclude;
import org.argouml.uml.diagram.use_case.ui.FigUseCase;
import org.tigris.gef.base.Layer;
import org.tigris.gef.graph.GraphEdgeRenderer;
import org.tigris.gef.graph.GraphNodeRenderer;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigEdge;
import org.tigris.gef.presentation.FigNode;
public abstract class UmlDiagramRenderer implements GraphNodeRenderer
,GraphEdgeRenderer
  { 
private FigNode getNodePresentationFor(Layer lay, Object modelElement)
    { 
assert modelElement != null : "A modelElement must be supplied";
for (Object fig : lay.getContentsNoEdges()) //1
{ 
if(fig instanceof FigNode
                    && ((FigNode) fig).getOwner().equals(modelElement))//1
{ 
return ((FigNode) fig);
} 
} 
for (Object fig : lay.getContentsEdgesOnly()) //1
{ 
if(fig instanceof FigEdgeModelElement
                    && modelElement.equals(((FigEdgeModelElement) fig)
                                           .getOwner()))//1
{ 
return ((FigEdgeModelElement) fig).getEdgePort();
} 
} 
return null;
} 
@Deprecated
    public FigEdge getFigEdgeFor(Object edge, Map styleAttributes)
    { 
if(edge == null)//1
{ 
throw new IllegalArgumentException("A model edge must be supplied");
} 
FigEdge newEdge = null;
if(Model.getFacade().isAAssociationClass(edge))//1
{ 
newEdge = new FigAssociationClass();
} 
else
if(Model.getFacade().isAAssociationEnd(edge))//1
{ 
newEdge = new FigAssociationEnd();
} 
else
if(Model.getFacade().isAAssociation(edge))//1
{ 
newEdge = new FigAssociation();
} 
else
if(Model.getFacade().isALink(edge))//1
{ 
newEdge = new FigLink();
} 
else
if(Model.getFacade().isAGeneralization(edge))//1
{ 
newEdge = new FigGeneralization();
} 
else
if(Model.getFacade().isAPackageImport(edge))//1
{ 
newEdge = new FigPermission();
} 
else
if(Model.getFacade().isAUsage(edge))//1
{ 
newEdge = new FigUsage();
} 
else
if(Model.getFacade().isADependency(edge))//1
{ 
if(Model.getExtensionMechanismsHelper().hasStereotype(edge,
                    CoreFactory.REALIZE_STEREOTYPE))//1
{ 
newEdge = new FigAbstraction();
} 
else
{ 
newEdge = new FigDependency();
} 
} 
else
if(edge instanceof CommentEdge)//1
{ 
newEdge = null;
} 
else
if(Model.getFacade().isAAssociationRole(edge))//1
{ 
newEdge = new FigAssociationRole();
} 
else
if(Model.getFacade().isATransition(edge))//1
{ 
newEdge = new FigTransition();
} 
else
if(Model.getFacade().isAExtend(edge))//1
{ 
newEdge = new FigExtend();
} 
else
if(Model.getFacade().isAInclude(edge))//1
{ 
newEdge = new FigInclude();
} 
if(newEdge == null)//1
{ 
throw new IllegalArgumentException(
                "Failed to construct a FigEdge for " + edge);
} 
return newEdge;
} 
@Deprecated
    public FigNode getFigNodeFor(
        Object node, int x, int y,
        Map styleAttributes)
    { 
if(node == null)//1
{ 
throw new IllegalArgumentException(
                "A model element must be supplied");
} 
FigNode figNode = null;
if(Model.getFacade().isAComment(node))//1
{ 
figNode = new FigComment();
} 
else
if(Model.getFacade().isAStubState(node))//1
{ 
return new FigStubState();
} 
else
if(Model.getFacade().isAAssociationClass(node))//1
{ 
figNode = new FigClassAssociationClass(node, x, y, 10, 10);
} 
else
if(Model.getFacade().isAClass(node))//1
{ 
figNode = new FigClass(node, x, y, 10, 10);
} 
else
if(Model.getFacade().isAInterface(node))//1
{ 
figNode = new FigInterface();
} 
else
if(Model.getFacade().isAEnumeration(node))//1
{ 
figNode = new FigEnumeration();
} 
else
if(Model.getFacade().isAStereotype(node))//1
{ 
figNode = new FigStereotypeDeclaration();
} 
else
if(Model.getFacade().isADataType(node))//1
{ 
figNode = new FigDataType();
} 
else
if(Model.getFacade().isAModel(node))//1
{ 
figNode = new FigModel(node, x, y);
} 
else
if(Model.getFacade().isASubsystem(node))//1
{ 
figNode = new FigSubsystem(node, x, y);
} 
else
if(Model.getFacade().isAPackage(node))//1
{ 
figNode = new FigPackage(node, x, y);
} 
else
if(Model.getFacade().isAAssociation(node))//1
{ 
figNode = new FigNodeAssociation();
} 
else
if(Model.getFacade().isAActor(node))//1
{ 
figNode = new FigActor();
} 
else
if(Model.getFacade().isAUseCase(node))//1
{ 
figNode = new FigUseCase();
} 
else
if(Model.getFacade().isAPartition(node))//1
{ 
figNode = new FigPartition();
} 
else
if(Model.getFacade().isACallState(node))//1
{ 
figNode = new FigCallState();
} 
else
if(Model.getFacade().isAObjectFlowState(node))//1
{ 
figNode = new FigObjectFlowState();
} 
else
if(Model.getFacade().isASubactivityState(node))//1
{ 
figNode = new FigSubactivityState();
} 
else
if(Model.getFacade().isAClassifierRole(node))//1
{ 
figNode = new FigClassifierRole();
} 
else
if(Model.getFacade().isAMessage(node))//1
{ 
figNode = new FigMessage();
} 
else
if(Model.getFacade().isANode(node))//1
{ 
figNode = new FigMNode();
} 
else
if(Model.getFacade().isANodeInstance(node))//1
{ 
figNode = new FigNodeInstance();
} 
else
if(Model.getFacade().isAComponent(node))//1
{ 
figNode = new FigComponent();
} 
else
if(Model.getFacade().isAComponentInstance(node))//1
{ 
figNode = new FigComponentInstance();
} 
else
if(Model.getFacade().isAObject(node))//1
{ 
figNode = new FigObject();
} 
else
if(Model.getFacade().isAComment(node))//1
{ 
figNode = new FigComment();
} 
else
if(Model.getFacade().isAActionState(node))//1
{ 
figNode = new FigActionState();
} 
else
if(Model.getFacade().isAFinalState(node))//1
{ 
figNode = new FigFinalState();
} 
else
if(Model.getFacade().isASubmachineState(node))//1
{ 
figNode = new FigSubmachineState();
} 
else
if(Model.getFacade().isAConcurrentRegion(node))//1
{ 
figNode = new FigConcurrentRegion();
} 
else
if(Model.getFacade().isASynchState(node))//1
{ 
figNode = new FigSynchState();
} 
else
if(Model.getFacade().isACompositeState(node))//1
{ 
figNode = new FigCompositeState();
} 
else
if(Model.getFacade().isAState(node))//1
{ 
figNode = new FigSimpleState();
} 
else
if(Model.getFacade().isAPseudostate(node))//1
{ 
Object pState = node;
Object kind = Model.getFacade().getKind(pState);
if(Model.getPseudostateKind().getInitial().equals(kind))//1
{ 
figNode = new FigInitialState();
} 
else
if(Model.getPseudostateKind().getChoice()
                       .equals(kind))//1
{ 
figNode = new FigBranchState();
} 
else
if(Model.getPseudostateKind().getJunction()
                       .equals(kind))//1
{ 
figNode = new FigJunctionState();
} 
else
if(Model.getPseudostateKind().getFork().equals(kind))//1
{ 
figNode = new FigForkState();
} 
else
if(Model.getPseudostateKind().getJoin().equals(kind))//1
{ 
figNode = new FigJoinState();
} 
else
if(Model.getPseudostateKind().getShallowHistory()
                       .equals(kind))//1
{ 
figNode = new FigShallowHistoryState();
} 
else
if(Model.getPseudostateKind().getDeepHistory()
                       .equals(kind))//1
{ 
figNode = new FigDeepHistoryState();
} 
} 
if(figNode == null)//1
{ 
throw new IllegalArgumentException(
                "Failed to construct a FigNode for " + node);
} 
setStyleAttributes(figNode, styleAttributes);
return figNode;
} 
private void setSourcePort(FigEdge edge, FigNode source)
    { 
edge.setSourcePortFig(source);
edge.setSourceFigNode(source);
} 
private void setStyleAttributes(Fig fig, Map<String, String> attributeMap)
    { 
String name;
String value;
for (Map.Entry<String, String> entry : attributeMap.entrySet()) //1
{ 
name = entry.getKey();
value = entry.getValue();
if("operationsVisible".equals(name))//1
{ 
((OperationsCompartmentContainer) fig)
                .setOperationsVisible(value.equalsIgnoreCase("true"));
} 
else
if("attributesVisible".equals(name))//1
{ 
((AttributesCompartmentContainer) fig)
                .setAttributesVisible(value.equalsIgnoreCase("true"));
} 
} 
} 
private void setDestPort(FigEdge edge, FigNode dest)
    { 
edge.setDestPortFig(dest);
edge.setDestFigNode(dest);
} 
protected final void setPorts(Layer layer, FigEdge newEdge)
    { 
Object modelElement = newEdge.getOwner();
if(newEdge.getSourcePortFig() == null)//1
{ 
Object source;
if(modelElement instanceof CommentEdge)//1
{ 
source = ((CommentEdge) modelElement).getSource();
} 
else
{ 
source = Model.getUmlHelper().getSource(modelElement);
} 
FigNode sourceNode = getNodePresentationFor(layer, source);
assert (sourceNode != null) : "No FigNode found for " + source;
setSourcePort(newEdge, sourceNode);
} 
if(newEdge.getDestPortFig() == null)//1
{ 
Object dest;
if(modelElement instanceof CommentEdge)//1
{ 
dest = ((CommentEdge) modelElement).getDestination();
} 
else
{ 
dest = Model.getUmlHelper().getDestination(newEdge.getOwner());
} 
setDestPort(newEdge, getNodePresentationFor(layer, dest));
} 
if(newEdge.getSourcePortFig() == null
                || newEdge.getDestPortFig() == null)//1
{ 
throw new IllegalStateException("Edge of type "
                                            + newEdge.getClass().getName()
                                            + " created with no source or destination port");
} 
} 

 } 
