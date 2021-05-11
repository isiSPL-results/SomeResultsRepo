
//#if -523103858 
// Compilation Unit of /ActionSetParameterDirectionKind.java 
 

//#if 1765793902 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -1283453550 
import java.awt.event.ActionEvent;
//#endif 


//#if -792146680 
import javax.swing.Action;
//#endif 


//#if 1537601115 
import javax.swing.JRadioButton;
//#endif 


//#if 2061602083 
import org.argouml.i18n.Translator;
//#endif 


//#if -475766423 
import org.argouml.model.Model;
//#endif 


//#if -1149218 
import org.argouml.uml.ui.UMLRadioButtonPanel;
//#endif 


//#if 429302312 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 973899479 
public class ActionSetParameterDirectionKind extends 
//#if -2018412089 
UndoableAction
//#endif 

  { 

//#if 899345620 
private static final ActionSetParameterDirectionKind SINGLETON =
        new ActionSetParameterDirectionKind();
//#endif 


//#if 229541649 
public static final String IN_COMMAND = "in";
//#endif 


//#if -440655707 
public static final String OUT_COMMAND = "out";
//#endif 


//#if -483404667 
public static final String INOUT_COMMAND = "inout";
//#endif 


//#if -977316953 
public static final String RETURN_COMMAND = "return";
//#endif 


//#if -217117280 
public static ActionSetParameterDirectionKind getInstance()
    { 

//#if 1405910630 
return SINGLETON;
//#endif 

} 

//#endif 


//#if -911170668 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if -1229075381 
super.actionPerformed(e);
//#endif 


//#if -842156336 
if(e.getSource() instanceof JRadioButton)//1
{ 

//#if -1720288928 
JRadioButton source = (JRadioButton) e.getSource();
//#endif 


//#if 1000094672 
String actionCommand = source.getActionCommand();
//#endif 


//#if 180947202 
Object target = ((UMLRadioButtonPanel) source.getParent())
                            .getTarget();
//#endif 


//#if -1594999576 
if(Model.getFacade().isAParameter(target))//1
{ 

//#if -1736960266 
Object kind = null;
//#endif 


//#if 1078162277 
if(actionCommand == null)//1
{ 

//#if 1528681579 
kind = null;
//#endif 

} 
else

//#if -192894026 
if(actionCommand.equals(IN_COMMAND))//1
{ 

//#if -1186932323 
kind = Model.getDirectionKind().getInParameter();
//#endif 

} 
else

//#if 1284848218 
if(actionCommand.equals(OUT_COMMAND))//1
{ 

//#if 256595290 
kind = Model.getDirectionKind().getOutParameter();
//#endif 

} 
else

//#if -525473221 
if(actionCommand.equals(INOUT_COMMAND))//1
{ 

//#if 1879205254 
kind = Model.getDirectionKind().getInOutParameter();
//#endif 

} 
else

//#if -1854846300 
if(actionCommand.equals(RETURN_COMMAND))//1
{ 

//#if 4946307 
kind = Model.getDirectionKind().getReturnParameter();
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#if -167738188 
Model.getCoreHelper().setKind(target, kind);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -483559300 
protected ActionSetParameterDirectionKind()
    { 

//#if -1470464684 
super(Translator.localize("Set"), null);
//#endif 


//#if -2090533125 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

