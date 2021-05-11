// Compilation Unit of /ActionNewInnerClass.java 
 
package org.argouml.uml.ui.foundation.core;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.ui.AbstractActionNewModelElement;
public class ActionNewInnerClass extends AbstractActionNewModelElement
  { 
public void actionPerformed(ActionEvent e)
    { 
Object target = TargetManager.getInstance().getModelTarget();
if(Model.getFacade().isAClassifier(target))//1
{ 
Object classifier = /* (MClassifier) */target;
Object inner = Model.getCoreFactory().buildClass(classifier);
TargetManager.getInstance().setTarget(inner);
super.actionPerformed(e);
} 

} 

public ActionNewInnerClass()
    { 
super("button.new-inner-class");
putValue(Action.NAME, Translator.localize("button.new-inner-class"));
} 

 } 


