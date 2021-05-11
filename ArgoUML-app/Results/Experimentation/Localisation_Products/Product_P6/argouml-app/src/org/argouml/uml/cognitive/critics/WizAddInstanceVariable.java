package org.argouml.uml.cognitive.critics;
import javax.swing.JPanel;
import org.argouml.cognitive.ui.WizStepTextField;
import org.argouml.i18n.Translator;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
public class WizAddInstanceVariable extends UMLWizard
  { 
private WizStepTextField step1 = null;
private String label = Translator.localize("label.name");
private String instructions =
        Translator.localize("critics.WizAddInstanceVariable-ins");
public void doAction(int oldStep)
    { 
Object attr;
switch (oldStep) //1
{ 
case 1://1

String newName = getSuggestion();
if(step1 != null)//1
{ 
newName = step1.getText();
} 
Object me = getModelElement();
Object attrType =
                ProjectManager.getManager()
                .getCurrentProject().getDefaultAttributeType();
attr =
                Model.getCoreFactory()
                .buildAttribute2(me, attrType);
Model.getCoreHelper().setName(attr, newName);
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
step1 =
                    new WizStepTextField(this, instructions,
                                         label, offerSuggestion());
} 
return step1;

} 
return null;
} 
public void setInstructions(String s)
    { 
instructions = s;
} 
public WizAddInstanceVariable()
    { 
super();
} 

 } 
