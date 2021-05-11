// Compilation Unit of /ActionOpenCritics.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.critics.ui;
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
public class ActionOpenCritics extends UndoableAction
  { 
public void actionPerformed(ActionEvent ae)
    { 
super.actionPerformed(ae);
CriticBrowserDialog dialog =
            new CriticBrowserDialog();
dialog.setVisible(true);
} 

public ActionOpenCritics()
    { 
super(Translator.localize("action.browse-critics"), null);
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.browse-critics"));
} 

 } 

//#endif 


