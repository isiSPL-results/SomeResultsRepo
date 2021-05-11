
//#if 1163171848 
// Compilation Unit of /InitDiagramAppearanceUI.java 
 

//#if 418970749 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 493463831 
import java.util.ArrayList;
//#endif 


//#if 350211353 
import java.util.Collections;
//#endif 


//#if -1190790422 
import java.util.List;
//#endif 


//#if 1861122244 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if -974805856 
import org.argouml.application.api.Argo;
//#endif 


//#if -721613093 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if 430236286 
import org.argouml.application.api.InitSubsystem;
//#endif 


//#if -1767212230 
public class InitDiagramAppearanceUI implements 
//#if 1506904495 
InitSubsystem
//#endif 

  { 

//#if -930536538 
public List<GUISettingsTabInterface> getProjectSettingsTabs()
    { 

//#if -138053280 
List<GUISettingsTabInterface> result =
            new ArrayList<GUISettingsTabInterface>();
//#endif 


//#if 1554087912 
result.add(new SettingsTabDiagramAppearance(Argo.SCOPE_PROJECT));
//#endif 


//#if 1785411405 
return result;
//#endif 

} 

//#endif 


//#if -1002879682 
public void init()
    { 
} 

//#endif 


//#if 1860076047 
public List<AbstractArgoJPanel> getDetailsTabs()
    { 

//#if -1953778047 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if -1002085321 
public List<GUISettingsTabInterface> getSettingsTabs()
    { 

//#if 1615229733 
List<GUISettingsTabInterface> result =
            new ArrayList<GUISettingsTabInterface>();
//#endif 


//#if -331388394 
result.add(new SettingsTabDiagramAppearance(Argo.SCOPE_APPLICATION));
//#endif 


//#if 1861078568 
return result;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

