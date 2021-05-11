// Compilation Unit of /WizMEName.java 
 
package org.argouml.uml.cognitive.critics;
import javax.swing.JPanel;
import org.apache.log4j.Logger;
import org.argouml.cognitive.ui.WizStepTextField;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class WizMEName extends UMLWizard
  { 
private static final Logger LOG = Logger.getLogger(WizMEName.class);
private String instructions = Translator.localize("critics.WizMEName-ins");
private String label = Translator.localize("label.name");
private boolean mustEdit = false;
private WizStepTextField step1 = null;
private String origSuggest;
public void setMustEdit(boolean b)
    { 
mustEdit = b;
} 

public void setInstructions(String s)
    { 
instructions = s;
} 

protected String getInstructions()
    { 
return instructions;
} 

public boolean canGoNext()
    { 
if(!super.canGoNext())//1
{ 
return false;
} 

if(step1 != null)//1
{ 
boolean changed = origSuggest.equals(step1.getText());
if(mustEdit && !changed)//1
{ 
return false;
} 

} 

return true;
} 

public void setSuggestion(String s)
    { 
origSuggest = s;
super.setSuggestion(s);
} 

public WizMEName() { 
} 

public void doAction(int oldStep)
    { 
LOG.debug("doAction " + oldStep);
switch (oldStep) //1
{ 
case 1://1

String newName = getSuggestion();
if(step1 != null)//1
{ 
newName = step1.getText();
} 

try //1
{ 
Object me = getModelElement();
Model.getCoreHelper().setName(me, newName);
} 
catch (Exception pve) //1
{ 
LOG.error("could not set name", pve);
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
step1 = new WizStepTextField(this, instructions,
                                             label, offerSuggestion());
} 

return step1;

} 

return null;
} 

 } 


