package org.argouml.persistence;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.argouml.application.api.Argo;
import org.argouml.application.helpers.ApplicationVersion;
import org.argouml.configuration.Configuration;
import org.argouml.kernel.ProfileConfiguration;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectMember;
import org.argouml.model.Model;
import org.argouml.model.UmlException;
import org.argouml.model.XmiWriter;
import org.argouml.profile.Profile;
import org.argouml.profile.ProfileFacade;
import org.argouml.profile.ProfileManager;
import org.argouml.profile.UserDefinedProfile;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.apache.log4j.Logger;
class ProfileConfigurationParser extends SAXParserBase
  { 
private ProfileConfigurationTokenTable tokens =
        new ProfileConfigurationTokenTable();
private Profile profile;
private String model;
private String filename;
private Collection<Profile> profiles = new ArrayList<Profile>();
private Collection<String> unresolvedFilenames = new ArrayList<String>();
private static final Logger LOG = Logger
                                      .getLogger(ProfileConfigurationParser.class);
protected void handleModelEnd(XMLElement e)
    { 
model = e.getText().trim();
LOG.debug("Got model = " + model);
} 
public ProfileConfigurationParser()
    { 
} 
private static Profile getMatchingUserDefinedProfile(String fileName,
            ProfileManager profileManager)
    { 
for (Profile candidateProfile
                : profileManager.getRegisteredProfiles()) //1
{ 
if(candidateProfile instanceof UserDefinedProfile)//1
{ 
UserDefinedProfile userProfile =
                    (UserDefinedProfile) candidateProfile;
if(userProfile.getModelFile() != null
                        && fileName
                        .equals(userProfile.getModelFile().getName()))//1
{ 
return userProfile;
} 
} 
} 
return null;
} 
protected void handleFilenameEnd(XMLElement e)
    { 
filename = e.getText().trim();
LOG.debug("Got filename = " + filename);
} 
protected void handleUserDefinedEnd(XMLElement e)
    { 
if(filename == null)//1
{ 
LOG.error("Got badly formed user defined profile entry " + e);
} 
profile = getMatchingUserDefinedProfile(filename, ProfileFacade
                                                .getManager());
if(profile == null)//1
{ 
unresolvedFilenames.add(filename);
} 
else
{ 
profiles.add(profile);
LOG.debug("Loaded user defined profile - filename = " + filename);
} 
} 
protected void handlePluginEnd(XMLElement e) throws SAXException
    { 
String name = e.getText().trim();
profile = lookupProfile(name);
if(profile != null)//1
{ 
profiles.add(profile);
LOG.debug("Found plugin profile " + name);
} 
else
{ 
LOG.error("Unabled to find plugin profile - " + name);
} 
} 
public Collection<String> getUnresolvedFilenames()
    { 
return unresolvedFilenames;
} 
protected void handleProfileEnd(XMLElement e)
    { 
if(profiles.isEmpty())//1
{ 
LOG.warn("No profiles defined");
} 
} 
private static Profile lookupProfile(String profileIdentifier)
    throws SAXException
    { 
Profile profile;
profile = ProfileFacade.getManager().lookForRegisteredProfile(
                      profileIdentifier);
if(profile == null)//1
{ 
profile = ProfileFacade.getManager().getProfileForClass(
                          profileIdentifier);
if(profile == null)//1
{ 
throw new SAXException("Plugin profile \"" + profileIdentifier
                                       + "\" is not available in installation.", null);
} 
} 
return profile;
} 
public void handleEndElement(XMLElement e) throws SAXException
    { 
try//1
{ 
switch (tokens.toToken(e.getName(), false)) //1
{ 
case ProfileConfigurationTokenTable.TOKEN_PROFILE://1

handleProfileEnd(e);
break;


case ProfileConfigurationTokenTable.TOKEN_PLUGIN://1

handlePluginEnd(e);
break;


case ProfileConfigurationTokenTable.TOKEN_USER_DEFINED://1

handleUserDefinedEnd(e);
break;


case ProfileConfigurationTokenTable.TOKEN_FILENAME://1

handleFilenameEnd(e);
break;


case ProfileConfigurationTokenTable.TOKEN_MODEL://1

handleModelEnd(e);
break;


default://1

LOG.warn("WARNING: unknown end tag:" + e.getName());
break;


} 
} 
catch (Exception ex) //1
{ 
throw new SAXException(ex);
} 
} 
public Collection<Profile> getProfiles()
    { 
return profiles;
} 
public void handleStartElement(XMLElement e)
    { 
try//1
{ 
switch (tokens.toToken(e.getName(), true)) //1
{ 
case ProfileConfigurationTokenTable.TOKEN_PROFILE://1

break;


case ProfileConfigurationTokenTable.TOKEN_PLUGIN://1

profile = null;
break;


case ProfileConfigurationTokenTable.TOKEN_USER_DEFINED://1

profile = null;
filename = null;
model = null;
break;


case ProfileConfigurationTokenTable.TOKEN_FILENAME://1

break;


case ProfileConfigurationTokenTable.TOKEN_MODEL://1

break;


default://1

LOG.warn("WARNING: unknown tag:" + e.getName());
break;


} 
} 
catch (Exception ex) //1
{ 
LOG.error("Exception in startelement", ex);
} 
} 
class ProfileConfigurationTokenTable extends XMLTokenTableBase
  { 
private static final String STRING_PROFILE = "profile";
private static final String STRING_PLUGIN = "plugin";
private static final String STRING_USER_DEFINED = "userDefined";
private static final String STRING_FILENAME = "filename";
private static final String STRING_MODEL = "model";
public static final int TOKEN_PROFILE = 1;
public static final int TOKEN_PLUGIN = 2;
public static final int TOKEN_USER_DEFINED = 3;
public static final int TOKEN_FILENAME = 4;
public static final int TOKEN_MODEL = 5;
private static final int TOKEN_LAST = 5;
public static final int TOKEN_UNDEFINED = 999;
protected void setupTokens()
        { 
addToken(STRING_PROFILE, Integer.valueOf(TOKEN_PROFILE));
addToken(STRING_PLUGIN, Integer.valueOf(TOKEN_PLUGIN));
addToken(STRING_USER_DEFINED, Integer.valueOf(TOKEN_USER_DEFINED));
addToken(STRING_FILENAME, Integer.valueOf(TOKEN_FILENAME));
addToken(STRING_MODEL, Integer.valueOf(TOKEN_MODEL));
} 
public ProfileConfigurationTokenTable()
        { 
super(TOKEN_LAST);
} 

 } 

 } 
public class ProfileConfigurationFilePersister extends MemberFilePersister
  { 
private static final Logger LOG =
        Logger.getLogger(ProfileConfigurationFilePersister.class);
private void addUserDefinedProfile(String fileName, StringBuffer xmi,
                                       ProfileManager profileManager) throws IOException
    { 
File profilesDirectory = getProfilesDirectory(profileManager);
File profileFile = new File(profilesDirectory, fileName);
OutputStreamWriter writer = new OutputStreamWriter(
            new FileOutputStream(profileFile),
            Argo.getEncoding());
writer.write(xmi.toString());
writer.close();
LOG.info("Wrote user defined profile \"" + profileFile
                 + "\", with size " + xmi.length() + ".");
if(isSomeProfileDirectoryConfigured(profileManager))//1
{ 
profileManager.refreshRegisteredProfiles();
} 
else
{ 
profileManager.addSearchPathDirectory(
                profilesDirectory.getAbsolutePath());
} 
} 
private static boolean isSomeProfileDirectoryConfigured(
        ProfileManager profileManager)
    { 
return profileManager.getSearchPathDirectories().size() > 0;
} 
public String getMainTag()
    { 
return "profile";
} 
private Collection<Profile> loadUnresolved(Collection<String> unresolved)
    { 
Collection<Profile> profiles = new ArrayList<Profile>();
ProfileManager profileManager = ProfileFacade.getManager();
for (String filename : unresolved) //1
{ 
} 
return profiles;
} 
public void save(ProjectMember member, OutputStream stream)
    throws SaveException
    { 
PrintWriter w;
try//1
{ 
w = new PrintWriter(new OutputStreamWriter(stream, "UTF-8"));
} 
catch (UnsupportedEncodingException e1) //1
{ 
throw new SaveException("UTF-8 encoding not supported on platform",
                                    e1);
} 
saveProjectMember(member, w);
w.flush();
} 
private static File getProfilesDirectory(ProfileManager profileManager)
    { 
if(isSomeProfileDirectoryConfigured(profileManager))//1
{ 
List<String> directories =
                profileManager.getSearchPathDirectories();
return new File(directories.get(0));
} 
else
{ 
File userSettingsFile = new File(
                Configuration.getFactory().getConfigurationHandler().
                getDefaultPath());
return userSettingsFile.getParentFile();
} 
} 
private void printModelXMI(PrintWriter w, Collection profileModels)
    throws UmlException
    { 
if(true)//1
{ 
return;
} 
StringWriter myWriter = new StringWriter();
for (Object model : profileModels) //1
{ 
XmiWriter xmiWriter = Model.getXmiWriter(model,
                                  (OutputStream) null, //myWriter,
                                  ApplicationVersion.getVersion() + "("
                                  + UmlFilePersister.PERSISTENCE_VERSION + ")");
xmiWriter.write();
} 
myWriter.flush();
w.println("" + myWriter.toString());
} 
@Override
    public void load(Project project, URL url) throws OpenException
    { 
try//1
{ 
load(project, url.openStream());
} 
catch (IOException e) //1
{ 
throw new OpenException(e);
} 
} 
public void load(Project project, InputStream inputStream)
    throws OpenException
    { 
try//1
{ 
ProfileConfigurationParser parser =
                new ProfileConfigurationParser();
parser.parse(new InputSource(inputStream));
Collection<Profile> profiles = parser.getProfiles();
Collection<String> unresolved = parser.getUnresolvedFilenames();
if(!unresolved.isEmpty())//1
{ 
profiles.addAll(loadUnresolved(unresolved));
} 
ProfileConfiguration pc = new ProfileConfiguration(project,
                    profiles);
project.setProfileConfiguration(pc);
} 
catch (Exception e) //1
{ 
if(e instanceof OpenException)//1
{ 
throw (OpenException) e;
} 
throw new OpenException(e);
} 
} 
private void saveProjectMember(ProjectMember member, PrintWriter w)
    throws SaveException
    { 
try//1
{ 
if(member instanceof ProfileConfiguration)//1
{ 
ProfileConfiguration pc = (ProfileConfiguration) member;
w.println("<?xml version = \"1.0\" encoding = \"UTF-8\" ?>");
w.println("");
w.println("<profile>");
for (Profile profile : pc.getProfiles()) //1
{ 
if(profile instanceof UserDefinedProfile)//1
{ 
UserDefinedProfile uprofile =
                            (UserDefinedProfile) profile;
w.println("\t\t<userDefined>");
w.println("\t\t\t<filename>"
                                  + uprofile.getModelFile().getName()
                                  + "</filename>");
w.println("\t\t\t<model>");
printModelXMI(w, uprofile.getProfilePackages());
w.println("\t\t\t</model>");
w.println("\t\t</userDefined>");
} 
else
{ 
w.println("\t\t<plugin>");
w.println("\t\t\t" + profile.getProfileIdentifier());
w.println("\t\t</plugin>");
} 
} 
w.println("</profile>");
} 
} 
catch (Exception e) //1
{ 
e.printStackTrace();
throw new SaveException(e);
} 
} 

 } 
