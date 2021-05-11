package org.argouml.uml.ui.behavior.collaborations;
import java.awt.event.ActionEvent;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLComboBox2;
import org.tigris.gef.undo.UndoableAction;
class ActionSetRepresentedClassifierCollaboration extends UndoableAction
  { 
public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
if(e.getSource() instanceof UMLComboBox2)//1
{ 
UMLComboBox2 source = (UMLComboBox2) e.getSource();
Object target = source.getTarget();
Object newValue = source.getSelectedItem();
if(!Model.getFacade().isAClassifier(newValue))//1
{ 
newValue = null;
} 
if(Model.getFacade().getRepresentedClassifier(target)
                    != newValue)//1
{ 
Model.getCollaborationsHelper().setRepresentedClassifier(
                    target, newValue);
} 
} 
} 
ActionSetRepresentedClassifierCollaboration()
    { 
super(Translator.localize("action.set"),
              ResourceLoaderWrapper.lookupIcon("action.set"));
} 

 } 
