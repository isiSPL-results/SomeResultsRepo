
//#if -2138340176 
// Compilation Unit of /UMLModelElementNameDocument.java 
 

//#if -1593761616 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 824341675 
import org.argouml.model.Model;
//#endif 


//#if -1955343887 
import org.argouml.uml.ui.UMLPlainTextDocument;
//#endif 


//#if 1214051728 
public class UMLModelElementNameDocument extends 
//#if -1293549325 
UMLPlainTextDocument
//#endif 

  { 

//#if 1489774722 
protected String getProperty()
    { 

//#if -1842924035 
return Model.getFacade().getName(getTarget());
//#endif 

} 

//#endif 


//#if -1153095635 
protected void setProperty(String text)
    { 

//#if -2107556318 
Model.getCoreHelper().setName(getTarget(), text);
//#endif 

} 

//#endif 


//#if -402722512 
public UMLModelElementNameDocument()
    { 

//#if -1053822033 
super("name");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

