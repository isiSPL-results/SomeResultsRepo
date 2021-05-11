
//#if -1899160544 
// Compilation Unit of /TempFileUtils.java 
 

//#if 1742140359 
package org.argouml.uml.generator;
//#endif 


//#if -1771602246 
import java.io.BufferedReader;
//#endif 


//#if -1763170240 
import java.io.File;
//#endif 


//#if 1850189821 
import java.io.FileReader;
//#endif 


//#if 484184657 
import java.io.IOException;
//#endif 


//#if -1787075321 
import java.util.ArrayList;
//#endif 


//#if 1774838074 
import java.util.Collection;
//#endif 


//#if 988449018 
import java.util.List;
//#endif 


//#if 1622362372 
import org.apache.log4j.Logger;
//#endif 


//#if -172969520 
public class TempFileUtils  { 

//#if 588717569 
private static final Logger LOG = Logger.getLogger(TempFileUtils.class);
//#endif 


//#if -1632723278 
private static void traverseDir(File dir, FileAction action)
    throws IOException
    { 

//#if -1941316749 
if(dir.exists())//1
{ 

//#if -1228351624 
File[] files = dir.listFiles();
//#endif 


//#if -132119965 
for (int i = 0; i < files.length; i++) //1
{ 

//#if 566827139 
if(files[i].isDirectory())//1
{ 

//#if -1573299539 
traverseDir(files[i], action);
//#endif 

} 
else
{ 

//#if -1131115461 
action.act(files[i]);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 304981763 
action.act(dir);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1205602106 
public static Collection<String> readFileNames(File dir)
    { 

//#if -981920240 
final List<String> ret = new ArrayList<String>();
//#endif 


//#if 1496418760 
final int prefix = dir.getPath().length() + 1;
//#endif 


//#if -348015115 
try //1
{ 

//#if 1557568349 
traverseDir(dir, new FileAction() {
                public void act(File f) {
                    if (!f.isDirectory()) {
                        ret.add(f.toString().substring(prefix));
                    }
                }
            });
//#endif 

} 

//#if -52328170 
catch (IOException ioe) //1
{ 

//#if 902240875 
LOG.error("Exception reading file names", ioe);
//#endif 

} 

//#endif 


//#endif 


//#if -599578455 
return ret;
//#endif 

} 

//#endif 


//#if 1632417151 
public static void deleteDir(File dir)
    { 

//#if 42356991 
try //1
{ 

//#if -1388144331 
traverseDir(dir, new FileAction() {
                public void act(File f) {
                    f.delete();
                }
            });
//#endif 

} 

//#if 260403494 
catch (IOException ioe) //1
{ 

//#if -546515637 
LOG.error("Exception deleting directory", ioe);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1336028698 
public static Collection<SourceUnit> readAllFiles(File dir)
    { 

//#if -455189804 
try //1
{ 

//#if -1925100982 
final List<SourceUnit> ret = new ArrayList<SourceUnit>();
//#endif 


//#if 1812508326 
final int prefix = dir.getPath().length() + 1;
//#endif 


//#if -1881546597 
traverseDir(dir, new FileAction() {

                public void act(File f) throws IOException {
                    // skip backup files. This is actually a workaround for the
                    // cpp generator, which always creates backup files (it's a
                    // bug).
                    if (!f.isDirectory() && !f.getName().endsWith(".bak")) {
                        // TODO: This is using the default platform character
                        // encoding.  Specifying an encoding will produce more
                        // predictable results
                        FileReader fr = new FileReader(f);
                        BufferedReader bfr = new BufferedReader(fr);
                        try {
                            StringBuffer result =
                                new StringBuffer((int) f.length());
                            String line = bfr.readLine();
                            do {
                                result.append(line);
                                line = bfr.readLine();
                                if (line != null) {
                                    result.append('\n');
                                }
                            } while (line != null);
                            ret.add(new SourceUnit(f.toString().substring(
                                                       prefix), result.toString()));
                        } finally {
                            bfr.close();
                            fr.close();
                        }
                    }
                }

            });
//#endif 


//#if -111049209 
return ret;
//#endif 

} 

//#if -1266873860 
catch (IOException ioe) //1
{ 

//#if 2099052163 
LOG.error("Exception reading files", ioe);
//#endif 

} 

//#endif 


//#endif 


//#if -1423750394 
return null;
//#endif 

} 

//#endif 


//#if -1625309515 
public static File createTempDir()
    { 

//#if -461291697 
File tmpdir = null;
//#endif 


//#if 2121168092 
try  //1
{ 

//#if 1074371008 
tmpdir = File.createTempFile("argouml", null);
//#endif 


//#if -1579396092 
tmpdir.delete();
//#endif 


//#if -1801146173 
if(!tmpdir.mkdir())//1
{ 

//#if 1117847115 
return null;
//#endif 

} 

//#endif 


//#if 57123016 
return tmpdir;
//#endif 

} 

//#if 2058012063 
catch (IOException ioe) //1
{ 

//#if -493623190 
LOG.error("Error while creating a temporary directory", ioe);
//#endif 


//#if 1357386922 
return null;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1834836418 
private interface FileAction  { 

//#if -1464847702 
void act(File file) throws IOException;
//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

