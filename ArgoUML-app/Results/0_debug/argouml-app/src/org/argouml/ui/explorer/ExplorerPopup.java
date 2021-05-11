
//#if -639097202 
// Compilation Unit of /ExplorerPopup.java 
 

//#if 1809603824 
package org.argouml.ui.explorer;
//#endif 


//#if 424231309 
import java.awt.event.ActionEvent;
//#endif 


//#if 2075136080 
import java.awt.event.MouseEvent;
//#endif 


//#if 486218590 
import java.util.ArrayList;
//#endif 


//#if -767494717 
import java.util.Collection;
//#endif 


//#if -278218893 
import java.util.Iterator;
//#endif 


//#if 1028257859 
import java.util.List;
//#endif 


//#if 1695942259 
import java.util.Set;
//#endif 


//#if 1164456497 
import java.util.TreeSet;
//#endif 


//#if -1820349567 
import javax.swing.AbstractAction;
//#endif 


//#if -2068370429 
import javax.swing.Action;
//#endif 


//#if 862918004 
import javax.swing.JMenu;
//#endif 


//#if 322619425 
import javax.swing.JMenuItem;
//#endif 


//#if 198227384 
import javax.swing.JPopupMenu;
//#endif 


//#if -834742136 
import org.argouml.i18n.Translator;
//#endif 


//#if 170317204 
import org.argouml.kernel.ProfileConfiguration;
//#endif 


//#if 1505065581 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1856202103 
import org.argouml.model.IllegalModelElementConnectionException;
//#endif 


//#if -2007947442 
import org.argouml.model.Model;
//#endif 


//#if 1251703182 
import org.argouml.profile.Profile;
//#endif 


//#if -1246759478 
import org.argouml.ui.ActionCreateContainedModelElement;
//#endif 


//#if -1743038794 
import org.argouml.ui.ActionCreateEdgeModelElement;
//#endif 


//#if 2047955796 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -2120956915 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -652463215 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if -656214458 
import org.argouml.uml.diagram.static_structure.ui.UMLClassDiagram;
//#endif 


//#if 900289790 
import org.argouml.uml.diagram.ui.ActionAddAllClassesFromModel;
//#endif 


//#if -907121514 
import org.argouml.uml.diagram.ui.ActionAddExistingEdge;
//#endif 


//#if -898485007 
import org.argouml.uml.diagram.ui.ActionAddExistingNode;
//#endif 


//#if -2083229646 
import org.argouml.uml.diagram.ui.ActionAddExistingNodes;
//#endif 


//#if -1876666094 
import org.argouml.uml.diagram.ui.ActionSaveDiagramToClipboard;
//#endif 


//#if -1099716301 
import org.argouml.uml.diagram.ui.ModeAddToDiagram;
//#endif 


//#if -1929962751 
import org.argouml.uml.ui.ActionClassDiagram;
//#endif 


//#if -1275918139 
import org.argouml.uml.ui.ActionDeleteModelElements;
//#endif 


//#if 992900120 
import org.argouml.uml.ui.ActionSetSourcePath;
//#endif 


//#if -520265345 
import org.tigris.gef.base.Diagram;
//#endif 


//#if -373030441 
import org.tigris.gef.base.Editor;
//#endif 


//#if -823563070 
import org.tigris.gef.base.Globals;
//#endif 


//#if 835268730 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -1465623168 
import org.tigris.gef.graph.MutableGraphModel;
//#endif 


//#if -1483363549 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 439483355 
import org.apache.log4j.Logger;
//#endif 


//#if -1281269180 
import org.argouml.uml.diagram.sequence.ui.UMLSequenceDiagram;
//#endif 


//#if -1607044682 
import org.argouml.uml.diagram.state.ui.UMLStateDiagram;
//#endif 


//#if 75570638 
import org.argouml.uml.ui.ActionCollaborationDiagram;
//#endif 


//#if 765129900 
import org.argouml.uml.ui.ActionDeploymentDiagram;
//#endif 


//#if 1878796648 
import org.argouml.uml.ui.ActionSequenceDiagram;
//#endif 


//#if -1958736614 
import org.argouml.uml.ui.ActionStateDiagram;
//#endif 


//#if -1949542496 
import org.argouml.uml.ui.ActionUseCaseDiagram;
//#endif 


//#if -124822396 
import org.argouml.uml.diagram.activity.ui.UMLActivityDiagram;
//#endif 


//#if -1073318218 
import org.argouml.uml.ui.ActionActivityDiagram;
//#endif 


//#if -1525848461 
public class ExplorerPopup extends 
//#if -1147746296 
JPopupMenu
//#endif 

  { 

//#if -1452255041 
private JMenu createDiagrams =
        new JMenu(menuLocalize("menu.popup.create-diagram"));
//#endif 


//#if -462913442 
private static final Object[] MODEL_ELEMENT_MENUITEMS =
        new Object[] {
        Model.getMetaTypes().getPackage(),
        "button.new-package",
        Model.getMetaTypes().getActor(),
        "button.new-actor",





        Model.getMetaTypes().getExtensionPoint(),
        "button.new-extension-point",
        Model.getMetaTypes().getUMLClass(),
        "button.new-class",
        Model.getMetaTypes().getInterface(),
        "button.new-interface",
        Model.getMetaTypes().getAttribute(),
        "button.new-attribute",
        Model.getMetaTypes().getOperation(),
        "button.new-operation",
        Model.getMetaTypes().getDataType(),
        "button.new-datatype",
        Model.getMetaTypes().getEnumeration(),
        "button.new-enumeration",
        Model.getMetaTypes().getEnumerationLiteral(),
        "button.new-enumeration-literal",
        Model.getMetaTypes().getSignal(),
        "button.new-signal",
        Model.getMetaTypes().getException(),
        "button.new-exception",
        Model.getMetaTypes().getComponent(),
        "button.new-component",
        Model.getMetaTypes().getComponentInstance(),
        "button.new-componentinstance",
        Model.getMetaTypes().getNode(),
        "button.new-node",
        Model.getMetaTypes().getNodeInstance(),
        "button.new-nodeinstance",
        Model.getMetaTypes().getReception(),
        "button.new-reception",
        Model.getMetaTypes().getStereotype(),
        "button.new-stereotype"
    };
//#endif 


//#if 1495652444 
private static final long serialVersionUID = -5663884871599931780L;
//#endif 


//#if -1905591074 
private static final Logger LOG =
        Logger.getLogger(ExplorerPopup.class);
//#endif 


//#if -97506812 
private static final Object[] MODEL_ELEMENT_MENUITEMS =
        new Object[] {
        Model.getMetaTypes().getPackage(),
        "button.new-package",
        Model.getMetaTypes().getActor(),
        "button.new-actor",


        Model.getMetaTypes().getUseCase(),
        "button.new-usecase",

        Model.getMetaTypes().getExtensionPoint(),
        "button.new-extension-point",
        Model.getMetaTypes().getUMLClass(),
        "button.new-class",
        Model.getMetaTypes().getInterface(),
        "button.new-interface",
        Model.getMetaTypes().getAttribute(),
        "button.new-attribute",
        Model.getMetaTypes().getOperation(),
        "button.new-operation",
        Model.getMetaTypes().getDataType(),
        "button.new-datatype",
        Model.getMetaTypes().getEnumeration(),
        "button.new-enumeration",
        Model.getMetaTypes().getEnumerationLiteral(),
        "button.new-enumeration-literal",
        Model.getMetaTypes().getSignal(),
        "button.new-signal",
        Model.getMetaTypes().getException(),
        "button.new-exception",
        Model.getMetaTypes().getComponent(),
        "button.new-component",
        Model.getMetaTypes().getComponentInstance(),
        "button.new-componentinstance",
        Model.getMetaTypes().getNode(),
        "button.new-node",
        Model.getMetaTypes().getNodeInstance(),
        "button.new-nodeinstance",
        Model.getMetaTypes().getReception(),
        "button.new-reception",
        Model.getMetaTypes().getStereotype(),
        "button.new-stereotype"
    };
//#endif 


//#if 488643259 
private void addMenuItemForBothEndsOf(Object edge)
    { 

//#if -1198128277 
Collection coll = null;
//#endif 


//#if -616241014 
if(Model.getFacade().isAAssociation(edge)
                || Model.getFacade().isALink(edge))//1
{ 

//#if 9135435 
coll = Model.getFacade().getConnections(edge);
//#endif 

} 
else

//#if -1188251874 
if(Model.getFacade().isAAbstraction(edge)
                   || Model.getFacade().isADependency(edge))//1
{ 

//#if -1417285112 
coll = new ArrayList();
//#endif 


//#if 58024614 
coll.addAll(Model.getFacade().getClients(edge));
//#endif 


//#if -1074181179 
coll.addAll(Model.getFacade().getSuppliers(edge));
//#endif 

} 
else

//#if -188037146 
if(Model.getFacade().isAGeneralization(edge))//1
{ 

//#if -1081039441 
coll = new ArrayList();
//#endif 


//#if 97588108 
Object parent = Model.getFacade().getGeneral(edge);
//#endif 


//#if 1313685352 
coll.add(parent);
//#endif 


//#if 771660601 
coll.addAll(Model.getFacade().getChildren(parent));
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#if -1435107332 
if(coll == null)//1
{ 

//#if 1397349833 
return;
//#endif 

} 

//#endif 


//#if -1242064137 
Iterator iter = coll.iterator();
//#endif 


//#if 1528579521 
while (iter.hasNext()) //1
{ 

//#if 1703126871 
Object me = iter.next();
//#endif 


//#if 1734863182 
if(me != null)//1
{ 

//#if 239977357 
if(Model.getFacade().isAAssociationEnd(me))//1
{ 

//#if 839287796 
me = Model.getFacade().getType(me);
//#endif 

} 

//#endif 


//#if -1568808842 
if(me != null)//1
{ 

//#if 1484999139 
String name = Model.getFacade().getName(me);
//#endif 


//#if -1648790566 
if(name == null || name.length() == 0)//1
{ 

//#if 1883883075 
name = "(anon element)";
//#endif 

} 

//#endif 


//#if -1442013135 
Action action =
                        new ActionAddExistingRelatedNode(
                        menuLocalize("menu.popup.add-to-diagram") + ": "
                        + name,
                        me);
//#endif 


//#if 1845210350 
this.add(action);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1604658610 
private String menuLocalize(String key)
    { 

//#if 883079993 
return Translator.localize(key);
//#endif 

} 

//#endif 


//#if -1135170906 
private void addCreateModelElementAction(
        Set<JMenuItem> menuItems,
        Object metaType,
        String relationshipDescr)
    { 

//#if 104876275 
List targets = TargetManager.getInstance().getTargets();
//#endif 


//#if -1911531153 
Object source = targets.get(0);
//#endif 


//#if 925566199 
Object dest = targets.get(1);
//#endif 


//#if -587003558 
JMenu subMenu = new OrderedMenu(
            menuLocalize("menu.popup.create") + " "
            + Model.getMetaTypes().getName(metaType));
//#endif 


//#if 1611394218 
buildDirectionalCreateMenuItem(
            metaType, dest, source, relationshipDescr, subMenu);
//#endif 


//#if 1610004184 
buildDirectionalCreateMenuItem(
            metaType, source, dest, relationshipDescr, subMenu);
//#endif 


//#if 1264304910 
if(subMenu.getMenuComponents().length > 0)//1
{ 

//#if 1655289528 
menuItems.add(subMenu);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2070738190 
private void buildDirectionalCreateMenuItem(
        Object metaType,
        Object source,
        Object dest,
        String relationshipDescr,
        JMenu menu)
    { 

//#if 1892850862 
if(Model.getUmlFactory().isConnectionValid(
                    metaType, source, dest, true))//1
{ 

//#if -22832437 
JMenuItem menuItem = new JMenuItem(
                new ActionCreateEdgeModelElement(
                    metaType,
                    source,
                    dest,
                    relationshipDescr));
//#endif 


//#if 1663196050 
if(menuItem != null)//1
{ 

//#if -189762066 
menu.add(menuItem);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -34772164 
private void initMenuCreateDiagrams()
    { 

//#if 731177859 
createDiagrams.add(new ActionUseCaseDiagram());
//#endif 


//#if 659757506 
createDiagrams.add(new ActionClassDiagram());
//#endif 


//#if -2135492303 
createDiagrams.add(new ActionSequenceDiagram());
//#endif 


//#if -2086411563 
createDiagrams.add(new ActionCollaborationDiagram());
//#endif 


//#if -1843903223 
createDiagrams.add(new ActionStateDiagram());
//#endif 


//#if -544145117 
createDiagrams.add(new ActionActivityDiagram());
//#endif 


//#if -1700953939 
createDiagrams.add(new ActionDeploymentDiagram());
//#endif 

} 

//#endif 


//#if -1316687032 
public ExplorerPopup(Object selectedItem, MouseEvent me)
    { 

//#if -2007539810 
super("Explorer popup menu");
//#endif 


//#if 677547178 
boolean multiSelect =
            TargetManager.getInstance().getTargets().size() > 1;
//#endif 


//#if 1568195295 
boolean mutableModelElementsOnly = true;
//#endif 


//#if -2110967612 
for (Object element : TargetManager.getInstance().getTargets()) //1
{ 

//#if -33953440 
if(!Model.getFacade().isAUMLElement(element)
                    || Model.getModelManagementHelper().isReadOnly(element))//1
{ 

//#if 1702827649 
mutableModelElementsOnly = false;
//#endif 


//#if 1572432650 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 59789734 
final ArgoDiagram activeDiagram = DiagramUtils.getActiveDiagram();
//#endif 


//#if -1798707218 
if(!multiSelect && mutableModelElementsOnly)//1
{ 

//#if 215299845 
initMenuCreateDiagrams();
//#endif 


//#if 452335451 
this.add(createDiagrams);
//#endif 

} 

//#endif 


//#if 2020033653 
try //1
{ 

//#if 1179590720 
if(!multiSelect && selectedItem instanceof Profile
                    && !((Profile) selectedItem).getProfilePackages().isEmpty())//1
{ 

//#if -2023806845 
this.add(new ActionExportProfileXMI((Profile) selectedItem));
//#endif 

} 

//#endif 

} 

//#if -1035098261 
catch (Exception e) //1
{ 
} 

//#endif 


//#endif 


//#if -16453681 
if(!multiSelect && selectedItem instanceof ProfileConfiguration)//1
{ 

//#if -814449027 
this.add(new ActionManageProfiles());
//#endif 

} 

//#endif 


//#if 1353886298 
if(mutableModelElementsOnly)//1
{ 

//#if -841426742 
initMenuCreateModelElements();
//#endif 

} 

//#endif 


//#if 1302494953 
final boolean modelElementSelected =
            Model.getFacade().isAUMLElement(selectedItem);
//#endif 


//#if -1061677278 
if(modelElementSelected)//1
{ 

//#if -1004023243 
final boolean nAryAssociationSelected =
                Model.getFacade().isANaryAssociation(selectedItem);
//#endif 


//#if 870047469 
final boolean classifierSelected =
                Model.getFacade().isAClassifier(selectedItem);
//#endif 


//#if -910075723 
final boolean packageSelected =
                Model.getFacade().isAPackage(selectedItem);
//#endif 


//#if -1008264939 
final boolean commentSelected =
                Model.getFacade().isAComment(selectedItem);
//#endif 


//#if -1802360491 
final boolean stateVertexSelected =
                Model.getFacade().isAStateVertex(selectedItem);
//#endif 


//#if 1762341893 
final boolean instanceSelected =
                Model.getFacade().isAInstance(selectedItem);
//#endif 


//#if 511832213 
final boolean dataValueSelected =
                Model.getFacade().isADataValue(selectedItem);
//#endif 


//#if -834074177 
final boolean relationshipSelected =
                Model.getFacade().isARelationship(selectedItem);
//#endif 


//#if 1500226771 
final boolean flowSelected =
                Model.getFacade().isAFlow(selectedItem);
//#endif 


//#if 680228667 
final boolean linkSelected =
                Model.getFacade().isALink(selectedItem);
//#endif 


//#if -1177591931 
final boolean transitionSelected =
                Model.getFacade().isATransition(selectedItem);
//#endif 


//#if 1254377963 
final boolean activityDiagramActive =
                activeDiagram instanceof UMLActivityDiagram;
//#endif 


//#if 1735443279 
final boolean sequenceDiagramActive =
                activeDiagram instanceof UMLSequenceDiagram;
//#endif 


//#if -1361739249 
final boolean stateDiagramActive =
                activeDiagram instanceof UMLStateDiagram;
//#endif 


//#if 1583785743 
final Object selectedStateMachine =
                (stateVertexSelected) ? Model
                .getStateMachinesHelper().getStateMachine(selectedItem)
                : null;
//#endif 


//#if 1595959481 
final Object diagramStateMachine =
                (stateDiagramActive) ? ((UMLStateDiagram) activeDiagram)
                .getStateMachine()
                : null;
//#endif 


//#if 2100329786 
final Object diagramActivity =
                (activityDiagramActive)
                ? ((UMLActivityDiagram) activeDiagram).getStateMachine()
                : null;
//#endif 


//#if 20648953 
Collection projectModels =
                ProjectManager.getManager().getCurrentProject().getModels();
//#endif 


//#if 286090163 
if(!multiSelect)//1
{ 

//#if 1321333834 
if((classifierSelected && !relationshipSelected)
                        || (packageSelected
                            // TODO: Allow adding models to a diagram - issue 4172.
                            && !projectModels.contains(selectedItem))












                        || (stateVertexSelected






                           )
                        || (instanceSelected
                            && !dataValueSelected





                           )
                        || nAryAssociationSelected || commentSelected)//1
{ 

//#if 418020529 
Action action =
                        new ActionAddExistingNode(
                        menuLocalize("menu.popup.add-to-diagram"),
                        selectedItem);
//#endif 


//#if -40555658 
this.add(action);
//#endif 

} 

//#endif 


//#if 1415402880 
if((classifierSelected && !relationshipSelected)
                        || (packageSelected
                            // TODO: Allow adding models to a diagram - issue 4172.
                            && !projectModels.contains(selectedItem))



                        || (stateVertexSelected
                            && activityDiagramActive



                            && diagramActivity == selectedStateMachine

                           )

                        || (stateVertexSelected



                            && stateDiagramActive
                            && diagramStateMachine == selectedStateMachine

                           )
                        || (instanceSelected
                            && !dataValueSelected





                           )
                        || nAryAssociationSelected || commentSelected)//1
{ 

//#if 1901016342 
Action action =
                        new ActionAddExistingNode(
                        menuLocalize("menu.popup.add-to-diagram"),
                        selectedItem);
//#endif 


//#if 1749879537 
this.add(action);
//#endif 

} 

//#endif 


//#if -2050963348 
if((relationshipSelected
                        && !flowSelected
                        && !nAryAssociationSelected)
                        || (linkSelected





                           )
                        || transitionSelected)//1
{ 

//#if -1585538695 
Action action =
                        new ActionAddExistingEdge(
                        menuLocalize("menu.popup.add-to-diagram"),
                        selectedItem);
//#endif 


//#if 1392049779 
this.add(action);
//#endif 


//#if -159275626 
addMenuItemForBothEndsOf(selectedItem);
//#endif 

} 

//#endif 


//#if 1491945567 
if((classifierSelected && !relationshipSelected)
                        || (packageSelected
                            // TODO: Allow adding models to a diagram - issue 4172.
                            && !projectModels.contains(selectedItem))












                        || (stateVertexSelected



                            && stateDiagramActive
                            && diagramStateMachine == selectedStateMachine

                           )
                        || (instanceSelected
                            && !dataValueSelected



                            && !sequenceDiagramActive

                           )
                        || nAryAssociationSelected || commentSelected)//1
{ 

//#if -892396876 
Action action =
                        new ActionAddExistingNode(
                        menuLocalize("menu.popup.add-to-diagram"),
                        selectedItem);
//#endif 


//#if -898601837 
this.add(action);
//#endif 

} 

//#endif 


//#if -2049455895 
if((classifierSelected && !relationshipSelected)
                        || (packageSelected
                            // TODO: Allow adding models to a diagram - issue 4172.
                            && !projectModels.contains(selectedItem))



                        || (stateVertexSelected
                            && activityDiagramActive



                            && diagramActivity == selectedStateMachine

                           )

                        || (stateVertexSelected



                            && stateDiagramActive
                            && diagramStateMachine == selectedStateMachine

                           )
                        || (instanceSelected
                            && !dataValueSelected



                            && !sequenceDiagramActive

                           )
                        || nAryAssociationSelected || commentSelected)//1
{ 

//#if -1154631691 
Action action =
                        new ActionAddExistingNode(
                        menuLocalize("menu.popup.add-to-diagram"),
                        selectedItem);
//#endif 


//#if -80817742 
this.add(action);
//#endif 

} 

//#endif 


//#if -1479345812 
if((classifierSelected && !relationshipSelected)
                        || (packageSelected
                            // TODO: Allow adding models to a diagram - issue 4172.
                            && !projectModels.contains(selectedItem))



                        || (stateVertexSelected
                            && activityDiagramActive





                           )

                        || (stateVertexSelected






                           )
                        || (instanceSelected
                            && !dataValueSelected



                            && !sequenceDiagramActive

                           )
                        || nAryAssociationSelected || commentSelected)//1
{ 

//#if 1653645150 
Action action =
                        new ActionAddExistingNode(
                        menuLocalize("menu.popup.add-to-diagram"),
                        selectedItem);
//#endif 


//#if -1056552023 
this.add(action);
//#endif 

} 

//#endif 


//#if 406459541 
if((relationshipSelected
                        && !flowSelected
                        && !nAryAssociationSelected)
                        || (linkSelected



                            && !sequenceDiagramActive

                           )
                        || transitionSelected)//1
{ 

//#if 1645058079 
Action action =
                        new ActionAddExistingEdge(
                        menuLocalize("menu.popup.add-to-diagram"),
                        selectedItem);
//#endif 


//#if -786630131 
this.add(action);
//#endif 


//#if 729649584 
addMenuItemForBothEndsOf(selectedItem);
//#endif 

} 

//#endif 


//#if 1444570556 
if(classifierSelected
                        || packageSelected)//1
{ 

//#if -1133917343 
this.add(new ActionSetSourcePath());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1466780656 
if(mutableModelElementsOnly
                    // Can't delete last top level model
                    && !(projectModels.size() == 1
                         && projectModels.contains(selectedItem)))//1
{ 

//#if 1414704752 
this.add(new ActionDeleteModelElements());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -441710168 
if(!multiSelect)//1
{ 

//#if 1613225650 
if(selectedItem instanceof UMLClassDiagram)//1
{ 

//#if -738301569 
Action action =
                    new ActionAddAllClassesFromModel(
                    menuLocalize("menu.popup.add-all-classes-to-diagram"),
                    selectedItem);
//#endif 


//#if 1697347230 
this.add(action);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1819415505 
if(multiSelect)//1
{ 

//#if -1532848459 
List<Object> classifiers = new ArrayList<Object>();
//#endif 


//#if 2114855121 
for (Object o : TargetManager.getInstance().getTargets()) //1
{ 

//#if -883894728 
if(Model.getFacade().isAClassifier(o)
                        && !Model.getFacade().isARelationship(o))//1
{ 

//#if 742573403 
classifiers.add(o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -503698437 
if(!classifiers.isEmpty())//1
{ 

//#if -1605008627 
Action action =
                    new ActionAddExistingNodes(
                    menuLocalize("menu.popup.add-to-diagram"),
                    classifiers);
//#endif 


//#if -1570946033 
this.add(action);
//#endif 

} 

//#endif 

} 
else

//#if 1814490791 
if(selectedItem instanceof Diagram)//1
{ 

//#if -240035452 
this.add(new ActionSaveDiagramToClipboard());
//#endif 


//#if 2026300051 
ActionDeleteModelElements ad = new ActionDeleteModelElements();
//#endif 


//#if -220345634 
ad.setEnabled(ad.shouldBeEnabled());
//#endif 


//#if 435151039 
this.add(ad);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 300633318 
private void initMenuCreateModelElements()
    { 

//#if -1602775552 
List targets = TargetManager.getInstance().getTargets();
//#endif 


//#if 571176761 
Set<JMenuItem> menuItems = new TreeSet<JMenuItem>();
//#endif 


//#if -755285533 
if(targets.size() >= 2)//1
{ 

//#if 657130785 
boolean classifierRoleFound = false;
//#endif 


//#if 1201777473 
boolean classifierRolesOnly = true;
//#endif 


//#if -433525614 
for (Iterator it = targets.iterator();
                    it.hasNext() && classifierRolesOnly; ) //1
{ 

//#if 1873244976 
if(Model.getFacade().isAClassifierRole(it.next()))//1
{ 

//#if 614396348 
classifierRoleFound = true;
//#endif 

} 
else
{ 

//#if 6483464 
classifierRolesOnly = false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1652082006 
if(classifierRolesOnly)//1
{ 

//#if -2070302756 
menuItems.add(new OrderedMenuItem(
                                  new ActionCreateAssociationRole(
                                      Model.getMetaTypes().getAssociationRole(),
                                      targets)));
//#endif 

} 
else

//#if 1959932527 
if(!classifierRoleFound)//1
{ 

//#if 1852172458 
boolean classifiersOnly = true;
//#endif 


//#if -1214512241 
for (Iterator it = targets.iterator();
                        it.hasNext() && classifiersOnly; ) //1
{ 

//#if -396828541 
if(!Model.getFacade().isAClassifier(it.next()))//1
{ 

//#if 1859135894 
classifiersOnly = false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1767112959 
if(classifiersOnly)//1
{ 

//#if -199893881 
menuItems.add(new OrderedMenuItem(
                                      new ActionCreateAssociation(
                                          Model.getMetaTypes().getAssociation(),
                                          targets)));
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1642789214 
if(targets.size() == 2)//1
{ 

//#if 2128667213 
addCreateModelElementAction(
                menuItems,
                Model.getMetaTypes().getDependency(),
                " " + menuLocalize("menu.popup.depends-on") + " ");
//#endif 


//#if -974611294 
addCreateModelElementAction(
                menuItems,
                Model.getMetaTypes().getGeneralization(),
                " " + menuLocalize("menu.popup.generalizes") + " ");
//#endif 


//#if -768954492 
addCreateModelElementAction(
                menuItems,
                Model.getMetaTypes().getInclude(),
                " " + menuLocalize("menu.popup.includes") + " ");
//#endif 


//#if -260057102 
addCreateModelElementAction(
                menuItems,
                Model.getMetaTypes().getExtend(),
                " " + menuLocalize("menu.popup.extends") + " ");
//#endif 


//#if -1190687824 
addCreateModelElementAction(
                menuItems,
                Model.getMetaTypes().getPackageImport(),
                " " + menuLocalize("menu.popup.has-permission-on") + " ");
//#endif 


//#if -577044580 
addCreateModelElementAction(
                menuItems,
                Model.getMetaTypes().getUsage(),
                " " + menuLocalize("menu.popup.uses") + " ");
//#endif 


//#if 1957940048 
addCreateModelElementAction(
                menuItems,
                Model.getMetaTypes().getAbstraction(),
                " " + menuLocalize("menu.popup.realizes") + " ");
//#endif 

} 
else

//#if -813637555 
if(targets.size() == 1)//1
{ 

//#if 529467547 
Object target = targets.get(0);
//#endif 


//#if -723864255 
for (int iter = 0; iter < MODEL_ELEMENT_MENUITEMS.length;
                    iter += 2) //1
{ 

//#if 369828594 
if(Model.getUmlFactory().isContainmentValid(
                            MODEL_ELEMENT_MENUITEMS[iter], target))//1
{ 

//#if 718672451 
menuItems.add(new OrderedMenuItem(
                                      new ActionCreateContainedModelElement(
                                          MODEL_ELEMENT_MENUITEMS[iter],
                                          target,
                                          (String)
                                          MODEL_ELEMENT_MENUITEMS[iter + 1])));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#endif 


//#if 831409152 
if(menuItems.size() == 1)//1
{ 

//#if -527246425 
add(menuItems.iterator().next());
//#endif 

} 
else

//#if 598520878 
if(menuItems.size() > 1)//1
{ 

//#if -285815191 
JMenu menu =
                new JMenu(menuLocalize("menu.popup.create-model-element"));
//#endif 


//#if -1154120356 
add(menu);
//#endif 


//#if -1789544069 
for (JMenuItem item : menuItems) //1
{ 

//#if -15134901 
menu.add(item);
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 347549667 
private class OrderedMenuItem extends 
//#if -676539991 
JMenuItem
//#endif 

 implements 
//#if -1443884947 
Comparable
//#endif 

  { 

//#if -280954152 
public OrderedMenuItem(Action action)
        { 

//#if 1473010657 
super(action);
//#endif 

} 

//#endif 


//#if 2094955380 
public int compareTo(Object o)
        { 

//#if 1611026769 
JMenuItem other = (JMenuItem) o;
//#endif 


//#if -1065500003 
return toString().compareTo(other.toString());
//#endif 

} 

//#endif 


//#if 917560680 
public OrderedMenuItem(String name)
        { 

//#if 1046124787 
super(name);
//#endif 


//#if 958525409 
setName(name);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 792503465 
private class ActionCreateAssociationRole extends 
//#if -1123411613 
AbstractAction
//#endif 

  { 

//#if 1525282341 
private Object metaType;
//#endif 


//#if 917380853 
private List classifierRoles;
//#endif 


//#if -978845345 
public ActionCreateAssociationRole(
            Object theMetaType,
            List classifierRolesList)
        { 

//#if 172099950 
super(menuLocalize("menu.popup.create") + " "
                  + Model.getMetaTypes().getName(theMetaType));
//#endif 


//#if 2100399760 
this.metaType = theMetaType;
//#endif 


//#if 1433082459 
this.classifierRoles = classifierRolesList;
//#endif 

} 

//#endif 


//#if -709961086 
public void actionPerformed(ActionEvent e)
        { 

//#if -132639617 
try //1
{ 

//#if 1660850705 
Object newElement = Model.getUmlFactory().buildConnection(
                                        metaType,
                                        classifierRoles.get(0),
                                        null,
                                        classifierRoles.get(1),
                                        null,
                                        null,
                                        null);
//#endif 


//#if 2083333009 
for (int i = 2; i < classifierRoles.size(); ++i) //1
{ 

//#if -453856235 
Model.getUmlFactory().buildConnection(
                        Model.getMetaTypes().getAssociationEndRole(),
                        newElement,
                        null,
                        classifierRoles.get(i),
                        null,
                        null,
                        null);
//#endif 

} 

//#endif 

} 

//#if 1978834380 
catch (IllegalModelElementConnectionException e1) //1
{ 

//#if 1905744748 
LOG.error("Exception", e1);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#if 957024499 
private class ActionAddExistingRelatedNode extends 
//#if -1130574735 
UndoableAction
//#endif 

  { 

//#if 764617335 
private Object object;
//#endif 


//#if 516259198 
public ActionAddExistingRelatedNode(String name, Object o)
        { 

//#if 1176984683 
super(name);
//#endif 


//#if -1291666039 
object = o;
//#endif 

} 

//#endif 


//#if -1395739914 
public boolean isEnabled()
        { 

//#if 1519175587 
ArgoDiagram dia = DiagramUtils.getActiveDiagram();
//#endif 


//#if 2134680907 
if(dia == null)//1
{ 

//#if -577297198 
return false;
//#endif 

} 

//#endif 


//#if 1829191018 
MutableGraphModel gm = (MutableGraphModel) dia.getGraphModel();
//#endif 


//#if -492132615 
return gm.canAddNode(object);
//#endif 

} 

//#endif 


//#if -452964455 
public void actionPerformed(ActionEvent ae)
        { 

//#if 1336619099 
super.actionPerformed(ae);
//#endif 


//#if -479277755 
Editor ce = Globals.curEditor();
//#endif 


//#if -1933225363 
GraphModel gm = ce.getGraphModel();
//#endif 


//#if 1386513824 
if(!(gm instanceof MutableGraphModel))//1
{ 

//#if 263733838 
return;
//#endif 

} 

//#endif 


//#if -1979406975 
String instructions = null;
//#endif 


//#if -1909000127 
if(object != null)//1
{ 

//#if 1119431063 
instructions =
                    Translator.localize(
                        "misc.message.click-on-diagram-to-add",
                        new Object[] {
                            Model.getFacade().toString(object),
                        });
//#endif 


//#if 828236474 
Globals.showStatus(instructions);
//#endif 

} 

//#endif 


//#if -1958194487 
ArrayList<Object> elementsToAdd = new ArrayList<Object>(1);
//#endif 


//#if 1341516459 
elementsToAdd.add(object);
//#endif 


//#if 482339633 
final ModeAddToDiagram placeMode =
                new ModeAddToDiagram(elementsToAdd, instructions);
//#endif 


//#if -202063680 
Globals.mode(placeMode, false);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 2008986003 
private class ActionCreateAssociation extends 
//#if -1733980230 
AbstractAction
//#endif 

  { 

//#if 1508975996 
private Object metaType;
//#endif 


//#if -46127384 
private List classifiers;
//#endif 


//#if 2074043403 
public void actionPerformed(ActionEvent e)
        { 

//#if -222004404 
try //1
{ 

//#if 2082980935 
Object newElement = Model.getUmlFactory().buildConnection(
                                        metaType,
                                        classifiers.get(0),
                                        null,
                                        classifiers.get(1),
                                        null,
                                        null,
                                        null);
//#endif 


//#if -1781761403 
for (int i = 2; i < classifiers.size(); ++i) //1
{ 

//#if 57401744 
Model.getUmlFactory().buildConnection(
                        Model.getMetaTypes().getAssociationEnd(),
                        newElement,
                        null,
                        classifiers.get(i),
                        null,
                        null,
                        null);
//#endif 

} 

//#endif 

} 

//#if -520121678 
catch (IllegalModelElementConnectionException e1) //1
{ 

//#if -1920890968 
LOG.error("Exception", e1);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 731377846 
public ActionCreateAssociation(
            Object theMetaType,
            List classifiersList)
        { 

//#if -768914906 
super(menuLocalize("menu.popup.create") + " "
                  + Model.getMetaTypes().getName(theMetaType));
//#endif 


//#if 673018696 
this.metaType = theMetaType;
//#endif 


//#if 2127258103 
this.classifiers = classifiersList;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1867507536 
private class OrderedMenu extends 
//#if 547391352 
JMenu
//#endif 

 implements 
//#if -23132245 
Comparable
//#endif 

  { 

//#if 1608674999 
public OrderedMenu(String name)
        { 

//#if -468673746 
super(name);
//#endif 

} 

//#endif 


//#if -1234098186 
public int compareTo(Object o)
        { 

//#if -1712267024 
JMenuItem other = (JMenuItem) o;
//#endif 


//#if -339835682 
return toString().compareTo(other.toString());
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

