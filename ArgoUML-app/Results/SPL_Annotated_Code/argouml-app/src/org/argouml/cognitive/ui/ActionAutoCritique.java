// Compilation Unit of /ActionAutoCritique.java 
 

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
import org.argouml.cognitive.Designer;
//#endif 


//#if COGNITIVE 
import org.argouml.i18n.Translator;
//#endif 


//#if COGNITIVE 
import org.argouml.ui.UndoableAction;
//#endif 


//#if COGNITIVE 
public class ActionAutoCritique extends UndoableAction
  { 
private static final long serialVersionUID = 9057306108717070004L;
public ActionAutoCritique()
    { 
super(Translator.localize("action.toggle-auto-critique"),
              null);
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.toggle-auto-critique"));
putValue("SELECTED",
                 Boolean.valueOf(Designer.theDesigner().getAutoCritique()));
} 

public void actionPerformed(ActionEvent ae)
    { 
super.actionPerformed(ae);
Designer d = Designer.theDesigner();
boolean b = d.getAutoCritique();
d.setAutoCritique(!b);
Designer.theDesigner().getToDoList().setPaused(
            !Designer.theDesigner().getToDoList().isPaused());
} 

 } 

//#endif 


