// Compilation Unit of /AbstractProjectMember.java 
 
package org.argouml.kernel;
import org.argouml.persistence.PersistenceManager;
public abstract class AbstractProjectMember implements ProjectMember
  { 
private String uniqueName;
private Project project = null;
public String getZipName()
    { 
if(uniqueName == null)//1
{ 
return null;
} 

String s = PersistenceManager.getInstance().getProjectBaseName(project);
if(uniqueName.length() > 0)//1
{ 
s += "_" + uniqueName;
} 

if(!s.endsWith(getZipFileExtension()))//1
{ 
s += getZipFileExtension();
} 

return s;
} 

public AbstractProjectMember(String theUniqueName, Project theProject)
    { 
project = theProject;
makeUniqueName(theUniqueName);
} 

protected void makeUniqueName(String s)
    { 
uniqueName = s;
if(uniqueName == null)//1
{ 
return;
} 

String pbn =
            PersistenceManager.getInstance().getProjectBaseName(project);
if(uniqueName.startsWith (pbn))//1
{ 
uniqueName = uniqueName.substring (pbn.length());
int i = 0;
for (; i < uniqueName.length(); i++) //1
{ 
if(uniqueName.charAt(i) != '_')//1
{ 
break;

} 

} 

if(i > 0)//1
{ 
uniqueName = uniqueName.substring(i);
} 

} 

if(uniqueName.endsWith(getZipFileExtension()))//1
{ 
uniqueName =
                uniqueName.substring(0,
                                     uniqueName.length() - getZipFileExtension().length());
} 

} 

public String toString()
    { 
return getZipName();
} 

public String getUniqueDiagramName()
    { 
String s = uniqueName;
if(s != null)//1
{ 
if(!s.endsWith (getZipFileExtension()))//1
{ 
s += getZipFileExtension();
} 

} 

return s;
} 

protected void remove()
    { 
uniqueName = null;
project = null;
} 

public abstract String getType();
public String getZipFileExtension()
    { 
return "." + getType();
} 

 } 


