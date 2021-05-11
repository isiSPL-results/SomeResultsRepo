package org.argouml.ui;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.argouml.application.api.GUISettingsTabInterface;
public final class GUI  { 
private static GUI instance = new GUI();
private List<GUISettingsTabInterface> settingsTabs =
        new ArrayList<GUISettingsTabInterface>();
private List<GUISettingsTabInterface> projectSettingsTabs =
        new ArrayList<GUISettingsTabInterface>();
public final List<GUISettingsTabInterface> getProjectSettingsTabs()
    { 
return Collections.unmodifiableList(projectSettingsTabs);
} 
public void addProjectSettingsTab(final GUISettingsTabInterface panel)
    { 
projectSettingsTabs.add(panel);
} 
public void addSettingsTab(final GUISettingsTabInterface panel)
    { 
settingsTabs.add(panel);
} 
public static GUI getInstance()
    { 
return instance;
} 
public final List<GUISettingsTabInterface> getSettingsTabs()
    { 
return Collections.unmodifiableList(settingsTabs);
} 
private GUI()
    { 
addSettingsTab(new SettingsTabPreferences());
addSettingsTab(new SettingsTabEnvironment());
addSettingsTab(new SettingsTabUser());
addSettingsTab(new SettingsTabAppearance());
addSettingsTab(new SettingsTabProfile());
addProjectSettingsTab(new ProjectSettingsTabProperties());
addProjectSettingsTab(new ProjectSettingsTabProfile());
} 

 } 
