
//#if 34370092 
// Compilation Unit of /ActionNewCreateAction.java 
 

//#if 209423446 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 1304498628 
import java.awt.event.ActionEvent;
//#endif 


//#if 560079674 
import javax.swing.Action;
//#endif 


//#if -2032595280 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 683740977 
import org.argouml.i18n.Translator;
//#endif 


//#if 549657207 
import org.argouml.model.Model;
//#endif 


//#if 963106187 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1377908565 
public class ActionNewCreateAction extends 
//#if 1858468094 
ActionNewAction
//#endif 

  { 

//#if -1528503689 
private static final ActionNewCreateAction SINGLETON =
        new ActionNewCreateAction();
//#endif 


//#if 1875549918 
protected Object createAction()
    { 

//#if 679761583 
return Model.getCommonBehaviorFactory().createCreateAction();
//#endif 

} 

//#endif 


//#if 711167177 
public static ActionNewCreateAction getInstance()
    { 

//#if 935558577 
return SINGLETON;
//#endif 

} 

//#endif 


//#if -696423369 
public static ActionNewAction getButtonInstance()
    { 

//#if 1276514727 
ActionNewAction a = new ActionNewCreateAction() {

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


//#if 2033007253 
a.putValue(SHORT_DESCRIPTION, a.getValue(Action.NAME));
//#endif 


//#if 183472335 
Object icon = ResourceLoaderWrapper.lookupIconResource("CreateAction");
//#endif 


//#if 1662982934 
a.putValue(SMALL_ICON, icon);
//#endif 


//#if 1873134874 
a.putValue(ROLE, Roles.EFFECT);
//#endif 


//#if -143849357 
return a;
//#endif 

} 

//#endif 


//#if 1351515761 
protected ActionNewCreateAction()
    { 

//#if -922137944 
super();
//#endif 


//#if 2016275075 
putValue(Action.NAME, Translator.localize("button.new-createaction"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

