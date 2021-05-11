
//#if 1956158833 
// Compilation Unit of /InitPatternCritics.java 
 

//#if -1526517276 
package org.argouml.pattern.cognitive.critics;
//#endif 


//#if 1624216824 
import java.util.Collections;
//#endif 


//#if 375373803 
import java.util.List;
//#endif 


//#if -1446250043 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if -14875014 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if -131529507 
import org.argouml.application.api.InitSubsystem;
//#endif 


//#if 992987539 
import org.argouml.cognitive.Agency;
//#endif 


//#if -1208173820 
import org.argouml.cognitive.Critic;
//#endif 


//#if 2113764518 
import org.argouml.model.Model;
//#endif 


//#if 1754198689 
public class InitPatternCritics implements 
//#if -1119258509 
InitSubsystem
//#endif 

  { 

//#if -139990620 
private static Critic crConsiderSingleton = new CrConsiderSingleton();
//#endif 


//#if 1180754010 
private static Critic crSingletonViolatedMSA =
        new CrSingletonViolatedMissingStaticAttr();
//#endif 


//#if -296010136 
private static Critic crSingletonViolatedOPC =
        new CrSingletonViolatedOnlyPrivateConstructors();
//#endif 


//#if -353469493 
public List<AbstractArgoJPanel> getDetailsTabs()
    { 

//#if 623747714 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if -2117459725 
public List<GUISettingsTabInterface> getSettingsTabs()
    { 

//#if 1569829212 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if 886430570 
public List<GUISettingsTabInterface> getProjectSettingsTabs()
    { 

//#if 719678906 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if 99332090 
public void init()
    { 

//#if 1882852436 
Object classCls = Model.getMetaTypes().getUMLClass();
//#endif 


//#if -1693051009 
Agency.register(crConsiderSingleton, classCls);
//#endif 


//#if -554527679 
Agency.register(crSingletonViolatedMSA, classCls);
//#endif 


//#if -427270470 
Agency.register(crSingletonViolatedOPC, classCls);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

