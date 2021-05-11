package org.argouml.uml.ui.behavior.use_cases;
import java.awt.event.ActionEvent;
import org.argouml.model.Model;
import org.argouml.uml.ui.AbstractActionNewModelElement;
public class ActionNewExtendExtensionPoint extends AbstractActionNewModelElement
  { 
public static final ActionNewExtendExtensionPoint SINGLETON =
        new ActionNewExtendExtensionPoint();
protected ActionNewExtendExtensionPoint()
    { 
super();
} 
public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
if(Model.getFacade().isAExtend(getTarget()))//1
{ 
Object point =
                Model.getUseCasesFactory().buildExtensionPoint(
                    Model.getFacade().getBase(getTarget()));
Model.getUseCasesHelper().addExtensionPoint(getTarget(), point);
} 
} 

 } 
