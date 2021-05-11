
//#if 393935112 
// Compilation Unit of /InitCheckListUI.java 
 

//#if -1709578932 
package org.argouml.cognitive.checklist.ui;
//#endif 


//#if 124353805 
import java.util.ArrayList;
//#endif 


//#if 2117761935 
import java.util.Collections;
//#endif 


//#if 534971700 
import java.util.List;
//#endif 


//#if -276833522 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if -1069577519 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if 392018420 
import org.argouml.application.api.InitSubsystem;
//#endif 


//#if -297523553 
public class InitCheckListUI implements 
//#if -432803009 
InitSubsystem
//#endif 

  { 

//#if -536114561 
public List<AbstractArgoJPanel> getDetailsTabs()
    { 

//#if 349584882 
List<AbstractArgoJPanel> result =
            new ArrayList<AbstractArgoJPanel>();
//#endif 


//#if -1354380387 
result.add(new TabChecklist());
//#endif 


//#if -1659035715 
return result;
//#endif 

} 

//#endif 


//#if 668029238 
public List<GUISettingsTabInterface> getProjectSettingsTabs()
    { 

//#if 1544951397 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if 1955836334 
public void init()
    { 
} 

//#endif 


//#if 910579879 
public List<GUISettingsTabInterface> getSettingsTabs()
    { 

//#if 1356414437 
return Collections.emptyList();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

