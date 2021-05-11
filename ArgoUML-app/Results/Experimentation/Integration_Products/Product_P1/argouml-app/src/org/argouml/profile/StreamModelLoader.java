package org.argouml.profile;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import org.argouml.model.Model;
import org.argouml.model.UmlException;
import org.argouml.model.XmiReader;
import org.xml.sax.InputSource;
public abstract class StreamModelLoader implements ProfileModelLoader
  { 
public Collection loadModel(InputStream inputStream, URL publicReference)
    throws ProfileException
    { 
if(inputStream == null)//1
{ 
throw new ProfileException("Profile not found!");
} 
try//1
{ 
XmiReader xmiReader = Model.getXmiReader();
InputSource inputSource = new InputSource(inputStream);
inputSource.setPublicId(publicReference.toString());
Collection elements = xmiReader.parse(inputSource, true);
return elements;
} 
catch (UmlException e) //1
{ 
throw new ProfileException("Invalid XMI data!", e);
} 
} 

 } 
