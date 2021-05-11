// Compilation Unit of /FileModelLoader.java 
 
package org.argouml.profile;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

public class FileModelLoader extends URLModelLoader
  { 

//#if LOGGING 
private static final Logger LOG = Logger.getLogger(FileModelLoader.class);
//#endif 

public Collection loadModel(ProfileReference reference)
    throws ProfileException
    { 

//#if LOGGING 
LOG.info("Loading profile from file'" + reference.getPath() + "'");
//#endif 

try //1
{ 
File modelFile = new File(reference.getPath());
URL url = modelFile.toURI().toURL();
return super.loadModel(url, reference.getPublicReference());
} 
catch (MalformedURLException e) //1
{ 
throw new ProfileException("Model file not found!", e);
} 


} 

 } 


