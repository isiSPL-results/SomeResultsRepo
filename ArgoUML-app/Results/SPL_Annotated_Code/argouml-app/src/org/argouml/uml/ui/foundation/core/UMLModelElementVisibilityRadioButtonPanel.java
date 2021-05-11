// Compilation Unit of /UMLModelElementVisibilityRadioButtonPanel.java 
 
package org.argouml.uml.ui.foundation.core;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLRadioButtonPanel;
public class UMLModelElementVisibilityRadioButtonPanel extends UMLRadioButtonPanel
  { 
private static final long serialVersionUID = -1705561978481456281L;
private static List<String[]> labelTextsAndActionCommands =
        new ArrayList<String[]>();
static
    {
        labelTextsAndActionCommands.add(new String[] {
                                            Translator.localize("label.visibility-public"),
                                            ActionSetModelElementVisibility.PUBLIC_COMMAND
                                        });
        labelTextsAndActionCommands.add(new String[] {
                                            Translator.localize("label.visibility-package"),
                                            ActionSetModelElementVisibility.PACKAGE_COMMAND
                                        });
        labelTextsAndActionCommands.add(new String[] {
                                            Translator.localize("label.visibility-protected"),
                                            ActionSetModelElementVisibility.PROTECTED_COMMAND
                                        });
        labelTextsAndActionCommands.add(new String[] {
                                            Translator.localize("label.visibility-private"),
                                            ActionSetModelElementVisibility.PRIVATE_COMMAND
                                        });
    }
public UMLModelElementVisibilityRadioButtonPanel(
        String title, boolean horizontal)
    { 
super(title, labelTextsAndActionCommands, "visibility",
              ActionSetModelElementVisibility.getInstance(), horizontal);
} 

public void setEnabled(boolean enabled)
    { 
for (final Component component : getComponents()) //1
{ 
component.setEnabled(enabled);
} 

} 

public void buildModel()
    { 
if(getTarget() != null)//1
{ 
Object target = getTarget();
Object kind = Model.getFacade().getVisibility(target);
if(kind == null)//1
{ 
setSelected(null);
} 
else
if(kind.equals(
                           Model.getVisibilityKind().getPublic()))//1
{ 
setSelected(ActionSetModelElementVisibility.PUBLIC_COMMAND);
} 
else
if(kind.equals(
                           Model.getVisibilityKind().getPackage()))//1
{ 
setSelected(ActionSetModelElementVisibility.PACKAGE_COMMAND);
} 
else
if(kind.equals(
                           Model.getVisibilityKind().getProtected()))//1
{ 
setSelected(ActionSetModelElementVisibility.PROTECTED_COMMAND);
} 
else
if(kind.equals(
                           Model.getVisibilityKind().getPrivate()))//1
{ 
setSelected(ActionSetModelElementVisibility.PRIVATE_COMMAND);
} 
else
{ 
setSelected(ActionSetModelElementVisibility.PUBLIC_COMMAND);
} 





} 

} 

 } 


