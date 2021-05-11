
//#if -636493264 
// Compilation Unit of /InitNotationUI.java 
 

//#if -1271591664 
package org.argouml.notation.ui;
//#endif 


//#if -653621737 
import java.util.ArrayList;
//#endif 


//#if 1807575577 
import java.util.Collections;
//#endif 


//#if 160366058 
import java.util.List;
//#endif 


//#if -492078140 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if 1699997600 
import org.argouml.application.api.Argo;
//#endif 


//#if 1307175899 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if 781320062 
import org.argouml.application.api.InitSubsystem;
//#endif 


//#if -1419092121 
public class InitNotationUI implements 
//#if -2043540992 
InitSubsystem
//#endif 

  { 

//#if -1951416777 
public List<GUISettingsTabInterface> getProjectSettingsTabs()
    { 

//#if 2054953141 
List<GUISettingsTabInterface> result =
            new ArrayList<GUISettingsTabInterface>();
//#endif 


//#if 2143090640 
result.add(new SettingsTabNotation(Argo.SCOPE_PROJECT));
//#endif 


//#if -1308075368 
return result;
//#endif 

} 

//#endif 


//#if -2019880994 
public List<AbstractArgoJPanel> getDetailsTabs()
    { 

//#if 1688319185 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if -187819322 
public List<GUISettingsTabInterface> getSettingsTabs()
    { 

//#if 1796560725 
List<GUISettingsTabInterface> result =
            new ArrayList<GUISettingsTabInterface>();
//#endif 


//#if -1132311399 
result.add(new SettingsTabNotation(Argo.SCOPE_APPLICATION));
//#endif 


//#if 66187256 
return result;
//#endif 

} 

//#endif 


//#if -164784307 
public void init()
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

