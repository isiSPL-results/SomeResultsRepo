package org.argouml.util;
import java.io.File;
import javax.swing.filechooser.FileFilter;
public class SuffixFilter extends FileFilter
  { 
private final String[] suffixes;
private final String desc;
public String toString()
    { 
return getDescription();
} 
public static String getExtension(String filename)
    { 
int i = filename.lastIndexOf('.');
if(i > 0 && i < filename.length() - 1)//1
{ 
return filename.substring(i + 1).toLowerCase();
} 
return null;
} 
public String getSuffix()
    { 
return suffixes[0];
} 
public String[] getSuffixes()
    { 
return suffixes;
} 
public SuffixFilter(String[] s, String d)
    { 
suffixes = new String[s.length];
System.arraycopy(s, 0, suffixes, 0, s.length);
desc = d;
} 
public boolean accept(File f)
    { 
if(f == null)//1
{ 
return false;
} 
if(f.isDirectory())//1
{ 
return true;
} 
String extension = getExtension(f);
for (String suffix : suffixes) //1
{ 
if(suffix.equalsIgnoreCase(extension))//1
{ 
return true;
} 
} 
return false;
} 
public static String getExtension(File f)
    { 
if(f == null)//1
{ 
return null;
} 
return getExtension(f.getName());
} 
public SuffixFilter(String suffix, String d)
    { 
suffixes = new String[] {suffix};
desc = d;
} 
public String getDescription()
    { 
StringBuffer result = new StringBuffer(desc);
result.append(" (");
for (int i = 0; i < suffixes.length; i++) //1
{ 
result.append('.');
result.append(suffixes[i]);
if(i < suffixes.length - 1)//1
{ 
result.append(", ");
} 
} 
result.append(')');
return result.toString();
} 

 } 
