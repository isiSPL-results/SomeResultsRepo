
//#if -1302456529 
// Compilation Unit of /InitSequenceDiagram.java 
 

//#if 28297210 
package org.argouml.uml.diagram.sequence.ui;
//#endif 


//#if -1092345661 
import java.util.Collections;
//#endif 


//#if -42331520 
import java.util.List;
//#endif 


//#if 28227674 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if 2072190213 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if -1898660568 
import org.argouml.application.api.InitSubsystem;
//#endif 


//#if -1030446644 
import org.argouml.uml.ui.PropPanelFactory;
//#endif 


//#if 1843524509 
import org.argouml.uml.ui.PropPanelFactoryManager;
//#endif 


//#if -1089965237 
public class InitSequenceDiagram implements 
//#if 707738452 
InitSubsystem
//#endif 

  { 

//#if 976509194 
public List<AbstractArgoJPanel> getDetailsTabs()
    { 

//#if 1953671865 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if -1954744967 
public void init()
    { 

//#if -1027773660 
PropPanelFactory diagramFactory =
            new SequenceDiagramPropPanelFactory();
//#endif 


//#if 291546131 
PropPanelFactoryManager.addPropPanelFactory(diagramFactory);
//#endif 

} 

//#endif 


//#if 1327420146 
public List<GUISettingsTabInterface> getSettingsTabs()
    { 

//#if -1422250493 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if -1437352821 
public List<GUISettingsTabInterface> getProjectSettingsTabs()
    { 

//#if 1584393865 
return Collections.emptyList();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

