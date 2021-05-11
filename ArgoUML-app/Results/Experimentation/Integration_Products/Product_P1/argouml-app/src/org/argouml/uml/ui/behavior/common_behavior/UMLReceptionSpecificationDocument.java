package org.argouml.uml.ui.behavior.common_behavior;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLPlainTextDocument;
public class UMLReceptionSpecificationDocument extends UMLPlainTextDocument
  { 
protected void setProperty(String text)
    { 
if(Model.getFacade().isAReception(getTarget()))//1
{ 
Model.getCommonBehaviorHelper().setSpecification(getTarget(), text);
} 
} 
public UMLReceptionSpecificationDocument()
    { 
super("specification");
} 
protected String getProperty()
    { 
if(Model.getFacade().isAReception(getTarget()))//1
{ 
return Model.getFacade().getSpecification(getTarget());
} 
return null;
} 

 } 
