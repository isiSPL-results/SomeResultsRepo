
//#if -408870061 
// Compilation Unit of /UMLStateEntryList.java 
 

//#if -867920917 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 1375510916 
import javax.swing.JPopupMenu;
//#endif 


//#if 1154079842 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 1753667549 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if -922807382 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewAction;
//#endif 


//#if -185540255 
import org.argouml.uml.ui.behavior.common_behavior.PopupMenuNewAction;
//#endif 


//#if -376134899 
public class UMLStateEntryList extends 
//#if -466618028 
UMLMutableLinkedList
//#endif 

  { 

//#if 367090091 
public JPopupMenu getPopupMenu()
    { 

//#if -1372481692 
return new PopupMenuNewAction(ActionNewAction.Roles.ENTRY, this);
//#endif 

} 

//#endif 


//#if 1112873519 
public UMLStateEntryList(
        UMLModelElementListModel2 dataModel)
    { 

//#if 1945974928 
super(dataModel);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

