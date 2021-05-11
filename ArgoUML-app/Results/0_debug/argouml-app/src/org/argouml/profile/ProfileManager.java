
//#if 608932112 
// Compilation Unit of /ProfileManager.java 
 

//#if -1397784067 
package org.argouml.profile;
//#endif 


//#if -711049888 
import java.util.List;
//#endif 


//#if -2124899561 
import org.argouml.kernel.ProfileConfiguration;
//#endif 


//#if 1199963356 
public interface ProfileManager  { 

//#if 172346620 
void addSearchPathDirectory(String path);
//#endif 


//#if -1505599950 
Profile getProfileForClass(String className);
//#endif 


//#if 116118562 
void addToDefaultProfiles(Profile profile);
//#endif 


//#if -93586479 
Profile lookForRegisteredProfile(String profile);
//#endif 


//#if -1364444746 
List<String> getSearchPathDirectories();
//#endif 


//#if -1629231892 
void removeFromDefaultProfiles(Profile profile);
//#endif 


//#if -1012890591 
Profile getUMLProfile();
//#endif 


//#if 1396355403 
List<Profile> getDefaultProfiles();
//#endif 


//#if -1930320554 
void refreshRegisteredProfiles();
//#endif 


//#if -1165257618 
List<Profile> getRegisteredProfiles();
//#endif 


//#if 1585103227 
void applyConfiguration(ProfileConfiguration pc);
//#endif 


//#if -1321812779 
void registerProfile(Profile profile);
//#endif 


//#if 612180308 
void removeProfile(Profile profile);
//#endif 


//#if -349638251 
void removeSearchPathDirectory(String path);
//#endif 

 } 

//#endif 


//#endif 

