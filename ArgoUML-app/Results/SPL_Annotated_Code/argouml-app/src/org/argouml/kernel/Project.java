// Compilation Unit of /Project.java 
 
package org.argouml.kernel;
import java.beans.VetoableChangeSupport;
import java.io.File;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.argouml.uml.diagram.ArgoDiagram;
import org.tigris.gef.presentation.Fig;
public interface Project  { 
public String getVersion();
public void setDirty(boolean isDirty);
@Deprecated
    public void setActiveDiagram(final ArgoDiagram theDiagram);
@Deprecated
    public boolean isInTrash(Object obj);
public ArgoDiagram getDiagram(String name);
public List<ArgoDiagram> getDiagramList();
public void setSearchPath(final List<String> theSearchpath);
public void addDiagram(final ArgoDiagram d);
public List<String> getSearchPathList();
public void addSearchPath(String searchPathElement);
public ProfileConfiguration getProfileConfiguration();
public void setPersistenceVersion(int pv);
public Map<String, Object> getUUIDRefs();
public URI getURI();
@Deprecated
    public void setRoot(final Object root);
@Deprecated
    public ArgoDiagram getActiveDiagram();
public void setSavedDiagramName(String diagramName);
@Deprecated
    public Object getRoot();
@Deprecated
    public Object getCurrentNamespace();
public Object getDefaultReturnType();
@Deprecated
    public void setCurrentNamespace(final Object m);
public Object getInitialTarget();
public void addMember(final Object m);
public ProjectSettings getProjectSettings();
public void moveToTrash(Object obj);
public void setHistoryFile(final String s);
public String getHistoryFile();
public Object findTypeInDefaultModel(String name);
public Object getDefaultParameterType();
public void setUUIDRefs(final Map<String, Object> uUIDRefs);
public void addModel(final Object model);
public Collection getModels();
public void setRoots(final Collection elements);
public void setFile(final File file);
public void remove();
public Object getDefaultAttributeType();
public void setAuthorname(final String s);
public void setVersion(final String s);
public List<ProjectMember> getMembers();
public void setProfileConfiguration(final ProfileConfiguration pc);
public UndoManager getUndoManager();
@Deprecated
    public VetoableChangeSupport getVetoSupport();
public void postLoad();
@Deprecated
    public Object getModel();
public String getAuthorname();
public URI getUri();
public List getUserDefinedModelList();
public void setUri(final URI theUri);
@Deprecated
    public void setVetoSupport(VetoableChangeSupport theVetoSupport);
public Object findType(String s);
public String getAuthoremail();
public void postSave();
public void setDescription(final String s);
public Object findTypeInModel(String s, Object ns);
public int getPersistenceVersion();
public String repair();
public String getDescription();
public Collection<Fig> findFigsForMember(Object member);
public Object findType(String s, boolean defineNew);
public String getName();
public boolean isValidDiagramName(String name);
public void preSave();
public int getPresentationCountFor(Object me);
public int getDiagramCount();
public Collection getRoots();
public void setAuthoremail(final String s);
public Collection findAllPresentationsFor(Object obj);
public boolean isDirty();
 } 


