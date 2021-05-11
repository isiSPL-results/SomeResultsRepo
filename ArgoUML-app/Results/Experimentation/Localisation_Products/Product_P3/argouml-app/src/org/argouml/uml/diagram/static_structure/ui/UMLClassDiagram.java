package org.argouml.uml.diagram.static_structure.ui;
import java.awt.Point;
import java.awt.Rectangle;
import java.beans.PropertyVetoException;
import java.util.Collection;
import javax.swing.Action;
import org.apache.log4j.Logger;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.deployment.ui.FigComponent;
import org.argouml.uml.diagram.deployment.ui.FigComponentInstance;
import org.argouml.uml.diagram.deployment.ui.FigMNode;
import org.argouml.uml.diagram.deployment.ui.FigNodeInstance;
import org.argouml.uml.diagram.deployment.ui.FigObject;
import org.argouml.uml.diagram.static_structure.ClassDiagramGraphModel;
import org.argouml.uml.diagram.ui.FigClassAssociationClass;
import org.argouml.uml.diagram.ui.FigEdgeAssociationClass;
import org.argouml.uml.diagram.ui.FigNodeAssociation;
import org.argouml.uml.diagram.ui.ModeCreateDependency;
import org.argouml.uml.diagram.ui.ModeCreatePermission;
import org.argouml.uml.diagram.ui.ModeCreateUsage;
import org.argouml.uml.diagram.ui.UMLDiagram;
import org.argouml.uml.diagram.use_case.ui.FigActor;
import org.argouml.uml.diagram.use_case.ui.FigUseCase;
import org.argouml.uml.ui.foundation.core.ActionAddAttribute;
import org.argouml.uml.ui.foundation.core.ActionAddOperation;
import org.argouml.util.ToolBarUtility;
import org.tigris.gef.base.LayerPerspective;
import org.tigris.gef.base.LayerPerspectiveMutable;
import org.tigris.gef.presentation.FigNode;
public class UMLClassDiagram extends UMLDiagram
  { 
private static final long serialVersionUID = -9192325790126361563L;
private static final Logger LOG = Logger.getLogger(UMLClassDiagram.class);
private Action actionAssociationClass;
private Action actionClass;
private Action actionInterface;
private Action actionDependency;
private Action actionPermission;
private Action actionUsage;
private Action actionLink;
private Action actionGeneralization;
private Action actionRealization;
private Action actionPackage;
private Action actionModel;
private Action actionSubsystem;
private Action actionAssociation;
private Action actionAssociationEnd;
private Action actionAggregation;
private Action actionComposition;
private Action actionUniAssociation;
private Action actionUniAggregation;
private Action actionUniComposition;
private Action actionDataType;
private Action actionEnumeration;
private Action actionStereotype;
private Action actionSignal;
private Action actionException;
protected Object[] getUmlActions()
    { 
Object[] actions = {
            getPackageActions(),
            getActionClass(),
            null,
            getAssociationActions(),
            getAggregationActions(),
            getCompositionActions(),
            getActionAssociationEnd(),
            getActionGeneralization(),
            null,
            getActionInterface(),
            getActionRealization(),
            null,
            getDependencyActions(),
            null,
            ActionAddAttribute.getTargetFollower(),
            ActionAddOperation.getTargetFollower(),
            getActionAssociationClass(),
            null,
            getDataTypeActions(),
        };
return actions;
} 
public boolean isRelocationAllowed(Object base)
    { 
return Model.getFacade().isANamespace(base);
} 
protected Action getActionAggregation()
    { 
if(actionAggregation == null)//1
{ 
actionAggregation =
                makeCreateAssociationAction(
                    Model.getAggregationKind().getAggregate(),
                    false,
                    "button.new-aggregation");
} 
return actionAggregation;
} 
protected Action getActionModel()
    { 
if(actionModel == null)//1
{ 
actionModel =
                makeCreateNodeAction(Model.getMetaTypes().getModel(), "Model");
} 
return actionModel;
} 
public String getLabelName()
    { 
return Translator.localize("label.class-diagram");
} 
protected Action getActionDependency()
    { 
if(actionDependency == null)//1
{ 
actionDependency = makeCreateDependencyAction(
                                   ModeCreateDependency.class,
                                   Model.getMetaTypes().getDependency(),
                                   "button.new-dependency");
} 
return actionDependency;
} 
protected Action getActionAssociationClass()
    { 
if(actionAssociationClass == null)//1
{ 
actionAssociationClass =
                makeCreateAssociationClassAction(
                    "button.new-associationclass");
} 
return actionAssociationClass;
} 
protected Action getActionAssociation()
    { 
if(actionAssociation == null)//1
{ 
actionAssociation =
                makeCreateAssociationAction(
                    Model.getAggregationKind().getNone(),
                    false, "button.new-association");
} 
return actionAssociation;
} 
public boolean relocate(Object base)
    { 
setNamespace(base);
damage();
return true;
} 
protected Action getActionPermission()
    { 
if(actionPermission == null)//1
{ 
actionPermission = makeCreateDependencyAction(
                                   ModeCreatePermission.class,
                                   Model.getMetaTypes().getPackageImport(),
                                   "button.new-permission");
} 
return actionPermission;
} 
protected Action getActionAssociationEnd()
    { 
if(actionAssociationEnd == null)//1
{ 
actionAssociationEnd =
                makeCreateAssociationEndAction("button.new-association-end");
} 
return actionAssociationEnd;
} 
@Override
    public boolean doesAccept(Object objectToAccept)
    { 
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
if(Model.getFacade().isAModel(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isASubsystem(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAPackage(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAComment(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAAssociation(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAEnumeration(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isADataType(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAStereotype(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAException(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isASignal(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAActor(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAUseCase(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAObject(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isANodeInstance(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAComponentInstance(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isANode(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAComponent(objectToAccept))//1
{ 
return true;
} 
return false;
} 
public Collection getRelocationCandidates(Object root)
    { 
return
            Model.getModelManagementHelper().getAllModelElementsOfKindWithModel(
                root, Model.getMetaTypes().getNamespace());
} 
private Action getActionSignal()
    { 
if(actionSignal == null)//1
{ 
actionSignal =
                makeCreateNodeAction(Model.getMetaTypes().getSignal(),
                                     "button.new-signal");
} 
return actionSignal;
} 
protected Action getActionGeneralization()
    { 
if(actionGeneralization == null)//1
{ 
actionGeneralization = makeCreateGeneralizationAction();
} 
return actionGeneralization;
} 
public UMLClassDiagram(String name, Object namespace)
    { 
super(name, namespace, new ClassDiagramGraphModel());
} 
private Object[] getDataTypeActions()
    { 
Object[] actions = {
            getActionDataType(),
            getActionEnumeration(),
            getActionStereotype(),
            getActionSignal(),
            getActionException(),
        };
ToolBarUtility.manageDefault(actions, "diagram.class.datatype");
return actions;
} 
private Object[] getDependencyActions()
    { 
Object[] actions = {
            getActionDependency(),
            getActionPermission(),
            getActionUsage(),
        };
ToolBarUtility.manageDefault(actions, "diagram.class.dependency");
return actions;
} 
public void setNamespace(Object ns)
    { 
if(!Model.getFacade().isANamespace(ns))//1
{ 
LOG.error("Illegal argument. "
                      + "Object " + ns + " is not a namespace");
throw new IllegalArgumentException("Illegal argument. "
                                               + "Object " + ns
                                               + " is not a namespace");
} 
boolean init = (null == getNamespace());
super.setNamespace(ns);
ClassDiagramGraphModel gm = (ClassDiagramGraphModel) getGraphModel();
gm.setHomeModel(ns);
if(init)//1
{ 
LayerPerspective lay =
                new LayerPerspectiveMutable(Model.getFacade().getName(ns), gm);
ClassDiagramRenderer rend = new ClassDiagramRenderer();
lay.setGraphNodeRenderer(rend);
lay.setGraphEdgeRenderer(rend);
setLayer(lay);
} 
} 
protected Action getActionUniComposition()
    { 
if(actionUniComposition == null)//1
{ 
actionUniComposition =
                makeCreateAssociationAction(
                    Model.getAggregationKind().getComposite(),
                    true,
                    "button.new-unicomposition");
} 
return actionUniComposition;
} 
private Object[] getCompositionActions()
    { 
Object[] actions = {
            getActionComposition(),
            getActionUniComposition(),
        };
ToolBarUtility.manageDefault(actions, "diagram.class.composition");
return actions;
} 
protected Action getActionUniAssociation()
    { 
if(actionUniAssociation == null)//1
{ 
actionUniAssociation =
                makeCreateAssociationAction(
                    Model.getAggregationKind().getNone(),
                    true,
                    "button.new-uniassociation");
} 
return actionUniAssociation;
} 
private Action getActionDataType()
    { 
if(actionDataType == null)//1
{ 
actionDataType =
                makeCreateNodeAction(Model.getMetaTypes().getDataType(),
                                     "button.new-datatype");
} 
return actionDataType;
} 
protected Action getActionUniAggregation()
    { 
if(actionUniAggregation == null)//1
{ 
actionUniAggregation =
                makeCreateAssociationAction(
                    Model.getAggregationKind().getAggregate(),
                    true,
                    "button.new-uniaggregation");
} 
return actionUniAggregation;
} 
protected Action getActionComposition()
    { 
if(actionComposition == null)//1
{ 
actionComposition =
                makeCreateAssociationAction(
                    Model.getAggregationKind().getComposite(),
                    false, "button.new-composition");
} 
return actionComposition;
} 
protected Action getActionRealization()
    { 
if(actionRealization == null)//1
{ 
actionRealization =
                makeCreateEdgeAction(
                    Model.getMetaTypes().getAbstraction(),
                    "button.new-realization");
} 
return actionRealization;
} 
protected Action getActionUsage()
    { 
if(actionUsage == null)//1
{ 
actionUsage = makeCreateDependencyAction(
                              ModeCreateUsage.class,
                              Model.getMetaTypes().getUsage(),
                              "button.new-usage");
} 
return actionUsage;
} 
protected Action getActionClass()
    { 
if(actionClass == null)//1
{ 
actionClass =
                makeCreateNodeAction(Model.getMetaTypes().getUMLClass(),
                                     "button.new-class");
} 
return actionClass;
} 
@Deprecated
    public UMLClassDiagram()
    { 
super(new ClassDiagramGraphModel());
} 
private Object[] getAggregationActions()
    { 
Object[] actions = {
            getActionAggregation(),
            getActionUniAggregation(),
        };
ToolBarUtility.manageDefault(actions, "diagram.class.aggregation");
return actions;
} 
protected Action getActionLink()
    { 
if(actionLink == null)//1
{ 
actionLink =
                makeCreateEdgeAction(Model.getMetaTypes().getLink(), "Link");
} 
return actionLink;
} 
private Object[] getAssociationActions()
    { 
Object[] actions = {
            getActionAssociation(),
            getActionUniAssociation(),
        };
ToolBarUtility.manageDefault(actions, "diagram.class.association");
return actions;
} 
private Action getActionStereotype()
    { 
if(actionStereotype == null)//1
{ 
actionStereotype =
                makeCreateNodeAction(Model.getMetaTypes().getStereotype(),
                                     "button.new-stereotype");
} 
return actionStereotype;
} 
public UMLClassDiagram(Object m)
    { 
super("", m, new ClassDiagramGraphModel());
String name = getNewDiagramName();
try//1
{ 
setName(name);
} 
catch (PropertyVetoException pve) //1
{ 
LOG.warn("Generated diagram name '" + name
                     + "' was vetoed by setName");
} 
} 
protected Action getActionPackage()
    { 
if(actionPackage == null)//1
{ 
actionPackage =
                makeCreateNodeAction(Model.getMetaTypes().getPackage(),
                                     "button.new-package");
} 
return actionPackage;
} 
protected Action getActionSubsystem()
    { 
if(actionSubsystem == null)//1
{ 
actionSubsystem =
                makeCreateNodeAction(
                    Model.getMetaTypes().getSubsystem(),
                    "Subsystem");
} 
return actionSubsystem;
} 
protected Action getActionInterface()
    { 
if(actionInterface == null)//1
{ 
actionInterface =
                makeCreateNodeAction(
                    Model.getMetaTypes().getInterface(),
                    "button.new-interface");
} 
return actionInterface;
} 
private Object getPackageActions()
    { 
if(false)//1
{ 
Object[] actions = {
                getActionPackage(),
                getActionModel(),
                getActionSubsystem(),
            };
ToolBarUtility.manageDefault(actions, "diagram.class.package");
return actions;
} 
else
{ 
return getActionPackage();
} 
} 
private Action getActionEnumeration()
    { 
if(actionEnumeration == null)//1
{ 
actionEnumeration =
                makeCreateNodeAction(Model.getMetaTypes().getEnumeration(),
                                     "button.new-enumeration");
} 
return actionEnumeration;
} 
private Action getActionException()
    { 
if(actionException == null)//1
{ 
actionException =
                makeCreateNodeAction(Model.getMetaTypes().getException(),
                                     "button.new-exception");
} 
return actionException;
} 
public void encloserChanged(FigNode enclosed, FigNode oldEncloser,
                                FigNode newEncloser)
    { 
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
if(Model.getFacade().isAAssociation(droppedObject))//1
{ 
figNode =
                createNaryAssociationNode(droppedObject, bounds, settings);
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
if(Model.getFacade().isAModel(droppedObject))//1
{ 
figNode = new FigModel(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isASubsystem(droppedObject))//1
{ 
figNode = new FigSubsystem(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAPackage(droppedObject))//1
{ 
figNode = new FigPackage(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAComment(droppedObject))//1
{ 
figNode = new FigComment(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAEnumeration(droppedObject))//1
{ 
figNode = new FigEnumeration(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isADataType(droppedObject))//1
{ 
figNode = new FigDataType(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAStereotype(droppedObject))//1
{ 
figNode = new FigStereotypeDeclaration(droppedObject, bounds,
                                                   settings);
} 
else
if(Model.getFacade().isAException(droppedObject))//1
{ 
figNode = new FigException(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isASignal(droppedObject))//1
{ 
figNode = new FigSignal(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAActor(droppedObject))//1
{ 
figNode = new FigActor(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAUseCase(droppedObject))//1
{ 
figNode = new FigUseCase(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAObject(droppedObject))//1
{ 
figNode = new FigObject(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isANodeInstance(droppedObject))//1
{ 
figNode = new FigNodeInstance(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAComponentInstance(droppedObject))//1
{ 
figNode = new FigComponentInstance(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isANode(droppedObject))//1
{ 
figNode = new FigMNode(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAComponent(droppedObject))//1
{ 
figNode = new FigComponent(droppedObject, bounds, settings);
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
LOG.debug("Dropped object NOT added " + droppedObject);
} 
return figNode;
} 

 } 
