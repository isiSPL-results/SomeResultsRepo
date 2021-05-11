
//#if 80060225 
// Compilation Unit of /ActionSetContextStateMachine.java 
 

//#if -777178555 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -1006296641 
import java.awt.event.ActionEvent;
//#endif 


//#if -1939382731 
import javax.swing.Action;
//#endif 


//#if 2063531670 
import org.argouml.i18n.Translator;
//#endif 


//#if 1984070748 
import org.argouml.model.Model;
//#endif 


//#if 662965983 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if 1036990805 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -498829563 
public class ActionSetContextStateMachine extends 
//#if 1632808909 
UndoableAction
//#endif 

  { 

//#if 809200202 
private static final ActionSetContextStateMachine SINGLETON =
        new ActionSetContextStateMachine();
//#endif 


//#if 1601078702 
private static final long serialVersionUID = -8118983979324112900L;
//#endif 


//#if 1908058223 
protected ActionSetContextStateMachine()
    { 

//#if 12970289 
super(Translator.localize("action.set"), null);
//#endif 


//#if -1802435890 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.set"));
//#endif 

} 

//#endif 


//#if 1865440003 
public static ActionSetContextStateMachine getInstance()
    { 

//#if 356686468 
return SINGLETON;
//#endif 

} 

//#endif 


//#if 2058968820 
public void actionPerformed(ActionEvent e)
    { 

//#if 736207373 
super.actionPerformed(e);
//#endif 


//#if -1305860596 
if(e.getSource() instanceof UMLComboBox2)//1
{ 

//#if 432492053 
UMLComboBox2 source = (UMLComboBox2) e.getSource();
//#endif 


//#if -706837449 
Object target = source.getTarget();
//#endif 


//#if -667941266 
if(Model.getFacade().getContext(target)
                    != source.getSelectedItem())//1
{ 

//#if -494484177 
Model.getStateMachinesHelper().setContext(
                    target, source.getSelectedItem());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

