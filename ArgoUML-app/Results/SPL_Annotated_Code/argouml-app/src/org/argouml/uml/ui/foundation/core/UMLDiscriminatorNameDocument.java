// Compilation Unit of /UMLDiscriminatorNameDocument.java 
 
package org.argouml.uml.ui.foundation.core;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLPlainTextDocument;
public class UMLDiscriminatorNameDocument extends UMLPlainTextDocument
  { 
protected void setProperty(String text)
    { 
Model.getCoreHelper().setDiscriminator(getTarget(), text);
} 

public UMLDiscriminatorNameDocument()
    { 
super("discriminator");
} 

protected String getProperty()
    { 
return (String) Model.getFacade().getDiscriminator(getTarget());
} 

 } 


