
//#if -185349752 
// Compilation Unit of /UMLTransitionGuardListModel.java 
 

//#if -335020289 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -963251728 
import javax.swing.JPopupMenu;
//#endif 


//#if 640905750 
import org.argouml.model.Model;
//#endif 


//#if -1151974516 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -753112575 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if 494130126 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -664354627 
public class UMLTransitionGuardListModel extends 
//#if 1557714334 
UMLModelElementListModel2
//#endif 

  { 

//#if -158495650 
@Override
    public boolean buildPopup(JPopupMenu popup, int index)
    { 

//#if -1990215499 
AbstractActionNewModelElement a = ActionNewGuard.getSingleton();
//#endif 


//#if 277772432 
a.setTarget(TargetManager.getInstance().getTarget());
//#endif 


//#if 2058952278 
popup.add(a);
//#endif 


//#if 1539754377 
return true;
//#endif 

} 

//#endif 


//#if 780214592 
protected boolean isValidElement(Object element)
    { 

//#if 44625904 
return element == Model.getFacade().getGuard(getTarget());
//#endif 

} 

//#endif 


//#if -1193029364 
protected void buildModelList()
    { 

//#if -111345158 
removeAllElements();
//#endif 


//#if -1731343151 
addElement(Model.getFacade().getGuard(getTarget()));
//#endif 

} 

//#endif 


//#if -1036351369 
public UMLTransitionGuardListModel()
    { 

//#if 393913466 
super("guard");
//#endif 

} 

//#endif 


//#if -1592160375 
@Override
    protected boolean hasPopup()
    { 

//#if -114468291 
return true;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

