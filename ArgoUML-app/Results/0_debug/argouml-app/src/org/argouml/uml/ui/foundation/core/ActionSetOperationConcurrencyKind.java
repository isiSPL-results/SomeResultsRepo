
//#if -1146458599 
// Compilation Unit of /ActionSetOperationConcurrencyKind.java 
 

//#if -2132781429 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -1396321579 
import java.awt.event.ActionEvent;
//#endif 


//#if -1604483765 
import javax.swing.Action;
//#endif 


//#if 2131896414 
import javax.swing.JRadioButton;
//#endif 


//#if -1437306816 
import org.argouml.i18n.Translator;
//#endif 


//#if 513235718 
import org.argouml.model.Model;
//#endif 


//#if 2046783393 
import org.argouml.uml.ui.UMLRadioButtonPanel;
//#endif 


//#if 1966109803 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 1626192202 
public class ActionSetOperationConcurrencyKind extends 
//#if 1943830983 
UndoableAction
//#endif 

  { 

//#if 1218822696 
private static final ActionSetOperationConcurrencyKind SINGLETON =
        new ActionSetOperationConcurrencyKind();
//#endif 


//#if 1170766021 
public static final String SEQUENTIAL_COMMAND = "sequential";
//#endif 


//#if -1284190747 
public static final String GUARDED_COMMAND = "guarded";
//#endif 


//#if -894411 
public static final String CONCURRENT_COMMAND = "concurrent";
//#endif 


//#if -151864942 
protected ActionSetOperationConcurrencyKind()
    { 

//#if -500520869 
super(Translator.localize("Set"), null);
//#endif 


//#if 1721719828 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 


//#if 1600641594 
public void actionPerformed(ActionEvent e)
    { 

//#if -304985483 
super.actionPerformed(e);
//#endif 


//#if 779358694 
if(e.getSource() instanceof JRadioButton)//1
{ 

//#if -1038413599 
JRadioButton source = (JRadioButton) e.getSource();
//#endif 


//#if 1714827311 
String actionCommand = source.getActionCommand();
//#endif 


//#if 189781507 
Object target = ((UMLRadioButtonPanel) source.getParent())
                            .getTarget();
//#endif 


//#if -891931289 
if(Model.getFacade().isAOperation(target))//1
{ 

//#if -1230823735 
Object m = /* (MModelElement) */target;
//#endif 


//#if -1827855403 
Object kind = null;
//#endif 


//#if 547034678 
if(actionCommand.equals(SEQUENTIAL_COMMAND))//1
{ 

//#if 2073377889 
kind = Model.getConcurrencyKind().getSequential();
//#endif 

} 
else

//#if -373972860 
if(actionCommand.equals(GUARDED_COMMAND))//1
{ 

//#if -241527924 
kind = Model.getConcurrencyKind().getGuarded();
//#endif 

} 
else
{ 

//#if -740715737 
kind = Model.getConcurrencyKind().getConcurrent();
//#endif 

} 

//#endif 


//#endif 


//#if 1292994722 
Model.getCoreHelper().setConcurrency(m, kind);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1692384502 
public static ActionSetOperationConcurrencyKind getInstance()
    { 

//#if -1371173096 
return SINGLETON;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

