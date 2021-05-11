package org.argouml.ui.cmd;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.ui.ProjectBrowser;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.cognitive.Designer;
public class ActionNew extends AbstractAction
  { 
private static final long serialVersionUID = -3943153836514178100L;
public void actionPerformed(ActionEvent e)
    { 
Model.getPump().flushModelEvents();
Model.getPump().stopPumpingEvents();
Model.getPump().flushModelEvents();
Project p = ProjectManager.getManager().getCurrentProject();
if(getValue("non-interactive") == null)//1
{ 
if(!ProjectBrowser.getInstance().askConfirmationAndSave())//1
{ 
return;
} 
} 
ProjectBrowser.getInstance().clearDialogs();
Designer.disableCritiquing();
Designer.clearCritiquing();
TargetManager.getInstance().cleanHistory();
p.remove();
p = ProjectManager.getManager().makeEmptyProject();
TargetManager.getInstance().setTarget(p.getDiagramList().get(0));
Designer.enableCritiquing();
Model.getPump().startPumpingEvents();
} 
public ActionNew()
    { 
super(Translator.localize("action.new"),
              ResourceLoaderWrapper.lookupIcon("action.new"));
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.new"));
} 

 } 
