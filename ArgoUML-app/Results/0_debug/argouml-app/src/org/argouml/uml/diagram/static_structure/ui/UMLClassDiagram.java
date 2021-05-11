
//#if 877249947 
// Compilation Unit of /UMLClassDiagram.java 
 

//#if 1829113430 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if -25911067 
import java.awt.Point;
//#endif 


//#if 1314363366 
import java.awt.Rectangle;
//#endif 


//#if 594473056 
import java.beans.PropertyVetoException;
//#endif 


//#if 1107288315 
import java.util.Collection;
//#endif 


//#if -819493573 
import javax.swing.Action;
//#endif 


//#if 346072483 
import org.apache.log4j.Logger;
//#endif 


//#if 976445008 
import org.argouml.i18n.Translator;
//#endif 


//#if -2101358314 
import org.argouml.model.Model;
//#endif 


//#if -203188487 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -1533056611 
import org.argouml.uml.diagram.deployment.ui.FigComponent;
//#endif 


//#if -494467704 
import org.argouml.uml.diagram.deployment.ui.FigComponentInstance;
//#endif 


//#if 747732043 
import org.argouml.uml.diagram.deployment.ui.FigMNode;
//#endif 


//#if -1020575931 
import org.argouml.uml.diagram.deployment.ui.FigNodeInstance;
//#endif 


//#if -247107971 
import org.argouml.uml.diagram.deployment.ui.FigObject;
//#endif 


//#if -1280792915 
import org.argouml.uml.diagram.static_structure.ClassDiagramGraphModel;
//#endif 


//#if -1779214038 
import org.argouml.uml.diagram.ui.FigClassAssociationClass;
//#endif 


//#if -948545655 
import org.argouml.uml.diagram.ui.FigEdgeAssociationClass;
//#endif 


//#if -1311265894 
import org.argouml.uml.diagram.ui.FigNodeAssociation;
//#endif 


//#if 621867595 
import org.argouml.uml.diagram.ui.ModeCreateDependency;
//#endif 


//#if -1724362681 
import org.argouml.uml.diagram.ui.ModeCreatePermission;
//#endif 


//#if 1741883871 
import org.argouml.uml.diagram.ui.ModeCreateUsage;
//#endif 


//#if -1710262986 
import org.argouml.uml.diagram.ui.UMLDiagram;
//#endif 


//#if -1119574302 
import org.argouml.uml.diagram.use_case.ui.FigActor;
//#endif 


//#if -827976512 
import org.argouml.uml.diagram.use_case.ui.FigUseCase;
//#endif 


//#if -150851051 
import org.argouml.uml.ui.foundation.core.ActionAddAttribute;
//#endif 


//#if -552312662 
import org.argouml.uml.ui.foundation.core.ActionAddOperation;
//#endif 


//#if 1594883101 
import org.argouml.util.ToolBarUtility;
//#endif 


//#if -962115887 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if 1729697439 
import org.tigris.gef.base.LayerPerspectiveMutable;
//#endif 


//#if -1481441749 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if -2001935811 
public class UMLClassDiagram extends 
//#if -1433918008 
UMLDiagram
//#endif 

  { 

//#if -1110938023 
private static final long serialVersionUID = -9192325790126361563L;
//#endif 


//#if -1953314334 
private static final Logger LOG = Logger.getLogger(UMLClassDiagram.class);
//#endif 


//#if -2005917858 
private Action actionAssociationClass;
//#endif 


//#if 812376137 
private Action actionClass;
//#endif 


//#if 263709096 
private Action actionInterface;
//#endif 


//#if 1080090506 
private Action actionDependency;
//#endif 


//#if -1266139770 
private Action actionPermission;
//#endif 


//#if 1334153536 
private Action actionUsage;
//#endif 


//#if -2043769797 
private Action actionLink;
//#endif 


//#if -1489140359 
private Action actionGeneralization;
//#endif 


//#if 1927971323 
private Action actionRealization;
//#endif 


//#if -932108869 
private Action actionPackage;
//#endif 


//#if 1101513912 
private Action actionModel;
//#endif 


//#if 1273574706 
private Action actionSubsystem;
//#endif 


//#if 201757152 
private Action actionAssociation;
//#endif 


//#if 1888474907 
private Action actionAssociationEnd;
//#endif 


//#if -1063251041 
private Action actionAggregation;
//#endif 


//#if -1617557033 
private Action actionComposition;
//#endif 


//#if 1355415844 
private Action actionUniAssociation;
//#endif 


//#if 90407651 
private Action actionUniAggregation;
//#endif 


//#if -463898341 
private Action actionUniComposition;
//#endif 


//#if -1006042511 
private Action actionDataType;
//#endif 


//#if -1371923238 
private Action actionEnumeration;
//#endif 


//#if 1763263619 
private Action actionStereotype;
//#endif 


//#if 648502477 
private Action actionSignal;
//#endif 


//#if 548004178 
private Action actionException;
//#endif 


//#if 1919531450 
protected Object[] getUmlActions()
    { 

//#if 104201009 
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
//#endif 


//#if -1923942407 
return actions;
//#endif 

} 

//#endif 


//#if 990937969 
public boolean isRelocationAllowed(Object base)
    { 

//#if -1733781840 
return Model.getFacade().isANamespace(base);
//#endif 

} 

//#endif 


//#if 798241842 
protected Action getActionAggregation()
    { 

//#if -1469847297 
if(actionAggregation == null)//1
{ 

//#if 1414340598 
actionAggregation =
                makeCreateAssociationAction(
                    Model.getAggregationKind().getAggregate(),
                    false,
                    "button.new-aggregation");
//#endif 

} 

//#endif 


//#if 1843090158 
return actionAggregation;
//#endif 

} 

//#endif 


//#if 1993218553 
protected Action getActionModel()
    { 

//#if -949598078 
if(actionModel == null)//1
{ 

//#if 917732428 
actionModel =
                makeCreateNodeAction(Model.getMetaTypes().getModel(), "Model");
//#endif 

} 

//#endif 


//#if 1198425539 
return actionModel;
//#endif 

} 

//#endif 


//#if -1803493299 
public String getLabelName()
    { 

//#if 843860417 
return Translator.localize("label.class-diagram");
//#endif 

} 

//#endif 


//#if -342121763 
protected Action getActionDependency()
    { 

//#if 2090451375 
if(actionDependency == null)//1
{ 

//#if -637265709 
actionDependency = makeCreateDependencyAction(
                                   ModeCreateDependency.class,
                                   Model.getMetaTypes().getDependency(),
                                   "button.new-dependency");
//#endif 

} 

//#endif 


//#if -105519938 
return actionDependency;
//#endif 

} 

//#endif 


//#if -252872375 
protected Action getActionAssociationClass()
    { 

//#if 963268761 
if(actionAssociationClass == null)//1
{ 

//#if 1703353224 
actionAssociationClass =
                makeCreateAssociationClassAction(
                    "button.new-associationclass");
//#endif 

} 

//#endif 


//#if 858346384 
return actionAssociationClass;
//#endif 

} 

//#endif 


//#if 1358790161 
protected Action getActionAssociation()
    { 

//#if -1073974860 
if(actionAssociation == null)//1
{ 

//#if 1052378570 
actionAssociation =
                makeCreateAssociationAction(
                    Model.getAggregationKind().getNone(),
                    false, "button.new-association");
//#endif 

} 

//#endif 


//#if -2130053243 
return actionAssociation;
//#endif 

} 

//#endif 


//#if 1713195980 
public boolean relocate(Object base)
    { 

//#if -1962283784 
setNamespace(base);
//#endif 


//#if 892614993 
damage();
//#endif 


//#if 867858307 
return true;
//#endif 

} 

//#endif 


//#if -60816287 
protected Action getActionPermission()
    { 

//#if -1372673384 
if(actionPermission == null)//1
{ 

//#if -1608392760 
actionPermission = makeCreateDependencyAction(
                                   ModeCreatePermission.class,
                                   Model.getMetaTypes().getPackageImport(),
                                   "button.new-permission");
//#endif 

} 

//#endif 


//#if -1766375969 
return actionPermission;
//#endif 

} 

//#endif 


//#if -320143380 
protected Action getActionAssociationEnd()
    { 

//#if -1962461153 
if(actionAssociationEnd == null)//1
{ 

//#if -1259611100 
actionAssociationEnd =
                makeCreateAssociationEndAction("button.new-association-end");
//#endif 

} 

//#endif 


//#if -783398544 
return actionAssociationEnd;
//#endif 

} 

//#endif 


//#if 1765673501 
@Override
    public boolean doesAccept(Object objectToAccept)
    { 

//#if 1534747057 
if(Model.getFacade().isAClass(objectToAccept))//1
{ 

//#if -1302834448 
return true;
//#endif 

} 
else

//#if -691633575 
if(Model.getFacade().isAInterface(objectToAccept))//1
{ 

//#if 1646599605 
return true;
//#endif 

} 
else

//#if 1982998408 
if(Model.getFacade().isAModel(objectToAccept))//1
{ 

//#if 1615377385 
return true;
//#endif 

} 
else

//#if -1176346938 
if(Model.getFacade().isASubsystem(objectToAccept))//1
{ 

//#if 1836117952 
return true;
//#endif 

} 
else

//#if 765458318 
if(Model.getFacade().isAPackage(objectToAccept))//1
{ 

//#if -1572942345 
return true;
//#endif 

} 
else

//#if -1661018237 
if(Model.getFacade().isAComment(objectToAccept))//1
{ 

//#if -1135877622 
return true;
//#endif 

} 
else

//#if 2068622834 
if(Model.getFacade().isAAssociation(objectToAccept))//1
{ 

//#if 1908095724 
return true;
//#endif 

} 
else

//#if -988409503 
if(Model.getFacade().isAEnumeration(objectToAccept))//1
{ 

//#if -15018478 
return true;
//#endif 

} 
else

//#if -1362283716 
if(Model.getFacade().isADataType(objectToAccept))//1
{ 

//#if 1137751290 
return true;
//#endif 

} 
else

//#if 935303741 
if(Model.getFacade().isAStereotype(objectToAccept))//1
{ 

//#if 564687178 
return true;
//#endif 

} 
else

//#if -1973224589 
if(Model.getFacade().isAException(objectToAccept))//1
{ 

//#if -1270436965 
return true;
//#endif 

} 
else

//#if -142425268 
if(Model.getFacade().isASignal(objectToAccept))//1
{ 

//#if -365744340 
return true;
//#endif 

} 
else

//#if -569480717 
if(Model.getFacade().isAActor(objectToAccept))//1
{ 

//#if 967027365 
return true;
//#endif 

} 
else

//#if -819787368 
if(Model.getFacade().isAUseCase(objectToAccept))//1
{ 

//#if -1620782718 
return true;
//#endif 

} 
else

//#if 1409721602 
if(Model.getFacade().isAObject(objectToAccept))//1
{ 

//#if -1258618758 
return true;
//#endif 

} 
else

//#if -912639914 
if(Model.getFacade().isANodeInstance(objectToAccept))//1
{ 

//#if 474705031 
return true;
//#endif 

} 
else

//#if -897479902 
if(Model.getFacade().isAComponentInstance(objectToAccept))//1
{ 

//#if -9711134 
return true;
//#endif 

} 
else

//#if -2074471199 
if(Model.getFacade().isANode(objectToAccept))//1
{ 

//#if -1304732009 
return true;
//#endif 

} 
else

//#if -252281681 
if(Model.getFacade().isAComponent(objectToAccept))//1
{ 

//#if -572320141 
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


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#if -796797748 
return false;
//#endif 

} 

//#endif 


//#if 1398463678 
public Collection getRelocationCandidates(Object root)
    { 

//#if -2138369393 
return
            Model.getModelManagementHelper().getAllModelElementsOfKindWithModel(
                root, Model.getMetaTypes().getNamespace());
//#endif 

} 

//#endif 


//#if 864321605 
private Action getActionSignal()
    { 

//#if -1277873443 
if(actionSignal == null)//1
{ 

//#if 1538489604 
actionSignal =
                makeCreateNodeAction(Model.getMetaTypes().getSignal(),
                                     "button.new-signal");
//#endif 

} 

//#endif 


//#if 1569996882 
return actionSignal;
//#endif 

} 

//#endif 


//#if -1947001522 
protected Action getActionGeneralization()
    { 

//#if 1910256410 
if(actionGeneralization == null)//1
{ 

//#if -986018912 
actionGeneralization = makeCreateGeneralizationAction();
//#endif 

} 

//#endif 


//#if -2021310937 
return actionGeneralization;
//#endif 

} 

//#endif 


//#if 1302313778 
public UMLClassDiagram(String name, Object namespace)
    { 

//#if 2085524138 
super(name, namespace, new ClassDiagramGraphModel());
//#endif 

} 

//#endif 


//#if -1535622209 
private Object[] getDataTypeActions()
    { 

//#if 1867293808 
Object[] actions = {
            getActionDataType(),
            getActionEnumeration(),
            getActionStereotype(),
            getActionSignal(),
            getActionException(),
        };
//#endif 


//#if -1474374466 
ToolBarUtility.manageDefault(actions, "diagram.class.datatype");
//#endif 


//#if 528586533 
return actions;
//#endif 

} 

//#endif 


//#if 666396952 
private Object[] getDependencyActions()
    { 

//#if 1240780639 
Object[] actions = {
            getActionDependency(),
            getActionPermission(),
            getActionUsage(),
        };
//#endif 


//#if 1689924037 
ToolBarUtility.manageDefault(actions, "diagram.class.dependency");
//#endif 


//#if -1520453993 
return actions;
//#endif 

} 

//#endif 


//#if -1989043396 
public void setNamespace(Object ns)
    { 

//#if -802329236 
if(!Model.getFacade().isANamespace(ns))//1
{ 

//#if -586354448 
LOG.error("Illegal argument. "
                      + "Object " + ns + " is not a namespace");
//#endif 


//#if 1822738830 
throw new IllegalArgumentException("Illegal argument. "
                                               + "Object " + ns
                                               + " is not a namespace");
//#endif 

} 

//#endif 


//#if -678004714 
boolean init = (null == getNamespace());
//#endif 


//#if -780158265 
super.setNamespace(ns);
//#endif 


//#if 1517616905 
ClassDiagramGraphModel gm = (ClassDiagramGraphModel) getGraphModel();
//#endif 


//#if -239846149 
gm.setHomeModel(ns);
//#endif 


//#if 1336672343 
if(init)//1
{ 

//#if -1916563929 
LayerPerspective lay =
                new LayerPerspectiveMutable(Model.getFacade().getName(ns), gm);
//#endif 


//#if -1203587161 
ClassDiagramRenderer rend = new ClassDiagramRenderer();
//#endif 


//#if 987460349 
lay.setGraphNodeRenderer(rend);
//#endif 


//#if 2140595682 
lay.setGraphEdgeRenderer(rend);
//#endif 


//#if 216610472 
setLayer(lay);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -229270036 
protected Action getActionUniComposition()
    { 

//#if 897564790 
if(actionUniComposition == null)//1
{ 

//#if 1771547983 
actionUniComposition =
                makeCreateAssociationAction(
                    Model.getAggregationKind().getComposite(),
                    true,
                    "button.new-unicomposition");
//#endif 

} 

//#endif 


//#if 1612456711 
return actionUniComposition;
//#endif 

} 

//#endif 


//#if 1354067823 
private Object[] getCompositionActions()
    { 

//#if -157812664 
Object[] actions = {
            getActionComposition(),
            getActionUniComposition(),
        };
//#endif 


//#if 592343063 
ToolBarUtility.manageDefault(actions, "diagram.class.composition");
//#endif 


//#if 1336912608 
return actions;
//#endif 

} 

//#endif 


//#if 334894851 
protected Action getActionUniAssociation()
    { 

//#if -2095132777 
if(actionUniAssociation == null)//1
{ 

//#if 1980273532 
actionUniAssociation =
                makeCreateAssociationAction(
                    Model.getAggregationKind().getNone(),
                    true,
                    "button.new-uniassociation");
//#endif 

} 

//#endif 


//#if -1971103846 
return actionUniAssociation;
//#endif 

} 

//#endif 


//#if -212041311 
private Action getActionDataType()
    { 

//#if 1583611839 
if(actionDataType == null)//1
{ 

//#if 269848437 
actionDataType =
                makeCreateNodeAction(Model.getMetaTypes().getDataType(),
                                     "button.new-datatype");
//#endif 

} 

//#endif 


//#if -1708986564 
return actionDataType;
//#endif 

} 

//#endif 


//#if -225653468 
protected Action getActionUniAggregation()
    { 

//#if 1475515613 
if(actionUniAggregation == null)//1
{ 

//#if -1333579821 
actionUniAggregation =
                makeCreateAssociationAction(
                    Model.getAggregationKind().getAggregate(),
                    true,
                    "button.new-uniaggregation");
//#endif 

} 

//#endif 


//#if -2035951298 
return actionUniAggregation;
//#endif 

} 

//#endif 


//#if 794625274 
protected Action getActionComposition()
    { 

//#if 877692798 
if(actionComposition == null)//1
{ 

//#if -2043782923 
actionComposition =
                makeCreateAssociationAction(
                    Model.getAggregationKind().getComposite(),
                    false, "button.new-composition");
//#endif 

} 

//#endif 


//#if 1130542109 
return actionComposition;
//#endif 

} 

//#endif 


//#if -963145386 
protected Action getActionRealization()
    { 

//#if 1867431016 
if(actionRealization == null)//1
{ 

//#if -1081494821 
actionRealization =
                makeCreateEdgeAction(
                    Model.getMetaTypes().getAbstraction(),
                    "button.new-realization");
//#endif 

} 

//#endif 


//#if 1934160719 
return actionRealization;
//#endif 

} 

//#endif 


//#if 615112305 
protected Action getActionUsage()
    { 

//#if 1912425819 
if(actionUsage == null)//1
{ 

//#if -1719471342 
actionUsage = makeCreateDependencyAction(
                              ModeCreateUsage.class,
                              Model.getMetaTypes().getUsage(),
                              "button.new-usage");
//#endif 

} 

//#endif 


//#if 1163765612 
return actionUsage;
//#endif 

} 

//#endif 


//#if 1619882120 
protected Action getActionClass()
    { 

//#if -132164553 
if(actionClass == null)//1
{ 

//#if -1117651657 
actionClass =
                makeCreateNodeAction(Model.getMetaTypes().getUMLClass(),
                                     "button.new-class");
//#endif 

} 

//#endif 


//#if -2089555462 
return actionClass;
//#endif 

} 

//#endif 


//#if 42497757 
@Deprecated
    public UMLClassDiagram()
    { 

//#if -967851896 
super(new ClassDiagramGraphModel());
//#endif 

} 

//#endif 


//#if 85799223 
private Object[] getAggregationActions()
    { 

//#if -372744214 
Object[] actions = {
            getActionAggregation(),
            getActionUniAggregation(),
        };
//#endif 


//#if -841266575 
ToolBarUtility.manageDefault(actions, "diagram.class.aggregation");
//#endif 


//#if -206957966 
return actions;
//#endif 

} 

//#endif 


//#if 723165324 
protected Action getActionLink()
    { 

//#if 362929929 
if(actionLink == null)//1
{ 

//#if -975177816 
actionLink =
                makeCreateEdgeAction(Model.getMetaTypes().getLink(), "Link");
//#endif 

} 

//#endif 


//#if -1941677990 
return actionLink;
//#endif 

} 

//#endif 


//#if -561652104 
private Object[] getAssociationActions()
    { 

//#if -2034262815 
Object[] actions = {
            getActionAssociation(),
            getActionUniAssociation(),
        };
//#endif 


//#if -193669529 
ToolBarUtility.manageDefault(actions, "diagram.class.association");
//#endif 


//#if 1402572007 
return actions;
//#endif 

} 

//#endif 


//#if 1944507471 
private Action getActionStereotype()
    { 

//#if 1187169690 
if(actionStereotype == null)//1
{ 

//#if 137267195 
actionStereotype =
                makeCreateNodeAction(Model.getMetaTypes().getStereotype(),
                                     "button.new-stereotype");
//#endif 

} 

//#endif 


//#if -959902341 
return actionStereotype;
//#endif 

} 

//#endif 


//#if 1141097510 
public UMLClassDiagram(Object m)
    { 

//#if -2089185780 
super("", m, new ClassDiagramGraphModel());
//#endif 


//#if 1445314982 
String name = getNewDiagramName();
//#endif 


//#if 1538628823 
try //1
{ 

//#if -295109915 
setName(name);
//#endif 

} 

//#if 1414759850 
catch (PropertyVetoException pve) //1
{ 

//#if 1047787735 
LOG.warn("Generated diagram name '" + name
                     + "' was vetoed by setName");
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -553273322 
protected Action getActionPackage()
    { 

//#if -840337441 
if(actionPackage == null)//1
{ 

//#if 1276887174 
actionPackage =
                makeCreateNodeAction(Model.getMetaTypes().getPackage(),
                                     "button.new-package");
//#endif 

} 

//#endif 


//#if 2056665350 
return actionPackage;
//#endif 

} 

//#endif 


//#if -1096300993 
protected Action getActionSubsystem()
    { 

//#if 306203278 
if(actionSubsystem == null)//1
{ 

//#if -230686902 
actionSubsystem =
                makeCreateNodeAction(
                    Model.getMetaTypes().getSubsystem(),
                    "Subsystem");
//#endif 

} 

//#endif 


//#if 14812803 
return actionSubsystem;
//#endif 

} 

//#endif 


//#if 1957603465 
protected Action getActionInterface()
    { 

//#if 852449495 
if(actionInterface == null)//1
{ 

//#if 1321176842 
actionInterface =
                makeCreateNodeAction(
                    Model.getMetaTypes().getInterface(),
                    "button.new-interface");
//#endif 

} 

//#endif 


//#if 943649848 
return actionInterface;
//#endif 

} 

//#endif 


//#if 185922101 
private Object getPackageActions()
    { 

//#if 451574411 
if(false)//1
{ 

//#if -811472910 
Object[] actions = {
                getActionPackage(),
                getActionModel(),
                getActionSubsystem(),
            };
//#endif 


//#if 584837548 
ToolBarUtility.manageDefault(actions, "diagram.class.package");
//#endif 


//#if -412316655 
return actions;
//#endif 

} 
else
{ 

//#if -1577367940 
return getActionPackage();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1708964756 
private Action getActionEnumeration()
    { 

//#if 1327038528 
if(actionEnumeration == null)//1
{ 

//#if -492154956 
actionEnumeration =
                makeCreateNodeAction(Model.getMetaTypes().getEnumeration(),
                                     "button.new-enumeration");
//#endif 

} 

//#endif 


//#if -1606348987 
return actionEnumeration;
//#endif 

} 

//#endif 


//#if -2030825100 
private Action getActionException()
    { 

//#if -110777010 
if(actionException == null)//1
{ 

//#if -2113713611 
actionException =
                makeCreateNodeAction(Model.getMetaTypes().getException(),
                                     "button.new-exception");
//#endif 

} 

//#endif 


//#if -1866807933 
return actionException;
//#endif 

} 

//#endif 


//#if -1539489390 
public void encloserChanged(FigNode enclosed, FigNode oldEncloser,
                                FigNode newEncloser)
    { 
} 

//#endif 


//#if 389808303 
@Override
    public FigNode drop(Object droppedObject, Point location)
    { 

//#if -238637940 
FigNode figNode = null;
//#endif 


//#if -569232346 
Rectangle bounds = null;
//#endif 


//#if -789270506 
if(location != null)//1
{ 

//#if -309210359 
bounds = new Rectangle(location.x, location.y, 0, 0);
//#endif 

} 

//#endif 


//#if -168854879 
DiagramSettings settings = getDiagramSettings();
//#endif 


//#if -842389672 
if(Model.getFacade().isAAssociation(droppedObject))//1
{ 

//#if -14563204 
figNode =
                createNaryAssociationNode(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 660569426 
if(Model.getFacade().isAClass(droppedObject))//1
{ 

//#if 1825473123 
figNode = new FigClass(droppedObject, bounds, settings);
//#endif 

} 
else

//#if -675628069 
if(Model.getFacade().isAInterface(droppedObject))//1
{ 

//#if 144473948 
figNode = new FigInterface(droppedObject, bounds, settings);
//#endif 

} 
else

//#if -416071623 
if(Model.getFacade().isAModel(droppedObject))//1
{ 

//#if -81935071 
figNode = new FigModel(droppedObject, bounds, settings);
//#endif 

} 
else

//#if -877869330 
if(Model.getFacade().isASubsystem(droppedObject))//1
{ 

//#if 2063010099 
figNode = new FigSubsystem(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 1474303102 
if(Model.getFacade().isAPackage(droppedObject))//1
{ 

//#if -1832190772 
figNode = new FigPackage(droppedObject, bounds, settings);
//#endif 

} 
else

//#if -1735172862 
if(Model.getFacade().isAComment(droppedObject))//1
{ 

//#if 1006609568 
figNode = new FigComment(droppedObject, bounds, settings);
//#endif 

} 
else

//#if -1047535814 
if(Model.getFacade().isAEnumeration(droppedObject))//1
{ 

//#if 996169809 
figNode = new FigEnumeration(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 1350099993 
if(Model.getFacade().isADataType(droppedObject))//1
{ 

//#if -78973977 
figNode = new FigDataType(droppedObject, bounds, settings);
//#endif 

} 
else

//#if -939289026 
if(Model.getFacade().isAStereotype(droppedObject))//1
{ 

//#if 728238724 
figNode = new FigStereotypeDeclaration(droppedObject, bounds,
                                                   settings);
//#endif 

} 
else

//#if -88953400 
if(Model.getFacade().isAException(droppedObject))//1
{ 

//#if 190506996 
figNode = new FigException(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 434195998 
if(Model.getFacade().isASignal(droppedObject))//1
{ 

//#if 1236202767 
figNode = new FigSignal(droppedObject, bounds, settings);
//#endif 

} 
else

//#if -1211508433 
if(Model.getFacade().isAActor(droppedObject))//1
{ 

//#if 192481191 
figNode = new FigActor(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 831076018 
if(Model.getFacade().isAUseCase(droppedObject))//1
{ 

//#if -1347168455 
figNode = new FigUseCase(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 1785499923 
if(Model.getFacade().isAObject(droppedObject))//1
{ 

//#if 990852513 
figNode = new FigObject(droppedObject, bounds, settings);
//#endif 

} 
else

//#if -641213328 
if(Model.getFacade().isANodeInstance(droppedObject))//1
{ 

//#if -733175726 
figNode = new FigNodeInstance(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 706366941 
if(Model.getFacade().isAComponentInstance(droppedObject))//1
{ 

//#if 1245716464 
figNode = new FigComponentInstance(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 348803086 
if(Model.getFacade().isANode(droppedObject))//1
{ 

//#if -2077077185 
figNode = new FigMNode(droppedObject, bounds, settings);
//#endif 

} 
else

//#if -1583907791 
if(Model.getFacade().isAComponent(droppedObject))//1
{ 

//#if -1349932331 
figNode = new FigComponent(droppedObject, bounds, settings);
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


//#if -1235318053 
if(figNode != null)//1
{ 

//#if -1918117305 
if(location != null)//1
{ 

//#if -704168531 
figNode.setLocation(location.x, location.y);
//#endif 

} 

//#endif 


//#if -1635541969 
LOG.debug("Dropped object " + droppedObject + " converted to "
                      + figNode);
//#endif 

} 
else
{ 

//#if -668591084 
LOG.debug("Dropped object NOT added " + droppedObject);
//#endif 

} 

//#endif 


//#if -1367087238 
return figNode;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

