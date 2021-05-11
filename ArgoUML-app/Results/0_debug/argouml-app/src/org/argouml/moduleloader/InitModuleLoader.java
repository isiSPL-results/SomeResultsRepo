
//#if 490298740 
// Compilation Unit of /InitModuleLoader.java 
 

//#if -783059770 
package org.argouml.moduleloader;
//#endif 


//#if 311709110 
import java.util.ArrayList;
//#endif 


//#if 1777583608 
import java.util.Collections;
//#endif 


//#if 237022955 
import java.util.List;
//#endif 


//#if 168880325 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if -6981766 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if 1313519069 
import org.argouml.application.api.InitSubsystem;
//#endif 


//#if 1825001201 
public class InitModuleLoader implements 
//#if -1239110765 
InitSubsystem
//#endif 

  { 

//#if 1934207443 
public List<GUISettingsTabInterface> getSettingsTabs()
    { 

//#if -1633443222 
List<GUISettingsTabInterface> result =
            new ArrayList<GUISettingsTabInterface>();
//#endif 


//#if -769506949 
result.add(new SettingsTabModules());
//#endif 


//#if 707714947 
return result;
//#endif 

} 

//#endif 


//#if -1317131093 
public List<AbstractArgoJPanel> getDetailsTabs()
    { 

//#if 1166980954 
return ModuleLoader2.getInstance().getDetailsTabs();
//#endif 

} 

//#endif 


//#if -346777974 
public List<GUISettingsTabInterface> getProjectSettingsTabs()
    { 

//#if 1180844050 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if -1301403430 
public void init()
    { 

//#if 1658724663 
ModuleLoader2.getInstance();
//#endif 


//#if -120364218 
ModuleLoader2.doLoad(false);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

