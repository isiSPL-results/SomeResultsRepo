
//#if 1579477376 
// Compilation Unit of /WizNavigable.java 
 

//#if 705445193 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 383326125 
import java.util.ArrayList;
//#endif 


//#if 881149588 
import java.util.List;
//#endif 


//#if 1890798800 
import javax.swing.JPanel;
//#endif 


//#if -1056229206 
import org.apache.log4j.Logger;
//#endif 


//#if 2064357446 
import org.argouml.cognitive.ui.WizStepChoice;
//#endif 


//#if -1182853673 
import org.argouml.i18n.Translator;
//#endif 


//#if 791307293 
import org.argouml.model.Model;
//#endif 


//#if -409584162 
public class WizNavigable extends 
//#if 1129392051 
UMLWizard
//#endif 

  { 

//#if -1898529195 
private static final Logger LOG = Logger.getLogger(WizNavigable.class);
//#endif 


//#if 1273935562 
private String instructions =
        Translator.localize("critics.WizNavigable-ins");
//#endif 


//#if -1958572170 
private String option0 =
        Translator.localize("critics.WizNavigable-option1");
//#endif 


//#if -1520532876 
private String option1 =
        Translator.localize("critics.WizNavigable-option2");
//#endif 


//#if -1082493582 
private String option2 =
        Translator.localize("critics.WizNavigable-option3");
//#endif 


//#if 748762622 
private WizStepChoice step1 = null;
//#endif 


//#if 1720997767 
private static final long serialVersionUID = 2571165058454693999L;
//#endif 


//#if -207481493 
public JPanel makePanel(int newStep)
    { 

//#if 318245389 
switch (newStep) //1
{ 
case 1://1


//#if 1795565806 
if(step1 == null)//1
{ 

//#if 687331226 
step1 = new WizStepChoice(this, instructions, getOptions());
//#endif 


//#if -191471729 
step1.setTarget(getToDoItem());
//#endif 

} 

//#endif 


//#if 801524235 
return step1;
//#endif 


} 

//#endif 


//#if 1863825361 
return null;
//#endif 

} 

//#endif 


//#if -54576783 
public void setInstructions(String s)
    { 

//#if 1445929659 
instructions = s;
//#endif 

} 

//#endif 


//#if -1262393755 
@Override
    public boolean canFinish()
    { 

//#if -307537760 
if(!super.canFinish())//1
{ 

//#if -384051776 
return false;
//#endif 

} 

//#endif 


//#if 1082926397 
if(getStep() == 0)//1
{ 

//#if -941253440 
return true;
//#endif 

} 

//#endif 


//#if -611060987 
if(getStep() == 1 && step1 != null && step1.getSelectedIndex() != -1)//1
{ 

//#if -2104303765 
return true;
//#endif 

} 

//#endif 


//#if -1274140757 
return false;
//#endif 

} 

//#endif 


//#if -1679288435 
public List<String> getOptions()
    { 

//#if -496243373 
List<String> result = new ArrayList<String>();
//#endif 


//#if 679649614 
Object asc = getModelElement();
//#endif 


//#if 1391380283 
Object ae0 =
            new ArrayList(Model.getFacade().getConnections(asc)).get(0);
//#endif 


//#if 224684925 
Object ae1 =
            new ArrayList(Model.getFacade().getConnections(asc)).get(1);
//#endif 


//#if 532896862 
Object cls0 = Model.getFacade().getType(ae0);
//#endif 


//#if -1650779104 
Object cls1 = Model.getFacade().getType(ae1);
//#endif 


//#if -1852183855 
if(cls0 != null && !"".equals(Model.getFacade().getName(cls0)))//1
{ 

//#if -1159781689 
option0 = Translator.localize("critics.WizNavigable-option4")
                      + Model.getFacade().getName(cls0);
//#endif 

} 

//#endif 


//#if -944342799 
if(cls1 != null && !"".equals(Model.getFacade().getName(cls1)))//1
{ 

//#if 819109669 
option1 = Translator.localize("critics.WizNavigable-option5")
                      + Model.getFacade().getName(cls1);
//#endif 

} 

//#endif 


//#if -653255545 
result.add(option0);
//#endif 


//#if -653254584 
result.add(option1);
//#endif 


//#if -653253623 
result.add(option2);
//#endif 


//#if -913036996 
return result;
//#endif 

} 

//#endif 


//#if 886100199 
public void doAction(int oldStep)
    { 

//#if -1036863691 
LOG.debug("doAction " + oldStep);
//#endif 


//#if 502402890 
switch (oldStep) //1
{ 
case 1://1


//#if -1618479548 
int choice = -1;
//#endif 


//#if -1542338453 
if(step1 != null)//1
{ 

//#if 1362016432 
choice = step1.getSelectedIndex();
//#endif 

} 

//#endif 


//#if -1614841326 
if(choice == -1)//1
{ 

//#if 1630712568 
throw new Error("nothing selected, should not get here");
//#endif 

} 

//#endif 


//#if 903239100 
try //1
{ 

//#if -174649210 
Object asc = getModelElement();
//#endif 


//#if -863578365 
Object ae0 =
                    new ArrayList(Model.getFacade().getConnections(asc)).get(0);
//#endif 


//#if -2030273723 
Object ae1 =
                    new ArrayList(Model.getFacade().getConnections(asc)).get(1);
//#endif 


//#if 674610794 
Model.getCoreHelper().setNavigable(ae0,
                                                   choice == 0 || choice == 2);
//#endif 


//#if 102045416 
Model.getCoreHelper().setNavigable(ae1,
                                                   choice == 1 || choice == 2);
//#endif 

} 

//#if 1548105466 
catch (Exception pve) //1
{ 

//#if -1528968104 
LOG.error("could not set navigablity", pve);
//#endif 

} 

//#endif 


//#endif 


} 

//#endif 

} 

//#endif 


//#if -367945367 
public WizNavigable() { 
} 

//#endif 

 } 

//#endif 


//#endif 

