
//#if -1374227697 
// Compilation Unit of /OldZargoFilePersister.java 
 

//#if 1100843894 
package org.argouml.persistence;
//#endif 


//#if 946264159 
import java.io.BufferedWriter;
//#endif 


//#if 2128580053 
import java.io.File;
//#endif 


//#if 196293985 
import java.io.FileNotFoundException;
//#endif 


//#if 209998580 
import java.io.FileOutputStream;
//#endif 


//#if -305648868 
import java.io.IOException;
//#endif 


//#if 833558557 
import java.io.OutputStreamWriter;
//#endif 


//#if 1718058450 
import java.util.ArrayList;
//#endif 


//#if -1235164721 
import java.util.Collection;
//#endif 


//#if 245852681 
import java.util.Hashtable;
//#endif 


//#if -625346065 
import java.util.zip.ZipEntry;
//#endif 


//#if -1266013740 
import java.util.zip.ZipOutputStream;
//#endif 


//#if -1118295743 
import org.argouml.application.helpers.ApplicationVersion;
//#endif 


//#if 1294698236 
import org.argouml.i18n.Translator;
//#endif 


//#if 1960433672 
import org.argouml.kernel.Project;
//#endif 


//#if 33647310 
import org.argouml.kernel.ProjectMember;
//#endif 


//#if 1645467869 
import org.argouml.ocl.OCLExpander;
//#endif 


//#if -2080760439 
import org.argouml.util.FileConstants;
//#endif 


//#if -771089898 
import org.tigris.gef.ocl.TemplateReader;
//#endif 


//#if 956302415 
import org.apache.log4j.Logger;
//#endif 


//#if 2043491882 
class OldZargoFilePersister extends 
//#if -82748907 
ZargoFilePersister
//#endif 

  { 

//#if -1104420584 
private static final String ARGO_MINI_TEE =
        "/org/argouml/persistence/argo.tee";
//#endif 


//#if 682427046 
private static final Logger LOG =
        Logger.getLogger(OldZargoFilePersister.class);
//#endif 


//#if 1129148127 
public boolean isSaveEnabled()
    { 

//#if 356978740 
return true;
//#endif 

} 

//#endif 


//#if -206462354 
public OldZargoFilePersister()
    { 
} 

//#endif 


//#if 24779180 
protected String getDesc()
    { 

//#if 552033554 
return Translator.localize("combobox.filefilter.zargo");
//#endif 

} 

//#endif 


//#if 909491161 
public void doSave(Project project, File file) throws SaveException,
               InterruptedException
    { 

//#if 925530314 
ProgressMgr progressMgr = new ProgressMgr();
//#endif 


//#if 334551837 
progressMgr.setNumberOfPhases(4);
//#endif 


//#if 1670348813 
progressMgr.nextPhase();
//#endif 


//#if 735980899 
File lastArchiveFile = new File(file.getAbsolutePath() + "~");
//#endif 


//#if -1892158693 
File tempFile = null;
//#endif 


//#if -2024821682 
try //1
{ 

//#if 762614625 
tempFile = createTempFile(file);
//#endif 

} 

//#if 2016605404 
catch (FileNotFoundException e) //1
{ 

//#if 413211221 
throw new SaveException(
                "Failed to archive the previous file version", e);
//#endif 

} 

//#endif 


//#if 1931308119 
catch (IOException e) //1
{ 

//#if -967315436 
throw new SaveException(
                "Failed to archive the previous file version", e);
//#endif 

} 

//#endif 


//#endif 


//#if -1575877484 
BufferedWriter writer = null;
//#endif 


//#if 1353020323 
try //2
{ 

//#if -1033732838 
project.setFile(file);
//#endif 


//#if 335425195 
project.setVersion(ApplicationVersion.getVersion());
//#endif 


//#if -1529718981 
project.setPersistenceVersion(PERSISTENCE_VERSION);
//#endif 


//#if -838590346 
ZipOutputStream stream =
                new ZipOutputStream(new FileOutputStream(file));
//#endif 


//#if 1443701102 
writer =
                new BufferedWriter(new OutputStreamWriter(stream, "UTF-8"));
//#endif 


//#if -1592429077 
ZipEntry zipEntry =
                new ZipEntry(PersistenceManager.getInstance()
                             .getProjectBaseName(project)
                             + FileConstants.UNCOMPRESSED_FILE_EXT);
//#endif 


//#if -489843430 
stream.putNextEntry(zipEntry);
//#endif 


//#if -1767909234 
Hashtable templates =
                TemplateReader.getInstance().read(ARGO_MINI_TEE);
//#endif 


//#if 832342246 
OCLExpander expander = new OCLExpander(templates);
//#endif 


//#if 1046988550 
expander.expand(writer, project);
//#endif 


//#if -1721118972 
writer.flush();
//#endif 


//#if 1866239903 
stream.closeEntry();
//#endif 


//#if 1022755726 
int counter = 0;
//#endif 


//#if 1404534974 
int size = project.getMembers().size();
//#endif 


//#if -544676415 
Collection<String> names = new ArrayList<String>();
//#endif 


//#if 225533068 
for (int i = 0; i < size; i++) //1
{ 

//#if 640806883 
ProjectMember projectMember = project.getMembers().get(i);
//#endif 


//#if -175477363 
if(!(projectMember.getType().equalsIgnoreCase("xmi")))//1
{ 

//#if -1329359002 
if(LOG.isInfoEnabled())//1
{ 

//#if -374587621 
LOG.info("Saving member: "
                                 + project.getMembers().get(i).getZipName());
//#endif 

} 

//#endif 


//#if 959252753 
String name = projectMember.getZipName();
//#endif 


//#if 1304088041 
String originalName = name;
//#endif 


//#if 217589123 
while (names.contains(name)) //1
{ 

//#if 872862989 
name = ++counter + originalName;
//#endif 

} 

//#endif 


//#if 942058195 
names.add(name);
//#endif 


//#if 1847987558 
stream.putNextEntry(new ZipEntry(name));
//#endif 


//#if -747853040 
MemberFilePersister persister =
                        getMemberFilePersister(projectMember);
//#endif 


//#if 1233185504 
persister.save(projectMember, stream);
//#endif 


//#if 1037691483 
stream.flush();
//#endif 


//#if -743366053 
stream.closeEntry();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1526854309 
for (int i = 0; i < size; i++) //2
{ 

//#if -606480956 
ProjectMember projectMember = project.getMembers().get(i);
//#endif 


//#if 75299826 
if(projectMember.getType().equalsIgnoreCase("xmi"))//1
{ 

//#if 2144256053 
if(LOG.isInfoEnabled())//1
{ 

//#if 1494307524 
LOG.info("Saving member of type: "
                                 + project.getMembers().get(i).getType());
//#endif 

} 

//#endif 


//#if -892887216 
stream.putNextEntry(
                        new ZipEntry(projectMember.getZipName()));
//#endif 


//#if -386067548 
OldModelMemberFilePersister persister =
                        new OldModelMemberFilePersister();
//#endif 


//#if 806451889 
persister.save(projectMember, stream);
//#endif 


//#if -246403860 
stream.flush();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -463710999 
if(lastArchiveFile.exists())//1
{ 

//#if 190902408 
lastArchiveFile.delete();
//#endif 

} 

//#endif 


//#if -188952753 
if(tempFile.exists() && !lastArchiveFile.exists())//1
{ 

//#if 1345455851 
tempFile.renameTo(lastArchiveFile);
//#endif 

} 

//#endif 


//#if 2091576485 
if(tempFile.exists())//1
{ 

//#if 1873533384 
tempFile.delete();
//#endif 

} 

//#endif 


//#if 59942850 
progressMgr.nextPhase();
//#endif 

} 

//#if -778306447 
catch (Exception e) //1
{ 

//#if 1658159912 
LOG.error("Exception occured during save attempt", e);
//#endif 


//#if 1725571168 
try //1
{ 

//#if -1639931304 
writer.close();
//#endif 

} 

//#if 1275286704 
catch (Exception ex) //1
{ 
} 

//#endif 


//#endif 


//#if -249901177 
file.delete();
//#endif 


//#if -1134702071 
tempFile.renameTo(file);
//#endif 


//#if -403475011 
throw new SaveException(e);
//#endif 

} 

//#endif 


//#endif 


//#if 1353050115 
try //3
{ 

//#if -1624687590 
writer.close();
//#endif 

} 

//#if 724479917 
catch (IOException ex) //1
{ 

//#if -308127654 
LOG.error("Failed to close save output writer", ex);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -27053674 
public boolean isLoadEnabled()
    { 

//#if 1503689752 
return false;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

