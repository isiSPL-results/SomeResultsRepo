
//#if -354147579 
// Compilation Unit of /ZargoFilePersister.java 
 

//#if -591889577 
package org.argouml.persistence;
//#endif 


//#if -530046416 
import java.io.BufferedReader;
//#endif 


//#if -7451520 
import java.io.BufferedWriter;
//#endif 


//#if -335378634 
import java.io.File;
//#endif 


//#if -1492645344 
import java.io.FileNotFoundException;
//#endif 


//#if -1482734891 
import java.io.FileOutputStream;
//#endif 


//#if 509301138 
import java.io.FilterInputStream;
//#endif 


//#if 928846491 
import java.io.IOException;
//#endif 


//#if -1089443654 
import java.io.InputStream;
//#endif 


//#if -1661459209 
import java.io.InputStreamReader;
//#endif 


//#if 1909298110 
import java.io.OutputStreamWriter;
//#endif 


//#if 1549066724 
import java.io.PrintWriter;
//#endif 


//#if 1759128335 
import java.io.Reader;
//#endif 


//#if 316844683 
import java.io.UnsupportedEncodingException;
//#endif 


//#if -2013244065 
import java.io.Writer;
//#endif 


//#if 1123573328 
import java.net.MalformedURLException;
//#endif 


//#if 1484890716 
import java.net.URL;
//#endif 


//#if -1342413487 
import java.util.ArrayList;
//#endif 


//#if -1293352336 
import java.util.List;
//#endif 


//#if -1579061744 
import java.util.zip.ZipEntry;
//#endif 


//#if -167743400 
import java.util.zip.ZipInputStream;
//#endif 


//#if 1340014227 
import java.util.zip.ZipOutputStream;
//#endif 


//#if 2095322790 
import org.argouml.application.api.Argo;
//#endif 


//#if 1523978722 
import org.argouml.application.helpers.ApplicationVersion;
//#endif 


//#if 282886011 
import org.argouml.i18n.Translator;
//#endif 


//#if -1258794071 
import org.argouml.kernel.Project;
//#endif 


//#if 178973027 
import org.argouml.kernel.ProjectFactory;
//#endif 


//#if 383969711 
import org.argouml.kernel.ProjectMember;
//#endif 


//#if -1512396793 
import org.argouml.kernel.ProfileConfiguration;
//#endif 


//#if 1396695210 
import org.argouml.util.FileConstants;
//#endif 


//#if 1931500054 
import org.argouml.util.ThreadUtils;
//#endif 


//#if -1252701624 
import org.xml.sax.InputSource;
//#endif 


//#if -557889116 
import org.xml.sax.SAXException;
//#endif 


//#if 1455887438 
import org.apache.log4j.Logger;
//#endif 


//#if -660031870 
class ZargoFilePersister extends 
//#if 1569562295 
UmlFilePersister
//#endif 

  { 

//#if -2088889990 
private static final Logger LOG =
        Logger.getLogger(ZargoFilePersister.class);
//#endif 


//#if -1111650919 
private void readerToWriter(
        Reader reader,
        Writer writer) throws IOException
    { 

//#if -1821592124 
int ch;
//#endif 


//#if -891444685 
while ((ch = reader.read()) != -1) //1
{ 

//#if 509841562 
if((ch != 0xFFFF) && (ch != 8))//1
{ 

//#if -893275978 
writer.write(ch);
//#endif 

} 

//#endif 


//#if -1920888699 
if(ch == 0xFFFF)//1
{ 

//#if -1130010257 
LOG.info("Stripping out 0xFFFF from save file");
//#endif 

} 
else

//#if -213782079 
if(ch == 8)//1
{ 

//#if 1387327429 
LOG.info("Stripping out 0x8 from save file");
//#endif 

} 
else
{ 

//#if -1524404578 
writer.write(ch);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -82911632 
private void copyDiagrams(File file, String encoding, PrintWriter writer)
    throws IOException
    { 

//#if 1879730969 
ZipInputStream zis = new ZipInputStream(toURL(file).openStream());
//#endif 


//#if 1018139787 
SubInputStream sub = new SubInputStream(zis);
//#endif 


//#if -1615988473 
ZipEntry currentEntry = null;
//#endif 


//#if -1655610269 
while ((currentEntry = sub.getNextEntry()) != null) //1
{ 

//#if 314132186 
if(currentEntry.getName().endsWith(".pgml"))//1
{ 

//#if 890447923 
BufferedReader reader = new BufferedReader(
                    new InputStreamReader(sub, encoding));
//#endif 


//#if 367240571 
String firstLine = reader.readLine();
//#endif 


//#if -82152887 
if(firstLine.startsWith("<?xml"))//1
{ 

//#if -455153160 
reader.readLine();
//#endif 

} 
else
{ 

//#if -1251106769 
writer.println(firstLine);
//#endif 

} 

//#endif 


//#if -1190987133 
readerToWriter(reader, writer);
//#endif 


//#if 1720533660 
sub.close();
//#endif 


//#if -108953759 
reader.close();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1711878290 
zis.close();
//#endif 

} 

//#endif 


//#if -1804549290 
private void copyMember(File file, String tag, String outputEncoding,
                            PrintWriter writer) throws IOException, MalformedURLException,
        UnsupportedEncodingException
    { 

//#if -1911671652 
ZipInputStream zis = openZipStreamAt(toURL(file), "." + tag);
//#endif 


//#if 1116225836 
if(zis != null)//1
{ 

//#if -1993058190 
InputStreamReader isr = new InputStreamReader(zis, outputEncoding);
//#endif 


//#if -308877881 
BufferedReader reader = new BufferedReader(isr);
//#endif 


//#if -807465894 
String firstLine = reader.readLine();
//#endif 


//#if 601333096 
if(firstLine.startsWith("<?xml"))//1
{ 

//#if 392270131 
reader.readLine();
//#endif 

} 
else
{ 

//#if 1735517482 
writer.println(firstLine);
//#endif 

} 

//#endif 


//#if 1430956258 
readerToWriter(reader, writer);
//#endif 


//#if -1854094761 
zis.close();
//#endif 


//#if -1191919902 
reader.close();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 874190767 
private URL makeZipEntryUrl(URL url, String entryName)
    throws MalformedURLException
    { 

//#if 341171120 
String entryURL = "jar:" + url + "!/" + entryName;
//#endif 


//#if -176453336 
return new URL(entryURL);
//#endif 

} 

//#endif 


//#if -15452572 
private List<String> getEntryNames(File file, String extension)
    throws IOException, MalformedURLException
    { 

//#if 1027163170 
ZipInputStream zis = new ZipInputStream(toURL(file).openStream());
//#endif 


//#if -1455756560 
List<String> result = new ArrayList<String>();
//#endif 


//#if -308798436 
ZipEntry entry = zis.getNextEntry();
//#endif 


//#if -1236431177 
while (entry != null) //1
{ 

//#if -646468411 
String name = entry.getName();
//#endif 


//#if -759005019 
if(extension == null || name.endsWith(extension))//1
{ 

//#if 2092427820 
result.add(name);
//#endif 

} 

//#endif 


//#if 1622343371 
entry = zis.getNextEntry();
//#endif 

} 

//#endif 


//#if 944623067 
zis.close();
//#endif 


//#if -1689438593 
return result;
//#endif 

} 

//#endif 


//#if 534659444 
private boolean containsProfile(File file) throws IOException
    { 

//#if -589177349 
return !getEntryNames(file, "." + ProfileConfiguration.EXTENSION)
               .isEmpty();
//#endif 

} 

//#endif 


//#if 866094722 
private InputStream openZipEntry(URL url, String entryName)
    throws MalformedURLException, IOException
    { 

//#if 1912168712 
return makeZipEntryUrl(url, entryName).openStream();
//#endif 

} 

//#endif 


//#if -2131696321 
private File zargoToUml(File file, ProgressMgr progressMgr)
    throws OpenException, InterruptedException
    { 

//#if 583996030 
File combinedFile = null;
//#endif 


//#if -215594048 
try //1
{ 

//#if -105535973 
combinedFile = File.createTempFile("combinedzargo_", ".uml");
//#endif 


//#if -878555214 
LOG.info(
                "Combining old style zargo sub files into new style uml file "
                + combinedFile.getAbsolutePath());
//#endif 


//#if -762620387 
combinedFile.deleteOnExit();
//#endif 


//#if 829622629 
String encoding = Argo.getEncoding();
//#endif 


//#if -937323226 
FileOutputStream stream = new FileOutputStream(combinedFile);
//#endif 


//#if 852051713 
PrintWriter writer =
                new PrintWriter(new BufferedWriter(
                                    new OutputStreamWriter(stream, encoding)));
//#endif 


//#if 749360453 
writer.println("<?xml version = \"1.0\" " + "encoding = \""
                           + encoding + "\" ?>");
//#endif 


//#if 289715120 
copyArgo(file, encoding, writer);
//#endif 


//#if -114648275 
progressMgr.nextPhase();
//#endif 


//#if 37530910 
copyMember(file, "profile", encoding, writer);
//#endif 


//#if -365541233 
copyXmi(file, encoding, writer);
//#endif 


//#if -1101955799 
copyDiagrams(file, encoding, writer);
//#endif 


//#if -1276794469 
copyMember(file, "todo", encoding, writer);
//#endif 


//#if -987713531 
progressMgr.nextPhase();
//#endif 


//#if 230724977 
writer.println("</uml>");
//#endif 


//#if 1972064197 
writer.close();
//#endif 


//#if -1521147176 
LOG.info("Completed combining files");
//#endif 

} 

//#if 1980158142 
catch (IOException e) //1
{ 

//#if 763128045 
throw new OpenException(e);
//#endif 

} 

//#endif 


//#endif 


//#if -1851460032 
return combinedFile;
//#endif 

} 

//#endif 


//#if 425591459 
private boolean containsTodo(File file) throws IOException
    { 

//#if -763326809 
return !getEntryNames(file, ".todo").isEmpty();
//#endif 

} 

//#endif 


//#if -1977289147 
@Override
    public Project doLoad(File file)
    throws OpenException, InterruptedException
    { 

//#if -676351969 
ProgressMgr progressMgr = new ProgressMgr();
//#endif 


//#if 1975808446 
progressMgr.setNumberOfPhases(3 + UML_PHASES_LOAD);
//#endif 


//#if -2146798295 
ThreadUtils.checkIfInterrupted();
//#endif 


//#if 731444705 
int fileVersion;
//#endif 


//#if 346983788 
String releaseVersion;
//#endif 


//#if 1473530083 
try //1
{ 

//#if 743198803 
String argoEntry = getEntryNames(file, ".argo").iterator().next();
//#endif 


//#if 2016477266 
URL argoUrl = makeZipEntryUrl(toURL(file), argoEntry);
//#endif 


//#if -1024124457 
fileVersion = getPersistenceVersion(argoUrl.openStream());
//#endif 


//#if -1923153734 
releaseVersion = getReleaseVersion(argoUrl.openStream());
//#endif 

} 

//#if 1986879895 
catch (MalformedURLException e) //1
{ 

//#if 874407841 
throw new OpenException(e);
//#endif 

} 

//#endif 


//#if -1882707543 
catch (IOException e) //1
{ 

//#if -442862262 
throw new OpenException(e);
//#endif 

} 

//#endif 


//#endif 


//#if 591181616 
boolean upgradeRequired = true;
//#endif 


//#if 1369004438 
LOG.info("Loading zargo file of version " + fileVersion);
//#endif 


//#if 361369339 
final Project p;
//#endif 


//#if 2034898309 
if(upgradeRequired)//1
{ 

//#if -156630776 
File combinedFile = zargoToUml(file, progressMgr);
//#endif 


//#if -69653596 
p = super.doLoad(file, combinedFile, progressMgr);
//#endif 

} 
else
{ 

//#if -275353559 
p = loadFromZargo(file, progressMgr);
//#endif 

} 

//#endif 


//#if 584057186 
progressMgr.nextPhase();
//#endif 


//#if 1097606782 
PersistenceManager.getInstance().setProjectURI(file.toURI(), p);
//#endif 


//#if 803461608 
return p;
//#endif 

} 

//#endif 


//#if 1361253324 
private void copyXmi(File file, String encoding, PrintWriter writer)
    throws IOException, MalformedURLException,
        UnsupportedEncodingException
    { 

//#if -1294548221 
ZipInputStream zis = openZipStreamAt(toURL(file), ".xmi");
//#endif 


//#if -401980801 
BufferedReader reader = new BufferedReader(
            new InputStreamReader(zis, encoding));
//#endif 


//#if 1942489769 
reader.readLine();
//#endif 


//#if -1622132197 
readerToWriter(reader, writer);
//#endif 


//#if -1769513008 
zis.close();
//#endif 


//#if 1732248265 
reader.close();
//#endif 

} 

//#endif 


//#if 1050359682 
private Project loadFromZargo(File file, ProgressMgr progressMgr)
    throws OpenException
    { 

//#if -206134861 
Project p = ProjectFactory.getInstance().createProject(file.toURI());
//#endif 


//#if 80686739 
try //1
{ 

//#if -1512266134 
progressMgr.nextPhase();
//#endif 


//#if -432887693 
ArgoParser parser = new ArgoParser();
//#endif 


//#if -542497344 
String argoEntry = getEntryNames(file, ".argo").iterator().next();
//#endif 


//#if -1762041019 
parser.readProject(p, new InputSource(makeZipEntryUrl(toURL(file),
                                                  argoEntry).toExternalForm()));
//#endif 


//#if 1502335017 
List memberList = parser.getMemberList();
//#endif 


//#if 2038588431 
LOG.info(memberList.size() + " members");
//#endif 


//#if 1819714370 
String xmiEntry = getEntryNames(file, ".xmi").iterator().next();
//#endif 


//#if 862808065 
MemberFilePersister persister = getMemberFilePersister("xmi");
//#endif 


//#if 140061270 
persister.load(p, makeZipEntryUrl(toURL(file), xmiEntry));
//#endif 


//#if 2029637308 
List<String> entries = getEntryNames(file, null);
//#endif 


//#if -496825906 
for (String name : entries) //1
{ 

//#if -1329706277 
String ext = name.substring(name.lastIndexOf('.') + 1);
//#endif 


//#if -1499263511 
if(!"argo".equals(ext) && !"xmi".equals(ext))//1
{ 

//#if -1131144743 
persister = getMemberFilePersister(ext);
//#endif 


//#if -1892582164 
LOG.info("Loading member with "
                             + persister.getClass().getName());
//#endif 


//#if -270485212 
persister.load(p, openZipEntry(toURL(file), name));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2008383576 
progressMgr.nextPhase();
//#endif 


//#if -1565329119 
ThreadUtils.checkIfInterrupted();
//#endif 


//#if 450388129 
p.postLoad();
//#endif 


//#if -2119463184 
return p;
//#endif 

} 

//#if -1708837038 
catch (InterruptedException e) //1
{ 

//#if 467427075 
return null;
//#endif 

} 

//#endif 


//#if -2045614176 
catch (MalformedURLException e) //1
{ 

//#if -1053457987 
throw new OpenException(e);
//#endif 

} 

//#endif 


//#if 1290958578 
catch (IOException e) //1
{ 

//#if 949287765 
throw new OpenException(e);
//#endif 

} 

//#endif 


//#if 1337445626 
catch (SAXException e) //1
{ 

//#if 1183316521 
throw new OpenException(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -2011150890 
@Override
    public void doSave(Project project, File file) throws SaveException,
               InterruptedException
    { 

//#if 306629810 
LOG.info("Saving");
//#endif 


//#if 1077823048 
ProgressMgr progressMgr = new ProgressMgr();
//#endif 


//#if -617210017 
progressMgr.setNumberOfPhases(4);
//#endif 


//#if 1698302347 
progressMgr.nextPhase();
//#endif 


//#if 1767063265 
File lastArchiveFile = new File(file.getAbsolutePath() + "~");
//#endif 


//#if -1611730151 
File tempFile = null;
//#endif 


//#if -965199540 
try //1
{ 

//#if 1371307621 
tempFile = createTempFile(file);
//#endif 

} 

//#if 1226419201 
catch (FileNotFoundException e) //1
{ 

//#if -1375515195 
throw new SaveException(
                "Failed to archive the previous file version", e);
//#endif 

} 

//#endif 


//#if -1792877124 
catch (IOException e) //1
{ 

//#if -1804795324 
throw new SaveException(
                "Failed to archive the previous file version", e);
//#endif 

} 

//#endif 


//#endif 


//#if 142919331 
ZipOutputStream stream = null;
//#endif 


//#if 546627045 
try //2
{ 

//#if -1921441539 
project.setFile(file);
//#endif 


//#if -1770052786 
project.setVersion(ApplicationVersion.getVersion());
//#endif 


//#if 64930360 
project.setPersistenceVersion(PERSISTENCE_VERSION);
//#endif 


//#if 923159675 
stream = new ZipOutputStream(new FileOutputStream(file));
//#endif 


//#if -298537268 
for (ProjectMember projectMember : project.getMembers()) //1
{ 

//#if 1412010927 
if(projectMember.getType().equalsIgnoreCase("xmi"))//1
{ 

//#if 626936236 
if(LOG.isInfoEnabled())//1
{ 

//#if -1045743861 
LOG.info("Saving member of type: "
                                 + projectMember.getType());
//#endif 

} 

//#endif 


//#if 1634118265 
stream.putNextEntry(
                        new ZipEntry(projectMember.getZipName()));
//#endif 


//#if 950976394 
MemberFilePersister persister =
                        getMemberFilePersister(projectMember);
//#endif 


//#if 1882599642 
persister.save(projectMember, stream);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1842585498 
if(lastArchiveFile.exists())//1
{ 

//#if -1953313449 
lastArchiveFile.delete();
//#endif 

} 

//#endif 


//#if 1405696588 
if(tempFile.exists() && !lastArchiveFile.exists())//1
{ 

//#if -1183089460 
tempFile.renameTo(lastArchiveFile);
//#endif 

} 

//#endif 


//#if -592960568 
if(tempFile.exists())//1
{ 

//#if 558675531 
tempFile.delete();
//#endif 

} 

//#endif 


//#if 1670373093 
progressMgr.nextPhase();
//#endif 

} 

//#if -182680008 
catch (Exception e) //1
{ 

//#if 1567793747 
LOG.error("Exception occured during save attempt", e);
//#endif 


//#if 1754587669 
try //1
{ 

//#if -453713357 
if(stream != null)//1
{ 

//#if 461454130 
stream.close();
//#endif 

} 

//#endif 

} 

//#if 1688903923 
catch (Exception ex) //1
{ 
} 

//#endif 


//#endif 


//#if 82250812 
file.delete();
//#endif 


//#if 1623289982 
tempFile.renameTo(file);
//#endif 


//#if -805067288 
throw new SaveException(e);
//#endif 

} 

//#endif 


//#endif 


//#if 546656837 
try //3
{ 

//#if -261274846 
stream.close();
//#endif 

} 

//#if 1870408443 
catch (IOException ex) //1
{ 

//#if -498595031 
LOG.error("Failed to close save output writer", ex);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -353575318 
@Override
    public String getExtension()
    { 

//#if -1951442939 
return "zargo";
//#endif 

} 

//#endif 


//#if 1168209979 
private ZipInputStream openZipStreamAt(URL url, String ext)
    throws IOException
    { 

//#if 1399334563 
ZipInputStream zis = new ZipInputStream(url.openStream());
//#endif 


//#if -2095032827 
ZipEntry entry = zis.getNextEntry();
//#endif 


//#if 2106676329 
while (entry != null && !entry.getName().endsWith(ext)) //1
{ 

//#if 1211556074 
entry = zis.getNextEntry();
//#endif 

} 

//#endif 


//#if 584113404 
if(entry == null)//1
{ 

//#if -90662120 
zis.close();
//#endif 


//#if 1659943352 
return null;
//#endif 

} 

//#endif 


//#if 1617455789 
return zis;
//#endif 

} 

//#endif 


//#if -132909598 
private void copyArgo(File file, String encoding, PrintWriter writer)
    throws IOException, MalformedURLException, OpenException,
        UnsupportedEncodingException
    { 

//#if -1921506212 
int pgmlCount = getPgmlCount(file);
//#endif 


//#if -879572347 
boolean containsToDo = containsTodo(file);
//#endif 


//#if 123308491 
boolean containsProfile = containsProfile(file);
//#endif 


//#if -691550368 
ZipInputStream zis =
            openZipStreamAt(toURL(file), FileConstants.PROJECT_FILE_EXT);
//#endif 


//#if 593914148 
if(zis == null)//1
{ 

//#if -369348726 
throw new OpenException(
                "There is no .argo file in the .zargo");
//#endif 

} 

//#endif 


//#if 1095277338 
String line;
//#endif 


//#if -1063677241 
BufferedReader reader =
            new BufferedReader(new InputStreamReader(zis, encoding));
//#endif 


//#if 527631832 
String rootLine;
//#endif 


//#if -33853794 
do{ 

//#if 1590171287 
rootLine = reader.readLine();
//#endif 


//#if -1917278885 
if(rootLine == null)//1
{ 

//#if 1629310876 
throw new OpenException(
                    "Can't find an <argo> tag in the argo file");
//#endif 

} 

//#endif 

} 
 while(!rootLine.startsWith("<argo"));//1

//#endif 


//#if -229136900 
String version = getVersion(rootLine);
//#endif 


//#if -1337262539 
writer.println("<uml version=\"" + version + "\">");
//#endif 


//#if 293145024 
writer.println(rootLine);
//#endif 


//#if 1866850424 
LOG.info("Transfering argo contents");
//#endif 


//#if 205041894 
int memberCount = 0;
//#endif 


//#if 884241874 
while ((line = reader.readLine()) != null) //1
{ 

//#if -2026878217 
if(line.trim().startsWith("<member"))//1
{ 

//#if -1008014601 
++memberCount;
//#endif 

} 

//#endif 


//#if -1538765914 
if(line.trim().equals("</argo>") && memberCount == 0)//1
{ 

//#if 15372285 
LOG.info("Inserting member info");
//#endif 


//#if -1903527824 
writer.println("<member type='xmi' name='.xmi' />");
//#endif 


//#if -896274731 
for (int i = 0; i < pgmlCount; ++i) //1
{ 

//#if 548066953 
writer.println("<member type='pgml' name='.pgml' />");
//#endif 

} 

//#endif 


//#if -1522139568 
if(containsToDo)//1
{ 

//#if 1509432478 
writer.println("<member type='todo' name='.todo' />");
//#endif 

} 

//#endif 


//#if 2058334223 
if(containsProfile)//1
{ 

//#if 1026432056 
String type = ProfileConfiguration.EXTENSION;
//#endif 


//#if 937139427 
writer.println("<member type='" + type + "' name='."
                                   + type + "' />");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -631810693 
writer.println(line);
//#endif 

} 

//#endif 


//#if -1478151367 
if(LOG.isInfoEnabled())//1
{ 

//#if 1643158963 
LOG.info("Member count = " + memberCount);
//#endif 

} 

//#endif 


//#if 235133064 
zis.close();
//#endif 


//#if 623128337 
reader.close();
//#endif 

} 

//#endif 


//#if 526260866 
public ZargoFilePersister()
    { 
} 

//#endif 


//#if 866742339 
private URL toURL(File file) throws MalformedURLException
    { 

//#if 81925097 
return file.toURI().toURL();
//#endif 

} 

//#endif 


//#if 466898114 
@Override
    public boolean isSaveEnabled()
    { 

//#if 1500761566 
return false;
//#endif 

} 

//#endif 


//#if -1953930993 
@Override
    protected String getDesc()
    { 

//#if -903162574 
return Translator.localize("combobox.filefilter.zargo");
//#endif 

} 

//#endif 


//#if -1998420578 
private int getPgmlCount(File file) throws IOException
    { 

//#if 1155139305 
return getEntryNames(file, ".pgml").size();
//#endif 

} 

//#endif 


//#if 1859837815 
private static class SubInputStream extends 
//#if -28715129 
FilterInputStream
//#endif 

  { 

//#if -764006955 
private ZipInputStream in;
//#endif 


//#if -217187443 
public ZipEntry getNextEntry() throws IOException
        { 

//#if -1958642029 
return in.getNextEntry();
//#endif 

} 

//#endif 


//#if -1302320926 
public SubInputStream(ZipInputStream z)
        { 

//#if -876441137 
super(z);
//#endif 


//#if -880977271 
in = z;
//#endif 

} 

//#endif 


//#if 1227443521 
@Override
        public void close() throws IOException
        { 

//#if 375323399 
in.closeEntry();
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

