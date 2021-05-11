
//#if -1087965887 
// Compilation Unit of /ActionSetChangeability.java 
 

//#if -1342106968 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -1106996712 
import java.awt.event.ActionEvent;
//#endif 


//#if 1703229326 
import javax.swing.Action;
//#endif 


//#if 2020465761 
import javax.swing.JRadioButton;
//#endif 


//#if -1058170531 
import org.argouml.i18n.Translator;
//#endif 


//#if -1430021469 
import org.argouml.model.Model;
//#endif 


//#if -865967516 
import org.argouml.uml.ui.UMLRadioButtonPanel;
//#endif 


//#if 1160331438 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 448034067 
public class ActionSetChangeability extends 
//#if 38700204 
UndoableAction
//#endif 

  { 

//#if 1649496201 
private static final ActionSetChangeability SINGLETON =
        new ActionSetChangeability();
//#endif 


//#if 1442099261 
@Deprecated
    public static final String ADDONLY_COMMAND = "addonly";
//#endif 


//#if -984687978 
public static final String CHANGEABLE_COMMAND = "changeable";
//#endif 


//#if 1447791682 
public static final String FROZEN_COMMAND = "frozen";
//#endif 


//#if -1483818907 
protected ActionSetChangeability()
    { 

//#if 2052744216 
super(Translator.localize("Set"), null);
//#endif 


//#if 974371767 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 


//#if -280792331 
public void actionPerformed(ActionEvent e)
    { 

//#if -1133852957 
super.actionPerformed(e);
//#endif 


//#if -2095956168 
if(e.getSource() instanceof JRadioButton)//1
{ 

//#if -2135453966 
JRadioButton source = (JRadioButton) e.getSource();
//#endif 


//#if -537318402 
String actionCommand = source.getActionCommand();
//#endif 


//#if -2098617964 
Object target =
                ((UMLRadioButtonPanel) source.getParent()).getTarget();
//#endif 


//#if -868048976 
if(Model.getFacade().isAAssociationEnd(target)
                    || Model.getFacade().isAAttribute(target))//1
{ 

//#if 590313896 
Object m =  target;
//#endif 


//#if -1807453341 
if(actionCommand.equals(CHANGEABLE_COMMAND))//1
{ 

//#if -206168247 
Model.getCoreHelper().setReadOnly(m, false);
//#endif 

} 
else

//#if -212932938 
if(actionCommand.equals(ADDONLY_COMMAND))//1
{ 

//#if -1074829039 
Model.getCoreHelper().setChangeability(
                        m, Model.getChangeableKind().getAddOnly());
//#endif 

} 
else
{ 

//#if -237964957 
Model.getCoreHelper().setReadOnly(m, true);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 61825903 
public static ActionSetChangeability getInstance()
    { 

//#if 468015173 
return SINGLETON;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

