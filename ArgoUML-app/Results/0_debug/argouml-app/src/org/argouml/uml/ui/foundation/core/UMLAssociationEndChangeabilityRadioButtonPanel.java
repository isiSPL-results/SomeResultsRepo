
//#if -1595597836 
// Compilation Unit of /UMLAssociationEndChangeabilityRadioButtonPanel.java 
 

//#if 748855923 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -880343298 
import java.util.ArrayList;
//#endif 


//#if -1264498525 
import java.util.List;
//#endif 


//#if 1047864360 
import org.argouml.i18n.Translator;
//#endif 


//#if -239189266 
import org.argouml.model.Model;
//#endif 


//#if 1098824377 
import org.argouml.uml.ui.UMLRadioButtonPanel;
//#endif 


//#if 1717553405 
public class UMLAssociationEndChangeabilityRadioButtonPanel extends 
//#if 13230585 
UMLRadioButtonPanel
//#endif 

  { 

//#if -1126094450 
private static List<String[]> labelTextsAndActionCommands =
        new ArrayList<String[]>();
//#endif 


//#if -241911354 
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
//#endif 


//#if 337584588 
public UMLAssociationEndChangeabilityRadioButtonPanel(
        String title, boolean horizontal)
    { 

//#if -1453621830 
super(title, labelTextsAndActionCommands, "changeability",
              ActionSetChangeability.getInstance(), horizontal);
//#endif 

} 

//#endif 


//#if -1202688341 
public void buildModel()
    { 

//#if -974119879 
if(getTarget() != null)//1
{ 

//#if -1893180253 
Object target = getTarget();
//#endif 


//#if 702046328 
Object kind = Model.getFacade().getChangeability(target);
//#endif 


//#if 166791761 
if(kind == null)//1
{ 

//#if -1355692233 
setSelected(null);
//#endif 

} 
else

//#if 1746811540 
if(kind.equals(Model.getChangeableKind().getChangeable()))//1
{ 

//#if -96680260 
setSelected(ActionSetChangeability.CHANGEABLE_COMMAND);
//#endif 

} 
else

//#if 1653398210 
if(kind.equals(Model.getChangeableKind().getAddOnly()))//1
{ 

//#if 786125444 
setSelected(ActionSetChangeability.ADDONLY_COMMAND);
//#endif 

} 
else

//#if 509145840 
if(kind.equals(Model.getChangeableKind().getFrozen()))//1
{ 

//#if -1705505068 
setSelected(ActionSetChangeability.FROZEN_COMMAND);
//#endif 

} 
else
{ 

//#if 500286690 
setSelected(ActionSetChangeability.CHANGEABLE_COMMAND);
//#endif 

} 

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

