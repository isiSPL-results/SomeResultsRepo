package org.argouml.uml.ui.foundation.extension_mechanisms;
import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import org.apache.log4j.Logger;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLComboBox2;
import org.tigris.gef.undo.UndoableAction;
public class ActionSetTagDefinitionOwner extends UndoableAction
  { 
private static final Logger LOG =
        Logger.getLogger(ActionSetTagDefinitionOwner.class);
public static final ActionSetTagDefinitionOwner SINGLETON =
        new ActionSetTagDefinitionOwner();
private static final long serialVersionUID = -5230402929326015086L;
public ActionSetTagDefinitionOwner()
    { 
super(Translator.localize("Set"),
              ResourceLoaderWrapper.lookupIcon("Set"));
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
} 
@Override
    public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
Object source = e.getSource();
LOG.info("Receiving " + e + "/" + e.getID() + "/"
                 + e.getActionCommand());
if(source instanceof UMLComboBox2
                && e.getModifiers() == AWTEvent.MOUSE_EVENT_MASK)//1
{ 
UMLComboBox2 combo = (UMLComboBox2) source;
Object o = combo.getSelectedItem();
final Object tagDefinition = combo.getTarget();
LOG.info("Set owner to " + o);
if(Model.getFacade().isAStereotype(o)
                    && Model.getFacade().isATagDefinition(tagDefinition))//1
{ 
Model.getCoreHelper().setOwner(tagDefinition, o);
} 
} 
} 

 } 
