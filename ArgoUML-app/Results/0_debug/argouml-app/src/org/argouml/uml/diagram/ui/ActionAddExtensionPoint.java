
//#if -682874644 
// Compilation Unit of /ActionAddExtensionPoint.java 
 

//#if -858814989 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -1482493570 
import java.awt.event.ActionEvent;
//#endif 


//#if 383016180 
import javax.swing.Action;
//#endif 


//#if 363014838 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 186328759 
import org.argouml.i18n.Translator;
//#endif 


//#if 1144120573 
import org.argouml.model.Model;
//#endif 


//#if 1159135557 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 691853844 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -532362771 
public final class ActionAddExtensionPoint extends 
//#if 1484658173 
UndoableAction
//#endif 

  { 

//#if 1534205092 
private static ActionAddExtensionPoint singleton;
//#endif 


//#if -235151125 
public ActionAddExtensionPoint()
    { 

//#if 56826595 
super(Translator.localize("button.new-extension-point"),
              ResourceLoaderWrapper.lookupIcon("button.new-extension-point"));
//#endif 


//#if -2055750658 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("button.new-extension-point"));
//#endif 

} 

//#endif 


//#if 1199209858 
public boolean isEnabled()
    { 

//#if -1126061545 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 1976839129 
return super.isEnabled()
               && (Model.getFacade().isAUseCase(target));
//#endif 

} 

//#endif 


//#if -1929545968 
public static ActionAddExtensionPoint singleton()
    { 

//#if -268753439 
if(singleton == null)//1
{ 

//#if -105156278 
singleton = new ActionAddExtensionPoint();
//#endif 

} 

//#endif 


//#if 1417732402 
return singleton;
//#endif 

} 

//#endif 


//#if -272793051 
public void actionPerformed(ActionEvent ae)
    { 

//#if 141505581 
super.actionPerformed(ae);
//#endif 


//#if 322273595 
Object         target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if -1355276269 
if(!(Model.getFacade().isAUseCase(target)))//1
{ 

//#if -200702323 
return;
//#endif 

} 

//#endif 


//#if -2031314737 
Object ep =
            Model.getUseCasesFactory()
            .buildExtensionPoint(target);
//#endif 


//#if -1072973972 
TargetManager.getInstance().setTarget(ep);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

