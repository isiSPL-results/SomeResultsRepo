
//#if -1699580096 
// Compilation Unit of /UMLUseCaseDiagram.java 
 

//#if 1669628103 
package org.argouml.uml.diagram.use_case.ui;
//#endif 


//#if 1081128848 
import java.awt.Point;
//#endif 


//#if 1908564241 
import java.awt.Rectangle;
//#endif 


//#if 1671483979 
import java.beans.PropertyVetoException;
//#endif 


//#if 903678822 
import java.util.Collection;
//#endif 


//#if 678677726 
import java.util.HashSet;
//#endif 


//#if -225292698 
import javax.swing.Action;
//#endif 


//#if -890511528 
import org.apache.log4j.Logger;
//#endif 


//#if 3192197 
import org.argouml.i18n.Translator;
//#endif 


//#if 957024971 
import org.argouml.model.Model;
//#endif 


//#if -354481559 
import org.argouml.ui.CmdCreateNode;
//#endif 


//#if -1900624210 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 586413865 
import org.argouml.uml.diagram.static_structure.ui.FigComment;
//#endif 


//#if 1939697186 
import org.argouml.uml.diagram.static_structure.ui.FigPackage;
//#endif 


//#if 764941488 
import org.argouml.uml.diagram.ui.ActionAddExtensionPoint;
//#endif 


//#if -911416259 
import org.argouml.uml.diagram.ui.ActionSetAddAssociationMode;
//#endif 


//#if 299256381 
import org.argouml.uml.diagram.ui.ActionSetMode;
//#endif 


//#if -736590149 
import org.argouml.uml.diagram.ui.RadioAction;
//#endif 


//#if 1407520299 
import org.argouml.uml.diagram.ui.UMLDiagram;
//#endif 


//#if 142546375 
import org.argouml.uml.diagram.use_case.UseCaseDiagramGraphModel;
//#endif 


//#if -1418415918 
import org.argouml.util.ToolBarUtility;
//#endif 


//#if -168805572 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if 11756500 
import org.tigris.gef.base.LayerPerspectiveMutable;
//#endif 


//#if 1677423295 
import org.tigris.gef.base.ModeCreatePolyEdge;
//#endif 


//#if 345264224 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if -1541286925 
public class UMLUseCaseDiagram extends 
//#if -1686961319 
UMLDiagram
//#endif 

  { 

//#if -1836763276 
private static final Logger LOG = Logger.getLogger(UMLUseCaseDiagram.class);
//#endif 


//#if -1165353541 
private Action actionActor;
//#endif 


//#if -1872152231 
private Action actionUseCase;
//#endif 


//#if 1429637359 
private Action actionAssociation;
//#endif 


//#if 164629166 
private Action actionAggregation;
//#endif 


//#if -389676826 
private Action actionComposition;
//#endif 


//#if 898202549 
private Action actionUniAssociation;
//#endif 


//#if -366805644 
private Action actionUniAggregation;
//#endif 


//#if -921111636 
private Action actionUniComposition;
//#endif 


//#if 736008858 
private Action actionGeneralize;
//#endif 


//#if -1910262228 
private Action actionExtend;
//#endif 


//#if -1472403416 
private Action actionInclude;
//#endif 


//#if -958510437 
private Action actionDependency;
//#endif 


//#if 650875029 
private Action actionExtensionPoint;
//#endif 


//#if 832519380 
protected Action getActionActor()
    { 

//#if 105536942 
if(actionActor == null)//1
{ 

//#if -735581048 
actionActor = new RadioAction(new CmdCreateNode(
                                              Model.getMetaTypes().getActor(), "button.new-actor"));
//#endif 

} 

//#endif 


//#if -1870418473 
return actionActor;
//#endif 

} 

//#endif 


//#if 923104126 
@Override
    public FigNode drop(Object droppedObject, Point location)
    { 

//#if 1976834280 
FigNode figNode = null;
//#endif 


//#if -609070262 
Rectangle bounds = null;
//#endif 


//#if -829108422 
if(location != null)//1
{ 

//#if 455957584 
bounds = new Rectangle(location.x, location.y, 0, 0);
//#endif 

} 

//#endif 


//#if -2085786171 
DiagramSettings settings = getDiagramSettings();
//#endif 


//#if -547063040 
if(Model.getFacade().isAActor(droppedObject))//1
{ 

//#if 677710948 
figNode = new FigActor(droppedObject, bounds, settings);
//#endif 

} 
else

//#if -1428482217 
if(Model.getFacade().isAUseCase(droppedObject))//1
{ 

//#if 1936984038 
figNode = new FigUseCase(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 1937220357 
if(Model.getFacade().isAComment(droppedObject))//1
{ 

//#if -1669520107 
figNode = new FigComment(droppedObject, bounds, settings);
//#endif 

} 
else

//#if -371131025 
if(Model.getFacade().isAPackage(droppedObject))//1
{ 

//#if 1043800522 
figNode = new FigPackage(droppedObject, bounds, settings);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#if 980154167 
if(figNode != null)//1
{ 

//#if 1119699989 
LOG.debug("Dropped object " + droppedObject + " converted to "
                      + figNode);
//#endif 

} 
else
{ 

//#if 60777626 
LOG.debug("Dropped object NOT added " + figNode);
//#endif 

} 

//#endif 


//#if -222246698 
return figNode;
//#endif 

} 

//#endif 


//#if -622299153 
@Deprecated
    public UMLUseCaseDiagram()
    { 

//#if -1787057974 
super(new UseCaseDiagramGraphModel());
//#endif 


//#if -1165393623 
try //1
{ 

//#if 1774719749 
setName(getNewDiagramName());
//#endif 

} 

//#if -912305222 
catch (PropertyVetoException pve) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 


//#if -680413369 
protected Action getActionInclude()
    { 

//#if 531527569 
if(actionInclude == null)//1
{ 

//#if -1758050136 
actionInclude = new RadioAction(
                new ActionSetMode(
                    ModeCreatePolyEdge.class,
                    "edgeClass",
                    Model.getMetaTypes().getInclude(),
                    "button.new-include"));
//#endif 

} 

//#endif 


//#if -1012911436 
return actionInclude;
//#endif 

} 

//#endif 


//#if -141185568 
protected Action getActionAssociation()
    { 

//#if -915730880 
if(actionAssociation == null)//1
{ 

//#if -1707056565 
actionAssociation = new RadioAction(
                new ActionSetAddAssociationMode(
                    Model.getAggregationKind().getNone(),
                    false,
                    "button.new-association"));
//#endif 

} 

//#endif 


//#if 1989930257 
return actionAssociation;
//#endif 

} 

//#endif 


//#if -602300204 
protected Action getActionUniAssociation()
    { 

//#if -717572573 
if(actionUniAssociation == null)//1
{ 

//#if 466223134 
actionUniAssociation  = new RadioAction(
                new ActionSetAddAssociationMode(
                    Model.getAggregationKind().getNone(),
                    true,
                    "button.new-uniassociation"));
//#endif 

} 

//#endif 


//#if -16640218 
return actionUniAssociation;
//#endif 

} 

//#endif 


//#if 1917817410 
@Override
    public void setNamespace(Object handle)
    { 

//#if -902743051 
if(!Model.getFacade().isANamespace(handle))//1
{ 

//#if -1666190845 
LOG.error(
                "Illegal argument. Object " + handle + " is not a namespace");
//#endif 


//#if 1562099499 
throw new IllegalArgumentException(
                "Illegal argument. Object " + handle + " is not a namespace");
//#endif 

} 

//#endif 


//#if -540863572 
Object m = handle;
//#endif 


//#if 1712780379 
super.setNamespace(m);
//#endif 


//#if -2068193285 
UseCaseDiagramGraphModel gm =
            (UseCaseDiagramGraphModel) getGraphModel();
//#endif 


//#if -1368990449 
gm.setHomeModel(m);
//#endif 


//#if 128064558 
LayerPerspective lay =
            new LayerPerspectiveMutable(Model.getFacade().getName(m), gm);
//#endif 


//#if 2023132408 
UseCaseDiagramRenderer rend = new UseCaseDiagramRenderer();
//#endif 


//#if -1801075376 
lay.setGraphNodeRenderer(rend);
//#endif 


//#if -647940043 
lay.setGraphEdgeRenderer(rend);
//#endif 


//#if -824440843 
setLayer(lay);
//#endif 

} 

//#endif 


//#if -752425373 
public void encloserChanged(FigNode enclosed,
                                FigNode oldEncloser, FigNode newEncloser)
    { 
} 

//#endif 


//#if -2132822451 

//#if 1406568658 
@SuppressWarnings("unchecked")
//#endif 


    public Collection getRelocationCandidates(Object root)
    { 

//#if -451244272 
Collection c = new HashSet();
//#endif 


//#if 91501721 
c.add(Model.getModelManagementHelper()
              .getAllModelElementsOfKindWithModel(root,
                      Model.getMetaTypes().getPackage()));
//#endif 


//#if 1785300020 
c.add(Model.getModelManagementHelper()
              .getAllModelElementsOfKindWithModel(root,
                      Model.getMetaTypes().getClassifier()));
//#endif 


//#if -1371320890 
return c;
//#endif 

} 

//#endif 


//#if -1166465091 
protected Action getActionUniComposition()
    { 

//#if 712923226 
if(actionUniComposition == null)//1
{ 

//#if 1195705368 
actionUniComposition  = new RadioAction(
                new ActionSetAddAssociationMode(
                    Model.getAggregationKind().getComposite(),
                    true,
                    "button.new-unicomposition"));
//#endif 

} 

//#endif 


//#if 1045657067 
return actionUniComposition;
//#endif 

} 

//#endif 


//#if 1329112203 
protected Object[] getUmlActions()
    { 

//#if 1709132856 
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
//#endif 


//#if 1436561618 
return actions;
//#endif 

} 

//#endif 


//#if -808928062 
public boolean isRelocationAllowed(Object base)
    { 

//#if -2017423293 
return Model.getFacade().isAPackage(base)
               || Model.getFacade().isAClassifier(base);
//#endif 

} 

//#endif 


//#if -1162848523 
protected Action getActionUniAggregation()
    { 

//#if -832339588 
if(actionUniAggregation == null)//1
{ 

//#if 1562690204 
actionUniAggregation  = new RadioAction(
                new ActionSetAddAssociationMode(
                    Model.getAggregationKind().getAggregate(),
                    true,
                    "button.new-uniaggregation"));
//#endif 

} 

//#endif 


//#if -1393530595 
return actionUniAggregation;
//#endif 

} 

//#endif 


//#if 320481268 
protected Action getActionExtensionPoint()
    { 

//#if 330277400 
if(actionExtensionPoint == null)//1
{ 

//#if 453087108 
actionExtensionPoint = ActionAddExtensionPoint.singleton();
//#endif 

} 

//#endif 


//#if -1157155685 
return actionExtensionPoint;
//#endif 

} 

//#endif 


//#if -187724746 
protected Action getActionUseCase()
    { 

//#if -500863757 
if(actionUseCase == null)//1
{ 

//#if -1572763852 
actionUseCase = new RadioAction(new CmdCreateNode(
                                                Model.getMetaTypes().getUseCase(), "button.new-usecase"));
//#endif 

} 

//#endif 


//#if 1027298712 
return actionUseCase;
//#endif 

} 

//#endif 


//#if -131984835 
protected Action getActionExtend()
    { 

//#if -606177485 
if(actionExtend == null)//1
{ 

//#if 1485378331 
actionExtend = new RadioAction(
                new ActionSetMode(
                    ModeCreatePolyEdge.class,
                    "edgeClass",
                    Model.getMetaTypes().getExtend(),
                    "button.new-extend"));
//#endif 

} 

//#endif 


//#if -414846076 
return actionExtend;
//#endif 

} 

//#endif 


//#if -968328226 
public String getLabelName()
    { 

//#if 388519489 
return Translator.localize("label.usecase-diagram");
//#endif 

} 

//#endif 


//#if -1040694954 
public UMLUseCaseDiagram(Object m)
    { 

//#if 188768823 
this();
//#endif 


//#if -230296981 
if(!Model.getFacade().isANamespace(m))//1
{ 

//#if 1849789654 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if -1598853131 
setNamespace(m);
//#endif 

} 

//#endif 


//#if -646943473 
protected Action getActionGeneralize()
    { 

//#if 733949008 
if(actionGeneralize == null)//1
{ 

//#if 119754102 
actionGeneralize = new RadioAction(
                new ActionSetMode(
                    ModeCreatePolyEdge.class,
                    "edgeClass",
                    Model.getMetaTypes().getGeneralization(),
                    "button.new-generalization"));
//#endif 

} 

//#endif 


//#if -418959235 
return actionGeneralize;
//#endif 

} 

//#endif 


//#if 183740553 
private Object[] getAssociationActions()
    { 

//#if 136048108 
Object[][] actions = {
            {getActionAssociation(), getActionUniAssociation() },
            {getActionAggregation(), getActionUniAggregation() },
            {getActionComposition(), getActionUniComposition() },
        };
//#endif 


//#if -1239813197 
ToolBarUtility.manageDefault(actions, "diagram.usecase.association");
//#endif 


//#if 1544597906 
return actions;
//#endif 

} 

//#endif 


//#if 1999654914 
public UMLUseCaseDiagram(String name, Object namespace)
    { 

//#if 733538474 
this(namespace);
//#endif 


//#if 13146939 
if(!Model.getFacade().isANamespace(namespace))//1
{ 

//#if 1102911829 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if 46377949 
try //1
{ 

//#if 1700876096 
setName(name);
//#endif 

} 

//#if 2101102536 
catch (PropertyVetoException v) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 


//#if 590068507 
public boolean relocate(Object base)
    { 

//#if 1602960542 
setNamespace(base);
//#endif 


//#if 658489463 
damage();
//#endif 


//#if -788476631 
return true;
//#endif 

} 

//#endif 


//#if -1637434066 
protected Action getActionDependency()
    { 

//#if 1940679406 
if(actionDependency == null)//1
{ 

//#if 1643643488 
actionDependency = new RadioAction(
                new ActionSetMode(
                    ModeCreatePolyEdge.class,
                    "edgeClass",
                    Model.getMetaTypes().getDependency(),
                    "button.new-dependency"));
//#endif 

} 

//#endif 


//#if 961816893 
return actionDependency;
//#endif 

} 

//#endif 


//#if -701733887 
protected Action getActionAggregation()
    { 

//#if 496110927 
if(actionAggregation == null)//1
{ 

//#if 865882693 
actionAggregation = new RadioAction(
                new ActionSetAddAssociationMode(
                    Model.getAggregationKind().getAggregate(),
                    false,
                    "button.new-aggregation"));
//#endif 

} 

//#endif 


//#if 1481569086 
return actionAggregation;
//#endif 

} 

//#endif 


//#if -2145414610 
@Override
    public boolean doesAccept(Object objectToAccept)
    { 

//#if -1225961843 
if(Model.getFacade().isAActor(objectToAccept))//1
{ 

//#if 1352224138 
return true;
//#endif 

} 
else

//#if 747716384 
if(Model.getFacade().isAUseCase(objectToAccept))//1
{ 

//#if -99938675 
return true;
//#endif 

} 
else

//#if -740292017 
if(Model.getFacade().isAComment(objectToAccept))//1
{ 

//#if -1476893297 
return true;
//#endif 

} 
else

//#if -518293198 
if(Model.getFacade().isAPackage(objectToAccept))//1
{ 

//#if 50652361 
return true;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#if -1450492787 
return false;
//#endif 

} 

//#endif 


//#if -705350455 
protected Action getActionComposition()
    { 

//#if 1268365590 
if(actionComposition == null)//1
{ 

//#if 1132052915 
actionComposition = new RadioAction(
                new ActionSetAddAssociationMode(
                    Model.getAggregationKind().getComposite(),
                    false,
                    "button.new-composition"));
//#endif 

} 

//#endif 


//#if 259454901 
return actionComposition;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

