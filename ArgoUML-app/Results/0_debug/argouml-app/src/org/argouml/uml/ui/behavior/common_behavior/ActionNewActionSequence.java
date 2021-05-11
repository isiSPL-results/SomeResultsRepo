
//#if -722273663 
// Compilation Unit of /ActionNewActionSequence.java 
 

//#if 1822420421 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 707477747 
import java.awt.event.ActionEvent;
//#endif 


//#if 719974761 
import javax.swing.Action;
//#endif 


//#if -823535071 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -644037150 
import org.argouml.i18n.Translator;
//#endif 


//#if -903884376 
import org.argouml.model.Model;
//#endif 


//#if 12830394 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -479153439 
public class ActionNewActionSequence extends 
//#if 10732300 
ActionNewAction
//#endif 

  { 

//#if 2007369183 
private static final ActionNewActionSequence SINGLETON =
        new ActionNewActionSequence();
//#endif 


//#if -488278250 
public static ActionNewActionSequence getInstance()
    { 

//#if 759463194 
return SINGLETON;
//#endif 

} 

//#endif 


//#if -360986968 
protected ActionNewActionSequence()
    { 

//#if -1722793915 
super();
//#endif 


//#if -1473629557 
putValue(Action.NAME, Translator.localize(
                     "button.new-actionsequence"));
//#endif 

} 

//#endif 


//#if 113162348 
protected Object createAction()
    { 

//#if 180965625 
return Model.getCommonBehaviorFactory().createActionSequence();
//#endif 

} 

//#endif 


//#if -838213527 
public static ActionNewAction getButtonInstance()
    { 

//#if -286322296 
ActionNewAction a = new ActionNewActionSequence() {

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


//#if 680950457 
a.putValue(SHORT_DESCRIPTION, a.getValue(Action.NAME));
//#endif 


//#if 634216910 
Object icon =
            ResourceLoaderWrapper.lookupIconResource("ActionSequence");
//#endif 


//#if 1517699130 
a.putValue(SMALL_ICON, icon);
//#endif 


//#if -305647298 
a.putValue(ROLE, Roles.EFFECT);
//#endif 


//#if 881272727 
return a;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

