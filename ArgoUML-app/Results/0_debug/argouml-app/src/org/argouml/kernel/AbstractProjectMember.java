
//#if -587163846 
// Compilation Unit of /AbstractProjectMember.java 
 

//#if 1242438638 
package org.argouml.kernel;
//#endif 


//#if 1101927753 
import org.argouml.persistence.PersistenceManager;
//#endif 


//#if -270204169 
public abstract class AbstractProjectMember implements 
//#if 552741495 
ProjectMember
//#endif 

  { 

//#if 107698119 
private String uniqueName;
//#endif 


//#if 427709950 
private Project project = null;
//#endif 


//#if 660188013 
public String getZipName()
    { 

//#if 1298166967 
if(uniqueName == null)//1
{ 

//#if 705017247 
return null;
//#endif 

} 

//#endif 


//#if -1471510870 
String s = PersistenceManager.getInstance().getProjectBaseName(project);
//#endif 


//#if 259616903 
if(uniqueName.length() > 0)//1
{ 

//#if 284404857 
s += "_" + uniqueName;
//#endif 

} 

//#endif 


//#if -1795033742 
if(!s.endsWith(getZipFileExtension()))//1
{ 

//#if -1902468868 
s += getZipFileExtension();
//#endif 

} 

//#endif 


//#if -2059570665 
return s;
//#endif 

} 

//#endif 


//#if -842015980 
public AbstractProjectMember(String theUniqueName, Project theProject)
    { 

//#if -129678095 
project = theProject;
//#endif 


//#if 1191890815 
makeUniqueName(theUniqueName);
//#endif 

} 

//#endif 


//#if -598694305 
protected void makeUniqueName(String s)
    { 

//#if 14329266 
uniqueName = s;
//#endif 


//#if -988048353 
if(uniqueName == null)//1
{ 

//#if 311302470 
return;
//#endif 

} 

//#endif 


//#if -199751525 
String pbn =
            PersistenceManager.getInstance().getProjectBaseName(project);
//#endif 


//#if -231924408 
if(uniqueName.startsWith (pbn))//1
{ 

//#if -1051426193 
uniqueName = uniqueName.substring (pbn.length());
//#endif 


//#if 1816802258 
int i = 0;
//#endif 


//#if 145239612 
for (; i < uniqueName.length(); i++) //1
{ 

//#if -157571971 
if(uniqueName.charAt(i) != '_')//1
{ 

//#if -1618640337 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1471478004 
if(i > 0)//1
{ 

//#if 1180671188 
uniqueName = uniqueName.substring(i);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1873379172 
if(uniqueName.endsWith(getZipFileExtension()))//1
{ 

//#if 614753821 
uniqueName =
                uniqueName.substring(0,
                                     uniqueName.length() - getZipFileExtension().length());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -856542013 
public String toString()
    { 

//#if -1892693106 
return getZipName();
//#endif 

} 

//#endif 


//#if -1540804786 
public String getUniqueDiagramName()
    { 

//#if -650367958 
String s = uniqueName;
//#endif 


//#if -548734515 
if(s != null)//1
{ 

//#if 239921867 
if(!s.endsWith (getZipFileExtension()))//1
{ 

//#if -224929943 
s += getZipFileExtension();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 683895730 
return s;
//#endif 

} 

//#endif 


//#if 532917323 
protected void remove()
    { 

//#if 1918221522 
uniqueName = null;
//#endif 


//#if -603350063 
project = null;
//#endif 

} 

//#endif 


//#if -1572732359 
public abstract String getType();
//#endif 


//#if 1623031011 
public String getZipFileExtension()
    { 

//#if -675983725 
return "." + getType();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

