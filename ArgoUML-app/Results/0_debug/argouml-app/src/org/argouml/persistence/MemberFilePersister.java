
//#if 1818591857 
// Compilation Unit of /MemberFilePersister.java 
 

//#if -97800412 
package org.argouml.persistence;
//#endif 


//#if -1262492355 
import java.io.BufferedReader;
//#endif 


//#if 1379092099 
import java.io.File;
//#endif 


//#if -242861463 
import java.io.FileInputStream;
//#endif 


//#if 1584279155 
import java.io.FileNotFoundException;
//#endif 


//#if -1167986002 
import java.io.IOException;
//#endif 


//#if 1108691149 
import java.io.InputStream;
//#endif 


//#if 770403018 
import java.io.InputStreamReader;
//#endif 


//#if -2040187714 
import java.io.OutputStream;
//#endif 


//#if -547765769 
import java.io.PrintWriter;
//#endif 


//#if 620655980 
import java.io.Writer;
//#endif 


//#if -1095605847 
import java.net.URL;
//#endif 


//#if -733926029 
import org.argouml.application.api.Argo;
//#endif 


//#if 1114490934 
import org.argouml.kernel.Project;
//#endif 


//#if 1849688188 
import org.argouml.kernel.ProjectMember;
//#endif 


//#if -869232592 
abstract class MemberFilePersister  { 

//#if 560692515 
public abstract void load(Project project, URL url)
    throws OpenException;
//#endif 


//#if 773677619 
public abstract String getMainTag();
//#endif 


//#if -1224856163 
public abstract void save(
        ProjectMember member,
        OutputStream stream) throws SaveException;
//#endif 


//#if 1084175683 
public abstract void load(Project project, InputStream inputStream)
    throws OpenException;
//#endif 


//#if -1968821058 
protected void addXmlFileToWriter(PrintWriter writer, File file)
    throws SaveException
    { 

//#if 397453117 
try //1
{ 

//#if -1087986798 
BufferedReader reader =
                new BufferedReader(
                new InputStreamReader(
                    new FileInputStream(file),
                    Argo.getEncoding()));
//#endif 


//#if 1494285269 
String line = reader.readLine();
//#endif 


//#if -1518605082 
while (line != null && (line.startsWith("<?xml ")
                                    || line.startsWith("<!DOCTYPE "))) //1
{ 

//#if 1772311570 
line = reader.readLine();
//#endif 

} 

//#endif 


//#if 742846910 
while (line != null) //1
{ 

//#if 2030654211 
(writer).println(line);
//#endif 


//#if -2014581294 
line = reader.readLine();
//#endif 

} 

//#endif 


//#if -677841403 
reader.close();
//#endif 

} 

//#if -2115296532 
catch (FileNotFoundException e) //1
{ 

//#if -1609241325 
throw new SaveException(e);
//#endif 

} 

//#endif 


//#if 1619324519 
catch (IOException e) //1
{ 

//#if -1705749738 
throw new SaveException(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

