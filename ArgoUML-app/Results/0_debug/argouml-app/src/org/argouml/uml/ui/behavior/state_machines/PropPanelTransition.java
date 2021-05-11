
//#if 14042954 
// Compilation Unit of /PropPanelTransition.java 
 

//#if -1851157745 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -1869518099 
import javax.swing.JList;
//#endif 


//#if -1214361922 
import org.argouml.uml.diagram.state.ui.ButtonActionNewCallEvent;
//#endif 


//#if 391456464 
import org.argouml.uml.diagram.state.ui.ButtonActionNewChangeEvent;
//#endif 


//#if -468621368 
import org.argouml.uml.diagram.state.ui.ButtonActionNewSignalEvent;
//#endif 


//#if -2009606163 
import org.argouml.uml.diagram.state.ui.ButtonActionNewTimeEvent;
//#endif 


//#if 1952163304 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if 2121337089 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if 2044438541 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewActionSequence;
//#endif 


//#if -638421488 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewCallAction;
//#endif 


//#if -568392846 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewCreateAction;
//#endif 


//#if -1677359806 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewDestroyAction;
//#endif 


//#if -1051982658 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewReturnAction;
//#endif 


//#if -488448602 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewSendAction;
//#endif 


//#if 1726782267 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewTerminateAction;
//#endif 


//#if 966928297 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewUninterpretedAction;
//#endif 


//#if 1315378476 
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
//#endif 


//#if -1212405271 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if -970602195 
import org.argouml.util.ToolBarUtility;
//#endif 


//#if 422767028 
public class PropPanelTransition extends 
//#if 1773988098 
PropPanelModelElement
//#endif 

  { 

//#if 408771725 
private static final long serialVersionUID = 7249233994894343728L;
//#endif 


//#if -1720040132 
public PropPanelTransition()
    { 

//#if -1763550359 
super("label.transition-title", lookupIcon("Transition"));
//#endif 


//#if 74616172 
addField("label.name",
                 getNameTextField());
//#endif 


//#if 1321118517 
addField("label.statemachine",
                 getSingleRowScroll(new UMLTransitionStatemachineListModel()));
//#endif 


//#if -1779230181 
addField("label.state",
                 getSingleRowScroll(new UMLTransitionStateListModel()));
//#endif 


//#if 1186421547 
addSeparator();
//#endif 


//#if -1170150379 
addField("label.source",
                 getSingleRowScroll(new UMLTransitionSourceListModel()));
//#endif 


//#if 1853419093 
addField("label.target",
                 getSingleRowScroll(new UMLTransitionTargetListModel()));
//#endif 


//#if 831762601 
addField("label.trigger",
                 getSingleRowScroll( new UMLTransitionTriggerListModel()));
//#endif 


//#if -1566879933 
addField("label.guard",
                 getSingleRowScroll(new UMLTransitionGuardListModel()));
//#endif 


//#if -103027115 
addField("label.effect",
                 getSingleRowScroll(new UMLTransitionEffectListModel()));
//#endif 


//#if 573040953 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if -1526097678 
addAction(getTriggerActions());
//#endif 


//#if -1986235740 
addAction(new ButtonActionNewGuard());
//#endif 


//#if 948403589 
addAction(getEffectActions());
//#endif 


//#if 206250923 
addAction(new ActionNewStereotype());
//#endif 


//#if -900230898 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if 434195338 
private Object[] getTriggerActions()
    { 

//#if 42413936 
Object[] actions = {
            new ButtonActionNewCallEvent(),
            new ButtonActionNewChangeEvent(),
            new ButtonActionNewSignalEvent(),
            new ButtonActionNewTimeEvent(),
        };
//#endif 


//#if -1003363111 
ToolBarUtility.manageDefault(actions, "transition.state.trigger");
//#endif 


//#if -608769859 
return actions;
//#endif 

} 

//#endif 


//#if -54660364 
protected Object[] getEffectActions()
    { 

//#if 985611149 
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
//#endif 


//#if -1382603873 
ToolBarUtility.manageDefault(actions, "transition.state.effect");
//#endif 


//#if -2036503722 
return actions;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

