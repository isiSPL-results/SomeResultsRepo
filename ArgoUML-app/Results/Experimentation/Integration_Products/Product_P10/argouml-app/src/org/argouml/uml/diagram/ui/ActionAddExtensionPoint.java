package org.argouml.uml.diagram.ui;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.tigris.gef.undo.UndoableAction;
public final class ActionAddExtensionPoint extends UndoableAction
  { 
private static ActionAddExtensionPoint singleton;
public ActionAddExtensionPoint()
    { 
super(Translator.localize("button.new-extension-point"),
              ResourceLoaderWrapper.lookupIcon("button.new-extension-point"));
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("button.new-extension-point"));
} 
public boolean isEnabled()
    { 
Object target = TargetManager.getInstance().getModelTarget();
return super.isEnabled()
               && (Model.getFacade().isAUseCase(target));
} 
public static ActionAddExtensionPoint singleton()
    { 
if(singleton == null)//1
{ 
singleton = new ActionAddExtensionPoint();
} 
return singleton;
} 
public void actionPerformed(ActionEvent ae)
    { 
super.actionPerformed(ae);
Object         target = TargetManager.getInstance().getModelTarget();
if(!(Model.getFacade().isAUseCase(target)))//1
{ 
return;
} 
Object ep =
            Model.getUseCasesFactory()
            .buildExtensionPoint(target);
TargetManager.getInstance().setTarget(ep);
} 

 } 
