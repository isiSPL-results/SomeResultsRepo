// Compilation Unit of /PropPanelTaggedValue.java 
 
package org.argouml.uml.ui.foundation.extension_mechanisms;
import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.uml.ui.ActionNavigateContainerElement;
import org.argouml.uml.ui.UMLComboBox2;
import org.argouml.uml.ui.UMLComboBoxModel2;
import org.argouml.uml.ui.UMLComboBoxNavigator;
import org.argouml.uml.ui.UMLLinkedList;
import org.argouml.uml.ui.UMLModelElementListModel2;
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
import org.tigris.gef.undo.UndoableAction;
public class PropPanelTaggedValue extends PropPanelModelElement
  { 
private JComponent modelElementSelector;
private JComponent typeSelector;
private JScrollPane referenceValuesScroll;
private JScrollPane dataValuesScroll;
protected JComponent getModelElementSelector()
    { 
if(modelElementSelector == null)//1
{ 
modelElementSelector = new Box(BoxLayout.X_AXIS);
modelElementSelector.add(new UMLComboBoxNavigator(
                                         Translator.localize("label.modelelement.navigate.tooltip"),
                                         new UMLComboBox2(
                                             new UMLTaggedValueModelElementComboBoxModel(),
                                             new ActionSetTaggedValueModelElement())
                                     ));
} 

return modelElementSelector;
} 

protected JScrollPane getReferenceValuesScroll()
    { 
if(referenceValuesScroll == null)//1
{ 
JList list = new UMLLinkedList(new UMLReferenceValueListModel());
referenceValuesScroll = new JScrollPane(list);
} 

return referenceValuesScroll;
} 

protected JComponent getTypeSelector()
    { 
if(typeSelector == null)//1
{ 
typeSelector = new Box(BoxLayout.X_AXIS);
typeSelector.add(new UMLComboBoxNavigator(
                                 Translator.localize("label.type.navigate.tooltip"),
                                 new UMLComboBox2(
                                     new UMLTaggedValueTypeComboBoxModel(),
                                     new ActionSetTaggedValueType())
                             ));
} 

return typeSelector;
} 

public PropPanelTaggedValue()
    { 
super("label.tagged-value", lookupIcon("TaggedValue"));
addField(Translator.localize("label.name"),
                 getNameTextField());
addField(Translator.localize("label.modelelement"),
                 getModelElementSelector());
addField(Translator.localize("label.type"),
                 getTypeSelector());
addSeparator();
addField(Translator.localize("label.reference-values"),
                 getReferenceValuesScroll());
addField(Translator.localize("label.data-values"),
                 getDataValuesScroll());
addAction(new ActionNavigateContainerElement());
addAction(new ActionNewTagDefinition());
addAction(getDeleteAction());
} 

protected JScrollPane getDataValuesScroll()
    { 
if(dataValuesScroll == null)//1
{ 
JList list = new UMLLinkedList(new UMLDataValueListModel());
dataValuesScroll = new JScrollPane(list);
} 

return dataValuesScroll;
} 

static class ActionSetTaggedValueModelElement extends UndoableAction
  { 
public void actionPerformed(ActionEvent e)
        { 
super.actionPerformed(e);
Object source = e.getSource();
if(source instanceof UMLComboBox2
                    && e.getModifiers() == AWTEvent.MOUSE_EVENT_MASK)//1
{ 
UMLComboBox2 combo = (UMLComboBox2) source;
Object o = combo.getSelectedItem();
final Object taggedValue = combo.getTarget();
if(Model.getFacade().isAModelElement(o)
                        && Model.getFacade().isATaggedValue(taggedValue))//1
{ 
Object oldME =
                        Model.getFacade().getModelElement(taggedValue);
Model.getExtensionMechanismsHelper()
                    .removeTaggedValue(oldME, taggedValue);
Model.getExtensionMechanismsHelper()
                    .addTaggedValue(o, taggedValue);
} 

} 

} 

public ActionSetTaggedValueModelElement()
        { 
super();
} 

 } 

static class ActionSetTaggedValueType extends UndoableAction
  { 
public void actionPerformed(ActionEvent e)
        { 
super.actionPerformed(e);
Object source = e.getSource();
if(source instanceof UMLComboBox2
                    && e.getModifiers() == AWTEvent.MOUSE_EVENT_MASK)//1
{ 
UMLComboBox2 combo = (UMLComboBox2) source;
Object o = combo.getSelectedItem();
final Object taggedValue = combo.getTarget();
if(Model.getFacade().isAModelElement(o)
                        && Model.getFacade().isATaggedValue(taggedValue))//1
{ 
Model.getExtensionMechanismsHelper()
                    .setType(taggedValue, o);
} 

} 

} 

public ActionSetTaggedValueType()
        { 
super();
} 

 } 

static class UMLTaggedValueModelElementComboBoxModel extends UMLComboBoxModel2
  { 
protected void buildModelList()
        { 
Project p = ProjectManager.getManager().getCurrentProject();
Object model = p.getRoot();
setElements(Model.getModelManagementHelper()
                        .getAllModelElementsOfKindWithModel(model,
                                Model.getMetaTypes().getModelElement()));
} 

protected Object getSelectedModelElement()
        { 
Object me = null;
if(getTarget() != null
                    && Model.getFacade().isATaggedValue(getTarget()))//1
{ 
me = Model.getFacade().getModelElement(getTarget());
} 

return me;
} 

protected boolean isValidElement(Object element)
        { 
return Model.getFacade().isAModelElement(element);
} 

public UMLTaggedValueModelElementComboBoxModel()
        { 
super("modelelement", true);
} 

 } 

static class UMLDataValueListModel extends UMLModelElementListModel2
  { 
protected boolean isValidElement(Object element)
        { 
return Model.getFacade().isAModelElement(element)
                   && Model.getFacade().getDataValue(
                       getTarget()).contains(element);
} 

protected void buildModelList()
        { 
if(getTarget() != null)//1
{ 
setAllElements(
                    Model.getFacade().getDataValue(getTarget()));
} 

} 

public UMLDataValueListModel()
        { 
super("dataValue");
} 

 } 

static class UMLTaggedValueTypeComboBoxModel extends UMLComboBoxModel2
  { 
protected Object getSelectedModelElement()
        { 
Object me = null;
if(getTarget() != null
                    && Model.getFacade().isATaggedValue(getTarget()))//1
{ 
me = Model.getFacade().getType(getTarget());
} 

return me;
} 

public UMLTaggedValueTypeComboBoxModel()
        { 
super("type", true);
} 

protected boolean isValidElement(Object element)
        { 
return Model.getFacade().isATagDefinition(element);
} 

protected void buildModelList()
        { 
Project p = ProjectManager.getManager().getCurrentProject();
Object model = p.getRoot();
setElements(Model.getModelManagementHelper()
                        .getAllModelElementsOfKindWithModel(model,
                                Model.getMetaTypes().getTagDefinition()));
} 

 } 

static class UMLReferenceValueListModel extends UMLModelElementListModel2
  { 
protected boolean isValidElement(Object element)
        { 
return Model.getFacade().isAModelElement(element)
                   && Model.getFacade().getReferenceValue(
                       getTarget()).contains(element);
} 

protected void buildModelList()
        { 
if(getTarget() != null)//1
{ 
setAllElements(
                    Model.getFacade().getReferenceValue(getTarget()));
} 

} 

public UMLReferenceValueListModel()
        { 
super("referenceValue");
} 

 } 

 } 


