
//#if -1006952932 
// Compilation Unit of /ActionSetRepresentedOperationCollaboration.java 
 

//#if -296413822 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if -1509959922 
import java.awt.event.ActionEvent;
//#endif 


//#if 1861438246 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -665128153 
import org.argouml.i18n.Translator;
//#endif 


//#if -626431635 
import org.argouml.model.Model;
//#endif 


//#if -708750608 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if -1453117532 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -1232220579 
class ActionSetRepresentedOperationCollaboration extends 
//#if 746947400 
UndoableAction
//#endif 

  { 

//#if 2045528270 
ActionSetRepresentedOperationCollaboration()
    { 

//#if -409683478 
super(Translator.localize("action.set"),
              ResourceLoaderWrapper.lookupIcon("action.set"));
//#endif 

} 

//#endif 


//#if 1320475609 
public void actionPerformed(ActionEvent e)
    { 

//#if 1150346550 
super.actionPerformed(e);
//#endif 


//#if -689538557 
if(e.getSource() instanceof UMLComboBox2)//1
{ 

//#if 1508171827 
UMLComboBox2 source = (UMLComboBox2) e.getSource();
//#endif 


//#if -1560364583 
Object target = source.getTarget();
//#endif 


//#if 2029925468 
Object newValue = source.getSelectedItem();
//#endif 


//#if -1060754752 
if(!Model.getFacade().isAOperation(newValue))//1
{ 

//#if 1785039527 
newValue = null;
//#endif 

} 

//#endif 


//#if 478455726 
if(Model.getFacade().getRepresentedOperation(target)
                    != newValue)//1
{ 

//#if 963273461 
Model.getCollaborationsHelper().setRepresentedOperation(
                    target, newValue);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

