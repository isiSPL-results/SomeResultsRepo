
//#if 729684533 
// Compilation Unit of /UmlFilePersister.java 
 

//#if -488886914 
package org.argouml.persistence;
//#endif 


//#if 552437426 
import java.io.BufferedInputStream;
//#endif 


//#if 1078997527 
import java.io.BufferedReader;
//#endif 


//#if 1601592423 
import java.io.BufferedWriter;
//#endif 


//#if -809829411 
import java.io.File;
//#endif 


//#if -1009575 
import java.io.FileNotFoundException;
//#endif 


//#if -1379732228 
import java.io.FileOutputStream;
//#endif 


//#if 1054869760 
import java.io.FilterOutputStream;
//#endif 


//#if 14574612 
import java.io.IOException;
//#endif 


//#if -2003715533 
import java.io.InputStream;
//#endif 


//#if 1531623344 
import java.io.InputStreamReader;
//#endif 


//#if 259452952 
import java.io.OutputStream;
//#endif 


//#if 2110609445 
import java.io.OutputStreamWriter;
//#endif 


//#if 634794845 
import java.io.PrintWriter;
//#endif 


//#if 1078465014 
import java.io.Reader;
//#endif 


//#if 1828805170 
import java.io.UnsupportedEncodingException;
//#endif 


//#if 1601059910 
import java.io.Writer;
//#endif 


//#if 119641911 
import java.net.MalformedURLException;
//#endif 


//#if 1010439939 
import java.net.URL;
//#endif 


//#if -1866281581 
import java.nio.ByteBuffer;
//#endif 


//#if 841090949 
import java.nio.CharBuffer;
//#endif 


//#if 1550461713 
import java.nio.charset.Charset;
//#endif 


//#if -1513203455 
import java.nio.charset.CharsetDecoder;
//#endif 


//#if 1923842427 
import java.nio.charset.CoderResult;
//#endif 


//#if -677790135 
import java.nio.charset.CodingErrorAction;
//#endif 


//#if 566076161 
import java.util.Hashtable;
//#endif 


//#if -1974015657 
import java.util.List;
//#endif 


//#if 970140246 
import java.util.regex.Matcher;
//#endif 


//#if 1919226808 
import java.util.regex.Pattern;
//#endif 


//#if -292881305 
import javax.xml.transform.Result;
//#endif 


//#if 41129785 
import javax.xml.transform.Transformer;
//#endif 


//#if -1601209170 
import javax.xml.transform.TransformerException;
//#endif 


//#if 171410387 
import javax.xml.transform.TransformerFactory;
//#endif 


//#if -1127689241 
import javax.xml.transform.stream.StreamResult;
//#endif 


//#if 47854505 
import javax.xml.transform.stream.StreamSource;
//#endif 


//#if -610094643 
import org.argouml.application.api.Argo;
//#endif 


//#if 1144574281 
import org.argouml.application.helpers.ApplicationVersion;
//#endif 


//#if -2066397196 
import org.argouml.i18n.Translator;
//#endif 


//#if -1057482736 
import org.argouml.kernel.Project;
//#endif 


//#if -2084588772 
import org.argouml.kernel.ProjectFactory;
//#endif 


//#if 1973519574 
import org.argouml.kernel.ProjectMember;
//#endif 


//#if -521554376 
import org.argouml.model.UmlException;
//#endif 


//#if 2118164669 
import org.argouml.util.ThreadUtils;
//#endif 


//#if -107541765 
import org.tigris.gef.ocl.ExpansionException;
//#endif 


//#if -118840052 
import org.tigris.gef.ocl.OCLExpander;
//#endif 


//#if -764591858 
import org.tigris.gef.ocl.TemplateReader;
//#endif 


//#if -454886453 
import org.xml.sax.SAXException;
//#endif 


//#if -203357881 
import org.apache.log4j.Logger;
//#endif 


//#if -1610399617 
public class UmlFilePersister extends 
//#if -1231225559 
AbstractFilePersister
//#endif 

  { 

//#if -566651788 
public static final int PERSISTENCE_VERSION = 6;
//#endif 


//#if -1806172257 
protected static final int UML_PHASES_LOAD = 2;
//#endif 


//#if 1624262419 
private static final String ARGO_TEE =
        "/org/argouml/persistence/argo.tee";
//#endif 


//#if 578434405 
private static final Logger LOG =
        Logger.getLogger(UmlFilePersister.class);
//#endif 


//#if -1228362141 
protected int getPersistenceVersion(InputStream inputStream)
    throws OpenException
    { 

//#if -563650071 
BufferedReader reader = null;
//#endif 


//#if 356368771 
try //1
{ 

//#if 561548529 
reader = new BufferedReader(new InputStreamReader(inputStream,
                                        Argo.getEncoding()));
//#endif 


//#if 1336714019 
String rootLine = reader.readLine();
//#endif 


//#if -1057093785 
while (rootLine != null && !rootLine.trim().startsWith("<argo ")) //1
{ 

//#if -388893646 
rootLine = reader.readLine();
//#endif 

} 

//#endif 


//#if 625568888 
if(rootLine == null)//1
{ 

//#if -264375130 
return 1;
//#endif 

} 

//#endif 


//#if -36033229 
return Integer.parseInt(getVersion(rootLine));
//#endif 

} 

//#if -901606367 
catch (IOException e) //1
{ 

//#if 1425205605 
throw new OpenException(e);
//#endif 

} 

//#endif 


//#if 368852475 
catch (NumberFormatException e) //1
{ 

//#if -138848787 
throw new OpenException(e);
//#endif 

} 

//#endif 

finally { 

//#if -1297511394 
try //1
{ 

//#if 1451211066 
if(reader != null)//1
{ 

//#if 863493792 
reader.close();
//#endif 

} 

//#endif 

} 

//#if -1921593514 
catch (IOException e) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -1888419037 
protected String getDesc()
    { 

//#if -1732430085 
return Translator.localize("combobox.filefilter.uml");
//#endif 

} 

//#endif 


//#if -491593261 
void writeProject(Project project,
                      OutputStream oStream,
                      ProgressMgr progressMgr) throws SaveException,
                                      InterruptedException
    { 

//#if 194426272 
OutputStreamWriter outputStreamWriter;
//#endif 


//#if 1603667305 
try //1
{ 

//#if 1201169083 
outputStreamWriter =
                new OutputStreamWriter(oStream, Argo.getEncoding());
//#endif 

} 

//#if 1223201872 
catch (UnsupportedEncodingException e) //1
{ 

//#if -278281309 
throw new SaveException(e);
//#endif 

} 

//#endif 


//#endif 


//#if 380833798 
PrintWriter writer =
            new PrintWriter(new BufferedWriter(outputStreamWriter));
//#endif 


//#if -368620205 
XmlFilterOutputStream filteredStream =
            new XmlFilterOutputStream(oStream, Argo.getEncoding());
//#endif 


//#if 1931526312 
try //2
{ 

//#if 179038622 
writer.println("<?xml version = \"1.0\" "
                           + "encoding = \""
                           + Argo.getEncoding() + "\" ?>");
//#endif 


//#if 1893440340 
writer.println("<uml version=\"" + PERSISTENCE_VERSION + "\">");
//#endif 


//#if -1137006861 
try //1
{ 

//#if 1767143782 
Hashtable templates =
                    TemplateReader.getInstance().read(ARGO_TEE);
//#endif 


//#if 37899606 
OCLExpander expander = new OCLExpander(templates);
//#endif 


//#if -1910922534 
expander.expand(writer, project, "  ");
//#endif 

} 

//#if 769340898 
catch (ExpansionException e) //1
{ 

//#if -294707185 
throw new SaveException(e);
//#endif 

} 

//#endif 


//#endif 


//#if -1265789612 
writer.flush();
//#endif 


//#if -1317437464 
if(progressMgr != null)//1
{ 

//#if 1500971720 
progressMgr.nextPhase();
//#endif 

} 

//#endif 


//#if -520929121 
for (ProjectMember projectMember : project.getMembers()) //1
{ 

//#if -12793813 
if(LOG.isInfoEnabled())//1
{ 

//#if 48135034 
LOG.info("Saving member : " + projectMember);
//#endif 

} 

//#endif 


//#if 199973867 
MemberFilePersister persister
                    = getMemberFilePersister(projectMember);
//#endif 


//#if -1639737855 
filteredStream.startEntry();
//#endif 


//#if -1021060302 
persister.save(projectMember, filteredStream);
//#endif 


//#if -1881466812 
try //1
{ 

//#if -1174807602 
filteredStream.flush();
//#endif 

} 

//#if 1776565699 
catch (IOException e) //1
{ 

//#if 214202678 
throw new SaveException(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -2055848500 
writer.println("</uml>");
//#endif 


//#if 674574462 
writer.flush();
//#endif 

} 
finally { 

//#if 608469472 
writer.close();
//#endif 


//#if -2075049229 
try //1
{ 

//#if 633801172 
filteredStream.reallyClose();
//#endif 

} 

//#if -1455305218 
catch (IOException e) //1
{ 

//#if 1927217561 
throw new SaveException(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 1504152917 
public UmlFilePersister()
    { 
} 

//#endif 


//#if -1688401010 
@Override
    public boolean isSaveEnabled()
    { 

//#if -465824678 
return true;
//#endif 

} 

//#endif 


//#if 292283207 
protected Project doLoad(File originalFile, File file,
                             ProgressMgr progressMgr) throws OpenException,
        InterruptedException
    { 

//#if -380611515 
XmlInputStream inputStream = null;
//#endif 


//#if -1078523553 
try //1
{ 

//#if 1524109353 
Project p = ProjectFactory.getInstance()
                        .createProject(file.toURI());
//#endif 


//#if 176972958 
int fileVersion = getPersistenceVersionFromFile(file);
//#endif 


//#if -1121370883 
LOG.info("Loading uml file of version " + fileVersion);
//#endif 


//#if 2005246750 
if(!checkVersion(fileVersion,  getReleaseVersionFromFile(file)))//1
{ 

//#if -764669868 
String release = getReleaseVersionFromFile(file);
//#endif 


//#if -115957616 
copyFile(
                    originalFile,
                    new File(originalFile.getAbsolutePath() + '~' + release));
//#endif 


//#if 1770629224 
progressMgr.setNumberOfPhases(progressMgr.getNumberOfPhases()
                                              + (PERSISTENCE_VERSION - fileVersion));
//#endif 


//#if -833878139 
while (fileVersion < PERSISTENCE_VERSION) //1
{ 

//#if -1615009475 
++fileVersion;
//#endif 


//#if -1574514607 
LOG.info("Upgrading to version " + fileVersion);
//#endif 


//#if 2049671205 
long startTime = System.currentTimeMillis();
//#endif 


//#if 655331101 
file = transform(file, fileVersion);
//#endif 


//#if 403440158 
long endTime = System.currentTimeMillis();
//#endif 


//#if -2100464689 
LOG.info("Upgrading took "
                             + ((endTime - startTime) / 1000)
                             + " seconds");
//#endif 


//#if 1396964051 
progressMgr.nextPhase();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 998317320 
progressMgr.nextPhase();
//#endif 


//#if -68535660 
inputStream = new XmlInputStream(
                file.toURI().toURL().openStream(),
                "argo",
                file.length(),
                100000);
//#endif 


//#if 143049621 
ArgoParser parser = new ArgoParser();
//#endif 


//#if 1763126176 
Reader reader =
                new InputStreamReader(inputStream,
                                      Argo.getEncoding());
//#endif 


//#if -253619566 
parser.readProject(p, reader);
//#endif 


//#if -661300665 
List memberList = parser.getMemberList();
//#endif 


//#if -125047251 
LOG.info(memberList.size() + " members");
//#endif 


//#if 542900191 
for (int i = 0; i < memberList.size(); ++i) //1
{ 

//#if 1944470841 
MemberFilePersister persister
                    = getMemberFilePersister((String) memberList.get(i));
//#endif 


//#if -1037344028 
LOG.info("Loading member with "
                         + persister.getClass().getName());
//#endif 


//#if 2081958445 
inputStream.reopen(persister.getMainTag());
//#endif 


//#if -557679397 
try //1
{ 

//#if 45921072 
persister.load(p, inputStream);
//#endif 

} 

//#if 1271051480 
catch (OpenException e) //1
{ 

//#if -931395513 
if("XMI".equals(persister.getMainTag())
                            && e.getCause() instanceof UmlException
                            && e.getCause().getCause() instanceof IOException)//1
{ 

//#if 1222133093 
inputStream.reopen("uml:Model");
//#endif 


//#if -512915132 
persister.load(p, inputStream);
//#endif 

} 
else
{ 

//#if 52131311 
throw e;
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1777198006 
progressMgr.nextPhase();
//#endif 


//#if -989391805 
ThreadUtils.checkIfInterrupted();
//#endif 


//#if 51288631 
inputStream.realClose();
//#endif 


//#if 362537155 
p.postLoad();
//#endif 


//#if -1415773810 
return p;
//#endif 

} 

//#if -1217795063 
catch (InterruptedException e) //1
{ 

//#if -589060244 
throw e;
//#endif 

} 

//#endif 


//#if -356030241 
catch (OpenException e) //1
{ 

//#if -1283568439 
throw e;
//#endif 

} 

//#endif 


//#if -1765259173 
catch (IOException e) //1
{ 

//#if -1761595061 
throw new OpenException(e);
//#endif 

} 

//#endif 


//#if 1083975857 
catch (SAXException e) //1
{ 

//#if -678564717 
throw new OpenException(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1639007524 
public boolean hasAnIcon()
    { 

//#if -1463999474 
return true;
//#endif 

} 

//#endif 


//#if -851398078 
public void doSave(Project project, File file)
    throws SaveException, InterruptedException
    { 

//#if 1888418234 
ProgressMgr progressMgr = new ProgressMgr();
//#endif 


//#if -187529171 
progressMgr.setNumberOfPhases(4);
//#endif 


//#if -1837899523 
progressMgr.nextPhase();
//#endif 


//#if -1417490861 
File lastArchiveFile = new File(file.getAbsolutePath() + "~");
//#endif 


//#if 1433651211 
File tempFile = null;
//#endif 


//#if 812607806 
try //1
{ 

//#if -1996302634 
tempFile = createTempFile(file);
//#endif 

} 

//#if -513255920 
catch (FileNotFoundException e) //1
{ 

//#if 1036375414 
throw new SaveException(
                "Failed to archive the previous file version", e);
//#endif 

} 

//#endif 


//#if 380436107 
catch (IOException e) //1
{ 

//#if 1080069873 
throw new SaveException(
                "Failed to archive the previous file version", e);
//#endif 

} 

//#endif 


//#endif 


//#if 1963544755 
try //2
{ 

//#if 1812538449 
project.setFile(file);
//#endif 


//#if 801741730 
project.setVersion(ApplicationVersion.getVersion());
//#endif 


//#if -1376129180 
project.setPersistenceVersion(PERSISTENCE_VERSION);
//#endif 


//#if -554568111 
OutputStream stream = new FileOutputStream(file);
//#endif 


//#if 819967630 
writeProject(project, stream, progressMgr);
//#endif 


//#if -528530484 
stream.close();
//#endif 


//#if -567517895 
progressMgr.nextPhase();
//#endif 


//#if 1874283881 
String path = file.getParent();
//#endif 


//#if -411880095 
if(LOG.isInfoEnabled())//1
{ 

//#if -583529359 
LOG.info("Dir ==" + path);
//#endif 

} 

//#endif 


//#if 436788114 
if(lastArchiveFile.exists())//1
{ 

//#if 720840372 
lastArchiveFile.delete();
//#endif 

} 

//#endif 


//#if -35362952 
if(tempFile.exists() && !lastArchiveFile.exists())//1
{ 

//#if -1469469324 
tempFile.renameTo(lastArchiveFile);
//#endif 

} 

//#endif 


//#if 1464115740 
if(tempFile.exists())//1
{ 

//#if 731259436 
tempFile.delete();
//#endif 

} 

//#endif 


//#if -1934286215 
progressMgr.nextPhase();
//#endif 

} 

//#if -1854188590 
catch (Exception e) //1
{ 

//#if 786318821 
LOG.error("Exception occured during save attempt", e);
//#endif 


//#if -572483094 
file.delete();
//#endif 


//#if 1080048812 
tempFile.renameTo(file);
//#endif 


//#if 1081246760 
if(e instanceof InterruptedException)//1
{ 

//#if 1270708422 
throw (InterruptedException) e;
//#endif 

} 
else
{ 

//#if 1062398807 
throw new SaveException(e);
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1452516529 
public Project doLoad(File file) throws OpenException,
        InterruptedException
    { 

//#if -857029796 
ProgressMgr progressMgr = new ProgressMgr();
//#endif 


//#if -2123197511 
progressMgr.setNumberOfPhases(UML_PHASES_LOAD);
//#endif 


//#if 1242684556 
ThreadUtils.checkIfInterrupted();
//#endif 


//#if 45574496 
return doLoad(file, file, progressMgr);
//#endif 

} 

//#endif 


//#if -2137576745 
protected boolean checkVersion(int fileVersion, String releaseVersion)
    throws OpenException, VersionException
    { 

//#if 519640563 
if(fileVersion > PERSISTENCE_VERSION)//1
{ 

//#if 965414827 
throw new VersionException(
                "The file selected is from a more up to date version of "
                + "ArgoUML. It has been saved with ArgoUML version "
                + releaseVersion
                + ". Please load with that or a more up to date"
                + "release of ArgoUML");
//#endif 

} 

//#endif 


//#if 677774286 
return fileVersion >= PERSISTENCE_VERSION;
//#endif 

} 

//#endif 


//#if -1821095042 
public String getExtension()
    { 

//#if 1989508135 
return "uml";
//#endif 

} 

//#endif 


//#if -786808128 
private int getPersistenceVersionFromFile(File file) throws OpenException
    { 

//#if 1523541905 
InputStream stream = null;
//#endif 


//#if 158165734 
try //1
{ 

//#if -2063695747 
stream = new BufferedInputStream(file.toURI().toURL()
                                             .openStream());
//#endif 


//#if -929423656 
int version = getPersistenceVersion(stream);
//#endif 


//#if -769956279 
stream.close();
//#endif 


//#if -942471366 
return version;
//#endif 

} 

//#if -1140461637 
catch (MalformedURLException e) //1
{ 

//#if 2077287216 
throw new OpenException(e);
//#endif 

} 

//#endif 


//#if -93236019 
catch (IOException e) //1
{ 

//#if 2112617386 
throw new OpenException(e);
//#endif 

} 

//#endif 

finally { 

//#if -584306695 
if(stream != null)//1
{ 

//#if 548132707 
try //1
{ 

//#if -1672629912 
stream.close();
//#endif 

} 

//#if -2038907464 
catch (IOException e) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 589507041 
protected String getVersion(String rootLine)
    { 

//#if 791155147 
String version;
//#endif 


//#if 430135797 
int versionPos = rootLine.indexOf("version=\"");
//#endif 


//#if 1731343466 
if(versionPos > 0)//1
{ 

//#if 474904101 
int startPos = versionPos + 9;
//#endif 


//#if -390962844 
int endPos = rootLine.indexOf("\"", startPos);
//#endif 


//#if 1216561227 
version = rootLine.substring(startPos, endPos);
//#endif 

} 
else
{ 

//#if -1161830204 
version = "1";
//#endif 

} 

//#endif 


//#if 2021037002 
return version;
//#endif 

} 

//#endif 


//#if -1798619487 
public final File transform(File file, int version)
    throws OpenException
    { 

//#if 870415174 
try //1
{ 

//#if -143274850 
String upgradeFilesPath = "/org/argouml/persistence/upgrades/";
//#endif 


//#if -2000499075 
String upgradeFile = "upgrade" + version + ".xsl";
//#endif 


//#if 452800385 
String xsltFileName = upgradeFilesPath + upgradeFile;
//#endif 


//#if 79374824 
URL xsltUrl = UmlFilePersister.class.getResource(xsltFileName);
//#endif 


//#if 1131546326 
LOG.info("Resource is " + xsltUrl);
//#endif 


//#if -1868695813 
StreamSource xsltStreamSource =
                new StreamSource(xsltUrl.openStream());
//#endif 


//#if -2115515146 
xsltStreamSource.setSystemId(xsltUrl.toExternalForm());
//#endif 


//#if -1160597687 
TransformerFactory factory = TransformerFactory.newInstance();
//#endif 


//#if -631578253 
Transformer transformer = factory.newTransformer(xsltStreamSource);
//#endif 


//#if 1210357539 
File transformedFile =
                File.createTempFile("upgrade_" + version + "_", ".uml");
//#endif 


//#if -2101331370 
transformedFile.deleteOnExit();
//#endif 


//#if 1045329635 
FileOutputStream stream =
                new FileOutputStream(transformedFile);
//#endif 


//#if 207507078 
Writer writer =
                new BufferedWriter(new OutputStreamWriter(stream,
                                   Argo.getEncoding()));
//#endif 


//#if -1187913794 
Result result = new StreamResult(writer);
//#endif 


//#if -1285281789 
StreamSource inputStreamSource = new StreamSource(file);
//#endif 


//#if -1315110648 
inputStreamSource.setSystemId(file);
//#endif 


//#if -1399764580 
transformer.transform(inputStreamSource, result);
//#endif 


//#if -587870360 
writer.close();
//#endif 


//#if -718895911 
return transformedFile;
//#endif 

} 

//#if -831835752 
catch (IOException e) //1
{ 

//#if -1974957451 
throw new OpenException(e);
//#endif 

} 

//#endif 


//#if 2015293955 
catch (TransformerException e) //1
{ 

//#if 61064754 
throw new OpenException(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -741323211 
protected String getReleaseVersion(InputStream inputStream)
    throws OpenException
    { 

//#if 847282635 
BufferedReader reader = null;
//#endif 


//#if 1130899045 
try //1
{ 

//#if 619163700 
reader = new BufferedReader(new InputStreamReader(inputStream,
                                        Argo.getEncoding()));
//#endif 


//#if 465957756 
String versionLine = reader.readLine();
//#endif 


//#if -593151188 
while (!versionLine.trim().startsWith("<version>")) //1
{ 

//#if -2057395111 
versionLine = reader.readLine();
//#endif 


//#if 1637680019 
if(versionLine == null)//1
{ 

//#if -679769279 
throw new OpenException(
                        "Failed to find the release <version> tag");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 890673840 
versionLine = versionLine.trim();
//#endif 


//#if -704283380 
int end = versionLine.lastIndexOf("</version>");
//#endif 


//#if 1852103839 
return versionLine.trim().substring(9, end);
//#endif 

} 

//#if -1312435545 
catch (IOException e) //1
{ 

//#if 1946992906 
throw new OpenException(e);
//#endif 

} 

//#endif 


//#if 146771201 
catch (NumberFormatException e) //1
{ 

//#if -2032785659 
throw new OpenException(e);
//#endif 

} 

//#endif 

finally { 

//#if -1699626263 
try //1
{ 

//#if 1575380841 
if(inputStream != null)//1
{ 

//#if -962036052 
inputStream.close();
//#endif 

} 

//#endif 


//#if 1795758106 
if(reader != null)//1
{ 

//#if -815091392 
reader.close();
//#endif 

} 

//#endif 

} 

//#if -1531716040 
catch (IOException e) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 1495300380 
private String getReleaseVersionFromFile(File file) throws OpenException
    { 

//#if 1310453110 
InputStream stream = null;
//#endif 


//#if -378115487 
try //1
{ 

//#if -1702768895 
stream = new BufferedInputStream(file.toURI().toURL().openStream());
//#endif 


//#if -1750216468 
String version = getReleaseVersion(stream);
//#endif 


//#if 1482628557 
stream.close();
//#endif 


//#if 238571318 
return version;
//#endif 

} 

//#if -459201084 
catch (MalformedURLException e) //1
{ 

//#if -1108756631 
throw new OpenException(e);
//#endif 

} 

//#endif 


//#if 898486806 
catch (IOException e) //1
{ 

//#if 1755181197 
throw new OpenException(e);
//#endif 

} 

//#endif 

finally { 

//#if 1729383351 
if(stream != null)//1
{ 

//#if 999774848 
try //1
{ 

//#if -732512298 
stream.close();
//#endif 

} 

//#if 1393579154 
catch (IOException e) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1059422770 
class XmlFilterOutputStream extends 
//#if -1341282312 
FilterOutputStream
//#endif 

  { 

//#if 1928037747 
private CharsetDecoder decoder;
//#endif 


//#if 122452408 
private boolean headerProcessed = false;
//#endif 


//#if 1901198772 
private static final int BUFFER_SIZE = 120;
//#endif 


//#if -1124327501 
private byte[] bytes = new byte[BUFFER_SIZE * 2];
//#endif 


//#if 576642122 
private ByteBuffer outBB = ByteBuffer.wrap(bytes);
//#endif 


//#if -746221575 
private ByteBuffer inBB = ByteBuffer.wrap(bytes);
//#endif 


//#if 786165493 
private CharBuffer outCB = CharBuffer.allocate(BUFFER_SIZE);
//#endif 


//#if 2096358424 
private final Pattern xmlDeclarationPattern = Pattern.compile(
                    "\\s*<\\?xml.*\\?>\\s*(<!DOCTYPE.*>\\s*)?");
//#endif 


//#if -1466205217 
public XmlFilterOutputStream(OutputStream outputStream,
                                     Charset charset)
        { 

//#if -212895212 
super(outputStream);
//#endif 


//#if -626420505 
decoder = charset.newDecoder();
//#endif 


//#if -2037069476 
decoder.onMalformedInput(CodingErrorAction.REPORT);
//#endif 


//#if 1481575747 
decoder.onUnmappableCharacter(CodingErrorAction.REPORT);
//#endif 


//#if 330670774 
startEntry();
//#endif 

} 

//#endif 


//#if -2018659923 
public XmlFilterOutputStream(OutputStream outputStream,
                                     String charsetName)
        { 

//#if -967367027 
this(outputStream, Charset.forName(charsetName));
//#endif 

} 

//#endif 


//#if 1858053037 
@Override
        public void close() throws IOException
        { 

//#if 1823621488 
flush();
//#endif 

} 

//#endif 


//#if 1087124257 
@Override
        public void flush() throws IOException
        { 

//#if 243328670 
if(!headerProcessed)//1
{ 

//#if 1623775101 
processHeader();
//#endif 

} 

//#endif 


//#if -776173461 
out.flush();
//#endif 

} 

//#endif 


//#if -681619926 
public void reallyClose() throws IOException
        { 

//#if -937540993 
out.close();
//#endif 

} 

//#endif 


//#if -484745929 
private void processHeader() throws IOException
        { 

//#if -1303419807 
headerProcessed = true;
//#endif 


//#if 1466353524 
outCB.position(0);
//#endif 


//#if -1341502053 
Matcher matcher = xmlDeclarationPattern.matcher(outCB);
//#endif 


//#if 1726209579 
String headerRemainder = matcher.replaceAll("");
//#endif 


//#if -1948819376 
int index = headerRemainder.length() - 1;
//#endif 


//#if 1429555833 
if(headerRemainder.charAt(index) == '\0')//1
{ 

//#if 923196402 
do{ 

//#if -1053005136 
index--;
//#endif 

} 
 while (index >= 0 && headerRemainder.charAt(index) == '\0');//1

//#endif 


//#if -281155885 
headerRemainder = headerRemainder.substring(0, index + 1);
//#endif 

} 

//#endif 


//#if 1494658280 
ByteBuffer bb = decoder.charset().encode(headerRemainder);
//#endif 


//#if 1761941509 
byte[] outBytes = new byte[bb.limit()];
//#endif 


//#if 774802367 
bb.get(outBytes);
//#endif 


//#if 291879031 
out.write(outBytes, 0, outBytes.length);
//#endif 


//#if 1562052323 
if(inBB.remaining() > 0)//1
{ 

//#if -625033721 
out.write(inBB.array(), inBB.position(),
                          inBB.remaining());
//#endif 


//#if 132278504 
inBB.position(0);
//#endif 


//#if -437436272 
inBB.limit(0);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -368619399 
@Override
        public void write(int b) throws IOException
        { 

//#if 1836074449 
if(headerProcessed)//1
{ 

//#if 1000788946 
out.write(b);
//#endif 

} 
else
{ 

//#if 2056990502 
outBB.put((byte) b);
//#endif 


//#if -1068195306 
inBB.limit(outBB.position());
//#endif 


//#if 857992005 
CoderResult result = decoder.decode(inBB, outCB, false);
//#endif 


//#if -1890750971 
if(result.isError())//1
{ 

//#if -338014295 
throw new RuntimeException(
                        "Unknown character decoding error");
//#endif 

} 

//#endif 


//#if 2142313481 
if(outCB.position() == outCB.limit())//1
{ 

//#if 386343435 
processHeader();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -222253826 
@Override
        public void write(byte[] b, int off, int len) throws IOException
        { 

//#if -702959416 
if((off | len | (b.length - (len + off)) | (off + len)) < 0)//1
{ 

//#if 1689380175 
throw new IndexOutOfBoundsException();
//#endif 

} 

//#endif 


//#if 2033985898 
if(headerProcessed)//1
{ 

//#if -810712285 
out.write(b, off, len);
//#endif 

} 
else
{ 

//#if 1198053642 
for (int i = 0; i < len; i++) //1
{ 

//#if -1256618064 
write(b[off + i]);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1972745997 
public void startEntry()
        { 

//#if -30856681 
headerProcessed = false;
//#endif 


//#if -662625325 
resetBuffers();
//#endif 

} 

//#endif 


//#if -47488003 
private void resetBuffers()
        { 

//#if -1642019955 
inBB.limit(0);
//#endif 


//#if -1242300956 
outBB.position(0);
//#endif 


//#if 265250853 
outCB.position(0);
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

