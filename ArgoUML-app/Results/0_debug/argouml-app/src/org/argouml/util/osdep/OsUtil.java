
//#if -456822300 
// Compilation Unit of /OsUtil.java 
 

//#if 600542076 
package org.argouml.util.osdep;
//#endif 


//#if 743547250 
public class OsUtil  { 

//#if 2025014486 
public static boolean isMacOSX()
    { 

//#if 280316213 
return (System.getProperty("os.name").toLowerCase()
                .startsWith("mac os x"));
//#endif 

} 

//#endif 


//#if 1004391852 
public static boolean isWin32()
    { 

//#if 214383958 
return (System.getProperty("os.name").indexOf("Windows") != -1);
//#endif 

} 

//#endif 


//#if -2029032321 
private OsUtil()
    { 
} 

//#endif 


//#if 478006806 
public static boolean isSunJdk()
    { 

//#if 485302184 
return (System.getProperty("java.vendor")
                .equals("Sun Microsystems Inc."));
//#endif 

} 

//#endif 


//#if 585973440 
public static boolean isMac()
    { 

//#if -524241869 
return (System.getProperty("mrj.version") != null);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

