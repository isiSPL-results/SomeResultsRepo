
//#if 896288423 
// Compilation Unit of /ButtonActionNewEvent.java 
 

//#if -128526070 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if 1503739146 
import java.awt.event.ActionEvent;
//#endif 


//#if 73271210 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1729737557 
import org.argouml.i18n.Translator;
//#endif 


//#if -1228528399 
import org.argouml.model.Model;
//#endif 


//#if 344783940 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if 942266308 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if 470070481 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 523032992 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 1149318348 
import org.tigris.toolbar.toolbutton.ModalAction;
//#endif 


//#if -1369312096 
abstract class ButtonActionNewEvent extends 
//#if 668099263 
UndoableAction
//#endif 

 implements 
//#if -72375176 
ModalAction
//#endif 

, 
//#if 1501740048 
TargetListener
//#endif 

  { 

//#if -40754555 
protected abstract String getIconName();
//#endif 


//#if 2073770286 
public void targetSet(TargetEvent e)
    { 

//#if -644902581 
setEnabled(isEnabled());
//#endif 

} 

//#endif 


//#if -1940488126 
public void actionPerformed(ActionEvent e)
    { 

//#if -133249794 
if(!isEnabled())//1
{ 

//#if 1099324285 
return;
//#endif 

} 

//#endif 


//#if -358491782 
super.actionPerformed(e);
//#endif 


//#if 1339529377 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if -1864847305 
Object model = Model.getFacade().getModel(target);
//#endif 


//#if 1418552987 
Object ns = Model.getStateMachinesHelper()
                    .findNamespaceForEvent(target, model);
//#endif 


//#if 264038927 
Object event = createEvent(ns);
//#endif 


//#if 431621618 
Model.getStateMachinesHelper().setEventAsTrigger(target, event);
//#endif 


//#if -165193353 
TargetManager.getInstance().setTarget(event);
//#endif 

} 

//#endif 


//#if 1037989164 
public void targetRemoved(TargetEvent e)
    { 

//#if 660283032 
setEnabled(isEnabled());
//#endif 

} 

//#endif 


//#if -328096725 
protected abstract String getKeyName();
//#endif 


//#if -19393652 
public void targetAdded(TargetEvent e)
    { 

//#if 753520546 
setEnabled(isEnabled());
//#endif 

} 

//#endif 


//#if -771370706 
ButtonActionNewEvent()
    { 

//#if -2005589993 
super();
//#endif 


//#if -1376463334 
putValue(NAME, getKeyName());
//#endif 


//#if -1607413478 
putValue(SHORT_DESCRIPTION, Translator.localize(getKeyName()));
//#endif 


//#if -731293969 
Object icon = ResourceLoaderWrapper.lookupIconResource(getIconName());
//#endif 


//#if 1421579448 
putValue(SMALL_ICON, icon);
//#endif 


//#if 678691390 
TargetManager.getInstance().addTargetListener(this);
//#endif 

} 

//#endif 


//#if -1204863036 
public boolean isEnabled()
    { 

//#if 1585500869 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 240774113 
return Model.getFacade().isATransition(target);
//#endif 

} 

//#endif 


//#if 887579927 
protected abstract Object createEvent(Object ns);
//#endif 

 } 

//#endif 


//#endif 

