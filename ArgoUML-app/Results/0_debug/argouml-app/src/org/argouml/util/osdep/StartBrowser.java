
//#if 1203735142 
// Compilation Unit of /StartBrowser.java 
 

//#if -980893037 
package org.argouml.util.osdep;
//#endif 


//#if 67102221 
import java.io.IOException;
//#endif 


//#if 376960598 
import java.lang.reflect.Method;
//#endif 


//#if -537924822 
import java.net.URL;
//#endif 


//#if -1508974912 
import org.apache.log4j.Logger;
//#endif 


//#if -895143525 
public class StartBrowser  { 

//#if 1947890757 
private static final Logger LOG = Logger.getLogger(StartBrowser.class);
//#endif 


//#if 663831496 
public static void openUrl(String url)
    { 

//#if -889991656 
try //1
{ 

//#if 210884725 
if(OsUtil.isWin32())//1
{ 

//#if -326159316 
Runtime.getRuntime().exec(
                    "rundll32 url.dll,FileProtocolHandler " + url);
//#endif 

} 
else

//#if -1232951686 
if(OsUtil.isMac())//1
{ 

//#if 1261002445 
try //1
{ 

//#if -295076904 
ClassLoader cl = ClassLoader.getSystemClassLoader();
//#endif 


//#if -1665145967 
Class c = cl.loadClass("com.apple.mrj.MRJFileUtils");
//#endif 


//#if 1058283908 
Class[] argtypes = {
                        String.class,
                    };
//#endif 


//#if -1284144961 
Method m = c.getMethod("openURL", argtypes);
//#endif 


//#if 1067730535 
Object[] args = {
                        url,
                    };
//#endif 


//#if -594347057 
m.invoke(c.newInstance(), args);
//#endif 

} 

//#if 1761501749 
catch (Exception cnfe) //1
{ 

//#if 62111088 
LOG.error(cnfe);
//#endif 


//#if -319768105 
LOG.info("Trying a default browser (netscape)");
//#endif 


//#if 513876917 
String[] commline = {
                        "netscape", url,
                    };
//#endif 


//#if 1698470782 
Runtime.getRuntime().exec(commline);
//#endif 

} 

//#endif 


//#endif 

} 
else
{ 

//#if 658535450 
Runtime.getRuntime().exec("firefox " + url);
//#endif 

} 

//#endif 


//#endif 

} 

//#if -549848771 
catch (IOException ioe) //1
{ 

//#if -478556721 
LOG.error(ioe);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -51979252 
public static void openUrl(URL url)
    { 

//#if 1858577140 
openUrl(url.toString());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

