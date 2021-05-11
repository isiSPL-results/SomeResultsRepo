// Compilation Unit of /InitCognitiveUI.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.ui;
//#endif 


//#if COGNITIVE 
import java.util.ArrayList;
//#endif 


//#if COGNITIVE 
import java.util.Collections;
//#endif 


//#if COGNITIVE 
import java.util.List;
//#endif 


//#if COGNITIVE 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if COGNITIVE 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if COGNITIVE 
import org.argouml.application.api.InitSubsystem;
//#endif 


//#if COGNITIVE 
public class InitCognitiveUI implements InitSubsystem
  { 
public List<GUISettingsTabInterface> getSettingsTabs()
    { 
return Collections.emptyList();
} 

public List<GUISettingsTabInterface> getProjectSettingsTabs()
    { 
return Collections.emptyList();
} 

public List<AbstractArgoJPanel> getDetailsTabs()
    { 
List<AbstractArgoJPanel> result =
            new ArrayList<AbstractArgoJPanel>();
result.add(new TabToDo());
return result;
} 

public void init()
    { 
} 

 } 

//#endif 


