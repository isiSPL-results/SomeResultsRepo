package org.argouml.uml.diagram.deployment.ui;
import org.argouml.uml.ui.PropPanel;
import org.argouml.uml.ui.PropPanelFactory;
public class DeploymentDiagramPropPanelFactory implements PropPanelFactory
  { 
public PropPanel createPropPanel(Object object)
    { 
if(object instanceof UMLDeploymentDiagram)//1
{ 
return new PropPanelUMLDeploymentDiagram();
} 
return null;
} 

 } 
