package org.argouml.application.helpers;
public class ApplicationVersion  { 
private static String version;
private static String stableVersion;
public static String getOnlineSupport()
    { 
return "http://argouml.tigris.org/nonav/support.html";
} 
public static void init(String v, String sv)
    { 
assert version == null;
version = v;
assert stableVersion == null;
stableVersion = sv;
} 
public static String getOnlineManual()
    { 
return "http://argouml-stats.tigris.org/nonav/documentation/"
               + "manual-" + stableVersion + "/";
} 
private ApplicationVersion()
    { 
} 
public static String getVersion()
    { 
return version;
} 

 } 
