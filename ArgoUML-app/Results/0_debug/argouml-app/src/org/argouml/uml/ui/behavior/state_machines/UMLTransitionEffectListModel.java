
//#if -1315220600 
// Compilation Unit of /UMLTransitionEffectListModel.java 
 

//#if -648939269 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 875049588 
import javax.swing.JPopupMenu;
//#endif 


//#if 1793671698 
import org.argouml.model.Model;
//#endif 


//#if -647423662 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 725637306 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewAction;
//#endif 


//#if -25902511 
import org.argouml.uml.ui.behavior.common_behavior.PopupMenuNewAction;
//#endif 


//#if 1657348167 
public class UMLTransitionEffectListModel extends 
//#if -390669108 
UMLModelElementListModel2
//#endif 

  { 

//#if -1964076742 
protected void buildModelList()
    { 

//#if 1950339183 
removeAllElements();
//#endif 


//#if 1595887802 
addElement(Model.getFacade().getEffect(getTarget()));
//#endif 

} 

//#endif 


//#if 1471325757 
public UMLTransitionEffectListModel()
    { 

//#if 1443423189 
super("effect");
//#endif 

} 

//#endif 


//#if -1852717714 
protected boolean isValidElement(Object element)
    { 

//#if -1013979691 
return element == Model.getFacade().getEffect(getTarget());
//#endif 

} 

//#endif 


//#if 1903359287 
@Override
    protected boolean hasPopup()
    { 

//#if 223398096 
return true;
//#endif 

} 

//#endif 


//#if -1199463696 
@Override
    public boolean buildPopup(JPopupMenu popup, int index)
    { 

//#if -853401681 
PopupMenuNewAction.buildMenu(popup,
                                     ActionNewAction.Roles.EFFECT, getTarget());
//#endif 


//#if 1747204336 
return true;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

