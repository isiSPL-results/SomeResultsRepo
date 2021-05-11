// Compilation Unit of /UMLTransitionGuardListModel.java 
 
package org.argouml.uml.ui.behavior.state_machines;
import javax.swing.JPopupMenu;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.ui.AbstractActionNewModelElement;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLTransitionGuardListModel extends UMLModelElementListModel2
  { 
@Override
    public boolean buildPopup(JPopupMenu popup, int index)
    { 
AbstractActionNewModelElement a = ActionNewGuard.getSingleton();
a.setTarget(TargetManager.getInstance().getTarget());
popup.add(a);
return true;
} 

protected boolean isValidElement(Object element)
    { 
return element == Model.getFacade().getGuard(getTarget());
} 

protected void buildModelList()
    { 
removeAllElements();
addElement(Model.getFacade().getGuard(getTarget()));
} 

public UMLTransitionGuardListModel()
    { 
super("guard");
} 

@Override
    protected boolean hasPopup()
    { 
return true;
} 

 } 


