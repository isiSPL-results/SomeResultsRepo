
//#if 1823787031 
// Compilation Unit of /SequenceDiagramGraphModel.java 
 

//#if -1268579518 
package org.argouml.uml.diagram.sequence;
//#endif 


//#if -371552616 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -2042546960 
import java.beans.PropertyChangeListener;
//#endif 


//#if 561994017 
import java.beans.VetoableChangeListener;
//#endif 


//#if 1986429801 
import java.util.ArrayList;
//#endif 


//#if -1505587432 
import java.util.Collection;
//#endif 


//#if 514224032 
import java.util.Hashtable;
//#endif 


//#if -1283820200 
import java.util.List;
//#endif 


//#if -2143000986 
import org.apache.log4j.Logger;
//#endif 


//#if 1453301704 
import org.argouml.model.DeleteInstanceEvent;
//#endif 


//#if -295464487 
import org.argouml.model.Model;
//#endif 


//#if 2070159899 
import org.argouml.uml.CommentEdge;
//#endif 


//#if -1098305935 
import org.argouml.uml.diagram.UMLMutableGraphSupport;
//#endif 


//#if 851834884 
import org.argouml.uml.diagram.sequence.ui.FigClassifierRole;
//#endif 


//#if 585140076 
import org.tigris.gef.base.Editor;
//#endif 


//#if -1185048115 
import org.tigris.gef.base.Globals;
//#endif 


//#if 651894134 
import org.tigris.gef.base.Mode;
//#endif 


//#if -84745037 
import org.tigris.gef.base.ModeManager;
//#endif 


//#if 1148172798 
public class SequenceDiagramGraphModel extends 
//#if -2136021503 
UMLMutableGraphSupport
//#endif 

 implements 
//#if 153821686 
VetoableChangeListener
//#endif 

, 
//#if -68743097 
PropertyChangeListener
//#endif 

  { 

//#if -2111950203 
private static final Logger LOG =
        Logger.getLogger(SequenceDiagramGraphModel.class);
//#endif 


//#if -718757878 
private Object collaboration;
//#endif 


//#if 1486492381 
private Object interaction;
//#endif 


//#if 1363921540 
private static final long serialVersionUID = -3799402191353570488L;
//#endif 


//#if -1376473001 
public SequenceDiagramGraphModel()
    { 
} 

//#endif 


//#if 987556166 
public Object getCollaboration()
    { 

//#if 2060598099 
if(collaboration == null)//1
{ 

//#if -1064669498 
collaboration =
                Model.getCollaborationsFactory().buildCollaboration(
                    getProject().getRoot());
//#endif 

} 

//#endif 


//#if 1226632816 
return collaboration;
//#endif 

} 

//#endif 


//#if -580640143 
public List getInEdges(Object port)
    { 

//#if 1497300624 
List res = new ArrayList();
//#endif 


//#if -938138783 
if(Model.getFacade().isAClassifierRole(port))//1
{ 

//#if -1660235933 
res.addAll(Model.getFacade().getSentMessages(port));
//#endif 

} 

//#endif 


//#if -1641006685 
return res;
//#endif 

} 

//#endif 


//#if 334631192 
public void addEdge(Object edge)
    { 

//#if -1618946504 
if(canAddEdge(edge))//1
{ 

//#if -791254571 
getEdges().add(edge);
//#endif 


//#if 1500554744 
fireEdgeAdded(edge);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2128979461 
public boolean canConnect(Object fromP, Object toP, Object edgeType)
    { 

//#if -747490140 
if(edgeType == CommentEdge.class
                && (Model.getFacade().isAComment(fromP)
                    || Model.getFacade().isAComment(toP))
                && !(Model.getFacade().isAComment(fromP)
                     && Model.getFacade().isAComment(toP)))//1
{ 

//#if -1197225592 
return true;
//#endif 

} 

//#endif 


//#if -1094708191 
if(!(fromP instanceof MessageNode) || !(toP instanceof MessageNode))//1
{ 

//#if -129047154 
return false;
//#endif 

} 

//#endif 


//#if 1669453537 
if(fromP == toP)//1
{ 

//#if -1325051297 
return false;
//#endif 

} 

//#endif 


//#if -1029637324 
MessageNode nodeFrom = (MessageNode) fromP;
//#endif 


//#if -1758538602 
MessageNode nodeTo = (MessageNode) toP;
//#endif 


//#if -615579807 
if(nodeFrom.getFigClassifierRole() == nodeTo.getFigClassifierRole())//1
{ 

//#if 2138476973 
FigClassifierRole fig = nodeFrom.getFigClassifierRole();
//#endif 


//#if -1763867157 
if(fig.getIndexOf(nodeFrom) >= fig.getIndexOf(nodeTo))//1
{ 

//#if -898978632 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -622487799 
Editor curEditor = Globals.curEditor();
//#endif 


//#if 810059017 
ModeManager modeManager = curEditor.getModeManager();
//#endif 


//#if 508288607 
Mode mode = modeManager.top();
//#endif 


//#if -332872143 
Hashtable args = mode.getArgs();
//#endif 


//#if 1672551730 
Object actionType = args.get("action");
//#endif 


//#if -1729517541 
if(Model.getMetaTypes().getCallAction().equals(actionType))//1
{ 

//#if -1001645096 
return nodeFrom.canCall() && nodeTo.canBeCalled();
//#endif 

} 
else

//#if -533030919 
if(Model.getMetaTypes().getReturnAction().equals(actionType))//1
{ 

//#if -60962088 
return nodeTo.canBeReturnedTo()
                   && nodeFrom.canReturn(nodeTo.getClassifierRole());
//#endif 

} 
else

//#if 1156018584 
if(Model.getMetaTypes().getCreateAction().equals(actionType))//1
{ 

//#if -1244791868 
if(nodeFrom.getFigClassifierRole()
                    == nodeTo.getFigClassifierRole())//1
{ 

//#if 431020130 
return false;
//#endif 

} 

//#endif 


//#if 851328077 
return nodeFrom.canCreate() && nodeTo.canBeCreated();
//#endif 

} 
else

//#if 488523729 
if(Model.getMetaTypes().getDestroyAction().equals(actionType))//1
{ 

//#if 1895917032 
return nodeFrom.canDestroy() && nodeTo.canBeDestroyed();
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#if -894575799 
return false;
//#endif 

} 

//#endif 


//#if 296295243 
public Object getHomeModel()
    { 

//#if -769319184 
return getCollaboration();
//#endif 

} 

//#endif 


//#if -2070014127 
private Object getInteraction()
    { 

//#if 132094045 
if(interaction == null)//1
{ 

//#if 1079861237 
interaction =
                Model.getCollaborationsFactory().buildInteraction(
                    collaboration);
//#endif 


//#if -560444287 
Model.getPump().addModelEventListener(this, interaction);
//#endif 

} 

//#endif 


//#if 1463664192 
return interaction;
//#endif 

} 

//#endif 


//#if -1362485551 
public List getPorts(Object nodeOrEdge)
    { 

//#if 950247334 
List ports = new ArrayList();
//#endif 


//#if 1511244604 
if(Model.getFacade().isAClassifierRole(nodeOrEdge))//1
{ 

//#if 584838879 
ports.addAll(Model.getFacade().getReceivedMessages(nodeOrEdge));
//#endif 


//#if 533826006 
ports.addAll(Model.getFacade().getSentMessages(nodeOrEdge));
//#endif 

} 
else

//#if 1310364472 
if(Model.getFacade().isAMessage(nodeOrEdge))//1
{ 

//#if 160834261 
ports.add(Model.getFacade().getSender(nodeOrEdge));
//#endif 


//#if 146029903 
ports.add(Model.getFacade().getReceiver(nodeOrEdge));
//#endif 

} 

//#endif 


//#endif 


//#if -904391731 
return ports;
//#endif 

} 

//#endif 


//#if 963303992 
public void addNode(Object node)
    { 

//#if -1782588007 
if(canAddNode(node))//1
{ 

//#if -1928399622 
getNodes().add(node);
//#endif 


//#if 1825768903 
fireNodeAdded(node);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 373561791 
public void setCollaboration(Object c)
    { 

//#if -1624866514 
collaboration = c;
//#endif 


//#if -1136955422 
Collection interactions = Model.getFacade().getInteractions(c);
//#endif 


//#if 629037747 
if(!interactions.isEmpty())//1
{ 

//#if -1887370461 
interaction = interactions.iterator().next();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1968216084 
public Object getOwner(Object port)
    { 

//#if 2082722502 
return port;
//#endif 

} 

//#endif 


//#if 1918967843 
public void propertyChange(PropertyChangeEvent evt)
    { 

//#if -1939116733 
if(evt instanceof DeleteInstanceEvent
                && evt.getSource() == interaction)//1
{ 

//#if -2037417897 
Model.getPump().removeModelEventListener(this, interaction);
//#endif 


//#if -685653313 
interaction = null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1947046306 
public void setHomeModel(Object namespace)
    { 

//#if 2050787936 
if(!Model.getFacade().isANamespace(namespace))//1
{ 

//#if 441280804 
throw new IllegalArgumentException(
                "A sequence diagram home model must be a namespace, "
                + "received a "
                + namespace);
//#endif 

} 

//#endif 


//#if -1626593078 
setCollaboration(namespace);
//#endif 


//#if 122330658 
super.setHomeModel(namespace);
//#endif 

} 

//#endif 


//#if 2085989540 
public boolean canAddEdge(Object edge)
    { 

//#if -407692162 
if(edge == null)//1
{ 

//#if 590816119 
return false;
//#endif 

} 

//#endif 


//#if -2056580826 
if(getEdges().contains(edge))//1
{ 

//#if 1141332411 
return false;
//#endif 

} 

//#endif 


//#if -1600946236 
Object end0 = null;
//#endif 


//#if -713442555 
Object end1 = null;
//#endif 


//#if -823745680 
if(Model.getFacade().isAMessage(edge))//1
{ 

//#if -1937730816 
end0 = Model.getFacade().getSender(edge);
//#endif 


//#if -1806380251 
end1 = Model.getFacade().getReceiver(edge);
//#endif 

} 
else

//#if -958506638 
if(edge instanceof CommentEdge)//1
{ 

//#if 684577964 
end0 = ((CommentEdge) edge).getSource();
//#endif 


//#if 1946605728 
end1 = ((CommentEdge) edge).getDestination();
//#endif 

} 
else
{ 

//#if 1824225698 
return false;
//#endif 

} 

//#endif 


//#endif 


//#if -1030807853 
if(end0 == null || end1 == null)//1
{ 

//#if -2031384917 
LOG.error("Edge rejected. Its ends are not attached to anything");
//#endif 


//#if 388044196 
return false;
//#endif 

} 

//#endif 


//#if 1386621909 
if(!containsNode(end0) && !containsEdge(end0))//1
{ 

//#if 1708930579 
LOG.error("Edge rejected. Its source end is attached to "
                      + end0
                      + " but this is not in the graph model");
//#endif 


//#if -1530210189 
return false;
//#endif 

} 

//#endif 


//#if -1918102219 
if(!containsNode(end1) && !containsEdge(end1))//1
{ 

//#if -60854188 
LOG.error("Edge rejected. Its destination end is attached to "
                      + end1
                      + " but this is not in the graph model");
//#endif 


//#if -1053537724 
return false;
//#endif 

} 

//#endif 


//#if 1736921828 
return true;
//#endif 

} 

//#endif 


//#if -477713725 
public void vetoableChange(PropertyChangeEvent pce)
    { 

//#if 1877262844 
if("ownedElement".equals(pce.getPropertyName()))//1
{ 

//#if 1940215155 
List oldOwned = (List) pce.getOldValue();
//#endif 


//#if 1026102460 
Object eo = pce.getNewValue();
//#endif 


//#if 1117393084 
Object me = Model.getFacade().getModelElement(eo);
//#endif 


//#if 1562151818 
if(oldOwned.contains(eo))//1
{ 

//#if -1588371027 
LOG.debug("model removed " + me);
//#endif 


//#if 468938194 
if(Model.getFacade().isAClassifierRole(me))//1
{ 

//#if 1054607086 
removeNode(me);
//#endif 

} 

//#endif 


//#if 2046052494 
if(Model.getFacade().isAMessage(me))//1
{ 

//#if 468918053 
removeEdge(me);
//#endif 

} 

//#endif 

} 
else
{ 

//#if 844591779 
LOG.debug("model added " + me);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 560419082 
public List getOutEdges(Object port)
    { 

//#if -2014401906 
List res = new ArrayList();
//#endif 


//#if 745296163 
if(Model.getFacade().isAClassifierRole(port))//1
{ 

//#if -107655998 
res.addAll(Model.getFacade().getReceivedMessages(port));
//#endif 

} 

//#endif 


//#if 79882469 
return res;
//#endif 

} 

//#endif 


//#if -1538898240 
@Override
    public Object connect(Object fromPort, Object toPort, Object edgeType)
    { 

//#if -1712589217 
if(!canConnect(fromPort, toPort, edgeType))//1
{ 

//#if -901239323 
return null;
//#endif 

} 

//#endif 


//#if 715021720 
if(edgeType == CommentEdge.class)//1
{ 

//#if -482963994 
return super.connect(fromPort, toPort, edgeType);
//#endif 

} 

//#endif 


//#if 94568095 
Object edge = null;
//#endif 


//#if -302580949 
Object fromObject = null;
//#endif 


//#if 867073852 
Object toObject = null;
//#endif 


//#if 411791768 
Object action = null;
//#endif 


//#if -1135026462 
if(Model.getMetaTypes().getMessage().equals(edgeType))//1
{ 

//#if -786362633 
Editor curEditor = Globals.curEditor();
//#endif 


//#if -1415281545 
ModeManager modeManager = curEditor.getModeManager();
//#endif 


//#if 1468211889 
Mode mode = modeManager.top();
//#endif 


//#if -1264566781 
Hashtable args = mode.getArgs();
//#endif 


//#if 1508676896 
Object actionType = args.get("action");
//#endif 


//#if -477367671 
if(Model.getMetaTypes().getCallAction().equals(actionType))//1
{ 

//#if 1193227468 
if(fromPort instanceof MessageNode
                        && toPort instanceof MessageNode)//1
{ 

//#if 1324470686 
fromObject = ((MessageNode) fromPort).getClassifierRole();
//#endif 


//#if -326245890 
toObject = ((MessageNode) toPort).getClassifierRole();
//#endif 


//#if -757453267 
action =
                        Model.getCommonBehaviorFactory()
                        .createCallAction();
//#endif 

} 

//#endif 

} 
else

//#if 1428807551 
if(Model.getMetaTypes().getCreateAction()
                       .equals(actionType))//1
{ 

//#if -1136694733 
if(fromPort instanceof MessageNode
                        && toPort instanceof MessageNode)//1
{ 

//#if 1680174030 
fromObject = ((MessageNode) fromPort).getClassifierRole();
//#endif 


//#if -91876306 
toObject = ((MessageNode) toPort).getClassifierRole();
//#endif 


//#if -712668737 
action =
                        Model.getCommonBehaviorFactory()
                        .createCreateAction();
//#endif 

} 

//#endif 

} 
else

//#if -1244871101 
if(Model.getMetaTypes().getReturnAction()
                       .equals(actionType))//1
{ 

//#if -1934865388 
if(fromPort instanceof MessageNode
                        && toPort instanceof MessageNode)//1
{ 

//#if 716096478 
fromObject = ((MessageNode) fromPort).getClassifierRole();
//#endif 


//#if -1893862338 
toObject = ((MessageNode) toPort).getClassifierRole();
//#endif 


//#if 268596251 
action =
                        Model.getCommonBehaviorFactory()
                        .createReturnAction();
//#endif 

} 

//#endif 

} 
else

//#if 1360229182 
if(Model.getMetaTypes().getDestroyAction()
                       .equals(actionType))//1
{ 

//#if -428498519 
if(fromPort instanceof MessageNode
                        && toPort instanceof MessageNode)//1
{ 

//#if -1028010357 
fromObject = ((MessageNode) fromPort).getClassifierRole();
//#endif 


//#if 1976493722 
toObject = ((MessageNode) fromPort).getClassifierRole();
//#endif 


//#if -936232426 
action =
                        Model.getCommonBehaviorFactory()
                        .createDestroyAction();
//#endif 

} 

//#endif 

} 
else

//#if -884880770 
if(Model.getMetaTypes().getSendAction()
                       .equals(actionType))//1
{ 
} 
else

//#if 444086142 
if(Model.getMetaTypes().getTerminateAction()
                       .equals(actionType))//1
{ 
} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if -1834891511 
if(fromObject != null && toObject != null && action != null)//1
{ 

//#if 1045828360 
Object associationRole =
                Model.getCollaborationsHelper().getAssociationRole(
                    fromObject,
                    toObject);
//#endif 


//#if 267145046 
if(associationRole == null)//1
{ 

//#if -1356430905 
associationRole =
                    Model.getCollaborationsFactory().buildAssociationRole(
                        fromObject, toObject);
//#endif 

} 

//#endif 


//#if -212480425 
Object message =
                Model.getCollaborationsFactory().buildMessage(
                    getInteraction(),
                    associationRole);
//#endif 


//#if -622929871 
if(action != null)//1
{ 

//#if -535660206 
Model.getCollaborationsHelper().setAction(message, action);
//#endif 


//#if 2078869037 
Model.getCoreHelper().setNamespace(action, getCollaboration());
//#endif 

} 

//#endif 


//#if -530382676 
Model.getCollaborationsHelper()
            .setSender(message, fromObject);
//#endif 


//#if -1372789484 
Model.getCommonBehaviorHelper()
            .setReceiver(message, toObject);
//#endif 


//#if 311017236 
addEdge(message);
//#endif 


//#if -251868167 
edge = message;
//#endif 

} 

//#endif 


//#if 1896238347 
if(edge == null)//1
{ 

//#if -844923778 
LOG.debug("Incorrect edge");
//#endif 

} 

//#endif 


//#if -132170014 
return edge;
//#endif 

} 

//#endif 


//#if -1580304956 
public boolean canAddNode(Object node)
    { 

//#if 1980341486 
if(node == null)//1
{ 

//#if -664718497 
return false;
//#endif 

} 

//#endif 


//#if 824884651 
return !getNodes().contains(node)
               && Model.getFacade().isAModelElement(node)
               && Model.getFacade().getNamespace(node) == getCollaboration();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

