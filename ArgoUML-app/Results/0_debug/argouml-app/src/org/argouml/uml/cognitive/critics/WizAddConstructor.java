
//#if 1290498065 
// Compilation Unit of /WizAddConstructor.java 
 

//#if 606522329 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1746587108 
import java.util.Collection;
//#endif 


//#if 140311392 
import javax.swing.JPanel;
//#endif 


//#if -869069710 
import org.argouml.cognitive.ui.WizStepTextField;
//#endif 


//#if 69781831 
import org.argouml.i18n.Translator;
//#endif 


//#if 204578796 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -636006515 
import org.argouml.model.Model;
//#endif 


//#if -1596068683 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1506020762 
public class WizAddConstructor extends 
//#if -1192517853 
UMLWizard
//#endif 

  { 

//#if 372022742 
private WizStepTextField step1;
//#endif 


//#if -1290740551 
private String label = Translator.localize("label.name");
//#endif 


//#if 1634278296 
private String instructions =
        Translator.localize("critics.WizAddConstructor-ins");
//#endif 


//#if 286302629 
private static final long serialVersionUID = -4661562206721689576L;
//#endif 


//#if 1421574875 
private Object getCreateStereotype(Object obj)
    { 

//#if 151471892 
return ProjectManager.getManager().getCurrentProject()
               .getProfileConfiguration().findStereotypeForObject("create",
                       obj);
//#endif 

} 

//#endif 


//#if 666394487 
public void doAction(int oldStep)
    { 

//#if 1884663977 
Object oper;
//#endif 


//#if -913158755 
Collection savedTargets;
//#endif 


//#if -335415808 
switch (oldStep) //1
{ 
case 1://1


//#if -587264047 
String newName = getSuggestion();
//#endif 


//#if -1732509293 
if(step1 != null)//1
{ 

//#if -558033046 
newName = step1.getText();
//#endif 

} 

//#endif 


//#if 218931625 
Object me = getModelElement();
//#endif 


//#if 1829897734 
savedTargets = TargetManager.getInstance().getTargets();
//#endif 


//#if -1145319636 
Object returnType =
                ProjectManager.getManager().getCurrentProject()
                .getDefaultReturnType();
//#endif 


//#if 1835146894 
oper =
                Model.getCoreFactory().buildOperation2(me, returnType, newName);
//#endif 


//#if -745297635 
Model.getCoreHelper()
            .addStereotype(oper, getCreateStereotype(oper));
//#endif 


//#if -288815469 
TargetManager.getInstance().setTargets(savedTargets);
//#endif 


//#if 1202682698 
break;

//#endif 


} 

//#endif 

} 

//#endif 


//#if 69811419 
public JPanel makePanel(int newStep)
    { 

//#if -341137836 
switch (newStep) //1
{ 
case 1://1


//#if 68340069 
if(step1 == null)//1
{ 

//#if 1933007655 
step1 =
                    new WizStepTextField(this, instructions,
                                         label, offerSuggestion());
//#endif 

} 

//#endif 


//#if -1256828990 
return step1;
//#endif 


} 

//#endif 


//#if -129156069 
return null;
//#endif 

} 

//#endif 


//#if 1423737373 
public WizAddConstructor()
    { 

//#if -1043506256 
super();
//#endif 

} 

//#endif 


//#if -48431103 
public void setInstructions(String s)
    { 

//#if 1127913789 
instructions = s;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

