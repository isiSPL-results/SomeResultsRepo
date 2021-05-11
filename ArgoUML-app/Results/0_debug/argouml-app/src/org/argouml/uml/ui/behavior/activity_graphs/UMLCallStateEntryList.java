
//#if 1623174395 
// Compilation Unit of /UMLCallStateEntryList.java 
 

//#if 822546718 
package org.argouml.uml.ui.behavior.activity_graphs;
//#endif 


//#if -731323162 
import javax.swing.JMenu;
//#endif 


//#if 472432006 
import javax.swing.JPopupMenu;
//#endif 


//#if -2040954502 
import org.argouml.i18n.Translator;
//#endif 


//#if 1919416503 
import org.argouml.uml.ui.ActionRemoveModelElement;
//#endif 


//#if -417584412 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 968491035 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if -166088472 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewAction;
//#endif 


//#if 1148075818 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewCallAction;
//#endif 


//#if -2119349536 
class UMLCallStateEntryList extends 
//#if -1856998019 
UMLMutableLinkedList
//#endif 

  { 

//#if 1043370340 
public UMLCallStateEntryList(
        UMLModelElementListModel2 dataModel)
    { 

//#if -1448472835 
super(dataModel);
//#endif 

} 

//#endif 


//#if 2050455188 
public JPopupMenu getPopupMenu()
    { 

//#if 718620977 
return new PopupMenuNewCallAction(ActionNewAction.Roles.ENTRY, this);
//#endif 

} 

//#endif 


//#if 327978175 
static class PopupMenuNewCallAction extends 
//#if -1281881554 
JPopupMenu
//#endif 

  { 

//#if 1677623846 
public PopupMenuNewCallAction(String role, UMLMutableLinkedList list)
        { 

//#if 253522506 
super();
//#endif 


//#if 187139765 
JMenu newMenu = new JMenu();
//#endif 


//#if -1988379 
newMenu.setText(Translator.localize("action.new"));
//#endif 


//#if 453880397 
newMenu.add(ActionNewCallAction.getInstance());
//#endif 


//#if 1536326524 
ActionNewCallAction.getInstance().setTarget(list.getTarget());
//#endif 


//#if -258785017 
ActionNewCallAction.getInstance().putValue(
                ActionNewAction.ROLE, role);
//#endif 


//#if 1125967711 
add(newMenu);
//#endif 


//#if -108044565 
addSeparator();
//#endif 


//#if -191486056 
ActionRemoveModelElement.SINGLETON.setObjectToRemove(ActionNewAction
                    .getAction(role, list.getTarget()));
//#endif 


//#if -1022153330 
add(ActionRemoveModelElement.SINGLETON);
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

