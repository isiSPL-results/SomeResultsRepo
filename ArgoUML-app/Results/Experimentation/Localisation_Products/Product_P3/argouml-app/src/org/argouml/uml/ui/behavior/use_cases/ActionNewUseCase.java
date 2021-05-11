package org.argouml.uml.ui.behavior.use_cases;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.ui.AbstractActionNewModelElement;
public class ActionNewUseCase extends AbstractActionNewModelElement
  { 
public void actionPerformed(ActionEvent e)
    { 
Object target = TargetManager.getInstance().getModelTarget();
if(Model.getFacade().isAUseCase(target))//1
{ 
Object ns = Model.getFacade().getNamespace(target);
if(ns != null)//1
{ 
Object useCase = Model.getUseCasesFactory()
                                 .createUseCase();
Model.getCoreHelper().addOwnedElement(ns, useCase);
TargetManager.getInstance().setTarget(useCase);
super.actionPerformed(e);
} 
} 
} 
public ActionNewUseCase()
    { 
super("button.new-usecase");
putValue(Action.NAME, Translator.localize("button.new-usecase"));
} 

 } 
