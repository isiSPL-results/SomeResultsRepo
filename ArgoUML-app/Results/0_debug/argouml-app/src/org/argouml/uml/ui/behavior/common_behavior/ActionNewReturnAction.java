
//#if -624735870 
// Compilation Unit of /ActionNewReturnAction.java 
 

//#if -1039025071 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if -133965185 
import java.awt.event.ActionEvent;
//#endif 


//#if -871704843 
import javax.swing.Action;
//#endif 


//#if -1177966315 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -958964266 
import org.argouml.i18n.Translator;
//#endif 


//#if -1850965092 
import org.argouml.model.Model;
//#endif 


//#if -1053833146 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1608131012 
public class ActionNewReturnAction extends 
//#if 844522385 
ActionNewAction
//#endif 

  { 

//#if 1605106268 
private static final ActionNewReturnAction SINGLETON =
        new ActionNewReturnAction();
//#endif 


//#if -57409758 
public static ActionNewReturnAction getInstance()
    { 

//#if -1017667451 
return SINGLETON;
//#endif 

} 

//#endif 


//#if -820744380 
public static ActionNewAction getButtonInstance()
    { 

//#if 1569698326 
ActionNewAction a = new ActionNewReturnAction() {

            public void actionPerformed(ActionEvent e) {
                Object target = TargetManager.getInstance().getModelTarget();
                if (!Model.getFacade().isATransition(target)) {
                    return;
                }
                setTarget(target);
                super.actionPerformed(e);
            }

        };
//#endif 


//#if 896020538 
a.putValue(SHORT_DESCRIPTION, a.getValue(Action.NAME));
//#endif 


//#if -1934155776 
Object icon = ResourceLoaderWrapper.lookupIconResource("ReturnAction");
//#endif 


//#if 1343968507 
a.putValue(SMALL_ICON, icon);
//#endif 


//#if 242948543 
a.putValue(ROLE, Roles.EFFECT);
//#endif 


//#if 1827366616 
return a;
//#endif 

} 

//#endif 


//#if 710380593 
protected Object createAction()
    { 

//#if 495751099 
return Model.getCommonBehaviorFactory().createReturnAction();
//#endif 

} 

//#endif 


//#if -388541326 
protected ActionNewReturnAction()
    { 

//#if 1047759389 
super();
//#endif 


//#if 726596194 
putValue(Action.NAME, Translator.localize(
                     "button.new-returnaction"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

