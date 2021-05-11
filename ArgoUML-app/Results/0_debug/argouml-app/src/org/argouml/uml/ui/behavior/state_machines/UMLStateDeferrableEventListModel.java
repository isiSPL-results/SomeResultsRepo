
//#if -1500548892 
// Compilation Unit of /UMLStateDeferrableEventListModel.java 
 

//#if 389870155 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 156895012 
import javax.swing.JPopupMenu;
//#endif 


//#if 1005716322 
import org.argouml.model.Model;
//#endif 


//#if 1490897410 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1866246130 
public class UMLStateDeferrableEventListModel extends 
//#if -1488076672 
UMLModelElementListModel2
//#endif 

  { 

//#if -907475524 
@Override
    public boolean buildPopup(JPopupMenu popup, int index)
    { 

//#if -58202718 
PopupMenuNewEvent.buildMenu(popup,
                                    ActionNewEvent.Roles.DEFERRABLE_EVENT, getTarget());
//#endif 


//#if -219573935 
return true;
//#endif 

} 

//#endif 


//#if -1757119762 
protected void buildModelList()
    { 

//#if -35924880 
setAllElements(Model.getFacade().getDeferrableEvents(getTarget()));
//#endif 

} 

//#endif 


//#if -1503279326 
protected boolean isValidElement(Object element)
    { 

//#if 1211785696 
return Model.getFacade().getDeferrableEvents(getTarget())
               .contains(element);
//#endif 

} 

//#endif 


//#if -1578242336 
public UMLStateDeferrableEventListModel()
    { 

//#if -846887774 
super("deferrableEvent");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

