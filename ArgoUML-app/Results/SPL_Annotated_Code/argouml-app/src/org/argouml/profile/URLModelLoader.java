// Compilation Unit of /URLModelLoader.java 
 
package org.argouml.profile;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.argouml.model.Model;
import org.argouml.model.UmlException;
import org.argouml.model.XmiReader;
import org.xml.sax.InputSource;
public class URLModelLoader implements ProfileModelLoader
  { 
public Collection loadModel(final ProfileReference reference)
    throws ProfileException
    { 
return loadModel(reference.getPublicReference(), reference
                         .getPublicReference());
} 

public Collection loadModel(URL url, URL publicId)
    throws ProfileException
    { 
if(url == null)//1
{ 
throw new ProfileException("Null profile URL");
} 

ZipInputStream zis = null;
try //1
{ 
Collection elements = null;
XmiReader xmiReader = Model.getXmiReader();
if(url.getPath().toLowerCase().endsWith(".zip"))//1
{ 
zis = new ZipInputStream(url.openStream());
ZipEntry entry = zis.getNextEntry();
if(entry != null)//1
{ 
url = makeZipEntryUrl(url, entry.getName());
} 

zis.close();
} 

InputSource inputSource = new InputSource(url.toExternalForm());
inputSource.setPublicId(publicId.toString());
elements = xmiReader.parse(inputSource, true);
return elements;
} 
catch (UmlException e) //1
{ 
throw new ProfileException("Error loading profile XMI file ", e);
} 

catch (IOException e) //1
{ 
throw new ProfileException("I/O error loading profile XMI ", e);
} 


} 

private URL makeZipEntryUrl(URL url, String entryName)
    throws MalformedURLException
    { 
String entryURL = "jar:" + url + "!/" + entryName;
return new URL(entryURL);
} 

 } 


