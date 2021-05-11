// Compilation Unit of /DiagramFactory.java 
 
package org.argouml.uml.diagram;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.ActivityDiagram;
import org.argouml.model.ClassDiagram;
import org.argouml.model.CollaborationDiagram;
import org.argouml.model.DeploymentDiagram;
import org.argouml.model.DiDiagram;
import org.argouml.model.Model;
import org.argouml.model.SequenceDiagram;
import org.argouml.model.StateDiagram;
import org.argouml.model.UseCaseDiagram;
import org.argouml.uml.diagram.activity.ui.UMLActivityDiagram;
import org.argouml.uml.diagram.collaboration.ui.UMLCollaborationDiagram;
import org.argouml.uml.diagram.deployment.ui.UMLDeploymentDiagram;
import org.argouml.uml.diagram.sequence.ui.UMLSequenceDiagram;
import org.argouml.uml.diagram.state.ui.UMLStateDiagram;
import org.argouml.uml.diagram.static_structure.ui.UMLClassDiagram;
import org.argouml.uml.diagram.use_case.ui.UMLUseCaseDiagram;
import org.tigris.gef.base.Diagram;
import org.tigris.gef.graph.GraphNodeRenderer;
public final class DiagramFactory  { 
private final Map noStyleProperties = new HashMap();
private static Map<DiagramType, Class> diagramClasses =
        new EnumMap<DiagramType, Class>(DiagramType.class);
private static DiagramFactory diagramFactory = new DiagramFactory();
private Map<DiagramType, Object> factories =
        new EnumMap<DiagramType, Object>(DiagramType.class);
public ArgoDiagram removeDiagram(ArgoDiagram diagram)
    { 
DiDiagram dd =
            ((UMLMutableGraphSupport) diagram.getGraphModel()).getDiDiagram();
if(dd != null)//1
{ 
GraphChangeAdapter.getInstance().removeDiagram(dd);
} 

return diagram;
} 

public static DiagramFactory getInstance()
    { 
return diagramFactory;
} 

@Deprecated
    public ArgoDiagram createDiagram(final DiagramType type,
                                     final Object namespace, final Object machine)
    { 
DiagramSettings settings = ProjectManager.getManager()
                                   .getCurrentProject().getProjectSettings()
                                   .getDefaultDiagramSettings();
return createInternal(type, namespace, machine, settings);
} 

@Deprecated
    public ArgoDiagram createDiagram(Class type, Object namespace,
                                     Object machine)
    { 
ArgoDiagram diagram = null;
Class diType = null;
if(type == UMLClassDiagram.class)//1
{ 
diagram = new UMLClassDiagram(namespace);
diType = ClassDiagram.class;
} 
else
if(type == UMLUseCaseDiagram.class)//1
{ 
diagram = new UMLUseCaseDiagram(namespace);
diType = UseCaseDiagram.class;
} 
else
if(type == UMLStateDiagram.class)//1
{ 
diagram = new UMLStateDiagram(namespace, machine);
diType = StateDiagram.class;
} 
else
if(type == UMLDeploymentDiagram.class)//1
{ 
diagram = new UMLDeploymentDiagram(namespace);
diType = DeploymentDiagram.class;
} 
else
if(type == UMLCollaborationDiagram.class)//1
{ 
diagram = new UMLCollaborationDiagram(namespace);
diType = CollaborationDiagram.class;
} 
else
if(type == UMLActivityDiagram.class)//1
{ 
diagram = new UMLActivityDiagram(namespace, machine);
diType = ActivityDiagram.class;
} 
else
if(type == UMLSequenceDiagram.class)//1
{ 
diagram = new UMLSequenceDiagram(namespace);
diType = SequenceDiagram.class;
} 







if(diagram == null)//1
{ 
throw new IllegalArgumentException ("Unknown diagram type");
} 

if(Model.getDiagramInterchangeModel() != null)//1
{ 
diagram.getGraphModel().addGraphEventListener(
                GraphChangeAdapter.getInstance());
DiDiagram dd = GraphChangeAdapter.getInstance()
                           .createDiagram(diType, namespace);
((UMLMutableGraphSupport) diagram.getGraphModel()).setDiDiagram(dd);
} 

return diagram;
} 

public ArgoDiagram createDefaultDiagram(Object namespace)
    { 
return createDiagram(DiagramType.Class, namespace, null);
} 

public ArgoDiagram create(
        final DiagramType type,
        final Object owner,
        final DiagramSettings settings)
    { 
return  createInternal(type, owner, null, settings);
} 

public void registerDiagramFactory(
        final DiagramType type,
        final DiagramFactoryInterface2 factory)
    { 
factories.put(type, factory);
} 

@Deprecated
    public void registerDiagramFactory(
        final DiagramType type,
        final DiagramFactoryInterface factory)
    { 
factories.put(type, factory);
} 

@Deprecated
    public Object createRenderingElement(Object diagram, Object model)
    { 
GraphNodeRenderer rend =
            ((Diagram) diagram).getLayer().getGraphNodeRenderer();
Object renderingElement =
            rend.getFigNodeFor(model, 0, 0, noStyleProperties);
return renderingElement;
} 

private ArgoDiagram createInternal(final DiagramType type,
                                       final Object namespace, final Object machine,
                                       DiagramSettings settings)
    { 
final ArgoDiagram diagram;
if(settings == null)//1
{ 
throw new IllegalArgumentException(
                "DiagramSettings may not be null");
} 

Object factory = factories.get(type);
if(factory != null)//1
{ 
Object owner;
if(machine != null)//1
{ 
owner = machine;
} 
else
{ 
owner = namespace;
} 

if(factory instanceof DiagramFactoryInterface2)//1
{ 
diagram = ((DiagramFactoryInterface2) factory).createDiagram(
                              owner, (String) null, settings);
} 
else
if(factory instanceof DiagramFactoryInterface)//1
{ 
diagram = ((DiagramFactoryInterface) factory).createDiagram(
                              namespace, machine);
diagram.setDiagramSettings(settings);
} 
else
{ 
throw new IllegalStateException(
                    "Unknown factory type registered");
} 


} 
else
{ 
if((




                        type == DiagramType.State




                        ||





                        type == DiagramType.Activity

                    )
                    && machine == null)//1
{ 
diagram = createDiagram(diagramClasses.get(type), null,
                                        namespace);
} 
else
{ 
diagram = createDiagram(diagramClasses.get(type), namespace,
                                        machine);
} 

diagram.setDiagramSettings(settings);
} 

return diagram;
} 

private DiagramFactory()
    { 
super();
diagramClasses.put(DiagramType.Class, UMLClassDiagram.class);
diagramClasses.put(DiagramType.UseCase, UMLUseCaseDiagram.class);
diagramClasses.put(DiagramType.State, UMLStateDiagram.class);
diagramClasses.put(DiagramType.Deployment, UMLDeploymentDiagram.class);
diagramClasses.put(DiagramType.Collaboration, UMLCollaborationDiagram.class);
diagramClasses.put(DiagramType.Activity, UMLActivityDiagram.class);
diagramClasses.put(DiagramType.Sequence, UMLSequenceDiagram.class);
} 

public enum DiagramType {
Class,

UseCase,

State,

Deployment,

Collaboration,

Activity,

Sequence,

;
 } 

 } 


