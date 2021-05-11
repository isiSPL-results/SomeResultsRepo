
//#if 1021112586 
// Compilation Unit of /UMLStructuralFeatureTargetScopeCheckBox.java 
 

//#if 976892125 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -1362183022 
import org.argouml.i18n.Translator;
//#endif 


//#if 1253613656 
import org.argouml.model.Model;
//#endif 


//#if 842454945 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if 2014163505 

//#if 2104190022 
@Deprecated
//#endif 

public class UMLStructuralFeatureTargetScopeCheckBox extends 
//#if 336922312 
UMLCheckBox2
//#endif 

  { 

//#if 745588614 
public void buildModel()
    { 

//#if 474801376 
if(Model.getFacade().getTargetScope(getTarget()) == null)//1
{ 

//#if -878435881 
Model.getCoreHelper().setTargetScope(getTarget(),
                                                 Model.getScopeKind().getInstance());
//#endif 

} 

//#endif 


//#if 1256498513 
setSelected(Model.getFacade().getTargetScope(getTarget()).equals(
                        Model.getScopeKind().getClassifier()));
//#endif 

} 

//#endif 


//#if 1395596268 
public UMLStructuralFeatureTargetScopeCheckBox()
    { 

//#if -1728414136 
super(Translator.localize("label.classifier"),
              ActionSetStructuralFeatureTargetScope.getInstance(),
              "targetScope");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

