
//#if 342492160 
// Compilation Unit of /ProfileFacade.java 
 

//#if 627997222 
package org.argouml.profile;
//#endif 


//#if 74577998 
import org.argouml.kernel.ProfileConfiguration;
//#endif 


//#if 177495203 
public class ProfileFacade  { 

//#if -1971957811 
private static ProfileManager manager;
//#endif 


//#if 1312668905 
public static ProfileManager getManager()
    { 

//#if 2021178209 
if(manager == null)//1
{ 

//#if 1666820685 
notInitialized("manager");
//#endif 

} 

//#endif 


//#if -2009776274 
return manager;
//#endif 

} 

//#endif 


//#if -2111017750 
public static void applyConfiguration(ProfileConfiguration pc)
    { 

//#if -1871659532 
getManager().applyConfiguration(pc);
//#endif 

} 

//#endif 


//#if 1419375256 
static void reset()
    { 

//#if 1533087815 
manager = null;
//#endif 

} 

//#endif 


//#if -1209977754 
public static void remove(Profile profile)
    { 

//#if -1874950972 
getManager().removeProfile(profile);
//#endif 

} 

//#endif 


//#if 707816335 
private static void notInitialized(String string)
    { 

//#if 1677057437 
throw new RuntimeException("ProfileFacade's " + string
                                   + " isn't initialized!");
//#endif 

} 

//#endif 


//#if 1953570951 
public static boolean isInitiated()
    { 

//#if -520880990 
return manager != null;
//#endif 

} 

//#endif 


//#if 678442917 
public static void setManager(ProfileManager profileManager)
    { 

//#if 1815727379 
manager = profileManager;
//#endif 

} 

//#endif 


//#if -2043504571 
public static void register(Profile profile)
    { 

//#if 1818137004 
getManager().registerProfile(profile);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

