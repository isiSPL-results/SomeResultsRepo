
//#if -1098447484 
// Compilation Unit of /UMLTransitionEffectList.java 
 

//#if -307817402 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 1553743433 
import javax.swing.JPopupMenu;
//#endif 


//#if 1337419623 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 970309048 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if -2117894651 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewAction;
//#endif 


//#if -2046454490 
import org.argouml.uml.ui.behavior.common_behavior.PopupMenuNewAction;
//#endif 


//#if -881447603 
public class UMLTransitionEffectList extends 
//#if 1745851215 
UMLMutableLinkedList
//#endif 

  { 

//#if -655059975 
public UMLTransitionEffectList(
        UMLModelElementListModel2 dataModel)
    { 

//#if 762259347 
super(dataModel);
//#endif 

} 

//#endif 


//#if 974190054 
public JPopupMenu getPopupMenu()
    { 

//#if -426871065 
return new PopupMenuNewAction(ActionNewAction.Roles.EFFECT, this);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

