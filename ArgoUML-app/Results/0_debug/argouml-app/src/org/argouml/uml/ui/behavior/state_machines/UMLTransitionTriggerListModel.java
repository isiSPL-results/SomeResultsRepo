
//#if 1959166154 
// Compilation Unit of /UMLTransitionTriggerListModel.java 
 

//#if -1293022067 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -1905080414 
import javax.swing.JPopupMenu;
//#endif 


//#if 1508987556 
import org.argouml.model.Model;
//#endif 


//#if 860846080 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1158118312 
public class UMLTransitionTriggerListModel extends 
//#if 1012644034 
UMLModelElementListModel2
//#endif 

  { 

//#if 507119784 
public UMLTransitionTriggerListModel()
    { 

//#if -543626638 
super("trigger");
//#endif 

} 

//#endif 


//#if -1607005596 
protected boolean isValidElement(Object element)
    { 

//#if -1169384055 
return element == Model.getFacade().getTrigger(getTarget());
//#endif 

} 

//#endif 


//#if 1386913210 
@Override
    public boolean buildPopup(JPopupMenu popup, int index)
    { 

//#if -1202470348 
PopupMenuNewEvent.buildMenu(popup,
                                    ActionNewEvent.Roles.TRIGGER, getTarget());
//#endif 


//#if 2112804612 
return true;
//#endif 

} 

//#endif 


//#if -2009562576 
protected void buildModelList()
    { 

//#if -1584644790 
removeAllElements();
//#endif 


//#if -1799382546 
addElement(Model.getFacade().getTrigger(getTarget()));
//#endif 

} 

//#endif 


//#if 1086707117 
@Override
    protected boolean hasPopup()
    { 

//#if -1935934309 
return true;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

