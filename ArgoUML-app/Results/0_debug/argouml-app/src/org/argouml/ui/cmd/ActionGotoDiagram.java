
//#if 1675696492 
// Compilation Unit of /ActionGotoDiagram.java 
 

//#if 1885732245 
package org.argouml.ui.cmd;
//#endif 


//#if -1395455067 
import java.awt.event.ActionEvent;
//#endif 


//#if 811109915 
import javax.swing.Action;
//#endif 


//#if 1635016368 
import org.argouml.application.api.CommandLineInterface;
//#endif 


//#if -1410444944 
import org.argouml.i18n.Translator;
//#endif 


//#if 1041886996 
import org.argouml.kernel.Project;
//#endif 


//#if -728717995 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1797075883 
import org.argouml.ui.GotoDialog;
//#endif 


//#if 1957948780 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1303325451 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -2011177669 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 139161736 
public class ActionGotoDiagram extends 
//#if -489924807 
UndoableAction
//#endif 

 implements 
//#if -1863984769 
CommandLineInterface
//#endif 

  { 

//#if -138374567 
public boolean doCommand(String argument)
    { 

//#if 546550078 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 1081081937 
ArgoDiagram d = p.getDiagram(argument);
//#endif 


//#if -1225034836 
if(d != null)//1
{ 

//#if -7306243 
TargetManager.getInstance().setTarget(d);
//#endif 


//#if 246563597 
return true;
//#endif 

} 

//#endif 


//#if 1609792176 
return false;
//#endif 

} 

//#endif 


//#if 416051297 
public void actionPerformed(ActionEvent ae)
    { 

//#if -342236308 
super.actionPerformed(ae);
//#endif 


//#if -650938639 
new GotoDialog().setVisible(true);
//#endif 

} 

//#endif 


//#if -1991788787 
public ActionGotoDiagram()
    { 

//#if 1068895864 
super(Translator.localize("action.goto-diagram"), null);
//#endif 


//#if 975923671 
putValue(Action.SHORT_DESCRIPTION, Translator
                 .localize("action.goto-diagram"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

