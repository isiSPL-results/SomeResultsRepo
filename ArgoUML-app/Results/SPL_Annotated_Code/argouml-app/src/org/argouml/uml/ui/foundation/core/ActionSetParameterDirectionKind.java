// Compilation Unit of /ActionSetParameterDirectionKind.java 
 
package org.argouml.uml.ui.foundation.core;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JRadioButton;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLRadioButtonPanel;
import org.tigris.gef.undo.UndoableAction;
public class ActionSetParameterDirectionKind extends UndoableAction
  { 
private static final ActionSetParameterDirectionKind SINGLETON =
        new ActionSetParameterDirectionKind();
public static final String IN_COMMAND = "in";
public static final String OUT_COMMAND = "out";
public static final String INOUT_COMMAND = "inout";
public static final String RETURN_COMMAND = "return";
public static ActionSetParameterDirectionKind getInstance()
    { 
return SINGLETON;
} 

@Override
    public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
if(e.getSource() instanceof JRadioButton)//1
{ 
JRadioButton source = (JRadioButton) e.getSource();
String actionCommand = source.getActionCommand();
Object target = ((UMLRadioButtonPanel) source.getParent())
                            .getTarget();
if(Model.getFacade().isAParameter(target))//1
{ 
Object kind = null;
if(actionCommand == null)//1
{ 
kind = null;
} 
else
if(actionCommand.equals(IN_COMMAND))//1
{ 
kind = Model.getDirectionKind().getInParameter();
} 
else
if(actionCommand.equals(OUT_COMMAND))//1
{ 
kind = Model.getDirectionKind().getOutParameter();
} 
else
if(actionCommand.equals(INOUT_COMMAND))//1
{ 
kind = Model.getDirectionKind().getInOutParameter();
} 
else
if(actionCommand.equals(RETURN_COMMAND))//1
{ 
kind = Model.getDirectionKind().getReturnParameter();
} 





Model.getCoreHelper().setKind(target, kind);
} 

} 

} 

protected ActionSetParameterDirectionKind()
    { 
super(Translator.localize("Set"), null);
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
} 

 } 


