
//#if 139174590 
// Compilation Unit of /UMLOperationConcurrencyRadioButtonPanel.java 
 

//#if 1014368819 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -2002653506 
import java.util.ArrayList;
//#endif 


//#if -1195079453 
import java.util.List;
//#endif 


//#if 889998312 
import org.argouml.i18n.Translator;
//#endif 


//#if 1402948270 
import org.argouml.model.Model;
//#endif 


//#if -336250119 
import org.argouml.uml.ui.UMLRadioButtonPanel;
//#endif 


//#if 445834333 
public class UMLOperationConcurrencyRadioButtonPanel extends 
//#if -1660061988 
UMLRadioButtonPanel
//#endif 

  { 

//#if 351736711 
private static List<String[]> labelTextsAndActionCommands;
//#endif 


//#if -1856093237 
public UMLOperationConcurrencyRadioButtonPanel(String title,
            boolean horizontal)
    { 

//#if 371188537 
super(title, getCommands(), "concurrency",
              ActionSetOperationConcurrencyKind.getInstance(), horizontal);
//#endif 

} 

//#endif 


//#if 539332112 
private static List<String[]> getCommands()
    { 

//#if -1534328114 
if(labelTextsAndActionCommands == null)//1
{ 

//#if 971294855 
labelTextsAndActionCommands =
                new ArrayList<String[]>();
//#endif 


//#if 926269178 
labelTextsAndActionCommands.add(new String[] {
                                                Translator.localize("label.concurrency-sequential"),
                                                ActionSetOperationConcurrencyKind.SEQUENTIAL_COMMAND
                                            });
//#endif 


//#if 1392108960 
labelTextsAndActionCommands.add(new String[] {
                                                Translator.localize("label.concurrency-guarded"),
                                                ActionSetOperationConcurrencyKind.GUARDED_COMMAND
                                            });
//#endif 


//#if 2099791354 
labelTextsAndActionCommands.add(new String[] {
                                                Translator.localize("label.concurrency-concurrent"),
                                                ActionSetOperationConcurrencyKind.CONCURRENT_COMMAND
                                            });
//#endif 

} 

//#endif 


//#if 80640367 
return labelTextsAndActionCommands;
//#endif 

} 

//#endif 


//#if 1423674088 
public void buildModel()
    { 

//#if 136659527 
if(getTarget() != null)//1
{ 

//#if 895605021 
Object target = getTarget();
//#endif 


//#if -963242619 
Object kind = Model.getFacade().getConcurrency(target);
//#endif 


//#if -1601986357 
if(kind == null)//1
{ 

//#if -830641519 
setSelected(null);
//#endif 

} 
else

//#if -529473367 
if(kind.equals(
                           Model.getConcurrencyKind().getSequential()))//1
{ 

//#if -2138678863 
setSelected(
                    ActionSetOperationConcurrencyKind.SEQUENTIAL_COMMAND);
//#endif 

} 
else

//#if -1654864494 
if(kind.equals(
                           Model.getConcurrencyKind().getGuarded()))//1
{ 

//#if 338358177 
setSelected(
                    ActionSetOperationConcurrencyKind.GUARDED_COMMAND);
//#endif 

} 
else

//#if -1115577046 
if(kind.equals(
                           Model.getConcurrencyKind().getConcurrent()))//1
{ 

//#if -802099176 
setSelected(
                    ActionSetOperationConcurrencyKind.CONCURRENT_COMMAND);
//#endif 

} 
else
{ 

//#if 432723460 
setSelected(
                    ActionSetOperationConcurrencyKind.SEQUENTIAL_COMMAND);
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

