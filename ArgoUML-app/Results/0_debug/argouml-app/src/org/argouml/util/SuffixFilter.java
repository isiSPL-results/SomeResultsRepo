
//#if 139910576 
// Compilation Unit of /SuffixFilter.java 
 

//#if 1655325673 
package org.argouml.util;
//#endif 


//#if -852569237 
import java.io.File;
//#endif 


//#if 196728536 
import javax.swing.filechooser.FileFilter;
//#endif 


//#if 317238085 
public class SuffixFilter extends 
//#if 1363341827 
FileFilter
//#endif 

  { 

//#if -1401442617 
private final String[] suffixes;
//#endif 


//#if -607532777 
private final String desc;
//#endif 


//#if 216524566 
public String toString()
    { 

//#if -2120350510 
return getDescription();
//#endif 

} 

//#endif 


//#if 1153948585 
public static String getExtension(String filename)
    { 

//#if 687447249 
int i = filename.lastIndexOf('.');
//#endif 


//#if -175181425 
if(i > 0 && i < filename.length() - 1)//1
{ 

//#if 697711170 
return filename.substring(i + 1).toLowerCase();
//#endif 

} 

//#endif 


//#if -1941849284 
return null;
//#endif 

} 

//#endif 


//#if -947223553 
public String getSuffix()
    { 

//#if 1079298838 
return suffixes[0];
//#endif 

} 

//#endif 


//#if -595327029 
public String[] getSuffixes()
    { 

//#if 2131153148 
return suffixes;
//#endif 

} 

//#endif 


//#if 121077609 
public SuffixFilter(String[] s, String d)
    { 

//#if 120051117 
suffixes = new String[s.length];
//#endif 


//#if 999902440 
System.arraycopy(s, 0, suffixes, 0, s.length);
//#endif 


//#if 1459966409 
desc = d;
//#endif 

} 

//#endif 


//#if -1405697073 
public boolean accept(File f)
    { 

//#if -1067112243 
if(f == null)//1
{ 

//#if -1079370664 
return false;
//#endif 

} 

//#endif 


//#if -861462180 
if(f.isDirectory())//1
{ 

//#if 2010633436 
return true;
//#endif 

} 

//#endif 


//#if 1215675979 
String extension = getExtension(f);
//#endif 


//#if 1091476797 
for (String suffix : suffixes) //1
{ 

//#if -283449750 
if(suffix.equalsIgnoreCase(extension))//1
{ 

//#if -1176095352 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2085601877 
return false;
//#endif 

} 

//#endif 


//#if -405791129 
public static String getExtension(File f)
    { 

//#if 1943616119 
if(f == null)//1
{ 

//#if -1733834180 
return null;
//#endif 

} 

//#endif 


//#if 1614321514 
return getExtension(f.getName());
//#endif 

} 

//#endif 


//#if -2087199751 
public SuffixFilter(String suffix, String d)
    { 

//#if 812726940 
suffixes = new String[] {suffix};
//#endif 


//#if 2043003210 
desc = d;
//#endif 

} 

//#endif 


//#if 1637502512 
public String getDescription()
    { 

//#if 1027383915 
StringBuffer result = new StringBuffer(desc);
//#endif 


//#if -1460183885 
result.append(" (");
//#endif 


//#if -1565521049 
for (int i = 0; i < suffixes.length; i++) //1
{ 

//#if 128956874 
result.append('.');
//#endif 


//#if 603467834 
result.append(suffixes[i]);
//#endif 


//#if -991931442 
if(i < suffixes.length - 1)//1
{ 

//#if 835034084 
result.append(", ");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1455531684 
result.append(')');
//#endif 


//#if -183073717 
return result.toString();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

