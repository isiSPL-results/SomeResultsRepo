package org.argouml.uml.cognitive.critics;
import javax.swing.JPanel;
import org.argouml.cognitive.ToDoItem;
import org.argouml.cognitive.ui.WizStepTextField;
import org.argouml.i18n.Translator;
public class WizTooMany extends UMLWizard
  { 
private String instructions =
        Translator.localize("critics.WizTooMany-ins");
private WizStepTextField step1;
public boolean canFinish()
    { 
if(!super.canFinish())//1
{ 
return false;
} 
if(getStep() == 0)//1
{ 
return true;
} 
if(getStep() == 1 && step1 != null)//1
{ 
try//1
{ 
Integer.parseInt(step1.getText());
return true;
} 
catch (NumberFormatException ex) //1
{ 
} 
} 
return false;
} 
public WizTooMany()
    { 
super();
} 
public void doAction(int oldStep)
    { 
switch (oldStep) //1
{ 
case 1://1

String newThreshold;
ToDoItem item = (ToDoItem) getToDoItem();
AbstractCrTooMany critic = (AbstractCrTooMany) item.getPoster();
if(step1 != null)//1
{ 
newThreshold = step1.getText();
try//1
{ 
critic.setThreshold(Integer.parseInt(newThreshold));
} 
catch (NumberFormatException ex) //1
{ 
} 
} 
break;


} 
} 
public JPanel makePanel(int newStep)
    { 
switch (newStep) //1
{ 
case 1://1

if(step1 == null)//1
{ 
ToDoItem item = (ToDoItem) getToDoItem();
AbstractCrTooMany critic = (AbstractCrTooMany) item.getPoster();
step1 = new WizStepTextField(this, instructions, "Threshold",
                                             Integer.toString(critic.getThreshold()));
} 
return step1;

} 
return null;
} 
public int getNumSteps()
    { 
return 1;
} 

 } 
