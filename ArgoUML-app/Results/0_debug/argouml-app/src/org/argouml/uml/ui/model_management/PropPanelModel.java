
//#if 454039833 
// Compilation Unit of /PropPanelModel.java 
 

//#if -789077104 
package org.argouml.uml.ui.model_management;
//#endif 


//#if -329783883 
import javax.swing.JList;
//#endif 


//#if 45075294 
import javax.swing.JScrollPane;
//#endif 


//#if 1442567208 
import org.argouml.i18n.Translator;
//#endif 


//#if -1946193936 
import org.argouml.uml.ui.ActionNavigateNamespace;
//#endif 


//#if -1149256247 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if -1242726359 
import org.argouml.uml.ui.foundation.core.ActionAddDataType;
//#endif 


//#if -84138974 
import org.argouml.uml.ui.foundation.core.ActionAddEnumeration;
//#endif 


//#if -1417094111 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if 704039286 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewTagDefinition;
//#endif 


//#if -2091721310 
public class PropPanelModel extends 
//#if 209890596 
PropPanelPackage
//#endif 

  { 

//#if -420802575 
public PropPanelModel()
    { 

//#if -1091889640 
super("label.model", lookupIcon("Model"));
//#endif 

} 

//#endif 


//#if 273713482 
@Override
    protected void placeElements()
    { 

//#if -724334916 
addField(Translator.localize("label.name"), getNameTextField());
//#endif 


//#if -1982245666 
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
//#endif 


//#if -1278104431 
add(getVisibilityPanel());
//#endif 


//#if -402751025 
add(getModifiersPanel());
//#endif 


//#if -1699386341 
addSeparator();
//#endif 


//#if -144516217 
addField(Translator.localize("label.generalizations"),
                 getGeneralizationScroll());
//#endif 


//#if -1896221977 
addField(Translator.localize("label.specializations"),
                 getSpecializationScroll());
//#endif 


//#if -1638920105 
addSeparator();
//#endif 


//#if -1997493937 
addField(Translator.localize("label.owned-elements"),
                 getOwnedElementsScroll());
//#endif 


//#if 1242089545 
JList importList =
            new UMLMutableLinkedList(new UMLClassifierPackageImportsListModel(),
                                     new ActionAddPackageImport(),
                                     null,
                                     new ActionRemovePackageImport(),
                                     true);
//#endif 


//#if 312643825 
addField(Translator.localize("label.imported-elements"),
                 new JScrollPane(importList));
//#endif 


//#if -920909901 
addAction(new ActionNavigateNamespace());
//#endif 


//#if 685434050 
addAction(new ActionAddPackage());
//#endif 


//#if -1941736050 
addAction(new ActionAddDataType());
//#endif 


//#if 1078715843 
addAction(new ActionAddEnumeration());
//#endif 


//#if 1008076987 
addAction(new ActionNewStereotype());
//#endif 


//#if -1063661654 
addAction(new ActionNewTagDefinition());
//#endif 


//#if 1043152382 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

