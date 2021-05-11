
//#if -2045581718 
// Compilation Unit of /ArgoDiagram.java 
 

//#if 367329545 
package org.argouml.uml.diagram;
//#endif 


//#if -635493316 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -1014821684 
import java.beans.PropertyChangeListener;
//#endif 


//#if 963254177 
import java.beans.PropertyVetoException;
//#endif 


//#if 1589719293 
import java.beans.VetoableChangeListener;
//#endif 


//#if -1756180907 
import java.util.Enumeration;
//#endif 


//#if -1214673492 
import java.util.Iterator;
//#endif 


//#if 1497813756 
import java.util.List;
//#endif 


//#if 205237586 
import org.argouml.application.events.ArgoDiagramAppearanceEventListener;
//#endif 


//#if -2117964255 
import org.argouml.application.events.ArgoNotationEventListener;
//#endif 


//#if -1664765387 
import org.argouml.kernel.Project;
//#endif 


//#if 1744684012 
import org.argouml.util.ItemUID;
//#endif 


//#if -1874139758 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if 1430781665 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 492896684 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1649409206 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if -875199098 
public interface ArgoDiagram extends 
//#if 1718569292 
ArgoNotationEventListener
//#endif 

, 
//#if -862054313 
ArgoDiagramAppearanceEventListener
//#endif 

  { 

//#if 1808067805 
public static final String NAMESPACE_KEY = "namespace";
//#endif 


//#if 1867318941 
public static final String NAME_KEY = "name";
//#endif 


//#if 1490742869 
public Object getNamespace();
//#endif 


//#if 773655009 
public String getName();
//#endif 


//#if -121184299 
public Iterator<Fig> getFigIterator();
//#endif 


//#if -1010568273 
public List getEdges();
//#endif 


//#if -2003739468 
public void setItemUID(ItemUID i);
//#endif 


//#if -1370266009 
public GraphModel getGraphModel();
//#endif 


//#if -278152427 
public ItemUID getItemUID();
//#endif 


//#if 2076722653 
public void removePropertyChangeListener(String property,
            PropertyChangeListener listener);
//#endif 


//#if 105941408 
public void setDiagramSettings(DiagramSettings settings);
//#endif 


//#if 1427960971 
public void postLoad();
//#endif 


//#if -797762469 
public List presentationsFor(Object obj);
//#endif 


//#if -248671448 
public void addPropertyChangeListener(String property,
                                          PropertyChangeListener listener);
//#endif 


//#if -1750728776 
public String getVetoMessage(String propertyName);
//#endif 


//#if -448523575 
public void setModelElementNamespace(Object modelElement, Object ns);
//#endif 


//#if -1778690102 
public void addVetoableChangeListener(VetoableChangeListener listener);
//#endif 


//#if 777525949 
public int countContained(List figures);
//#endif 


//#if -1425442851 
public void preSave();
//#endif 


//#if -802994056 
public void setName(String n) throws PropertyVetoException;
//#endif 


//#if -1974478291 
public Object getOwner();
//#endif 


//#if 1411122999 
public LayerPerspective getLayer();
//#endif 


//#if -1122850491 
public void setProject(Project p);
//#endif 


//#if 1341310684 
public void propertyChange(PropertyChangeEvent evt);
//#endif 


//#if -1300819638 
public List getNodes();
//#endif 


//#if 1578808553 
public void remove();
//#endif 


//#if 2057819983 
public String repair();
//#endif 


//#if 157470640 
public void encloserChanged(FigNode enclosed, FigNode oldEncloser,
                                FigNode newEncloser);
//#endif 


//#if 1648565594 
public void setNamespace(Object ns);
//#endif 


//#if 1369059765 
public void removeVetoableChangeListener(VetoableChangeListener listener);
//#endif 


//#if -993916955 
public Object getDependentElement();
//#endif 


//#if 520038151 
public DiagramSettings getDiagramSettings();
//#endif 


//#if -856846276 
public void add(Fig f);
//#endif 


//#if 1616062306 
public void postSave();
//#endif 


//#if -614123244 
public void damage();
//#endif 


//#if -1731517019 
public Fig getContainingFig(Object obj);
//#endif 


//#if -1800192506 
public Fig presentationFor(Object o);
//#endif 


//#if 429293517 
public Project getProject();
//#endif 

 } 

//#endif 


//#endif 

