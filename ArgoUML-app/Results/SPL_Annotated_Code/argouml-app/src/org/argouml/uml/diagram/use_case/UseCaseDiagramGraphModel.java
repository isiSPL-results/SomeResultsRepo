// Compilation Unit of /UseCaseDiagramGraphModel.java 
 
package org.argouml.uml.diagram.use_case;
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
public class UseCaseDiagramGraphModel extends UMLMutableGraphSupport
 implements VetoableChangeListener
  { 
private static final Logger LOG =
        Logger.getLogger(UseCaseDiagramGraphModel.class);
static final long serialVersionUID = -8516841965639203796L;
public Object getOwner(Object port)
    { 
return port;
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
                     + " to use case diagram.");
} 

if(!canAddEdge(edge))//1
{ 
LOG.info("Attempt to add edge rejected");
return;
} 

getEdges().add(edge);
if(Model.getFacade().isAUMLElement(edge)
                && Model.getFacade().getNamespace(edge) == null)//1
{ 
Model.getCoreHelper().addOwnedElement(getHomeModel(), edge);
} 

fireEdgeAdded(edge);
} 

@Override
    public void addNode(Object node)
    { 
LOG.debug("adding usecase node");
if(!canAddNode(node))//1
{ 
return;
} 

getNodes().add(node);
if(Model.getFacade().isAUMLElement(node)
                && Model.getFacade().getNamespace(node) == null)//1
{ 
Model.getCoreHelper().addOwnedElement(getHomeModel(), node);
} 

fireNodeAdded(node);
} 

public List getOutEdges(Object port)
    { 
return Collections.EMPTY_LIST;
} 

@Override
    public boolean canConnect(Object fromP, Object toP)
    { 
if(Model.getFacade().isAActor(fromP)
                && Model.getFacade().isAActor(toP))//1
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
Object eo = /*(MElementImport)*/ pce.getNewValue();
Object  me = Model.getFacade().getModelElement(eo);
if(oldOwned.contains(eo))//1
{ 
LOG.debug("model removed " + me);
if((Model.getFacade().isAActor(me))
                        || (Model.getFacade().isAUseCase(me)))//1
{ 
removeNode(me);
} 
else
if((Model.getFacade().isAAssociation(me))
                           || (Model.getFacade().isAGeneralization(me))
                           || (Model.getFacade().isAExtend(me))
                           || (Model.getFacade().isAInclude(me))
                           || (Model.getFacade().isADependency(me)))//1
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
    public boolean canAddNode(Object node)
    { 
if(Model.getFacade().isAAssociation(node)
                && !Model.getFacade().isANaryAssociation(node))//1
{ 
return false;
} 

if(super.canAddNode(node))//1
{ 
return true;
} 

if(containsNode(node))//1
{ 
return false;
} 

return Model.getFacade().isAActor(node)
               || Model.getFacade().isAUseCase(node)
               || Model.getFacade().isAPackage(node);
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
Iterator iter = conns.iterator();
if(conns.size() < 2)//1
{ 
return false;
} 

Object associationEnd0 = iter.next();
Object associationEnd1 = iter.next();
if((associationEnd0 == null) || (associationEnd1 == null))//1
{ 
return false;
} 

sourceModelElement = Model.getFacade().getType(associationEnd0);
destModelElement = Model.getFacade().getType(associationEnd1);
} 
else
if(Model.getFacade().isAGeneralization(edge))//1
{ 
sourceModelElement = Model.getFacade().getSpecific(edge);
destModelElement = Model.getFacade().getGeneral(edge);
} 
else
if(Model.getFacade().isAExtend(edge))//1
{ 
sourceModelElement = Model.getFacade().getBase(edge);
destModelElement = Model.getFacade().getExtension(edge);
} 
else
if(Model.getFacade().isAInclude(edge))//1
{ 
sourceModelElement = Model.getFacade().getBase(edge);
destModelElement = Model.getFacade().getAddition(edge);
} 
else
if(Model.getFacade().isADependency(edge))//1
{ 
Collection clients   = Model.getFacade().getClients(edge);
Collection suppliers = Model.getFacade().getSuppliers(edge);
if(clients == null || clients.isEmpty()
                    || suppliers == null || suppliers.isEmpty())//1
{ 
return false;
} 

sourceModelElement = clients.iterator().next();
destModelElement = suppliers.iterator().next();
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

public List getPorts(Object nodeOrEdge)
    { 
if(Model.getFacade().isAActor(nodeOrEdge))//1
{ 
List result = new ArrayList();
result.add(nodeOrEdge);
return result;
} 
else
if(Model.getFacade().isAUseCase(nodeOrEdge))//1
{ 
List result = new ArrayList();
result.add(nodeOrEdge);
return result;
} 


return Collections.EMPTY_LIST;
} 

@Override
    public void addNodeRelatedEdges(Object node)
    { 
super.addNodeRelatedEdges(node);
if(Model.getFacade().isAUseCase(node))//1
{ 
List relations = new ArrayList();
relations.addAll(Model.getFacade().getIncludes(node));
relations.addAll(Model.getFacade().getIncluders(node));
relations.addAll(Model.getFacade().getExtends(node));
relations.addAll(Model.getFacade().getExtenders(node));
for (Object relation : relations) //1
{ 
if(canAddEdge(relation))//1
{ 
addEdge(relation);
} 

} 

} 

if(Model.getFacade().isAClassifier(node))//1
{ 
Collection ends = Model.getFacade().getAssociationEnds(node);
for (Object ae : ends) //1
{ 
if(canAddEdge(Model.getFacade().getAssociation(ae)))//1
{ 
addEdge(Model.getFacade().getAssociation(ae));
} 

} 

} 

if(Model.getFacade().isAGeneralizableElement(node))//1
{ 
Collection gn = Model.getFacade().getGeneralizations(node);
for (Object g : gn) //1
{ 
if(canAddEdge(g))//1
{ 
addEdge(g);
} 

} 

Collection sp = Model.getFacade().getSpecializations(node);
for (Object s : sp) //1
{ 
if(canAddEdge(s))//1
{ 
addEdge(s);
} 

} 

} 

if(Model.getFacade().isAUMLElement(node))//1
{ 
Collection dependencies =
                new ArrayList(Model.getFacade().getClientDependencies(node));
dependencies.addAll(Model.getFacade().getSupplierDependencies(node));
for (Object dependency : dependencies) //1
{ 
if(canAddEdge(dependency))//1
{ 
addEdge(dependency);
} 

} 

} 

} 

public List getInEdges(Object port)
    { 
if(Model.getFacade().isAActor(port)
                || Model.getFacade().isAUseCase(port))//1
{ 
List result = new ArrayList();
Collection ends = Model.getFacade().getAssociationEnds(port);
if(ends == null)//1
{ 
return Collections.EMPTY_LIST;
} 

for (Object ae : ends) //1
{ 
result.add(Model.getFacade().getAssociation(ae));
} 

return result;
} 

return Collections.EMPTY_LIST;
} 

 } 


