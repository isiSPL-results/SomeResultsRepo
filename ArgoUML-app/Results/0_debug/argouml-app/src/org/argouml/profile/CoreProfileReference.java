
//#if -1354199418 
// Compilation Unit of /CoreProfileReference.java 
 

//#if -1207905571 
package org.argouml.profile;
//#endif 


//#if 289632800 
import java.net.MalformedURLException;
//#endif 


//#if -490141140 
import java.net.URL;
//#endif 


//#if -1084054120 
public class CoreProfileReference extends 
//#if 1059877322 
ProfileReference
//#endif 

  { 

//#if -368364487 
static final String PROFILES_RESOURCE_PATH =
        "/org/argouml/profile/profiles/uml14/";
//#endif 


//#if -2145094544 
static final String PROFILES_BASE_URL =
        "http://argouml.org/profiles/uml14/";
//#endif 


//#if 658742195 
public CoreProfileReference(String fileName) throws MalformedURLException
    { 

//#if 1390196450 
super(PROFILES_RESOURCE_PATH + fileName,
              new URL(PROFILES_BASE_URL + fileName));
//#endif 


//#if -1998690378 
assert fileName != null
        : "null isn't acceptable as the profile file name.";
//#endif 


//#if 789808888 
assert !"".equals(fileName)
        : "the empty string isn't acceptable as the profile file name.";
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

