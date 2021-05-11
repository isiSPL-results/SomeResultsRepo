
//#if 1398551124 
// Compilation Unit of /StreamModelLoader.java 
 

//#if -1078276846 
package org.argouml.profile;
//#endif 


//#if 899613205 
import java.io.InputStream;
//#endif 


//#if 1522993505 
import java.net.URL;
//#endif 


//#if -89293771 
import java.util.Collection;
//#endif 


//#if -1249725540 
import org.argouml.model.Model;
//#endif 


//#if -1989276394 
import org.argouml.model.UmlException;
//#endif 


//#if 1858768270 
import org.argouml.model.XmiReader;
//#endif 


//#if -1510883805 
import org.xml.sax.InputSource;
//#endif 


//#if 1197705257 
import org.apache.log4j.Logger;
//#endif 


//#if -1975861454 
public abstract class StreamModelLoader implements 
//#if 1743470342 
ProfileModelLoader
//#endif 

  { 

//#if 1921846361 
private static final Logger LOG = Logger.getLogger(StreamModelLoader.class);
//#endif 


//#if 1710570780 
public Collection loadModel(InputStream inputStream, URL publicReference)
    throws ProfileException
    { 

//#if -590920506 
if(inputStream == null)//1
{ 

//#if 90107092 
LOG.error("Profile not found");
//#endif 


//#if 581715729 
throw new ProfileException("Profile not found!");
//#endif 

} 

//#endif 


//#if 21902510 
try //1
{ 

//#if 1104846181 
XmiReader xmiReader = Model.getXmiReader();
//#endif 


//#if -1028243320 
InputSource inputSource = new InputSource(inputStream);
//#endif 


//#if -1289453020 
inputSource.setPublicId(publicReference.toString());
//#endif 


//#if -1017697043 
Collection elements = xmiReader.parse(inputSource, true);
//#endif 


//#if -350270650 
return elements;
//#endif 

} 

//#if 1719393261 
catch (UmlException e) //1
{ 

//#if 849032842 
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

