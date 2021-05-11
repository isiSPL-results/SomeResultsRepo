
//#if -1113583930 
// Compilation Unit of /UMLActionAsynchronousCheckBox.java 
 

//#if 1285266175 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if -1320331928 
import org.argouml.i18n.Translator;
//#endif 


//#if 1088492590 
import org.argouml.model.Model;
//#endif 


//#if 795940215 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if -1868442885 
public class UMLActionAsynchronousCheckBox extends 
//#if -1590544460 
UMLCheckBox2
//#endif 

  { 

//#if 1501515892 
public UMLActionAsynchronousCheckBox()
    { 

//#if 889246553 
super(Translator.localize("checkbox.asynchronous"),
              ActionSetActionAsynchronous.getInstance(), "isAsynchronous");
//#endif 

} 

//#endif 


//#if -576274062 
public void buildModel()
    { 

//#if -1618774737 
if(getTarget() != null)//1
{ 

//#if 723610584 
setSelected(Model.getFacade().isAsynchronous(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

