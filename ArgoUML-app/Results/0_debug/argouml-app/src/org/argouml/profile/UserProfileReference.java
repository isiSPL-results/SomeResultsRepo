
//#if -788123389 
// Compilation Unit of /UserProfileReference.java 
 

//#if 577722569 
package org.argouml.profile;
//#endif 


//#if 1097015538 
import java.io.File;
//#endif 


//#if -572227316 
import java.net.MalformedURLException;
//#endif 


//#if -1377682408 
import java.net.URL;
//#endif 


//#if 1061599664 
public class UserProfileReference extends 
//#if 130099867 
ProfileReference
//#endif 

  { 

//#if -1015345990 
static final String DEFAULT_USER_PROFILE_BASE_URL =
        "http://argouml.org/user-profiles/";
//#endif 


//#if 2038063574 
public UserProfileReference(String thePath, URL publicReference)
    { 

//#if -234208614 
super(thePath, publicReference);
//#endif 

} 

//#endif 


//#if -22837804 
public UserProfileReference(String path) throws MalformedURLException
    { 

//#if -8498470 
super(path,
              new URL(DEFAULT_USER_PROFILE_BASE_URL + new File(path).getName()));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

