
//#if 1543752445 
// Compilation Unit of /UseCaseDiagramGraphModel.java 
 

//#if -1876373377 
package org.argouml.uml.diagram.use_case;
//#endif 


//#if -936894060 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -958196571 
import java.beans.VetoableChangeListener;
//#endif 


//#if -178850323 
import java.util.ArrayList;
//#endif 


//#if 90205460 
import java.util.Collection;
//#endif 


//#if -1498596241 
import java.util.Collections;
//#endif 


//#if 670158596 
import java.util.Iterator;
//#endif 


//#if -1109032876 
import java.util.List;
//#endif 


//#if 1425012458 
import org.apache.log4j.Logger;
//#endif 


//#if -1022418339 
import org.argouml.model.Model;
//#endif 


//#if -150220641 
import org.argouml.uml.CommentEdge;
//#endif 


//#if -1431746195 
import org.argouml.uml.diagram.UMLMutableGraphSupport;
//#endif 


//#if -1329661214 
public class UseCaseDiagramGraphModel extends 
//#if -863407123 
UMLMutableGraphSupport
//#endif 

 implements 
//#if 1426436066 
VetoableChangeListener
//#endif 

  { 

//#if -870215413 
private static final Logger LOG =
        Logger.getLogger(UseCaseDiagramGraphModel.class);
//#endif 


//#if 1953717823 
static final long serialVersionUID = -8516841965639203796L;
//#endif 


//#if 1911795456 
public Object getOwner(Object port)
    { 

//#if -944947008 
return port;
//#endif 

} 

//#endif 


//#if 427388660 
@Override
    public void addEdge(Object edge)
    { 

//#if 22494728 
if(edge == null)//1
{ 

//#if 879632424 
throw new IllegalArgumentException("Cannot add a null edge");
//#endif 

} 

//#endif 


//#if 493936221 
if(getDestPort(edge) == null || getSourcePort(edge) == null)//1
{ 

//#if -1241748661 
throw new IllegalArgumentException(
                "The source and dest port should be provided on an edge");
//#endif 

} 

//#endif 


//#if 796973772 
if(LOG.isInfoEnabled())//1
{ 

//#if 1153486577 
LOG.info("Adding an edge of type "
                     + edge.getClass().getName()
                     + " to use case diagram.");
//#endif 

} 

//#endif 


//#if 233535935 
if(!canAddEdge(edge))//1
{ 

//#if 1919916539 
LOG.info("Attempt to add edge rejected");
//#endif 


//#if 649023576 
return;
//#endif 

} 

//#endif 


//#if -710219276 
getEdges().add(edge);
//#endif 


//#if -97021889 
if(Model.getFacade().isAUMLElement(edge)
                && Model.getFacade().getNamespace(edge) == null)//1
{ 

//#if -1492384944 
Model.getCoreHelper().addOwnedElement(getHomeModel(), edge);
//#endif 

} 

//#endif 


//#if 671884793 
fireEdgeAdded(edge);
//#endif 

} 

//#endif 


//#if 1056061460 
@Override
    public void addNode(Object node)
    { 

//#if 178738706 
LOG.debug("adding usecase node");
//#endif 


//#if 899958173 
if(!canAddNode(node))//1
{ 

//#if -708591245 
return;
//#endif 

} 

//#endif 


//#if -1419385280 
getNodes().add(node);
//#endif 


//#if -976112589 
if(Model.getFacade().isAUMLElement(node)
                && Model.getFacade().getNamespace(node) == null)//1
{ 

//#if -1540203483 
Model.getCoreHelper().addOwnedElement(getHomeModel(), node);
//#endif 

} 

//#endif 


//#if -1898589247 
fireNodeAdded(node);
//#endif 

} 

//#endif 


//#if -1188620386 
public List getOutEdges(Object port)
    { 

//#if -2005989818 
return Collections.EMPTY_LIST;
//#endif 

} 

//#endif 


//#if -690143079 
@Override
    public boolean canConnect(Object fromP, Object toP)
    { 

//#if -888184888 
if(Model.getFacade().isAActor(fromP)
                && Model.getFacade().isAActor(toP))//1
{ 

//#if 1558642604 
return false;
//#endif 

} 

//#endif 


//#if -108800159 
return true;
//#endif 

} 

//#endif 


//#if 802580911 
public void vetoableChange(PropertyChangeEvent pce)
    { 

//#if 908109077 
if("ownedElement".equals(pce.getPropertyName()))//1
{ 

//#if 2034028750 
List oldOwned = (List) pce.getOldValue();
//#endif 


//#if 1558548164 
Object eo = /*(MElementImport)*/ pce.getNewValue();
//#endif 


//#if 1184847447 
Object  me = Model.getFacade().getModelElement(eo);
//#endif 


//#if -1069888049 
if(oldOwned.contains(eo))//1
{ 

//#if -352073509 
LOG.debug("model removed " + me);
//#endif 


//#if -699868177 
if((Model.getFacade().isAActor(me))
                        || (Model.getFacade().isAUseCase(me)))//1
{ 

//#if -603170936 
removeNode(me);
//#endif 

} 
else

//#if 680933170 
if((Model.getFacade().isAAssociation(me))
                           || (Model.getFacade().isAGeneralization(me))
                           || (Model.getFacade().isAExtend(me))
                           || (Model.getFacade().isAInclude(me))
                           || (Model.getFacade().isADependency(me)))//1
{ 

//#if -279902903 
removeEdge(me);
//#endif 

} 

//#endif 


//#endif 

} 
else
{ 

//#if 838726615 
LOG.debug("model added " + me);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1064763040 
@Override
    public boolean canAddNode(Object node)
    { 

//#if -17924526 
if(Model.getFacade().isAAssociation(node)
                && !Model.getFacade().isANaryAssociation(node))//1
{ 

//#if 1060837213 
return false;
//#endif 

} 

//#endif 


//#if 1298076074 
if(super.canAddNode(node))//1
{ 

//#if 1543810494 
return true;
//#endif 

} 

//#endif 


//#if -1123242363 
if(containsNode(node))//1
{ 

//#if -1629823961 
return false;
//#endif 

} 

//#endif 


//#if -1756935027 
return Model.getFacade().isAActor(node)
               || Model.getFacade().isAUseCase(node)
               || Model.getFacade().isAPackage(node);
//#endif 

} 

//#endif 


//#if 436090240 
@Override
    public boolean canAddEdge(Object edge)
    { 

//#if -466874811 
if(edge == null)//1
{ 

//#if -505445254 
return false;
//#endif 

} 

//#endif 


//#if -1104477055 
if(containsEdge(edge))//1
{ 

//#if -1435074942 
return false;
//#endif 

} 

//#endif 


//#if 499907894 
Object sourceModelElement = null;
//#endif 


//#if 2027661373 
Object destModelElement = null;
//#endif 


//#if -310142415 
if(Model.getFacade().isAAssociation(edge))//1
{ 

//#if -1651058065 
Collection conns = Model.getFacade().getConnections(edge);
//#endif 


//#if -651488895 
Iterator iter = conns.iterator();
//#endif 


//#if -446788577 
if(conns.size() < 2)//1
{ 

//#if -1853628539 
return false;
//#endif 

} 

//#endif 


//#if -377811158 
Object associationEnd0 = iter.next();
//#endif 


//#if -883369783 
Object associationEnd1 = iter.next();
//#endif 


//#if 1700379391 
if((associationEnd0 == null) || (associationEnd1 == null))//1
{ 

//#if -239159370 
return false;
//#endif 

} 

//#endif 


//#if -414974926 
sourceModelElement = Model.getFacade().getType(associationEnd0);
//#endif 


//#if 244389434 
destModelElement = Model.getFacade().getType(associationEnd1);
//#endif 

} 
else

//#if -1760544288 
if(Model.getFacade().isAGeneralization(edge))//1
{ 

//#if 1816269974 
sourceModelElement = Model.getFacade().getSpecific(edge);
//#endif 


//#if 2122791077 
destModelElement = Model.getFacade().getGeneral(edge);
//#endif 

} 
else

//#if 1342759514 
if(Model.getFacade().isAExtend(edge))//1
{ 

//#if -1507314930 
sourceModelElement = Model.getFacade().getBase(edge);
//#endif 


//#if 1990396951 
destModelElement = Model.getFacade().getExtension(edge);
//#endif 

} 
else

//#if 2141602253 
if(Model.getFacade().isAInclude(edge))//1
{ 

//#if -769407562 
sourceModelElement = Model.getFacade().getBase(edge);
//#endif 


//#if 1738680516 
destModelElement = Model.getFacade().getAddition(edge);
//#endif 

} 
else

//#if 264186485 
if(Model.getFacade().isADependency(edge))//1
{ 

//#if -1837028579 
Collection clients   = Model.getFacade().getClients(edge);
//#endif 


//#if 1106763709 
Collection suppliers = Model.getFacade().getSuppliers(edge);
//#endif 


//#if 1031168222 
if(clients == null || clients.isEmpty()
                    || suppliers == null || suppliers.isEmpty())//1
{ 

//#if 493682236 
return false;
//#endif 

} 

//#endif 


//#if -1118344310 
sourceModelElement = clients.iterator().next();
//#endif 


//#if 1622791332 
destModelElement = suppliers.iterator().next();
//#endif 

} 
else

//#if 1983890146 
if(edge instanceof CommentEdge)//1
{ 

//#if -1003371205 
sourceModelElement = ((CommentEdge) edge).getSource();
//#endif 


//#if -1825747977 
destModelElement = ((CommentEdge) edge).getDestination();
//#endif 

} 
else
{ 

//#if -569766973 
return false;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#if 118891282 
if(sourceModelElement == null || destModelElement == null)//1
{ 

//#if 1803976424 
LOG.error("Edge rejected. Its ends are not attached to anything");
//#endif 


//#if -1113735007 
return false;
//#endif 

} 

//#endif 


//#if 1234239420 
if(!containsNode(sourceModelElement)
                && !containsEdge(sourceModelElement))//1
{ 

//#if -217419521 
LOG.error("Edge rejected. Its source end is attached to "
                      + sourceModelElement
                      + " but this is not in the graph model");
//#endif 


//#if -2005395514 
return false;
//#endif 

} 

//#endif 


//#if -177832740 
if(!containsNode(destModelElement)
                && !containsEdge(destModelElement))//1
{ 

//#if 705136527 
LOG.error("Edge rejected. Its destination end is attached to "
                      + destModelElement
                      + " but this is not in the graph model");
//#endif 


//#if -692811480 
return false;
//#endif 

} 

//#endif 


//#if 653190635 
return true;
//#endif 

} 

//#endif 


//#if -454041667 
public List getPorts(Object nodeOrEdge)
    { 

//#if -207520613 
if(Model.getFacade().isAActor(nodeOrEdge))//1
{ 

//#if -1803190459 
List result = new ArrayList();
//#endif 


//#if 1671379784 
result.add(nodeOrEdge);
//#endif 


//#if 1704421482 
return result;
//#endif 

} 
else

//#if -267947197 
if(Model.getFacade().isAUseCase(nodeOrEdge))//1
{ 

//#if -1845931634 
List result = new ArrayList();
//#endif 


//#if 1160295839 
result.add(nodeOrEdge);
//#endif 


//#if 1968083841 
return result;
//#endif 

} 

//#endif 


//#endif 


//#if 936086667 
return Collections.EMPTY_LIST;
//#endif 

} 

//#endif 


//#if -880847201 
@Override
    public void addNodeRelatedEdges(Object node)
    { 

//#if 800250564 
super.addNodeRelatedEdges(node);
//#endif 


//#if -1442058895 
if(Model.getFacade().isAUseCase(node))//1
{ 

//#if -1418790646 
List relations = new ArrayList();
//#endif 


//#if 1526449780 
relations.addAll(Model.getFacade().getIncludes(node));
//#endif 


//#if -157673566 
relations.addAll(Model.getFacade().getIncluders(node));
//#endif 


//#if 2087507282 
relations.addAll(Model.getFacade().getExtends(node));
//#endif 


//#if -929978427 
relations.addAll(Model.getFacade().getExtenders(node));
//#endif 


//#if 657137268 
for (Object relation : relations) //1
{ 

//#if 573817439 
if(canAddEdge(relation))//1
{ 

//#if 768413801 
addEdge(relation);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -730899019 
if(Model.getFacade().isAClassifier(node))//1
{ 

//#if 64647168 
Collection ends = Model.getFacade().getAssociationEnds(node);
//#endif 


//#if -1635463320 
for (Object ae : ends) //1
{ 

//#if 967963222 
if(canAddEdge(Model.getFacade().getAssociation(ae)))//1
{ 

//#if 1433395305 
addEdge(Model.getFacade().getAssociation(ae));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1203959843 
if(Model.getFacade().isAGeneralizableElement(node))//1
{ 

//#if 692252443 
Collection gn = Model.getFacade().getGeneralizations(node);
//#endif 


//#if -730248678 
for (Object g : gn) //1
{ 

//#if 2122881191 
if(canAddEdge(g))//1
{ 

//#if -1535377687 
addEdge(g);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1070605216 
Collection sp = Model.getFacade().getSpecializations(node);
//#endif 


//#if -945964284 
for (Object s : sp) //1
{ 

//#if 652829158 
if(canAddEdge(s))//1
{ 

//#if 991424036 
addEdge(s);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -413987236 
if(Model.getFacade().isAUMLElement(node))//1
{ 

//#if -180444952 
Collection dependencies =
                new ArrayList(Model.getFacade().getClientDependencies(node));
//#endif 


//#if -2082275007 
dependencies.addAll(Model.getFacade().getSupplierDependencies(node));
//#endif 


//#if 631210668 
for (Object dependency : dependencies) //1
{ 

//#if -1679158530 
if(canAddEdge(dependency))//1
{ 

//#if -1097208924 
addEdge(dependency);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -637060771 
public List getInEdges(Object port)
    { 

//#if 1505535531 
if(Model.getFacade().isAActor(port)
                || Model.getFacade().isAUseCase(port))//1
{ 

//#if 2108734823 
List result = new ArrayList();
//#endif 


//#if 731078709 
Collection ends = Model.getFacade().getAssociationEnds(port);
//#endif 


//#if 415890700 
if(ends == null)//1
{ 

//#if 1565839392 
return Collections.EMPTY_LIST;
//#endif 

} 

//#endif 


//#if -1145095118 
for (Object ae : ends) //1
{ 

//#if 2074574851 
result.add(Model.getFacade().getAssociation(ae));
//#endif 

} 

//#endif 


//#if 387439368 
return result;
//#endif 

} 

//#endif 


//#if 503765880 
return Collections.EMPTY_LIST;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

