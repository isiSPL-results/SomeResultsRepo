// Compilation Unit of /SequenceDiagramGraphModel.java 
 
package org.argouml.uml.diagram.sequence;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import org.apache.log4j.Logger;
import org.argouml.model.DeleteInstanceEvent;
import org.argouml.model.Model;
import org.argouml.uml.CommentEdge;
import org.argouml.uml.diagram.UMLMutableGraphSupport;
import org.argouml.uml.diagram.sequence.ui.FigClassifierRole;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.Mode;
import org.tigris.gef.base.ModeManager;
public class SequenceDiagramGraphModel extends UMLMutableGraphSupport
 implements VetoableChangeListener
, PropertyChangeListener
  { 
private static final Logger LOG =
        Logger.getLogger(SequenceDiagramGraphModel.class);
private Object collaboration;
private Object interaction;
private static final long serialVersionUID = -3799402191353570488L;
public SequenceDiagramGraphModel()
    { 
} 

public Object getCollaboration()
    { 
if(collaboration == null)//1
{ 
collaboration =
                Model.getCollaborationsFactory().buildCollaboration(
                    getProject().getRoot());
} 

return collaboration;
} 

public List getInEdges(Object port)
    { 
List res = new ArrayList();
if(Model.getFacade().isAClassifierRole(port))//1
{ 
res.addAll(Model.getFacade().getSentMessages(port));
} 

return res;
} 

public void addEdge(Object edge)
    { 
if(canAddEdge(edge))//1
{ 
getEdges().add(edge);
fireEdgeAdded(edge);
} 

} 

public boolean canConnect(Object fromP, Object toP, Object edgeType)
    { 
if(edgeType == CommentEdge.class
                && (Model.getFacade().isAComment(fromP)
                    || Model.getFacade().isAComment(toP))
                && !(Model.getFacade().isAComment(fromP)
                     && Model.getFacade().isAComment(toP)))//1
{ 
return true;
} 

if(!(fromP instanceof MessageNode) || !(toP instanceof MessageNode))//1
{ 
return false;
} 

if(fromP == toP)//1
{ 
return false;
} 

MessageNode nodeFrom = (MessageNode) fromP;
MessageNode nodeTo = (MessageNode) toP;
if(nodeFrom.getFigClassifierRole() == nodeTo.getFigClassifierRole())//1
{ 
FigClassifierRole fig = nodeFrom.getFigClassifierRole();
if(fig.getIndexOf(nodeFrom) >= fig.getIndexOf(nodeTo))//1
{ 
return false;
} 

} 

Editor curEditor = Globals.curEditor();
ModeManager modeManager = curEditor.getModeManager();
Mode mode = modeManager.top();
Hashtable args = mode.getArgs();
Object actionType = args.get("action");
if(Model.getMetaTypes().getCallAction().equals(actionType))//1
{ 
return nodeFrom.canCall() && nodeTo.canBeCalled();
} 
else
if(Model.getMetaTypes().getReturnAction().equals(actionType))//1
{ 
return nodeTo.canBeReturnedTo()
                   && nodeFrom.canReturn(nodeTo.getClassifierRole());
} 
else
if(Model.getMetaTypes().getCreateAction().equals(actionType))//1
{ 
if(nodeFrom.getFigClassifierRole()
                    == nodeTo.getFigClassifierRole())//1
{ 
return false;
} 

return nodeFrom.canCreate() && nodeTo.canBeCreated();
} 
else
if(Model.getMetaTypes().getDestroyAction().equals(actionType))//1
{ 
return nodeFrom.canDestroy() && nodeTo.canBeDestroyed();
} 




return false;
} 

public Object getHomeModel()
    { 
return getCollaboration();
} 

private Object getInteraction()
    { 
if(interaction == null)//1
{ 
interaction =
                Model.getCollaborationsFactory().buildInteraction(
                    collaboration);
Model.getPump().addModelEventListener(this, interaction);
} 

return interaction;
} 

public List getPorts(Object nodeOrEdge)
    { 
List ports = new ArrayList();
if(Model.getFacade().isAClassifierRole(nodeOrEdge))//1
{ 
ports.addAll(Model.getFacade().getReceivedMessages(nodeOrEdge));
ports.addAll(Model.getFacade().getSentMessages(nodeOrEdge));
} 
else
if(Model.getFacade().isAMessage(nodeOrEdge))//1
{ 
ports.add(Model.getFacade().getSender(nodeOrEdge));
ports.add(Model.getFacade().getReceiver(nodeOrEdge));
} 


return ports;
} 

public void addNode(Object node)
    { 
if(canAddNode(node))//1
{ 
getNodes().add(node);
fireNodeAdded(node);
} 

} 

public void setCollaboration(Object c)
    { 
collaboration = c;
Collection interactions = Model.getFacade().getInteractions(c);
if(!interactions.isEmpty())//1
{ 
interaction = interactions.iterator().next();
} 

} 

public Object getOwner(Object port)
    { 
return port;
} 

public void propertyChange(PropertyChangeEvent evt)
    { 
if(evt instanceof DeleteInstanceEvent
                && evt.getSource() == interaction)//1
{ 
Model.getPump().removeModelEventListener(this, interaction);
interaction = null;
} 

} 

public void setHomeModel(Object namespace)
    { 
if(!Model.getFacade().isANamespace(namespace))//1
{ 
throw new IllegalArgumentException(
                "A sequence diagram home model must be a namespace, "
                + "received a "
                + namespace);
} 

setCollaboration(namespace);
super.setHomeModel(namespace);
} 

public boolean canAddEdge(Object edge)
    { 
if(edge == null)//1
{ 
return false;
} 

if(getEdges().contains(edge))//1
{ 
return false;
} 

Object end0 = null;
Object end1 = null;
if(Model.getFacade().isAMessage(edge))//1
{ 
end0 = Model.getFacade().getSender(edge);
end1 = Model.getFacade().getReceiver(edge);
} 
else
if(edge instanceof CommentEdge)//1
{ 
end0 = ((CommentEdge) edge).getSource();
end1 = ((CommentEdge) edge).getDestination();
} 
else
{ 
return false;
} 


if(end0 == null || end1 == null)//1
{ 
LOG.error("Edge rejected. Its ends are not attached to anything");
return false;
} 

if(!containsNode(end0) && !containsEdge(end0))//1
{ 
LOG.error("Edge rejected. Its source end is attached to "
                      + end0
                      + " but this is not in the graph model");
return false;
} 

if(!containsNode(end1) && !containsEdge(end1))//1
{ 
LOG.error("Edge rejected. Its destination end is attached to "
                      + end1
                      + " but this is not in the graph model");
return false;
} 

return true;
} 

public void vetoableChange(PropertyChangeEvent pce)
    { 
if("ownedElement".equals(pce.getPropertyName()))//1
{ 
List oldOwned = (List) pce.getOldValue();
Object eo = pce.getNewValue();
Object me = Model.getFacade().getModelElement(eo);
if(oldOwned.contains(eo))//1
{ 
LOG.debug("model removed " + me);
if(Model.getFacade().isAClassifierRole(me))//1
{ 
removeNode(me);
} 

if(Model.getFacade().isAMessage(me))//1
{ 
removeEdge(me);
} 

} 
else
{ 
LOG.debug("model added " + me);
} 

} 

} 

public List getOutEdges(Object port)
    { 
List res = new ArrayList();
if(Model.getFacade().isAClassifierRole(port))//1
{ 
res.addAll(Model.getFacade().getReceivedMessages(port));
} 

return res;
} 

@Override
    public Object connect(Object fromPort, Object toPort, Object edgeType)
    { 
if(!canConnect(fromPort, toPort, edgeType))//1
{ 
return null;
} 

if(edgeType == CommentEdge.class)//1
{ 
return super.connect(fromPort, toPort, edgeType);
} 

Object edge = null;
Object fromObject = null;
Object toObject = null;
Object action = null;
if(Model.getMetaTypes().getMessage().equals(edgeType))//1
{ 
Editor curEditor = Globals.curEditor();
ModeManager modeManager = curEditor.getModeManager();
Mode mode = modeManager.top();
Hashtable args = mode.getArgs();
Object actionType = args.get("action");
if(Model.getMetaTypes().getCallAction().equals(actionType))//1
{ 
if(fromPort instanceof MessageNode
                        && toPort instanceof MessageNode)//1
{ 
fromObject = ((MessageNode) fromPort).getClassifierRole();
toObject = ((MessageNode) toPort).getClassifierRole();
action =
                        Model.getCommonBehaviorFactory()
                        .createCallAction();
} 

} 
else
if(Model.getMetaTypes().getCreateAction()
                       .equals(actionType))//1
{ 
if(fromPort instanceof MessageNode
                        && toPort instanceof MessageNode)//1
{ 
fromObject = ((MessageNode) fromPort).getClassifierRole();
toObject = ((MessageNode) toPort).getClassifierRole();
action =
                        Model.getCommonBehaviorFactory()
                        .createCreateAction();
} 

} 
else
if(Model.getMetaTypes().getReturnAction()
                       .equals(actionType))//1
{ 
if(fromPort instanceof MessageNode
                        && toPort instanceof MessageNode)//1
{ 
fromObject = ((MessageNode) fromPort).getClassifierRole();
toObject = ((MessageNode) toPort).getClassifierRole();
action =
                        Model.getCommonBehaviorFactory()
                        .createReturnAction();
} 

} 
else
if(Model.getMetaTypes().getDestroyAction()
                       .equals(actionType))//1
{ 
if(fromPort instanceof MessageNode
                        && toPort instanceof MessageNode)//1
{ 
fromObject = ((MessageNode) fromPort).getClassifierRole();
toObject = ((MessageNode) fromPort).getClassifierRole();
action =
                        Model.getCommonBehaviorFactory()
                        .createDestroyAction();
} 

} 
else
if(Model.getMetaTypes().getSendAction()
                       .equals(actionType))//1
{ 
} 
else
if(Model.getMetaTypes().getTerminateAction()
                       .equals(actionType))//1
{ 
} 






} 

if(fromObject != null && toObject != null && action != null)//1
{ 
Object associationRole =
                Model.getCollaborationsHelper().getAssociationRole(
                    fromObject,
                    toObject);
if(associationRole == null)//1
{ 
associationRole =
                    Model.getCollaborationsFactory().buildAssociationRole(
                        fromObject, toObject);
} 

Object message =
                Model.getCollaborationsFactory().buildMessage(
                    getInteraction(),
                    associationRole);
if(action != null)//1
{ 
Model.getCollaborationsHelper().setAction(message, action);
Model.getCoreHelper().setNamespace(action, getCollaboration());
} 

Model.getCollaborationsHelper()
            .setSender(message, fromObject);
Model.getCommonBehaviorHelper()
            .setReceiver(message, toObject);
addEdge(message);
edge = message;
} 

if(edge == null)//1
{ 
LOG.debug("Incorrect edge");
} 

return edge;
} 

public boolean canAddNode(Object node)
    { 
if(node == null)//1
{ 
return false;
} 

return !getNodes().contains(node)
               && Model.getFacade().isAModelElement(node)
               && Model.getFacade().getNamespace(node) == getCollaboration();
} 

 } 


