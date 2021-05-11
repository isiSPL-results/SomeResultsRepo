
//#if -1576030946 
// Compilation Unit of /ZipFilePersister.java 
 

//#if -377923071 
package org.argouml.persistence;
//#endif 


//#if 1710351996 
import java.io.BufferedOutputStream;
//#endif 


//#if -1116957472 
import java.io.File;
//#endif 


//#if -2009479754 
import java.io.FileNotFoundException;
//#endif 


//#if -1268768385 
import java.io.FileOutputStream;
//#endif 


//#if 1166160305 
import java.io.IOException;
//#endif 


//#if -852129840 
import java.io.InputStream;
//#endif 


//#if 1598871067 
import java.io.OutputStream;
//#endif 


//#if 703311878 
import java.net.URL;
//#endif 


//#if -1279398086 
import java.util.zip.ZipEntry;
//#endif 


//#if -461510142 
import java.util.zip.ZipInputStream;
//#endif 


//#if 823179817 
import java.util.zip.ZipOutputStream;
//#endif 


//#if 827598993 
import org.argouml.i18n.Translator;
//#endif 


//#if -1795412013 
import org.argouml.kernel.Project;
//#endif 


//#if 1053354489 
import org.argouml.kernel.ProjectFactory;
//#endif 


//#if 665247670 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 827817561 
import org.argouml.kernel.ProjectMember;
//#endif 


//#if -291904553 
import org.argouml.model.Model;
//#endif 


//#if -553062818 
import org.xml.sax.InputSource;
//#endif 


//#if -2139441052 
import org.apache.log4j.Logger;
//#endif 


//#if 2038176158 
class ZipFilePersister extends 
//#if 1172572792 
XmiFilePersister
//#endif 

  { 

//#if -935811573 
private static final Logger LOG =
        Logger.getLogger(ZipFilePersister.class);
//#endif 


//#if -1719489561 
@Override
    public boolean hasAnIcon()
    { 

//#if 1978079501 
return false;
//#endif 

} 

//#endif 


//#if 715673251 
public boolean isSaveEnabled()
    { 

//#if -1499580803 
return true;
//#endif 

} 

//#endif 


//#if 528288356 
public void doSave(Project project, File file) throws SaveException
    { 

//#if -1430160519 
LOG.info("Receiving file '" + file.getName() + "'");
//#endif 


//#if -416687766 
File lastArchiveFile = new File(file.getAbsolutePath() + "~");
//#endif 


//#if -1503015838 
File tempFile = null;
//#endif 


//#if -71305195 
try //1
{ 

//#if -1738330455 
tempFile = createTempFile(file);
//#endif 

} 

//#if -467939534 
catch (FileNotFoundException e) //1
{ 

//#if -1095433086 
throw new SaveException(
                "Failed to archive the previous file version", e);
//#endif 

} 

//#endif 


//#if 701307437 
catch (IOException e) //1
{ 

//#if -1551247345 
throw new SaveException(
                "Failed to archive the previous file version", e);
//#endif 

} 

//#endif 


//#endif 


//#if 646478230 
OutputStream bufferedStream = null;
//#endif 


//#if 1755823740 
try //2
{ 

//#if 1256828116 
ZipOutputStream stream =
                new ZipOutputStream(new FileOutputStream(file));
//#endif 


//#if -1570608047 
String fileName = file.getName();
//#endif 


//#if -127594100 
ZipEntry xmiEntry =
                new ZipEntry(fileName.substring(0, fileName.lastIndexOf(".")));
//#endif 


//#if 2008864677 
stream.putNextEntry(xmiEntry);
//#endif 


//#if 451252877 
bufferedStream = new BufferedOutputStream(stream);
//#endif 


//#if -696908516 
int size = project.getMembers().size();
//#endif 


//#if -824580370 
for (int i = 0; i < size; i++) //1
{ 

//#if 1636121123 
ProjectMember projectMember =
                    project.getMembers().get(i);
//#endif 


//#if -1514926157 
if(projectMember.getType().equalsIgnoreCase("xmi"))//1
{ 

//#if 97431788 
if(LOG.isInfoEnabled())//1
{ 

//#if 1430552924 
LOG.info("Saving member of type: "
                                 + (project.getMembers()
                                    .get(i)).getType());
//#endif 

} 

//#endif 


//#if -1442975344 
MemberFilePersister persister
                        = new ModelMemberFilePersister();
//#endif 


//#if 232783769 
persister.save(projectMember, bufferedStream);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1635514363 
stream.close();
//#endif 


//#if 1406668235 
if(lastArchiveFile.exists())//1
{ 

//#if 857423227 
lastArchiveFile.delete();
//#endif 

} 

//#endif 


//#if -399162575 
if(tempFile.exists() && !lastArchiveFile.exists())//1
{ 

//#if 80335694 
tempFile.renameTo(lastArchiveFile);
//#endif 

} 

//#endif 


//#if -1128886781 
if(tempFile.exists())//1
{ 

//#if -380046293 
tempFile.delete();
//#endif 

} 

//#endif 

} 

//#if -61608117 
catch (Exception e) //1
{ 

//#if -1276152749 
LOG.error("Exception occured during save attempt", e);
//#endif 


//#if -182497259 
try //1
{ 

//#if 716424588 
bufferedStream.close();
//#endif 

} 

//#if 1574491253 
catch (IOException ex) //1
{ 
} 

//#endif 


//#endif 


//#if -819758532 
file.delete();
//#endif 


//#if -724803970 
tempFile.renameTo(file);
//#endif 


//#if -581535768 
throw new SaveException(e);
//#endif 

} 

//#endif 


//#endif 


//#if 1755853532 
try //3
{ 

//#if -553119438 
bufferedStream.close();
//#endif 

} 

//#if 1602000531 
catch (IOException ex) //1
{ 

//#if -199168093 
LOG.error("Failed to close save output writer", ex);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1368595477 
public Project doLoad(File file)
    throws OpenException
    { 

//#if 1922195515 
LOG.info("Receiving file '" + file.getName() + "'");
//#endif 


//#if -216643881 
try //1
{ 

//#if 1172577405 
Project p = ProjectFactory.getInstance().createProject();
//#endif 


//#if 657918797 
String fileName = file.getName();
//#endif 


//#if -592516366 
String extension =
                fileName.substring(
                    fileName.indexOf('.'),
                    fileName.lastIndexOf('.'));
//#endif 


//#if 1947288420 
InputStream stream = openZipStreamAt(file.toURI().toURL(),
                                                 extension);
//#endif 


//#if 1654453097 
InputSource is =
                new InputSource(
                new XmiInputStream(stream, this, 100000, null));
//#endif 


//#if 1168044011 
is.setSystemId(file.toURI().toURL().toExternalForm());
//#endif 


//#if 692973140 
ModelMemberFilePersister modelPersister =
                new ModelMemberFilePersister();
//#endif 


//#if 616220213 
modelPersister.readModels(is);
//#endif 


//#if 239412695 
Object model = modelPersister.getCurModel();
//#endif 


//#if 1387275278 
Model.getUmlHelper().addListenersToModel(model);
//#endif 


//#if 1839383742 
p.setUUIDRefs(modelPersister.getUUIDRefs());
//#endif 


//#if 1447799177 
p.addMember(model);
//#endif 


//#if 768210870 
parseXmiExtensions(p);
//#endif 


//#if 554341772 
modelPersister.registerDiagrams(p);
//#endif 


//#if -2071310062 
p.setRoot(model);
//#endif 


//#if -1449678860 
p.setRoots(modelPersister.getElementsRead());
//#endif 


//#if 2042599186 
ProjectManager.getManager().setSaveEnabled(false);
//#endif 


//#if 465265058 
return p;
//#endif 

} 

//#if 2045151351 
catch (IOException e) //1
{ 

//#if -1504607466 
throw new OpenException(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1012696208 
protected String getDesc()
    { 

//#if 1699348205 
return Translator.localize("combobox.filefilter.zip");
//#endif 

} 

//#endif 


//#if -40584166 
private ZipInputStream openZipStreamAt(URL url, String ext)
    throws IOException
    { 

//#if 484551565 
ZipInputStream zis = new ZipInputStream(url.openStream());
//#endif 


//#if 709251803 
ZipEntry entry = zis.getNextEntry();
//#endif 


//#if 968788543 
while (entry != null && !entry.getName().endsWith(ext)) //1
{ 

//#if 815329143 
entry = zis.getNextEntry();
//#endif 

} 

//#endif 


//#if -2078497129 
return zis;
//#endif 

} 

//#endif 


//#if -2065046389 
public String getExtension()
    { 

//#if 2107442219 
return "zip";
//#endif 

} 

//#endif 


//#if -1470926923 
public ZipFilePersister()
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

