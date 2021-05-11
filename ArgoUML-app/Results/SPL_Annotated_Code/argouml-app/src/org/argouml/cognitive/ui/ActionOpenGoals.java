// Compilation Unit of /ActionOpenGoals.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.ui;
//#endif 


//#if COGNITIVE 
import java.awt.event.ActionEvent;
//#endif 


//#if COGNITIVE 
import javax.swing.Action;
//#endif 


//#if COGNITIVE 
import org.argouml.i18n.Translator;
//#endif 


//#if COGNITIVE 
import org.argouml.ui.UndoableAction;
//#endif 


//#if COGNITIVE 
public class ActionOpenGoals extends UndoableAction
  { 
public ActionOpenGoals()
    { 
super(Translator.localize("action.design-goals"), null);
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.design-goals"));
} 

public void actionPerformed(ActionEvent ae)
    { 
super.actionPerformed(ae);
GoalsDialog d = new GoalsDialog();
d.setVisible(true);
} 

 } 

//#endif 


