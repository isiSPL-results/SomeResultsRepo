package org.argouml.uml.cognitive.critics;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JPanel;
import org.apache.log4j.Logger;
import org.argouml.cognitive.ui.WizStepManyTextFields;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class WizManyNames extends UMLWizard
  { 
private static final Logger LOG = Logger.getLogger(WizManyNames.class);
private String instructions = Translator
                                  .localize("critics.WizManyNames-ins");
private List mes;
private WizStepManyTextFields step1;
private static final long serialVersionUID = -2827847568754795770L;
public JPanel makePanel(int newStep)
    { 
switch (newStep) //1
{ 
case 1://1

if(step1 == null)//1
{ 
List<String> names = new ArrayList<String>();
int size = mes.size();
for (int i = 0; i < size; i++) //1
{ 
Object me = mes.get(i);
names.add(Model.getFacade().getName(me));
} 
step1 = new WizStepManyTextFields(this, instructions, names);
} 
return step1;

default://1

} 
return null;
} 
public void setModelElements(List elements)
    { 
int mSize = elements.size();
for (int i = 0; i < 3 && i < mSize; ++i) //1
{ 
if(!Model.getFacade().isAModelElement(elements.get(i)))//1
{ 
throw new IllegalArgumentException(
                    "The list should contain model elements in "
                    + "the first 3 positions");
} 
} 
mes = elements;
} 
public WizManyNames()
    { 
} 
public void doAction(int oldStep)
    { 
LOG.debug("doAction " + oldStep);
switch (oldStep) //1
{ 
case 1://1

List<String> newNames = null;
if(step1 != null)//1
{ 
newNames = step1.getStringList();
} 
try//1
{ 
int size = mes.size();
for (int i = 0; i < size; i++) //1
{ 
Object me = mes.get(i);
Model.getCoreHelper().setName(me, newNames.get(i));
} 
} 
catch (Exception pve) //1
{ 
LOG.error("could not set name", pve);
} 
break;


default://1

} 
} 

 } 
