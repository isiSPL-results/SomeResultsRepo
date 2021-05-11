
//#if 393638194 
// Compilation Unit of /ButtonActionNewEffect.java 
 

//#if -1953292080 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if 486770692 
import java.awt.event.ActionEvent;
//#endif 


//#if -872501136 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1103978737 
import org.argouml.i18n.Translator;
//#endif 


//#if -1304540105 
import org.argouml.model.Model;
//#endif 


//#if -1149908021 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -210138470 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -2089527662 
import org.tigris.toolbar.toolbutton.ModalAction;
//#endif 


//#if -975008623 
abstract class ButtonActionNewEffect extends 
//#if -824089027 
UndoableAction
//#endif 

 implements 
//#if 1125482938 
ModalAction
//#endif 

  { 

//#if 1539595117 
protected abstract String getKeyName();
//#endif 


//#if 822545688 
public ButtonActionNewEffect()
    { 

//#if 1673732146 
super();
//#endif 


//#if 711244469 
putValue(NAME, getKeyName());
//#endif 


//#if -1864118539 
putValue(SHORT_DESCRIPTION, Translator.localize(getKeyName()));
//#endif 


//#if -1295922700 
Object icon = ResourceLoaderWrapper.lookupIconResource(getIconName());
//#endif 


//#if -377363437 
putValue(SMALL_ICON, icon);
//#endif 

} 

//#endif 


//#if 420988548 
public void actionPerformed(ActionEvent e)
    { 

//#if -1880129123 
if(!isEnabled())//1
{ 

//#if 1195102605 
return;
//#endif 

} 

//#endif 


//#if 151282393 
super.actionPerformed(e);
//#endif 


//#if -1267468510 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if -316254122 
Object model = Model.getFacade().getModel(target);
//#endif 


//#if 2095679196 
Object ns = Model.getStateMachinesHelper()
                    .findNamespaceForEvent(target, model);
//#endif 


//#if -57872304 
Object event = createEvent(ns);
//#endif 


//#if 2051641361 
Model.getStateMachinesHelper().setEventAsTrigger(target, event);
//#endif 


//#if -1750172330 
TargetManager.getInstance().setTarget(event);
//#endif 

} 

//#endif 


//#if 1554102293 
protected abstract Object createEvent(Object ns);
//#endif 


//#if 254180802 
public boolean isEnabled()
    { 

//#if 706070991 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 749838827 
return Model.getFacade().isATransition(target);
//#endif 

} 

//#endif 


//#if 2023117699 
protected abstract String getIconName();
//#endif 

 } 

//#endif 


//#endif 

