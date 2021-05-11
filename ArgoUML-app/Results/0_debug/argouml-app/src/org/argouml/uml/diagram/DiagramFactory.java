
//#if -1690679365 
// Compilation Unit of /DiagramFactory.java 
 

//#if 1488303490 
package org.argouml.uml.diagram;
//#endif 


//#if 1491898536 
import java.util.EnumMap;
//#endif 


//#if -584126923 
import java.util.HashMap;
//#endif 


//#if 1201079303 
import java.util.Map;
//#endif 


//#if -1708486981 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1686544481 
import org.argouml.model.ActivityDiagram;
//#endif 


//#if 1171802422 
import org.argouml.model.ClassDiagram;
//#endif 


//#if 1249855235 
import org.argouml.model.CollaborationDiagram;
//#endif 


//#if -1296605289 
import org.argouml.model.DeploymentDiagram;
//#endif 


//#if -1970898089 
import org.argouml.model.DiDiagram;
//#endif 


//#if -2018073316 
import org.argouml.model.Model;
//#endif 


//#if 343692051 
import org.argouml.model.SequenceDiagram;
//#endif 


//#if 1143028559 
import org.argouml.model.StateDiagram;
//#endif 


//#if -1860514667 
import org.argouml.model.UseCaseDiagram;
//#endif 


//#if 1921885430 
import org.argouml.uml.diagram.activity.ui.UMLActivityDiagram;
//#endif 


//#if 592630800 
import org.argouml.uml.diagram.collaboration.ui.UMLCollaborationDiagram;
//#endif 


//#if 1650559606 
import org.argouml.uml.diagram.deployment.ui.UMLDeploymentDiagram;
//#endif 


//#if 765438646 
import org.argouml.uml.diagram.sequence.ui.UMLSequenceDiagram;
//#endif 


//#if -420972632 
import org.argouml.uml.diagram.state.ui.UMLStateDiagram;
//#endif 


//#if -1927666412 
import org.argouml.uml.diagram.static_structure.ui.UMLClassDiagram;
//#endif 


//#if -1391271815 
import org.argouml.uml.diagram.use_case.ui.UMLUseCaseDiagram;
//#endif 


//#if -1833744307 
import org.tigris.gef.base.Diagram;
//#endif 


//#if 1616474400 
import org.tigris.gef.graph.GraphNodeRenderer;
//#endif 


//#if -1064629307 
public final class DiagramFactory  { 

//#if -1953131760 
private final Map noStyleProperties = new HashMap();
//#endif 


//#if 143765580 
private static Map<DiagramType, Class> diagramClasses =
        new EnumMap<DiagramType, Class>(DiagramType.class);
//#endif 


//#if -1286315128 
private static DiagramFactory diagramFactory = new DiagramFactory();
//#endif 


//#if -2130658215 
private Map<DiagramType, Object> factories =
        new EnumMap<DiagramType, Object>(DiagramType.class);
//#endif 


//#if -2089006131 
public ArgoDiagram removeDiagram(ArgoDiagram diagram)
    { 

//#if 1797430253 
DiDiagram dd =
            ((UMLMutableGraphSupport) diagram.getGraphModel()).getDiDiagram();
//#endif 


//#if 1091794326 
if(dd != null)//1
{ 

//#if -40040727 
GraphChangeAdapter.getInstance().removeDiagram(dd);
//#endif 

} 

//#endif 


//#if -18857000 
return diagram;
//#endif 

} 

//#endif 


//#if -1257121833 
public static DiagramFactory getInstance()
    { 

//#if -5055240 
return diagramFactory;
//#endif 

} 

//#endif 


//#if -269680650 
@Deprecated
    public ArgoDiagram createDiagram(final DiagramType type,
                                     final Object namespace, final Object machine)
    { 

//#if 1168676544 
DiagramSettings settings = ProjectManager.getManager()
                                   .getCurrentProject().getProjectSettings()
                                   .getDefaultDiagramSettings();
//#endif 


//#if 331730557 
return createInternal(type, namespace, machine, settings);
//#endif 

} 

//#endif 


//#if 86955105 
@Deprecated
    public ArgoDiagram createDiagram(Class type, Object namespace,
                                     Object machine)
    { 

//#if -393340762 
ArgoDiagram diagram = null;
//#endif 


//#if -899440200 
Class diType = null;
//#endif 


//#if 528823346 
if(type == UMLClassDiagram.class)//1
{ 

//#if 388412794 
diagram = new UMLClassDiagram(namespace);
//#endif 


//#if -1606068012 
diType = ClassDiagram.class;
//#endif 

} 
else

//#if 296592980 
if(type == UMLUseCaseDiagram.class)//1
{ 

//#if 1096973371 
diagram = new UMLUseCaseDiagram(namespace);
//#endif 


//#if -1957951885 
diType = UseCaseDiagram.class;
//#endif 

} 
else

//#if 1182772469 
if(type == UMLStateDiagram.class)//1
{ 

//#if 641849422 
diagram = new UMLStateDiagram(namespace, machine);
//#endif 


//#if -710783265 
diType = StateDiagram.class;
//#endif 

} 
else

//#if 894186546 
if(type == UMLDeploymentDiagram.class)//1
{ 

//#if 799135380 
diagram = new UMLDeploymentDiagram(namespace);
//#endif 


//#if -1252796384 
diType = DeploymentDiagram.class;
//#endif 

} 
else

//#if -1443916534 
if(type == UMLCollaborationDiagram.class)//1
{ 

//#if -1086963557 
diagram = new UMLCollaborationDiagram(namespace);
//#endif 


//#if -783453969 
diType = CollaborationDiagram.class;
//#endif 

} 
else

//#if -1061213984 
if(type == UMLActivityDiagram.class)//1
{ 

//#if 428796456 
diagram = new UMLActivityDiagram(namespace, machine);
//#endif 


//#if -1084872275 
diType = ActivityDiagram.class;
//#endif 

} 
else

//#if 1216276909 
if(type == UMLSequenceDiagram.class)//1
{ 

//#if 1965705694 
diagram = new UMLSequenceDiagram(namespace);
//#endif 


//#if 418170338 
diType = SequenceDiagram.class;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#if 22812653 
if(diagram == null)//1
{ 

//#if -947528218 
throw new IllegalArgumentException ("Unknown diagram type");
//#endif 

} 

//#endif 


//#if 1086452288 
if(Model.getDiagramInterchangeModel() != null)//1
{ 

//#if -1291958885 
diagram.getGraphModel().addGraphEventListener(
                GraphChangeAdapter.getInstance());
//#endif 


//#if 1126448005 
DiDiagram dd = GraphChangeAdapter.getInstance()
                           .createDiagram(diType, namespace);
//#endif 


//#if 550522668 
((UMLMutableGraphSupport) diagram.getGraphModel()).setDiDiagram(dd);
//#endif 

} 

//#endif 


//#if 1097095790 
return diagram;
//#endif 

} 

//#endif 


//#if -2060248131 
public ArgoDiagram createDefaultDiagram(Object namespace)
    { 

//#if -603541913 
return createDiagram(DiagramType.Class, namespace, null);
//#endif 

} 

//#endif 


//#if -428803567 
public ArgoDiagram create(
        final DiagramType type,
        final Object owner,
        final DiagramSettings settings)
    { 

//#if -47971862 
return  createInternal(type, owner, null, settings);
//#endif 

} 

//#endif 


//#if -305420140 
public void registerDiagramFactory(
        final DiagramType type,
        final DiagramFactoryInterface2 factory)
    { 

//#if -546871966 
factories.put(type, factory);
//#endif 

} 

//#endif 


//#if 1439591457 
@Deprecated
    public void registerDiagramFactory(
        final DiagramType type,
        final DiagramFactoryInterface factory)
    { 

//#if 784786770 
factories.put(type, factory);
//#endif 

} 

//#endif 


//#if 536765311 
@Deprecated
    public Object createRenderingElement(Object diagram, Object model)
    { 

//#if -1550740235 
GraphNodeRenderer rend =
            ((Diagram) diagram).getLayer().getGraphNodeRenderer();
//#endif 


//#if -512592195 
Object renderingElement =
            rend.getFigNodeFor(model, 0, 0, noStyleProperties);
//#endif 


//#if 972264388 
return renderingElement;
//#endif 

} 

//#endif 


//#if -1338595186 
private ArgoDiagram createInternal(final DiagramType type,
                                       final Object namespace, final Object machine,
                                       DiagramSettings settings)
    { 

//#if -1152744946 
final ArgoDiagram diagram;
//#endif 


//#if 866605787 
if(settings == null)//1
{ 

//#if -1213497391 
throw new IllegalArgumentException(
                "DiagramSettings may not be null");
//#endif 

} 

//#endif 


//#if 1103207864 
Object factory = factories.get(type);
//#endif 


//#if 719726572 
if(factory != null)//1
{ 

//#if -63432336 
Object owner;
//#endif 


//#if -562952080 
if(machine != null)//1
{ 

//#if -1049532058 
owner = machine;
//#endif 

} 
else
{ 

//#if -1111207754 
owner = namespace;
//#endif 

} 

//#endif 


//#if 808658092 
if(factory instanceof DiagramFactoryInterface2)//1
{ 

//#if 2874502 
diagram = ((DiagramFactoryInterface2) factory).createDiagram(
                              owner, (String) null, settings);
//#endif 

} 
else

//#if -881160241 
if(factory instanceof DiagramFactoryInterface)//1
{ 

//#if -1694825709 
diagram = ((DiagramFactoryInterface) factory).createDiagram(
                              namespace, machine);
//#endif 


//#if -1047381260 
diagram.setDiagramSettings(settings);
//#endif 

} 
else
{ 

//#if 46215435 
throw new IllegalStateException(
                    "Unknown factory type registered");
//#endif 

} 

//#endif 


//#endif 

} 
else
{ 

//#if 840176480 
if((




                        type == DiagramType.State




                        ||





                        type == DiagramType.Activity

                    )
                    && machine == null)//1
{ 

//#if 591705107 
diagram = createDiagram(diagramClasses.get(type), null,
                                        namespace);
//#endif 

} 
else
{ 

//#if -756044533 
diagram = createDiagram(diagramClasses.get(type), namespace,
                                        machine);
//#endif 

} 

//#endif 


//#if 1773800126 
diagram.setDiagramSettings(settings);
//#endif 

} 

//#endif 


//#if -1436810406 
return diagram;
//#endif 

} 

//#endif 


//#if 748922132 
private DiagramFactory()
    { 

//#if 25438369 
super();
//#endif 


//#if -1409372988 
diagramClasses.put(DiagramType.Class, UMLClassDiagram.class);
//#endif 


//#if -89398364 
diagramClasses.put(DiagramType.UseCase, UMLUseCaseDiagram.class);
//#endif 


//#if 1893366948 
diagramClasses.put(DiagramType.State, UMLStateDiagram.class);
//#endif 


//#if -615473110 
diagramClasses.put(DiagramType.Deployment, UMLDeploymentDiagram.class);
//#endif 


//#if -1783346396 
diagramClasses.put(DiagramType.Collaboration, UMLCollaborationDiagram.class);
//#endif 


//#if 510108502 
diagramClasses.put(DiagramType.Activity, UMLActivityDiagram.class);
//#endif 


//#if -65601422 
diagramClasses.put(DiagramType.Sequence, UMLSequenceDiagram.class);
//#endif 

} 

//#endif 


//#if 869041887 
public enum DiagramType {

//#if 116855891 
Class,

//#endif 


//#if -372786830 
UseCase,

//#endif 


//#if 131870572 
State,

//#endif 


//#if -196026166 
Deployment,

//#endif 


//#if 1762023968 
Collaboration,

//#endif 


//#if -17967532 
Activity,

//#endif 


//#if -1307419898 
Sequence,

//#endif 

;
 } 

//#endif 

 } 

//#endif 


//#endif 

