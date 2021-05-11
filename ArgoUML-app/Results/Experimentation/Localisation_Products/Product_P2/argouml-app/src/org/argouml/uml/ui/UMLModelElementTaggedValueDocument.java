package org.argouml.uml.ui;
import org.argouml.model.Model;
public class UMLModelElementTaggedValueDocument extends UMLPlainTextDocument
  { 
public UMLModelElementTaggedValueDocument(String taggedValue)
    { 
super(taggedValue);
} 
protected void setProperty(String text)
    { 
if(getTarget() != null)//1
{ 
Model.getCoreHelper().setTaggedValue(
                getTarget(),
                getEventName(),
                text);
} 
} 
protected String getProperty()
    { 
String eventName = getEventName();
if(Model.getFacade().isAModelElement(getTarget()))//1
{ 
Object taggedValue =
                Model.getFacade().getTaggedValue(getTarget(), eventName);
if(taggedValue != null)//1
{ 
return Model.getFacade().getValueOfTag(taggedValue);
} 
} 
return "";
} 

 } 
