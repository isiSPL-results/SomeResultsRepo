// Compilation Unit of /ActionNewActor.java 
 
package org.argouml.uml.ui.behavior.use_cases;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import org.argouml.i18n.Translator;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.ui.AbstractActionNewModelElement;
public class ActionNewActor extends AbstractActionNewModelElement
  { 
public ActionNewActor()
    { 
super("button.new-actor");
putValue(Action.NAME, Translator.localize("button.new-actor"));
} 

public void actionPerformed(ActionEvent e)
    { 
Object target = TargetManager.getInstance().getModelTarget();
if(Model.getFacade().isAActor(target))//1
{ 
Object model =
                ProjectManager.getManager().getCurrentProject().getModel();
TargetManager.getInstance().setTarget(
                Model.getUseCasesFactory().buildActor(target, model));
super.actionPerformed(e);
} 

} 

 } 


