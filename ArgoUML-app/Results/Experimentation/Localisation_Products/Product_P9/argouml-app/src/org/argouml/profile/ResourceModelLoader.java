package org.argouml.profile;
import java.util.Collection;
import org.apache.log4j.Logger;
public class ResourceModelLoader extends URLModelLoader
  { 
private Class clazz;
private static final Logger LOG = Logger
                                      .getLogger(ResourceModelLoader.class);
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
LOG.info("Loading profile from resource'" + reference.getPath() + "'");
return super.loadModel(clazz.getResource(reference.getPath()),
                               reference.getPublicReference());
} 

 } 
