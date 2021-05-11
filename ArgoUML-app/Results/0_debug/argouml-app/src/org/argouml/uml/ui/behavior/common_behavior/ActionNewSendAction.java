
//#if 470337644 
// Compilation Unit of /ActionNewSendAction.java 
 

//#if -1492553624 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if -635161002 
import java.awt.event.ActionEvent;
//#endif 


//#if 183761356 
import javax.swing.Action;
//#endif 


//#if 282435294 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 683834591 
import org.argouml.i18n.Translator;
//#endif 


//#if -1341485275 
import org.argouml.model.Model;
//#endif 


//#if -2082236899 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 916264229 
public class ActionNewSendAction extends 
//#if 1200277561 
ActionNewAction
//#endif 

  { 

//#if -1376462716 
private static final ActionNewSendAction SINGLETON =
        new ActionNewSendAction();
//#endif 


//#if -1206901790 
protected ActionNewSendAction()
    { 

//#if 407223745 
super();
//#endif 


//#if -1775015594 
putValue(Action.NAME, Translator.localize(
                     "button.new-sendaction"));
//#endif 

} 

//#endif 


//#if -1039488295 
protected Object createAction()
    { 

//#if -1546467834 
return Model.getCommonBehaviorFactory().createSendAction();
//#endif 

} 

//#endif 


//#if 1274901916 
public static ActionNewAction getButtonInstance()
    { 

//#if 1807913231 
ActionNewAction a = new ActionNewSendAction() {

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


//#if -201049991 
a.putValue(SHORT_DESCRIPTION, a.getValue(Action.NAME));
//#endif 


//#if -2128623897 
Object icon = ResourceLoaderWrapper.lookupIconResource("SendAction");
//#endif 


//#if 1169534458 
a.putValue(SMALL_ICON, icon);
//#endif 


//#if 115551998 
a.putValue(ROLE, Roles.EFFECT);
//#endif 


//#if 1039594839 
return a;
//#endif 

} 

//#endif 


//#if -440594142 
public static ActionNewSendAction getInstance()
    { 

//#if 598091620 
return SINGLETON;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

