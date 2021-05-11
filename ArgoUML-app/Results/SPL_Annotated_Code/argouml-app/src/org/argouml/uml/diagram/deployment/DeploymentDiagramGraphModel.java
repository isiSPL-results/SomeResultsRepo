// Compilation Unit of /DeploymentDiagramGraphModel.java 
 
package org.argouml.uml.diagram.deployment;
import java.beans.PropertyChangeEvent;
import java.beans.VetoableChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
import org.argouml.model.Model;
import org.argouml.uml.CommentEdge;
import org.argouml.uml.diagram.UMLMutableGraphSupport;
public class DeploymentDiagramGraphModel extends UMLMutableGraphSupport
 implements VetoableChangeListener
  { 
private static final Logger LOG =
        Logger.getLogger(DeploymentDiagramGraphModel.class);
static final long serialVersionUID = 1003748292917485298L;
@Override
    public void addNode(Object node)
    { 
LOG.debug("adding class node!!");
if(!canAddNode(node))//1
{ 
return;
} 

getNodes().add(node);
if(Model.getFacade().isAModelElement(node)
                && (Model.getFacade().getNamespace(node) == null))//1
{ 
Model.getCoreHelper().addOwnedElement(getHomeModel(), node);
} 

fireNodeAdded(node);
} 

@Override
    public boolean canAddNode(Object node)
    { 
if(node == null)//1
{ 
return false;
} 

if(Model.getFacade().isAAssociation(node)
                && !Model.getFacade().isANaryAssociation(node))//1
{ 
return false;
} 

if(containsNode(node))//1
{ 
return false;
} 

if(Model.getFacade().isAAssociation(node))//1
{ 
Collection ends = Model.getFacade().getConnections(node);
boolean canAdd = true;
for (Object end : ends) //1
{ 
Object classifier =
                    Model.getFacade().getClassifier(end);
if(!containsNode(classifier))//1
{ 
canAdd = false;
break;

} 

} 

return canAdd;
} 

return (Model.getFacade().isANode(node))
               || (Model.getFacade().isAComponent(node))
               || (Model.getFacade().isAClass(node))
               || (Model.getFacade().isAInterface(node))
               || (Model.getFacade().isAObject(node))
               || (Model.getFacade().isANodeInstance(node))
               || (Model.getFacade().isAComponentInstance(node)
                   || (Model.getFacade().isAComment(node)));
} 

@Override
    public boolean canAddEdge(Object edge)
    { 
if(edge == null)//1
{ 
return false;
} 

if(containsEdge(edge))//1
{ 
return false;
} 

Object end0 = null, end1 = null;
if(edge instanceof CommentEdge)//1
{ 
end0 = ((CommentEdge) edge).getSource();
end1 = ((CommentEdge) edge).getDestination();
} 
else
if(Model.getFacade().isAAssociationEnd(edge))//1
{ 
end0 = Model.getFacade().getAssociation(edge);
end1 = Model.getFacade().getType(edge);
return (end0 != null
                    && end1 != null
                    && (containsEdge(end0) || containsNode(end0))
                    && containsNode(end1));
} 
else
if(Model.getFacade().isARelationship(edge))//1
{ 
end0 = Model.getCoreHelper().getSource(edge);
end1 = Model.getCoreHelper().getDestination(edge);
} 
else
if(Model.getFacade().isALink(edge))//1
{ 
end0 = Model.getCommonBehaviorHelper().getSource(edge);
end1 =
                Model.getCommonBehaviorHelper().getDestination(edge);
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

public List getInEdges(Object port)
    { 
List res = new ArrayList();
if(Model.getFacade().isANode(port))//1
{ 
Collection ends = Model.getFacade().getAssociationEnds(port);
if(ends == null)//1
{ 
return Collections.EMPTY_LIST;
} 

for (Object end : ends) //1
{ 
res.add(Model.getFacade().getAssociation(end));
} 

} 

if(Model.getFacade().isANodeInstance(port))//1
{ 
Object noi = port;
Collection ends = Model.getFacade().getLinkEnds(noi);
res.addAll(ends);
} 

if(Model.getFacade().isAComponent(port))//1
{ 
Collection ends = Model.getFacade().getAssociationEnds(port);
if(ends == null)//1
{ 
return Collections.EMPTY_LIST;
} 

for (Object end : ends) //1
{ 
res.add(Model.getFacade().getAssociation(end));
} 

} 

if(Model.getFacade().isAComponentInstance(port))//1
{ 
Object coi = port;
Collection ends = Model.getFacade().getLinkEnds(coi);
res.addAll(ends);
} 

if(Model.getFacade().isAClass(port))//1
{ 
Collection ends = Model.getFacade().getAssociationEnds(port);
if(ends == null)//1
{ 
return Collections.EMPTY_LIST;
} 

for (Object end : ends) //1
{ 
res.add(Model.getFacade().getAssociation(end));
} 

} 

if(Model.getFacade().isAInterface(port))//1
{ 
Collection ends = Model.getFacade().getAssociationEnds(port);
if(ends == null)//1
{ 
return Collections.EMPTY_LIST;
} 

for (Object end : ends) //1
{ 
res.add(Model.getFacade().getAssociation(end));
} 

} 

if(Model.getFacade().isAObject(port))//1
{ 
Object clo = port;
Collection ends = Model.getFacade().getLinkEnds(clo);
res.addAll(ends);
} 

return res;
} 

public List getOutEdges(Object port)
    { 
return Collections.EMPTY_LIST;
} 

public List getPorts(Object nodeOrEdge)
    { 
List res = new ArrayList();
if(Model.getFacade().isANode(nodeOrEdge))//1
{ 
res.add(nodeOrEdge);
} 

if(Model.getFacade().isANodeInstance(nodeOrEdge))//1
{ 
res.add(nodeOrEdge);
} 

if(Model.getFacade().isAComponent(nodeOrEdge))//1
{ 
res.add(nodeOrEdge);
} 

if(Model.getFacade().isAComponentInstance(nodeOrEdge))//1
{ 
res.add(nodeOrEdge);
} 

if(Model.getFacade().isAClass(nodeOrEdge))//1
{ 
res.add(nodeOrEdge);
} 

if(Model.getFacade().isAInterface(nodeOrEdge))//1
{ 
res.add(nodeOrEdge);
} 

if(Model.getFacade().isAObject(nodeOrEdge))//1
{ 
res.add(nodeOrEdge);
} 

return res;
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
if(Model.getFacade().isANode(me))//1
{ 
removeNode(me);
} 

if(Model.getFacade().isANodeInstance(me))//1
{ 
removeNode(me);
} 

if(Model.getFacade().isAComponent(me))//1
{ 
removeNode(me);
} 

if(Model.getFacade().isAComponentInstance(me))//1
{ 
removeNode(me);
} 

if(Model.getFacade().isAClass(me))//1
{ 
removeNode(me);
} 

if(Model.getFacade().isAInterface(me))//1
{ 
removeNode(me);
} 

if(Model.getFacade().isAObject(me))//1
{ 
removeNode(me);
} 

if(Model.getFacade().isAAssociation(me))//1
{ 
removeEdge(me);
} 

if(Model.getFacade().isADependency(me))//1
{ 
removeEdge(me);
} 

if(Model.getFacade().isALink(me))//1
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

@Override
    public void addEdge(Object edge)
    { 
LOG.debug("adding class edge!!!!!!");
if(!canAddEdge(edge))//1
{ 
return;
} 

getEdges().add(edge);
if(Model.getFacade().isAModelElement(edge)
                && !Model.getFacade().isAAssociationEnd(edge))//1
{ 
Model.getCoreHelper().addOwnedElement(getHomeModel(), edge);
} 

fireEdgeAdded(edge);
} 

public Object getOwner(Object port)
    { 
return port;
} 

@Override
    public void addNodeRelatedEdges(Object node)
    { 
super.addNodeRelatedEdges(node);
if(Model.getFacade().isAClassifier(node))//1
{ 
Collection ends = Model.getFacade().getAssociationEnds(node);
for (Object ae : ends) //1
{ 
if(!Model.getFacade().isANaryAssociation(
                            Model.getFacade().getAssociation(ae))
                        && canAddEdge(Model.getFacade().getAssociation(ae)))//1
{ 
addEdge(Model.getFacade().getAssociation(ae));
} 

return;
} 

} 

if(Model.getFacade().isAAssociation(node))//1
{ 
Collection ends = Model.getFacade().getConnections(node);
for (Object associationEnd : ends) //1
{ 
if(canAddEdge(associationEnd))//1
{ 
addEdge(associationEnd);
} 

} 

} 

if(Model.getFacade().isAInstance(node))//1
{ 
Collection ends = Model.getFacade().getLinkEnds(node);
for (Object end : ends) //1
{ 
Object link = Model.getFacade().getLink(end);
if(canAddEdge(link))//1
{ 
addEdge(link);
} 

return;
} 

} 

if(Model.getFacade().isAGeneralizableElement(node))//1
{ 
Collection generalizations =
                Model.getFacade().getGeneralizations(node);
for (Object generalization : generalizations) //1
{ 
if(canAddEdge(generalization))//1
{ 
addEdge(generalization);
} 

return;
} 

Collection specializations =
                Model.getFacade().getSpecializations(node);
for (Object specialization : specializations) //1
{ 
if(canAddEdge(specialization))//1
{ 
addEdge(specialization);
} 

return;
} 

} 

if(Model.getFacade().isAModelElement(node))//1
{ 
List dependencies =
                new ArrayList(Model.getFacade().getClientDependencies(node));
dependencies.addAll(Model.getFacade().getSupplierDependencies(node));
for (Object dependency : dependencies) //1
{ 
if(canAddEdge(dependency))//1
{ 
addEdge(dependency);
} 

return;
} 

} 

} 

 } 


