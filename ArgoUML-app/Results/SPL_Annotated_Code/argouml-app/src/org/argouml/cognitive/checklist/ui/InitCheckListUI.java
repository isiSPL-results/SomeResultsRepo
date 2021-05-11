// Compilation Unit of /InitCheckListUI.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.checklist.ui;
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
public class InitCheckListUI implements InitSubsystem
  { 
public List<AbstractArgoJPanel> getDetailsTabs()
    { 
List<AbstractArgoJPanel> result =
            new ArrayList<AbstractArgoJPanel>();
result.add(new TabChecklist());
return result;
} 

public List<GUISettingsTabInterface> getProjectSettingsTabs()
    { 
return Collections.emptyList();
} 

public void init()
    { 
} 

public List<GUISettingsTabInterface> getSettingsTabs()
    { 
return Collections.emptyList();
} 

 } 

//#endif 


