
//#if -1067117281 
// Compilation Unit of /InitActivityDiagram.java 
 

//#if -497583553 
package org.argouml.uml.diagram.activity.ui;
//#endif 


//#if -1813494868 
import java.util.Collections;
//#endif 


//#if 221737911 
import java.util.List;
//#endif 


//#if -1526628975 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if -1543634386 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if -2119478895 
import org.argouml.application.api.InitSubsystem;
//#endif 


//#if 1835596021 
import org.argouml.uml.ui.PropPanelFactory;
//#endif 


//#if -706876332 
import org.argouml.uml.ui.PropPanelFactoryManager;
//#endif 


//#if -780185370 
public class InitActivityDiagram implements 
//#if 1977222111 
InitSubsystem
//#endif 

  { 

//#if 1235538951 
public List<GUISettingsTabInterface> getSettingsTabs()
    { 

//#if -982128801 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if 45899022 
public void init()
    { 

//#if 1877160632 
PropPanelFactory diagramFactory = new ActivityDiagramPropPanelFactory();
//#endif 


//#if -2067481639 
PropPanelFactoryManager.addPropPanelFactory(diagramFactory);
//#endif 

} 

//#endif 


//#if 1404258774 
public List<GUISettingsTabInterface> getProjectSettingsTabs()
    { 

//#if 730511305 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if -1925050913 
public List<AbstractArgoJPanel> getDetailsTabs()
    { 

//#if 1928133677 
return Collections.emptyList();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

