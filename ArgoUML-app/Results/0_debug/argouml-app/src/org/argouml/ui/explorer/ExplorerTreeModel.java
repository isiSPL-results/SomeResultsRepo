
//#if 857944499 
// Compilation Unit of /ExplorerTreeModel.java 
 

//#if 143941264 
package org.argouml.ui.explorer;
//#endif 


//#if 794265890 
import java.awt.EventQueue;
//#endif 


//#if -1674370102 
import java.awt.event.ItemEvent;
//#endif 


//#if -658818434 
import java.awt.event.ItemListener;
//#endif 


//#if -1267690050 
import java.util.ArrayList;
//#endif 


//#if 695912291 
import java.util.Collection;
//#endif 


//#if 98446336 
import java.util.Collections;
//#endif 


//#if -1573064661 
import java.util.Comparator;
//#endif 


//#if -1528832626 
import java.util.Enumeration;
//#endif 


//#if -1528033209 
import java.util.HashMap;
//#endif 


//#if -1527850495 
import java.util.HashSet;
//#endif 


//#if 1881960723 
import java.util.Iterator;
//#endif 


//#if 1811240650 
import java.util.LinkedList;
//#endif 


//#if -1305902621 
import java.util.List;
//#endif 


//#if 927727385 
import java.util.Map;
//#endif 


//#if 927910099 
import java.util.Set;
//#endif 


//#if 1874800808 
import javax.swing.tree.DefaultMutableTreeNode;
//#endif 


//#if -1036699293 
import javax.swing.tree.DefaultTreeModel;
//#endif 


//#if -1498109469 
import javax.swing.tree.MutableTreeNode;
//#endif 


//#if -228475827 
import javax.swing.tree.TreeNode;
//#endif 


//#if -227030390 
import javax.swing.tree.TreePath;
//#endif 


//#if -112312676 
import org.argouml.kernel.Project;
//#endif 


//#if -2091561779 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1091691821 
import org.argouml.model.InvalidElementException;
//#endif 


//#if -1904525050 
import org.argouml.ui.explorer.rules.PerspectiveRule;
//#endif 


//#if -1415363013 
import org.apache.log4j.Logger;
//#endif 


//#if -1341569326 
public class ExplorerTreeModel extends 
//#if -668377899 
DefaultTreeModel
//#endif 

 implements 
//#if 1172490682 
TreeModelUMLEventListener
//#endif 

, 
//#if 2045836882 
ItemListener
//#endif 

  { 

//#if 1724146192 
private List<PerspectiveRule> rules;
//#endif 


//#if -731250016 
private Map<Object, Set<ExplorerTreeNode>> modelElementMap;
//#endif 


//#if -1024768901 
private Comparator order;
//#endif 


//#if -1296289311 
private List<ExplorerTreeNode> updatingChildren =
        new ArrayList<ExplorerTreeNode>();
//#endif 


//#if 1240082824 
private ExplorerUpdater nodeUpdater = new ExplorerUpdater();
//#endif 


//#if 1555652488 
private ExplorerTree tree;
//#endif 


//#if -181273406 
private static final long serialVersionUID = 3132732494386565870L;
//#endif 


//#if 1644989793 
private static final Logger LOG =
        Logger.getLogger(ExplorerTreeModel.class);
//#endif 


//#if -1246259865 
public ExplorerTreeModel(Object root, ExplorerTree myTree)
    { 

//#if 1758644469 
super(new DefaultMutableTreeNode());
//#endif 


//#if -752931096 
tree = myTree;
//#endif 


//#if -1604495626 
setRoot(new ExplorerTreeNode(root, this));
//#endif 


//#if -1095470532 
setAsksAllowsChildren(false);
//#endif 


//#if 232433432 
modelElementMap = new HashMap<Object, Set<ExplorerTreeNode>>();
//#endif 


//#if -188524123 
ExplorerEventAdaptor.getInstance()
        .setTreeModelUMLEventListener(this);
//#endif 


//#if 1110930921 
order = new TypeThenNameOrder();
//#endif 

} 

//#endif 


//#if 1717724170 
public void structureChanged()
    { 

//#if -1569709072 
if(getRoot() instanceof ExplorerTreeNode)//1
{ 

//#if -199965549 
((ExplorerTreeNode) getRoot()).remove();
//#endif 

} 

//#endif 


//#if -643671611 
for (Collection nodes : modelElementMap.values()) //1
{ 

//#if -679551287 
nodes.clear();
//#endif 

} 

//#endif 


//#if 1410004001 
modelElementMap.clear();
//#endif 


//#if -1643478305 
modelElementMap = new HashMap<Object, Set<ExplorerTreeNode>>();
//#endif 


//#if -750278122 
Project proj = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -1163748917 
ExplorerTreeNode rootNode = new ExplorerTreeNode(proj, this);
//#endif 


//#if -1897028052 
addToMap(proj, rootNode);
//#endif 


//#if 194730857 
setRoot(rootNode);
//#endif 

} 

//#endif 


//#if -1671978962 
private Collection<ExplorerTreeNode> findNodes(Object modelElement)
    { 

//#if 1310285129 
Collection<ExplorerTreeNode> nodes = modelElementMap.get(modelElement);
//#endif 


//#if -1551616907 
if(nodes == null)//1
{ 

//#if -5163831 
return Collections.EMPTY_LIST;
//#endif 

} 

//#endif 


//#if -1670412614 
return nodes;
//#endif 

} 

//#endif 


//#if -1600136143 
ExplorerUpdater getNodeUpdater()
    { 

//#if 1098152328 
return nodeUpdater;
//#endif 

} 

//#endif 


//#if 757896081 
private void removeNodesFromMap(ExplorerTreeNode node)
    { 

//#if 981330996 
Enumeration children = node.children();
//#endif 


//#if 484279845 
while (children.hasMoreElements()) //1
{ 

//#if 1085539317 
ExplorerTreeNode child = (ExplorerTreeNode) children.nextElement();
//#endif 


//#if 39373396 
removeNodesFromMap(child);
//#endif 

} 

//#endif 


//#if 877722563 
removeFromMap(node.getUserObject(), node);
//#endif 

} 

//#endif 


//#if 1595887321 
public void modelElementChanged(Object node)
    { 

//#if 1575716717 
traverseModified((TreeNode) getRoot(), node);
//#endif 

} 

//#endif 


//#if 477540453 
public void modelElementAdded(Object node)
    { 

//#if 2108852483 
traverseModified((TreeNode) getRoot(), node);
//#endif 

} 

//#endif 


//#if 18467188 
private void removeFromMap(Object modelElement, ExplorerTreeNode node)
    { 

//#if 886005240 
Collection<ExplorerTreeNode> nodes = modelElementMap.get(modelElement);
//#endif 


//#if 1417310080 
if(nodes != null)//1
{ 

//#if -323890853 
nodes.remove(node);
//#endif 


//#if -985881852 
if(nodes.isEmpty())//1
{ 

//#if 51682271 
modelElementMap.remove(modelElement);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -2096805430 
private void addToMap(Object modelElement, ExplorerTreeNode node)
    { 

//#if -1588201330 
Set<ExplorerTreeNode> nodes = modelElementMap.get(modelElement);
//#endif 


//#if 1742524720 
if(nodes != null)//1
{ 

//#if -21603793 
nodes.add(node);
//#endif 

} 
else
{ 

//#if -27028526 
nodes = new HashSet<ExplorerTreeNode>();
//#endif 


//#if 289121213 
nodes.add(node);
//#endif 


//#if -1610764083 
modelElementMap.put(modelElement, nodes);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 197714565 
public void modelElementRemoved(Object node)
    { 

//#if -79594417 
for (ExplorerTreeNode changeNode
                : new ArrayList<ExplorerTreeNode>(findNodes(node))) //1
{ 

//#if -723457209 
if(changeNode.getParent() != null)//1
{ 

//#if 1653263539 
removeNodeFromParent(changeNode);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 642764260 
traverseModified((TreeNode) getRoot(), node);
//#endif 

} 

//#endif 


//#if 1128369096 
private Set prepareAddRemoveSets(List children, List newChildren)
    { 

//#if -308274251 
Set removeSet = new HashSet();
//#endif 


//#if 893621472 
Set commonObjects = new HashSet();
//#endif 


//#if -231700129 
if(children.size() < newChildren.size())//1
{ 

//#if 1403718673 
commonObjects.addAll(children);
//#endif 


//#if -816096995 
commonObjects.retainAll(newChildren);
//#endif 

} 
else
{ 

//#if -1999087126 
commonObjects.addAll(newChildren);
//#endif 


//#if 599144542 
commonObjects.retainAll(children);
//#endif 

} 

//#endif 


//#if -656092911 
newChildren.removeAll(commonObjects);
//#endif 


//#if 263836473 
removeSet.addAll(children);
//#endif 


//#if -524155440 
removeSet.removeAll(commonObjects);
//#endif 


//#if -354656440 
Iterator it = removeSet.iterator();
//#endif 


//#if 1141998562 
List weakNodes = null;
//#endif 


//#if -111477510 
while (it.hasNext()) //1
{ 

//#if -408190194 
Object obj = it.next();
//#endif 


//#if 837073570 
if(!(obj instanceof WeakExplorerNode))//1
{ 

//#if -743666034 
continue;
//#endif 

} 

//#endif 


//#if -748142967 
WeakExplorerNode node = (WeakExplorerNode) obj;
//#endif 


//#if 1062280642 
if(weakNodes == null)//1
{ 

//#if -1506850677 
weakNodes = new LinkedList();
//#endif 


//#if -1822307627 
Iterator it2 = newChildren.iterator();
//#endif 


//#if 2143074452 
while (it2.hasNext()) //1
{ 

//#if 1155112026 
Object obj2 = it2.next();
//#endif 


//#if 1923313974 
if(obj2 instanceof WeakExplorerNode)//1
{ 

//#if -1794194279 
weakNodes.add(obj2);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1700168721 
Iterator it3 = weakNodes.iterator();
//#endif 


//#if 2107890708 
while (it3.hasNext()) //1
{ 

//#if 333937441 
Object obj3 = it3.next();
//#endif 


//#if 1811709321 
if(node.subsumes(obj3))//1
{ 

//#if 1722338846 
it.remove();
//#endif 


//#if -1337165672 
newChildren.remove(obj3);
//#endif 


//#if 1193510117 
it3.remove();
//#endif 


//#if 679181863 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1156368989 
return removeSet;
//#endif 

} 

//#endif 


//#if 1372806345 
private void mergeChildren(ExplorerTreeNode node, List children,
                               List newChildren)
    { 

//#if -190142796 
Set removeObjects = prepareAddRemoveSets(children, newChildren);
//#endif 


//#if 77224831 
List<ExplorerTreeNode> actualNodes = new ArrayList<ExplorerTreeNode>();
//#endif 


//#if -1610572757 
Enumeration childrenEnum = node.children();
//#endif 


//#if 741188990 
while (childrenEnum.hasMoreElements()) //1
{ 

//#if 1640008153 
actualNodes.add((ExplorerTreeNode) childrenEnum.nextElement());
//#endif 

} 

//#endif 


//#if -2092175178 
int position = 0;
//#endif 


//#if 1092054637 
Iterator childNodes = actualNodes.iterator();
//#endif 


//#if -2146710171 
Iterator newNodes = newChildren.iterator();
//#endif 


//#if 1519044773 
Object firstNew = newNodes.hasNext() ? newNodes.next() : null;
//#endif 


//#if 233146010 
while (childNodes.hasNext()) //1
{ 

//#if 2089837232 
Object childObj = childNodes.next();
//#endif 


//#if -967579558 
if(!(childObj instanceof ExplorerTreeNode))//1
{ 

//#if 901502319 
continue;
//#endif 

} 

//#endif 


//#if 1382820957 
ExplorerTreeNode child = (ExplorerTreeNode) childObj;
//#endif 


//#if -1897973345 
Object userObject = child.getUserObject();
//#endif 


//#if 2058289702 
if(removeObjects.contains(userObject))//1
{ 

//#if -183285317 
removeNodeFromParent(child);
//#endif 

} 
else
{ 

//#if -2103264663 
while (firstNew != null
                        && order.compare(firstNew, userObject) < 0) //1
{ 

//#if 1316583976 
insertNodeInto(new ExplorerTreeNode(firstNew, this),
                                   node,
                                   position);
//#endif 


//#if -2059087460 
position++;
//#endif 


//#if -249351372 
firstNew = newNodes.hasNext() ? newNodes.next() : null;
//#endif 

} 

//#endif 


//#if 791330453 
position++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1222116552 
while (firstNew != null) //1
{ 

//#if -1900022310 
insertNodeInto(new ExplorerTreeNode(firstNew, this),
                           node,
                           position);
//#endif 


//#if 1723098830 
position++;
//#endif 


//#if 426463974 
firstNew = newNodes.hasNext() ? newNodes.next() : null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 786428361 
public void updateChildren(TreePath path)
    { 

//#if 1315440184 
ExplorerTreeNode node = (ExplorerTreeNode) path.getLastPathComponent();
//#endif 


//#if -758978234 
Object modelElement = node.getUserObject();
//#endif 


//#if -1658980570 
if(rules == null)//1
{ 

//#if 803448391 
return;
//#endif 

} 

//#endif 


//#if 604468623 
if(updatingChildren.contains(node))//1
{ 

//#if 282491623 
return;
//#endif 

} 

//#endif 


//#if 108314073 
updatingChildren.add(node);
//#endif 


//#if -792678345 
List children = reorderChildren(node);
//#endif 


//#if 675676060 
List newChildren = new ArrayList();
//#endif 


//#if -668039068 
Set deps = new HashSet();
//#endif 


//#if -988236302 
collectChildren(modelElement, newChildren, deps);
//#endif 


//#if -476434825 
node.setModifySet(deps);
//#endif 


//#if -535742030 
mergeChildren(node, children, newChildren);
//#endif 


//#if 1725072986 
updatingChildren.remove(node);
//#endif 

} 

//#endif 


//#if -931187007 
public void itemStateChanged(ItemEvent e)
    { 

//#if -817608616 
if(e.getSource() instanceof PerspectiveComboBox)//1
{ 

//#if -671171950 
rules = ((ExplorerPerspective) e.getItem()).getList();
//#endif 

} 
else
{ 

//#if 811886501 
order = (Comparator) e.getItem();
//#endif 

} 

//#endif 


//#if 236401498 
structureChanged();
//#endif 


//#if -1787358370 
tree.expandPath(tree.getPathForRow(1));
//#endif 

} 

//#endif 


//#if -2025195135 
private List<Object> reorderChildren(ExplorerTreeNode node)
    { 

//#if -1825971710 
List<Object> childUserObjects = new ArrayList<Object>();
//#endif 


//#if -50982805 
List<ExplorerTreeNode> reordered = new ArrayList<ExplorerTreeNode>();
//#endif 


//#if -665845200 
Enumeration enChld = node.children();
//#endif 


//#if -452805816 
Object lastObj = null;
//#endif 


//#if -862503089 
while (enChld.hasMoreElements()) //1
{ 

//#if 742145511 
Object child = enChld.nextElement();
//#endif 


//#if -130399402 
if(child instanceof ExplorerTreeNode)//1
{ 

//#if 372417000 
Object obj = ((ExplorerTreeNode) child).getUserObject();
//#endif 


//#if -1780642107 
if(lastObj != null && order.compare(lastObj, obj) > 0)//1
{ 

//#if 710593455 
if(!tree.isPathSelected(new TreePath(
                                                 getPathToRoot((ExplorerTreeNode) child))))//1
{ 

//#if -1342074536 
reordered.add((ExplorerTreeNode) child);
//#endif 

} 
else
{ 

//#if 951009949 
ExplorerTreeNode prev =
                            (ExplorerTreeNode) ((ExplorerTreeNode) child)
                            .getPreviousSibling();
//#endif 


//#if 149672566 
while (prev != null
                                && (order.compare(prev.getUserObject(), obj)
                                    >= 0)) //1
{ 

//#if -1013622799 
reordered.add(prev);
//#endif 


//#if -1952936059 
childUserObjects.remove(childUserObjects.size() - 1);
//#endif 


//#if -644539899 
prev = (ExplorerTreeNode) prev.getPreviousSibling();
//#endif 

} 

//#endif 


//#if 1727216477 
childUserObjects.add(obj);
//#endif 


//#if 993784284 
lastObj = obj;
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1657692217 
childUserObjects.add(obj);
//#endif 


//#if -2032666682 
lastObj = obj;
//#endif 

} 

//#endif 

} 
else
{ 

//#if -185897660 
throw new IllegalArgumentException(
                    "Incomprehencible child node " + child.toString());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2118762901 
for (ExplorerTreeNode child : reordered) //1
{ 

//#if 1774932165 
super.removeNodeFromParent(child);
//#endif 

} 

//#endif 


//#if 1226278140 
for (ExplorerTreeNode child : reordered) //2
{ 

//#if -1346973329 
Object obj = child.getUserObject();
//#endif 


//#if 2080046221 
int ip = Collections.binarySearch(childUserObjects, obj, order);
//#endif 


//#if -2099859024 
if(ip < 0)//1
{ 

//#if 1466314567 
ip = -(ip + 1);
//#endif 

} 

//#endif 


//#if 819608471 
super.insertNodeInto(child, node, ip);
//#endif 


//#if -1678552274 
childUserObjects.add(ip, obj);
//#endif 

} 

//#endif 


//#if 815922221 
return childUserObjects;
//#endif 

} 

//#endif 


//#if -385285903 
@Override
    public void insertNodeInto(MutableTreeNode newChild,
                               MutableTreeNode parent, int index)
    { 

//#if 130338214 
super.insertNodeInto(newChild, parent, index);
//#endif 


//#if -509235412 
if(newChild instanceof ExplorerTreeNode)//1
{ 

//#if 1928181455 
addNodesToMap((ExplorerTreeNode) newChild);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1451661469 
private void traverseModified(TreeNode start, Object node)
    { 

//#if -1275200920 
Enumeration children = start.children();
//#endif 


//#if -1765959449 
while (children.hasMoreElements()) //1
{ 

//#if 1274546561 
TreeNode child = (TreeNode) children.nextElement();
//#endif 


//#if 1345643988 
traverseModified(child, node);
//#endif 

} 

//#endif 


//#if 1017179610 
if(start instanceof ExplorerTreeNode)//1
{ 

//#if 368787293 
((ExplorerTreeNode) start).nodeModified(node);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 547085669 
private void addNodesToMap(ExplorerTreeNode node)
    { 

//#if 394799704 
Enumeration children = node.children();
//#endif 


//#if -102251447 
while (children.hasMoreElements()) //1
{ 

//#if 385178627 
ExplorerTreeNode child = (ExplorerTreeNode) children.nextElement();
//#endif 


//#if 1077558300 
addNodesToMap(child);
//#endif 

} 

//#endif 


//#if -531649195 
addToMap(node.getUserObject(), node);
//#endif 

} 

//#endif 


//#if 1858676893 
private void collectChildren(Object modelElement, List newChildren,
                                 Set deps)
    { 

//#if -769966204 
if(modelElement == null)//1
{ 

//#if -152426758 
return;
//#endif 

} 

//#endif 


//#if -792397263 
for (PerspectiveRule rule : rules) //1
{ 

//#if 2037432241 
Collection children = Collections.emptySet();
//#endif 


//#if -229095013 
try //1
{ 

//#if -912328337 
children = rule.getChildren(modelElement);
//#endif 

} 

//#if 48436482 
catch (InvalidElementException e) //1
{ 

//#if 2012751929 
LOG.debug("InvalidElementException in ExplorerTree : "
                          + e.getStackTrace());
//#endif 

} 

//#endif 


//#endif 


//#if 1498755048 
for (Object child : children) //1
{ 

//#if -2046508557 
if(!newChildren.contains(child))//1
{ 

//#if 802659229 
newChildren.add(child);
//#endif 

} 

//#endif 


//#if 1774602246 
if(child == null)//1
{ 

//#if 2043191777 
LOG.warn("PerspectiveRule " + rule + " wanted to "
                             + "add null to the explorer tree!");
//#endif 

} 
else

//#if -525605932 
if((child != null) &&

                        !newChildren.contains(child))//1
{ 

//#if 26759875 
newChildren.add(child);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -266422474 
try //2
{ 

//#if -1606372099 
Set dependencies = rule.getDependencies(modelElement);
//#endif 


//#if 1562249834 
deps.addAll(dependencies);
//#endif 

} 

//#if -1560022190 
catch (InvalidElementException e) //1
{ 

//#if -1245683005 
LOG.debug("InvalidElementException in ExplorerTree : "
                          + e.getStackTrace());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1022250859 
Collections.sort(newChildren, order);
//#endif 


//#if 1214728394 
deps.addAll(newChildren);
//#endif 

} 

//#endif 


//#if -477558479 
@Override
    public void removeNodeFromParent(MutableTreeNode node)
    { 

//#if -1141346876 
if(node instanceof ExplorerTreeNode)//1
{ 

//#if 12089704 
removeNodesFromMap((ExplorerTreeNode) node);
//#endif 


//#if -616192810 
((ExplorerTreeNode) node).remove();
//#endif 

} 

//#endif 


//#if -766781101 
super.removeNodeFromParent(node);
//#endif 

} 

//#endif 


//#if -2063832771 
class ExplorerUpdater implements 
//#if -1553739841 
Runnable
//#endif 

  { 

//#if -1981111089 
private LinkedList<ExplorerTreeNode> pendingUpdates =
            new LinkedList<ExplorerTreeNode>();
//#endif 


//#if -390740395 
private boolean hot;
//#endif 


//#if -1900206464 
public static final int MAX_UPDATES_PER_RUN = 100;
//#endif 


//#if 237762733 
public void run()
        { 

//#if -1122993601 
boolean done = false;
//#endif 


//#if 156173377 
for (int i = 0; i < MAX_UPDATES_PER_RUN; i++) //1
{ 

//#if -465471355 
ExplorerTreeNode node = null;
//#endif 


//#if 1564105101 
synchronized (this) //1
{ 

//#if 706736600 
if(!pendingUpdates.isEmpty())//1
{ 

//#if -539321905 
node = pendingUpdates.removeFirst();
//#endif 


//#if 58411341 
node.setPending(false);
//#endif 

} 
else
{ 

//#if -1809756867 
done = true;
//#endif 


//#if -713224717 
hot = false;
//#endif 


//#if 680422791 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1737896004 
updateChildren(new TreePath(getPathToRoot(node)));
//#endif 

} 

//#endif 


//#if -1290630380 
if(!done)//1
{ 

//#if 1741109175 
schedule();
//#endif 

} 
else
{ 

//#if -565379639 
tree.refreshSelection();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1776493055 
private synchronized void schedule()
        { 

//#if 1268793891 
if(hot)//1
{ 

//#if -2041388460 
return;
//#endif 

} 

//#endif 


//#if -1726168604 
hot = true;
//#endif 


//#if 274446114 
EventQueue.invokeLater(this);
//#endif 

} 

//#endif 


//#if -1558646646 
public synchronized void schedule(ExplorerTreeNode node)
        { 

//#if -729013849 
if(node.getPending())//1
{ 

//#if -2001252457 
return;
//#endif 

} 

//#endif 


//#if 1418283994 
pendingUpdates.add(node);
//#endif 


//#if -1142409885 
node.setPending(true);
//#endif 


//#if 77799815 
schedule();
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

