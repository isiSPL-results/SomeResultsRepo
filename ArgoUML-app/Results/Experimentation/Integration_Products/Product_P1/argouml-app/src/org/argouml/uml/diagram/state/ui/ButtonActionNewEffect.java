package org.argouml.uml.diagram.state.ui;
import java.awt.event.ActionEvent;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.tigris.gef.undo.UndoableAction;
import org.tigris.toolbar.toolbutton.ModalAction;
abstract class ButtonActionNewEffect extends UndoableAction
 implements ModalAction
  { 
protected abstract String getKeyName();public ButtonActionNewEffect()
    { 
super();
putValue(NAME, getKeyName());
putValue(SHORT_DESCRIPTION, Translator.localize(getKeyName()));
Object icon = ResourceLoaderWrapper.lookupIconResource(getIconName());
putValue(SMALL_ICON, icon);
} 
public void actionPerformed(ActionEvent e)
    { 
if(!isEnabled())//1
{ 
return;
} 
super.actionPerformed(e);
Object target = TargetManager.getInstance().getModelTarget();
Object model = Model.getFacade().getModel(target);
Object ns = Model.getStateMachinesHelper()
                    .findNamespaceForEvent(target, model);
Object event = createEvent(ns);
Model.getStateMachinesHelper().setEventAsTrigger(target, event);
TargetManager.getInstance().setTarget(event);
} 
protected abstract Object createEvent(Object ns);public boolean isEnabled()
    { 
Object target = TargetManager.getInstance().getModelTarget();
return Model.getFacade().isATransition(target);
} 
protected abstract String getIconName();
 } 
