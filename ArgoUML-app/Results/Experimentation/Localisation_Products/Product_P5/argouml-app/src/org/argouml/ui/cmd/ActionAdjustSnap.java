package org.argouml.ui.cmd;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.KeyStroke;
import org.argouml.application.api.Argo;
import org.argouml.configuration.Configuration;
import org.argouml.i18n.Translator;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.Guide;
import org.tigris.gef.base.GuideGrid;
public class ActionAdjustSnap extends AbstractAction
  { 
private int guideSize;
private static final String DEFAULT_ID = "8";
private static ButtonGroup myGroup;
static void init()
    { 
String id = Configuration.getString(Argo.KEY_SNAP, DEFAULT_ID);
List<Action> actions = createAdjustSnapActions();
for (Action a : actions) //1
{ 
if(a.getValue("ID").equals(id))//1
{ 
a.actionPerformed(null);
if(myGroup != null)//1
{ 
for (Enumeration e = myGroup.getElements();
                            e.hasMoreElements();) //1
{ 
AbstractButton ab = (AbstractButton) e.nextElement();
Action action = ab.getAction();
if(action instanceof ActionAdjustSnap)//1
{ 
String currentID = (String) action.getValue("ID");
if(id.equals(currentID))//1
{ 
myGroup.setSelected(ab.getModel(), true);
return;
} 
} 
} 
} 
return;
} 
} 
} 
public ActionAdjustSnap(int size, String name)
    { 
super();
guideSize = size;
putValue(Action.NAME, name);
} 
static List<Action> createAdjustSnapActions()
    { 
List<Action> result = new ArrayList<Action>();
Action a;
String name;
name = Translator.localize("menu.item.snap-4");
a = new ActionAdjustSnap(4, name);
a.putValue("ID", "4");
a.putValue("shortcut", KeyStroke.getKeyStroke(
                       KeyEvent.VK_1, Event.ALT_MASK + Event.CTRL_MASK));
result.add(a);
name = Translator.localize("menu.item.snap-8");
a = new ActionAdjustSnap(8, name);
a.putValue("ID", "8");
a.putValue("shortcut", KeyStroke.getKeyStroke(
                       KeyEvent.VK_2, Event.ALT_MASK + Event.CTRL_MASK));
result.add(a);
name = Translator.localize("menu.item.snap-16");
a = new ActionAdjustSnap(16, name);
a.putValue("ID", "16");
a.putValue("shortcut", KeyStroke.getKeyStroke(
                       KeyEvent.VK_3, Event.ALT_MASK + Event.CTRL_MASK));
result.add(a);
name = Translator.localize("menu.item.snap-32");
a = new ActionAdjustSnap(32, name);
a.putValue("ID", "32");
a.putValue("shortcut", KeyStroke.getKeyStroke(
                       KeyEvent.VK_4, Event.ALT_MASK + Event.CTRL_MASK));
result.add(a);
return result;
} 
public void actionPerformed(ActionEvent e)
    { 
Editor ce = Globals.curEditor();
Guide guide = ce.getGuide();
if(guide instanceof GuideGrid)//1
{ 
((GuideGrid) guide).gridSize(guideSize);
Configuration.setString(Argo.KEY_SNAP, (String) getValue("ID"));
} 
} 
static void setGroup(ButtonGroup group)
    { 
myGroup = group;
} 

 } 
