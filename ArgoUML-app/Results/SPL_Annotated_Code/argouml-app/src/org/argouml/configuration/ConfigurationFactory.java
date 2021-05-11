// Compilation Unit of /ConfigurationFactory.java 
 
package org.argouml.configuration;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

public class ConfigurationFactory implements IConfigurationFactory
  { 
private static final IConfigurationFactory SINGLETON;
private static ConfigurationHandler handler =
        new ConfigurationProperties();

//#if (CLASS || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) && ! LOGGING  
static
    {
        String name = System.getProperty("argo.ConfigurationFactory");
        IConfigurationFactory newFactory = null;
        if (name != null) {
            try {
                newFactory =
                    (IConfigurationFactory) Class.forName(name).newInstance();
            } catch (Exception e) {







            }
        }
        if (newFactory == null) {
            newFactory = new ConfigurationFactory();
        }
        SINGLETON = newFactory;
    }
//#endif 


//#if LOGGING 
static
    {
        String name = System.getProperty("argo.ConfigurationFactory");
        IConfigurationFactory newFactory = null;
        if (name != null) {
            try {
                newFactory =
                    (IConfigurationFactory) Class.forName(name).newInstance();
            } catch (Exception e) {



                Logger.getLogger(ConfigurationFactory.class).
                warn("Can't create configuration factory "
                     + name + ", using default factory");

            }
        }
        if (newFactory == null) {
            newFactory = new ConfigurationFactory();
        }
        SINGLETON = newFactory;
    }
//#endif 

public static final IConfigurationFactory getInstance()
    { 
return SINGLETON;
} 

public ConfigurationHandler getConfigurationHandler()
    { 
return handler;
} 

private ConfigurationFactory()
    { 
} 

 } 


