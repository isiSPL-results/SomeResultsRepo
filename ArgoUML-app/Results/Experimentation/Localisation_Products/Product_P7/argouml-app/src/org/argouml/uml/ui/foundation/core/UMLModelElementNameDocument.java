package org.argouml.uml.ui.foundation.core;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLPlainTextDocument;
public class UMLModelElementNameDocument extends UMLPlainTextDocument
  { 
protected String getProperty()
    { 
return Model.getFacade().getName(getTarget());
} 
protected void setProperty(String text)
    { 
Model.getCoreHelper().setName(getTarget(), text);
} 
public UMLModelElementNameDocument()
    { 
super("name");
} 

 } 
