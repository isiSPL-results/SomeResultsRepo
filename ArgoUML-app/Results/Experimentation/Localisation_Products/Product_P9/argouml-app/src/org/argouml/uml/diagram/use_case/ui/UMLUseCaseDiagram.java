package org.argouml.uml.diagram.use_case.ui;
import java.awt.Point;
import java.awt.Rectangle;
import java.beans.PropertyVetoException;
import java.util.Collection;
import java.util.HashSet;
import javax.swing.Action;
import org.apache.log4j.Logger;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.ui.CmdCreateNode;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.static_structure.ui.FigComment;
import org.argouml.uml.diagram.static_structure.ui.FigPackage;
import org.argouml.uml.diagram.ui.ActionAddExtensionPoint;
import org.argouml.uml.diagram.ui.ActionSetAddAssociationMode;
import org.argouml.uml.diagram.ui.ActionSetMode;
import org.argouml.uml.diagram.ui.RadioAction;
import org.argouml.uml.diagram.ui.UMLDiagram;
import org.argouml.uml.diagram.use_case.UseCaseDiagramGraphModel;
import org.argouml.util.ToolBarUtility;
import org.tigris.gef.base.LayerPerspective;
import org.tigris.gef.base.LayerPerspectiveMutable;
import org.tigris.gef.base.ModeCreatePolyEdge;
import org.tigris.gef.presentation.FigNode;
public class UMLUseCaseDiagram extends UMLDiagram
  { 
private static final Logger LOG = Logger.getLogger(UMLUseCaseDiagram.class);
private Action actionActor;
private Action actionUseCase;
private Action actionAssociation;
private Action actionAggregation;
private Action actionComposition;
private Action actionUniAssociation;
private Action actionUniAggregation;
private Action actionUniComposition;
private Action actionGeneralize;
private Action actionExtend;
private Action actionInclude;
private Action actionDependency;
private Action actionExtensionPoint;
protected Action getActionActor()
    { 
if(actionActor == null)//1
{ 
actionActor = new RadioAction(new CmdCreateNode(
                                              Model.getMetaTypes().getActor(), "button.new-actor"));
} 
return actionActor;
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
if(Model.getFacade().isAComment(droppedObject))//1
{ 
figNode = new FigComment(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAPackage(droppedObject))//1
{ 
figNode = new FigPackage(droppedObject, bounds, settings);
} 
if(figNode != null)//1
{ 
LOG.debug("Dropped object " + droppedObject + " converted to "
                      + figNode);
} 
else
{ 
LOG.debug("Dropped object NOT added " + figNode);
} 
return figNode;
} 
@Deprecated
    public UMLUseCaseDiagram()
    { 
super(new UseCaseDiagramGraphModel());
try//1
{ 
setName(getNewDiagramName());
} 
catch (PropertyVetoException pve) //1
{ 
} 
} 
protected Action getActionInclude()
    { 
if(actionInclude == null)//1
{ 
actionInclude = new RadioAction(
                new ActionSetMode(
                    ModeCreatePolyEdge.class,
                    "edgeClass",
                    Model.getMetaTypes().getInclude(),
                    "button.new-include"));
} 
return actionInclude;
} 
protected Action getActionAssociation()
    { 
if(actionAssociation == null)//1
{ 
actionAssociation = new RadioAction(
                new ActionSetAddAssociationMode(
                    Model.getAggregationKind().getNone(),
                    false,
                    "button.new-association"));
} 
return actionAssociation;
} 
protected Action getActionUniAssociation()
    { 
if(actionUniAssociation == null)//1
{ 
actionUniAssociation  = new RadioAction(
                new ActionSetAddAssociationMode(
                    Model.getAggregationKind().getNone(),
                    true,
                    "button.new-uniassociation"));
} 
return actionUniAssociation;
} 
@Override
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
super.setNamespace(m);
UseCaseDiagramGraphModel gm =
            (UseCaseDiagramGraphModel) getGraphModel();
gm.setHomeModel(m);
LayerPerspective lay =
            new LayerPerspectiveMutable(Model.getFacade().getName(m), gm);
UseCaseDiagramRenderer rend = new UseCaseDiagramRenderer();
lay.setGraphNodeRenderer(rend);
lay.setGraphEdgeRenderer(rend);
setLayer(lay);
} 
public void encloserChanged(FigNode enclosed,
                                FigNode oldEncloser, FigNode newEncloser)
    { 
} 
@SuppressWarnings("unchecked")

    public Collection getRelocationCandidates(Object root)
    { 
Collection c = new HashSet();
c.add(Model.getModelManagementHelper()
              .getAllModelElementsOfKindWithModel(root,
                      Model.getMetaTypes().getPackage()));
c.add(Model.getModelManagementHelper()
              .getAllModelElementsOfKindWithModel(root,
                      Model.getMetaTypes().getClassifier()));
return c;
} 
protected Action getActionUniComposition()
    { 
if(actionUniComposition == null)//1
{ 
actionUniComposition  = new RadioAction(
                new ActionSetAddAssociationMode(
                    Model.getAggregationKind().getComposite(),
                    true,
                    "button.new-unicomposition"));
} 
return actionUniComposition;
} 
protected Object[] getUmlActions()
    { 
Object[] actions = {
            getActionActor(),
            getActionUseCase(),
            null,
            getAssociationActions(),
            getActionDependency(),
            getActionGeneralize(),
            getActionExtend(),
            getActionInclude(),
            null,
            getActionExtensionPoint(),
        };
return actions;
} 
public boolean isRelocationAllowed(Object base)
    { 
return Model.getFacade().isAPackage(base)
               || Model.getFacade().isAClassifier(base);
} 
protected Action getActionUniAggregation()
    { 
if(actionUniAggregation == null)//1
{ 
actionUniAggregation  = new RadioAction(
                new ActionSetAddAssociationMode(
                    Model.getAggregationKind().getAggregate(),
                    true,
                    "button.new-uniaggregation"));
} 
return actionUniAggregation;
} 
protected Action getActionExtensionPoint()
    { 
if(actionExtensionPoint == null)//1
{ 
actionExtensionPoint = ActionAddExtensionPoint.singleton();
} 
return actionExtensionPoint;
} 
protected Action getActionUseCase()
    { 
if(actionUseCase == null)//1
{ 
actionUseCase = new RadioAction(new CmdCreateNode(
                                                Model.getMetaTypes().getUseCase(), "button.new-usecase"));
} 
return actionUseCase;
} 
protected Action getActionExtend()
    { 
if(actionExtend == null)//1
{ 
actionExtend = new RadioAction(
                new ActionSetMode(
                    ModeCreatePolyEdge.class,
                    "edgeClass",
                    Model.getMetaTypes().getExtend(),
                    "button.new-extend"));
} 
return actionExtend;
} 
public String getLabelName()
    { 
return Translator.localize("label.usecase-diagram");
} 
public UMLUseCaseDiagram(Object m)
    { 
this();
if(!Model.getFacade().isANamespace(m))//1
{ 
throw new IllegalArgumentException();
} 
setNamespace(m);
} 
protected Action getActionGeneralize()
    { 
if(actionGeneralize == null)//1
{ 
actionGeneralize = new RadioAction(
                new ActionSetMode(
                    ModeCreatePolyEdge.class,
                    "edgeClass",
                    Model.getMetaTypes().getGeneralization(),
                    "button.new-generalization"));
} 
return actionGeneralize;
} 
private Object[] getAssociationActions()
    { 
Object[][] actions = {
            {getActionAssociation(), getActionUniAssociation() },
            {getActionAggregation(), getActionUniAggregation() },
            {getActionComposition(), getActionUniComposition() },
        };
ToolBarUtility.manageDefault(actions, "diagram.usecase.association");
return actions;
} 
public UMLUseCaseDiagram(String name, Object namespace)
    { 
this(namespace);
if(!Model.getFacade().isANamespace(namespace))//1
{ 
throw new IllegalArgumentException();
} 
try//1
{ 
setName(name);
} 
catch (PropertyVetoException v) //1
{ 
} 
} 
public boolean relocate(Object base)
    { 
setNamespace(base);
damage();
return true;
} 
protected Action getActionDependency()
    { 
if(actionDependency == null)//1
{ 
actionDependency = new RadioAction(
                new ActionSetMode(
                    ModeCreatePolyEdge.class,
                    "edgeClass",
                    Model.getMetaTypes().getDependency(),
                    "button.new-dependency"));
} 
return actionDependency;
} 
protected Action getActionAggregation()
    { 
if(actionAggregation == null)//1
{ 
actionAggregation = new RadioAction(
                new ActionSetAddAssociationMode(
                    Model.getAggregationKind().getAggregate(),
                    false,
                    "button.new-aggregation"));
} 
return actionAggregation;
} 
@Override
    public boolean doesAccept(Object objectToAccept)
    { 
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
if(Model.getFacade().isAComment(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAPackage(objectToAccept))//1
{ 
return true;
} 
return false;
} 
protected Action getActionComposition()
    { 
if(actionComposition == null)//1
{ 
actionComposition = new RadioAction(
                new ActionSetAddAssociationMode(
                    Model.getAggregationKind().getComposite(),
                    false,
                    "button.new-composition"));
} 
return actionComposition;
} 

 } 
