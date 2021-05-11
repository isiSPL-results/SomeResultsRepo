
//#if 1248574663 
// Compilation Unit of /UMLAssociationEndAggregationRadioButtonPanel.java 
 

//#if 560011876 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 309166319 
import java.util.ArrayList;
//#endif 


//#if -2000643054 
import java.util.List;
//#endif 


//#if 742333721 
import org.argouml.i18n.Translator;
//#endif 


//#if 201612383 
import org.argouml.model.Model;
//#endif 


//#if 1652977960 
import org.argouml.uml.ui.UMLRadioButtonPanel;
//#endif 


//#if 1161422612 
public class UMLAssociationEndAggregationRadioButtonPanel extends 
//#if 263809933 
UMLRadioButtonPanel
//#endif 

  { 

//#if -1037645702 
private static List<String[]> labelTextsAndActionCommands =
        new ArrayList<String[]>();
//#endif 


//#if -317286734 
static
    {
        labelTextsAndActionCommands.add(new String[] {
                                            Translator.localize("label.aggregationkind-aggregate"),
                                            ActionSetAssociationEndAggregation.AGGREGATE_COMMAND
                                        });
        labelTextsAndActionCommands.add(new String[] {
                                            Translator.localize("label.aggregationkind-composite"),
                                            ActionSetAssociationEndAggregation.COMPOSITE_COMMAND
                                        });
        labelTextsAndActionCommands.add(new String[] {
                                            Translator.localize("label.aggregationkind-none"),
                                            ActionSetAssociationEndAggregation.NONE_COMMAND
                                        });
    }
//#endif 


//#if -1938777928 
public UMLAssociationEndAggregationRadioButtonPanel(String title,
            boolean horizontal)
    { 

//#if 1495710566 
super(title, labelTextsAndActionCommands, "aggregation",
              ActionSetAssociationEndAggregation.getInstance(), horizontal);
//#endif 

} 

//#endif 


//#if -846492521 
public void buildModel()
    { 

//#if -599487128 
if(getTarget() != null)//1
{ 

//#if -1187339213 
Object target = getTarget();
//#endif 


//#if -2056454592 
Object kind = Model.getFacade().getAggregation(target);
//#endif 


//#if 1313595873 
if(kind == null)//1
{ 

//#if 1399700745 
setSelected(null);
//#endif 

} 
else

//#if 268934775 
if(kind.equals(Model.getAggregationKind().getNone()))//1
{ 

//#if 945726757 
setSelected(ActionSetAssociationEndAggregation.NONE_COMMAND);
//#endif 

} 
else

//#if -2132057430 
if(kind.equals(Model.getAggregationKind().getAggregate()))//1
{ 

//#if -1496671831 
setSelected(
                    ActionSetAssociationEndAggregation.AGGREGATE_COMMAND);
//#endif 

} 
else

//#if -830200537 
if(kind.equals(Model.getAggregationKind().getComposite()))//1
{ 

//#if 1211900736 
setSelected(
                    ActionSetAssociationEndAggregation.COMPOSITE_COMMAND);
//#endif 

} 
else
{ 

//#if -1861230188 
setSelected(ActionSetAssociationEndAggregation.NONE_COMMAND);
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

