
//#if 1876371374 
// Compilation Unit of /ActionNewSynchState.java 
 

//#if 1790209195 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -887425383 
import java.awt.event.ActionEvent;
//#endif 


//#if -1000035057 
import javax.swing.Action;
//#endif 


//#if 1453573372 
import org.argouml.i18n.Translator;
//#endif 


//#if 1114009026 
import org.argouml.model.Model;
//#endif 


//#if -978475051 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if 1796656968 
public class ActionNewSynchState extends 
//#if -913201932 
AbstractActionNewModelElement
//#endif 

  { 

//#if -535565224 
private static final ActionNewSynchState SINGLETON =
        new ActionNewSynchState();
//#endif 


//#if 1613499836 
public static ActionNewSynchState getInstance()
    { 

//#if 2089060617 
return SINGLETON;
//#endif 

} 

//#endif 


//#if -795521976 
protected ActionNewSynchState()
    { 

//#if 909144945 
super();
//#endif 


//#if 1877461612 
putValue(Action.NAME, Translator.localize("button.new-synchstate"));
//#endif 

} 

//#endif 


//#if -398818042 
public void actionPerformed(ActionEvent e)
    { 

//#if 1258990815 
super.actionPerformed(e);
//#endif 


//#if 1513119150 
Model.getStateMachinesFactory().buildSynchState(getTarget());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

