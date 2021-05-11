// Compilation Unit of /PropPanelModelElement.java 
 
package org.argouml.uml.ui.foundation.core;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import org.argouml.i18n.Translator;
import org.argouml.kernel.UmlModelMutator;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.ui.PropPanel;
import org.argouml.uml.ui.ScrollList;
import org.argouml.uml.ui.UMLComboBoxNavigator;
import org.argouml.uml.ui.UMLDerivedCheckBox;
import org.argouml.uml.ui.UMLMutableLinkedList;
import org.argouml.uml.ui.UMLPlainTextDocument;
import org.argouml.uml.ui.UMLSearchableComboBox;
import org.argouml.uml.ui.UMLTextField2;
public abstract class PropPanelModelElement extends PropPanel
  { 
private JComboBox namespaceSelector;
private JScrollPane supplierDependencyScroll;
private JScrollPane clientDependencyScroll;
private JScrollPane targetFlowScroll;
private JScrollPane sourceFlowScroll;
private JScrollPane constraintScroll;
private JPanel visibilityPanel;
private JScrollPane elementResidenceScroll;
private JTextField nameTextField;
private UMLModelElementNamespaceComboBoxModel namespaceComboBoxModel =
        new UMLModelElementNamespaceComboBoxModel();
private static UMLModelElementClientDependencyListModel
    clientDependencyListModel =
        new UMLModelElementClientDependencyListModel();
private static UMLModelElementConstraintListModel constraintListModel =
        new UMLModelElementConstraintListModel();
private static UMLModelElementElementResidenceListModel
    elementResidenceListModel =
        new UMLModelElementElementResidenceListModel();
private static UMLModelElementNameDocument nameDocument =
        new UMLModelElementNameDocument();
private static UMLModelElementSourceFlowListModel sourceFlowListModel =
        new UMLModelElementSourceFlowListModel();
private static UMLModelElementTargetFlowListModel targetFlowListModel =
        new UMLModelElementTargetFlowListModel();
protected JComponent getClientDependencyScroll()
    { 
if(clientDependencyScroll == null)//1
{ 
JList list = new UMLMutableLinkedList(
                clientDependencyListModel,
                new ActionAddClientDependencyAction(),
                null,
                null,
                true);
clientDependencyScroll = new JScrollPane(list);
} 

return clientDependencyScroll;
} 

protected JComponent getVisibilityPanel()
    { 
if(visibilityPanel == null)//1
{ 
visibilityPanel =
                new UMLModelElementVisibilityRadioButtonPanel(
                Translator.localize("label.visibility"), true);
} 

return visibilityPanel;
} 

protected JComponent getConstraintScroll()
    { 
if(constraintScroll == null)//1
{ 
JList constraintList = new UMLMutableLinkedList(
                constraintListModel, null,
                ActionNewModelElementConstraint.getInstance());
constraintScroll = new JScrollPane(constraintList);
} 

return constraintScroll;
} 

protected JComponent getSupplierDependencyScroll()
    { 
if(supplierDependencyScroll == null)//1
{ 
JList list = new UMLMutableLinkedList(
                new UMLModelElementSupplierDependencyListModel(),
                new ActionAddSupplierDependencyAction(),
                null,
                null,
                true);
supplierDependencyScroll = new JScrollPane(list);
} 

return supplierDependencyScroll;
} 

public PropPanelModelElement(String name, ImageIcon icon)
    { 
super(name, icon);
} 

protected JComponent getElementResidenceScroll()
    { 
if(elementResidenceScroll == null)//1
{ 
elementResidenceScroll = new ScrollList(elementResidenceListModel);
} 

return elementResidenceScroll;
} 

protected JComponent getTargetFlowScroll()
    { 
if(targetFlowScroll == null)//1
{ 
targetFlowScroll = new ScrollList(targetFlowListModel);
} 

return targetFlowScroll;
} 

protected UMLPlainTextDocument getNameDocument()
    { 
return nameDocument;
} 

public PropPanelModelElement()
    { 
this("label.model-element-title", (ImageIcon) null);
addField("label.name",
                 getNameTextField());
addField("label.namespace",
                 getNamespaceSelector());
addSeparator();
addField("label.supplier-dependencies",
                 getSupplierDependencyScroll());
addField("label.client-dependencies",
                 getClientDependencyScroll());
addField("label.source-flows",
                 getSourceFlowScroll());
addField("label.target-flows",
                 getTargetFlowScroll());
addSeparator();
addField("label.constraints",
                 getConstraintScroll());
add(getVisibilityPanel());
addField("label.derived",
                 new UMLDerivedCheckBox());
} 

protected JComponent getNameTextField()
    { 
if(nameTextField == null)//1
{ 
nameTextField = new UMLTextField2(nameDocument);
} 

return nameTextField;
} 

@Override
    public void setTarget(Object target)
    { 
super.setTarget(target);
if(Model.getFacade().isAUMLElement(target))//1
{ 
boolean enable =
                !Model.getModelManagementHelper().isReadOnly(target);
for (final Component component : getComponents()) //1
{ 
if(component instanceof JScrollPane)//1
{ 
Component c =
                        ((JScrollPane) component).getViewport().getView();
if(c.getClass().isAnnotationPresent(
                                UmlModelMutator.class))//1
{ 
c.setEnabled(enable);
} 

} 
else
if(!(component instanceof JLabel)
                           && component.isEnabled() != enable)//1
{ 
component.setEnabled(enable);
} 


} 

} 

} 

@Override
    protected final List getActions()
    { 
List actions = super.getActions();
if(Model.getFacade().isAUMLElement(getTarget())
                && Model.getModelManagementHelper().isReadOnly(getTarget()))//1
{ 
final List<Action> filteredActions = new ArrayList<Action>(2);
for (Object o : actions) //1
{ 
if(o instanceof Action && !o.getClass().isAnnotationPresent(
                            UmlModelMutator.class))//1
{ 
filteredActions.add((Action) o);
} 

} 

return filteredActions;
} 
else
{ 
return actions;
} 

} 

protected JComponent getSourceFlowScroll()
    { 
if(sourceFlowScroll == null)//1
{ 
sourceFlowScroll = new ScrollList(sourceFlowListModel);
} 

return sourceFlowScroll;
} 

protected JComponent getNamespaceSelector()
    { 
if(namespaceSelector == null)//1
{ 
namespaceSelector = new UMLSearchableComboBox(
                namespaceComboBoxModel,
                new ActionSetModelElementNamespace(), true);
} 

return new UMLComboBoxNavigator(
                   Translator.localize("label.namespace.navigate.tooltip"),
                   namespaceSelector);
} 

public void navigateUp()
    { 
TargetManager.getInstance().setTarget(
            Model.getFacade().getModelElementContainer(getTarget()));
} 

 } 


