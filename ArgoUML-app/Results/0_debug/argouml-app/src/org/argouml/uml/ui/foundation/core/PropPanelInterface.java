
//#if 875602611 
// Compilation Unit of /PropPanelInterface.java 
 

//#if -1108216942 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -1352989625 
import org.argouml.i18n.Translator;
//#endif 


//#if 319036913 
import org.argouml.uml.ui.ActionNavigateNamespace;
//#endif 


//#if -1154715998 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if 2040095667 
public class PropPanelInterface extends 
//#if 555664573 
PropPanelClassifier
//#endif 

  { 

//#if 470404044 
private static final long serialVersionUID = 849399652073446108L;
//#endif 


//#if 2046022919 
public PropPanelInterface()
    { 

//#if -1778819733 
super("label.interface", lookupIcon("Interface"));
//#endif 


//#if -982818383 
addField(Translator.localize("label.name"), getNameTextField());
//#endif 


//#if -1480589943 
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
//#endif 


//#if 1839139972 
add(getModifiersPanel());
//#endif 


//#if -498960260 
add(getVisibilityPanel());
//#endif 


//#if 1718412560 
addSeparator();
//#endif 


//#if 2072494908 
addField(Translator.localize("label.generalizations"),
                 getGeneralizationScroll());
//#endif 


//#if 320789148 
addField(Translator.localize("label.specializations"),
                 getSpecializationScroll());
//#endif 


//#if 1513420610 
addSeparator();
//#endif 


//#if 1002566711 
addField(Translator.localize("label.association-ends"),
                 getAssociationEndScroll());
//#endif 


//#if 1998526240 
addField(Translator.localize("label.features"),
                 getFeatureScroll());
//#endif 


//#if 1832393822 
addAction(new ActionNavigateNamespace());
//#endif 


//#if -586138728 
addAction(new ActionAddOperation());
//#endif 


//#if -2008526953 
addAction(getActionNewReception());
//#endif 


//#if -2012201013 
addAction(new ActionNewInterface());
//#endif 


//#if 641018598 
addAction(new ActionNewStereotype());
//#endif 


//#if -1771084237 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

