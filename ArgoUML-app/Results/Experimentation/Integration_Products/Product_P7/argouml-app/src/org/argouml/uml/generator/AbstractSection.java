package org.argouml.uml.generator;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
public abstract class AbstractSection  { 
private static final Logger LOG =
        Logger.getLogger(AbstractSection.class);
private static final String LINE_SEPARATOR =
        System.getProperty("line.separator");
private Map<String, String> mAry;
public void read(String filename)
    { 
try//1
{ 
FileReader f = new FileReader(filename);
BufferedReader fr = new BufferedReader(f);
String line = "";
StringBuilder content = new StringBuilder();
boolean inSection = false;
while (line != null) //1
{ 
line = fr.readLine();
if(line != null)//1
{ 
if(inSection)//1
{ 
String sectionId = getSectId(line);
if(sectionId != null)//1
{ 
inSection = false;
mAry.put(sectionId, content.toString());
content = new StringBuilder();
} 
else
{ 
content.append(line + LINE_SEPARATOR);
} 
} 
else
{ 
String sectionId = getSectId(line);
if(sectionId != null)//1
{ 
inSection = true;
} 
} 
} 
} 
fr.close();
} 
catch (IOException e) //1
{ 
LOG.error("Error: " + e.toString());
} 
} 
public static String getSectId(String line)
    { 
final String begin = "// section ";
final String end1 = " begin";
final String end2 = " end";
int first = line.indexOf(begin);
int second = line.indexOf(end1);
if(second < 0)//1
{ 
second = line.indexOf(end2);
} 
String s = null;
if((first >= 0) && (second >= 0))//1
{ 
first = first + begin.length();
s = line.substring(first, second);
} 
return s;
} 
public void write(String filename, String indent,
                      boolean outputLostSections)
    { 
try//1
{ 
FileReader f = new FileReader(filename);
BufferedReader fr = new BufferedReader(f);
FileWriter fw = new FileWriter(filename + ".out");
String line = "";
line = fr.readLine();
while (line != null) //1
{ 
String sectionId = getSectId(line);
if(sectionId != null)//1
{ 
String content = mAry.get(sectionId);
if(content != null)//1
{ 
fw.write(line + LINE_SEPARATOR);
fw.write(content);
String endSectionId = null;
do{ 
line = fr.readLine();
if(line == null)//1
{ 
throw new EOFException(
                                    "Reached end of file while looking "
                                    + "for the end of section with ID = \""
                                    + sectionId + "\"!");
} 
endSectionId = getSectId(line);
} 
 while (endSectionId == null);//1
if(!endSectionId.equals(sectionId))//1
{ 
LOG.error("Mismatch between sectionId (\""
                                      + sectionId + "\") and endSectionId (\""
                                      + endSectionId + "\")!");
} 
} 
mAry.remove(sectionId);
} 
fw.write(line);
line = fr.readLine();
if(line != null)//1
{ 
fw.write(LINE_SEPARATOR);
} 
} 
if((!mAry.isEmpty()) && (outputLostSections))//1
{ 
fw.write("/* lost code following: " + LINE_SEPARATOR);
Set mapEntries = mAry.entrySet();
Iterator itr = mapEntries.iterator();
while (itr.hasNext()) //1
{ 
Map.Entry entry = (Map.Entry) itr.next();
fw.write(indent + "// section " + entry.getKey()
                             + " begin" + LINE_SEPARATOR);
fw.write((String) entry.getValue());
fw.write(indent + "// section " + entry.getKey()
                             + " end" + LINE_SEPARATOR);
} 
fw.write("*/");
} 
fr.close();
fw.close();
} 
catch (IOException e) //1
{ 
LOG.error("Error: " + e.toString());
} 
} 
public static String generate(String id, String indent)
    { 
return "";
} 
public AbstractSection()
    { 
mAry = new HashMap<String, String>();
} 

 } 
