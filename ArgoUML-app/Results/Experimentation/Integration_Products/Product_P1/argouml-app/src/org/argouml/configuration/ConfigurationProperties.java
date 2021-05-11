package org.argouml.configuration;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
class ConfigurationProperties extends ConfigurationHandler
  { 
private static String propertyLocation =
        "/org/argouml/resource/default.properties";
private Properties propertyBundle;
private boolean canComplain = true;
ConfigurationProperties()
    { 
super(true);
Properties defaults = new Properties();
try//1
{ 
defaults.load(getClass().getResourceAsStream(propertyLocation));
} 
catch (Exception ioe) //1
{ 
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
return false;
} 
catch (final IOException e) //1
{ 
return false;
} 
catch (final SecurityException e) //1
{ 
return false;
} 
} 
public boolean loadURL(URL url)
    { 
try//1
{ 
propertyBundle.load(url.openStream());
return true;
} 
catch (Exception e) //1
{ 
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
} 
else
{ 
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
} 
} 
} 
if(file.exists() && file.isFile() && file.canRead())//1
{ 
try//1
{ 
propertyBundle.load(new FileInputStream(file));
return true;
} 
catch (final IOException e) //1
{ 
canComplain = false;
} 
} 
} 
catch (final SecurityException e) //1
{ 
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
return true;
} 
catch (Exception e) //1
{ 
canComplain = false;
} 
return false;
} 

 } 
