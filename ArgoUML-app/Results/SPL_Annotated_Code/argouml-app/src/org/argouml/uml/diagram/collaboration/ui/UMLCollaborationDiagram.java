// Compilation Unit of /UMLCollaborationDiagram.java 
 
package org.argouml.uml.diagram.collaboration.ui;
import java.awt.Point;
import java.awt.Rectangle;
import java.beans.PropertyVetoException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.Action;
import org.apache.log4j.Logger;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.collaboration.CollabDiagramGraphModel;
import org.argouml.uml.diagram.static_structure.ui.FigComment;
import org.argouml.uml.diagram.ui.ActionAddAssociationRole;
import org.argouml.uml.diagram.ui.ActionAddMessage;
import org.argouml.uml.diagram.ui.ActionSetMode;
import org.argouml.uml.diagram.ui.FigMessage;
import org.argouml.uml.diagram.ui.RadioAction;
import org.argouml.uml.diagram.ui.UMLDiagram;
import org.argouml.util.ToolBarUtility;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.Layer;
import org.tigris.gef.base.LayerPerspective;
import org.tigris.gef.base.LayerPerspectiveMutable;
import org.tigris.gef.base.ModeCreatePolyEdge;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigNode;
public class UMLCollaborationDiagram extends UMLDiagram
  { 
private static final Logger LOG =
        Logger.getLogger(UMLCollaborationDiagram.class);
private Action actionClassifierRole;
private Action actionGeneralize;
private Action actionAssociation;
private Action actionAggregation;
private Action actionComposition;
private Action actionUniAssociation;
private Action actionUniAggregation;
private Action actionUniComposition;
private Action actionDepend;
private Action actionMessage;
private static final long serialVersionUID = 8081715986963837750L;
private Object[] getAssociationActions()
    { 
Object[][] actions = {
            {getActionAssociation(), getActionUniAssociation() },
            {getActionAggregation(), getActionUniAggregation() },
            {getActionComposition(), getActionUniComposition() },
        };
ToolBarUtility.manageDefault(actions,
                                     "diagram.collaboration.association");
return actions;
} 

public int getNumMessages()
    { 
Layer lay = getLayer();
Collection figs = lay.getContents();
int res = 0;
Iterator it = figs.iterator();
while (it.hasNext()) //1
{ 
Fig f = (Fig) it.next();
if(Model.getFacade().isAMessage(f.getOwner()))//1
{ 
res++;
} 

} 

return res;
} 

@Override
    public Object getDependentElement()
    { 
return getNamespace();
} 

private Action getActionAggregation()
    { 
if(actionAggregation == null)//1
{ 
actionAggregation =
                new RadioAction(
                new ActionAddAssociationRole(
                    Model.getAggregationKind().getAggregate(),
                    false,
                    "button.new-aggregation"));
} 

return actionAggregation;
} 

protected Action getActionUniAggregation()
    { 
if(actionUniAggregation == null)//1
{ 
actionUniAggregation =
                new RadioAction(
                new ActionAddAssociationRole(
                    Model.getAggregationKind().getAggregate(),
                    true,
                    "button.new-uniaggregation"));
} 

return actionUniAggregation;
} 

public void setNamespace(Object handle)
    { 
if(!Model.getFacade().isANamespace(handle))//1
{ 
LOG.error(
                "Illegal argument. Object " + handle + " is not a namespace");
throw new IllegalArgumentException(
                "Illegal argument. Object " + handle + " is not a namespace");
} 

super.setNamespace(handle);
CollabDiagramGraphModel gm = createGraphModel();
gm.setCollaboration(handle);
LayerPerspective lay =
            new LayerPerspectiveMutable(Model.getFacade().getName(handle), gm);
CollabDiagramRenderer rend = new CollabDiagramRenderer();
lay.setGraphNodeRenderer(rend);
lay.setGraphEdgeRenderer(rend);
setLayer(lay);
} 

@Override
    public boolean doesAccept(Object objectToAccept)
    { 
if(Model.getFacade().isAClassifierRole(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAMessage(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAComment(objectToAccept))//1
{ 
return true;
} 
else
if(Model.getFacade().isAClassifier(objectToAccept))//1
{ 
return true;
} 




return false;
} 

@Override
    public String getInstructions(Object droppedObject)
    { 
if(Model.getFacade().isAClassifierRole(droppedObject))//1
{ 
return super.getInstructions(droppedObject);
} 
else
if(Model.getFacade().isAClassifier(droppedObject))//1
{ 
return Translator.localize(
                       "misc.message.click-on-diagram-to-add-as-cr",
                       new Object[] {Model.getFacade().toString(droppedObject)});
} 


return super.getInstructions(droppedObject);
} 

private CollabDiagramGraphModel createGraphModel()
    { 
if((getGraphModel() instanceof CollabDiagramGraphModel))//1
{ 
return (CollabDiagramGraphModel) getGraphModel();
} 
else
{ 
return new CollabDiagramGraphModel();
} 

} 

protected Object[] getUmlActions()
    { 
Object[] actions = {
            getActionClassifierRole(),
            null,
            getAssociationActions(),
            getActionGeneralize(),
            getActionDepend(),
            null,
            getActionMessage(), //this one behaves differently, hence seperated!
        };
return actions;
} 

protected Action getActionDepend()
    { 
if(actionDepend == null)//1
{ 
actionDepend =
                new RadioAction(
                new ActionSetMode(
                    ModeCreatePolyEdge.class,
                    "edgeClass",
                    Model.getMetaTypes().getDependency(),
                    "button.new-dependency"));
} 

return actionDepend;
} 

private Object makeNewCR(Object base)
    { 
Object node = null;
Editor ce = Globals.curEditor();
GraphModel gm = ce.getGraphModel();
if(gm instanceof CollabDiagramGraphModel)//1
{ 
Object collaboration =
                ((CollabDiagramGraphModel) gm).getHomeModel();
node =
                Model.getCollaborationsFactory().buildClassifierRole(
                    collaboration);
} 

Model.getCollaborationsHelper().addBase(node, base);
return node;
} 

public void postLoad()
    { 
super.postLoad();
if(getNamespace() == null)//1
{ 
throw new IllegalStateException(
                "The namespace of the collaboration diagram is not set");
} 

Collection messages;
Iterator msgIterator;
Collection ownedElements =
            Model.getFacade().getOwnedElements(getNamespace());
Iterator oeIterator = ownedElements.iterator();
Layer lay = getLayer();
while (oeIterator.hasNext()) //1
{ 
Object me = oeIterator.next();
if(Model.getFacade().isAAssociationRole(me))//1
{ 
messages = Model.getFacade().getMessages(me);
msgIterator = messages.iterator();
while (msgIterator.hasNext()) //1
{ 
Object message = msgIterator.next();
FigMessage figMessage =
                        (FigMessage) lay.presentationFor(message);
if(figMessage != null)//1
{ 
figMessage.addPathItemToFigAssociationRole(lay);
} 

} 

} 

} 

} 

private Action getActionMessage()
    { 
if(actionMessage == null)//1
{ 
actionMessage = ActionAddMessage.getTargetFollower();
} 

return actionMessage;
} 

protected Action getActionComposition()
    { 
if(actionComposition == null)//1
{ 
actionComposition =
                new RadioAction(
                new ActionAddAssociationRole(
                    Model.getAggregationKind().getComposite(),
                    false,
                    "button.new-composition"));
} 

return actionComposition;
} 

protected Action getActionGeneralize()
    { 
if(actionGeneralize == null)//1
{ 
actionGeneralize =
                new RadioAction(
                new ActionSetMode(
                    ModeCreatePolyEdge.class,
                    "edgeClass",
                    Model.getMetaTypes().getGeneralization(),
                    "button.new-generalization"));
} 

return actionGeneralize;
} 

protected Action getActionUniAssociation()
    { 
if(actionUniAssociation  == null)//1
{ 
actionUniAssociation =
                new RadioAction(
                new ActionAddAssociationRole(
                    Model.getAggregationKind().getNone(),
                    true,
                    "button.new-uniassociation"));
} 

return actionUniAssociation;
} 

protected Action getActionUniComposition()
    { 
if(actionUniComposition == null)//1
{ 
actionUniComposition =
                new RadioAction(
                new ActionAddAssociationRole(
                    Model.getAggregationKind().getComposite(),
                    true,
                    "button.new-unicomposition"));
} 

return actionUniComposition;
} 

public void encloserChanged(FigNode enclosed,
                                FigNode oldEncloser, FigNode newEncloser)
    { 
} 

@Deprecated
    public UMLCollaborationDiagram()
    { 
try //1
{ 
setName(getNewDiagramName());
} 
catch (PropertyVetoException pve) //1
{ 
} 


setGraphModel(createGraphModel());
} 

public String getLabelName()
    { 
return Translator.localize("label.collaboration-diagram");
} 

private FigClassifierRole makeNewFigCR(Object classifierRole,
                                           Point location)
    { 
if(classifierRole != null)//1
{ 
FigClassifierRole newCR = new FigClassifierRole(classifierRole,
                    new Rectangle(location), getDiagramSettings());
getGraphModel().getNodes().add(newCR.getOwner());
return newCR;
} 

return null;
} 

@Override
    public FigNode drop(Object droppedObject, Point location)
    { 
FigNode figNode = null;
GraphModel gm = getGraphModel();
Layer lay = Globals.curEditor().getLayerManager().getActiveLayer();
Rectangle bounds = null;
if(location != null)//1
{ 
bounds = new Rectangle(location.x, location.y, 0, 0);
} 

DiagramSettings settings = getDiagramSettings();
if(Model.getFacade().isAClassifierRole(droppedObject))//1
{ 
figNode = new FigClassifierRole(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAMessage(droppedObject))//1
{ 
figNode = new FigMessage(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAComment(droppedObject))//1
{ 
figNode = new FigComment(droppedObject, bounds, settings);
} 
else
if(Model.getFacade().isAClassifierRole(droppedObject))//1
{ 
figNode = makeNewFigCR(droppedObject, location);
} 
else
if(Model.getFacade().isAClassifier(droppedObject))//1
{ 
figNode = makeNewFigCR(makeNewCR(droppedObject), location);
} 





if(figNode != null)//1
{ 
LOG.debug("Dropped object " + droppedObject + " converted to "
                      + figNode);
} 
else
{ 
LOG.debug("Dropped object NOT added " + droppedObject);
} 

return figNode;
} 

protected Action getActionAssociation()
    { 
if(actionAssociation == null)//1
{ 
actionAssociation =
                new RadioAction(
                new ActionAddAssociationRole(
                    Model.getAggregationKind().getNone(),
                    false,
                    "button.new-associationrole",
                    "Association"));
} 

return actionAssociation;
} 

public boolean isRelocationAllowed(Object base)
    { 
return false;
} 

@SuppressWarnings("unchecked")

    public Collection getRelocationCandidates(Object root)
    { 
Collection c =  new HashSet();
c.add(getOwner());
return c;
} 

@Deprecated
    public UMLCollaborationDiagram(Object collaboration)
    { 
this();
setNamespace(collaboration);
} 

private Action getActionClassifierRole()
    { 
if(actionClassifierRole == null)//1
{ 
actionClassifierRole =
                new RadioAction(new ActionAddClassifierRole());
} 

return actionClassifierRole;
} 

public boolean relocate(Object base)
    { 
return false;
} 

 } 


