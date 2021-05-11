
//#if -167861484 
// Compilation Unit of /XmiFilePersister.java 
 

//#if -1136862723 
package org.argouml.persistence;
//#endif 


//#if 675683583 
import java.io.ByteArrayInputStream;
//#endif 


//#if 559099612 
import java.io.File;
//#endif 


//#if 1557324602 
import java.io.FileNotFoundException;
//#endif 


//#if -2027708037 
import java.io.FileOutputStream;
//#endif 


//#if -1470782411 
import java.io.IOException;
//#endif 


//#if 805894740 
import java.io.InputStream;
//#endif 


//#if 1458025495 
import java.io.OutputStream;
//#endif 


//#if -1917224412 
import java.io.StringReader;
//#endif 


//#if 552924907 
import java.util.ArrayList;
//#endif 


//#if -693217130 
import java.util.List;
//#endif 


//#if -35727595 
import org.argouml.i18n.Translator;
//#endif 


//#if -991977265 
import org.argouml.kernel.Project;
//#endif 


//#if -1093687939 
import org.argouml.kernel.ProjectFactory;
//#endif 


//#if -1481794758 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 2005484117 
import org.argouml.kernel.ProjectMember;
//#endif 


//#if -39291813 
import org.argouml.model.Model;
//#endif 


//#if 644412860 
import org.argouml.util.ThreadUtils;
//#endif 


//#if -300450078 
import org.xml.sax.InputSource;
//#endif 


//#if -1886828312 
import org.apache.log4j.Logger;
//#endif 


//#if 1144672662 
import org.argouml.uml.cognitive.ProjectMemberTodoList;
//#endif 


//#if -178418041 
class XmiFilePersister extends 
//#if 1665538924 
AbstractFilePersister
//#endif 

 implements 
//#if -1265664479 
XmiExtensionParser
//#endif 

  { 

//#if -1814635130 
private List<String> pgmlStrings = new ArrayList<String>();
//#endif 


//#if 188839284 
private String argoString;
//#endif 


//#if -626647448 
private static final Logger LOG =
        Logger.getLogger(XmiFilePersister.class);
//#endif 


//#if 2123438439 
private String todoString;
//#endif 


//#if -669447894 
public void parse(String label, String xmiExtensionString)
    { 

//#if 1864537965 
if(label.equals("pgml"))//1
{ 

//#if 1811190171 
pgmlStrings.add(xmiExtensionString);
//#endif 

} 
else

//#if 1849342562 
if(label.equals("argo"))//1
{ 

//#if -1086849170 
argoString = xmiExtensionString;
//#endif 

} 
else

//#if 1308212007 
if(label.equals("todo"))//1
{ 

//#if -1496308906 
todoString = xmiExtensionString;
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if 67228165 
public void doSave(Project project, File file)
    throws SaveException, InterruptedException
    { 

//#if -1718065800 
ProgressMgr progressMgr = new ProgressMgr();
//#endif 


//#if 830191151 
progressMgr.setNumberOfPhases(4);
//#endif 


//#if -711423813 
progressMgr.nextPhase();
//#endif 


//#if -2140602863 
File lastArchiveFile = new File(file.getAbsolutePath() + "~");
//#endif 


//#if 1546163785 
File tempFile = null;
//#endif 


//#if 187245692 
try //1
{ 

//#if -1899705073 
tempFile = createTempFile(file);
//#endif 

} 

//#if -1715375166 
catch (FileNotFoundException e) //1
{ 

//#if -1309674530 
throw new SaveException(
                "Failed to archive the previous file version", e);
//#endif 

} 

//#endif 


//#if 550253245 
catch (IOException e) //1
{ 

//#if -1606936071 
throw new SaveException(
                "Failed to archive the previous file version", e);
//#endif 

} 

//#endif 


//#endif 


//#if -1944941634 
OutputStream stream = null;
//#endif 


//#if -926030667 
try //2
{ 

//#if -2012845135 
stream = new FileOutputStream(file);
//#endif 


//#if -540237043 
writeProject(project, stream, progressMgr);
//#endif 


//#if -1096855285 
stream.close();
//#endif 


//#if 842828497 
if(lastArchiveFile.exists())//1
{ 

//#if -1776632139 
lastArchiveFile.delete();
//#endif 

} 

//#endif 


//#if -1475411657 
if(tempFile.exists() && !lastArchiveFile.exists())//1
{ 

//#if 1551834669 
tempFile.renameTo(lastArchiveFile);
//#endif 

} 

//#endif 


//#if 905317309 
if(tempFile.exists())//1
{ 

//#if -396372098 
tempFile.delete();
//#endif 

} 

//#endif 

} 

//#if 332606532 
catch (InterruptedException exc) //1
{ 

//#if -1834243271 
try //1
{ 

//#if 686593446 
stream.close();
//#endif 

} 

//#if -1572381401 
catch (IOException ex) //1
{ 
} 

//#endif 


//#endif 


//#if 662254766 
throw exc;
//#endif 

} 

//#endif 


//#if 1334353509 
catch (Exception e) //1
{ 

//#if 1020367580 
LOG.error("Exception occured during save attempt", e);
//#endif 


//#if 83953964 
try //1
{ 

//#if 533471668 
stream.close();
//#endif 

} 

//#if -109176644 
catch (IOException ex) //1
{ 
} 

//#endif 


//#endif 


//#if 878849107 
file.delete();
//#endif 


//#if -1453285419 
tempFile.renameTo(file);
//#endif 


//#if -1689624207 
throw new SaveException(e);
//#endif 

} 

//#endif 


//#endif 


//#if 1636839351 
progressMgr.nextPhase();
//#endif 

} 

//#endif 


//#if -962812621 
public boolean isSaveEnabled()
    { 

//#if -235874611 
return false;
//#endif 

} 

//#endif 


//#if 1712342094 
public void parseXmiExtensions(Project project) throws OpenException
    { 

//#if 1391179259 
if(argoString != null)//1
{ 

//#if 1793658381 
LOG.info("Parsing argoString " + argoString.length());
//#endif 


//#if 943020408 
StringReader inputStream = new StringReader(argoString);
//#endif 


//#if -534489593 
ArgoParser parser = new ArgoParser();
//#endif 


//#if -1169424681 
try //1
{ 

//#if -864730340 
parser.readProject(project, inputStream);
//#endif 

} 

//#if 1485806388 
catch (Exception e) //1
{ 

//#if -631485336 
throw new OpenException("Exception caught", e);
//#endif 

} 

//#endif 


//#endif 

} 
else
{ 

//#if -1931728550 
project.addMember(new ProjectMemberTodoList("", project));
//#endif 

} 

//#endif 


//#if -335621755 
for (String pgml : pgmlStrings) //1
{ 

//#if 432559348 
LOG.info("Parsing pgml " + pgml.length());
//#endif 


//#if 1400499892 
InputStream inputStream = new ByteArrayInputStream(pgml.getBytes());
//#endif 


//#if -1628652344 
MemberFilePersister persister =
                // TODO: Cyclic dependency between PersistanceManager and here
                PersistenceManager.getInstance()
                .getDiagramMemberFilePersister();
//#endif 


//#if 345838836 
persister.load(project, inputStream);
//#endif 

} 

//#endif 


//#if -851848344 
if(todoString != null)//1
{ 

//#if 1132727661 
LOG.info("Parsing todoString " + todoString.length());
//#endif 


//#if 838491118 
InputStream inputStream =
                new ByteArrayInputStream(todoString.getBytes());
//#endif 


//#if -1087624152 
MemberFilePersister persister = null;
//#endif 


//#if 1602926684 
persister = new TodoListMemberFilePersister();
//#endif 


//#if 388184175 
persister.load(project, inputStream);
//#endif 

} 
else
{ 

//#if 1336724524 
project.addMember(new ProjectMemberTodoList("", project));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 290313307 
void writeProject(Project project,
                      OutputStream stream,
                      ProgressMgr progressMgr) throws SaveException,
                                      InterruptedException
    { 

//#if 1935857653 
int size = project.getMembers().size();
//#endif 


//#if 1033134517 
for (int i = 0; i < size; i++) //1
{ 

//#if 711039520 
ProjectMember projectMember =
                project.getMembers().get(i);
//#endif 


//#if -1404036046 
if(projectMember.getType().equalsIgnoreCase(getExtension()))//1
{ 

//#if 524479633 
if(LOG.isInfoEnabled())//1
{ 

//#if 1996442452 
LOG.info("Saving member of type: "
                             + (project.getMembers()
                                .get(i)).getType());
//#endif 

} 

//#endif 


//#if 1186365067 
MemberFilePersister persister = new ModelMemberFilePersister();
//#endif 


//#if 1818311893 
persister.save(projectMember, stream);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1458676241 
if(progressMgr != null)//1
{ 

//#if -651385222 
progressMgr.nextPhase();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 203595547 
public String getExtension()
    { 

//#if -425279579 
return "xmi";
//#endif 

} 

//#endif 


//#if 1388794297 
public boolean hasAnIcon()
    { 

//#if -780620176 
return true;
//#endif 

} 

//#endif 


//#if -1370746636 
public Project doLoad(File file)
    throws OpenException, InterruptedException
    { 

//#if -1004842136 
LOG.info("Loading with XMIFilePersister");
//#endif 


//#if -2118997397 
try //1
{ 

//#if 361147518 
Project p = ProjectFactory.getInstance().createProject();
//#endif 


//#if 680204853 
long length = file.length();
//#endif 


//#if 501199310 
long phaseSpace = 100000;
//#endif 


//#if -461981534 
int phases = (int) (length / phaseSpace);
//#endif 


//#if -2060603992 
if(phases < 10)//1
{ 

//#if 557191145 
phaseSpace = length / 10;
//#endif 


//#if -131536973 
phases = 10;
//#endif 

} 

//#endif 


//#if -914019359 
LOG.info("File length is " + length + " phase space is "
                     + phaseSpace + " phases is " + phases);
//#endif 


//#if -1063123558 
ProgressMgr progressMgr = new ProgressMgr();
//#endif 


//#if -902005245 
progressMgr.setNumberOfPhases(phases);
//#endif 


//#if -719748082 
ThreadUtils.checkIfInterrupted();
//#endif 


//#if -1397342675 
InputSource source = new InputSource(new XmiInputStream(file
                                                 .toURI().toURL().openStream(), this, phaseSpace,
                                                 progressMgr));
//#endif 


//#if -1746272129 
source.setSystemId(file.toURI().toURL().toString());
//#endif 


//#if -808764365 
ModelMemberFilePersister modelPersister =
                new ModelMemberFilePersister();
//#endif 


//#if -1947521305 
modelPersister.readModels(source);
//#endif 


//#if -283924426 
Object model = modelPersister.getCurModel();
//#endif 


//#if 651865309 
progressMgr.nextPhase();
//#endif 


//#if 1937443023 
Model.getUmlHelper().addListenersToModel(model);
//#endif 


//#if 1834496511 
p.setUUIDRefs(modelPersister.getUUIDRefs());
//#endif 


//#if 1733049640 
p.addMember(model);
//#endif 


//#if -1075524681 
parseXmiExtensions(p);
//#endif 


//#if -704246997 
modelPersister.registerDiagrams(p);
//#endif 


//#if -645316495 
p.setRoot(model);
//#endif 


//#if -1601183021 
p.setRoots(modelPersister.getElementsRead());
//#endif 


//#if 1311398365 
File defaultProjectFile = new File(file.getPath() + ".zargo");
//#endif 


//#if -55656080 
for (int i = 0; i < 99; i++) //1
{ 

//#if 1930108152 
if(!defaultProjectFile.exists())//1
{ 

//#if 812551322 
break;

//#endif 

} 

//#endif 


//#if -1322591295 
defaultProjectFile =
                    new File(file.getPath() + "." + i + ".zargo");
//#endif 

} 

//#endif 


//#if -217638501 
PersistenceManager.getInstance().setProjectURI(
                defaultProjectFile.toURI(), p);
//#endif 


//#if -2122645419 
progressMgr.nextPhase();
//#endif 


//#if -1822142573 
ProjectManager.getManager().setSaveEnabled(false);
//#endif 


//#if -965551261 
return p;
//#endif 

} 

//#if -1675480962 
catch (IOException e) //1
{ 

//#if -238531989 
throw new OpenException(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1139382784 
protected String getDesc()
    { 

//#if -1827931864 
return Translator.localize("combobox.filefilter.xmi");
//#endif 

} 

//#endif 


//#if -1222627086 
public XmiFilePersister()
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

