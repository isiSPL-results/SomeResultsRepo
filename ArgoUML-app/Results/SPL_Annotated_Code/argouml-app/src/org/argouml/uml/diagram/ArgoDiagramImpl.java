// Compilation Unit of /ArgoDiagramImpl.java 
 
package org.argouml.uml.diagram;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.argouml.application.events.ArgoDiagramAppearanceEvent;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoNotationEvent;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.CoreHelper;
import org.argouml.model.DeleteInstanceEvent;
import org.argouml.model.InvalidElementException;
import org.argouml.model.Model;
import org.argouml.model.ModelManagementHelper;
import org.argouml.uml.diagram.activity.ui.FigPool;
import org.argouml.uml.diagram.static_structure.ui.FigComment;
import org.argouml.uml.diagram.ui.ArgoFig;
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
import org.argouml.uml.diagram.ui.FigNodeModelElement;
import org.argouml.util.EnumerationIterator;
import org.argouml.util.IItemUID;
import org.argouml.util.ItemUID;
import org.tigris.gef.base.Diagram;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.LayerPerspective;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.graph.MutableGraphSupport;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigEdge;
import org.tigris.gef.presentation.FigGroup;
import org.tigris.gef.presentation.FigNode;
import org.tigris.gef.undo.UndoManager;
public abstract class ArgoDiagramImpl extends Diagram
 implements PropertyChangeListener
, VetoableChangeListener
, ArgoDiagram
, IItemUID
  { 
private ItemUID id;
private Project project;
protected Object namespace;
private DiagramSettings settings;
private static final Logger LOG = Logger.getLogger(ArgoDiagramImpl.class);
static final long serialVersionUID = -401219134410459387L;
public void vetoableChange(PropertyChangeEvent evt)
    throws PropertyVetoException
    { 
if("name".equals(evt.getPropertyName()))//1
{ 
if(project != null)//1
{ 
if(!project.isValidDiagramName((String) evt.getNewValue()))//1
{ 
throw new PropertyVetoException("Invalid name", evt);
} 

} 

} 

} 

public Project getProject()
    { 
return project;
} 

public String repair()
    { 
StringBuffer report = new StringBuffer(500);
boolean faultFixed;
do{ 
faultFixed = false;
List<Fig> figs = new ArrayList<Fig>(getLayer().getContentsNoEdges());
for (Fig f : figs) //1
{ 
if(repairFig(f, report))//1
{ 
faultFixed = true;
} 

} 

figs = new ArrayList<Fig>(getLayer().getContentsEdgesOnly());
for (Fig f : figs) //2
{ 
if(repairFig(f, report))//1
{ 
faultFixed = true;
} 

} 

} 
 while (faultFixed);//1

return report.toString();
} 

public void notationRemoved(ArgoNotationEvent e)
    { 
} 

public void diagramFontChanged(ArgoDiagramAppearanceEvent e)
    { 
renderingChanged();
} 

public void setProject(Project p)
    { 
project = p;
} 

public Object getNamespace()
    { 
return namespace;
} 

public abstract void encloserChanged(
        FigNode enclosed, FigNode oldEncloser, FigNode newEncloser);
public void renderingChanged()
    { 
for (Object fig : getLayer().getContents()) //1
{ 
try //1
{ 
if(fig instanceof ArgoFig)//1
{ 
((ArgoFig) fig).renderingChanged();
} 
else
{ 
LOG.warn("Diagram " + getName() + " contains non-ArgoFig "
                             + fig);
} 

} 
catch (InvalidElementException e) //1
{ 
LOG.error("Tried to refresh deleted element ", e);
} 


} 

damage();
} 

public void notationAdded(ArgoNotationEvent e)
    { 
} 

public ItemUID getItemUID()
    { 
return id;
} 

@Deprecated
    public ArgoDiagramImpl()
    { 
super();
getLayer().getGraphModel().removeGraphEventListener(getLayer());
constructorInit();
} 

public void notationProviderAdded(ArgoNotationEvent e)
    { 
} 

public Iterator<Fig> getFigIterator()
    { 
return new EnumerationIterator(elements());
} 

public Object getDependentElement()
    { 
return null;
} 

private String figDescription(Fig f)
    { 
String description = "\n" + f.getClass().getName();
if(f instanceof FigComment)//1
{ 
description += " \"" + ((FigComment) f).getBody() + "\"";
} 
else
if(f instanceof FigNodeModelElement)//1
{ 
description += " \"" + ((FigNodeModelElement) f).getName() + "\"";
} 
else
if(f instanceof FigEdgeModelElement)//1
{ 
FigEdgeModelElement fe = (FigEdgeModelElement) f;
description += " \"" + fe.getName() + "\"";
String source;
if(fe.getSourceFigNode() == null)//1
{ 
source = "(null)";
} 
else
{ 
source =
                    ((FigNodeModelElement) fe.getSourceFigNode()).getName();
} 

String dest;
if(fe.getDestFigNode() == null)//1
{ 
dest = "(null)";
} 
else
{ 
dest = ((FigNodeModelElement) fe.getDestFigNode()).getName();
} 

description += " [" + source + "=>" + dest + "]";
} 



return description + "\n";
} 

public void notationProviderRemoved(ArgoNotationEvent e)
    { 
} 

public void notationChanged(ArgoNotationEvent e)
    { 
renderingChanged();
} 

public ArgoDiagramImpl(String name, GraphModel graphModel,
                           LayerPerspective layer)
    { 
super(name, graphModel, layer);
try //1
{ 
setName(name);
} 
catch (PropertyVetoException pve) //1
{ 
} 


constructorInit();
} 

public void setDiagramSettings(DiagramSettings newSettings)
    { 
settings = newSettings;
} 

public void setNamespace(Object ns)
    { 
if(!Model.getFacade().isANamespace(ns))//1
{ 
LOG.error("Not a namespace");
LOG.error(ns);
throw new IllegalArgumentException("Given object not a namespace");
} 

if((namespace != null) && (namespace != ns))//1
{ 
Model.getPump().removeModelEventListener(this, namespace);
} 

Object oldNs = namespace;
namespace = ns;
firePropertyChange(NAMESPACE_KEY, oldNs, ns);
Model.getPump().addModelEventListener(this, namespace, "remove");
} 

public List presentationsFor(Object obj)
    { 
List<Fig> presentations = new ArrayList<Fig>();
int figCount = getLayer().getContents().size();
for (int figIndex = 0; figIndex < figCount; ++figIndex) //1
{ 
Fig fig = (Fig) getLayer().getContents().get(figIndex);
if(fig.getOwner() == obj)//1
{ 
presentations.add(fig);
} 

} 

return presentations;
} 

public void setItemUID(ItemUID i)
    { 
id = i;
} 

@Deprecated
    public ArgoDiagramImpl(String diagramName)
    { 
super(diagramName);
try //1
{ 
setName(diagramName);
} 
catch (PropertyVetoException pve) //1
{ 
} 


constructorInit();
} 

public String getVetoMessage(String propertyName)
    { 
if(propertyName.equals("name"))//1
{ 
return "Name of diagram may not exist already";
} 

return null;
} 

private void constructorInit()
    { 
Project project = ProjectManager.getManager().getCurrentProject();
if(project != null)//1
{ 
settings = project.getProjectSettings().getDefaultDiagramSettings();
} 

if(!(UndoManager.getInstance() instanceof DiagramUndoManager))//1
{ 
UndoManager.setInstance(new DiagramUndoManager());
LOG.info("Setting Diagram undo manager");
} 
else
{ 
LOG.info("Diagram undo manager already set");
} 

ArgoEventPump.addListener(ArgoEventTypes.ANY_NOTATION_EVENT, this);
ArgoEventPump.addListener(
            ArgoEventTypes.ANY_DIAGRAM_APPEARANCE_EVENT, this);
addVetoableChangeListener(this);
} 

public String toString()
    { 
return "Diagram: " + getName();
} 

public Fig getContainingFig(Object obj)
    { 
Fig fig = super.presentationFor(obj);
if(fig == null && Model.getFacade().isAUMLElement(obj))//1
{ 
if(Model.getFacade().isAOperation(obj)
                    || Model.getFacade().isAReception(obj)
                    || Model.getFacade().isAAttribute(obj))//1
{ 
return presentationFor(Model.getFacade().getOwner(obj));
} 

} 

return fig;
} 

public void damage()
    { 
if(getLayer() != null && getLayer().getEditors() != null)//1
{ 
Iterator it = getLayer().getEditors().iterator();
while (it.hasNext()) //1
{ 
((Editor) it.next()).damageAll();
} 

} 

} 

public Object getOwner()
    { 
return getNamespace();
} 

private boolean repairFig(Fig f, StringBuffer report)
    { 
LOG.info("Checking " + figDescription(f) + f.getOwner());
boolean faultFixed = false;
String figDescription = null;
if(!getLayer().equals(f.getLayer()))//1
{ 
if(figDescription == null)//1
{ 
figDescription = figDescription(f);
report.append(figDescription);
} 

if(f.getLayer() == null)//1
{ 
report.append("-- Fixed: layer was null\n");
} 
else
{ 
report.append("-- Fixed: refered to wrong layer\n");
} 

faultFixed = true;
f.setLayer(getLayer());
} 

if(!f.isVisible())//1
{ 
if(figDescription == null)//1
{ 
figDescription = figDescription(f);
report.append(figDescription);
} 

report.append("-- Fixed: a Fig must be visible\n");
faultFixed = true;
f.setVisible(true);
} 

if(f instanceof FigEdge)//1
{ 
FigEdge fe = (FigEdge) f;
FigNode destFig = fe.getDestFigNode();
FigNode sourceFig = fe.getSourceFigNode();
if(destFig == null)//1
{ 
if(figDescription == null)//1
{ 
figDescription = figDescription(f);
report.append(figDescription);
} 

faultFixed = true;
report.append("-- Removed: as it has no dest Fig\n");
f.removeFromDiagram();
} 
else
if(sourceFig == null)//1
{ 
if(figDescription == null)//1
{ 
figDescription = figDescription(f);
report.append(figDescription);
} 

faultFixed = true;
report.append("-- Removed: as it has no source Fig\n");
f.removeFromDiagram();
} 
else
if(sourceFig.getOwner() == null)//1
{ 
if(figDescription == null)//1
{ 
figDescription = figDescription(f);
report.append(figDescription);
} 

faultFixed = true;
report.append("-- Removed: as its source Fig has no owner\n");
f.removeFromDiagram();
} 
else
if(destFig.getOwner() == null)//1
{ 
if(figDescription == null)//1
{ 
figDescription = figDescription(f);
report.append(figDescription);
} 

faultFixed = true;
report.append(
                    "-- Removed: as its destination Fig has no owner\n");
f.removeFromDiagram();
} 
else
if(Model.getUmlFactory().isRemoved(
                           sourceFig.getOwner()))//1
{ 
if(figDescription == null)//1
{ 
figDescription = figDescription(f);
report.append(figDescription);
} 

faultFixed = true;
report.append("-- Removed: as its source Figs owner is no "
                              + "longer in the repository\n");
f.removeFromDiagram();
} 
else
if(Model.getUmlFactory().isRemoved(
                           destFig.getOwner()))//1
{ 
if(figDescription == null)//1
{ 
figDescription = figDescription(f);
report.append(figDescription);
} 

faultFixed = true;
report.append("-- Removed: as its destination Figs owner "
                              + "is no longer in the repository\n");
f.removeFromDiagram();
} 






} 
else
if((f instanceof FigNode || f instanceof FigEdge)
                   && f.getOwner() == null



                   && !(f instanceof FigPool))//1
{ 
if(figDescription == null)//1
{ 
figDescription = figDescription(f);
report.append(figDescription);
} 

faultFixed = true;
report.append("-- Removed: owner was null\n");
f.removeFromDiagram();
} 
else
if((f instanceof FigNode || f instanceof FigEdge)
                   &&  Model.getFacade().isAUMLElement(f.getOwner())
                   &&  Model.getUmlFactory().isRemoved(f.getOwner()))//1
{ 
if(figDescription == null)//1
{ 
figDescription = figDescription(f);
report.append(figDescription);
} 

faultFixed = true;
report.append(
                "-- Removed: model element no longer in the repository\n");
f.removeFromDiagram();
} 
else
if(f instanceof FigGroup && !(f instanceof FigNode))//1
{ 
if(figDescription == null)//1
{ 
figDescription = figDescription(f);
report.append(figDescription);
} 

faultFixed = true;
report.append(
                "-- Removed: a FigGroup should not be on the diagram\n");
f.removeFromDiagram();
} 




return faultFixed;
} 

public void remove()
    { 
List<Fig> contents = new ArrayList<Fig>(getLayer().getContents());
int size = contents.size();
for (int i = 0; i < size; ++i) //1
{ 
Fig f = contents.get(i);
f.removeFromDiagram();
} 

firePropertyChange("remove", null, null);
super.remove();
} 

public void setName(String n) throws PropertyVetoException
    { 
super.setName(n);
MutableGraphSupport.enableSaveAction();
} 

public void propertyChange(PropertyChangeEvent evt)
    { 
if((evt.getSource() == namespace)
                && (evt instanceof DeleteInstanceEvent)
                && "remove".equals(evt.getPropertyName()))//1
{ 
Model.getPump().removeModelEventListener(this, namespace, "remove");
if(getProject() != null)//1
{ 
getProject().moveToTrash(this);
} 

} 

} 

public List getNodes()
    { 
if(getGraphModel() != null)//1
{ 
return getGraphModel().getNodes();
} 

return super.getNodes();
} 

public DiagramSettings getDiagramSettings()
    { 
return settings;
} 

public void setModelElementNamespace(Object modelElement, Object ns)
    { 
if(modelElement == null)//1
{ 
return;
} 

if(ns == null)//1
{ 
if(getNamespace() != null)//1
{ 
ns = getNamespace();
} 
else
{ 
ns = getProject().getRoot();
} 

} 

if(ns == null)//2
{ 
return;
} 

if(Model.getFacade().getNamespace(modelElement) == ns)//1
{ 
return;
} 

CoreHelper coreHelper = Model.getCoreHelper();
ModelManagementHelper modelHelper = Model.getModelManagementHelper();
if(!modelHelper.isCyclicOwnership(ns, modelElement)
                && coreHelper.isValidNamespace(modelElement, ns))//1
{ 
coreHelper.setModelElementContainer(modelElement, ns);
} 

} 

public List getEdges()
    { 
if(getGraphModel() != null)//1
{ 
return getGraphModel().getEdges();
} 

return super.getEdges();
} 

 } 


