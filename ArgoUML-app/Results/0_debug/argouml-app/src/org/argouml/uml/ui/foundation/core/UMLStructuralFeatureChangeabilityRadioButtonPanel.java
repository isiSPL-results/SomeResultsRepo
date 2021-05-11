
//#if 943354103 
// Compilation Unit of /UMLStructuralFeatureChangeabilityRadioButtonPanel.java 
 

//#if 1087473528 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 2137167363 
import java.util.ArrayList;
//#endif 


//#if -1185961346 
import java.util.List;
//#endif 


//#if 111664685 
import org.argouml.i18n.Translator;
//#endif 


//#if 528533363 
import org.argouml.model.Model;
//#endif 


//#if -22283372 
import org.argouml.uml.ui.UMLRadioButtonPanel;
//#endif 


//#if 297640151 
public class UMLStructuralFeatureChangeabilityRadioButtonPanel extends 
//#if -445596928 
UMLRadioButtonPanel
//#endif 

  { 

//#if -1269957145 
private static List<String[]> labelTextsAndActionCommands =
        new ArrayList<String[]>();
//#endif 


//#if -2097905761 
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


//#if 747775044 
public void buildModel()
    { 

//#if -773699742 
if(getTarget() != null)//1
{ 

//#if -1633739237 
Object target =  getTarget();
//#endif 


//#if 343257600 
Object kind = Model.getFacade().getChangeability(target);
//#endif 


//#if -2145598519 
if(kind == null)//1
{ 

//#if 2093752209 
setSelected(null);
//#endif 

} 
else

//#if -1452300617 
if(kind.equals(
                           Model.getChangeableKind().getAddOnly()))//1
{ 

//#if -1337480777 
setSelected(ActionSetChangeability.ADDONLY_COMMAND);
//#endif 

} 
else

//#if -754201966 
if(kind.equals(
                           Model.getChangeableKind().getChangeable()))//1
{ 

//#if 1843104472 
setSelected(ActionSetChangeability.CHANGEABLE_COMMAND);
//#endif 

} 
else

//#if 539022755 
if(kind.equals(
                           Model.getChangeableKind().getFrozen()))//1
{ 

//#if 1056865934 
setSelected(ActionSetChangeability.FROZEN_COMMAND);
//#endif 

} 
else
{ 

//#if 894983613 
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


//#if -810921326 
public UMLStructuralFeatureChangeabilityRadioButtonPanel(
        String title, boolean horizontal)
    { 

//#if 804436131 
super(title, labelTextsAndActionCommands, "changeability",
              ActionSetChangeability.getInstance(), horizontal);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

