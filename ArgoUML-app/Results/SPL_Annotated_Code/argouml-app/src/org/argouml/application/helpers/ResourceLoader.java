// Compilation Unit of /ResourceLoader.java 
 
package org.argouml.application.helpers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
class ResourceLoader  { 
private static HashMap<String, Icon> resourceCache =
        new HashMap<String, Icon>();
private static List<String> resourceLocations = new ArrayList<String>();
private static List<String> resourceExtensions = new ArrayList<String>();
public static boolean containsExtension(String extension)
    { 
return resourceExtensions.contains(extension);
} 

public static ImageIcon lookupIconResource(String resource, String desc,
            ClassLoader loader)
    { 
resource = toJavaIdentifier(resource);
if(isInCache(resource))//1
{ 
return (ImageIcon) resourceCache.get(resource);
} 

ImageIcon res = null;
java.net.URL imgURL = lookupIconUrl(resource, loader);
if(imgURL != null)//1
{ 
res = new ImageIcon(imgURL, desc);
synchronized (resourceCache) //1
{ 
resourceCache.put(resource, res);
} 

} 

return res;
} 

public static void addResourceExtension(String extension)
    { 
if(!containsExtension(extension))//1
{ 
resourceExtensions.add(extension);
} 

} 

public static final String toJavaIdentifier(String s)
    { 
int len = s.length();
int pos = 0;
for (int i = 0; i < len; i++, pos++) //1
{ 
if(!Character.isJavaIdentifierPart(s.charAt(i)))//1
{ 
break;

} 

} 

if(pos == len)//1
{ 
return s;
} 

StringBuffer buf = new StringBuffer(len);
buf.append(s.substring(0, pos));
for (int i = pos + 1; i < len; i++) //1
{ 
char c = s.charAt(i);
if(Character.isJavaIdentifierPart(c))//1
{ 
buf.append(c);
} 

} 

return buf.toString();
} 

public static ImageIcon lookupIconResource(String resource, String desc)
    { 
return lookupIconResource(resource, desc, null);
} 

public static void addResourceLocation(String location)
    { 
if(!containsLocation(location))//1
{ 
resourceLocations.add(location);
} 

} 

public static void removeResourceExtension(String extension)
    { 
for (Iterator iter = resourceExtensions.iterator(); iter.hasNext();) //1
{ 
String ext = (String) iter.next();
if(ext.equals(extension))//1
{ 
resourceExtensions.remove(ext);
break;

} 

} 

} 

public static ImageIcon lookupIconResource(String resource,
            ClassLoader loader)
    { 
return lookupIconResource(resource, resource, loader);
} 

public static ImageIcon lookupIconResource(String resource)
    { 
return lookupIconResource(resource, resource);
} 

static java.net.URL lookupIconUrl(String resource,
                                      ClassLoader loader)
    { 
java.net.URL imgURL = null;
for (Iterator extensions = resourceExtensions.iterator();
                extensions.hasNext();) //1
{ 
String tmpExt = (String) extensions.next();
for (Iterator locations = resourceLocations.iterator();
                    locations.hasNext();) //1
{ 
String imageName =
                    locations.next() + "/" + resource + "." + tmpExt;
if(loader == null)//1
{ 
imgURL = ResourceLoader.class.getResource(imageName);
} 
else
{ 
imgURL = loader.getResource(imageName);
} 

if(imgURL != null)//1
{ 
break;

} 

} 

if(imgURL != null)//1
{ 
break;

} 

} 

return imgURL;
} 

public static boolean isInCache(String resource)
    { 
return resourceCache.containsKey(resource);
} 

public static boolean containsLocation(String location)
    { 
return resourceLocations.contains(location);
} 

public static void removeResourceLocation(String location)
    { 
for (Iterator iter = resourceLocations.iterator(); iter.hasNext();) //1
{ 
String loc = (String) iter.next();
if(loc.equals(location))//1
{ 
resourceLocations.remove(loc);
break;

} 

} 

} 

 } 


