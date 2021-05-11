
//#if 2088104527 
// Compilation Unit of /ProfileConfigurationFilePersister.java 
 

//#if -340882564 
package org.argouml.persistence;
//#endif 


//#if -1097079077 
import java.io.File;
//#endif 


//#if -1231727878 
import java.io.FileOutputStream;
//#endif 


//#if 2053947222 
import java.io.IOException;
//#endif 


//#if 35657077 
import java.io.InputStream;
//#endif 


//#if -944505578 
import java.io.OutputStream;
//#endif 


//#if -1686098269 
import java.io.OutputStreamWriter;
//#endif 


//#if -1620799841 
import java.io.PrintWriter;
//#endif 


//#if 497806707 
import java.io.StringWriter;
//#endif 


//#if 170961712 
import java.io.UnsupportedEncodingException;
//#endif 


//#if 723190273 
import java.net.URL;
//#endif 


//#if -217312756 
import java.util.ArrayList;
//#endif 


//#if -1102129963 
import java.util.Collection;
//#endif 


//#if 1151929557 
import java.util.List;
//#endif 


//#if -357682741 
import org.argouml.application.api.Argo;
//#endif 


//#if 1544523207 
import org.argouml.application.helpers.ApplicationVersion;
//#endif 


//#if 328034914 
import org.argouml.configuration.Configuration;
//#endif 


//#if -1005082302 
import org.argouml.kernel.ProfileConfiguration;
//#endif 


//#if -559223154 
import org.argouml.kernel.Project;
//#endif 


//#if -2069035820 
import org.argouml.kernel.ProjectMember;
//#endif 


//#if 1787500284 
import org.argouml.model.Model;
//#endif 


//#if -1540285002 
import org.argouml.model.UmlException;
//#endif 


//#if -145200322 
import org.argouml.model.XmiWriter;
//#endif 


//#if -1713774020 
import org.argouml.profile.Profile;
//#endif 


//#if -1435920382 
import org.argouml.profile.ProfileFacade;
//#endif 


//#if -1934076627 
import org.argouml.profile.ProfileManager;
//#endif 


//#if -7994 
import org.argouml.profile.UserDefinedProfile;
//#endif 


//#if 1526342019 
import org.xml.sax.InputSource;
//#endif 


//#if -306882103 
import org.xml.sax.SAXException;
//#endif 


//#if -60036215 
import org.apache.log4j.Logger;
//#endif 


//#if 463176993 
class ProfileConfigurationParser extends 
//#if -1400916474 
SAXParserBase
//#endif 

  { 

//#if -1853673814 
private ProfileConfigurationTokenTable tokens =
        new ProfileConfigurationTokenTable();
//#endif 


//#if -1842583860 
private Profile profile;
//#endif 


//#if -1436267342 
private String model;
//#endif 


//#if -667681644 
private String filename;
//#endif 


//#if 212910063 
private Collection<Profile> profiles = new ArrayList<Profile>();
//#endif 


//#if -1776064718 
private Collection<String> unresolvedFilenames = new ArrayList<String>();
//#endif 


//#if -1448402330 
private static final Logger LOG = Logger
                                      .getLogger(ProfileConfigurationParser.class);
//#endif 


//#if -417634487 
protected void handleModelEnd(XMLElement e)
    { 

//#if 2082363017 
model = e.getText().trim();
//#endif 


//#if 1522411437 
LOG.debug("Got model = " + model);
//#endif 

} 

//#endif 


//#if 2121249226 
public ProfileConfigurationParser()
    { 
} 

//#endif 


//#if 486785123 
private static Profile getMatchingUserDefinedProfile(String fileName,
            ProfileManager profileManager)
    { 

//#if -1572182735 
for (Profile candidateProfile
                : profileManager.getRegisteredProfiles()) //1
{ 

//#if 768689872 
if(candidateProfile instanceof UserDefinedProfile)//1
{ 

//#if -1002532687 
UserDefinedProfile userProfile =
                    (UserDefinedProfile) candidateProfile;
//#endif 


//#if 1963488017 
if(userProfile.getModelFile() != null
                        && fileName
                        .equals(userProfile.getModelFile().getName()))//1
{ 

//#if -1874047939 
return userProfile;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1256336450 
return null;
//#endif 

} 

//#endif 


//#if 363929747 
protected void handleFilenameEnd(XMLElement e)
    { 

//#if -1223637527 
filename = e.getText().trim();
//#endif 


//#if 162419477 
LOG.debug("Got filename = " + filename);
//#endif 

} 

//#endif 


//#if -1565312418 
protected void handleUserDefinedEnd(XMLElement e)
    { 

//#if 1604189040 
if(filename == null)//1
{ 

//#if 1425633077 
LOG.error("Got badly formed user defined profile entry " + e);
//#endif 

} 

//#endif 


//#if -1809147381 
profile = getMatchingUserDefinedProfile(filename, ProfileFacade
                                                .getManager());
//#endif 


//#if 1740149598 
if(profile == null)//1
{ 

//#if -962950383 
unresolvedFilenames.add(filename);
//#endif 

} 
else
{ 

//#if 698730885 
profiles.add(profile);
//#endif 


//#if -112695255 
LOG.debug("Loaded user defined profile - filename = " + filename);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2026012687 
protected void handlePluginEnd(XMLElement e) throws SAXException
    { 

//#if -1594532679 
String name = e.getText().trim();
//#endif 


//#if 1826165663 
profile = lookupProfile(name);
//#endif 


//#if 1014071390 
if(profile != null)//1
{ 

//#if 163784178 
profiles.add(profile);
//#endif 


//#if 1646192923 
LOG.debug("Found plugin profile " + name);
//#endif 

} 
else
{ 

//#if 632285537 
LOG.error("Unabled to find plugin profile - " + name);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1574262766 
public Collection<String> getUnresolvedFilenames()
    { 

//#if 1302649768 
return unresolvedFilenames;
//#endif 

} 

//#endif 


//#if 194933577 
protected void handleProfileEnd(XMLElement e)
    { 

//#if 979149562 
if(profiles.isEmpty())//1
{ 

//#if -875742973 
LOG.warn("No profiles defined");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 96611263 
private static Profile lookupProfile(String profileIdentifier)
    throws SAXException
    { 

//#if 165417908 
Profile profile;
//#endif 


//#if -273425271 
profile = ProfileFacade.getManager().lookForRegisteredProfile(
                      profileIdentifier);
//#endif 


//#if 822333044 
if(profile == null)//1
{ 

//#if 1583690894 
profile = ProfileFacade.getManager().getProfileForClass(
                          profileIdentifier);
//#endif 


//#if 1548637812 
if(profile == null)//1
{ 

//#if -1439232624 
throw new SAXException("Plugin profile \"" + profileIdentifier
                                       + "\" is not available in installation.", null);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 867075657 
return profile;
//#endif 

} 

//#endif 


//#if -1320896663 
public void handleEndElement(XMLElement e) throws SAXException
    { 

//#if -974105715 
try //1
{ 

//#if 134650239 
switch (tokens.toToken(e.getName(), false)) //1
{ 
case ProfileConfigurationTokenTable.TOKEN_PROFILE://1


//#if -1402893205 
handleProfileEnd(e);
//#endif 


//#if -1266709986 
break;

//#endif 


case ProfileConfigurationTokenTable.TOKEN_PLUGIN://1


//#if 1734722499 
handlePluginEnd(e);
//#endif 


//#if -1876873880 
break;

//#endif 


case ProfileConfigurationTokenTable.TOKEN_USER_DEFINED://1


//#if 1048459079 
handleUserDefinedEnd(e);
//#endif 


//#if 2076206063 
break;

//#endif 


case ProfileConfigurationTokenTable.TOKEN_FILENAME://1


//#if -1188319206 
handleFilenameEnd(e);
//#endif 


//#if 1688149021 
break;

//#endif 


case ProfileConfigurationTokenTable.TOKEN_MODEL://1


//#if -185386880 
handleModelEnd(e);
//#endif 


//#if -1088871245 
break;

//#endif 


default://1


//#if -1537850863 
LOG.warn("WARNING: unknown end tag:" + e.getName());
//#endif 


//#if 60177844 
break;

//#endif 


} 

//#endif 

} 

//#if -679227313 
catch (Exception ex) //1
{ 

//#if 803948514 
throw new SAXException(ex);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -694320373 
public Collection<Profile> getProfiles()
    { 

//#if 85657275 
return profiles;
//#endif 

} 

//#endif 


//#if 1632177406 
public void handleStartElement(XMLElement e)
    { 

//#if 1399606315 
try //1
{ 

//#if -1223850795 
switch (tokens.toToken(e.getName(), true)) //1
{ 
case ProfileConfigurationTokenTable.TOKEN_PROFILE://1


//#if -1574424450 
break;

//#endif 


case ProfileConfigurationTokenTable.TOKEN_PLUGIN://1


//#if -1108733455 
profile = null;
//#endif 


//#if 607999659 
break;

//#endif 


case ProfileConfigurationTokenTable.TOKEN_USER_DEFINED://1


//#if -1424363406 
profile = null;
//#endif 


//#if 1818917996 
filename = null;
//#endif 


//#if 975773298 
model = null;
//#endif 


//#if 1099454282 
break;

//#endif 


case ProfileConfigurationTokenTable.TOKEN_FILENAME://1


//#if -150828560 
break;

//#endif 


case ProfileConfigurationTokenTable.TOKEN_MODEL://1


//#if -665140405 
break;

//#endif 


default://1


//#if -954468689 
LOG.warn("WARNING: unknown tag:" + e.getName());
//#endif 


//#if -1741418901 
break;

//#endif 


} 

//#endif 

} 

//#if -527483200 
catch (Exception ex) //1
{ 

//#if -295745045 
LOG.error("Exception in startelement", ex);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -2085651290 
class ProfileConfigurationTokenTable extends 
//#if 2037621214 
XMLTokenTableBase
//#endif 

  { 

//#if -342844979 
private static final String STRING_PROFILE = "profile";
//#endif 


//#if -1066876899 
private static final String STRING_PLUGIN = "plugin";
//#endif 


//#if 1039103524 
private static final String STRING_USER_DEFINED = "userDefined";
//#endif 


//#if -1768387515 
private static final String STRING_FILENAME = "filename";
//#endif 


//#if 509540045 
private static final String STRING_MODEL = "model";
//#endif 


//#if -2114158829 
public static final int TOKEN_PROFILE = 1;
//#endif 


//#if 1063272062 
public static final int TOKEN_PLUGIN = 2;
//#endif 


//#if -872971045 
public static final int TOKEN_USER_DEFINED = 3;
//#endif 


//#if 663705768 
public static final int TOKEN_FILENAME = 4;
//#endif 


//#if 1413423951 
public static final int TOKEN_MODEL = 5;
//#endif 


//#if -1996134500 
private static final int TOKEN_LAST = 5;
//#endif 


//#if -1115120540 
public static final int TOKEN_UNDEFINED = 999;
//#endif 


//#if -564130923 
protected void setupTokens()
        { 

//#if 654417403 
addToken(STRING_PROFILE, Integer.valueOf(TOKEN_PROFILE));
//#endif 


//#if 839047465 
addToken(STRING_PLUGIN, Integer.valueOf(TOKEN_PLUGIN));
//#endif 


//#if 2010480553 
addToken(STRING_USER_DEFINED, Integer.valueOf(TOKEN_USER_DEFINED));
//#endif 


//#if 1561619305 
addToken(STRING_FILENAME, Integer.valueOf(TOKEN_FILENAME));
//#endif 


//#if 1148527931 
addToken(STRING_MODEL, Integer.valueOf(TOKEN_MODEL));
//#endif 

} 

//#endif 


//#if 2099801195 
public ProfileConfigurationTokenTable()
        { 

//#if 1521355559 
super(TOKEN_LAST);
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#if -165552756 
public class ProfileConfigurationFilePersister extends 
//#if -1709303614 
MemberFilePersister
//#endif 

  { 

//#if 138810475 
private static final Logger LOG =
        Logger.getLogger(ProfileConfigurationFilePersister.class);
//#endif 


//#if 1167832334 
private void addUserDefinedProfile(String fileName, StringBuffer xmi,
                                       ProfileManager profileManager) throws IOException
    { 

//#if 241066119 
File profilesDirectory = getProfilesDirectory(profileManager);
//#endif 


//#if 1674897750 
File profileFile = new File(profilesDirectory, fileName);
//#endif 


//#if -1266751890 
OutputStreamWriter writer = new OutputStreamWriter(
            new FileOutputStream(profileFile),
            Argo.getEncoding());
//#endif 


//#if -310177655 
writer.write(xmi.toString());
//#endif 


//#if -1754086647 
writer.close();
//#endif 


//#if 1099140433 
LOG.info("Wrote user defined profile \"" + profileFile
                 + "\", with size " + xmi.length() + ".");
//#endif 


//#if 413621628 
if(isSomeProfileDirectoryConfigured(profileManager))//1
{ 

//#if 292802590 
profileManager.refreshRegisteredProfiles();
//#endif 

} 
else
{ 

//#if 352394816 
profileManager.addSearchPathDirectory(
                profilesDirectory.getAbsolutePath());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1585242215 
private static boolean isSomeProfileDirectoryConfigured(
        ProfileManager profileManager)
    { 

//#if 1400403355 
return profileManager.getSearchPathDirectories().size() > 0;
//#endif 

} 

//#endif 


//#if 1063058031 
public String getMainTag()
    { 

//#if -528702410 
return "profile";
//#endif 

} 

//#endif 


//#if 1267734833 
private Collection<Profile> loadUnresolved(Collection<String> unresolved)
    { 

//#if 498960249 
Collection<Profile> profiles = new ArrayList<Profile>();
//#endif 


//#if 1559775932 
ProfileManager profileManager = ProfileFacade.getManager();
//#endif 


//#if 1630712323 
for (String filename : unresolved) //1
{ 
} 

//#endif 


//#if -436461784 
return profiles;
//#endif 

} 

//#endif 


//#if 100959457 
public void save(ProjectMember member, OutputStream stream)
    throws SaveException
    { 

//#if -352104099 
PrintWriter w;
//#endif 


//#if 241374077 
try //1
{ 

//#if -728918375 
w = new PrintWriter(new OutputStreamWriter(stream, "UTF-8"));
//#endif 

} 

//#if 1407474071 
catch (UnsupportedEncodingException e1) //1
{ 

//#if 1715396850 
throw new SaveException("UTF-8 encoding not supported on platform",
                                    e1);
//#endif 

} 

//#endif 


//#endif 


//#if 698275632 
saveProjectMember(member, w);
//#endif 


//#if 312269492 
w.flush();
//#endif 

} 

//#endif 


//#if -108477686 
private static File getProfilesDirectory(ProfileManager profileManager)
    { 

//#if -598691223 
if(isSomeProfileDirectoryConfigured(profileManager))//1
{ 

//#if 1875188605 
List<String> directories =
                profileManager.getSearchPathDirectories();
//#endif 


//#if -476795184 
return new File(directories.get(0));
//#endif 

} 
else
{ 

//#if 445309331 
File userSettingsFile = new File(
                Configuration.getFactory().getConfigurationHandler().
                getDefaultPath());
//#endif 


//#if -424417469 
return userSettingsFile.getParentFile();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1939724243 
private void printModelXMI(PrintWriter w, Collection profileModels)
    throws UmlException
    { 

//#if 555217012 
if(true)//1
{ 

//#if -2003124583 
return;
//#endif 

} 

//#endif 


//#if 1691346499 
StringWriter myWriter = new StringWriter();
//#endif 


//#if 93713791 
for (Object model : profileModels) //1
{ 

//#if 58061847 
XmiWriter xmiWriter = Model.getXmiWriter(model,
                                  (OutputStream) null, //myWriter,
                                  ApplicationVersion.getVersion() + "("
                                  + UmlFilePersister.PERSISTENCE_VERSION + ")");
//#endif 


//#if -1104621013 
xmiWriter.write();
//#endif 

} 

//#endif 


//#if 985290776 
myWriter.flush();
//#endif 


//#if 1175603776 
w.println("" + myWriter.toString());
//#endif 

} 

//#endif 


//#if 1877225177 
@Override
    public void load(Project project, URL url) throws OpenException
    { 

//#if -1350969874 
try //1
{ 

//#if -1051446337 
load(project, url.openStream());
//#endif 

} 

//#if 202381076 
catch (IOException e) //1
{ 

//#if 1989078645 
throw new OpenException(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -812718721 
public void load(Project project, InputStream inputStream)
    throws OpenException
    { 

//#if 772457984 
try //1
{ 

//#if -2031625921 
ProfileConfigurationParser parser =
                new ProfileConfigurationParser();
//#endif 


//#if -837423311 
parser.parse(new InputSource(inputStream));
//#endif 


//#if 114161448 
Collection<Profile> profiles = parser.getProfiles();
//#endif 


//#if -671256126 
Collection<String> unresolved = parser.getUnresolvedFilenames();
//#endif 


//#if 1243455622 
if(!unresolved.isEmpty())//1
{ 

//#if -275136477 
profiles.addAll(loadUnresolved(unresolved));
//#endif 

} 

//#endif 


//#if -1321210554 
ProfileConfiguration pc = new ProfileConfiguration(project,
                    profiles);
//#endif 


//#if 1851812756 
project.setProfileConfiguration(pc);
//#endif 

} 

//#if 1728428892 
catch (Exception e) //1
{ 

//#if 1093476311 
if(e instanceof OpenException)//1
{ 

//#if -460367849 
throw (OpenException) e;
//#endif 

} 

//#endif 


//#if 1505330890 
throw new OpenException(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1508199602 
private void saveProjectMember(ProjectMember member, PrintWriter w)
    throws SaveException
    { 

//#if -513349418 
try //1
{ 

//#if 545905204 
if(member instanceof ProfileConfiguration)//1
{ 

//#if 1608419119 
ProfileConfiguration pc = (ProfileConfiguration) member;
//#endif 


//#if -907337408 
w.println("<?xml version = \"1.0\" encoding = \"UTF-8\" ?>");
//#endif 


//#if 727455073 
w.println("");
//#endif 


//#if 524861782 
w.println("<profile>");
//#endif 


//#if 1300433962 
for (Profile profile : pc.getProfiles()) //1
{ 

//#if 666339860 
if(profile instanceof UserDefinedProfile)//1
{ 

//#if -1361167266 
UserDefinedProfile uprofile =
                            (UserDefinedProfile) profile;
//#endif 


//#if 898127506 
w.println("\t\t<userDefined>");
//#endif 


//#if 710991023 
w.println("\t\t\t<filename>"
                                  + uprofile.getModelFile().getName()
                                  + "</filename>");
//#endif 


//#if 1079132693 
w.println("\t\t\t<model>");
//#endif 


//#if 1769693376 
printModelXMI(w, uprofile.getProfilePackages());
//#endif 


//#if -1341302182 
w.println("\t\t\t</model>");
//#endif 


//#if 380988999 
w.println("\t\t</userDefined>");
//#endif 

} 
else
{ 

//#if 2055248901 
w.println("\t\t<plugin>");
//#endif 


//#if -2145542219 
w.println("\t\t\t" + profile.getProfileIdentifier());
//#endif 


//#if -521394180 
w.println("\t\t</plugin>");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -151181319 
w.println("</profile>");
//#endif 

} 

//#endif 

} 

//#if 1256733912 
catch (Exception e) //1
{ 

//#if 1815477490 
e.printStackTrace();
//#endif 


//#if -1102925970 
throw new SaveException(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

