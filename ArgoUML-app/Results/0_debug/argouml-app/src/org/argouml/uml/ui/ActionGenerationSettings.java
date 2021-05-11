
//#if 977001415 
// Compilation Unit of /ActionGenerationSettings.java 
 

//#if -1620698870 
package org.argouml.uml.ui;
//#endif 


//#if -1944241790 
import java.awt.event.ActionEvent;
//#endif 


//#if 831056120 
import javax.swing.Action;
//#endif 


//#if -1242964173 
import org.argouml.i18n.Translator;
//#endif 


//#if 848293816 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 1199996230 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if -2080317928 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -1170107808 
public class ActionGenerationSettings extends 
//#if 761568546 
UndoableAction
//#endif 

  { 

//#if 150916634 
@Override
    public void actionPerformed(ActionEvent ae)
    { 

//#if -1988318558 
super.actionPerformed(ae);
//#endif 


//#if 675791410 
SourcePathDialog cgd = new SourcePathDialog();
//#endif 


//#if -1700310673 
cgd.setVisible(true);
//#endif 

} 

//#endif 


//#if -361475209 
@Override
    public boolean isEnabled()
    { 

//#if 731326497 
return true;
//#endif 

} 

//#endif 


//#if -1533540951 
public ActionGenerationSettings()
    { 

//#if 673245580 
super(Translator
              .localize("action.settings-for-project-code-generation"), null);
//#endif 


//#if -1536694845 
putValue(Action.SHORT_DESCRIPTION, Translator
                 .localize("action.settings-for-project-code-generation"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

