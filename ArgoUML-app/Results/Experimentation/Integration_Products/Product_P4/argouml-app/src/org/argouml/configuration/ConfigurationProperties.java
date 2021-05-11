package org.argouml.configuration;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import org.apache.log4j.Logger;
class ConfigurationProperties extends ConfigurationHandler
  { 
private static String propertyLocation =
        "/org/argouml/resource/default.properties";
private Properties propertyBundle;
private boolean canComplain = true;
private static final Logger LOG =
        Logger.getLogger(ConfigurationProperties.class);
ConfigurationProperties()
    { 
super(true);
Properties defaults = new Properties();
try//1
{ 
defaults.load(getClass().getResourceAsStream(propertyLocation));
LOG.debug("Configuration loaded from " + propertyLocation);
} 
catch (Exception ioe) //1
{ 
LOG.warn("Configuration not loaded from " + propertyLocation, ioe);
} 
propertyBundle = new Properties(defaults);
} 
@Deprecated
    public String getOldDefaultPath()
    { 
return System.getProperty("user.home") + "/argo.user.properties";
} 
private static boolean copyFile(final File source, final File dest)
    { 
try//1
{ 
final FileInputStream fis = new FileInputStream(source);
final FileOutputStream fos = new FileOutputStream(dest);
byte[] buf = new byte[1024];
int i = 0;
while ((i = fis.read(buf)) != -1) //1
{ 
fos.write(buf, 0, i);
} 
fis.close();
fos.close();
return true;
} 
catch (final FileNotFoundException e) //1
{ 
LOG.error("File not found while copying", e);
return false;
} 
catch (final IOException e) //1
{ 
LOG.error("IO error copying file", e);
return false;
} 
catch (final SecurityException e) //1
{ 
LOG.error("You are not allowed to copy these files", e);
return false;
} 
} 
public boolean loadURL(URL url)
    { 
try//1
{ 
propertyBundle.load(url.openStream());
LOG.info("Configuration loaded from " + url + "\n");
return true;
} 
catch (Exception e) //1
{ 
if(canComplain)//1
{ 
LOG.warn("Unable to load configuration " + url + "\n");
} 
canComplain = false;
return false;
} 
} 
public String getDefaultPath()
    { 
return System.getProperty("user.home")
               + "/.argouml/argo.user.properties";
} 
public void setValue(String key, String value)
    { 
LOG.debug("key '" + key + "' set to '" + value + "'");
propertyBundle.setProperty(key, value);
} 
public boolean saveURL(URL url)
    { 
return false;
} 
public boolean loadFile(File file)
    { 
try//1
{ 
if(!file.exists())//1
{ 
final File oldFile = new File(getOldDefaultPath());
if(oldFile.exists() && oldFile.isFile() && oldFile.canRead()
                        && file.getParentFile().canWrite())//1
{ 
final boolean result = copyFile(oldFile, file);
if(result)//1
{ 
LOG.info("Configuration copied from "
                                 + oldFile + " to " + file);
} 
else
{ 
LOG.error("Error copying old configuration to new, "
                                  + "see previous log messages");
} 
} 
else
{ 
try//1
{ 
file.createNewFile();
} 
catch (IOException e) //1
{ 
LOG.error("Could not create the properties file at: "
                                  + file.getAbsolutePath(), e);
} 
} 
} 
if(file.exists() && file.isFile() && file.canRead())//1
{ 
try//1
{ 
propertyBundle.load(new FileInputStream(file));
LOG.info("Configuration loaded from " + file);
return true;
} 
catch (final IOException e) //1
{ 
if(canComplain)//1
{ 
LOG.warn("Unable to load configuration " + file);
} 
canComplain = false;
} 
} 
} 
catch (final SecurityException e) //1
{ 
LOG.error("A security exception occurred trying to load"
                      + " the configuration, check your security settings", e);
} 
return false;
} 
public void remove(String key)
    { 
propertyBundle.remove(key);
} 
public String getValue(String key, String defaultValue)
    { 
String result = "";
try//1
{ 
result = propertyBundle.getProperty(key, defaultValue);
} 
catch (Exception e) //1
{ 
result = defaultValue;
} 
return result;
} 
public boolean saveFile(File file)
    { 
try//1
{ 
propertyBundle.store(new FileOutputStream(file),
                                 "ArgoUML properties");
LOG.info("Configuration saved to " + file);
return true;
} 
catch (Exception e) //1
{ 
if(canComplain)//1
{ 
LOG.warn("Unable to save configuration " + file + "\n");
} 
canComplain = false;
} 
return false;
} 

 } 
