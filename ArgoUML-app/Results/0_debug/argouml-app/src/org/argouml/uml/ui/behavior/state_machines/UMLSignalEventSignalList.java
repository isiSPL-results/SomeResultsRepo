
//#if 1603852357 
// Compilation Unit of /UMLSignalEventSignalList.java 
 

//#if 981708106 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -57832763 
import javax.swing.JPopupMenu;
//#endif 


//#if 753555599 
import org.argouml.uml.ui.AbstractActionAddModelElement2;
//#endif 


//#if -1636962589 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -540051268 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if 548252887 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewSignal;
//#endif 


//#if 219876852 
class UMLSignalEventSignalList extends 
//#if 1191372417 
UMLMutableLinkedList
//#endif 

  { 

//#if -1827081963 
public UMLSignalEventSignalList(UMLModelElementListModel2 dataModel)
    { 

//#if 433477764 
super(dataModel, (AbstractActionAddModelElement2) null, null, null,
              true);
//#endif 


//#if -1112501122 
setDelete(false);
//#endif 


//#if -1761647974 
setDeleteAction(null);
//#endif 

} 

//#endif 


//#if 2145612440 
public JPopupMenu getPopupMenu()
    { 

//#if -2063433228 
JPopupMenu menu = new JPopupMenu();
//#endif 


//#if 1093675977 
ActionAddSignalsToSignalEvent.SINGLETON.setTarget(getTarget());
//#endif 


//#if -192022286 
menu.add(ActionAddSignalsToSignalEvent.SINGLETON);
//#endif 


//#if -697792295 
menu.add(new ActionNewSignal());
//#endif 


//#if -1329638646 
return menu;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

