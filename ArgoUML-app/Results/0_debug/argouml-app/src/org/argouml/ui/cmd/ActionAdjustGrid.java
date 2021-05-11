
//#if -1788260172 
// Compilation Unit of /ActionAdjustGrid.java 
 

//#if 1095551211 
package org.argouml.ui.cmd;
//#endif 


//#if -1354834751 
import java.awt.Toolkit;
//#endif 


//#if -1587088497 
import java.awt.event.ActionEvent;
//#endif 


//#if -1114395064 
import java.awt.event.KeyEvent;
//#endif 


//#if -1234384996 
import java.util.ArrayList;
//#endif 


//#if 412553196 
import java.util.Enumeration;
//#endif 


//#if -647552603 
import java.util.HashMap;
//#endif 


//#if 988880197 
import java.util.List;
//#endif 


//#if -1353552009 
import java.util.Map;
//#endif 


//#if 463297923 
import javax.swing.AbstractAction;
//#endif 


//#if 1866454023 
import javax.swing.AbstractButton;
//#endif 


//#if 1616904197 
import javax.swing.Action;
//#endif 


//#if -573304786 
import javax.swing.ButtonGroup;
//#endif 


//#if 2071999076 
import javax.swing.KeyStroke;
//#endif 


//#if 2140997179 
import org.argouml.application.api.Argo;
//#endif 


//#if -1567901710 
import org.argouml.configuration.Configuration;
//#endif 


//#if 1238853318 
import org.argouml.i18n.Translator;
//#endif 


//#if 1910617049 
import org.tigris.gef.base.Editor;
//#endif 


//#if 1250032384 
import org.tigris.gef.base.Globals;
//#endif 


//#if 121181247 
import org.tigris.gef.base.Layer;
//#endif 


//#if -521838695 
import org.tigris.gef.base.LayerGrid;
//#endif 


//#if -1016163001 
public class ActionAdjustGrid extends 
//#if 1822779468 
AbstractAction
//#endif 

  { 

//#if 1624369403 
private final Map<String, Comparable> myMap;
//#endif 


//#if 1867410660 
private static final String DEFAULT_ID = "03";
//#endif 


//#if 2068548760 
private static ButtonGroup myGroup;
//#endif 


//#if 1311149251 
private static final int DEFAULT_MASK =
        Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
//#endif 


//#if 2021785355 
public static Action buildGridAction(final String property,
                                         final int spacing, final boolean paintLines,
                                         final boolean paintDots, final String id, final int key)
    { 

//#if 1588306913 
String name = Translator.localize(property);
//#endif 


//#if 646428854 
HashMap<String, Comparable> map1 = new HashMap<String, Comparable>(4);
//#endif 


//#if -2045143181 
map1.put("spacing", Integer.valueOf(spacing));
//#endif 


//#if -499924985 
map1.put("paintLines", Boolean.valueOf(paintLines));
//#endif 


//#if 227360681 
map1.put("paintDots", Boolean.valueOf(paintDots));
//#endif 


//#if -750431624 
Action action = new ActionAdjustGrid(map1, name);
//#endif 


//#if -328319980 
action.putValue("ID", id);
//#endif 


//#if 1237765254 
action.putValue("shortcut", KeyStroke.getKeyStroke(
                            key, DEFAULT_MASK));
//#endif 


//#if -343534557 
return action;
//#endif 

} 

//#endif 


//#if 1645939736 
private ActionAdjustGrid(final Map<String, Comparable> map,
                             final String name)
    { 

//#if 2134668033 
super();
//#endif 


//#if 801144462 
myMap = map;
//#endif 


//#if 408556202 
putValue(Action.NAME, name);
//#endif 

} 

//#endif 


//#if 1246837697 
public void actionPerformed(final ActionEvent e)
    { 

//#if -1281957407 
final Editor editor = Globals.curEditor();
//#endif 


//#if -907426054 
if(editor != null)//1
{ 

//#if 962144590 
final Layer grid = editor.getLayerManager().findLayerNamed("Grid");
//#endif 


//#if -939065145 
if(grid instanceof LayerGrid)//1
{ 

//#if 620943325 
if(myMap != null)//1
{ 

//#if 63588019 
if(myMap instanceof HashMap)//1
{ 

//#if -57387955 
grid.adjust((HashMap<String, Comparable>) myMap);
//#endif 

} 
else
{ 

//#if 380216441 
grid.adjust(new HashMap<String, Comparable>(myMap));
//#endif 

} 

//#endif 


//#if 673951049 
Configuration.setString(Argo.KEY_GRID,
                                            (String) getValue("ID"));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 21893437 
static List<Action> createAdjustGridActions(final boolean longStrings)
    { 

//#if 2127890535 
List<Action> result = new ArrayList<Action>();
//#endif 


//#if 778480254 
result.add(buildGridAction(longStrings ? "action.adjust-grid.lines-16"
                                   : "menu.item.lines-16", 16, true, true, "01", KeyEvent.VK_1));
//#endif 


//#if -256128741 
result.add(buildGridAction(longStrings ? "action.adjust-grid.lines-8"
                                   : "menu.item.lines-8", 8, true, true, "02", KeyEvent.VK_2));
//#endif 


//#if 821131173 
result.add(buildGridAction(longStrings ? "action.adjust-grid.dots-16"
                                   : "menu.item.dots-16", 16, false, true, "03", KeyEvent.VK_3));
//#endif 


//#if -767724073 
result.add(buildGridAction(longStrings ? "action.adjust-grid.dots-32"
                                   : "menu.item.dots-32", 32, false, true, "04", KeyEvent.VK_4));
//#endif 


//#if 490819596 
result.add(buildGridAction(
                       longStrings ? "action.adjust-grid.none"
                       : "menu.item.none", 16, false, false, "05",
                       KeyEvent.VK_5));
//#endif 


//#if 1301840520 
return result;
//#endif 

} 

//#endif 


//#if -713376825 
static void init()
    { 

//#if 1870086188 
String id = Configuration.getString(Argo.KEY_GRID, DEFAULT_ID);
//#endif 


//#if 1281216853 
List<Action> actions = createAdjustGridActions(false);
//#endif 


//#if -1308979587 
for (Action a : actions) //1
{ 

//#if 1639787237 
if(a.getValue("ID").equals(id))//1
{ 

//#if 1639242481 
a.actionPerformed(null);
//#endif 


//#if -64636800 
if(myGroup != null)//1
{ 

//#if -1143048439 
for (Enumeration e = myGroup.getElements();
                            e.hasMoreElements();) //1
{ 

//#if -1839986540 
AbstractButton ab = (AbstractButton) e.nextElement();
//#endif 


//#if -864825915 
Action action = ab.getAction();
//#endif 


//#if 1698320229 
if(action instanceof ActionAdjustGrid)//1
{ 

//#if 193352885 
String currentID = (String) action.getValue("ID");
//#endif 


//#if -1520700737 
if(id.equals(currentID))//1
{ 

//#if 234561135 
myGroup.setSelected(ab.getModel(), true);
//#endif 


//#if -208972275 
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


//#if 715255902 
return;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1352678218 
static void setGroup(final ButtonGroup group)
    { 

//#if 60272016 
myGroup = group;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

