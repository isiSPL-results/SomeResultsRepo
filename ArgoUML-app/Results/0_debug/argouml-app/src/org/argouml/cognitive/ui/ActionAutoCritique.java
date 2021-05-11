
//#if 1469658785 
// Compilation Unit of /ActionAutoCritique.java 
 

//#if 1846786641 
package org.argouml.cognitive.ui;
//#endif 


//#if -1121344479 
import java.awt.event.ActionEvent;
//#endif 


//#if 1201496727 
import javax.swing.Action;
//#endif 


//#if 244658457 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1502951308 
import org.argouml.i18n.Translator;
//#endif 


//#if 860376432 
import org.argouml.ui.UndoableAction;
//#endif 


//#if 1517562949 
public class ActionAutoCritique extends 
//#if 355649771 
UndoableAction
//#endif 

  { 

//#if -1642635643 
private static final long serialVersionUID = 9057306108717070004L;
//#endif 


//#if -2075045832 
public ActionAutoCritique()
    { 

//#if 871487931 
super(Translator.localize("action.toggle-auto-critique"),
              null);
//#endif 


//#if -471864268 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.toggle-auto-critique"));
//#endif 


//#if -151478126 
putValue("SELECTED",
                 Boolean.valueOf(Designer.theDesigner().getAutoCritique()));
//#endif 

} 

//#endif 


//#if 443893651 
public void actionPerformed(ActionEvent ae)
    { 

//#if 991572691 
super.actionPerformed(ae);
//#endif 


//#if -1154721711 
Designer d = Designer.theDesigner();
//#endif 


//#if 218724228 
boolean b = d.getAutoCritique();
//#endif 


//#if 1822104430 
d.setAutoCritique(!b);
//#endif 


//#if 642118340 
Designer.theDesigner().getToDoList().setPaused(
            !Designer.theDesigner().getToDoList().isPaused());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

