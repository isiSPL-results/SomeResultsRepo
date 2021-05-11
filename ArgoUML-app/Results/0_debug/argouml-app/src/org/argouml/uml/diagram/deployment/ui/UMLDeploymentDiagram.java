
//#if -283358009 
// Compilation Unit of /UMLDeploymentDiagram.java 
 

//#if -1944098061 
package org.argouml.uml.diagram.deployment.ui;
//#endif 


//#if -862931233 
import java.awt.Point;
//#endif 


//#if -467394336 
import java.awt.Rectangle;
//#endif 


//#if -185386022 
import java.beans.PropertyVetoException;
//#endif 


//#if 1146781548 
import java.util.ArrayList;
//#endif 


//#if -1764879499 
import java.util.Collection;
//#endif 


//#if 1693716021 
import javax.swing.Action;
//#endif 


//#if -66803479 
import org.apache.log4j.Logger;
//#endif 


//#if -38252906 
import org.argouml.i18n.Translator;
//#endif 


//#if 1343700471 
import org.argouml.model.Facade;
//#endif 


//#if 1780733020 
import org.argouml.model.Model;
//#endif 


//#if -1639279752 
import org.argouml.ui.CmdCreateNode;
//#endif 


//#if -1621864897 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 788872737 
import org.argouml.uml.diagram.deployment.DeploymentDiagramGraphModel;
//#endif 


//#if 2038571647 
import org.argouml.uml.diagram.static_structure.ui.FigClass;
//#endif 


//#if -732546184 
import org.argouml.uml.diagram.static_structure.ui.FigComment;
//#endif 


//#if -2099898146 
import org.argouml.uml.diagram.static_structure.ui.FigInterface;
//#endif 


//#if 2064590988 
import org.argouml.uml.diagram.ui.ActionSetAddAssociationMode;
//#endif 


//#if 350860492 
import org.argouml.uml.diagram.ui.ActionSetMode;
//#endif 


//#if 345462368 
import org.argouml.uml.diagram.ui.FigNodeAssociation;
//#endif 


//#if -1697429238 
import org.argouml.uml.diagram.ui.RadioAction;
//#endif 


//#if -424589828 
import org.argouml.uml.diagram.ui.UMLDiagram;
//#endif 


//#if 1981909852 
import org.argouml.uml.diagram.use_case.ui.FigActor;
//#endif 


//#if -92841629 
import org.argouml.util.ToolBarUtility;
//#endif 


//#if 1573209419 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if -248464667 
import org.tigris.gef.base.LayerPerspectiveMutable;
//#endif 


//#if 716584206 
import org.tigris.gef.base.ModeCreatePolyEdge;
//#endif 


//#if 1509836913 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if 879776518 
public class UMLDeploymentDiagram extends 
//#if 1434964767 
UMLDiagram
//#endif 

  { 

//#if 1750121416 
private static final Logger LOG =
        Logger.getLogger(UMLDeploymentDiagram.class);
//#endif 


//#if -1837182373 
private Action actionMNode;
//#endif 


//#if 1497944134 
private Action actionMNodeInstance;
//#endif 


//#if 232677436 
private Action actionMComponent;
//#endif 


//#if 116452647 
private Action actionMComponentInstance;
//#endif 


//#if -1435844063 
private Action actionMClass;
//#endif 


//#if -918415488 
private Action actionMInterface;
//#endif 


//#if 220206142 
private Action actionMObject;
//#endif 


//#if -1206033230 
private Action actionMDependency;
//#endif 


//#if -1948601928 
private Action actionMAssociation;
//#endif 


//#if -1839198365 
private Action actionMLink;
//#endif 


//#if -1661505303 
private Action actionAssociation;
//#endif 


//#if 1368453800 
private Action actionAggregation;
//#endif 


//#if 814147808 
private Action actionComposition;
//#endif 


//#if 1060952443 
private Action actionUniAssociation;
//#endif 


//#if -204055750 
private Action actionUniAggregation;
//#endif 


//#if -758361742 
private Action actionUniComposition;
//#endif 


//#if 895694497 
private Action actionMGeneralization;
//#endif 


//#if 6977075 
private Action actionMAbstraction;
//#endif 


//#if 565635106 
static final long serialVersionUID = -375918274062198744L;
//#endif 


//#if 402201001 
public void encloserChanged(FigNode enclosed, FigNode oldEncloser,
                                FigNode newEncloser)
    { 

//#if -1779563208 
if(oldEncloser != null && newEncloser == null
                && Model.getFacade().isAComponent(oldEncloser.getOwner()))//1
{ 

//#if -1081682778 
Collection<Object> er1 = Model.getFacade().getElementResidences(
                                         enclosed.getOwner());
//#endif 


//#if -640742067 
Collection er2 = Model.getFacade().getResidentElements(
                                 oldEncloser.getOwner());
//#endif 


//#if 1573110691 
Collection<Object> common = new ArrayList<Object>(er1);
//#endif 


//#if -445217154 
common.retainAll(er2);
//#endif 


//#if 66089135 
for (Object elementResidence : common) //1
{ 

//#if 2026553039 
Model.getUmlFactory().delete(elementResidence);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -322384222 
protected Action getActionMAbstraction()
    { 

//#if 706333115 
if(actionMAbstraction == null)//1
{ 

//#if -1697640938 
actionMAbstraction =
                new RadioAction(new ActionSetMode(
                                    ModeCreatePolyEdge.class,
                                    "edgeClass",
                                    Model.getMetaTypes().getAbstraction(),
                                    "button.new-realization"));
//#endif 

} 

//#endif 


//#if -1654062354 
return actionMAbstraction;
//#endif 

} 

//#endif 


//#if -7029807 
protected Object[] getUmlActions()
    { 

//#if 1365596470 
Object[] actions = {
            getActionMNode(),
            getActionMNodeInstance(),
            getActionMComponent(),
            getActionMComponentInstance(),
            getActionMGeneralization(),
            getActionMAbstraction(),
            getActionMDependency(),
            getAssociationActions(),
            getActionMObject(),
            getActionMLink(),
        };
//#endif 


//#if -1569798451 
return actions;
//#endif 

} 

//#endif 


//#if -815791171 
protected Action getActionMAssociation()
    { 

//#if -1015960056 
if(actionMAssociation == null)//1
{ 

//#if -245635058 
actionMAssociation =
                new RadioAction(new ActionSetMode(
                                    ModeCreatePolyEdge.class,
                                    "edgeClass",
                                    Model.getMetaTypes().getAssociation(),
                                    "button.new-association"));
//#endif 

} 

//#endif 


//#if -265075163 
return actionMAssociation;
//#endif 

} 

//#endif 


//#if -1237718917 
protected Action getActionAggregation()
    { 

//#if 936870146 
if(actionAggregation == null)//1
{ 

//#if -2133521941 
actionAggregation =
                new RadioAction(
                new ActionSetAddAssociationMode(
                    Model.getAggregationKind().getAggregate(),
                    false,
                    "button.new-aggregation"));
//#endif 

} 

//#endif 


//#if -1579816655 
return actionAggregation;
//#endif 

} 

//#endif 


//#if -422860296 
@Override
    public FigNode drop(Object droppedObject, Point location)
    { 

//#if 2054492195 
FigNode figNode = null;
//#endif 


//#if 1798325103 
Rectangle bounds = null;
//#endif 


//#if 1578286943 
if(location != null)//1
{ 

//#if -1930987570 
bounds = new Rectangle(location.x, location.y, 0, 0);
//#endif 

} 

//#endif 


//#if 257326826 
DiagramSettings settings = getDiagramSettings();
//#endif 


//#if -2031365278 
if(Model.getFacade().isANode(droppedObject))//1
{ 

//#if -1946264433 
figNode = new FigMNode(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 443969165 
if(Model.getFacade().isAAssociation(droppedObject))//1
{ 

//#if -679853769 
figNode =
                createNaryAssociationNode(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 1238940050 
if(Model.getFacade().isANodeInstance(droppedObject))//1
{ 

//#if -1390900798 
figNode = new FigNodeInstance(droppedObject, bounds, settings);
//#endif 

} 
else

//#if -1023866013 
if(Model.getFacade().isAComponent(droppedObject))//1
{ 

//#if -500974708 
figNode = new FigComponent(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 1020029433 
if(Model.getFacade().isAComponentInstance(droppedObject))//1
{ 

//#if -1583886717 
figNode = new FigComponentInstance(droppedObject, bounds, settings);
//#endif 

} 
else

//#if -310877530 
if(Model.getFacade().isAClass(droppedObject))//1
{ 

//#if -1360707475 
figNode = new FigClass(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 1463735274 
if(Model.getFacade().isAInterface(droppedObject))//1
{ 

//#if -1427710543 
figNode = new FigInterface(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 849354203 
if(Model.getFacade().isAObject(droppedObject))//1
{ 

//#if 92251713 
figNode = new FigObject(droppedObject, bounds, settings);
//#endif 

} 
else

//#if -1712001585 
if(Model.getFacade().isAActor(droppedObject))//1
{ 

//#if 175868029 
figNode = new FigActor(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 790780314 
if(Model.getFacade().isAComment(droppedObject))//1
{ 

//#if 1493397759 
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


//#endif 


//#endif 


//#if 1057812082 
if(figNode != null)//1
{ 

//#if -1493503689 
if(location != null)//1
{ 

//#if 96978230 
figNode.setLocation(location.x, location.y);
//#endif 

} 

//#endif 


//#if 837748511 
LOG.debug("Dropped object " + droppedObject + " converted to "
                      + figNode);
//#endif 

} 
else
{ 

//#if -1585545749 
LOG.debug("Dropped object NOT added " + figNode);
//#endif 

} 

//#endif 


//#if -464615343 
return figNode;
//#endif 

} 

//#endif 


//#if -1183413808 
public void setNamespace(Object handle)
    { 

//#if 323069052 
if(!Model.getFacade().isANamespace(handle))//1
{ 

//#if -1616700850 
LOG.error(
                "Illegal argument. Object " + handle + " is not a namespace");
//#endif 


//#if -879725952 
throw new IllegalArgumentException(
                "Illegal argument. Object " + handle + " is not a namespace");
//#endif 

} 

//#endif 


//#if -1662033915 
Object m = handle;
//#endif 


//#if 948204643 
boolean init = (null == getNamespace());
//#endif 


//#if -1241136670 
super.setNamespace(m);
//#endif 


//#if -1158212330 
DeploymentDiagramGraphModel gm = createGraphModel();
//#endif 


//#if 695424232 
gm.setHomeModel(m);
//#endif 


//#if 1000068004 
if(init)//1
{ 

//#if 1543827277 
LayerPerspective lay =
                new LayerPerspectiveMutable(Model.getFacade().getName(m), gm);
//#endif 


//#if -1841368081 
DeploymentDiagramRenderer rend = new DeploymentDiagramRenderer();
//#endif 


//#if 1071970385 
lay.setGraphNodeRenderer(rend);
//#endif 


//#if -2069861578 
lay.setGraphEdgeRenderer(rend);
//#endif 


//#if 1194168020 
setLayer(lay);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2119339157 
public boolean relocate(Object base)
    { 

//#if -1927116253 
setNamespace(base);
//#endif 


//#if 1126973500 
damage();
//#endif 


//#if -1546883154 
return true;
//#endif 

} 

//#endif 


//#if -1820307945 
@Deprecated
    public UMLDeploymentDiagram()
    { 

//#if 1462979555 
try //1
{ 

//#if 639848971 
setName(getNewDiagramName());
//#endif 

} 

//#if 2091492829 
catch (PropertyVetoException pve) //1
{ 
} 

//#endif 


//#endif 


//#if 138687106 
setGraphModel(createGraphModel());
//#endif 

} 

//#endif 


//#if 387229730 
protected Action getActionMGeneralization()
    { 

//#if -602796447 
if(actionMGeneralization == null)//1
{ 

//#if -1166626050 
actionMGeneralization =
                new RadioAction(new ActionSetMode(
                                    ModeCreatePolyEdge.class,
                                    "edgeClass",
                                    Model.getMetaTypes().getGeneralization(),
                                    "button.new-generalization"));
//#endif 

} 

//#endif 


//#if 576930786 
return actionMGeneralization;
//#endif 

} 

//#endif 


//#if 30429428 
@Override
    public boolean doesAccept(Object objectToAccept)
    { 

//#if 109826701 
if(Model.getFacade().isANode(objectToAccept))//1
{ 

//#if 1479504408 
return true;
//#endif 

} 
else

//#if 1692513704 
if(Model.getFacade().isAAssociation(objectToAccept))//1
{ 

//#if -1314895083 
return true;
//#endif 

} 
else

//#if -1299668182 
if(Model.getFacade().isANodeInstance(objectToAccept))//1
{ 

//#if -669490348 
return true;
//#endif 

} 
else

//#if 1951926105 
if(Model.getFacade().isAComponent(objectToAccept))//1
{ 

//#if 1467915841 
return true;
//#endif 

} 
else

//#if 1837492562 
if(Model.getFacade().isAComponentInstance(objectToAccept))//1
{ 

//#if 2098498522 
return true;
//#endif 

} 
else

//#if 1408057446 
if(Model.getFacade().isAClass(objectToAccept))//1
{ 

//#if 326621847 
return true;
//#endif 

} 
else

//#if 76829735 
if(Model.getFacade().isAInterface(objectToAccept))//1
{ 

//#if -1828299283 
return true;
//#endif 

} 
else

//#if -1734575863 
if(Model.getFacade().isAObject(objectToAccept))//1
{ 

//#if -602296526 
return true;
//#endif 

} 
else

//#if -1461365370 
if(Model.getFacade().isAComment(objectToAccept))//1
{ 

//#if 1247253674 
return true;
//#endif 

} 
else

//#if 1132039565 
if(Model.getFacade().isAActor(objectToAccept))//1
{ 

//#if 1760643894 
return true;
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


//#if 552782018 
return false;
//#endif 

} 

//#endif 


//#if -4470725 
protected Action getActionUniAggregation()
    { 

//#if -1722143330 
if(actionUniAggregation == null)//1
{ 

//#if 1639887443 
actionUniAggregation =
                new RadioAction(
                new ActionSetAddAssociationMode(
                    Model.getAggregationKind().getAggregate(),
                    true, "button.new-uniaggregation"));
//#endif 

} 

//#endif 


//#if -254060865 
return actionUniAggregation;
//#endif 

} 

//#endif 


//#if -1148789433 

//#if -1910579876 
@SuppressWarnings("unchecked")
//#endif 


    public Collection getRelocationCandidates(Object root)
    { 

//#if 957383374 
return
            Model.getModelManagementHelper().getAllModelElementsOfKindWithModel(
                root, Model.getMetaTypes().getPackage());
//#endif 

} 

//#endif 


//#if -1774125148 
public String getLabelName()
    { 

//#if -336648718 
return Translator.localize("label.deployment-diagram");
//#endif 

} 

//#endif 


//#if -804683672 
protected Action getActionMNode()
    { 

//#if 1841308887 
if(actionMNode == null)//1
{ 

//#if -1683971796 
actionMNode =
                new RadioAction(new CmdCreateNode(
                                    Model.getMetaTypes().getNode(),
                                    "button.new-node"));
//#endif 

} 

//#endif 


//#if 1519596492 
return actionMNode;
//#endif 

} 

//#endif 


//#if -436164812 
protected Action getActionMClass()
    { 

//#if 67775948 
if(actionMClass == null)//1
{ 

//#if 1050293945 
actionMClass =
                new RadioAction(
                new CmdCreateNode(Model.getMetaTypes().getUMLClass(),
                                  "button.new-class"));
//#endif 

} 

//#endif 


//#if -1825209445 
return actionMClass;
//#endif 

} 

//#endif 


//#if -867179424 
protected Action getActionMLink()
    { 

//#if 1455515510 
if(actionMLink == null)//1
{ 

//#if -1539736829 
actionMLink =
                new RadioAction(new ActionSetMode(
                                    ModeCreatePolyEdge.class,
                                    "edgeClass",
                                    Model.getMetaTypes().getLink(),
                                    "button.new-link"));
//#endif 

} 

//#endif 


//#if -544567109 
return actionMLink;
//#endif 

} 

//#endif 


//#if -1238092507 
protected Action getActionMObject()
    { 

//#if -768372763 
if(actionMObject == null)//1
{ 

//#if 439748529 
actionMObject =
                new RadioAction(
                new CmdCreateNode(Model.getMetaTypes().getObject(),
                                  "button.new-object"));
//#endif 

} 

//#endif 


//#if -821285440 
return actionMObject;
//#endif 

} 

//#endif 


//#if -1367551201 
@Deprecated
    public UMLDeploymentDiagram(Object namespace)
    { 

//#if 1438724587 
this();
//#endif 


//#if 2138528303 
setNamespace(namespace);
//#endif 

} 

//#endif 


//#if -108403746 
private DeploymentDiagramGraphModel createGraphModel()
    { 

//#if -503153898 
if((getGraphModel() instanceof DeploymentDiagramGraphModel))//1
{ 

//#if 1222635196 
return (DeploymentDiagramGraphModel) getGraphModel();
//#endif 

} 
else
{ 

//#if -826551533 
return new DeploymentDiagramGraphModel();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 557561777 
protected Action getActionMDependency()
    { 

//#if -106467728 
if(actionMDependency == null)//1
{ 

//#if 394148532 
actionMDependency =
                new RadioAction(new ActionSetMode(
                                    ModeCreatePolyEdge.class,
                                    "edgeClass",
                                    Model.getMetaTypes().getDependency(),
                                    "button.new-dependency"));
//#endif 

} 

//#endif 


//#if -125200013 
return actionMDependency;
//#endif 

} 

//#endif 


//#if -677170598 
protected Action getActionAssociation()
    { 

//#if -529589366 
if(actionAssociation == null)//1
{ 

//#if -1401235726 
actionAssociation =
                new RadioAction(
                new ActionSetAddAssociationMode(
                    Model.getAggregationKind().getNone(),
                    false,
                    "button.new-association"));
//#endif 

} 

//#endif 


//#if -270648869 
return actionAssociation;
//#endif 

} 

//#endif 


//#if -8087293 
protected Action getActionUniComposition()
    { 

//#if -1138366343 
if(actionUniComposition == null)//1
{ 

//#if -440199473 
actionUniComposition =
                new RadioAction(
                new ActionSetAddAssociationMode(
                    Model.getAggregationKind().getComposite(),
                    true, "button.new-unicomposition"));
//#endif 

} 

//#endif 


//#if 1215646026 
return actionUniComposition;
//#endif 

} 

//#endif 


//#if 748073807 
private Object[] getAssociationActions()
    { 

//#if 612052804 
Object[][] actions = {
            {getActionAssociation(), getActionUniAssociation() },
            {getActionAggregation(), getActionUniAggregation() },
            {getActionComposition(), getActionUniComposition() },
        };
//#endif 


//#if 90016411 
ToolBarUtility.manageDefault(actions, "diagram.deployment.association");
//#endif 


//#if -1971793174 
return actions;
//#endif 

} 

//#endif 


//#if -745661688 
public boolean isRelocationAllowed(Object base)
    { 

//#if 1916418957 
return Model.getFacade().isAPackage(base);
//#endif 

} 

//#endif 


//#if -146104466 
protected Action getActionMComponentInstance()
    { 

//#if 260173025 
if(actionMComponentInstance == null)//1
{ 

//#if -1450059199 
actionMComponentInstance =
                new RadioAction(new CmdCreateNode(
                                    Model.getMetaTypes().getComponentInstance(),
                                    "button.new-componentinstance"));
//#endif 

} 

//#endif 


//#if 25130940 
return actionMComponentInstance;
//#endif 

} 

//#endif 


//#if -327366435 
protected Action getActionMNodeInstance()
    { 

//#if -162294434 
if(actionMNodeInstance == null)//1
{ 

//#if -722605116 
actionMNodeInstance =
                new RadioAction(new CmdCreateNode(
                                    Model.getMetaTypes().getNodeInstance(),
                                    "button.new-nodeinstance"));
//#endif 

} 

//#endif 


//#if 1074521161 
return actionMNodeInstance;
//#endif 

} 

//#endif 


//#if 1171084290 
public void setModelElementNamespace(
        Object modelElement,
        Object namespace)
    { 

//#if 1245098862 
Facade facade = Model.getFacade();
//#endif 


//#if -1107686343 
if(facade.isANode(modelElement)
                || facade.isANodeInstance(modelElement)
                || facade.isAComponent(modelElement)
                || facade.isAComponentInstance(modelElement))//1
{ 

//#if 460095805 
LOG.info("Setting namespace of " + modelElement);
//#endif 


//#if -461004024 
super.setModelElementNamespace(modelElement, namespace);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1509652473 
protected Action getActionMComponent()
    { 

//#if 935719329 
if(actionMComponent == null)//1
{ 

//#if 1181136379 
actionMComponent =
                new RadioAction(
                new CmdCreateNode(
                    Model.getMetaTypes().getComponent(),
                    "button.new-component"));
//#endif 

} 

//#endif 


//#if -1067045434 
return actionMComponent;
//#endif 

} 

//#endif 


//#if 185510197 
protected Action getActionMInterface()
    { 

//#if 884640507 
if(actionMInterface == null)//1
{ 

//#if 1917895873 
actionMInterface =
                new RadioAction(
                new CmdCreateNode(
                    Model.getMetaTypes().getInterface(),
                    "button.new-interface"));
//#endif 

} 

//#endif 


//#if 1410283432 
return actionMInterface;
//#endif 

} 

//#endif 


//#if 556077594 
protected Action getActionUniAssociation()
    { 

//#if -510808030 
if(actionUniAssociation == null)//1
{ 

//#if 57199597 
actionUniAssociation =
                new RadioAction(
                new ActionSetAddAssociationMode(
                    Model.getAggregationKind().getNone(),
                    true, "button.new-uniassociation"));
//#endif 

} 

//#endif 


//#if 463223909 
return actionUniAssociation;
//#endif 

} 

//#endif 


//#if -1241335485 
protected Action getActionComposition()
    { 

//#if -705077365 
if(actionComposition == null)//1
{ 

//#if -111965525 
actionComposition =
                new RadioAction(
                new ActionSetAddAssociationMode(
                    Model.getAggregationKind().getComposite(),
                    false,
                    "button.new-composition"));
//#endif 

} 

//#endif 


//#if -1436689942 
return actionComposition;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

