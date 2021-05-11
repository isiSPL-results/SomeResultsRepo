
//#if -437118070 
// Compilation Unit of /ActionNewStubState.java 
 

//#if 137035326 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -1685708634 
import java.awt.event.ActionEvent;
//#endif 


//#if -556977124 
import javax.swing.Action;
//#endif 


//#if -1818370929 
import org.argouml.i18n.Translator;
//#endif 


//#if -580303147 
import org.argouml.model.Model;
//#endif 


//#if -1954407902 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if 2026779820 
public class ActionNewStubState extends 
//#if -652195460 
AbstractActionNewModelElement
//#endif 

  { 

//#if 1665452848 
private static final ActionNewStubState SINGLETON =
        new ActionNewStubState();
//#endif 


//#if 840446985 
protected ActionNewStubState()
    { 

//#if -561958209 
super();
//#endif 


//#if 435890587 
putValue(Action.NAME, Translator.localize(
                     "button.new-stubstate"));
//#endif 

} 

//#endif 


//#if -95740018 
public void actionPerformed(ActionEvent e)
    { 

//#if 79017537 
super.actionPerformed(e);
//#endif 


//#if -449542661 
Model.getStateMachinesFactory().buildStubState(getTarget());
//#endif 

} 

//#endif 


//#if 2032559709 
public static ActionNewStubState getInstance()
    { 

//#if 947556267 
return SINGLETON;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

