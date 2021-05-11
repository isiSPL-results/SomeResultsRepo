
//#if 1650404641 
// Compilation Unit of /DeploymentDiagramPropPanelFactory.java 
 

//#if 1520780603 
package org.argouml.uml.diagram.deployment.ui;
//#endif 


//#if -338410531 
import org.argouml.uml.ui.PropPanel;
//#endif 


//#if -1421994321 
import org.argouml.uml.ui.PropPanelFactory;
//#endif 


//#if -908397341 
public class DeploymentDiagramPropPanelFactory implements 
//#if -95662340 
PropPanelFactory
//#endif 

  { 

//#if -1871762077 
public PropPanel createPropPanel(Object object)
    { 

//#if -2128103975 
if(object instanceof UMLDeploymentDiagram)//1
{ 

//#if 58390081 
return new PropPanelUMLDeploymentDiagram();
//#endif 

} 

//#endif 


//#if 1316527461 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

