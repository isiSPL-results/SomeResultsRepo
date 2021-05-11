// Compilation Unit of /ExplorerTree.java 
 
package org.argouml.ui.explorer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.kernel.ProjectSettings;
import org.argouml.ui.DisplayTextTree;
import org.argouml.ui.ProjectActions;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.ui.targetmanager.TargetListener;
import org.argouml.ui.targetmanager.TargetManager;
import org.tigris.gef.presentation.Fig;
public class ExplorerTree extends DisplayTextTree
  { 
private boolean updatingSelection;
private boolean updatingSelectionViaTreeSelection;
private static final long serialVersionUID = 992867483644759920L;
public void refreshSelection()
    { 
Collection targets = TargetManager.getInstance().getTargets();
updatingSelectionViaTreeSelection = true;
setSelection(targets.toArray());
updatingSelectionViaTreeSelection = false;
} 

private void addTargetsInternal(Object[] addedTargets)
    { 
if(addedTargets.length < 1)//1
{ 
return;
} 

Set targets = new HashSet();
for (Object t : addedTargets) //1
{ 
if(t instanceof Fig)//1
{ 
targets.add(((Fig) t).getOwner());
} 
else
{ 
targets.add(t);
} 

selectVisible(t);
} 

int[] selectedRows = getSelectionRows();
if(selectedRows != null && selectedRows.length > 0)//1
{ 
makeVisible(getPathForRow(selectedRows[0]));
scrollRowToVisible(selectedRows[0]);
} 

} 

private void selectVisible(Object target)
    { 
for (int j = 0; j < getRowCount(); j++) //1
{ 
Object rowItem =
                ((DefaultMutableTreeNode) getPathForRow(j)
                 .getLastPathComponent()).getUserObject();
if(rowItem == target)//1
{ 
addSelectionRow(j);
} 

} 

} 

private void selectChildren(ExplorerTreeModel model, ExplorerTreeNode node,
                                Set targets)
    { 
if(targets.isEmpty())//1
{ 
return;
} 

Object nodeObject = node.getUserObject();
if(nodeObject != null)//1
{ 
for (Object t : targets) //1
{ 
if(t == nodeObject)//1
{ 
addSelectionPath(new TreePath(node.getPath()));
} 

} 

} 

model.updateChildren(new TreePath(node.getPath()));
Enumeration e = node.children();
while (e.hasMoreElements()) //1
{ 
selectChildren(model, (ExplorerTreeNode) e.nextElement(), targets);
} 

} 

public ExplorerTree()
    { 
super();
Project p = ProjectManager.getManager().getCurrentProject();
this.setModel(new ExplorerTreeModel(p, this));
ProjectSettings ps = p.getProjectSettings();
setShowStereotype(ps.getShowStereotypesValue());
this.addMouseListener(new ExplorerMouseListener(this));
this.addTreeSelectionListener(new ExplorerTreeSelectionListener());
this.addTreeWillExpandListener(new ExplorerTreeWillExpandListener());
this.addTreeExpansionListener(new ExplorerTreeExpansionListener());
TargetManager.getInstance()
        .addTargetListener(new ExplorerTargetListener());
} 

private void selectAll(Set targets)
    { 
ExplorerTreeModel model = (ExplorerTreeModel) getModel();
ExplorerTreeNode root = (ExplorerTreeNode) model.getRoot();
selectChildren(model, root, targets);
} 

private void setSelection(Object[] targets)
    { 
updatingSelectionViaTreeSelection = true;
this.clearSelection();
addTargetsInternal(targets);
updatingSelectionViaTreeSelection = false;
} 

class ExplorerTreeExpansionListener implements TreeExpansionListener
  { 
public void treeCollapsed(TreeExpansionEvent event)
        { 
} 

public void treeExpanded(TreeExpansionEvent event)
        { 
setSelection(TargetManager.getInstance().getTargets().toArray());
} 

 } 

class ExplorerTreeWillExpandListener implements TreeWillExpandListener
  { 
public void treeWillCollapse(TreeExpansionEvent tee)
        { 
} 

public void treeWillExpand(TreeExpansionEvent tee)
        { 
Project p = ProjectManager.getManager().getCurrentProject();
ProjectSettings ps = p.getProjectSettings();
setShowStereotype(ps.getShowStereotypesValue());
if(getModel() instanceof ExplorerTreeModel)//1
{ 
((ExplorerTreeModel) getModel()).updateChildren(tee.getPath());
} 

} 

 } 

class ExplorerMouseListener extends MouseAdapter
  { 
private JTree mLTree;
private void myDoubleClick()
        { 
Object target = TargetManager.getInstance().getTarget();
if(target != null)//1
{ 
List show = new ArrayList();
show.add(target);
ProjectActions.jumpToDiagramShowing(show);
} 

} 

@Override
        public void mousePressed(MouseEvent me)
        { 
if(me.isPopupTrigger())//1
{ 
me.consume();
showPopupMenu(me);
} 

} 

public ExplorerMouseListener(JTree newtree)
        { 
super();
mLTree = newtree;
} 

@Override
        public void mouseReleased(MouseEvent me)
        { 
if(me.isPopupTrigger())//1
{ 
me.consume();
showPopupMenu(me);
} 

} 

public void showPopupMenu(MouseEvent me)
        { 
TreePath path = getPathForLocation(me.getX(), me.getY());
if(path == null)//1
{ 
return;
} 

if(!isPathSelected(path))//1
{ 
getSelectionModel().setSelectionPath(path);
} 

Object selectedItem =
                ((DefaultMutableTreeNode) path.getLastPathComponent())
                .getUserObject();
JPopupMenu popup = new ExplorerPopup(selectedItem, me);
if(popup.getComponentCount() > 0)//1
{ 
popup.show(mLTree, me.getX(), me.getY());
} 

} 

@Override
        public void mouseClicked(MouseEvent me)
        { 
if(me.isPopupTrigger())//1
{ 
me.consume();
showPopupMenu(me);
} 

if(me.getClickCount() >= 2)//1
{ 
myDoubleClick();
} 

} 

 } 

class ExplorerTreeSelectionListener implements TreeSelectionListener
  { 
public void valueChanged(TreeSelectionEvent e)
        { 
if(!updatingSelectionViaTreeSelection)//1
{ 
updatingSelectionViaTreeSelection = true;
TreePath[] addedOrRemovedPaths = e.getPaths();
TreePath[] selectedPaths = getSelectionPaths();
List elementsAsList = new ArrayList();
for (int i = 0;
                        selectedPaths != null && i < selectedPaths.length; i++) //1
{ 
Object element =
                        ((DefaultMutableTreeNode)
                         selectedPaths[i].getLastPathComponent())
                        .getUserObject();
elementsAsList.add(element);
int rows = getRowCount();
for (int row = 0; row < rows; row++) //1
{ 
Object rowItem =
                            ((DefaultMutableTreeNode) getPathForRow(row)
                             .getLastPathComponent())
                            .getUserObject();
if(rowItem == element
                                && !(isRowSelected(row)))//1
{ 
addSelectionRow(row);
} 

} 

} 

boolean callSetTarget = true;
List addedElements = new ArrayList();
for (int i = 0; i < addedOrRemovedPaths.length; i++) //1
{ 
Object element =
                        ((DefaultMutableTreeNode)
                         addedOrRemovedPaths[i].getLastPathComponent())
                        .getUserObject();
if(!e.isAddedPath(i))//1
{ 
callSetTarget = false;
break;

} 

addedElements.add(element);
} 

if(callSetTarget && addedElements.size()
                        == elementsAsList.size()
                        && elementsAsList.containsAll(addedElements))//1
{ 
TargetManager.getInstance().setTargets(elementsAsList);
} 
else
{ 
List removedTargets = new ArrayList();
List addedTargets = new ArrayList();
for (int i = 0; i < addedOrRemovedPaths.length; i++) //1
{ 
Object element =
                            ((DefaultMutableTreeNode)
                             addedOrRemovedPaths[i]
                             .getLastPathComponent())
                            .getUserObject();
if(e.isAddedPath(i))//1
{ 
addedTargets.add(element);
} 
else
{ 
removedTargets.add(element);
} 

} 

if(!removedTargets.isEmpty())//1
{ 
Iterator it = removedTargets.iterator();
while (it.hasNext()) //1
{ 
TargetManager.getInstance().removeTarget(it.next());
} 

} 

if(!addedTargets.isEmpty())//1
{ 
Iterator it = addedTargets.iterator();
while (it.hasNext()) //1
{ 
TargetManager.getInstance().addTarget(it.next());
} 

} 

} 

updatingSelectionViaTreeSelection = false;
} 

} 

 } 

class ExplorerTargetListener implements TargetListener
  { 
private void setTargets(Object[] targets)
        { 
if(!updatingSelection)//1
{ 
updatingSelection = true;
if(targets.length <= 0)//1
{ 
clearSelection();
} 
else
{ 
setSelection(targets);
} 

updatingSelection = false;
} 

} 

public void targetRemoved(TargetEvent e)
        { 
if(!updatingSelection)//1
{ 
updatingSelection = true;
Object[] targets = e.getRemovedTargets();
int rows = getRowCount();
for (int i = 0; i < targets.length; i++) //1
{ 
Object target = targets[i];
if(target instanceof Fig)//1
{ 
target = ((Fig) target).getOwner();
} 

for (int j = 0; j < rows; j++) //1
{ 
Object rowItem =
                            ((DefaultMutableTreeNode)
                             getPathForRow(j).getLastPathComponent())
                            .getUserObject();
if(rowItem == target)//1
{ 
updatingSelectionViaTreeSelection = true;
removeSelectionRow(j);
updatingSelectionViaTreeSelection = false;
} 

} 

} 

if(getSelectionCount() > 0)//1
{ 
scrollRowToVisible(getSelectionRows()[0]);
} 

updatingSelection = false;
} 

} 

public void targetSet(TargetEvent e)
        { 
setTargets(e.getNewTargets());
} 

public void targetAdded(TargetEvent e)
        { 
if(!updatingSelection)//1
{ 
updatingSelection = true;
Object[] targets = e.getAddedTargets();
updatingSelectionViaTreeSelection = true;
addTargetsInternal(targets);
updatingSelectionViaTreeSelection = false;
updatingSelection = false;
} 

} 

 } 

 } 


