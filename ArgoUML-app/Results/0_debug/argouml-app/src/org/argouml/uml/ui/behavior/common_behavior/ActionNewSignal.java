
//#if -497783979 
// Compilation Unit of /ActionNewSignal.java 
 

//#if 1005184006 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 547288436 
import java.awt.event.ActionEvent;
//#endif 


//#if 225883882 
import javax.swing.Action;
//#endif 


//#if 1464600135 
import javax.swing.Icon;
//#endif 


//#if -1155900160 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1314938495 
import org.argouml.i18n.Translator;
//#endif 


//#if -1511566137 
import org.argouml.model.Model;
//#endif 


//#if -957851333 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1970094192 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if 1342091793 
public class ActionNewSignal extends 
//#if 1378980946 
AbstractActionNewModelElement
//#endif 

  { 

//#if -1527425308 
public void actionPerformed(ActionEvent e)
    { 

//#if 190882883 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 1685891775 
if(Model.getFacade().isASignalEvent(target)
                || Model.getFacade().isASendAction(target)
                || Model.getFacade().isAReception(target)
                || Model.getFacade().isABehavioralFeature(target))//1
{ 

//#if 749606077 
Object newSig =
                Model.getCommonBehaviorFactory().buildSignal(target);
//#endif 


//#if -22493456 
TargetManager.getInstance().setTarget(newSig);
//#endif 

} 
else
{ 

//#if 1012216347 
Object ns = null;
//#endif 


//#if -2115013879 
if(Model.getFacade().isANamespace(target))//1
{ 

//#if 592643826 
ns = target;
//#endif 

} 
else
{ 

//#if -625524770 
ns = Model.getFacade().getNamespace(target);
//#endif 

} 

//#endif 


//#if -663215577 
Object newElement = Model.getCommonBehaviorFactory().createSignal();
//#endif 


//#if -644461065 
TargetManager.getInstance().setTarget(newElement);
//#endif 


//#if 150819431 
Model.getCoreHelper().setNamespace(newElement, ns);
//#endif 

} 

//#endif 


//#if -1974482536 
super.actionPerformed(e);
//#endif 

} 

//#endif 


//#if 1587593313 
public ActionNewSignal()
    { 

//#if 712543850 
super("button.new-signal");
//#endif 


//#if -1630463628 
putValue(Action.NAME, Translator.localize("button.new-signal"));
//#endif 


//#if -1207064760 
Icon icon = ResourceLoaderWrapper.lookupIcon("SignalSending");
//#endif 


//#if 2093729286 
putValue(Action.SMALL_ICON, icon);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

