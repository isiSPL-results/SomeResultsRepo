
//#if 1758787610 
// Compilation Unit of /SourceUnit.java 
 

//#if -524529155 
package org.argouml.uml.generator;
//#endif 


//#if 1661941542 
public class SourceUnit  { 

//#if 483129715 
public static final String FILE_SEPARATOR =
        System.getProperty("file.separator");
//#endif 


//#if -344496603 
private Language language;
//#endif 


//#if 958673849 
private String name;
//#endif 


//#if 730309774 
private String basePath;
//#endif 


//#if 208032153 
private String content;
//#endif 


//#if 210801206 
public String getBasePath()
    { 

//#if 1582699529 
return basePath;
//#endif 

} 

//#endif 


//#if -1652152162 
public SourceUnit(String theName, String path, String theContent)
    { 

//#if 1624132103 
setName(theName);
//#endif 


//#if -1515196909 
setBasePath(path);
//#endif 


//#if -222120789 
this.content = theContent;
//#endif 

} 

//#endif 


//#if -519950983 
public void setContent(String theContent)
    { 

//#if -711377822 
this.content = theContent;
//#endif 

} 

//#endif 


//#if 809963213 
public void setFullName(String path)
    { 

//#if 1328263097 
int sep = path.lastIndexOf(FILE_SEPARATOR);
//#endif 


//#if 188856977 
if(sep >= 0)//1
{ 

//#if -946794444 
basePath = path.substring(0, sep);
//#endif 


//#if 1854779875 
name = path.substring(sep + FILE_SEPARATOR.length());
//#endif 

} 
else
{ 

//#if -756233854 
basePath = "";
//#endif 


//#if 1594300338 
name = path;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1342473348 
public void setName(String filename)
    { 

//#if 302051897 
int sep = filename.lastIndexOf(FILE_SEPARATOR);
//#endif 


//#if 2132520495 
if(sep >= 0)//1
{ 

//#if 139919342 
name = filename.substring(sep + FILE_SEPARATOR.length());
//#endif 

} 
else
{ 

//#if -1418055919 
name = filename;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 798852466 
public SourceUnit(String fullName, String theContent)
    { 

//#if 1038053093 
setFullName(fullName);
//#endif 


//#if -1038364126 
content = theContent;
//#endif 

} 

//#endif 


//#if -1340427461 
public String getContent()
    { 

//#if 248038523 
return content;
//#endif 

} 

//#endif 


//#if 1736802729 
public void setBasePath(String path)
    { 

//#if -1108845777 
if(path.endsWith(FILE_SEPARATOR))//1
{ 

//#if 690807731 
basePath =
                path.substring(0, path.length() - FILE_SEPARATOR.length());
//#endif 

} 
else
{ 

//#if -937606952 
basePath = path;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1384003567 
public Language getLanguage()
    { 

//#if -1785231855 
return language;
//#endif 

} 

//#endif 


//#if 180714586 
public String getFullName()
    { 

//#if 639503839 
return basePath + System.getProperty("file.separator") + name;
//#endif 

} 

//#endif 


//#if 1319244251 
public void setLanguage(Language lang)
    { 

//#if 113078072 
this.language = lang;
//#endif 

} 

//#endif 


//#if -2054701973 
public String getName()
    { 

//#if 234423734 
return name;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

