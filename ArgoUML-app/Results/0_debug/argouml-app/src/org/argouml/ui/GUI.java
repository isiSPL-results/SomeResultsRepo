
//#if 967680546 
// Compilation Unit of /GUI.java 
 

//#if 1585922567 
package org.argouml.ui;
//#endif 


//#if -636462612 
import java.util.ArrayList;
//#endif 


//#if 1117625518 
import java.util.Collections;
//#endif 


//#if 474962165 
import java.util.List;
//#endif 


//#if 2137205680 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if -874020563 
public final class GUI  { 

//#if 928158029 
private static GUI instance = new GUI();
//#endif 


//#if 1946192338 
private List<GUISettingsTabInterface> settingsTabs =
        new ArrayList<GUISettingsTabInterface>();
//#endif 


//#if 1827073887 
private List<GUISettingsTabInterface> projectSettingsTabs =
        new ArrayList<GUISettingsTabInterface>();
//#endif 


//#if -2037945442 
public final List<GUISettingsTabInterface> getProjectSettingsTabs()
    { 

//#if -328276547 
return Collections.unmodifiableList(projectSettingsTabs);
//#endif 

} 

//#endif 


//#if -74943064 
public void addProjectSettingsTab(final GUISettingsTabInterface panel)
    { 

//#if -1005962347 
projectSettingsTabs.add(panel);
//#endif 

} 

//#endif 


//#if -1208791073 
public void addSettingsTab(final GUISettingsTabInterface panel)
    { 

//#if -1986365720 
settingsTabs.add(panel);
//#endif 

} 

//#endif 


//#if 2104004980 
public static GUI getInstance()
    { 

//#if 949332649 
return instance;
//#endif 

} 

//#endif 


//#if 43754303 
public final List<GUISettingsTabInterface> getSettingsTabs()
    { 

//#if -1949184504 
return Collections.unmodifiableList(settingsTabs);
//#endif 

} 

//#endif 


//#if -690835963 
private GUI()
    { 

//#if -1306592961 
addSettingsTab(new SettingsTabPreferences());
//#endif 


//#if 914376410 
addSettingsTab(new SettingsTabEnvironment());
//#endif 


//#if -111457686 
addSettingsTab(new SettingsTabUser());
//#endif 


//#if -1354246781 
addSettingsTab(new SettingsTabAppearance());
//#endif 


//#if -637194896 
addSettingsTab(new SettingsTabProfile());
//#endif 


//#if -916988108 
addProjectSettingsTab(new ProjectSettingsTabProperties());
//#endif 


//#if -811622322 
addProjectSettingsTab(new ProjectSettingsTabProfile());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

