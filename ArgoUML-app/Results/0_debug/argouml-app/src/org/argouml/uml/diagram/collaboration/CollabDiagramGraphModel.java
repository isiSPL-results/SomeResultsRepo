
//#if -1972262130 
// Compilation Unit of /CollabDiagramGraphModel.java 
 

//#if 893604638 
package org.argouml.uml.diagram.collaboration;
//#endif 


//#if -1144988472 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 1633950961 
import java.beans.VetoableChangeListener;
//#endif 


//#if 526594873 
import java.util.ArrayList;
//#endif 


//#if 484170056 
import java.util.Collection;
//#endif 


//#if 2124371643 
import java.util.Collections;
//#endif 


//#if 178232 
import java.util.Iterator;
//#endif 


//#if 1084433288 
import java.util.List;
//#endif 


//#if -121328074 
import org.apache.log4j.Logger;
//#endif 


//#if 1726208425 
import org.argouml.model.Model;
//#endif 


//#if -1478753813 
import org.argouml.uml.CommentEdge;
//#endif 


//#if -437445471 
import org.argouml.uml.diagram.UMLMutableGraphSupport;
//#endif 


//#if -1633332414 
public class CollabDiagramGraphModel extends 
//#if -1612398070 
UMLMutableGraphSupport
//#endif 

 implements 
//#if 677445119 
VetoableChangeListener
//#endif 

  { 

//#if -11138558 
private static final Logger LOG =
        Logger.getLogger(CollabDiagramGraphModel.class);
//#endif 


//#if -2008957108 
private static final long serialVersionUID = -4895696235473642985L;
//#endif 


//#if 1757093260 
public void vetoableChange(PropertyChangeEvent pce)
    { 

//#if -1535243724 
if("ownedElement".equals(pce.getPropertyName()))//1
{ 

//#if -195494212 
List oldOwned = (List) pce.getOldValue();
//#endif 


//#if 1158392626 
Object eo = /*(MElementImport)*/ pce.getNewValue();
//#endif 


//#if 784691909 
Object me = Model.getFacade().getModelElement(eo);
//#endif 


//#if -1328767967 
if(oldOwned.contains(eo))//1
{ 

//#if 2037390156 
LOG.debug("model removed " + me);
//#endif 


//#if -592171651 
if(Model.getFacade().isAClassifier(me))//1
{ 

//#if 1183094965 
removeNode(me);
//#endif 

} 

//#endif 


//#if -1639397523 
if(Model.getFacade().isAMessage(me))//1
{ 

//#if -1345315505 
removeNode(me);
//#endif 

} 

//#endif 


//#if -1043462297 
if(Model.getFacade().isAAssociation(me))//1
{ 

//#if -1482144298 
removeEdge(me);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -4339162 
LOG.debug("model added " + me);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -516969423 
@Override
    public void addNode(Object node)
    { 

//#if -1126651903 
LOG.debug("adding MClassifierRole node!!");
//#endif 


//#if -202202751 
if(!canAddNode(node))//1
{ 

//#if -963412237 
return;
//#endif 

} 

//#endif 


//#if -572279588 
getNodes().add(node);
//#endif 


//#if 1590112611 
if(Model.getFacade().isAClassifier(node))//1
{ 

//#if -1467809077 
Model.getCoreHelper().addOwnedElement(getHomeModel(), node);
//#endif 

} 

//#endif 


//#if 206946725 
fireNodeAdded(node);
//#endif 

} 

//#endif 


//#if -1145642223 
@Override
    public void addEdge(Object edge)
    { 

//#if 1538709190 
LOG.debug("adding class edge!!!!!!");
//#endif 


//#if 1517656301 
if(!canAddEdge(edge))//1
{ 

//#if 334256172 
return;
//#endif 

} 

//#endif 


//#if 2137180550 
getEdges().add(edge);
//#endif 


//#if 1599188856 
if(Model.getFacade().isAModelElement(edge)
                && Model.getFacade().getNamespace(edge) == null)//1
{ 

//#if 2067469695 
Model.getCoreHelper().addOwnedElement(getHomeModel(), edge);
//#endif 

} 

//#endif 


//#if -621736921 
fireEdgeAdded(edge);
//#endif 

} 

//#endif 


//#if -1678918435 
public Object getOwner(Object port)
    { 

//#if -1780509620 
return port;
//#endif 

} 

//#endif 


//#if 1577486140 
@Override
    public void addNodeRelatedEdges(Object node)
    { 

//#if 768990392 
super.addNodeRelatedEdges(node);
//#endif 


//#if -1912925783 
if(Model.getFacade().isAClassifier(node))//1
{ 

//#if 1197671796 
Collection ends = Model.getFacade().getAssociationEnds(node);
//#endif 


//#if -1804648031 
for (Object end : ends) //1
{ 

//#if 1314061943 
if(canAddEdge(Model.getFacade().getAssociation(end)))//1
{ 

//#if 508968724 
addEdge(Model.getFacade().getAssociation(end));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 318724817 
if(Model.getFacade().isAGeneralizableElement(node))//1
{ 

//#if 1698151628 
Collection generalizations =
                Model.getFacade().getGeneralizations(node);
//#endif 


//#if -415847608 
for (Object generalization : generalizations) //1
{ 

//#if -436591073 
if(canAddEdge(generalization))//1
{ 

//#if -1137782118 
addEdge(generalization);
//#endif 


//#if -741797687 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1559860692 
Collection specializations = Model.getFacade().getSpecializations(node);
//#endif 


//#if -2016338136 
for (Object specialization : specializations) //1
{ 

//#if -1943381718 
if(canAddEdge(specialization))//1
{ 

//#if 267769522 
addEdge(specialization);
//#endif 


//#if 672817376 
return;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1050542171 
if(Model.getFacade().isAModelElement(node))//1
{ 

//#if -1996644219 
Collection dependencies =
                new ArrayList(Model.getFacade().getClientDependencies(node));
//#endif 


//#if 1052174238 
dependencies.addAll(Model.getFacade().getSupplierDependencies(node));
//#endif 


//#if -772006647 
for (Object dependency : dependencies) //1
{ 

//#if -10759709 
if(canAddEdge(dependency))//1
{ 

//#if -207872163 
addEdge(dependency);
//#endif 


//#if 727997077 
return;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 67192634 
public List getInEdges(Object port)
    { 

//#if 590775738 
if(Model.getFacade().isAClassifierRole(port))//1
{ 

//#if 646094242 
Object cr = port;
//#endif 


//#if 1454547316 
Collection ends = Model.getFacade().getAssociationEnds(cr);
//#endif 


//#if -379061797 
if(ends == null)//1
{ 

//#if 2137779834 
return Collections.EMPTY_LIST;
//#endif 

} 

//#endif 


//#if -529483400 
List result = new ArrayList();
//#endif 


//#if 135060276 
for (Object end : ends) //1
{ 

//#if 752416632 
result.add(Model.getFacade().getAssociation(end));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1956910575 
return Collections.EMPTY_LIST;
//#endif 

} 

//#endif 


//#if 1162196762 
public List getPorts(Object nodeOrEdge)
    { 

//#if 846497936 
if(Model.getFacade().isAClassifierRole(nodeOrEdge))//1
{ 

//#if -895571835 
List result = new ArrayList();
//#endif 


//#if -1913087480 
result.add(nodeOrEdge);
//#endif 


//#if 664024874 
return result;
//#endif 

} 

//#endif 


//#if 1747120666 
return Collections.EMPTY_LIST;
//#endif 

} 

//#endif 


//#if 951078580 
public void setCollaboration(Object collaboration)
    { 

//#if -1113711546 
try //1
{ 

//#if 1601335088 
if(collaboration == null)//1
{ 

//#if -1652265271 
throw new IllegalArgumentException(
                    "A null collaboration was supplied");
//#endif 

} 

//#endif 


//#if -610180064 
if(!(Model.getFacade().isACollaboration(collaboration)))//1
{ 

//#if -21370491 
throw new IllegalArgumentException(
                    "Expected a collaboration. The type received was "
                    + collaboration.getClass().getName());
//#endif 

} 

//#endif 

} 

//#if 1028907861 
catch (IllegalArgumentException e) //1
{ 

//#if -1817136346 
LOG.error("Illegal Argument to setCollaboration", e);
//#endif 


//#if 1117498830 
throw e;
//#endif 

} 

//#endif 


//#endif 


//#if 144593383 
setHomeModel(collaboration);
//#endif 

} 

//#endif 


//#if -790484739 
@Override
    public boolean canAddNode(Object node)
    { 

//#if -1384765355 
if(node == null)//1
{ 

//#if 1905613680 
return false;
//#endif 

} 

//#endif 


//#if 1738922827 
if(Model.getFacade().isAAssociation(node)
                && !Model.getFacade().isANaryAssociation(node))//1
{ 

//#if -2140903304 
return false;
//#endif 

} 

//#endif 


//#if 1851524716 
if(containsNode(node))//1
{ 

//#if 107309991 
return false;
//#endif 

} 

//#endif 


//#if -1667790586 
return (Model.getFacade().isAClassifierRole(node)
                || Model.getFacade().isAMessage(node)
                || Model.getFacade().isAComment(node));
//#endif 

} 

//#endif 


//#if -831601311 
public List getOutEdges(Object port)
    { 

//#if 1838920257 
return Collections.EMPTY_LIST;
//#endif 

} 

//#endif 


//#if -1254299108 
@Override
    public boolean canConnect(Object fromP, Object toP)
    { 

//#if 2142734135 
if((Model.getFacade().isAClassifierRole(fromP))
                && (Model.getFacade().isAClassifierRole(toP)))//1
{ 

//#if 445012340 
return true;
//#endif 

} 

//#endif 


//#if 891314263 
return false;
//#endif 

} 

//#endif 


//#if -1419157539 
@Override
    public boolean canAddEdge(Object edge)
    { 

//#if -1303164045 
if(edge == null)//1
{ 

//#if 233821359 
return false;
//#endif 

} 

//#endif 


//#if 1745957807 
if(containsEdge(edge))//1
{ 

//#if 568752527 
return false;
//#endif 

} 

//#endif 


//#if -798548433 
Object end0 = null;
//#endif 


//#if 88955248 
Object end1 = null;
//#endif 


//#if 1147790837 
if(Model.getFacade().isAAssociationRole(edge))//1
{ 

//#if -945703151 
Collection conns = Model.getFacade().getConnections(edge);
//#endif 


//#if -672460129 
Iterator iter = conns.iterator();
//#endif 


//#if 1032401217 
if(conns.size() < 2)//1
{ 

//#if -924632173 
return false;
//#endif 

} 

//#endif 


//#if -918261154 
Object associationEndRole0 = iter.next();
//#endif 


//#if -1423819779 
Object associationEndRole1 = iter.next();
//#endif 


//#if -197599965 
if(associationEndRole0 == null || associationEndRole1 == null)//1
{ 

//#if 1759005620 
return false;
//#endif 

} 

//#endif 


//#if -461886175 
end0 = Model.getFacade().getType(associationEndRole0);
//#endif 


//#if -469644573 
end1 = Model.getFacade().getType(associationEndRole1);
//#endif 

} 
else

//#if -1741028477 
if(Model.getFacade().isAGeneralization(edge))//1
{ 

//#if 2098766357 
Object gen = /*(MGeneralization)*/ edge;
//#endif 


//#if -1001898407 
end0 = Model.getFacade().getGeneral(gen);
//#endif 


//#if 472580438 
end1 = Model.getFacade().getSpecific(gen);
//#endif 

} 
else

//#if 18242959 
if(Model.getFacade().isADependency(edge))//1
{ 

//#if -959841562 
Collection clients = Model.getFacade().getClients(edge);
//#endif 


//#if -2108579066 
Collection suppliers = Model.getFacade().getSuppliers(edge);
//#endif 


//#if -236018265 
if(clients == null || clients.isEmpty()
                    || suppliers == null || suppliers.isEmpty())//1
{ 

//#if 14586974 
return false;
//#endif 

} 

//#endif 


//#if 703661836 
end0 = clients.iterator().next();
//#endif 


//#if 1547857580 
end1 = suppliers.iterator().next();
//#endif 

} 
else

//#if -212380444 
if(edge instanceof CommentEdge)//1
{ 

//#if -1069120177 
end0 = ((CommentEdge) edge).getSource();
//#endif 


//#if 849483229 
end1 = ((CommentEdge) edge).getDestination();
//#endif 

} 
else
{ 

//#if 806174506 
return false;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#if 1807713864 
if(end0 == null || end1 == null)//1
{ 

//#if -336033933 
LOG.error("Edge rejected. Its ends are not attached to anything");
//#endif 


//#if -1906002836 
return false;
//#endif 

} 

//#endif 


//#if -1677098998 
if(!containsNode(end0)
                && !containsEdge(end0))//1
{ 

//#if -1390260365 
LOG.error("Edge rejected. Its source end is attached to " + end0
                      + " but this is not in the graph model");
//#endif 


//#if -705025581 
return false;
//#endif 

} 

//#endif 


//#if -686855830 
if(!containsNode(end1)
                && !containsEdge(end1))//1
{ 

//#if -1882020955 
LOG.error("Edge rejected. Its destination end is attached to "
                      + end1 + " but this is not in the graph model");
//#endif 


//#if -532482285 
return false;
//#endif 

} 

//#endif 


//#if 2111774105 
return true;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

