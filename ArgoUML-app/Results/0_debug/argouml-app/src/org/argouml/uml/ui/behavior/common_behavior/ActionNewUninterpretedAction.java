
//#if -1645015852 
// Compilation Unit of /ActionNewUninterpretedAction.java 
 

//#if -1594000672 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if -1411879218 
import java.awt.event.ActionEvent;
//#endif 


//#if 1472473668 
import javax.swing.Action;
//#endif 


//#if 1782176614 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1919593625 
import org.argouml.i18n.Translator;
//#endif 


//#if -1700927059 
import org.argouml.model.Model;
//#endif 


//#if 1707597461 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1477563226 
public class ActionNewUninterpretedAction extends 
//#if -1612975527 
ActionNewAction
//#endif 

  { 

//#if -1679797320 
private static final ActionNewUninterpretedAction SINGLETON =
        new ActionNewUninterpretedAction();
//#endif 


//#if -233549817 
protected ActionNewUninterpretedAction()
    { 

//#if -916730550 
super();
//#endif 


//#if -1967887764 
putValue(Action.NAME, Translator.localize(
                     "button.new-uninterpretedaction"));
//#endif 

} 

//#endif 


//#if -1323220657 
public static ActionNewUninterpretedAction getInstance()
    { 

//#if 513063626 
return SINGLETON;
//#endif 

} 

//#endif 


//#if 437192572 
public static ActionNewAction getButtonInstance()
    { 

//#if -1153250205 
ActionNewAction a = new ActionNewUninterpretedAction() {

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


//#if -659270988 
a.putValue(SHORT_DESCRIPTION, a.getValue(Action.NAME));
//#endif 


//#if -867568897 
Object icon =
            ResourceLoaderWrapper.lookupIconResource("UninterpretedAction");
//#endif 


//#if -1511482379 
a.putValue(SMALL_ICON, icon);
//#endif 


//#if 638749241 
a.putValue(ROLE, Roles.EFFECT);
//#endif 


//#if 136474322 
return a;
//#endif 

} 

//#endif 


//#if -210264839 
protected Object createAction()
    { 

//#if 1441092232 
return Model.getCommonBehaviorFactory().createUninterpretedAction();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

