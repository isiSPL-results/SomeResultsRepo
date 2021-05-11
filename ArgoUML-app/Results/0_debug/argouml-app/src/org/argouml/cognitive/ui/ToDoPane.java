
//#if 1704736982 
// Compilation Unit of /ToDoPane.java 
 

//#if -1041591757 
package org.argouml.cognitive.ui;
//#endif 


//#if 1641945361 
import java.awt.BorderLayout;
//#endif 


//#if 215690796 
import java.awt.Color;
//#endif 


//#if -2147150199 
import java.awt.Dimension;
//#endif 


//#if 1264106908 
import java.awt.event.ItemEvent;
//#endif 


//#if -513640596 
import java.awt.event.ItemListener;
//#endif 


//#if -1417288930 
import java.awt.event.MouseEvent;
//#endif 


//#if 119687850 
import java.awt.event.MouseListener;
//#endif 


//#if -1155210054 
import java.text.MessageFormat;
//#endif 


//#if 186818732 
import java.util.ArrayList;
//#endif 


//#if -1726227915 
import java.util.List;
//#endif 


//#if 979585677 
import javax.swing.BorderFactory;
//#endif 


//#if 107230980 
import javax.swing.JComboBox;
//#endif 


//#if -1278455551 
import javax.swing.JLabel;
//#endif 


//#if -1163581455 
import javax.swing.JPanel;
//#endif 


//#if -1408487924 
import javax.swing.JScrollPane;
//#endif 


//#if 1629224931 
import javax.swing.JTree;
//#endif 


//#if 759000127 
import javax.swing.SwingUtilities;
//#endif 


//#if -1568630549 
import javax.swing.event.TreeSelectionEvent;
//#endif 


//#if 1217177021 
import javax.swing.event.TreeSelectionListener;
//#endif 


//#if -733517776 
import javax.swing.tree.TreeModel;
//#endif 


//#if 671443704 
import javax.swing.tree.TreePath;
//#endif 


//#if -212194775 
import org.apache.log4j.Logger;
//#endif 


//#if 336852599 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1183133047 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -1180676514 
import org.argouml.cognitive.ToDoList;
//#endif 


//#if 478600382 
import org.argouml.cognitive.ToDoListEvent;
//#endif 


//#if 1738239242 
import org.argouml.cognitive.ToDoListListener;
//#endif 


//#if 649503592 
import org.argouml.cognitive.Translator;
//#endif 


//#if -367233981 
import org.argouml.ui.DisplayTextTree;
//#endif 


//#if 371052755 
import org.argouml.ui.PerspectiveSupport;
//#endif 


//#if 1486111223 
import org.argouml.ui.ProjectBrowser;
//#endif 


//#if -1427080877 
import org.argouml.ui.SplashScreen;
//#endif 


//#if -971522854 
public class ToDoPane extends 
//#if 1798949474 
JPanel
//#endif 

 implements 
//#if 1943355791 
ItemListener
//#endif 

, 
//#if -1946032454 
TreeSelectionListener
//#endif 

, 
//#if 1186178257 
MouseListener
//#endif 

, 
//#if -1219922016 
ToDoListListener
//#endif 

  { 

//#if 1301758452 
private static final Logger LOG = Logger.getLogger(ToDoPane.class);
//#endif 


//#if 1865617367 
private static final int WARN_THRESHOLD = 50;
//#endif 


//#if 1938270060 
private static final int ALARM_THRESHOLD = 100;
//#endif 


//#if -1218015041 
private static final Color WARN_COLOR = Color.yellow;
//#endif 


//#if 233047996 
private static final Color ALARM_COLOR = Color.pink;
//#endif 


//#if 1580399639 
private static int clicksInToDoPane;
//#endif 


//#if -2033455979 
private static int dblClicksInToDoPane;
//#endif 


//#if -718370934 
private static int toDoPerspectivesChanged;
//#endif 


//#if -881010544 
private JTree tree;
//#endif 


//#if -162606695 
private JComboBox combo;
//#endif 


//#if 1426639865 
private List<ToDoPerspective> perspectives;
//#endif 


//#if 40746500 
private ToDoPerspective curPerspective;
//#endif 


//#if 1577732026 
private ToDoList root;
//#endif 


//#if 1566890001 
private JLabel countLabel;
//#endif 


//#if -1075074063 
private Object lastSel;
//#endif 


//#if 54483996 
private static final long serialVersionUID = 1911401582875302996L;
//#endif 


//#if 1543797899 
private static String formatCountLabel(int size)
    { 

//#if 662677963 
switch (size) //1
{ 
case 0://1


//#if 1809171063 
return Translator.localize("label.todopane.no-items");
//#endif 


case 1://1


//#if 1828546876 
return MessageFormat.
                   format(Translator.localize("label.todopane.item"),
                          new Object[] {
                              Integer.valueOf(size),
                          });
//#endif 


default://1


//#if -2130072707 
return MessageFormat.
                   format(Translator.localize("label.todopane.items"),
                          new Object[] {
                              Integer.valueOf(size),
                          });
//#endif 


} 

//#endif 

} 

//#endif 


//#if 1044733481 
public void selectItem(ToDoItem item)
    { 

//#if -1805563363 
Object[] path = new Object[3];
//#endif 


//#if 711666995 
Object category = null;
//#endif 


//#if -1261272775 
int size = curPerspective.getChildCount(root);
//#endif 


//#if 1186829690 
for (int i = 0; i < size; i++) //1
{ 

//#if -43189729 
category = curPerspective.getChild(root, i);
//#endif 


//#if 321210359 
if(curPerspective.getIndexOfChild(category, item) != -1)//1
{ 

//#if 781872142 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1170241447 
if(category == null)//1
{ 

//#if -831234529 
return;
//#endif 

} 

//#endif 


//#if -921368192 
path[0] = root;
//#endif 


//#if 1465494211 
path[1] = category;
//#endif 


//#if -1738887379 
path[2] = item;
//#endif 


//#if -1252524236 
TreePath trPath = new TreePath(path);
//#endif 


//#if 1590884269 
tree.expandPath(trPath);
//#endif 


//#if 1478286217 
tree.scrollPathToVisible(trPath);
//#endif 


//#if 510073277 
tree.setSelectionPath(trPath);
//#endif 

} 

//#endif 


//#if 809410670 
public ToDoPerspective getCurPerspective()
    { 

//#if 134509466 
return curPerspective;
//#endif 

} 

//#endif 


//#if -1164789239 
private static List<ToDoPerspective> buildPerspectives()
    { 

//#if 845970170 
ToDoPerspective priority = new ToDoByPriority();
//#endif 


//#if -674146678 
ToDoPerspective decision = new ToDoByDecision();
//#endif 


//#if -503679076 
ToDoPerspective goal = new ToDoByGoal();
//#endif 


//#if 1285551056 
ToDoPerspective offender = new ToDoByOffender();
//#endif 


//#if 530394984 
ToDoPerspective poster = new ToDoByPoster();
//#endif 


//#if 10585294 
ToDoPerspective type = new ToDoByType();
//#endif 


//#if 2108882347 
List<ToDoPerspective> perspectives = new ArrayList<ToDoPerspective>();
//#endif 


//#if -860185738 
perspectives.add(priority);
//#endif 


//#if 651535278 
perspectives.add(decision);
//#endif 


//#if -233647835 
perspectives.add(goal);
//#endif 


//#if -1787208885 
perspectives.add(offender);
//#endif 


//#if 2127675615 
perspectives.add(poster);
//#endif 


//#if 148206476 
perspectives.add(type);
//#endif 


//#if 1177870006 
PerspectiveSupport.registerRule(new GoListToDecisionsToItems());
//#endif 


//#if -1068284435 
PerspectiveSupport.registerRule(new GoListToGoalsToItems());
//#endif 


//#if -190578950 
PerspectiveSupport.registerRule(new GoListToPriorityToItem());
//#endif 


//#if 317023120 
PerspectiveSupport.registerRule(new GoListToTypeToItem());
//#endif 


//#if -1960568369 
PerspectiveSupport.registerRule(new GoListToOffenderToItem());
//#endif 


//#if -497843037 
PerspectiveSupport.registerRule(new GoListToPosterToItem());
//#endif 


//#if -1647602218 
return perspectives;
//#endif 

} 

//#endif 


//#if -988556961 
public void mousePressed(MouseEvent e)
    { 
} 

//#endif 


//#if -366167663 
public void toDoItemsRemoved(final ToDoListEvent tde)
    { 

//#if -594648304 
swingInvoke(new Runnable() {
            public void run() {
                if (curPerspective instanceof ToDoListListener) {
                    ((ToDoListListener) curPerspective).toDoItemsRemoved(tde);
                }
                updateCountLabel();
            }
        });
//#endif 

} 

//#endif 


//#if 1977587140 
public ToDoList getRoot()
    { 

//#if -88572780 
return root;
//#endif 

} 

//#endif 


//#if -313197999 
public void toDoListChanged(final ToDoListEvent tde)
    { 

//#if -406924559 
swingInvoke(new Runnable() {
            public void run() {
                if (curPerspective instanceof ToDoListListener) {
                    ((ToDoListListener) curPerspective).toDoListChanged(tde);
                }
                updateCountLabel();
            }
        });
//#endif 

} 

//#endif 


//#if 355509524 
public void updateCountLabel()
    { 

//#if -1167062863 
int size = Designer.theDesigner().getToDoList().size();
//#endif 


//#if -695706370 
countLabel.setText(formatCountLabel(size));
//#endif 


//#if 357361637 
countLabel.setOpaque(size > WARN_THRESHOLD);
//#endif 


//#if -471590597 
countLabel.setBackground((size >= ALARM_THRESHOLD) ? ALARM_COLOR
                                 : WARN_COLOR);
//#endif 

} 

//#endif 


//#if 2094509086 
public void myDoubleClick(
        @SuppressWarnings("unused") int row,
        @SuppressWarnings("unused") TreePath path)
    { 

//#if -1479467812 
dblClicksInToDoPane++;
//#endif 


//#if 1813259106 
if(getSelectedObject() == null)//1
{ 

//#if -388505811 
return;
//#endif 

} 

//#endif 


//#if -326026119 
Object sel = getSelectedObject();
//#endif 


//#if -1772109687 
if(sel instanceof ToDoItem)//1
{ 

//#if 791614011 
((ToDoItem) sel).action();
//#endif 

} 

//#endif 


//#if -301436381 
LOG.debug("2: " + getSelectedObject().toString());
//#endif 

} 

//#endif 


//#if -1121644355 
public void toDoItemsChanged(final ToDoListEvent tde)
    { 

//#if -1550538057 
swingInvoke(new Runnable() {
            public void run() {
                if (curPerspective instanceof ToDoListListener) {
                    ((ToDoListListener) curPerspective).toDoItemsChanged(tde);
                }
            }
        });
//#endif 

} 

//#endif 


//#if 1302448070 
public ToDoPane(SplashScreen splash)
    { 

//#if 1638267797 
setLayout(new BorderLayout());
//#endif 


//#if 1415014636 
combo = new JComboBox();
//#endif 


//#if -1151980218 
tree = new DisplayTextTree();
//#endif 


//#if -521936485 
perspectives = new ArrayList<ToDoPerspective>();
//#endif 


//#if 48668080 
countLabel = new JLabel(formatCountLabel(999));
//#endif 


//#if 343283517 
countLabel.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 4));
//#endif 


//#if 1875895769 
JPanel toolbarPanel = new JPanel(new BorderLayout());
//#endif 


//#if 2130952404 
toolbarPanel.add(countLabel, BorderLayout.EAST);
//#endif 


//#if -1123878419 
toolbarPanel.add(combo, BorderLayout.CENTER);
//#endif 


//#if -1416406365 
add(toolbarPanel, BorderLayout.NORTH);
//#endif 


//#if 1496944884 
add(new JScrollPane(tree), BorderLayout.CENTER);
//#endif 


//#if -1815792824 
combo.addItemListener(this);
//#endif 


//#if 1217723999 
tree.addTreeSelectionListener(this);
//#endif 


//#if 340737313 
tree.setCellRenderer(new ToDoTreeRenderer());
//#endif 


//#if -210044568 
tree.addMouseListener(this);
//#endif 


//#if -29360555 
setRoot(Designer.theDesigner().getToDoList());
//#endif 


//#if 1790145102 
Designer.theDesigner().getToDoList().addToDoListListener(this);
//#endif 


//#if -264322683 
if(splash != null)//1
{ 

//#if -645296266 
splash.getStatusBar().showStatus(
                Translator.localize("statusmsg.bar.making-todopane"));
//#endif 


//#if -1551480680 
splash.getStatusBar().showProgress(25);
//#endif 

} 

//#endif 


//#if 215445361 
setPerspectives(buildPerspectives());
//#endif 


//#if 1113770822 
setMinimumSize(new Dimension(120, 100));
//#endif 


//#if -1349138875 
Dimension preferredSize = getPreferredSize();
//#endif 


//#if -570519938 
preferredSize.height = 120;
//#endif 


//#if -1621160924 
setPreferredSize(preferredSize);
//#endif 

} 

//#endif 


//#if -1274983100 
public void setRoot(ToDoList r)
    { 

//#if 1873595355 
root = r;
//#endif 


//#if -1550352982 
updateTree();
//#endif 

} 

//#endif 


//#if 1950573089 
public Object getSelectedObject()
    { 

//#if -1261448464 
return tree.getLastSelectedPathComponent();
//#endif 

} 

//#endif 


//#if -1800367152 
public void valueChanged(TreeSelectionEvent e)
    { 

//#if 691399258 
LOG.debug("ToDoPane valueChanged");
//#endif 


//#if -2022770170 
Object sel = getSelectedObject();
//#endif 


//#if -1284539656 
ProjectBrowser.getInstance().setToDoItem(sel);
//#endif 


//#if -27909216 
LOG.debug("lastselection: " + lastSel);
//#endif 


//#if 862107386 
LOG.debug("sel: " + sel);
//#endif 


//#if 1895817184 
if(lastSel instanceof ToDoItem)//1
{ 

//#if -711458708 
((ToDoItem) lastSel).deselect();
//#endif 

} 

//#endif 


//#if 1622768982 
if(sel instanceof ToDoItem)//1
{ 

//#if 670440200 
((ToDoItem) sel).select();
//#endif 

} 

//#endif 


//#if -1167285932 
lastSel = sel;
//#endif 

} 

//#endif 


//#if 1528724582 
private void swingInvoke(Runnable task)
    { 

//#if -1607285612 
if(SwingUtilities.isEventDispatchThread())//1
{ 

//#if -518531700 
task.run();
//#endif 

} 
else
{ 

//#if 1832085213 
SwingUtilities.invokeLater(task);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1222139069 
public static void mySingleClick(
        @SuppressWarnings("unused") int row,
        @SuppressWarnings("unused") TreePath path)
    { 

//#if 973589914 
clicksInToDoPane++;
//#endif 

} 

//#endif 


//#if -2043540895 
public void setPerspectives(List<ToDoPerspective> pers)
    { 

//#if -1122703568 
perspectives = pers;
//#endif 


//#if -1517510514 
if(pers.isEmpty())//1
{ 

//#if -631918522 
curPerspective = null;
//#endif 

} 
else
{ 

//#if -1887201324 
curPerspective = pers.get(0);
//#endif 

} 

//#endif 


//#if 1029449151 
for (ToDoPerspective tdp : perspectives) //1
{ 

//#if -320180541 
combo.addItem(tdp);
//#endif 

} 

//#endif 


//#if 670111587 
if(pers.isEmpty())//2
{ 

//#if 228543233 
curPerspective = null;
//#endif 

} 
else

//#if 1232512139 
if(pers.contains(curPerspective))//1
{ 

//#if -1829693635 
setCurPerspective(curPerspective);
//#endif 

} 
else
{ 

//#if -437505412 
setCurPerspective(perspectives.get(0));
//#endif 

} 

//#endif 


//#endif 


//#if 1164477058 
updateTree();
//#endif 

} 

//#endif 


//#if 1293334462 
public void itemStateChanged(ItemEvent e)
    { 

//#if 1844115240 
if(e.getSource() == combo)//1
{ 

//#if -465006216 
updateTree();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -365134246 
public List<ToDoPerspective> getPerspectiveList()
    { 

//#if 1560845679 
return perspectives;
//#endif 

} 

//#endif 


//#if -1368672719 
public void toDoItemsAdded(final ToDoListEvent tde)
    { 

//#if 1904202334 
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
//#endif 

} 

//#endif 


//#if 720919930 
public void mouseClicked(MouseEvent e)
    { 

//#if 85860869 
int row = tree.getRowForLocation(e.getX(), e.getY());
//#endif 


//#if -901485341 
TreePath path = tree.getPathForLocation(e.getX(), e.getY());
//#endif 


//#if -1555447611 
if(row != -1)//1
{ 

//#if -405959678 
if(e.getClickCount() >= 2)//1
{ 

//#if -155183238 
myDoubleClick(row, path);
//#endif 

} 
else
{ 

//#if -87202216 
mySingleClick(row, path);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -518135147 
e.consume();
//#endif 

} 

//#endif 


//#if 331883364 
public void mouseExited(MouseEvent e)
    { 
} 

//#endif 


//#if -735686102 
public void mouseEntered(MouseEvent e)
    { 
} 

//#endif 


//#if -790996536 
public void setCurPerspective(TreeModel per)
    { 

//#if 1829040459 
if(perspectives == null || !perspectives.contains(per))//1
{ 

//#if 1436298951 
return;
//#endif 

} 

//#endif 


//#if -218018486 
combo.setSelectedItem(per);
//#endif 


//#if -1003579791 
toDoPerspectivesChanged++;
//#endif 

} 

//#endif 


//#if 133175396 
public void mouseReleased(MouseEvent e)
    { 
} 

//#endif 


//#if -1057675518 
protected void updateTree()
    { 

//#if 1872922975 
ToDoPerspective tm = (ToDoPerspective) combo.getSelectedItem();
//#endif 


//#if -458836059 
curPerspective = tm;
//#endif 


//#if 1314258930 
if(curPerspective == null)//1
{ 

//#if 1871754299 
tree.setVisible(false);
//#endif 

} 
else
{ 

//#if -370570124 
LOG.debug("ToDoPane setting tree model");
//#endif 


//#if 20865726 
curPerspective.setRoot(root);
//#endif 


//#if 1510538519 
tree.setShowsRootHandles(true);
//#endif 


//#if -418498101 
tree.setModel(curPerspective);
//#endif 


//#if 235475540 
tree.setVisible(true);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

