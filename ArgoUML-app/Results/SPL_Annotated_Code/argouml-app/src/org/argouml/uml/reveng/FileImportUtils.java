// Compilation Unit of /FileImportUtils.java 
 
package org.argouml.uml.reveng;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.argouml.taskmgmt.ProgressMonitor;
import org.argouml.util.SuffixFilter;
public class FileImportUtils  { 
public static List<File> getList(File file, boolean recurse,
                                     SuffixFilter[] filters, ProgressMonitor monitor)
    { 
if(file == null)//1
{ 
return Collections.emptyList();
} 

List<File> results = new ArrayList<File>();
List<File> toDoDirectories = new LinkedList<File>();
Set<File> seenDirectories = new HashSet<File>();
toDoDirectories.add(file);
while (!toDoDirectories.isEmpty()) //1
{ 
if(monitor != null && monitor.isCanceled())//1
{ 
return Collections.emptyList();
} 

File curDir = toDoDirectories.remove(0);
if(!curDir.isDirectory())//1
{ 
results.add(curDir);
continue;
} 

File[] files = curDir.listFiles();
if(files != null)//1
{ 
for (File curFile : curDir.listFiles()) //1
{ 
if(curFile.isDirectory())//1
{ 
if(recurse && !seenDirectories.contains(curFile))//1
{ 
toDoDirectories.add(curFile);
seenDirectories.add(curFile);
} 

} 
else
{ 
if(matchesSuffix(curFile, filters))//1
{ 
results.add(curFile);
} 

} 

} 

} 

} 

return results;
} 

public static boolean matchesSuffix(Object file, SuffixFilter[] filters)
    { 
if(!(file instanceof File))//1
{ 
return false;
} 

if(filters != null)//1
{ 
for (int i = 0; i < filters.length; i++) //1
{ 
if(filters[i].accept((File) file))//1
{ 
return true;
} 

} 

} 

return false;
} 

 } 


