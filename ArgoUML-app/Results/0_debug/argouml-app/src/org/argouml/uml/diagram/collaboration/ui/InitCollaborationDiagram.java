
//#if 648406273 
// Compilation Unit of /InitCollaborationDiagram.java 
 

//#if -2064806284 
package org.argouml.uml.diagram.collaboration.ui;
//#endif 


//#if -1786739527 
import java.util.Collections;
//#endif 


//#if -1490118838 
import java.util.List;
//#endif 


//#if 1687000356 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if -163533189 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if 1096649246 
import org.argouml.application.api.InitSubsystem;
//#endif 


//#if 186638146 
import org.argouml.uml.ui.PropPanelFactory;
//#endif 


//#if 208848231 
import org.argouml.uml.ui.PropPanelFactoryManager;
//#endif 


//#if -1902913473 
public class InitCollaborationDiagram implements 
//#if 1436244467 
InitSubsystem
//#endif 

  { 

//#if 364403 
public List<GUISettingsTabInterface> getSettingsTabs()
    { 

//#if -194797951 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if 1645802 
public List<GUISettingsTabInterface> getProjectSettingsTabs()
    { 

//#if -1169026396 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if -604059061 
public List<AbstractArgoJPanel> getDetailsTabs()
    { 

//#if 877971164 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if -1501798790 
public void init()
    { 

//#if 1176103921 
PropPanelFactory diagramFactory =
            new CollaborationDiagramPropPanelFactory();
//#endif 


//#if -1337015552 
PropPanelFactoryManager.addPropPanelFactory(diagramFactory);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

