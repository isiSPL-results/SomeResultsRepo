package org.argouml.kernel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeSupport;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.argouml.application.api.Argo;
import org.argouml.application.helpers.ApplicationVersion;
import org.argouml.configuration.Configuration;
import org.argouml.i18n.Translator;
import org.argouml.model.InvalidElementException;
import org.argouml.model.Model;
import org.argouml.profile.Profile;
import org.argouml.profile.ProfileFacade;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.CommentEdge;
import org.argouml.uml.ProjectMemberModel;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramFactory;
import org.argouml.uml.diagram.ProjectMemberDiagram;
import org.tigris.gef.presentation.Fig;
import org.argouml.uml.cognitive.ProjectMemberTodoList;
public class ProjectImpl implements java.io.Serializable
,Project
  { 
private static final String UNTITLED_FILE =
        Translator.localize("label.projectbrowser-title");
static final long serialVersionUID = 1399111233978692444L;
private URI uri;
private String authorname;
private String authoremail;
private String description;
private String version;
private ProjectSettings projectSettings;
private final List<String> searchpath = new ArrayList<String>();
private final List<ProjectMember> members = new MemberList();
private String historyFile;
private int persistenceVersion;
private final List models = new ArrayList();
private Object root;
private final Collection roots = new HashSet();
private final List<ArgoDiagram> diagrams = new ArrayList<ArgoDiagram>();
private Object currentNamespace;
private Map<String, Object> uuidRefs;
private transient VetoableChangeSupport vetoSupport;
private ProfileConfiguration profileConfiguration;
private ArgoDiagram activeDiagram;
private String savedDiagramName;
private HashMap<String, Object> defaultModelTypeCache;
private final Collection trashcan = new ArrayList();
private UndoManager undoManager = DefaultUndoManager.getInstance();
private boolean dirty = false;
public int getDiagramCount()
    { 
return diagrams.size();
} 
private void addModelInternal(final Object model)
    { 
models.add(model);
roots.add(model);
setCurrentNamespace(model);
setSaveEnabled(true);
if(models.size() > 1 || roots.size() > 1)//1
{ 
} 
} 
protected void removeDiagram(ArgoDiagram d)
    { 
diagrams.remove(d);
Object o = d.getDependentElement();
if(o != null)//1
{ 
moveToTrash(o);
} 
} 
public ArgoDiagram getDiagram(String name)
    { 
for (ArgoDiagram ad : diagrams) //1
{ 
if(ad.getName() != null && ad.getName().equals(name))//1
{ 
return ad;
} 
if(ad.getItemUID() != null
                    && ad.getItemUID().toString().equals(name))//1
{ 
return ad;
} 
} 
return null;
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public void setVetoSupport(VetoableChangeSupport theVetoSupport)
    { 
vetoSupport = theVetoSupport;
} 
private void addTodoMember(ProjectMemberTodoList pm)
    { 
members.add(pm);
} 
public String getDescription()
    { 
return description;
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public ArgoDiagram getActiveDiagram()
    { 
return activeDiagram;
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public void setActiveDiagram(final ArgoDiagram theDiagram)
    { 
activeDiagram = theDiagram;
} 
public void preSave()
    { 
for (ArgoDiagram diagram : diagrams) //1
{ 
diagram.preSave();
} 
} 
public Collection<Fig> findFigsForMember(Object member)
    { 
Collection<Fig> figs = new ArrayList<Fig>();
for (ArgoDiagram diagram : diagrams) //1
{ 
Fig fig = diagram.getContainingFig(member);
if(fig != null)//1
{ 
figs.add(fig);
} 
} 
return figs;
} 
public String getHistoryFile()
    { 
return historyFile;
} 
public void setHistoryFile(final String s)
    { 
historyFile = s;
} 
public ProjectImpl(URI theProjectUri)
    { 
this();
uri = theProjectUri;
} 
public ProjectSettings getProjectSettings()
    { 
return projectSettings;
} 
public void postSave()
    { 
for (ArgoDiagram diagram : diagrams) //1
{ 
diagram.postSave();
} 
setSaveEnabled(true);
} 
public boolean isDirty()
    { 
return ProjectManager.getManager().isSaveActionEnabled();
} 
public void addModel(final Object model)
    { 
if(!Model.getFacade().isAModel(model))//1
{ 
throw new IllegalArgumentException();
} 
if(!models.contains(model))//1
{ 
setRoot(model);
} 
} 
public URI getUri()
    { 
return uri;
} 
public String getAuthorname()
    { 
return authorname;
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public boolean isInTrash(Object obj)
    { 
return trashcan.contains(obj);
} 
public Collection findAllPresentationsFor(Object obj)
    { 
Collection<Fig> figs = new ArrayList<Fig>();
for (ArgoDiagram diagram : diagrams) //1
{ 
Fig aFig = diagram.presentationFor(obj);
if(aFig != null)//1
{ 
figs.add(aFig);
} 
} 
return figs;
} 
public Object getDefaultReturnType()
    { 
if(profileConfiguration.getDefaultTypeStrategy() != null)//1
{ 
return profileConfiguration.getDefaultTypeStrategy()
                   .getDefaultReturnType();
} 
return null;
} 
public void setFile(final File file)
    { 
URI theProjectUri = file.toURI();
uri = theProjectUri;
} 
public List<ProjectMember> getMembers()
    { 
return members;
} 
public void addDiagram(final ArgoDiagram d)
    { 
d.setProject(this);
diagrams.add(d);
d.addPropertyChangeListener("name", new NamePCL());
setSaveEnabled(true);
} 
public void setRoots(final Collection elements)
    { 
boolean modelFound = false;
for (Object element : elements) //1
{ 
if(Model.getFacade().isAModel(element))//1
{ 
addModel(element);
if(!modelFound)//1
{ 
setRoot(element);
modelFound = true;
} 
} 
} 
roots.clear();
roots.addAll(elements);
} 
public void setAuthoremail(final String s)
    { 
final String oldAuthorEmail = authoremail;
AbstractCommand command = new AbstractCommand() {
            public Object execute() {
                authoremail = s;
                return null;
            }

            public void undo() {
                authoremail = oldAuthorEmail;
            }
        };
undoManager.execute(command);
} 
public boolean isValidDiagramName(String name)
    { 
boolean rv = true;
for (ArgoDiagram diagram : diagrams) //1
{ 
if(diagram.getName().equals(name))//1
{ 
rv = false;
break;

} 
} 
return rv;
} 
public void setSavedDiagramName(String diagramName)
    { 
savedDiagramName = diagramName;
} 
public Collection getModels()
    { 
Set result = new HashSet();
result.addAll(models);
for (Profile profile : getProfileConfiguration().getProfiles()) //1
{ 
try//1
{ 
result.addAll(profile.getProfilePackages());
} 
catch (org.argouml.profile.ProfileException e) //1
{ 
} 
} 
return Collections.unmodifiableCollection(result);
} 
private void addModelMember(final Object m)
    { 
boolean memberFound = false;
Object currentMember =
            members.get(0);
if(currentMember instanceof ProjectMemberModel)//1
{ 
Object currentModel =
                ((ProjectMemberModel) currentMember).getModel();
if(currentModel == m)//1
{ 
memberFound = true;
} 
} 
if(!memberFound)//1
{ 
if(!models.contains(m))//1
{ 
addModel(m);
} 
ProjectMember pm = new ProjectMemberModel(m, this);
members.add(pm);
} 
else
{ 
throw new IllegalArgumentException(
                "Attempted to load 2 models");
} 
} 
public void setVersion(String s)
    { 
version = s;
} 
private void addDiagramMember(ArgoDiagram d)
    { 
int serial = getDiagramCount();
while (!isValidDiagramName(d.getName())) //1
{ 
try//1
{ 
d.setName(d.getName() + " " + serial);
} 
catch (PropertyVetoException e) //1
{ 
serial++;
} 
} 
ProjectMember pm = new ProjectMemberDiagram(d, this);
addDiagram(d);
members.add(pm);
} 
public URI getURI()
    { 
return uri;
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public void setCurrentNamespace(final Object m)
    { 
if(m != null && !Model.getFacade().isANamespace(m))//1
{ 
throw new IllegalArgumentException();
} 
currentNamespace = m;
} 
public Object findTypeInDefaultModel(String name)
    { 
if(defaultModelTypeCache.containsKey(name))//1
{ 
return defaultModelTypeCache.get(name);
} 
Object result = profileConfiguration.findType(name);
defaultModelTypeCache.put(name, result);
return result;
} 
public void addMember(Object m)
    { 
if(m == null)//1
{ 
throw new IllegalArgumentException(
                "A model member must be suppleid");
} 
else
if(m instanceof ArgoDiagram)//1
{ 
addDiagramMember((ArgoDiagram) m);
} 
else
if(m instanceof ProjectMemberTodoList)//1
{ 
addTodoMember((ProjectMemberTodoList) m);
} 
else
if(Model.getFacade().isAModel(m))//1
{ 
addModelMember(m);
} 
else
{ 
throw new IllegalArgumentException(
                "The member must be a UML model todo member or diagram."
                + "It is " + m.getClass().getName());
} 
} 
public Object getInitialTarget()
    { 
if(savedDiagramName != null)//1
{ 
return getDiagram(savedDiagramName);
} 
if(diagrams.size() > 0)//1
{ 
return diagrams.get(0);
} 
if(models.size() > 0)//1
{ 
return models.iterator().next();
} 
return null;
} 
public Object findTypeInModel(String typeName, Object namespace)
    { 
if(typeName == null)//1
{ 
throw new IllegalArgumentException("typeName must be non-null");
} 
if(!Model.getFacade().isANamespace(namespace))//1
{ 
throw new IllegalArgumentException(
                "Looking for the classifier " + typeName
                + " in a non-namespace object of " + namespace
                + ". A namespace was expected.");
} 
Collection allClassifiers =
            Model.getModelManagementHelper()
            .getAllModelElementsOfKind(namespace,
                                       Model.getMetaTypes().getClassifier());
for (Object classifier : allClassifiers) //1
{ 
if(typeName.equals(Model.getFacade().getName(classifier)))//1
{ 
return classifier;
} 
} 
return null;
} 
public void postLoad()
    { 
long startTime = System.currentTimeMillis();
for (ArgoDiagram diagram : diagrams) //1
{ 
diagram.postLoad();
} 
long endTime = System.currentTimeMillis();
Object model = getModel();
setRoot(model);
setSaveEnabled(true);
uuidRefs = null;
} 
public Object getDefaultParameterType()
    { 
if(profileConfiguration.getDefaultTypeStrategy() != null)//1
{ 
return profileConfiguration.getDefaultTypeStrategy()
                   .getDefaultParameterType();
} 
return null;
} 
public void addSearchPath(final String searchPathElement)
    { 
if(!searchpath.contains(searchPathElement))//1
{ 
searchpath.add(searchPathElement);
} 
} 
public ProfileConfiguration getProfileConfiguration()
    { 
return profileConfiguration;
} 
public void setUUIDRefs(Map<String, Object> uUIDRefs)
    { 
uuidRefs = uUIDRefs;
} 
public void setSearchPath(final List<String> theSearchpath)
    { 
searchpath.clear();
searchpath.addAll(theSearchpath);
} 
public void setUri(URI theUri)
    { 
uri = theUri;
} 
protected void trashInternal(Object obj)
    { 
if(Model.getFacade().isAModel(obj))//1
{ 
return;
} 
if(obj != null)//1
{ 
trashcan.add(obj);
} 
if(Model.getFacade().isAUMLElement(obj))//1
{ 
Model.getUmlFactory().delete(obj);
if(models.contains(obj))//1
{ 
models.remove(obj);
} 
} 
else
if(obj instanceof ArgoDiagram)//1
{ 
removeProjectMemberDiagram((ArgoDiagram) obj);
ProjectManager.getManager()
            .firePropertyChanged("remove", obj, null);
} 
else
if(obj instanceof Fig)//1
{ 
((Fig) obj).deleteFromModel();
} 
else
if(obj instanceof CommentEdge)//1
{ 
CommentEdge ce = (CommentEdge) obj;
ce.delete();
} 
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public void setRoot(final Object theRoot)
    { 
if(theRoot == null)//1
{ 
throw new IllegalArgumentException(
                "A root model element is required");
} 
if(!Model.getFacade().isAModel(theRoot))//1
{ 
throw new IllegalArgumentException(
                "The root model element must be a model - got "
                + theRoot.getClass().getName());
} 
Object treeRoot = Model.getModelManagementFactory().getRootModel();
if(treeRoot != null)//1
{ 
models.remove(treeRoot);
} 
root = theRoot;
Model.getModelManagementFactory().setRootModel(theRoot);
addModelInternal(theRoot);
roots.clear();
roots.add(theRoot);
} 
public void setDirty(boolean isDirty)
    { 
dirty = isDirty;
ProjectManager.getManager().setSaveEnabled(isDirty);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public Object getCurrentNamespace()
    { 
return currentNamespace;
} 
public ProjectImpl()
    { 
setProfileConfiguration(new ProfileConfiguration(this));
projectSettings = new ProjectSettings();
Model.getModelManagementFactory().setRootModel(null);
authorname = Configuration.getString(Argo.KEY_USER_FULLNAME);
authoremail = Configuration.getString(Argo.KEY_USER_EMAIL);
description = "";
version = ApplicationVersion.getVersion();
historyFile = "";
defaultModelTypeCache = new HashMap<String, Object>();
addSearchPath("PROJECT_DIR");
} 
public Object findType(String s, boolean defineNew)
    { 
if(s != null)//1
{ 
s = s.trim();
} 
if(s == null || s.length() == 0)//1
{ 
return null;
} 
Object cls = null;
for (Object model : models) //1
{ 
cls = findTypeInModel(s, model);
if(cls != null)//1
{ 
return cls;
} 
} 
cls = findTypeInDefaultModel(s);
if(cls == null && defineNew)//1
{ 
cls =
                Model.getCoreFactory().buildClass(getCurrentNamespace());
Model.getCoreHelper().setName(cls, s);
} 
return cls;
} 
public void moveToTrash(Object obj)
    { 
if(obj instanceof Collection)//1
{ 
Iterator i = ((Collection) obj).iterator();
while (i.hasNext()) //1
{ 
Object trash = i.next();
if(!trashcan.contains(trash))//1
{ 
trashInternal(trash);
} 
} 
} 
else
{ 
if(!trashcan.contains(obj))//1
{ 
trashInternal(obj);
} 
} 
} 
public Map<String, Object> getUUIDRefs()
    { 
return uuidRefs;
} 
public String getAuthoremail()
    { 
return authoremail;
} 
public void setDescription(final String s)
    { 
final String oldDescription = description;
AbstractCommand command = new AbstractCommand() {
            public Object execute() {
                description = s;
                return null;
            }

            public void undo() {
                description = oldDescription;
            }
        };
undoManager.execute(command);
} 
protected void removeProjectMemberDiagram(ArgoDiagram d)
    { 
if(activeDiagram == d)//1
{ 
ArgoDiagram defaultDiagram = null;
if(diagrams.size() == 1)//1
{ 
Object projectRoot = getRoot();
if(!Model.getUmlFactory().isRemoved(projectRoot))//1
{ 
defaultDiagram = DiagramFactory.getInstance()
                                     .createDefaultDiagram(projectRoot);
addMember(defaultDiagram);
} 
} 
else
{ 
defaultDiagram = diagrams.get(0);
if(defaultDiagram == d)//1
{ 
defaultDiagram = diagrams.get(1);
} 
} 
activeDiagram = defaultDiagram;
TargetManager.getInstance().setTarget(activeDiagram);
} 
removeDiagram(d);
members.remove(d);
d.remove();
setSaveEnabled(true);
} 
public void setPersistenceVersion(int pv)
    { 
persistenceVersion = pv;
} 
public final Collection getRoots()
    { 
return Collections.unmodifiableCollection(roots);
} 
public Object findType(String s)
    { 
return findType(s, true);
} 
public void setAuthorname(final String s)
    { 
final String oldAuthorName = authorname;
AbstractCommand command = new AbstractCommand() {
            public Object execute() {
                authorname = s;
                return null;
            }

            public void undo() {
                authorname = oldAuthorName;
            }
        };
undoManager.execute(command);
} 
public void setProfileConfiguration(ProfileConfiguration pc)
    { 
if(this.profileConfiguration != pc)//1
{ 
if(this.profileConfiguration != null)//1
{ 
this.members.remove(this.profileConfiguration);
} 
this.profileConfiguration = pc;
members.add(pc);
} 
ProfileFacade.applyConfiguration(pc);
} 
private void setSaveEnabled(boolean enable)
    { 
ProjectManager pm = ProjectManager.getManager();
if(pm.getCurrentProject() == this)//1
{ 
pm.setSaveEnabled(enable);
} 
} 
public Object getDefaultAttributeType()
    { 
if(profileConfiguration.getDefaultTypeStrategy() != null)//1
{ 
return profileConfiguration.getDefaultTypeStrategy()
                   .getDefaultAttributeType();
} 
return null;
} 
public List<String> getSearchPathList()
    { 
return Collections.unmodifiableList(searchpath);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public Object getModel()
    { 
if(models.size() != 1)//1
{ 
return null;
} 
return models.iterator().next();
} 
public String getVersion()
    { 
return version;
} 
public int getPersistenceVersion()
    { 
return persistenceVersion;
} 
public int getPresentationCountFor(Object me)
    { 
if(!Model.getFacade().isAUMLElement(me))//1
{ 
throw new IllegalArgumentException();
} 
int presentations = 0;
for (ArgoDiagram d : diagrams) //1
{ 
presentations += d.getLayer().presentationCountFor(me);
} 
return presentations;
} 
public List<ArgoDiagram> getDiagramList()
    { 
return Collections.unmodifiableList(diagrams);
} 
private void emptyTrashCan()
    { 
trashcan.clear();
} 
public void remove()
    { 
for (ArgoDiagram diagram : diagrams) //1
{ 
diagram.remove();
} 
members.clear();
if(!roots.isEmpty())//1
{ 
try//1
{ 
Model.getUmlFactory().deleteExtent(roots.iterator().next());
} 
catch (InvalidElementException e) //1
{ 
} 
roots.clear();
} 
models.clear();
diagrams.clear();
searchpath.clear();
if(uuidRefs != null)//1
{ 
uuidRefs.clear();
} 
if(defaultModelTypeCache != null)//1
{ 
defaultModelTypeCache.clear();
} 
uuidRefs = null;
defaultModelTypeCache = null;
uri = null;
authorname = null;
authoremail = null;
description = null;
version = null;
historyFile = null;
currentNamespace = null;
vetoSupport = null;
activeDiagram = null;
savedDiagramName = null;
emptyTrashCan();
} 
public UndoManager getUndoManager()
    { 
return undoManager;
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public final Object getRoot()
    { 
return root;
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public VetoableChangeSupport getVetoSupport()
    { 
if(vetoSupport == null)//1
{ 
vetoSupport = new VetoableChangeSupport(this);
} 
return vetoSupport;
} 
public String repair()
    { 
StringBuilder report = new StringBuilder();
Iterator it = members.iterator();
while (it.hasNext()) //1
{ 
ProjectMember member = (ProjectMember) it.next();
report.append(member.repair());
} 
return report.toString();
} 
public String getName()
    { 
if(uri == null)//1
{ 
return UNTITLED_FILE;
} 
return new File(uri).getName();
} 
public List getUserDefinedModelList()
    { 
return models;
} 
private class NamePCL implements PropertyChangeListener
  { 
public void propertyChange(PropertyChangeEvent evt)
        { 
setSaveEnabled(true);
} 

 } 

 } 
