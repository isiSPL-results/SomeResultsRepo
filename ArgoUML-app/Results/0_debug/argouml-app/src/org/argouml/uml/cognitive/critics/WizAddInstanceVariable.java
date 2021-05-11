
//#if -809928915 
// Compilation Unit of /WizAddInstanceVariable.java 
 

//#if 1701047003 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -177447326 
import javax.swing.JPanel;
//#endif 


//#if 814180144 
import org.argouml.cognitive.ui.WizStepTextField;
//#endif 


//#if -1488213883 
import org.argouml.i18n.Translator;
//#endif 


//#if -1422681942 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1315471925 
import org.argouml.model.Model;
//#endif 


//#if 150876231 
public class WizAddInstanceVariable extends 
//#if -783451718 
UMLWizard
//#endif 

  { 

//#if -742350331 
private WizStepTextField step1 = null;
//#endif 


//#if -1738116912 
private String label = Translator.localize("label.name");
//#endif 


//#if 971290988 
private String instructions =
        Translator.localize("critics.WizAddInstanceVariable-ins");
//#endif 


//#if -3942080 
public void doAction(int oldStep)
    { 

//#if 1382501965 
Object attr;
//#endif 


//#if 214978207 
switch (oldStep) //1
{ 
case 1://1


//#if -2127603744 
String newName = getSuggestion();
//#endif 


//#if -142301150 
if(step1 != null)//1
{ 

//#if 312953589 
newName = step1.getText();
//#endif 

} 

//#endif 


//#if -475730950 
Object me = getModelElement();
//#endif 


//#if 717567480 
Object attrType =
                ProjectManager.getManager()
                .getCurrentProject().getDefaultAttributeType();
//#endif 


//#if -1813574039 
attr =
                Model.getCoreFactory()
                .buildAttribute2(me, attrType);
//#endif 


//#if 1774201865 
Model.getCoreHelper().setName(attr, newName);
//#endif 


//#if 801783897 
break;

//#endif 


} 

//#endif 

} 

//#endif 


//#if 1671070322 
public JPanel makePanel(int newStep)
    { 

//#if 72626084 
switch (newStep) //1
{ 
case 1://1


//#if 1057972069 
if(step1 == null)//1
{ 

//#if -1310569012 
step1 =
                    new WizStepTextField(this, instructions,
                                         label, offerSuggestion());
//#endif 

} 

//#endif 


//#if -1229232702 
return step1;
//#endif 


} 

//#endif 


//#if 106045926 
return null;
//#endif 

} 

//#endif 


//#if -1949012662 
public void setInstructions(String s)
    { 

//#if 1785718646 
instructions = s;
//#endif 

} 

//#endif 


//#if 2041534041 
public WizAddInstanceVariable()
    { 

//#if -417979125 
super();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

