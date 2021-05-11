// Compilation Unit of /XmiFilePersister.java 
 
package org.argouml.persistence;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectFactory;
import org.argouml.kernel.ProjectManager;
import org.argouml.kernel.ProjectMember;
import org.argouml.model.Model;
import org.argouml.util.ThreadUtils;
import org.xml.sax.InputSource;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.ProjectMemberTodoList;
//#endif 

class XmiFilePersister extends AbstractFilePersister
 implements XmiExtensionParser
  { 
private List<String> pgmlStrings = new ArrayList<String>();
private String argoString;

//#if LOGGING 
private static final Logger LOG =
        Logger.getLogger(XmiFilePersister.class);
//#endif 


//#if COGNITIVE 
private String todoString;
//#endif 

public void parse(String label, String xmiExtensionString)
    { 
if(label.equals("pgml"))//1
{ 
pgmlStrings.add(xmiExtensionString);
} 
else
if(label.equals("argo"))//1
{ 
argoString = xmiExtensionString;
} 
else

//#if COGNITIVE 
if(label.equals("todo"))//1
{ 
todoString = xmiExtensionString;
} 

//#endif 



} 

public void doSave(Project project, File file)
    throws SaveException, InterruptedException
    { 
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


OutputStream stream = null;
try //2
{ 
stream = new FileOutputStream(file);
writeProject(project, stream, progressMgr);
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
catch (InterruptedException exc) //1
{ 
try //1
{ 
stream.close();
} 
catch (IOException ex) //1
{ 
} 


throw exc;
} 

catch (Exception e) //1
{ 

//#if LOGGING 
LOG.error("Exception occured during save attempt", e);
//#endif 

try //1
{ 
stream.close();
} 
catch (IOException ex) //1
{ 
} 


file.delete();
tempFile.renameTo(file);
throw new SaveException(e);
} 


progressMgr.nextPhase();
} 

public boolean isSaveEnabled()
    { 
return false;
} 

public void parseXmiExtensions(Project project) throws OpenException
    { 
if(argoString != null)//1
{ 

//#if LOGGING 
LOG.info("Parsing argoString " + argoString.length());
//#endif 

StringReader inputStream = new StringReader(argoString);
ArgoParser parser = new ArgoParser();
try //1
{ 
parser.readProject(project, inputStream);
} 
catch (Exception e) //1
{ 
throw new OpenException("Exception caught", e);
} 


} 
else
{ 
project.addMember(new ProjectMemberTodoList("", project));
} 

for (String pgml : pgmlStrings) //1
{ 

//#if LOGGING 
LOG.info("Parsing pgml " + pgml.length());
//#endif 

InputStream inputStream = new ByteArrayInputStream(pgml.getBytes());
MemberFilePersister persister =
                // TODO: Cyclic dependency between PersistanceManager and here
                PersistenceManager.getInstance()
                .getDiagramMemberFilePersister();
persister.load(project, inputStream);
} 


//#if COGNITIVE 
if(todoString != null)//1
{ 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.info("Parsing todoString " + todoString.length());
//#endif 

InputStream inputStream =
                new ByteArrayInputStream(todoString.getBytes());
MemberFilePersister persister = null;
persister = new TodoListMemberFilePersister();
persister.load(project, inputStream);
} 
else
{ 
project.addMember(new ProjectMemberTodoList("", project));
} 

//#endif 

} 

void writeProject(Project project,
                      OutputStream stream,
                      ProgressMgr progressMgr) throws SaveException,
                                      InterruptedException
    { 
int size = project.getMembers().size();
for (int i = 0; i < size; i++) //1
{ 
ProjectMember projectMember =
                project.getMembers().get(i);
if(projectMember.getType().equalsIgnoreCase(getExtension()))//1
{ 

//#if LOGGING 
if(LOG.isInfoEnabled())//1
{ 
LOG.info("Saving member of type: "
                             + (project.getMembers()
                                .get(i)).getType());
} 

//#endif 

MemberFilePersister persister = new ModelMemberFilePersister();
persister.save(projectMember, stream);
} 

} 

if(progressMgr != null)//1
{ 
progressMgr.nextPhase();
} 

} 

public String getExtension()
    { 
return "xmi";
} 

public boolean hasAnIcon()
    { 
return true;
} 

public Project doLoad(File file)
    throws OpenException, InterruptedException
    { 

//#if LOGGING 
LOG.info("Loading with XMIFilePersister");
//#endif 

try //1
{ 
Project p = ProjectFactory.getInstance().createProject();
long length = file.length();
long phaseSpace = 100000;
int phases = (int) (length / phaseSpace);
if(phases < 10)//1
{ 
phaseSpace = length / 10;
phases = 10;
} 


//#if LOGGING 
LOG.info("File length is " + length + " phase space is "
                     + phaseSpace + " phases is " + phases);
//#endif 

ProgressMgr progressMgr = new ProgressMgr();
progressMgr.setNumberOfPhases(phases);
ThreadUtils.checkIfInterrupted();
InputSource source = new InputSource(new XmiInputStream(file
                                                 .toURI().toURL().openStream(), this, phaseSpace,
                                                 progressMgr));
source.setSystemId(file.toURI().toURL().toString());
ModelMemberFilePersister modelPersister =
                new ModelMemberFilePersister();
modelPersister.readModels(source);
Object model = modelPersister.getCurModel();
progressMgr.nextPhase();
Model.getUmlHelper().addListenersToModel(model);
p.setUUIDRefs(modelPersister.getUUIDRefs());
p.addMember(model);
parseXmiExtensions(p);
modelPersister.registerDiagrams(p);
p.setRoot(model);
p.setRoots(modelPersister.getElementsRead());
File defaultProjectFile = new File(file.getPath() + ".zargo");
for (int i = 0; i < 99; i++) //1
{ 
if(!defaultProjectFile.exists())//1
{ 
break;

} 

defaultProjectFile =
                    new File(file.getPath() + "." + i + ".zargo");
} 

PersistenceManager.getInstance().setProjectURI(
                defaultProjectFile.toURI(), p);
progressMgr.nextPhase();
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
return Translator.localize("combobox.filefilter.xmi");
} 

public XmiFilePersister()
    { 
} 

 } 


