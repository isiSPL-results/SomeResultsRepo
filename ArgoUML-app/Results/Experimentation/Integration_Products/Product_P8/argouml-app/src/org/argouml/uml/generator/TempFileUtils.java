package org.argouml.uml.generator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.log4j.Logger;
public class TempFileUtils  { 
private static final Logger LOG = Logger.getLogger(TempFileUtils.class);
private static void traverseDir(File dir, FileAction action)
    throws IOException
    { 
if(dir.exists())//1
{ 
File[] files = dir.listFiles();
for (int i = 0; i < files.length; i++) //1
{ 
if(files[i].isDirectory())//1
{ 
traverseDir(files[i], action);
} 
else
{ 
action.act(files[i]);
} 
} 
action.act(dir);
} 
} 
public static Collection<String> readFileNames(File dir)
    { 
final List<String> ret = new ArrayList<String>();
final int prefix = dir.getPath().length() + 1;
try//1
{ 
traverseDir(dir, new FileAction() {
                public void act(File f) {
                    if (!f.isDirectory()) {
                        ret.add(f.toString().substring(prefix));
                    }
                }
            });
} 
catch (IOException ioe) //1
{ 
LOG.error("Exception reading file names", ioe);
} 
return ret;
} 
public static void deleteDir(File dir)
    { 
try//1
{ 
traverseDir(dir, new FileAction() {
                public void act(File f) {
                    f.delete();
                }
            });
} 
catch (IOException ioe) //1
{ 
LOG.error("Exception deleting directory", ioe);
} 
} 
public static Collection<SourceUnit> readAllFiles(File dir)
    { 
try//1
{ 
final List<SourceUnit> ret = new ArrayList<SourceUnit>();
final int prefix = dir.getPath().length() + 1;
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
return ret;
} 
catch (IOException ioe) //1
{ 
LOG.error("Exception reading files", ioe);
} 
return null;
} 
public static File createTempDir()
    { 
File tmpdir = null;
try//1
{ 
tmpdir = File.createTempFile("argouml", null);
tmpdir.delete();
if(!tmpdir.mkdir())//1
{ 
return null;
} 
return tmpdir;
} 
catch (IOException ioe) //1
{ 
LOG.error("Error while creating a temporary directory", ioe);
return null;
} 
} 
private interface FileAction  { 
void act(File file) throws IOException;
 } 

 } 
