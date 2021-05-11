package org.argouml.moduleloader;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import org.argouml.application.api.AbstractArgoJPanel;
import org.argouml.application.api.Argo;
import org.argouml.i18n.Translator;
import org.apache.log4j.Logger;
class ModuleStatus  { 
private boolean enabled;
private boolean selected;
public void setUnselect()
    { 
selected = false;
} 
public boolean isSelected()
    { 
return selected;
} 
public void setSelected(boolean value)
    { 
if(value)//1
{ 
setSelected();
} 
else
{ 
setUnselect();
} 
} 
public void setEnabled()
    { 
enabled = true;
} 
public boolean isEnabled()
    { 
return enabled;
} 
public void setDisabled()
    { 
enabled = false;
} 
public void setSelected()
    { 
selected = true;
} 

 } 
public final class ModuleLoader2  { 
private Map<ModuleInterface, ModuleStatus> moduleStatus;
private List<String> extensionLocations = new ArrayList<String>();
private static final ModuleLoader2 INSTANCE = new ModuleLoader2();
private static final String FILE_PREFIX = "file:";
private static final String JAR_PREFIX = "jar:";
public static final String CLASS_SUFFIX = ".class";
private static final Logger LOG = Logger.getLogger(ModuleLoader2.class);
public static Collection<String> allModules()
    { 
Collection<String> coll = new HashSet<String>();
for (ModuleInterface mf : getInstance().availableModules()) //1
{ 
coll.add(mf.getName());
} 
return coll;
} 
public static boolean isEnabled(String name)
    { 
return getInstance().isEnabledInternal(name);
} 
public static ModuleLoader2 getInstance()
    { 
return INSTANCE;
} 
private ModuleLoader2()
    { 
moduleStatus = new HashMap<ModuleInterface, ModuleStatus>();
computeExtensionLocations();
} 
List<AbstractArgoJPanel> getDetailsTabs()
    { 
List<AbstractArgoJPanel> result = new ArrayList<AbstractArgoJPanel>();
for (ModuleInterface module : getInstance().availableModules()) //1
{ 
ModuleStatus status = moduleStatus.get(module);
if(status == null)//1
{ 
continue;
} 
if(status.isEnabled())//1
{ 
if(module instanceof DetailsTabProvider)//1
{ 
result.addAll(
                        ((DetailsTabProvider) module).getDetailsTabs());
} 
} 
} 
return result;
} 
private void computeExtensionLocations()
    { 
String extForm = getClass().getResource(Argo.ARGOINI).toExternalForm();
String argoRoot =
            extForm.substring(0,
                              extForm.length() - Argo.ARGOINI.length());
if(argoRoot.startsWith(JAR_PREFIX))//1
{ 
argoRoot = argoRoot.substring(JAR_PREFIX.length());
if(argoRoot.endsWith("!"))//1
{ 
argoRoot = argoRoot.substring(0, argoRoot.length() - 1);
} 
} 
String argoHome = null;
if(argoRoot != null)//1
{ 
LOG.info("argoRoot is " + argoRoot);
if(argoRoot.startsWith(FILE_PREFIX))//1
{ 
argoHome =
                    new File(argoRoot.substring(FILE_PREFIX.length()))
                .getAbsoluteFile().getParent();
} 
else
{ 
argoHome = new File(argoRoot).getAbsoluteFile().getParent();
} 
try//1
{ 
argoHome = java.net.URLDecoder.decode(argoHome,
                                                      Argo.getEncoding());
} 
catch (UnsupportedEncodingException e) //1
{ 
LOG.warn("Encoding "
                         + Argo.getEncoding()
                         + " is unknown.");
} 
LOG.info("argoHome is " + argoHome);
} 
if(argoHome != null)//1
{ 
String extdir;
if(argoHome.startsWith(FILE_PREFIX))//1
{ 
extdir = argoHome.substring(FILE_PREFIX.length())
                         + File.separator + "ext";
} 
else
{ 
extdir = argoHome + File.separator + "ext";
} 
extensionLocations.add(extdir);
} 
String extdir = System.getProperty("argo.ext.dir");
if(extdir != null)//1
{ 
extensionLocations.add(extdir);
} 
} 
private Map.Entry<ModuleInterface, ModuleStatus> findModule(String name)
    { 
for (Map.Entry<ModuleInterface, ModuleStatus> entry : moduleStatus
                .entrySet()) //1
{ 
ModuleInterface module = entry.getKey();
if(name.equalsIgnoreCase(module.getName()))//1
{ 
return entry;
} 
} 
return null;
} 
private void huntModulesFromNamedDirectory(String dirname)
    { 
File extensionDir = new File(dirname);
if(extensionDir.isDirectory())//1
{ 
File[] files = extensionDir.listFiles(new JarFileFilter());
for (File file : files) //1
{ 
JarFile jarfile = null;
try//1
{ 
jarfile = new JarFile(file);
if(jarfile != null)//1
{ 
ClassLoader classloader =
                            new URLClassLoader(new URL[] {
                                                   file.toURI().toURL(),
                                               });
try//1
{ 
processJarFile(classloader, file);
} 
catch (ClassNotFoundException e) //1
{ 
LOG.error("The class is not found.", e);
return;
} 
} 
} 
catch (IOException ioe) //1
{ 
LOG.error("Cannot open Jar file " + file, ioe);
} 
} 
} 
} 
private void addModule(ModuleInterface mf)
    { 
for (ModuleInterface foundMf : moduleStatus.keySet()) //1
{ 
if(foundMf.getName().equals(mf.getName()))//1
{ 
return;
} 
} 
ModuleStatus ms = new ModuleStatus();
ms.setSelected();
moduleStatus.put(mf, ms);
} 
private void processJarFile(ClassLoader classloader, File file)
    throws ClassNotFoundException
    { 
LOG.info("Opening jar file " + file);
JarFile jarfile;
try//1
{ 
jarfile = new JarFile(file);
} 
catch (IOException e) //1
{ 
LOG.error("Unable to open " + file, e);
return;
} 
Manifest manifest;
try//2
{ 
manifest = jarfile.getManifest();
if(manifest == null)//1
{ 
LOG.warn(file + " does not have a manifest");
} 
} 
catch (IOException e) //1
{ 
LOG.error("Unable to read manifest of " + file, e);
return;
} 
boolean loadedClass = false;
if(manifest == null)//1
{ 
Enumeration<JarEntry> jarEntries = jarfile.entries();
while (jarEntries.hasMoreElements()) //1
{ 
JarEntry entry = jarEntries.nextElement();
loadedClass =
                    loadedClass
                    | processEntry(classloader, entry.getName());
} 
} 
else
{ 
Map<String, Attributes> entries = manifest.getEntries();
for (String key : entries.keySet()) //1
{ 
loadedClass =
                    loadedClass
                    | processEntry(classloader, key);
} 
} 
Translator.addClassLoader(classloader);
if(!loadedClass && !file.getName().contains("argouml-i18n-"))//1
{ 
LOG.error("Failed to find any loadable ArgoUML modules in jar "
                      + file);
} 
} 
public static void doLoad(boolean failingAllowed)
    { 
getInstance().doInternal(failingAllowed);
} 
public static boolean isSelected(String name)
    { 
return getInstance().isSelectedInternal(name);
} 
public static void setSelected(String name, boolean value)
    { 
getInstance().setSelectedInternal(name, value);
} 
private String getDescriptionInternal(String name)
    { 
Map.Entry<ModuleInterface, ModuleStatus> entry = findModule(name);
if(entry == null)//1
{ 
throw new IllegalArgumentException("Module does not exist.");
} 
ModuleInterface module = entry.getKey();
StringBuffer sb = new StringBuffer();
String desc = module.getInfo(ModuleInterface.DESCRIPTION);
if(desc != null)//1
{ 
sb.append(desc);
sb.append("\n\n");
} 
String author = module.getInfo(ModuleInterface.AUTHOR);
if(author != null)//1
{ 
sb.append("Author: ").append(author);
sb.append("\n");
} 
String version = module.getInfo(ModuleInterface.VERSION);
if(version != null)//1
{ 
sb.append("Version: ").append(version);
sb.append("\n");
} 
return sb.toString();
} 
private void huntForModules()
    { 
} 
private boolean processEntry(ClassLoader classloader, String cname)
    throws ClassNotFoundException
    { 
if(cname.endsWith(CLASS_SUFFIX))//1
{ 
int classNamelen = cname.length() - CLASS_SUFFIX.length();
String className = cname.substring(0, classNamelen);
className = className.replace('/', '.');
return addClass(classloader, className);
} 
return false;
} 
private void huntForModulesFromExtensionDir()
    { 
for (String location : extensionLocations) //1
{ 
huntModulesFromNamedDirectory(location);
} 
} 
private Collection<ModuleInterface> availableModules()
    { 
return Collections.unmodifiableCollection(moduleStatus.keySet());
} 
private void setSelectedInternal(String name, boolean value)
    { 
Map.Entry<ModuleInterface, ModuleStatus> entry = findModule(name);
if(entry != null)//1
{ 
ModuleStatus status = entry.getValue();
status.setSelected(value);
} 
} 
public List<String> getExtensionLocations()
    { 
return Collections.unmodifiableList(extensionLocations);
} 
public static void addClass(String classname)
    throws ClassNotFoundException
    { 
getInstance().addClass(ModuleLoader2.class.getClassLoader(),
                               classname);
} 
private boolean isSelectedInternal(String name)
    { 
Map.Entry<ModuleInterface, ModuleStatus> entry = findModule(name);
if(entry != null)//1
{ 
ModuleStatus status = entry.getValue();
if(status == null)//1
{ 
return false;
} 
return status.isSelected();
} 
return false;
} 
public static String getDescription(String name)
    { 
return getInstance().getDescriptionInternal(name);
} 
private boolean isEnabledInternal(String name)
    { 
Map.Entry<ModuleInterface, ModuleStatus> entry = findModule(name);
if(entry != null)//1
{ 
ModuleStatus status = entry.getValue();
if(status == null)//1
{ 
return false;
} 
return status.isEnabled();
} 
return false;
} 
private void doInternal(boolean failingAllowed)
    { 
huntForModules();
boolean someModuleSucceeded;
do{ 
someModuleSucceeded = false;
for (ModuleInterface module : getInstance().availableModules()) //1
{ 
ModuleStatus status = moduleStatus.get(module);
if(status == null)//1
{ 
continue;
} 
if(!status.isEnabled() && status.isSelected())//1
{ 
try//1
{ 
if(module.enable())//1
{ 
someModuleSucceeded = true;
status.setEnabled();
} 
} 
catch (Throwable e) //1
{ 
LOG.error("Exception or error while trying to "
                                  + "enable module " + module.getName(), e);
} 
} 
else
if(status.isEnabled() && !status.isSelected())//1
{ 
try//1
{ 
if(module.disable())//1
{ 
someModuleSucceeded = true;
status.setDisabled();
} 
} 
catch (Throwable e) //1
{ 
LOG.error("Exception or error while trying to "
                                  + "disable module " + module.getName(), e);
} 
} 
} 
} 
 while (someModuleSucceeded);//1
if(!failingAllowed)//1
{ 
for (ModuleInterface module : getInstance().availableModules()) //1
{ 
ModuleStatus status = moduleStatus.get(module);
if(status == null)//1
{ 
continue;
} 
if(status.isEnabled() && status.isSelected())//1
{ 
continue;
} 
if(!status.isEnabled() && !status.isSelected())//1
{ 
continue;
} 
if(status.isSelected())//1
{ 
LOG.warn("ModuleLoader was not able to enable module "
                             + module.getName());
} 
else
{ 
LOG.warn("ModuleLoader was not able to disable module "
                             + module.getName());
} 
} 
} 
} 
private boolean addClass(ClassLoader classLoader, String classname)
    throws ClassNotFoundException
    { 
LOG.info("Loading module " + classname);
Class moduleClass;
try//1
{ 
moduleClass = classLoader.loadClass(classname);
} 
catch (UnsupportedClassVersionError e) //1
{ 
LOG.error("Unsupported Java class version for " + classname);
return false;
} 
catch (NoClassDefFoundError e) //1
{ 
LOG.error("Unable to find required class while loading "
                      + classname + " - may indicate an obsolete"
                      + " extension module or an unresolved dependency", e);
return false;
} 
catch (Throwable e) //1
{ 
if(e instanceof ClassNotFoundException)//1
{ 
throw (ClassNotFoundException) e;
} 
LOG.error("Unexpected error while loading " + classname, e);
return false;
} 
if(!ModuleInterface.class.isAssignableFrom(moduleClass))//1
{ 
LOG.debug("The class " + classname + " is not a module.");
return false;
} 
Constructor defaultConstructor;
try//2
{ 
defaultConstructor =
                moduleClass.getDeclaredConstructor(new Class[] {});
} 
catch (SecurityException e) //1
{ 
LOG.error("The default constructor for class " + classname
                      + " is not accessable.",
                      e);
return false;
} 
catch (NoSuchMethodException e) //1
{ 
LOG.error("The default constructor for class " + classname
                      + " is not found.", e);
return false;
} 
catch (NoClassDefFoundError e) //1
{ 
LOG.error("Unable to find required class while loading "
                      + classname + " - may indicate an obsolete"
                      + " extension module or an unresolved dependency", e);
return false;
} 
catch (Throwable e) //1
{ 
LOG.error("Unexpected error while loading " + classname, e);
return false;
} 
if(!Modifier.isPublic(defaultConstructor.getModifiers()))//1
{ 
LOG.error("The default constructor for class " + classname
                      + " is not public.  Not loaded.");
return false;
} 
Object moduleInstance;
try//3
{ 
moduleInstance = defaultConstructor.newInstance(new Object[] {});
} 
catch (IllegalArgumentException e) //1
{ 
LOG.error("The constructor for class " + classname
                      + " is called with incorrect argument.", e);
return false;
} 
catch (InstantiationException e) //1
{ 
LOG.error("The constructor for class " + classname
                      + " threw an exception.", e);
return false;
} 
catch (IllegalAccessException e) //1
{ 
LOG.error("The constructor for class " + classname
                      + " is not accessible.", e);
return false;
} 
catch (InvocationTargetException e) //1
{ 
LOG.error("The constructor for class " + classname
                      + " cannot be called.", e);
return false;
} 
catch (NoClassDefFoundError e) //1
{ 
LOG.error("Unable to find required class while instantiating "
                      + classname + " - may indicate an obsolete"
                      + " extension module or an unresolved dependency", e);
return false;
} 
catch (Throwable e) //1
{ 
LOG.error("Unexpected error while instantiating " + classname, e);
return false;
} 
if(!(moduleInstance instanceof ModuleInterface))//1
{ 
LOG.error("The class " + classname + " is not a module.");
return false;
} 
ModuleInterface mf = (ModuleInterface) moduleInstance;
addModule(mf);
LOG.info("Succesfully loaded module " + classname);
return true;
} 
static class JarFileFilter implements FileFilter
  { 
public boolean accept(File pathname)
        { 
return (pathname.canRead()
                    && pathname.isFile()
                    && pathname.getPath().toLowerCase().endsWith(".jar"));
} 

 } 

 } 
