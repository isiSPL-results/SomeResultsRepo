// Compilation Unit of /InitPatternCritics.java 
 

//#if COGNITIVE 
package org.argouml.pattern.cognitive.critics;
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
import org.argouml.cognitive.Agency;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Critic;
//#endif 


//#if COGNITIVE 
import org.argouml.model.Model;
//#endif 


//#if COGNITIVE 
public class InitPatternCritics implements InitSubsystem
  { 
private static Critic crConsiderSingleton = new CrConsiderSingleton();
private static Critic crSingletonViolatedMSA =
        new CrSingletonViolatedMissingStaticAttr();
private static Critic crSingletonViolatedOPC =
        new CrSingletonViolatedOnlyPrivateConstructors();
public List<AbstractArgoJPanel> getDetailsTabs()
    { 
return Collections.emptyList();
} 

public List<GUISettingsTabInterface> getSettingsTabs()
    { 
return Collections.emptyList();
} 

public List<GUISettingsTabInterface> getProjectSettingsTabs()
    { 
return Collections.emptyList();
} 

public void init()
    { 
Object classCls = Model.getMetaTypes().getUMLClass();
Agency.register(crConsiderSingleton, classCls);
Agency.register(crSingletonViolatedMSA, classCls);
Agency.register(crSingletonViolatedOPC, classCls);
} 

 } 

//#endif 


