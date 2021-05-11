
//#if 851206542 
// Compilation Unit of /ActionNewSubmachineState.java 
 

//#if -669626863 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 1182221427 
import java.awt.event.ActionEvent;
//#endif 


//#if 1462858985 
import javax.swing.Action;
//#endif 


//#if 1188115042 
import org.argouml.i18n.Translator;
//#endif 


//#if -1753317848 
import org.argouml.model.Model;
//#endif 


//#if 761181743 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if -1156476736 
public class ActionNewSubmachineState extends 
//#if -547366042 
AbstractActionNewModelElement
//#endif 

  { 

//#if 748196070 
private static final ActionNewSubmachineState SINGLETON =
        new ActionNewSubmachineState();
//#endif 


//#if 869722938 
protected ActionNewSubmachineState()
    { 

//#if -1661173335 
super();
//#endif 


//#if -1686840308 
putValue(Action.NAME, Translator.localize(
                     "button.new-submachinestate"));
//#endif 

} 

//#endif 


//#if -267617952 
public static ActionNewSubmachineState getInstance()
    { 

//#if 1213617788 
return SINGLETON;
//#endif 

} 

//#endif 


//#if 538236152 
public void actionPerformed(ActionEvent e)
    { 

//#if 1124456842 
super.actionPerformed(e);
//#endif 


//#if 1998526041 
Model.getStateMachinesFactory().buildSubmachineState(getTarget());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

