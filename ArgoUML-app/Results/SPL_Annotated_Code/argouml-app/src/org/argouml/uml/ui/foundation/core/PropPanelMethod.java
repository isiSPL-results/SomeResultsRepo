// Compilation Unit of /PropPanelMethod.java 
 
package org.argouml.uml.ui.foundation.core;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.apache.log4j.Logger;
import org.argouml.i18n.Translator;
import org.argouml.model.AttributeChangeEvent;
import org.argouml.model.Model;
import org.argouml.model.UmlChangeEvent;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.ui.ActionNavigateOwner;
import org.argouml.uml.ui.UMLComboBox2;
import org.argouml.uml.ui.UMLComboBoxModel2;
import org.argouml.uml.ui.UMLComboBoxNavigator;
import org.argouml.uml.ui.UMLExpressionBodyField;
import org.argouml.uml.ui.UMLExpressionLanguageField;
import org.argouml.uml.ui.UMLExpressionModel2;
import org.argouml.uml.ui.UMLUserInterfaceContainer;
import org.tigris.gef.undo.UndoableAction;
class UMLMethodProcedureExpressionModel extends UMLExpressionModel2
  { 
private static final Logger LOG =
        Logger.getLogger(UMLMethodProcedureExpressionModel.class);
public Object getExpression()
    { 
return Model.getFacade().getBody(
                   TargetManager.getInstance().getTarget());
} 

public void setExpression(Object expression)
    { 
Object target = TargetManager.getInstance().getTarget();
if(target == null)//1
{ 
throw new IllegalStateException("There is no target for "
                                            + getContainer());
} 

Model.getCoreHelper().setBody(target, expression);
} 

public Object newExpression()
    { 
LOG.debug("new empty procedure expression");
return Model.getDataTypesFactory().createProcedureExpression("", "");
} 

public UMLMethodProcedureExpressionModel(
        UMLUserInterfaceContainer container,
        String propertyName)
    { 
super(container, propertyName);
} 

 } 

public class PropPanelMethod extends PropPanelFeature
  { 
private UMLComboBox2 specificationComboBox;
private static UMLMethodSpecificationComboBoxModel
    specificationComboBoxModel;
public UMLComboBox2 getSpecificationComboBox()
    { 
if(specificationComboBox == null)//1
{ 
if(specificationComboBoxModel == null)//1
{ 
specificationComboBoxModel =
                    new UMLMethodSpecificationComboBoxModel();
} 

specificationComboBox =
                new UMLComboBox2(
                specificationComboBoxModel,
                new ActionSetMethodSpecification());
} 

return specificationComboBox;
} 

public PropPanelMethod()
    { 
super("label.method", lookupIcon("Method"));
addField(Translator.localize("label.name"),
                 getNameTextField());
addField(Translator.localize("label.owner"),
                 getOwnerScroll());
addField(Translator.localize("label.specification"),
                 new UMLComboBoxNavigator(
                     Translator
                     .localize("label.specification.navigate.tooltip"),
                     getSpecificationComboBox()));
add(getVisibilityPanel());
JPanel modifiersPanel = createBorderPanel(Translator.localize(
                                    "label.modifiers"));
modifiersPanel.add(new UMLBehavioralFeatureQueryCheckBox());
modifiersPanel.add(new UMLFeatureOwnerScopeCheckBox());
add(modifiersPanel);
addSeparator();
UMLExpressionModel2 procedureModel =
            new UMLMethodProcedureExpressionModel(
            this, "");
addField(Translator.localize("label.language"),
                 new UMLExpressionLanguageField(procedureModel,
                                                false));
JScrollPane bodyPane = new JScrollPane(
            new UMLExpressionBodyField(
                procedureModel, true));
addField(Translator.localize("label.body"), bodyPane);
addAction(new ActionNavigateOwner());
addAction(getDeleteAction());
} 

private static class ActionSetMethodSpecification extends UndoableAction
  { 
public void actionPerformed(ActionEvent e)
        { 
super.actionPerformed(e);
Object source = e.getSource();
Object oldOperation = null;
Object newOperation = null;
Object method = null;
if(source instanceof UMLComboBox2)//1
{ 
UMLComboBox2 box = (UMLComboBox2) source;
Object o = box.getTarget();
if(Model.getFacade().isAMethod(o))//1
{ 
method = o;
oldOperation =
                        Model.getCoreHelper().getSpecification(method);
} 

o = box.getSelectedItem();
if(Model.getFacade().isAOperation(o))//1
{ 
newOperation = o;
} 

} 

if(newOperation != oldOperation && method != null)//1
{ 
Model.getCoreHelper().setSpecification(method, newOperation);
} 

} 

protected ActionSetMethodSpecification()
        { 
super(Translator.localize("Set"), null);
putValue(Action.SHORT_DESCRIPTION,
                     Translator.localize("Set"));
} 

 } 

private static class UMLMethodSpecificationComboBoxModel extends UMLComboBoxModel2
  { 
protected boolean isValidElement(Object element)
        { 
Object specification =
                Model.getCoreHelper().getSpecification(getTarget());
return specification == element;
} 

public UMLMethodSpecificationComboBoxModel()
        { 
super("specification", false);
Model.getPump().addClassModelEventListener(this,
                    Model.getMetaTypes().getOperation(), "method");
} 

public void modelChanged(UmlChangeEvent evt)
        { 
if(evt instanceof AttributeChangeEvent)//1
{ 
if(evt.getPropertyName().equals("specification"))//1
{ 
if(evt.getSource() == getTarget()
                            && (getChangedElement(evt) != null))//1
{ 
Object elem = getChangedElement(evt);
setSelectedItem(elem);
} 

} 

} 

} 

protected Object getSelectedModelElement()
        { 
return Model.getCoreHelper().getSpecification(getTarget());
} 

protected void buildModelList()
        { 
if(getTarget() != null)//1
{ 
removeAllElements();
Object classifier = Model.getFacade().getOwner(getTarget());
addAll(Model.getFacade().getOperations(classifier));
} 

} 

 } 

 } 


