
//#if 1367339004 
// Compilation Unit of /PropPanelTagDefinition.java 
 

//#if -1964013567 
package org.argouml.uml.ui.foundation.extension_mechanisms;
//#endif 


//#if 1541928196 
import java.awt.event.ActionEvent;
//#endif 


//#if -789754246 
import java.util.Collection;
//#endif 


//#if 1725727306 
import java.util.HashSet;
//#endif 


//#if -2126494086 
import javax.swing.Action;
//#endif 


//#if 1236083259 
import javax.swing.Box;
//#endif 


//#if -2004310991 
import javax.swing.BoxLayout;
//#endif 


//#if 1762164253 
import javax.swing.JComponent;
//#endif 


//#if -1633608514 
import javax.swing.JList;
//#endif 


//#if 1004710262 
import javax.swing.JPanel;
//#endif 


//#if 1829492647 
import javax.swing.JScrollPane;
//#endif 


//#if -1269181500 
import org.apache.log4j.Logger;
//#endif 


//#if -545877007 
import org.argouml.i18n.Translator;
//#endif 


//#if 1164133142 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 566970733 
import org.argouml.model.AssociationChangeEvent;
//#endif 


//#if 18706888 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if 578354999 
import org.argouml.model.Model;
//#endif 


//#if 221517888 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if 1820840889 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if -1322549574 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if -2073192127 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if -1035963307 
import org.argouml.uml.ui.UMLComboBoxNavigator;
//#endif 


//#if 1490576624 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if -2026904726 
import org.argouml.uml.ui.UMLMultiplicityPanel;
//#endif 


//#if 141830600 
import org.argouml.uml.ui.UMLSearchableComboBox;
//#endif 


//#if 1886644795 
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
//#endif 


//#if -1149611081 
import org.argouml.uml.ui.foundation.core.UMLModelElementNamespaceComboBoxModel;
//#endif 


//#if 832632730 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 1262261533 
public class PropPanelTagDefinition extends 
//#if 1813452015 
PropPanelModelElement
//#endif 

  { 

//#if 20887887 
private static final long serialVersionUID = 3563940705352568635L;
//#endif 


//#if 1916637850 
private JComponent ownerSelector;
//#endif 


//#if -2126652734 
private JComponent tdNamespaceSelector;
//#endif 


//#if -1247865755 
private UMLComboBox2 typeComboBox;
//#endif 


//#if -623070525 
private JScrollPane typedValuesScroll;
//#endif 


//#if -937682642 
private static UMLTagDefinitionOwnerComboBoxModel
    ownerComboBoxModel =
        new UMLTagDefinitionOwnerComboBoxModel();
//#endif 


//#if -1813040496 
private UMLComboBoxModel2 tdNamespaceComboBoxModel =
        new UMLTagDefinitionNamespaceComboBoxModel();
//#endif 


//#if 479410634 
private static UMLMetaClassComboBoxModel typeComboBoxModel;
//#endif 


//#if -315017508 
private static UMLTagDefinitionTypedValuesListModel typedValuesListModel =
        new UMLTagDefinitionTypedValuesListModel();
//#endif 


//#if 1837241895 
private JPanel multiplicityComboBox;
//#endif 


//#if 930488981 
public JScrollPane getTypedValuesScroll()
    { 

//#if 932249753 
if(typedValuesScroll == null)//1
{ 

//#if -1468210982 
JList typedValuesList  = new UMLLinkedList(typedValuesListModel);
//#endif 


//#if 302175134 
typedValuesScroll = new JScrollPane(typedValuesList);
//#endif 

} 

//#endif 


//#if -1191359602 
return typedValuesScroll;
//#endif 

} 

//#endif 


//#if -1468428517 
public PropPanelTagDefinition()
    { 

//#if 41152780 
super("label.tag-definition-title", lookupIcon("TagDefinition"));
//#endif 


//#if 1731020314 
addField(Translator.localize("label.name"),
                 getNameTextField());
//#endif 


//#if -12660416 
addField(Translator.localize("label.owner"),
                 getOwnerSelector());
//#endif 


//#if -1634000368 
addField(Translator.localize("label.namespace"),
                 getTDNamespaceSelector());
//#endif 


//#if -1264232034 
addField(Translator.localize("label.multiplicity"),
                 getMultiplicityComboBox());
//#endif 


//#if 2142851699 
add(getVisibilityPanel());
//#endif 


//#if -1394958471 
addSeparator();
//#endif 


//#if -468095470 
UMLComboBoxNavigator typeComboBoxNav = new UMLComboBoxNavigator(
            Translator.localize("label.class.navigate.tooltip"),
            getTypeComboBox());
//#endif 


//#if -1508834965 
typeComboBoxNav.setEnabled(false);
//#endif 


//#if 1742466514 
addField(Translator.localize("label.type"), typeComboBoxNav);
//#endif 


//#if -2121642569 
addField(Translator.localize("label.tagged-values"),
                 getTypedValuesScroll());
//#endif 


//#if -503941753 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if 483543304 
addAction(new ActionNewTagDefinition());
//#endif 


//#if -531745572 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if 1979352671 
public UMLComboBox2 getTypeComboBox()
    { 

//#if 1818819928 
if(typeComboBox == null)//1
{ 

//#if -2079220919 
if(typeComboBoxModel == null)//1
{ 

//#if -2060334477 
typeComboBoxModel = new UMLMetaClassComboBoxModel();
//#endif 

} 

//#endif 


//#if -1608329601 
typeComboBox =
                new UMLComboBox2(typeComboBoxModel,
                                 ActionSetTagDefinitionType.getInstance());
//#endif 


//#if -891132048 
typeComboBox.setEnabled(false);
//#endif 

} 

//#endif 


//#if 1485982267 
return typeComboBox;
//#endif 

} 

//#endif 


//#if -542460272 
protected JPanel getMultiplicityComboBox()
    { 

//#if -872821011 
if(multiplicityComboBox == null)//1
{ 

//#if -482483072 
multiplicityComboBox = new UMLMultiplicityPanel();
//#endif 

} 

//#endif 


//#if 341879590 
return multiplicityComboBox;
//#endif 

} 

//#endif 


//#if -1528586767 
protected JComponent getTDNamespaceSelector()
    { 

//#if -97842633 
if(tdNamespaceSelector == null)//1
{ 

//#if -2129191056 
tdNamespaceSelector = new UMLSearchableComboBox(
                tdNamespaceComboBoxModel,
                new ActionSetTagDefinitionNamespace(), true);
//#endif 

} 

//#endif 


//#if 1343183914 
return tdNamespaceSelector;
//#endif 

} 

//#endif 


//#if 1428918841 
protected JComponent getOwnerSelector()
    { 

//#if 98811076 
if(ownerSelector == null)//1
{ 

//#if -1221630348 
ownerSelector = new Box(BoxLayout.X_AXIS);
//#endif 


//#if -1151609560 
ownerSelector.add(new UMLComboBoxNavigator(
                                  Translator.localize("label.owner.navigate.tooltip"),
                                  new UMLComboBox2(ownerComboBoxModel,
                                                   new ActionSetTagDefinitionOwner())
                              ));
//#endif 

} 

//#endif 


//#if -1087313433 
return ownerSelector;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -815615324 
class UMLTagDefinitionNamespaceComboBoxModel extends 
//#if 1201805134 
UMLModelElementNamespaceComboBoxModel
//#endif 

  { 

//#if 300657678 
private static final Logger LOG =
        Logger.getLogger(UMLTagDefinitionNamespaceComboBoxModel.class);
//#endif 


//#if 1433418810 
@Override
    public void modelChanged(UmlChangeEvent evt)
    { 

//#if -1091060568 
Object t = getTarget();
//#endif 


//#if -449549708 
if(t != null && evt.getSource() == t
                && (evt instanceof AttributeChangeEvent
                    || evt instanceof AssociationChangeEvent))//1
{ 

//#if -1566515732 
buildModelList();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1344708539 
@Override
    protected boolean isValidElement(Object o)
    { 

//#if 1431668656 
return Model.getFacade().isANamespace(o);
//#endif 

} 

//#endif 


//#if 1303478746 
@Override
    protected void buildModelList()
    { 

//#if 1112188111 
Collection roots =
            ProjectManager.getManager().getCurrentProject().getRoots();
//#endif 


//#if 433502459 
Collection c = new HashSet();
//#endif 


//#if -43720866 
c.add(null);
//#endif 


//#if -1368872590 
for (Object root : roots) //1
{ 

//#if -1558072881 
c.add(root);
//#endif 


//#if 64548100 
c.addAll(Model.getModelManagementHelper().getAllNamespaces(root));
//#endif 

} 

//#endif 


//#if -1375661107 
Object target = getTarget();
//#endif 


//#if -1370604588 
if(target != null)//1
{ 

//#if -851053846 
Object namespace = Model.getFacade().getNamespace(target);
//#endif 


//#if 334767988 
if(namespace != null)//1
{ 

//#if 951684271 
c.add(namespace);
//#endif 


//#if 1283495266 
LOG.warn("The current TD namespace is not a valid one!");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -318369741 
setElements(c);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 125821184 
class ActionSetTagDefinitionNamespace extends 
//#if 416114942 
UndoableAction
//#endif 

  { 

//#if -1240380880 
private static final long serialVersionUID = 366165281490799874L;
//#endif 


//#if -914377993 
protected ActionSetTagDefinitionNamespace()
    { 

//#if 978944921 
super(Translator.localize("Set"), null);
//#endif 


//#if 407550742 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 


//#if -945683189 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if -161498350 
super.actionPerformed(e);
//#endif 


//#if -619761087 
Object source = e.getSource();
//#endif 


//#if 697076702 
Object oldNamespace = null;
//#endif 


//#if -299299003 
Object newNamespace = null;
//#endif 


//#if -1707210863 
Object m = null;
//#endif 


//#if -779730937 
if(source instanceof UMLComboBox2)//1
{ 

//#if -914379991 
UMLComboBox2 box = (UMLComboBox2) source;
//#endif 


//#if 540567623 
Object o = box.getTarget();
//#endif 


//#if 239299433 
if(Model.getFacade().isAModelElement(o))//1
{ 

//#if 1210658249 
m = o;
//#endif 


//#if 1113070234 
oldNamespace = Model.getFacade().getNamespace(m);
//#endif 

} 

//#endif 


//#if -410223989 
o = box.getSelectedItem();
//#endif 


//#if -1268249155 
if(Model.getFacade().isANamespace(o))//1
{ 

//#if -1623256004 
newNamespace = o;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -915225548 
if(newNamespace != oldNamespace && m != null && newNamespace != null)//1
{ 

//#if 1624940136 
Model.getCoreHelper().setOwner(m, null);
//#endif 


//#if 529297748 
Model.getCoreHelper().setNamespace(m, newNamespace);
//#endif 


//#if -212466802 
super.actionPerformed(e);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

