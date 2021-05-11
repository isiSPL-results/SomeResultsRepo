package org.argouml.profile;
import java.util.Collection;
public class ResourceModelLoader extends URLModelLoader
  { 
private Class clazz;
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
return super.loadModel(clazz.getResource(reference.getPath()),
                               reference.getPublicReference());
} 

 } 
