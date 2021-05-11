
//#if -794865295 
// Compilation Unit of /PropPanelDataType.java 
 

//#if 268597466 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 177736614 
import java.awt.event.ActionEvent;
//#endif 


//#if 1744445212 
import javax.swing.Action;
//#endif 


//#if 643387536 
import javax.swing.ImageIcon;
//#endif 


//#if -1093097508 
import javax.swing.JList;
//#endif 


//#if 2099909701 
import javax.swing.JScrollPane;
//#endif 


//#if 113856911 
import org.argouml.i18n.Translator;
//#endif 


//#if -955461068 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 848772053 
import org.argouml.model.Model;
//#endif 


//#if -115160211 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1870775586 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if -753178921 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if -2041480686 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if 959292506 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if 439174034 
public class PropPanelDataType extends 
//#if -398201083 
PropPanelClassifier
//#endif 

  { 

//#if 440722912 
private JScrollPane operationScroll;
//#endif 


//#if -1548299217 
private static UMLClassOperationListModel operationListModel =
        new UMLClassOperationListModel();
//#endif 


//#if -16327694 
private static final long serialVersionUID = -8752986130386737802L;
//#endif 


//#if 1865208736 
public PropPanelDataType()
    { 

//#if -323806464 
this("label.data-type", lookupIcon("DataType"));
//#endif 

} 

//#endif 


//#if -740546362 
@Override
    public JScrollPane getOperationScroll()
    { 

//#if 2012968872 
if(operationScroll == null)//1
{ 

//#if -1167275271 
JList list = new UMLLinkedList(operationListModel);
//#endif 


//#if 2114085485 
operationScroll = new JScrollPane(list);
//#endif 

} 

//#endif 


//#if -1203360889 
return operationScroll;
//#endif 

} 

//#endif 


//#if -471190806 
public PropPanelDataType(String title, ImageIcon icon)
    { 

//#if 2025300597 
super(title, icon);
//#endif 


//#if 170065966 
addField(Translator.localize("label.name"),
                 getNameTextField());
//#endif 


//#if 1553357740 
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
//#endif 


//#if 562217153 
add(getModifiersPanel());
//#endif 


//#if -1428861985 
add(getVisibilityPanel());
//#endif 


//#if -771993203 
addSeparator();
//#endif 


//#if 918296487 
addField(Translator.localize("label.client-dependencies"),
                 getClientDependencyScroll());
//#endif 


//#if -1077379705 
addField(Translator.localize("label.supplier-dependencies"),
                 getSupplierDependencyScroll());
//#endif 


//#if 889560185 
addField(Translator.localize("label.generalizations"),
                 getGeneralizationScroll());
//#endif 


//#if -862145575 
addField(Translator.localize("label.specializations"),
                 getSpecializationScroll());
//#endif 


//#if 1100406181 
addSeparator();
//#endif 


//#if -989857665 
addField(Translator.localize("label.operations"),
                 getOperationScroll());
//#endif 


//#if 413849499 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if 2115102428 
addAction(new ActionAddDataType());
//#endif 


//#if -486934104 
addEnumerationButtons();
//#endif 


//#if -2000690921 
addAction(new ActionAddQueryOperation());
//#endif 


//#if -200450423 
addAction(new ActionNewStereotype());
//#endif 


//#if -1934314512 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if -1642425321 
protected void addEnumerationButtons()
    { 

//#if -1780408973 
addAction(new ActionAddEnumeration());
//#endif 

} 

//#endif 


//#if 388753414 
private static class ActionAddQueryOperation extends 
//#if 2031104230 
AbstractActionNewModelElement
//#endif 

  { 

//#if 1927390374 
private static final long serialVersionUID = -3393730108010236394L;
//#endif 


//#if -923045363 
public ActionAddQueryOperation()
        { 

//#if 265521104 
super("button.new-operation");
//#endif 


//#if 1248450798 
putValue(Action.NAME, Translator.localize("button.new-operation"));
//#endif 

} 

//#endif 


//#if -1370447594 
@Override
        public void actionPerformed(ActionEvent e)
        { 

//#if 428564335 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 1006503261 
if(Model.getFacade().isAClassifier(target))//1
{ 

//#if -1378149040 
Object returnType =
                    ProjectManager.getManager()
                    .getCurrentProject().getDefaultReturnType();
//#endif 


//#if -1082145189 
Object newOper =
                    Model.getCoreFactory()
                    .buildOperation(target, returnType);
//#endif 


//#if 954365311 
Model.getCoreHelper().setQuery(newOper, true);
//#endif 


//#if 1076014853 
TargetManager.getInstance().setTarget(newOper);
//#endif 


//#if 470644948 
super.actionPerformed(e);
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

