// Compilation Unit of /ButtonActionNewGuard.java 
 
package org.argouml.uml.ui.behavior.state_machines;
import java.awt.event.ActionEvent;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.kernel.UmlModelMutator;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.tigris.gef.undo.UndoableAction;
import org.tigris.toolbar.toolbutton.ModalAction;
@UmlModelMutator
public class ButtonActionNewGuard extends UndoableAction
 implements ModalAction
  { 
public ButtonActionNewGuard()
    { 
super();
putValue(NAME, getKeyName());
putValue(SHORT_DESCRIPTION, Translator.localize(getKeyName()));
Object icon = ResourceLoaderWrapper.lookupIconResource(getIconName());
putValue(SMALL_ICON, icon);
} 

protected String getIconName()
    { 
return "Guard";
} 

public boolean isEnabled()
    { 
Object target = TargetManager.getInstance().getModelTarget();
return Model.getFacade().isATransition(target);
} 

public void actionPerformed(ActionEvent e)
    { 
if(!isEnabled())//1
{ 
return;
} 

super.actionPerformed(e);
Object target = TargetManager.getInstance().getModelTarget();
Object guard = Model.getFacade().getGuard(target);
if(guard == null)//1
{ 
guard = Model.getStateMachinesFactory().buildGuard(target);
} 

TargetManager.getInstance().setTarget(guard);
} 

protected String getKeyName()
    { 
return "button.new-guard";
} 

 } 


