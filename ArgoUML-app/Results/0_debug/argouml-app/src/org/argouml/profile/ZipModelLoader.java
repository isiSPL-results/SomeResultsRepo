
//#if -489127322 
// Compilation Unit of /ZipModelLoader.java 
 

//#if -924973520 
package org.argouml.profile;
//#endif 


//#if -124967591 
import java.io.File;
//#endif 


//#if 151901976 
import java.io.IOException;
//#endif 


//#if -1866388169 
import java.io.InputStream;
//#endif 


//#if 1201854899 
import java.net.MalformedURLException;
//#endif 


//#if 1695301759 
import java.net.URL;
//#endif 


//#if 64009555 
import java.util.Collection;
//#endif 


//#if -1954349965 
import java.util.zip.ZipEntry;
//#endif 


//#if -1933023109 
import java.util.zip.ZipInputStream;
//#endif 


//#if -1588112821 
import org.apache.log4j.Logger;
//#endif 


//#if -1861327803 
public class ZipModelLoader extends 
//#if -1836547574 
StreamModelLoader
//#endif 

  { 

//#if -1398790537 
private static final Logger LOG = Logger.getLogger(ZipModelLoader.class);
//#endif 


//#if -1467889935 
public Collection loadModel(ProfileReference reference)
    throws ProfileException
    { 

//#if -901298024 
LOG.info("Loading profile from ZIP '" + reference.getPath() + "'");
//#endif 


//#if -306527808 
if(!reference.getPath().endsWith("zip"))//1
{ 

//#if -1374445984 
throw new ProfileException("Profile could not be loaded!");
//#endif 

} 

//#endif 


//#if 16218718 
InputStream is = null;
//#endif 


//#if 1563639742 
File modelFile = new File(reference.getPath());
//#endif 


//#if 1945124602 
String filename = modelFile.getName();
//#endif 


//#if 789930968 
String extension = filename.substring(filename.indexOf('.'),
                                              filename.lastIndexOf('.'));
//#endif 


//#if -206135587 
String path = modelFile.getParent();
//#endif 


//#if -533156018 
if(path != null)//1
{ 

//#if -2064095870 
System.setProperty("org.argouml.model.modules_search_path",
                               path);
//#endif 

} 

//#endif 


//#if -417112477 
try //1
{ 

//#if -486413422 
is = openZipStreamAt(modelFile.toURI().toURL(), extension);
//#endif 

} 

//#if 61818638 
catch (MalformedURLException e) //1
{ 

//#if -1505720629 
LOG.error("Exception while loading profile '"
                      + reference.getPath() + "'", e);
//#endif 


//#if -888359279 
throw new ProfileException(e);
//#endif 

} 

//#endif 


//#if 462235616 
catch (IOException e) //1
{ 

//#if -797180964 
LOG.error("Exception while loading profile '"
                      + reference.getPath() + "'", e);
//#endif 


//#if -578939296 
throw new ProfileException(e);
//#endif 

} 

//#endif 


//#endif 


//#if -1762736905 
if(is == null)//1
{ 

//#if 726956417 
throw new ProfileException("Profile could not be loaded!");
//#endif 

} 

//#endif 


//#if 639554799 
return super.loadModel(is, reference.getPublicReference());
//#endif 

} 

//#endif 


//#if -577457841 
private ZipInputStream openZipStreamAt(URL url, String ext)
    throws IOException
    { 

//#if -1653554990 
ZipInputStream zis = new ZipInputStream(url.openStream());
//#endif 


//#if 714005622 
ZipEntry entry = zis.getNextEntry();
//#endif 


//#if -1039845286 
while (entry != null && !entry.getName().endsWith(ext)) //1
{ 

//#if -296969212 
entry = zis.getNextEntry();
//#endif 

} 

//#endif 


//#if -1552806052 
return zis;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

