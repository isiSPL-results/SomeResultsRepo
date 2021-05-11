package org.argouml.moduleloader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.argouml.application.api.AbstractArgoJPanel;
import org.argouml.application.api.GUISettingsTabInterface;
import org.argouml.application.api.InitSubsystem;
public class InitModuleLoader implements InitSubsystem
  { 
public List<GUISettingsTabInterface> getSettingsTabs()
    { 
List<GUISettingsTabInterface> result =
            new ArrayList<GUISettingsTabInterface>();
result.add(new SettingsTabModules());
return result;
} 
public List<AbstractArgoJPanel> getDetailsTabs()
    { 
return ModuleLoader2.getInstance().getDetailsTabs();
} 
public List<GUISettingsTabInterface> getProjectSettingsTabs()
    { 
return Collections.emptyList();
} 
public void init()
    { 
ModuleLoader2.getInstance();
ModuleLoader2.doLoad(false);
} 

 } 
