
//#if 2109773826 
// Compilation Unit of /ConfigurationHandler.java 
 

//#if 1485903703 
package org.argouml.configuration;
//#endif 


//#if 65271489 
import java.beans.PropertyChangeListener;
//#endif 


//#if 1287706194 
import java.beans.PropertyChangeSupport;
//#endif 


//#if 1168650669 
import java.io.File;
//#endif 


//#if -1306047277 
import java.net.URL;
//#endif 


//#if 2137459063 
import org.apache.log4j.Logger;
//#endif 


//#if -1316439568 
public abstract class ConfigurationHandler  { 

//#if 1551180738 
private File loadedFromFile;
//#endif 


//#if -921346088 
private URL loadedFromURL;
//#endif 


//#if -1067661605 
private boolean changeable;
//#endif 


//#if -1602843584 
private boolean loaded;
//#endif 


//#if 2054541964 
private static PropertyChangeSupport pcl;
//#endif 


//#if 761635793 
private static final Logger LOG =
        Logger.getLogger(ConfigurationHandler.class);
//#endif 


//#if -2062929201 
public abstract void remove(String key);
//#endif 


//#if 332580871 
private void loadIfNecessary()
    { 

//#if -27063264 
if(!loaded)//1
{ 

//#if -2059348224 
loadDefault();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1842871888 
private synchronized void workerSetValue(ConfigurationKey key,
            String newValue)
    { 

//#if 697491753 
loadIfNecessary();
//#endif 


//#if 1617113919 
String oldValue = getValue(key.getKey(), "");
//#endif 


//#if 387637144 
setValue(key.getKey(), newValue);
//#endif 


//#if -1300505964 
if(pcl != null)//1
{ 

//#if -1550830692 
pcl.firePropertyChange(key.getKey(), oldValue, newValue);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -149830434 
public abstract boolean loadURL(URL url);
//#endif 


//#if -1436429337 
public abstract boolean saveURL(URL url);
//#endif 


//#if -560952564 
public final void setString(ConfigurationKey key, String newValue)
    { 

//#if -1990751763 
workerSetValue(key, newValue);
//#endif 

} 

//#endif 


//#if 1149618453 
public final void setInteger(ConfigurationKey key, int value)
    { 

//#if 1835397155 
workerSetValue(key, Integer.toString(value));
//#endif 

} 

//#endif 


//#if -904525832 
public final void setBoolean(ConfigurationKey key, boolean value)
    { 

//#if -898049497 
Boolean bool = Boolean.valueOf(value);
//#endif 


//#if 1835904198 
workerSetValue(key, bool.toString());
//#endif 

} 

//#endif 


//#if 85752656 
public final boolean loadDefault()
    { 

//#if 841827997 
if(loaded)//1
{ 

//#if 1288239846 
return false;
//#endif 

} 

//#endif 


//#if 1679646170 
boolean status = load(new File(getDefaultPath()));
//#endif 


//#if 1235326411 
if(!status)//1
{ 

//#if 736287779 
status = loadUnspecified();
//#endif 

} 

//#endif 


//#if 1420099408 
loaded = true;
//#endif 


//#if -1914927618 
return status;
//#endif 

} 

//#endif 


//#if 726597406 
public abstract String getDefaultPath();
//#endif 


//#if 1409491003 
public final boolean load(File file)
    { 

//#if -2061313647 
boolean status = loadFile(file);
//#endif 


//#if 1904075429 
if(status)//1
{ 

//#if 33408084 
if(pcl != null)//1
{ 

//#if -187688179 
pcl.firePropertyChange(Configuration.FILE_LOADED, null, file);
//#endif 

} 

//#endif 


//#if 1196526984 
loadedFromFile = file;
//#endif 

} 

//#endif 


//#if -816824167 
return status;
//#endif 

} 

//#endif 


//#if 515075534 
public abstract boolean saveFile(File file);
//#endif 


//#if 1050239693 
public final int getInteger(ConfigurationKey key, int defaultValue)
    { 

//#if 840507439 
loadIfNecessary();
//#endif 


//#if 1989828215 
try //1
{ 

//#if 1392745252 
String s = getValue(key.getKey(), Integer.toString(defaultValue));
//#endif 


//#if 1164965309 
return Integer.parseInt(s);
//#endif 

} 

//#if 1226169972 
catch (NumberFormatException nfe) //1
{ 

//#if 1697645379 
return defaultValue;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1733984600 
public final void removeListener(ConfigurationKey key,
                                     PropertyChangeListener p)
    { 

//#if 753486404 
if(pcl != null)//1
{ 

//#if -2132341953 
LOG.debug("removePropertyChangeListener("
                      + key.getKey() + ")");
//#endif 


//#if 1607178258 
pcl.removePropertyChangeListener(key.getKey(), p);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1241954457 
public final boolean saveDefault()
    { 

//#if 692068599 
return saveDefault(false);
//#endif 

} 

//#endif 


//#if -927262550 
public final boolean save(URL url)
    { 

//#if -607182890 
if(!loaded)//1
{ 

//#if 1765485206 
return false;
//#endif 

} 

//#endif 


//#if -1652424235 
boolean status = saveURL(url);
//#endif 


//#if -1748472430 
if(status)//1
{ 

//#if -975702598 
if(pcl != null)//1
{ 

//#if 1114598520 
pcl.firePropertyChange(Configuration.URL_SAVED, null, url);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -174404730 
return status;
//#endif 

} 

//#endif 


//#if 1294845303 
public abstract boolean loadFile(File file);
//#endif 


//#if -554576700 
public final void setDouble(ConfigurationKey key, double value)
    { 

//#if -698738026 
workerSetValue(key, Double.toString(value));
//#endif 

} 

//#endif 


//#if -1398980789 
public final void addListener(ConfigurationKey key,
                                  PropertyChangeListener p)
    { 

//#if 967119027 
if(pcl == null)//1
{ 

//#if -1406572839 
pcl = new PropertyChangeSupport(this);
//#endif 

} 

//#endif 


//#if -1706927873 
LOG.debug("addPropertyChangeListener("
                  + key.getKey() + ")");
//#endif 


//#if 310732840 
pcl.addPropertyChangeListener(key.getKey(), p);
//#endif 

} 

//#endif 


//#if -1003615180 
public ConfigurationHandler(boolean c)
    { 

//#if 969109125 
super();
//#endif 


//#if -840943835 
changeable = c;
//#endif 

} 

//#endif 


//#if 754849269 
public final void addListener(PropertyChangeListener p)
    { 

//#if 776345635 
if(pcl == null)//1
{ 

//#if -1571742178 
pcl = new PropertyChangeSupport(this);
//#endif 

} 

//#endif 


//#if 331551486 
LOG.debug("addPropertyChangeListener(" + p + ")");
//#endif 


//#if -1515453063 
pcl.addPropertyChangeListener(p);
//#endif 

} 

//#endif 


//#if 476090916 
boolean saveUnspecified()
    { 

//#if 1744645508 
return false;
//#endif 

} 

//#endif 


//#if -1973454031 
public final boolean getBoolean(ConfigurationKey key,
                                    boolean defaultValue)
    { 

//#if -2114598496 
loadIfNecessary();
//#endif 


//#if -1972524827 
Boolean dflt = Boolean.valueOf(defaultValue);
//#endif 


//#if -439709330 
Boolean b =
            key != null
            ? Boolean.valueOf(getValue(key.getKey(), dflt.toString()))
            : dflt;
//#endif 


//#if 315652963 
return b.booleanValue();
//#endif 

} 

//#endif 


//#if 420913939 
public final boolean load(URL url)
    { 

//#if -1356012928 
boolean status = loadURL(url);
//#endif 


//#if 576079494 
if(status)//1
{ 

//#if -610350369 
if(pcl != null)//1
{ 

//#if 1372643621 
pcl.firePropertyChange(Configuration.URL_LOADED, null, url);
//#endif 

} 

//#endif 


//#if -1345757809 
loadedFromURL = url;
//#endif 

} 

//#endif 


//#if -2144820102 
return status;
//#endif 

} 

//#endif 


//#if -63726328 
public boolean hasKey(ConfigurationKey key)
    { 

//#if 1706115173 
return getValue(key.getKey(), "true").equals(getValue(key.getKey(),
                "false"));
//#endif 

} 

//#endif 


//#if 775308132 
public final double getDouble(ConfigurationKey key, double defaultValue)
    { 

//#if 1677232668 
loadIfNecessary();
//#endif 


//#if 2050982884 
try //1
{ 

//#if -1155822445 
String s = getValue(key.getKey(), Double.toString(defaultValue));
//#endif 


//#if -858527796 
return Double.parseDouble(s);
//#endif 

} 

//#if -152497875 
catch (NumberFormatException nfe) //1
{ 

//#if -867109415 
return defaultValue;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1089988050 
public final void removeListener(PropertyChangeListener p)
    { 

//#if -1812780661 
if(pcl != null)//1
{ 

//#if 1715763166 
LOG.debug("removePropertyChangeListener()");
//#endif 


//#if -1503693545 
pcl.removePropertyChangeListener(p);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -604295452 
public final String getString(ConfigurationKey key, String defaultValue)
    { 

//#if -776880038 
loadIfNecessary();
//#endif 


//#if 303644164 
return getValue(key.getKey(), defaultValue);
//#endif 

} 

//#endif 


//#if 435382800 
public abstract void setValue(String key, String value);
//#endif 


//#if -2080829130 
public final boolean saveDefault(boolean force)
    { 

//#if 1766153748 
if(force)//1
{ 

//#if 2102937086 
File toFile = new File(getDefaultPath());
//#endif 


//#if -2036705931 
boolean saved = saveFile(toFile);
//#endif 


//#if 882439103 
if(saved)//1
{ 

//#if 737917283 
loadedFromFile = toFile;
//#endif 

} 

//#endif 


//#if -370603713 
return saved;
//#endif 

} 

//#endif 


//#if -692409137 
if(!loaded)//1
{ 

//#if 569666495 
return false;
//#endif 

} 

//#endif 


//#if 2079207477 
if(loadedFromFile != null)//1
{ 

//#if -44852832 
return saveFile(loadedFromFile);
//#endif 

} 

//#endif 


//#if 1917861580 
if(loadedFromURL != null)//1
{ 

//#if 445760988 
return saveURL(loadedFromURL);
//#endif 

} 

//#endif 


//#if -1199582700 
return false;
//#endif 

} 

//#endif 


//#if -1961891588 
public final boolean isLoaded()
    { 

//#if -663273037 
return loaded;
//#endif 

} 

//#endif 


//#if -1402958830 
public final boolean save(File file)
    { 

//#if -1630261419 
if(!loaded)//1
{ 

//#if 140672599 
return false;
//#endif 

} 

//#endif 


//#if 1868831784 
boolean status = saveFile(file);
//#endif 


//#if 573829683 
if(status)//1
{ 

//#if 2096839597 
if(pcl != null)//1
{ 

//#if 1803325684 
pcl.firePropertyChange(Configuration.FILE_SAVED, null, file);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2147069913 
return status;
//#endif 

} 

//#endif 


//#if 1546534058 
public abstract String getValue(String key, String defaultValue);
//#endif 


//#if 455758273 
public final boolean isChangeable()
    { 

//#if -1255937184 
return changeable;
//#endif 

} 

//#endif 


//#if -52944549 
boolean loadUnspecified()
    { 

//#if 1733224990 
return false;
//#endif 

} 

//#endif 


//#if 1593066511 
public ConfigurationHandler()
    { 

//#if 1003104463 
this(true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

