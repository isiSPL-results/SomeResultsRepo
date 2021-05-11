// Compilation Unit of /UMLAssociationEndAggregationRadioButtonPanel.java 
 
package org.argouml.uml.ui.foundation.core;
import java.util.ArrayList;
import java.util.List;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLRadioButtonPanel;
public class UMLAssociationEndAggregationRadioButtonPanel extends UMLRadioButtonPanel
  { 
private static List<String[]> labelTextsAndActionCommands =
        new ArrayList<String[]>();
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
public UMLAssociationEndAggregationRadioButtonPanel(String title,
            boolean horizontal)
    { 
super(title, labelTextsAndActionCommands, "aggregation",
              ActionSetAssociationEndAggregation.getInstance(), horizontal);
} 

public void buildModel()
    { 
if(getTarget() != null)//1
{ 
Object target = getTarget();
Object kind = Model.getFacade().getAggregation(target);
if(kind == null)//1
{ 
setSelected(null);
} 
else
if(kind.equals(Model.getAggregationKind().getNone()))//1
{ 
setSelected(ActionSetAssociationEndAggregation.NONE_COMMAND);
} 
else
if(kind.equals(Model.getAggregationKind().getAggregate()))//1
{ 
setSelected(
                    ActionSetAssociationEndAggregation.AGGREGATE_COMMAND);
} 
else
if(kind.equals(Model.getAggregationKind().getComposite()))//1
{ 
setSelected(
                    ActionSetAssociationEndAggregation.COMPOSITE_COMMAND);
} 
else
{ 
setSelected(ActionSetAssociationEndAggregation.NONE_COMMAND);
} 




} 

} 

 } 


