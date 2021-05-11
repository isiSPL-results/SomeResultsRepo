
//#if 210320332 
// Compilation Unit of /InitUseCaseDiagram.java 
 

//#if -1730245721 
package org.argouml.uml.diagram.use_case.ui;
//#endif 


//#if 699529597 
import java.util.Collections;
//#endif 


//#if -1611057402 
import java.util.List;
//#endif 


//#if 495600864 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if 1537766463 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if -949422878 
import org.argouml.application.api.InitSubsystem;
//#endif 


//#if 766749958 
import org.argouml.uml.ui.PropPanelFactory;
//#endif 


//#if 1205121827 
import org.argouml.uml.ui.PropPanelFactoryManager;
//#endif 


//#if 949865833 
public class InitUseCaseDiagram implements 
//#if 654585152 
InitSubsystem
//#endif 

  { 

//#if -1631178377 
public List<GUISettingsTabInterface> getProjectSettingsTabs()
    { 

//#if 246738767 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if -886648954 
public List<GUISettingsTabInterface> getSettingsTabs()
    { 

//#if 685508729 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if -601773043 
public void init()
    { 

//#if -1815762723 
PropPanelFactory diagramFactory = new UseCaseDiagramPropPanelFactory();
//#endif 


//#if -515152282 
PropPanelFactoryManager.addPropPanelFactory(diagramFactory);
//#endif 

} 

//#endif 


//#if 1758090398 
public List<AbstractArgoJPanel> getDetailsTabs()
    { 

//#if 306565094 
return Collections.emptyList();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

