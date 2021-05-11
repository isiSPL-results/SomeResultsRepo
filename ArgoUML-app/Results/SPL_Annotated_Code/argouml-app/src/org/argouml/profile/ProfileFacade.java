// Compilation Unit of /ProfileFacade.java 
 
package org.argouml.profile;
import org.argouml.kernel.ProfileConfiguration;
public class ProfileFacade  { 
private static ProfileManager manager;
public static ProfileManager getManager()
    { 
if(manager == null)//1
{ 
notInitialized("manager");
} 

return manager;
} 

public static void applyConfiguration(ProfileConfiguration pc)
    { 
getManager().applyConfiguration(pc);
} 

static void reset()
    { 
manager = null;
} 

public static void remove(Profile profile)
    { 
getManager().removeProfile(profile);
} 

private static void notInitialized(String string)
    { 
throw new RuntimeException("ProfileFacade's " + string
                                   + " isn't initialized!");
} 

public static boolean isInitiated()
    { 
return manager != null;
} 

public static void setManager(ProfileManager profileManager)
    { 
manager = profileManager;
} 

public static void register(Profile profile)
    { 
getManager().registerProfile(profile);
} 

 } 


