
//#if -1479291091 
// Compilation Unit of /ReaderModelLoader.java 
 

//#if -1271456955 
package org.argouml.profile;
//#endif 


//#if 1375049031 
import java.io.Reader;
//#endif 


//#if -282473880 
import java.util.Collection;
//#endif 


//#if -1022176119 
import org.argouml.model.Model;
//#endif 


//#if 1794144137 
import org.argouml.model.UmlException;
//#endif 


//#if 72773627 
import org.argouml.model.XmiReader;
//#endif 


//#if -1283334384 
import org.xml.sax.InputSource;
//#endif 


//#if 1425254678 
import org.apache.log4j.Logger;
//#endif 


//#if -869959782 
public class ReaderModelLoader implements 
//#if 1586246069 
ProfileModelLoader
//#endif 

  { 

//#if -1114615084 
private Reader reader;
//#endif 


//#if 1552729957 
private static final Logger LOG = Logger.getLogger(
                                          ReaderModelLoader.class);
//#endif 


//#if 520307154 
public ReaderModelLoader(Reader theReader)
    { 

//#if -1987490713 
this.reader = theReader;
//#endif 

} 

//#endif 


//#if -1892799295 
public Collection loadModel(ProfileReference reference)
    throws ProfileException
    { 

//#if 492771279 
if(reader == null)//1
{ 

//#if 2034266504 
LOG.error("Profile not found");
//#endif 


//#if 41280453 
throw new ProfileException("Profile not found!");
//#endif 

} 

//#endif 


//#if -1096144252 
try //1
{ 

//#if -1723422298 
XmiReader xmiReader = Model.getXmiReader();
//#endif 


//#if 1989169994 
InputSource inputSource = new InputSource(reader);
//#endif 


//#if 2004579063 
inputSource.setSystemId(reference.getPath());
//#endif 


//#if 328715235 
inputSource.setPublicId(
                reference.getPublicReference().toString());
//#endif 


//#if -1708207540 
Collection elements = xmiReader.parse(inputSource, true);
//#endif 


//#if -2134089755 
return elements;
//#endif 

} 

//#if 1220842142 
catch (UmlException e) //1
{ 

//#if -158640443 
throw new ProfileException("Invalid XMI data!", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

