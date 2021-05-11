// Compilation Unit of /OsUtil.java 
 
package org.argouml.util.osdep;
public class OsUtil  { 
public static boolean isMacOSX()
    { 
return (System.getProperty("os.name").toLowerCase()
                .startsWith("mac os x"));
} 

public static boolean isWin32()
    { 
return (System.getProperty("os.name").indexOf("Windows") != -1);
} 

private OsUtil()
    { 
} 

public static boolean isSunJdk()
    { 
return (System.getProperty("java.vendor")
                .equals("Sun Microsystems Inc."));
} 

public static boolean isMac()
    { 
return (System.getProperty("mrj.version") != null);
} 

 } 


