
//#if 13124072 
// Compilation Unit of /InitClassDiagram.java 
 

//#if 1695657113 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if -236013947 
import java.util.Collections;
//#endif 


//#if 596873982 
import java.util.List;
//#endif 


//#if 1375125720 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if -1778207929 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if 1806491114 
import org.argouml.application.api.InitSubsystem;
//#endif 


//#if -1455621106 
import org.argouml.uml.ui.PropPanelFactory;
//#endif 


//#if 739109659 
import org.argouml.uml.ui.PropPanelFactoryManager;
//#endif 


//#if 1137090400 
public class InitClassDiagram implements 
//#if 1578515118 
InitSubsystem
//#endif 

  { 

//#if 2045411295 
public void init()
    { 

//#if 838759681 
PropPanelFactory diagramFactory = new ClassDiagramPropPanelFactory();
//#endif 


//#if 307224387 
PropPanelFactoryManager.addPropPanelFactory(diagramFactory);
//#endif 

} 

//#endif 


//#if -1131139856 
public List<AbstractArgoJPanel> getDetailsTabs()
    { 

//#if 1164590052 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if -1746034088 
public List<GUISettingsTabInterface> getSettingsTabs()
    { 

//#if -1341924260 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if -188354971 
public List<GUISettingsTabInterface> getProjectSettingsTabs()
    { 

//#if 2143595687 
return Collections.emptyList();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

