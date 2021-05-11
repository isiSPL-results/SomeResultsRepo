
//#if -945996203 
// Compilation Unit of /Configuration.java 
 

//#if 1083114300 
package org.argouml.configuration;
//#endif 


//#if 904187708 
import java.beans.PropertyChangeListener;
//#endif 


//#if -1019305390 
import java.io.File;
//#endif 


//#if 800963960 
import java.net.URL;
//#endif 


//#if -158168833 
public final class Configuration  { 

//#if -717722116 
public static final String FILE_LOADED = "configuration.load.file";
//#endif 


//#if 1288842326 
public static final String URL_LOADED = "configuration.load.url";
//#endif 


//#if -1934129279 
public static final String FILE_SAVED = "configuration.save.file";
//#endif 


//#if 990241511 
public static final String URL_SAVED = "configuration.save.url";
//#endif 


//#if -1313609785 
private static ConfigurationHandler config =
        getFactory().getConfigurationHandler();
//#endif 


//#if 1655807052 
public static boolean load(URL url)
    { 

//#if -918361216 
return config.load(url);
//#endif 

} 

//#endif 


//#if -1190244851 
public static ConfigurationKey makeKey(String k1, String k2,
                                           String k3, String k4,
                                           String k5)
    { 

//#if -325089169 
return new ConfigurationKeyImpl(k1, k2, k3, k4, k5);
//#endif 

} 

//#endif 


//#if 532454016 
private Configuration()
    { 
} 

//#endif 


//#if 1845749639 
public static int getInteger(ConfigurationKey key)
    { 

//#if -147159931 
return getInteger(key, 0);
//#endif 

} 

//#endif 


//#if -1210384678 
public static ConfigurationKey makeKey(ConfigurationKey ck, String k1)
    { 

//#if -2094103956 
return new ConfigurationKeyImpl(ck, k1);
//#endif 

} 

//#endif 


//#if 2108407709 
public static String getString(ConfigurationKey key,
                                   String defaultValue)
    { 

//#if 1063514359 
return config.getString(key, defaultValue);
//#endif 

} 

//#endif 


//#if -1679372796 
public static boolean getBoolean(ConfigurationKey key)
    { 

//#if -1761480999 
return getBoolean(key, false);
//#endif 

} 

//#endif 


//#if -433493073 
public static IConfigurationFactory getFactory()
    { 

//#if 1522797514 
return ConfigurationFactory.getInstance();
//#endif 

} 

//#endif 


//#if -1747847041 
public static ConfigurationKey makeKey(String k1, String k2)
    { 

//#if -487904787 
return new ConfigurationKeyImpl(k1, k2);
//#endif 

} 

//#endif 


//#if 144663934 
public static ConfigurationKey makeKey(String k1, String k2,
                                           String k3, String k4)
    { 

//#if -131680795 
return new ConfigurationKeyImpl(k1, k2, k3, k4);
//#endif 

} 

//#endif 


//#if 2010940879 
public static ConfigurationKey makeKey(String k1)
    { 

//#if -58049431 
return new ConfigurationKeyImpl(k1);
//#endif 

} 

//#endif 


//#if 1102045940 
public static void setInteger(ConfigurationKey key, int newValue)
    { 

//#if 593462291 
config.setInteger(key, newValue);
//#endif 

} 

//#endif 


//#if -806956003 
public static double getDouble(ConfigurationKey key,
                                   double defaultValue)
    { 

//#if 450369850 
return config.getDouble(key, defaultValue);
//#endif 

} 

//#endif 


//#if 1452631112 
public static double getDouble(ConfigurationKey key)
    { 

//#if -743422240 
return getDouble(key, 0);
//#endif 

} 

//#endif 


//#if -2103606668 
public static int getInteger(ConfigurationKey key, int defaultValue)
    { 

//#if 210301492 
return config.getInteger(key, defaultValue);
//#endif 

} 

//#endif 


//#if 1150324913 
public static void setBoolean(ConfigurationKey key,
                                  boolean newValue)
    { 

//#if -1533180843 
config.setBoolean(key, newValue);
//#endif 

} 

//#endif 


//#if 1688837312 
public static boolean save(boolean force)
    { 

//#if 1022431741 
return config.saveDefault(force);
//#endif 

} 

//#endif 


//#if 1113230318 
public static ConfigurationKey makeKey(String k1, String k2, String k3)
    { 

//#if -331302422 
return new ConfigurationKeyImpl(k1, k2, k3);
//#endif 

} 

//#endif 


//#if -1453002988 
public static ConfigurationHandler getConfigurationHandler()
    { 

//#if -1015123745 
return config;
//#endif 

} 

//#endif 


//#if -1938226216 
public static boolean getBoolean(ConfigurationKey key,
                                     boolean defaultValue)
    { 

//#if -1795340228 
return config.getBoolean(key, defaultValue);
//#endif 

} 

//#endif 


//#if -1029238889 
public static void removeKey(ConfigurationKey key)
    { 

//#if 597755893 
config.remove(key.getKey());
//#endif 

} 

//#endif 


//#if 1898183333 
public static void setDouble(ConfigurationKey key, double newValue)
    { 

//#if 360802640 
config.setDouble(key, newValue);
//#endif 

} 

//#endif 


//#if 866029644 
public static boolean load()
    { 

//#if 438091935 
return config.loadDefault();
//#endif 

} 

//#endif 


//#if -1677126590 
public static void removeListener(PropertyChangeListener pcl)
    { 

//#if 1434394987 
config.removeListener(pcl);
//#endif 

} 

//#endif 


//#if 1054130979 
public static boolean save()
    { 

//#if -205215178 
return Configuration.save(false);
//#endif 

} 

//#endif 


//#if 256313939 
public static void addListener(PropertyChangeListener pcl)
    { 

//#if -1363902469 
config.addListener(pcl);
//#endif 

} 

//#endif 


//#if -846046039 
public static void addListener(ConfigurationKey key,
                                   PropertyChangeListener pcl)
    { 

//#if -8797838 
config.addListener(key, pcl);
//#endif 

} 

//#endif 


//#if -1564168396 
public static boolean load(File file)
    { 

//#if 1191380665 
return config.load(file);
//#endif 

} 

//#endif 


//#if -247047547 
public static void setString(ConfigurationKey key, String newValue)
    { 

//#if 459380642 
config.setString(key, newValue);
//#endif 

} 

//#endif 


//#if -2000479976 
public static void removeListener(ConfigurationKey key,
                                      PropertyChangeListener pcl)
    { 

//#if 358965960 
config.removeListener(key, pcl);
//#endif 

} 

//#endif 


//#if -230780824 
public static String getString(ConfigurationKey key)
    { 

//#if 1536643712 
return getString(key, "");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

