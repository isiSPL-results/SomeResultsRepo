
//#if -1267196187 
// Compilation Unit of /UMLStateExitList.java 
 

//#if 378525491 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 1488773436 
import javax.swing.JPopupMenu;
//#endif 


//#if 1139212826 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -381223131 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if 1110099698 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewAction;
//#endif 


//#if -1184560871 
import org.argouml.uml.ui.behavior.common_behavior.PopupMenuNewAction;
//#endif 


//#if 1701715479 
public class UMLStateExitList extends 
//#if -1598242869 
UMLMutableLinkedList
//#endif 

  { 

//#if 1347180052 
public UMLStateExitList(
        UMLModelElementListModel2 dataModel)
    { 

//#if -1676805585 
super(dataModel);
//#endif 

} 

//#endif 


//#if -1409435806 
public JPopupMenu getPopupMenu()
    { 

//#if 1576495182 
return new PopupMenuNewAction(ActionNewAction.Roles.EXIT, this);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

