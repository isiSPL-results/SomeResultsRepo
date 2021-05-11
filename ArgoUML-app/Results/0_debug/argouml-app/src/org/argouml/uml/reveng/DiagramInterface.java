
//#if -87096866 
// Compilation Unit of /DiagramInterface.java 
 

//#if -1260061382 
package org.argouml.uml.reveng;
//#endif 


//#if 157796780 
import java.awt.Rectangle;
//#endif 


//#if -1047949402 
import java.beans.PropertyVetoException;
//#endif 


//#if -947130336 
import java.util.ArrayList;
//#endif 


//#if -1303137727 
import java.util.List;
//#endif 


//#if -1293508707 
import org.apache.log4j.Logger;
//#endif 


//#if 801952250 
import org.argouml.kernel.Project;
//#endif 


//#if 554027792 
import org.argouml.model.Model;
//#endif 


//#if -659041073 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 795041942 
import org.argouml.uml.diagram.DiagramFactory;
//#endif 


//#if 120299175 
import org.argouml.uml.diagram.static_structure.ClassDiagramGraphModel;
//#endif 


//#if -1064003509 
import org.argouml.uml.diagram.static_structure.ui.FigClass;
//#endif 


//#if 1807408153 
import org.argouml.uml.diagram.static_structure.ui.FigClassifierBox;
//#endif 


//#if 1826670762 
import org.argouml.uml.diagram.static_structure.ui.FigInterface;
//#endif 


//#if -246684355 
import org.argouml.uml.diagram.static_structure.ui.FigPackage;
//#endif 


//#if 1862315733 
import org.tigris.gef.base.Editor;
//#endif 


//#if -1942695145 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if -1927285497 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 689860766 
public class DiagramInterface  { 

//#if 583231669 
private static final char DIAGRAM_NAME_SEPARATOR = '_';
//#endif 


//#if -1300704173 
private static final String DIAGRAM_NAME_SUFFIX = "classes";
//#endif 


//#if 2145936952 
private static final Logger LOG =
        Logger.getLogger(DiagramInterface.class);
//#endif 


//#if -1157112695 
private Editor currentEditor;
//#endif 


//#if 1567029482 
private List<ArgoDiagram> modifiedDiagrams =
        new ArrayList<ArgoDiagram>();
//#endif 


//#if 1009898553 
private ClassDiagramGraphModel currentGM;
//#endif 


//#if 884471889 
private LayerPerspective currentLayer;
//#endif 


//#if 1569791310 
private ArgoDiagram currentDiagram;
//#endif 


//#if 964084745 
private Project currentProject;
//#endif 


//#if 1604342898 
public DiagramInterface(Editor editor)
    { 

//#if -285516319 
currentEditor = editor;
//#endif 


//#if 87963340 
LayerPerspective layer =
            (LayerPerspective) editor.getLayerManager().getActiveLayer();
//#endif 


//#if -797302495 
currentProject = ((ArgoDiagram) layer.getDiagram()).getProject();
//#endif 

} 

//#endif 


//#if -416933559 
void resetModifiedDiagrams()
    { 

//#if 2132424241 
modifiedDiagrams = new ArrayList<ArgoDiagram>();
//#endif 

} 

//#endif 


//#if 1876435697 
private String getDiagramName(String packageName)
    { 

//#if 381392318 
return packageName.replace('.', DIAGRAM_NAME_SEPARATOR)
               + DIAGRAM_NAME_SEPARATOR + DIAGRAM_NAME_SUFFIX;
//#endif 

} 

//#endif 


//#if -143342160 
public List<ArgoDiagram> getModifiedDiagramList()
    { 

//#if -324820743 
return modifiedDiagrams;
//#endif 

} 

//#endif 


//#if -827882220 
public DiagramInterface(Editor editor, Project project)
    { 

//#if -1966471265 
currentEditor = editor;
//#endif 

} 

//#endif 


//#if 1045777434 
public void addPackage(Object newPackage)
    { 

//#if -197976829 
if(!isInDiagram(newPackage))//1
{ 

//#if 933406063 
if(currentGM.canAddNode(newPackage))//1
{ 

//#if -820481992 
FigPackage newPackageFig = new FigPackage(newPackage,
                        new Rectangle(0, 0, 0, 0), currentDiagram
                        .getDiagramSettings());
//#endif 


//#if 1976889001 
currentLayer.add(newPackageFig);
//#endif 


//#if -1994927006 
currentGM.addNode(newPackage);
//#endif 


//#if -1616149531 
currentLayer.putInPosition(newPackageFig);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 280340243 
public void createRootClassDiagram()
    { 

//#if -480207171 
selectClassDiagram(null, "");
//#endif 

} 

//#endif 


//#if 1076019527 
private void addClassifier(Object classifier, boolean minimise)
    { 

//#if -201014400 
if(currentGM.canAddNode(classifier))//1
{ 

//#if 427410671 
FigClassifierBox newFig;
//#endif 


//#if -583939980 
if(Model.getFacade().isAClass(classifier))//1
{ 

//#if -21513711 
newFig = new FigClass(classifier, new Rectangle(0, 0, 0, 0),
                                      currentDiagram.getDiagramSettings());
//#endif 

} 
else

//#if 256565794 
if(Model.getFacade().isAInterface(classifier))//1
{ 

//#if 542290818 
newFig = new FigInterface(classifier,
                                          new Rectangle(0, 0, 0, 0), currentDiagram
                                          .getDiagramSettings());
//#endif 

} 
else
{ 

//#if 2028350294 
return;
//#endif 

} 

//#endif 


//#endif 


//#if -1408931311 
currentLayer.add(newFig);
//#endif 


//#if -807869719 
currentGM.addNode(classifier);
//#endif 


//#if 1335265109 
currentLayer.putInPosition(newFig);
//#endif 


//#if -375261668 
newFig.setOperationsVisible(!minimise);
//#endif 


//#if -1538318915 
if(Model.getFacade().isAClass(classifier))//2
{ 

//#if 1060298643 
((FigClass) newFig).setAttributesVisible(!minimise);
//#endif 

} 

//#endif 


//#if 1928325322 
newFig.renderingChanged();
//#endif 

} 
else
{ 

//#if 43763842 
FigClassifierBox existingFig = null;
//#endif 


//#if -584071449 
List figs = currentLayer.getContentsNoEdges();
//#endif 


//#if -252834787 
for (int i = 0; i < figs.size(); i++) //1
{ 

//#if 875303777 
Fig fig = (Fig) figs.get(i);
//#endif 


//#if -764956011 
if(classifier == fig.getOwner())//1
{ 

//#if -128676894 
existingFig = (FigClassifierBox) fig;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1505895467 
existingFig.renderingChanged();
//#endif 

} 

//#endif 


//#if -458505999 
currentGM.addNodeRelatedEdges(classifier);
//#endif 

} 

//#endif 


//#if 1271181209 
void markDiagramAsModified(ArgoDiagram diagram)
    { 

//#if 696709443 
if(!modifiedDiagrams.contains(diagram))//1
{ 

//#if -1605958943 
modifiedDiagrams.add(diagram);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1544212417 
public boolean isInDiagram(Object p)
    { 

//#if 1118393392 
if(currentDiagram == null)//1
{ 

//#if 1946844907 
return false;
//#endif 

} 
else
{ 

//#if -605126501 
return currentDiagram.getNodes().contains(p);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2076128026 
public void selectClassDiagram(Object p, String name)
    { 

//#if 473533512 
if(currentProject == null)//1
{ 

//#if 787174120 
throw new RuntimeException("current project not set yet");
//#endif 

} 

//#endif 


//#if 1315629893 
ArgoDiagram m = currentProject.getDiagram(getDiagramName(name));
//#endif 


//#if -526896737 
if(m != null)//1
{ 

//#if 438460035 
setCurrentDiagram(m);
//#endif 

} 
else
{ 

//#if -1422881044 
addClassDiagram(p, name);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 276589587 
public boolean isDiagramInProject(String name)
    { 

//#if -1830463816 
if(currentProject == null)//1
{ 

//#if -1143566955 
throw new RuntimeException("current project not set yet");
//#endif 

} 

//#endif 


//#if -992270404 
return currentProject.getDiagram(getDiagramName(name)) != null;
//#endif 

} 

//#endif 


//#if -112824327 
public void addClass(Object newClass, boolean minimise)
    { 

//#if -118678807 
addClassifier(newClass, minimise);
//#endif 

} 

//#endif 


//#if -1090545685 
public void setCurrentDiagram(ArgoDiagram diagram)
    { 

//#if 1031249502 
if(diagram == null)//1
{ 

//#if 2022895392 
throw new RuntimeException("you can't select a null diagram");
//#endif 

} 

//#endif 


//#if -1450852684 
currentGM = (ClassDiagramGraphModel) diagram.getGraphModel();
//#endif 


//#if 1647719462 
currentLayer = diagram.getLayer();
//#endif 


//#if -1503931804 
currentDiagram = diagram;
//#endif 


//#if -937772442 
currentProject = diagram.getProject();
//#endif 


//#if -1438995433 
markDiagramAsModified(diagram);
//#endif 

} 

//#endif 


//#if -1767197415 
public void addInterface(Object newInterface, boolean minimise)
    { 

//#if -261604517 
addClassifier(newInterface, minimise);
//#endif 

} 

//#endif 


//#if -215560502 
public void addClassDiagram(Object ns, String name)
    { 

//#if 1573740335 
if(currentProject == null)//1
{ 

//#if 1878099534 
throw new RuntimeException("current project not set yet");
//#endif 

} 

//#endif 


//#if -1869967334 
ArgoDiagram d = DiagramFactory.getInstance().createDiagram(
                            DiagramFactory.DiagramType.Class,
                            ns == null ? currentProject.getRoot() : ns, null);
//#endif 


//#if -319234911 
try //1
{ 

//#if 602302875 
d.setName(getDiagramName(name));
//#endif 

} 

//#if -1259691944 
catch (PropertyVetoException pve) //1
{ 

//#if -1448944968 
LOG.error("Failed to set diagram name.", pve);
//#endif 

} 

//#endif 


//#endif 


//#if 1684478502 
currentProject.addMember(d);
//#endif 


//#if -1565205953 
setCurrentDiagram(d);
//#endif 

} 

//#endif 


//#if -1064689413 
Editor getEditor()
    { 

//#if -562196513 
return currentEditor;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

