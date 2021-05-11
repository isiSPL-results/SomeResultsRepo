
//#if 1792240546 
// Compilation Unit of /ImportClassLoader.java 
 

//#if 676438283 
package org.argouml.uml.reveng;
//#endif 


//#if 440214641 
import java.util.ArrayList;
//#endif 


//#if -155889840 
import java.util.List;
//#endif 


//#if 1131971874 
import java.util.StringTokenizer;
//#endif 


//#if 1425251439 
import java.net.URLClassLoader;
//#endif 


//#if 1119594300 
import java.net.URL;
//#endif 


//#if 1900997424 
import java.net.MalformedURLException;
//#endif 


//#if -700675050 
import java.io.File;
//#endif 


//#if 642990958 
import org.apache.log4j.Logger;
//#endif 


//#if 1875569542 
import org.argouml.application.api.Argo;
//#endif 


//#if 1910134855 
import org.argouml.configuration.Configuration;
//#endif 


//#if 658383123 
public final class ImportClassLoader extends 
//#if -896442439 
URLClassLoader
//#endif 

  { 

//#if 474467789 
private static final Logger LOG = Logger.getLogger(ImportClassLoader.class);
//#endif 


//#if 188052116 
private static ImportClassLoader instance;
//#endif 


//#if -845333636 
private ImportClassLoader(URL[] urls)
    { 

//#if 459689204 
super(urls);
//#endif 

} 

//#endif 


//#if 1860183665 
public void loadUserPath()
    { 

//#if -1200717808 
setPath(Configuration.getString(Argo.KEY_USER_IMPORT_CLASSPATH, ""));
//#endif 

} 

//#endif 


//#if 1982846456 
public void setPath(String path)
    { 

//#if -169532018 
StringTokenizer st = new StringTokenizer(path, ";");
//#endif 


//#if 1132214092 
st.countTokens();
//#endif 


//#if 228826606 
while (st.hasMoreTokens()) //1
{ 

//#if -1804704458 
String token = st.nextToken();
//#endif 


//#if 219485964 
try //1
{ 

//#if -1030203386 
this.addFile(new File(token));
//#endif 

} 

//#if -2054711489 
catch (MalformedURLException e) //1
{ 

//#if -329519054 
LOG.warn("could not set path ", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 1393886775 
public void setPath(Object[] paths)
    { 

//#if 865806075 
for (int i = 0; i < paths.length; i++) //1
{ 

//#if -935554248 
try //1
{ 

//#if -901906142 
this.addFile(new File(paths[i].toString()));
//#endif 

} 

//#if -545970853 
catch (Exception e) //1
{ 

//#if -1641248428 
LOG.warn("could not set path ", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 2132780520 
public static URL[] getURLs(String path)
    { 

//#if 1103704396 
java.util.List<URL> urlList = new ArrayList<URL>();
//#endif 


//#if 524572425 
StringTokenizer st = new StringTokenizer(path, ";");
//#endif 


//#if 246857811 
while (st.hasMoreTokens()) //1
{ 

//#if 1033294602 
String token = st.nextToken();
//#endif 


//#if 1578446008 
try //1
{ 

//#if 20983028 
urlList.add(new File(token).toURI().toURL());
//#endif 

} 

//#if -400853754 
catch (MalformedURLException e) //1
{ 

//#if -1807629488 
LOG.error(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1784010866 
URL[] urls = new URL[urlList.size()];
//#endif 


//#if 370575067 
for (int i = 0; i < urls.length; i++) //1
{ 

//#if -439301859 
urls[i] = urlList.get(i);
//#endif 

} 

//#endif 


//#if 2101389072 
return urls;
//#endif 

} 

//#endif 


//#if 161623990 
@Override
    public String toString()
    { 

//#if -1994729440 
URL[] urls = this.getURLs();
//#endif 


//#if 809245850 
StringBuilder path = new StringBuilder();
//#endif 


//#if -301812 
for (int i = 0; i < urls.length; i++) //1
{ 

//#if -834207661 
path.append(urls[i].getFile());
//#endif 


//#if -914611384 
if(i < urls.length - 1)//1
{ 

//#if -1729518143 
path.append(";");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 904160189 
return path.toString();
//#endif 

} 

//#endif 


//#if 1397519316 
public static ImportClassLoader getInstance()
    throws MalformedURLException
    { 

//#if -392010600 
if(instance == null)//1
{ 

//#if 339193465 
String path =
                Configuration.getString(Argo.KEY_USER_IMPORT_CLASSPATH,
                                        System.getProperty("user.dir"));
//#endif 


//#if 357843157 
return getInstance(getURLs(path));
//#endif 

} 
else
{ 

//#if -1952937279 
return instance;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -952266168 
public void saveUserPath()
    { 

//#if 1967504618 
Configuration.setString(Argo.KEY_USER_IMPORT_CLASSPATH,
                                this.toString());
//#endif 

} 

//#endif 


//#if -240699733 
public static ImportClassLoader getInstance(URL[] urls)
    throws MalformedURLException
    { 

//#if -324986542 
instance = new ImportClassLoader(urls);
//#endif 


//#if 55235764 
return instance;
//#endif 

} 

//#endif 


//#if 1458520461 
public void removeFile(File f)
    { 

//#if 1757324510 
URL url = null;
//#endif 


//#if 1041565085 
try //1
{ 

//#if -101163550 
url = f.toURI().toURL();
//#endif 

} 

//#if 678691028 
catch (MalformedURLException e) //1
{ 

//#if 2105408897 
LOG.warn("could not remove file ", e);
//#endif 


//#if 1897135803 
return;
//#endif 

} 

//#endif 


//#endif 


//#if 944479641 
List<URL> urls = new ArrayList<URL>();
//#endif 


//#if -2107394027 
for (URL u : getURLs()) //1
{ 

//#if 1181049998 
if(!url.equals(u))//1
{ 

//#if 170745397 
urls.add(u);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 780305328 
if(urls.size() == 0)//1
{ 

//#if 626216978 
return;
//#endif 

} 

//#endif 


//#if -1717839002 
instance = new ImportClassLoader((URL[]) urls.toArray());
//#endif 

} 

//#endif 


//#if 405396970 
public void addFile(File f) throws MalformedURLException
    { 

//#if -116404807 
addURL(f.toURI().toURL());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

