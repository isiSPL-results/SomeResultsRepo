
//#if 1897752371 
// Compilation Unit of /UMLAssociationEndNavigableCheckBox.java 
 

//#if -1381789220 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -380859247 
import org.argouml.i18n.Translator;
//#endif 


//#if 442779607 
import org.argouml.model.Model;
//#endif 


//#if 1497272352 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if 1301689217 
public class UMLAssociationEndNavigableCheckBox extends 
//#if -710729025 
UMLCheckBox2
//#endif 

  { 

//#if 446965342 
public UMLAssociationEndNavigableCheckBox()
    { 

//#if 770525739 
super(Translator.localize("label.navigable"),
              ActionSetAssociationEndNavigable.getInstance(), "isNavigable");
//#endif 

} 

//#endif 


//#if -1677616451 
public void buildModel()
    { 

//#if 53972836 
if(getTarget() != null)//1
{ 

//#if 1218008989 
setSelected(Model.getFacade().isNavigable(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

