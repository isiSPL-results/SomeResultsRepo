
//#if -1126626702 
// Compilation Unit of /OSXAdapter.java 
 

//#if -425639223 
package org.argouml.util.osdep;
//#endif 


//#if 1798762939 
import java.lang.reflect.InvocationHandler;
//#endif 


//#if 756464583 
import java.lang.reflect.InvocationTargetException;
//#endif 


//#if 409959648 
import java.lang.reflect.Method;
//#endif 


//#if 249531751 
import java.lang.reflect.Proxy;
//#endif 


//#if -953721098 
import org.apache.log4j.Logger;
//#endif 


//#if -58569958 
public class OSXAdapter implements 
//#if 342094726 
InvocationHandler
//#endif 

  { 

//#if 1788872373 
private static final Logger LOG = Logger.getLogger(OSXAdapter.class);
//#endif 


//#if -711875566 
protected Object targetObject;
//#endif 


//#if 127382606 
protected Method targetMethod;
//#endif 


//#if 235028678 
protected String proxySignature;
//#endif 


//#if 1568825169 
static Object macOSXApplication;
//#endif 


//#if -1289658948 
public boolean callTarget(Object appleEvent)
    throws InvocationTargetException, IllegalAccessException
    { 

//#if 623829028 
Object result = targetMethod.invoke(targetObject, (Object[])null);
//#endif 


//#if -288523341 
if(result == null)//1
{ 

//#if -907466252 
return true;
//#endif 

} 

//#endif 


//#if 522927112 
return Boolean.valueOf(result.toString()).booleanValue();
//#endif 

} 

//#endif 


//#if 1963155614 
protected OSXAdapter(String proxySignature, Object target, Method handler)
    { 

//#if -479292259 
this.proxySignature = proxySignature;
//#endif 


//#if 1804403164 
this.targetObject = target;
//#endif 


//#if 817986557 
this.targetMethod = handler;
//#endif 

} 

//#endif 


//#if -2006877339 
public static void setPreferencesHandler(Object target, Method prefsHandler)
    { 

//#if -1642539212 
boolean enablePrefsMenu = (target != null && prefsHandler != null);
//#endif 


//#if 1929595531 
if(enablePrefsMenu)//1
{ 

//#if -682131516 
setHandler(new OSXAdapter("handlePreferences", target, prefsHandler));
//#endif 

} 

//#endif 


//#if -377818024 
try //1
{ 

//#if -890785957 
Method enablePrefsMethod = macOSXApplication.getClass().getDeclaredMethod("setEnabledPreferencesMenu", new Class[] { boolean.class });
//#endif 


//#if -551648051 
enablePrefsMethod.invoke(macOSXApplication, new Object[] { Boolean.valueOf(enablePrefsMenu) });
//#endif 

} 

//#if -1523743068 
catch (Exception ex) //1
{ 

//#if -734011689 
LOG.error("OSXAdapter could not access the About Menu");
//#endif 


//#if 1052639108 
ex.printStackTrace();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -799965482 
public static void setHandler(OSXAdapter adapter)
    { 

//#if 1852223489 
try //1
{ 

//#if -950215824 
Class applicationClass = Class.forName("com.apple.eawt.Application");
//#endif 


//#if 406756898 
if(macOSXApplication == null)//1
{ 

//#if 1181915071 
macOSXApplication = applicationClass.getConstructor((Class[])null).newInstance((Object[])null);
//#endif 

} 

//#endif 


//#if 1935954672 
Class applicationListenerClass = Class.forName("com.apple.eawt.ApplicationListener");
//#endif 


//#if 1408165703 
Method addListenerMethod = applicationClass.getDeclaredMethod("addApplicationListener", new Class[] { applicationListenerClass });
//#endif 


//#if 1643813587 
Object osxAdapterProxy = Proxy.newProxyInstance(OSXAdapter.class.getClassLoader(), new Class[] { applicationListenerClass }, adapter);
//#endif 


//#if 1815558556 
addListenerMethod.invoke(macOSXApplication, new Object[] { osxAdapterProxy });
//#endif 

} 

//#if 1861181837 
catch (ClassNotFoundException cnfe) //1
{ 

//#if 787484822 
LOG.error("This version of Mac OS X does not support the Apple EAWT.  ApplicationEvent handling has been disabled (" + cnfe + ")");
//#endif 

} 

//#endif 


//#if 1481177495 
catch (Exception ex) //1
{ 

//#if -638870729 
LOG.error("Mac OS X Adapter could not talk to EAWT:");
//#endif 


//#if -1947510638 
ex.printStackTrace();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1986556581 
public static void setFileHandler(Object target, Method fileHandler)
    { 

//#if -1927330955 
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
//#endif 

} 

//#endif 


//#if 1401361147 
public static void setQuitHandler(Object target, Method quitHandler)
    { 

//#if -1834494923 
setHandler(new OSXAdapter("handleQuit", target, quitHandler));
//#endif 

} 

//#endif 


//#if -768858854 
protected void setApplicationEventHandled(Object event, boolean handled)
    { 

//#if 1534706642 
if(event != null)//1
{ 

//#if -1710517221 
try //1
{ 

//#if -1267689363 
Method setHandledMethod = event.getClass().getDeclaredMethod("setHandled", new Class[] { boolean.class });
//#endif 


//#if -1530525045 
setHandledMethod.invoke(event, new Object[] { Boolean.valueOf(handled) });
//#endif 

} 

//#if -1833537451 
catch (Exception ex) //1
{ 

//#if 164953203 
LOG.error("OSXAdapter was unable to handle an ApplicationEvent: " + event, ex);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 1915982999 
public static void setAboutHandler(Object target, Method aboutHandler)
    { 

//#if 589707629 
boolean enableAboutMenu = (target != null && aboutHandler != null);
//#endif 


//#if 1001672641 
if(enableAboutMenu)//1
{ 

//#if -1838639392 
setHandler(new OSXAdapter("handleAbout", target, aboutHandler));
//#endif 

} 

//#endif 


//#if -137726031 
try //1
{ 

//#if 1260832335 
Method enableAboutMethod = macOSXApplication.getClass().getDeclaredMethod("setEnabledAboutMenu", new Class[] { boolean.class });
//#endif 


//#if 1130856083 
enableAboutMethod.invoke(macOSXApplication, new Object[] { Boolean.valueOf(enableAboutMenu) });
//#endif 

} 

//#if 1969008418 
catch (Exception ex) //1
{ 

//#if 1656632872 
LOG.error("OSXAdapter could not access the About Menu", ex);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1308400854 
protected boolean isCorrectMethod(Method method, Object[] args)
    { 

//#if -1457212731 
return (targetMethod != null && proxySignature.equals(method.getName()) && args.length == 1);
//#endif 

} 

//#endif 


//#if -1494571871 
public Object invoke (Object proxy, Method method, Object[] args) throws Throwable
    { 

//#if 2124377578 
if(isCorrectMethod(method, args))//1
{ 

//#if -500940456 
boolean handled = callTarget(args[0]);
//#endif 


//#if -6202710 
setApplicationEventHandled(args[0], handled);
//#endif 

} 

//#endif 


//#if -1922435117 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

