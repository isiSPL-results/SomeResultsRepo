
//#if 284342557 
// Compilation Unit of /UMLParameterDirectionKindRadioButtonPanel.java 
 

//#if 334593042 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1243807389 
import java.util.ArrayList;
//#endif 


//#if -1115502172 
import java.util.List;
//#endif 


//#if 262868167 
import org.argouml.i18n.Translator;
//#endif 


//#if 1279742733 
import org.argouml.model.Model;
//#endif 


//#if -765622086 
import org.argouml.uml.ui.UMLRadioButtonPanel;
//#endif 


//#if 1350474714 
public class UMLParameterDirectionKindRadioButtonPanel extends 
//#if -1939506523 
UMLRadioButtonPanel
//#endif 

  { 

//#if 1398771810 
private static List<String[]> labelTextsAndActionCommands =
        new ArrayList<String[]>();
//#endif 


//#if -54301600 
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
//#endif 


//#if 2118867652 
public UMLParameterDirectionKindRadioButtonPanel(String title,
            boolean horizontal)
    { 

//#if 129821590 
super(title, labelTextsAndActionCommands, "kind",
              ActionSetParameterDirectionKind.getInstance(), horizontal);
//#endif 

} 

//#endif 


//#if 138151551 
public void buildModel()
    { 

//#if 939664746 
if(getTarget() != null)//1
{ 

//#if 1348934592 
Object target = getTarget();
//#endif 


//#if -1576873907 
Object kind = Model.getFacade().getKind(target);
//#endif 


//#if 1180382830 
if(kind == null)//1
{ 

//#if 960378238 
setSelected(null);
//#endif 

} 
else

//#if 759706065 
if(kind.equals(
                           Model.getDirectionKind().getInParameter()))//1
{ 

//#if -97896175 
setSelected(ActionSetParameterDirectionKind.IN_COMMAND);
//#endif 

} 
else

//#if 1522395000 
if(kind.equals(
                           Model.getDirectionKind().getInOutParameter()))//1
{ 

//#if 280681110 
setSelected(ActionSetParameterDirectionKind.INOUT_COMMAND);
//#endif 

} 
else

//#if 1331341397 
if(kind.equals(
                           Model.getDirectionKind().getOutParameter()))//1
{ 

//#if -149913783 
setSelected(ActionSetParameterDirectionKind.OUT_COMMAND);
//#endif 

} 
else
{ 

//#if 91317619 
setSelected(ActionSetParameterDirectionKind.RETURN_COMMAND);
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

