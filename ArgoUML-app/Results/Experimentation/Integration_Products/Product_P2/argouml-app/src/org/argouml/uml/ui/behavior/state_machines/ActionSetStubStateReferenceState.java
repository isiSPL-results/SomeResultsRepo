package org.argouml.uml.ui.behavior.state_machines;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLComboBox2;
import org.tigris.gef.undo.UndoableAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
public class ActionSetStubStateReferenceState extends UndoableAction
  { 
private static final ActionSetStubStateReferenceState SINGLETON =
        new ActionSetStubStateReferenceState();
public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
if(e.getSource() instanceof UMLComboBox2)//1
{ 
UMLComboBox2 box = (UMLComboBox2) e.getSource();
Object o = box.getSelectedItem();
if(o != null)//1
{ 
String name = Model.getStateMachinesHelper().getPath(o);
if(name != null)//1
Model.getStateMachinesHelper()
                    .setReferenceState(box.getTarget(), name);
} 
} 
} 
public static ActionSetStubStateReferenceState getInstance()
    { 
return SINGLETON;
} 
protected ActionSetStubStateReferenceState()
    { 
super(Translator.localize("action.set"), null);
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.set"));
} 

 } 
