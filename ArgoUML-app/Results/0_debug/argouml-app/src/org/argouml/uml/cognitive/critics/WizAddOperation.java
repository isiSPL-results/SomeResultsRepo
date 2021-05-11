
//#if -332020205 
// Compilation Unit of /WizAddOperation.java 
 

//#if -417574785 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -1370715130 
import javax.swing.JPanel;
//#endif 


//#if 851714316 
import org.argouml.cognitive.ui.WizStepTextField;
//#endif 


//#if 1381667681 
import org.argouml.i18n.Translator;
//#endif 


//#if 1002827398 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1722168999 
import org.argouml.model.Model;
//#endif 


//#if 773988077 
public class WizAddOperation extends 
//#if -915831819 
UMLWizard
//#endif 

  { 

//#if -579207126 
private WizStepTextField step1 = null;
//#endif 


//#if -1054323061 
private String label = Translator.localize("label.name");
//#endif 


//#if -1781749172 
private String instructions;
//#endif 


//#if -1421602331 
public void doAction(int oldStep)
    { 

//#if -899385253 
switch (oldStep) //1
{ 
case 1://1


//#if 1801840336 
String newName = getSuggestion();
//#endif 


//#if -1419370734 
if(step1 != null)//1
{ 

//#if -495818210 
newName = step1.getText();
//#endif 

} 

//#endif 


//#if -605928694 
Object me = getModelElement();
//#endif 


//#if -52291221 
Object returnType =
                ProjectManager.getManager()
                .getCurrentProject().getDefaultReturnType();
//#endif 


//#if -391453254 
Model.getCoreFactory().buildOperation2(me, returnType, newName);
//#endif 


//#if -395141303 
break;

//#endif 


} 

//#endif 

} 

//#endif 


//#if 567954349 
public JPanel makePanel(int newStep)
    { 

//#if 173564724 
switch (newStep) //1
{ 
case 1://1


//#if -1010509304 
if(step1 == null)//1
{ 

//#if -1343947545 
step1 =
                    new WizStepTextField(this, instructions,
                                         label, offerSuggestion());
//#endif 

} 

//#endif 


//#if -448899419 
return step1;
//#endif 


} 

//#endif 


//#if 1359817907 
return null;
//#endif 

} 

//#endif 


//#if -1785869457 
public void setInstructions(String s)
    { 

//#if -1303442096 
instructions = s;
//#endif 

} 

//#endif 


//#if -1114282468 
public WizAddOperation()
    { 

//#if -481029433 
super();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

