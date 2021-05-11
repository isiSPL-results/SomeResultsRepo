
//#if -774807237 
// Compilation Unit of /PropPanelCallEvent.java 
 

//#if -30285824 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -505234780 
import java.awt.event.ActionEvent;
//#endif 


//#if 2037882407 
import java.util.ArrayList;
//#endif 


//#if 89443354 
import java.util.Collection;
//#endif 


//#if 416580177 
import org.argouml.i18n.Translator;
//#endif 


//#if 2043485591 
import org.argouml.model.Model;
//#endif 


//#if 2044444267 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 321600794 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if 1717950177 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if 424399541 
import org.argouml.uml.ui.UMLComboBoxNavigator;
//#endif 


//#if -1831561368 
import org.argouml.uml.ui.UMLSearchableComboBox;
//#endif 


//#if -1299464792 
import org.argouml.uml.ui.foundation.core.ActionNewParameter;
//#endif 


//#if 1924492231 
class UMLCallEventOperationComboBoxModel extends 
//#if 1477160909 
UMLComboBoxModel2
//#endif 

  { 

//#if 769325923 
protected boolean isValidElement(Object element)
    { 

//#if 702264080 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if -909257585 
if(Model.getFacade().isACallEvent(target))//1
{ 

//#if 790656577 
return element == Model.getFacade().getOperation(target);
//#endif 

} 

//#endif 


//#if -1275199293 
return false;
//#endif 

} 

//#endif 


//#if 1219779813 
protected Object getSelectedModelElement()
    { 

//#if 1958678288 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 1151662223 
if(Model.getFacade().isACallEvent(target))//1
{ 

//#if 883775806 
return Model.getFacade().getOperation(target);
//#endif 

} 

//#endif 


//#if -1277836055 
return null;
//#endif 

} 

//#endif 


//#if 1840921412 
public UMLCallEventOperationComboBoxModel()
    { 

//#if 1603772703 
super("operation", true);
//#endif 

} 

//#endif 


//#if 33837359 
protected void buildModelList()
    { 

//#if 1998604041 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 1228675878 
Collection ops = new ArrayList();
//#endif 


//#if 1865105398 
if(Model.getFacade().isACallEvent(target))//1
{ 

//#if 1099735023 
Object ns = Model.getFacade().getNamespace(target);
//#endif 


//#if -710451311 
if(Model.getFacade().isANamespace(ns))//1
{ 

//#if -23463412 
Collection classifiers =
                    Model.getModelManagementHelper().getAllModelElementsOfKind(
                        ns,
                        Model.getMetaTypes().getClassifier());
//#endif 


//#if -1903359097 
for (Object classifier : classifiers) //1
{ 

//#if -1775597228 
ops.addAll(Model.getFacade().getOperations(classifier));
//#endif 

} 

//#endif 


//#if -1462049107 
for (Object importedElem : Model.getModelManagementHelper()
                        .getAllImportedElements(ns)) //1
{ 

//#if -2034826716 
if(Model.getFacade().isAClassifier(importedElem))//1
{ 

//#if 765034391 
ops.addAll(Model.getFacade()
                                   .getOperations(importedElem));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1527807583 
setElements(ops);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -962695184 
class UMLCallEventOperationComboBox2 extends 
//#if -1000244496 
UMLSearchableComboBox
//#endif 

  { 

//#if -1567494140 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if 682776059 
super.actionPerformed(e);
//#endif 


//#if -1020872982 
Object source = e.getSource();
//#endif 


//#if -586740816 
if(source instanceof UMLComboBox2)//1
{ 

//#if 1042589367 
Object selected = ((UMLComboBox2) source).getSelectedItem();
//#endif 


//#if -88010358 
Object target = ((UMLComboBox2) source).getTarget();
//#endif 


//#if -1025070714 
if(Model.getFacade().isACallEvent(target)
                    && Model.getFacade().isAOperation(selected))//1
{ 

//#if -2104108030 
if(Model.getFacade().getOperation(target) != selected)//1
{ 

//#if 933106911 
Model.getCommonBehaviorHelper()
                    .setOperation(target, selected);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 911705435 
public UMLCallEventOperationComboBox2(UMLComboBoxModel2 arg0)
    { 

//#if -2011017768 
super(arg0, null);
//#endif 


//#if 949660301 
setEditable(false);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -344249076 
public class PropPanelCallEvent extends 
//#if 1376975351 
PropPanelEvent
//#endif 

  { 

//#if -2020883364 
@Override
    public void initialize()
    { 

//#if 555315880 
super.initialize();
//#endif 


//#if -1500181583 
UMLSearchableComboBox operationComboBox =
            new UMLCallEventOperationComboBox2(
            new UMLCallEventOperationComboBoxModel());
//#endif 


//#if -1658017582 
addField("label.operations",
                 new UMLComboBoxNavigator(
                     Translator.localize("label.operation.navigate.tooltip"),
                     operationComboBox));
//#endif 


//#if -191089710 
addAction(new ActionNewParameter());
//#endif 


//#if -807368438 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if -372681757 
public PropPanelCallEvent()
    { 

//#if -1429182230 
super("label.call-event", lookupIcon("CallEvent"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

