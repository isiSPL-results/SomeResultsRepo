// Compilation Unit of /ImportCommon.java 
 
package org.argouml.uml.reveng;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.StringTokenizer;
import org.argouml.application.api.Argo;
import org.argouml.cognitive.Designer;
import org.argouml.configuration.Configuration;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.taskmgmt.ProgressMonitor;
import org.argouml.ui.explorer.ExplorerEventAdaptor;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.static_structure.ClassDiagramGraphModel;
import org.argouml.uml.diagram.static_structure.layout.ClassdiagramLayouter;
import org.argouml.util.SuffixFilter;
import org.tigris.gef.base.Globals;
public abstract class ImportCommon implements ImportSettingsInternal
  { 
protected static final int MAX_PROGRESS_PREPARE = 1;
protected static final int MAX_PROGRESS_IMPORT = 99;
protected static final int MAX_PROGRESS = MAX_PROGRESS_PREPARE
            + MAX_PROGRESS_IMPORT;
private Hashtable<String, ImportInterface> modules;
private ImportInterface currentModule;
private String srcPath;
private DiagramInterface diagramInterface;
private File[] selectedFiles;
private SuffixFilter selectedSuffixFilter;
protected void initCurrentDiagram()
    { 
diagramInterface = getCurrentDiagram();
} 

public String getEncoding()
    { 
String enc = Configuration.getString(Argo.KEY_INPUT_SOURCE_ENCODING);
if(enc == null || enc.trim().equals(""))//1
{ 
enc = System.getProperty("file.encoding");
} 

return enc;
} 

public boolean isDescend()
    { 
String flags =
            Configuration.getString(
                Argo.KEY_IMPORT_GENERAL_SETTINGS_FLAGS);
if(flags != null && flags.length() > 0)//1
{ 
StringTokenizer st = new StringTokenizer(flags, ",");
if(st.hasMoreTokens() && st.nextToken().equals("false"))//1
{ 
return false;
} 

} 

return true;
} 

private String getQualifiedName(Object element)
    { 
StringBuffer sb = new StringBuffer();
Object ns = element;
while (ns != null) //1
{ 
String name = Model.getFacade().getName(ns);
if(name == null)//1
{ 
name = "";
} 

sb.insert(0, name);
ns = Model.getFacade().getNamespace(ns);
if(ns != null)//1
{ 
sb.insert(0, ".");
} 

} 

return sb.toString();
} 

public boolean isDiagramLayout()
    { 
String flags =
            Configuration.getString(
                Argo.KEY_IMPORT_GENERAL_SETTINGS_FLAGS);
if(flags != null && flags.length() > 0)//1
{ 
StringTokenizer st = new StringTokenizer(flags, ",");
skipTokens(st, 4);
if(st.hasMoreTokens() && st.nextToken().equals("false"))//1
{ 
return false;
} 

} 

return true;
} 

protected ImportInterface getCurrentModule()
    { 
return currentModule;
} 

protected void setCurrentModule(ImportInterface module)
    { 
currentModule = module;
} 

public void setSrcPath(String path)
    { 
srcPath = path;
} 

protected void setSelectedFiles(final File[] files)
    { 
selectedFiles = files;
} 

public abstract boolean isDescendSelected();
protected Hashtable<String, ImportInterface> getModules()
    { 
return modules;
} 

private void addFiguresToDiagrams(Collection newElements)
    { 
for (Object element : newElements) //1
{ 
if(Model.getFacade().isAClassifier(element)
                    || Model.getFacade().isAPackage(element))//1
{ 
Object ns = Model.getFacade().getNamespace(element);
if(ns == null)//1
{ 
diagramInterface.createRootClassDiagram();
} 
else
{ 
String packageName = getQualifiedName(ns);
if(packageName != null
                            && !packageName.equals(""))//1
{ 
diagramInterface.selectClassDiagram(ns,
                                                            packageName);
} 
else
{ 
diagramInterface.createRootClassDiagram();
} 

if(Model.getFacade().isAInterface(element))//1
{ 
diagramInterface.addInterface(element,
                                                      isMinimizeFigsSelected());
} 
else
if(Model.getFacade().isAClass(element))//1
{ 
diagramInterface.addClass(element,
                                                  isMinimizeFigsSelected());
} 
else
if(Model.getFacade().isAPackage(element))//1
{ 
diagramInterface.addPackage(element);
} 



} 

} 

} 

} 

public abstract boolean isMinimizeFigsSelected();
public abstract boolean isChangedOnlySelected();
protected List<File> getFileList(ProgressMonitor monitor)
    { 
List<File> files = Arrays.asList(getSelectedFiles());
if(files.size() == 1)//1
{ 
File file = files.get(0);
SuffixFilter suffixFilters[] = {selectedSuffixFilter};
if(suffixFilters[0] == null)//1
{ 
suffixFilters = currentModule.getSuffixFilters();
} 

files =
                FileImportUtils.getList(
                    file, isDescendSelected(),
                    suffixFilters, monitor);
if(file.isDirectory())//1
{ 
setSrcPath(file.getAbsolutePath());
} 
else
{ 
setSrcPath(null);
} 

} 

if(isChangedOnlySelected())//1
{ 
Object model =
                ProjectManager.getManager().getCurrentProject().getModel();
for (int i = files.size() - 1; i >= 0; i--) //1
{ 
File f = files.get(i);
String fn = f.getAbsolutePath();
String lm = String.valueOf(f.lastModified());
if(lm.equals(
                            Model.getFacade().getTaggedValueValue(model, fn)))//1
{ 
files.remove(i);
} 

} 

} 

return files;
} 

protected void doImport(ProgressMonitor monitor)
    { 
monitor.setMaximumProgress(MAX_PROGRESS);
int progress = 0;
monitor.updateSubTask(Translator.localize("dialog.import.preImport"));
List<File> files = getFileList(monitor);
progress += MAX_PROGRESS_PREPARE;
monitor.updateProgress(progress);
if(files.size() == 0)//1
{ 
monitor.notifyNullAction();
return;
} 

Model.getPump().stopPumpingEvents();
boolean criticThreadWasOn = Designer.theDesigner().getAutoCritique();
if(criticThreadWasOn)//1
{ 
Designer.theDesigner().setAutoCritique(false);
} 

try //1
{ 
doImportInternal(files, monitor, progress);
} 
finally { 
if(criticThreadWasOn)//1
{ 
Designer.theDesigner().setAutoCritique(true);
} 

ExplorerEventAdaptor.getInstance().structureChanged();
Model.getPump().startPumpingEvents();
} 

} 

public abstract boolean isCreateDiagramsSelected();
public boolean isMinimizeFigs()
    { 
String flags =
            Configuration.getString(
                Argo.KEY_IMPORT_GENERAL_SETTINGS_FLAGS);
if(flags != null && flags.length() > 0)//1
{ 
StringTokenizer st = new StringTokenizer(flags, ",");
skipTokens(st, 3);
if(st.hasMoreTokens() && st.nextToken().equals("false"))//1
{ 
return false;
} 

} 

return true;
} 

public abstract int getImportLevel();
public abstract String getInputSourceEncoding();
private void skipTokens(StringTokenizer st, int count)
    { 
for (int i = 0; i < count; i++) //1
{ 
if(st.hasMoreTokens())//1
{ 
st.nextToken();
} 

} 

} 

private DiagramInterface getCurrentDiagram()
    { 
DiagramInterface result = null;
if(Globals.curEditor().getGraphModel()
                instanceof ClassDiagramGraphModel)//1
{ 
result =  new DiagramInterface(Globals.curEditor());
} 

return result;
} 

protected File[] getSelectedFiles()
    { 
File[] copy = new File[selectedFiles.length];
for (int i = 0; i < selectedFiles.length; i++) //1
{ 
copy[i] = selectedFiles[i];
} 

return copy;
} 

private void doImportInternal(List<File> filesLeft,
                                  final ProgressMonitor monitor, int progress)
    { 
Project project =  ProjectManager.getManager().getCurrentProject();
initCurrentDiagram();
final StringBuffer problems = new StringBuffer();
Collection newElements = new HashSet();
try //1
{ 
newElements.addAll(currentModule.parseFiles(
                                   project, filesLeft, this, monitor));
} 
catch (Exception e) //1
{ 
problems.append(printToBuffer(e));
} 


if(isCreateDiagramsSelected())//1
{ 
addFiguresToDiagrams(newElements);
} 

if(isDiagramLayoutSelected())//1
{ 
monitor.updateMainTask(
                Translator.localize("dialog.import.postImport"));
monitor.updateSubTask(
                Translator.localize("dialog.import.layoutAction"));
layoutDiagrams(monitor, progress + filesLeft.size());
} 

if(problems != null && problems.length() > 0)//1
{ 
monitor.notifyMessage(
                Translator.localize(
                    "dialog.title.import-problems"), //$NON-NLS-1$
                Translator.localize(
                    "label.import-problems"),        //$NON-NLS-1$
                problems.toString());
} 

monitor.updateMainTask(Translator.localize("dialog.import.done"));
monitor.updateSubTask("");
monitor.updateProgress(MAX_PROGRESS);
} 

public boolean isChangedOnly()
    { 
String flags =
            Configuration.getString(Argo.KEY_IMPORT_GENERAL_SETTINGS_FLAGS);
if(flags != null && flags.length() > 0)//1
{ 
StringTokenizer st = new StringTokenizer(flags, ",");
skipTokens(st, 1);
if(st.hasMoreTokens() && st.nextToken().equals("false"))//1
{ 
return false;
} 

} 

return true;
} 

public boolean isCreateDiagrams()
    { 
String flags =
            Configuration.getString(
                Argo.KEY_IMPORT_GENERAL_SETTINGS_FLAGS);
if(flags != null && flags.length() > 0)//1
{ 
StringTokenizer st = new StringTokenizer(flags, ",");
skipTokens(st, 2);
if(st.hasMoreTokens() && st.nextToken().equals("false"))//1
{ 
return false;
} 

} 

return true;
} 

public String getSrcPath()
    { 
return srcPath;
} 

private void setLastModified(Project project, File file)
    { 
String fn = file.getAbsolutePath();
String lm = String.valueOf(file.lastModified());
if(lm != null)//1
{ 
Model.getCoreHelper()
            .setTaggedValue(project.getModel(), fn, lm);
} 

} 

private StringBuffer printToBuffer(Exception e)
    { 
StringWriter sw = new StringWriter();
PrintWriter pw = new java.io.PrintWriter(sw);
e.printStackTrace(pw);
return sw.getBuffer();
} 

public abstract boolean isDiagramLayoutSelected();
protected ImportCommon()
    { 
super();
modules = new Hashtable<String, ImportInterface>();
for (ImportInterface importer : ImporterManager.getInstance()
                .getImporters()) //1
{ 
modules.put(importer.getName(), importer);
} 

if(modules.isEmpty())//1
{ 
throw new RuntimeException("Internal error. "
                                       + "No importer modules found.");
} 

currentModule = modules.get("Java");
if(currentModule == null)//1
{ 
currentModule = modules.elements().nextElement();
} 

} 

public void layoutDiagrams(ProgressMonitor monitor, int startingProgress)
    { 
if(diagramInterface == null)//1
{ 
return;
} 

List<ArgoDiagram> diagrams = diagramInterface.getModifiedDiagramList();
int total = startingProgress + diagrams.size()
                    / 10;
for (int i = 0; i < diagrams.size(); i++) //1
{ 
ArgoDiagram diagram = diagrams.get(i);
ClassdiagramLayouter layouter = new ClassdiagramLayouter(diagram);
layouter.layout();
int act = startingProgress + (i + 1) / 10;
int progress = MAX_PROGRESS_PREPARE
                           + MAX_PROGRESS_IMPORT * act / total;
if(monitor != null)//1
{ 
monitor.updateProgress(progress);
} 

} 

} 

protected void setSelectedSuffixFilter(final SuffixFilter suffixFilter)
    { 
selectedSuffixFilter = suffixFilter;
} 

public List<String> getLanguages()
    { 
return Collections.unmodifiableList(
                   new ArrayList<String>(modules.keySet()));
} 

 } 


