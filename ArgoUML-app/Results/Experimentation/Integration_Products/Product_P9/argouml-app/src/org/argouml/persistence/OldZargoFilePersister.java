package org.argouml.persistence;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.argouml.application.helpers.ApplicationVersion;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectMember;
import org.argouml.ocl.OCLExpander;
import org.argouml.util.FileConstants;
import org.tigris.gef.ocl.TemplateReader;
import org.apache.log4j.Logger;
class OldZargoFilePersister extends ZargoFilePersister
  { 
private static final String ARGO_MINI_TEE =
        "/org/argouml/persistence/argo.tee";
private static final Logger LOG =
        Logger.getLogger(OldZargoFilePersister.class);
public boolean isSaveEnabled()
    { 
return true;
} 
public OldZargoFilePersister()
    { 
} 
protected String getDesc()
    { 
return Translator.localize("combobox.filefilter.zargo");
} 
public void doSave(Project project, File file) throws SaveException,
               InterruptedException
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
BufferedWriter writer = null;
try//2
{ 
project.setFile(file);
project.setVersion(ApplicationVersion.getVersion());
project.setPersistenceVersion(PERSISTENCE_VERSION);
ZipOutputStream stream =
                new ZipOutputStream(new FileOutputStream(file));
writer =
                new BufferedWriter(new OutputStreamWriter(stream, "UTF-8"));
ZipEntry zipEntry =
                new ZipEntry(PersistenceManager.getInstance()
                             .getProjectBaseName(project)
                             + FileConstants.UNCOMPRESSED_FILE_EXT);
stream.putNextEntry(zipEntry);
Hashtable templates =
                TemplateReader.getInstance().read(ARGO_MINI_TEE);
OCLExpander expander = new OCLExpander(templates);
expander.expand(writer, project);
writer.flush();
stream.closeEntry();
int counter = 0;
int size = project.getMembers().size();
Collection<String> names = new ArrayList<String>();
for (int i = 0; i < size; i++) //1
{ 
ProjectMember projectMember = project.getMembers().get(i);
if(!(projectMember.getType().equalsIgnoreCase("xmi")))//1
{ 
if(LOG.isInfoEnabled())//1
{ 
LOG.info("Saving member: "
                                 + project.getMembers().get(i).getZipName());
} 
String name = projectMember.getZipName();
String originalName = name;
while (names.contains(name)) //1
{ 
name = ++counter + originalName;
} 
names.add(name);
stream.putNextEntry(new ZipEntry(name));
MemberFilePersister persister =
                        getMemberFilePersister(projectMember);
persister.save(projectMember, stream);
stream.flush();
stream.closeEntry();
} 
} 
for (int i = 0; i < size; i++) //2
{ 
ProjectMember projectMember = project.getMembers().get(i);
if(projectMember.getType().equalsIgnoreCase("xmi"))//1
{ 
if(LOG.isInfoEnabled())//1
{ 
LOG.info("Saving member of type: "
                                 + project.getMembers().get(i).getType());
} 
stream.putNextEntry(
                        new ZipEntry(projectMember.getZipName()));
OldModelMemberFilePersister persister =
                        new OldModelMemberFilePersister();
persister.save(projectMember, stream);
stream.flush();
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
LOG.error("Exception occured during save attempt", e);
try//1
{ 
writer.close();
} 
catch (Exception ex) //1
{ 
} 
file.delete();
tempFile.renameTo(file);
throw new SaveException(e);
} 
try//3
{ 
writer.close();
} 
catch (IOException ex) //1
{ 
LOG.error("Failed to close save output writer", ex);
} 
} 
public boolean isLoadEnabled()
    { 
return false;
} 

 } 
