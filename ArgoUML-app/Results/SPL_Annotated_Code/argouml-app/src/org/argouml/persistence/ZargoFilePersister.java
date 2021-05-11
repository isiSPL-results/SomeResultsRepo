// Compilation Unit of /ZargoFilePersister.java 
 
package org.argouml.persistence;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.argouml.application.api.Argo;
import org.argouml.application.helpers.ApplicationVersion;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectFactory;
import org.argouml.kernel.ProjectMember;
import org.argouml.kernel.ProfileConfiguration;
import org.argouml.util.FileConstants;
import org.argouml.util.ThreadUtils;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

class ZargoFilePersister extends UmlFilePersister
  { 

//#if LOGGING 
private static final Logger LOG =
        Logger.getLogger(ZargoFilePersister.class);
//#endif 

private void readerToWriter(
        Reader reader,
        Writer writer) throws IOException
    { 
int ch;
while ((ch = reader.read()) != -1) //1
{ 

//#if (CLASS || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) && ! LOGGING  
if((ch != 0xFFFF) && (ch != 8))//1
{ 
writer.write(ch);
} 

//#endif 


//#if LOGGING 
if(ch == 0xFFFF)//1
{ 
LOG.info("Stripping out 0xFFFF from save file");
} 
else

//#if LOGGING 
if(ch == 8)//1
{ 
LOG.info("Stripping out 0x8 from save file");
} 
else
{ 
writer.write(ch);
} 

//#endif 


//#endif 

} 

} 

private void copyDiagrams(File file, String encoding, PrintWriter writer)
    throws IOException
    { 
ZipInputStream zis = new ZipInputStream(toURL(file).openStream());
SubInputStream sub = new SubInputStream(zis);
ZipEntry currentEntry = null;
while ((currentEntry = sub.getNextEntry()) != null) //1
{ 
if(currentEntry.getName().endsWith(".pgml"))//1
{ 
BufferedReader reader = new BufferedReader(
                    new InputStreamReader(sub, encoding));
String firstLine = reader.readLine();
if(firstLine.startsWith("<?xml"))//1
{ 
reader.readLine();
} 
else
{ 
writer.println(firstLine);
} 

readerToWriter(reader, writer);
sub.close();
reader.close();
} 

} 

zis.close();
} 

private void copyMember(File file, String tag, String outputEncoding,
                            PrintWriter writer) throws IOException, MalformedURLException,
        UnsupportedEncodingException
    { 
ZipInputStream zis = openZipStreamAt(toURL(file), "." + tag);
if(zis != null)//1
{ 
InputStreamReader isr = new InputStreamReader(zis, outputEncoding);
BufferedReader reader = new BufferedReader(isr);
String firstLine = reader.readLine();
if(firstLine.startsWith("<?xml"))//1
{ 
reader.readLine();
} 
else
{ 
writer.println(firstLine);
} 

readerToWriter(reader, writer);
zis.close();
reader.close();
} 

} 

private URL makeZipEntryUrl(URL url, String entryName)
    throws MalformedURLException
    { 
String entryURL = "jar:" + url + "!/" + entryName;
return new URL(entryURL);
} 

private List<String> getEntryNames(File file, String extension)
    throws IOException, MalformedURLException
    { 
ZipInputStream zis = new ZipInputStream(toURL(file).openStream());
List<String> result = new ArrayList<String>();
ZipEntry entry = zis.getNextEntry();
while (entry != null) //1
{ 
String name = entry.getName();
if(extension == null || name.endsWith(extension))//1
{ 
result.add(name);
} 

entry = zis.getNextEntry();
} 

zis.close();
return result;
} 

private boolean containsProfile(File file) throws IOException
    { 
return !getEntryNames(file, "." + ProfileConfiguration.EXTENSION)
               .isEmpty();
} 

private InputStream openZipEntry(URL url, String entryName)
    throws MalformedURLException, IOException
    { 
return makeZipEntryUrl(url, entryName).openStream();
} 

private File zargoToUml(File file, ProgressMgr progressMgr)
    throws OpenException, InterruptedException
    { 
File combinedFile = null;
try //1
{ 
combinedFile = File.createTempFile("combinedzargo_", ".uml");

//#if LOGGING 
LOG.info(
                "Combining old style zargo sub files into new style uml file "
                + combinedFile.getAbsolutePath());
//#endif 

combinedFile.deleteOnExit();
String encoding = Argo.getEncoding();
FileOutputStream stream = new FileOutputStream(combinedFile);
PrintWriter writer =
                new PrintWriter(new BufferedWriter(
                                    new OutputStreamWriter(stream, encoding)));
writer.println("<?xml version = \"1.0\" " + "encoding = \""
                           + encoding + "\" ?>");
copyArgo(file, encoding, writer);
progressMgr.nextPhase();
copyMember(file, "profile", encoding, writer);
copyXmi(file, encoding, writer);
copyDiagrams(file, encoding, writer);
copyMember(file, "todo", encoding, writer);
progressMgr.nextPhase();
writer.println("</uml>");
writer.close();

//#if LOGGING 
LOG.info("Completed combining files");
//#endif 

} 
catch (IOException e) //1
{ 
throw new OpenException(e);
} 


return combinedFile;
} 

private boolean containsTodo(File file) throws IOException
    { 
return !getEntryNames(file, ".todo").isEmpty();
} 

@Override
    public Project doLoad(File file)
    throws OpenException, InterruptedException
    { 
ProgressMgr progressMgr = new ProgressMgr();
progressMgr.setNumberOfPhases(3 + UML_PHASES_LOAD);
ThreadUtils.checkIfInterrupted();
int fileVersion;
String releaseVersion;
try //1
{ 
String argoEntry = getEntryNames(file, ".argo").iterator().next();
URL argoUrl = makeZipEntryUrl(toURL(file), argoEntry);
fileVersion = getPersistenceVersion(argoUrl.openStream());
releaseVersion = getReleaseVersion(argoUrl.openStream());
} 
catch (MalformedURLException e) //1
{ 
throw new OpenException(e);
} 

catch (IOException e) //1
{ 
throw new OpenException(e);
} 


boolean upgradeRequired = true;

//#if LOGGING 
LOG.info("Loading zargo file of version " + fileVersion);
//#endif 

final Project p;
if(upgradeRequired)//1
{ 
File combinedFile = zargoToUml(file, progressMgr);
p = super.doLoad(file, combinedFile, progressMgr);
} 
else
{ 
p = loadFromZargo(file, progressMgr);
} 

progressMgr.nextPhase();
PersistenceManager.getInstance().setProjectURI(file.toURI(), p);
return p;
} 

private void copyXmi(File file, String encoding, PrintWriter writer)
    throws IOException, MalformedURLException,
        UnsupportedEncodingException
    { 
ZipInputStream zis = openZipStreamAt(toURL(file), ".xmi");
BufferedReader reader = new BufferedReader(
            new InputStreamReader(zis, encoding));
reader.readLine();
readerToWriter(reader, writer);
zis.close();
reader.close();
} 

private Project loadFromZargo(File file, ProgressMgr progressMgr)
    throws OpenException
    { 
Project p = ProjectFactory.getInstance().createProject(file.toURI());
try //1
{ 
progressMgr.nextPhase();
ArgoParser parser = new ArgoParser();
String argoEntry = getEntryNames(file, ".argo").iterator().next();
parser.readProject(p, new InputSource(makeZipEntryUrl(toURL(file),
                                                  argoEntry).toExternalForm()));
List memberList = parser.getMemberList();

//#if LOGGING 
LOG.info(memberList.size() + " members");
//#endif 

String xmiEntry = getEntryNames(file, ".xmi").iterator().next();
MemberFilePersister persister = getMemberFilePersister("xmi");
persister.load(p, makeZipEntryUrl(toURL(file), xmiEntry));
List<String> entries = getEntryNames(file, null);
for (String name : entries) //1
{ 
String ext = name.substring(name.lastIndexOf('.') + 1);
if(!"argo".equals(ext) && !"xmi".equals(ext))//1
{ 
persister = getMemberFilePersister(ext);

//#if LOGGING 
LOG.info("Loading member with "
                             + persister.getClass().getName());
//#endif 

persister.load(p, openZipEntry(toURL(file), name));
} 

} 

progressMgr.nextPhase();
ThreadUtils.checkIfInterrupted();
p.postLoad();
return p;
} 
catch (InterruptedException e) //1
{ 
return null;
} 

catch (MalformedURLException e) //1
{ 
throw new OpenException(e);
} 

catch (IOException e) //1
{ 
throw new OpenException(e);
} 

catch (SAXException e) //1
{ 
throw new OpenException(e);
} 


} 

@Override
    public void doSave(Project project, File file) throws SaveException,
               InterruptedException
    { 

//#if LOGGING 
LOG.info("Saving");
//#endif 

ProgressMgr progressMgr = new ProgressMgr();
progressMgr.setNumberOfPhases(4);
progressMgr.nextPhase();
File lastArchiveFile = new File(file.getAbsolutePath() + "~");
File tempFile = null;
try //1
{ 
tempFile = createTempFile(file);
} 
catch (FileNotFoundException e) //1
{ 
throw new SaveException(
                "Failed to archive the previous file version", e);
} 

catch (IOException e) //1
{ 
throw new SaveException(
                "Failed to archive the previous file version", e);
} 


ZipOutputStream stream = null;
try //2
{ 
project.setFile(file);
project.setVersion(ApplicationVersion.getVersion());
project.setPersistenceVersion(PERSISTENCE_VERSION);
stream = new ZipOutputStream(new FileOutputStream(file));
for (ProjectMember projectMember : project.getMembers()) //1
{ 
if(projectMember.getType().equalsIgnoreCase("xmi"))//1
{ 

//#if LOGGING 
if(LOG.isInfoEnabled())//1
{ 
LOG.info("Saving member of type: "
                                 + projectMember.getType());
} 

//#endif 

stream.putNextEntry(
                        new ZipEntry(projectMember.getZipName()));
MemberFilePersister persister =
                        getMemberFilePersister(projectMember);
persister.save(projectMember, stream);
} 

} 

if(lastArchiveFile.exists())//1
{ 
lastArchiveFile.delete();
} 

if(tempFile.exists() && !lastArchiveFile.exists())//1
{ 
tempFile.renameTo(lastArchiveFile);
} 

if(tempFile.exists())//1
{ 
tempFile.delete();
} 

progressMgr.nextPhase();
} 
catch (Exception e) //1
{ 

//#if LOGGING 
LOG.error("Exception occured during save attempt", e);
//#endif 

try //1
{ 
if(stream != null)//1
{ 
stream.close();
} 

} 
catch (Exception ex) //1
{ 
} 


file.delete();
tempFile.renameTo(file);
throw new SaveException(e);
} 


try //3
{ 
stream.close();
} 
catch (IOException ex) //1
{ 

//#if LOGGING 
LOG.error("Failed to close save output writer", ex);
//#endif 

} 


} 

@Override
    public String getExtension()
    { 
return "zargo";
} 

private ZipInputStream openZipStreamAt(URL url, String ext)
    throws IOException
    { 
ZipInputStream zis = new ZipInputStream(url.openStream());
ZipEntry entry = zis.getNextEntry();
while (entry != null && !entry.getName().endsWith(ext)) //1
{ 
entry = zis.getNextEntry();
} 

if(entry == null)//1
{ 
zis.close();
return null;
} 

return zis;
} 

private void copyArgo(File file, String encoding, PrintWriter writer)
    throws IOException, MalformedURLException, OpenException,
        UnsupportedEncodingException
    { 
int pgmlCount = getPgmlCount(file);
boolean containsToDo = containsTodo(file);
boolean containsProfile = containsProfile(file);
ZipInputStream zis =
            openZipStreamAt(toURL(file), FileConstants.PROJECT_FILE_EXT);
if(zis == null)//1
{ 
throw new OpenException(
                "There is no .argo file in the .zargo");
} 

String line;
BufferedReader reader =
            new BufferedReader(new InputStreamReader(zis, encoding));
String rootLine;
do{ 
rootLine = reader.readLine();
if(rootLine == null)//1
{ 
throw new OpenException(
                    "Can't find an <argo> tag in the argo file");
} 

} 
 while(!rootLine.startsWith("<argo"));//1

String version = getVersion(rootLine);
writer.println("<uml version=\"" + version + "\">");
writer.println(rootLine);

//#if LOGGING 
LOG.info("Transfering argo contents");
//#endif 

int memberCount = 0;
while ((line = reader.readLine()) != null) //1
{ 
if(line.trim().startsWith("<member"))//1
{ 
++memberCount;
} 

if(line.trim().equals("</argo>") && memberCount == 0)//1
{ 

//#if LOGGING 
LOG.info("Inserting member info");
//#endif 

writer.println("<member type='xmi' name='.xmi' />");
for (int i = 0; i < pgmlCount; ++i) //1
{ 
writer.println("<member type='pgml' name='.pgml' />");
} 

if(containsToDo)//1
{ 
writer.println("<member type='todo' name='.todo' />");
} 

if(containsProfile)//1
{ 
String type = ProfileConfiguration.EXTENSION;
writer.println("<member type='" + type + "' name='."
                                   + type + "' />");
} 

} 

writer.println(line);
} 


//#if LOGGING 
if(LOG.isInfoEnabled())//1
{ 
LOG.info("Member count = " + memberCount);
} 

//#endif 

zis.close();
reader.close();
} 

public ZargoFilePersister()
    { 
} 

private URL toURL(File file) throws MalformedURLException
    { 
return file.toURI().toURL();
} 

@Override
    public boolean isSaveEnabled()
    { 
return false;
} 

@Override
    protected String getDesc()
    { 
return Translator.localize("combobox.filefilter.zargo");
} 

private int getPgmlCount(File file) throws IOException
    { 
return getEntryNames(file, ".pgml").size();
} 

private static class SubInputStream extends FilterInputStream
  { 
private ZipInputStream in;
public ZipEntry getNextEntry() throws IOException
        { 
return in.getNextEntry();
} 

public SubInputStream(ZipInputStream z)
        { 
super(z);
in = z;
} 

@Override
        public void close() throws IOException
        { 
in.closeEntry();
} 

 } 

 } 


