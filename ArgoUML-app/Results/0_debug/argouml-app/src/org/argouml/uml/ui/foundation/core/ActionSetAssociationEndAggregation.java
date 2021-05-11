
//#if -452713720 
// Compilation Unit of /ActionSetAssociationEndAggregation.java 
 

//#if -1108305954 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -2140260318 
import java.awt.event.ActionEvent;
//#endif 


//#if 1469220760 
import javax.swing.Action;
//#endif 


//#if -264405781 
import javax.swing.JRadioButton;
//#endif 


//#if 1270396051 
import org.argouml.i18n.Translator;
//#endif 


//#if -1919368999 
import org.argouml.model.Model;
//#endif 


//#if -2136913554 
import org.argouml.uml.ui.UMLRadioButtonPanel;
//#endif 


//#if -1187431240 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 73012491 
public class ActionSetAssociationEndAggregation extends 
//#if -326118357 
UndoableAction
//#endif 

  { 

//#if -1054982712 
private static final ActionSetAssociationEndAggregation SINGLETON =
        new ActionSetAssociationEndAggregation();
//#endif 


//#if 893497825 
public static final String AGGREGATE_COMMAND = "aggregate";
//#endif 


//#if 1946283233 
public static final String COMPOSITE_COMMAND = "composite";
//#endif 


//#if 1725641875 
public static final String NONE_COMMAND = "none";
//#endif 


//#if 1536770134 
public void actionPerformed(ActionEvent e)
    { 

//#if -1348074314 
super.actionPerformed(e);
//#endif 


//#if -732560955 
if(e.getSource() instanceof JRadioButton)//1
{ 

//#if 2087497582 
JRadioButton source = (JRadioButton) e.getSource();
//#endif 


//#if 153095170 
String actionCommand = source.getActionCommand();
//#endif 


//#if -890917872 
Object target = ((UMLRadioButtonPanel) source.getParent())
                            .getTarget();
//#endif 


//#if -1037466467 
if(Model.getFacade().isAAssociationEnd(target))//1
{ 

//#if 1092646905 
Object m = target;
//#endif 


//#if 1266898764 
Object kind = null;
//#endif 


//#if -1789655891 
if(actionCommand.equals(AGGREGATE_COMMAND))//1
{ 

//#if -565150199 
kind = Model.getAggregationKind().getAggregate();
//#endif 

} 
else

//#if 197891537 
if(actionCommand.equals(COMPOSITE_COMMAND))//1
{ 

//#if -901050521 
kind = Model.getAggregationKind().getComposite();
//#endif 

} 
else
{ 

//#if 433486165 
kind = Model.getAggregationKind().getNone();
//#endif 

} 

//#endif 


//#endif 


//#if -575672804 
Model.getCoreHelper().setAggregation(m, kind);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1941053218 
public static ActionSetAssociationEndAggregation getInstance()
    { 

//#if -1484016131 
return SINGLETON;
//#endif 

} 

//#endif 


//#if -2146935564 
protected ActionSetAssociationEndAggregation()
    { 

//#if -91364877 
super(Translator.localize("action.set"), null);
//#endif 


//#if 109072332 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.set"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

