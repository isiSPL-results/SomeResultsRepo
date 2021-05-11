
//#if 450990550 
// Compilation Unit of /Project.java 
 

//#if -419148470 
package org.argouml.kernel;
//#endif 


//#if 1963378179 
import java.beans.VetoableChangeSupport;
//#endif 


//#if 1521460399 
import java.io.File;
//#endif 


//#if -953237640 
import java.net.URI;
//#endif 


//#if -436109655 
import java.util.Collection;
//#endif 


//#if 717530537 
import java.util.List;
//#endif 


//#if 1685736083 
import java.util.Map;
//#endif 


//#if -1665101209 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 1469529759 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1271867432 
public interface Project  { 

//#if -719721889 
public String getVersion();
//#endif 


//#if -1044938160 
public void setDirty(boolean isDirty);
//#endif 


//#if 194210324 
@Deprecated
    public void setActiveDiagram(final ArgoDiagram theDiagram);
//#endif 


//#if -639629378 
@Deprecated
    public boolean isInTrash(Object obj);
//#endif 


//#if 1824846225 
public ArgoDiagram getDiagram(String name);
//#endif 


//#if 880006995 
public List<ArgoDiagram> getDiagramList();
//#endif 


//#if -2034444936 
public void setSearchPath(final List<String> theSearchpath);
//#endif 


//#if -1426913632 
public void addDiagram(final ArgoDiagram d);
//#endif 


//#if 1101048744 
public List<String> getSearchPathList();
//#endif 


//#if -318702012 
public void addSearchPath(String searchPathElement);
//#endif 


//#if 1067727820 
public ProfileConfiguration getProfileConfiguration();
//#endif 


//#if 499655680 
public void setPersistenceVersion(int pv);
//#endif 


//#if 1038043075 
public Map<String, Object> getUUIDRefs();
//#endif 


//#if 1371951832 
public URI getURI();
//#endif 


//#if -74251452 
@Deprecated
    public void setRoot(final Object root);
//#endif 


//#if -1893797960 
@Deprecated
    public ArgoDiagram getActiveDiagram();
//#endif 


//#if -1743908662 
public void setSavedDiagramName(String diagramName);
//#endif 


//#if -762359680 
@Deprecated
    public Object getRoot();
//#endif 


//#if 574495744 
@Deprecated
    public Object getCurrentNamespace();
//#endif 


//#if -1706016864 
public Object getDefaultReturnType();
//#endif 


//#if -418801729 
@Deprecated
    public void setCurrentNamespace(final Object m);
//#endif 


//#if -1741307030 
public Object getInitialTarget();
//#endif 


//#if 1542448741 
public void addMember(final Object m);
//#endif 


//#if -811953992 
public ProjectSettings getProjectSettings();
//#endif 


//#if -1354557876 
public void moveToTrash(Object obj);
//#endif 


//#if 1291191074 
public void setHistoryFile(final String s);
//#endif 


//#if 1378257079 
public String getHistoryFile();
//#endif 


//#if 1035584207 
public Object findTypeInDefaultModel(String name);
//#endif 


//#if 735205903 
public Object getDefaultParameterType();
//#endif 


//#if -1504875202 
public void setUUIDRefs(final Map<String, Object> uUIDRefs);
//#endif 


//#if 1875202868 
public void addModel(final Object model);
//#endif 


//#if -1235158408 
public Collection getModels();
//#endif 


//#if -1257388328 
public void setRoots(final Collection elements);
//#endif 


//#if -1074683676 
public void setFile(final File file);
//#endif 


//#if -423128860 
public void remove();
//#endif 


//#if -711651646 
public Object getDefaultAttributeType();
//#endif 


//#if 288350766 
public void setAuthorname(final String s);
//#endif 


//#if -2015966134 
public void setVersion(final String s);
//#endif 


//#if 1649799522 
public List<ProjectMember> getMembers();
//#endif 


//#if -1992681365 
public void setProfileConfiguration(final ProfileConfiguration pc);
//#endif 


//#if -820189422 
public UndoManager getUndoManager();
//#endif 


//#if -47020111 
@Deprecated
    public VetoableChangeSupport getVetoSupport();
//#endif 


//#if 1711455686 
public void postLoad();
//#endif 


//#if 1983562349 
@Deprecated
    public Object getModel();
//#endif 


//#if 443097553 
public String getAuthorname();
//#endif 


//#if 1372935896 
public URI getUri();
//#endif 


//#if -1828168553 
public List getUserDefinedModelList();
//#endif 


//#if -937881063 
public void setUri(final URI theUri);
//#endif 


//#if -1158111663 
@Deprecated
    public void setVetoSupport(VetoableChangeSupport theVetoSupport);
//#endif 


//#if 1297670610 
public Object findType(String s);
//#endif 


//#if 1786175800 
public String getAuthoremail();
//#endif 


//#if 1899557021 
public void postSave();
//#endif 


//#if 1124929006 
public void setDescription(final String s);
//#endif 


//#if -2006204710 
public Object findTypeInModel(String s, Object ns);
//#endif 


//#if -1706149076 
public int getPersistenceVersion();
//#endif 


//#if -1953652598 
public String repair();
//#endif 


//#if -927046269 
public String getDescription();
//#endif 


//#if 2109689718 
public Collection<Fig> findFigsForMember(Object member);
//#endif 


//#if -2092548137 
public Object findType(String s, boolean defineNew);
//#endif 


//#if 972056582 
public String getName();
//#endif 


//#if -1930990162 
public boolean isValidDiagramName(String name);
//#endif 


//#if 939006786 
public void preSave();
//#endif 


//#if 993028304 
public int getPresentationCountFor(Object me);
//#endif 


//#if 100650671 
public int getDiagramCount();
//#endif 


//#if -2103440027 
public Collection getRoots();
//#endif 


//#if -1484217821 
public void setAuthoremail(final String s);
//#endif 


//#if 917513322 
public Collection findAllPresentationsFor(Object obj);
//#endif 


//#if 1910361580 
public boolean isDirty();
//#endif 

 } 

//#endif 


//#endif 

