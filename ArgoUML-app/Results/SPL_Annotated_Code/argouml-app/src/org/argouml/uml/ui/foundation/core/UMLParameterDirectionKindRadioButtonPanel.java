// Compilation Unit of /UMLParameterDirectionKindRadioButtonPanel.java 
 
package org.argouml.uml.ui.foundation.core;
import java.util.ArrayList;
import java.util.List;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLRadioButtonPanel;
public class UMLParameterDirectionKindRadioButtonPanel extends UMLRadioButtonPanel
  { 
private static List<String[]> labelTextsAndActionCommands =
        new ArrayList<String[]>();
static
    {
        labelTextsAndActionCommands.add(new String[] {
                                            Translator.localize("label.parameter-direction-in"),
                                            ActionSetParameterDirectionKind.IN_COMMAND
                                        });
        labelTextsAndActionCommands.add(new String[] {
                                            Translator.localize("label.parameter-direction-out"),
                                            ActionSetParameterDirectionKind.OUT_COMMAND
                                        });
        labelTextsAndActionCommands.add(new String[] {
                                            Translator.localize("label.parameter-direction-inout"),
                                            ActionSetParameterDirectionKind.INOUT_COMMAND
                                        });
        labelTextsAndActionCommands.add(new String[] {
                                            Translator.localize("label.parameter-direction-return"),
                                            ActionSetParameterDirectionKind.RETURN_COMMAND
                                        });
    }
public UMLParameterDirectionKindRadioButtonPanel(String title,
            boolean horizontal)
    { 
super(title, labelTextsAndActionCommands, "kind",
              ActionSetParameterDirectionKind.getInstance(), horizontal);
} 

public void buildModel()
    { 
if(getTarget() != null)//1
{ 
Object target = getTarget();
Object kind = Model.getFacade().getKind(target);
if(kind == null)//1
{ 
setSelected(null);
} 
else
if(kind.equals(
                           Model.getDirectionKind().getInParameter()))//1
{ 
setSelected(ActionSetParameterDirectionKind.IN_COMMAND);
} 
else
if(kind.equals(
                           Model.getDirectionKind().getInOutParameter()))//1
{ 
setSelected(ActionSetParameterDirectionKind.INOUT_COMMAND);
} 
else
if(kind.equals(
                           Model.getDirectionKind().getOutParameter()))//1
{ 
setSelected(ActionSetParameterDirectionKind.OUT_COMMAND);
} 
else
{ 
setSelected(ActionSetParameterDirectionKind.RETURN_COMMAND);
} 




} 

} 

 } 


