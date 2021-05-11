// Compilation Unit of /ArgoDiagram.java 
 
package org.argouml.uml.diagram;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import org.argouml.application.events.ArgoDiagramAppearanceEventListener;
import org.argouml.application.events.ArgoNotationEventListener;
import org.argouml.kernel.Project;
import org.argouml.util.ItemUID;
import org.tigris.gef.base.LayerPerspective;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigNode;
public interface ArgoDiagram extends ArgoNotationEventListener
, ArgoDiagramAppearanceEventListener
  { 
public static final String NAMESPACE_KEY = "namespace";
public static final String NAME_KEY = "name";
public Object getNamespace();
public String getName();
public Iterator<Fig> getFigIterator();
public List getEdges();
public void setItemUID(ItemUID i);
public GraphModel getGraphModel();
public ItemUID getItemUID();
public void removePropertyChangeListener(String property,
            PropertyChangeListener listener);
public void setDiagramSettings(DiagramSettings settings);
public void postLoad();
public List presentationsFor(Object obj);
public void addPropertyChangeListener(String property,
                                          PropertyChangeListener listener);
public String getVetoMessage(String propertyName);
public void setModelElementNamespace(Object modelElement, Object ns);
public void addVetoableChangeListener(VetoableChangeListener listener);
public int countContained(List figures);
public void preSave();
public void setName(String n) throws PropertyVetoException;
public Object getOwner();
public LayerPerspective getLayer();
public void setProject(Project p);
public void propertyChange(PropertyChangeEvent evt);
public List getNodes();
public void remove();
public String repair();
public void encloserChanged(FigNode enclosed, FigNode oldEncloser,
                                FigNode newEncloser);
public void setNamespace(Object ns);
public void removeVetoableChangeListener(VetoableChangeListener listener);
public Object getDependentElement();
public DiagramSettings getDiagramSettings();
public void add(Fig f);
public void postSave();
public void damage();
public Fig getContainingFig(Object obj);
public Fig presentationFor(Object o);
public Project getProject();
 } 


