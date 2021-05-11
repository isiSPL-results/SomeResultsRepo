
//#if 1407298459 
// Compilation Unit of /StateDiagramGraphModel.java 
 

//#if 1185891185 
package org.argouml.uml.diagram.state;
//#endif 


//#if -315013657 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 1286941554 
import java.beans.VetoableChangeListener;
//#endif 


//#if 372328314 
import java.util.ArrayList;
//#endif 


//#if -3125977 
import java.util.Collection;
//#endif 


//#if -96903492 
import java.util.Collections;
//#endif 


//#if -420440105 
import java.util.Iterator;
//#endif 


//#if 1098361511 
import java.util.List;
//#endif 


//#if -167986697 
import org.apache.log4j.Logger;
//#endif 


//#if -2035399287 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1679549802 
import org.argouml.model.Model;
//#endif 


//#if -290044628 
import org.argouml.uml.CommentEdge;
//#endif 


//#if -1744476224 
import org.argouml.uml.diagram.UMLMutableGraphSupport;
//#endif 


//#if 1837831521 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1479006341 
public class StateDiagramGraphModel extends 
//#if -1964780801 
UMLMutableGraphSupport
//#endif 

 implements 
//#if 325062388 
VetoableChangeListener
//#endif 

  { 

//#if -915459777 
private static final Logger LOG =
        Logger.getLogger(StateDiagramGraphModel.class);
//#endif 


//#if -136955766 
private Object machine;
//#endif 


//#if -2015071307 
static final long serialVersionUID = -8056507319026044174L;
//#endif 


//#if 962390251 
public void changeConnectedNode(Object newNode, Object oldNode,
                                    Object edge, boolean isSource)
    { 

//#if -766612975 
if(isSource)//1
{ 

//#if -1558234090 
Model.getStateMachinesHelper().setSource(edge, newNode);
//#endif 

} 
else
{ 

//#if 1312100594 
Model.getCommonBehaviorHelper().setTarget(edge, newNode);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1946146555 
public void addNodeRelatedEdges(Object node)
    { 

//#if -317401475 
super.addNodeRelatedEdges(node);
//#endif 


//#if -811522154 
if(Model.getFacade().isAStateVertex(node))//1
{ 

//#if 1476824865 
Collection transen =
                new ArrayList(Model.getFacade().getOutgoings(node));
//#endif 


//#if -152601781 
transen.addAll(Model.getFacade().getIncomings(node));
//#endif 


//#if 167410402 
Iterator iter = transen.iterator();
//#endif 


//#if 1550082945 
while (iter.hasNext()) //1
{ 

//#if 670655250 
Object dep = /* (MTransition) */iter.next();
//#endif 


//#if 2080487900 
if(canAddEdge(dep))//1
{ 

//#if -1698638866 
addEdge(dep);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1179347439 
public List getInEdges(Object port)
    { 

//#if -1132937224 
if(Model.getFacade().isAStateVertex(port))//1
{ 

//#if -1325995217 
return new ArrayList(Model.getFacade().getIncomings(port));
//#endif 

} 

//#endif 


//#if 1951295282 
LOG.debug("TODO: getInEdges of MState");
//#endif 


//#if 1481556167 
return Collections.EMPTY_LIST;
//#endif 

} 

//#endif 


//#if -1133812778 
public void setMachine(Object sm)
    { 

//#if 1605048946 
if(!Model.getFacade().isAStateMachine(sm))//1
{ 

//#if -1665197844 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if 480053822 
if(sm != null)//1
{ 

//#if 342266890 
machine = sm;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1912198566 
public void addEdge(Object edge)
    { 

//#if -824081318 
LOG.debug("adding statechart/activity diagram edge!!!!!!");
//#endif 


//#if 571705593 
if(!canAddEdge(edge))//1
{ 

//#if 1698462614 
return;
//#endif 

} 

//#endif 


//#if 1519236346 
getEdges().add(edge);
//#endif 


//#if -641670605 
fireEdgeAdded(edge);
//#endif 

} 

//#endif 


//#if -1498568392 
public boolean canChangeConnectedNode(Object newNode, Object oldNode,
                                          Object edge)
    { 

//#if 1425334831 
if(newNode == oldNode)//1
{ 

//#if -852127190 
return false;
//#endif 

} 

//#endif 


//#if 507222051 
if(!(Model.getFacade().isAState(newNode)
                || Model.getFacade().isAState(oldNode)
                || Model.getFacade().isATransition(edge)))//1
{ 

//#if 55637435 
return false;
//#endif 

} 

//#endif 


//#if -165358394 
Object otherSideNode = Model.getFacade().getSource(edge);
//#endif 


//#if 570043944 
if(otherSideNode == oldNode)//1
{ 

//#if -1505760875 
otherSideNode = Model.getFacade().getTarget(edge);
//#endif 

} 

//#endif 


//#if -2024246882 
if(Model.getFacade().isACompositeState(newNode)
                && Model.getStateMachinesHelper().getAllSubStates(newNode)
                .contains(otherSideNode))//1
{ 

//#if -863976166 
return false;
//#endif 

} 

//#endif 


//#if -1163604462 
return true;
//#endif 

} 

//#endif 


//#if -714540724 
public List getOutEdges(Object port)
    { 

//#if 592906241 
if(Model.getFacade().isAStateVertex(port))//1
{ 

//#if 1733660667 
return new ArrayList(Model.getFacade().getOutgoings(port));
//#endif 

} 

//#endif 


//#if 712714462 
LOG.debug("TODO: getOutEdges of MState");
//#endif 


//#if 1198013136 
return Collections.EMPTY_LIST;
//#endif 

} 

//#endif 


//#if 1855665729 
public void vetoableChange(PropertyChangeEvent pce)
    { 

//#if 502863426 
if("ownedElement".equals(pce.getPropertyName()))//1
{ 

//#if 910603932 
Collection oldOwned = (Collection) pce.getOldValue();
//#endif 


//#if 958701778 
Object eo = /* (MElementImport) */pce.getNewValue();
//#endif 


//#if 585001061 
Object me = Model.getFacade().getModelElement(eo);
//#endif 


//#if -308721023 
if(oldOwned.contains(eo))//1
{ 

//#if 2130093921 
LOG.debug("model removed " + me);
//#endif 


//#if 1689305676 
if(Model.getFacade().isAState(me))//1
{ 

//#if 1297743870 
removeNode(me);
//#endif 

} 

//#endif 


//#if 1093821902 
if(Model.getFacade().isAPseudostate(me))//1
{ 

//#if -1641452595 
removeNode(me);
//#endif 

} 

//#endif 


//#if 675842748 
if(Model.getFacade().isATransition(me))//1
{ 

//#if 497500478 
removeEdge(me);
//#endif 

} 

//#endif 

} 
else
{ 

//#if 51734077 
LOG.debug("model added " + me);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1125216628 
public boolean isRemoveFromDiagramAllowed(Collection figs)
    { 

//#if -2013863324 
if(figs.isEmpty())//1
{ 

//#if 787237135 
return false;
//#endif 

} 

//#endif 


//#if -243006973 
Iterator i = figs.iterator();
//#endif 


//#if 2121166182 
while (i.hasNext()) //1
{ 

//#if -107428120 
Object obj = i.next();
//#endif 


//#if 1654404787 
if(!(obj instanceof Fig))//1
{ 

//#if 1979701682 
return false;
//#endif 

} 

//#endif 


//#if -1462639485 
Object uml = ((Fig) obj).getOwner();
//#endif 


//#if 795663977 
if(uml != null)//1
{ 

//#if -269951695 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1489045143 
return true;
//#endif 

} 

//#endif 


//#if 1000699727 
public List getPorts(Object nodeOrEdge)
    { 

//#if 454790703 
List res = new ArrayList();
//#endif 


//#if -1255699755 
if(Model.getFacade().isAState(nodeOrEdge))//1
{ 

//#if -234062456 
res.add(nodeOrEdge);
//#endif 

} 

//#endif 


//#if 1093276183 
if(Model.getFacade().isAPseudostate(nodeOrEdge))//1
{ 

//#if 2135344330 
res.add(nodeOrEdge);
//#endif 

} 

//#endif 


//#if 161985444 
return res;
//#endif 

} 

//#endif 


//#if 11462318 
public Object connect(Object fromPort, Object toPort,
                          Object edgeClass)
    { 

//#if 883073856 
if(Model.getFacade().isAFinalState(fromPort))//1
{ 

//#if -1937051267 
return null;
//#endif 

} 

//#endif 


//#if 1692257012 
if(Model.getFacade().isAPseudostate(toPort)
                && Model.getPseudostateKind().getInitial().equals(
                    Model.getFacade().getKind(toPort)))//1
{ 

//#if -27780396 
return null;
//#endif 

} 

//#endif 


//#if 605826593 
if(Model.getMetaTypes().getTransition().equals(edgeClass))//1
{ 

//#if 771004220 
Object tr = null;
//#endif 


//#if -2097120060 
tr =
                Model.getStateMachinesFactory()
                .buildTransition(fromPort, toPort);
//#endif 


//#if -1196312100 
if(canAddEdge(tr))//1
{ 

//#if 744204924 
addEdge(tr);
//#endif 

} 
else
{ 

//#if 467140296 
ProjectManager.getManager().getCurrentProject().moveToTrash(tr);
//#endif 


//#if 391010846 
tr = null;
//#endif 

} 

//#endif 


//#if -311894043 
return tr;
//#endif 

} 
else

//#if -1594074160 
if(edgeClass == CommentEdge.class)//1
{ 

//#if -1492041459 
try //1
{ 

//#if -440426150 
Object connection =
                    buildConnection(
                        edgeClass, fromPort, null, toPort, null, null,
                        ProjectManager.getManager().getCurrentProject()
                        .getModel());
//#endif 


//#if 2005111676 
addEdge(connection);
//#endif 


//#if -1998581461 
return connection;
//#endif 

} 

//#if -1788070327 
catch (Exception ex) //1
{ 

//#if -71437875 
LOG.error("buildConnection() failed", ex);
//#endif 

} 

//#endif 


//#endif 


//#if 1410621549 
return null;
//#endif 

} 
else
{ 

//#if 1860045340 
LOG.debug("wrong kind of edge in StateDiagram connect3 "
                      + edgeClass);
//#endif 


//#if -617673666 
return null;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 34328646 
public Object getMachine()
    { 

//#if 1306668966 
return machine;
//#endif 

} 

//#endif 


//#if 915295334 
public boolean canAddEdge(Object edge)
    { 

//#if 1374008843 
if(super.canAddEdge(edge))//1
{ 

//#if -1892257509 
return true;
//#endif 

} 

//#endif 


//#if 1207884330 
if(edge == null)//1
{ 

//#if -1799515771 
return false;
//#endif 

} 

//#endif 


//#if 356129638 
if(containsEdge(edge))//1
{ 

//#if 1224266831 
return false;
//#endif 

} 

//#endif 


//#if -163357544 
Object end0 = null;
//#endif 


//#if 724146137 
Object end1 = null;
//#endif 


//#if 173768056 
if(Model.getFacade().isATransition(edge))//1
{ 

//#if -1597621581 
end0 = Model.getFacade().getSource(edge);
//#endif 


//#if -1732904740 
end1 = Model.getFacade().getTarget(edge);
//#endif 


//#if 1667865363 
if(Model.getFacade().isACompositeState(end0)
                    && Model.getStateMachinesHelper().getAllSubStates(end0)
                    .contains(end1))//1
{ 

//#if -2013948536 
return false;
//#endif 

} 

//#endif 

} 
else

//#if -1410304107 
if(edge instanceof CommentEdge)//1
{ 

//#if 820328388 
end0 = ((CommentEdge) edge).getSource();
//#endif 


//#if -83254136 
end1 = ((CommentEdge) edge).getDestination();
//#endif 

} 
else
{ 

//#if -165350816 
return false;
//#endif 

} 

//#endif 


//#endif 


//#if 103791231 
if(end0 == null || end1 == null)//1
{ 

//#if -1042192743 
LOG.error("Edge rejected. Its ends are not attached to anything");
//#endif 


//#if 966690322 
return false;
//#endif 

} 

//#endif 


//#if 1173337217 
if(!containsNode(end0)
                && !containsEdge(end0))//1
{ 

//#if 1427141870 
LOG.error("Edge rejected. Its source end is attached to "
                      + end0
                      + " but this is not in the graph model");
//#endif 


//#if 435041550 
return false;
//#endif 

} 

//#endif 


//#if -2131386911 
if(!containsNode(end1)
                && !containsEdge(end1))//1
{ 

//#if 1857513483 
LOG.error("Edge rejected. Its destination end is attached to "
                      + end1
                      + " but this is not in the graph model");
//#endif 


//#if -1773763731 
return false;
//#endif 

} 

//#endif 


//#if -466763376 
return true;
//#endif 

} 

//#endif 


//#if -1283525766 
public void addNode(Object node)
    { 

//#if -59302906 
LOG.debug("adding statechart/activity diagram node: " + node);
//#endif 


//#if -1096083929 
if(!canAddNode(node))//1
{ 

//#if 1189137825 
return;
//#endif 

} 

//#endif 


//#if -1070680164 
if(containsNode(node))//1
{ 

//#if -1472636579 
return;
//#endif 

} 

//#endif 


//#if -466488842 
getNodes().add(node);
//#endif 


//#if -2053226533 
if(Model.getFacade().isAStateVertex(node))//1
{ 

//#if 1657577148 
Object top = Model.getStateMachinesHelper().getTop(getMachine());
//#endif 


//#if -766616616 
Model.getStateMachinesHelper().addSubvertex(top, node);
//#endif 

} 

//#endif 


//#if 1595832651 
fireNodeAdded(node);
//#endif 

} 

//#endif 


//#if -566763630 
public Object getOwner(Object port)
    { 

//#if -986063077 
return port;
//#endif 

} 

//#endif 


//#if 911256231 
public boolean canConnect(Object fromPort, Object toPort)
    { 

//#if 328931052 
if(!(Model.getFacade().isAStateVertex(fromPort)))//1
{ 

//#if 1497149436 
LOG.error("internal error not from sv");
//#endif 


//#if -1689190595 
return false;
//#endif 

} 

//#endif 


//#if 1086420669 
if(!(Model.getFacade().isAStateVertex(toPort)))//1
{ 

//#if 283773302 
LOG.error("internal error not to sv");
//#endif 


//#if -1422301720 
return false;
//#endif 

} 

//#endif 


//#if 42647718 
if(Model.getFacade().isAFinalState(fromPort))//1
{ 

//#if 1688605439 
return false;
//#endif 

} 

//#endif 


//#if 1459277267 
if(Model.getFacade().isAPseudostate(toPort))//1
{ 

//#if -996260799 
if((Model.getPseudostateKind().getInitial()).equals(
                        Model.getFacade().getKind(toPort)))//1
{ 

//#if 1491111002 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1667721914 
return true;
//#endif 

} 

//#endif 


//#if 1543968134 
public boolean canAddNode(Object node)
    { 

//#if 1921181232 
if(node == null
                || !Model.getFacade().isAModelElement(node)
                || containsNode(node))//1
{ 

//#if 1513541587 
return false;
//#endif 

} 

//#endif 


//#if 1038340554 
if(Model.getFacade().isAComment(node))//1
{ 

//#if -684164683 
return true;
//#endif 

} 

//#endif 


//#if -471562156 
if(Model.getFacade().isAStateVertex(node)
                || Model.getFacade().isAPartition(node))//1
{ 

//#if 794400474 
Object nodeMachine =
                Model.getStateMachinesHelper().getStateMachine(node);
//#endif 


//#if -1868883924 
if(nodeMachine == null || nodeMachine == getMachine())//1
{ 

//#if -1503067311 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1076467546 
return false;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

