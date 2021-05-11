
//#if -118035886 
// Compilation Unit of /ActionNewDestroyAction.java 
 

//#if 1614767077 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if -109969645 
import java.awt.event.ActionEvent;
//#endif 


//#if -278868087 
import javax.swing.Action;
//#endif 


//#if -511883263 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -215102526 
import org.argouml.i18n.Translator;
//#endif 


//#if 1776207752 
import org.argouml.model.Model;
//#endif 


//#if -1408613158 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -942770970 
public class ActionNewDestroyAction extends 
//#if 1034487188 
ActionNewAction
//#endif 

  { 

//#if 1220524349 
private static final ActionNewDestroyAction SINGLETON =
        new ActionNewDestroyAction();
//#endif 


//#if -453448460 
protected Object createAction()
    { 

//#if 509063079 
return Model.getCommonBehaviorFactory().createDestroyAction();
//#endif 

} 

//#endif 


//#if 769211491 
public static ActionNewDestroyAction getInstance()
    { 

//#if -291949906 
return SINGLETON;
//#endif 

} 

//#endif 


//#if -92386079 
public static ActionNewAction getButtonInstance()
    { 

//#if -1947351250 
ActionNewAction a = new ActionNewDestroyAction() {

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


//#if -423518088 
a.putValue(SHORT_DESCRIPTION, a.getValue(Action.NAME));
//#endif 


//#if 1367405012 
Object icon = ResourceLoaderWrapper.lookupIconResource("DestroyAction");
//#endif 


//#if 1871287993 
a.putValue(SMALL_ICON, icon);
//#endif 


//#if 190833661 
a.putValue(ROLE, Roles.EFFECT);
//#endif 


//#if -1236175978 
return a;
//#endif 

} 

//#endif 


//#if 1309546249 
protected ActionNewDestroyAction()
    { 

//#if 380936602 
super();
//#endif 


//#if 1395636035 
putValue(Action.NAME, Translator.localize("button.new-destroyaction"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

