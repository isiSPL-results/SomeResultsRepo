
//#if -966170638 
// Compilation Unit of /ActionNewTerminateAction.java 
 

//#if -1959986537 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if -1056293307 
import java.awt.event.ActionEvent;
//#endif 


//#if -1984143173 
import javax.swing.Action;
//#endif 


//#if -1802954353 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 513635024 
import org.argouml.i18n.Translator;
//#endif 


//#if -731372138 
import org.argouml.model.Model;
//#endif 


//#if -764289012 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 2004023103 
public class ActionNewTerminateAction extends 
//#if -1325775237 
ActionNewAction
//#endif 

  { 

//#if -1407306730 
private static final ActionNewTerminateAction SINGLETON =
        new ActionNewTerminateAction();
//#endif 


//#if 1351528218 
public static ActionNewAction getButtonInstance()
    { 

//#if 1695952648 
ActionNewAction a = new ActionNewTerminateAction() {

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


//#if 849036011 
a.putValue(SHORT_DESCRIPTION, a.getValue(Action.NAME));
//#endif 


//#if 1293227322 
Object icon = ResourceLoaderWrapper.lookupIconResource(
                          "TerminateAction");
//#endif 


//#if 1942217452 
a.putValue(SMALL_ICON, icon);
//#endif 


//#if -365432976 
a.putValue(ROLE, Roles.EFFECT);
//#endif 


//#if 2030540617 
return a;
//#endif 

} 

//#endif 


//#if 1331410903 
protected ActionNewTerminateAction()
    { 

//#if -956797211 
super();
//#endif 


//#if 397698997 
putValue(Action.NAME, Translator.localize(
                     "button.new-terminateaction"));
//#endif 

} 

//#endif 


//#if -1508438629 
protected Object createAction()
    { 

//#if 1810024039 
return Model.getCommonBehaviorFactory().createTerminateAction();
//#endif 

} 

//#endif 


//#if -7059453 
public static ActionNewTerminateAction getInstance()
    { 

//#if -1100770090 
return SINGLETON;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

