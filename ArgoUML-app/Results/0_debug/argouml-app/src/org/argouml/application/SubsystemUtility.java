
//#if 1595067915 
// Compilation Unit of /SubsystemUtility.java 
 

//#if -2041815966 
package org.argouml.application;
//#endif 


//#if 1980553446 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if -1679854599 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if -504400612 
import org.argouml.application.api.InitSubsystem;
//#endif 


//#if -730589891 
import org.argouml.ui.DetailsPane;
//#endif 


//#if 557071084 
import org.argouml.ui.GUI;
//#endif 


//#if 1037242432 
import org.argouml.ui.ProjectBrowser;
//#endif 


//#if -1798373317 
import org.argouml.ui.TabToDoTarget;
//#endif 


//#if -1827348096 
public class SubsystemUtility  { 

//#if -1589479457 
static void initSubsystem(InitSubsystem subsystem)
    { 

//#if -1382715260 
subsystem.init();
//#endif 


//#if -173065952 
for (GUISettingsTabInterface tab : subsystem.getSettingsTabs()) //1
{ 

//#if -1532482248 
GUI.getInstance().addSettingsTab(tab);
//#endif 

} 

//#endif 


//#if 1642429485 
for (GUISettingsTabInterface tab : subsystem.getProjectSettingsTabs()) //1
{ 

//#if -2141794425 
GUI.getInstance().addProjectSettingsTab(tab);
//#endif 

} 

//#endif 


//#if -708784238 
for (AbstractArgoJPanel tab : subsystem.getDetailsTabs()) //1
{ 

//#if 1899117632 
((DetailsPane) ProjectBrowser.getInstance().getDetailsPane())
            .addTab(tab, !(tab instanceof TabToDoTarget));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

