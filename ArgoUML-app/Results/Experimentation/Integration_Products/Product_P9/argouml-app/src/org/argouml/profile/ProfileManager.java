package org.argouml.profile;
import java.util.List;
import org.argouml.kernel.ProfileConfiguration;
public interface ProfileManager  { 
void addSearchPathDirectory(String path);Profile getProfileForClass(String className);void addToDefaultProfiles(Profile profile);Profile lookForRegisteredProfile(String profile);List<String> getSearchPathDirectories();void removeFromDefaultProfiles(Profile profile);Profile getUMLProfile();List<Profile> getDefaultProfiles();void refreshRegisteredProfiles();List<Profile> getRegisteredProfiles();void applyConfiguration(ProfileConfiguration pc);void registerProfile(Profile profile);void removeProfile(Profile profile);void removeSearchPathDirectory(String path);
 } 
