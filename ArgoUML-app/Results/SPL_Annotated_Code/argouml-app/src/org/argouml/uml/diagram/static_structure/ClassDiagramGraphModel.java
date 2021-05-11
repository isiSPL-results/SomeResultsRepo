// Compilation Unit of /ClassDiagramGraphModel.java 
 
package org.argouml.uml.diagram.static_structure;
import java.beans.PropertyChangeEvent;
import java.beans.VetoableChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.argouml.model.Model;
import org.argouml.uml.CommentEdge;
import org.argouml.uml.diagram.UMLMutableGraphSupport;
public class ClassDiagramGraphModel extends UMLMutableGraphSupport
 implements VetoableChangeListener
  { 
private static final Logger LOG =
        Logger.getLogger(ClassDiagramGraphModel.class);
static final long serialVersionUID = -2638688086415040146L;
@Override
    public void addNodeRelatedEdges(Object node)
    { 
super.addNodeRelatedEdges(node);
if(Model.getFacade().isAClassifier(node))//1
{ 
Collection ends = Model.getFacade().getAssociationEnds(node);
Iterator iter = ends.iterator();
while (iter.hasNext()) //1
{ 
Object association =
                    Model.getFacade().getAssociation(iter.next());
if(!Model.getFacade().isANaryAssociation(association)
                        && canAddEdge(association))//1
{ 
addEdge(association);
} 

} 

} 

if(Model.getFacade().isAGeneralizableElement(node))//1
{ 
Collection generalizations =
                Model.getFacade().getGeneralizations(node);
Iterator iter = generalizations.iterator();
while (iter.hasNext()) //1
{ 
Object generalization = iter.next();
if(canAddEdge(generalization))//1
{ 
addEdge(generalization);
} 

} 

Collection specializations =
                Model.getFacade().getSpecializations(node);
iter = specializations.iterator();
while (iter.hasNext()) //2
{ 
Object specialization = iter.next();
if(canAddEdge(specialization))//1
{ 
addEdge(specialization);
} 

} 

} 

if(Model.getFacade().isAAssociation(node))//1
{ 
Collection ends = Model.getFacade().getConnections(node);
Iterator iter = ends.iterator();
while (iter.hasNext()) //1
{ 
Object associationEnd = iter.next();
if(canAddEdge(associationEnd))//1
{ 
addEdge(associationEnd);
} 

} 

} 

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

Object sourceModelElement = null;
Object destModelElement = null;
if(Model.getFacade().isAAssociation(edge))//1
{ 
Collection conns = Model.getFacade().getConnections(edge);
if(conns.size() < 2)//1
{ 
LOG.error("Association rejected. Must have at least 2 ends");
return false;
} 

Iterator iter = conns.iterator();
Object associationEnd0 = iter.next();
Object associationEnd1 = iter.next();
if(associationEnd0 == null || associationEnd1 == null)//1
{ 
LOG.error("Association rejected. An end is null");
return false;
} 

sourceModelElement = Model.getFacade().getType(associationEnd0);
destModelElement = Model.getFacade().getType(associationEnd1);
} 
else
if(Model.getFacade().isAAssociationEnd(edge))//1
{ 
sourceModelElement = Model.getFacade().getAssociation(edge);
destModelElement = Model.getFacade().getType(edge);
if(sourceModelElement == null || destModelElement == null)//1
{ 
LOG.error("Association end rejected. An end is null");
return false;
} 

if(!containsEdge(sourceModelElement)
                    && !containsNode(sourceModelElement))//1
{ 
LOG.error("Association end rejected. The source model element ("
                          + sourceModelElement.getClass().getName()
                          + ") must be on the diagram");
return false;
} 

if(!containsNode(destModelElement))//1
{ 
LOG.error("Association end rejected. "
                          + "The destination model element must be "
                          + "on the diagram.");
return false;
} 

} 
else
if(Model.getFacade().isAGeneralization(edge))//1
{ 
sourceModelElement = Model.getFacade().getSpecific(edge);
destModelElement = Model.getFacade().getGeneral(edge);
} 
else
if(Model.getFacade().isADependency(edge))//1
{ 
Collection clients = Model.getFacade().getClients(edge);
Collection suppliers = Model.getFacade().getSuppliers(edge);
if(clients == null || suppliers == null)//1
{ 
return false;
} 

sourceModelElement = clients.iterator().next();
destModelElement = suppliers.iterator().next();
} 
else
if(Model.getFacade().isALink(edge))//1
{ 
Collection roles = Model.getFacade().getConnections(edge);
if(roles.size() < 2)//1
{ 
return false;
} 

Iterator iter = roles.iterator();
Object linkEnd0 = iter.next();
Object linkEnd1 = iter.next();
if(linkEnd0 == null || linkEnd1 == null)//1
{ 
return false;
} 

sourceModelElement = Model.getFacade().getInstance(linkEnd0);
destModelElement = Model.getFacade().getInstance(linkEnd1);
} 
else
if(edge instanceof CommentEdge)//1
{ 
sourceModelElement = ((CommentEdge) edge).getSource();
destModelElement = ((CommentEdge) edge).getDestination();
} 
else
{ 
return false;
} 






if(sourceModelElement == null || destModelElement == null)//1
{ 
LOG.error("Edge rejected. Its ends are not attached to anything");
return false;
} 

if(!containsNode(sourceModelElement)
                && !containsEdge(sourceModelElement))//1
{ 
LOG.error("Edge rejected. Its source end is attached to "
                      + sourceModelElement
                      + " but this is not in the graph model");
return false;
} 

if(!containsNode(destModelElement)
                && !containsEdge(destModelElement))//1
{ 
LOG.error("Edge rejected. Its destination end is attached to "
                      + destModelElement
                      + " but this is not in the graph model");
return false;
} 

return true;
} 

@Override
    public boolean canAddNode(Object node)
    { 
if(Model.getFacade().isAAssociation(node)
                && !Model.getFacade().isANaryAssociation(node))//1
{ 
LOG.debug("A binary association cannot be added as a node");
return false;
} 

if(super.canAddNode(node) && !containsNode(node))//1
{ 
return true;
} 

if(containsNode(node))//1
{ 
LOG.error("Addition of node of type "
                      + node.getClass().getName()
                      + " rejected because its already in the graph model");
return false;
} 

if(Model.getFacade().isAAssociation(node))//1
{ 
Collection ends = Model.getFacade().getConnections(node);
Iterator iter = ends.iterator();
while (iter.hasNext()) //1
{ 
Object classifier =
                    Model.getFacade().getClassifier(iter.next());
if(!containsNode(classifier))//1
{ 
LOG.error("Addition of node of type "
                              + node.getClass().getName()
                              + " rejected because it is connected to a "
                              + "classifier that is not in the diagram");
return false;
} 

} 

return true;
} 

if(Model.getFacade().isAModel(node))//1
{ 
return false;
} 

if(Model.getFacade().isAClassifierRole(node))//1
{ 
return false;
} 

return Model.getFacade().isAClassifier(node)
               || Model.getFacade().isAPackage(node)
               || Model.getFacade().isAStereotype(node)
               || Model.getFacade().isASignal(node)
               || Model.getFacade().isAInstance(node);
} 

public List getOutEdges(Object port)
    { 
List<Object> edges = new ArrayList<Object>();
if(Model.getFacade().isAModelElement(port))//1
{ 
Iterator it =
                Model.getFacade().getClientDependencies(port).iterator();
while (it.hasNext()) //1
{ 
edges.add(it.next());
} 

} 

if(Model.getFacade().isAGeneralizableElement(port))//1
{ 
Iterator it = Model.getFacade().getGeneralizations(port).iterator();
while (it.hasNext()) //1
{ 
edges.add(it.next());
} 

} 

if(Model.getFacade().isAClassifier(port))//1
{ 
Iterator it = Model.getFacade().getAssociationEnds(port).iterator();
while (it.hasNext()) //1
{ 
Object thisEnd = it.next();
Object assoc = Model.getFacade().getAssociation(thisEnd);
if(assoc != null)//1
{ 
Iterator it2 =
                        Model.getFacade().getAssociationEnds(assoc).iterator();
while (it2.hasNext()) //1
{ 
Object nextAssocEnd = it2.next();
if(!thisEnd.equals(nextAssocEnd)
                                && Model.getFacade().isNavigable(
                                    nextAssocEnd))//1
{ 
edges.add(nextAssocEnd);
} 

} 

} 

} 

} 

return edges;
} 

public List getInEdges(Object port)
    { 
List<Object> edges = new ArrayList<Object>();
if(Model.getFacade().isAModelElement(port))//1
{ 
Iterator it =
                Model.getFacade().getSupplierDependencies(port).iterator();
while (it.hasNext()) //1
{ 
edges.add(it.next());
} 

} 

if(Model.getFacade().isAGeneralizableElement(port))//1
{ 
Iterator it = Model.getFacade().getSpecializations(port).iterator();
while (it.hasNext()) //1
{ 
edges.add(it.next());
} 

} 

if(Model.getFacade().isAClassifier(port)
                || Model.getFacade().isAPackage(port))//1
{ 
Iterator it = Model.getFacade().getAssociationEnds(port).iterator();
while (it.hasNext()) //1
{ 
Object nextAssocEnd = it.next();
if(Model.getFacade().isNavigable(nextAssocEnd))//1
{ 
edges.add(nextAssocEnd);
} 

} 

} 

if(Model.getFacade().isAInstance(port))//1
{ 
Iterator it = Model.getFacade().getLinkEnds(port).iterator();
while (it.hasNext()) //1
{ 
edges.add(it.next());
} 

} 

return edges;
} 

@Override
    public void addEdge(Object edge)
    { 
if(edge == null)//1
{ 
throw new IllegalArgumentException("Cannot add a null edge");
} 

if(getDestPort(edge) == null || getSourcePort(edge) == null)//1
{ 
throw new IllegalArgumentException(
                "The source and dest port should be provided on an edge");
} 

if(LOG.isInfoEnabled())//1
{ 
LOG.info("Adding an edge of type "
                     + edge.getClass().getName()
                     + " to class diagram.");
} 

if(!canAddEdge(edge))//1
{ 
LOG.info("Attempt to add edge rejected");
return;
} 

getEdges().add(edge);
if(Model.getFacade().isAModelElement(edge)
                && Model.getFacade().getNamespace(edge) == null
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
    public boolean canChangeConnectedNode(Object newNode, Object oldNode,
                                          Object edge)
    { 
if(newNode == oldNode)//1
{ 
return false;
} 

if(!(Model.getFacade().isAClass(newNode)
                || Model.getFacade().isAClass(oldNode)
                || Model.getFacade().isAAssociation(edge)))//1
{ 
return false;
} 

return true;
} 

public void vetoableChange(PropertyChangeEvent pce)
    { 
if("ownedElement".equals(pce.getPropertyName()))//1
{ 
List oldOwned = (List) pce.getOldValue();
Object elementImport = pce.getNewValue();
Object modelElement =
                Model.getFacade().getModelElement(elementImport);
if(oldOwned.contains(elementImport))//1
{ 
LOG.debug("model removed " + modelElement);
if(Model.getFacade().isAClassifier(modelElement))//1
{ 
removeNode(modelElement);
} 

if(Model.getFacade().isAPackage(modelElement))//1
{ 
removeNode(modelElement);
} 

if(Model.getFacade().isAAssociation(modelElement))//1
{ 
removeEdge(modelElement);
} 

if(Model.getFacade().isADependency(modelElement))//1
{ 
removeEdge(modelElement);
} 

if(Model.getFacade().isAGeneralization(modelElement))//1
{ 
removeEdge(modelElement);
} 

} 
else
{ 
LOG.debug("model added " + modelElement);
} 

} 

} 

@Override
    public void changeConnectedNode(Object newNode, Object oldNode,
                                    Object edge, boolean isSource)
    { 
if(Model.getFacade().isAAssociation(edge))//1
{ 
rerouteAssociation(newNode,  oldNode,  edge,  isSource);
} 
else
if(Model.getFacade().isAGeneralization(edge))//1
{ 
rerouteGeneralization(newNode,  oldNode,  edge,  isSource);
} 
else
if(Model.getFacade().isADependency(edge))//1
{ 
rerouteDependency(newNode,  oldNode,  edge,  isSource);
} 
else
if(Model.getFacade().isALink(edge))//1
{ 
rerouteLink(newNode,  oldNode,  edge,  isSource);
} 




} 

public List<Object> getPorts(Object nodeOrEdge)
    { 
List<Object> res = new ArrayList<Object>();
if(Model.getFacade().isAClassifier(nodeOrEdge))//1
{ 
res.add(nodeOrEdge);
} 

if(Model.getFacade().isAInstance(nodeOrEdge))//1
{ 
res.add(nodeOrEdge);
} 

if(Model.getFacade().isAModel(nodeOrEdge))//1
{ 
res.add(nodeOrEdge);
} 

if(Model.getFacade().isAStereotype(nodeOrEdge))//1
{ 
res.add(nodeOrEdge);
} 

if(Model.getFacade().isASignal(nodeOrEdge))//1
{ 
res.add(nodeOrEdge);
} 

return res;
} 

@Override
    public void addNode(Object node)
    { 
if(!canAddNode(node))//1
{ 
return;
} 

getNodes().add(node);
if(Model.getFacade().isAModelElement(node)
                && Model.getFacade().getNamespace(node) == null)//1
{ 
Model.getCoreHelper().addOwnedElement(getHomeModel(), node);
} 

fireNodeAdded(node);
} 

private void rerouteDependency(Object newNode, Object oldNode,
                                   Object edge, boolean isSource)
    { 
} 

private void rerouteLink(Object newNode, Object oldNode,
                             Object edge, boolean isSource)
    { 
} 

private void rerouteAssociation(Object newNode, Object oldNode,
                                    Object edge, boolean isSource)
    { 
if(!(Model.getFacade().isAClassifier(newNode))
                || !(Model.getFacade().isAClassifier(oldNode)))//1
{ 
return;
} 

Object otherNode = null;
if(isSource)//1
{ 
otherNode = Model.getCoreHelper().getDestination(edge);
} 
else
{ 
otherNode = Model.getCoreHelper().getSource(edge);
} 

if(Model.getFacade().isAInterface(newNode)
                && Model.getFacade().isAInterface(otherNode))//1
{ 
return;
} 

Object edgeAssoc = edge;
Object theEnd = null;
Object theOtherEnd = null;
Collection connections = Model.getFacade().getConnections(edgeAssoc);
Iterator iter = connections.iterator();
if(isSource)//2
{ 
theEnd = iter.next();
theOtherEnd = iter.next();
} 
else
{ 
theOtherEnd = iter.next();
theEnd = iter.next();
} 

Model.getCoreHelper().setType(theEnd, newNode);
} 

private void rerouteGeneralization(Object newNode, Object oldNode,
                                       Object edge, boolean isSource)
    { 
} 

 } 


