
//#if 1797734549 
// Compilation Unit of /UMLCompositeStateConcurrentCheckBox.java 
 

//#if 703230504 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 906388601 
import org.argouml.i18n.Translator;
//#endif 


//#if 139875263 
import org.argouml.model.Model;
//#endif 


//#if -2080754680 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if -1038075889 

//#if 1091011447 
@Deprecated
//#endif 

public class UMLCompositeStateConcurrentCheckBox extends 
//#if -1006842441 
UMLCheckBox2
//#endif 

  { 

//#if 1264316341 
public void buildModel()
    { 

//#if -1838325380 
setSelected(Model.getFacade().isConcurrent(getTarget()));
//#endif 

} 

//#endif 


//#if -799014188 
public UMLCompositeStateConcurrentCheckBox()
    { 

//#if -1877609967 
super(Translator.localize("label.concurrent"),
              ActionSetCompositeStateConcurrent.getInstance(),
              "isConcurent");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

