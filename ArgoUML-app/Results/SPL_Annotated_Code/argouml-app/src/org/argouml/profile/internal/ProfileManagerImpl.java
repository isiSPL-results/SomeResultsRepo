// Compilation Unit of /ProfileManagerImpl.java 
 
package org.argouml.profile.internal;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import org.argouml.configuration.Configuration;
import org.argouml.configuration.ConfigurationKey;
import org.argouml.kernel.ProfileConfiguration;
import org.argouml.model.Model;
import org.argouml.model.UmlException;
import org.argouml.profile.Profile;
import org.argouml.profile.ProfileException;
import org.argouml.profile.ProfileManager;
import org.argouml.profile.UserDefinedProfile;
import org.argouml.profile.UserDefinedProfileHelper;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Agency;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Critic;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.ProfileCodeGeneration;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.ProfileGoodPractices;
//#endif 

public class ProfileManagerImpl implements ProfileManager
  { 
private static final String DIRECTORY_SEPARATOR = "*";
public static final ConfigurationKey KEY_DEFAULT_PROFILES = Configuration
            .makeKey("profiles", "default");
public static final ConfigurationKey KEY_DEFAULT_DIRECTORIES = Configuration
            .makeKey("profiles", "directories");
private boolean disableConfigurationUpdate = false;
private List<Profile> profiles = new ArrayList<Profile>();
private List<Profile> defaultProfiles = new ArrayList<Profile>();
private List<String> searchDirectories = new ArrayList<String>();
private ProfileUML profileUML;
private ProfileJava profileJava;
private static final String OLD_PROFILE_PACKAGE = "org.argouml.uml.profile";
private static final String NEW_PROFILE_PACKAGE =
        "org.argouml.profile.internal";

//#if LOGGING 
private static final Logger LOG = Logger.getLogger(
                                          ProfileManagerImpl.class);
//#endif 


//#if COGNITIVE 
private ProfileGoodPractices profileGoodPractices;
//#endif 


//#if COGNITIVE 
private ProfileCodeGeneration profileCodeGeneration;
//#endif 

public void addSearchPathDirectory(String path)
    { 
if(path != null && !searchDirectories.contains(path))//1
{ 
searchDirectories.add(path);
updateSearchDirectoriesConfiguration();
try //1
{ 
Model.getXmiReader().addSearchPath(path);
} 
catch (UmlException e) //1
{ 

//#if LOGGING 
LOG.error("Couldn't retrive XMI Reader from Model.", e);
//#endif 

} 


} 

} 

private void updateSearchDirectoriesConfiguration()
    { 
if(!disableConfigurationUpdate)//1
{ 
StringBuffer buf = new StringBuffer();
for (String s : searchDirectories) //1
{ 
buf.append(s).append(DIRECTORY_SEPARATOR);
} 

Configuration.setString(KEY_DEFAULT_DIRECTORIES, buf.toString());
} 

} 

public ProfileManagerImpl()
    { 
try //1
{ 
disableConfigurationUpdate = true;
profileUML = new ProfileUML();
profileJava = new ProfileJava(profileUML);

//#if COGNITIVE 
profileGoodPractices = new ProfileGoodPractices();
//#endif 


//#if COGNITIVE 
profileCodeGeneration = new ProfileCodeGeneration(
                profileGoodPractices);
//#endif 

registerProfile(profileUML);
addToDefaultProfiles(profileUML);
registerProfile(profileJava);

//#if COGNITIVE 
registerProfile(profileGoodPractices);
//#endif 


//#if COGNITIVE 
registerProfile(profileCodeGeneration);
//#endif 

registerProfile(new ProfileMeta());
} 
catch (ProfileException e) //1
{ 
throw new RuntimeException(e);
} 

finally { 
disableConfigurationUpdate = false;
} 

loadDirectoriesFromConfiguration();
refreshRegisteredProfiles();
loadDefaultProfilesfromConfiguration();
} 

public Profile lookForRegisteredProfile(String value)
    { 
List<Profile> registeredProfiles = getRegisteredProfiles();
for (Profile profile : registeredProfiles) //1
{ 
if(profile.getProfileIdentifier().equalsIgnoreCase(value))//1
{ 
return profile;
} 

} 

return null;
} 

private void loadDefaultProfilesfromConfiguration()
    { 
if(!disableConfigurationUpdate)//1
{ 
disableConfigurationUpdate = true;
String defaultProfilesList = Configuration
                                         .getString(KEY_DEFAULT_PROFILES);
if(defaultProfilesList.equals(""))//1
{ 
addToDefaultProfiles(profileJava);

//#if COGNITIVE 
addToDefaultProfiles(profileGoodPractices);
//#endif 


//#if COGNITIVE 
addToDefaultProfiles(profileCodeGeneration);
//#endif 

} 
else
{ 
StringTokenizer tokenizer = new StringTokenizer(
                    defaultProfilesList, DIRECTORY_SEPARATOR, false);
while (tokenizer.hasMoreTokens()) //1
{ 
String desc = tokenizer.nextToken();
Profile p = null;
if(desc.charAt(0) == 'U')//1
{ 
String fileName = desc.substring(1);
File file;
try //1
{ 
file = new File(new URI(fileName));
p = findUserDefinedProfile(file);
if(p == null)//1
{ 
try //1
{ 
p = new UserDefinedProfile(file);
registerProfile(p);
} 
catch (ProfileException e) //1
{ 

//#if LOGGING 
LOG.error("Error loading profile: " + file,
                                              e);
//#endif 

} 


} 

} 
catch (URISyntaxException e1) //1
{ 

//#if LOGGING 
LOG.error("Invalid path for Profile: " + fileName,
                                      e1);
//#endif 

} 

catch (Throwable e2) //1
{ 

//#if LOGGING 
LOG.error("Error loading profile: " + fileName,
                                      e2);
//#endif 

} 


} 
else
if(desc.charAt(0) == 'C')//1
{ 
String profileIdentifier = desc.substring(1);
p = lookForRegisteredProfile(profileIdentifier);
} 


if(p != null)//1
{ 
addToDefaultProfiles(p);
} 

} 

} 

disableConfigurationUpdate = false;
} 

} 

public Profile getProfileForClass(String profileClass)
    { 
Profile found = null;
if(profileClass != null
                && profileClass.startsWith(OLD_PROFILE_PACKAGE))//1
{ 
profileClass = profileClass.replace(OLD_PROFILE_PACKAGE,
                                                NEW_PROFILE_PACKAGE);
} 

assert profileUML.getClass().getName().startsWith(NEW_PROFILE_PACKAGE);
for (Profile p : profiles) //1
{ 
if(p.getClass().getName().equals(profileClass))//1
{ 
found = p;
break;

} 

} 

return found;
} 

public void removeSearchPathDirectory(String path)
    { 
if(path != null)//1
{ 
searchDirectories.remove(path);
updateSearchDirectoriesConfiguration();
try //1
{ 
Model.getXmiReader().removeSearchPath(path);
} 
catch (UmlException e) //1
{ 

//#if LOGGING 
LOG.error("Couldn't retrive XMI Reader from Model.", e);
//#endif 

} 


} 

} 

public void removeProfile(Profile p)
    { 
if(p != null && p != profileUML)//1
{ 
profiles.remove(p);
defaultProfiles.remove(p);
} 

try //1
{ 
Collection packages = p.getProfilePackages();
if(packages != null && !packages.isEmpty())//1
{ 
Model.getUmlFactory().deleteExtent(packages.iterator().next());
} 

} 
catch (ProfileException e) //1
{ 
} 


} 

public List<Profile> getRegisteredProfiles()
    { 
return profiles;
} 

private void loadDirectoriesFromConfiguration()
    { 
disableConfigurationUpdate = true;
StringTokenizer tokenizer =
            new StringTokenizer(
            Configuration.getString(KEY_DEFAULT_DIRECTORIES),
            DIRECTORY_SEPARATOR, false);
while (tokenizer.hasMoreTokens()) //1
{ 
searchDirectories.add(tokenizer.nextToken());
} 

disableConfigurationUpdate = false;
} 

public void addToDefaultProfiles(Profile p)
    { 
if(p != null && profiles.contains(p)
                && !defaultProfiles.contains(p))//1
{ 
defaultProfiles.add(p);
updateDefaultProfilesConfiguration();
} 

} 

public void removeFromDefaultProfiles(Profile p)
    { 
if(p != null && p != profileUML && profiles.contains(p))//1
{ 
defaultProfiles.remove(p);
updateDefaultProfilesConfiguration();
} 

} 

public List<Profile> getDefaultProfiles()
    { 
return Collections.unmodifiableList(defaultProfiles);
} 

private void updateDefaultProfilesConfiguration()
    { 
if(!disableConfigurationUpdate)//1
{ 
StringBuffer buf = new StringBuffer();
for (Profile p : defaultProfiles) //1
{ 
if(p instanceof UserDefinedProfile)//1
{ 
buf.append("U"
                               + ((UserDefinedProfile) p).getModelFile()
                               .toURI().toASCIIString());
} 
else
{ 
buf.append("C" + p.getProfileIdentifier());
} 

buf.append(DIRECTORY_SEPARATOR);
} 

Configuration.setString(KEY_DEFAULT_PROFILES, buf.toString());
} 

} 

public Profile getUMLProfile()
    { 
return profileUML;
} 

public void registerProfile(Profile p)
    { 
if(p != null && !profiles.contains(p))//1
{ 
if(p instanceof UserDefinedProfile
                    || getProfileForClass(p.getClass().getName()) == null)//1
{ 
profiles.add(p);

//#if COGNITIVE 
for (Critic critic : p.getCritics()) //1
{ 
for (Object meta : critic.getCriticizedDesignMaterials()) //1
{ 
Agency.register(critic, meta);
} 

critic.setEnabled(false);
} 

//#endif 

loadDefaultProfilesfromConfiguration();
} 

} 

} 

public List<String> getSearchPathDirectories()
    { 
return Collections.unmodifiableList(searchDirectories);
} 

public void refreshRegisteredProfiles()
    { 
ArrayList<File> dirs = new ArrayList<File>();
for (String dirName : searchDirectories) //1
{ 
File dir = new File(dirName);
if(dir.exists())//1
{ 
dirs.add(dir);
} 

} 

if(!dirs.isEmpty())//1
{ 
File[] fileArray = new File[dirs.size()];
for (int i = 0; i < dirs.size(); i++) //1
{ 
fileArray[i] = dirs.get(i);
} 

List<File> dirList
                = UserDefinedProfileHelper.getFileList(fileArray);
for (File file : dirList) //1
{ 
boolean found =
                    findUserDefinedProfile(file) != null;
if(!found)//1
{ 
UserDefinedProfile udp = null;
try //1
{ 
udp = new UserDefinedProfile(file);
registerProfile(udp);
} 
catch (ProfileException e) //1
{ 

//#if LOGGING 
LOG.warn("Failed to load user defined profile "
                                 + file.getAbsolutePath() + ".", e);
//#endif 

} 


} 

} 

} 

} 

public void applyConfiguration(ProfileConfiguration pc)
    { 

//#if COGNITIVE 
for (Profile p : this.profiles) //1
{ 
for (Critic c : p.getCritics()) //1
{ 
c.setEnabled(false);
Configuration.setBoolean(c.getCriticKey(), false);
} 

} 

//#endif 


//#if COGNITIVE 
for (Profile p : pc.getProfiles()) //1
{ 
for (Critic c : p.getCritics()) //1
{ 
c.setEnabled(true);
Configuration.setBoolean(c.getCriticKey(), true);
} 

} 

//#endif 

} 

private Profile findUserDefinedProfile(File file)
    { 
for (Profile p : profiles) //1
{ 
if(p instanceof UserDefinedProfile)//1
{ 
UserDefinedProfile udp = (UserDefinedProfile) p;
if(file.equals(udp.getModelFile()))//1
{ 
return udp;
} 

} 

} 

return null;
} 

 } 


