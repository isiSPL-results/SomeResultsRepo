// Compilation Unit of /ConfigurationProperties.java 
 
package org.argouml.configuration;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

class ConfigurationProperties extends ConfigurationHandler
  { 
private static String propertyLocation =
        "/org/argouml/resource/default.properties";
private Properties propertyBundle;
private boolean canComplain = true;

//#if LOGGING 
private static final Logger LOG =
        Logger.getLogger(ConfigurationProperties.class);
//#endif 

ConfigurationProperties()
    { 
super(true);
Properties defaults = new Properties();
try //1
{ 
defaults.load(getClass().getResourceAsStream(propertyLocation));

//#if LOGGING 
LOG.debug("Configuration loaded from " + propertyLocation);
//#endif 

} 
catch (Exception ioe) //1
{ 

//#if LOGGING 
LOG.warn("Configuration not loaded from " + propertyLocation, ioe);
//#endif 

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
try //1
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

//#if LOGGING 
LOG.error("File not found while copying", e);
//#endif 

return false;
} 

catch (final IOException e) //1
{ 

//#if LOGGING 
LOG.error("IO error copying file", e);
//#endif 

return false;
} 

catch (final SecurityException e) //1
{ 

//#if LOGGING 
LOG.error("You are not allowed to copy these files", e);
//#endif 

return false;
} 


} 

public boolean loadURL(URL url)
    { 
try //1
{ 
propertyBundle.load(url.openStream());

//#if LOGGING 
LOG.info("Configuration loaded from " + url + "\n");
//#endif 

return true;
} 
catch (Exception e) //1
{ 

//#if LOGGING 
if(canComplain)//1
{ 
LOG.warn("Unable to load configuration " + url + "\n");
} 

//#endif 

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

//#if LOGGING 
LOG.debug("key '" + key + "' set to '" + value + "'");
//#endif 

propertyBundle.setProperty(key, value);
} 

public boolean saveURL(URL url)
    { 
return false;
} 

public boolean loadFile(File file)
    { 
try //1
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

//#if LOGGING 
LOG.info("Configuration copied from "
                                 + oldFile + " to " + file);
//#endif 

} 
else
{ 

//#if LOGGING 
LOG.error("Error copying old configuration to new, "
                                  + "see previous log messages");
//#endif 

} 

} 
else
{ 
try //1
{ 
file.createNewFile();
} 
catch (IOException e) //1
{ 

//#if LOGGING 
LOG.error("Could not create the properties file at: "
                                  + file.getAbsolutePath(), e);
//#endif 

} 


} 

} 

if(file.exists() && file.isFile() && file.canRead())//1
{ 
try //1
{ 
propertyBundle.load(new FileInputStream(file));

//#if LOGGING 
LOG.info("Configuration loaded from " + file);
//#endif 

return true;
} 
catch (final IOException e) //1
{ 

//#if LOGGING 
if(canComplain)//1
{ 
LOG.warn("Unable to load configuration " + file);
} 

//#endif 

canComplain = false;
} 


} 

} 
catch (final SecurityException e) //1
{ 

//#if LOGGING 
LOG.error("A security exception occurred trying to load"
                      + " the configuration, check your security settings", e);
//#endif 

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
try //1
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
try //1
{ 
propertyBundle.store(new FileOutputStream(file),
                                 "ArgoUML properties");

//#if LOGGING 
LOG.info("Configuration saved to " + file);
//#endif 

return true;
} 
catch (Exception e) //1
{ 

//#if LOGGING 
if(canComplain)//1
{ 
LOG.warn("Unable to save configuration " + file + "\n");
} 

//#endif 

canComplain = false;
} 


return false;
} 

 } 


