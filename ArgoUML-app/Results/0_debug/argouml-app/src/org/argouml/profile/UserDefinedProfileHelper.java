
//#if -976717144 
// Compilation Unit of /UserDefinedProfileHelper.java 
 

//#if -1918321514 
package org.argouml.profile;
//#endif 


//#if 1716494783 
import java.io.File;
//#endif 


//#if -350286168 
import java.util.ArrayList;
//#endif 


//#if -405109397 
import java.util.HashSet;
//#endif 


//#if 185989920 
import java.util.LinkedList;
//#endif 


//#if -832987463 
import java.util.List;
//#endif 


//#if -857949891 
import java.util.Set;
//#endif 


//#if -1791687366 
import javax.swing.JFileChooser;
//#endif 


//#if 1316122156 
import javax.swing.filechooser.FileFilter;
//#endif 


//#if -744738551 
public class UserDefinedProfileHelper  { 

//#if 190547950 
public static JFileChooser createUserDefinedProfileFileChooser()
    { 

//#if 1717402318 
JFileChooser fileChooser = new JFileChooser();
//#endif 


//#if 1103964102 
fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//#endif 


//#if -2107841225 
fileChooser.setMultiSelectionEnabled(true);
//#endif 


//#if -975575571 
fileChooser.setFileFilter(new FileFilter() {

            public boolean accept(File file) {
                String s = file.getName().toLowerCase();
                return file.isDirectory() || (file.isFile() && (
                                                  s.endsWith(".xmi") || s.endsWith(".xml")
                                                  || s.endsWith(".xmi.zip") || s.endsWith(".xml.zip")));
            }

            public String getDescription() {
                return "*.xmi *.xml *.xmi.zip *.xml.zip";
            }

        });
//#endif 


//#if -766516574 
return fileChooser;
//#endif 

} 

//#endif 


//#if -1950219289 
private static List<File> getList(File file)
    { 

//#if 1898623169 
List<File> results = new ArrayList<File>();
//#endif 


//#if -1714580086 
List<File> toDoDirectories = new LinkedList<File>();
//#endif 


//#if -962497060 
Set<File> seenDirectories = new HashSet<File>();
//#endif 


//#if 490798703 
toDoDirectories.add(file);
//#endif 


//#if 1615856842 
while (!toDoDirectories.isEmpty()) //1
{ 

//#if -1332645995 
File curDir = toDoDirectories.remove(0);
//#endif 


//#if 88559879 
if(!curDir.isDirectory())//1
{ 

//#if 1750641251 
results.add(curDir);
//#endif 


//#if 15832815 
continue;
//#endif 

} 

//#endif 


//#if 515628152 
File[] files = curDir.listFiles();
//#endif 


//#if -1044247427 
if(files != null)//1
{ 

//#if -710653812 
for (File curFile : curDir.listFiles()) //1
{ 

//#if -1027254468 
if(curFile.isDirectory())//1
{ 

//#if 1245574532 
if(!seenDirectories.contains(curFile))//1
{ 

//#if 325192179 
toDoDirectories.add(curFile);
//#endif 


//#if -478039682 
seenDirectories.add(curFile);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1804777238 
String s = curFile.getName().toLowerCase();
//#endif 


//#if 792633650 
if(s.endsWith(".xmi") || s.endsWith(".xml")
                                || s.endsWith(".xmi.zip")
                                || s.endsWith(".xml.zip"))//1
{ 

//#if -660783175 
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


//#if 1003354118 
return results;
//#endif 

} 

//#endif 


//#if -809038180 
public static List<File> getFileList(File[] fileArray)
    { 

//#if -88638834 
List<File> files = new ArrayList<File>();
//#endif 


//#if 1109248330 
for (int i = 0; i < fileArray.length; i++) //1
{ 

//#if 527780736 
File file = fileArray[i];
//#endif 


//#if 473828054 
files.addAll(getList(file));
//#endif 

} 

//#endif 


//#if -585083623 
return files;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

