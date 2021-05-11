
//#if 332579872 
// Compilation Unit of /ProfileLoader.java 
 

//#if -2003946383 
package org.argouml.profile.init;
//#endif 


//#if 166722352 
import java.io.File;
//#endif 


//#if 1093429976 
import java.io.FileFilter;
//#endif 


//#if -1646390943 
import java.io.IOException;
//#endif 


//#if 1986991702 
import java.net.URL;
//#endif 


//#if -1306552043 
import java.net.URLClassLoader;
//#endif 


//#if 677210778 
import java.util.HashSet;
//#endif 


//#if 189358058 
import java.util.List;
//#endif 


//#if -1656437710 
import java.util.Map;
//#endif 


//#if -1656254996 
import java.util.Set;
//#endif 


//#if 93843528 
import java.util.StringTokenizer;
//#endif 


//#if -1420303682 
import java.util.jar.Attributes;
//#endif 


//#if -1933632982 
import java.util.jar.JarFile;
//#endif 


//#if 803532646 
import java.util.jar.Manifest;
//#endif 


//#if -1972545471 
import org.argouml.i18n.Translator;
//#endif 


//#if -1719613497 
import org.argouml.moduleloader.ModuleLoader2;
//#endif 


//#if -1773434272 
import org.argouml.profile.ProfileException;
//#endif 


//#if -1735329075 
import org.argouml.profile.ProfileFacade;
//#endif 


//#if 1737327835 
import org.argouml.profile.UserDefinedProfile;
//#endif 


//#if -2088812524 
import org.apache.log4j.Logger;
//#endif 


//#if 699592899 
import org.argouml.cognitive.Critic;
//#endif 


//#if 1364226691 
public final class ProfileLoader  { 

//#if 782172417 
private static final String JAR_PREFIX = "jar:";
//#endif 


//#if 1841378603 
private static final String FILE_PREFIX = "file:";
//#endif 


//#if 1984873406 
private static final Logger LOG = Logger.getLogger(ProfileLoader.class);
//#endif 


//#if -1576169957 
private Set<Critic> loadJavaCriticsForProfile(Attributes attr,
            ClassLoader classloader)
    { 

//#if 659570648 
Set<Critic> ret = new HashSet<Critic>();
//#endif 


//#if -1766556009 
String value = attr.getValue("Java-Critics");
//#endif 


//#if -229260611 
if(value != null)//1
{ 

//#if -509147052 
StringTokenizer st = new StringTokenizer(value, ",");
//#endif 


//#if 991988554 
while (st.hasMoreElements()) //1
{ 

//#if 584977068 
String entry = st.nextToken().trim();
//#endif 


//#if 451935906 
try //1
{ 

//#if 1942714988 
Class cl = classloader.loadClass(entry);
//#endif 


//#if 74647243 
Critic critic = (Critic) cl.newInstance();
//#endif 


//#if 1352758877 
ret.add(critic);
//#endif 

} 

//#if -409315260 
catch (ClassNotFoundException e) //1
{ 

//#if -531265202 
LOG.error("Error loading class: " + entry, e);
//#endif 

} 

//#endif 


//#if -1831021302 
catch (InstantiationException e) //1
{ 

//#if -60811671 
LOG.error("Error instantianting class: " + entry, e);
//#endif 

} 

//#endif 


//#if 312244599 
catch (IllegalAccessException e) //1
{ 

//#if 2098644541 
LOG.error("Exception", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -1086542410 
return ret;
//#endif 

} 

//#endif 


//#if 986188110 
private void huntForProfilesInDir(String dir)
    { 

//#if 1053534359 
LOG.info("Looking for Profiles in " + dir);
//#endif 


//#if 1962413368 
File extensionDir = new File(dir);
//#endif 


//#if 650391967 
if(extensionDir.isDirectory())//1
{ 

//#if 2080649953 
File[] files = extensionDir.listFiles(new JarFileFilter());
//#endif 


//#if 896517128 
for (File file : files) //1
{ 

//#if -1117182705 
JarFile jarfile = null;
//#endif 


//#if -1409794002 
try //1
{ 

//#if 312407620 
jarfile = new JarFile(file);
//#endif 


//#if -74600980 
if(jarfile != null)//1
{ 

//#if -1693454707 
LOG.info("Looking for Profiles in the Jar "
                                 + jarfile.getName());
//#endif 


//#if -275128015 
ClassLoader classloader = new URLClassLoader(
                            new URL[] {file.toURI().toURL()});
//#endif 


//#if -1696460213 
loadProfilesFromJarFile(jarfile.getManifest(), file,
                                                classloader);
//#endif 

} 

//#endif 

} 

//#if 237327972 
catch (IOException ioe) //1
{ 

//#if -1684409828 
LOG.debug("Cannot open Jar file " + file, ioe);
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


//#if -9695911 
private void loadProfilesFromJarFile(Manifest manifest, File file,
                                         ClassLoader classloader)
    { 

//#if -1154162041 
Map<String, Attributes> entries = manifest.getEntries();
//#endif 


//#if -2037912995 
boolean classLoaderAlreadyAdded = false;
//#endif 


//#if -1059313852 
for (String entryName : entries.keySet()) //1
{ 

//#if -1709565740 
Attributes attr = entries.get(entryName);
//#endif 


//#if 1598200069 
if(new Boolean(attr.getValue("Profile") + "").booleanValue())//1
{ 

//#if -1519551189 
try //1
{ 

//#if -2038345719 
if(!classLoaderAlreadyAdded)//1
{ 

//#if -1178726958 
Translator.addClassLoader(classloader);
//#endif 


//#if 622351010 
classLoaderAlreadyAdded = true;
//#endif 

} 

//#endif 


//#if -965217243 
Set<Critic> critics = loadJavaCriticsForProfile(attr,
                                          classloader);
//#endif 


//#if -1700709119 
String modelPath = attr.getValue("Model");
//#endif 


//#if -160262576 
URL modelURL = null;
//#endif 


//#if -1898667414 
if(modelPath != null)//1
{ 

//#if -830969885 
modelURL = new URL(JAR_PREFIX + FILE_PREFIX
                                           + file.getCanonicalPath() + "!" + modelPath);
//#endif 

} 

//#endif 


//#if 1455119351 
UserDefinedProfile udp = new UserDefinedProfile(entryName,
                            modelURL,





                            loadManifestDependenciesForProfile(attr));
//#endif 


//#if 1542082116 
UserDefinedProfile udp = new UserDefinedProfile(entryName,
                            modelURL,



                            critics,

                            loadManifestDependenciesForProfile(attr));
//#endif 


//#if -1780156190 
ProfileFacade.getManager().registerProfile(udp);
//#endif 


//#if -531570875 
LOG.debug("Registered Profile: " + udp.getDisplayName()
                              + "...");
//#endif 

} 

//#if -1355006592 
catch (ProfileException e) //1
{ 

//#if 1663122473 
LOG.error("Exception", e);
//#endif 

} 

//#endif 


//#if 1833282699 
catch (IOException e) //1
{ 

//#if 1029419495 
LOG.error("Exception", e);
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


//#if -1273593401 
public void doLoad()
    { 

//#if -1951592430 
List<String> extDirs =
            ModuleLoader2.getInstance().getExtensionLocations();
//#endif 


//#if 1470810428 
for (String extDir : extDirs) //1
{ 

//#if 1567456140 
huntForProfilesInDir(extDir);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1409005087 
private Set<String> loadManifestDependenciesForProfile(Attributes attr)
    { 

//#if -147515925 
Set<String> ret = new HashSet<String>();
//#endif 


//#if 347436447 
String value = attr.getValue("Depends-on");
//#endif 


//#if -33702250 
if(value != null)//1
{ 

//#if 423686799 
StringTokenizer st = new StringTokenizer(value, ",");
//#endif 


//#if -1142088123 
while (st.hasMoreElements()) //1
{ 

//#if -1869925533 
String entry = st.nextToken().trim();
//#endif 


//#if 1145694221 
ret.add(entry);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 50762383 
return ret;
//#endif 

} 

//#endif 


//#if -451671715 
static class JarFileFilter implements 
//#if 353016834 
FileFilter
//#endif 

  { 

//#if -59276210 
public boolean accept(File pathname)
        { 

//#if 879081863 
return (pathname.canRead()
                    && pathname.isFile()
                    && pathname.getPath().toLowerCase().endsWith(".jar"));
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

