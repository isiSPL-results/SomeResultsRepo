
//#if 538620186 
// Compilation Unit of /ProjectImpl.java 
 

//#if 478614544 
package org.argouml.kernel;
//#endif 


//#if -351314333 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -419279547 
import java.beans.PropertyChangeListener;
//#endif 


//#if -818650104 
import java.beans.PropertyVetoException;
//#endif 


//#if -29380355 
import java.beans.VetoableChangeSupport;
//#endif 


//#if -259239767 
import java.io.File;
//#endif 


//#if 1561029490 
import java.net.URI;
//#endif 


//#if -1514822530 
import java.util.ArrayList;
//#endif 


//#if 1624740003 
import java.util.Collection;
//#endif 


//#if -1172665664 
import java.util.Collections;
//#endif 


//#if -576336121 
import java.util.HashMap;
//#endif 


//#if -576153407 
import java.util.HashSet;
//#endif 


//#if 1319799379 
import java.util.Iterator;
//#endif 


//#if -1138345181 
import java.util.List;
//#endif 


//#if -1976361511 
import java.util.Map;
//#endif 


//#if -1976178797 
import java.util.Set;
//#endif 


//#if -1536841575 
import org.argouml.application.api.Argo;
//#endif 


//#if -1104138987 
import org.argouml.application.helpers.ApplicationVersion;
//#endif 


//#if -1344843820 
import org.argouml.configuration.Configuration;
//#endif 


//#if 619594152 
import org.argouml.i18n.Translator;
//#endif 


//#if 472605677 
import org.argouml.model.InvalidElementException;
//#endif 


//#if -1335746450 
import org.argouml.model.Model;
//#endif 


//#if -1588927826 
import org.argouml.profile.Profile;
//#endif 


//#if 664861428 
import org.argouml.profile.ProfileFacade;
//#endif 


//#if 364807732 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -408986064 
import org.argouml.uml.CommentEdge;
//#endif 


//#if 975941332 
import org.argouml.uml.ProjectMemberModel;
//#endif 


//#if 1398345005 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -1094589576 
import org.argouml.uml.diagram.DiagramFactory;
//#endif 


//#if 555685903 
import org.argouml.uml.diagram.ProjectMemberDiagram;
//#endif 


//#if 712510565 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1111684347 
import org.apache.log4j.Logger;
//#endif 


//#if -549079895 
import org.argouml.uml.cognitive.ProjectMemberTodoList;
//#endif 


//#if 1184624191 
public class ProjectImpl implements 
//#if -1092554808 
java.io.Serializable
//#endif 

, 
//#if 762510124 
Project
//#endif 

  { 

//#if -1247667021 
private static final String UNTITLED_FILE =
        Translator.localize("label.projectbrowser-title");
//#endif 


//#if -1941516911 
static final long serialVersionUID = 1399111233978692444L;
//#endif 


//#if -367610587 
private URI uri;
//#endif 


//#if 821621918 
private String authorname;
//#endif 


//#if -546456495 
private String authoremail;
//#endif 


//#if 1028588198 
private String description;
//#endif 


//#if -1292889910 
private String version;
//#endif 


//#if -1752066267 
private ProjectSettings projectSettings;
//#endif 


//#if -1426687247 
private final List<String> searchpath = new ArrayList<String>();
//#endif 


//#if 121919599 
private final List<ProjectMember> members = new MemberList();
//#endif 


//#if 964405490 
private String historyFile;
//#endif 


//#if -1981238519 
private int persistenceVersion;
//#endif 


//#if 152807278 
private final List models = new ArrayList();
//#endif 


//#if 1245381668 
private Object root;
//#endif 


//#if 600691740 
private final Collection roots = new HashSet();
//#endif 


//#if 960913772 
private final List<ArgoDiagram> diagrams = new ArrayList<ArgoDiagram>();
//#endif 


//#if -1583473500 
private Object currentNamespace;
//#endif 


//#if 61729606 
private Map<String, Object> uuidRefs;
//#endif 


//#if -1953713987 
private transient VetoableChangeSupport vetoSupport;
//#endif 


//#if 970614603 
private ProfileConfiguration profileConfiguration;
//#endif 


//#if 667137554 
private ArgoDiagram activeDiagram;
//#endif 


//#if -1549114467 
private String savedDiagramName;
//#endif 


//#if 1847532035 
private HashMap<String, Object> defaultModelTypeCache;
//#endif 


//#if 841388316 
private final Collection trashcan = new ArrayList();
//#endif 


//#if -2050032018 
private UndoManager undoManager = DefaultUndoManager.getInstance();
//#endif 


//#if -1363840875 
private boolean dirty = false;
//#endif 


//#if 38018224 
private static final Logger LOG = Logger.getLogger(ProjectImpl.class);
//#endif 


//#if 1793696698 
public int getDiagramCount()
    { 

//#if -270742076 
return diagrams.size();
//#endif 

} 

//#endif 


//#if -1988419588 
private void addModelInternal(final Object model)
    { 

//#if 1911133917 
models.add(model);
//#endif 


//#if 1108080778 
roots.add(model);
//#endif 


//#if 2106580010 
setCurrentNamespace(model);
//#endif 


//#if -624111879 
setSaveEnabled(true);
//#endif 


//#if -1993305419 
if(models.size() > 1 || roots.size() > 1)//1
{ 

//#if -1733206924 
LOG.debug("Multiple roots/models");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -728434607 
protected void removeDiagram(ArgoDiagram d)
    { 

//#if 1945757009 
diagrams.remove(d);
//#endif 


//#if -2051991539 
Object o = d.getDependentElement();
//#endif 


//#if -1315662690 
if(o != null)//1
{ 

//#if 1570850865 
moveToTrash(o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1204086374 
public ArgoDiagram getDiagram(String name)
    { 

//#if -150576883 
for (ArgoDiagram ad : diagrams) //1
{ 

//#if -29016985 
if(ad.getName() != null && ad.getName().equals(name))//1
{ 

//#if 2094355088 
return ad;
//#endif 

} 

//#endif 


//#if 1691105920 
if(ad.getItemUID() != null
                    && ad.getItemUID().toString().equals(name))//1
{ 

//#if -267159456 
return ad;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 167874139 
return null;
//#endif 

} 

//#endif 


//#if -1640671204 

//#if -497619287 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public void setVetoSupport(VetoableChangeSupport theVetoSupport)
    { 

//#if -1989526742 
vetoSupport = theVetoSupport;
//#endif 

} 

//#endif 


//#if 1103640166 
private void addTodoMember(ProjectMemberTodoList pm)
    { 

//#if 1734055697 
members.add(pm);
//#endif 


//#if 751161844 
LOG.info("Added todo member, there are now " + members.size());
//#endif 

} 

//#endif 


//#if -1702419506 
public String getDescription()
    { 

//#if 908198168 
return description;
//#endif 

} 

//#endif 


//#if 878629187 

//#if -847747807 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public ArgoDiagram getActiveDiagram()
    { 

//#if -96506183 
return activeDiagram;
//#endif 

} 

//#endif 


//#if 171789993 

//#if -908535525 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public void setActiveDiagram(final ArgoDiagram theDiagram)
    { 

//#if -2126131119 
activeDiagram = theDiagram;
//#endif 

} 

//#endif 


//#if 1628507287 
public void preSave()
    { 

//#if 1334042207 
for (ArgoDiagram diagram : diagrams) //1
{ 

//#if -1099044271 
diagram.preSave();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 181705921 
public Collection<Fig> findFigsForMember(Object member)
    { 

//#if -228140627 
Collection<Fig> figs = new ArrayList<Fig>();
//#endif 


//#if 2108778574 
for (ArgoDiagram diagram : diagrams) //1
{ 

//#if -1548135414 
Fig fig = diagram.getContainingFig(member);
//#endif 


//#if 182828498 
if(fig != null)//1
{ 

//#if -541391212 
figs.add(fig);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2023925568 
return figs;
//#endif 

} 

//#endif 


//#if 602883842 
public String getHistoryFile()
    { 

//#if 1414458732 
return historyFile;
//#endif 

} 

//#endif 


//#if -529948755 
public void setHistoryFile(final String s)
    { 

//#if 593323399 
historyFile = s;
//#endif 

} 

//#endif 


//#if 1535085388 
public ProjectImpl(URI theProjectUri)
    { 

//#if 283982071 
this();
//#endif 


//#if 1997745293 
uri = theProjectUri;
//#endif 

} 

//#endif 


//#if -361716659 
public ProjectSettings getProjectSettings()
    { 

//#if -1760613127 
return projectSettings;
//#endif 

} 

//#endif 


//#if 1799236072 
public void postSave()
    { 

//#if -37874598 
for (ArgoDiagram diagram : diagrams) //1
{ 

//#if 2046453295 
diagram.postSave();
//#endif 

} 

//#endif 


//#if 675596086 
setSaveEnabled(true);
//#endif 

} 

//#endif 


//#if -8789897 
public boolean isDirty()
    { 

//#if 760048551 
return ProjectManager.getManager().isSaveActionEnabled();
//#endif 

} 

//#endif 


//#if 872191615 
public void addModel(final Object model)
    { 

//#if 285163343 
if(!Model.getFacade().isAModel(model))//1
{ 

//#if -1387044450 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if -269024998 
if(!models.contains(model))//1
{ 

//#if -1961488135 
setRoot(model);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -172713619 
public URI getUri()
    { 

//#if 1237188430 
return uri;
//#endif 

} 

//#endif 


//#if 1387916838 
public String getAuthorname()
    { 

//#if -1602512642 
return authorname;
//#endif 

} 

//#endif 


//#if -802107383 

//#if -497892712 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public boolean isInTrash(Object obj)
    { 

//#if 187256954 
return trashcan.contains(obj);
//#endif 

} 

//#endif 


//#if -1900132235 
public Collection findAllPresentationsFor(Object obj)
    { 

//#if -1950979898 
Collection<Fig> figs = new ArrayList<Fig>();
//#endif 


//#if -74904171 
for (ArgoDiagram diagram : diagrams) //1
{ 

//#if -1885281864 
Fig aFig = diagram.presentationFor(obj);
//#endif 


//#if 171020466 
if(aFig != null)//1
{ 

//#if -1153936010 
figs.add(aFig);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -422383225 
return figs;
//#endif 

} 

//#endif 


//#if 1434835371 
public Object getDefaultReturnType()
    { 

//#if -936410920 
if(profileConfiguration.getDefaultTypeStrategy() != null)//1
{ 

//#if -1009350606 
return profileConfiguration.getDefaultTypeStrategy()
                   .getDefaultReturnType();
//#endif 

} 

//#endif 


//#if -1467097594 
return null;
//#endif 

} 

//#endif 


//#if -414432849 
public void setFile(final File file)
    { 

//#if -1992933093 
URI theProjectUri = file.toURI();
//#endif 


//#if 1851215345 
if(LOG.isDebugEnabled())//1
{ 

//#if 1369588686 
LOG.debug("Setting project file name from \""
                      + uri
                      + "\" to \""
                      + theProjectUri
                      + "\".");
//#endif 

} 

//#endif 


//#if 1270304269 
uri = theProjectUri;
//#endif 

} 

//#endif 


//#if 621221751 
public List<ProjectMember> getMembers()
    { 

//#if 1000686726 
LOG.info("Getting the members there are " + members.size());
//#endif 


//#if -1606974520 
return members;
//#endif 

} 

//#endif 


//#if -2047673483 
public void addDiagram(final ArgoDiagram d)
    { 

//#if 715399215 
d.setProject(this);
//#endif 


//#if -1317631063 
diagrams.add(d);
//#endif 


//#if 1942197368 
d.addPropertyChangeListener("name", new NamePCL());
//#endif 


//#if -2107556642 
setSaveEnabled(true);
//#endif 

} 

//#endif 


//#if 1923959085 
public void setRoots(final Collection elements)
    { 

//#if 549771488 
boolean modelFound = false;
//#endif 


//#if 743981415 
for (Object element : elements) //1
{ 

//#if -1495917407 
if(!Model.getFacade().isAPackage(element))//1
{ 

//#if 75344998 
LOG.warn("Top level element other than package found - "
                         + Model.getFacade().getName(element));
//#endif 

} 

//#endif 


//#if -519458189 
if(Model.getFacade().isAModel(element))//1
{ 

//#if -251110552 
addModel(element);
//#endif 


//#if 1069434769 
if(!modelFound)//1
{ 

//#if 259676566 
setRoot(element);
//#endif 


//#if 1305184189 
modelFound = true;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 816525430 
roots.clear();
//#endif 


//#if 804131048 
roots.addAll(elements);
//#endif 

} 

//#endif 


//#if 989609646 
public void setAuthoremail(final String s)
    { 

//#if -2122469602 
final String oldAuthorEmail = authoremail;
//#endif 


//#if -1502768585 
AbstractCommand command = new AbstractCommand() {
            public Object execute() {
                authoremail = s;
                return null;
            }

            public void undo() {
                authoremail = oldAuthorEmail;
            }
        };
//#endif 


//#if -1066191907 
undoManager.execute(command);
//#endif 

} 

//#endif 


//#if 1250357251 
public boolean isValidDiagramName(String name)
    { 

//#if -1863236163 
boolean rv = true;
//#endif 


//#if 272025739 
for (ArgoDiagram diagram : diagrams) //1
{ 

//#if 2129001427 
if(diagram.getName().equals(name))//1
{ 

//#if -1670681228 
rv = false;
//#endif 


//#if -1122369607 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1794170888 
return rv;
//#endif 

} 

//#endif 


//#if -321143915 
public void setSavedDiagramName(String diagramName)
    { 

//#if 1192030647 
savedDiagramName = diagramName;
//#endif 

} 

//#endif 


//#if -290339123 
public Collection getModels()
    { 

//#if -330642240 
Set result = new HashSet();
//#endif 


//#if -461897701 
result.addAll(models);
//#endif 


//#if -1905957460 
for (Profile profile : getProfileConfiguration().getProfiles()) //1
{ 

//#if -985745390 
try //1
{ 

//#if 1584982339 
result.addAll(profile.getProfilePackages());
//#endif 

} 

//#if -592477699 
catch (org.argouml.profile.ProfileException e) //1
{ 

//#if 234037021 
LOG.error("Exception when fetching models from profile "
                          + profile.getDisplayName(), e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -200423125 
return Collections.unmodifiableCollection(result);
//#endif 

} 

//#endif 


//#if 1076339413 
private void addModelMember(final Object m)
    { 

//#if 1047933705 
boolean memberFound = false;
//#endif 


//#if 231454534 
Object currentMember =
            members.get(0);
//#endif 


//#if 1849385950 
if(currentMember instanceof ProjectMemberModel)//1
{ 

//#if -210126579 
Object currentModel =
                ((ProjectMemberModel) currentMember).getModel();
//#endif 


//#if 1537532947 
if(currentModel == m)//1
{ 

//#if -871283860 
memberFound = true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1275379950 
if(!memberFound)//1
{ 

//#if 1333119078 
if(!models.contains(m))//1
{ 

//#if -1349724218 
addModel(m);
//#endif 

} 

//#endif 


//#if -995347691 
ProjectMember pm = new ProjectMemberModel(m, this);
//#endif 


//#if -1516520761 
LOG.info("Adding model member to start of member list");
//#endif 


//#if 724770706 
members.add(pm);
//#endif 

} 
else
{ 

//#if 364207040 
LOG.info("Attempted to load 2 models");
//#endif 


//#if 2051803874 
throw new IllegalArgumentException(
                "Attempted to load 2 models");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2117370415 
public void setVersion(String s)
    { 

//#if -147262362 
version = s;
//#endif 

} 

//#endif 


//#if -1563614163 
private void addDiagramMember(ArgoDiagram d)
    { 

//#if 419091038 
int serial = getDiagramCount();
//#endif 


//#if 198693767 
while (!isValidDiagramName(d.getName())) //1
{ 

//#if -145177406 
try //1
{ 

//#if 1194360650 
d.setName(d.getName() + " " + serial);
//#endif 

} 

//#if -1210640872 
catch (PropertyVetoException e) //1
{ 

//#if -845147469 
serial++;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -663910903 
ProjectMember pm = new ProjectMemberDiagram(d, this);
//#endif 


//#if 438145948 
addDiagram(d);
//#endif 


//#if 917182087 
members.add(pm);
//#endif 

} 

//#endif 


//#if -173697683 
public URI getURI()
    { 

//#if 1856016368 
return uri;
//#endif 

} 

//#endif 


//#if -2080326070 

//#if -1606552310 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public void setCurrentNamespace(final Object m)
    { 

//#if -1077816499 
if(m != null && !Model.getFacade().isANamespace(m))//1
{ 

//#if -151948568 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if -1745147386 
currentNamespace = m;
//#endif 

} 

//#endif 


//#if -486955942 
public Object findTypeInDefaultModel(String name)
    { 

//#if 542184972 
if(defaultModelTypeCache.containsKey(name))//1
{ 

//#if 2008493333 
return defaultModelTypeCache.get(name);
//#endif 

} 

//#endif 


//#if -398578773 
Object result = profileConfiguration.findType(name);
//#endif 


//#if -1545828862 
defaultModelTypeCache.put(name, result);
//#endif 


//#if -1803734873 
return result;
//#endif 

} 

//#endif 


//#if 1162403026 
public void addMember(Object m)
    { 

//#if -972610453 
if(m == null)//1
{ 

//#if -466216727 
throw new IllegalArgumentException(
                "A model member must be suppleid");
//#endif 

} 
else

//#if 1521313776 
if(m instanceof ArgoDiagram)//1
{ 

//#if 1958993899 
LOG.info("Adding diagram member");
//#endif 


//#if -5998669 
addDiagramMember((ArgoDiagram) m);
//#endif 

} 
else

//#if 2074528369 
if(Model.getFacade().isAModel(m))//1
{ 

//#if -1490581179 
LOG.info("Adding model member");
//#endif 


//#if 947995290 
addModelMember(m);
//#endif 

} 
else
{ 

//#if 1767879180 
throw new IllegalArgumentException(
                "The member must be a UML model todo member or diagram."
                + "It is " + m.getClass().getName());
//#endif 

} 

//#endif 


//#if -2037832499 
if(m instanceof ProjectMemberTodoList)//1
{ 

//#if 1923901127 
LOG.info("Adding todo member");
//#endif 


//#if -283257626 
addTodoMember((ProjectMemberTodoList) m);
//#endif 

} 
else

//#if -2103540839 
if(Model.getFacade().isAModel(m))//1
{ 

//#if -1186845369 
LOG.info("Adding model member");
//#endif 


//#if -1367320164 
addModelMember(m);
//#endif 

} 
else
{ 

//#if 1814958046 
throw new IllegalArgumentException(
                "The member must be a UML model todo member or diagram."
                + "It is " + m.getClass().getName());
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#if -1886705556 
LOG.info("There are now " + members.size() + " members");
//#endif 

} 

//#endif 


//#if 449321717 
public Object getInitialTarget()
    { 

//#if -235769991 
if(savedDiagramName != null)//1
{ 

//#if -900259068 
return getDiagram(savedDiagramName);
//#endif 

} 

//#endif 


//#if 96615123 
if(diagrams.size() > 0)//1
{ 

//#if -878264979 
return diagrams.get(0);
//#endif 

} 

//#endif 


//#if -756585239 
if(models.size() > 0)//1
{ 

//#if -454244864 
return models.iterator().next();
//#endif 

} 

//#endif 


//#if 126873584 
return null;
//#endif 

} 

//#endif 


//#if -1958210025 
public Object findTypeInModel(String typeName, Object namespace)
    { 

//#if -984161384 
if(typeName == null)//1
{ 

//#if -746545054 
throw new IllegalArgumentException("typeName must be non-null");
//#endif 

} 

//#endif 


//#if -1505225957 
if(!Model.getFacade().isANamespace(namespace))//1
{ 

//#if 1950748777 
throw new IllegalArgumentException(
                "Looking for the classifier " + typeName
                + " in a non-namespace object of " + namespace
                + ". A namespace was expected.");
//#endif 

} 

//#endif 


//#if 958029046 
Collection allClassifiers =
            Model.getModelManagementHelper()
            .getAllModelElementsOfKind(namespace,
                                       Model.getMetaTypes().getClassifier());
//#endif 


//#if -1809254195 
for (Object classifier : allClassifiers) //1
{ 

//#if 1754878670 
if(typeName.equals(Model.getFacade().getName(classifier)))//1
{ 

//#if -370919718 
return classifier;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1638569853 
return null;
//#endif 

} 

//#endif 


//#if 1611134737 
public void postLoad()
    { 

//#if -1230072590 
long startTime = System.currentTimeMillis();
//#endif 


//#if 1054754937 
for (ArgoDiagram diagram : diagrams) //1
{ 

//#if 1859726257 
diagram.postLoad();
//#endif 

} 

//#endif 


//#if -1611143637 
long endTime = System.currentTimeMillis();
//#endif 


//#if 880963201 
LOG.debug("Diagram post load took " + (endTime - startTime) + " msec.");
//#endif 


//#if -1072822077 
Object model = getModel();
//#endif 


//#if -1162987491 
LOG.info("Setting root model to " + model);
//#endif 


//#if -615544762 
setRoot(model);
//#endif 


//#if 1282084245 
setSaveEnabled(true);
//#endif 


//#if 964566275 
uuidRefs = null;
//#endif 

} 

//#endif 


//#if -293371868 
public Object getDefaultParameterType()
    { 

//#if 1917857828 
if(profileConfiguration.getDefaultTypeStrategy() != null)//1
{ 

//#if -460130090 
return profileConfiguration.getDefaultTypeStrategy()
                   .getDefaultParameterType();
//#endif 

} 

//#endif 


//#if -1258565574 
return null;
//#endif 

} 

//#endif 


//#if 1141275709 
public void addSearchPath(final String searchPathElement)
    { 

//#if 1493967844 
if(!searchpath.contains(searchPathElement))//1
{ 

//#if 162461312 
searchpath.add(searchPathElement);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -379938527 
public ProfileConfiguration getProfileConfiguration()
    { 

//#if -155656757 
return profileConfiguration;
//#endif 

} 

//#endif 


//#if 1677707637 
public void setUUIDRefs(Map<String, Object> uUIDRefs)
    { 

//#if -1774637420 
uuidRefs = uUIDRefs;
//#endif 

} 

//#endif 


//#if -2002091955 
public void setSearchPath(final List<String> theSearchpath)
    { 

//#if 148001542 
searchpath.clear();
//#endif 


//#if 1884889153 
searchpath.addAll(theSearchpath);
//#endif 

} 

//#endif 


//#if -443217258 
public void setUri(URI theUri)
    { 

//#if -1032018416 
if(LOG.isDebugEnabled())//1
{ 

//#if 228908514 
LOG.debug("Setting project URI from \"" + uri
                      + "\" to \"" + theUri + "\".");
//#endif 

} 

//#endif 


//#if 219590409 
uri = theUri;
//#endif 

} 

//#endif 


//#if 886710297 
protected void trashInternal(Object obj)
    { 

//#if -1472355773 
if(Model.getFacade().isAModel(obj))//1
{ 

//#if 609910263 
return;
//#endif 

} 

//#endif 


//#if -276544937 
if(obj != null)//1
{ 

//#if 1201577947 
trashcan.add(obj);
//#endif 

} 

//#endif 


//#if -1416391184 
if(Model.getFacade().isAUMLElement(obj))//1
{ 

//#if -1882292442 
Model.getUmlFactory().delete(obj);
//#endif 


//#if -2010460618 
if(models.contains(obj))//1
{ 

//#if -393545227 
models.remove(obj);
//#endif 

} 

//#endif 

} 
else

//#if 1651456435 
if(obj instanceof ArgoDiagram)//1
{ 

//#if 1972454385 
removeProjectMemberDiagram((ArgoDiagram) obj);
//#endif 


//#if -1997420610 
ProjectManager.getManager()
            .firePropertyChanged("remove", obj, null);
//#endif 

} 
else

//#if 1171144498 
if(obj instanceof Fig)//1
{ 

//#if 1746980783 
((Fig) obj).deleteFromModel();
//#endif 


//#if -1405187199 
LOG.info("Request to delete a Fig " + obj.getClass().getName());
//#endif 

} 
else

//#if -457029296 
if(obj instanceof CommentEdge)//1
{ 

//#if 670641264 
CommentEdge ce = (CommentEdge) obj;
//#endif 


//#if -1131848867 
LOG.info("Removing the link from " + ce.getAnnotatedElement()
                     + " to " + ce.getComment());
//#endif 


//#if 1826180429 
ce.delete();
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if -1736484988 

//#if 736724724 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public void setRoot(final Object theRoot)
    { 

//#if -1837345220 
if(theRoot == null)//1
{ 

//#if 705701633 
throw new IllegalArgumentException(
                "A root model element is required");
//#endif 

} 

//#endif 


//#if -1870780713 
if(!Model.getFacade().isAModel(theRoot))//1
{ 

//#if -1427609219 
throw new IllegalArgumentException(
                "The root model element must be a model - got "
                + theRoot.getClass().getName());
//#endif 

} 

//#endif 


//#if -1561386222 
Object treeRoot = Model.getModelManagementFactory().getRootModel();
//#endif 


//#if -1090519343 
if(treeRoot != null)//1
{ 

//#if -379958480 
models.remove(treeRoot);
//#endif 

} 

//#endif 


//#if 1016181950 
root = theRoot;
//#endif 


//#if -1334667579 
Model.getModelManagementFactory().setRootModel(theRoot);
//#endif 


//#if 681194311 
addModelInternal(theRoot);
//#endif 


//#if -587649969 
roots.clear();
//#endif 


//#if -1824989060 
roots.add(theRoot);
//#endif 

} 

//#endif 


//#if 2095914075 
public void setDirty(boolean isDirty)
    { 

//#if 1162006825 
dirty = isDirty;
//#endif 


//#if -1248299301 
ProjectManager.getManager().setSaveEnabled(isDirty);
//#endif 

} 

//#endif 


//#if 412017739 

//#if -917669295 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public Object getCurrentNamespace()
    { 

//#if 1439123926 
return currentNamespace;
//#endif 

} 

//#endif 


//#if -608636060 
public ProjectImpl()
    { 

//#if 1499659229 
setProfileConfiguration(new ProfileConfiguration(this));
//#endif 


//#if 1251983889 
projectSettings = new ProjectSettings();
//#endif 


//#if -1263717454 
Model.getModelManagementFactory().setRootModel(null);
//#endif 


//#if -988528417 
authorname = Configuration.getString(Argo.KEY_USER_FULLNAME);
//#endif 


//#if -1647315266 
authoremail = Configuration.getString(Argo.KEY_USER_EMAIL);
//#endif 


//#if -2144102610 
description = "";
//#endif 


//#if -126522397 
version = ApplicationVersion.getVersion();
//#endif 


//#if 1344257378 
historyFile = "";
//#endif 


//#if -2078795311 
defaultModelTypeCache = new HashMap<String, Object>();
//#endif 


//#if 1291794813 
LOG.info("making empty project with empty model");
//#endif 


//#if -514373175 
addSearchPath("PROJECT_DIR");
//#endif 

} 

//#endif 


//#if 679879010 
public Object findType(String s, boolean defineNew)
    { 

//#if -1546512892 
if(s != null)//1
{ 

//#if -58035677 
s = s.trim();
//#endif 

} 

//#endif 


//#if 1003671286 
if(s == null || s.length() == 0)//1
{ 

//#if -2056159454 
return null;
//#endif 

} 

//#endif 


//#if 1067996081 
Object cls = null;
//#endif 


//#if 1660301330 
for (Object model : models) //1
{ 

//#if 349664428 
cls = findTypeInModel(s, model);
//#endif 


//#if -1962581002 
if(cls != null)//1
{ 

//#if 280710334 
return cls;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -398455807 
cls = findTypeInDefaultModel(s);
//#endif 


//#if 1065297270 
if(cls == null && defineNew)//1
{ 

//#if -1261146439 
LOG.debug("new Type defined!");
//#endif 


//#if -185821503 
cls =
                Model.getCoreFactory().buildClass(getCurrentNamespace());
//#endif 


//#if -1254050003 
Model.getCoreHelper().setName(cls, s);
//#endif 

} 

//#endif 


//#if 210016018 
return cls;
//#endif 

} 

//#endif 


//#if -694307049 
public void moveToTrash(Object obj)
    { 

//#if -2008422334 
if(obj instanceof Collection)//1
{ 

//#if -983228649 
Iterator i = ((Collection) obj).iterator();
//#endif 


//#if 1312007448 
while (i.hasNext()) //1
{ 

//#if 1448796594 
Object trash = i.next();
//#endif 


//#if 812155214 
if(!trashcan.contains(trash))//1
{ 

//#if 1822436312 
trashInternal(trash);
//#endif 

} 

//#endif 

} 

//#endif 

} 
else
{ 

//#if 51858828 
if(!trashcan.contains(obj))//1
{ 

//#if 240044688 
trashInternal(obj);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 9465304 
public Map<String, Object> getUUIDRefs()
    { 

//#if -48868533 
return uuidRefs;
//#endif 

} 

//#endif 


//#if 1010802563 
public String getAuthoremail()
    { 

//#if 1205138315 
return authoremail;
//#endif 

} 

//#endif 


//#if -696210823 
public void setDescription(final String s)
    { 

//#if -1007217986 
final String oldDescription = description;
//#endif 


//#if 1262624748 
AbstractCommand command = new AbstractCommand() {
            public Object execute() {
                description = s;
                return null;
            }

            public void undo() {
                description = oldDescription;
            }
        };
//#endif 


//#if 1042311303 
undoManager.execute(command);
//#endif 

} 

//#endif 


//#if 2131136848 
protected void removeProjectMemberDiagram(ArgoDiagram d)
    { 

//#if 1093419480 
if(activeDiagram == d)//1
{ 

//#if -1794206946 
LOG.debug("Deleting active diagram " + d);
//#endif 


//#if -497976650 
ArgoDiagram defaultDiagram = null;
//#endif 


//#if -1320408921 
if(diagrams.size() == 1)//1
{ 

//#if 1670499842 
LOG.debug("Deleting last diagram - creating new default diag");
//#endif 


//#if 811082097 
Object projectRoot = getRoot();
//#endif 


//#if 568623154 
if(!Model.getUmlFactory().isRemoved(projectRoot))//1
{ 

//#if -960363324 
defaultDiagram = DiagramFactory.getInstance()
                                     .createDefaultDiagram(projectRoot);
//#endif 


//#if -359872300 
addMember(defaultDiagram);
//#endif 

} 

//#endif 

} 
else
{ 

//#if 281182369 
defaultDiagram = diagrams.get(0);
//#endif 


//#if -1327207659 
LOG.debug("Candidate default diagram is " + defaultDiagram);
//#endif 


//#if -2039007077 
if(defaultDiagram == d)//1
{ 

//#if 893637089 
defaultDiagram = diagrams.get(1);
//#endif 


//#if 1871589810 
LOG.debug("Switching default diagram to " + defaultDiagram);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1599795764 
activeDiagram = defaultDiagram;
//#endif 


//#if -649744759 
TargetManager.getInstance().setTarget(activeDiagram);
//#endif 


//#if 1054183194 
LOG.debug("New active diagram is " + defaultDiagram);
//#endif 

} 

//#endif 


//#if 635064331 
removeDiagram(d);
//#endif 


//#if 1684851513 
members.remove(d);
//#endif 


//#if 228333114 
d.remove();
//#endif 


//#if 1597216596 
setSaveEnabled(true);
//#endif 

} 

//#endif 


//#if -1321484149 
public void setPersistenceVersion(int pv)
    { 

//#if 340310718 
persistenceVersion = pv;
//#endif 

} 

//#endif 


//#if -1322753798 
public final Collection getRoots()
    { 

//#if -1027257946 
return Collections.unmodifiableCollection(roots);
//#endif 

} 

//#endif 


//#if -1264063257 
public Object findType(String s)
    { 

//#if -565627051 
return findType(s, true);
//#endif 

} 

//#endif 


//#if -740227005 
public void setAuthorname(final String s)
    { 

//#if -1530342830 
final String oldAuthorName = authorname;
//#endif 


//#if -1884504738 
AbstractCommand command = new AbstractCommand() {
            public Object execute() {
                authorname = s;
                return null;
            }

            public void undo() {
                authorname = oldAuthorName;
            }
        };
//#endif 


//#if 604882161 
undoManager.execute(command);
//#endif 

} 

//#endif 


//#if -2045566202 
public void setProfileConfiguration(ProfileConfiguration pc)
    { 

//#if 164555685 
if(this.profileConfiguration != pc)//1
{ 

//#if -1005971319 
if(this.profileConfiguration != null)//1
{ 

//#if -1696607057 
this.members.remove(this.profileConfiguration);
//#endif 

} 

//#endif 


//#if 376641020 
this.profileConfiguration = pc;
//#endif 


//#if -195172051 
members.add(pc);
//#endif 

} 

//#endif 


//#if -2061058082 
ProfileFacade.applyConfiguration(pc);
//#endif 

} 

//#endif 


//#if -532135302 
private void setSaveEnabled(boolean enable)
    { 

//#if -2109697475 
ProjectManager pm = ProjectManager.getManager();
//#endif 


//#if -1898141921 
if(pm.getCurrentProject() == this)//1
{ 

//#if -1294778956 
pm.setSaveEnabled(enable);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1740229417 
public Object getDefaultAttributeType()
    { 

//#if -1610461250 
if(profileConfiguration.getDefaultTypeStrategy() != null)//1
{ 

//#if 264177753 
return profileConfiguration.getDefaultTypeStrategy()
                   .getDefaultAttributeType();
//#endif 

} 

//#endif 


//#if -1396848672 
return null;
//#endif 

} 

//#endif 


//#if 72470973 
public List<String> getSearchPathList()
    { 

//#if 1135475197 
return Collections.unmodifiableList(searchpath);
//#endif 

} 

//#endif 


//#if 976501506 

//#if -771244782 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public Object getModel()
    { 

//#if 1279849476 
if(models.size() != 1)//1
{ 

//#if 1851875294 
return null;
//#endif 

} 

//#endif 


//#if -135967426 
return models.iterator().next();
//#endif 

} 

//#endif 


//#if 1811645994 
public String getVersion()
    { 

//#if 436800343 
return version;
//#endif 

} 

//#endif 


//#if -1045898249 
public int getPersistenceVersion()
    { 

//#if -965652033 
return persistenceVersion;
//#endif 

} 

//#endif 


//#if 2065483739 
public int getPresentationCountFor(Object me)
    { 

//#if 1218261319 
if(!Model.getFacade().isAUMLElement(me))//1
{ 

//#if 482773651 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if 608704813 
int presentations = 0;
//#endif 


//#if 1667690504 
for (ArgoDiagram d : diagrams) //1
{ 

//#if 125613814 
presentations += d.getLayer().presentationCountFor(me);
//#endif 

} 

//#endif 


//#if -1698080157 
return presentations;
//#endif 

} 

//#endif 


//#if 259247144 
public List<ArgoDiagram> getDiagramList()
    { 

//#if -506902364 
return Collections.unmodifiableList(diagrams);
//#endif 

} 

//#endif 


//#if -1336282084 
private void emptyTrashCan()
    { 

//#if -1259673698 
trashcan.clear();
//#endif 

} 

//#endif 


//#if -1093623569 
public void remove()
    { 

//#if 1609368573 
for (ArgoDiagram diagram : diagrams) //1
{ 

//#if -1591861435 
diagram.remove();
//#endif 

} 

//#endif 


//#if 2080752911 
members.clear();
//#endif 


//#if 1532417420 
if(!roots.isEmpty())//1
{ 

//#if -1738650475 
try //1
{ 

//#if 1377568745 
Model.getUmlFactory().deleteExtent(roots.iterator().next());
//#endif 

} 

//#if 130152425 
catch (InvalidElementException e) //1
{ 

//#if -604742061 
LOG.warn("Extent deleted a second time");
//#endif 

} 

//#endif 


//#endif 


//#if -1838883255 
roots.clear();
//#endif 

} 

//#endif 


//#if -44889756 
models.clear();
//#endif 


//#if -74210866 
diagrams.clear();
//#endif 


//#if 839412705 
searchpath.clear();
//#endif 


//#if -2134706492 
if(uuidRefs != null)//1
{ 

//#if 2056980764 
uuidRefs.clear();
//#endif 

} 

//#endif 


//#if 1433400397 
if(defaultModelTypeCache != null)//1
{ 

//#if 939460097 
defaultModelTypeCache.clear();
//#endif 

} 

//#endif 


//#if 1734129407 
uuidRefs = null;
//#endif 


//#if 1190638922 
defaultModelTypeCache = null;
//#endif 


//#if -1278417770 
uri = null;
//#endif 


//#if -1255937670 
authorname = null;
//#endif 


//#if 895003995 
authoremail = null;
//#endif 


//#if 1616843814 
description = null;
//#endif 


//#if -1727829630 
version = null;
//#endif 


//#if -438665894 
historyFile = null;
//#endif 


//#if 260361222 
currentNamespace = null;
//#endif 


//#if -1803205521 
vetoSupport = null;
//#endif 


//#if 144862615 
activeDiagram = null;
//#endif 


//#if -1760852645 
savedDiagramName = null;
//#endif 


//#if -704517822 
emptyTrashCan();
//#endif 

} 

//#endif 


//#if -1827250265 
public UndoManager getUndoManager()
    { 

//#if -1087182515 
return undoManager;
//#endif 

} 

//#endif 


//#if 2090449107 

//#if -1139023447 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public final Object getRoot()
    { 

//#if -390438828 
return root;
//#endif 

} 

//#endif 


//#if -1708544452 

//#if 513506892 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public VetoableChangeSupport getVetoSupport()
    { 

//#if -658659259 
if(vetoSupport == null)//1
{ 

//#if -270256036 
vetoSupport = new VetoableChangeSupport(this);
//#endif 

} 

//#endif 


//#if -579368414 
return vetoSupport;
//#endif 

} 

//#endif 


//#if -2053973547 
public String repair()
    { 

//#if 625057566 
StringBuilder report = new StringBuilder();
//#endif 


//#if -831867514 
Iterator it = members.iterator();
//#endif 


//#if 1764546525 
while (it.hasNext()) //1
{ 

//#if 1033594601 
ProjectMember member = (ProjectMember) it.next();
//#endif 


//#if -426710665 
report.append(member.repair());
//#endif 

} 

//#endif 


//#if 1723825527 
return report.toString();
//#endif 

} 

//#endif 


//#if -2137892837 
public String getName()
    { 

//#if 1219733450 
if(uri == null)//1
{ 

//#if -754450426 
return UNTITLED_FILE;
//#endif 

} 

//#endif 


//#if -474677964 
return new File(uri).getName();
//#endif 

} 

//#endif 


//#if 1048970220 
public List getUserDefinedModelList()
    { 

//#if -1815589764 
return models;
//#endif 

} 

//#endif 


//#if 1944116844 
private class NamePCL implements 
//#if 483313123 
PropertyChangeListener
//#endif 

  { 

//#if -288961857 
public void propertyChange(PropertyChangeEvent evt)
        { 

//#if 1418296134 
setSaveEnabled(true);
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

