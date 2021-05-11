package org.argouml.persistence;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectFactory;
import org.argouml.kernel.ProjectManager;
import org.argouml.kernel.ProjectMember;
import org.argouml.model.Model;
import org.xml.sax.InputSource;
import org.apache.log4j.Logger;
class ZipFilePersister extends XmiFilePersister
  { 
private static final Logger LOG =
        Logger.getLogger(ZipFilePersister.class);
@Override
    public boolean hasAnIcon()
    { 
return false;
} 
public boolean isSaveEnabled()
    { 
return true;
} 
public void doSave(Project project, File file) throws SaveException
    { 
LOG.info("Receiving file '" + file.getName() + "'");
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
OutputStream bufferedStream = null;
try//2
{ 
ZipOutputStream stream =
                new ZipOutputStream(new FileOutputStream(file));
String fileName = file.getName();
ZipEntry xmiEntry =
                new ZipEntry(fileName.substring(0, fileName.lastIndexOf(".")));
stream.putNextEntry(xmiEntry);
bufferedStream = new BufferedOutputStream(stream);
int size = project.getMembers().size();
for (int i = 0; i < size; i++) //1
{ 
ProjectMember projectMember =
                    project.getMembers().get(i);
if(projectMember.getType().equalsIgnoreCase("xmi"))//1
{ 
if(LOG.isInfoEnabled())//1
{ 
LOG.info("Saving member of type: "
                                 + (project.getMembers()
                                    .get(i)).getType());
} 
MemberFilePersister persister
                        = new ModelMemberFilePersister();
persister.save(projectMember, bufferedStream);
} 
} 
stream.close();
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
} 
catch (Exception e) //1
{ 
LOG.error("Exception occured during save attempt", e);
try//1
{ 
bufferedStream.close();
} 
catch (IOException ex) //1
{ 
} 
file.delete();
tempFile.renameTo(file);
throw new SaveException(e);
} 
try//3
{ 
bufferedStream.close();
} 
catch (IOException ex) //1
{ 
LOG.error("Failed to close save output writer", ex);
} 
} 
public Project doLoad(File file)
    throws OpenException
    { 
LOG.info("Receiving file '" + file.getName() + "'");
try//1
{ 
Project p = ProjectFactory.getInstance().createProject();
String fileName = file.getName();
String extension =
                fileName.substring(
                    fileName.indexOf('.'),
                    fileName.lastIndexOf('.'));
InputStream stream = openZipStreamAt(file.toURI().toURL(),
                                                 extension);
InputSource is =
                new InputSource(
                new XmiInputStream(stream, this, 100000, null));
is.setSystemId(file.toURI().toURL().toExternalForm());
ModelMemberFilePersister modelPersister =
                new ModelMemberFilePersister();
modelPersister.readModels(is);
Object model = modelPersister.getCurModel();
Model.getUmlHelper().addListenersToModel(model);
p.setUUIDRefs(modelPersister.getUUIDRefs());
p.addMember(model);
parseXmiExtensions(p);
modelPersister.registerDiagrams(p);
p.setRoot(model);
p.setRoots(modelPersister.getElementsRead());
ProjectManager.getManager().setSaveEnabled(false);
return p;
} 
catch (IOException e) //1
{ 
throw new OpenException(e);
} 
} 
protected String getDesc()
    { 
return Translator.localize("combobox.filefilter.zip");
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
return zis;
} 
public String getExtension()
    { 
return "zip";
} 
public ZipFilePersister()
    { 
} 

 } 
