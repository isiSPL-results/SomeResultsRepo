
//#if -329382428 
// Compilation Unit of /ActionNew.java 
 

//#if 1117909714 
package org.argouml.ui.cmd;
//#endif 


//#if 852568008 
import java.awt.event.ActionEvent;
//#endif 


//#if -1392012868 
import javax.swing.AbstractAction;
//#endif 


//#if 509246782 
import javax.swing.Action;
//#endif 


//#if -1313909204 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -441206355 
import org.argouml.i18n.Translator;
//#endif 


//#if -1005057225 
import org.argouml.kernel.Project;
//#endif 


//#if 159656914 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 432431859 
import org.argouml.model.Model;
//#endif 


//#if -1906200050 
import org.argouml.ui.ProjectBrowser;
//#endif 


//#if -634166385 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1745581760 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1490266315 
public class ActionNew extends 
//#if -296190236 
AbstractAction
//#endif 

  { 

//#if 580469612 
private static final long serialVersionUID = -3943153836514178100L;
//#endif 


//#if -999360479 
public void actionPerformed(ActionEvent e)
    { 

//#if -1940878809 
Model.getPump().flushModelEvents();
//#endif 


//#if 1223559742 
Model.getPump().stopPumpingEvents();
//#endif 


//#if -1870813493 
Model.getPump().flushModelEvents();
//#endif 


//#if -1338554171 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 34939993 
if(getValue("non-interactive") == null)//1
{ 

//#if -854943488 
if(!ProjectBrowser.getInstance().askConfirmationAndSave())//1
{ 

//#if 1251533891 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -647702724 
ProjectBrowser.getInstance().clearDialogs();
//#endif 


//#if 554313253 
Designer.disableCritiquing();
//#endif 


//#if 1827444576 
Designer.clearCritiquing();
//#endif 


//#if -599257382 
TargetManager.getInstance().cleanHistory();
//#endif 


//#if 184258839 
p.remove();
//#endif 


//#if 833937174 
p = ProjectManager.getManager().makeEmptyProject();
//#endif 


//#if -436999129 
TargetManager.getInstance().setTarget(p.getDiagramList().get(0));
//#endif 


//#if -1644692698 
Designer.enableCritiquing();
//#endif 


//#if -2020975212 
Model.getPump().startPumpingEvents();
//#endif 

} 

//#endif 


//#if -1216350570 
public ActionNew()
    { 

//#if -74023042 
super(Translator.localize("action.new"),
              ResourceLoaderWrapper.lookupIcon("action.new"));
//#endif 


//#if -249650126 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.new"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

