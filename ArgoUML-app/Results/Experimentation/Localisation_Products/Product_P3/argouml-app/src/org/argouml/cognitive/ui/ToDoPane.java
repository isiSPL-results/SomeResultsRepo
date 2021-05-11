package org.argouml.cognitive.ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ToDoItem;
import org.argouml.cognitive.ToDoList;
import org.argouml.cognitive.ToDoListEvent;
import org.argouml.cognitive.ToDoListListener;
import org.argouml.cognitive.Translator;
import org.argouml.ui.DisplayTextTree;
import org.argouml.ui.PerspectiveSupport;
import org.argouml.ui.ProjectBrowser;
import org.argouml.ui.SplashScreen;
public class ToDoPane extends JPanel
 implements ItemListener
,TreeSelectionListener
,MouseListener
,ToDoListListener
  { 
private static final int WARN_THRESHOLD = 50;
private static final int ALARM_THRESHOLD = 100;
private static final Color WARN_COLOR = Color.yellow;
private static final Color ALARM_COLOR = Color.pink;
private static int clicksInToDoPane;
private static int dblClicksInToDoPane;
private static int toDoPerspectivesChanged;
private JTree tree;
private JComboBox combo;
private List<ToDoPerspective> perspectives;
private ToDoPerspective curPerspective;
private ToDoList root;
private JLabel countLabel;
private Object lastSel;
private static final long serialVersionUID = 1911401582875302996L;
private static String formatCountLabel(int size)
    { 
switch (size) //1
{ 
case 0://1

return Translator.localize("label.todopane.no-items");

case 1://1

return MessageFormat.
                   format(Translator.localize("label.todopane.item"),
                          new Object[] {
                              Integer.valueOf(size),
                          });

default://1

return MessageFormat.
                   format(Translator.localize("label.todopane.items"),
                          new Object[] {
                              Integer.valueOf(size),
                          });

} 
} 
public void selectItem(ToDoItem item)
    { 
Object[] path = new Object[3];
Object category = null;
int size = curPerspective.getChildCount(root);
for (int i = 0; i < size; i++) //1
{ 
category = curPerspective.getChild(root, i);
if(curPerspective.getIndexOfChild(category, item) != -1)//1
{ 
break;

} 
} 
if(category == null)//1
{ 
return;
} 
path[0] = root;
path[1] = category;
path[2] = item;
TreePath trPath = new TreePath(path);
tree.expandPath(trPath);
tree.scrollPathToVisible(trPath);
tree.setSelectionPath(trPath);
} 
public ToDoPerspective getCurPerspective()
    { 
return curPerspective;
} 
private static List<ToDoPerspective> buildPerspectives()
    { 
ToDoPerspective priority = new ToDoByPriority();
ToDoPerspective decision = new ToDoByDecision();
ToDoPerspective goal = new ToDoByGoal();
ToDoPerspective offender = new ToDoByOffender();
ToDoPerspective poster = new ToDoByPoster();
ToDoPerspective type = new ToDoByType();
List<ToDoPerspective> perspectives = new ArrayList<ToDoPerspective>();
perspectives.add(priority);
perspectives.add(decision);
perspectives.add(goal);
perspectives.add(offender);
perspectives.add(poster);
perspectives.add(type);
PerspectiveSupport.registerRule(new GoListToDecisionsToItems());
PerspectiveSupport.registerRule(new GoListToGoalsToItems());
PerspectiveSupport.registerRule(new GoListToPriorityToItem());
PerspectiveSupport.registerRule(new GoListToTypeToItem());
PerspectiveSupport.registerRule(new GoListToOffenderToItem());
PerspectiveSupport.registerRule(new GoListToPosterToItem());
return perspectives;
} 
public void mousePressed(MouseEvent e)
    { 
} 
public void toDoItemsRemoved(final ToDoListEvent tde)
    { 
swingInvoke(new Runnable() {
            public void run() {
                if (curPerspective instanceof ToDoListListener) {
                    ((ToDoListListener) curPerspective).toDoItemsRemoved(tde);
                }
                updateCountLabel();
            }
        });
} 
public ToDoList getRoot()
    { 
return root;
} 
public void toDoListChanged(final ToDoListEvent tde)
    { 
swingInvoke(new Runnable() {
            public void run() {
                if (curPerspective instanceof ToDoListListener) {
                    ((ToDoListListener) curPerspective).toDoListChanged(tde);
                }
                updateCountLabel();
            }
        });
} 
public void updateCountLabel()
    { 
int size = Designer.theDesigner().getToDoList().size();
countLabel.setText(formatCountLabel(size));
countLabel.setOpaque(size > WARN_THRESHOLD);
countLabel.setBackground((size >= ALARM_THRESHOLD) ? ALARM_COLOR
                                 : WARN_COLOR);
} 
public void myDoubleClick(
        @SuppressWarnings("unused") int row,
        @SuppressWarnings("unused") TreePath path)
    { 
dblClicksInToDoPane++;
if(getSelectedObject() == null)//1
{ 
return;
} 
Object sel = getSelectedObject();
if(sel instanceof ToDoItem)//1
{ 
((ToDoItem) sel).action();
} 
} 
public void toDoItemsChanged(final ToDoListEvent tde)
    { 
swingInvoke(new Runnable() {
            public void run() {
                if (curPerspective instanceof ToDoListListener) {
                    ((ToDoListListener) curPerspective).toDoItemsChanged(tde);
                }
            }
        });
} 
public ToDoPane(SplashScreen splash)
    { 
setLayout(new BorderLayout());
combo = new JComboBox();
tree = new DisplayTextTree();
perspectives = new ArrayList<ToDoPerspective>();
countLabel = new JLabel(formatCountLabel(999));
countLabel.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 4));
JPanel toolbarPanel = new JPanel(new BorderLayout());
toolbarPanel.add(countLabel, BorderLayout.EAST);
toolbarPanel.add(combo, BorderLayout.CENTER);
add(toolbarPanel, BorderLayout.NORTH);
add(new JScrollPane(tree), BorderLayout.CENTER);
combo.addItemListener(this);
tree.addTreeSelectionListener(this);
tree.setCellRenderer(new ToDoTreeRenderer());
tree.addMouseListener(this);
setRoot(Designer.theDesigner().getToDoList());
Designer.theDesigner().getToDoList().addToDoListListener(this);
if(splash != null)//1
{ 
splash.getStatusBar().showStatus(
                Translator.localize("statusmsg.bar.making-todopane"));
splash.getStatusBar().showProgress(25);
} 
setPerspectives(buildPerspectives());
setMinimumSize(new Dimension(120, 100));
Dimension preferredSize = getPreferredSize();
preferredSize.height = 120;
setPreferredSize(preferredSize);
} 
public void setRoot(ToDoList r)
    { 
root = r;
updateTree();
} 
public Object getSelectedObject()
    { 
return tree.getLastSelectedPathComponent();
} 
public void valueChanged(TreeSelectionEvent e)
    { 
Object sel = getSelectedObject();
ProjectBrowser.getInstance().setToDoItem(sel);
if(lastSel instanceof ToDoItem)//1
{ 
((ToDoItem) lastSel).deselect();
} 
if(sel instanceof ToDoItem)//1
{ 
((ToDoItem) sel).select();
} 
lastSel = sel;
} 
private void swingInvoke(Runnable task)
    { 
if(SwingUtilities.isEventDispatchThread())//1
{ 
task.run();
} 
else
{ 
SwingUtilities.invokeLater(task);
} 
} 
public static void mySingleClick(
        @SuppressWarnings("unused") int row,
        @SuppressWarnings("unused") TreePath path)
    { 
clicksInToDoPane++;
} 
public void setPerspectives(List<ToDoPerspective> pers)
    { 
perspectives = pers;
if(pers.isEmpty())//1
{ 
curPerspective = null;
} 
else
{ 
curPerspective = pers.get(0);
} 
for (ToDoPerspective tdp : perspectives) //1
{ 
combo.addItem(tdp);
} 
if(pers.isEmpty())//2
{ 
curPerspective = null;
} 
else
if(pers.contains(curPerspective))//1
{ 
setCurPerspective(curPerspective);
} 
else
{ 
setCurPerspective(perspectives.get(0));
} 
updateTree();
} 
public void itemStateChanged(ItemEvent e)
    { 
if(e.getSource() == combo)//1
{ 
updateTree();
} 
} 
public List<ToDoPerspective> getPerspectiveList()
    { 
return perspectives;
} 
public void toDoItemsAdded(final ToDoListEvent tde)
    { 
swingInvoke(new Runnable() {
            public void run() {
                if (curPerspective instanceof ToDoListListener) {
                    ((ToDoListListener) curPerspective).toDoItemsAdded(tde);
                }
                List<ToDoItem> items = tde.getToDoItemList();
                for (ToDoItem todo : items) {
                    if (todo.getPriority()
                            >= ToDoItem.INTERRUPTIVE_PRIORITY) {
                        // keep nagging until the user solves the problem:
                        // This seems a nice way to nag:
                        selectItem(todo);
                        break; // Only interrupt for one todoitem
                    }
                }
                updateCountLabel();
            }
        });
} 
public void mouseClicked(MouseEvent e)
    { 
int row = tree.getRowForLocation(e.getX(), e.getY());
TreePath path = tree.getPathForLocation(e.getX(), e.getY());
if(row != -1)//1
{ 
if(e.getClickCount() >= 2)//1
{ 
myDoubleClick(row, path);
} 
else
{ 
mySingleClick(row, path);
} 
} 
e.consume();
} 
public void mouseExited(MouseEvent e)
    { 
} 
public void mouseEntered(MouseEvent e)
    { 
} 
public void setCurPerspective(TreeModel per)
    { 
if(perspectives == null || !perspectives.contains(per))//1
{ 
return;
} 
combo.setSelectedItem(per);
toDoPerspectivesChanged++;
} 
public void mouseReleased(MouseEvent e)
    { 
} 
protected void updateTree()
    { 
ToDoPerspective tm = (ToDoPerspective) combo.getSelectedItem();
curPerspective = tm;
if(curPerspective == null)//1
{ 
tree.setVisible(false);
} 
else
{ 
curPerspective.setRoot(root);
tree.setShowsRootHandles(true);
tree.setModel(curPerspective);
tree.setVisible(true);
} 
} 

 } 
