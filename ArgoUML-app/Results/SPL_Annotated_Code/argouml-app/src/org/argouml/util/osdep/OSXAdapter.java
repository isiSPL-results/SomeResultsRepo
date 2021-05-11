// Compilation Unit of /OSXAdapter.java 
 
package org.argouml.util.osdep;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.log4j.Logger;
public class OSXAdapter implements InvocationHandler
  { 
private static final Logger LOG = Logger.getLogger(OSXAdapter.class);
protected Object targetObject;
protected Method targetMethod;
protected String proxySignature;
static Object macOSXApplication;
public boolean callTarget(Object appleEvent)
    throws InvocationTargetException, IllegalAccessException
    { 
Object result = targetMethod.invoke(targetObject, (Object[])null);
if(result == null)//1
{ 
return true;
} 

return Boolean.valueOf(result.toString()).booleanValue();
} 

protected OSXAdapter(String proxySignature, Object target, Method handler)
    { 
this.proxySignature = proxySignature;
this.targetObject = target;
this.targetMethod = handler;
} 

public static void setPreferencesHandler(Object target, Method prefsHandler)
    { 
boolean enablePrefsMenu = (target != null && prefsHandler != null);
if(enablePrefsMenu)//1
{ 
setHandler(new OSXAdapter("handlePreferences", target, prefsHandler));
} 

try //1
{ 
Method enablePrefsMethod = macOSXApplication.getClass().getDeclaredMethod("setEnabledPreferencesMenu", new Class[] { boolean.class });
enablePrefsMethod.invoke(macOSXApplication, new Object[] { Boolean.valueOf(enablePrefsMenu) });
} 
catch (Exception ex) //1
{ 
LOG.error("OSXAdapter could not access the About Menu");
ex.printStackTrace();
} 


} 

public static void setHandler(OSXAdapter adapter)
    { 
try //1
{ 
Class applicationClass = Class.forName("com.apple.eawt.Application");
if(macOSXApplication == null)//1
{ 
macOSXApplication = applicationClass.getConstructor((Class[])null).newInstance((Object[])null);
} 

Class applicationListenerClass = Class.forName("com.apple.eawt.ApplicationListener");
Method addListenerMethod = applicationClass.getDeclaredMethod("addApplicationListener", new Class[] { applicationListenerClass });
Object osxAdapterProxy = Proxy.newProxyInstance(OSXAdapter.class.getClassLoader(), new Class[] { applicationListenerClass }, adapter);
addListenerMethod.invoke(macOSXApplication, new Object[] { osxAdapterProxy });
} 
catch (ClassNotFoundException cnfe) //1
{ 
LOG.error("This version of Mac OS X does not support the Apple EAWT.  ApplicationEvent handling has been disabled (" + cnfe + ")");
} 

catch (Exception ex) //1
{ 
LOG.error("Mac OS X Adapter could not talk to EAWT:");
ex.printStackTrace();
} 


} 

public static void setFileHandler(Object target, Method fileHandler)
    { 
setHandler(new OSXAdapter("handleOpenFile", target, fileHandler) {
            // Override OSXAdapter.callTarget to send information on the
            // file to be opened
            public boolean callTarget(Object appleEvent) {
                if (appleEvent != null) {
                    try {
                        Method getFilenameMethod = appleEvent.getClass().getDeclaredMethod("getFilename", (Class[])null);
                        String filename = (String) getFilenameMethod.invoke(appleEvent, (Object[])null);
                        this.targetMethod.invoke(this.targetObject, new Object[] { filename });
                    } catch (Exception ex) {

                    }
                }
                return true;
            }
        });
} 

public static void setQuitHandler(Object target, Method quitHandler)
    { 
setHandler(new OSXAdapter("handleQuit", target, quitHandler));
} 

protected void setApplicationEventHandled(Object event, boolean handled)
    { 
if(event != null)//1
{ 
try //1
{ 
Method setHandledMethod = event.getClass().getDeclaredMethod("setHandled", new Class[] { boolean.class });
setHandledMethod.invoke(event, new Object[] { Boolean.valueOf(handled) });
} 
catch (Exception ex) //1
{ 
LOG.error("OSXAdapter was unable to handle an ApplicationEvent: " + event, ex);
} 


} 

} 

public static void setAboutHandler(Object target, Method aboutHandler)
    { 
boolean enableAboutMenu = (target != null && aboutHandler != null);
if(enableAboutMenu)//1
{ 
setHandler(new OSXAdapter("handleAbout", target, aboutHandler));
} 

try //1
{ 
Method enableAboutMethod = macOSXApplication.getClass().getDeclaredMethod("setEnabledAboutMenu", new Class[] { boolean.class });
enableAboutMethod.invoke(macOSXApplication, new Object[] { Boolean.valueOf(enableAboutMenu) });
} 
catch (Exception ex) //1
{ 
LOG.error("OSXAdapter could not access the About Menu", ex);
} 


} 

protected boolean isCorrectMethod(Method method, Object[] args)
    { 
return (targetMethod != null && proxySignature.equals(method.getName()) && args.length == 1);
} 

public Object invoke (Object proxy, Method method, Object[] args) throws Throwable
    { 
if(isCorrectMethod(method, args))//1
{ 
boolean handled = callTarget(args[0]);
setApplicationEventHandled(args[0], handled);
} 

return null;
} 

 } 


