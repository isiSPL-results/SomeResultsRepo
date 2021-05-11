
//#if -353721754 
// Compilation Unit of /PopupMenuNewEvent.java 
 

//#if -2081478490 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 67658932 
import javax.swing.Action;
//#endif 


//#if -1146387805 
import javax.swing.JMenu;
//#endif 


//#if 537855440 
import javax.swing.JMenuItem;
//#endif 


//#if -1719390743 
import javax.swing.JPopupMenu;
//#endif 


//#if -241969417 
import org.argouml.i18n.Translator;
//#endif 


//#if -213273548 
import org.argouml.uml.ui.ActionRemoveModelElement;
//#endif 


//#if 1895147391 
import org.argouml.uml.ui.behavior.activity_graphs.ActionAddEventAsTrigger;
//#endif 


//#if 1190593434 
public class PopupMenuNewEvent extends 
//#if 1972216798 
JPopupMenu
//#endif 

  { 

//#if -1550451084 
private static final long serialVersionUID = -7624618103144695448L;
//#endif 


//#if -461555779 
public PopupMenuNewEvent(String role, Object target)
    { 

//#if -78511508 
super();
//#endif 


//#if -660586381 
buildMenu(this, role, target);
//#endif 

} 

//#endif 


//#if -1085186516 
static void buildMenu(JPopupMenu pmenu, String role, Object target)
    { 

//#if -1045987411 
assert role != null;
//#endif 


//#if 937710450 
assert target != null;
//#endif 


//#if 643391013 
if(role.equals(ActionNewEvent.Roles.DEFERRABLE_EVENT)
                || role.equals(ActionNewEvent.Roles.TRIGGER))//1
{ 

//#if 173368304 
JMenu select = new JMenu(Translator.localize("action.select"));
//#endif 


//#if 2018405084 
if(role.equals(ActionNewEvent.Roles.DEFERRABLE_EVENT))//1
{ 

//#if 599178381 
ActionAddEventAsDeferrableEvent.SINGLETON.setTarget(target);
//#endif 


//#if 700640308 
JMenuItem menuItem = new JMenuItem(
                    ActionAddEventAsDeferrableEvent.SINGLETON);
//#endif 


//#if -289224134 
select.add(menuItem);
//#endif 

} 
else

//#if -1918650716 
if(role.equals(ActionNewEvent.Roles.TRIGGER))//1
{ 

//#if -196135012 
ActionAddEventAsTrigger.SINGLETON.setTarget(target);
//#endif 


//#if 376694551 
select.add(ActionAddEventAsTrigger.SINGLETON);
//#endif 

} 

//#endif 


//#endif 


//#if -458050655 
pmenu.add(select);
//#endif 

} 

//#endif 


//#if 340423729 
JMenu newMenu = new JMenu(Translator.localize("action.new"));
//#endif 


//#if 1733462815 
newMenu.add(ActionNewCallEvent.getSingleton());
//#endif 


//#if -654373309 
ActionNewCallEvent.getSingleton().setTarget(target);
//#endif 


//#if 1745920091 
ActionNewCallEvent.getSingleton().putValue(ActionNewEvent.ROLE, role);
//#endif 


//#if -1794953807 
newMenu.add(ActionNewChangeEvent.getSingleton());
//#endif 


//#if 110047089 
ActionNewChangeEvent.getSingleton().setTarget(target);
//#endif 


//#if 752697581 
ActionNewChangeEvent.getSingleton().putValue(ActionNewEvent.ROLE, role);
//#endif 


//#if 97418921 
newMenu.add(ActionNewSignalEvent.getSingleton());
//#endif 


//#if -383718023 
ActionNewSignalEvent.getSingleton().setTarget(target);
//#endif 


//#if 147739621 
ActionNewSignalEvent.getSingleton().putValue(ActionNewEvent.ROLE, role);
//#endif 


//#if -1662396850 
newMenu.add(ActionNewTimeEvent.getSingleton());
//#endif 


//#if 2018486004 
ActionNewTimeEvent.getSingleton().setTarget(target);
//#endif 


//#if -639606838 
ActionNewTimeEvent.getSingleton().putValue(ActionNewEvent.ROLE, role);
//#endif 


//#if -1705431620 
pmenu.add(newMenu);
//#endif 


//#if 1926464008 
pmenu.addSeparator();
//#endif 


//#if -50386575 
ActionRemoveModelElement.SINGLETON.setObjectToRemove(
            ActionNewEvent.getAction(role, target));
//#endif 


//#if -782913050 
ActionRemoveModelElement.SINGLETON.putValue(Action.NAME,
                Translator.localize("action.delete-from-model"));
//#endif 


//#if 1783289105 
pmenu.add(ActionRemoveModelElement.SINGLETON);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

