package org.argouml.uml.ui.foundation.core;
import java.awt.event.ActionEvent;
import java.util.Collection;
import javax.swing.Action;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLComboBox2;
import org.tigris.gef.undo.UndoableAction;
public class ActionSetModelElementStereotype extends UndoableAction
  { 
private static final ActionSetModelElementStereotype SINGLETON =
        new ActionSetModelElementStereotype();
protected ActionSetModelElementStereotype()
    { 
super(Translator.localize("Set"), null);
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
} 
public static ActionSetModelElementStereotype getInstance()
    { 
return SINGLETON;
} 
public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
Object source = e.getSource();
Collection oldStereo = null;
Object newStereo = null;
Object target = null;
if(source instanceof UMLComboBox2)//1
{ 
UMLComboBox2 combo = (UMLComboBox2) source;
if(Model.getFacade().isAStereotype(combo.getSelectedItem()))//1
{ 
newStereo = combo.getSelectedItem();
} 
if(Model.getFacade().isAModelElement(combo.getTarget()))//1
{ 
target = combo.getTarget();
oldStereo = Model.getFacade().getStereotypes(target);
} 
if("".equals(combo.getSelectedItem()))//1
{ 
newStereo = null;
} 
} 
if(oldStereo != null && !oldStereo.contains(newStereo)
                && target != null)//1
{ 
if(newStereo != null)//1
{ 
Model.getCoreHelper().addStereotype(target, newStereo);
} 
} 
} 

 } 
