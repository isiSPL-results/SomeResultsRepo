
//#if 1171920654 
// Compilation Unit of /PropPanelComponent.java 
 

//#if -1907470314 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1916081688 
import javax.swing.JList;
//#endif 


//#if -1896749695 
import javax.swing.JScrollPane;
//#endif 


//#if 1636705483 
import org.argouml.i18n.Translator;
//#endif 


//#if -547134227 
import org.argouml.uml.ui.ActionNavigateNamespace;
//#endif 


//#if -1157936042 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if -701783138 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if 266776691 
public class PropPanelComponent extends 
//#if 375437144 
PropPanelClassifier
//#endif 

  { 

//#if 1187071156 
private static final long serialVersionUID = 1551050121647608478L;
//#endif 


//#if 1514183888 
public PropPanelComponent()
    { 

//#if 1670999229 
super("label.component", lookupIcon("Component"));
//#endif 


//#if -1432709629 
addField(Translator.localize("label.name"), getNameTextField());
//#endif 


//#if 1374782839 
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
//#endif 


//#if 736374358 
add(getModifiersPanel());
//#endif 


//#if 1288226146 
addSeparator();
//#endif 


//#if -1889188082 
addField(Translator.localize("label.generalizations"),
                 getGeneralizationScroll());
//#endif 


//#if 654073454 
addField(Translator.localize("label.specializations"),
                 getSpecializationScroll());
//#endif 


//#if 2012372400 
addSeparator();
//#endif 


//#if -1154171268 
addField(Translator.localize("label.client-dependencies"),
                 getClientDependencyScroll());
//#endif 


//#if 2000138716 
addField(Translator.localize("label.supplier-dependencies"),
                 getSupplierDependencyScroll());
//#endif 


//#if 31784015 
JList resList = new UMLLinkedList(new UMLComponentResidentListModel());
//#endif 


//#if 1251917710 
addField(Translator.localize("label.residents"),
                 new JScrollPane(resList));
//#endif 


//#if -1818960820 
addAction(new ActionNavigateNamespace());
//#endif 


//#if -1829580055 
addAction(getActionNewReception());
//#endif 


//#if 1893405140 
addAction(new ActionNewStereotype());
//#endif 


//#if -2033496315 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

