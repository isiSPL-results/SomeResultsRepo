// Compilation Unit of /PropPanelUseCase.java 
 
package org.argouml.uml.ui.behavior.use_cases;
import javax.swing.JList;
import javax.swing.JScrollPane;
import org.argouml.uml.ui.ActionNavigateNamespace;
import org.argouml.uml.ui.UMLLinkedList;
import org.argouml.uml.ui.UMLMutableLinkedList;
import org.argouml.uml.ui.foundation.core.ActionAddAttribute;
import org.argouml.uml.ui.foundation.core.ActionAddOperation;
import org.argouml.uml.ui.foundation.core.PropPanelClassifier;
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
public class PropPanelUseCase extends PropPanelClassifier
  { 
private static final long serialVersionUID = 8352300400553000518L;
public PropPanelUseCase()
    { 
super("label.usecase", lookupIcon("UseCase"));
addField("label.name", getNameTextField());
addField("label.namespace", getNamespaceSelector());
add(getModifiersPanel());
addField("label.client-dependencies", getClientDependencyScroll());
addField("label.supplier-dependencies", getSupplierDependencyScroll());
addSeparator();
addField("label.generalizations", getGeneralizationScroll());
addField("label.specializations", getSpecializationScroll());
JList extendsList = new UMLLinkedList(new UMLUseCaseExtendListModel());
addField("label.extends",
                 new JScrollPane(extendsList));
JList includesList =
            new UMLLinkedList(
            new UMLUseCaseIncludeListModel());
addField("label.includes",
                 new JScrollPane(includesList));
addSeparator();
addField("label.attributes",
                 getAttributeScroll());
addField("label.association-ends",
                 getAssociationEndScroll());
addField("label.operations",
                 getOperationScroll());
JList extensionPoints =
            new UMLMutableLinkedList(
            new UMLUseCaseExtensionPointListModel(), null,
            ActionNewUseCaseExtensionPoint.SINGLETON);
addField("label.extension-points",
                 new JScrollPane(extensionPoints));
addAction(new ActionNavigateNamespace());
addAction(new ActionNewUseCase());
addAction(new ActionNewExtensionPoint());
addAction(new ActionAddAttribute());
addAction(new ActionAddOperation());
addAction(getActionNewReception());
addAction(new ActionNewStereotype());
addAction(getDeleteAction());
} 

 } 


