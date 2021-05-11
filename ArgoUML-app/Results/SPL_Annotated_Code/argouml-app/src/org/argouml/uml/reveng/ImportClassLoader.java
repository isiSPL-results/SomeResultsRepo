// Compilation Unit of /ImportClassLoader.java 
 
package org.argouml.uml.reveng;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.net.URLClassLoader;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.File;
import org.apache.log4j.Logger;
import org.argouml.application.api.Argo;
import org.argouml.configuration.Configuration;
public final class ImportClassLoader extends URLClassLoader
  { 
private static final Logger LOG = Logger.getLogger(ImportClassLoader.class);
private static ImportClassLoader instance;
private ImportClassLoader(URL[] urls)
    { 
super(urls);
} 

public void loadUserPath()
    { 
setPath(Configuration.getString(Argo.KEY_USER_IMPORT_CLASSPATH, ""));
} 

public void setPath(String path)
    { 
StringTokenizer st = new StringTokenizer(path, ";");
st.countTokens();
while (st.hasMoreTokens()) //1
{ 
String token = st.nextToken();
try //1
{ 
this.addFile(new File(token));
} 
catch (MalformedURLException e) //1
{ 
LOG.warn("could not set path ", e);
} 


} 

} 

public void setPath(Object[] paths)
    { 
for (int i = 0; i < paths.length; i++) //1
{ 
try //1
{ 
this.addFile(new File(paths[i].toString()));
} 
catch (Exception e) //1
{ 
LOG.warn("could not set path ", e);
} 


} 

} 

public static URL[] getURLs(String path)
    { 
java.util.List<URL> urlList = new ArrayList<URL>();
StringTokenizer st = new StringTokenizer(path, ";");
while (st.hasMoreTokens()) //1
{ 
String token = st.nextToken();
try //1
{ 
urlList.add(new File(token).toURI().toURL());
} 
catch (MalformedURLException e) //1
{ 
LOG.error(e);
} 


} 

URL[] urls = new URL[urlList.size()];
for (int i = 0; i < urls.length; i++) //1
{ 
urls[i] = urlList.get(i);
} 

return urls;
} 

@Override
    public String toString()
    { 
URL[] urls = this.getURLs();
StringBuilder path = new StringBuilder();
for (int i = 0; i < urls.length; i++) //1
{ 
path.append(urls[i].getFile());
if(i < urls.length - 1)//1
{ 
path.append(";");
} 

} 

return path.toString();
} 

public static ImportClassLoader getInstance()
    throws MalformedURLException
    { 
if(instance == null)//1
{ 
String path =
                Configuration.getString(Argo.KEY_USER_IMPORT_CLASSPATH,
                                        System.getProperty("user.dir"));
return getInstance(getURLs(path));
} 
else
{ 
return instance;
} 

} 

public void saveUserPath()
    { 
Configuration.setString(Argo.KEY_USER_IMPORT_CLASSPATH,
                                this.toString());
} 

public static ImportClassLoader getInstance(URL[] urls)
    throws MalformedURLException
    { 
instance = new ImportClassLoader(urls);
return instance;
} 

public void removeFile(File f)
    { 
URL url = null;
try //1
{ 
url = f.toURI().toURL();
} 
catch (MalformedURLException e) //1
{ 
LOG.warn("could not remove file ", e);
return;
} 


List<URL> urls = new ArrayList<URL>();
for (URL u : getURLs()) //1
{ 
if(!url.equals(u))//1
{ 
urls.add(u);
} 

} 

if(urls.size() == 0)//1
{ 
return;
} 

instance = new ImportClassLoader((URL[]) urls.toArray());
} 

public void addFile(File f) throws MalformedURLException
    { 
addURL(f.toURI().toURL());
} 

 } 


