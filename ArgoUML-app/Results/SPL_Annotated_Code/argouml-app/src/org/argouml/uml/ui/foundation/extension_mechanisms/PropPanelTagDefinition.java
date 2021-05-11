// Compilation Unit of /PropPanelTagDefinition.java 
 
package org.argouml.uml.ui.foundation.extension_mechanisms;
import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.HashSet;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.apache.log4j.Logger;
import org.argouml.i18n.Translator;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.AssociationChangeEvent;
import org.argouml.model.AttributeChangeEvent;
import org.argouml.model.Model;
import org.argouml.model.UmlChangeEvent;
import org.argouml.uml.ui.ActionNavigateContainerElement;
import org.argouml.uml.ui.UMLComboBox2;
import org.argouml.uml.ui.UMLComboBoxModel2;
import org.argouml.uml.ui.UMLComboBoxNavigator;
import org.argouml.uml.ui.UMLLinkedList;
import org.argouml.uml.ui.UMLMultiplicityPanel;
import org.argouml.uml.ui.UMLSearchableComboBox;
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
import org.argouml.uml.ui.foundation.core.UMLModelElementNamespaceComboBoxModel;
import org.tigris.gef.undo.UndoableAction;
public class PropPanelTagDefinition extends PropPanelModelElement
  { 
private static final long serialVersionUID = 3563940705352568635L;
private JComponent ownerSelector;
private JComponent tdNamespaceSelector;
private UMLComboBox2 typeComboBox;
private JScrollPane typedValuesScroll;
private static UMLTagDefinitionOwnerComboBoxModel
    ownerComboBoxModel =
        new UMLTagDefinitionOwnerComboBoxModel();
private UMLComboBoxModel2 tdNamespaceComboBoxModel =
        new UMLTagDefinitionNamespaceComboBoxModel();
private static UMLMetaClassComboBoxModel typeComboBoxModel;
private static UMLTagDefinitionTypedValuesListModel typedValuesListModel =
        new UMLTagDefinitionTypedValuesListModel();
private JPanel multiplicityComboBox;
public JScrollPane getTypedValuesScroll()
    { 
if(typedValuesScroll == null)//1
{ 
JList typedValuesList  = new UMLLinkedList(typedValuesListModel);
typedValuesScroll = new JScrollPane(typedValuesList);
} 

return typedValuesScroll;
} 

public PropPanelTagDefinition()
    { 
super("label.tag-definition-title", lookupIcon("TagDefinition"));
addField(Translator.localize("label.name"),
                 getNameTextField());
addField(Translator.localize("label.owner"),
                 getOwnerSelector());
addField(Translator.localize("label.namespace"),
                 getTDNamespaceSelector());
addField(Translator.localize("label.multiplicity"),
                 getMultiplicityComboBox());
add(getVisibilityPanel());
addSeparator();
UMLComboBoxNavigator typeComboBoxNav = new UMLComboBoxNavigator(
            Translator.localize("label.class.navigate.tooltip"),
            getTypeComboBox());
typeComboBoxNav.setEnabled(false);
addField(Translator.localize("label.type"), typeComboBoxNav);
addField(Translator.localize("label.tagged-values"),
                 getTypedValuesScroll());
addAction(new ActionNavigateContainerElement());
addAction(new ActionNewTagDefinition());
addAction(getDeleteAction());
} 

public UMLComboBox2 getTypeComboBox()
    { 
if(typeComboBox == null)//1
{ 
if(typeComboBoxModel == null)//1
{ 
typeComboBoxModel = new UMLMetaClassComboBoxModel();
} 

typeComboBox =
                new UMLComboBox2(typeComboBoxModel,
                                 ActionSetTagDefinitionType.getInstance());
typeComboBox.setEnabled(false);
} 

return typeComboBox;
} 

protected JPanel getMultiplicityComboBox()
    { 
if(multiplicityComboBox == null)//1
{ 
multiplicityComboBox = new UMLMultiplicityPanel();
} 

return multiplicityComboBox;
} 

protected JComponent getTDNamespaceSelector()
    { 
if(tdNamespaceSelector == null)//1
{ 
tdNamespaceSelector = new UMLSearchableComboBox(
                tdNamespaceComboBoxModel,
                new ActionSetTagDefinitionNamespace(), true);
} 

return tdNamespaceSelector;
} 

protected JComponent getOwnerSelector()
    { 
if(ownerSelector == null)//1
{ 
ownerSelector = new Box(BoxLayout.X_AXIS);
ownerSelector.add(new UMLComboBoxNavigator(
                                  Translator.localize("label.owner.navigate.tooltip"),
                                  new UMLComboBox2(ownerComboBoxModel,
                                                   new ActionSetTagDefinitionOwner())
                              ));
} 

return ownerSelector;
} 

 } 

class UMLTagDefinitionNamespaceComboBoxModel extends UMLModelElementNamespaceComboBoxModel
  { 
private static final Logger LOG =
        Logger.getLogger(UMLTagDefinitionNamespaceComboBoxModel.class);
@Override
    public void modelChanged(UmlChangeEvent evt)
    { 
Object t = getTarget();
if(t != null && evt.getSource() == t
                && (evt instanceof AttributeChangeEvent
                    || evt instanceof AssociationChangeEvent))//1
{ 
buildModelList();
} 

} 

@Override
    protected boolean isValidElement(Object o)
    { 
return Model.getFacade().isANamespace(o);
} 

@Override
    protected void buildModelList()
    { 
Collection roots =
            ProjectManager.getManager().getCurrentProject().getRoots();
Collection c = new HashSet();
c.add(null);
for (Object root : roots) //1
{ 
c.add(root);
c.addAll(Model.getModelManagementHelper().getAllNamespaces(root));
} 

Object target = getTarget();
if(target != null)//1
{ 
Object namespace = Model.getFacade().getNamespace(target);
if(namespace != null)//1
{ 
c.add(namespace);
LOG.warn("The current TD namespace is not a valid one!");
} 

} 

setElements(c);
} 

 } 

class ActionSetTagDefinitionNamespace extends UndoableAction
  { 
private static final long serialVersionUID = 366165281490799874L;
protected ActionSetTagDefinitionNamespace()
    { 
super(Translator.localize("Set"), null);
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
} 

@Override
    public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
Object source = e.getSource();
Object oldNamespace = null;
Object newNamespace = null;
Object m = null;
if(source instanceof UMLComboBox2)//1
{ 
UMLComboBox2 box = (UMLComboBox2) source;
Object o = box.getTarget();
if(Model.getFacade().isAModelElement(o))//1
{ 
m = o;
oldNamespace = Model.getFacade().getNamespace(m);
} 

o = box.getSelectedItem();
if(Model.getFacade().isANamespace(o))//1
{ 
newNamespace = o;
} 

} 

if(newNamespace != oldNamespace && m != null && newNamespace != null)//1
{ 
Model.getCoreHelper().setOwner(m, null);
Model.getCoreHelper().setNamespace(m, newNamespace);
super.actionPerformed(e);
} 

} 

 } 


