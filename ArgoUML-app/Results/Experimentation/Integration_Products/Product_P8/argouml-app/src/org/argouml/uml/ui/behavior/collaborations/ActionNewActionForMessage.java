package org.argouml.uml.ui.behavior.collaborations;
import java.awt.event.ActionEvent;
import org.argouml.model.Model;
import org.argouml.uml.ui.AbstractActionNewModelElement;
public class ActionNewActionForMessage extends AbstractActionNewModelElement
  { 
private static final ActionNewActionForMessage SINGLETON =
        new ActionNewActionForMessage();
public static ActionNewActionForMessage getInstance()
    { 
return SINGLETON;
} 
public ActionNewActionForMessage()
    { 
super();
} 
public boolean isEnabled()
    { 
if(getTarget() != null)//1
{ 
return Model.getFacade().getAction(getTarget()) == null;
} 
return false;
} 
public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
Model.getCommonBehaviorFactory().buildAction(getTarget());
} 

 } 
