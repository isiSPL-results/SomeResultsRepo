// Compilation Unit of /ActionOpenDecisions.java 
 

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
public class ActionOpenDecisions extends UndoableAction
  { 
public void actionPerformed(ActionEvent ae)
    { 
super.actionPerformed(ae);
DesignIssuesDialog d = new DesignIssuesDialog();
d.setVisible(true);
} 

public ActionOpenDecisions()
    { 
super(Translator.localize("action.design-issues"), null);
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.design-issues"));
} 

 } 

//#endif 


