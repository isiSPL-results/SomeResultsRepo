package org.argouml.ui.explorer;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import org.argouml.i18n.Translator;
import org.argouml.kernel.ProfileConfiguration;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.IllegalModelElementConnectionException;
import org.argouml.model.Model;
import org.argouml.profile.Profile;
import org.argouml.ui.ActionCreateContainedModelElement;
import org.argouml.ui.ActionCreateEdgeModelElement;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramUtils;
import org.argouml.uml.diagram.static_structure.ui.UMLClassDiagram;
import org.argouml.uml.diagram.ui.ActionAddAllClassesFromModel;
import org.argouml.uml.diagram.ui.ActionAddExistingEdge;
import org.argouml.uml.diagram.ui.ActionAddExistingNode;
import org.argouml.uml.diagram.ui.ActionAddExistingNodes;
import org.argouml.uml.diagram.ui.ActionSaveDiagramToClipboard;
import org.argouml.uml.diagram.ui.ModeAddToDiagram;
import org.argouml.uml.ui.ActionClassDiagram;
import org.argouml.uml.ui.ActionDeleteModelElements;
import org.argouml.uml.ui.ActionSetSourcePath;
import org.tigris.gef.base.Diagram;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.graph.MutableGraphModel;
import org.tigris.gef.undo.UndoableAction;
import org.apache.log4j.Logger;
import org.argouml.uml.diagram.state.ui.UMLStateDiagram;
import org.argouml.uml.ui.ActionCollaborationDiagram;
import org.argouml.uml.ui.ActionDeploymentDiagram;
import org.argouml.uml.ui.ActionStateDiagram;
import org.argouml.uml.ui.ActionUseCaseDiagram;
import org.argouml.uml.diagram.activity.ui.UMLActivityDiagram;
import org.argouml.uml.ui.ActionActivityDiagram;
public class ExplorerPopup extends JPopupMenu
  { 
private JMenu createDiagrams =
        new JMenu(menuLocalize("menu.popup.create-diagram"));
private static final long serialVersionUID = -5663884871599931780L;
private static final Logger LOG =
        Logger.getLogger(ExplorerPopup.class);
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
private void addMenuItemForBothEndsOf(Object edge)
    { 
Collection coll = null;
if(Model.getFacade().isAAssociation(edge)
                || Model.getFacade().isALink(edge))//1
{ 
coll = Model.getFacade().getConnections(edge);
} 
else
if(Model.getFacade().isAAbstraction(edge)
                   || Model.getFacade().isADependency(edge))//1
{ 
coll = new ArrayList();
coll.addAll(Model.getFacade().getClients(edge));
coll.addAll(Model.getFacade().getSuppliers(edge));
} 
else
if(Model.getFacade().isAGeneralization(edge))//1
{ 
coll = new ArrayList();
Object parent = Model.getFacade().getGeneral(edge);
coll.add(parent);
coll.addAll(Model.getFacade().getChildren(parent));
} 
if(coll == null)//1
{ 
return;
} 
Iterator iter = coll.iterator();
while (iter.hasNext()) //1
{ 
Object me = iter.next();
if(me != null)//1
{ 
if(Model.getFacade().isAAssociationEnd(me))//1
{ 
me = Model.getFacade().getType(me);
} 
if(me != null)//1
{ 
String name = Model.getFacade().getName(me);
if(name == null || name.length() == 0)//1
{ 
name = "(anon element)";
} 
Action action =
                        new ActionAddExistingRelatedNode(
                        menuLocalize("menu.popup.add-to-diagram") + ": "
                        + name,
                        me);
this.add(action);
} 
} 
} 
} 
private String menuLocalize(String key)
    { 
return Translator.localize(key);
} 
private void addCreateModelElementAction(
        Set<JMenuItem> menuItems,
        Object metaType,
        String relationshipDescr)
    { 
List targets = TargetManager.getInstance().getTargets();
Object source = targets.get(0);
Object dest = targets.get(1);
JMenu subMenu = new OrderedMenu(
            menuLocalize("menu.popup.create") + " "
            + Model.getMetaTypes().getName(metaType));
buildDirectionalCreateMenuItem(
            metaType, dest, source, relationshipDescr, subMenu);
buildDirectionalCreateMenuItem(
            metaType, source, dest, relationshipDescr, subMenu);
if(subMenu.getMenuComponents().length > 0)//1
{ 
menuItems.add(subMenu);
} 
} 
private void buildDirectionalCreateMenuItem(
        Object metaType,
        Object source,
        Object dest,
        String relationshipDescr,
        JMenu menu)
    { 
if(Model.getUmlFactory().isConnectionValid(
                    metaType, source, dest, true))//1
{ 
JMenuItem menuItem = new JMenuItem(
                new ActionCreateEdgeModelElement(
                    metaType,
                    source,
                    dest,
                    relationshipDescr));
if(menuItem != null)//1
{ 
menu.add(menuItem);
} 
} 
} 
private void initMenuCreateDiagrams()
    { 
createDiagrams.add(new ActionUseCaseDiagram());
createDiagrams.add(new ActionClassDiagram());
createDiagrams.add(new ActionCollaborationDiagram());
createDiagrams.add(new ActionStateDiagram());
createDiagrams.add(new ActionActivityDiagram());
createDiagrams.add(new ActionDeploymentDiagram());
} 
public ExplorerPopup(Object selectedItem, MouseEvent me)
    { 
super("Explorer popup menu");
boolean multiSelect =
            TargetManager.getInstance().getTargets().size() > 1;
boolean mutableModelElementsOnly = true;
for (Object element : TargetManager.getInstance().getTargets()) //1
{ 
if(!Model.getFacade().isAUMLElement(element)
                    || Model.getModelManagementHelper().isReadOnly(element))//1
{ 
mutableModelElementsOnly = false;
break;

} 
} 
final ArgoDiagram activeDiagram = DiagramUtils.getActiveDiagram();
if(!multiSelect && mutableModelElementsOnly)//1
{ 
initMenuCreateDiagrams();
this.add(createDiagrams);
} 
try//1
{ 
if(!multiSelect && selectedItem instanceof Profile
                    && !((Profile) selectedItem).getProfilePackages().isEmpty())//1
{ 
this.add(new ActionExportProfileXMI((Profile) selectedItem));
} 
} 
catch (Exception e) //1
{ 
} 
if(!multiSelect && selectedItem instanceof ProfileConfiguration)//1
{ 
this.add(new ActionManageProfiles());
} 
if(mutableModelElementsOnly)//1
{ 
initMenuCreateModelElements();
} 
final boolean modelElementSelected =
            Model.getFacade().isAUMLElement(selectedItem);
if(modelElementSelected)//1
{ 
final boolean nAryAssociationSelected =
                Model.getFacade().isANaryAssociation(selectedItem);
final boolean classifierSelected =
                Model.getFacade().isAClassifier(selectedItem);
final boolean packageSelected =
                Model.getFacade().isAPackage(selectedItem);
final boolean commentSelected =
                Model.getFacade().isAComment(selectedItem);
final boolean stateVertexSelected =
                Model.getFacade().isAStateVertex(selectedItem);
final boolean instanceSelected =
                Model.getFacade().isAInstance(selectedItem);
final boolean dataValueSelected =
                Model.getFacade().isADataValue(selectedItem);
final boolean relationshipSelected =
                Model.getFacade().isARelationship(selectedItem);
final boolean flowSelected =
                Model.getFacade().isAFlow(selectedItem);
final boolean linkSelected =
                Model.getFacade().isALink(selectedItem);
final boolean transitionSelected =
                Model.getFacade().isATransition(selectedItem);
final boolean activityDiagramActive =
                activeDiagram instanceof UMLActivityDiagram;
final boolean stateDiagramActive =
                activeDiagram instanceof UMLStateDiagram;
final Object selectedStateMachine =
                (stateVertexSelected) ? Model
                .getStateMachinesHelper().getStateMachine(selectedItem)
                : null;
final Object diagramStateMachine =
                (stateDiagramActive) ? ((UMLStateDiagram) activeDiagram)
                .getStateMachine()
                : null;
final Object diagramActivity =
                (activityDiagramActive)
                ? ((UMLActivityDiagram) activeDiagram).getStateMachine()
                : null;
Collection projectModels =
                ProjectManager.getManager().getCurrentProject().getModels();
if(!multiSelect)//1
{ 
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
Action action =
                        new ActionAddExistingNode(
                        menuLocalize("menu.popup.add-to-diagram"),
                        selectedItem);
this.add(action);
} 
if((relationshipSelected
                        && !flowSelected
                        && !nAryAssociationSelected)
                        || (linkSelected





                           )
                        || transitionSelected)//1
{ 
Action action =
                        new ActionAddExistingEdge(
                        menuLocalize("menu.popup.add-to-diagram"),
                        selectedItem);
this.add(action);
addMenuItemForBothEndsOf(selectedItem);
} 
if(classifierSelected
                        || packageSelected)//1
{ 
this.add(new ActionSetSourcePath());
} 
} 
if(mutableModelElementsOnly
                    // Can't delete last top level model
                    && !(projectModels.size() == 1
                         && projectModels.contains(selectedItem)))//1
{ 
this.add(new ActionDeleteModelElements());
} 
} 
if(!multiSelect)//1
{ 
if(selectedItem instanceof UMLClassDiagram)//1
{ 
Action action =
                    new ActionAddAllClassesFromModel(
                    menuLocalize("menu.popup.add-all-classes-to-diagram"),
                    selectedItem);
this.add(action);
} 
} 
if(multiSelect)//1
{ 
List<Object> classifiers = new ArrayList<Object>();
for (Object o : TargetManager.getInstance().getTargets()) //1
{ 
if(Model.getFacade().isAClassifier(o)
                        && !Model.getFacade().isARelationship(o))//1
{ 
classifiers.add(o);
} 
} 
if(!classifiers.isEmpty())//1
{ 
Action action =
                    new ActionAddExistingNodes(
                    menuLocalize("menu.popup.add-to-diagram"),
                    classifiers);
this.add(action);
} 
} 
else
if(selectedItem instanceof Diagram)//1
{ 
this.add(new ActionSaveDiagramToClipboard());
ActionDeleteModelElements ad = new ActionDeleteModelElements();
ad.setEnabled(ad.shouldBeEnabled());
this.add(ad);
} 
} 
private void initMenuCreateModelElements()
    { 
List targets = TargetManager.getInstance().getTargets();
Set<JMenuItem> menuItems = new TreeSet<JMenuItem>();
if(targets.size() >= 2)//1
{ 
boolean classifierRoleFound = false;
boolean classifierRolesOnly = true;
for (Iterator it = targets.iterator();
                    it.hasNext() && classifierRolesOnly; ) //1
{ 
if(Model.getFacade().isAClassifierRole(it.next()))//1
{ 
classifierRoleFound = true;
} 
else
{ 
classifierRolesOnly = false;
} 
} 
if(classifierRolesOnly)//1
{ 
menuItems.add(new OrderedMenuItem(
                                  new ActionCreateAssociationRole(
                                      Model.getMetaTypes().getAssociationRole(),
                                      targets)));
} 
else
if(!classifierRoleFound)//1
{ 
boolean classifiersOnly = true;
for (Iterator it = targets.iterator();
                        it.hasNext() && classifiersOnly; ) //1
{ 
if(!Model.getFacade().isAClassifier(it.next()))//1
{ 
classifiersOnly = false;
} 
} 
if(classifiersOnly)//1
{ 
menuItems.add(new OrderedMenuItem(
                                      new ActionCreateAssociation(
                                          Model.getMetaTypes().getAssociation(),
                                          targets)));
} 
} 
} 
if(targets.size() == 2)//1
{ 
addCreateModelElementAction(
                menuItems,
                Model.getMetaTypes().getDependency(),
                " " + menuLocalize("menu.popup.depends-on") + " ");
addCreateModelElementAction(
                menuItems,
                Model.getMetaTypes().getGeneralization(),
                " " + menuLocalize("menu.popup.generalizes") + " ");
addCreateModelElementAction(
                menuItems,
                Model.getMetaTypes().getInclude(),
                " " + menuLocalize("menu.popup.includes") + " ");
addCreateModelElementAction(
                menuItems,
                Model.getMetaTypes().getExtend(),
                " " + menuLocalize("menu.popup.extends") + " ");
addCreateModelElementAction(
                menuItems,
                Model.getMetaTypes().getPackageImport(),
                " " + menuLocalize("menu.popup.has-permission-on") + " ");
addCreateModelElementAction(
                menuItems,
                Model.getMetaTypes().getUsage(),
                " " + menuLocalize("menu.popup.uses") + " ");
addCreateModelElementAction(
                menuItems,
                Model.getMetaTypes().getAbstraction(),
                " " + menuLocalize("menu.popup.realizes") + " ");
} 
else
if(targets.size() == 1)//1
{ 
Object target = targets.get(0);
for (int iter = 0; iter < MODEL_ELEMENT_MENUITEMS.length;
                    iter += 2) //1
{ 
if(Model.getUmlFactory().isContainmentValid(
                            MODEL_ELEMENT_MENUITEMS[iter], target))//1
{ 
menuItems.add(new OrderedMenuItem(
                                      new ActionCreateContainedModelElement(
                                          MODEL_ELEMENT_MENUITEMS[iter],
                                          target,
                                          (String)
                                          MODEL_ELEMENT_MENUITEMS[iter + 1])));
} 
} 
} 
if(menuItems.size() == 1)//1
{ 
add(menuItems.iterator().next());
} 
else
if(menuItems.size() > 1)//1
{ 
JMenu menu =
                new JMenu(menuLocalize("menu.popup.create-model-element"));
add(menu);
for (JMenuItem item : menuItems) //1
{ 
menu.add(item);
} 
} 
} 
private class OrderedMenuItem extends JMenuItem
 implements Comparable
  { 
public OrderedMenuItem(Action action)
        { 
super(action);
} 
public int compareTo(Object o)
        { 
JMenuItem other = (JMenuItem) o;
return toString().compareTo(other.toString());
} 
public OrderedMenuItem(String name)
        { 
super(name);
setName(name);
} 

 } 
private class ActionCreateAssociationRole extends AbstractAction
  { 
private Object metaType;
private List classifierRoles;
public ActionCreateAssociationRole(
            Object theMetaType,
            List classifierRolesList)
        { 
super(menuLocalize("menu.popup.create") + " "
                  + Model.getMetaTypes().getName(theMetaType));
this.metaType = theMetaType;
this.classifierRoles = classifierRolesList;
} 
public void actionPerformed(ActionEvent e)
        { 
try//1
{ 
Object newElement = Model.getUmlFactory().buildConnection(
                                        metaType,
                                        classifierRoles.get(0),
                                        null,
                                        classifierRoles.get(1),
                                        null,
                                        null,
                                        null);
for (int i = 2; i < classifierRoles.size(); ++i) //1
{ 
Model.getUmlFactory().buildConnection(
                        Model.getMetaTypes().getAssociationEndRole(),
                        newElement,
                        null,
                        classifierRoles.get(i),
                        null,
                        null,
                        null);
} 
} 
catch (IllegalModelElementConnectionException e1) //1
{ 
LOG.error("Exception", e1);
} 
} 

 } 
private class ActionAddExistingRelatedNode extends UndoableAction
  { 
private Object object;
public ActionAddExistingRelatedNode(String name, Object o)
        { 
super(name);
object = o;
} 
public boolean isEnabled()
        { 
ArgoDiagram dia = DiagramUtils.getActiveDiagram();
if(dia == null)//1
{ 
return false;
} 
MutableGraphModel gm = (MutableGraphModel) dia.getGraphModel();
return gm.canAddNode(object);
} 
public void actionPerformed(ActionEvent ae)
        { 
super.actionPerformed(ae);
Editor ce = Globals.curEditor();
GraphModel gm = ce.getGraphModel();
if(!(gm instanceof MutableGraphModel))//1
{ 
return;
} 
String instructions = null;
if(object != null)//1
{ 
instructions =
                    Translator.localize(
                        "misc.message.click-on-diagram-to-add",
                        new Object[] {
                            Model.getFacade().toString(object),
                        });
Globals.showStatus(instructions);
} 
ArrayList<Object> elementsToAdd = new ArrayList<Object>(1);
elementsToAdd.add(object);
final ModeAddToDiagram placeMode =
                new ModeAddToDiagram(elementsToAdd, instructions);
Globals.mode(placeMode, false);
} 

 } 
private class ActionCreateAssociation extends AbstractAction
  { 
private Object metaType;
private List classifiers;
public void actionPerformed(ActionEvent e)
        { 
try//1
{ 
Object newElement = Model.getUmlFactory().buildConnection(
                                        metaType,
                                        classifiers.get(0),
                                        null,
                                        classifiers.get(1),
                                        null,
                                        null,
                                        null);
for (int i = 2; i < classifiers.size(); ++i) //1
{ 
Model.getUmlFactory().buildConnection(
                        Model.getMetaTypes().getAssociationEnd(),
                        newElement,
                        null,
                        classifiers.get(i),
                        null,
                        null,
                        null);
} 
} 
catch (IllegalModelElementConnectionException e1) //1
{ 
LOG.error("Exception", e1);
} 
} 
public ActionCreateAssociation(
            Object theMetaType,
            List classifiersList)
        { 
super(menuLocalize("menu.popup.create") + " "
                  + Model.getMetaTypes().getName(theMetaType));
this.metaType = theMetaType;
this.classifiers = classifiersList;
} 

 } 
private class OrderedMenu extends JMenu
 implements Comparable
  { 
public OrderedMenu(String name)
        { 
super(name);
} 
public int compareTo(Object o)
        { 
JMenuItem other = (JMenuItem) o;
return toString().compareTo(other.toString());
} 

 } 

 } 
