
//#if -1366631087 
// Compilation Unit of /ActionNewCallAction.java 
 

//#if 938308490 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if -196993544 
import java.awt.event.ActionEvent;
//#endif 


//#if 746365806 
import javax.swing.Action;
//#endif 


//#if -1903820292 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1382123901 
import org.argouml.i18n.Translator;
//#endif 


//#if -1158374717 
import org.argouml.model.Model;
//#endif 


//#if 382859711 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -2092051687 
public class ActionNewCallAction extends 
//#if -1864277325 
ActionNewAction
//#endif 

  { 

//#if 1052288798 
private static final ActionNewCallAction SINGLETON =
        new ActionNewCallAction();
//#endif 


//#if 31030014 
protected ActionNewCallAction()
    { 

//#if -394473225 
super();
//#endif 


//#if -1000672330 
putValue(Action.NAME, Translator.localize(
                     "button.new-callaction"));
//#endif 

} 

//#endif 


//#if 1163004898 
public static ActionNewAction getButtonInstance()
    { 

//#if 152572240 
ActionNewAction a = new ActionNewCallAction() {

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


//#if -2096566738 
a.putValue(SHORT_DESCRIPTION, a.getValue(Action.NAME));
//#endif 


//#if 1642838790 
Object icon = ResourceLoaderWrapper.lookupIconResource("CallAction");
//#endif 


//#if 2078514159 
a.putValue(SMALL_ICON, icon);
//#endif 


//#if 1766683571 
a.putValue(ROLE, Roles.EFFECT);
//#endif 


//#if -19025972 
return a;
//#endif 

} 

//#endif 


//#if 2086324818 
public static ActionNewCallAction getInstance()
    { 

//#if -203383875 
return SINGLETON;
//#endif 

} 

//#endif 


//#if -849582125 
protected Object createAction()
    { 

//#if 873219109 
return Model.getCommonBehaviorFactory().createCallAction();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

