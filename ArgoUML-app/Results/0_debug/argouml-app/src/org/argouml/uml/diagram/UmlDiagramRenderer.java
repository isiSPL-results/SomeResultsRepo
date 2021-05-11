
//#if 2128164007 
// Compilation Unit of /UmlDiagramRenderer.java 
 

//#if -38491496 
package org.argouml.uml.diagram;
//#endif 


//#if -1684119375 
import java.util.Map;
//#endif 


//#if -997416636 
import org.argouml.model.CoreFactory;
//#endif 


//#if -820398778 
import org.argouml.model.Model;
//#endif 


//#if 72402696 
import org.argouml.uml.CommentEdge;
//#endif 


//#if 345987813 
import org.argouml.uml.diagram.activity.ui.FigActionState;
//#endif 


//#if 938780237 
import org.argouml.uml.diagram.activity.ui.FigCallState;
//#endif 


//#if 1714247164 
import org.argouml.uml.diagram.activity.ui.FigObjectFlowState;
//#endif 


//#if -608797930 
import org.argouml.uml.diagram.activity.ui.FigPartition;
//#endif 


//#if -513092652 
import org.argouml.uml.diagram.activity.ui.FigSubactivityState;
//#endif 


//#if 915961371 
import org.argouml.uml.diagram.collaboration.ui.FigAssociationRole;
//#endif 


//#if 147084909 
import org.argouml.uml.diagram.collaboration.ui.FigClassifierRole;
//#endif 


//#if -1167562899 
import org.argouml.uml.diagram.deployment.ui.FigComponent;
//#endif 


//#if -912444584 
import org.argouml.uml.diagram.deployment.ui.FigComponentInstance;
//#endif 


//#if -1348345317 
import org.argouml.uml.diagram.deployment.ui.FigMNode;
//#endif 


//#if -339497099 
import org.argouml.uml.diagram.deployment.ui.FigNodeInstance;
//#endif 


//#if -800996691 
import org.argouml.uml.diagram.deployment.ui.FigObject;
//#endif 


//#if 2129202007 
import org.argouml.uml.diagram.state.ui.FigBranchState;
//#endif 


//#if 2002351622 
import org.argouml.uml.diagram.state.ui.FigCompositeState;
//#endif 


//#if -41744475 
import org.argouml.uml.diagram.state.ui.FigConcurrentRegion;
//#endif 


//#if 914594695 
import org.argouml.uml.diagram.state.ui.FigDeepHistoryState;
//#endif 


//#if 1217284149 
import org.argouml.uml.diagram.state.ui.FigFinalState;
//#endif 


//#if 1445523767 
import org.argouml.uml.diagram.state.ui.FigForkState;
//#endif 


//#if -1148794301 
import org.argouml.uml.diagram.state.ui.FigInitialState;
//#endif 


//#if 521589663 
import org.argouml.uml.diagram.state.ui.FigJoinState;
//#endif 


//#if 368597193 
import org.argouml.uml.diagram.state.ui.FigJunctionState;
//#endif 


//#if -1482244075 
import org.argouml.uml.diagram.state.ui.FigShallowHistoryState;
//#endif 


//#if 1776077671 
import org.argouml.uml.diagram.state.ui.FigSimpleState;
//#endif 


//#if -20624349 
import org.argouml.uml.diagram.state.ui.FigStubState;
//#endif 


//#if 1117300348 
import org.argouml.uml.diagram.state.ui.FigSubmachineState;
//#endif 


//#if 418110124 
import org.argouml.uml.diagram.state.ui.FigSynchState;
//#endif 


//#if 1517583067 
import org.argouml.uml.diagram.state.ui.FigTransition;
//#endif 


//#if -2001919531 
import org.argouml.uml.diagram.static_structure.ui.FigClass;
//#endif 


//#if -994132658 
import org.argouml.uml.diagram.static_structure.ui.FigComment;
//#endif 


//#if 368297317 
import org.argouml.uml.diagram.static_structure.ui.FigDataType;
//#endif 


//#if 950342010 
import org.argouml.uml.diagram.static_structure.ui.FigEdgeNote;
//#endif 


//#if 1957627238 
import org.argouml.uml.diagram.static_structure.ui.FigEnumeration;
//#endif 


//#if -81429196 
import org.argouml.uml.diagram.static_structure.ui.FigInterface;
//#endif 


//#if 1329129775 
import org.argouml.uml.diagram.static_structure.ui.FigLink;
//#endif 


//#if -1712781756 
import org.argouml.uml.diagram.static_structure.ui.FigModel;
//#endif 


//#if 359150663 
import org.argouml.uml.diagram.static_structure.ui.FigPackage;
//#endif 


//#if -783157659 
import org.argouml.uml.diagram.static_structure.ui.FigStereotypeDeclaration;
//#endif 


//#if 928436414 
import org.argouml.uml.diagram.static_structure.ui.FigSubsystem;
//#endif 


//#if 455841827 
import org.argouml.uml.diagram.ui.FigAbstraction;
//#endif 


//#if -1499737176 
import org.argouml.uml.diagram.ui.FigAssociation;
//#endif 


//#if -2092647786 
import org.argouml.uml.diagram.ui.FigAssociationClass;
//#endif 


//#if 1874976851 
import org.argouml.uml.diagram.ui.FigAssociationEnd;
//#endif 


//#if 961156442 
import org.argouml.uml.diagram.ui.FigClassAssociationClass;
//#endif 


//#if -1330101054 
import org.argouml.uml.diagram.ui.FigDependency;
//#endif 


//#if 618214717 
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
//#endif 


//#if -1502638415 
import org.argouml.uml.diagram.ui.FigGeneralization;
//#endif 


//#if -1359857694 
import org.argouml.uml.diagram.ui.FigMessage;
//#endif 


//#if 1530612682 
import org.argouml.uml.diagram.ui.FigNodeAssociation;
//#endif 


//#if 618635966 
import org.argouml.uml.diagram.ui.FigPermission;
//#endif 


//#if -863909624 
import org.argouml.uml.diagram.ui.FigUsage;
//#endif 


//#if 634667186 
import org.argouml.uml.diagram.use_case.ui.FigActor;
//#endif 


//#if -1944194539 
import org.argouml.uml.diagram.use_case.ui.FigExtend;
//#endif 


//#if 1770662239 
import org.argouml.uml.diagram.use_case.ui.FigInclude;
//#endif 


//#if 1370913424 
import org.argouml.uml.diagram.use_case.ui.FigUseCase;
//#endif 


//#if 1037237881 
import org.tigris.gef.base.Layer;
//#endif 


//#if 768838235 
import org.tigris.gef.graph.GraphEdgeRenderer;
//#endif 


//#if 644007862 
import org.tigris.gef.graph.GraphNodeRenderer;
//#endif 


//#if 1276725565 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1604038144 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if -1595401637 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if 386069218 
public abstract class UmlDiagramRenderer implements 
//#if 1907382876 
GraphNodeRenderer
//#endif 

, 
//#if -1552273641 
GraphEdgeRenderer
//#endif 

  { 

//#if 1848991893 
private FigNode getNodePresentationFor(Layer lay, Object modelElement)
    { 

//#if -1678322047 
assert modelElement != null : "A modelElement must be supplied";
//#endif 


//#if -1283713474 
for (Object fig : lay.getContentsNoEdges()) //1
{ 

//#if 558895000 
if(fig instanceof FigNode
                    && ((FigNode) fig).getOwner().equals(modelElement))//1
{ 

//#if 1850262227 
return ((FigNode) fig);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -781031797 
for (Object fig : lay.getContentsEdgesOnly()) //1
{ 

//#if 1007733141 
if(fig instanceof FigEdgeModelElement
                    && modelElement.equals(((FigEdgeModelElement) fig)
                                           .getOwner()))//1
{ 

//#if 820568930 
return ((FigEdgeModelElement) fig).getEdgePort();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1933240946 
return null;
//#endif 

} 

//#endif 


//#if 85428339 
@Deprecated
    public FigEdge getFigEdgeFor(Object edge, Map styleAttributes)
    { 

//#if 1352781929 
if(edge == null)//1
{ 

//#if 620626491 
throw new IllegalArgumentException("A model edge must be supplied");
//#endif 

} 

//#endif 


//#if 1745454977 
FigEdge newEdge = null;
//#endif 


//#if 584731515 
if(Model.getFacade().isAAssociationClass(edge))//1
{ 

//#if 127368031 
newEdge = new FigAssociationClass();
//#endif 

} 
else

//#if 1437074117 
if(Model.getFacade().isAAssociationEnd(edge))//1
{ 

//#if -1258565261 
newEdge = new FigAssociationEnd();
//#endif 

} 
else

//#if -693701070 
if(Model.getFacade().isAAssociation(edge))//1
{ 

//#if 1313080258 
newEdge = new FigAssociation();
//#endif 

} 
else

//#if -583063516 
if(Model.getFacade().isALink(edge))//1
{ 

//#if -368245132 
newEdge = new FigLink();
//#endif 

} 
else

//#if -671562174 
if(Model.getFacade().isAGeneralization(edge))//1
{ 

//#if -1204296471 
newEdge = new FigGeneralization();
//#endif 

} 
else

//#if -546290035 
if(Model.getFacade().isAPackageImport(edge))//1
{ 

//#if -1503956794 
newEdge = new FigPermission();
//#endif 

} 
else

//#if 345859440 
if(Model.getFacade().isAUsage(edge))//1
{ 

//#if 1425873992 
newEdge = new FigUsage();
//#endif 

} 
else

//#if -164987863 
if(Model.getFacade().isADependency(edge))//1
{ 

//#if 2119056079 
if(Model.getExtensionMechanismsHelper().hasStereotype(edge,
                    CoreFactory.REALIZE_STEREOTYPE))//1
{ 

//#if -2031533854 
newEdge = new FigAbstraction();
//#endif 

} 
else
{ 

//#if -832103120 
newEdge = new FigDependency();
//#endif 

} 

//#endif 

} 
else

//#if -625866129 
if(edge instanceof CommentEdge)//1
{ 

//#if -935649848 
newEdge = null;
//#endif 

} 
else

//#if -1632397011 
if(Model.getFacade().isAAssociationRole(edge))//1
{ 

//#if 255750423 
newEdge = new FigAssociationRole();
//#endif 

} 
else

//#if 1129075131 
if(Model.getFacade().isATransition(edge))//1
{ 

//#if 1456782516 
newEdge = new FigTransition();
//#endif 

} 
else

//#if -1101519976 
if(Model.getFacade().isAExtend(edge))//1
{ 

//#if 1245448824 
newEdge = new FigExtend();
//#endif 

} 
else

//#if 480719777 
if(Model.getFacade().isAInclude(edge))//1
{ 

//#if -1535390728 
newEdge = new FigInclude();
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


//#if -67110513 
if(newEdge == null)//1
{ 

//#if 1714066882 
throw new IllegalArgumentException(
                "Failed to construct a FigEdge for " + edge);
//#endif 

} 

//#endif 


//#if -1101872516 
return newEdge;
//#endif 

} 

//#endif 


//#if -493534877 
@Deprecated
    public FigNode getFigNodeFor(
        Object node, int x, int y,
        Map styleAttributes)
    { 

//#if 126495396 
if(node == null)//1
{ 

//#if 1056010757 
throw new IllegalArgumentException(
                "A model element must be supplied");
//#endif 

} 

//#endif 


//#if -1419039409 
FigNode figNode = null;
//#endif 


//#if -265800764 
if(Model.getFacade().isAComment(node))//1
{ 

//#if -1794787909 
figNode = new FigComment();
//#endif 

} 
else

//#if 236176927 
if(Model.getFacade().isAStubState(node))//1
{ 

//#if 1613666227 
return new FigStubState();
//#endif 

} 
else

//#if -2086191253 
if(Model.getFacade().isAAssociationClass(node))//1
{ 

//#if 689676342 
figNode = new FigClassAssociationClass(node, x, y, 10, 10);
//#endif 

} 
else

//#if 389825349 
if(Model.getFacade().isAClass(node))//1
{ 

//#if 930039765 
figNode = new FigClass(node, x, y, 10, 10);
//#endif 

} 
else

//#if -580136859 
if(Model.getFacade().isAInterface(node))//1
{ 

//#if -287782059 
figNode = new FigInterface();
//#endif 

} 
else

//#if -2109306244 
if(Model.getFacade().isAEnumeration(node))//1
{ 

//#if 1402868607 
figNode = new FigEnumeration();
//#endif 

} 
else

//#if 740866929 
if(Model.getFacade().isAStereotype(node))//1
{ 

//#if -1812490778 
figNode = new FigStereotypeDeclaration();
//#endif 

} 
else

//#if 1595653104 
if(Model.getFacade().isADataType(node))//1
{ 

//#if 146217310 
figNode = new FigDataType();
//#endif 

} 
else

//#if 1143064965 
if(Model.getFacade().isAModel(node))//1
{ 

//#if -480313487 
figNode = new FigModel(node, x, y);
//#endif 

} 
else

//#if 868484035 
if(Model.getFacade().isASubsystem(node))//1
{ 

//#if -583294157 
figNode = new FigSubsystem(node, x, y);
//#endif 

} 
else

//#if -807350265 
if(Model.getFacade().isAPackage(node))//1
{ 

//#if 586647153 
figNode = new FigPackage(node, x, y);
//#endif 

} 
else

//#if -69495575 
if(Model.getFacade().isAAssociation(node))//1
{ 

//#if -786323267 
figNode = new FigNodeAssociation();
//#endif 

} 
else

//#if -440691649 
if(Model.getFacade().isAActor(node))//1
{ 

//#if 1646956567 
figNode = new FigActor();
//#endif 

} 
else

//#if -1188658844 
if(Model.getFacade().isAUseCase(node))//1
{ 

//#if -2094054149 
figNode = new FigUseCase();
//#endif 

} 
else

//#if -2031220933 
if(Model.getFacade().isAPartition(node))//1
{ 

//#if -697494615 
figNode = new FigPartition();
//#endif 

} 
else

//#if 1490117502 
if(Model.getFacade().isACallState(node))//1
{ 

//#if -799047823 
figNode = new FigCallState();
//#endif 

} 
else

//#if -1118351641 
if(Model.getFacade().isAObjectFlowState(node))//1
{ 

//#if 465450779 
figNode = new FigObjectFlowState();
//#endif 

} 
else

//#if 1943514987 
if(Model.getFacade().isASubactivityState(node))//1
{ 

//#if 1253028761 
figNode = new FigSubactivityState();
//#endif 

} 
else

//#if -1431906321 
if(Model.getFacade().isAClassifierRole(node))//1
{ 

//#if -81497198 
figNode = new FigClassifierRole();
//#endif 

} 
else

//#if -1366528061 
if(Model.getFacade().isAMessage(node))//1
{ 

//#if 1655113126 
figNode = new FigMessage();
//#endif 

} 
else

//#if 2077993362 
if(Model.getFacade().isANode(node))//1
{ 

//#if 454256497 
figNode = new FigMNode();
//#endif 

} 
else

//#if 2002413186 
if(Model.getFacade().isANodeInstance(node))//1
{ 

//#if 1964655625 
figNode = new FigNodeInstance();
//#endif 

} 
else

//#if -169256287 
if(Model.getFacade().isAComponent(node))//1
{ 

//#if -2056614755 
figNode = new FigComponent();
//#endif 

} 
else

//#if -708762486 
if(Model.getFacade().isAComponentInstance(node))//1
{ 

//#if -707511665 
figNode = new FigComponentInstance();
//#endif 

} 
else

//#if 450013057 
if(Model.getFacade().isAObject(node))//1
{ 

//#if 1845358631 
figNode = new FigObject();
//#endif 

} 
else

//#if -1093645747 
if(Model.getFacade().isAComment(node))//1
{ 

//#if 1012250395 
figNode = new FigComment();
//#endif 

} 
else

//#if 980050543 
if(Model.getFacade().isAActionState(node))//1
{ 

//#if -1508926344 
figNode = new FigActionState();
//#endif 

} 
else

//#if -382151130 
if(Model.getFacade().isAFinalState(node))//1
{ 

//#if -373199636 
figNode = new FigFinalState();
//#endif 

} 
else

//#if 368289350 
if(Model.getFacade().isASubmachineState(node))//1
{ 

//#if -1474598746 
figNode = new FigSubmachineState();
//#endif 

} 
else

//#if -645471636 
if(Model.getFacade().isAConcurrentRegion(node))//1
{ 

//#if -1991126218 
figNode = new FigConcurrentRegion();
//#endif 

} 
else

//#if -1224294198 
if(Model.getFacade().isASynchState(node))//1
{ 

//#if 316621152 
figNode = new FigSynchState();
//#endif 

} 
else

//#if 827045102 
if(Model.getFacade().isACompositeState(node))//1
{ 

//#if -748251392 
figNode = new FigCompositeState();
//#endif 

} 
else

//#if 410087215 
if(Model.getFacade().isAState(node))//1
{ 

//#if -1762752412 
figNode = new FigSimpleState();
//#endif 

} 
else

//#if -762460842 
if(Model.getFacade().isAPseudostate(node))//1
{ 

//#if 2110415862 
Object pState = node;
//#endif 


//#if -1495559741 
Object kind = Model.getFacade().getKind(pState);
//#endif 


//#if -522978995 
if(Model.getPseudostateKind().getInitial().equals(kind))//1
{ 

//#if -149430842 
figNode = new FigInitialState();
//#endif 

} 
else

//#if -2003982631 
if(Model.getPseudostateKind().getChoice()
                       .equals(kind))//1
{ 

//#if -530746556 
figNode = new FigBranchState();
//#endif 

} 
else

//#if 709238610 
if(Model.getPseudostateKind().getJunction()
                       .equals(kind))//1
{ 

//#if -371117208 
figNode = new FigJunctionState();
//#endif 

} 
else

//#if 665737555 
if(Model.getPseudostateKind().getFork().equals(kind))//1
{ 

//#if -307757113 
figNode = new FigForkState();
//#endif 

} 
else

//#if 777604508 
if(Model.getPseudostateKind().getJoin().equals(kind))//1
{ 

//#if -2137922705 
figNode = new FigJoinState();
//#endif 

} 
else

//#if 600517553 
if(Model.getPseudostateKind().getShallowHistory()
                       .equals(kind))//1
{ 

//#if 1969866041 
figNode = new FigShallowHistoryState();
//#endif 

} 
else

//#if -486638923 
if(Model.getPseudostateKind().getDeepHistory()
                       .equals(kind))//1
{ 

//#if 433311818 
figNode = new FigDeepHistoryState();
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


//#if 671836930 
if(figNode == null)//1
{ 

//#if 1819818242 
throw new IllegalArgumentException(
                "Failed to construct a FigNode for " + node);
//#endif 

} 

//#endif 


//#if 1114799626 
setStyleAttributes(figNode, styleAttributes);
//#endif 


//#if 448591485 
return figNode;
//#endif 

} 

//#endif 


//#if 864247488 
private void setSourcePort(FigEdge edge, FigNode source)
    { 

//#if -1630745245 
edge.setSourcePortFig(source);
//#endif 


//#if 40116320 
edge.setSourceFigNode(source);
//#endif 

} 

//#endif 


//#if 1287265997 
private void setStyleAttributes(Fig fig, Map<String, String> attributeMap)
    { 

//#if -16602700 
String name;
//#endif 


//#if -285663546 
String value;
//#endif 


//#if 564681063 
for (Map.Entry<String, String> entry : attributeMap.entrySet()) //1
{ 

//#if 433887723 
name = entry.getKey();
//#endif 


//#if 1334755247 
value = entry.getValue();
//#endif 


//#if -1106698320 
if("operationsVisible".equals(name))//1
{ 

//#if 833684904 
((OperationsCompartmentContainer) fig)
                .setOperationsVisible(value.equalsIgnoreCase("true"));
//#endif 

} 
else

//#if -938823266 
if("attributesVisible".equals(name))//1
{ 

//#if 1520304526 
((AttributesCompartmentContainer) fig)
                .setAttributesVisible(value.equalsIgnoreCase("true"));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 681527282 
private void setDestPort(FigEdge edge, FigNode dest)
    { 

//#if -1482066792 
edge.setDestPortFig(dest);
//#endif 


//#if 973300437 
edge.setDestFigNode(dest);
//#endif 

} 

//#endif 


//#if -193661306 
protected final void setPorts(Layer layer, FigEdge newEdge)
    { 

//#if 900459401 
Object modelElement = newEdge.getOwner();
//#endif 


//#if -847775946 
if(newEdge.getSourcePortFig() == null)//1
{ 

//#if -325926380 
Object source;
//#endif 


//#if -1994798393 
if(modelElement instanceof CommentEdge)//1
{ 

//#if -2070999015 
source = ((CommentEdge) modelElement).getSource();
//#endif 

} 
else
{ 

//#if 1099590697 
source = Model.getUmlHelper().getSource(modelElement);
//#endif 

} 

//#endif 


//#if 1907032082 
FigNode sourceNode = getNodePresentationFor(layer, source);
//#endif 


//#if -1310951673 
assert (sourceNode != null) : "No FigNode found for " + source;
//#endif 


//#if -1676484299 
setSourcePort(newEdge, sourceNode);
//#endif 

} 

//#endif 


//#if 1359502543 
if(newEdge.getDestPortFig() == null)//1
{ 

//#if -448826634 
Object dest;
//#endif 


//#if -670998050 
if(modelElement instanceof CommentEdge)//1
{ 

//#if -2004713540 
dest = ((CommentEdge) modelElement).getDestination();
//#endif 

} 
else
{ 

//#if 1875029317 
dest = Model.getUmlHelper().getDestination(newEdge.getOwner());
//#endif 

} 

//#endif 


//#if -1493576989 
setDestPort(newEdge, getNodePresentationFor(layer, dest));
//#endif 

} 

//#endif 


//#if -1340856774 
if(newEdge.getSourcePortFig() == null
                || newEdge.getDestPortFig() == null)//1
{ 

//#if 1459902028 
throw new IllegalStateException("Edge of type "
                                            + newEdge.getClass().getName()
                                            + " created with no source or destination port");
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

