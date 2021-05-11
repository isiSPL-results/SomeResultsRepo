
//#if 1706692808 
// Compilation Unit of /ClassDiagramGraphModel.java 
 

//#if 376202238 
package org.argouml.uml.diagram.static_structure;
//#endif 


//#if -1374121733 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 228005854 
import java.beans.VetoableChangeListener;
//#endif 


//#if -1586355994 
import java.util.ArrayList;
//#endif 


//#if -592797381 
import java.util.Collection;
//#endif 


//#if 347660523 
import java.util.Iterator;
//#endif 


//#if 358063547 
import java.util.List;
//#endif 


//#if -652542621 
import org.apache.log4j.Logger;
//#endif 


//#if 1194993878 
import org.argouml.model.Model;
//#endif 


//#if -923995496 
import org.argouml.uml.CommentEdge;
//#endif 


//#if -869004588 
import org.argouml.uml.diagram.UMLMutableGraphSupport;
//#endif 


//#if -875773304 
public class ClassDiagramGraphModel extends 
//#if 160142880 
UMLMutableGraphSupport
//#endif 

 implements 
//#if -1844981227 
VetoableChangeListener
//#endif 

  { 

//#if 2137931191 
private static final Logger LOG =
        Logger.getLogger(ClassDiagramGraphModel.class);
//#endif 


//#if -1950416038 
static final long serialVersionUID = -2638688086415040146L;
//#endif 


//#if 683998802 
@Override
    public void addNodeRelatedEdges(Object node)
    { 

//#if -285439060 
super.addNodeRelatedEdges(node);
//#endif 


//#if 695136925 
if(Model.getFacade().isAClassifier(node))//1
{ 

//#if -498106845 
Collection ends = Model.getFacade().getAssociationEnds(node);
//#endif 


//#if 1758718778 
Iterator iter = ends.iterator();
//#endif 


//#if -1148919510 
while (iter.hasNext()) //1
{ 

//#if 1588925994 
Object association =
                    Model.getFacade().getAssociation(iter.next());
//#endif 


//#if -1663252688 
if(!Model.getFacade().isANaryAssociation(association)
                        && canAddEdge(association))//1
{ 

//#if -1828107178 
addEdge(association);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1091934917 
if(Model.getFacade().isAGeneralizableElement(node))//1
{ 

//#if 802961624 
Collection generalizations =
                Model.getFacade().getGeneralizations(node);
//#endif 


//#if -1521525477 
Iterator iter = generalizations.iterator();
//#endif 


//#if 1127146388 
while (iter.hasNext()) //1
{ 

//#if 1443698639 
Object generalization = iter.next();
//#endif 


//#if 1831565730 
if(canAddEdge(generalization))//1
{ 

//#if 2030473274 
addEdge(generalization);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1839916600 
Collection specializations =
                Model.getFacade().getSpecializations(node);
//#endif 


//#if -687359266 
iter = specializations.iterator();
//#endif 


//#if 763801245 
while (iter.hasNext()) //2
{ 

//#if 169183481 
Object specialization = iter.next();
//#endif 


//#if -353186868 
if(canAddEdge(specialization))//1
{ 

//#if -980069562 
addEdge(specialization);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 776719027 
if(Model.getFacade().isAAssociation(node))//1
{ 

//#if -1749459735 
Collection ends = Model.getFacade().getConnections(node);
//#endif 


//#if 56340600 
Iterator iter = ends.iterator();
//#endif 


//#if -957723348 
while (iter.hasNext()) //1
{ 

//#if -93845398 
Object associationEnd = iter.next();
//#endif 


//#if -1645728707 
if(canAddEdge(associationEnd))//1
{ 

//#if 1779978554 
addEdge(associationEnd);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 666656627 
@Override
    public boolean canAddEdge(Object edge)
    { 

//#if 1166841512 
if(edge == null)//1
{ 

//#if -1834822866 
return false;
//#endif 

} 

//#endif 


//#if 1895463396 
if(containsEdge(edge))//1
{ 

//#if -1243419215 
return false;
//#endif 

} 

//#endif 


//#if 609054131 
Object sourceModelElement = null;
//#endif 


//#if -720825350 
Object destModelElement = null;
//#endif 


//#if -366116844 
if(Model.getFacade().isAAssociation(edge))//1
{ 

//#if 471670856 
Collection conns = Model.getFacade().getConnections(edge);
//#endif 


//#if -815982536 
if(conns.size() < 2)//1
{ 

//#if -353473797 
LOG.error("Association rejected. Must have at least 2 ends");
//#endif 


//#if 1197243483 
return false;
//#endif 

} 

//#endif 


//#if 1375080840 
Iterator iter = conns.iterator();
//#endif 


//#if 86553521 
Object associationEnd0 = iter.next();
//#endif 


//#if -419005104 
Object associationEnd1 = iter.next();
//#endif 


//#if 1601492890 
if(associationEnd0 == null || associationEnd1 == null)//1
{ 

//#if 27281167 
LOG.error("Association rejected. An end is null");
//#endif 


//#if -1155458251 
return false;
//#endif 

} 

//#endif 


//#if -453697479 
sourceModelElement = Model.getFacade().getType(associationEnd0);
//#endif 


//#if -461795327 
destModelElement = Model.getFacade().getType(associationEnd1);
//#endif 

} 
else

//#if -291610440 
if(Model.getFacade().isAAssociationEnd(edge))//1
{ 

//#if 619269081 
sourceModelElement = Model.getFacade().getAssociation(edge);
//#endif 


//#if 1767810675 
destModelElement = Model.getFacade().getType(edge);
//#endif 


//#if -1785618522 
if(sourceModelElement == null || destModelElement == null)//1
{ 

//#if -1982952099 
LOG.error("Association end rejected. An end is null");
//#endif 


//#if 361199378 
return false;
//#endif 

} 

//#endif 


//#if 1423170298 
if(!containsEdge(sourceModelElement)
                    && !containsNode(sourceModelElement))//1
{ 

//#if -80715603 
LOG.error("Association end rejected. The source model element ("
                          + sourceModelElement.getClass().getName()
                          + ") must be on the diagram");
//#endif 


//#if -364583081 
return false;
//#endif 

} 

//#endif 


//#if -1696141655 
if(!containsNode(destModelElement))//1
{ 

//#if -1635462165 
LOG.error("Association end rejected. "
                          + "The destination model element must be "
                          + "on the diagram.");
//#endif 


//#if 1941413162 
return false;
//#endif 

} 

//#endif 

} 
else

//#if -84394678 
if(Model.getFacade().isAGeneralization(edge))//1
{ 

//#if 745043992 
sourceModelElement = Model.getFacade().getSpecific(edge);
//#endif 


//#if -2026023837 
destModelElement = Model.getFacade().getGeneral(edge);
//#endif 

} 
else

//#if 736340051 
if(Model.getFacade().isADependency(edge))//1
{ 

//#if 1266282314 
Collection clients = Model.getFacade().getClients(edge);
//#endif 


//#if -1956067990 
Collection suppliers = Model.getFacade().getSuppliers(edge);
//#endif 


//#if 546486732 
if(clients == null || suppliers == null)//1
{ 

//#if -1144283558 
return false;
//#endif 

} 

//#endif 


//#if -400970569 
sourceModelElement = clients.iterator().next();
//#endif 


//#if -1954802223 
destModelElement = suppliers.iterator().next();
//#endif 

} 
else

//#if 1038337511 
if(Model.getFacade().isALink(edge))//1
{ 

//#if -1098126166 
Collection roles = Model.getFacade().getConnections(edge);
//#endif 


//#if 2144492910 
if(roles.size() < 2)//1
{ 

//#if -109839553 
return false;
//#endif 

} 

//#endif 


//#if 1178338450 
Iterator iter = roles.iterator();
//#endif 


//#if 307185970 
Object linkEnd0 = iter.next();
//#endif 


//#if -198372655 
Object linkEnd1 = iter.next();
//#endif 


//#if 1242488786 
if(linkEnd0 == null || linkEnd1 == null)//1
{ 

//#if 387517868 
return false;
//#endif 

} 

//#endif 


//#if -1781909919 
sourceModelElement = Model.getFacade().getInstance(linkEnd0);
//#endif 


//#if 1316605563 
destModelElement = Model.getFacade().getInstance(linkEnd1);
//#endif 

} 
else

//#if 2118214962 
if(edge instanceof CommentEdge)//1
{ 

//#if -1500214155 
sourceModelElement = ((CommentEdge) edge).getSource();
//#endif 


//#if 1478197885 
destModelElement = ((CommentEdge) edge).getDestination();
//#endif 

} 
else
{ 

//#if 1398488289 
return false;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#if -1624225483 
if(sourceModelElement == null || destModelElement == null)//1
{ 

//#if -2073475008 
LOG.error("Edge rejected. Its ends are not attached to anything");
//#endif 


//#if -367483911 
return false;
//#endif 

} 

//#endif 


//#if 1040561759 
if(!containsNode(sourceModelElement)
                && !containsEdge(sourceModelElement))//1
{ 

//#if -2128282278 
LOG.error("Edge rejected. Its source end is attached to "
                      + sourceModelElement
                      + " but this is not in the graph model");
//#endif 


//#if -1049191135 
return false;
//#endif 

} 

//#endif 


//#if 1471020287 
if(!containsNode(destModelElement)
                && !containsEdge(destModelElement))//1
{ 

//#if -1155052925 
LOG.error("Edge rejected. Its destination end is attached to "
                      + destModelElement
                      + " but this is not in the graph model");
//#endif 


//#if -1421341004 
return false;
//#endif 

} 

//#endif 


//#if -1679149938 
return true;
//#endif 

} 

//#endif 


//#if 1295329427 
@Override
    public boolean canAddNode(Object node)
    { 

//#if -1099430474 
if(Model.getFacade().isAAssociation(node)
                && !Model.getFacade().isANaryAssociation(node))//1
{ 

//#if -743509984 
LOG.debug("A binary association cannot be added as a node");
//#endif 


//#if 981517517 
return false;
//#endif 

} 

//#endif 


//#if 804385259 
if(super.canAddNode(node) && !containsNode(node))//1
{ 

//#if 19287241 
return true;
//#endif 

} 

//#endif 


//#if -130970975 
if(containsNode(node))//1
{ 

//#if 1804152731 
LOG.error("Addition of node of type "
                      + node.getClass().getName()
                      + " rejected because its already in the graph model");
//#endif 


//#if -1096963393 
return false;
//#endif 

} 

//#endif 


//#if -2082303412 
if(Model.getFacade().isAAssociation(node))//1
{ 

//#if -1034689651 
Collection ends = Model.getFacade().getConnections(node);
//#endif 


//#if 226072916 
Iterator iter = ends.iterator();
//#endif 


//#if -1443018032 
while (iter.hasNext()) //1
{ 

//#if -682623584 
Object classifier =
                    Model.getFacade().getClassifier(iter.next());
//#endif 


//#if 632796083 
if(!containsNode(classifier))//1
{ 

//#if 1416809231 
LOG.error("Addition of node of type "
                              + node.getClass().getName()
                              + " rejected because it is connected to a "
                              + "classifier that is not in the diagram");
//#endif 


//#if -178818311 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 558238148 
return true;
//#endif 

} 

//#endif 


//#if -763747852 
if(Model.getFacade().isAModel(node))//1
{ 

//#if -514471575 
return false;
//#endif 

} 

//#endif 


//#if 626814586 
if(Model.getFacade().isAClassifierRole(node))//1
{ 

//#if 541561748 
return false;
//#endif 

} 

//#endif 


//#if -289948021 
return Model.getFacade().isAClassifier(node)
               || Model.getFacade().isAPackage(node)
               || Model.getFacade().isAStereotype(node)
               || Model.getFacade().isASignal(node)
               || Model.getFacade().isAInstance(node);
//#endif 

} 

//#endif 


//#if -952129653 
public List getOutEdges(Object port)
    { 

//#if 1741664533 
List<Object> edges = new ArrayList<Object>();
//#endif 


//#if 1400423432 
if(Model.getFacade().isAModelElement(port))//1
{ 

//#if -712108849 
Iterator it =
                Model.getFacade().getClientDependencies(port).iterator();
//#endif 


//#if 1016419735 
while (it.hasNext()) //1
{ 

//#if -132410404 
edges.add(it.next());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1611436670 
if(Model.getFacade().isAGeneralizableElement(port))//1
{ 

//#if -8620985 
Iterator it = Model.getFacade().getGeneralizations(port).iterator();
//#endif 


//#if -1879542264 
while (it.hasNext()) //1
{ 

//#if 1739377587 
edges.add(it.next());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1614616662 
if(Model.getFacade().isAClassifier(port))//1
{ 

//#if 2119555191 
Iterator it = Model.getFacade().getAssociationEnds(port).iterator();
//#endif 


//#if 619193274 
while (it.hasNext()) //1
{ 

//#if -2054972612 
Object thisEnd = it.next();
//#endif 


//#if -536417804 
Object assoc = Model.getFacade().getAssociation(thisEnd);
//#endif 


//#if 1519090606 
if(assoc != null)//1
{ 

//#if -78505641 
Iterator it2 =
                        Model.getFacade().getAssociationEnds(assoc).iterator();
//#endif 


//#if 1939977598 
while (it2.hasNext()) //1
{ 

//#if -972107013 
Object nextAssocEnd = it2.next();
//#endif 


//#if 1551578929 
if(!thisEnd.equals(nextAssocEnd)
                                && Model.getFacade().isNavigable(
                                    nextAssocEnd))//1
{ 

//#if -773446493 
edges.add(nextAssocEnd);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1748141368 
return edges;
//#endif 

} 

//#endif 


//#if 1171683280 
public List getInEdges(Object port)
    { 

//#if 2092304220 
List<Object> edges = new ArrayList<Object>();
//#endif 


//#if -1740619231 
if(Model.getFacade().isAModelElement(port))//1
{ 

//#if 1733631618 
Iterator it =
                Model.getFacade().getSupplierDependencies(port).iterator();
//#endif 


//#if 237035593 
while (it.hasNext()) //1
{ 

//#if -1255284350 
edges.add(it.next());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 388294551 
if(Model.getFacade().isAGeneralizableElement(port))//1
{ 

//#if -1390735030 
Iterator it = Model.getFacade().getSpecializations(port).iterator();
//#endif 


//#if -1854437162 
while (it.hasNext()) //1
{ 

//#if -574143765 
edges.add(it.next());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1705518592 
if(Model.getFacade().isAClassifier(port)
                || Model.getFacade().isAPackage(port))//1
{ 

//#if -551765273 
Iterator it = Model.getFacade().getAssociationEnds(port).iterator();
//#endif 


//#if 1325967178 
while (it.hasNext()) //1
{ 

//#if -1365668655 
Object nextAssocEnd = it.next();
//#endif 


//#if -321877684 
if(Model.getFacade().isNavigable(nextAssocEnd))//1
{ 

//#if -1354081565 
edges.add(nextAssocEnd);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -600869981 
if(Model.getFacade().isAInstance(port))//1
{ 

//#if -924436493 
Iterator it = Model.getFacade().getLinkEnds(port).iterator();
//#endif 


//#if -719701635 
while (it.hasNext()) //1
{ 

//#if -2074739576 
edges.add(it.next());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -451651183 
return edges;
//#endif 

} 

//#endif 


//#if -1278293209 
@Override
    public void addEdge(Object edge)
    { 

//#if 1600428338 
if(edge == null)//1
{ 

//#if 1887699006 
throw new IllegalArgumentException("Cannot add a null edge");
//#endif 

} 

//#endif 


//#if -1408350329 
if(getDestPort(edge) == null || getSourcePort(edge) == null)//1
{ 

//#if -234394010 
throw new IllegalArgumentException(
                "The source and dest port should be provided on an edge");
//#endif 

} 

//#endif 


//#if 2136370914 
if(LOG.isInfoEnabled())//1
{ 

//#if 2122884555 
LOG.info("Adding an edge of type "
                     + edge.getClass().getName()
                     + " to class diagram.");
//#endif 

} 

//#endif 


//#if 1294146389 
if(!canAddEdge(edge))//1
{ 

//#if -1900282737 
LOG.info("Attempt to add edge rejected");
//#endif 


//#if 1701359084 
return;
//#endif 

} 

//#endif 


//#if 1776459806 
getEdges().add(edge);
//#endif 


//#if 205614290 
if(Model.getFacade().isAModelElement(edge)
                && Model.getFacade().getNamespace(edge) == null
                && !Model.getFacade().isAAssociationEnd(edge))//1
{ 

//#if 729913718 
Model.getCoreHelper().addOwnedElement(getHomeModel(), edge);
//#endif 

} 

//#endif 


//#if 475005583 
fireEdgeAdded(edge);
//#endif 

} 

//#endif 


//#if -574427789 
public Object getOwner(Object port)
    { 

//#if 2110153208 
return port;
//#endif 

} 

//#endif 


//#if 1496247109 
@Override
    public boolean canChangeConnectedNode(Object newNode, Object oldNode,
                                          Object edge)
    { 

//#if 739449923 
if(newNode == oldNode)//1
{ 

//#if -1688329 
return false;
//#endif 

} 

//#endif 


//#if -1938104051 
if(!(Model.getFacade().isAClass(newNode)
                || Model.getFacade().isAClass(oldNode)
                || Model.getFacade().isAAssociation(edge)))//1
{ 

//#if 62037734 
return false;
//#endif 

} 

//#endif 


//#if -1436907994 
return true;
//#endif 

} 

//#endif 


//#if 2109235746 
public void vetoableChange(PropertyChangeEvent pce)
    { 

//#if 728334121 
if("ownedElement".equals(pce.getPropertyName()))//1
{ 

//#if -606447893 
List oldOwned = (List) pce.getOldValue();
//#endif 


//#if 1220496665 
Object elementImport = pce.getNewValue();
//#endif 


//#if -1922836842 
Object modelElement =
                Model.getFacade().getModelElement(elementImport);
//#endif 


//#if 1070143205 
if(oldOwned.contains(elementImport))//1
{ 

//#if -863964019 
LOG.debug("model removed " + modelElement);
//#endif 


//#if -1888106340 
if(Model.getFacade().isAClassifier(modelElement))//1
{ 

//#if 1948052577 
removeNode(modelElement);
//#endif 

} 

//#endif 


//#if 2020888791 
if(Model.getFacade().isAPackage(modelElement))//1
{ 

//#if 1324173825 
removeNode(modelElement);
//#endif 

} 

//#endif 


//#if -774231342 
if(Model.getFacade().isAAssociation(modelElement))//1
{ 

//#if -976520654 
removeEdge(modelElement);
//#endif 

} 

//#endif 


//#if -100447418 
if(Model.getFacade().isADependency(modelElement))//1
{ 

//#if -2131365548 
removeEdge(modelElement);
//#endif 

} 

//#endif 


//#if -2073683529 
if(Model.getFacade().isAGeneralization(modelElement))//1
{ 

//#if -208906251 
removeEdge(modelElement);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1668682097 
LOG.debug("model added " + modelElement);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 72400568 
@Override
    public void changeConnectedNode(Object newNode, Object oldNode,
                                    Object edge, boolean isSource)
    { 

//#if 1774702028 
if(Model.getFacade().isAAssociation(edge))//1
{ 

//#if 1628889096 
rerouteAssociation(newNode,  oldNode,  edge,  isSource);
//#endif 

} 
else

//#if 1468018546 
if(Model.getFacade().isAGeneralization(edge))//1
{ 

//#if 638857873 
rerouteGeneralization(newNode,  oldNode,  edge,  isSource);
//#endif 

} 
else

//#if -117738874 
if(Model.getFacade().isADependency(edge))//1
{ 

//#if 546492911 
rerouteDependency(newNode,  oldNode,  edge,  isSource);
//#endif 

} 
else

//#if -1657734381 
if(Model.getFacade().isALink(edge))//1
{ 

//#if 1239839812 
rerouteLink(newNode,  oldNode,  edge,  isSource);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if 1473154035 
public List<Object> getPorts(Object nodeOrEdge)
    { 

//#if 1834475345 
List<Object> res = new ArrayList<Object>();
//#endif 


//#if -1122234397 
if(Model.getFacade().isAClassifier(nodeOrEdge))//1
{ 

//#if 780504802 
res.add(nodeOrEdge);
//#endif 

} 

//#endif 


//#if 435076375 
if(Model.getFacade().isAInstance(nodeOrEdge))//1
{ 

//#if 1422642916 
res.add(nodeOrEdge);
//#endif 

} 

//#endif 


//#if 819421525 
if(Model.getFacade().isAModel(nodeOrEdge))//1
{ 

//#if -1778236353 
res.add(nodeOrEdge);
//#endif 

} 

//#endif 


//#if 1903304436 
if(Model.getFacade().isAStereotype(nodeOrEdge))//1
{ 

//#if -2027320282 
res.add(nodeOrEdge);
//#endif 

} 

//#endif 


//#if 1405967338 
if(Model.getFacade().isASignal(nodeOrEdge))//1
{ 

//#if -1812570288 
res.add(nodeOrEdge);
//#endif 

} 

//#endif 


//#if 430410940 
return res;
//#endif 

} 

//#endif 


//#if -649620409 
@Override
    public void addNode(Object node)
    { 

//#if 1332304349 
if(!canAddNode(node))//1
{ 

//#if -999626860 
return;
//#endif 

} 

//#endif 


//#if -1936508416 
getNodes().add(node);
//#endif 


//#if -1274448770 
if(Model.getFacade().isAModelElement(node)
                && Model.getFacade().getNamespace(node) == null)//1
{ 

//#if -1320380342 
Model.getCoreHelper().addOwnedElement(getHomeModel(), node);
//#endif 

} 

//#endif 


//#if 1825507329 
fireNodeAdded(node);
//#endif 

} 

//#endif 


//#if 2058915472 
private void rerouteDependency(Object newNode, Object oldNode,
                                   Object edge, boolean isSource)
    { 
} 

//#endif 


//#if 1822589759 
private void rerouteLink(Object newNode, Object oldNode,
                             Object edge, boolean isSource)
    { 
} 

//#endif 


//#if 292710894 
private void rerouteAssociation(Object newNode, Object oldNode,
                                    Object edge, boolean isSource)
    { 

//#if -75598903 
if(!(Model.getFacade().isAClassifier(newNode))
                || !(Model.getFacade().isAClassifier(oldNode)))//1
{ 

//#if -1583094302 
return;
//#endif 

} 

//#endif 


//#if -739001895 
Object otherNode = null;
//#endif 


//#if -7150521 
if(isSource)//1
{ 

//#if 1149401568 
otherNode = Model.getCoreHelper().getDestination(edge);
//#endif 

} 
else
{ 

//#if 2146847692 
otherNode = Model.getCoreHelper().getSource(edge);
//#endif 

} 

//#endif 


//#if 797030994 
if(Model.getFacade().isAInterface(newNode)
                && Model.getFacade().isAInterface(otherNode))//1
{ 

//#if -244432940 
return;
//#endif 

} 

//#endif 


//#if 1900324617 
Object edgeAssoc = edge;
//#endif 


//#if 1363216881 
Object theEnd = null;
//#endif 


//#if 1225465955 
Object theOtherEnd = null;
//#endif 


//#if 40106682 
Collection connections = Model.getFacade().getConnections(edgeAssoc);
//#endif 


//#if 2044846349 
Iterator iter = connections.iterator();
//#endif 


//#if 1727270154 
if(isSource)//2
{ 

//#if 1984005907 
theEnd = iter.next();
//#endif 


//#if 527922435 
theOtherEnd = iter.next();
//#endif 

} 
else
{ 

//#if -2003932343 
theOtherEnd = iter.next();
//#endif 


//#if -854639347 
theEnd = iter.next();
//#endif 

} 

//#endif 


//#if -21803682 
Model.getCoreHelper().setType(theEnd, newNode);
//#endif 

} 

//#endif 


//#if 889300161 
private void rerouteGeneralization(Object newNode, Object oldNode,
                                       Object edge, boolean isSource)
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

