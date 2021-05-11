
//#if -39078876 
// Compilation Unit of /UMLMutableGraphSupport.java 
 

//#if 569802188 
package org.argouml.uml.diagram;
//#endif 


//#if 1509253538 
import java.util.ArrayList;
//#endif 


//#if 881817599 
import java.util.Collection;
//#endif 


//#if 1570055 
import java.util.Dictionary;
//#endif 


//#if 447518895 
import java.util.Iterator;
//#endif 


//#if 340121471 
import java.util.List;
//#endif 


//#if 1673561597 
import java.util.Map;
//#endif 


//#if 676823071 
import org.apache.log4j.Logger;
//#endif 


//#if -362083784 
import org.argouml.kernel.Project;
//#endif 


//#if -1806543155 
import org.argouml.model.DiDiagram;
//#endif 


//#if -1770607726 
import org.argouml.model.Model;
//#endif 


//#if 1439126624 
import org.argouml.model.UmlException;
//#endif 


//#if 1282520916 
import org.argouml.uml.CommentEdge;
//#endif 


//#if 698279699 
import org.tigris.gef.base.Editor;
//#endif 


//#if -1972687098 
import org.tigris.gef.base.Globals;
//#endif 


//#if -2127873315 
import org.tigris.gef.base.Mode;
//#endif 


//#if -1269746324 
import org.tigris.gef.base.ModeManager;
//#endif 


//#if -1566974378 
import org.tigris.gef.graph.MutableGraphSupport;
//#endif 


//#if 1534489927 
public abstract class UMLMutableGraphSupport extends 
//#if -1024787367 
MutableGraphSupport
//#endif 

  { 

//#if -670831341 
private static final Logger LOG =
        Logger.getLogger(UMLMutableGraphSupport.class);
//#endif 


//#if 1545049638 
private DiDiagram diDiagram;
//#endif 


//#if -1478727292 
private List nodes = new ArrayList();
//#endif 


//#if -1417234647 
private List edges = new ArrayList();
//#endif 


//#if 653050533 
private Object homeModel;
//#endif 


//#if 444507526 
private Project project;
//#endif 


//#if 1350208016 
public Object connect(Object fromPort, Object toPort, Object edgeType)
    { 

//#if 269851064 
Editor curEditor = Globals.curEditor();
//#endif 


//#if -1253398152 
ModeManager modeManager = curEditor.getModeManager();
//#endif 


//#if -1681896752 
Mode mode = modeManager.top();
//#endif 


//#if 26073944 
Dictionary args = mode.getArgs();
//#endif 


//#if -5069556 
Object style = args.get("aggregation");
//#endif 


//#if -1667855267 
Boolean unidirectional = (Boolean) args.get("unidirectional");
//#endif 


//#if 721056992 
Object model = getProject().getModel();
//#endif 


//#if -1338587343 
Object connection =
            buildConnection(
                edgeType, fromPort, style, toPort,
                null, unidirectional,
                model);
//#endif 


//#if -909813912 
if(connection == null)//1
{ 

//#if -227282309 
if(LOG.isDebugEnabled())//1
{ 

//#if -701925120 
LOG.debug("Cannot make a " + edgeType
                          + " between a " + fromPort.getClass().getName()
                          + " and a " + toPort.getClass().getName());
//#endif 

} 

//#endif 


//#if -1407592727 
return null;
//#endif 

} 

//#endif 


//#if -544925238 
addEdge(connection);
//#endif 


//#if -1851051610 
if(LOG.isDebugEnabled())//1
{ 

//#if 458946083 
LOG.debug("Connection type" + edgeType
                      + " made between a " + fromPort.getClass().getName()
                      + " and a " + toPort.getClass().getName());
//#endif 

} 

//#endif 


//#if -1492197987 
return connection;
//#endif 

} 

//#endif 


//#if -1820342694 
protected boolean isConnectionValid(
        Object edgeType,
        Object fromElement,
        Object toElement)
    { 

//#if -1568265630 
if(!nodes.contains(fromElement) || !nodes.contains(toElement))//1
{ 

//#if 628898193 
return false;
//#endif 

} 

//#endif 


//#if -1670018942 
if(edgeType.equals(CommentEdge.class))//1
{ 

//#if 966640446 
return ((Model.getFacade().isAComment(fromElement)
                     && Model.getFacade().isAModelElement(toElement))
                    || (Model.getFacade().isAComment(toElement)
                        && Model.getFacade().isAModelElement(fromElement)));
//#endif 

} 

//#endif 


//#if 62025514 
return Model.getUmlFactory().isConnectionValid(
                   edgeType,
                   fromElement,
                   toElement,
                   true);
//#endif 

} 

//#endif 


//#if 1214903403 
public UMLMutableGraphSupport()
    { 

//#if -1685606789 
super();
//#endif 

} 

//#endif 


//#if -1506483544 
public Object getDestPort(Object edge)
    { 

//#if -2138937602 
if(edge instanceof CommentEdge)//1
{ 

//#if 123387412 
return ((CommentEdge) edge).getDestination();
//#endif 

} 
else

//#if -1173521545 
if(Model.getFacade().isAAssociation(edge))//1
{ 

//#if -1826601733 
List conns = new ArrayList(Model.getFacade().getConnections(edge));
//#endif 


//#if -1976456159 
return conns.get(1);
//#endif 

} 
else

//#if 280349182 
if(Model.getFacade().isARelationship(edge)
                   || Model.getFacade().isATransition(edge)
                   || Model.getFacade().isAAssociationEnd(edge))//1
{ 

//#if 810563923 
return Model.getUmlHelper().getDestination(edge);
//#endif 

} 
else

//#if -1885598035 
if(Model.getFacade().isALink(edge))//1
{ 

//#if 910993686 
return Model.getCommonBehaviorHelper().getDestination(edge);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#if 1477641229 
LOG.error(this.getClass().toString() + ": getDestPort("
                  + edge.toString() + ") - can't handle");
//#endif 


//#if 465397814 
return null;
//#endif 

} 

//#endif 


//#if -1329293430 
public Object connect(Object fromPort, Object toPort, Object edgeType,
                          Map styleAttributes)
    { 

//#if 1908376891 
return null;
//#endif 

} 

//#endif 


//#if -1177207028 
public void setProject(Project p)
    { 

//#if 2081966304 
project = p;
//#endif 

} 

//#endif 


//#if -188088509 
public Object connect(Object fromPort, Object toPort, Class edgeClass)
    { 

//#if 2128295660 
return connect(fromPort, toPort, (Object) edgeClass);
//#endif 

} 

//#endif 


//#if 1189341408 
public CommentEdge buildCommentConnection(Object from, Object to)
    { 

//#if -1185430868 
if(from == null || to == null)//1
{ 

//#if 2128348394 
throw new IllegalArgumentException("Either fromNode == null "
                                               + "or toNode == null");
//#endif 

} 

//#endif 


//#if 1525220253 
Object comment = null;
//#endif 


//#if 157815444 
Object annotatedElement = null;
//#endif 


//#if -2017095142 
if(Model.getFacade().isAComment(from))//1
{ 

//#if 1048423123 
comment = from;
//#endif 


//#if -158459641 
annotatedElement = to;
//#endif 

} 
else
{ 

//#if -1688536385 
if(Model.getFacade().isAComment(to))//1
{ 

//#if 1906732220 
comment = to;
//#endif 


//#if 628972958 
annotatedElement = from;
//#endif 

} 
else
{ 

//#if 487158807 
return null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 8522944 
CommentEdge connection = new CommentEdge(from, to);
//#endif 


//#if 648392687 
Model.getCoreHelper().addAnnotatedElement(comment, annotatedElement);
//#endif 


//#if 251901811 
return connection;
//#endif 

} 

//#endif 


//#if 430032321 
@Override
    public void removeEdge(Object edge)
    { 

//#if -1926897601 
if(!containsEdge(edge))//1
{ 

//#if -1203012333 
return;
//#endif 

} 

//#endif 


//#if 1022202970 
edges.remove(edge);
//#endif 


//#if -764563477 
fireEdgeRemoved(edge);
//#endif 

} 

//#endif 


//#if 1454520865 
public Object getSourcePort(Object edge)
    { 

//#if -1012033314 
if(edge instanceof CommentEdge)//1
{ 

//#if 1048134453 
return ((CommentEdge) edge).getSource();
//#endif 

} 
else

//#if 665210822 
if(Model.getFacade().isARelationship(edge)
                   || Model.getFacade().isATransition(edge)
                   || Model.getFacade().isAAssociationEnd(edge))//1
{ 

//#if -1555606438 
return Model.getUmlHelper().getSource(edge);
//#endif 

} 
else

//#if 271011084 
if(Model.getFacade().isALink(edge))//1
{ 

//#if 1657055224 
return Model.getCommonBehaviorHelper().getSource(edge);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#if -2049025626 
LOG.error(this.getClass().toString() + ": getSourcePort("
                  + edge.toString() + ") - can't handle");
//#endif 


//#if -556086698 
return null;
//#endif 

} 

//#endif 


//#if -1268170237 
public void addNodeRelatedEdges(Object node)
    { 

//#if 1075076564 
if(Model.getFacade().isAModelElement(node))//1
{ 

//#if -1694729761 
List specs =
                new ArrayList(Model.getFacade().getClientDependencies(node));
//#endif 


//#if 671511292 
specs.addAll(Model.getFacade().getSupplierDependencies(node));
//#endif 


//#if 1776592179 
Iterator iter = specs.iterator();
//#endif 


//#if -367993781 
while (iter.hasNext()) //1
{ 

//#if 64698512 
Object dependency = iter.next();
//#endif 


//#if -1887878301 
if(canAddEdge(dependency))//1
{ 

//#if -1674383268 
addEdge(dependency);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1726745092 
Collection cmnt = new ArrayList();
//#endif 


//#if 1614472172 
if(Model.getFacade().isAComment(node))//1
{ 

//#if -183559908 
cmnt.addAll(Model.getFacade().getAnnotatedElements(node));
//#endif 

} 

//#endif 


//#if 34868317 
if(Model.getFacade().isAModelElement(node))//2
{ 

//#if 563773022 
cmnt.addAll(Model.getFacade().getComments(node));
//#endif 

} 

//#endif 


//#if 1426243061 
Iterator iter = cmnt.iterator();
//#endif 


//#if 910907719 
while (iter.hasNext()) //1
{ 

//#if -828982520 
Object ae = iter.next();
//#endif 


//#if -10968394 
CommentEdge ce = new CommentEdge(node, ae);
//#endif 


//#if -1213332643 
if(canAddEdge(ce))//1
{ 

//#if 384553507 
addEdge(ce);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -344046332 
public boolean canAddNode(Object node)
    { 

//#if -191809565 
if(node == null)//1
{ 

//#if 1869698824 
return false;
//#endif 

} 

//#endif 


//#if -201640957 
if(Model.getFacade().isAComment(node))//1
{ 

//#if -1395354121 
return true;
//#endif 

} 

//#endif 


//#if -1765328255 
return false;
//#endif 

} 

//#endif 


//#if -40118315 
void setDiDiagram(DiDiagram dd)
    { 

//#if 1172542705 
diDiagram = dd;
//#endif 

} 

//#endif 


//#if -972719132 
public boolean canAddEdge(Object edge)
    { 

//#if -2102769874 
if(edge instanceof CommentEdge)//1
{ 

//#if 1555772264 
CommentEdge ce = (CommentEdge) edge;
//#endif 


//#if 1462494203 
return isConnectionValid(CommentEdge.class,
                                     ce.getSource(),
                                     ce.getDestination());
//#endif 

} 
else

//#if -1572980682 
if(edge != null
                   && Model.getUmlFactory().isConnectionType(edge))//1
{ 

//#if -1212582015 
return isConnectionValid(edge.getClass(),
                                     Model.getUmlHelper().getSource(edge),
                                     Model.getUmlHelper().getDestination(edge));
//#endif 

} 

//#endif 


//#endif 


//#if -1610286266 
return false;
//#endif 

} 

//#endif 


//#if 1058705121 
@Override
    public void removeNode(Object node)
    { 

//#if 138897566 
if(!containsNode(node))//1
{ 

//#if -338782535 
return;
//#endif 

} 

//#endif 


//#if 1286229467 
nodes.remove(node);
//#endif 


//#if 1550804340 
fireNodeRemoved(node);
//#endif 

} 

//#endif 


//#if 1583786320 
public DiDiagram getDiDiagram()
    { 

//#if 261946698 
return diDiagram;
//#endif 

} 

//#endif 


//#if -1370020853 
public Object getHomeModel()
    { 

//#if -1641334844 
return homeModel;
//#endif 

} 

//#endif 


//#if -1423318143 
public boolean constainsEdge(Object edge)
    { 

//#if 27137485 
return edges.contains(edge);
//#endif 

} 

//#endif 


//#if -709538359 
protected Object buildConnection(
        Object edgeType,
        Object fromElement,
        Object fromStyle,
        Object toElement,
        Object toStyle,
        Object unidirectional,
        Object namespace)
    { 

//#if 302858636 
Object connection = null;
//#endif 


//#if -1649957276 
if(edgeType == CommentEdge.class)//1
{ 

//#if 141240884 
connection =
                buildCommentConnection(fromElement, toElement);
//#endif 

} 
else
{ 

//#if 1751389532 
try //1
{ 

//#if 1078852196 
connection =
                    Model.getUmlFactory().buildConnection(
                        edgeType,
                        fromElement,
                        fromStyle,
                        toElement,
                        toStyle,
                        unidirectional,
                        namespace);
//#endif 


//#if 460212778 
LOG.info("Created " + connection + " between "
                         + fromElement + " and " + toElement);
//#endif 

} 

//#if -1433245659 
catch (UmlException ex) //1
{ 
} 

//#endif 


//#if 945071914 
catch (IllegalArgumentException iae) //1
{ 

//#if 1542192885 
LOG.warn("IllegalArgumentException caught", iae);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1656159083 
return connection;
//#endif 

} 

//#endif 


//#if -988621899 
public boolean canConnect(Object fromP, Object toP)
    { 

//#if 1312226418 
return true;
//#endif 

} 

//#endif 


//#if -1619139631 
public List getNodes()
    { 

//#if -1162777000 
return nodes;
//#endif 

} 

//#endif 


//#if -1328888266 
public List getEdges()
    { 

//#if 2062516660 
return edges;
//#endif 

} 

//#endif 


//#if -1604245082 
public Project getProject()
    { 

//#if -376349484 
return project;
//#endif 

} 

//#endif 


//#if -1284360142 
public boolean containsNode(Object node)
    { 

//#if 455834857 
return nodes.contains(node);
//#endif 

} 

//#endif 


//#if -1184631310 
public boolean isRemoveFromDiagramAllowed(Collection figs)
    { 

//#if 888111264 
return !figs.isEmpty();
//#endif 

} 

//#endif 


//#if -613342512 
public void setHomeModel(Object ns)
    { 

//#if 284395245 
if(!Model.getFacade().isANamespace(ns))//1
{ 

//#if 461549749 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if -2047124938 
homeModel = ns;
//#endif 

} 

//#endif 


//#if -822414464 
public Object connect(Object fromPort, Object toPort)
    { 

//#if 889791424 
throw new UnsupportedOperationException(
            "The connect method is not supported");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

