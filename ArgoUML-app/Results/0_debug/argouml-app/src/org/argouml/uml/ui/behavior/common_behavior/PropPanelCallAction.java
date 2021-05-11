
//#if -1578321185 
// Compilation Unit of /PropPanelCallAction.java 
 

//#if -1157832378 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 2073215668 
import java.awt.event.ActionEvent;
//#endif 


//#if 2107213847 
import java.util.ArrayList;
//#endif 


//#if -2056249302 
import java.util.Collection;
//#endif 


//#if 1298091930 
import java.util.Iterator;
//#endif 


//#if -1255834559 
import org.argouml.i18n.Translator;
//#endif 


//#if -669960328 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if 1711837063 
import org.argouml.model.Model;
//#endif 


//#if 18473456 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if 219784827 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -913457398 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if 402066161 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if -909810523 
import org.argouml.uml.ui.UMLComboBoxNavigator;
//#endif 


//#if -242400392 
import org.argouml.uml.ui.UMLSearchableComboBox;
//#endif 


//#if -1019538102 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 1749910516 
public class PropPanelCallAction extends 
//#if -486411958 
PropPanelAction
//#endif 

  { 

//#if -1497457759 
private static final long serialVersionUID = 6998109319912301992L;
//#endif 


//#if -890498771 
@Override
    public void initialize()
    { 

//#if 1845001363 
super.initialize();
//#endif 


//#if -1517254838 
UMLSearchableComboBox operationComboBox =
            new UMLCallActionOperationComboBox2(
            new UMLCallActionOperationComboBoxModel());
//#endif 


//#if 1306327514 
addFieldBefore(Translator.localize("label.operation"),
                       new UMLComboBoxNavigator(
                           Translator.localize("label.operation.navigate.tooltip"),
                           operationComboBox),
                       argumentsScroll);
//#endif 

} 

//#endif 


//#if 1425566016 
public PropPanelCallAction()
    { 

//#if -966656214 
super("label.call-action", lookupIcon("CallAction"));
//#endif 

} 

//#endif 


//#if -1977079710 
private static class UMLCallActionOperationComboBox2 extends 
//#if 1638155962 
UMLSearchableComboBox
//#endif 

  { 

//#if -1153189119 
private static final long serialVersionUID = 1453984990567492914L;
//#endif 


//#if -1039206615 
public UMLCallActionOperationComboBox2(UMLComboBoxModel2 arg0)
        { 

//#if -30267288 
super(arg0, new SetActionOperationAction());
//#endif 


//#if -1988277666 
setEditable(false);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1894357817 
private static class UMLCallActionOperationComboBoxModel extends 
//#if 1008357103 
UMLComboBoxModel2
//#endif 

  { 

//#if -446170719 
private static final long serialVersionUID = 7752478921939209157L;
//#endif 


//#if -1401851003 
protected boolean isValidElement(Object element)
        { 

//#if 385025525 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 1120816246 
if(Model.getFacade().isACallAction(target))//1
{ 

//#if 200961584 
return element == Model.getFacade().getOperation(target);
//#endif 

} 

//#endif 


//#if 1316875368 
return false;
//#endif 

} 

//#endif 


//#if -1782770246 
public UMLCallActionOperationComboBoxModel()
        { 

//#if 733593383 
super("operation", true);
//#endif 

} 

//#endif 


//#if 618125187 
protected Object getSelectedModelElement()
        { 

//#if -1420038787 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 1810907134 
if(Model.getFacade().isACallAction(target))//1
{ 

//#if 1108962138 
return Model.getFacade().getOperation(target);
//#endif 

} 

//#endif 


//#if 2052130332 
return null;
//#endif 

} 

//#endif 


//#if 1334005073 
protected void buildModelList()
        { 

//#if 1262319294 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 1476542289 
Collection ops = new ArrayList();
//#endif 


//#if -353574209 
if(Model.getFacade().isACallAction(target))//1
{ 

//#if -447820828 
Object ns = Model.getFacade().getModelElementContainer(target);
//#endif 


//#if -21293 
while (!Model.getFacade().isAPackage(ns)) //1
{ 

//#if 718777274 
ns = Model.getFacade().getModelElementContainer(ns);
//#endif 


//#if -877357742 
if(ns == null)//1
{ 

//#if 1640652439 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if -216112471 
if(Model.getFacade().isANamespace(ns))//1
{ 

//#if 718736616 
Collection c =
                        Model.getModelManagementHelper()
                        .getAllModelElementsOfKind(
                            ns,
                            Model.getMetaTypes().getClassifier());
//#endif 


//#if -837899446 
Iterator i = c.iterator();
//#endif 


//#if 1845775845 
while (i.hasNext()) //1
{ 

//#if -1529582706 
ops.addAll(Model.getFacade().getOperations(i.next()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2097864393 
Object current = Model.getFacade().getOperation(target);
//#endif 


//#if -276963121 
if(Model.getFacade().isAOperation(current))//1
{ 

//#if 1199903703 
if(!ops.contains(current))//1
{ 

//#if -804848092 
ops.add(current);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 67259980 
setElements(ops);
//#endif 

} 

//#endif 


//#if -467162693 
@Override
        public void modelChanged(UmlChangeEvent evt)
        { 

//#if 1951380368 
if(evt instanceof AttributeChangeEvent)//1
{ 

//#if 1805091549 
if(evt.getPropertyName().equals("operation"))//1
{ 

//#if 909365173 
if(evt.getSource() == getTarget()
                            && (getChangedElement(evt) != null))//1
{ 

//#if 903480680 
Object elem = getChangedElement(evt);
//#endif 


//#if -1608360219 
setSelectedItem(elem);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1026817113 
private static class SetActionOperationAction extends 
//#if 1617530252 
UndoableAction
//#endif 

  { 

//#if -1754446977 
private static final long serialVersionUID = -3574312020866131632L;
//#endif 


//#if 1708644999 
public SetActionOperationAction()
        { 

//#if -2046290661 
super("");
//#endif 

} 

//#endif 


//#if 2118788629 
public void actionPerformed(ActionEvent e)
        { 

//#if -1086011451 
super.actionPerformed(e);
//#endif 


//#if -18620876 
Object source = e.getSource();
//#endif 


//#if 1416972538 
if(source instanceof UMLComboBox2)//1
{ 

//#if 894147068 
Object selected = ((UMLComboBox2) source).getSelectedItem();
//#endif 


//#if 1694374351 
Object target = ((UMLComboBox2) source).getTarget();
//#endif 


//#if 155647215 
if(Model.getFacade().isACallAction(target)
                        && Model.getFacade().isAOperation(selected))//1
{ 

//#if -2074680665 
if(Model.getFacade().getOperation(target) != selected)//1
{ 

//#if -1659955248 
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

 } 

//#endif 

 } 

//#endif 


//#endif 

