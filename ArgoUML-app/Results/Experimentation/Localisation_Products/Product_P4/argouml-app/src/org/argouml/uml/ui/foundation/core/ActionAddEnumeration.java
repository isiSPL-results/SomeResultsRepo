package org.argouml.uml.ui.foundation.core;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.Icon;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.ui.AbstractActionNewModelElement;
public class ActionAddEnumeration extends AbstractActionNewModelElement
  { 
public ActionAddEnumeration()
    { 
super("button.new-enumeration");
putValue(Action.NAME, Translator.localize("button.new-enumeration"));
Icon icon = ResourceLoaderWrapper.lookupIcon("Enumeration");
putValue(Action.SMALL_ICON, icon);
} 
public void actionPerformed(ActionEvent e)
    { 
Object target = TargetManager.getInstance().getModelTarget();
Object ns = null;
if(Model.getFacade().isANamespace(target))//1
{ 
ns = target;
} 
if(Model.getFacade().isAParameter(target))//1
if(Model.getFacade().getBehavioralFeature(target) != null)//1
{ 
target = Model.getFacade().getBehavioralFeature(target);
} 
if(Model.getFacade().isAFeature(target))//1
if(Model.getFacade().getOwner(target) != null)//1
{ 
target = Model.getFacade().getOwner(target);
} 
if(Model.getFacade().isAEvent(target))//1
{ 
ns = Model.getFacade().getNamespace(target);
} 
if(Model.getFacade().isAClassifier(target))//1
{ 
ns = Model.getFacade().getNamespace(target);
} 
if(Model.getFacade().isAAssociationEnd(target))//1
{ 
target = Model.getFacade().getAssociation(target);
ns = Model.getFacade().getNamespace(target);
} 
Object newEnum = Model.getCoreFactory().buildEnumeration("", ns);
TargetManager.getInstance().setTarget(newEnum);
super.actionPerformed(e);
} 

 } 
