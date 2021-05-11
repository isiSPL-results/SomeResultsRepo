
//#if 114313617 
// Compilation Unit of /DeploymentDiagramGraphModel.java 
 

//#if 1008482617 
package org.argouml.uml.diagram.deployment;
//#endif 


//#if 1222019901 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -1887642020 
import java.beans.VetoableChangeListener;
//#endif 


//#if 1600781284 
import java.util.ArrayList;
//#endif 


//#if -575789571 
import java.util.Collection;
//#endif 


//#if -669605722 
import java.util.Collections;
//#endif 


//#if -309961731 
import java.util.List;
//#endif 


//#if -779015839 
import org.apache.log4j.Logger;
//#endif 


//#if 1068520660 
import org.argouml.model.Model;
//#endif 


//#if 38858646 
import org.argouml.uml.CommentEdge;
//#endif 


//#if -74890986 
import org.argouml.uml.diagram.UMLMutableGraphSupport;
//#endif 


//#if 866924341 
public class DeploymentDiagramGraphModel extends 
//#if 403378848 
UMLMutableGraphSupport
//#endif 

 implements 
//#if -1601745259 
VetoableChangeListener
//#endif 

  { 

//#if -696963872 
private static final Logger LOG =
        Logger.getLogger(DeploymentDiagramGraphModel.class);
//#endif 


//#if -1431683486 
static final long serialVersionUID = 1003748292917485298L;
//#endif 


//#if -1505881913 
@Override
    public void addNode(Object node)
    { 

//#if 2011060368 
LOG.debug("adding class node!!");
//#endif 


//#if -2064149762 
if(!canAddNode(node))//1
{ 

//#if 971885398 
return;
//#endif 

} 

//#endif 


//#if -708871041 
getNodes().add(node);
//#endif 


//#if -25815450 
if(Model.getFacade().isAModelElement(node)
                && (Model.getFacade().getNamespace(node) == null))//1
{ 

//#if -989196480 
Model.getCoreHelper().addOwnedElement(getHomeModel(), node);
//#endif 

} 

//#endif 


//#if 1172371874 
fireNodeAdded(node);
//#endif 

} 

//#endif 


//#if 24921363 
@Override
    public boolean canAddNode(Object node)
    { 

//#if -2038872147 
if(node == null)//1
{ 

//#if -489153830 
return false;
//#endif 

} 

//#endif 


//#if 1594048243 
if(Model.getFacade().isAAssociation(node)
                && !Model.getFacade().isANaryAssociation(node))//1
{ 

//#if 225767166 
return false;
//#endif 

} 

//#endif 


//#if -715764284 
if(containsNode(node))//1
{ 

//#if -261792019 
return false;
//#endif 

} 

//#endif 


//#if -1561238033 
if(Model.getFacade().isAAssociation(node))//1
{ 

//#if 1704175728 
Collection ends = Model.getFacade().getConnections(node);
//#endif 


//#if -1549690899 
boolean canAdd = true;
//#endif 


//#if 955552217 
for (Object end : ends) //1
{ 

//#if 578256968 
Object classifier =
                    Model.getFacade().getClassifier(end);
//#endif 


//#if -1335073846 
if(!containsNode(classifier))//1
{ 

//#if -1591673600 
canAdd = false;
//#endif 


//#if 1959709632 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1703792382 
return canAdd;
//#endif 

} 

//#endif 


//#if 1511000019 
return (Model.getFacade().isANode(node))
               || (Model.getFacade().isAComponent(node))
               || (Model.getFacade().isAClass(node))
               || (Model.getFacade().isAInterface(node))
               || (Model.getFacade().isAObject(node))
               || (Model.getFacade().isANodeInstance(node))
               || (Model.getFacade().isAComponentInstance(node)
                   || (Model.getFacade().isAComment(node)));
//#endif 

} 

//#endif 


//#if -603751437 
@Override
    public boolean canAddEdge(Object edge)
    { 

//#if 2119583498 
if(edge == null)//1
{ 

//#if 791419022 
return false;
//#endif 

} 

//#endif 


//#if -1622759354 
if(containsEdge(edge))//1
{ 

//#if -1284887390 
return false;
//#endif 

} 

//#endif 


//#if 225300502 
Object end0 = null, end1 = null;
//#endif 


//#if 767729725 
if(edge instanceof CommentEdge)//1
{ 

//#if -380228414 
end0 = ((CommentEdge) edge).getSource();
//#endif 


//#if 411049546 
end1 = ((CommentEdge) edge).getDestination();
//#endif 

} 
else

//#if 1957327332 
if(Model.getFacade().isAAssociationEnd(edge))//1
{ 

//#if -1881367864 
end0 = Model.getFacade().getAssociation(edge);
//#endif 


//#if 3750186 
end1 = Model.getFacade().getType(edge);
//#endif 


//#if 455871149 
return (end0 != null
                    && end1 != null
                    && (containsEdge(end0) || containsNode(end0))
                    && containsNode(end1));
//#endif 

} 
else

//#if 632355698 
if(Model.getFacade().isARelationship(edge))//1
{ 

//#if 1851470224 
end0 = Model.getCoreHelper().getSource(edge);
//#endif 


//#if 175147222 
end1 = Model.getCoreHelper().getDestination(edge);
//#endif 

} 
else

//#if -1889429945 
if(Model.getFacade().isALink(edge))//1
{ 

//#if 887402680 
end0 = Model.getCommonBehaviorHelper().getSource(edge);
//#endif 


//#if 2079577454 
end1 =
                Model.getCommonBehaviorHelper().getDestination(edge);
//#endif 

} 
else

//#if 748967428 
if(edge instanceof CommentEdge)//1
{ 

//#if 311858712 
end0 = ((CommentEdge) edge).getSource();
//#endif 


//#if 1994005172 
end1 = ((CommentEdge) edge).getDestination();
//#endif 

} 
else
{ 

//#if 532113791 
return false;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#if 1802164063 
if(end0 == null || end1 == null)//1
{ 

//#if -825117127 
LOG.error("Edge rejected. Its ends are not attached to anything");
//#endif 


//#if -1438437966 
return false;
//#endif 

} 

//#endif 


//#if -1976477343 
if(!containsNode(end0)
                && !containsEdge(end0))//1
{ 

//#if -276261437 
LOG.error("Edge rejected. Its source end is attached to "
                      + end0
                      + " but this is not in the graph model");
//#endif 


//#if -1635806173 
return false;
//#endif 

} 

//#endif 


//#if -986234175 
if(!containsNode(end1)
                && !containsEdge(end1))//1
{ 

//#if -162666157 
LOG.error("Edge rejected. Its destination end is attached to "
                      + end1
                      + " but this is not in the graph model");
//#endif 


//#if 1024482085 
return false;
//#endif 

} 

//#endif 


//#if -665823632 
return true;
//#endif 

} 

//#endif 


//#if -1165732784 
public List getInEdges(Object port)
    { 

//#if -1138027460 
List res = new ArrayList();
//#endif 


//#if -1113882432 
if(Model.getFacade().isANode(port))//1
{ 

//#if 415904684 
Collection ends = Model.getFacade().getAssociationEnds(port);
//#endif 


//#if 1071184821 
if(ends == null)//1
{ 

//#if 1201276572 
return Collections.EMPTY_LIST;
//#endif 

} 

//#endif 


//#if 957673882 
for (Object end : ends) //1
{ 

//#if -506174810 
res.add(Model.getFacade().getAssociation(end));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 696566581 
if(Model.getFacade().isANodeInstance(port))//1
{ 

//#if -876477547 
Object noi = port;
//#endif 


//#if -83885438 
Collection ends = Model.getFacade().getLinkEnds(noi);
//#endif 


//#if 2210835 
res.addAll(ends);
//#endif 

} 

//#endif 


//#if 407112079 
if(Model.getFacade().isAComponent(port))//1
{ 

//#if 642228204 
Collection ends = Model.getFacade().getAssociationEnds(port);
//#endif 


//#if 715376501 
if(ends == null)//1
{ 

//#if 333130552 
return Collections.EMPTY_LIST;
//#endif 

} 

//#endif 


//#if 737377754 
for (Object end : ends) //1
{ 

//#if -131140482 
res.add(Model.getFacade().getAssociation(end));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1703211772 
if(Model.getFacade().isAComponentInstance(port))//1
{ 

//#if -895686064 
Object coi = port;
//#endif 


//#if 1413942897 
Collection ends = Model.getFacade().getLinkEnds(coi);
//#endif 


//#if 431066713 
res.addAll(ends);
//#endif 

} 

//#endif 


//#if 1898011978 
if(Model.getFacade().isAClass(port))//1
{ 

//#if 152598084 
Collection ends = Model.getFacade().getAssociationEnds(port);
//#endif 


//#if 1867812381 
if(ends == null)//1
{ 

//#if 2116455321 
return Collections.EMPTY_LIST;
//#endif 

} 

//#endif 


//#if 1400676402 
for (Object end : ends) //1
{ 

//#if -1813732887 
res.add(Model.getFacade().getAssociation(end));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -543146293 
if(Model.getFacade().isAInterface(port))//1
{ 

//#if -1497115185 
Collection ends = Model.getFacade().getAssociationEnds(port);
//#endif 


//#if 1397885490 
if(ends == null)//1
{ 

//#if 125561908 
return Collections.EMPTY_LIST;
//#endif 

} 

//#endif 


//#if 576874813 
for (Object end : ends) //1
{ 

//#if 933828584 
res.add(Model.getFacade().getAssociation(end));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 534798397 
if(Model.getFacade().isAObject(port))//1
{ 

//#if 46002441 
Object clo = port;
//#endif 


//#if 1626065930 
Collection ends = Model.getFacade().getLinkEnds(clo);
//#endif 


//#if 820872233 
res.addAll(ends);
//#endif 

} 

//#endif 


//#if 1031167095 
return res;
//#endif 

} 

//#endif 


//#if -397583605 
public List getOutEdges(Object port)
    { 

//#if -47607716 
return Collections.EMPTY_LIST;
//#endif 

} 

//#endif 


//#if -1162852048 
public List getPorts(Object nodeOrEdge)
    { 

//#if 1026992020 
List res = new ArrayList();
//#endif 


//#if 2063021735 
if(Model.getFacade().isANode(nodeOrEdge))//1
{ 

//#if -846334134 
res.add(nodeOrEdge);
//#endif 

} 

//#endif 


//#if -781851300 
if(Model.getFacade().isANodeInstance(nodeOrEdge))//1
{ 

//#if -425654712 
res.add(nodeOrEdge);
//#endif 

} 

//#endif 


//#if 1528089062 
if(Model.getFacade().isAComponent(nodeOrEdge))//1
{ 

//#if 990988697 
res.add(nodeOrEdge);
//#endif 

} 

//#endif 


//#if 219662747 
if(Model.getFacade().isAComponentInstance(nodeOrEdge))//1
{ 

//#if 1928441374 
res.add(nodeOrEdge);
//#endif 

} 

//#endif 


//#if 1017483617 
if(Model.getFacade().isAClass(nodeOrEdge))//1
{ 

//#if 742144227 
res.add(nodeOrEdge);
//#endif 

} 

//#endif 


//#if 1034625570 
if(Model.getFacade().isAInterface(nodeOrEdge))//1
{ 

//#if 179161497 
res.add(nodeOrEdge);
//#endif 

} 

//#endif 


//#if 1484094052 
if(Model.getFacade().isAObject(nodeOrEdge))//1
{ 

//#if -1145625943 
res.add(nodeOrEdge);
//#endif 

} 

//#endif 


//#if -1989789153 
return res;
//#endif 

} 

//#endif 


//#if 1209876130 
public void vetoableChange(PropertyChangeEvent pce)
    { 

//#if -1374970053 
if("ownedElement".equals(pce.getPropertyName()))//1
{ 

//#if 400413255 
List oldOwned = (List) pce.getOldValue();
//#endif 


//#if 1746651792 
Object eo = pce.getNewValue();
//#endif 


//#if 348886160 
Object me = Model.getFacade().getModelElement(eo);
//#endif 


//#if -1870622666 
if(oldOwned.contains(eo))//1
{ 

//#if 595895945 
LOG.debug("model removed " + me);
//#endif 


//#if 1904304833 
if(Model.getFacade().isANode(me))//1
{ 

//#if -1158607588 
removeNode(me);
//#endif 

} 

//#endif 


//#if -2103540106 
if(Model.getFacade().isANodeInstance(me))//1
{ 

//#if -659518559 
removeNode(me);
//#endif 

} 

//#endif 


//#if 182500576 
if(Model.getFacade().isAComponent(me))//1
{ 

//#if -2105597679 
removeNode(me);
//#endif 

} 

//#endif 


//#if 1347244437 
if(Model.getFacade().isAComponentInstance(me))//1
{ 

//#if 391366023 
removeNode(me);
//#endif 

} 

//#endif 


//#if -2093471909 
if(Model.getFacade().isAClass(me))//1
{ 

//#if -2061039445 
removeNode(me);
//#endif 

} 

//#endif 


//#if -654241508 
if(Model.getFacade().isAInterface(me))//1
{ 

//#if 936927981 
removeNode(me);
//#endif 

} 

//#endif 


//#if 392933246 
if(Model.getFacade().isAObject(me))//1
{ 

//#if 1931985125 
removeNode(me);
//#endif 

} 

//#endif 


//#if -992238620 
if(Model.getFacade().isAAssociation(me))//1
{ 

//#if -594607648 
removeEdge(me);
//#endif 

} 

//#endif 


//#if 1125743754 
if(Model.getFacade().isADependency(me))//1
{ 

//#if -382907983 
removeEdge(me);
//#endif 

} 

//#endif 


//#if -382014279 
if(Model.getFacade().isALink(me))//1
{ 

//#if 224007833 
removeEdge(me);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -822690190 
LOG.debug("model added " + me);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -2134554713 
@Override
    public void addEdge(Object edge)
    { 

//#if 1196825504 
LOG.debug("adding class edge!!!!!!");
//#endif 


//#if -1133455277 
if(!canAddEdge(edge))//1
{ 

//#if -2011338008 
return;
//#endif 

} 

//#endif 


//#if 1755329504 
getEdges().add(edge);
//#endif 


//#if -186441762 
if(Model.getFacade().isAModelElement(edge)
                && !Model.getFacade().isAAssociationEnd(edge))//1
{ 

//#if -1276370399 
Model.getCoreHelper().addOwnedElement(getHomeModel(), edge);
//#endif 

} 

//#endif 


//#if 1167060621 
fireEdgeAdded(edge);
//#endif 

} 

//#endif 


//#if 1383123443 
public Object getOwner(Object port)
    { 

//#if 2028359891 
return port;
//#endif 

} 

//#endif 


//#if -312165678 
@Override
    public void addNodeRelatedEdges(Object node)
    { 

//#if 827867521 
super.addNodeRelatedEdges(node);
//#endif 


//#if -773353230 
if(Model.getFacade().isAClassifier(node))//1
{ 

//#if 1524335492 
Collection ends = Model.getFacade().getAssociationEnds(node);
//#endif 


//#if -1207596700 
for (Object ae : ends) //1
{ 

//#if 3973518 
if(!Model.getFacade().isANaryAssociation(
                            Model.getFacade().getAssociation(ae))
                        && canAddEdge(Model.getFacade().getAssociation(ae)))//1
{ 

//#if -1869468346 
addEdge(Model.getFacade().getAssociation(ae));
//#endif 

} 

//#endif 


//#if -932825111 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1796802818 
if(Model.getFacade().isAAssociation(node))//1
{ 

//#if 2077448887 
Collection ends = Model.getFacade().getConnections(node);
//#endif 


//#if -942606113 
for (Object associationEnd : ends) //1
{ 

//#if 228067110 
if(canAddEdge(associationEnd))//1
{ 

//#if 877122817 
addEdge(associationEnd);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1678947558 
if(Model.getFacade().isAInstance(node))//1
{ 

//#if 984972912 
Collection ends = Model.getFacade().getLinkEnds(node);
//#endif 


//#if -1976025686 
for (Object end : ends) //1
{ 

//#if 586891928 
Object link = Model.getFacade().getLink(end);
//#endif 


//#if 1082590047 
if(canAddEdge(link))//1
{ 

//#if 319160507 
addEdge(link);
//#endif 

} 

//#endif 


//#if 1573177954 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1238373082 
if(Model.getFacade().isAGeneralizableElement(node))//1
{ 

//#if 200920775 
Collection generalizations =
                Model.getFacade().getGeneralizations(node);
//#endif 


//#if 581848301 
for (Object generalization : generalizations) //1
{ 

//#if -1800803211 
if(canAddEdge(generalization))//1
{ 

//#if 1396807717 
addEdge(generalization);
//#endif 

} 

//#endif 


//#if 989833402 
return;
//#endif 

} 

//#endif 


//#if 1237875751 
Collection specializations =
                Model.getFacade().getSpecializations(node);
//#endif 


//#if -1018642227 
for (Object specialization : specializations) //1
{ 

//#if -1991381524 
if(canAddEdge(specialization))//1
{ 

//#if 1931550655 
addEdge(specialization);
//#endif 

} 

//#endif 


//#if -1378990240 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 963105124 
if(Model.getFacade().isAModelElement(node))//1
{ 

//#if -1268635748 
List dependencies =
                new ArrayList(Model.getFacade().getClientDependencies(node));
//#endif 


//#if 897025653 
dependencies.addAll(Model.getFacade().getSupplierDependencies(node));
//#endif 


//#if 2113263584 
for (Object dependency : dependencies) //1
{ 

//#if 1842133969 
if(canAddEdge(dependency))//1
{ 

//#if 121357096 
addEdge(dependency);
//#endif 

} 

//#endif 


//#if -526563899 
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


//#endif 

