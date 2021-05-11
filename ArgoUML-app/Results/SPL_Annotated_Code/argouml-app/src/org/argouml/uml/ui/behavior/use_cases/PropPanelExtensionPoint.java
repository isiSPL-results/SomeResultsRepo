// Compilation Unit of /PropPanelExtensionPoint.java 
 
package org.argouml.uml.ui.behavior.use_cases;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.ui.AbstractActionNewModelElement;
import org.argouml.uml.ui.ActionNavigateContainerElement;
import org.argouml.uml.ui.UMLLinkedList;
import org.argouml.uml.ui.UMLTextField2;
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
public class PropPanelExtensionPoint extends PropPanelModelElement
  { 
private static final long serialVersionUID = 1835785842490972735L;
public PropPanelExtensionPoint()
    { 
super("label.extension-point",  lookupIcon("ExtensionPoint"));
addField("label.name", getNameTextField());
JTextField locationField = new UMLTextField2(
            new UMLExtensionPointLocationDocument());
addField("label.location",
                 locationField);
addSeparator();
addField("label.usecase-base",
                 getSingleRowScroll(new UMLExtensionPointUseCaseListModel()));
JList extendList = new UMLLinkedList(
            new UMLExtensionPointExtendListModel());
addField("label.extend",
                 new JScrollPane(extendList));
addAction(new ActionNavigateContainerElement());
addAction(new ActionNewExtensionPoint());
addAction(new ActionNewStereotype());
addAction(getDeleteAction());
} 

@Override
    public void navigateUp()
    { 
Object target = getTarget();
if(!(Model.getFacade().isAExtensionPoint(target)))//1
{ 
return;
} 

Object owner = Model.getFacade().getUseCase(target);
if(owner != null)//1
{ 
TargetManager.getInstance().setTarget(owner);
} 

} 

private static class ActionNewExtensionPoint extends AbstractActionNewModelElement
  { 
private static final long serialVersionUID = -4149133466093969498L;
public ActionNewExtensionPoint()
        { 
super("button.new-extension-point");
putValue(Action.NAME,
                     Translator.localize("button.new-extension-point"));
} 

@Override
        public void actionPerformed(ActionEvent e)
        { 
Object target = TargetManager.getInstance().getModelTarget();
if(Model.getFacade().isAExtensionPoint(target))//1
{ 
TargetManager.getInstance().setTarget(
                    Model.getUseCasesFactory().buildExtensionPoint(
                        Model.getFacade().getUseCase(target)));
super.actionPerformed(e);
} 

} 

 } 

 } 


