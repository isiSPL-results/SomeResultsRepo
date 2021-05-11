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
import org.argouml.uml.cognitive.ProjectMemberTodoList;
class XmiFilePersister extends AbstractFilePersister
 implements XmiExtensionParser
  { 
private List<String> pgmlStrings = new ArrayList<String>();
private String argoString;
private String todoString;
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
if(label.equals("todo"))//1
{ 
todoString = xmiExtensionString;
} 
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
OutputStream stream = null;
try//2
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
try//1
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
try//1
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
StringReader inputStream = new StringReader(argoString);
ArgoParser parser = new ArgoParser();
try//1
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
InputStream inputStream = new ByteArrayInputStream(pgml.getBytes());
MemberFilePersister persister =
                // TODO: Cyclic dependency between PersistanceManager and here
                PersistenceManager.getInstance()
                .getDiagramMemberFilePersister();
persister.load(project, inputStream);
} 
if(todoString != null)//1
{ 
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
try//1
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
