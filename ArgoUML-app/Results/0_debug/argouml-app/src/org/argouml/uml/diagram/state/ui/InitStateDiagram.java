
//#if -953618402 
// Compilation Unit of /InitStateDiagram.java 
 

//#if 992476149 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if 1648476014 
import java.util.Collections;
//#endif 


//#if -1302802891 
import java.util.List;
//#endif 


//#if 1315528719 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if 1094057584 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if -1285334957 
import org.argouml.application.api.InitSubsystem;
//#endif 


//#if 810924343 
import org.argouml.uml.ui.PropPanelFactory;
//#endif 


//#if -618218030 
import org.argouml.uml.ui.PropPanelFactoryManager;
//#endif 


//#if 1612594206 
public class InitStateDiagram implements 
//#if 778183601 
InitSubsystem
//#endif 

  { 

//#if -2028959192 
public List<GUISettingsTabInterface> getProjectSettingsTabs()
    { 

//#if -1678021596 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if 732648444 
public void init()
    { 

//#if -105527762 
PropPanelFactory diagramFactory = new StateDiagramPropPanelFactory();
//#endif 


//#if 1435682671 
PropPanelFactoryManager.addPropPanelFactory(diagramFactory);
//#endif 

} 

//#endif 


//#if 42512461 
public List<AbstractArgoJPanel> getDetailsTabs()
    { 

//#if 1975966308 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if -1630049291 
public List<GUISettingsTabInterface> getSettingsTabs()
    { 

//#if 196848365 
return Collections.emptyList();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

