
//#if 705290790 
// Compilation Unit of /ResourceModelLoader.java 
 

//#if 1826771892 
package org.argouml.profile;
//#endif 


//#if -1479212329 
import java.util.Collection;
//#endif 


//#if 1913644615 
import org.apache.log4j.Logger;
//#endif 


//#if -1908543392 
public class ResourceModelLoader extends 
//#if -698385982 
URLModelLoader
//#endif 

  { 

//#if -1953321395 
private Class clazz;
//#endif 


//#if -528150771 
private static final Logger LOG = Logger
                                      .getLogger(ResourceModelLoader.class);
//#endif 


//#if 1090105286 
public ResourceModelLoader(Class c)
    { 

//#if -958829127 
clazz = c;
//#endif 

} 

//#endif 


//#if -952125839 
public ResourceModelLoader()
    { 

//#if 1055869364 
this.clazz = this.getClass();
//#endif 

} 

//#endif 


//#if -596394796 
public Collection loadModel(ProfileReference reference)
    throws ProfileException
    { 

//#if 59049807 
LOG.info("Loading profile from resource'" + reference.getPath() + "'");
//#endif 


//#if 656851025 
return super.loadModel(clazz.getResource(reference.getPath()),
                               reference.getPublicReference());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

