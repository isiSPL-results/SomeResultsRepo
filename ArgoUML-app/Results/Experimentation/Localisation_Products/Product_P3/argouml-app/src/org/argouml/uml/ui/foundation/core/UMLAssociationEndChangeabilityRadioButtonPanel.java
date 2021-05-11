package org.argouml.uml.ui.foundation.core;
import java.util.ArrayList;
import java.util.List;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLRadioButtonPanel;
public class UMLAssociationEndChangeabilityRadioButtonPanel extends UMLRadioButtonPanel
  { 
private static List<String[]> labelTextsAndActionCommands =
        new ArrayList<String[]>();
static
    {
        labelTextsAndActionCommands.add(new String[] {
                                            Translator.localize("label.changeability-addonly"),
                                            ActionSetChangeability.ADDONLY_COMMAND
                                        });
        labelTextsAndActionCommands.add(new String[] {
                                            Translator.localize("label.changeability-changeable"),
                                            ActionSetChangeability.CHANGEABLE_COMMAND
                                        });
        labelTextsAndActionCommands.add(new String[] {
                                            Translator.localize("label.changeability-frozen"),
                                            ActionSetChangeability.FROZEN_COMMAND
                                        });
    }
public UMLAssociationEndChangeabilityRadioButtonPanel(
        String title, boolean horizontal)
    { 
super(title, labelTextsAndActionCommands, "changeability",
              ActionSetChangeability.getInstance(), horizontal);
} 
public void buildModel()
    { 
if(getTarget() != null)//1
{ 
Object target = getTarget();
Object kind = Model.getFacade().getChangeability(target);
if(kind == null)//1
{ 
setSelected(null);
} 
else
if(kind.equals(Model.getChangeableKind().getChangeable()))//1
{ 
setSelected(ActionSetChangeability.CHANGEABLE_COMMAND);
} 
else
if(kind.equals(Model.getChangeableKind().getAddOnly()))//1
{ 
setSelected(ActionSetChangeability.ADDONLY_COMMAND);
} 
else
if(kind.equals(Model.getChangeableKind().getFrozen()))//1
{ 
setSelected(ActionSetChangeability.FROZEN_COMMAND);
} 
else
{ 
setSelected(ActionSetChangeability.CHANGEABLE_COMMAND);
} 
} 
} 

 } 
