// Compilation Unit of /CollabDiagramGraphModel.java 
 
package org.argouml.uml.diagram.collaboration;
import java.beans.PropertyChangeEvent;
import java.beans.VetoableChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.argouml.model.Model;
import org.argouml.uml.CommentEdge;
import org.argouml.uml.diagram.UMLMutableGraphSupport;
public class CollabDiagramGraphModel extends UMLMutableGraphSupport
 implements VetoableChangeListener
  { 
private static final Logger LOG =
        Logger.getLogger(CollabDiagramGraphModel.class);
private static final long serialVersionUID = -4895696235473642985L;
public void vetoableChange(PropertyChangeEvent pce)
    { 
if("ownedElement".equals(pce.getPropertyName()))//1
{ 
List oldOwned = (List) pce.getOldValue();
Object eo = /*(MElementImport)*/ pce.getNewValue();
Object me = Model.getFacade().getModelElement(eo);
if(oldOwned.contains(eo))//1
{ 
LOG.debug("model removed " + me);
if(Model.getFacade().isAClassifier(me))//1
{ 
removeNode(me);
} 

if(Model.getFacade().isAMessage(me))//1
{ 
removeNode(me);
} 

if(Model.getFacade().isAAssociation(me))//1
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
    public void addNode(Object node)
    { 
LOG.debug("adding MClassifierRole node!!");
if(!canAddNode(node))//1
{ 
return;
} 

getNodes().add(node);
if(Model.getFacade().isAClassifier(node))//1
{ 
Model.getCoreHelper().addOwnedElement(getHomeModel(), node);
} 

fireNodeAdded(node);
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
                && Model.getFacade().getNamespace(edge) == null)//1
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
for (Object end : ends) //1
{ 
if(canAddEdge(Model.getFacade().getAssociation(end)))//1
{ 
addEdge(Model.getFacade().getAssociation(end));
} 

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
return;
} 

} 

Collection specializations = Model.getFacade().getSpecializations(node);
for (Object specialization : specializations) //1
{ 
if(canAddEdge(specialization))//1
{ 
addEdge(specialization);
return;
} 

} 

} 

if(Model.getFacade().isAModelElement(node))//1
{ 
Collection dependencies =
                new ArrayList(Model.getFacade().getClientDependencies(node));
dependencies.addAll(Model.getFacade().getSupplierDependencies(node));
for (Object dependency : dependencies) //1
{ 
if(canAddEdge(dependency))//1
{ 
addEdge(dependency);
return;
} 

} 

} 

} 

public List getInEdges(Object port)
    { 
if(Model.getFacade().isAClassifierRole(port))//1
{ 
Object cr = port;
Collection ends = Model.getFacade().getAssociationEnds(cr);
if(ends == null)//1
{ 
return Collections.EMPTY_LIST;
} 

List result = new ArrayList();
for (Object end : ends) //1
{ 
result.add(Model.getFacade().getAssociation(end));
} 

} 

return Collections.EMPTY_LIST;
} 

public List getPorts(Object nodeOrEdge)
    { 
if(Model.getFacade().isAClassifierRole(nodeOrEdge))//1
{ 
List result = new ArrayList();
result.add(nodeOrEdge);
return result;
} 

return Collections.EMPTY_LIST;
} 

public void setCollaboration(Object collaboration)
    { 
try //1
{ 
if(collaboration == null)//1
{ 
throw new IllegalArgumentException(
                    "A null collaboration was supplied");
} 

if(!(Model.getFacade().isACollaboration(collaboration)))//1
{ 
throw new IllegalArgumentException(
                    "Expected a collaboration. The type received was "
                    + collaboration.getClass().getName());
} 

} 
catch (IllegalArgumentException e) //1
{ 
LOG.error("Illegal Argument to setCollaboration", e);
throw e;
} 


setHomeModel(collaboration);
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

return (Model.getFacade().isAClassifierRole(node)
                || Model.getFacade().isAMessage(node)
                || Model.getFacade().isAComment(node));
} 

public List getOutEdges(Object port)
    { 
return Collections.EMPTY_LIST;
} 

@Override
    public boolean canConnect(Object fromP, Object toP)
    { 
if((Model.getFacade().isAClassifierRole(fromP))
                && (Model.getFacade().isAClassifierRole(toP)))//1
{ 
return true;
} 

return false;
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

Object end0 = null;
Object end1 = null;
if(Model.getFacade().isAAssociationRole(edge))//1
{ 
Collection conns = Model.getFacade().getConnections(edge);
Iterator iter = conns.iterator();
if(conns.size() < 2)//1
{ 
return false;
} 

Object associationEndRole0 = iter.next();
Object associationEndRole1 = iter.next();
if(associationEndRole0 == null || associationEndRole1 == null)//1
{ 
return false;
} 

end0 = Model.getFacade().getType(associationEndRole0);
end1 = Model.getFacade().getType(associationEndRole1);
} 
else
if(Model.getFacade().isAGeneralization(edge))//1
{ 
Object gen = /*(MGeneralization)*/ edge;
end0 = Model.getFacade().getGeneral(gen);
end1 = Model.getFacade().getSpecific(gen);
} 
else
if(Model.getFacade().isADependency(edge))//1
{ 
Collection clients = Model.getFacade().getClients(edge);
Collection suppliers = Model.getFacade().getSuppliers(edge);
if(clients == null || clients.isEmpty()
                    || suppliers == null || suppliers.isEmpty())//1
{ 
return false;
} 

end0 = clients.iterator().next();
end1 = suppliers.iterator().next();
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
LOG.error("Edge rejected. Its source end is attached to " + end0
                      + " but this is not in the graph model");
return false;
} 

if(!containsNode(end1)
                && !containsEdge(end1))//1
{ 
LOG.error("Edge rejected. Its destination end is attached to "
                      + end1 + " but this is not in the graph model");
return false;
} 

return true;
} 

 } 


