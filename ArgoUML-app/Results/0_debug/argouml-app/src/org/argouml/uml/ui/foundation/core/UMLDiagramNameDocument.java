
//#if -955638879 
// Compilation Unit of /UMLDiagramNameDocument.java 
 

//#if -682614903 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -107832270 
import java.beans.PropertyVetoException;
//#endif 


//#if -1111298877 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 582164891 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if -234505142 
import org.argouml.uml.ui.UMLPlainTextDocument;
//#endif 


//#if -101513655 
public class UMLDiagramNameDocument extends 
//#if -30116926 
UMLPlainTextDocument
//#endif 

  { 

//#if -757179311 
protected String getProperty()
    { 

//#if 597218832 
Object target = DiagramUtils.getActiveDiagram();
//#endif 


//#if -341842422 
if(target instanceof ArgoDiagram)//1
{ 

//#if 897892038 
return ((ArgoDiagram) target).getName();
//#endif 

} 

//#endif 


//#if 84078523 
return "";
//#endif 

} 

//#endif 


//#if -1513061421 
public UMLDiagramNameDocument()
    { 

//#if 561684213 
super("name");
//#endif 

} 

//#endif 


//#if -2000020228 
protected void setProperty(String text)
    { 

//#if -604723094 
Object target = DiagramUtils.getActiveDiagram();
//#endif 


//#if -382728208 
if(target instanceof ArgoDiagram)//1
{ 

//#if -1691822897 
try //1
{ 

//#if 130581162 
((ArgoDiagram) target).setName(text);
//#endif 

} 

//#if -1313423886 
catch (PropertyVetoException e) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

