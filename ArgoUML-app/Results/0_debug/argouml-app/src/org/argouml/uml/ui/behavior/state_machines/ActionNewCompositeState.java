
//#if -515699839 
// Compilation Unit of /ActionNewCompositeState.java 
 

//#if 822312982 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 325407694 
import java.awt.event.ActionEvent;
//#endif 


//#if 1493569348 
import javax.swing.Action;
//#endif 


//#if 396693095 
import org.argouml.i18n.Translator;
//#endif 


//#if -3988307 
import org.argouml.model.Model;
//#endif 


//#if -1150746806 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if -979823207 
public class ActionNewCompositeState extends 
//#if 49866285 
AbstractActionNewModelElement
//#endif 

  { 

//#if 222736515 
private static ActionNewCompositeState singleton =
        new ActionNewCompositeState();
//#endif 


//#if 911551125 
protected ActionNewCompositeState()
    { 

//#if 1071384952 
super();
//#endif 


//#if 1296567275 
putValue(Action.NAME,
                 Translator.localize("button.new-compositestate"));
//#endif 

} 

//#endif 


//#if 916063941 
public static ActionNewCompositeState getSingleton()
    { 

//#if -807116761 
return singleton;
//#endif 

} 

//#endif 


//#if 87053055 
public void actionPerformed(ActionEvent e)
    { 

//#if -1512319261 
super.actionPerformed(e);
//#endif 


//#if -277005288 
Model.getStateMachinesFactory().buildCompositeState(getTarget());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

