
//#if -1526555860 
// Compilation Unit of /ExplorerTree.java 
 

//#if -1139416333 
package org.argouml.ui.explorer;
//#endif 


//#if -946606696 
import java.awt.event.MouseAdapter;
//#endif 


//#if 849824429 
import java.awt.event.MouseEvent;
//#endif 


//#if -1022320773 
import java.util.ArrayList;
//#endif 


//#if -287574714 
import java.util.Collection;
//#endif 


//#if -1952158709 
import java.util.Enumeration;
//#endif 


//#if -1768935682 
import java.util.HashSet;
//#endif 


//#if -1296712778 
import java.util.Iterator;
//#endif 


//#if 737121798 
import java.util.List;
//#endif 


//#if 439624784 
import java.util.Set;
//#endif 


//#if 1839849595 
import javax.swing.JPopupMenu;
//#endif 


//#if -825661838 
import javax.swing.JTree;
//#endif 


//#if -1194714385 
import javax.swing.event.TreeExpansionEvent;
//#endif 


//#if -591547079 
import javax.swing.event.TreeExpansionListener;
//#endif 


//#if -763088388 
import javax.swing.event.TreeSelectionEvent;
//#endif 


//#if -1153554676 
import javax.swing.event.TreeSelectionListener;
//#endif 


//#if 715229002 
import javax.swing.event.TreeWillExpandListener;
//#endif 


//#if -1678902811 
import javax.swing.tree.DefaultMutableTreeNode;
//#endif 


//#if -1356410233 
import javax.swing.tree.TreePath;
//#endif 


//#if -763349441 
import org.argouml.kernel.Project;
//#endif 


//#if -2018572342 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -448603556 
import org.argouml.kernel.ProjectSettings;
//#endif 


//#if 1724411412 
import org.argouml.ui.DisplayTextTree;
//#endif 


//#if -1595152687 
import org.argouml.ui.ProjectActions;
//#endif 


//#if 1368424330 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if 1945323198 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if 640974487 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1129745438 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -2043452934 
public class ExplorerTree extends 
//#if -604578694 
DisplayTextTree
//#endif 

  { 

//#if -658218387 
private boolean updatingSelection;
//#endif 


//#if 1905067053 
private boolean updatingSelectionViaTreeSelection;
//#endif 


//#if -1252103274 
private static final long serialVersionUID = 992867483644759920L;
//#endif 


//#if 1471610306 
public void refreshSelection()
    { 

//#if 278965584 
Collection targets = TargetManager.getInstance().getTargets();
//#endif 


//#if 1105958181 
updatingSelectionViaTreeSelection = true;
//#endif 


//#if -869933960 
setSelection(targets.toArray());
//#endif 


//#if -491796032 
updatingSelectionViaTreeSelection = false;
//#endif 

} 

//#endif 


//#if 1665076192 
private void addTargetsInternal(Object[] addedTargets)
    { 

//#if 1502326382 
if(addedTargets.length < 1)//1
{ 

//#if -1949142549 
return;
//#endif 

} 

//#endif 


//#if -1477527085 
Set targets = new HashSet();
//#endif 


//#if 1976516376 
for (Object t : addedTargets) //1
{ 

//#if -108725246 
if(t instanceof Fig)//1
{ 

//#if 174312520 
targets.add(((Fig) t).getOwner());
//#endif 

} 
else
{ 

//#if 1487576869 
targets.add(t);
//#endif 

} 

//#endif 


//#if -193401569 
selectVisible(t);
//#endif 

} 

//#endif 


//#if 1077885033 
int[] selectedRows = getSelectionRows();
//#endif 


//#if 834411970 
if(selectedRows != null && selectedRows.length > 0)//1
{ 

//#if -672054423 
makeVisible(getPathForRow(selectedRows[0]));
//#endif 


//#if 2136196618 
scrollRowToVisible(selectedRows[0]);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -167238461 
private void selectVisible(Object target)
    { 

//#if 1924456037 
for (int j = 0; j < getRowCount(); j++) //1
{ 

//#if 284352978 
Object rowItem =
                ((DefaultMutableTreeNode) getPathForRow(j)
                 .getLastPathComponent()).getUserObject();
//#endif 


//#if 1060755587 
if(rowItem == target)//1
{ 

//#if 1663296871 
addSelectionRow(j);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 980196932 
private void selectChildren(ExplorerTreeModel model, ExplorerTreeNode node,
                                Set targets)
    { 

//#if -763792942 
if(targets.isEmpty())//1
{ 

//#if 2023186872 
return;
//#endif 

} 

//#endif 


//#if -8883706 
Object nodeObject = node.getUserObject();
//#endif 


//#if 1066574970 
if(nodeObject != null)//1
{ 

//#if 645406624 
for (Object t : targets) //1
{ 

//#if -1141459182 
if(t == nodeObject)//1
{ 

//#if -787452156 
addSelectionPath(new TreePath(node.getPath()));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1329131144 
model.updateChildren(new TreePath(node.getPath()));
//#endif 


//#if -8180079 
Enumeration e = node.children();
//#endif 


//#if 1770710930 
while (e.hasMoreElements()) //1
{ 

//#if 2014242918 
selectChildren(model, (ExplorerTreeNode) e.nextElement(), targets);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1959935526 
public ExplorerTree()
    { 

//#if -441558462 
super();
//#endif 


//#if 916369507 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 642737177 
this.setModel(new ExplorerTreeModel(p, this));
//#endif 


//#if 232749557 
ProjectSettings ps = p.getProjectSettings();
//#endif 


//#if 1623990597 
setShowStereotype(ps.getShowStereotypesValue());
//#endif 


//#if 657260242 
this.addMouseListener(new ExplorerMouseListener(this));
//#endif 


//#if -1237768752 
this.addTreeSelectionListener(new ExplorerTreeSelectionListener());
//#endif 


//#if 111538842 
this.addTreeWillExpandListener(new ExplorerTreeWillExpandListener());
//#endif 


//#if 181143600 
this.addTreeExpansionListener(new ExplorerTreeExpansionListener());
//#endif 


//#if 1085926782 
TargetManager.getInstance()
        .addTargetListener(new ExplorerTargetListener());
//#endif 

} 

//#endif 


//#if -866421982 
private void selectAll(Set targets)
    { 

//#if 2003783853 
ExplorerTreeModel model = (ExplorerTreeModel) getModel();
//#endif 


//#if -1099025712 
ExplorerTreeNode root = (ExplorerTreeNode) model.getRoot();
//#endif 


//#if -1096319675 
selectChildren(model, root, targets);
//#endif 

} 

//#endif 


//#if -1048978782 
private void setSelection(Object[] targets)
    { 

//#if -1556937744 
updatingSelectionViaTreeSelection = true;
//#endif 


//#if -1358600271 
this.clearSelection();
//#endif 


//#if -910741168 
addTargetsInternal(targets);
//#endif 


//#if -1437191083 
updatingSelectionViaTreeSelection = false;
//#endif 

} 

//#endif 


//#if 1848516753 
class ExplorerTreeExpansionListener implements 
//#if -242224689 
TreeExpansionListener
//#endif 

  { 

//#if 2037644954 
public void treeCollapsed(TreeExpansionEvent event)
        { 
} 

//#endif 


//#if 1668473238 
public void treeExpanded(TreeExpansionEvent event)
        { 

//#if 464303244 
setSelection(TargetManager.getInstance().getTargets().toArray());
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1668421538 
class ExplorerTreeWillExpandListener implements 
//#if -710417108 
TreeWillExpandListener
//#endif 

  { 

//#if -1104266770 
public void treeWillCollapse(TreeExpansionEvent tee)
        { 
} 

//#endif 


//#if 1879810465 
public void treeWillExpand(TreeExpansionEvent tee)
        { 

//#if 102714743 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 826588937 
ProjectSettings ps = p.getProjectSettings();
//#endif 


//#if 1618394545 
setShowStereotype(ps.getShowStereotypesValue());
//#endif 


//#if -422401768 
if(getModel() instanceof ExplorerTreeModel)//1
{ 

//#if -2138739483 
((ExplorerTreeModel) getModel()).updateChildren(tee.getPath());
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1626453387 
class ExplorerMouseListener extends 
//#if 1790996928 
MouseAdapter
//#endif 

  { 

//#if -41559133 
private JTree mLTree;
//#endif 


//#if 667459307 
private void myDoubleClick()
        { 

//#if 614093119 
Object target = TargetManager.getInstance().getTarget();
//#endif 


//#if 138389746 
if(target != null)//1
{ 

//#if -1102590675 
List show = new ArrayList();
//#endif 


//#if 1346657999 
show.add(target);
//#endif 


//#if -1041347938 
ProjectActions.jumpToDiagramShowing(show);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1782242908 
@Override
        public void mousePressed(MouseEvent me)
        { 

//#if -1894865281 
if(me.isPopupTrigger())//1
{ 

//#if 1838378832 
me.consume();
//#endif 


//#if -1116849624 
showPopupMenu(me);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1651288730 
public ExplorerMouseListener(JTree newtree)
        { 

//#if -657302551 
super();
//#endif 


//#if 829395891 
mLTree = newtree;
//#endif 

} 

//#endif 


//#if 1233694115 
@Override
        public void mouseReleased(MouseEvent me)
        { 

//#if 1631296435 
if(me.isPopupTrigger())//1
{ 

//#if -993608913 
me.consume();
//#endif 


//#if 1713013161 
showPopupMenu(me);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 170366671 
public void showPopupMenu(MouseEvent me)
        { 

//#if -897007832 
TreePath path = getPathForLocation(me.getX(), me.getY());
//#endif 


//#if -1279018498 
if(path == null)//1
{ 

//#if -1617377603 
return;
//#endif 

} 

//#endif 


//#if 31507109 
if(!isPathSelected(path))//1
{ 

//#if 1184211674 
getSelectionModel().setSelectionPath(path);
//#endif 

} 

//#endif 


//#if 845039680 
Object selectedItem =
                ((DefaultMutableTreeNode) path.getLastPathComponent())
                .getUserObject();
//#endif 


//#if 374569504 
JPopupMenu popup = new ExplorerPopup(selectedItem, me);
//#endif 


//#if -946039529 
if(popup.getComponentCount() > 0)//1
{ 

//#if 914295750 
popup.show(mLTree, me.getX(), me.getY());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -328066839 
@Override
        public void mouseClicked(MouseEvent me)
        { 

//#if 1224639121 
if(me.isPopupTrigger())//1
{ 

//#if -285782452 
me.consume();
//#endif 


//#if 600463532 
showPopupMenu(me);
//#endif 

} 

//#endif 


//#if 913115983 
if(me.getClickCount() >= 2)//1
{ 

//#if -1858898422 
myDoubleClick();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#if 29272158 
class ExplorerTreeSelectionListener implements 
//#if 66367764 
TreeSelectionListener
//#endif 

  { 

//#if -478167382 
public void valueChanged(TreeSelectionEvent e)
        { 

//#if -650743360 
if(!updatingSelectionViaTreeSelection)//1
{ 

//#if -1296041815 
updatingSelectionViaTreeSelection = true;
//#endif 


//#if 1925948539 
TreePath[] addedOrRemovedPaths = e.getPaths();
//#endif 


//#if 826835390 
TreePath[] selectedPaths = getSelectionPaths();
//#endif 


//#if 1955452856 
List elementsAsList = new ArrayList();
//#endif 


//#if 1693368926 
for (int i = 0;
                        selectedPaths != null && i < selectedPaths.length; i++) //1
{ 

//#if -1956316154 
Object element =
                        ((DefaultMutableTreeNode)
                         selectedPaths[i].getLastPathComponent())
                        .getUserObject();
//#endif 


//#if -254578164 
elementsAsList.add(element);
//#endif 


//#if -1382184848 
int rows = getRowCount();
//#endif 


//#if 669950100 
for (int row = 0; row < rows; row++) //1
{ 

//#if 558975198 
Object rowItem =
                            ((DefaultMutableTreeNode) getPathForRow(row)
                             .getLastPathComponent())
                            .getUserObject();
//#endif 


//#if 872293160 
if(rowItem == element
                                && !(isRowSelected(row)))//1
{ 

//#if 463226531 
addSelectionRow(row);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -157636950 
boolean callSetTarget = true;
//#endif 


//#if -1586371758 
List addedElements = new ArrayList();
//#endif 


//#if 2071547854 
for (int i = 0; i < addedOrRemovedPaths.length; i++) //1
{ 

//#if 1269911487 
Object element =
                        ((DefaultMutableTreeNode)
                         addedOrRemovedPaths[i].getLastPathComponent())
                        .getUserObject();
//#endif 


//#if -1738802309 
if(!e.isAddedPath(i))//1
{ 

//#if -1363321847 
callSetTarget = false;
//#endif 


//#if -853954971 
break;

//#endif 

} 

//#endif 


//#if 1070769641 
addedElements.add(element);
//#endif 

} 

//#endif 


//#if -50566642 
if(callSetTarget && addedElements.size()
                        == elementsAsList.size()
                        && elementsAsList.containsAll(addedElements))//1
{ 

//#if 268422521 
TargetManager.getInstance().setTargets(elementsAsList);
//#endif 

} 
else
{ 

//#if 931360030 
List removedTargets = new ArrayList();
//#endif 


//#if -1816474114 
List addedTargets = new ArrayList();
//#endif 


//#if 156813059 
for (int i = 0; i < addedOrRemovedPaths.length; i++) //1
{ 

//#if -565168691 
Object element =
                            ((DefaultMutableTreeNode)
                             addedOrRemovedPaths[i]
                             .getLastPathComponent())
                            .getUserObject();
//#endif 


//#if -1424038764 
if(e.isAddedPath(i))//1
{ 

//#if -579710717 
addedTargets.add(element);
//#endif 

} 
else
{ 

//#if -1779882937 
removedTargets.add(element);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1313028978 
if(!removedTargets.isEmpty())//1
{ 

//#if 1675970650 
Iterator it = removedTargets.iterator();
//#endif 


//#if 1286610388 
while (it.hasNext()) //1
{ 

//#if -524702211 
TargetManager.getInstance().removeTarget(it.next());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 435258222 
if(!addedTargets.isEmpty())//1
{ 

//#if 1691297131 
Iterator it = addedTargets.iterator();
//#endif 


//#if -1031522557 
while (it.hasNext()) //1
{ 

//#if -1390947277 
TargetManager.getInstance().addTarget(it.next());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1939351876 
updatingSelectionViaTreeSelection = false;
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1491116311 
class ExplorerTargetListener implements 
//#if 967265450 
TargetListener
//#endif 

  { 

//#if 978296702 
private void setTargets(Object[] targets)
        { 

//#if -194448373 
if(!updatingSelection)//1
{ 

//#if 186758807 
updatingSelection = true;
//#endif 


//#if 1818718137 
if(targets.length <= 0)//1
{ 

//#if 329129560 
clearSelection();
//#endif 

} 
else
{ 

//#if -246457283 
setSelection(targets);
//#endif 

} 

//#endif 


//#if 1077794446 
updatingSelection = false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -293087406 
public void targetRemoved(TargetEvent e)
        { 

//#if -572520059 
if(!updatingSelection)//1
{ 

//#if 464669313 
updatingSelection = true;
//#endif 


//#if 1035493916 
Object[] targets = e.getRemovedTargets();
//#endif 


//#if 1878463417 
int rows = getRowCount();
//#endif 


//#if 957508437 
for (int i = 0; i < targets.length; i++) //1
{ 

//#if 994208087 
Object target = targets[i];
//#endif 


//#if -1642096806 
if(target instanceof Fig)//1
{ 

//#if 903322460 
target = ((Fig) target).getOwner();
//#endif 

} 

//#endif 


//#if 1872172346 
for (int j = 0; j < rows; j++) //1
{ 

//#if -1807986409 
Object rowItem =
                            ((DefaultMutableTreeNode)
                             getPathForRow(j).getLastPathComponent())
                            .getUserObject();
//#endif 


//#if 1959940616 
if(rowItem == target)//1
{ 

//#if -818824946 
updatingSelectionViaTreeSelection = true;
//#endif 


//#if 1243639086 
removeSelectionRow(j);
//#endif 


//#if -30530825 
updatingSelectionViaTreeSelection = false;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1702371810 
if(getSelectionCount() > 0)//1
{ 

//#if 455842143 
scrollRowToVisible(getSelectionRows()[0]);
//#endif 

} 

//#endif 


//#if 1103085540 
updatingSelection = false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 552050260 
public void targetSet(TargetEvent e)
        { 

//#if 1416672672 
setTargets(e.getNewTargets());
//#endif 

} 

//#endif 


//#if -2103457998 
public void targetAdded(TargetEvent e)
        { 

//#if 1689953986 
if(!updatingSelection)//1
{ 

//#if 473627952 
updatingSelection = true;
//#endif 


//#if -1577314963 
Object[] targets = e.getAddedTargets();
//#endif 


//#if -2095083664 
updatingSelectionViaTreeSelection = true;
//#endif 


//#if -1339107888 
addTargetsInternal(targets);
//#endif 


//#if -939845419 
updatingSelectionViaTreeSelection = false;
//#endif 


//#if 1380803349 
updatingSelection = false;
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

