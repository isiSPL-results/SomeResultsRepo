// Compilation Unit of /StateDiagramGraphModel.java 
 
package org.argouml.uml.diagram.state;
import java.beans.PropertyChangeEvent;
import java.beans.VetoableChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.uml.CommentEdge;
import org.argouml.uml.diagram.UMLMutableGraphSupport;
import org.tigris.gef.presentation.Fig;
public class StateDiagramGraphModel extends UMLMutableGraphSupport
 implements VetoableChangeListener
  { 
private static final Logger LOG =
        Logger.getLogger(StateDiagramGraphModel.class);
private Object machine;
static final long serialVersionUID = -8056507319026044174L;
public void changeConnectedNode(Object newNode, Object oldNode,
                                    Object edge, boolean isSource)
    { 
if(isSource)//1
{ 
Model.getStateMachinesHelper().setSource(edge, newNode);
} 
else
{ 
Model.getCommonBehaviorHelper().setTarget(edge, newNode);
} 

} 

public void addNodeRelatedEdges(Object node)
    { 
super.addNodeRelatedEdges(node);
if(Model.getFacade().isAStateVertex(node))//1
{ 
Collection transen =
                new ArrayList(Model.getFacade().getOutgoings(node));
transen.addAll(Model.getFacade().getIncomings(node));
Iterator iter = transen.iterator();
while (iter.hasNext()) //1
{ 
Object dep = /* (MTransition) */iter.next();
if(canAddEdge(dep))//1
{ 
addEdge(dep);
} 

} 

} 

} 

public List getInEdges(Object port)
    { 
if(Model.getFacade().isAStateVertex(port))//1
{ 
return new ArrayList(Model.getFacade().getIncomings(port));
} 

LOG.debug("TODO: getInEdges of MState");
return Collections.EMPTY_LIST;
} 

public void setMachine(Object sm)
    { 
if(!Model.getFacade().isAStateMachine(sm))//1
{ 
throw new IllegalArgumentException();
} 

if(sm != null)//1
{ 
machine = sm;
} 

} 

public void addEdge(Object edge)
    { 
LOG.debug("adding statechart/activity diagram edge!!!!!!");
if(!canAddEdge(edge))//1
{ 
return;
} 

getEdges().add(edge);
fireEdgeAdded(edge);
} 

public boolean canChangeConnectedNode(Object newNode, Object oldNode,
                                          Object edge)
    { 
if(newNode == oldNode)//1
{ 
return false;
} 

if(!(Model.getFacade().isAState(newNode)
                || Model.getFacade().isAState(oldNode)
                || Model.getFacade().isATransition(edge)))//1
{ 
return false;
} 

Object otherSideNode = Model.getFacade().getSource(edge);
if(otherSideNode == oldNode)//1
{ 
otherSideNode = Model.getFacade().getTarget(edge);
} 

if(Model.getFacade().isACompositeState(newNode)
                && Model.getStateMachinesHelper().getAllSubStates(newNode)
                .contains(otherSideNode))//1
{ 
return false;
} 

return true;
} 

public List getOutEdges(Object port)
    { 
if(Model.getFacade().isAStateVertex(port))//1
{ 
return new ArrayList(Model.getFacade().getOutgoings(port));
} 

LOG.debug("TODO: getOutEdges of MState");
return Collections.EMPTY_LIST;
} 

public void vetoableChange(PropertyChangeEvent pce)
    { 
if("ownedElement".equals(pce.getPropertyName()))//1
{ 
Collection oldOwned = (Collection) pce.getOldValue();
Object eo = /* (MElementImport) */pce.getNewValue();
Object me = Model.getFacade().getModelElement(eo);
if(oldOwned.contains(eo))//1
{ 
LOG.debug("model removed " + me);
if(Model.getFacade().isAState(me))//1
{ 
removeNode(me);
} 

if(Model.getFacade().isAPseudostate(me))//1
{ 
removeNode(me);
} 

if(Model.getFacade().isATransition(me))//1
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

public boolean isRemoveFromDiagramAllowed(Collection figs)
    { 
if(figs.isEmpty())//1
{ 
return false;
} 

Iterator i = figs.iterator();
while (i.hasNext()) //1
{ 
Object obj = i.next();
if(!(obj instanceof Fig))//1
{ 
return false;
} 

Object uml = ((Fig) obj).getOwner();
if(uml != null)//1
{ 
return false;
} 

} 

return true;
} 

public List getPorts(Object nodeOrEdge)
    { 
List res = new ArrayList();
if(Model.getFacade().isAState(nodeOrEdge))//1
{ 
res.add(nodeOrEdge);
} 

if(Model.getFacade().isAPseudostate(nodeOrEdge))//1
{ 
res.add(nodeOrEdge);
} 

return res;
} 

public Object connect(Object fromPort, Object toPort,
                          Object edgeClass)
    { 
if(Model.getFacade().isAFinalState(fromPort))//1
{ 
return null;
} 

if(Model.getFacade().isAPseudostate(toPort)
                && Model.getPseudostateKind().getInitial().equals(
                    Model.getFacade().getKind(toPort)))//1
{ 
return null;
} 

if(Model.getMetaTypes().getTransition().equals(edgeClass))//1
{ 
Object tr = null;
tr =
                Model.getStateMachinesFactory()
                .buildTransition(fromPort, toPort);
if(canAddEdge(tr))//1
{ 
addEdge(tr);
} 
else
{ 
ProjectManager.getManager().getCurrentProject().moveToTrash(tr);
tr = null;
} 

return tr;
} 
else
if(edgeClass == CommentEdge.class)//1
{ 
try //1
{ 
Object connection =
                    buildConnection(
                        edgeClass, fromPort, null, toPort, null, null,
                        ProjectManager.getManager().getCurrentProject()
                        .getModel());
addEdge(connection);
return connection;
} 
catch (Exception ex) //1
{ 
LOG.error("buildConnection() failed", ex);
} 


return null;
} 
else
{ 
LOG.debug("wrong kind of edge in StateDiagram connect3 "
                      + edgeClass);
return null;
} 


} 

public Object getMachine()
    { 
return machine;
} 

public boolean canAddEdge(Object edge)
    { 
if(super.canAddEdge(edge))//1
{ 
return true;
} 

if(edge == null)//1
{ 
return false;
} 

if(containsEdge(edge))//1
{ 
return false;
} 

Object end0 = null;
Object end1 = null;
if(Model.getFacade().isATransition(edge))//1
{ 
end0 = Model.getFacade().getSource(edge);
end1 = Model.getFacade().getTarget(edge);
if(Model.getFacade().isACompositeState(end0)
                    && Model.getStateMachinesHelper().getAllSubStates(end0)
                    .contains(end1))//1
{ 
return false;
} 

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

if(!containsNode(end0)
                && !containsEdge(end0))//1
{ 
LOG.error("Edge rejected. Its source end is attached to "
                      + end0
                      + " but this is not in the graph model");
return false;
} 

if(!containsNode(end1)
                && !containsEdge(end1))//1
{ 
LOG.error("Edge rejected. Its destination end is attached to "
                      + end1
                      + " but this is not in the graph model");
return false;
} 

return true;
} 

public void addNode(Object node)
    { 
LOG.debug("adding statechart/activity diagram node: " + node);
if(!canAddNode(node))//1
{ 
return;
} 

if(containsNode(node))//1
{ 
return;
} 

getNodes().add(node);
if(Model.getFacade().isAStateVertex(node))//1
{ 
Object top = Model.getStateMachinesHelper().getTop(getMachine());
Model.getStateMachinesHelper().addSubvertex(top, node);
} 

fireNodeAdded(node);
} 

public Object getOwner(Object port)
    { 
return port;
} 

public boolean canConnect(Object fromPort, Object toPort)
    { 
if(!(Model.getFacade().isAStateVertex(fromPort)))//1
{ 
LOG.error("internal error not from sv");
return false;
} 

if(!(Model.getFacade().isAStateVertex(toPort)))//1
{ 
LOG.error("internal error not to sv");
return false;
} 

if(Model.getFacade().isAFinalState(fromPort))//1
{ 
return false;
} 

if(Model.getFacade().isAPseudostate(toPort))//1
{ 
if((Model.getPseudostateKind().getInitial()).equals(
                        Model.getFacade().getKind(toPort)))//1
{ 
return false;
} 

} 

return true;
} 

public boolean canAddNode(Object node)
    { 
if(node == null
                || !Model.getFacade().isAModelElement(node)
                || containsNode(node))//1
{ 
return false;
} 

if(Model.getFacade().isAComment(node))//1
{ 
return true;
} 

if(Model.getFacade().isAStateVertex(node)
                || Model.getFacade().isAPartition(node))//1
{ 
Object nodeMachine =
                Model.getStateMachinesHelper().getStateMachine(node);
if(nodeMachine == null || nodeMachine == getMachine())//1
{ 
return true;
} 

} 

return false;
} 

 } 


