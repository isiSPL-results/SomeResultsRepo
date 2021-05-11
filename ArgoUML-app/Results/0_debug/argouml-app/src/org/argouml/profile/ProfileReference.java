
//#if 459911179 
// Compilation Unit of /ProfileReference.java 
 

//#if 1809439427 
package org.argouml.profile;
//#endif 


//#if -112968468 
import java.io.File;
//#endif 


//#if 1707300882 
import java.net.URL;
//#endif 


//#if -1501918401 
public class ProfileReference  { 

//#if -1909767575 
private String path;
//#endif 


//#if -185881665 
private URL url;
//#endif 


//#if 1834765883 
public String getPath()
    { 

//#if 1984128195 
return path;
//#endif 

} 

//#endif 


//#if 1226647276 
public URL getPublicReference()
    { 

//#if 2100875930 
return url;
//#endif 

} 

//#endif 


//#if -831392455 
public ProfileReference(String thePath, URL publicReference)
    { 

//#if 119817131 
File file = new File(thePath);
//#endif 


//#if 348148389 
File fileFromPublicReference = new File(publicReference.getPath());
//#endif 


//#if 63783781 
assert file.getName().equals(fileFromPublicReference.getName())
        : "File name in path and in publicReference are different.";
//#endif 


//#if -173078327 
path = thePath;
//#endif 


//#if -2015692933 
url = publicReference;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

