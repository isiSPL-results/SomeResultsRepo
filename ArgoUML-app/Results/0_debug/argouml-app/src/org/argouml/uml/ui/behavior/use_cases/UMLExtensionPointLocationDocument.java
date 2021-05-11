
//#if 1986800295 
// Compilation Unit of /UMLExtensionPointLocationDocument.java 
 

//#if -642493709 
package org.argouml.uml.ui.behavior.use_cases;
//#endif 


//#if 1281008917 
import org.argouml.model.Model;
//#endif 


//#if 1990323803 
import org.argouml.uml.ui.UMLPlainTextDocument;
//#endif 


//#if 1847505378 
public class UMLExtensionPointLocationDocument extends 
//#if 89472642 
UMLPlainTextDocument
//#endif 

  { 

//#if -662870084 
protected void setProperty(String text)
    { 

//#if 1160509407 
Model.getUseCasesHelper().setLocation(getTarget(), text);
//#endif 

} 

//#endif 


//#if -1502334167 
public UMLExtensionPointLocationDocument()
    { 

//#if 1786728968 
super("location");
//#endif 

} 

//#endif 


//#if -320313583 
protected String getProperty()
    { 

//#if 1269649663 
return Model.getFacade().getLocation(getTarget());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

