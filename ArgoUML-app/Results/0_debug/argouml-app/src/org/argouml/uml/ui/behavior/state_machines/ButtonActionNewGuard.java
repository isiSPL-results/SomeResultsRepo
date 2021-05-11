
//#if 442764488 
// Compilation Unit of /ButtonActionNewGuard.java 
 

//#if -1222436845 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -1763217871 
import java.awt.event.ActionEvent;
//#endif 


//#if 1570330147 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 73810020 
import org.argouml.i18n.Translator;
//#endif 


//#if -1840927092 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if 2050940202 
import org.argouml.model.Model;
//#endif 


//#if -626411528 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1713304519 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 1529589957 
import org.tigris.toolbar.toolbutton.ModalAction;
//#endif 


//#if 2065585451 

//#if 2111389352 
@UmlModelMutator
//#endif 

public class ButtonActionNewGuard extends 
//#if -1911114929 
UndoableAction
//#endif 

 implements 
//#if 443522536 
ModalAction
//#endif 

  { 

//#if -260524942 
public ButtonActionNewGuard()
    { 

//#if 994623224 
super();
//#endif 


//#if 859650683 
putValue(NAME, getKeyName());
//#endif 


//#if 1988156731 
putValue(SHORT_DESCRIPTION, Translator.localize(getKeyName()));
//#endif 


//#if 579909486 
Object icon = ResourceLoaderWrapper.lookupIconResource(getIconName());
//#endif 


//#if 65248601 
putValue(SMALL_ICON, icon);
//#endif 

} 

//#endif 


//#if -1125917833 
protected String getIconName()
    { 

//#if -374710789 
return "Guard";
//#endif 

} 

//#endif 


//#if 1374952532 
public boolean isEnabled()
    { 

//#if -1344749371 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 564582881 
return Model.getFacade().isATransition(target);
//#endif 

} 

//#endif 


//#if -288689742 
public void actionPerformed(ActionEvent e)
    { 

//#if -444905343 
if(!isEnabled())//1
{ 

//#if 781046879 
return;
//#endif 

} 

//#endif 


//#if -114266435 
super.actionPerformed(e);
//#endif 


//#if 1199568830 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 1142144698 
Object guard = Model.getFacade().getGuard(target);
//#endif 


//#if 144622610 
if(guard == null)//1
{ 

//#if -1511969967 
guard = Model.getStateMachinesFactory().buildGuard(target);
//#endif 

} 

//#endif 


//#if -326990715 
TargetManager.getInstance().setTarget(guard);
//#endif 

} 

//#endif 


//#if 745276665 
protected String getKeyName()
    { 

//#if -1780112272 
return "button.new-guard";
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

