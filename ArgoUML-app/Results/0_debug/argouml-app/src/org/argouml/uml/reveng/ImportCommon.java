
//#if 1900805832 
// Compilation Unit of /ImportCommon.java 
 

//#if 344416741 
package org.argouml.uml.reveng;
//#endif 


//#if 886493052 
import java.io.File;
//#endif 


//#if -114172194 
import java.io.PrintWriter;
//#endif 


//#if -41376492 
import java.io.StringWriter;
//#endif 


//#if 1289314891 
import java.util.ArrayList;
//#endif 


//#if 526264794 
import java.util.Arrays;
//#endif 


//#if -1641313162 
import java.util.Collection;
//#endif 


//#if 658901325 
import java.util.Collections;
//#endif 


//#if 575366606 
import java.util.HashSet;
//#endif 


//#if -182890878 
import java.util.Hashtable;
//#endif 


//#if 399266102 
import java.util.List;
//#endif 


//#if -113150084 
import java.util.StringTokenizer;
//#endif 


//#if -1969782804 
import org.argouml.application.api.Argo;
//#endif 


//#if 2040548216 
import org.argouml.cognitive.Designer;
//#endif 


//#if 1798776097 
import org.argouml.configuration.Configuration;
//#endif 


//#if 970056309 
import org.argouml.i18n.Translator;
//#endif 


//#if 1118677359 
import org.argouml.kernel.Project;
//#endif 


//#if -1673355622 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -2136461381 
import org.argouml.model.Model;
//#endif 


//#if -404970446 
import org.argouml.taskmgmt.ProgressMonitor;
//#endif 


//#if -43914088 
import org.argouml.ui.explorer.ExplorerEventAdaptor;
//#endif 


//#if 1432981754 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 479640658 
import org.argouml.uml.diagram.static_structure.ClassDiagramGraphModel;
//#endif 


//#if 1862578520 
import org.argouml.uml.diagram.static_structure.layout.ClassdiagramLayouter;
//#endif 


//#if -1261645270 
import org.argouml.util.SuffixFilter;
//#endif 


//#if 981235375 
import org.tigris.gef.base.Globals;
//#endif 


//#if 247248315 
public abstract class ImportCommon implements 
//#if -1667625093 
ImportSettingsInternal
//#endif 

  { 

//#if 100583512 
protected static final int MAX_PROGRESS_PREPARE = 1;
//#endif 


//#if -779610021 
protected static final int MAX_PROGRESS_IMPORT = 99;
//#endif 


//#if -132012444 
protected static final int MAX_PROGRESS = MAX_PROGRESS_PREPARE
            + MAX_PROGRESS_IMPORT;
//#endif 


//#if -1498070000 
private Hashtable<String, ImportInterface> modules;
//#endif 


//#if 1305364477 
private ImportInterface currentModule;
//#endif 


//#if 746767440 
private String srcPath;
//#endif 


//#if 1669210434 
private DiagramInterface diagramInterface;
//#endif 


//#if 1592151754 
private File[] selectedFiles;
//#endif 


//#if 1757969569 
private SuffixFilter selectedSuffixFilter;
//#endif 


//#if -1221011785 
protected void initCurrentDiagram()
    { 

//#if -1714952805 
diagramInterface = getCurrentDiagram();
//#endif 

} 

//#endif 


//#if -1096829286 
public String getEncoding()
    { 

//#if 978945706 
String enc = Configuration.getString(Argo.KEY_INPUT_SOURCE_ENCODING);
//#endif 


//#if 703735755 
if(enc == null || enc.trim().equals(""))//1
{ 

//#if 1892732796 
enc = System.getProperty("file.encoding");
//#endif 

} 

//#endif 


//#if -1564900753 
return enc;
//#endif 

} 

//#endif 


//#if -261086664 
public boolean isDescend()
    { 

//#if 471952737 
String flags =
            Configuration.getString(
                Argo.KEY_IMPORT_GENERAL_SETTINGS_FLAGS);
//#endif 


//#if -560246865 
if(flags != null && flags.length() > 0)//1
{ 

//#if 998811249 
StringTokenizer st = new StringTokenizer(flags, ",");
//#endif 


//#if -949923915 
if(st.hasMoreTokens() && st.nextToken().equals("false"))//1
{ 

//#if 14398488 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -56889035 
return true;
//#endif 

} 

//#endif 


//#if 2073973925 
private String getQualifiedName(Object element)
    { 

//#if -1146809118 
StringBuffer sb = new StringBuffer();
//#endif 


//#if 1304663700 
Object ns = element;
//#endif 


//#if -944557077 
while (ns != null) //1
{ 

//#if 2024293973 
String name = Model.getFacade().getName(ns);
//#endif 


//#if -760962311 
if(name == null)//1
{ 

//#if -1797844867 
name = "";
//#endif 

} 

//#endif 


//#if 372799701 
sb.insert(0, name);
//#endif 


//#if -67126036 
ns = Model.getFacade().getNamespace(ns);
//#endif 


//#if 277563919 
if(ns != null)//1
{ 

//#if 1643345975 
sb.insert(0, ".");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 728005763 
return sb.toString();
//#endif 

} 

//#endif 


//#if 1154604267 
public boolean isDiagramLayout()
    { 

//#if -1259088534 
String flags =
            Configuration.getString(
                Argo.KEY_IMPORT_GENERAL_SETTINGS_FLAGS);
//#endif 


//#if 743781560 
if(flags != null && flags.length() > 0)//1
{ 

//#if 83757479 
StringTokenizer st = new StringTokenizer(flags, ",");
//#endif 


//#if -121347684 
skipTokens(st, 4);
//#endif 


//#if -1077335745 
if(st.hasMoreTokens() && st.nextToken().equals("false"))//1
{ 

//#if -2046908610 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1278600180 
return true;
//#endif 

} 

//#endif 


//#if 42405228 
protected ImportInterface getCurrentModule()
    { 

//#if 1677387793 
return currentModule;
//#endif 

} 

//#endif 


//#if -1601947870 
protected void setCurrentModule(ImportInterface module)
    { 

//#if -1535565883 
currentModule = module;
//#endif 

} 

//#endif 


//#if 355894949 
public void setSrcPath(String path)
    { 

//#if 1170418137 
srcPath = path;
//#endif 

} 

//#endif 


//#if -1491391708 
protected void setSelectedFiles(final File[] files)
    { 

//#if 1069906780 
selectedFiles = files;
//#endif 

} 

//#endif 


//#if -910751275 
public abstract boolean isDescendSelected();
//#endif 


//#if 196512451 
protected Hashtable<String, ImportInterface> getModules()
    { 

//#if -569870298 
return modules;
//#endif 

} 

//#endif 


//#if 1150316366 
private void addFiguresToDiagrams(Collection newElements)
    { 

//#if 1444245886 
for (Object element : newElements) //1
{ 

//#if 503675412 
if(Model.getFacade().isAClassifier(element)
                    || Model.getFacade().isAPackage(element))//1
{ 

//#if -1265819979 
Object ns = Model.getFacade().getNamespace(element);
//#endif 


//#if -349267058 
if(ns == null)//1
{ 

//#if -294356098 
diagramInterface.createRootClassDiagram();
//#endif 

} 
else
{ 

//#if 1672601595 
String packageName = getQualifiedName(ns);
//#endif 


//#if 955721415 
if(packageName != null
                            && !packageName.equals(""))//1
{ 

//#if 421774736 
diagramInterface.selectClassDiagram(ns,
                                                            packageName);
//#endif 

} 
else
{ 

//#if -1215188885 
diagramInterface.createRootClassDiagram();
//#endif 

} 

//#endif 


//#if 1398174052 
if(Model.getFacade().isAInterface(element))//1
{ 

//#if -720093418 
diagramInterface.addInterface(element,
                                                      isMinimizeFigsSelected());
//#endif 

} 
else

//#if 1907846927 
if(Model.getFacade().isAClass(element))//1
{ 

//#if -2087858613 
diagramInterface.addClass(element,
                                                  isMinimizeFigsSelected());
//#endif 

} 
else

//#if -1267352844 
if(Model.getFacade().isAPackage(element))//1
{ 

//#if 1016432706 
diagramInterface.addPackage(element);
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -199056870 
public abstract boolean isMinimizeFigsSelected();
//#endif 


//#if -134050133 
public abstract boolean isChangedOnlySelected();
//#endif 


//#if 659319912 
protected List<File> getFileList(ProgressMonitor monitor)
    { 

//#if 240105469 
List<File> files = Arrays.asList(getSelectedFiles());
//#endif 


//#if -2015050869 
if(files.size() == 1)//1
{ 

//#if 1845364740 
File file = files.get(0);
//#endif 


//#if -1439464941 
SuffixFilter suffixFilters[] = {selectedSuffixFilter};
//#endif 


//#if -638626616 
if(suffixFilters[0] == null)//1
{ 

//#if -1778711101 
suffixFilters = currentModule.getSuffixFilters();
//#endif 

} 

//#endif 


//#if -392831726 
files =
                FileImportUtils.getList(
                    file, isDescendSelected(),
                    suffixFilters, monitor);
//#endif 


//#if 602474677 
if(file.isDirectory())//1
{ 

//#if 1032870561 
setSrcPath(file.getAbsolutePath());
//#endif 

} 
else
{ 

//#if 1065377483 
setSrcPath(null);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -150329307 
if(isChangedOnlySelected())//1
{ 

//#if 160531277 
Object model =
                ProjectManager.getManager().getCurrentProject().getModel();
//#endif 


//#if 401441228 
for (int i = files.size() - 1; i >= 0; i--) //1
{ 

//#if 1241949517 
File f = files.get(i);
//#endif 


//#if -821669214 
String fn = f.getAbsolutePath();
//#endif 


//#if 1700447582 
String lm = String.valueOf(f.lastModified());
//#endif 


//#if 1333731664 
if(lm.equals(
                            Model.getFacade().getTaggedValueValue(model, fn)))//1
{ 

//#if -2052427142 
files.remove(i);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -988489206 
return files;
//#endif 

} 

//#endif 


//#if -458965456 
protected void doImport(ProgressMonitor monitor)
    { 

//#if -1815038146 
monitor.setMaximumProgress(MAX_PROGRESS);
//#endif 


//#if -918484591 
int progress = 0;
//#endif 


//#if -343708948 
monitor.updateSubTask(Translator.localize("dialog.import.preImport"));
//#endif 


//#if -161627963 
List<File> files = getFileList(monitor);
//#endif 


//#if -1434218425 
progress += MAX_PROGRESS_PREPARE;
//#endif 


//#if -192971880 
monitor.updateProgress(progress);
//#endif 


//#if -959670919 
if(files.size() == 0)//1
{ 

//#if -1141927541 
monitor.notifyNullAction();
//#endif 


//#if -1652540970 
return;
//#endif 

} 

//#endif 


//#if -1324675198 
Model.getPump().stopPumpingEvents();
//#endif 


//#if -704354623 
boolean criticThreadWasOn = Designer.theDesigner().getAutoCritique();
//#endif 


//#if -260214452 
if(criticThreadWasOn)//1
{ 

//#if 520082676 
Designer.theDesigner().setAutoCritique(false);
//#endif 

} 

//#endif 


//#if -1123251493 
try //1
{ 

//#if -1124989317 
doImportInternal(files, monitor, progress);
//#endif 

} 
finally { 

//#if 668113858 
if(criticThreadWasOn)//1
{ 

//#if 1535791779 
Designer.theDesigner().setAutoCritique(true);
//#endif 

} 

//#endif 


//#if -1900129010 
ExplorerEventAdaptor.getInstance().structureChanged();
//#endif 


//#if -1121450470 
Model.getPump().startPumpingEvents();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1489371767 
public abstract boolean isCreateDiagramsSelected();
//#endif 


//#if -1203719295 
public boolean isMinimizeFigs()
    { 

//#if -603339164 
String flags =
            Configuration.getString(
                Argo.KEY_IMPORT_GENERAL_SETTINGS_FLAGS);
//#endif 


//#if -1084545102 
if(flags != null && flags.length() > 0)//1
{ 

//#if 2010590446 
StringTokenizer st = new StringTokenizer(flags, ",");
//#endif 


//#if 218384244 
skipTokens(st, 3);
//#endif 


//#if 1004914136 
if(st.hasMoreTokens() && st.nextToken().equals("false"))//1
{ 

//#if 169906383 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -248097838 
return true;
//#endif 

} 

//#endif 


//#if -759924840 
public abstract int getImportLevel();
//#endif 


//#if 1694801109 
public abstract String getInputSourceEncoding();
//#endif 


//#if -290695850 
private void skipTokens(StringTokenizer st, int count)
    { 

//#if 692483217 
for (int i = 0; i < count; i++) //1
{ 

//#if 2013151564 
if(st.hasMoreTokens())//1
{ 

//#if -1525295533 
st.nextToken();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -479728194 
private DiagramInterface getCurrentDiagram()
    { 

//#if -1023870429 
DiagramInterface result = null;
//#endif 


//#if 212262812 
if(Globals.curEditor().getGraphModel()
                instanceof ClassDiagramGraphModel)//1
{ 

//#if 8599353 
result =  new DiagramInterface(Globals.curEditor());
//#endif 

} 

//#endif 


//#if 811776549 
return result;
//#endif 

} 

//#endif 


//#if 277225789 
protected File[] getSelectedFiles()
    { 

//#if 1355674365 
File[] copy = new File[selectedFiles.length];
//#endif 


//#if -621750610 
for (int i = 0; i < selectedFiles.length; i++) //1
{ 

//#if 670121507 
copy[i] = selectedFiles[i];
//#endif 

} 

//#endif 


//#if -1634361420 
return copy;
//#endif 

} 

//#endif 


//#if -1884491806 
private void doImportInternal(List<File> filesLeft,
                                  final ProgressMonitor monitor, int progress)
    { 

//#if -835458262 
Project project =  ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 1870839869 
initCurrentDiagram();
//#endif 


//#if 476001886 
final StringBuffer problems = new StringBuffer();
//#endif 


//#if -823501521 
Collection newElements = new HashSet();
//#endif 


//#if 2121388777 
try //1
{ 

//#if -1798997454 
newElements.addAll(currentModule.parseFiles(
                                   project, filesLeft, this, monitor));
//#endif 

} 

//#if 890553837 
catch (Exception e) //1
{ 

//#if -1436847182 
problems.append(printToBuffer(e));
//#endif 

} 

//#endif 


//#endif 


//#if -282207678 
if(isCreateDiagramsSelected())//1
{ 

//#if 925898640 
addFiguresToDiagrams(newElements);
//#endif 

} 

//#endif 


//#if 2089339839 
if(isDiagramLayoutSelected())//1
{ 

//#if 1605631742 
monitor.updateMainTask(
                Translator.localize("dialog.import.postImport"));
//#endif 


//#if 211603904 
monitor.updateSubTask(
                Translator.localize("dialog.import.layoutAction"));
//#endif 


//#if -1768335323 
layoutDiagrams(monitor, progress + filesLeft.size());
//#endif 

} 

//#endif 


//#if -354450644 
if(problems != null && problems.length() > 0)//1
{ 

//#if -82979700 
monitor.notifyMessage(
                Translator.localize(
                    "dialog.title.import-problems"), //$NON-NLS-1$
                Translator.localize(
                    "label.import-problems"),        //$NON-NLS-1$
                problems.toString());
//#endif 

} 

//#endif 


//#if 4355419 
monitor.updateMainTask(Translator.localize("dialog.import.done"));
//#endif 


//#if -493837819 
monitor.updateSubTask("");
//#endif 


//#if 22263589 
monitor.updateProgress(MAX_PROGRESS);
//#endif 

} 

//#endif 


//#if 309591566 
public boolean isChangedOnly()
    { 

//#if 1175215492 
String flags =
            Configuration.getString(Argo.KEY_IMPORT_GENERAL_SETTINGS_FLAGS);
//#endif 


//#if -333750574 
if(flags != null && flags.length() > 0)//1
{ 

//#if -675234721 
StringTokenizer st = new StringTokenizer(flags, ",");
//#endif 


//#if 1169889953 
skipTokens(st, 1);
//#endif 


//#if -1934097017 
if(st.hasMoreTokens() && st.nextToken().equals("false"))//1
{ 

//#if -1996064768 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1636522162 
return true;
//#endif 

} 

//#endif 


//#if -407265936 
public boolean isCreateDiagrams()
    { 

//#if -384553607 
String flags =
            Configuration.getString(
                Argo.KEY_IMPORT_GENERAL_SETTINGS_FLAGS);
//#endif 


//#if 1537345479 
if(flags != null && flags.length() > 0)//1
{ 

//#if -1174143142 
StringTokenizer st = new StringTokenizer(flags, ",");
//#endif 


//#if -1585246521 
skipTokens(st, 2);
//#endif 


//#if -117379860 
if(st.hasMoreTokens() && st.nextToken().equals("false"))//1
{ 

//#if 661037941 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -299889123 
return true;
//#endif 

} 

//#endif 


//#if 276716836 
public String getSrcPath()
    { 

//#if 1887946185 
return srcPath;
//#endif 

} 

//#endif 


//#if -1234131859 
private void setLastModified(Project project, File file)
    { 

//#if 943436379 
String fn = file.getAbsolutePath();
//#endif 


//#if -2067470739 
String lm = String.valueOf(file.lastModified());
//#endif 


//#if -887500494 
if(lm != null)//1
{ 

//#if -288436735 
Model.getCoreHelper()
            .setTaggedValue(project.getModel(), fn, lm);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -278360363 
private StringBuffer printToBuffer(Exception e)
    { 

//#if -75583238 
StringWriter sw = new StringWriter();
//#endif 


//#if 905976755 
PrintWriter pw = new java.io.PrintWriter(sw);
//#endif 


//#if 1541322193 
e.printStackTrace(pw);
//#endif 


//#if 130424877 
return sw.getBuffer();
//#endif 

} 

//#endif 


//#if 2013683720 
public abstract boolean isDiagramLayoutSelected();
//#endif 


//#if -1395416215 
protected ImportCommon()
    { 

//#if 1690696113 
super();
//#endif 


//#if 964204169 
modules = new Hashtable<String, ImportInterface>();
//#endif 


//#if -379069906 
for (ImportInterface importer : ImporterManager.getInstance()
                .getImporters()) //1
{ 

//#if 298372037 
modules.put(importer.getName(), importer);
//#endif 

} 

//#endif 


//#if 1996735948 
if(modules.isEmpty())//1
{ 

//#if 2068879084 
throw new RuntimeException("Internal error. "
                                       + "No importer modules found.");
//#endif 

} 

//#endif 


//#if -1106574765 
currentModule = modules.get("Java");
//#endif 


//#if 1788444251 
if(currentModule == null)//1
{ 

//#if -1258522294 
currentModule = modules.elements().nextElement();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1957545089 
public void layoutDiagrams(ProgressMonitor monitor, int startingProgress)
    { 

//#if 1144882744 
if(diagramInterface == null)//1
{ 

//#if -896412603 
return;
//#endif 

} 

//#endif 


//#if 314215203 
List<ArgoDiagram> diagrams = diagramInterface.getModifiedDiagramList();
//#endif 


//#if 1153575935 
int total = startingProgress + diagrams.size()
                    / 10;
//#endif 


//#if 1260665580 
for (int i = 0; i < diagrams.size(); i++) //1
{ 

//#if 1905823510 
ArgoDiagram diagram = diagrams.get(i);
//#endif 


//#if 106086436 
ClassdiagramLayouter layouter = new ClassdiagramLayouter(diagram);
//#endif 


//#if 2039984674 
layouter.layout();
//#endif 


//#if 335361090 
int act = startingProgress + (i + 1) / 10;
//#endif 


//#if 579607443 
int progress = MAX_PROGRESS_PREPARE
                           + MAX_PROGRESS_IMPORT * act / total;
//#endif 


//#if 429545763 
if(monitor != null)//1
{ 

//#if -1523503492 
monitor.updateProgress(progress);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1340001071 
protected void setSelectedSuffixFilter(final SuffixFilter suffixFilter)
    { 

//#if -47843596 
selectedSuffixFilter = suffixFilter;
//#endif 

} 

//#endif 


//#if -386097324 
public List<String> getLanguages()
    { 

//#if 1623445132 
return Collections.unmodifiableList(
                   new ArrayList<String>(modules.keySet()));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

