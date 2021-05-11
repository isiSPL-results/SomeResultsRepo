
//#if -644637365 
// Compilation Unit of /ConfigurationKeyImpl.java 
 

//#if -1685457881 
package org.argouml.configuration;
//#endif 


//#if 1956412215 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -216896393 
public class ConfigurationKeyImpl implements 
//#if -856072757 
ConfigurationKey
//#endif 

  { 

//#if -1209059772 
private String key = null;
//#endif 


//#if -1401707927 
public String toString()
    { 

//#if 921518291 
return "{ConfigurationKeyImpl:" + key + "}";
//#endif 

} 

//#endif 


//#if 1842819467 
public ConfigurationKeyImpl(ConfigurationKey ck, String k1)
    { 

//#if -140498880 
key = ck.getKey() + "." + k1;
//#endif 

} 

//#endif 


//#if -954675578 
public boolean isChangedProperty(PropertyChangeEvent pce)
    { 

//#if 266994552 
if(pce == null)//1
{ 

//#if -211990901 
return false;
//#endif 

} 

//#endif 


//#if 683452493 
return pce.getPropertyName().equals(key);
//#endif 

} 

//#endif 


//#if -173752547 
public ConfigurationKeyImpl(String k1, String k2, String k3)
    { 

//#if -565566427 
key = "argo." + k1 + "." + k2 + "." + k3;
//#endif 

} 

//#endif 


//#if 1785820862 
public ConfigurationKeyImpl(String k1)
    { 

//#if -1247273164 
key = "argo." + k1;
//#endif 

} 

//#endif 


//#if 911975536 
public ConfigurationKeyImpl(String k1, String k2)
    { 

//#if 193511687 
key = "argo." + k1 + "." + k2;
//#endif 

} 

//#endif 


//#if -476424401 
public ConfigurationKeyImpl(String k1, String k2, String k3, String k4)
    { 

//#if 1285854493 
key = "argo." + k1 + "." + k2 + "." + k3 + "." + k4;
//#endif 

} 

//#endif 


//#if -1583762564 
public ConfigurationKeyImpl(String k1, String k2,
                                String k3, String k4, String k5)
    { 

//#if 295390279 
key = "argo." + k1 + "." + k2 + "." + k3 + "." + k4 + "." + k5;
//#endif 

} 

//#endif 


//#if -1005444826 
public final String getKey()
    { 

//#if -1415250748 
return key;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

