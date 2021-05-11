
//#if -703240080 
// Compilation Unit of /FileImportUtils.java 
 

//#if -1582313110 
package org.argouml.uml.reveng;
//#endif 


//#if 1392042263 
import java.io.File;
//#endif 


//#if 1036541008 
import java.util.ArrayList;
//#endif 


//#if -1738631662 
import java.util.Collections;
//#endif 


//#if -1807016685 
import java.util.HashSet;
//#endif 


//#if 227959416 
import java.util.LinkedList;
//#endif 


//#if 900753425 
import java.util.List;
//#endif 


//#if 1968923877 
import java.util.Set;
//#endif 


//#if 2119849165 
import org.argouml.taskmgmt.ProgressMonitor;
//#endif 


//#if 323144175 
import org.argouml.util.SuffixFilter;
//#endif 


//#if 999976744 
public class FileImportUtils  { 

//#if -390494856 
public static List<File> getList(File file, boolean recurse,
                                     SuffixFilter[] filters, ProgressMonitor monitor)
    { 

//#if 1780162466 
if(file == null)//1
{ 

//#if 466944517 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if -1064942338 
List<File> results = new ArrayList<File>();
//#endif 


//#if 196638189 
List<File> toDoDirectories = new LinkedList<File>();
//#endif 


//#if -847642689 
Set<File> seenDirectories = new HashSet<File>();
//#endif 


//#if 1398295314 
toDoDirectories.add(file);
//#endif 


//#if -665443923 
while (!toDoDirectories.isEmpty()) //1
{ 

//#if 916337422 
if(monitor != null && monitor.isCanceled())//1
{ 

//#if -789176424 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if -728802657 
File curDir = toDoDirectories.remove(0);
//#endif 


//#if 172290749 
if(!curDir.isDirectory())//1
{ 

//#if -1117018006 
results.add(curDir);
//#endif 


//#if 1710298952 
continue;
//#endif 

} 

//#endif 


//#if -434022654 
File[] files = curDir.listFiles();
//#endif 


//#if 68565427 
if(files != null)//1
{ 

//#if -1125989868 
for (File curFile : curDir.listFiles()) //1
{ 

//#if 292275393 
if(curFile.isDirectory())//1
{ 

//#if 988529152 
if(recurse && !seenDirectories.contains(curFile))//1
{ 

//#if -179084202 
toDoDirectories.add(curFile);
//#endif 


//#if -982316063 
seenDirectories.add(curFile);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -192410877 
if(matchesSuffix(curFile, filters))//1
{ 

//#if -1589291550 
results.add(curFile);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -401546967 
return results;
//#endif 

} 

//#endif 


//#if 271864013 
public static boolean matchesSuffix(Object file, SuffixFilter[] filters)
    { 

//#if 879717331 
if(!(file instanceof File))//1
{ 

//#if 1032691409 
return false;
//#endif 

} 

//#endif 


//#if -21150605 
if(filters != null)//1
{ 

//#if -676478446 
for (int i = 0; i < filters.length; i++) //1
{ 

//#if 129968948 
if(filters[i].accept((File) file))//1
{ 

//#if 1624847619 
return true;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1508227680 
return false;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

