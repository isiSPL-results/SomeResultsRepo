package org.argouml.uml.ui.foundation.core;
import javax.swing.DefaultListModel;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.ui.targetmanager.TargetListener;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.ui.ActionNavigateContainerElement;
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
class EnumerationListModel extends DefaultListModel
 implements TargetListener
  { 
public void targetRemoved(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
private void setTarget(Object t)
    { 
removeAllElements();
if(Model.getFacade().isAEnumerationLiteral(t))//1
{ 
addElement(Model.getFacade().getEnumeration(t));
} 
} 
public void targetSet(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
public EnumerationListModel()
    { 
super();
setTarget(TargetManager.getInstance().getModelTarget());
TargetManager.getInstance().addTargetListener(this);
} 
public void targetAdded(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 

 } 
public class PropPanelEnumerationLiteral extends PropPanelModelElement
  { 
private static final long serialVersionUID = 1486642919681744144L;
public PropPanelEnumerationLiteral()
    { 
super("label.enumeration-literal", lookupIcon("EnumerationLiteral"));
addField(Translator.localize("label.name"),
                 getNameTextField());
addField(Translator.localize("label.enumeration"),
                 getSingleRowScroll(new EnumerationListModel()));
addAction(new ActionNavigateContainerElement());
addAction(new ActionAddLiteral());
addAction(new ActionNewStereotype());
addAction(getDeleteAction());
} 

 } 
