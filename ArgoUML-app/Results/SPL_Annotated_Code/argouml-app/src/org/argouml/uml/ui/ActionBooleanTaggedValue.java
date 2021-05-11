// Compilation Unit of /ActionBooleanTaggedValue.java 
 
package org.argouml.uml.ui;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.tigris.gef.undo.UndoableAction;
public class ActionBooleanTaggedValue extends UndoableAction
  { 
private String tagName;
public ActionBooleanTaggedValue(String theTagName)
    { 
super(Translator.localize("Set"), null);
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
tagName = theTagName;
} 

@Override
    public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
if(!(e.getSource() instanceof UMLCheckBox2))//1
{ 
return;
} 

UMLCheckBox2 source = (UMLCheckBox2) e.getSource();
Object obj = source.getTarget();
if(!Model.getFacade().isAModelElement(obj))//1
{ 
return;
} 

boolean newState = source.isSelected();
Object taggedValue = Model.getFacade().getTaggedValue(obj, tagName);
if(taggedValue == null)//1
{ 
taggedValue =
                Model.getExtensionMechanismsFactory().buildTaggedValue(
                    tagName, "");
Model.getExtensionMechanismsHelper().addTaggedValue(
                obj, taggedValue);
} 

if(newState)//1
{ 
Model.getCommonBehaviorHelper().setValue(taggedValue, "true");
} 
else
{ 
Model.getCommonBehaviorHelper().setValue(taggedValue, "false");
} 

} 

 } 


