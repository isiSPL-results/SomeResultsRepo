package org.argouml.uml.ui.foundation.core;
import java.util.ArrayList;
import java.util.List;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLRadioButtonPanel;
public class UMLOperationConcurrencyRadioButtonPanel extends UMLRadioButtonPanel
  { 
private static List<String[]> labelTextsAndActionCommands;
public UMLOperationConcurrencyRadioButtonPanel(String title,
            boolean horizontal)
    { 
super(title, getCommands(), "concurrency",
              ActionSetOperationConcurrencyKind.getInstance(), horizontal);
} 
private static List<String[]> getCommands()
    { 
if(labelTextsAndActionCommands == null)//1
{ 
labelTextsAndActionCommands =
                new ArrayList<String[]>();
labelTextsAndActionCommands.add(new String[] {
                                                Translator.localize("label.concurrency-sequential"),
                                                ActionSetOperationConcurrencyKind.SEQUENTIAL_COMMAND
                                            });
labelTextsAndActionCommands.add(new String[] {
                                                Translator.localize("label.concurrency-guarded"),
                                                ActionSetOperationConcurrencyKind.GUARDED_COMMAND
                                            });
labelTextsAndActionCommands.add(new String[] {
                                                Translator.localize("label.concurrency-concurrent"),
                                                ActionSetOperationConcurrencyKind.CONCURRENT_COMMAND
                                            });
} 
return labelTextsAndActionCommands;
} 
public void buildModel()
    { 
if(getTarget() != null)//1
{ 
Object target = getTarget();
Object kind = Model.getFacade().getConcurrency(target);
if(kind == null)//1
{ 
setSelected(null);
} 
else
if(kind.equals(
                           Model.getConcurrencyKind().getSequential()))//1
{ 
setSelected(
                    ActionSetOperationConcurrencyKind.SEQUENTIAL_COMMAND);
} 
else
if(kind.equals(
                           Model.getConcurrencyKind().getGuarded()))//1
{ 
setSelected(
                    ActionSetOperationConcurrencyKind.GUARDED_COMMAND);
} 
else
if(kind.equals(
                           Model.getConcurrencyKind().getConcurrent()))//1
{ 
setSelected(
                    ActionSetOperationConcurrencyKind.CONCURRENT_COMMAND);
} 
else
{ 
setSelected(
                    ActionSetOperationConcurrencyKind.SEQUENTIAL_COMMAND);
} 
} 
} 

 } 
