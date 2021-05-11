package org.argouml.uml.cognitive.critics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.apache.log4j.Logger;
import org.argouml.cognitive.ui.WizStepChoice;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class WizNavigable extends UMLWizard
  { 
private static final Logger LOG = Logger.getLogger(WizNavigable.class);
private String instructions =
        Translator.localize("critics.WizNavigable-ins");
private String option0 =
        Translator.localize("critics.WizNavigable-option1");
private String option1 =
        Translator.localize("critics.WizNavigable-option2");
private String option2 =
        Translator.localize("critics.WizNavigable-option3");
private WizStepChoice step1 = null;
private static final long serialVersionUID = 2571165058454693999L;
public JPanel makePanel(int newStep)
    { 
switch (newStep) //1
{ 
case 1://1

if(step1 == null)//1
{ 
step1 = new WizStepChoice(this, instructions, getOptions());
step1.setTarget(getToDoItem());
} 
return step1;

} 
return null;
} 
public void setInstructions(String s)
    { 
instructions = s;
} 
@Override
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
if(getStep() == 1 && step1 != null && step1.getSelectedIndex() != -1)//1
{ 
return true;
} 
return false;
} 
public List<String> getOptions()
    { 
List<String> result = new ArrayList<String>();
Object asc = getModelElement();
Object ae0 =
            new ArrayList(Model.getFacade().getConnections(asc)).get(0);
Object ae1 =
            new ArrayList(Model.getFacade().getConnections(asc)).get(1);
Object cls0 = Model.getFacade().getType(ae0);
Object cls1 = Model.getFacade().getType(ae1);
if(cls0 != null && !"".equals(Model.getFacade().getName(cls0)))//1
{ 
option0 = Translator.localize("critics.WizNavigable-option4")
                      + Model.getFacade().getName(cls0);
} 
if(cls1 != null && !"".equals(Model.getFacade().getName(cls1)))//1
{ 
option1 = Translator.localize("critics.WizNavigable-option5")
                      + Model.getFacade().getName(cls1);
} 
result.add(option0);
result.add(option1);
result.add(option2);
return result;
} 
public void doAction(int oldStep)
    { 
LOG.debug("doAction " + oldStep);
switch (oldStep) //1
{ 
case 1://1

int choice = -1;
if(step1 != null)//1
{ 
choice = step1.getSelectedIndex();
} 
if(choice == -1)//1
{ 
throw new Error("nothing selected, should not get here");
} 
try//1
{ 
Object asc = getModelElement();
Object ae0 =
                    new ArrayList(Model.getFacade().getConnections(asc)).get(0);
Object ae1 =
                    new ArrayList(Model.getFacade().getConnections(asc)).get(1);
Model.getCoreHelper().setNavigable(ae0,
                                                   choice == 0 || choice == 2);
Model.getCoreHelper().setNavigable(ae1,
                                                   choice == 1 || choice == 2);
} 
catch (Exception pve) //1
{ 
LOG.error("could not set navigablity", pve);
} 

} 
} 
public WizNavigable() { 
} 

 } 
