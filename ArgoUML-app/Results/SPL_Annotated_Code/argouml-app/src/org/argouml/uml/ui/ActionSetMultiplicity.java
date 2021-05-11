// Compilation Unit of /ActionSetMultiplicity.java 
 
package org.argouml.uml.ui;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import org.argouml.i18n.Translator;
import org.tigris.gef.undo.UndoableAction;
public abstract class ActionSetMultiplicity extends UndoableAction
  { 
public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
Object source = e.getSource();
if(source instanceof UMLComboBox2)//1
{ 
Object selected = ((UMLComboBox2) source).getSelectedItem();
Object target = ((UMLComboBox2) source).getTarget();
if(target != null && selected != null)//1
{ 
setSelectedItem(selected, target);
} 

} 

} 

protected ActionSetMultiplicity()
    { 
super(Translator.localize("Set"), null);
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
} 

public abstract void setSelectedItem(Object item, Object target);
 } 


