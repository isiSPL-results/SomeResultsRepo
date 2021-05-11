// Compilation Unit of /PropPanelTransition.java 
 
package org.argouml.uml.ui.behavior.state_machines;
import javax.swing.JList;
import org.argouml.uml.diagram.state.ui.ButtonActionNewCallEvent;
import org.argouml.uml.diagram.state.ui.ButtonActionNewChangeEvent;
import org.argouml.uml.diagram.state.ui.ButtonActionNewSignalEvent;
import org.argouml.uml.diagram.state.ui.ButtonActionNewTimeEvent;
import org.argouml.uml.ui.ActionNavigateContainerElement;
import org.argouml.uml.ui.UMLMutableLinkedList;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewActionSequence;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewCallAction;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewCreateAction;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewDestroyAction;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewReturnAction;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewSendAction;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewTerminateAction;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewUninterpretedAction;
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
import org.argouml.util.ToolBarUtility;
public class PropPanelTransition extends PropPanelModelElement
  { 
private static final long serialVersionUID = 7249233994894343728L;
public PropPanelTransition()
    { 
super("label.transition-title", lookupIcon("Transition"));
addField("label.name",
                 getNameTextField());
addField("label.statemachine",
                 getSingleRowScroll(new UMLTransitionStatemachineListModel()));
addField("label.state",
                 getSingleRowScroll(new UMLTransitionStateListModel()));
addSeparator();
addField("label.source",
                 getSingleRowScroll(new UMLTransitionSourceListModel()));
addField("label.target",
                 getSingleRowScroll(new UMLTransitionTargetListModel()));
addField("label.trigger",
                 getSingleRowScroll( new UMLTransitionTriggerListModel()));
addField("label.guard",
                 getSingleRowScroll(new UMLTransitionGuardListModel()));
addField("label.effect",
                 getSingleRowScroll(new UMLTransitionEffectListModel()));
addAction(new ActionNavigateContainerElement());
addAction(getTriggerActions());
addAction(new ButtonActionNewGuard());
addAction(getEffectActions());
addAction(new ActionNewStereotype());
addAction(getDeleteAction());
} 

private Object[] getTriggerActions()
    { 
Object[] actions = {
            new ButtonActionNewCallEvent(),
            new ButtonActionNewChangeEvent(),
            new ButtonActionNewSignalEvent(),
            new ButtonActionNewTimeEvent(),
        };
ToolBarUtility.manageDefault(actions, "transition.state.trigger");
return actions;
} 

protected Object[] getEffectActions()
    { 
Object[] actions = {
            ActionNewCallAction.getButtonInstance(),
            ActionNewCreateAction.getButtonInstance(),
            ActionNewDestroyAction.getButtonInstance(),
            ActionNewReturnAction.getButtonInstance(),
            ActionNewSendAction.getButtonInstance(),
            ActionNewTerminateAction.getButtonInstance(),
            ActionNewUninterpretedAction.getButtonInstance(),
            ActionNewActionSequence.getButtonInstance(),
        };
ToolBarUtility.manageDefault(actions, "transition.state.effect");
return actions;
} 

 } 


