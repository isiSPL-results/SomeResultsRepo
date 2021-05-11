
//#if -1691685757 
// Compilation Unit of /ResourceLoader.java 
 

//#if 430532679 
package org.argouml.application.helpers;
//#endif 


//#if -1634586087 
import java.util.ArrayList;
//#endif 


//#if 1139738466 
import java.util.HashMap;
//#endif 


//#if -1316463272 
import java.util.Iterator;
//#endif 


//#if 1074288808 
import java.util.List;
//#endif 


//#if 1590741189 
import javax.swing.Icon;
//#endif 


//#if -226092476 
import javax.swing.ImageIcon;
//#endif 


//#if 64876201 
class ResourceLoader  { 

//#if 1676063258 
private static HashMap<String, Icon> resourceCache =
        new HashMap<String, Icon>();
//#endif 


//#if -873420353 
private static List<String> resourceLocations = new ArrayList<String>();
//#endif 


//#if -270466147 
private static List<String> resourceExtensions = new ArrayList<String>();
//#endif 


//#if -708766022 
public static boolean containsExtension(String extension)
    { 

//#if -1369233605 
return resourceExtensions.contains(extension);
//#endif 

} 

//#endif 


//#if 2103758540 
public static ImageIcon lookupIconResource(String resource, String desc,
            ClassLoader loader)
    { 

//#if -1819612236 
resource = toJavaIdentifier(resource);
//#endif 


//#if 68368164 
if(isInCache(resource))//1
{ 

//#if -1804522665 
return (ImageIcon) resourceCache.get(resource);
//#endif 

} 

//#endif 


//#if -626723548 
ImageIcon res = null;
//#endif 


//#if 173898105 
java.net.URL imgURL = lookupIconUrl(resource, loader);
//#endif 


//#if 1137325921 
if(imgURL != null)//1
{ 

//#if -1341820577 
res = new ImageIcon(imgURL, desc);
//#endif 


//#if 969333115 
synchronized (resourceCache) //1
{ 

//#if 920700696 
resourceCache.put(resource, res);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1707496108 
return res;
//#endif 

} 

//#endif 


//#if 1745800494 
public static void addResourceExtension(String extension)
    { 

//#if 1028285032 
if(!containsExtension(extension))//1
{ 

//#if -283900890 
resourceExtensions.add(extension);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -891056653 
public static final String toJavaIdentifier(String s)
    { 

//#if -720908087 
int len = s.length();
//#endif 


//#if 1273089436 
int pos = 0;
//#endif 


//#if -637268040 
for (int i = 0; i < len; i++, pos++) //1
{ 

//#if -63434888 
if(!Character.isJavaIdentifierPart(s.charAt(i)))//1
{ 

//#if -1409437789 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if -200837683 
if(pos == len)//1
{ 

//#if -1606781447 
return s;
//#endif 

} 

//#endif 


//#if 208574510 
StringBuffer buf = new StringBuffer(len);
//#endif 


//#if -864166943 
buf.append(s.substring(0, pos));
//#endif 


//#if 1787007802 
for (int i = pos + 1; i < len; i++) //1
{ 

//#if 1985404892 
char c = s.charAt(i);
//#endif 


//#if 1688937651 
if(Character.isJavaIdentifierPart(c))//1
{ 

//#if -996935205 
buf.append(c);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1825984900 
return buf.toString();
//#endif 

} 

//#endif 


//#if 1561014398 
public static ImageIcon lookupIconResource(String resource, String desc)
    { 

//#if 354024891 
return lookupIconResource(resource, desc, null);
//#endif 

} 

//#endif 


//#if 476101050 
public static void addResourceLocation(String location)
    { 

//#if 1649394184 
if(!containsLocation(location))//1
{ 

//#if -1369862066 
resourceLocations.add(location);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 294830971 
public static void removeResourceExtension(String extension)
    { 

//#if 369882549 
for (Iterator iter = resourceExtensions.iterator(); iter.hasNext();) //1
{ 

//#if -1256142727 
String ext = (String) iter.next();
//#endif 


//#if 581853870 
if(ext.equals(extension))//1
{ 

//#if -2016328751 
resourceExtensions.remove(ext);
//#endif 


//#if -1958961242 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -782456236 
public static ImageIcon lookupIconResource(String resource,
            ClassLoader loader)
    { 

//#if 1140831108 
return lookupIconResource(resource, resource, loader);
//#endif 

} 

//#endif 


//#if -225419770 
public static ImageIcon lookupIconResource(String resource)
    { 

//#if -774801282 
return lookupIconResource(resource, resource);
//#endif 

} 

//#endif 


//#if -1786735630 
static java.net.URL lookupIconUrl(String resource,
                                      ClassLoader loader)
    { 

//#if 1124598643 
java.net.URL imgURL = null;
//#endif 


//#if 185839057 
for (Iterator extensions = resourceExtensions.iterator();
                extensions.hasNext();) //1
{ 

//#if 1018533903 
String tmpExt = (String) extensions.next();
//#endif 


//#if 1811035063 
for (Iterator locations = resourceLocations.iterator();
                    locations.hasNext();) //1
{ 

//#if -1180595192 
String imageName =
                    locations.next() + "/" + resource + "." + tmpExt;
//#endif 


//#if 1593874081 
if(loader == null)//1
{ 

//#if -2095748548 
imgURL = ResourceLoader.class.getResource(imageName);
//#endif 

} 
else
{ 

//#if 191916191 
imgURL = loader.getResource(imageName);
//#endif 

} 

//#endif 


//#if -202419562 
if(imgURL != null)//1
{ 

//#if 342550863 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 613751666 
if(imgURL != null)//1
{ 

//#if -884905117 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1586516225 
return imgURL;
//#endif 

} 

//#endif 


//#if 1508857822 
public static boolean isInCache(String resource)
    { 

//#if -1137009341 
return resourceCache.containsKey(resource);
//#endif 

} 

//#endif 


//#if 1894774342 
public static boolean containsLocation(String location)
    { 

//#if 143246382 
return resourceLocations.contains(location);
//#endif 

} 

//#endif 


//#if -1760043193 
public static void removeResourceLocation(String location)
    { 

//#if -1499898591 
for (Iterator iter = resourceLocations.iterator(); iter.hasNext();) //1
{ 

//#if 297255126 
String loc = (String) iter.next();
//#endif 


//#if 140531301 
if(loc.equals(location))//1
{ 

//#if -2052725580 
resourceLocations.remove(loc);
//#endif 


//#if -2092048700 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

