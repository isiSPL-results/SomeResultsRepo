// Compilation Unit of /SequenceDiagramPropPanelFactory.java 
 
package org.argouml.uml.diagram.sequence.ui;
import org.argouml.uml.ui.PropPanel;
import org.argouml.uml.ui.PropPanelFactory;
public class SequenceDiagramPropPanelFactory implements PropPanelFactory
  { 
public PropPanel createPropPanel(Object object)
    { 
if(object instanceof UMLSequenceDiagram)//1
{ 
return new PropPanelUMLSequenceDiagram();
} 

return null;
} 

 } 


