
//#if -476183216 
// Compilation Unit of /UMLDiscriminatorNameDocument.java 
 

//#if 309981007 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 895285706 
import org.argouml.model.Model;
//#endif 


//#if -527025904 
import org.argouml.uml.ui.UMLPlainTextDocument;
//#endif 


//#if 1004937356 
public class UMLDiscriminatorNameDocument extends 
//#if -1319453768 
UMLPlainTextDocument
//#endif 

  { 

//#if -809649934 
protected void setProperty(String text)
    { 

//#if -275407102 
Model.getCoreHelper().setDiscriminator(getTarget(), text);
//#endif 

} 

//#endif 


//#if -528508142 
public UMLDiscriminatorNameDocument()
    { 

//#if 1597402589 
super("discriminator");
//#endif 

} 

//#endif 


//#if 1955614279 
protected String getProperty()
    { 

//#if 1951987146 
return (String) Model.getFacade().getDiscriminator(getTarget());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

