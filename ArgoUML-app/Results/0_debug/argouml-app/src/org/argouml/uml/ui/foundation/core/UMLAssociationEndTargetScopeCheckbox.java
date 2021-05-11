
//#if 359450489 
// Compilation Unit of /UMLAssociationEndTargetScopeCheckbox.java 
 

//#if 892120443 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 304002864 
import org.argouml.i18n.Translator;
//#endif 


//#if -117794314 
import org.argouml.model.Model;
//#endif 


//#if 564941631 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if -11317366 
public class UMLAssociationEndTargetScopeCheckbox extends 
//#if 1095065442 
UMLCheckBox2
//#endif 

  { 

//#if 1151457865 
public UMLAssociationEndTargetScopeCheckbox()
    { 

//#if -63526278 
super(Translator.localize("label.static"),
              ActionSetAssociationEndTargetScope.getInstance(),
              "targetScope");
//#endif 

} 

//#endif 


//#if -861493344 
public void buildModel()
    { 

//#if 1842428271 
if(getTarget() != null)//1
{ 

//#if 165278625 
Object associationEnd = getTarget();
//#endif 


//#if 71644596 
setSelected(Model.getFacade().isStatic(associationEnd));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

