package org.argouml.uml.diagram.use_case.ui;
import org.argouml.uml.ui.PropPanel;
import org.argouml.uml.ui.PropPanelFactory;
public class UseCaseDiagramPropPanelFactory implements PropPanelFactory
  { 
public PropPanel createPropPanel(Object object)
    { 
if(object instanceof UMLUseCaseDiagram)//1
{ 
return new PropPanelUMLUseCaseDiagram();
} 
return null;
} 

 } 
