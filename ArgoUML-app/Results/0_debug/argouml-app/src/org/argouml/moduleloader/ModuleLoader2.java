
//#if 1164329597 
// Compilation Unit of /ModuleLoader2.java 
 

//#if -716525904 
package org.argouml.moduleloader;
//#endif 


//#if -677377977 
import java.io.File;
//#endif 


//#if 2089683631 
import java.io.FileFilter;
//#endif 


//#if -827298710 
import java.io.IOException;
//#endif 


//#if 1434601628 
import java.io.UnsupportedEncodingException;
//#endif 


//#if 805231682 
import java.lang.reflect.Constructor;
//#endif 


//#if 1837429230 
import java.lang.reflect.InvocationTargetException;
//#endif 


//#if -2087795933 
import java.lang.reflect.Modifier;
//#endif 


//#if 1142891373 
import java.net.URL;
//#endif 


//#if 751519646 
import java.net.URLClassLoader;
//#endif 


//#if 1196408608 
import java.util.ArrayList;
//#endif 


//#if -226440639 
import java.util.Collection;
//#endif 


//#if 1570276578 
import java.util.Collections;
//#endif 


//#if -57002384 
import java.util.Enumeration;
//#endif 


//#if -1091950039 
import java.util.HashMap;
//#endif 


//#if -1091767325 
import java.util.HashSet;
//#endif 


//#if 757760833 
import java.util.List;
//#endif 


//#if -2053744133 
import java.util.Map;
//#endif 


//#if -2079186799 
import java.util.StringTokenizer;
//#endif 


//#if -2044590763 
import java.util.jar.Attributes;
//#endif 


//#if 2030665685 
import java.util.jar.JarEntry;
//#endif 


//#if -765012237 
import java.util.jar.JarFile;
//#endif 


//#if -1623929923 
import java.util.jar.Manifest;
//#endif 


//#if -1287396069 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if 1642030391 
import org.argouml.application.api.Argo;
//#endif 


//#if 1394383434 
import org.argouml.i18n.Translator;
//#endif 


//#if -30740835 
import org.apache.log4j.Logger;
//#endif 


//#if -1796789377 
class ModuleStatus  { 

//#if 1437848170 
private boolean enabled;
//#endif 


//#if 539301296 
private boolean selected;
//#endif 


//#if -923552112 
public void setUnselect()
    { 

//#if 810926868 
selected = false;
//#endif 

} 

//#endif 


//#if 718837722 
public boolean isSelected()
    { 

//#if -642026182 
return selected;
//#endif 

} 

//#endif 


//#if -609562067 
public void setSelected(boolean value)
    { 

//#if 1896296405 
if(value)//1
{ 

//#if 695475947 
setSelected();
//#endif 

} 
else
{ 

//#if 1790071714 
setUnselect();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2021832392 
public void setEnabled()
    { 

//#if -1225562746 
enabled = true;
//#endif 

} 

//#endif 


//#if -277966524 
public boolean isEnabled()
    { 

//#if 1738226474 
return enabled;
//#endif 

} 

//#endif 


//#if -965282185 
public void setDisabled()
    { 

//#if 779320249 
enabled = false;
//#endif 

} 

//#endif 


//#if -1001839914 
public void setSelected()
    { 

//#if -1340159714 
selected = true;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1097122255 
public final class ModuleLoader2  { 

//#if 45254292 
private Map<ModuleInterface, ModuleStatus> moduleStatus;
//#endif 


//#if -1514644613 
private List<String> extensionLocations = new ArrayList<String>();
//#endif 


//#if 1899260034 
private static final ModuleLoader2 INSTANCE = new ModuleLoader2();
//#endif 


//#if 871846494 
private static final String FILE_PREFIX = "file:";
//#endif 


//#if 168873716 
private static final String JAR_PREFIX = "jar:";
//#endif 


//#if -991436059 
public static final String CLASS_SUFFIX = ".class";
//#endif 


//#if 555766024 
private static final Logger LOG = Logger.getLogger(ModuleLoader2.class);
//#endif 


//#if 193444632 
public static Collection<String> allModules()
    { 

//#if 1513497852 
Collection<String> coll = new HashSet<String>();
//#endif 


//#if -1965437787 
for (ModuleInterface mf : getInstance().availableModules()) //1
{ 

//#if 763485645 
coll.add(mf.getName());
//#endif 

} 

//#endif 


//#if 1921073622 
return coll;
//#endif 

} 

//#endif 


//#if -1967308266 
public static boolean isEnabled(String name)
    { 

//#if 177644841 
return getInstance().isEnabledInternal(name);
//#endif 

} 

//#endif 


//#if 265386523 
public static ModuleLoader2 getInstance()
    { 

//#if -1211856890 
return INSTANCE;
//#endif 

} 

//#endif 


//#if 262473372 
private ModuleLoader2()
    { 

//#if -1978753909 
moduleStatus = new HashMap<ModuleInterface, ModuleStatus>();
//#endif 


//#if 1765443847 
computeExtensionLocations();
//#endif 

} 

//#endif 


//#if 483337825 
List<AbstractArgoJPanel> getDetailsTabs()
    { 

//#if 1949696730 
List<AbstractArgoJPanel> result = new ArrayList<AbstractArgoJPanel>();
//#endif 


//#if -16629918 
for (ModuleInterface module : getInstance().availableModules()) //1
{ 

//#if 285239983 
ModuleStatus status = moduleStatus.get(module);
//#endif 


//#if -920890064 
if(status == null)//1
{ 

//#if 1269340953 
continue;
//#endif 

} 

//#endif 


//#if -401725741 
if(status.isEnabled())//1
{ 

//#if 1823859886 
if(module instanceof DetailsTabProvider)//1
{ 

//#if -1435221681 
result.addAll(
                        ((DetailsTabProvider) module).getDetailsTabs());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1574271445 
return result;
//#endif 

} 

//#endif 


//#if -1352622101 
private void computeExtensionLocations()
    { 

//#if -1688312974 
String extForm = getClass().getResource(Argo.ARGOINI).toExternalForm();
//#endif 


//#if 1977527390 
String argoRoot =
            extForm.substring(0,
                              extForm.length() - Argo.ARGOINI.length());
//#endif 


//#if -1320538987 
if(argoRoot.startsWith(JAR_PREFIX))//1
{ 

//#if -717059392 
argoRoot = argoRoot.substring(JAR_PREFIX.length());
//#endif 


//#if -1871706841 
if(argoRoot.endsWith("!"))//1
{ 

//#if 273009061 
argoRoot = argoRoot.substring(0, argoRoot.length() - 1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1761571453 
String argoHome = null;
//#endif 


//#if 300716910 
if(argoRoot != null)//1
{ 

//#if 830823633 
LOG.info("argoRoot is " + argoRoot);
//#endif 


//#if 1462463873 
if(argoRoot.startsWith(FILE_PREFIX))//1
{ 

//#if -2035119285 
argoHome =
                    new File(argoRoot.substring(FILE_PREFIX.length()))
                .getAbsoluteFile().getParent();
//#endif 

} 
else
{ 

//#if 818828374 
argoHome = new File(argoRoot).getAbsoluteFile().getParent();
//#endif 

} 

//#endif 


//#if -1743060806 
try //1
{ 

//#if 1732534768 
argoHome = java.net.URLDecoder.decode(argoHome,
                                                      Argo.getEncoding());
//#endif 

} 

//#if 1794598611 
catch (UnsupportedEncodingException e) //1
{ 

//#if 207055385 
LOG.warn("Encoding "
                         + Argo.getEncoding()
                         + " is unknown.");
//#endif 

} 

//#endif 


//#endif 


//#if 1807874763 
LOG.info("argoHome is " + argoHome);
//#endif 

} 

//#endif 


//#if 1987637035 
if(argoHome != null)//1
{ 

//#if -579067985 
String extdir;
//#endif 


//#if 1498931283 
if(argoHome.startsWith(FILE_PREFIX))//1
{ 

//#if 621237931 
extdir = argoHome.substring(FILE_PREFIX.length())
                         + File.separator + "ext";
//#endif 

} 
else
{ 

//#if 1813726893 
extdir = argoHome + File.separator + "ext";
//#endif 

} 

//#endif 


//#if -1900760795 
extensionLocations.add(extdir);
//#endif 

} 

//#endif 


//#if 1165454086 
String extdir = System.getProperty("argo.ext.dir");
//#endif 


//#if 1480041887 
if(extdir != null)//1
{ 

//#if 778557780 
extensionLocations.add(extdir);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 557014007 
private Map.Entry<ModuleInterface, ModuleStatus> findModule(String name)
    { 

//#if -1471607605 
for (Map.Entry<ModuleInterface, ModuleStatus> entry : moduleStatus
                .entrySet()) //1
{ 

//#if -705732062 
ModuleInterface module = entry.getKey();
//#endif 


//#if 1535354353 
if(name.equalsIgnoreCase(module.getName()))//1
{ 

//#if 1822783969 
return entry;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 645194324 
return null;
//#endif 

} 

//#endif 


//#if 1495151908 
private void huntModulesFromNamedDirectory(String dirname)
    { 

//#if 572935229 
File extensionDir = new File(dirname);
//#endif 


//#if -359017435 
if(extensionDir.isDirectory())//1
{ 

//#if -1366186113 
File[] files = extensionDir.listFiles(new JarFileFilter());
//#endif 


//#if -125219926 
for (File file : files) //1
{ 

//#if -773946468 
JarFile jarfile = null;
//#endif 


//#if 619342203 
try //1
{ 

//#if 1377332884 
jarfile = new JarFile(file);
//#endif 


//#if -1065466980 
if(jarfile != null)//1
{ 

//#if -1925047469 
ClassLoader classloader =
                            new URLClassLoader(new URL[] {
                                                   file.toURI().toURL(),
                                               });
//#endif 


//#if 1204383518 
try //1
{ 

//#if -368122216 
processJarFile(classloader, file);
//#endif 

} 

//#if 435298213 
catch (ClassNotFoundException e) //1
{ 

//#if -278648686 
LOG.error("The class is not found.", e);
//#endif 


//#if -997232442 
return;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#if 247794221 
catch (IOException ioe) //1
{ 

//#if 1730889878 
LOG.error("Cannot open Jar file " + file, ioe);
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


//#if 2060044714 
private void addModule(ModuleInterface mf)
    { 

//#if 1532644080 
for (ModuleInterface foundMf : moduleStatus.keySet()) //1
{ 

//#if 453933946 
if(foundMf.getName().equals(mf.getName()))//1
{ 

//#if 1503090716 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1047547756 
ModuleStatus ms = new ModuleStatus();
//#endif 


//#if -728351516 
ms.setSelected();
//#endif 


//#if -652476253 
moduleStatus.put(mf, ms);
//#endif 

} 

//#endif 


//#if 1928510478 
private void processJarFile(ClassLoader classloader, File file)
    throws ClassNotFoundException
    { 

//#if -1146076478 
LOG.info("Opening jar file " + file);
//#endif 


//#if -1343278879 
JarFile jarfile;
//#endif 


//#if 2063357744 
try //1
{ 

//#if -1452982383 
jarfile = new JarFile(file);
//#endif 

} 

//#if 1494707790 
catch (IOException e) //1
{ 

//#if -1370244002 
LOG.error("Unable to open " + file, e);
//#endif 


//#if -2103035223 
return;
//#endif 

} 

//#endif 


//#endif 


//#if 1055129027 
Manifest manifest;
//#endif 


//#if -81312383 
try //2
{ 

//#if -1306411603 
manifest = jarfile.getManifest();
//#endif 


//#if 2033675836 
if(manifest == null)//1
{ 

//#if -167048968 
LOG.warn(file + " does not have a manifest");
//#endif 

} 

//#endif 

} 

//#if -700795439 
catch (IOException e) //1
{ 

//#if 2117498318 
LOG.error("Unable to read manifest of " + file, e);
//#endif 


//#if -144704889 
return;
//#endif 

} 

//#endif 


//#endif 


//#if -804329072 
boolean loadedClass = false;
//#endif 


//#if 638388431 
if(manifest == null)//1
{ 

//#if 1713048485 
Enumeration<JarEntry> jarEntries = jarfile.entries();
//#endif 


//#if -348842853 
while (jarEntries.hasMoreElements()) //1
{ 

//#if -390459175 
JarEntry entry = jarEntries.nextElement();
//#endif 


//#if 1454889428 
loadedClass =
                    loadedClass
                    | processEntry(classloader, entry.getName());
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1380962879 
Map<String, Attributes> entries = manifest.getEntries();
//#endif 


//#if 949302204 
for (String key : entries.keySet()) //1
{ 

//#if -585638615 
loadedClass =
                    loadedClass
                    | processEntry(classloader, key);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1331268711 
Translator.addClassLoader(classloader);
//#endif 


//#if -474675533 
if(!loadedClass && !file.getName().contains("argouml-i18n-"))//1
{ 

//#if 428802383 
LOG.error("Failed to find any loadable ArgoUML modules in jar "
                      + file);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -627410722 
public static void doLoad(boolean failingAllowed)
    { 

//#if -1269916299 
getInstance().doInternal(failingAllowed);
//#endif 

} 

//#endif 


//#if -1046084528 
public static boolean isSelected(String name)
    { 

//#if 1095183697 
return getInstance().isSelectedInternal(name);
//#endif 

} 

//#endif 


//#if 138533521 
public static void setSelected(String name, boolean value)
    { 

//#if -360206844 
getInstance().setSelectedInternal(name, value);
//#endif 

} 

//#endif 


//#if 88423505 
private String getDescriptionInternal(String name)
    { 

//#if 1351334288 
Map.Entry<ModuleInterface, ModuleStatus> entry = findModule(name);
//#endif 


//#if 579169366 
if(entry == null)//1
{ 

//#if -1322511799 
throw new IllegalArgumentException("Module does not exist.");
//#endif 

} 

//#endif 


//#if -2070280015 
ModuleInterface module = entry.getKey();
//#endif 


//#if 1100091430 
StringBuffer sb = new StringBuffer();
//#endif 


//#if -1027504286 
String desc = module.getInfo(ModuleInterface.DESCRIPTION);
//#endif 


//#if -1160433849 
if(desc != null)//1
{ 

//#if 88313859 
sb.append(desc);
//#endif 


//#if 363731406 
sb.append("\n\n");
//#endif 

} 

//#endif 


//#if -1454811421 
String author = module.getInfo(ModuleInterface.AUTHOR);
//#endif 


//#if 1101431553 
if(author != null)//1
{ 

//#if 2145002862 
sb.append("Author: ").append(author);
//#endif 


//#if 287556637 
sb.append("\n");
//#endif 

} 

//#endif 


//#if 1841637913 
String version = module.getInfo(ModuleInterface.VERSION);
//#endif 


//#if -2098569064 
if(version != null)//1
{ 

//#if 2073201968 
sb.append("Version: ").append(version);
//#endif 


//#if 1660563953 
sb.append("\n");
//#endif 

} 

//#endif 


//#if -315850049 
return sb.toString();
//#endif 

} 

//#endif 


//#if -921686594 
private void huntForModules()
    { 

//#if 165109227 
huntForModulesFromExtensionDir();
//#endif 


//#if -1170667095 
String listOfClasses = System.getProperty("argouml.modules");
//#endif 


//#if -701805641 
if(listOfClasses != null)//1
{ 

//#if 1791331097 
StringTokenizer si = new StringTokenizer(listOfClasses, ";");
//#endif 


//#if 1043686667 
while (si.hasMoreTokens()) //1
{ 

//#if 2026232099 
String className = si.nextToken();
//#endif 


//#if 1781499892 
try //1
{ 

//#if 935530413 
addClass(className);
//#endif 

} 

//#if 1671120380 
catch (ClassNotFoundException e) //1
{ 

//#if -493901678 
LOG.error("Could not load module from class " + className);
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


//#if 2055395832 
private boolean processEntry(ClassLoader classloader, String cname)
    throws ClassNotFoundException
    { 

//#if -79003405 
if(cname.endsWith(CLASS_SUFFIX))//1
{ 

//#if -563914355 
int classNamelen = cname.length() - CLASS_SUFFIX.length();
//#endif 


//#if 1600247197 
String className = cname.substring(0, classNamelen);
//#endif 


//#if 8084049 
className = className.replace('/', '.');
//#endif 


//#if 1140806926 
return addClass(classloader, className);
//#endif 

} 

//#endif 


//#if -204284849 
return false;
//#endif 

} 

//#endif 


//#if 1130977910 
private void huntForModulesFromExtensionDir()
    { 

//#if -490977563 
for (String location : extensionLocations) //1
{ 

//#if 1607475965 
huntModulesFromNamedDirectory(location);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1936265898 
private Collection<ModuleInterface> availableModules()
    { 

//#if -1169122479 
return Collections.unmodifiableCollection(moduleStatus.keySet());
//#endif 

} 

//#endif 


//#if -761560438 
private void setSelectedInternal(String name, boolean value)
    { 

//#if 1243361988 
Map.Entry<ModuleInterface, ModuleStatus> entry = findModule(name);
//#endif 


//#if -2088991706 
if(entry != null)//1
{ 

//#if -1977052858 
ModuleStatus status = entry.getValue();
//#endif 


//#if -51653652 
status.setSelected(value);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -310542157 
public List<String> getExtensionLocations()
    { 

//#if -1450592884 
return Collections.unmodifiableList(extensionLocations);
//#endif 

} 

//#endif 


//#if 705428807 
public static void addClass(String classname)
    throws ClassNotFoundException
    { 

//#if 264276077 
getInstance().addClass(ModuleLoader2.class.getClassLoader(),
                               classname);
//#endif 

} 

//#endif 


//#if -544834249 
private boolean isSelectedInternal(String name)
    { 

//#if 1173902422 
Map.Entry<ModuleInterface, ModuleStatus> entry = findModule(name);
//#endif 


//#if 2091366584 
if(entry != null)//1
{ 

//#if 1641073475 
ModuleStatus status = entry.getValue();
//#endif 


//#if -1744762593 
if(status == null)//1
{ 

//#if -654282069 
return false;
//#endif 

} 

//#endif 


//#if -344562602 
return status.isSelected();
//#endif 

} 

//#endif 


//#if -1852404178 
return false;
//#endif 

} 

//#endif 


//#if -1287147842 
public static String getDescription(String name)
    { 

//#if -1547980513 
return getInstance().getDescriptionInternal(name);
//#endif 

} 

//#endif 


//#if 121766569 
private boolean isEnabledInternal(String name)
    { 

//#if 674334940 
Map.Entry<ModuleInterface, ModuleStatus> entry = findModule(name);
//#endif 


//#if 1774100030 
if(entry != null)//1
{ 

//#if -917734077 
ModuleStatus status = entry.getValue();
//#endif 


//#if -1826416865 
if(status == null)//1
{ 

//#if 1006040246 
return false;
//#endif 

} 

//#endif 


//#if 1725544994 
return status.isEnabled();
//#endif 

} 

//#endif 


//#if 1024561204 
return false;
//#endif 

} 

//#endif 


//#if -903726543 
private void doInternal(boolean failingAllowed)
    { 

//#if -661883821 
huntForModules();
//#endif 


//#if -548487348 
boolean someModuleSucceeded;
//#endif 


//#if -923411445 
do{ 

//#if -2112078965 
someModuleSucceeded = false;
//#endif 


//#if -431235904 
for (ModuleInterface module : getInstance().availableModules()) //1
{ 

//#if -299916458 
ModuleStatus status = moduleStatus.get(module);
//#endif 


//#if -2099345751 
if(status == null)//1
{ 

//#if -1923731312 
continue;
//#endif 

} 

//#endif 


//#if 807319221 
if(!status.isEnabled() && status.isSelected())//1
{ 

//#if -1355774008 
try //1
{ 

//#if 953618350 
if(module.enable())//1
{ 

//#if 1940963268 
someModuleSucceeded = true;
//#endif 


//#if -1232750292 
status.setEnabled();
//#endif 

} 

//#endif 

} 

//#if -1773386771 
catch (Throwable e) //1
{ 

//#if -536192787 
LOG.error("Exception or error while trying to "
                                  + "enable module " + module.getName(), e);
//#endif 

} 

//#endif 


//#endif 

} 
else

//#if -1552284869 
if(status.isEnabled() && !status.isSelected())//1
{ 

//#if -1238501406 
try //1
{ 

//#if -177381111 
if(module.disable())//1
{ 

//#if -1104207372 
someModuleSucceeded = true;
//#endif 


//#if -1479535813 
status.setDisabled();
//#endif 

} 

//#endif 

} 

//#if -1311207663 
catch (Throwable e) //1
{ 

//#if -1379533207 
LOG.error("Exception or error while trying to "
                                  + "disable module " + module.getName(), e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 
 while (someModuleSucceeded);//1

//#endif 


//#if 1928959768 
if(!failingAllowed)//1
{ 

//#if -1369058341 
for (ModuleInterface module : getInstance().availableModules()) //1
{ 

//#if 1298434464 
ModuleStatus status = moduleStatus.get(module);
//#endif 


//#if 674836767 
if(status == null)//1
{ 

//#if 196128459 
continue;
//#endif 

} 

//#endif 


//#if -1976807376 
if(status.isEnabled() && status.isSelected())//1
{ 

//#if -1084739407 
continue;
//#endif 

} 

//#endif 


//#if 1734374408 
if(!status.isEnabled() && !status.isSelected())//1
{ 

//#if 815536262 
continue;
//#endif 

} 

//#endif 


//#if 1343840364 
if(status.isSelected())//1
{ 

//#if -782216874 
LOG.warn("ModuleLoader was not able to enable module "
                             + module.getName());
//#endif 

} 
else
{ 

//#if 731842247 
LOG.warn("ModuleLoader was not able to disable module "
                             + module.getName());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 782724983 
private boolean addClass(ClassLoader classLoader, String classname)
    throws ClassNotFoundException
    { 

//#if 180714264 
LOG.info("Loading module " + classname);
//#endif 


//#if 1101463941 
Class moduleClass;
//#endif 


//#if -973225832 
try //1
{ 

//#if 2132060678 
moduleClass = classLoader.loadClass(classname);
//#endif 

} 

//#if 470959811 
catch (UnsupportedClassVersionError e) //1
{ 

//#if -26012749 
LOG.error("Unsupported Java class version for " + classname);
//#endif 


//#if 1610490041 
return false;
//#endif 

} 

//#endif 


//#if -11169342 
catch (NoClassDefFoundError e) //1
{ 

//#if 21437128 
LOG.error("Unable to find required class while loading "
                      + classname + " - may indicate an obsolete"
                      + " extension module or an unresolved dependency", e);
//#endif 


//#if 1261622116 
return false;
//#endif 

} 

//#endif 


//#if 1156010340 
catch (Throwable e) //1
{ 

//#if 2086832830 
if(e instanceof ClassNotFoundException)//1
{ 

//#if 1294521650 
throw (ClassNotFoundException) e;
//#endif 

} 

//#endif 


//#if 450231059 
LOG.error("Unexpected error while loading " + classname, e);
//#endif 


//#if 1634100080 
return false;
//#endif 

} 

//#endif 


//#endif 


//#if -872717791 
if(!ModuleInterface.class.isAssignableFrom(moduleClass))//1
{ 

//#if 1890979347 
LOG.debug("The class " + classname + " is not a module.");
//#endif 


//#if 68866794 
return false;
//#endif 

} 

//#endif 


//#if -657520086 
Constructor defaultConstructor;
//#endif 


//#if 1953530649 
try //2
{ 

//#if 2077834799 
defaultConstructor =
                moduleClass.getDeclaredConstructor(new Class[] {});
//#endif 

} 

//#if -1904312966 
catch (SecurityException e) //1
{ 

//#if 1480707432 
LOG.error("The default constructor for class " + classname
                      + " is not accessable.",
                      e);
//#endif 


//#if -272085094 
return false;
//#endif 

} 

//#endif 


//#if 1737314083 
catch (NoSuchMethodException e) //1
{ 

//#if 699205889 
LOG.error("The default constructor for class " + classname
                      + " is not found.", e);
//#endif 


//#if 1562832111 
return false;
//#endif 

} 

//#endif 


//#if 163132989 
catch (NoClassDefFoundError e) //1
{ 

//#if 1274621632 
LOG.error("Unable to find required class while loading "
                      + classname + " - may indicate an obsolete"
                      + " extension module or an unresolved dependency", e);
//#endif 


//#if -502410916 
return false;
//#endif 

} 

//#endif 


//#if 1308470217 
catch (Throwable e) //1
{ 

//#if -940806018 
LOG.error("Unexpected error while loading " + classname, e);
//#endif 


//#if 2033135013 
return false;
//#endif 

} 

//#endif 


//#endif 


//#if -2109321045 
if(!Modifier.isPublic(defaultConstructor.getModifiers()))//1
{ 

//#if 1551087659 
LOG.error("The default constructor for class " + classname
                      + " is not public.  Not loaded.");
//#endif 


//#if 1033908385 
return false;
//#endif 

} 

//#endif 


//#if 1245588953 
Object moduleInstance;
//#endif 


//#if 1953560441 
try //3
{ 

//#if 1429724736 
moduleInstance = defaultConstructor.newInstance(new Object[] {});
//#endif 

} 

//#if 2055124220 
catch (IllegalArgumentException e) //1
{ 

//#if 1563066984 
LOG.error("The constructor for class " + classname
                      + " is called with incorrect argument.", e);
//#endif 


//#if 577797267 
return false;
//#endif 

} 

//#endif 


//#if 164485942 
catch (InstantiationException e) //1
{ 

//#if -1301562168 
LOG.error("The constructor for class " + classname
                      + " threw an exception.", e);
//#endif 


//#if 1159935006 
return false;
//#endif 

} 

//#endif 


//#if -1987215453 
catch (IllegalAccessException e) //1
{ 

//#if -22020010 
LOG.error("The constructor for class " + classname
                      + " is not accessible.", e);
//#endif 


//#if -835518993 
return false;
//#endif 

} 

//#endif 


//#if 325186868 
catch (InvocationTargetException e) //1
{ 

//#if 1931599711 
LOG.error("The constructor for class " + classname
                      + " cannot be called.", e);
//#endif 


//#if 1307596228 
return false;
//#endif 

} 

//#endif 


//#if -1430955996 
catch (NoClassDefFoundError e) //1
{ 

//#if 144147623 
LOG.error("Unable to find required class while instantiating "
                      + classname + " - may indicate an obsolete"
                      + " extension module or an unresolved dependency", e);
//#endif 


//#if -1298641960 
return false;
//#endif 

} 

//#endif 


//#if -513559486 
catch (Throwable e) //1
{ 

//#if -569112054 
LOG.error("Unexpected error while instantiating " + classname, e);
//#endif 


//#if -510819858 
return false;
//#endif 

} 

//#endif 


//#endif 


//#if -538979903 
if(!(moduleInstance instanceof ModuleInterface))//1
{ 

//#if -884617337 
LOG.error("The class " + classname + " is not a module.");
//#endif 


//#if -383249869 
return false;
//#endif 

} 

//#endif 


//#if 1315425359 
ModuleInterface mf = (ModuleInterface) moduleInstance;
//#endif 


//#if -314387896 
addModule(mf);
//#endif 


//#if 556007061 
LOG.info("Succesfully loaded module " + classname);
//#endif 


//#if 1302605979 
return true;
//#endif 

} 

//#endif 


//#if -1223131632 
static class JarFileFilter implements 
//#if 900308201 
FileFilter
//#endif 

  { 

//#if -27234425 
public boolean accept(File pathname)
        { 

//#if -1633945783 
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

