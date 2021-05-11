
//#if 1807663335 
// Compilation Unit of /WizTooMany.java 
 

//#if -1187022179 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1133752868 
import javax.swing.JPanel;
//#endif 


//#if 1929685052 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 1627453742 
import org.argouml.cognitive.ui.WizStepTextField;
//#endif 


//#if 1146711811 
import org.argouml.i18n.Translator;
//#endif 


//#if -661979798 
public class WizTooMany extends 
//#if 2022756384 
UMLWizard
//#endif 

  { 

//#if 328492741 
private String instructions =
        Translator.localize("critics.WizTooMany-ins");
//#endif 


//#if -1299943853 
private WizStepTextField step1;
//#endif 


//#if 1104860868 
public boolean canFinish()
    { 

//#if 686545674 
if(!super.canFinish())//1
{ 

//#if 425707950 
return false;
//#endif 

} 

//#endif 


//#if 223428391 
if(getStep() == 0)//1
{ 

//#if -984265357 
return true;
//#endif 

} 

//#endif 


//#if 314539664 
if(getStep() == 1 && step1 != null)//1
{ 

//#if -1832816895 
try //1
{ 

//#if -1538845076 
Integer.parseInt(step1.getText());
//#endif 


//#if 679295650 
return true;
//#endif 

} 

//#if -1748986061 
catch (NumberFormatException ex) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 


//#if -2015887103 
return false;
//#endif 

} 

//#endif 


//#if -1486391212 
public WizTooMany()
    { 

//#if -1000880555 
super();
//#endif 

} 

//#endif 


//#if 375037594 
public void doAction(int oldStep)
    { 

//#if -118039364 
switch (oldStep) //1
{ 
case 1://1


//#if 1858127767 
String newThreshold;
//#endif 


//#if -1143526660 
ToDoItem item = (ToDoItem) getToDoItem();
//#endif 


//#if 1118268114 
AbstractCrTooMany critic = (AbstractCrTooMany) item.getPoster();
//#endif 


//#if -470333907 
if(step1 != null)//1
{ 

//#if -961554585 
newThreshold = step1.getText();
//#endif 


//#if 751752033 
try //1
{ 

//#if -1919479905 
critic.setThreshold(Integer.parseInt(newThreshold));
//#endif 

} 

//#if 365261326 
catch (NumberFormatException ex) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 


//#if 1057576676 
break;

//#endif 


} 

//#endif 

} 

//#endif 


//#if 385517272 
public JPanel makePanel(int newStep)
    { 

//#if 176657629 
switch (newStep) //1
{ 
case 1://1


//#if 1570834540 
if(step1 == null)//1
{ 

//#if -1835380072 
ToDoItem item = (ToDoItem) getToDoItem();
//#endif 


//#if 1312519094 
AbstractCrTooMany critic = (AbstractCrTooMany) item.getPoster();
//#endif 


//#if -942156264 
step1 = new WizStepTextField(this, instructions, "Threshold",
                                             Integer.toString(critic.getThreshold()));
//#endif 

} 

//#endif 


//#if 1776689161 
return step1;
//#endif 


} 

//#endif 


//#if -2064287900 
return null;
//#endif 

} 

//#endif 


//#if -1444267631 
public int getNumSteps()
    { 

//#if 1131729388 
return 1;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

