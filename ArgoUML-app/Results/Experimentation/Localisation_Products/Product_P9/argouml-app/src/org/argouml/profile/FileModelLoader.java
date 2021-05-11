package org.argouml.profile;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import org.apache.log4j.Logger;
public class FileModelLoader extends URLModelLoader
  { 
private static final Logger LOG = Logger.getLogger(FileModelLoader.class);
public Collection loadModel(ProfileReference reference)
    throws ProfileException
    { 
LOG.info("Loading profile from file'" + reference.getPath() + "'");
try//1
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
