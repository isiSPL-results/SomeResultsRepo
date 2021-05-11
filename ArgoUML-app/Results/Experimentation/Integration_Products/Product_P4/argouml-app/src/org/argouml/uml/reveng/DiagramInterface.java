package org.argouml.uml.reveng;
import java.awt.Rectangle;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.argouml.kernel.Project;
import org.argouml.model.Model;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramFactory;
import org.argouml.uml.diagram.static_structure.ClassDiagramGraphModel;
import org.argouml.uml.diagram.static_structure.ui.FigClass;
import org.argouml.uml.diagram.static_structure.ui.FigClassifierBox;
import org.argouml.uml.diagram.static_structure.ui.FigInterface;
import org.argouml.uml.diagram.static_structure.ui.FigPackage;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.LayerPerspective;
import org.tigris.gef.presentation.Fig;
public class DiagramInterface  { 
private static final char DIAGRAM_NAME_SEPARATOR = '_';
private static final String DIAGRAM_NAME_SUFFIX = "classes";
private static final Logger LOG =
        Logger.getLogger(DiagramInterface.class);
private Editor currentEditor;
private List<ArgoDiagram> modifiedDiagrams =
        new ArrayList<ArgoDiagram>();
private ClassDiagramGraphModel currentGM;
private LayerPerspective currentLayer;
private ArgoDiagram currentDiagram;
private Project currentProject;
public DiagramInterface(Editor editor)
    { 
currentEditor = editor;
LayerPerspective layer =
            (LayerPerspective) editor.getLayerManager().getActiveLayer();
currentProject = ((ArgoDiagram) layer.getDiagram()).getProject();
} 
void resetModifiedDiagrams()
    { 
modifiedDiagrams = new ArrayList<ArgoDiagram>();
} 
private String getDiagramName(String packageName)
    { 
return packageName.replace('.', DIAGRAM_NAME_SEPARATOR)
               + DIAGRAM_NAME_SEPARATOR + DIAGRAM_NAME_SUFFIX;
} 
public List<ArgoDiagram> getModifiedDiagramList()
    { 
return modifiedDiagrams;
} 
public DiagramInterface(Editor editor, Project project)
    { 
currentEditor = editor;
} 
public void addPackage(Object newPackage)
    { 
if(!isInDiagram(newPackage))//1
{ 
if(currentGM.canAddNode(newPackage))//1
{ 
FigPackage newPackageFig = new FigPackage(newPackage,
                        new Rectangle(0, 0, 0, 0), currentDiagram
                        .getDiagramSettings());
currentLayer.add(newPackageFig);
currentGM.addNode(newPackage);
currentLayer.putInPosition(newPackageFig);
} 
} 
} 
public void createRootClassDiagram()
    { 
selectClassDiagram(null, "");
} 
private void addClassifier(Object classifier, boolean minimise)
    { 
if(currentGM.canAddNode(classifier))//1
{ 
FigClassifierBox newFig;
if(Model.getFacade().isAClass(classifier))//1
{ 
newFig = new FigClass(classifier, new Rectangle(0, 0, 0, 0),
                                      currentDiagram.getDiagramSettings());
} 
else
if(Model.getFacade().isAInterface(classifier))//1
{ 
newFig = new FigInterface(classifier,
                                          new Rectangle(0, 0, 0, 0), currentDiagram
                                          .getDiagramSettings());
} 
else
{ 
return;
} 
currentLayer.add(newFig);
currentGM.addNode(classifier);
currentLayer.putInPosition(newFig);
newFig.setOperationsVisible(!minimise);
if(Model.getFacade().isAClass(classifier))//2
{ 
((FigClass) newFig).setAttributesVisible(!minimise);
} 
newFig.renderingChanged();
} 
else
{ 
FigClassifierBox existingFig = null;
List figs = currentLayer.getContentsNoEdges();
for (int i = 0; i < figs.size(); i++) //1
{ 
Fig fig = (Fig) figs.get(i);
if(classifier == fig.getOwner())//1
{ 
existingFig = (FigClassifierBox) fig;
} 
} 
existingFig.renderingChanged();
} 
currentGM.addNodeRelatedEdges(classifier);
} 
void markDiagramAsModified(ArgoDiagram diagram)
    { 
if(!modifiedDiagrams.contains(diagram))//1
{ 
modifiedDiagrams.add(diagram);
} 
} 
public boolean isInDiagram(Object p)
    { 
if(currentDiagram == null)//1
{ 
return false;
} 
else
{ 
return currentDiagram.getNodes().contains(p);
} 
} 
public void selectClassDiagram(Object p, String name)
    { 
if(currentProject == null)//1
{ 
throw new RuntimeException("current project not set yet");
} 
ArgoDiagram m = currentProject.getDiagram(getDiagramName(name));
if(m != null)//1
{ 
setCurrentDiagram(m);
} 
else
{ 
addClassDiagram(p, name);
} 
} 
public boolean isDiagramInProject(String name)
    { 
if(currentProject == null)//1
{ 
throw new RuntimeException("current project not set yet");
} 
return currentProject.getDiagram(getDiagramName(name)) != null;
} 
public void addClass(Object newClass, boolean minimise)
    { 
addClassifier(newClass, minimise);
} 
public void setCurrentDiagram(ArgoDiagram diagram)
    { 
if(diagram == null)//1
{ 
throw new RuntimeException("you can't select a null diagram");
} 
currentGM = (ClassDiagramGraphModel) diagram.getGraphModel();
currentLayer = diagram.getLayer();
currentDiagram = diagram;
currentProject = diagram.getProject();
markDiagramAsModified(diagram);
} 
public void addInterface(Object newInterface, boolean minimise)
    { 
addClassifier(newInterface, minimise);
} 
public void addClassDiagram(Object ns, String name)
    { 
if(currentProject == null)//1
{ 
throw new RuntimeException("current project not set yet");
} 
ArgoDiagram d = DiagramFactory.getInstance().createDiagram(
                            DiagramFactory.DiagramType.Class,
                            ns == null ? currentProject.getRoot() : ns, null);
try//1
{ 
d.setName(getDiagramName(name));
} 
catch (PropertyVetoException pve) //1
{ 
LOG.error("Failed to set diagram name.", pve);
} 
currentProject.addMember(d);
setCurrentDiagram(d);
} 
Editor getEditor()
    { 
return currentEditor;
} 

 } 
