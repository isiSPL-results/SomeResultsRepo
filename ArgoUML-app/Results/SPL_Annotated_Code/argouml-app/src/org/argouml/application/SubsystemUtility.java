// Compilation Unit of /SubsystemUtility.java 
 
package org.argouml.application;
import org.argouml.application.api.AbstractArgoJPanel;
import org.argouml.application.api.GUISettingsTabInterface;
import org.argouml.application.api.InitSubsystem;
import org.argouml.ui.DetailsPane;
import org.argouml.ui.GUI;
import org.argouml.ui.ProjectBrowser;
import org.argouml.ui.TabToDoTarget;
public class SubsystemUtility  { 
static void initSubsystem(InitSubsystem subsystem)
    { 
subsystem.init();
for (GUISettingsTabInterface tab : subsystem.getSettingsTabs()) //1
{ 
GUI.getInstance().addSettingsTab(tab);
} 

for (GUISettingsTabInterface tab : subsystem.getProjectSettingsTabs()) //1
{ 
GUI.getInstance().addProjectSettingsTab(tab);
} 

for (AbstractArgoJPanel tab : subsystem.getDetailsTabs()) //1
{ 
((DetailsPane) ProjectBrowser.getInstance().getDetailsPane())
            .addTab(tab, !(tab instanceof TabToDoTarget));
} 

} 

 } 


