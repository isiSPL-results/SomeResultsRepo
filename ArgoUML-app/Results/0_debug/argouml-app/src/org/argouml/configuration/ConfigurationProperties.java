
//#if 390040023 
// Compilation Unit of /ConfigurationProperties.java 
 

//#if 1255721113 
package org.argouml.configuration;
//#endif 


//#if -1377411473 
import java.io.File;
//#endif 


//#if 1704146685 
import java.io.FileInputStream;
//#endif 


//#if -790074361 
import java.io.FileNotFoundException;
//#endif 


//#if -760935282 
import java.io.FileOutputStream;
//#endif 


//#if 1575770434 
import java.io.IOException;
//#endif 


//#if 442857877 
import java.net.URL;
//#endif 


//#if 757492852 
import java.util.Properties;
//#endif 


//#if -2123059339 
import org.apache.log4j.Logger;
//#endif 


//#if -2102602496 
class ConfigurationProperties extends 
//#if -1280064933 
ConfigurationHandler
//#endif 

  { 

//#if -110166346 
private static String propertyLocation =
        "/org/argouml/resource/default.properties";
//#endif 


//#if -211731243 
private Properties propertyBundle;
//#endif 


//#if -1193552227 
private boolean canComplain = true;
//#endif 


//#if -1742021062 
private static final Logger LOG =
        Logger.getLogger(ConfigurationProperties.class);
//#endif 


//#if 902031619 
ConfigurationProperties()
    { 

//#if -1424453090 
super(true);
//#endif 


//#if 1238089742 
Properties defaults = new Properties();
//#endif 


//#if 1570904071 
try //1
{ 

//#if 736863527 
defaults.load(getClass().getResourceAsStream(propertyLocation));
//#endif 


//#if -1920571916 
LOG.debug("Configuration loaded from " + propertyLocation);
//#endif 

} 

//#if -1359192465 
catch (Exception ioe) //1
{ 

//#if -389836374 
LOG.warn("Configuration not loaded from " + propertyLocation, ioe);
//#endif 

} 

//#endif 


//#endif 


//#if 504574862 
propertyBundle = new Properties(defaults);
//#endif 

} 

//#endif 


//#if -1882479344 
@Deprecated
    public String getOldDefaultPath()
    { 

//#if -1783887931 
return System.getProperty("user.home") + "/argo.user.properties";
//#endif 

} 

//#endif 


//#if 1184697197 
private static boolean copyFile(final File source, final File dest)
    { 

//#if -315274274 
try //1
{ 

//#if 965791914 
final FileInputStream fis = new FileInputStream(source);
//#endif 


//#if 1929316717 
final FileOutputStream fos = new FileOutputStream(dest);
//#endif 


//#if 1423716574 
byte[] buf = new byte[1024];
//#endif 


//#if 428761462 
int i = 0;
//#endif 


//#if -1442264908 
while ((i = fis.read(buf)) != -1) //1
{ 

//#if 70032419 
fos.write(buf, 0, i);
//#endif 

} 

//#endif 


//#if 262685816 
fis.close();
//#endif 


//#if -1929087746 
fos.close();
//#endif 


//#if -456676283 
return true;
//#endif 

} 

//#if 1547713768 
catch (final FileNotFoundException e) //1
{ 

//#if 1465694427 
LOG.error("File not found while copying", e);
//#endif 


//#if 659517877 
return false;
//#endif 

} 

//#endif 


//#if 253170531 
catch (final IOException e) //1
{ 

//#if 561088650 
LOG.error("IO error copying file", e);
//#endif 


//#if -1997076828 
return false;
//#endif 

} 

//#endif 


//#if -367549219 
catch (final SecurityException e) //1
{ 

//#if 1713747845 
LOG.error("You are not allowed to copy these files", e);
//#endif 


//#if 382310726 
return false;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1068279502 
public boolean loadURL(URL url)
    { 

//#if 279121193 
try //1
{ 

//#if -1599242585 
propertyBundle.load(url.openStream());
//#endif 


//#if 392627128 
LOG.info("Configuration loaded from " + url + "\n");
//#endif 


//#if -659862115 
return true;
//#endif 

} 

//#if -672695398 
catch (Exception e) //1
{ 

//#if 938824308 
if(canComplain)//1
{ 

//#if 71431645 
LOG.warn("Unable to load configuration " + url + "\n");
//#endif 

} 

//#endif 


//#if 1530100122 
canComplain = false;
//#endif 


//#if 1958636998 
return false;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -191851662 
public String getDefaultPath()
    { 

//#if 1844239683 
return System.getProperty("user.home")
               + "/.argouml/argo.user.properties";
//#endif 

} 

//#endif 


//#if 2007531068 
public void setValue(String key, String value)
    { 

//#if 1960336482 
LOG.debug("key '" + key + "' set to '" + value + "'");
//#endif 


//#if 1162044467 
propertyBundle.setProperty(key, value);
//#endif 

} 

//#endif 


//#if 1940088891 
public boolean saveURL(URL url)
    { 

//#if 446744113 
return false;
//#endif 

} 

//#endif 


//#if -1279663965 
public boolean loadFile(File file)
    { 

//#if 1448470994 
try //1
{ 

//#if 2108883458 
if(!file.exists())//1
{ 

//#if -1415946225 
final File oldFile = new File(getOldDefaultPath());
//#endif 


//#if 366157957 
if(oldFile.exists() && oldFile.isFile() && oldFile.canRead()
                        && file.getParentFile().canWrite())//1
{ 

//#if -1036024994 
final boolean result = copyFile(oldFile, file);
//#endif 


//#if -551373998 
if(result)//1
{ 

//#if 177202622 
LOG.info("Configuration copied from "
                                 + oldFile + " to " + file);
//#endif 

} 
else
{ 

//#if 685111468 
LOG.error("Error copying old configuration to new, "
                                  + "see previous log messages");
//#endif 

} 

//#endif 

} 
else
{ 

//#if -211431589 
try //1
{ 

//#if -19656262 
file.createNewFile();
//#endif 

} 

//#if 1370304314 
catch (IOException e) //1
{ 

//#if 1286144726 
LOG.error("Could not create the properties file at: "
                                  + file.getAbsolutePath(), e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -580599149 
if(file.exists() && file.isFile() && file.canRead())//1
{ 

//#if 175240694 
try //1
{ 

//#if -1960052765 
propertyBundle.load(new FileInputStream(file));
//#endif 


//#if 929288919 
LOG.info("Configuration loaded from " + file);
//#endif 


//#if 2051641482 
return true;
//#endif 

} 

//#if -2075424165 
catch (final IOException e) //1
{ 

//#if 1431821896 
if(canComplain)//1
{ 

//#if -1656811656 
LOG.warn("Unable to load configuration " + file);
//#endif 

} 

//#endif 


//#if 2023097710 
canComplain = false;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#if 1888195385 
catch (final SecurityException e) //1
{ 

//#if -1270845457 
LOG.error("A security exception occurred trying to load"
                      + " the configuration, check your security settings", e);
//#endif 

} 

//#endif 


//#endif 


//#if 403272388 
return false;
//#endif 

} 

//#endif 


//#if -707083269 
public void remove(String key)
    { 

//#if -1653459140 
propertyBundle.remove(key);
//#endif 

} 

//#endif 


//#if 1401887230 
public String getValue(String key, String defaultValue)
    { 

//#if -1148530271 
String result = "";
//#endif 


//#if -910978197 
try //1
{ 

//#if 1357546684 
result = propertyBundle.getProperty(key, defaultValue);
//#endif 

} 

//#if 685505323 
catch (Exception e) //1
{ 

//#if 291500242 
result = defaultValue;
//#endif 

} 

//#endif 


//#endif 


//#if -1587755463 
return result;
//#endif 

} 

//#endif 


//#if -2059433734 
public boolean saveFile(File file)
    { 

//#if 961536939 
try //1
{ 

//#if -1216528895 
propertyBundle.store(new FileOutputStream(file),
                                 "ArgoUML properties");
//#endif 


//#if -2041630954 
LOG.info("Configuration saved to " + file);
//#endif 


//#if 39085788 
return true;
//#endif 

} 

//#if 727366886 
catch (Exception e) //1
{ 

//#if -1509073961 
if(canComplain)//1
{ 

//#if -406196033 
LOG.warn("Unable to save configuration " + file + "\n");
//#endif 

} 

//#endif 


//#if -917798147 
canComplain = false;
//#endif 

} 

//#endif 


//#endif 


//#if -485693987 
return false;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

