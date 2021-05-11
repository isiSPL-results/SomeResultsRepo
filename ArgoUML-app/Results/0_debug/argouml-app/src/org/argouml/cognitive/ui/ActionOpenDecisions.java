
//#if -383913877 
// Compilation Unit of /ActionOpenDecisions.java 
 

//#if 1905898158 
package org.argouml.cognitive.ui;
//#endif 


//#if 711112548 
import java.awt.event.ActionEvent;
//#endif 


//#if 1649633498 
import javax.swing.Action;
//#endif 


//#if -531358319 
import org.argouml.i18n.Translator;
//#endif 


//#if -1741631667 
import org.argouml.ui.UndoableAction;
//#endif 


//#if -4610522 
public class ActionOpenDecisions extends 
//#if 471791771 
UndoableAction
//#endif 

  { 

//#if 1546664771 
public void actionPerformed(ActionEvent ae)
    { 

//#if -179017889 
super.actionPerformed(ae);
//#endif 


//#if 1313979211 
DesignIssuesDialog d = new DesignIssuesDialog();
//#endif 


//#if 1739502454 
d.setVisible(true);
//#endif 

} 

//#endif 


//#if 1579284904 
public ActionOpenDecisions()
    { 

//#if 339828762 
super(Translator.localize("action.design-issues"), null);
//#endif 


//#if -122944443 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.design-issues"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

