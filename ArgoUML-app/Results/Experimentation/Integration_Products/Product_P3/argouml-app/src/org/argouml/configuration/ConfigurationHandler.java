package org.argouml.configuration;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.net.URL;
public abstract class ConfigurationHandler  { 
private File loadedFromFile;
private URL loadedFromURL;
private boolean changeable;
private boolean loaded;
private static PropertyChangeSupport pcl;
public abstract void remove(String key);private void loadIfNecessary()
    { 
if(!loaded)//1
{ 
loadDefault();
} 
} 
private synchronized void workerSetValue(ConfigurationKey key,
            String newValue)
    { 
loadIfNecessary();
String oldValue = getValue(key.getKey(), "");
setValue(key.getKey(), newValue);
if(pcl != null)//1
{ 
pcl.firePropertyChange(key.getKey(), oldValue, newValue);
} 
} 
public abstract boolean loadURL(URL url);public abstract boolean saveURL(URL url);public final void setString(ConfigurationKey key, String newValue)
    { 
workerSetValue(key, newValue);
} 
public final void setInteger(ConfigurationKey key, int value)
    { 
workerSetValue(key, Integer.toString(value));
} 
public final void setBoolean(ConfigurationKey key, boolean value)
    { 
Boolean bool = Boolean.valueOf(value);
workerSetValue(key, bool.toString());
} 
public final boolean loadDefault()
    { 
if(loaded)//1
{ 
return false;
} 
boolean status = load(new File(getDefaultPath()));
if(!status)//1
{ 
status = loadUnspecified();
} 
loaded = true;
return status;
} 
public abstract String getDefaultPath();public final boolean load(File file)
    { 
boolean status = loadFile(file);
if(status)//1
{ 
if(pcl != null)//1
{ 
pcl.firePropertyChange(Configuration.FILE_LOADED, null, file);
} 
loadedFromFile = file;
} 
return status;
} 
public abstract boolean saveFile(File file);public final int getInteger(ConfigurationKey key, int defaultValue)
    { 
loadIfNecessary();
try//1
{ 
String s = getValue(key.getKey(), Integer.toString(defaultValue));
return Integer.parseInt(s);
} 
catch (NumberFormatException nfe) //1
{ 
return defaultValue;
} 
} 
public final void removeListener(ConfigurationKey key,
                                     PropertyChangeListener p)
    { 
if(pcl != null)//1
{ 
pcl.removePropertyChangeListener(key.getKey(), p);
} 
} 
public final boolean saveDefault()
    { 
return saveDefault(false);
} 
public final boolean save(URL url)
    { 
if(!loaded)//1
{ 
return false;
} 
boolean status = saveURL(url);
if(status)//1
{ 
if(pcl != null)//1
{ 
pcl.firePropertyChange(Configuration.URL_SAVED, null, url);
} 
} 
return status;
} 
public abstract boolean loadFile(File file);public final void setDouble(ConfigurationKey key, double value)
    { 
workerSetValue(key, Double.toString(value));
} 
public final void addListener(ConfigurationKey key,
                                  PropertyChangeListener p)
    { 
if(pcl == null)//1
{ 
pcl = new PropertyChangeSupport(this);
} 
pcl.addPropertyChangeListener(key.getKey(), p);
} 
public ConfigurationHandler(boolean c)
    { 
super();
changeable = c;
} 
public final void addListener(PropertyChangeListener p)
    { 
if(pcl == null)//1
{ 
pcl = new PropertyChangeSupport(this);
} 
pcl.addPropertyChangeListener(p);
} 
boolean saveUnspecified()
    { 
return false;
} 
public final boolean getBoolean(ConfigurationKey key,
                                    boolean defaultValue)
    { 
loadIfNecessary();
Boolean dflt = Boolean.valueOf(defaultValue);
Boolean b =
            key != null
            ? Boolean.valueOf(getValue(key.getKey(), dflt.toString()))
            : dflt;
return b.booleanValue();
} 
public final boolean load(URL url)
    { 
boolean status = loadURL(url);
if(status)//1
{ 
if(pcl != null)//1
{ 
pcl.firePropertyChange(Configuration.URL_LOADED, null, url);
} 
loadedFromURL = url;
} 
return status;
} 
public boolean hasKey(ConfigurationKey key)
    { 
return getValue(key.getKey(), "true").equals(getValue(key.getKey(),
                "false"));
} 
public final double getDouble(ConfigurationKey key, double defaultValue)
    { 
loadIfNecessary();
try//1
{ 
String s = getValue(key.getKey(), Double.toString(defaultValue));
return Double.parseDouble(s);
} 
catch (NumberFormatException nfe) //1
{ 
return defaultValue;
} 
} 
public final void removeListener(PropertyChangeListener p)
    { 
if(pcl != null)//1
{ 
pcl.removePropertyChangeListener(p);
} 
} 
public final String getString(ConfigurationKey key, String defaultValue)
    { 
loadIfNecessary();
return getValue(key.getKey(), defaultValue);
} 
public abstract void setValue(String key, String value);public final boolean saveDefault(boolean force)
    { 
if(force)//1
{ 
File toFile = new File(getDefaultPath());
boolean saved = saveFile(toFile);
if(saved)//1
{ 
loadedFromFile = toFile;
} 
return saved;
} 
if(!loaded)//1
{ 
return false;
} 
if(loadedFromFile != null)//1
{ 
return saveFile(loadedFromFile);
} 
if(loadedFromURL != null)//1
{ 
return saveURL(loadedFromURL);
} 
return false;
} 
public final boolean isLoaded()
    { 
return loaded;
} 
public final boolean save(File file)
    { 
if(!loaded)//1
{ 
return false;
} 
boolean status = saveFile(file);
if(status)//1
{ 
if(pcl != null)//1
{ 
pcl.firePropertyChange(Configuration.FILE_SAVED, null, file);
} 
} 
return status;
} 
public abstract String getValue(String key, String defaultValue);public final boolean isChangeable()
    { 
return changeable;
} 
boolean loadUnspecified()
    { 
return false;
} 
public ConfigurationHandler()
    { 
this(true);
} 

 } 
