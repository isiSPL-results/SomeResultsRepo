
//#if 455496401 
// Compilation Unit of /AbstractSection.java 
 

//#if -1004723187 
package org.argouml.uml.generator;
//#endif 


//#if 690799104 
import java.io.BufferedReader;
//#endif 


//#if -1807627857 
import java.io.EOFException;
//#endif 


//#if -1609728445 
import java.io.FileReader;
//#endif 


//#if -1087133549 
import java.io.FileWriter;
//#endif 


//#if 600900811 
import java.io.IOException;
//#endif 


//#if -26777910 
import java.util.HashMap;
//#endif 


//#if 1176234736 
import java.util.Iterator;
//#endif 


//#if -2086334692 
import java.util.Map;
//#endif 


//#if -2086151978 
import java.util.Set;
//#endif 


//#if 647392894 
import org.apache.log4j.Logger;
//#endif 


//#if -2012043282 
public abstract class AbstractSection  { 

//#if -616315210 
private static final Logger LOG =
        Logger.getLogger(AbstractSection.class);
//#endif 


//#if 702351423 
private static final String LINE_SEPARATOR =
        System.getProperty("line.separator");
//#endif 


//#if -909263244 
private Map<String, String> mAry;
//#endif 


//#if 1673760453 
public void read(String filename)
    { 

//#if -267931084 
try //1
{ 

//#if -1044173207 
FileReader f = new FileReader(filename);
//#endif 


//#if 1322170676 
BufferedReader fr = new BufferedReader(f);
//#endif 


//#if 505539956 
String line = "";
//#endif 


//#if -1197186253 
StringBuilder content = new StringBuilder();
//#endif 


//#if 581036428 
boolean inSection = false;
//#endif 


//#if -946600313 
while (line != null) //1
{ 

//#if 1900371905 
line = fr.readLine();
//#endif 


//#if 1741246228 
if(line != null)//1
{ 

//#if -1770756036 
if(inSection)//1
{ 

//#if -1871973841 
String sectionId = getSectId(line);
//#endif 


//#if 956071591 
if(sectionId != null)//1
{ 

//#if -16822283 
inSection = false;
//#endif 


//#if -624548276 
mAry.put(sectionId, content.toString());
//#endif 


//#if 1923846444 
content = new StringBuilder();
//#endif 

} 
else
{ 

//#if -1672671140 
content.append(line + LINE_SEPARATOR);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -111180639 
String sectionId = getSectId(line);
//#endif 


//#if -543352935 
if(sectionId != null)//1
{ 

//#if -2034085922 
inSection = true;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1613587149 
fr.close();
//#endif 

} 

//#if -115897876 
catch (IOException e) //1
{ 

//#if 2055125713 
LOG.error("Error: " + e.toString());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1651064927 
public static String getSectId(String line)
    { 

//#if 1579069870 
final String begin = "// section ";
//#endif 


//#if 1616786089 
final String end1 = " begin";
//#endif 


//#if -540739334 
final String end2 = " end";
//#endif 


//#if 167713493 
int first = line.indexOf(begin);
//#endif 


//#if 1480340606 
int second = line.indexOf(end1);
//#endif 


//#if -710238798 
if(second < 0)//1
{ 

//#if 1741574036 
second = line.indexOf(end2);
//#endif 

} 

//#endif 


//#if 1649399600 
String s = null;
//#endif 


//#if -1007268262 
if((first >= 0) && (second >= 0))//1
{ 

//#if 255427628 
first = first + begin.length();
//#endif 


//#if 1428307694 
s = line.substring(first, second);
//#endif 

} 

//#endif 


//#if -1759842271 
return s;
//#endif 

} 

//#endif 


//#if 1037108376 
public void write(String filename, String indent,
                      boolean outputLostSections)
    { 

//#if 1067265413 
try //1
{ 

//#if 1962918369 
FileReader f = new FileReader(filename);
//#endif 


//#if 624185004 
BufferedReader fr = new BufferedReader(f);
//#endif 


//#if 1681813193 
FileWriter fw = new FileWriter(filename + ".out");
//#endif 


//#if 1615489772 
String line = "";
//#endif 


//#if 1087673294 
line = fr.readLine();
//#endif 


//#if 43420159 
while (line != null) //1
{ 

//#if 115079695 
String sectionId = getSectId(line);
//#endif 


//#if -830808441 
if(sectionId != null)//1
{ 

//#if 1095135609 
String content = mAry.get(sectionId);
//#endif 


//#if -1292766768 
if(content != null)//1
{ 

//#if -15989196 
fw.write(line + LINE_SEPARATOR);
//#endif 


//#if 1592165244 
fw.write(content);
//#endif 


//#if -99311644 
String endSectionId = null;
//#endif 


//#if 336372517 
do{ 

//#if 602471116 
line = fr.readLine();
//#endif 


//#if -1809412029 
if(line == null)//1
{ 

//#if 170396082 
throw new EOFException(
                                    "Reached end of file while looking "
                                    + "for the end of section with ID = \""
                                    + sectionId + "\"!");
//#endif 

} 

//#endif 


//#if -647710233 
endSectionId = getSectId(line);
//#endif 

} 
 while (endSectionId == null);//1

//#endif 


//#if 1035569918 
if(!endSectionId.equals(sectionId))//1
{ 

//#if 1904838185 
LOG.error("Mismatch between sectionId (\""
                                      + sectionId + "\") and endSectionId (\""
                                      + endSectionId + "\")!");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1490442230 
mAry.remove(sectionId);
//#endif 

} 

//#endif 


//#if 1187663109 
fw.write(line);
//#endif 


//#if -1677258160 
line = fr.readLine();
//#endif 


//#if 2099534179 
if(line != null)//1
{ 

//#if -2115342752 
fw.write(LINE_SEPARATOR);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -66433133 
if((!mAry.isEmpty()) && (outputLostSections))//1
{ 

//#if 1405944592 
fw.write("/* lost code following: " + LINE_SEPARATOR);
//#endif 


//#if 1904047272 
Set mapEntries = mAry.entrySet();
//#endif 


//#if 2112247744 
Iterator itr = mapEntries.iterator();
//#endif 


//#if -1512095730 
while (itr.hasNext()) //1
{ 

//#if -767373937 
Map.Entry entry = (Map.Entry) itr.next();
//#endif 


//#if 1052255377 
fw.write(indent + "// section " + entry.getKey()
                             + " begin" + LINE_SEPARATOR);
//#endif 


//#if 81370101 
fw.write((String) entry.getValue());
//#endif 


//#if 134311171 
fw.write(indent + "// section " + entry.getKey()
                             + " end" + LINE_SEPARATOR);
//#endif 

} 

//#endif 


//#if -1050220983 
fw.write("*/");
//#endif 

} 

//#endif 


//#if -18885957 
fr.close();
//#endif 


//#if -1001453482 
fw.close();
//#endif 

} 

//#if -265488714 
catch (IOException e) //1
{ 

//#if 1506804261 
LOG.error("Error: " + e.toString());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -2083224050 
public static String generate(String id, String indent)
    { 

//#if -1447515620 
return "";
//#endif 

} 

//#endif 


//#if -1387474958 
public AbstractSection()
    { 

//#if 892813886 
mAry = new HashMap<String, String>();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

