
//#if 156085322 
// Compilation Unit of /InitCognitiveUI.java 
 

//#if -1101753944 
package org.argouml.cognitive.ui;
//#endif 


//#if -1593140255 
import java.util.ArrayList;
//#endif 


//#if 873411939 
import java.util.Collections;
//#endif 


//#if -1823018528 
import java.util.List;
//#endif 


//#if 1161172922 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if 345004453 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if -1824046648 
import org.argouml.application.api.InitSubsystem;
//#endif 


//#if -1349275641 
public class InitCognitiveUI implements 
//#if 1161163528 
InitSubsystem
//#endif 

  { 

//#if 563452094 
public List<GUISettingsTabInterface> getSettingsTabs()
    { 

//#if -670653403 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if 1444223295 
public List<GUISettingsTabInterface> getProjectSettingsTabs()
    { 

//#if -821445809 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if -948541482 
public List<AbstractArgoJPanel> getDetailsTabs()
    { 

//#if -1066737136 
List<AbstractArgoJPanel> result =
            new ArrayList<AbstractArgoJPanel>();
//#endif 


//#if -1424721929 
result.add(new TabToDo());
//#endif 


//#if -1220186913 
return result;
//#endif 

} 

//#endif 


//#if -1640451771 
public void init()
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

