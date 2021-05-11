
//#if -354838785 
// Compilation Unit of /UMLModelElementVisibilityRadioButtonPanel.java 
 

//#if 1230963354 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -1116835271 
import java.awt.Component;
//#endif 


//#if -1287744219 
import java.util.ArrayList;
//#endif 


//#if -292209124 
import java.util.List;
//#endif 


//#if 187407183 
import org.argouml.i18n.Translator;
//#endif 


//#if -115055211 
import org.argouml.model.Model;
//#endif 


//#if 1190663474 
import org.argouml.uml.ui.UMLRadioButtonPanel;
//#endif 


//#if -1614898467 
public class UMLModelElementVisibilityRadioButtonPanel extends 
//#if 858757816 
UMLRadioButtonPanel
//#endif 

  { 

//#if -1855263795 
private static final long serialVersionUID = -1705561978481456281L;
//#endif 


//#if 1332459823 
private static List<String[]> labelTextsAndActionCommands =
        new ArrayList<String[]>();
//#endif 


//#if -1342293487 
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
//#endif 


//#if -1119829770 
public UMLModelElementVisibilityRadioButtonPanel(
        String title, boolean horizontal)
    { 

//#if 3768586 
super(title, labelTextsAndActionCommands, "visibility",
              ActionSetModelElementVisibility.getInstance(), horizontal);
//#endif 

} 

//#endif 


//#if -970673033 
public void setEnabled(boolean enabled)
    { 

//#if -1196155923 
for (final Component component : getComponents()) //1
{ 

//#if 1845560757 
component.setEnabled(enabled);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2084140660 
public void buildModel()
    { 

//#if -922240662 
if(getTarget() != null)//1
{ 

//#if -1633546427 
Object target = getTarget();
//#endif 


//#if 189054292 
Object kind = Model.getFacade().getVisibility(target);
//#endif 


//#if -1831829773 
if(kind == null)//1
{ 

//#if -133695581 
setSelected(null);
//#endif 

} 
else

//#if 1717795931 
if(kind.equals(
                           Model.getVisibilityKind().getPublic()))//1
{ 

//#if 1383164593 
setSelected(ActionSetModelElementVisibility.PUBLIC_COMMAND);
//#endif 

} 
else

//#if 1026149888 
if(kind.equals(
                           Model.getVisibilityKind().getPackage()))//1
{ 

//#if -132045505 
setSelected(ActionSetModelElementVisibility.PACKAGE_COMMAND);
//#endif 

} 
else

//#if -537664435 
if(kind.equals(
                           Model.getVisibilityKind().getProtected()))//1
{ 

//#if -147982764 
setSelected(ActionSetModelElementVisibility.PROTECTED_COMMAND);
//#endif 

} 
else

//#if -1951029855 
if(kind.equals(
                           Model.getVisibilityKind().getPrivate()))//1
{ 

//#if 1343355953 
setSelected(ActionSetModelElementVisibility.PRIVATE_COMMAND);
//#endif 

} 
else
{ 

//#if 2048803443 
setSelected(ActionSetModelElementVisibility.PUBLIC_COMMAND);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

