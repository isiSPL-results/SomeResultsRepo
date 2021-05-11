// Compilation Unit of /UMLExtensionPointLocationDocument.java 
 
package org.argouml.uml.ui.behavior.use_cases;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLPlainTextDocument;
public class UMLExtensionPointLocationDocument extends UMLPlainTextDocument
  { 
protected void setProperty(String text)
    { 
Model.getUseCasesHelper().setLocation(getTarget(), text);
} 

public UMLExtensionPointLocationDocument()
    { 
super("location");
} 

protected String getProperty()
    { 
return Model.getFacade().getLocation(getTarget());
} 

 } 


