
//#if -1314479081 
// Compilation Unit of /ActionSetSubmachineStateSubmachine.java 
 

//#if -759727289 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -1464996739 
import java.awt.event.ActionEvent;
//#endif 


//#if -1087518989 
import javax.swing.Action;
//#endif 


//#if 728730520 
import org.argouml.i18n.Translator;
//#endif 


//#if -881466786 
import org.argouml.model.Model;
//#endif 


//#if -486389023 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if 81290771 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -746549393 
public class ActionSetSubmachineStateSubmachine extends 
//#if 1844054387 
UndoableAction
//#endif 

  { 

//#if -1080242640 
private static final ActionSetSubmachineStateSubmachine SINGLETON =
        new ActionSetSubmachineStateSubmachine();
//#endif 


//#if -1208518923 
protected ActionSetSubmachineStateSubmachine()
    { 

//#if -2143478768 
super(Translator.localize("action.set"), null);
//#endif 


//#if 1920795919 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.set"));
//#endif 

} 

//#endif 


//#if -293007631 
public static ActionSetSubmachineStateSubmachine getInstance()
    { 

//#if 974127553 
return SINGLETON;
//#endif 

} 

//#endif 


//#if -1227617266 
public void actionPerformed(ActionEvent e)
    { 

//#if 579610714 
super.actionPerformed(e);
//#endif 


//#if 553476959 
if(e.getSource() instanceof UMLComboBox2)//1
{ 

//#if 1679180297 
UMLComboBox2 box = (UMLComboBox2) e.getSource();
//#endif 


//#if 12456231 
Model.getStateMachinesHelper().setStatemachineAsSubmachine(
                box.getTarget(), box.getSelectedItem());
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

