package org.argouml.uml.ui.foundation.core;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLPlainTextDocument;
public class UMLOperationSpecificationDocument extends UMLPlainTextDocument
  { 
private static final long serialVersionUID = -152721992761681537L;
protected void setProperty(String text)
    { 
if(Model.getFacade().isAOperation(getTarget())
                || Model.getFacade().isAReception(getTarget()))//1
{ 
Model.getCoreHelper().setSpecification(getTarget(), text);
} 
} 
public UMLOperationSpecificationDocument()
    { 
super("specification");
} 
protected String getProperty()
    { 
if(Model.getFacade().isAOperation(getTarget())
                || Model.getFacade().isAReception(getTarget()))//1
{ 
return Model.getFacade().getSpecification(getTarget());
} 
return null;
} 

 } 
