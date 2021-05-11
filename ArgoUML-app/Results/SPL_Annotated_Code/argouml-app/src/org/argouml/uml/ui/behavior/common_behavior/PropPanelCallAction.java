// Compilation Unit of /PropPanelCallAction.java 
 
package org.argouml.uml.ui.behavior.common_behavior;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.argouml.i18n.Translator;
import org.argouml.model.AttributeChangeEvent;
import org.argouml.model.Model;
import org.argouml.model.UmlChangeEvent;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.ui.UMLComboBox2;
import org.argouml.uml.ui.UMLComboBoxModel2;
import org.argouml.uml.ui.UMLComboBoxNavigator;
import org.argouml.uml.ui.UMLSearchableComboBox;
import org.tigris.gef.undo.UndoableAction;
public class PropPanelCallAction extends PropPanelAction
  { 
private static final long serialVersionUID = 6998109319912301992L;
@Override
    public void initialize()
    { 
super.initialize();
UMLSearchableComboBox operationComboBox =
            new UMLCallActionOperationComboBox2(
            new UMLCallActionOperationComboBoxModel());
addFieldBefore(Translator.localize("label.operation"),
                       new UMLComboBoxNavigator(
                           Translator.localize("label.operation.navigate.tooltip"),
                           operationComboBox),
                       argumentsScroll);
} 

public PropPanelCallAction()
    { 
super("label.call-action", lookupIcon("CallAction"));
} 

private static class UMLCallActionOperationComboBox2 extends UMLSearchableComboBox
  { 
private static final long serialVersionUID = 1453984990567492914L;
public UMLCallActionOperationComboBox2(UMLComboBoxModel2 arg0)
        { 
super(arg0, new SetActionOperationAction());
setEditable(false);
} 

 } 

private static class UMLCallActionOperationComboBoxModel extends UMLComboBoxModel2
  { 
private static final long serialVersionUID = 7752478921939209157L;
protected boolean isValidElement(Object element)
        { 
Object target = TargetManager.getInstance().getModelTarget();
if(Model.getFacade().isACallAction(target))//1
{ 
return element == Model.getFacade().getOperation(target);
} 

return false;
} 

public UMLCallActionOperationComboBoxModel()
        { 
super("operation", true);
} 

protected Object getSelectedModelElement()
        { 
Object target = TargetManager.getInstance().getModelTarget();
if(Model.getFacade().isACallAction(target))//1
{ 
return Model.getFacade().getOperation(target);
} 

return null;
} 

protected void buildModelList()
        { 
Object target = TargetManager.getInstance().getModelTarget();
Collection ops = new ArrayList();
if(Model.getFacade().isACallAction(target))//1
{ 
Object ns = Model.getFacade().getModelElementContainer(target);
while (!Model.getFacade().isAPackage(ns)) //1
{ 
ns = Model.getFacade().getModelElementContainer(ns);
if(ns == null)//1
{ 
break;

} 

} 

if(Model.getFacade().isANamespace(ns))//1
{ 
Collection c =
                        Model.getModelManagementHelper()
                        .getAllModelElementsOfKind(
                            ns,
                            Model.getMetaTypes().getClassifier());
Iterator i = c.iterator();
while (i.hasNext()) //1
{ 
ops.addAll(Model.getFacade().getOperations(i.next()));
} 

} 

Object current = Model.getFacade().getOperation(target);
if(Model.getFacade().isAOperation(current))//1
{ 
if(!ops.contains(current))//1
{ 
ops.add(current);
} 

} 

} 

setElements(ops);
} 

@Override
        public void modelChanged(UmlChangeEvent evt)
        { 
if(evt instanceof AttributeChangeEvent)//1
{ 
if(evt.getPropertyName().equals("operation"))//1
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

 } 

private static class SetActionOperationAction extends UndoableAction
  { 
private static final long serialVersionUID = -3574312020866131632L;
public SetActionOperationAction()
        { 
super("");
} 

public void actionPerformed(ActionEvent e)
        { 
super.actionPerformed(e);
Object source = e.getSource();
if(source instanceof UMLComboBox2)//1
{ 
Object selected = ((UMLComboBox2) source).getSelectedItem();
Object target = ((UMLComboBox2) source).getTarget();
if(Model.getFacade().isACallAction(target)
                        && Model.getFacade().isAOperation(selected))//1
{ 
if(Model.getFacade().getOperation(target) != selected)//1
{ 
Model.getCommonBehaviorHelper()
                        .setOperation(target, selected);
} 

} 

} 

} 

 } 

 } 


