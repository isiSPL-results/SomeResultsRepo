
//#if -805780336 
// Compilation Unit of /ActionSetSynch.java 
 

//#if 1736204238 
package org.argouml.uml.ui.behavior.activity_graphs;
//#endif 


//#if 1461800203 
import java.awt.event.ActionEvent;
//#endif 


//#if 2035914113 
import javax.swing.Action;
//#endif 


//#if 1265122506 
import org.argouml.i18n.Translator;
//#endif 


//#if 751500432 
import org.argouml.model.Model;
//#endif 


//#if -383419431 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if 2011256993 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 645110201 
public class ActionSetSynch extends 
//#if -407868338 
UndoableAction
//#endif 

  { 

//#if 279202315 
private static final ActionSetSynch SINGLETON =
        new ActionSetSynch();
//#endif 


//#if -414081418 
protected ActionSetSynch()
    { 

//#if -1911537462 
super(Translator.localize("action.set"), null);
//#endif 


//#if -662491371 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.set"));
//#endif 

} 

//#endif 


//#if -986013638 
public static ActionSetSynch getInstance()
    { 

//#if -164319521 
return SINGLETON;
//#endif 

} 

//#endif 


//#if 1854539155 
public void actionPerformed(ActionEvent e)
    { 

//#if 26724821 
super.actionPerformed(e);
//#endif 


//#if -791273282 
if(e.getSource() instanceof UMLCheckBox2)//1
{ 

//#if 734352204 
UMLCheckBox2 source = (UMLCheckBox2) e.getSource();
//#endif 


//#if -32977940 
Object target = source.getTarget();
//#endif 


//#if -2010579617 
if(Model.getFacade().isAObjectFlowState(target))//1
{ 

//#if 1030956758 
Object m = target;
//#endif 


//#if -771384594 
Model.getActivityGraphsHelper().setSynch(
                    m,
                    source.isSelected());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

