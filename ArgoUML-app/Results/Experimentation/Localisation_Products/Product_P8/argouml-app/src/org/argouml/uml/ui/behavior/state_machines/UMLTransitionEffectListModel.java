package org.argouml.uml.ui.behavior.state_machines;
import javax.swing.JPopupMenu;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewAction;
import org.argouml.uml.ui.behavior.common_behavior.PopupMenuNewAction;
public class UMLTransitionEffectListModel extends UMLModelElementListModel2
  { 
protected void buildModelList()
    { 
removeAllElements();
addElement(Model.getFacade().getEffect(getTarget()));
} 
public UMLTransitionEffectListModel()
    { 
super("effect");
} 
protected boolean isValidElement(Object element)
    { 
return element == Model.getFacade().getEffect(getTarget());
} 
@Override
    protected boolean hasPopup()
    { 
return true;
} 
@Override
    public boolean buildPopup(JPopupMenu popup, int index)
    { 
PopupMenuNewAction.buildMenu(popup,
                                     ActionNewAction.Roles.EFFECT, getTarget());
return true;
} 

 } 
