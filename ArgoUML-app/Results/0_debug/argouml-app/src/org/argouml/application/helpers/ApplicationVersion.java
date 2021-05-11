
//#if -1507370961 
// Compilation Unit of /ApplicationVersion.java 
 

//#if -1694378697 
package org.argouml.application.helpers;
//#endif 


//#if -2107083081 
public class ApplicationVersion  { 

//#if 1047047892 
private static String version;
//#endif 


//#if -715695505 
private static String stableVersion;
//#endif 


//#if 459362400 
public static String getOnlineSupport()
    { 

//#if -2076644719 
return "http://argouml.tigris.org/nonav/support.html";
//#endif 

} 

//#endif 


//#if 694286578 
public static void init(String v, String sv)
    { 

//#if 1870062228 
assert version == null;
//#endif 


//#if 2130991068 
version = v;
//#endif 


//#if -321536849 
assert stableVersion == null;
//#endif 


//#if 22394630 
stableVersion = sv;
//#endif 

} 

//#endif 


//#if -2059737609 
public static String getOnlineManual()
    { 

//#if 1501224877 
return "http://argouml-stats.tigris.org/nonav/documentation/"
               + "manual-" + stableVersion + "/";
//#endif 

} 

//#endif 


//#if 1308312539 
private ApplicationVersion()
    { 
} 

//#endif 


//#if 1106702427 
public static String getManualForCritic()
    { 

//#if 965164131 
return "http://argouml-stats.tigris.org/documentation/"
               + "manual-"
               + stableVersion
               + "-single/argomanual.html#critics.";
//#endif 

} 

//#endif 


//#if 1194507900 
public static String getVersion()
    { 

//#if 2016265191 
return version;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

