
//#if 1374145574 
// Compilation Unit of /ToolBarUtility.java 
 

//#if -337496203 
package org.argouml.util;
//#endif 


//#if 705952502 
import java.awt.Component;
//#endif 


//#if 2009638041 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 328454991 
import java.beans.PropertyChangeListener;
//#endif 


//#if -573373863 
import java.util.Collection;
//#endif 


//#if -579901927 
import javax.swing.Action;
//#endif 


//#if -1475577685 
import javax.swing.JButton;
//#endif 


//#if 1625606942 
import javax.swing.JToolBar;
//#endif 


//#if -1827102843 
import org.apache.log4j.Logger;
//#endif 


//#if -5593506 
import org.argouml.configuration.Configuration;
//#endif 


//#if 868164825 
import org.argouml.configuration.ConfigurationKey;
//#endif 


//#if 783623808 
import org.tigris.toolbar.ToolBarManager;
//#endif 


//#if -1817595801 
import org.tigris.toolbar.toolbutton.PopupToolBoxButton;
//#endif 


//#if -486027871 
public class ToolBarUtility  { 

//#if -2013729603 
private static final Logger LOG = Logger.getLogger(ToolBarUtility.class);
//#endif 


//#if -1506068535 
public static void addItemsToToolBar(JToolBar buttonPanel,
                                         Collection actions)
    { 

//#if 917588027 
addItemsToToolBar(buttonPanel, actions.toArray());
//#endif 

} 

//#endif 


//#if 92003529 
private static PopupToolBoxButton buildPopupToolBoxButton(Object[] actions,
            boolean rollover)
    { 

//#if -1247306731 
PopupToolBoxButton toolBox = null;
//#endif 


//#if 1594125395 
for (int i = 0; i < actions.length; ++i) //1
{ 

//#if -829578984 
if(actions[i] instanceof Action)//1
{ 

//#if -1207946659 
LOG.info("Adding a " + actions[i] + " to the toolbar");
//#endif 


//#if 1037947902 
Action a = (Action) actions[i];
//#endif 


//#if 290657541 
if(toolBox == null)//1
{ 

//#if 829080474 
toolBox = new PopupToolBoxButton(a, 0, 1, rollover);
//#endif 

} 

//#endif 


//#if 1356283363 
toolBox.add(a);
//#endif 

} 
else

//#if 935609005 
if(actions[i] instanceof Component)//1
{ 

//#if 580583924 
toolBox.add((Component) actions[i]);
//#endif 

} 
else

//#if 378129953 
if(actions[i] instanceof Object[])//1
{ 

//#if -748702219 
Object[] actionRow = (Object[]) actions[i];
//#endif 


//#if 863492205 
for (int j = 0; j < actionRow.length; ++j) //1
{ 

//#if 498008814 
Action a = (Action) actionRow[j];
//#endif 


//#if -1726621987 
if(toolBox == null)//1
{ 

//#if -1202142720 
int cols = actionRow.length;
//#endif 


//#if 4340364 
toolBox = new PopupToolBoxButton(a, 0, cols, rollover);
//#endif 

} 

//#endif 


//#if 1487451403 
toolBox.add(a);
//#endif 

} 

//#endif 

} 
else
{ 

//#if 653969785 
LOG.error("Can't add a " + actions[i] + " to the toolbar");
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if 579781140 
return toolBox;
//#endif 

} 

//#endif 


//#if 971544196 
public static void manageDefault(Object[] actions, String key)
    { 

//#if -1793716361 
Action defaultAction = null;
//#endif 


//#if -633381656 
ConfigurationKey k =
            Configuration.makeKey("default", "popupactions", key);
//#endif 


//#if 1155102945 
String defaultName = Configuration.getString(k);
//#endif 


//#if -1574252905 
PopupActionsListener listener = new PopupActionsListener(k);
//#endif 


//#if -662934290 
for (int i = 0; i < actions.length; ++i) //1
{ 

//#if -1206413528 
if(actions[i] instanceof Action)//1
{ 

//#if -1767340117 
Action a = (Action) actions[i];
//#endif 


//#if 2146571132 
if(a.getValue(Action.NAME).equals(defaultName))//1
{ 

//#if 1345334306 
defaultAction = a;
//#endif 

} 

//#endif 


//#if -1914041598 
a.addPropertyChangeListener(listener);
//#endif 

} 
else

//#if 1056908185 
if(actions[i] instanceof Object[])//1
{ 

//#if -85829793 
Object[] actionRow = (Object[]) actions[i];
//#endif 


//#if -2027434921 
for (int j = 0; j < actionRow.length; ++j) //1
{ 

//#if -1659676290 
Action a = (Action) actionRow[j];
//#endif 


//#if 1119024401 
if(a.getValue(Action.NAME).equals(defaultName))//1
{ 

//#if -1019155234 
defaultAction = a;
//#endif 

} 

//#endif 


//#if 2087248919 
a.addPropertyChangeListener(listener);
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1007541704 
if(defaultAction != null)//1
{ 

//#if -2047328389 
defaultAction.putValue("isDefault", Boolean.valueOf(true));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -442106676 
public static void addItemsToToolBar(JToolBar buttonPanel,
                                         Object[] actions)
    { 

//#if 1343320310 
JButton button = buildPopupToolBoxButton(actions, false);
//#endif 


//#if 1261903561 
if(!ToolBarManager.alwaysUseStandardRollover())//1
{ 

//#if -205868633 
button.setBorderPainted(false);
//#endif 

} 

//#endif 


//#if 1945829415 
buttonPanel.add(button);
//#endif 

} 

//#endif 


//#if 734631821 
static class PopupActionsListener implements 
//#if 670371156 
PropertyChangeListener
//#endif 

  { 

//#if 1387755701 
private boolean blockEvents;
//#endif 


//#if 1700344397 
private ConfigurationKey key;
//#endif 


//#if 2128262896 
public void propertyChange(PropertyChangeEvent evt)
        { 

//#if 824075522 
if(evt.getSource() instanceof Action)//1
{ 

//#if 1011880733 
Action a = (Action) evt.getSource();
//#endif 


//#if -1408602356 
if(!blockEvents && evt.getPropertyName().equals("popped"))//1
{ 

//#if 3681861 
blockEvents = true;
//#endif 


//#if -282350048 
a.putValue("popped", Boolean.valueOf(false));
//#endif 


//#if -302623584 
blockEvents = false;
//#endif 


//#if 2095795997 
Configuration.setString(key,
                                            (String) a.getValue(Action.NAME));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 639347590 
public PopupActionsListener(ConfigurationKey k)
        { 

//#if 1445812980 
key = k;
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

