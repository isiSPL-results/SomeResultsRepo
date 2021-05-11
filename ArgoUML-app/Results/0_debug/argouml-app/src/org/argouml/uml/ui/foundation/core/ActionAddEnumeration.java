
//#if -182564440 
// Compilation Unit of /ActionAddEnumeration.java 
 

//#if 260556121 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -380246969 
import java.awt.event.ActionEvent;
//#endif 


//#if -1127798595 
import javax.swing.Action;
//#endif 


//#if 967102682 
import javax.swing.Icon;
//#endif 


//#if 29868621 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -3764978 
import org.argouml.i18n.Translator;
//#endif 


//#if 1145310932 
import org.argouml.model.Model;
//#endif 


//#if -872070642 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1962868483 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if 1188396656 
public class ActionAddEnumeration extends 
//#if 1738180756 
AbstractActionNewModelElement
//#endif 

  { 

//#if -1406956563 
public ActionAddEnumeration()
    { 

//#if 1058763342 
super("button.new-enumeration");
//#endif 


//#if 1740045164 
putValue(Action.NAME, Translator.localize("button.new-enumeration"));
//#endif 


//#if -1696980172 
Icon icon = ResourceLoaderWrapper.lookupIcon("Enumeration");
//#endif 


//#if 1403291207 
putValue(Action.SMALL_ICON, icon);
//#endif 

} 

//#endif 


//#if 1974689958 
public void actionPerformed(ActionEvent e)
    { 

//#if -157983616 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if -50855258 
Object ns = null;
//#endif 


//#if 1394954526 
if(Model.getFacade().isANamespace(target))//1
{ 

//#if 2121039081 
ns = target;
//#endif 

} 

//#endif 


//#if 1422895724 
if(Model.getFacade().isAParameter(target))//1

//#if -1426653821 
if(Model.getFacade().getBehavioralFeature(target) != null)//1
{ 

//#if -870407566 
target = Model.getFacade().getBehavioralFeature(target);
//#endif 

} 

//#endif 


//#endif 


//#if 215725305 
if(Model.getFacade().isAFeature(target))//1

//#if -1740706575 
if(Model.getFacade().getOwner(target) != null)//1
{ 

//#if 647576084 
target = Model.getFacade().getOwner(target);
//#endif 

} 

//#endif 


//#endif 


//#if 1598805341 
if(Model.getFacade().isAEvent(target))//1
{ 

//#if -653964494 
ns = Model.getFacade().getNamespace(target);
//#endif 

} 

//#endif 


//#if -1730784274 
if(Model.getFacade().isAClassifier(target))//1
{ 

//#if 1213624787 
ns = Model.getFacade().getNamespace(target);
//#endif 

} 

//#endif 


//#if 1787265639 
if(Model.getFacade().isAAssociationEnd(target))//1
{ 

//#if 637727819 
target = Model.getFacade().getAssociation(target);
//#endif 


//#if 1368312229 
ns = Model.getFacade().getNamespace(target);
//#endif 

} 

//#endif 


//#if 2052917825 
Object newEnum = Model.getCoreFactory().buildEnumeration("", ns);
//#endif 


//#if -880218465 
TargetManager.getInstance().setTarget(newEnum);
//#endif 


//#if -174726725 
super.actionPerformed(e);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

