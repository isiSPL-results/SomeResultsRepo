
//#if 1425392176 
// Compilation Unit of /ConfigurationFactory.java 
 

//#if -1513973922 
package org.argouml.configuration;
//#endif 


//#if -286138672 
import org.apache.log4j.Logger;
//#endif 


//#if 1044608345 
public class ConfigurationFactory implements 
//#if -1480276440 
IConfigurationFactory
//#endif 

  { 

//#if 113073683 
private static final IConfigurationFactory SINGLETON;
//#endif 


//#if 1028133134 
private static ConfigurationHandler handler =
        new ConfigurationProperties();
//#endif 


//#if -473096251 
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


//#if 1370758077 
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


//#if 1298055193 
public static final IConfigurationFactory getInstance()
    { 

//#if 1835012048 
return SINGLETON;
//#endif 

} 

//#endif 


//#if -685996711 
public ConfigurationHandler getConfigurationHandler()
    { 

//#if -1602076317 
return handler;
//#endif 

} 

//#endif 


//#if -1815684445 
private ConfigurationFactory()
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

