package org.argouml.cognitive.ui;
import java.awt.BorderLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import org.argouml.application.api.AbstractArgoJPanel;
import org.argouml.cognitive.ToDoItem;
import org.argouml.cognitive.critics.Wizard;
import org.argouml.configuration.Configuration;
import org.argouml.swingext.LeftArrowIcon;
import org.argouml.ui.TabToDoTarget;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.ui.targetmanager.TargetManager;
import org.tigris.swidgets.BorderSplitPane;
import org.tigris.swidgets.Horizontal;
import org.tigris.swidgets.Vertical;
import org.tigris.toolbar.ToolBarFactory;
public class TabToDo extends AbstractArgoJPanel
 implements TabToDoTarget
,ComponentListener
  { 
private static int numHushes;
private static final Action actionNewToDoItem = new ActionNewToDoItem();
private static final ToDoItemAction actionResolve = new ActionResolve();
private static final ToDoItemAction actionSnooze = new ActionSnooze();
private WizDescription description = new WizDescription();
private JPanel lastPanel;
private BorderSplitPane splitPane;
private Object target;
private static final long serialVersionUID = 4819730646847978729L;
public void targetSet(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
public TabToDo()
    { 
super("tab.todo-item");
setIcon(new LeftArrowIcon());
String position =
            Configuration.getString(Configuration.makeKey("layout",
                                    "tabtodo"));
setOrientation(
            ((position.equals("West") || position.equals("East"))
             ? Vertical.getInstance() : Horizontal.getInstance()));
setLayout(new BorderLayout());
Object[] actions = {actionNewToDoItem, actionResolve, actionSnooze };
ToolBarFactory factory = new ToolBarFactory(actions);
factory.setRollover(true);
factory.setFloatable(false);
factory.setOrientation(SwingConstants.VERTICAL);
JToolBar toolBar = factory.createToolBar();
toolBar.setName(getTitle());
add(toolBar, BorderLayout.WEST);
splitPane = new BorderSplitPane();
add(splitPane, BorderLayout.CENTER);
setTarget(null);
addComponentListener(this);
} 
public static void incrementNumHushes()
    { 
numHushes++;
} 
public void componentShown(ComponentEvent e)
    { 
setTargetInternal(target);
} 
public void refresh()
    { 
setTarget(TargetManager.getInstance().getTarget());
} 
public void setTree(ToDoPane tdp)
    { 
if(getOrientation().equals(Horizontal.getInstance()))//1
{ 
splitPane.add(tdp, BorderSplitPane.WEST);
} 
else
{ 
splitPane.add(tdp, BorderSplitPane.NORTH);
} 
} 
public void showDescription()
    { 
if(lastPanel != null)//1
{ 
splitPane.remove(lastPanel);
} 
splitPane.add(description, BorderSplitPane.CENTER);
lastPanel = description;
validate();
repaint();
} 
public void componentResized(ComponentEvent e)
    { 
} 
public Object getTarget()
    { 
return target;
} 
public void showStep(JPanel ws)
    { 
if(lastPanel != null)//1
{ 
splitPane.remove(lastPanel);
} 
if(ws != null)//1
{ 
splitPane.add(ws, BorderSplitPane.CENTER);
lastPanel = ws;
} 
else
{ 
splitPane.add(description, BorderSplitPane.CENTER);
lastPanel = description;
} 
validate();
repaint();
} 
public void componentMoved(ComponentEvent e)
    { 
} 
public void setTarget(Object item)
    { 
target = item;
if(isVisible())//1
{ 
setTargetInternal(item);
} 
} 
public void targetRemoved(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
private void setTargetInternal(Object item)
    { 
description.setTarget(item);
Wizard w = null;
if(item instanceof ToDoItem)//1
{ 
w = ((ToDoItem) item).getWizard();
} 
if(w != null)//1
{ 
showStep(w.getCurrentPanel());
} 
else
{ 
showDescription();
} 
updateActionsEnabled(item);
} 
public void componentHidden(ComponentEvent e)
    { 
setTargetInternal(null);
} 
public void targetAdded(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
protected static void updateActionsEnabled(Object item)
    { 
actionResolve.setEnabled(actionResolve.isEnabled());
actionResolve.updateEnabled(item);
actionSnooze.setEnabled(actionSnooze.isEnabled());
actionSnooze.updateEnabled(item);
} 

 } 
