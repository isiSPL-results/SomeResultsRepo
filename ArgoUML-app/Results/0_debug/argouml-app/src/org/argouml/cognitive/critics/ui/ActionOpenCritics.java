
//#if 676195713 
// Compilation Unit of /ActionOpenCritics.java 
 

//#if 1347989378 
package org.argouml.cognitive.critics.ui;
//#endif 


//#if -2066378495 
import java.awt.event.ActionEvent;
//#endif 


//#if -2131480713 
import javax.swing.Action;
//#endif 


//#if -734234732 
import org.argouml.i18n.Translator;
//#endif 


//#if 862631056 
import org.argouml.ui.UndoableAction;
//#endif 


//#if -710852463 
public class ActionOpenCritics extends 
//#if 1598690041 
UndoableAction
//#endif 

  { 

//#if -149750751 
public void actionPerformed(ActionEvent ae)
    { 

//#if 1280138395 
super.actionPerformed(ae);
//#endif 


//#if 245024817 
CriticBrowserDialog dialog =
            new CriticBrowserDialog();
//#endif 


//#if 264695558 
dialog.setVisible(true);
//#endif 

} 

//#endif 


//#if 1935031538 
public ActionOpenCritics()
    { 

//#if 992934475 
super(Translator.localize("action.browse-critics"), null);
//#endif 


//#if -1892477660 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.browse-critics"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

