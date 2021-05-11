
//#if 409917117 
// Compilation Unit of /UMLModelElementTaggedValueDocument.java 
 

//#if -967510465 
package org.argouml.uml.ui;
//#endif 


//#if -731154898 
import org.argouml.model.Model;
//#endif 


//#if -2119105613 
public class UMLModelElementTaggedValueDocument extends 
//#if -1560461964 
UMLPlainTextDocument
//#endif 

  { 

//#if 1396620517 
public UMLModelElementTaggedValueDocument(String taggedValue)
    { 

//#if -1709622943 
super(taggedValue);
//#endif 

} 

//#endif 


//#if 318587566 
protected void setProperty(String text)
    { 

//#if 1206542305 
if(getTarget() != null)//1
{ 

//#if 560187806 
Model.getCoreHelper().setTaggedValue(
                getTarget(),
                getEventName(),
                text);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 40064003 
protected String getProperty()
    { 

//#if -1759017209 
String eventName = getEventName();
//#endif 


//#if -1408595655 
if(Model.getFacade().isAModelElement(getTarget()))//1
{ 

//#if -1755168936 
Object taggedValue =
                Model.getFacade().getTaggedValue(getTarget(), eventName);
//#endif 


//#if 1250944266 
if(taggedValue != null)//1
{ 

//#if 374798874 
return Model.getFacade().getValueOfTag(taggedValue);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -874994480 
return "";
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

