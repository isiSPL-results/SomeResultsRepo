
//#if -1326350336 
// Compilation Unit of /URLModelLoader.java 
 

//#if -1933141830 
package org.argouml.profile;
//#endif 


//#if 535022414 
import java.io.IOException;
//#endif 


//#if -87734339 
import java.net.MalformedURLException;
//#endif 


//#if 2056060169 
import java.net.URL;
//#endif 


//#if -944158755 
import java.util.Collection;
//#endif 


//#if -141486979 
import java.util.zip.ZipEntry;
//#endif 


//#if -589115131 
import java.util.zip.ZipInputStream;
//#endif 


//#if 623601396 
import org.argouml.model.Model;
//#endif 


//#if -728930626 
import org.argouml.model.UmlException;
//#endif 


//#if -1447439130 
import org.argouml.model.XmiReader;
//#endif 


//#if 362443131 
import org.xml.sax.InputSource;
//#endif 


//#if 840452673 
public class URLModelLoader implements 
//#if -1607975960 
ProfileModelLoader
//#endif 

  { 

//#if 808528200 
public Collection loadModel(final ProfileReference reference)
    throws ProfileException
    { 

//#if 1539502742 
return loadModel(reference.getPublicReference(), reference
                         .getPublicReference());
//#endif 

} 

//#endif 


//#if -608500588 
public Collection loadModel(URL url, URL publicId)
    throws ProfileException
    { 

//#if -1629946553 
if(url == null)//1
{ 

//#if -2121309219 
throw new ProfileException("Null profile URL");
//#endif 

} 

//#endif 


//#if -536143138 
ZipInputStream zis = null;
//#endif 


//#if 1646590954 
try //1
{ 

//#if 1999546026 
Collection elements = null;
//#endif 


//#if -606543691 
XmiReader xmiReader = Model.getXmiReader();
//#endif 


//#if -752572113 
if(url.getPath().toLowerCase().endsWith(".zip"))//1
{ 

//#if 1125627997 
zis = new ZipInputStream(url.openStream());
//#endif 


//#if 1263108866 
ZipEntry entry = zis.getNextEntry();
//#endif 


//#if -422799813 
if(entry != null)//1
{ 

//#if -308983012 
url = makeZipEntryUrl(url, entry.getName());
//#endif 

} 

//#endif 


//#if -935910603 
zis.close();
//#endif 

} 

//#endif 


//#if 1042328576 
InputSource inputSource = new InputSource(url.toExternalForm());
//#endif 


//#if -140501184 
inputSource.setPublicId(publicId.toString());
//#endif 


//#if -763954277 
elements = xmiReader.parse(inputSource, true);
//#endif 


//#if -2060161546 
return elements;
//#endif 

} 

//#if -875985262 
catch (UmlException e) //1
{ 

//#if 1148017097 
throw new ProfileException("Error loading profile XMI file ", e);
//#endif 

} 

//#endif 


//#if -2025231612 
catch (IOException e) //1
{ 

//#if 2049583587 
throw new ProfileException("I/O error loading profile XMI ", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 610398558 
private URL makeZipEntryUrl(URL url, String entryName)
    throws MalformedURLException
    { 

//#if 2063369295 
String entryURL = "jar:" + url + "!/" + entryName;
//#endif 


//#if -409179257 
return new URL(entryURL);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

