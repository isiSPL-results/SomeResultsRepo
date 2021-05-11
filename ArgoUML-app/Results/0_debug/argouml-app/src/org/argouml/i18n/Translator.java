
//#if 267519772 
// Compilation Unit of /Translator.java 
 

//#if 620784066 
package org.argouml.i18n;
//#endif 


//#if 563855423 
import java.text.MessageFormat;
//#endif 


//#if 896927409 
import java.util.ArrayList;
//#endif 


//#if 2054103546 
import java.util.HashMap;
//#endif 


//#if 1259050432 
import java.util.Iterator;
//#endif 


//#if 864552208 
import java.util.List;
//#endif 


//#if 2062466580 
import java.util.Locale;
//#endif 


//#if 27910732 
import java.util.Map;
//#endif 


//#if -743875917 
import java.util.MissingResourceException;
//#endif 


//#if -459799042 
import java.util.ResourceBundle;
//#endif 


//#if 224104843 
import org.tigris.gef.util.Localizer;
//#endif 


//#if 1506870702 
import org.apache.log4j.Logger;
//#endif 


//#if -575537491 
public final class Translator  { 

//#if -1400678469 
private static final String BUNDLES_PATH = "org.argouml.i18n";
//#endif 


//#if 1463448085 
private static Map<String, ResourceBundle> bundles;
//#endif 


//#if 1126384606 
private static List<ClassLoader> classLoaders =
        new ArrayList<ClassLoader>();
//#endif 


//#if 1896327959 
private static boolean initialized;
//#endif 


//#if -1083122399 
private static Locale systemDefaultLocale;
//#endif 


//#if -1600956753 
private static final Logger LOG = Logger.getLogger(Translator.class);
//#endif 


//#if -1013664017 
public static String localize(String key, Object[] args)
    { 

//#if 1338238277 
return messageFormat(key, args);
//#endif 

} 

//#endif 


//#if -840091728 
public static Locale[] getLocales()
    { 

//#if 1248277804 
return new Locale[] {
                   Locale.ENGLISH,
                   Locale.FRENCH,
                   new Locale("es", ""),
                   Locale.GERMAN,
                   Locale.ITALIAN,
                   new Locale("nb", ""),
                   new Locale("pt", ""),
                   new Locale("ru", ""),
                   Locale.CHINESE,
                   Locale.UK,
               };
//#endif 

} 

//#endif 


//#if -981032059 
public static void setLocale(Locale locale)
    { 

//#if 2140993682 
Locale.setDefault(locale);
//#endif 


//#if -1553515818 
bundles = new HashMap<String, ResourceBundle>();
//#endif 

} 

//#endif 


//#if -905126110 
public static String messageFormat(String key, Object[] args)
    { 

//#if 949568411 
return new MessageFormat(localize(key)).format(args);
//#endif 

} 

//#endif 


//#if -987940054 
public static void init(String locale)
    { 

//#if 1865182396 
initialized = true;
//#endif 


//#if -117998444 
systemDefaultLocale = Locale.getDefault();
//#endif 


//#if 948738781 
if((!"".equals(locale)) && (locale != null))//1
{ 

//#if -760050114 
setLocale(locale);
//#endif 

} 
else
{ 

//#if 1024217577 
setLocale(new Locale(
                          System.getProperty("user.language", "en"),
                          System.getProperty("user.country", "")));
//#endif 

} 

//#endif 


//#if 444291451 
Localizer.addResource("GefBase",
                              "org.tigris.gef.base.BaseResourceBundle");
//#endif 


//#if -558531398 
Localizer.addResource(
            "GefPres",
            "org.tigris.gef.presentation.PresentationResourceBundle");
//#endif 

} 

//#endif 


//#if 91904527 
public static void addClassLoader(ClassLoader cl)
    { 

//#if -1539497063 
classLoaders.add(cl);
//#endif 

} 

//#endif 


//#if -104795199 
public static Locale getSystemDefaultLocale()
    { 

//#if -1793937123 
return systemDefaultLocale;
//#endif 

} 

//#endif 


//#if -255274023 
private static void loadBundle(String name)
    { 

//#if 1485873799 
if(bundles.containsKey(name))//1
{ 

//#if -267071043 
return;
//#endif 

} 

//#endif 


//#if -1086301584 
String resource = BUNDLES_PATH + "." + name;
//#endif 


//#if -397718342 
ResourceBundle bundle = null;
//#endif 


//#if 1270186791 
try //1
{ 

//#if 415214416 
LOG.debug("Loading " + resource);
//#endif 


//#if -1248356074 
Locale locale = Locale.getDefault();
//#endif 


//#if 919025673 
bundle = ResourceBundle.getBundle(resource, locale);
//#endif 

} 

//#if -1035972746 
catch (MissingResourceException e1) //1
{ 

//#if -682228777 
LOG.debug("Resource " + resource
                      + " not found in the default class loader.");
//#endif 


//#if 1708894548 
Iterator iter = classLoaders.iterator();
//#endif 


//#if -816104960 
while (iter.hasNext()) //1
{ 

//#if -514544854 
ClassLoader cl = (ClassLoader) iter.next();
//#endif 


//#if 405907066 
try //1
{ 

//#if 1804943681 
LOG.debug("Loading " + resource + " from " + cl);
//#endif 


//#if -278056890 
bundle =
                        ResourceBundle.getBundle(resource,
                                                 Locale.getDefault(),
                                                 cl);
//#endif 


//#if 394411368 
break;

//#endif 

} 

//#if -1978866842 
catch (MissingResourceException e2) //1
{ 

//#if 1764104399 
LOG.debug("Resource " + resource + " not found in " + cl);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#endif 


//#if 1432534094 
bundles.put(name, bundle);
//#endif 

} 

//#endif 


//#if 1621718792 
public static void initForEclipse (String locale)
    { 

//#if -758137097 
initInternal(locale);
//#endif 

} 

//#endif 


//#if 197716427 
private static String getName(String key)
    { 

//#if -40871991 
if(key == null)//1
{ 

//#if 783928271 
return null;
//#endif 

} 

//#endif 


//#if 498672806 
int indexOfDot = key.indexOf(".");
//#endif 


//#if -1221763169 
if(indexOfDot > 0)//1
{ 

//#if -1928057717 
return key.substring(0, indexOfDot);
//#endif 

} 

//#endif 


//#if -393722146 
return null;
//#endif 

} 

//#endif 


//#if -1671111483 
private Translator()
    { 
} 

//#endif 


//#if -604079335 
public static String localize(String key)
    { 

//#if -686331978 
if(!initialized)//1
{ 

//#if -1584266732 
init("en");
//#endif 

} 

//#endif 


//#if -1826806509 
if(key == null)//1
{ 

//#if 1904605550 
throw new IllegalArgumentException("null");
//#endif 

} 

//#endif 


//#if -146319847 
String name = getName(key);
//#endif 


//#if 1258354261 
if(name == null)//1
{ 

//#if 1887996445 
return Localizer.localize("UMLMenu", key);
//#endif 

} 

//#endif 


//#if -728864755 
loadBundle(name);
//#endif 


//#if -1584743737 
ResourceBundle bundle = bundles.get(name);
//#endif 


//#if -1843414836 
if(bundle == null)//1
{ 

//#if -126433704 
LOG.debug("Bundle (" + name + ") for resource "
                      + key + " not found.");
//#endif 


//#if -1093980486 
return key;
//#endif 

} 

//#endif 


//#if 1941330374 
try //1
{ 

//#if -181165790 
return bundle.getString(key);
//#endif 

} 

//#if 442685408 
catch (MissingResourceException e) //1
{ 

//#if -122539169 
LOG.debug("Resource " + key + " not found.");
//#endif 


//#if -1043776230 
return key;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1591479197 
public static void setLocale(String name)
    { 

//#if 1977800895 
if(!initialized)//1
{ 

//#if 1318762255 
init("en");
//#endif 

} 

//#endif 


//#if -1468866589 
String language = name;
//#endif 


//#if 1047218332 
String country = "";
//#endif 


//#if 722338641 
int i = name.indexOf("_");
//#endif 


//#if -1913136116 
if((i > 0) && (name.length() > i + 1))//1
{ 

//#if -934315173 
language = name.substring(0, i);
//#endif 


//#if -1846383939 
country = name.substring(i + 1);
//#endif 

} 

//#endif 


//#if -1949094088 
setLocale(new Locale(language, country));
//#endif 

} 

//#endif 


//#if 273438934 
private static void initInternal (String s)
    { 

//#if 140886896 
assert !initialized;
//#endif 


//#if -1261895662 
initialized = true;
//#endif 


//#if -1318352770 
systemDefaultLocale = Locale.getDefault();
//#endif 


//#if -294368291 
if((!"".equals(s)) && (s != null))//1
{ 

//#if -1816892840 
setLocale(s);
//#endif 

} 
else
{ 

//#if 1305316416 
setLocale(new Locale(
                          System.getProperty("user.language", "en"),
                          System.getProperty("user.country", "")));
//#endif 

} 

//#endif 


//#if 139193061 
Localizer.addResource("GefBase",
                              "org.tigris.gef.base.BaseResourceBundle");
//#endif 


//#if -912655836 
Localizer.addResource(
            "GefPres",
            "org.tigris.gef.presentation.PresentationResourceBundle");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

