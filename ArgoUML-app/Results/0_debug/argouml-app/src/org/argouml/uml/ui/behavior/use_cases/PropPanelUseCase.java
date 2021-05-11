
//#if 187798677 
// Compilation Unit of /PropPanelUseCase.java 
 

//#if -194345345 
package org.argouml.uml.ui.behavior.use_cases;
//#endif 


//#if -77124080 
import javax.swing.JList;
//#endif 


//#if -654302343 
import javax.swing.JScrollPane;
//#endif 


//#if 57783285 
import org.argouml.uml.ui.ActionNavigateNamespace;
//#endif 


//#if 130499934 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if -670400540 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if -175374136 
import org.argouml.uml.ui.foundation.core.ActionAddAttribute;
//#endif 


//#if -576835747 
import org.argouml.uml.ui.foundation.core.ActionAddOperation;
//#endif 


//#if -1026025445 
import org.argouml.uml.ui.foundation.core.PropPanelClassifier;
//#endif 


//#if 1799132838 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if 730519381 
public class PropPanelUseCase extends 
//#if 1634429535 
PropPanelClassifier
//#endif 

  { 

//#if -1865167352 
private static final long serialVersionUID = 8352300400553000518L;
//#endif 


//#if 671539331 
public PropPanelUseCase()
    { 

//#if 1797959381 
super("label.usecase", lookupIcon("UseCase"));
//#endif 


//#if 854570653 
addField("label.name", getNameTextField());
//#endif 


//#if -24878509 
addField("label.namespace", getNamespaceSelector());
//#endif 


//#if 334661518 
add(getModifiersPanel());
//#endif 


//#if 734652736 
addField("label.client-dependencies", getClientDependencyScroll());
//#endif 


//#if -2071846846 
addField("label.supplier-dependencies", getSupplierDependencyScroll());
//#endif 


//#if -939342694 
addSeparator();
//#endif 


//#if 681410490 
addField("label.generalizations", getGeneralizationScroll());
//#endif 


//#if -1052521768 
addField("label.specializations", getSpecializationScroll());
//#endif 


//#if -32207124 
JList extendsList = new UMLLinkedList(new UMLUseCaseExtendListModel());
//#endif 


//#if -2037422829 
addField("label.extends",
                 new JScrollPane(extendsList));
//#endif 


//#if -1875446908 
JList includesList =
            new UMLLinkedList(
            new UMLUseCaseIncludeListModel());
//#endif 


//#if 2133131911 
addField("label.includes",
                 new JScrollPane(includesList));
//#endif 


//#if 2048750456 
addSeparator();
//#endif 


//#if 2084436016 
addField("label.attributes",
                 getAttributeScroll());
//#endif 


//#if -1967226055 
addField("label.association-ends",
                 getAssociationEndScroll());
//#endif 


//#if -645701424 
addField("label.operations",
                 getOperationScroll());
//#endif 


//#if 758783268 
JList extensionPoints =
            new UMLMutableLinkedList(
            new UMLUseCaseExtensionPointListModel(), null,
            ActionNewUseCaseExtensionPoint.SINGLETON);
//#endif 


//#if -2060542082 
addField("label.extension-points",
                 new JScrollPane(extensionPoints));
//#endif 


//#if -606999532 
addAction(new ActionNavigateNamespace());
//#endif 


//#if 645118387 
addAction(new ActionNewUseCase());
//#endif 


//#if -302671877 
addAction(new ActionNewExtensionPoint());
//#endif 


//#if 1318724823 
addAction(new ActionAddAttribute());
//#endif 


//#if -1435176414 
addAction(new ActionAddOperation());
//#endif 


//#if 1437402657 
addAction(getActionNewReception());
//#endif 


//#if 90654108 
addAction(new ActionNewStereotype());
//#endif 


//#if -1592112067 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

