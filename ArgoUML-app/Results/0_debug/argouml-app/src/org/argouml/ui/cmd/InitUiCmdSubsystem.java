
//#if -507318525 
// Compilation Unit of /InitUiCmdSubsystem.java 
 

//#if -1989169083 
package org.argouml.ui.cmd;
//#endif 


//#if -24137994 
import java.util.ArrayList;
//#endif 


//#if 1151063864 
import java.util.Collections;
//#endif 


//#if 475891115 
import java.util.List;
//#endif 


//#if -515719291 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if 1941690554 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if -1820481763 
import org.argouml.application.api.InitSubsystem;
//#endif 


//#if -1451025253 
public class InitUiCmdSubsystem implements 
//#if -1066973162 
InitSubsystem
//#endif 

  { 

//#if -1341023881 
public void init()
    { 

//#if 520425931 
ActionAdjustSnap.init();
//#endif 


//#if -983928505 
ActionAdjustGrid.init();
//#endif 

} 

//#endif 


//#if 440429704 
public List<AbstractArgoJPanel> getDetailsTabs()
    { 

//#if -1422640305 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if 367120368 
public List<GUISettingsTabInterface> getSettingsTabs()
    { 

//#if 160206390 
List<GUISettingsTabInterface> result =
            new ArrayList<GUISettingsTabInterface>();
//#endif 


//#if -1557877651 
result.add(new SettingsTabShortcuts());
//#endif 


//#if -1448407753 
return result;
//#endif 

} 

//#endif 


//#if -555235891 
public List<GUISettingsTabInterface> getProjectSettingsTabs()
    { 

//#if 1551677381 
return Collections.emptyList();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

