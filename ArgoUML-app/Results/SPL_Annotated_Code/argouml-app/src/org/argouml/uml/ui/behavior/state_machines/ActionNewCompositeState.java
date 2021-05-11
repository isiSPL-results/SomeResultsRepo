// Compilation Unit of /ActionNewCompositeState.java 
 
package org.argouml.uml.ui.behavior.state_machines;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.AbstractActionNewModelElement;
public class ActionNewCompositeState extends AbstractActionNewModelElement
  { 
private static ActionNewCompositeState singleton =
        new ActionNewCompositeState();
protected ActionNewCompositeState()
    { 
super();
putValue(Action.NAME,
                 Translator.localize("button.new-compositestate"));
} 

public static ActionNewCompositeState getSingleton()
    { 
return singleton;
} 

public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
Model.getStateMachinesFactory().buildCompositeState(getTarget());
} 

 } 


