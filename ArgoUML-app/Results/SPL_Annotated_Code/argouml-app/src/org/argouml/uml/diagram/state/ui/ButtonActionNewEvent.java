// Compilation Unit of /ButtonActionNewEvent.java 
 
package org.argouml.uml.diagram.state.ui;
import java.awt.event.ActionEvent;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.ui.targetmanager.TargetListener;
import org.argouml.ui.targetmanager.TargetManager;
import org.tigris.gef.undo.UndoableAction;
import org.tigris.toolbar.toolbutton.ModalAction;
abstract class ButtonActionNewEvent extends UndoableAction
 implements ModalAction
, TargetListener
  { 
protected abstract String getIconName();
public void targetSet(TargetEvent e)
    { 
setEnabled(isEnabled());
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

public void targetRemoved(TargetEvent e)
    { 
setEnabled(isEnabled());
} 

protected abstract String getKeyName();
public void targetAdded(TargetEvent e)
    { 
setEnabled(isEnabled());
} 

ButtonActionNewEvent()
    { 
super();
putValue(NAME, getKeyName());
putValue(SHORT_DESCRIPTION, Translator.localize(getKeyName()));
Object icon = ResourceLoaderWrapper.lookupIconResource(getIconName());
putValue(SMALL_ICON, icon);
TargetManager.getInstance().addTargetListener(this);
} 

public boolean isEnabled()
    { 
Object target = TargetManager.getInstance().getModelTarget();
return Model.getFacade().isATransition(target);
} 

protected abstract Object createEvent(Object ns);
 } 


