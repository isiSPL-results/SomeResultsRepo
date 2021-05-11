
//#if -498482165 
// Compilation Unit of /PropPanelClass.java 
 

//#if 931439910 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -815383075 
import org.argouml.uml.ui.ActionNavigateNamespace;
//#endif 


//#if -1293896562 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if -20967202 
public class PropPanelClass extends 
//#if 615140221 
PropPanelClassifier
//#endif 

  { 

//#if 1595241487 
private static final long serialVersionUID = -8288739384387629966L;
//#endif 


//#if -1849782970 
public PropPanelClass()
    { 

//#if 1106438687 
super("label.class", lookupIcon("Class"));
//#endif 


//#if -83180333 
addField("label.name", getNameTextField());
//#endif 


//#if -1334382371 
addField("label.namespace", getNamespaceSelector());
//#endif 


//#if -1180589800 
getModifiersPanel().add(new UMLClassActiveCheckBox());
//#endif 


//#if -2092093800 
add(getModifiersPanel());
//#endif 


//#if -2108122904 
add(getVisibilityPanel());
//#endif 


//#if -1922641884 
addSeparator();
//#endif 


//#if -1723124362 
addField("label.client-dependencies", getClientDependencyScroll());
//#endif 


//#if 2071355768 
addField("label.supplier-dependencies", getSupplierDependencyScroll());
//#endif 


//#if -213799824 
addField("label.generalizations", getGeneralizationScroll());
//#endif 


//#if -1947732082 
addField("label.specializations", getSpecializationScroll());
//#endif 


//#if 259539886 
addSeparator();
//#endif 


//#if -36016026 
addField("label.attributes", getAttributeScroll());
//#endif 


//#if 346025283 
addField("label.association-ends", getAssociationEndScroll());
//#endif 


//#if 1528813830 
addField("label.operations", getOperationScroll());
//#endif 


//#if 1962260942 
addField("label.owned-elements", getOwnedElementsScroll());
//#endif 


//#if -2069426230 
addAction(new ActionNavigateNamespace());
//#endif 


//#if -687929503 
addAction(new ActionAddAttribute());
//#endif 


//#if 853136556 
addAction(new ActionAddOperation());
//#endif 


//#if -569251669 
addAction(getActionNewReception());
//#endif 


//#if -1832848926 
addAction(new ActionNewInnerClass());
//#endif 


//#if 1306193694 
addAction(new ActionNewClass());
//#endif 


//#if -1986087854 
addAction(new ActionNewStereotype());
//#endif 


//#if 89546311 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

