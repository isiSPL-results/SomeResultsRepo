
//#if 1949935612 
// Compilation Unit of /ActionOpenGoals.java 
 

//#if -1834687303 
package org.argouml.cognitive.ui;
//#endif 


//#if 717080249 
import java.awt.event.ActionEvent;
//#endif 


//#if -1217815249 
import javax.swing.Action;
//#endif 


//#if -346359588 
import org.argouml.i18n.Translator;
//#endif 


//#if -51510312 
import org.argouml.ui.UndoableAction;
//#endif 


//#if 1667298202 
public class ActionOpenGoals extends 
//#if 496600285 
UndoableAction
//#endif 

  { 

//#if -6024945 
public ActionOpenGoals()
    { 

//#if -1589323502 
super(Translator.localize("action.design-goals"), null);
//#endif 


//#if -1261310467 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.design-goals"));
//#endif 

} 

//#endif 


//#if 892999941 
public void actionPerformed(ActionEvent ae)
    { 

//#if -1018939141 
super.actionPerformed(ae);
//#endif 


//#if 1235586949 
GoalsDialog d = new GoalsDialog();
//#endif 


//#if -384091814 
d.setVisible(true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

