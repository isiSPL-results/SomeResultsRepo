
//#if -1758890552 
// Compilation Unit of /UMLReceptionSpecificationDocument.java 
 

//#if 2010714427 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 763539570 
import org.argouml.model.Model;
//#endif 


//#if -1576427592 
import org.argouml.uml.ui.UMLPlainTextDocument;
//#endif 


//#if 2017675149 
public class UMLReceptionSpecificationDocument extends 
//#if 1826599236 
UMLPlainTextDocument
//#endif 

  { 

//#if -1315039618 
protected void setProperty(String text)
    { 

//#if 820921519 
if(Model.getFacade().isAReception(getTarget()))//1
{ 

//#if 547585648 
Model.getCommonBehaviorHelper().setSpecification(getTarget(), text);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1618308299 
public UMLReceptionSpecificationDocument()
    { 

//#if -1292937236 
super("specification");
//#endif 

} 

//#endif 


//#if -4393005 
protected String getProperty()
    { 

//#if 1205045082 
if(Model.getFacade().isAReception(getTarget()))//1
{ 

//#if -1374628970 
return Model.getFacade().getSpecification(getTarget());
//#endif 

} 

//#endif 


//#if -888333610 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

