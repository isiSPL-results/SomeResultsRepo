
//#if 2129400428 
// Compilation Unit of /FileModelLoader.java 
 

//#if -508620183 
package org.argouml.profile;
//#endif 


//#if 507935378 
import java.io.File;
//#endif 


//#if 780186284 
import java.net.MalformedURLException;
//#endif 


//#if -1966762568 
import java.net.URL;
//#endif 


//#if 480362892 
import java.util.Collection;
//#endif 


//#if -1871401102 
import org.apache.log4j.Logger;
//#endif 


//#if -963482147 
public class FileModelLoader extends 
//#if -728557124 
URLModelLoader
//#endif 

  { 

//#if 468239577 
private static final Logger LOG = Logger.getLogger(FileModelLoader.class);
//#endif 


//#if -105539122 
public Collection loadModel(ProfileReference reference)
    throws ProfileException
    { 

//#if 1827495464 
LOG.info("Loading profile from file'" + reference.getPath() + "'");
//#endif 


//#if -1996527028 
try //1
{ 

//#if 1303896311 
File modelFile = new File(reference.getPath());
//#endif 


//#if 1219490324 
URL url = modelFile.toURI().toURL();
//#endif 


//#if -2045092805 
return super.loadModel(url, reference.getPublicReference());
//#endif 

} 

//#if -1411890579 
catch (MalformedURLException e) //1
{ 

//#if 541508599 
throw new ProfileException("Model file not found!", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

