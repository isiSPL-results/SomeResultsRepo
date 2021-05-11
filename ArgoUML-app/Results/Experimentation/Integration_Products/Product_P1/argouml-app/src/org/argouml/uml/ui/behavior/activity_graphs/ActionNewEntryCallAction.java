package org.argouml.uml.ui.behavior.activity_graphs;
import java.awt.event.ActionEvent;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.tigris.gef.undo.UndoableAction;
class ActionNewEntryCallAction extends UndoableAction
  { 
public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
Object t = TargetManager.getInstance().getModelTarget();
Object ca = Model.getCommonBehaviorFactory().createCallAction();
Model.getStateMachinesHelper().setEntry(t, ca);
TargetManager.getInstance().setTarget(ca);
} 
public ActionNewEntryCallAction()
    { 
super();
} 

 } 
