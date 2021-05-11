// Compilation Unit of /TabToDo.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.ui;
//#endif 


//#if COGNITIVE 
import java.awt.BorderLayout;
//#endif 


//#if COGNITIVE 
import java.awt.event.ComponentEvent;
//#endif 


//#if COGNITIVE 
import java.awt.event.ComponentListener;
//#endif 


//#if COGNITIVE 
import javax.swing.Action;
//#endif 


//#if COGNITIVE 
import javax.swing.JPanel;
//#endif 


//#if COGNITIVE 
import javax.swing.JToolBar;
//#endif 


//#if COGNITIVE 
import javax.swing.SwingConstants;
//#endif 


//#if COGNITIVE 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if COGNITIVE 
import org.argouml.configuration.Configuration;
//#endif 


//#if COGNITIVE 
import org.argouml.swingext.LeftArrowIcon;
//#endif 


//#if COGNITIVE 
import org.argouml.ui.TabToDoTarget;
//#endif 


//#if COGNITIVE 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if COGNITIVE 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if COGNITIVE 
import org.tigris.swidgets.BorderSplitPane;
//#endif 


//#if COGNITIVE 
import org.tigris.swidgets.Horizontal;
//#endif 


//#if COGNITIVE 
import org.tigris.swidgets.Vertical;
//#endif 


//#if COGNITIVE 
import org.tigris.toolbar.ToolBarFactory;
//#endif 


//#if COGNITIVE 
public class TabToDo extends AbstractArgoJPanel
 implements TabToDoTarget
, ComponentListener
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

//#endif 


