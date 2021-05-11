package org.argouml.persistence;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.argouml.application.api.Argo;
import org.argouml.application.helpers.ApplicationVersion;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectFactory;
import org.argouml.kernel.ProjectMember;
import org.argouml.model.UmlException;
import org.argouml.util.ThreadUtils;
import org.tigris.gef.ocl.ExpansionException;
import org.tigris.gef.ocl.OCLExpander;
import org.tigris.gef.ocl.TemplateReader;
import org.xml.sax.SAXException;
public class UmlFilePersister extends AbstractFilePersister
  { 
public static final int PERSISTENCE_VERSION = 6;
protected static final int UML_PHASES_LOAD = 2;
private static final String ARGO_TEE =
        "/org/argouml/persistence/argo.tee";
protected int getPersistenceVersion(InputStream inputStream)
    throws OpenException
    { 
BufferedReader reader = null;
try//1
{ 
reader = new BufferedReader(new InputStreamReader(inputStream,
                                        Argo.getEncoding()));
String rootLine = reader.readLine();
while (rootLine != null && !rootLine.trim().startsWith("<argo ")) //1
{ 
rootLine = reader.readLine();
} 
if(rootLine == null)//1
{ 
return 1;
} 
return Integer.parseInt(getVersion(rootLine));
} 
catch (IOException e) //1
{ 
throw new OpenException(e);
} 
catch (NumberFormatException e) //1
{ 
throw new OpenException(e);
} 
finally { 
try//1
{ 
if(reader != null)//1
{ 
reader.close();
} 
} 
catch (IOException e) //1
{ 
} 
} 
} 
protected String getDesc()
    { 
return Translator.localize("combobox.filefilter.uml");
} 
void writeProject(Project project,
                      OutputStream oStream,
                      ProgressMgr progressMgr) throws SaveException,
                                      InterruptedException
    { 
OutputStreamWriter outputStreamWriter;
try//1
{ 
outputStreamWriter =
                new OutputStreamWriter(oStream, Argo.getEncoding());
} 
catch (UnsupportedEncodingException e) //1
{ 
throw new SaveException(e);
} 
PrintWriter writer =
            new PrintWriter(new BufferedWriter(outputStreamWriter));
XmlFilterOutputStream filteredStream =
            new XmlFilterOutputStream(oStream, Argo.getEncoding());
try//2
{ 
writer.println("<?xml version = \"1.0\" "
                           + "encoding = \""
                           + Argo.getEncoding() + "\" ?>");
writer.println("<uml version=\"" + PERSISTENCE_VERSION + "\">");
try//1
{ 
Hashtable templates =
                    TemplateReader.getInstance().read(ARGO_TEE);
OCLExpander expander = new OCLExpander(templates);
expander.expand(writer, project, "  ");
} 
catch (ExpansionException e) //1
{ 
throw new SaveException(e);
} 
writer.flush();
if(progressMgr != null)//1
{ 
progressMgr.nextPhase();
} 
for (ProjectMember projectMember : project.getMembers()) //1
{ 
MemberFilePersister persister
                    = getMemberFilePersister(projectMember);
filteredStream.startEntry();
persister.save(projectMember, filteredStream);
try//1
{ 
filteredStream.flush();
} 
catch (IOException e) //1
{ 
throw new SaveException(e);
} 
} 
writer.println("</uml>");
writer.flush();
} 
finally { 
writer.close();
try//1
{ 
filteredStream.reallyClose();
} 
catch (IOException e) //1
{ 
throw new SaveException(e);
} 
} 
} 
public UmlFilePersister()
    { 
} 
@Override
    public boolean isSaveEnabled()
    { 
return true;
} 
protected Project doLoad(File originalFile, File file,
                             ProgressMgr progressMgr) throws OpenException,
        InterruptedException
    { 
XmlInputStream inputStream = null;
try//1
{ 
Project p = ProjectFactory.getInstance()
                        .createProject(file.toURI());
int fileVersion = getPersistenceVersionFromFile(file);
if(!checkVersion(fileVersion,  getReleaseVersionFromFile(file)))//1
{ 
String release = getReleaseVersionFromFile(file);
copyFile(
                    originalFile,
                    new File(originalFile.getAbsolutePath() + '~' + release));
progressMgr.setNumberOfPhases(progressMgr.getNumberOfPhases()
                                              + (PERSISTENCE_VERSION - fileVersion));
while (fileVersion < PERSISTENCE_VERSION) //1
{ 
++fileVersion;
long startTime = System.currentTimeMillis();
file = transform(file, fileVersion);
long endTime = System.currentTimeMillis();
progressMgr.nextPhase();
} 
} 
progressMgr.nextPhase();
inputStream = new XmlInputStream(
                file.toURI().toURL().openStream(),
                "argo",
                file.length(),
                100000);
ArgoParser parser = new ArgoParser();
Reader reader =
                new InputStreamReader(inputStream,
                                      Argo.getEncoding());
parser.readProject(p, reader);
List memberList = parser.getMemberList();
for (int i = 0; i < memberList.size(); ++i) //1
{ 
MemberFilePersister persister
                    = getMemberFilePersister((String) memberList.get(i));
inputStream.reopen(persister.getMainTag());
try//1
{ 
persister.load(p, inputStream);
} 
catch (OpenException e) //1
{ 
if("XMI".equals(persister.getMainTag())
                            && e.getCause() instanceof UmlException
                            && e.getCause().getCause() instanceof IOException)//1
{ 
inputStream.reopen("uml:Model");
persister.load(p, inputStream);
} 
else
{ 
throw e;
} 
} 
} 
progressMgr.nextPhase();
ThreadUtils.checkIfInterrupted();
inputStream.realClose();
p.postLoad();
return p;
} 
catch (InterruptedException e) //1
{ 
throw e;
} 
catch (OpenException e) //1
{ 
throw e;
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
public boolean hasAnIcon()
    { 
return true;
} 
public void doSave(Project project, File file)
    throws SaveException, InterruptedException
    { 
ProgressMgr progressMgr = new ProgressMgr();
progressMgr.setNumberOfPhases(4);
progressMgr.nextPhase();
File lastArchiveFile = new File(file.getAbsolutePath() + "~");
File tempFile = null;
try//1
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
try//2
{ 
project.setFile(file);
project.setVersion(ApplicationVersion.getVersion());
project.setPersistenceVersion(PERSISTENCE_VERSION);
OutputStream stream = new FileOutputStream(file);
writeProject(project, stream, progressMgr);
stream.close();
progressMgr.nextPhase();
String path = file.getParent();
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
file.delete();
tempFile.renameTo(file);
if(e instanceof InterruptedException)//1
{ 
throw (InterruptedException) e;
} 
else
{ 
throw new SaveException(e);
} 
} 
} 
public Project doLoad(File file) throws OpenException,
        InterruptedException
    { 
ProgressMgr progressMgr = new ProgressMgr();
progressMgr.setNumberOfPhases(UML_PHASES_LOAD);
ThreadUtils.checkIfInterrupted();
return doLoad(file, file, progressMgr);
} 
protected boolean checkVersion(int fileVersion, String releaseVersion)
    throws OpenException, VersionException
    { 
if(fileVersion > PERSISTENCE_VERSION)//1
{ 
throw new VersionException(
                "The file selected is from a more up to date version of "
                + "ArgoUML. It has been saved with ArgoUML version "
                + releaseVersion
                + ". Please load with that or a more up to date"
                + "release of ArgoUML");
} 
return fileVersion >= PERSISTENCE_VERSION;
} 
public String getExtension()
    { 
return "uml";
} 
private int getPersistenceVersionFromFile(File file) throws OpenException
    { 
InputStream stream = null;
try//1
{ 
stream = new BufferedInputStream(file.toURI().toURL()
                                             .openStream());
int version = getPersistenceVersion(stream);
stream.close();
return version;
} 
catch (MalformedURLException e) //1
{ 
throw new OpenException(e);
} 
catch (IOException e) //1
{ 
throw new OpenException(e);
} 
finally { 
if(stream != null)//1
{ 
try//1
{ 
stream.close();
} 
catch (IOException e) //1
{ 
} 
} 
} 
} 
protected String getVersion(String rootLine)
    { 
String version;
int versionPos = rootLine.indexOf("version=\"");
if(versionPos > 0)//1
{ 
int startPos = versionPos + 9;
int endPos = rootLine.indexOf("\"", startPos);
version = rootLine.substring(startPos, endPos);
} 
else
{ 
version = "1";
} 
return version;
} 
public final File transform(File file, int version)
    throws OpenException
    { 
try//1
{ 
String upgradeFilesPath = "/org/argouml/persistence/upgrades/";
String upgradeFile = "upgrade" + version + ".xsl";
String xsltFileName = upgradeFilesPath + upgradeFile;
URL xsltUrl = UmlFilePersister.class.getResource(xsltFileName);
StreamSource xsltStreamSource =
                new StreamSource(xsltUrl.openStream());
xsltStreamSource.setSystemId(xsltUrl.toExternalForm());
TransformerFactory factory = TransformerFactory.newInstance();
Transformer transformer = factory.newTransformer(xsltStreamSource);
File transformedFile =
                File.createTempFile("upgrade_" + version + "_", ".uml");
transformedFile.deleteOnExit();
FileOutputStream stream =
                new FileOutputStream(transformedFile);
Writer writer =
                new BufferedWriter(new OutputStreamWriter(stream,
                                   Argo.getEncoding()));
Result result = new StreamResult(writer);
StreamSource inputStreamSource = new StreamSource(file);
inputStreamSource.setSystemId(file);
transformer.transform(inputStreamSource, result);
writer.close();
return transformedFile;
} 
catch (IOException e) //1
{ 
throw new OpenException(e);
} 
catch (TransformerException e) //1
{ 
throw new OpenException(e);
} 
} 
protected String getReleaseVersion(InputStream inputStream)
    throws OpenException
    { 
BufferedReader reader = null;
try//1
{ 
reader = new BufferedReader(new InputStreamReader(inputStream,
                                        Argo.getEncoding()));
String versionLine = reader.readLine();
while (!versionLine.trim().startsWith("<version>")) //1
{ 
versionLine = reader.readLine();
if(versionLine == null)//1
{ 
throw new OpenException(
                        "Failed to find the release <version> tag");
} 
} 
versionLine = versionLine.trim();
int end = versionLine.lastIndexOf("</version>");
return versionLine.trim().substring(9, end);
} 
catch (IOException e) //1
{ 
throw new OpenException(e);
} 
catch (NumberFormatException e) //1
{ 
throw new OpenException(e);
} 
finally { 
try//1
{ 
if(inputStream != null)//1
{ 
inputStream.close();
} 
if(reader != null)//1
{ 
reader.close();
} 
} 
catch (IOException e) //1
{ 
} 
} 
} 
private String getReleaseVersionFromFile(File file) throws OpenException
    { 
InputStream stream = null;
try//1
{ 
stream = new BufferedInputStream(file.toURI().toURL().openStream());
String version = getReleaseVersion(stream);
stream.close();
return version;
} 
catch (MalformedURLException e) //1
{ 
throw new OpenException(e);
} 
catch (IOException e) //1
{ 
throw new OpenException(e);
} 
finally { 
if(stream != null)//1
{ 
try//1
{ 
stream.close();
} 
catch (IOException e) //1
{ 
} 
} 
} 
} 
class XmlFilterOutputStream extends FilterOutputStream
  { 
private CharsetDecoder decoder;
private boolean headerProcessed = false;
private static final int BUFFER_SIZE = 120;
private byte[] bytes = new byte[BUFFER_SIZE * 2];
private ByteBuffer outBB = ByteBuffer.wrap(bytes);
private ByteBuffer inBB = ByteBuffer.wrap(bytes);
private CharBuffer outCB = CharBuffer.allocate(BUFFER_SIZE);
private final Pattern xmlDeclarationPattern = Pattern.compile(
                    "\\s*<\\?xml.*\\?>\\s*(<!DOCTYPE.*>\\s*)?");
public XmlFilterOutputStream(OutputStream outputStream,
                                     Charset charset)
        { 
super(outputStream);
decoder = charset.newDecoder();
decoder.onMalformedInput(CodingErrorAction.REPORT);
decoder.onUnmappableCharacter(CodingErrorAction.REPORT);
startEntry();
} 
public XmlFilterOutputStream(OutputStream outputStream,
                                     String charsetName)
        { 
this(outputStream, Charset.forName(charsetName));
} 
@Override
        public void close() throws IOException
        { 
flush();
} 
@Override
        public void flush() throws IOException
        { 
if(!headerProcessed)//1
{ 
processHeader();
} 
out.flush();
} 
public void reallyClose() throws IOException
        { 
out.close();
} 
private void processHeader() throws IOException
        { 
headerProcessed = true;
outCB.position(0);
Matcher matcher = xmlDeclarationPattern.matcher(outCB);
String headerRemainder = matcher.replaceAll("");
int index = headerRemainder.length() - 1;
if(headerRemainder.charAt(index) == '\0')//1
{ 
do{ 
index--;
} 
 while (index >= 0 && headerRemainder.charAt(index) == '\0');//1
headerRemainder = headerRemainder.substring(0, index + 1);
} 
ByteBuffer bb = decoder.charset().encode(headerRemainder);
byte[] outBytes = new byte[bb.limit()];
bb.get(outBytes);
out.write(outBytes, 0, outBytes.length);
if(inBB.remaining() > 0)//1
{ 
out.write(inBB.array(), inBB.position(),
                          inBB.remaining());
inBB.position(0);
inBB.limit(0);
} 
} 
@Override
        public void write(int b) throws IOException
        { 
if(headerProcessed)//1
{ 
out.write(b);
} 
else
{ 
outBB.put((byte) b);
inBB.limit(outBB.position());
CoderResult result = decoder.decode(inBB, outCB, false);
if(result.isError())//1
{ 
throw new RuntimeException(
                        "Unknown character decoding error");
} 
if(outCB.position() == outCB.limit())//1
{ 
processHeader();
} 
} 
} 
@Override
        public void write(byte[] b, int off, int len) throws IOException
        { 
if((off | len | (b.length - (len + off)) | (off + len)) < 0)//1
{ 
throw new IndexOutOfBoundsException();
} 
if(headerProcessed)//1
{ 
out.write(b, off, len);
} 
else
{ 
for (int i = 0; i < len; i++) //1
{ 
write(b[off + i]);
} 
} 
} 
public void startEntry()
        { 
headerProcessed = false;
resetBuffers();
} 
private void resetBuffers()
        { 
inBB.limit(0);
outBB.position(0);
outCB.position(0);
} 

 } 

 } 
