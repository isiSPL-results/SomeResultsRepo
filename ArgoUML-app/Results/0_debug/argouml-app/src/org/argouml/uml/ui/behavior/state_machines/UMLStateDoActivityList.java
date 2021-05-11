
//#if 1470720493 
// Compilation Unit of /UMLStateDoActivityList.java 
 

//#if 131985079 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 637181752 
import javax.swing.JPopupMenu;
//#endif 


//#if 2086394646 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -785024855 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if -1308535178 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewAction;
//#endif 


//#if 1930173205 
import org.argouml.uml.ui.behavior.common_behavior.PopupMenuNewAction;
//#endif 


//#if -1055742097 
public class UMLStateDoActivityList extends 
//#if 695302958 
UMLMutableLinkedList
//#endif 

  { 

//#if -150251885 
public UMLStateDoActivityList(
        UMLModelElementListModel2 dataModel)
    { 

//#if -302684387 
super(dataModel);
//#endif 

} 

//#endif 


//#if -2034904315 
public JPopupMenu getPopupMenu()
    { 

//#if -1488608474 
return new PopupMenuNewAction(ActionNewAction.Roles.DO, this);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

