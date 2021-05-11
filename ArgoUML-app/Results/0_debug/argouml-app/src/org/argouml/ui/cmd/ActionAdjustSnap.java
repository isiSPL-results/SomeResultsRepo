
//#if 1204557423 
// Compilation Unit of /ActionAdjustSnap.java 
 

//#if 1941966235 
package org.argouml.ui.cmd;
//#endif 


//#if -2481611 
import java.awt.Event;
//#endif 


//#if -1840379681 
import java.awt.event.ActionEvent;
//#endif 


//#if 1182079736 
import java.awt.event.KeyEvent;
//#endif 


//#if -387969972 
import java.util.ArrayList;
//#endif 


//#if 2068572316 
import java.util.Enumeration;
//#endif 


//#if -2007913835 
import java.util.List;
//#endif 


//#if 210006739 
import javax.swing.AbstractAction;
//#endif 


//#if 1613162839 
import javax.swing.AbstractButton;
//#endif 


//#if -988191403 
import javax.swing.Action;
//#endif 


//#if 1723170014 
import javax.swing.ButtonGroup;
//#endif 


//#if -566949100 
import javax.swing.KeyStroke;
//#endif 


//#if 1376968587 
import org.argouml.application.api.Argo;
//#endif 


//#if 1742587042 
import org.argouml.configuration.Configuration;
//#endif 


//#if 1976761206 
import org.argouml.i18n.Translator;
//#endif 


//#if 1657325865 
import org.tigris.gef.base.Editor;
//#endif 


//#if 1987940272 
import org.tigris.gef.base.Globals;
//#endif 


//#if -704879452 
import org.tigris.gef.base.Guide;
//#endif 


//#if 51377534 
import org.tigris.gef.base.GuideGrid;
//#endif 


//#if -546747621 
public class ActionAdjustSnap extends 
//#if -762868547 
AbstractAction
//#endif 

  { 

//#if 185912111 
private int guideSize;
//#endif 


//#if -683080968 
private static final String DEFAULT_ID = "8";
//#endif 


//#if -1432234295 
private static ButtonGroup myGroup;
//#endif 


//#if 1264945144 
static void init()
    { 

//#if -1473308339 
String id = Configuration.getString(Argo.KEY_SNAP, DEFAULT_ID);
//#endif 


//#if 455921073 
List<Action> actions = createAdjustSnapActions();
//#endif 


//#if 1499759650 
for (Action a : actions) //1
{ 

//#if -173851894 
if(a.getValue("ID").equals(id))//1
{ 

//#if 1527837853 
a.actionPerformed(null);
//#endif 


//#if 1888061484 
if(myGroup != null)//1
{ 

//#if -1413741566 
for (Enumeration e = myGroup.getElements();
                            e.hasMoreElements();) //1
{ 

//#if 1339907934 
AbstractButton ab = (AbstractButton) e.nextElement();
//#endif 


//#if -1943106373 
Action action = ab.getAction();
//#endif 


//#if -1465303757 
if(action instanceof ActionAdjustSnap)//1
{ 

//#if -880880283 
String currentID = (String) action.getValue("ID");
//#endif 


//#if 1056395279 
if(id.equals(currentID))//1
{ 

//#if 600094491 
myGroup.setSelected(ab.getModel(), true);
//#endif 


//#if 410142689 
return;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -831907534 
return;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1708797574 
public ActionAdjustSnap(int size, String name)
    { 

//#if 1285459008 
super();
//#endif 


//#if -1499909063 
guideSize = size;
//#endif 


//#if 175840011 
putValue(Action.NAME, name);
//#endif 

} 

//#endif 


//#if 1464588428 
static List<Action> createAdjustSnapActions()
    { 

//#if -1442517270 
List<Action> result = new ArrayList<Action>();
//#endif 


//#if -807198247 
Action a;
//#endif 


//#if 1493045206 
String name;
//#endif 


//#if 738966249 
name = Translator.localize("menu.item.snap-4");
//#endif 


//#if -533173197 
a = new ActionAdjustSnap(4, name);
//#endif 


//#if -1606023253 
a.putValue("ID", "4");
//#endif 


//#if 117095236 
a.putValue("shortcut", KeyStroke.getKeyStroke(
                       KeyEvent.VK_1, Event.ALT_MASK + Event.CTRL_MASK));
//#endif 


//#if 523733444 
result.add(a);
//#endif 


//#if 739085413 
name = Translator.localize("menu.item.snap-8");
//#endif 


//#if 2143100847 
a = new ActionAdjustSnap(8, name);
//#endif 


//#if -1605904089 
a.putValue("ID", "8");
//#endif 


//#if 1842576133 
a.putValue("shortcut", KeyStroke.getKeyStroke(
                       KeyEvent.VK_2, Event.ALT_MASK + Event.CTRL_MASK));
//#endif 


//#if -1073109490 
result.add(a);
//#endif 


//#if 1430935270 
name = Translator.localize("menu.item.snap-16");
//#endif 


//#if -352145562 
a = new ActionAdjustSnap(16, name);
//#endif 


//#if 1750704740 
a.putValue("ID", "16");
//#endif 


//#if -726910266 
a.putValue("shortcut", KeyStroke.getKeyStroke(
                       KeyEvent.VK_3, Event.ALT_MASK + Event.CTRL_MASK));
//#endif 


//#if -1073109489 
result.add(a);
//#endif 


//#if 1432663148 
name = Translator.localize("menu.item.snap-32");
//#endif 


//#if 1946606060 
a = new ActionAdjustSnap(32, name);
//#endif 


//#if 1752432618 
a.putValue("ID", "32");
//#endif 


//#if 998570631 
a.putValue("shortcut", KeyStroke.getKeyStroke(
                       KeyEvent.VK_4, Event.ALT_MASK + Event.CTRL_MASK));
//#endif 


//#if -1073109488 
result.add(a);
//#endif 


//#if 543956261 
return result;
//#endif 

} 

//#endif 


//#if 1032847464 
public void actionPerformed(ActionEvent e)
    { 

//#if -965437245 
Editor ce = Globals.curEditor();
//#endif 


//#if -335123089 
Guide guide = ce.getGuide();
//#endif 


//#if -1050920425 
if(guide instanceof GuideGrid)//1
{ 

//#if -755829645 
((GuideGrid) guide).gridSize(guideSize);
//#endif 


//#if -675084728 
Configuration.setString(Argo.KEY_SNAP, (String) getValue("ID"));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -55893677 
static void setGroup(ButtonGroup group)
    { 

//#if 776876040 
myGroup = group;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

