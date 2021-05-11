// Compilation Unit of /ZipModelLoader.java 
 
package org.argouml.profile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

public class ZipModelLoader extends StreamModelLoader
  { 

//#if LOGGING 
private static final Logger LOG = Logger.getLogger(ZipModelLoader.class);
//#endif 

public Collection loadModel(ProfileReference reference)
    throws ProfileException
    { 

//#if LOGGING 
LOG.info("Loading profile from ZIP '" + reference.getPath() + "'");
//#endif 

if(!reference.getPath().endsWith("zip"))//1
{ 
throw new ProfileException("Profile could not be loaded!");
} 

InputStream is = null;
File modelFile = new File(reference.getPath());
String filename = modelFile.getName();
String extension = filename.substring(filename.indexOf('.'),
                                              filename.lastIndexOf('.'));
String path = modelFile.getParent();
if(path != null)//1
{ 
System.setProperty("org.argouml.model.modules_search_path",
                               path);
} 

try //1
{ 
is = openZipStreamAt(modelFile.toURI().toURL(), extension);
} 
catch (MalformedURLException e) //1
{ 

//#if LOGGING 
LOG.error("Exception while loading profile '"
                      + reference.getPath() + "'", e);
//#endif 

throw new ProfileException(e);
} 

catch (IOException e) //1
{ 

//#if LOGGING 
LOG.error("Exception while loading profile '"
                      + reference.getPath() + "'", e);
//#endif 

throw new ProfileException(e);
} 


if(is == null)//1
{ 
throw new ProfileException("Profile could not be loaded!");
} 

return super.loadModel(is, reference.getPublicReference());
} 

private ZipInputStream openZipStreamAt(URL url, String ext)
    throws IOException
    { 
ZipInputStream zis = new ZipInputStream(url.openStream());
ZipEntry entry = zis.getNextEntry();
while (entry != null && !entry.getName().endsWith(ext)) //1
{ 
entry = zis.getNextEntry();
} 

return zis;
} 

 } 


