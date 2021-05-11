package org.argouml.uml.ui.foundation.core;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLComboBox2;
import org.tigris.gef.undo.UndoableAction;
public class ActionSetAssociationEndType extends UndoableAction
  { 
private static final ActionSetAssociationEndType SINGLETON =
        new ActionSetAssociationEndType();
public static ActionSetAssociationEndType getInstance()
    { 
return SINGLETON;
} 
protected ActionSetAssociationEndType()
    { 
super(Translator.localize("Set"), null);
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
} 
@Override
    public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
Object source = e.getSource();
Object oldClassifier = null;
Object newClassifier = null;
Object end = null;
if(source instanceof UMLComboBox2)//1
{ 
UMLComboBox2 box = (UMLComboBox2) source;
Object o = box.getTarget();
if(Model.getFacade().isAAssociationEnd(o))//1
{ 
end = o;
oldClassifier = Model.getFacade().getType(end);
} 
o = box.getSelectedItem();
if(Model.getFacade().isAClassifier(o))//1
{ 
newClassifier = o;
} 
} 
if(newClassifier != oldClassifier && end != null
                && newClassifier != null)//1
{ 
Model.getCoreHelper().setType(end, newClassifier);
super.actionPerformed(e);
} 
} 

 } 
