// Compilation Unit of /UMLDiagramNameDocument.java 
 
package org.argouml.uml.ui.foundation.core;
import java.beans.PropertyVetoException;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramUtils;
import org.argouml.uml.ui.UMLPlainTextDocument;
public class UMLDiagramNameDocument extends UMLPlainTextDocument
  { 
protected String getProperty()
    { 
Object target = DiagramUtils.getActiveDiagram();
if(target instanceof ArgoDiagram)//1
{ 
return ((ArgoDiagram) target).getName();
} 

return "";
} 

public UMLDiagramNameDocument()
    { 
super("name");
} 

protected void setProperty(String text)
    { 
Object target = DiagramUtils.getActiveDiagram();
if(target instanceof ArgoDiagram)//1
{ 
try //1
{ 
((ArgoDiagram) target).setName(text);
} 
catch (PropertyVetoException e) //1
{ 
} 


} 

} 

 } 


