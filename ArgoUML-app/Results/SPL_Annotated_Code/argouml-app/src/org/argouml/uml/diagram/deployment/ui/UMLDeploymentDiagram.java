// Compilation Unit of /UMLDeploymentDiagram.java 
 
package org.argouml.uml.diagram.deployment.ui;
import java.awt.Point;
import java.awt.Rectangle;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.Action;
import org.apache.log4j.Logger;
import org.argouml.i18n.Translator;
import org.argouml.model.Facade;
import org.argouml.model.Model;
import org.argouml.ui.CmdCreateNode;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.deployment.DeploymentDiagramGraphModel;
import org.argouml.uml.diagram.static_structure.ui.FigClass;
import org.argouml.uml.diagram.static_structure.ui.FigComment;
import org.argouml.uml.diagram.static_structure.ui.FigInterface;
import org.argouml.uml.diagram.ui.ActionSetAddAssociationMode;
import org.argouml.uml.diagram.ui.ActionSetMode;
import org.argouml.uml.diagram.ui.FigNodeAssociation;
import org.argouml.uml.diagram.ui.RadioAction;
import org.argouml.uml.diagram.ui.UMLDiagram;
import org.argouml.uml.diagram.use_case.ui.FigActor;
import org.argouml.util.ToolBarUtility;
import org.tigris.gef.base.LayerPerspective;
import org.tigris.gef.base.LayerPerspectiveMutable;
import org.tigris.gef.base.ModeCreatePolyEdge;
import org.tigris.gef.presentation.FigNode;
public class UMLDeploymentDiagram extends UMLDiagram
  { 
private static final Logger LOG =
        Logger.getLogger(UMLDeploymentDiagram.class);
private Action actionMNode;
private Action actionMNodeInstance;
private Action actionMComponent;
private Action actionMComponentInstance;
private Action actionMClass;
private Action actionMInterface;
private Action actionMObject;
private Action actionMDependency;
private Action actionMAssociation;
private Action actionMLink;
private Action actionAssociation;
private Action actionAggregation;
private Action actionComposition;
private Action actionUniAssociation;
private Action actionUniAggregation;
private Action actionUniComposition;
private Action actionMGeneralization;
private Action actionMAbstraction;
static final long serialVersionUID = -375918274062198744L;
public void encloserChanged(FigNode enclosed, FigNode oldEncloser,
                                FigNode newEncloser)
    { 
if(oldEncloser != null && newEncloser == null
                && Model.getFacade().isAComponent(oldEncloser.getOwner()))//1
{ 
Collection<Object> er1 = Model.getFacade().getElementResidences(
                                         enclosed.getOwner());
Collection er2 = Model.getFacade().getResidentElements(
                                 oldEncloser.getOwner());
Collection<Object> common = new ArrayList<Object>(er1);
common.retainAll(er2);
for (Object elementResidence : common) //1
{ 
Model.getUmlFactory().delete(elementResidence);
} 

} 

} 

protected Action getActionMAbstraction()
    { 
if(actionMAbstraction == null)//1
{ 
actionMAbstraction =
                new RadioAction(new ActionSetMode(
                                    ModeCreatePolyEdge.class,
                                    "edgeClass",
                                    Model.getMetaTypes().getAbstraction(),
                                    "button.new-realization"));
} 

return actionMAbstraction;
} 

protected Object[] getUmlActions()
    { 
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
return actions;
} 

protected Action getActionMAssociation()
    { 
if(actionMAssociation == null)//1
{ 
actionMAssociation =
                new RadioAction(new ActionSetMode(
                                    ModeCreatePolyEdge.class,
                                    "edgeClass",
                                    Model.getMetaTypes().getAssociation(),
                                    "button.new-association"));
} 

return actionMAssociation;
} 

protected Action getActionAggregation()
    { 
if(actionAggregation == null)//1
{ 
actionAggregation =
                new RadioAction(
                new ActionSetAddAssociationMode(
                    Model.getAggregationKind().getAggregate(),
                    false,
                    "button.new-aggregation"));
} 

return actionAggregation;
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
if(Model.getFacade().isANode(droppedObject))//1
{ 
figNode = new FigMNode(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAAssociation(droppedObject))//1
{ 
figNode =
                createNaryAssociationNode(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isANodeInstance(droppedObject))//1
{ 
figNode = new FigNodeInstance(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAComponent(droppedObject))//1
{ 
figNode = new FigComponent(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAComponentInstance(droppedObject))//1
{ 
figNode = new FigComponentInstance(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAClass(droppedObject))//1
{ 
figNode = new FigClass(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAInterface(droppedObject))//1
{ 
figNode = new FigInterface(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAObject(droppedObject))//1
{ 
figNode = new FigObject(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAActor(droppedObject))//1
{ 
figNode = new FigActor(droppedObject, bounds, settings);
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
LOG.debug("Dropped object NOT added " + figNode);
} 

return figNode;
} 

public void setNamespace(Object handle)
    { 
if(!Model.getFacade().isANamespace(handle))//1
{ 
LOG.error(
                "Illegal argument. Object " + handle + " is not a namespace");
throw new IllegalArgumentException(
                "Illegal argument. Object " + handle + " is not a namespace");
} 

Object m = handle;
boolean init = (null == getNamespace());
super.setNamespace(m);
DeploymentDiagramGraphModel gm = createGraphModel();
gm.setHomeModel(m);
if(init)//1
{ 
LayerPerspective lay =
                new LayerPerspectiveMutable(Model.getFacade().getName(m), gm);
DeploymentDiagramRenderer rend = new DeploymentDiagramRenderer();
lay.setGraphNodeRenderer(rend);
lay.setGraphEdgeRenderer(rend);
setLayer(lay);
} 

} 

public boolean relocate(Object base)
    { 
setNamespace(base);
damage();
return true;
} 

@Deprecated
    public UMLDeploymentDiagram()
    { 
try //1
{ 
setName(getNewDiagramName());
} 
catch (PropertyVetoException pve) //1
{ 
} 


setGraphModel(createGraphModel());
} 

protected Action getActionMGeneralization()
    { 
if(actionMGeneralization == null)//1
{ 
actionMGeneralization =
                new RadioAction(new ActionSetMode(
                                    ModeCreatePolyEdge.class,
                                    "edgeClass",
                                    Model.getMetaTypes().getGeneralization(),
                                    "button.new-generalization"));
} 

return actionMGeneralization;
} 

@Override
    public boolean doesAccept(Object objectToAccept)
    { 
if(Model.getFacade().isANode(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAAssociation(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isANodeInstance(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAComponent(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAComponentInstance(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAClass(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAInterface(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAObject(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAComment(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAActor(objectToAccept))//1
{ 
return true;
} 










return false;
} 

protected Action getActionUniAggregation()
    { 
if(actionUniAggregation == null)//1
{ 
actionUniAggregation =
                new RadioAction(
                new ActionSetAddAssociationMode(
                    Model.getAggregationKind().getAggregate(),
                    true, "button.new-uniaggregation"));
} 

return actionUniAggregation;
} 

@SuppressWarnings("unchecked")

    public Collection getRelocationCandidates(Object root)
    { 
return
            Model.getModelManagementHelper().getAllModelElementsOfKindWithModel(
                root, Model.getMetaTypes().getPackage());
} 

public String getLabelName()
    { 
return Translator.localize("label.deployment-diagram");
} 

protected Action getActionMNode()
    { 
if(actionMNode == null)//1
{ 
actionMNode =
                new RadioAction(new CmdCreateNode(
                                    Model.getMetaTypes().getNode(),
                                    "button.new-node"));
} 

return actionMNode;
} 

protected Action getActionMClass()
    { 
if(actionMClass == null)//1
{ 
actionMClass =
                new RadioAction(
                new CmdCreateNode(Model.getMetaTypes().getUMLClass(),
                                  "button.new-class"));
} 

return actionMClass;
} 

protected Action getActionMLink()
    { 
if(actionMLink == null)//1
{ 
actionMLink =
                new RadioAction(new ActionSetMode(
                                    ModeCreatePolyEdge.class,
                                    "edgeClass",
                                    Model.getMetaTypes().getLink(),
                                    "button.new-link"));
} 

return actionMLink;
} 

protected Action getActionMObject()
    { 
if(actionMObject == null)//1
{ 
actionMObject =
                new RadioAction(
                new CmdCreateNode(Model.getMetaTypes().getObject(),
                                  "button.new-object"));
} 

return actionMObject;
} 

@Deprecated
    public UMLDeploymentDiagram(Object namespace)
    { 
this();
setNamespace(namespace);
} 

private DeploymentDiagramGraphModel createGraphModel()
    { 
if((getGraphModel() instanceof DeploymentDiagramGraphModel))//1
{ 
return (DeploymentDiagramGraphModel) getGraphModel();
} 
else
{ 
return new DeploymentDiagramGraphModel();
} 

} 

protected Action getActionMDependency()
    { 
if(actionMDependency == null)//1
{ 
actionMDependency =
                new RadioAction(new ActionSetMode(
                                    ModeCreatePolyEdge.class,
                                    "edgeClass",
                                    Model.getMetaTypes().getDependency(),
                                    "button.new-dependency"));
} 

return actionMDependency;
} 

protected Action getActionAssociation()
    { 
if(actionAssociation == null)//1
{ 
actionAssociation =
                new RadioAction(
                new ActionSetAddAssociationMode(
                    Model.getAggregationKind().getNone(),
                    false,
                    "button.new-association"));
} 

return actionAssociation;
} 

protected Action getActionUniComposition()
    { 
if(actionUniComposition == null)//1
{ 
actionUniComposition =
                new RadioAction(
                new ActionSetAddAssociationMode(
                    Model.getAggregationKind().getComposite(),
                    true, "button.new-unicomposition"));
} 

return actionUniComposition;
} 

private Object[] getAssociationActions()
    { 
Object[][] actions = {
            {getActionAssociation(), getActionUniAssociation() },
            {getActionAggregation(), getActionUniAggregation() },
            {getActionComposition(), getActionUniComposition() },
        };
ToolBarUtility.manageDefault(actions, "diagram.deployment.association");
return actions;
} 

public boolean isRelocationAllowed(Object base)
    { 
return Model.getFacade().isAPackage(base);
} 

protected Action getActionMComponentInstance()
    { 
if(actionMComponentInstance == null)//1
{ 
actionMComponentInstance =
                new RadioAction(new CmdCreateNode(
                                    Model.getMetaTypes().getComponentInstance(),
                                    "button.new-componentinstance"));
} 

return actionMComponentInstance;
} 

protected Action getActionMNodeInstance()
    { 
if(actionMNodeInstance == null)//1
{ 
actionMNodeInstance =
                new RadioAction(new CmdCreateNode(
                                    Model.getMetaTypes().getNodeInstance(),
                                    "button.new-nodeinstance"));
} 

return actionMNodeInstance;
} 

public void setModelElementNamespace(
        Object modelElement,
        Object namespace)
    { 
Facade facade = Model.getFacade();
if(facade.isANode(modelElement)
                || facade.isANodeInstance(modelElement)
                || facade.isAComponent(modelElement)
                || facade.isAComponentInstance(modelElement))//1
{ 
LOG.info("Setting namespace of " + modelElement);
super.setModelElementNamespace(modelElement, namespace);
} 

} 

protected Action getActionMComponent()
    { 
if(actionMComponent == null)//1
{ 
actionMComponent =
                new RadioAction(
                new CmdCreateNode(
                    Model.getMetaTypes().getComponent(),
                    "button.new-component"));
} 

return actionMComponent;
} 

protected Action getActionMInterface()
    { 
if(actionMInterface == null)//1
{ 
actionMInterface =
                new RadioAction(
                new CmdCreateNode(
                    Model.getMetaTypes().getInterface(),
                    "button.new-interface"));
} 

return actionMInterface;
} 

protected Action getActionUniAssociation()
    { 
if(actionUniAssociation == null)//1
{ 
actionUniAssociation =
                new RadioAction(
                new ActionSetAddAssociationMode(
                    Model.getAggregationKind().getNone(),
                    true, "button.new-uniassociation"));
} 

return actionUniAssociation;
} 

protected Action getActionComposition()
    { 
if(actionComposition == null)//1
{ 
actionComposition =
                new RadioAction(
                new ActionSetAddAssociationMode(
                    Model.getAggregationKind().getComposite(),
                    false,
                    "button.new-composition"));
} 

return actionComposition;
} 

 } 


