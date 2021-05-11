
//#if 551061430 
// Compilation Unit of /ProfileManagerImpl.java 
 

//#if 1053043789 
package org.argouml.profile.internal;
//#endif 


//#if 1578930471 
import java.io.File;
//#endif 


//#if -895767568 
import java.net.URI;
//#endif 


//#if -788129318 
import java.net.URISyntaxException;
//#endif 


//#if 1110538816 
import java.util.ArrayList;
//#endif 


//#if 1406563105 
import java.util.Collection;
//#endif 


//#if 653785090 
import java.util.Collections;
//#endif 


//#if 111694881 
import java.util.List;
//#endif 


//#if -599587919 
import java.util.StringTokenizer;
//#endif 


//#if 285257878 
import org.argouml.configuration.Configuration;
//#endif 


//#if -1622257759 
import org.argouml.configuration.ConfigurationKey;
//#endif 


//#if -1047859338 
import org.argouml.kernel.ProfileConfiguration;
//#endif 


//#if 1536771376 
import org.argouml.model.Model;
//#endif 


//#if -1758442238 
import org.argouml.model.UmlException;
//#endif 


//#if -553789840 
import org.argouml.profile.Profile;
//#endif 


//#if -840733865 
import org.argouml.profile.ProfileException;
//#endif 


//#if -2101936519 
import org.argouml.profile.ProfileManager;
//#endif 


//#if 414254098 
import org.argouml.profile.UserDefinedProfile;
//#endif 


//#if -1019280188 
import org.argouml.profile.UserDefinedProfileHelper;
//#endif 


//#if -310765123 
import org.apache.log4j.Logger;
//#endif 


//#if -617756855 
import org.argouml.cognitive.Agency;
//#endif 


//#if 1476049082 
import org.argouml.cognitive.Critic;
//#endif 


//#if 1607484643 
import org.argouml.uml.cognitive.critics.ProfileCodeGeneration;
//#endif 


//#if 1629132979 
import org.argouml.uml.cognitive.critics.ProfileGoodPractices;
//#endif 


//#if -2021462820 
public class ProfileManagerImpl implements 
//#if 842673556 
ProfileManager
//#endif 

  { 

//#if -575639183 
private static final String DIRECTORY_SEPARATOR = "*";
//#endif 


//#if -35651637 
public static final ConfigurationKey KEY_DEFAULT_PROFILES = Configuration
            .makeKey("profiles", "default");
//#endif 


//#if 1733147340 
public static final ConfigurationKey KEY_DEFAULT_DIRECTORIES = Configuration
            .makeKey("profiles", "directories");
//#endif 


//#if -177609111 
private boolean disableConfigurationUpdate = false;
//#endif 


//#if 237208691 
private List<Profile> profiles = new ArrayList<Profile>();
//#endif 


//#if -1189040526 
private List<Profile> defaultProfiles = new ArrayList<Profile>();
//#endif 


//#if -973789450 
private List<String> searchDirectories = new ArrayList<String>();
//#endif 


//#if -2073386542 
private ProfileUML profileUML;
//#endif 


//#if 1539782600 
private ProfileJava profileJava;
//#endif 


//#if -1888962508 
private static final String OLD_PROFILE_PACKAGE = "org.argouml.uml.profile";
//#endif 


//#if 523431208 
private static final String NEW_PROFILE_PACKAGE =
        "org.argouml.profile.internal";
//#endif 


//#if 1562334306 
private static final Logger LOG = Logger.getLogger(
                                          ProfileManagerImpl.class);
//#endif 


//#if -428702524 
private ProfileGoodPractices profileGoodPractices;
//#endif 


//#if -315944536 
private ProfileCodeGeneration profileCodeGeneration;
//#endif 


//#if -1367510025 
public void addSearchPathDirectory(String path)
    { 

//#if -1338373861 
if(path != null && !searchDirectories.contains(path))//1
{ 

//#if 1164797487 
searchDirectories.add(path);
//#endif 


//#if 1728811096 
updateSearchDirectoriesConfiguration();
//#endif 


//#if 1697020188 
try //1
{ 

//#if -1472051166 
Model.getXmiReader().addSearchPath(path);
//#endif 

} 

//#if 1049098975 
catch (UmlException e) //1
{ 

//#if 748405155 
LOG.error("Couldn't retrive XMI Reader from Model.", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -1028480892 
private void updateSearchDirectoriesConfiguration()
    { 

//#if 1504421516 
if(!disableConfigurationUpdate)//1
{ 

//#if -1322214570 
StringBuffer buf = new StringBuffer();
//#endif 


//#if -1880195262 
for (String s : searchDirectories) //1
{ 

//#if 770432735 
buf.append(s).append(DIRECTORY_SEPARATOR);
//#endif 

} 

//#endif 


//#if -201200488 
Configuration.setString(KEY_DEFAULT_DIRECTORIES, buf.toString());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1351604670 
public ProfileManagerImpl()
    { 

//#if 886673667 
try //1
{ 

//#if -568228636 
disableConfigurationUpdate = true;
//#endif 


//#if 398295524 
profileUML = new ProfileUML();
//#endif 


//#if -1830126933 
profileJava = new ProfileJava(profileUML);
//#endif 


//#if 432147606 
profileGoodPractices = new ProfileGoodPractices();
//#endif 


//#if 1440081362 
profileCodeGeneration = new ProfileCodeGeneration(
                profileGoodPractices);
//#endif 


//#if 368626236 
registerProfile(profileUML);
//#endif 


//#if -1002354727 
addToDefaultProfiles(profileUML);
//#endif 


//#if -1752634274 
registerProfile(profileJava);
//#endif 


//#if -594935165 
registerProfile(profileGoodPractices);
//#endif 


//#if -904419359 
registerProfile(profileCodeGeneration);
//#endif 


//#if 149104288 
registerProfile(new ProfileMeta());
//#endif 

} 

//#if -854973569 
catch (ProfileException e) //1
{ 

//#if -1505000811 
throw new RuntimeException(e);
//#endif 

} 

//#endif 

finally { 

//#if -1479422026 
disableConfigurationUpdate = false;
//#endif 

} 

//#endif 


//#if 1684170214 
loadDirectoriesFromConfiguration();
//#endif 


//#if 2076944832 
refreshRegisteredProfiles();
//#endif 


//#if 750399686 
loadDefaultProfilesfromConfiguration();
//#endif 

} 

//#endif 


//#if -1040808956 
public Profile lookForRegisteredProfile(String value)
    { 

//#if 1557229455 
List<Profile> registeredProfiles = getRegisteredProfiles();
//#endif 


//#if 2029616662 
for (Profile profile : registeredProfiles) //1
{ 

//#if 1519109343 
if(profile.getProfileIdentifier().equalsIgnoreCase(value))//1
{ 

//#if -2147082989 
return profile;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1915456245 
return null;
//#endif 

} 

//#endif 


//#if -1504346513 
private void loadDefaultProfilesfromConfiguration()
    { 

//#if -201185593 
if(!disableConfigurationUpdate)//1
{ 

//#if -1477450454 
disableConfigurationUpdate = true;
//#endif 


//#if 1141463131 
String defaultProfilesList = Configuration
                                         .getString(KEY_DEFAULT_PROFILES);
//#endif 


//#if -993081451 
if(defaultProfilesList.equals(""))//1
{ 

//#if 515183436 
addToDefaultProfiles(profileJava);
//#endif 


//#if -1443903659 
addToDefaultProfiles(profileGoodPractices);
//#endif 


//#if -1452638897 
addToDefaultProfiles(profileCodeGeneration);
//#endif 

} 
else
{ 

//#if 1518573397 
StringTokenizer tokenizer = new StringTokenizer(
                    defaultProfilesList, DIRECTORY_SEPARATOR, false);
//#endif 


//#if -1789737226 
while (tokenizer.hasMoreTokens()) //1
{ 

//#if -816282760 
String desc = tokenizer.nextToken();
//#endif 


//#if -698040756 
Profile p = null;
//#endif 


//#if 1077141609 
if(desc.charAt(0) == 'U')//1
{ 

//#if -814029425 
String fileName = desc.substring(1);
//#endif 


//#if 2024594654 
File file;
//#endif 


//#if -1116873253 
try //1
{ 

//#if 495258168 
file = new File(new URI(fileName));
//#endif 


//#if 63435448 
p = findUserDefinedProfile(file);
//#endif 


//#if 1133628929 
if(p == null)//1
{ 

//#if -517488110 
try //1
{ 

//#if 1348068104 
p = new UserDefinedProfile(file);
//#endif 


//#if -704065552 
registerProfile(p);
//#endif 

} 

//#if -546972976 
catch (ProfileException e) //1
{ 

//#if 181394353 
LOG.error("Error loading profile: " + file,
                                              e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#if 1997797167 
catch (URISyntaxException e1) //1
{ 

//#if -998071095 
LOG.error("Invalid path for Profile: " + fileName,
                                      e1);
//#endif 

} 

//#endif 


//#if -43013190 
catch (Throwable e2) //1
{ 

//#if -292328056 
LOG.error("Error loading profile: " + fileName,
                                      e2);
//#endif 

} 

//#endif 


//#endif 

} 
else

//#if 1549015485 
if(desc.charAt(0) == 'C')//1
{ 

//#if 843594678 
String profileIdentifier = desc.substring(1);
//#endif 


//#if 1154191249 
p = lookForRegisteredProfile(profileIdentifier);
//#endif 

} 

//#endif 


//#endif 


//#if 2008606398 
if(p != null)//1
{ 

//#if -1518143162 
addToDefaultProfiles(p);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1026914907 
disableConfigurationUpdate = false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 399677459 
public Profile getProfileForClass(String profileClass)
    { 

//#if 1661798679 
Profile found = null;
//#endif 


//#if -386494463 
if(profileClass != null
                && profileClass.startsWith(OLD_PROFILE_PACKAGE))//1
{ 

//#if -608256947 
profileClass = profileClass.replace(OLD_PROFILE_PACKAGE,
                                                NEW_PROFILE_PACKAGE);
//#endif 

} 

//#endif 


//#if 140387955 
assert profileUML.getClass().getName().startsWith(NEW_PROFILE_PACKAGE);
//#endif 


//#if -464435905 
for (Profile p : profiles) //1
{ 

//#if 167602609 
if(p.getClass().getName().equals(profileClass))//1
{ 

//#if -654945615 
found = p;
//#endif 


//#if -188894073 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1657447984 
return found;
//#endif 

} 

//#endif 


//#if 326739130 
public void removeSearchPathDirectory(String path)
    { 

//#if -1967378162 
if(path != null)//1
{ 

//#if -1631252459 
searchDirectories.remove(path);
//#endif 


//#if -1233764989 
updateSearchDirectoriesConfiguration();
//#endif 


//#if 711397009 
try //1
{ 

//#if -1483787125 
Model.getXmiReader().removeSearchPath(path);
//#endif 

} 

//#if -2137055002 
catch (UmlException e) //1
{ 

//#if -833047936 
LOG.error("Couldn't retrive XMI Reader from Model.", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 1603060306 
public void removeProfile(Profile p)
    { 

//#if -1057637216 
if(p != null && p != profileUML)//1
{ 

//#if 1427235592 
profiles.remove(p);
//#endif 


//#if 1938075963 
defaultProfiles.remove(p);
//#endif 

} 

//#endif 


//#if 1680670061 
try //1
{ 

//#if 765314553 
Collection packages = p.getProfilePackages();
//#endif 


//#if -1577868608 
if(packages != null && !packages.isEmpty())//1
{ 

//#if 1817721408 
Model.getUmlFactory().deleteExtent(packages.iterator().next());
//#endif 

} 

//#endif 

} 

//#if 1363151617 
catch (ProfileException e) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 


//#if -1998143959 
public List<Profile> getRegisteredProfiles()
    { 

//#if -282043454 
return profiles;
//#endif 

} 

//#endif 


//#if -330669489 
private void loadDirectoriesFromConfiguration()
    { 

//#if -56600865 
disableConfigurationUpdate = true;
//#endif 


//#if 2138186131 
StringTokenizer tokenizer =
            new StringTokenizer(
            Configuration.getString(KEY_DEFAULT_DIRECTORIES),
            DIRECTORY_SEPARATOR, false);
//#endif 


//#if -884437428 
while (tokenizer.hasMoreTokens()) //1
{ 

//#if -24517974 
searchDirectories.add(tokenizer.nextToken());
//#endif 

} 

//#endif 


//#if 2123579206 
disableConfigurationUpdate = false;
//#endif 

} 

//#endif 


//#if 768252982 
public void addToDefaultProfiles(Profile p)
    { 

//#if 1678879548 
if(p != null && profiles.contains(p)
                && !defaultProfiles.contains(p))//1
{ 

//#if -531602103 
defaultProfiles.add(p);
//#endif 


//#if 1287554199 
updateDefaultProfilesConfiguration();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1209636758 
public void removeFromDefaultProfiles(Profile p)
    { 

//#if 994156290 
if(p != null && p != profileUML && profiles.contains(p))//1
{ 

//#if 99732867 
defaultProfiles.remove(p);
//#endif 


//#if 1688227012 
updateDefaultProfilesConfiguration();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -120628880 
public List<Profile> getDefaultProfiles()
    { 

//#if 553544507 
return Collections.unmodifiableList(defaultProfiles);
//#endif 

} 

//#endif 


//#if -2058631364 
private void updateDefaultProfilesConfiguration()
    { 

//#if -1290276786 
if(!disableConfigurationUpdate)//1
{ 

//#if -1134717897 
StringBuffer buf = new StringBuffer();
//#endif 


//#if -2008416430 
for (Profile p : defaultProfiles) //1
{ 

//#if 1774392357 
if(p instanceof UserDefinedProfile)//1
{ 

//#if 2144242478 
buf.append("U"
                               + ((UserDefinedProfile) p).getModelFile()
                               .toURI().toASCIIString());
//#endif 

} 
else
{ 

//#if 1861794038 
buf.append("C" + p.getProfileIdentifier());
//#endif 

} 

//#endif 


//#if -81662221 
buf.append(DIRECTORY_SEPARATOR);
//#endif 

} 

//#endif 


//#if 284852318 
Configuration.setString(KEY_DEFAULT_PROFILES, buf.toString());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1631354596 
public Profile getUMLProfile()
    { 

//#if -1453573372 
return profileUML;
//#endif 

} 

//#endif 


//#if 828566867 
public void registerProfile(Profile p)
    { 

//#if 807227576 
if(p != null && !profiles.contains(p))//1
{ 

//#if -668941608 
if(p instanceof UserDefinedProfile
                    || getProfileForClass(p.getClass().getName()) == null)//1
{ 

//#if 683641539 
profiles.add(p);
//#endif 


//#if -988088841 
for (Critic critic : p.getCritics()) //1
{ 

//#if 1886998643 
for (Object meta : critic.getCriticizedDesignMaterials()) //1
{ 

//#if 1014417567 
Agency.register(critic, meta);
//#endif 

} 

//#endif 


//#if 435423219 
critic.setEnabled(false);
//#endif 

} 

//#endif 


//#if -1520141369 
loadDefaultProfilesfromConfiguration();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1390665905 
public List<String> getSearchPathDirectories()
    { 

//#if -1842017712 
return Collections.unmodifiableList(searchDirectories);
//#endif 

} 

//#endif 


//#if -412347717 
public void refreshRegisteredProfiles()
    { 

//#if 2075699285 
ArrayList<File> dirs = new ArrayList<File>();
//#endif 


//#if -796863829 
for (String dirName : searchDirectories) //1
{ 

//#if -1152616534 
File dir = new File(dirName);
//#endif 


//#if 297457129 
if(dir.exists())//1
{ 

//#if -1635449507 
dirs.add(dir);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2135386008 
if(!dirs.isEmpty())//1
{ 

//#if 356946167 
File[] fileArray = new File[dirs.size()];
//#endif 


//#if 1138291634 
for (int i = 0; i < dirs.size(); i++) //1
{ 

//#if 914945007 
fileArray[i] = dirs.get(i);
//#endif 

} 

//#endif 


//#if 929171980 
List<File> dirList
                = UserDefinedProfileHelper.getFileList(fileArray);
//#endif 


//#if 595916676 
for (File file : dirList) //1
{ 

//#if -1900934609 
boolean found =
                    findUserDefinedProfile(file) != null;
//#endif 


//#if 129217457 
if(!found)//1
{ 

//#if -252938809 
UserDefinedProfile udp = null;
//#endif 


//#if 1593135452 
try //1
{ 

//#if -1559838425 
udp = new UserDefinedProfile(file);
//#endif 


//#if 1001189809 
registerProfile(udp);
//#endif 

} 

//#if -1744769570 
catch (ProfileException e) //1
{ 

//#if 1589030556 
LOG.warn("Failed to load user defined profile "
                                 + file.getAbsolutePath() + ".", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1698349706 
public void applyConfiguration(ProfileConfiguration pc)
    { 

//#if -293810352 
for (Profile p : this.profiles) //1
{ 

//#if 749626787 
for (Critic c : p.getCritics()) //1
{ 

//#if -98191386 
c.setEnabled(false);
//#endif 


//#if 510510693 
Configuration.setBoolean(c.getCriticKey(), false);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1194310624 
for (Profile p : pc.getProfiles()) //1
{ 

//#if 284806630 
for (Critic c : p.getCritics()) //1
{ 

//#if -1453516105 
c.setEnabled(true);
//#endif 


//#if 749357448 
Configuration.setBoolean(c.getCriticKey(), true);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1802926621 
private Profile findUserDefinedProfile(File file)
    { 

//#if 704031306 
for (Profile p : profiles) //1
{ 

//#if -1904602898 
if(p instanceof UserDefinedProfile)//1
{ 

//#if 1477924195 
UserDefinedProfile udp = (UserDefinedProfile) p;
//#endif 


//#if 1416283533 
if(file.equals(udp.getModelFile()))//1
{ 

//#if -1096479618 
return udp;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1231691832 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

