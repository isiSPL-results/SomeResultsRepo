
//#if 1837041095 
// Compilation Unit of /TabToDo.java 
 

//#if -317120198 
package org.argouml.cognitive.ui;
//#endif 


//#if -264027240 
import java.awt.BorderLayout;
//#endif 


//#if 1193769213 
import java.awt.event.ComponentEvent;
//#endif 


//#if 128107 
import java.awt.event.ComponentListener;
//#endif 


//#if -1233256498 
import javax.swing.Action;
//#endif 


//#if 1897947850 
import javax.swing.JPanel;
//#endif 


//#if 817089427 
import javax.swing.JToolBar;
//#endif 


//#if -523359117 
import javax.swing.SwingConstants;
//#endif 


//#if 611669864 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if 1811910626 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 2050987233 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if 74620873 
import org.argouml.configuration.Configuration;
//#endif 


//#if -626184801 
import org.argouml.swingext.LeftArrowIcon;
//#endif 


//#if 1508604733 
import org.argouml.ui.TabToDoTarget;
//#endif 


//#if 1729132818 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if -610519521 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -765425172 
import org.tigris.swidgets.BorderSplitPane;
//#endif 


//#if -75491728 
import org.tigris.swidgets.Horizontal;
//#endif 


//#if 860112798 
import org.tigris.swidgets.Vertical;
//#endif 


//#if 415585902 
import org.tigris.toolbar.ToolBarFactory;
//#endif 


//#if -1570518154 
public class TabToDo extends 
//#if -533440909 
AbstractArgoJPanel
//#endif 

 implements 
//#if -1181746802 
TabToDoTarget
//#endif 

, 
//#if -78537133 
ComponentListener
//#endif 

  { 

//#if 1966671681 
private static int numHushes;
//#endif 


//#if -1564159132 
private static final Action actionNewToDoItem = new ActionNewToDoItem();
//#endif 


//#if -292673237 
private static final ToDoItemAction actionResolve = new ActionResolve();
//#endif 


//#if 296743885 
private static final ToDoItemAction actionSnooze = new ActionSnooze();
//#endif 


//#if -926379168 
private WizDescription description = new WizDescription();
//#endif 


//#if 2110521324 
private JPanel lastPanel;
//#endif 


//#if -1897004022 
private BorderSplitPane splitPane;
//#endif 


//#if -346145018 
private Object target;
//#endif 


//#if 1367788108 
private static final long serialVersionUID = 4819730646847978729L;
//#endif 


//#if 1837493051 
public void targetSet(TargetEvent e)
    { 

//#if 821430924 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -2075571819 
public TabToDo()
    { 

//#if -763716781 
super("tab.todo-item");
//#endif 


//#if -473906960 
setIcon(new LeftArrowIcon());
//#endif 


//#if -118596430 
String position =
            Configuration.getString(Configuration.makeKey("layout",
                                    "tabtodo"));
//#endif 


//#if 401054044 
setOrientation(
            ((position.equals("West") || position.equals("East"))
             ? Vertical.getInstance() : Horizontal.getInstance()));
//#endif 


//#if -739617416 
setLayout(new BorderLayout());
//#endif 


//#if 141868862 
Object[] actions = {actionNewToDoItem, actionResolve, actionSnooze };
//#endif 


//#if 179235775 
ToolBarFactory factory = new ToolBarFactory(actions);
//#endif 


//#if -434926418 
factory.setRollover(true);
//#endif 


//#if 191223194 
factory.setFloatable(false);
//#endif 


//#if -67829820 
factory.setOrientation(SwingConstants.VERTICAL);
//#endif 


//#if 1557368423 
JToolBar toolBar = factory.createToolBar();
//#endif 


//#if 1295483096 
toolBar.setName(getTitle());
//#endif 


//#if -135195092 
add(toolBar, BorderLayout.WEST);
//#endif 


//#if -1464678636 
splitPane = new BorderSplitPane();
//#endif 


//#if -2123659623 
add(splitPane, BorderLayout.CENTER);
//#endif 


//#if -39694845 
setTarget(null);
//#endif 


//#if 355854419 
addComponentListener(this);
//#endif 

} 

//#endif 


//#if -162922543 
public static void incrementNumHushes()
    { 

//#if 133076995 
numHushes++;
//#endif 

} 

//#endif 


//#if -1384337926 
public void componentShown(ComponentEvent e)
    { 

//#if -545653436 
setTargetInternal(target);
//#endif 

} 

//#endif 


//#if 2066499425 
public void refresh()
    { 

//#if 177604083 
setTarget(TargetManager.getInstance().getTarget());
//#endif 

} 

//#endif 


//#if -1555573798 
public void setTree(ToDoPane tdp)
    { 

//#if 1218653489 
if(getOrientation().equals(Horizontal.getInstance()))//1
{ 

//#if -1677050139 
splitPane.add(tdp, BorderSplitPane.WEST);
//#endif 

} 
else
{ 

//#if 1058384972 
splitPane.add(tdp, BorderSplitPane.NORTH);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1694812347 
public void showDescription()
    { 

//#if 867386727 
if(lastPanel != null)//1
{ 

//#if 1461187426 
splitPane.remove(lastPanel);
//#endif 

} 

//#endif 


//#if -209105349 
splitPane.add(description, BorderSplitPane.CENTER);
//#endif 


//#if -1891427129 
lastPanel = description;
//#endif 


//#if -273324661 
validate();
//#endif 


//#if 501090696 
repaint();
//#endif 

} 

//#endif 


//#if -1099609541 
public void componentResized(ComponentEvent e)
    { 
} 

//#endif 


//#if 1118794722 
public Object getTarget()
    { 

//#if -1484237666 
return target;
//#endif 

} 

//#endif 


//#if -1422303473 
public void showStep(JPanel ws)
    { 

//#if -1614276790 
if(lastPanel != null)//1
{ 

//#if 1395037069 
splitPane.remove(lastPanel);
//#endif 

} 

//#endif 


//#if -1088879402 
if(ws != null)//1
{ 

//#if 969614482 
splitPane.add(ws, BorderSplitPane.CENTER);
//#endif 


//#if -538192346 
lastPanel = ws;
//#endif 

} 
else
{ 

//#if -1954921677 
splitPane.add(description, BorderSplitPane.CENTER);
//#endif 


//#if 1721939391 
lastPanel = description;
//#endif 

} 

//#endif 


//#if -2062490744 
validate();
//#endif 


//#if -1773381653 
repaint();
//#endif 

} 

//#endif 


//#if 273165464 
public void componentMoved(ComponentEvent e)
    { 
} 

//#endif 


//#if -1842335449 
public void setTarget(Object item)
    { 

//#if -980925504 
target = item;
//#endif 


//#if -384579478 
if(isVisible())//1
{ 

//#if -1690296713 
setTargetInternal(item);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -136881991 
public void targetRemoved(TargetEvent e)
    { 

//#if -1034268928 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 1340554406 
private void setTargetInternal(Object item)
    { 

//#if 1933910324 
description.setTarget(item);
//#endif 


//#if 463308283 
Wizard w = null;
//#endif 


//#if 243183587 
if(item instanceof ToDoItem)//1
{ 

//#if 1083921685 
w = ((ToDoItem) item).getWizard();
//#endif 

} 

//#endif 


//#if -928807489 
if(w != null)//1
{ 

//#if -1811659925 
showStep(w.getCurrentPanel());
//#endif 

} 
else
{ 

//#if 771662462 
showDescription();
//#endif 

} 

//#endif 


//#if -1190569064 
updateActionsEnabled(item);
//#endif 

} 

//#endif 


//#if 432368381 
public void componentHidden(ComponentEvent e)
    { 

//#if -2032529022 
setTargetInternal(null);
//#endif 

} 

//#endif 


//#if 551450201 
public void targetAdded(TargetEvent e)
    { 

//#if -1860909179 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -1073734706 
protected static void updateActionsEnabled(Object item)
    { 

//#if -956184207 
actionResolve.setEnabled(actionResolve.isEnabled());
//#endif 


//#if 1720986877 
actionResolve.updateEnabled(item);
//#endif 


//#if 2117178495 
actionSnooze.setEnabled(actionSnooze.isEnabled());
//#endif 


//#if 89820407 
actionSnooze.updateEnabled(item);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

