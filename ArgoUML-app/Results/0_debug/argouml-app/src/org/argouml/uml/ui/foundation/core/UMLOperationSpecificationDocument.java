
//#if -806618068 
// Compilation Unit of /UMLOperationSpecificationDocument.java 
 

//#if 1926636676 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 773822079 
import org.argouml.model.Model;
//#endif 


//#if -1598370875 
import org.argouml.uml.ui.UMLPlainTextDocument;
//#endif 


//#if 1558637378 
public class UMLOperationSpecificationDocument extends 
//#if 972357887 
UMLPlainTextDocument
//#endif 

  { 

//#if 617406495 
private static final long serialVersionUID = -152721992761681537L;
//#endif 


//#if 206213177 
protected void setProperty(String text)
    { 

//#if -537535455 
if(Model.getFacade().isAOperation(getTarget())
                || Model.getFacade().isAReception(getTarget()))//1
{ 

//#if 688681076 
Model.getCoreHelper().setSpecification(getTarget(), text);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 359945410 
public UMLOperationSpecificationDocument()
    { 

//#if 597467910 
super("specification");
//#endif 

} 

//#endif 


//#if 1410358414 
protected String getProperty()
    { 

//#if -1046758996 
if(Model.getFacade().isAOperation(getTarget())
                || Model.getFacade().isAReception(getTarget()))//1
{ 

//#if -1789090568 
return Model.getFacade().getSpecification(getTarget());
//#endif 

} 

//#endif 


//#if 2017781093 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

