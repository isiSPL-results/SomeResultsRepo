// Compilation Unit of /ActionNewExtensionPoint.java 
 
package org.argouml.uml.ui.behavior.use_cases;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.ui.AbstractActionNewModelElement;
class ActionNewExtensionPoint extends AbstractActionNewModelElement
  { 
private static final long serialVersionUID = 1556105736769814764L;
public ActionNewExtensionPoint()
    { 
super("button.new-extension-point");
putValue(Action.NAME,
                 Translator.localize("button.new-extension-point"));
} 

public void actionPerformed(ActionEvent e)
    { 
Object target = TargetManager.getInstance().getModelTarget();
if(Model.getFacade().isAUseCase(target))//1
{ 
TargetManager.getInstance().setTarget(
                Model.getUseCasesFactory().buildExtensionPoint(target));
super.actionPerformed(e);
} 

} 

 } 


