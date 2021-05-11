
//#if -2143063759 
// Compilation Unit of /InitDeploymentDiagram.java 
 

//#if 1267783933 
package org.argouml.uml.diagram.deployment.ui;
//#endif 


//#if 1297888996 
import java.util.Collections;
//#endif 


//#if 230043519 
import java.util.List;
//#endif 


//#if 341776729 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if 456295270 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if -165840695 
import org.argouml.application.api.InitSubsystem;
//#endif 


//#if 259451437 
import org.argouml.uml.ui.PropPanelFactory;
//#endif 


//#if -273634276 
import org.argouml.uml.ui.PropPanelFactoryManager;
//#endif 


//#if 694822696 
public class InitDeploymentDiagram implements 
//#if 1167824179 
InitSubsystem
//#endif 

  { 

//#if -781493446 
public void init()
    { 

//#if 1937608319 
PropPanelFactory diagramFactory =
            new DeploymentDiagramPropPanelFactory();
//#endif 


//#if -703713430 
PropPanelFactoryManager.addPropPanelFactory(diagramFactory);
//#endif 

} 

//#endif 


//#if -2044528885 
public List<AbstractArgoJPanel> getDetailsTabs()
    { 

//#if 823732042 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if 1970513962 
public List<GUISettingsTabInterface> getProjectSettingsTabs()
    { 

//#if 1726695471 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if -1106957261 
public List<GUISettingsTabInterface> getSettingsTabs()
    { 

//#if -510343409 
return Collections.emptyList();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

