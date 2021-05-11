
//#if -489488141 
// Compilation Unit of /WizManyNames.java 
 

//#if 591454635 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -300909685 
import java.util.ArrayList;
//#endif 


//#if 408580086 
import java.util.List;
//#endif 


//#if 1959301553 
import java.util.Vector;
//#endif 


//#if -1456409294 
import javax.swing.JPanel;
//#endif 


//#if -1542357624 
import org.apache.log4j.Logger;
//#endif 


//#if 891110852 
import org.argouml.cognitive.ui.WizStepManyTextFields;
//#endif 


//#if 1945877429 
import org.argouml.i18n.Translator;
//#endif 


//#if 305178875 
import org.argouml.model.Model;
//#endif 


//#if 155038862 
public class WizManyNames extends 
//#if -1594110673 
UMLWizard
//#endif 

  { 

//#if 186527647 
private static final Logger LOG = Logger.getLogger(WizManyNames.class);
//#endif 


//#if 1547108160 
private String instructions = Translator
                                  .localize("critics.WizManyNames-ins");
//#endif 


//#if 924390385 
private List mes;
//#endif 


//#if 1489806780 
private WizStepManyTextFields step1;
//#endif 


//#if -1031460914 
private static final long serialVersionUID = -2827847568754795770L;
//#endif 


//#if -1672280345 
public JPanel makePanel(int newStep)
    { 

//#if 123606227 
switch (newStep) //1
{ 
case 1://1


//#if 1323664558 
if(step1 == null)//1
{ 

//#if -538523165 
List<String> names = new ArrayList<String>();
//#endif 


//#if 1919887534 
int size = mes.size();
//#endif 


//#if 894162030 
for (int i = 0; i < size; i++) //1
{ 

//#if 164995923 
Object me = mes.get(i);
//#endif 


//#if 552828042 
names.add(Model.getFacade().getName(me));
//#endif 

} 

//#endif 


//#if -1802965323 
step1 = new WizStepManyTextFields(this, instructions, names);
//#endif 

} 

//#endif 


//#if -700090933 
return step1;
//#endif 


default://1

} 

//#endif 


//#if -2087242437 
return null;
//#endif 

} 

//#endif 


//#if -1923994569 
public void setModelElements(List elements)
    { 

//#if -1322099846 
int mSize = elements.size();
//#endif 


//#if 1960338490 
for (int i = 0; i < 3 && i < mSize; ++i) //1
{ 

//#if 2122721575 
if(!Model.getFacade().isAModelElement(elements.get(i)))//1
{ 

//#if -2111056581 
throw new IllegalArgumentException(
                    "The list should contain model elements in "
                    + "the first 3 positions");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 176300732 
mes = elements;
//#endif 

} 

//#endif 


//#if -1796157253 
public WizManyNames()
    { 
} 

//#endif 


//#if 1064677611 
public void doAction(int oldStep)
    { 

//#if 1805395498 
LOG.debug("doAction " + oldStep);
//#endif 


//#if -166359279 
switch (oldStep) //1
{ 
case 1://1


//#if 822123959 
List<String> newNames = null;
//#endif 


//#if -1605628626 
if(step1 != null)//1
{ 

//#if 1254877576 
newNames = step1.getStringList();
//#endif 

} 

//#endif 


//#if 198665983 
try //1
{ 

//#if -1754410742 
int size = mes.size();
//#endif 


//#if 1030342602 
for (int i = 0; i < size; i++) //1
{ 

//#if 607317545 
Object me = mes.get(i);
//#endif 


//#if -210883559 
Model.getCoreHelper().setName(me, newNames.get(i));
//#endif 

} 

//#endif 

} 

//#if -778624492 
catch (Exception pve) //1
{ 

//#if -1265133886 
LOG.error("could not set name", pve);
//#endif 

} 

//#endif 


//#endif 


//#if -317204635 
break;

//#endif 


default://1

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

