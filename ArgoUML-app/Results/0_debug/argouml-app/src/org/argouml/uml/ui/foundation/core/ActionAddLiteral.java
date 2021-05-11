
//#if 1648226403 
// Compilation Unit of /ActionAddLiteral.java 
 

//#if -487716216 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -561562056 
import java.awt.event.ActionEvent;
//#endif 


//#if -184155218 
import javax.swing.Action;
//#endif 


//#if -1592806389 
import javax.swing.Icon;
//#endif 


//#if -1236354628 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1329565379 
import org.argouml.i18n.Translator;
//#endif 


//#if 511533699 
import org.argouml.model.Model;
//#endif 


//#if 1028561407 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 375971380 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if -847711223 
public class ActionAddLiteral extends 
//#if 94848113 
AbstractActionNewModelElement
//#endif 

  { 

//#if 1718759640 
public ActionAddLiteral()
    { 

//#if 1731489612 
super("button.new-enumeration-literal");
//#endif 


//#if -953972370 
putValue(Action.NAME, Translator.localize(
                     "button.new-enumeration-literal"));
//#endif 


//#if 19997093 
Icon icon = ResourceLoaderWrapper.lookupIcon("EnumerationLiteral");
//#endif 


//#if 1874193447 
putValue(Action.SMALL_ICON, icon);
//#endif 

} 

//#endif 


//#if -1933530045 
public void actionPerformed(ActionEvent e)
    { 

//#if 506269617 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 1700058726 
if(Model.getFacade().isAEnumerationLiteral(target))//1
{ 

//#if -1001106773 
target = Model.getFacade().getEnumeration(target);
//#endif 

} 

//#endif 


//#if -813397857 
if(Model.getFacade().isAClassifier(target))//1
{ 

//#if -830505873 
Object el =
                Model.getCoreFactory().buildEnumerationLiteral("", target);
//#endif 


//#if -1385803340 
TargetManager.getInstance().setTarget(el);
//#endif 


//#if 250573524 
super.actionPerformed(e);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

