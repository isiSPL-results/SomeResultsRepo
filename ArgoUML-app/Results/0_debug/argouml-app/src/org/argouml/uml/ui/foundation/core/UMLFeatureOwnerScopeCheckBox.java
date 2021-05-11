
//#if -697222560 
// Compilation Unit of /UMLFeatureOwnerScopeCheckBox.java 
 

//#if 2061172130 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1354178135 
import org.argouml.i18n.Translator;
//#endif 


//#if 280669341 
import org.argouml.model.Model;
//#endif 


//#if 31379174 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if -1914751663 
public class UMLFeatureOwnerScopeCheckBox extends 
//#if 1498261523 
UMLCheckBox2
//#endif 

  { 

//#if -1089173743 
public void buildModel()
    { 

//#if -1839818439 
setSelected(Model.getFacade().isStatic(getTarget()));
//#endif 

} 

//#endif 


//#if -1110933752 
public UMLFeatureOwnerScopeCheckBox()
    { 

//#if -714009412 
super(Translator.localize("checkbox.static-lc"),
              ActionSetFeatureOwnerScope.getInstance(), "ownerScope");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

