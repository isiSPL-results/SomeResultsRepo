
//#if -1306491077 
// Compilation Unit of /JavaRuntimeUtility.java 
 

//#if -339170065 
package org.argouml.util;
//#endif 


//#if -1997738996 
public class JavaRuntimeUtility  { 

//#if 927132992 
public static boolean isJreSupported()
    { 

//#if -1971981735 
String javaVersion = System.getProperty("java.version", "");
//#endif 


//#if -1813870031 
return (!(javaVersion.startsWith("1.4")
                  || javaVersion.startsWith("1.3")
                  || javaVersion.startsWith("1.2")
                  || javaVersion.startsWith("1.1")));
//#endif 

} 

//#endif 


//#if 1716103389 
public static String getJreVersion()
    { 

//#if 1226758277 
return System.getProperty("java.version", "");
//#endif 

} 

//#endif 


//#if -877564889 
public static boolean isJre5()
    { 

//#if 1418708387 
String javaVersion = System.getProperty("java.version", "");
//#endif 


//#if -1638721811 
return (javaVersion.startsWith("1.5"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

