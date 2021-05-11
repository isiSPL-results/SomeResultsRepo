// Compilation Unit of /ResourceModelLoader.java 
 
package org.argouml.profile;
import java.util.Collection;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

public class ResourceModelLoader extends URLModelLoader
  { 
private Class clazz;

//#if LOGGING 
private static final Logger LOG = Logger
                                      .getLogger(ResourceModelLoader.class);
//#endif 

public ResourceModelLoader(Class c)
    { 
clazz = c;
} 

public ResourceModelLoader()
    { 
this.clazz = this.getClass();
} 

public Collection loadModel(ProfileReference reference)
    throws ProfileException
    { 

//#if LOGGING 
LOG.info("Loading profile from resource'" + reference.getPath() + "'");
//#endif 

return super.loadModel(clazz.getResource(reference.getPath()),
                               reference.getPublicReference());
} 

 } 


